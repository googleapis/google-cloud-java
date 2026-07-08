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

package com.google.devicesandservices.health.v4;

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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devicesandservices.health.v4.stub.DataPointsServiceStub;
import com.google.devicesandservices.health.v4.stub.DataPointsServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Data Points Service exposing the user's health and fitness measured and
 * derived data.
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
 * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
 *   DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
 *   DataPoint response = dataPointsServiceClient.getDataPoint(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataPointsServiceClient object to clean up resources
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
 *      <td><p> GetDataPoint</td>
 *      <td><p> Get a single identifyable data point.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataPoint(GetDataPointRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataPoint(DataPointName name)
 *           <li><p> getDataPoint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataPointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataPoints</td>
 *      <td><p> Query user health and fitness data points.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataPoints(ListDataPointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataPoints(DataTypeName parent)
 *           <li><p> listDataPoints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataPointsPagedCallable()
 *           <li><p> listDataPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataPoint</td>
 *      <td><p> Creates a single identifiable data point.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataPointAsync(CreateDataPointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDataPointAsync(DataTypeName parent, DataPoint dataPoint)
 *           <li><p> createDataPointAsync(String parent, DataPoint dataPoint)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataPointOperationCallable()
 *           <li><p> createDataPointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataPoint</td>
 *      <td><p> Updates a single identifiable data point. If a data point with the specified `name` is not found, the request will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataPointAsync(UpdateDataPointRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDataPointAsync(DataPoint dataPoint)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataPointOperationCallable()
 *           <li><p> updateDataPointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteDataPoints</td>
 *      <td><p> Delete a batch of identifyable data points.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteDataPointsAsync(BatchDeleteDataPointsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteDataPointsOperationCallable()
 *           <li><p> batchDeleteDataPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReconcileDataPoints</td>
 *      <td><p> Reconcile data points from multiple data sources into a single data stream.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reconcileDataPoints(ReconcileDataPointsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reconcileDataPointsPagedCallable()
 *           <li><p> reconcileDataPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RollUpDataPoints</td>
 *      <td><p> Roll up data points over physical time intervals for supported data types.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollUpDataPoints(RollUpDataPointsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollUpDataPointsPagedCallable()
 *           <li><p> rollUpDataPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DailyRollUpDataPoints</td>
 *      <td><p> Roll up data points over civil time intervals for supported data types.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> dailyRollUpDataPoints(DailyRollUpDataPointsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> dailyRollUpDataPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportExerciseTcx</td>
 *      <td><p> Exports exercise data in TCX format.
 * <p>  &#42;&#42;IMPORTANT:&#42;&#42; HTTP clients must append `?alt=media` to the request URL to download the raw TCX file.
 * <p>  Example: `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
 * <p>  Without `alt=media`, the server returns a JSON response (`ExportExerciseTcxResponse`) which is intended primarily for gRPC clients.
 * <p>  &#42;&#42;Note:&#42;&#42; While the Authorization section below states that any one of the listed scopes is accepted, this specific method requires the user to provide both one of the `activity_and_fitness` scopes (`normal` or `readonly`) AND one of the `location` scopes (`normal` or `readonly`) in their access token to succeed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportExerciseTcx(ExportExerciseTcxRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> exportExerciseTcx(DataPointName name)
 *           <li><p> exportExerciseTcx(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportExerciseTcxCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataPointsServiceSettings to
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
 * DataPointsServiceSettings dataPointsServiceSettings =
 *     DataPointsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataPointsServiceClient dataPointsServiceClient =
 *     DataPointsServiceClient.create(dataPointsServiceSettings);
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
 * DataPointsServiceSettings dataPointsServiceSettings =
 *     DataPointsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataPointsServiceClient dataPointsServiceClient =
 *     DataPointsServiceClient.create(dataPointsServiceSettings);
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
 * DataPointsServiceSettings dataPointsServiceSettings =
 *     DataPointsServiceSettings.newHttpJsonBuilder().build();
 * DataPointsServiceClient dataPointsServiceClient =
 *     DataPointsServiceClient.create(dataPointsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DataPointsServiceClient implements BackgroundResource {
  private final DataPointsServiceSettings settings;
  private final DataPointsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataPointsServiceClient with default settings. */
  public static final DataPointsServiceClient create() throws IOException {
    return create(DataPointsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataPointsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataPointsServiceClient create(DataPointsServiceSettings settings)
      throws IOException {
    return new DataPointsServiceClient(settings);
  }

  /**
   * Constructs an instance of DataPointsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataPointsServiceSettings).
   */
  public static final DataPointsServiceClient create(DataPointsServiceStub stub) {
    return new DataPointsServiceClient(stub);
  }

  /**
   * Constructs an instance of DataPointsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataPointsServiceClient(DataPointsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataPointsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataPointsServiceClient(DataPointsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataPointsServiceSettings getSettings() {
    return settings;
  }

  public DataPointsServiceStub getStub() {
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
   * Get a single identifyable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
   *   DataPoint response = dataPointsServiceClient.getDataPoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data point to retrieve.
   *     <p>Format: `users/{user}/dataTypes/{data_type}/dataPoints/{data_point}`
   *     <p>See [DataPoint.name][google.devicesandservices.health.v4.DataPoint.name] for examples
   *     and possible values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPoint getDataPoint(DataPointName name) {
    GetDataPointRequest request =
        GetDataPointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataPoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single identifyable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   String name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString();
   *   DataPoint response = dataPointsServiceClient.getDataPoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data point to retrieve.
   *     <p>Format: `users/{user}/dataTypes/{data_type}/dataPoints/{data_point}`
   *     <p>See [DataPoint.name][google.devicesandservices.health.v4.DataPoint.name] for examples
   *     and possible values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPoint getDataPoint(String name) {
    GetDataPointRequest request = GetDataPointRequest.newBuilder().setName(name).build();
    return getDataPoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single identifyable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   GetDataPointRequest request =
   *       GetDataPointRequest.newBuilder()
   *           .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
   *           .build();
   *   DataPoint response = dataPointsServiceClient.getDataPoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataPoint getDataPoint(GetDataPointRequest request) {
    return getDataPointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single identifyable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   GetDataPointRequest request =
   *       GetDataPointRequest.newBuilder()
   *           .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
   *           .build();
   *   ApiFuture<DataPoint> future =
   *       dataPointsServiceClient.getDataPointCallable().futureCall(request);
   *   // Do something.
   *   DataPoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable() {
    return stub.getDataPointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query user health and fitness data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
   *   for (DataPoint element : dataPointsServiceClient.listDataPoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent data type of the Data Point collection.
   *     <p>Format: `users/me/dataTypes/{data_type}`, e.g.:
   *     <p>- `users/me/dataTypes/steps` - `users/me/dataTypes/weight`
   *     <p>For a list of the supported data types see the [DataPoint
   *     data][google.devicesandservices.health.v4.DataPoint] union field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPointsPagedResponse listDataPoints(DataTypeName parent) {
    ListDataPointsRequest request =
        ListDataPointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataPoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query user health and fitness data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   String parent = DataTypeName.of("[USER]", "[DATA_TYPE]").toString();
   *   for (DataPoint element : dataPointsServiceClient.listDataPoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent data type of the Data Point collection.
   *     <p>Format: `users/me/dataTypes/{data_type}`, e.g.:
   *     <p>- `users/me/dataTypes/steps` - `users/me/dataTypes/weight`
   *     <p>For a list of the supported data types see the [DataPoint
   *     data][google.devicesandservices.health.v4.DataPoint] union field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPointsPagedResponse listDataPoints(String parent) {
    ListDataPointsRequest request = ListDataPointsRequest.newBuilder().setParent(parent).build();
    return listDataPoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query user health and fitness data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ListDataPointsRequest request =
   *       ListDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataPoint element : dataPointsServiceClient.listDataPoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataPointsPagedResponse listDataPoints(ListDataPointsRequest request) {
    return listDataPointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query user health and fitness data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ListDataPointsRequest request =
   *       ListDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataPoint> future =
   *       dataPointsServiceClient.listDataPointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataPoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable() {
    return stub.listDataPointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Query user health and fitness data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ListDataPointsRequest request =
   *       ListDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataPointsResponse response =
   *         dataPointsServiceClient.listDataPointsCallable().call(request);
   *     for (DataPoint element : response.getDataPointsList()) {
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
  public final UnaryCallable<ListDataPointsRequest, ListDataPointsResponse>
      listDataPointsCallable() {
    return stub.listDataPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a single identifiable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DataTypeName parent = DataTypeName.of("[USER]", "[DATA_TYPE]");
   *   DataPoint dataPoint = DataPoint.newBuilder().build();
   *   DataPoint response = dataPointsServiceClient.createDataPointAsync(parent, dataPoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the data point will be created. Format:
   *     `users/{user}/dataTypes/{data_type}`
   * @param dataPoint Required. The data point to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataPoint, CreateDataPointOperationMetadata> createDataPointAsync(
      DataTypeName parent, DataPoint dataPoint) {
    CreateDataPointRequest request =
        CreateDataPointRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataPoint(dataPoint)
            .build();
    return createDataPointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a single identifiable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   String parent = DataTypeName.of("[USER]", "[DATA_TYPE]").toString();
   *   DataPoint dataPoint = DataPoint.newBuilder().build();
   *   DataPoint response = dataPointsServiceClient.createDataPointAsync(parent, dataPoint).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the data point will be created. Format:
   *     `users/{user}/dataTypes/{data_type}`
   * @param dataPoint Required. The data point to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataPoint, CreateDataPointOperationMetadata> createDataPointAsync(
      String parent, DataPoint dataPoint) {
    CreateDataPointRequest request =
        CreateDataPointRequest.newBuilder().setParent(parent).setDataPoint(dataPoint).build();
    return createDataPointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a single identifiable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   CreateDataPointRequest request =
   *       CreateDataPointRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setDataPoint(DataPoint.newBuilder().build())
   *           .build();
   *   DataPoint response = dataPointsServiceClient.createDataPointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataPoint, CreateDataPointOperationMetadata> createDataPointAsync(
      CreateDataPointRequest request) {
    return createDataPointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a single identifiable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   CreateDataPointRequest request =
   *       CreateDataPointRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setDataPoint(DataPoint.newBuilder().build())
   *           .build();
   *   OperationFuture<DataPoint, CreateDataPointOperationMetadata> future =
   *       dataPointsServiceClient.createDataPointOperationCallable().futureCall(request);
   *   // Do something.
   *   DataPoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable() {
    return stub.createDataPointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a single identifiable data point.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   CreateDataPointRequest request =
   *       CreateDataPointRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setDataPoint(DataPoint.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataPointsServiceClient.createDataPointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable() {
    return stub.createDataPointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single identifiable data point. If a data point with the specified `name` is not
   * found, the request will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DataPoint dataPoint = DataPoint.newBuilder().build();
   *   DataPoint response = dataPointsServiceClient.updateDataPointAsync(dataPoint).get();
   * }
   * }</pre>
   *
   * @param dataPoint Required. The data point to update
   *     <p>The data point's `name` field is used to identify the data point to update.
   *     <p>Format: `users/{user}/dataTypes/{data_type}/dataPoints/{data_point}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataPoint, UpdateDataPointOperationMetadata> updateDataPointAsync(
      DataPoint dataPoint) {
    UpdateDataPointRequest request =
        UpdateDataPointRequest.newBuilder().setDataPoint(dataPoint).build();
    return updateDataPointAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single identifiable data point. If a data point with the specified `name` is not
   * found, the request will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   UpdateDataPointRequest request =
   *       UpdateDataPointRequest.newBuilder().setDataPoint(DataPoint.newBuilder().build()).build();
   *   DataPoint response = dataPointsServiceClient.updateDataPointAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataPoint, UpdateDataPointOperationMetadata> updateDataPointAsync(
      UpdateDataPointRequest request) {
    return updateDataPointOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single identifiable data point. If a data point with the specified `name` is not
   * found, the request will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   UpdateDataPointRequest request =
   *       UpdateDataPointRequest.newBuilder().setDataPoint(DataPoint.newBuilder().build()).build();
   *   OperationFuture<DataPoint, UpdateDataPointOperationMetadata> future =
   *       dataPointsServiceClient.updateDataPointOperationCallable().futureCall(request);
   *   // Do something.
   *   DataPoint response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable() {
    return stub.updateDataPointOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single identifiable data point. If a data point with the specified `name` is not
   * found, the request will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   UpdateDataPointRequest request =
   *       UpdateDataPointRequest.newBuilder().setDataPoint(DataPoint.newBuilder().build()).build();
   *   ApiFuture<Operation> future =
   *       dataPointsServiceClient.updateDataPointCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable() {
    return stub.updateDataPointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a batch of identifyable data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   BatchDeleteDataPointsRequest request =
   *       BatchDeleteDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeleteDataPointsResponse response =
   *       dataPointsServiceClient.batchDeleteDataPointsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchDeleteDataPointsResponse, BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsAsync(BatchDeleteDataPointsRequest request) {
    return batchDeleteDataPointsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a batch of identifyable data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   BatchDeleteDataPointsRequest request =
   *       BatchDeleteDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BatchDeleteDataPointsResponse, BatchDeleteDataPointsOperationMetadata>
   *       future =
   *           dataPointsServiceClient.batchDeleteDataPointsOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchDeleteDataPointsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable() {
    return stub.batchDeleteDataPointsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a batch of identifyable data points.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   BatchDeleteDataPointsRequest request =
   *       BatchDeleteDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataPointsServiceClient.batchDeleteDataPointsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsCallable() {
    return stub.batchDeleteDataPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reconcile data points from multiple data sources into a single data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ReconcileDataPointsRequest request =
   *       ReconcileDataPointsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   for (ReconciledDataPoint element :
   *       dataPointsServiceClient.reconcileDataPoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReconcileDataPointsPagedResponse reconcileDataPoints(
      ReconcileDataPointsRequest request) {
    return reconcileDataPointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reconcile data points from multiple data sources into a single data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ReconcileDataPointsRequest request =
   *       ReconcileDataPointsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   ApiFuture<ReconciledDataPoint> future =
   *       dataPointsServiceClient.reconcileDataPointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReconciledDataPoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable() {
    return stub.reconcileDataPointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reconcile data points from multiple data sources into a single data stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ReconcileDataPointsRequest request =
   *       ReconcileDataPointsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   while (true) {
   *     ReconcileDataPointsResponse response =
   *         dataPointsServiceClient.reconcileDataPointsCallable().call(request);
   *     for (ReconciledDataPoint element : response.getDataPointsList()) {
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
  public final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable() {
    return stub.reconcileDataPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Roll up data points over physical time intervals for supported data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   RollUpDataPointsRequest request =
   *       RollUpDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setRange(Interval.newBuilder().build())
   *           .setWindowSize(Duration.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   for (RollupDataPoint element :
   *       dataPointsServiceClient.rollUpDataPoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RollUpDataPointsPagedResponse rollUpDataPoints(RollUpDataPointsRequest request) {
    return rollUpDataPointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Roll up data points over physical time intervals for supported data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   RollUpDataPointsRequest request =
   *       RollUpDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setRange(Interval.newBuilder().build())
   *           .setWindowSize(Duration.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   ApiFuture<RollupDataPoint> future =
   *       dataPointsServiceClient.rollUpDataPointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RollupDataPoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable() {
    return stub.rollUpDataPointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Roll up data points over physical time intervals for supported data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   RollUpDataPointsRequest request =
   *       RollUpDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setRange(Interval.newBuilder().build())
   *           .setWindowSize(Duration.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   while (true) {
   *     RollUpDataPointsResponse response =
   *         dataPointsServiceClient.rollUpDataPointsCallable().call(request);
   *     for (RollupDataPoint element : response.getRollupDataPointsList()) {
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
  public final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable() {
    return stub.rollUpDataPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Roll up data points over civil time intervals for supported data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DailyRollUpDataPointsRequest request =
   *       DailyRollUpDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setRange(CivilTimeInterval.newBuilder().build())
   *           .setWindowSizeDays(1064520774)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   DailyRollUpDataPointsResponse response =
   *       dataPointsServiceClient.dailyRollUpDataPoints(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DailyRollUpDataPointsResponse dailyRollUpDataPoints(
      DailyRollUpDataPointsRequest request) {
    return dailyRollUpDataPointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Roll up data points over civil time intervals for supported data types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DailyRollUpDataPointsRequest request =
   *       DailyRollUpDataPointsRequest.newBuilder()
   *           .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
   *           .setRange(CivilTimeInterval.newBuilder().build())
   *           .setWindowSizeDays(1064520774)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setDataSourceFamily("dataSourceFamily586548265")
   *           .build();
   *   ApiFuture<DailyRollUpDataPointsResponse> future =
   *       dataPointsServiceClient.dailyRollUpDataPointsCallable().futureCall(request);
   *   // Do something.
   *   DailyRollUpDataPointsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable() {
    return stub.dailyRollUpDataPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports exercise data in TCX format.
   *
   * <p>&#42;&#42;IMPORTANT:&#42;&#42; HTTP clients must append `?alt=media` to the request URL to
   * download the raw TCX file.
   *
   * <p>Example:
   * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
   *
   * <p>Without `alt=media`, the server returns a JSON response (`ExportExerciseTcxResponse`) which
   * is intended primarily for gRPC clients.
   *
   * <p>&#42;&#42;Note:&#42;&#42; While the Authorization section below states that any one of the
   * listed scopes is accepted, this specific method requires the user to provide both one of the
   * `activity_and_fitness` scopes (`normal` or `readonly`) AND one of the `location` scopes
   * (`normal` or `readonly`) in their access token to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   DataPointName name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]");
   *   ExportExerciseTcxResponse response = dataPointsServiceClient.exportExerciseTcx(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the exercise data point to export.
   *     <p>Format: `users/{user}/dataTypes/exercise/dataPoints/{data_point}` Example:
   *     `users/me/dataTypes/exercise/dataPoints/2026443605080188808`
   *     <p>The `{user}` is the alias `"me"` currently. Future versions may support user IDs. The
   *     `{data_point}` ID maps to the exercise ID, which is a long integer.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportExerciseTcxResponse exportExerciseTcx(DataPointName name) {
    ExportExerciseTcxRequest request =
        ExportExerciseTcxRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return exportExerciseTcx(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports exercise data in TCX format.
   *
   * <p>&#42;&#42;IMPORTANT:&#42;&#42; HTTP clients must append `?alt=media` to the request URL to
   * download the raw TCX file.
   *
   * <p>Example:
   * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
   *
   * <p>Without `alt=media`, the server returns a JSON response (`ExportExerciseTcxResponse`) which
   * is intended primarily for gRPC clients.
   *
   * <p>&#42;&#42;Note:&#42;&#42; While the Authorization section below states that any one of the
   * listed scopes is accepted, this specific method requires the user to provide both one of the
   * `activity_and_fitness` scopes (`normal` or `readonly`) AND one of the `location` scopes
   * (`normal` or `readonly`) in their access token to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   String name = DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString();
   *   ExportExerciseTcxResponse response = dataPointsServiceClient.exportExerciseTcx(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the exercise data point to export.
   *     <p>Format: `users/{user}/dataTypes/exercise/dataPoints/{data_point}` Example:
   *     `users/me/dataTypes/exercise/dataPoints/2026443605080188808`
   *     <p>The `{user}` is the alias `"me"` currently. Future versions may support user IDs. The
   *     `{data_point}` ID maps to the exercise ID, which is a long integer.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportExerciseTcxResponse exportExerciseTcx(String name) {
    ExportExerciseTcxRequest request = ExportExerciseTcxRequest.newBuilder().setName(name).build();
    return exportExerciseTcx(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports exercise data in TCX format.
   *
   * <p>&#42;&#42;IMPORTANT:&#42;&#42; HTTP clients must append `?alt=media` to the request URL to
   * download the raw TCX file.
   *
   * <p>Example:
   * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
   *
   * <p>Without `alt=media`, the server returns a JSON response (`ExportExerciseTcxResponse`) which
   * is intended primarily for gRPC clients.
   *
   * <p>&#42;&#42;Note:&#42;&#42; While the Authorization section below states that any one of the
   * listed scopes is accepted, this specific method requires the user to provide both one of the
   * `activity_and_fitness` scopes (`normal` or `readonly`) AND one of the `location` scopes
   * (`normal` or `readonly`) in their access token to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ExportExerciseTcxRequest request =
   *       ExportExerciseTcxRequest.newBuilder()
   *           .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
   *           .setPartialData(true)
   *           .build();
   *   ExportExerciseTcxResponse response = dataPointsServiceClient.exportExerciseTcx(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportExerciseTcxResponse exportExerciseTcx(ExportExerciseTcxRequest request) {
    return exportExerciseTcxCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports exercise data in TCX format.
   *
   * <p>&#42;&#42;IMPORTANT:&#42;&#42; HTTP clients must append `?alt=media` to the request URL to
   * download the raw TCX file.
   *
   * <p>Example:
   * `https://health.googleapis.com/v4/users/me/dataTypes/exercise/dataPoints/EXERCISE_ID:exportExerciseTcx?alt=media`
   *
   * <p>Without `alt=media`, the server returns a JSON response (`ExportExerciseTcxResponse`) which
   * is intended primarily for gRPC clients.
   *
   * <p>&#42;&#42;Note:&#42;&#42; While the Authorization section below states that any one of the
   * listed scopes is accepted, this specific method requires the user to provide both one of the
   * `activity_and_fitness` scopes (`normal` or `readonly`) AND one of the `location` scopes
   * (`normal` or `readonly`) in their access token to succeed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
   *   ExportExerciseTcxRequest request =
   *       ExportExerciseTcxRequest.newBuilder()
   *           .setName(DataPointName.of("[USER]", "[DATA_TYPE]", "[DATA_POINT]").toString())
   *           .setPartialData(true)
   *           .build();
   *   ApiFuture<ExportExerciseTcxResponse> future =
   *       dataPointsServiceClient.exportExerciseTcxCallable().futureCall(request);
   *   // Do something.
   *   ExportExerciseTcxResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable() {
    return stub.exportExerciseTcxCallable();
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

  public static class ListDataPointsPagedResponse
      extends AbstractPagedListResponse<
          ListDataPointsRequest,
          ListDataPointsResponse,
          DataPoint,
          ListDataPointsPage,
          ListDataPointsFixedSizeCollection> {

    public static ApiFuture<ListDataPointsPagedResponse> createAsync(
        PageContext<ListDataPointsRequest, ListDataPointsResponse, DataPoint> context,
        ApiFuture<ListDataPointsResponse> futureResponse) {
      ApiFuture<ListDataPointsPage> futurePage =
          ListDataPointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataPointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataPointsPagedResponse(ListDataPointsPage page) {
      super(page, ListDataPointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataPointsPage
      extends AbstractPage<
          ListDataPointsRequest, ListDataPointsResponse, DataPoint, ListDataPointsPage> {

    private ListDataPointsPage(
        PageContext<ListDataPointsRequest, ListDataPointsResponse, DataPoint> context,
        ListDataPointsResponse response) {
      super(context, response);
    }

    private static ListDataPointsPage createEmptyPage() {
      return new ListDataPointsPage(null, null);
    }

    @Override
    protected ListDataPointsPage createPage(
        PageContext<ListDataPointsRequest, ListDataPointsResponse, DataPoint> context,
        ListDataPointsResponse response) {
      return new ListDataPointsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataPointsPage> createPageAsync(
        PageContext<ListDataPointsRequest, ListDataPointsResponse, DataPoint> context,
        ApiFuture<ListDataPointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataPointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataPointsRequest,
          ListDataPointsResponse,
          DataPoint,
          ListDataPointsPage,
          ListDataPointsFixedSizeCollection> {

    private ListDataPointsFixedSizeCollection(List<ListDataPointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataPointsFixedSizeCollection createEmptyCollection() {
      return new ListDataPointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataPointsFixedSizeCollection createCollection(
        List<ListDataPointsPage> pages, int collectionSize) {
      return new ListDataPointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ReconcileDataPointsPagedResponse
      extends AbstractPagedListResponse<
          ReconcileDataPointsRequest,
          ReconcileDataPointsResponse,
          ReconciledDataPoint,
          ReconcileDataPointsPage,
          ReconcileDataPointsFixedSizeCollection> {

    public static ApiFuture<ReconcileDataPointsPagedResponse> createAsync(
        PageContext<ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
            context,
        ApiFuture<ReconcileDataPointsResponse> futureResponse) {
      ApiFuture<ReconcileDataPointsPage> futurePage =
          ReconcileDataPointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ReconcileDataPointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ReconcileDataPointsPagedResponse(ReconcileDataPointsPage page) {
      super(page, ReconcileDataPointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ReconcileDataPointsPage
      extends AbstractPage<
          ReconcileDataPointsRequest,
          ReconcileDataPointsResponse,
          ReconciledDataPoint,
          ReconcileDataPointsPage> {

    private ReconcileDataPointsPage(
        PageContext<ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
            context,
        ReconcileDataPointsResponse response) {
      super(context, response);
    }

    private static ReconcileDataPointsPage createEmptyPage() {
      return new ReconcileDataPointsPage(null, null);
    }

    @Override
    protected ReconcileDataPointsPage createPage(
        PageContext<ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
            context,
        ReconcileDataPointsResponse response) {
      return new ReconcileDataPointsPage(context, response);
    }

    @Override
    public ApiFuture<ReconcileDataPointsPage> createPageAsync(
        PageContext<ReconcileDataPointsRequest, ReconcileDataPointsResponse, ReconciledDataPoint>
            context,
        ApiFuture<ReconcileDataPointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ReconcileDataPointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ReconcileDataPointsRequest,
          ReconcileDataPointsResponse,
          ReconciledDataPoint,
          ReconcileDataPointsPage,
          ReconcileDataPointsFixedSizeCollection> {

    private ReconcileDataPointsFixedSizeCollection(
        List<ReconcileDataPointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ReconcileDataPointsFixedSizeCollection createEmptyCollection() {
      return new ReconcileDataPointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ReconcileDataPointsFixedSizeCollection createCollection(
        List<ReconcileDataPointsPage> pages, int collectionSize) {
      return new ReconcileDataPointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class RollUpDataPointsPagedResponse
      extends AbstractPagedListResponse<
          RollUpDataPointsRequest,
          RollUpDataPointsResponse,
          RollupDataPoint,
          RollUpDataPointsPage,
          RollUpDataPointsFixedSizeCollection> {

    public static ApiFuture<RollUpDataPointsPagedResponse> createAsync(
        PageContext<RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint> context,
        ApiFuture<RollUpDataPointsResponse> futureResponse) {
      ApiFuture<RollUpDataPointsPage> futurePage =
          RollUpDataPointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new RollUpDataPointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private RollUpDataPointsPagedResponse(RollUpDataPointsPage page) {
      super(page, RollUpDataPointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class RollUpDataPointsPage
      extends AbstractPage<
          RollUpDataPointsRequest,
          RollUpDataPointsResponse,
          RollupDataPoint,
          RollUpDataPointsPage> {

    private RollUpDataPointsPage(
        PageContext<RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint> context,
        RollUpDataPointsResponse response) {
      super(context, response);
    }

    private static RollUpDataPointsPage createEmptyPage() {
      return new RollUpDataPointsPage(null, null);
    }

    @Override
    protected RollUpDataPointsPage createPage(
        PageContext<RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint> context,
        RollUpDataPointsResponse response) {
      return new RollUpDataPointsPage(context, response);
    }

    @Override
    public ApiFuture<RollUpDataPointsPage> createPageAsync(
        PageContext<RollUpDataPointsRequest, RollUpDataPointsResponse, RollupDataPoint> context,
        ApiFuture<RollUpDataPointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class RollUpDataPointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          RollUpDataPointsRequest,
          RollUpDataPointsResponse,
          RollupDataPoint,
          RollUpDataPointsPage,
          RollUpDataPointsFixedSizeCollection> {

    private RollUpDataPointsFixedSizeCollection(
        List<RollUpDataPointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static RollUpDataPointsFixedSizeCollection createEmptyCollection() {
      return new RollUpDataPointsFixedSizeCollection(null, 0);
    }

    @Override
    protected RollUpDataPointsFixedSizeCollection createCollection(
        List<RollUpDataPointsPage> pages, int collectionSize) {
      return new RollUpDataPointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
