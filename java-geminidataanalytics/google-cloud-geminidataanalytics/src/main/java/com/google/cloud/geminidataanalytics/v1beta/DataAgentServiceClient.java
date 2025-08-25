/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.geminidataanalytics.v1beta;

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
import com.google.cloud.geminidataanalytics.v1beta.stub.DataAgentServiceStub;
import com.google.cloud.geminidataanalytics.v1beta.stub.DataAgentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources.
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
 * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
 *   DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
 *   DataAgent response = dataAgentServiceClient.getDataAgent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataAgentServiceClient object to clean up resources
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
 *      <td><p> ListDataAgents</td>
 *      <td><p> Lists DataAgents in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataAgents(ListDataAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataAgents(LocationName parent)
 *           <li><p> listDataAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataAgentsPagedCallable()
 *           <li><p> listDataAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccessibleDataAgents</td>
 *      <td><p> Lists DataAgents that are accessible to the caller in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccessibleDataAgents(ListAccessibleDataAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccessibleDataAgents(LocationName parent)
 *           <li><p> listAccessibleDataAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccessibleDataAgentsPagedCallable()
 *           <li><p> listAccessibleDataAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataAgent</td>
 *      <td><p> Gets details of a single DataAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataAgent(GetDataAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataAgent(DataAgentName name)
 *           <li><p> getDataAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataAgent</td>
 *      <td><p> Creates a new DataAgent in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataAgentAsync(CreateDataAgentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDataAgentAsync(LocationName parent, DataAgent dataAgent, String dataAgentId)
 *           <li><p> createDataAgentAsync(String parent, DataAgent dataAgent, String dataAgentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataAgentOperationCallable()
 *           <li><p> createDataAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataAgent</td>
 *      <td><p> Updates the parameters of a single DataAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataAgentAsync(UpdateDataAgentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDataAgentAsync(DataAgent dataAgent, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataAgentOperationCallable()
 *           <li><p> updateDataAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataAgent</td>
 *      <td><p> Deletes a single DataAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataAgentAsync(DeleteDataAgentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDataAgentAsync(DataAgentName name)
 *           <li><p> deleteDataAgentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataAgentOperationCallable()
 *           <li><p> deleteDataAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM policy for DataAgent</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the IAM policy for a DataAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource)
 *           <li><p> setIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataAgentServiceSettings to
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
 * DataAgentServiceSettings dataAgentServiceSettings =
 *     DataAgentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataAgentServiceClient dataAgentServiceClient =
 *     DataAgentServiceClient.create(dataAgentServiceSettings);
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
 * DataAgentServiceSettings dataAgentServiceSettings =
 *     DataAgentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataAgentServiceClient dataAgentServiceClient =
 *     DataAgentServiceClient.create(dataAgentServiceSettings);
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
 * DataAgentServiceSettings dataAgentServiceSettings =
 *     DataAgentServiceSettings.newHttpJsonBuilder().build();
 * DataAgentServiceClient dataAgentServiceClient =
 *     DataAgentServiceClient.create(dataAgentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataAgentServiceClient implements BackgroundResource {
  private final DataAgentServiceSettings settings;
  private final DataAgentServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DataAgentServiceClient with default settings. */
  public static final DataAgentServiceClient create() throws IOException {
    return create(DataAgentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataAgentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataAgentServiceClient create(DataAgentServiceSettings settings)
      throws IOException {
    return new DataAgentServiceClient(settings);
  }

  /**
   * Constructs an instance of DataAgentServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataAgentServiceSettings).
   */
  public static final DataAgentServiceClient create(DataAgentServiceStub stub) {
    return new DataAgentServiceClient(stub);
  }

  /**
   * Constructs an instance of DataAgentServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataAgentServiceClient(DataAgentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataAgentServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DataAgentServiceClient(DataAgentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DataAgentServiceSettings getSettings() {
    return settings;
  }

  public DataAgentServiceStub getStub() {
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
   * Lists DataAgents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataAgent element : dataAgentServiceClient.listDataAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDataAgentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAgentsPagedResponse listDataAgents(LocationName parent) {
    ListDataAgentsRequest request =
        ListDataAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataAgent element : dataAgentServiceClient.listDataAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDataAgentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAgentsPagedResponse listDataAgents(String parent) {
    ListDataAgentsRequest request = ListDataAgentsRequest.newBuilder().setParent(parent).build();
    return listDataAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListDataAgentsRequest request =
   *       ListDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (DataAgent element : dataAgentServiceClient.listDataAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAgentsPagedResponse listDataAgents(ListDataAgentsRequest request) {
    return listDataAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListDataAgentsRequest request =
   *       ListDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<DataAgent> future =
   *       dataAgentServiceClient.listDataAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAgent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataAgentsRequest, ListDataAgentsPagedResponse>
      listDataAgentsPagedCallable() {
    return stub.listDataAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListDataAgentsRequest request =
   *       ListDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListDataAgentsResponse response =
   *         dataAgentServiceClient.listDataAgentsCallable().call(request);
   *     for (DataAgent element : response.getDataAgentsList()) {
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
  public final UnaryCallable<ListDataAgentsRequest, ListDataAgentsResponse>
      listDataAgentsCallable() {
    return stub.listDataAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents that are accessible to the caller in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DataAgent element :
   *       dataAgentServiceClient.listAccessibleDataAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAccessibleDataAgentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessibleDataAgentsPagedResponse listAccessibleDataAgents(LocationName parent) {
    ListAccessibleDataAgentsRequest request =
        ListAccessibleDataAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccessibleDataAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents that are accessible to the caller in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DataAgent element :
   *       dataAgentServiceClient.listAccessibleDataAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAccessibleDataAgentsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessibleDataAgentsPagedResponse listAccessibleDataAgents(String parent) {
    ListAccessibleDataAgentsRequest request =
        ListAccessibleDataAgentsRequest.newBuilder().setParent(parent).build();
    return listAccessibleDataAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents that are accessible to the caller in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListAccessibleDataAgentsRequest request =
   *       ListAccessibleDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (DataAgent element :
   *       dataAgentServiceClient.listAccessibleDataAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccessibleDataAgentsPagedResponse listAccessibleDataAgents(
      ListAccessibleDataAgentsRequest request) {
    return listAccessibleDataAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents that are accessible to the caller in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListAccessibleDataAgentsRequest request =
   *       ListAccessibleDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<DataAgent> future =
   *       dataAgentServiceClient.listAccessibleDataAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAgent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsPagedCallable() {
    return stub.listAccessibleDataAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataAgents that are accessible to the caller in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListAccessibleDataAgentsRequest request =
   *       ListAccessibleDataAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListAccessibleDataAgentsResponse response =
   *         dataAgentServiceClient.listAccessibleDataAgentsCallable().call(request);
   *     for (DataAgent element : response.getDataAgentsList()) {
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
  public final UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
      listAccessibleDataAgentsCallable() {
    return stub.listAccessibleDataAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
   *   DataAgent response = dataAgentServiceClient.getDataAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAgent getDataAgent(DataAgentName name) {
    GetDataAgentRequest request =
        GetDataAgentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString();
   *   DataAgent response = dataAgentServiceClient.getDataAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAgent getDataAgent(String name) {
    GetDataAgentRequest request = GetDataAgentRequest.newBuilder().setName(name).build();
    return getDataAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetDataAgentRequest request =
   *       GetDataAgentRequest.newBuilder()
   *           .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .build();
   *   DataAgent response = dataAgentServiceClient.getDataAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAgent getDataAgent(GetDataAgentRequest request) {
    return getDataAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetDataAgentRequest request =
   *       GetDataAgentRequest.newBuilder()
   *           .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .build();
   *   ApiFuture<DataAgent> future =
   *       dataAgentServiceClient.getDataAgentCallable().futureCall(request);
   *   // Do something.
   *   DataAgent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAgentRequest, DataAgent> getDataAgentCallable() {
    return stub.getDataAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DataAgent in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DataAgent dataAgent = DataAgent.newBuilder().build();
   *   String dataAgentId = "dataAgentId1752773622";
   *   DataAgent response =
   *       dataAgentServiceClient.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param dataAgent Required. The resource being created.
   * @param dataAgentId Optional. Id of the requesting object. Must be unique within the parent. The
   *     allowed format is: `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`. If not provided, the server will
   *     auto-generate a value for the id.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAgent, OperationMetadata> createDataAgentAsync(
      LocationName parent, DataAgent dataAgent, String dataAgentId) {
    CreateDataAgentRequest request =
        CreateDataAgentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAgent(dataAgent)
            .setDataAgentId(dataAgentId)
            .build();
    return createDataAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DataAgent in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DataAgent dataAgent = DataAgent.newBuilder().build();
   *   String dataAgentId = "dataAgentId1752773622";
   *   DataAgent response =
   *       dataAgentServiceClient.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param dataAgent Required. The resource being created.
   * @param dataAgentId Optional. Id of the requesting object. Must be unique within the parent. The
   *     allowed format is: `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`. If not provided, the server will
   *     auto-generate a value for the id.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAgent, OperationMetadata> createDataAgentAsync(
      String parent, DataAgent dataAgent, String dataAgentId) {
    CreateDataAgentRequest request =
        CreateDataAgentRequest.newBuilder()
            .setParent(parent)
            .setDataAgent(dataAgent)
            .setDataAgentId(dataAgentId)
            .build();
    return createDataAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DataAgent in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   CreateDataAgentRequest request =
   *       CreateDataAgentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAgentId("dataAgentId1752773622")
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DataAgent response = dataAgentServiceClient.createDataAgentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAgent, OperationMetadata> createDataAgentAsync(
      CreateDataAgentRequest request) {
    return createDataAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DataAgent in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   CreateDataAgentRequest request =
   *       CreateDataAgentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAgentId("dataAgentId1752773622")
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DataAgent, OperationMetadata> future =
   *       dataAgentServiceClient.createDataAgentOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAgent response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationCallable() {
    return stub.createDataAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DataAgent in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   CreateDataAgentRequest request =
   *       CreateDataAgentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDataAgentId("dataAgentId1752773622")
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataAgentServiceClient.createDataAgentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAgentRequest, Operation> createDataAgentCallable() {
    return stub.createDataAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DataAgent dataAgent = DataAgent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAgent response = dataAgentServiceClient.updateDataAgentAsync(dataAgent, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataAgent Required. The resource being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     DataAgent resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields with non-default values present in the
   *     request will be overwritten. If a wildcard mask is provided, all fields will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAgent, OperationMetadata> updateDataAgentAsync(
      DataAgent dataAgent, FieldMask updateMask) {
    UpdateDataAgentRequest request =
        UpdateDataAgentRequest.newBuilder()
            .setDataAgent(dataAgent)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   UpdateDataAgentRequest request =
   *       UpdateDataAgentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DataAgent response = dataAgentServiceClient.updateDataAgentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataAgent, OperationMetadata> updateDataAgentAsync(
      UpdateDataAgentRequest request) {
    return updateDataAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   UpdateDataAgentRequest request =
   *       UpdateDataAgentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DataAgent, OperationMetadata> future =
   *       dataAgentServiceClient.updateDataAgentOperationCallable().futureCall(request);
   *   // Do something.
   *   DataAgent response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationCallable() {
    return stub.updateDataAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   UpdateDataAgentRequest request =
   *       UpdateDataAgentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataAgent(DataAgent.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataAgentServiceClient.updateDataAgentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAgentRequest, Operation> updateDataAgentCallable() {
    return stub.updateDataAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DataAgentName name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
   *   dataAgentServiceClient.deleteDataAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAgentAsync(DataAgentName name) {
    DeleteDataAgentRequest request =
        DeleteDataAgentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDataAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String name = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString();
   *   dataAgentServiceClient.deleteDataAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAgentAsync(String name) {
    DeleteDataAgentRequest request = DeleteDataAgentRequest.newBuilder().setName(name).build();
    return deleteDataAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DeleteDataAgentRequest request =
   *       DeleteDataAgentRequest.newBuilder()
   *           .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   dataAgentServiceClient.deleteDataAgentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDataAgentAsync(
      DeleteDataAgentRequest request) {
    return deleteDataAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DeleteDataAgentRequest request =
   *       DeleteDataAgentRequest.newBuilder()
   *           .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataAgentServiceClient.deleteDataAgentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationCallable() {
    return stub.deleteDataAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   DeleteDataAgentRequest request =
   *       DeleteDataAgentRequest.newBuilder()
   *           .setName(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       dataAgentServiceClient.deleteDataAgentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAgentRequest, Operation> deleteDataAgentCallable() {
    return stub.deleteDataAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM policy for DataAgent
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
   *   Policy response = dataAgentServiceClient.getIamPolicy(resource);
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
   * Gets the IAM policy for DataAgent
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy response = dataAgentServiceClient.getIamPolicy(resource);
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
   * Gets the IAM policy for DataAgent
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataAgentServiceClient.getIamPolicy(request);
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
   * Gets the IAM policy for DataAgent
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataAgentServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the IAM policy for a DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ResourceName resource = DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]");
   *   Policy response = dataAgentServiceClient.setIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy for a DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy response = dataAgentServiceClient.setIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource) {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().setResource(resource).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM policy for a DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataAgentServiceClient.setIamPolicy(request);
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
   * Sets the IAM policy for a DataAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DataAgentName.of("[PROJECT]", "[LOCATION]", "[DATA_AGENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataAgentServiceClient.setIamPolicyCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dataAgentServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dataAgentServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dataAgentServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dataAgentServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = dataAgentServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListDataAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListDataAgentsRequest,
          ListDataAgentsResponse,
          DataAgent,
          ListDataAgentsPage,
          ListDataAgentsFixedSizeCollection> {

    public static ApiFuture<ListDataAgentsPagedResponse> createAsync(
        PageContext<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent> context,
        ApiFuture<ListDataAgentsResponse> futureResponse) {
      ApiFuture<ListDataAgentsPage> futurePage =
          ListDataAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAgentsPagedResponse(ListDataAgentsPage page) {
      super(page, ListDataAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAgentsPage
      extends AbstractPage<
          ListDataAgentsRequest, ListDataAgentsResponse, DataAgent, ListDataAgentsPage> {

    private ListDataAgentsPage(
        PageContext<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent> context,
        ListDataAgentsResponse response) {
      super(context, response);
    }

    private static ListDataAgentsPage createEmptyPage() {
      return new ListDataAgentsPage(null, null);
    }

    @Override
    protected ListDataAgentsPage createPage(
        PageContext<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent> context,
        ListDataAgentsResponse response) {
      return new ListDataAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAgentsPage> createPageAsync(
        PageContext<ListDataAgentsRequest, ListDataAgentsResponse, DataAgent> context,
        ApiFuture<ListDataAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAgentsRequest,
          ListDataAgentsResponse,
          DataAgent,
          ListDataAgentsPage,
          ListDataAgentsFixedSizeCollection> {

    private ListDataAgentsFixedSizeCollection(List<ListDataAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAgentsFixedSizeCollection createEmptyCollection() {
      return new ListDataAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAgentsFixedSizeCollection createCollection(
        List<ListDataAgentsPage> pages, int collectionSize) {
      return new ListDataAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAccessibleDataAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          DataAgent,
          ListAccessibleDataAgentsPage,
          ListAccessibleDataAgentsFixedSizeCollection> {

    public static ApiFuture<ListAccessibleDataAgentsPagedResponse> createAsync(
        PageContext<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
            context,
        ApiFuture<ListAccessibleDataAgentsResponse> futureResponse) {
      ApiFuture<ListAccessibleDataAgentsPage> futurePage =
          ListAccessibleDataAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccessibleDataAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccessibleDataAgentsPagedResponse(ListAccessibleDataAgentsPage page) {
      super(page, ListAccessibleDataAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccessibleDataAgentsPage
      extends AbstractPage<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          DataAgent,
          ListAccessibleDataAgentsPage> {

    private ListAccessibleDataAgentsPage(
        PageContext<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
            context,
        ListAccessibleDataAgentsResponse response) {
      super(context, response);
    }

    private static ListAccessibleDataAgentsPage createEmptyPage() {
      return new ListAccessibleDataAgentsPage(null, null);
    }

    @Override
    protected ListAccessibleDataAgentsPage createPage(
        PageContext<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
            context,
        ListAccessibleDataAgentsResponse response) {
      return new ListAccessibleDataAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccessibleDataAgentsPage> createPageAsync(
        PageContext<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse, DataAgent>
            context,
        ApiFuture<ListAccessibleDataAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccessibleDataAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccessibleDataAgentsRequest,
          ListAccessibleDataAgentsResponse,
          DataAgent,
          ListAccessibleDataAgentsPage,
          ListAccessibleDataAgentsFixedSizeCollection> {

    private ListAccessibleDataAgentsFixedSizeCollection(
        List<ListAccessibleDataAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccessibleDataAgentsFixedSizeCollection createEmptyCollection() {
      return new ListAccessibleDataAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccessibleDataAgentsFixedSizeCollection createCollection(
        List<ListAccessibleDataAgentsPage> pages, int collectionSize) {
      return new ListAccessibleDataAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
