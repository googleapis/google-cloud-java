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

package com.google.cloud.managedkafka.v1;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaConnectStub;
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaConnectStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service that a client application uses to manage Apache Kafka Connect
 * clusters and connectors.
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
 * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
 *   ConnectClusterName name =
 *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
 *   ConnectCluster response = managedKafkaConnectClient.getConnectCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ManagedKafkaConnectClient object to clean up resources
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
 *      <td><p> ListConnectClusters</td>
 *      <td><p> Lists the Kafka Connect clusters in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConnectClusters(ListConnectClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConnectClusters(LocationName parent)
 *           <li><p> listConnectClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConnectClustersPagedCallable()
 *           <li><p> listConnectClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConnectCluster</td>
 *      <td><p> Returns the properties of a single Kafka Connect cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnectCluster(GetConnectClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConnectCluster(ConnectClusterName name)
 *           <li><p> getConnectCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConnectCluster</td>
 *      <td><p> Creates a new Kafka Connect cluster in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConnectClusterAsync(CreateConnectClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createConnectClusterAsync(LocationName parent, ConnectCluster connectCluster, String connectClusterId)
 *           <li><p> createConnectClusterAsync(String parent, ConnectCluster connectCluster, String connectClusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConnectClusterOperationCallable()
 *           <li><p> createConnectClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConnectCluster</td>
 *      <td><p> Updates the properties of a single Kafka Connect cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConnectClusterAsync(UpdateConnectClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateConnectClusterAsync(ConnectCluster connectCluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConnectClusterOperationCallable()
 *           <li><p> updateConnectClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConnectCluster</td>
 *      <td><p> Deletes a single Connect cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConnectClusterAsync(DeleteConnectClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteConnectClusterAsync(ConnectClusterName name)
 *           <li><p> deleteConnectClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConnectClusterOperationCallable()
 *           <li><p> deleteConnectClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConnectors</td>
 *      <td><p> Lists the connectors in a given Connect cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConnectors(ListConnectorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConnectors(ConnectClusterName parent)
 *           <li><p> listConnectors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConnectorsPagedCallable()
 *           <li><p> listConnectorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConnector</td>
 *      <td><p> Returns the properties of a single connector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnector(GetConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConnector(ConnectorName name)
 *           <li><p> getConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConnector</td>
 *      <td><p> Creates a new connector in a given Connect cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConnector(CreateConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createConnector(ConnectClusterName parent, Connector connector, String connectorId)
 *           <li><p> createConnector(String parent, Connector connector, String connectorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConnector</td>
 *      <td><p> Updates the properties of a connector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConnector(UpdateConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConnector(Connector connector, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConnector</td>
 *      <td><p> Deletes a connector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConnector(DeleteConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConnector(ConnectorName name)
 *           <li><p> deleteConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PauseConnector</td>
 *      <td><p> Pauses the connector and its tasks.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pauseConnector(PauseConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> pauseConnector(ConnectorName name)
 *           <li><p> pauseConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pauseConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeConnector</td>
 *      <td><p> Resumes the connector and its tasks.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeConnector(ResumeConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> resumeConnector(ConnectorName name)
 *           <li><p> resumeConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestartConnector</td>
 *      <td><p> Restarts the connector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restartConnector(RestartConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> restartConnector(ConnectorName name)
 *           <li><p> restartConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restartConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopConnector</td>
 *      <td><p> Stops the connector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopConnector(StopConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> stopConnector(ConnectorName name)
 *           <li><p> stopConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopConnectorCallable()
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
 * <p>This class can be customized by passing in a custom instance of ManagedKafkaConnectSettings to
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
 * ManagedKafkaConnectSettings managedKafkaConnectSettings =
 *     ManagedKafkaConnectSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ManagedKafkaConnectClient managedKafkaConnectClient =
 *     ManagedKafkaConnectClient.create(managedKafkaConnectSettings);
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
 * ManagedKafkaConnectSettings managedKafkaConnectSettings =
 *     ManagedKafkaConnectSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ManagedKafkaConnectClient managedKafkaConnectClient =
 *     ManagedKafkaConnectClient.create(managedKafkaConnectSettings);
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
 * ManagedKafkaConnectSettings managedKafkaConnectSettings =
 *     ManagedKafkaConnectSettings.newHttpJsonBuilder().build();
 * ManagedKafkaConnectClient managedKafkaConnectClient =
 *     ManagedKafkaConnectClient.create(managedKafkaConnectSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaConnectClient implements BackgroundResource {
  private final ManagedKafkaConnectSettings settings;
  private final ManagedKafkaConnectStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ManagedKafkaConnectClient with default settings. */
  public static final ManagedKafkaConnectClient create() throws IOException {
    return create(ManagedKafkaConnectSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ManagedKafkaConnectClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ManagedKafkaConnectClient create(ManagedKafkaConnectSettings settings)
      throws IOException {
    return new ManagedKafkaConnectClient(settings);
  }

  /**
   * Constructs an instance of ManagedKafkaConnectClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ManagedKafkaConnectSettings).
   */
  public static final ManagedKafkaConnectClient create(ManagedKafkaConnectStub stub) {
    return new ManagedKafkaConnectClient(stub);
  }

  /**
   * Constructs an instance of ManagedKafkaConnectClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ManagedKafkaConnectClient(ManagedKafkaConnectSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ManagedKafkaConnectStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ManagedKafkaConnectClient(ManagedKafkaConnectStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ManagedKafkaConnectSettings getSettings() {
    return settings;
  }

  public ManagedKafkaConnectStub getStub() {
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
   * Lists the Kafka Connect clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ConnectCluster element :
   *       managedKafkaConnectClient.listConnectClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project/location whose Connect clusters are to be listed.
   *     Structured like `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectClustersPagedResponse listConnectClusters(LocationName parent) {
    ListConnectClustersRequest request =
        ListConnectClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnectClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Kafka Connect clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ConnectCluster element :
   *       managedKafkaConnectClient.listConnectClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project/location whose Connect clusters are to be listed.
   *     Structured like `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectClustersPagedResponse listConnectClusters(String parent) {
    ListConnectClustersRequest request =
        ListConnectClustersRequest.newBuilder().setParent(parent).build();
    return listConnectClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Kafka Connect clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectClustersRequest request =
   *       ListConnectClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ConnectCluster element :
   *       managedKafkaConnectClient.listConnectClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectClustersPagedResponse listConnectClusters(
      ListConnectClustersRequest request) {
    return listConnectClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Kafka Connect clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectClustersRequest request =
   *       ListConnectClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ConnectCluster> future =
   *       managedKafkaConnectClient.listConnectClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConnectCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable() {
    return stub.listConnectClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Kafka Connect clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectClustersRequest request =
   *       ListConnectClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectClustersResponse response =
   *         managedKafkaConnectClient.listConnectClustersCallable().call(request);
   *     for (ConnectCluster element : response.getConnectClustersList()) {
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
  public final UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable() {
    return stub.listConnectClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectClusterName name =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
   *   ConnectCluster response = managedKafkaConnectClient.getConnectCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Kafka Connect cluster whose configuration to return.
   *     Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectCluster getConnectCluster(ConnectClusterName name) {
    GetConnectClusterRequest request =
        GetConnectClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConnectCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString();
   *   ConnectCluster response = managedKafkaConnectClient.getConnectCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Kafka Connect cluster whose configuration to return.
   *     Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectCluster getConnectCluster(String name) {
    GetConnectClusterRequest request = GetConnectClusterRequest.newBuilder().setName(name).build();
    return getConnectCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetConnectClusterRequest request =
   *       GetConnectClusterRequest.newBuilder()
   *           .setName(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .build();
   *   ConnectCluster response = managedKafkaConnectClient.getConnectCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectCluster getConnectCluster(GetConnectClusterRequest request) {
    return getConnectClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetConnectClusterRequest request =
   *       GetConnectClusterRequest.newBuilder()
   *           .setName(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<ConnectCluster> future =
   *       managedKafkaConnectClient.getConnectClusterCallable().futureCall(request);
   *   // Do something.
   *   ConnectCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable() {
    return stub.getConnectClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Kafka Connect cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
   *   String connectClusterId = "connectClusterId-1562078485";
   *   ConnectCluster response =
   *       managedKafkaConnectClient
   *           .createConnectClusterAsync(parent, connectCluster, connectClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent project/location in which to create the Kafka Connect
   *     cluster. Structured like `projects/{project}/locations/{location}/`.
   * @param connectCluster Required. Configuration of the Kafka Connect cluster to create. Its
   *     `name` field is ignored.
   * @param connectClusterId Required. The ID to use for the Connect cluster, which will become the
   *     final component of the cluster's name. The ID must be 1-63 characters long, and match the
   *     regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-cluster-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectCluster, OperationMetadata> createConnectClusterAsync(
      LocationName parent, ConnectCluster connectCluster, String connectClusterId) {
    CreateConnectClusterRequest request =
        CreateConnectClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnectCluster(connectCluster)
            .setConnectClusterId(connectClusterId)
            .build();
    return createConnectClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Kafka Connect cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
   *   String connectClusterId = "connectClusterId-1562078485";
   *   ConnectCluster response =
   *       managedKafkaConnectClient
   *           .createConnectClusterAsync(parent, connectCluster, connectClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent project/location in which to create the Kafka Connect
   *     cluster. Structured like `projects/{project}/locations/{location}/`.
   * @param connectCluster Required. Configuration of the Kafka Connect cluster to create. Its
   *     `name` field is ignored.
   * @param connectClusterId Required. The ID to use for the Connect cluster, which will become the
   *     final component of the cluster's name. The ID must be 1-63 characters long, and match the
   *     regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-cluster-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectCluster, OperationMetadata> createConnectClusterAsync(
      String parent, ConnectCluster connectCluster, String connectClusterId) {
    CreateConnectClusterRequest request =
        CreateConnectClusterRequest.newBuilder()
            .setParent(parent)
            .setConnectCluster(connectCluster)
            .setConnectClusterId(connectClusterId)
            .build();
    return createConnectClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Kafka Connect cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   CreateConnectClusterRequest request =
   *       CreateConnectClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectClusterId("connectClusterId-1562078485")
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ConnectCluster response = managedKafkaConnectClient.createConnectClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectCluster, OperationMetadata> createConnectClusterAsync(
      CreateConnectClusterRequest request) {
    return createConnectClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Kafka Connect cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   CreateConnectClusterRequest request =
   *       CreateConnectClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectClusterId("connectClusterId-1562078485")
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ConnectCluster, OperationMetadata> future =
   *       managedKafkaConnectClient.createConnectClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable() {
    return stub.createConnectClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Kafka Connect cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   CreateConnectClusterRequest request =
   *       CreateConnectClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectClusterId("connectClusterId-1562078485")
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedKafkaConnectClient.createConnectClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectClusterRequest, Operation>
      createConnectClusterCallable() {
    return stub.createConnectClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConnectCluster response =
   *       managedKafkaConnectClient.updateConnectClusterAsync(connectCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param connectCluster Required. The Kafka Connect cluster to update. Its `name` field must be
   *     populated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     cluster resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The mask
   *     is required and a value of &#42; will update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectCluster, OperationMetadata> updateConnectClusterAsync(
      ConnectCluster connectCluster, FieldMask updateMask) {
    UpdateConnectClusterRequest request =
        UpdateConnectClusterRequest.newBuilder()
            .setConnectCluster(connectCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateConnectClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   UpdateConnectClusterRequest request =
   *       UpdateConnectClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ConnectCluster response = managedKafkaConnectClient.updateConnectClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ConnectCluster, OperationMetadata> updateConnectClusterAsync(
      UpdateConnectClusterRequest request) {
    return updateConnectClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   UpdateConnectClusterRequest request =
   *       UpdateConnectClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ConnectCluster, OperationMetadata> future =
   *       managedKafkaConnectClient.updateConnectClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   ConnectCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable() {
    return stub.updateConnectClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single Kafka Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   UpdateConnectClusterRequest request =
   *       UpdateConnectClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnectCluster(ConnectCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedKafkaConnectClient.updateConnectClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectClusterRequest, Operation>
      updateConnectClusterCallable() {
    return stub.updateConnectClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectClusterName name =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
   *   managedKafkaConnectClient.deleteConnectClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Kafka Connect cluster to delete. Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectClusterAsync(
      ConnectClusterName name) {
    DeleteConnectClusterRequest request =
        DeleteConnectClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteConnectClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString();
   *   managedKafkaConnectClient.deleteConnectClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Kafka Connect cluster to delete. Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectClusterAsync(String name) {
    DeleteConnectClusterRequest request =
        DeleteConnectClusterRequest.newBuilder().setName(name).build();
    return deleteConnectClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   DeleteConnectClusterRequest request =
   *       DeleteConnectClusterRequest.newBuilder()
   *           .setName(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   managedKafkaConnectClient.deleteConnectClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectClusterAsync(
      DeleteConnectClusterRequest request) {
    return deleteConnectClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   DeleteConnectClusterRequest request =
   *       DeleteConnectClusterRequest.newBuilder()
   *           .setName(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       managedKafkaConnectClient.deleteConnectClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable() {
    return stub.deleteConnectClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   DeleteConnectClusterRequest request =
   *       DeleteConnectClusterRequest.newBuilder()
   *           .setName(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedKafkaConnectClient.deleteConnectClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectClusterRequest, Operation>
      deleteConnectClusterCallable() {
    return stub.deleteConnectClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connectors in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectClusterName parent =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
   *   for (Connector element : managedKafkaConnectClient.listConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Connect cluster whose connectors are to be listed.
   *     Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(ConnectClusterName parent) {
    ListConnectorsRequest request =
        ListConnectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connectors in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String parent =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString();
   *   for (Connector element : managedKafkaConnectClient.listConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent Connect cluster whose connectors are to be listed.
   *     Structured like
   *     `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(String parent) {
    ListConnectorsRequest request = ListConnectorsRequest.newBuilder().setParent(parent).build();
    return listConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connectors in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Connector element : managedKafkaConnectClient.listConnectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectorsPagedResponse listConnectors(ListConnectorsRequest request) {
    return listConnectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connectors in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Connector> future =
   *       managedKafkaConnectClient.listConnectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Connector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    return stub.listConnectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the connectors in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListConnectorsRequest request =
   *       ListConnectorsRequest.newBuilder()
   *           .setParent(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConnectorsResponse response =
   *         managedKafkaConnectClient.listConnectorsCallable().call(request);
   *     for (Connector element : response.getConnectorsList()) {
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
  public final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsCallable() {
    return stub.listConnectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   Connector response = managedKafkaConnectClient.getConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector whose configuration to return. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(ConnectorName name) {
    GetConnectorRequest request =
        GetConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   Connector response = managedKafkaConnectClient.getConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector whose configuration to return. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(String name) {
    GetConnectorRequest request = GetConnectorRequest.newBuilder().setName(name).build();
    return getConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetConnectorRequest request =
   *       GetConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   Connector response = managedKafkaConnectClient.getConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector getConnector(GetConnectorRequest request) {
    return getConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetConnectorRequest request =
   *       GetConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Connector> future =
   *       managedKafkaConnectClient.getConnectorCallable().futureCall(request);
   *   // Do something.
   *   Connector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return stub.getConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connector in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectClusterName parent =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
   *   Connector connector = Connector.newBuilder().build();
   *   String connectorId = "connectorId1724784200";
   *   Connector response =
   *       managedKafkaConnectClient.createConnector(parent, connector, connectorId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent Connect cluster in which to create the connector. Structured
   *     like `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @param connector Required. The connector to create.
   * @param connectorId Required. The ID to use for the connector, which will become the final
   *     component of the connector's name. The ID must be 1-63 characters long, and match the
   *     regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-connector-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector createConnector(
      ConnectClusterName parent, Connector connector, String connectorId) {
    CreateConnectorRequest request =
        CreateConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnector(connector)
            .setConnectorId(connectorId)
            .build();
    return createConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connector in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String parent =
   *       ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString();
   *   Connector connector = Connector.newBuilder().build();
   *   String connectorId = "connectorId1724784200";
   *   Connector response =
   *       managedKafkaConnectClient.createConnector(parent, connector, connectorId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent Connect cluster in which to create the connector. Structured
   *     like `projects/{project}/locations/{location}/connectClusters/{connect_cluster_id}`.
   * @param connector Required. The connector to create.
   * @param connectorId Required. The ID to use for the connector, which will become the final
   *     component of the connector's name. The ID must be 1-63 characters long, and match the
   *     regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-connector-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector createConnector(String parent, Connector connector, String connectorId) {
    CreateConnectorRequest request =
        CreateConnectorRequest.newBuilder()
            .setParent(parent)
            .setConnector(connector)
            .setConnectorId(connectorId)
            .build();
    return createConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connector in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   CreateConnectorRequest request =
   *       CreateConnectorRequest.newBuilder()
   *           .setParent(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setConnectorId("connectorId1724784200")
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   Connector response = managedKafkaConnectClient.createConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector createConnector(CreateConnectorRequest request) {
    return createConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connector in a given Connect cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   CreateConnectorRequest request =
   *       CreateConnectorRequest.newBuilder()
   *           .setParent(
   *               ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
   *           .setConnectorId("connectorId1724784200")
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   ApiFuture<Connector> future =
   *       managedKafkaConnectClient.createConnectorCallable().futureCall(request);
   *   // Do something.
   *   Connector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable() {
    return stub.createConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   Connector connector = Connector.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Connector response = managedKafkaConnectClient.updateConnector(connector, updateMask);
   * }
   * }</pre>
   *
   * @param connector Required. The connector to update. Its `name` field must be populated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     cluster resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The mask
   *     is required and a value of &#42; will update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector updateConnector(Connector connector, FieldMask updateMask) {
    UpdateConnectorRequest request =
        UpdateConnectorRequest.newBuilder()
            .setConnector(connector)
            .setUpdateMask(updateMask)
            .build();
    return updateConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   UpdateConnectorRequest request =
   *       UpdateConnectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   Connector response = managedKafkaConnectClient.updateConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connector updateConnector(UpdateConnectorRequest request) {
    return updateConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   UpdateConnectorRequest request =
   *       UpdateConnectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnector(Connector.newBuilder().build())
   *           .build();
   *   ApiFuture<Connector> future =
   *       managedKafkaConnectClient.updateConnectorCallable().futureCall(request);
   *   // Do something.
   *   Connector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable() {
    return stub.updateConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   managedKafkaConnectClient.deleteConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to delete. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnector(ConnectorName name) {
    DeleteConnectorRequest request =
        DeleteConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   managedKafkaConnectClient.deleteConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to delete. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnector(String name) {
    DeleteConnectorRequest request = DeleteConnectorRequest.newBuilder().setName(name).build();
    deleteConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   DeleteConnectorRequest request =
   *       DeleteConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   managedKafkaConnectClient.deleteConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnector(DeleteConnectorRequest request) {
    deleteConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   DeleteConnectorRequest request =
   *       DeleteConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       managedKafkaConnectClient.deleteConnectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable() {
    return stub.deleteConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   PauseConnectorResponse response = managedKafkaConnectClient.pauseConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to pause. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PauseConnectorResponse pauseConnector(ConnectorName name) {
    PauseConnectorRequest request =
        PauseConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return pauseConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   PauseConnectorResponse response = managedKafkaConnectClient.pauseConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to pause. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PauseConnectorResponse pauseConnector(String name) {
    PauseConnectorRequest request = PauseConnectorRequest.newBuilder().setName(name).build();
    return pauseConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   PauseConnectorRequest request =
   *       PauseConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   PauseConnectorResponse response = managedKafkaConnectClient.pauseConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PauseConnectorResponse pauseConnector(PauseConnectorRequest request) {
    return pauseConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   PauseConnectorRequest request =
   *       PauseConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PauseConnectorResponse> future =
   *       managedKafkaConnectClient.pauseConnectorCallable().futureCall(request);
   *   // Do something.
   *   PauseConnectorResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseConnectorRequest, PauseConnectorResponse>
      pauseConnectorCallable() {
    return stub.pauseConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   ResumeConnectorResponse response = managedKafkaConnectClient.resumeConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to pause. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResumeConnectorResponse resumeConnector(ConnectorName name) {
    ResumeConnectorRequest request =
        ResumeConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resumeConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   ResumeConnectorResponse response = managedKafkaConnectClient.resumeConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to pause. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResumeConnectorResponse resumeConnector(String name) {
    ResumeConnectorRequest request = ResumeConnectorRequest.newBuilder().setName(name).build();
    return resumeConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ResumeConnectorRequest request =
   *       ResumeConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ResumeConnectorResponse response = managedKafkaConnectClient.resumeConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResumeConnectorResponse resumeConnector(ResumeConnectorRequest request) {
    return resumeConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the connector and its tasks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ResumeConnectorRequest request =
   *       ResumeConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResumeConnectorResponse> future =
   *       managedKafkaConnectClient.resumeConnectorCallable().futureCall(request);
   *   // Do something.
   *   ResumeConnectorResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorCallable() {
    return stub.resumeConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   RestartConnectorResponse response = managedKafkaConnectClient.restartConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to restart. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestartConnectorResponse restartConnector(ConnectorName name) {
    RestartConnectorRequest request =
        RestartConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return restartConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   RestartConnectorResponse response = managedKafkaConnectClient.restartConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to restart. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestartConnectorResponse restartConnector(String name) {
    RestartConnectorRequest request = RestartConnectorRequest.newBuilder().setName(name).build();
    return restartConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   RestartConnectorRequest request =
   *       RestartConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   RestartConnectorResponse response = managedKafkaConnectClient.restartConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestartConnectorResponse restartConnector(RestartConnectorRequest request) {
    return restartConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   RestartConnectorRequest request =
   *       RestartConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RestartConnectorResponse> future =
   *       managedKafkaConnectClient.restartConnectorCallable().futureCall(request);
   *   // Do something.
   *   RestartConnectorResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable() {
    return stub.restartConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ConnectorName name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
   *   StopConnectorResponse response = managedKafkaConnectClient.stopConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to stop. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopConnectorResponse stopConnector(ConnectorName name) {
    StopConnectorRequest request =
        StopConnectorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   String name =
   *       ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *           .toString();
   *   StopConnectorResponse response = managedKafkaConnectClient.stopConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the connector to stop. Structured like:
   *     projects/{project}/locations/{location}/connectClusters/{connectCluster}/connectors/{connector}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopConnectorResponse stopConnector(String name) {
    StopConnectorRequest request = StopConnectorRequest.newBuilder().setName(name).build();
    return stopConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   StopConnectorRequest request =
   *       StopConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   StopConnectorResponse response = managedKafkaConnectClient.stopConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StopConnectorResponse stopConnector(StopConnectorRequest request) {
    return stopConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the connector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   StopConnectorRequest request =
   *       StopConnectorRequest.newBuilder()
   *           .setName(
   *               ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<StopConnectorResponse> future =
   *       managedKafkaConnectClient.stopConnectorCallable().futureCall(request);
   *   // Do something.
   *   StopConnectorResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable() {
    return stub.stopConnectorCallable();
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
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : managedKafkaConnectClient.listLocations(request).iterateAll()) {
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
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       managedKafkaConnectClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         managedKafkaConnectClient.listLocationsCallable().call(request);
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
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = managedKafkaConnectClient.getLocation(request);
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
   * try (ManagedKafkaConnectClient managedKafkaConnectClient = ManagedKafkaConnectClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       managedKafkaConnectClient.getLocationCallable().futureCall(request);
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

  public static class ListConnectClustersPagedResponse
      extends AbstractPagedListResponse<
          ListConnectClustersRequest,
          ListConnectClustersResponse,
          ConnectCluster,
          ListConnectClustersPage,
          ListConnectClustersFixedSizeCollection> {

    public static ApiFuture<ListConnectClustersPagedResponse> createAsync(
        PageContext<ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
            context,
        ApiFuture<ListConnectClustersResponse> futureResponse) {
      ApiFuture<ListConnectClustersPage> futurePage =
          ListConnectClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectClustersPagedResponse(ListConnectClustersPage page) {
      super(page, ListConnectClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectClustersPage
      extends AbstractPage<
          ListConnectClustersRequest,
          ListConnectClustersResponse,
          ConnectCluster,
          ListConnectClustersPage> {

    private ListConnectClustersPage(
        PageContext<ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
            context,
        ListConnectClustersResponse response) {
      super(context, response);
    }

    private static ListConnectClustersPage createEmptyPage() {
      return new ListConnectClustersPage(null, null);
    }

    @Override
    protected ListConnectClustersPage createPage(
        PageContext<ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
            context,
        ListConnectClustersResponse response) {
      return new ListConnectClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectClustersPage> createPageAsync(
        PageContext<ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
            context,
        ApiFuture<ListConnectClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectClustersRequest,
          ListConnectClustersResponse,
          ConnectCluster,
          ListConnectClustersPage,
          ListConnectClustersFixedSizeCollection> {

    private ListConnectClustersFixedSizeCollection(
        List<ListConnectClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectClustersFixedSizeCollection createEmptyCollection() {
      return new ListConnectClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectClustersFixedSizeCollection createCollection(
        List<ListConnectClustersPage> pages, int collectionSize) {
      return new ListConnectClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConnectorsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectorsRequest,
          ListConnectorsResponse,
          Connector,
          ListConnectorsPage,
          ListConnectorsFixedSizeCollection> {

    public static ApiFuture<ListConnectorsPagedResponse> createAsync(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ApiFuture<ListConnectorsResponse> futureResponse) {
      ApiFuture<ListConnectorsPage> futurePage =
          ListConnectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectorsPagedResponse(ListConnectorsPage page) {
      super(page, ListConnectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectorsPage
      extends AbstractPage<
          ListConnectorsRequest, ListConnectorsResponse, Connector, ListConnectorsPage> {

    private ListConnectorsPage(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ListConnectorsResponse response) {
      super(context, response);
    }

    private static ListConnectorsPage createEmptyPage() {
      return new ListConnectorsPage(null, null);
    }

    @Override
    protected ListConnectorsPage createPage(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ListConnectorsResponse response) {
      return new ListConnectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectorsPage> createPageAsync(
        PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> context,
        ApiFuture<ListConnectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectorsRequest,
          ListConnectorsResponse,
          Connector,
          ListConnectorsPage,
          ListConnectorsFixedSizeCollection> {

    private ListConnectorsFixedSizeCollection(List<ListConnectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectorsFixedSizeCollection createEmptyCollection() {
      return new ListConnectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectorsFixedSizeCollection createCollection(
        List<ListConnectorsPage> pages, int collectionSize) {
      return new ListConnectorsFixedSizeCollection(pages, collectionSize);
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
