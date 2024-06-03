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
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaStub;
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaStubSettings;
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
 * Service Description: The service that a client application uses to manage Apache Kafka clusters,
 * topics and consumer groups.
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
 * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
 *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
 *   Cluster response = managedKafkaClient.getCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ManagedKafkaClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListClusters</td>
 *      <td><p> Lists the clusters in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClusters(ListClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClusters(LocationName parent)
 *           <li><p> listClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClustersPagedCallable()
 *           <li><p> listClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCluster</td>
 *      <td><p> Returns the properties of a single cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCluster(GetClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCluster(ClusterName name)
 *           <li><p> getCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCluster</td>
 *      <td><p> Creates a new cluster in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClusterAsync(CreateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClusterAsync(LocationName parent, Cluster cluster, String clusterId)
 *           <li><p> createClusterAsync(String parent, Cluster cluster, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClusterOperationCallable()
 *           <li><p> createClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCluster</td>
 *      <td><p> Updates the properties of a single cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(UpdateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(Cluster cluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClusterOperationCallable()
 *           <li><p> updateClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCluster</td>
 *      <td><p> Deletes a single cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(DeleteClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(ClusterName name)
 *           <li><p> deleteClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClusterOperationCallable()
 *           <li><p> deleteClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTopics</td>
 *      <td><p> Lists the topics in a given cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTopics(ListTopicsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTopics(ClusterName parent)
 *           <li><p> listTopics(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTopicsPagedCallable()
 *           <li><p> listTopicsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTopic</td>
 *      <td><p> Returns the properties of a single topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTopic(GetTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTopic(TopicName name)
 *           <li><p> getTopic(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTopic</td>
 *      <td><p> Creates a new topic in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTopic(CreateTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTopic(ClusterName parent, Topic topic, String topicId)
 *           <li><p> createTopic(String parent, Topic topic, String topicId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTopic</td>
 *      <td><p> Updates the properties of a single topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTopic(UpdateTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTopic(Topic topic, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTopic</td>
 *      <td><p> Deletes a single topic.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTopic(DeleteTopicRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTopic(TopicName name)
 *           <li><p> deleteTopic(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTopicCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConsumerGroups</td>
 *      <td><p> Lists the consumer groups in a given cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConsumerGroups(ListConsumerGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConsumerGroups(ClusterName parent)
 *           <li><p> listConsumerGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConsumerGroupsPagedCallable()
 *           <li><p> listConsumerGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConsumerGroup</td>
 *      <td><p> Returns the properties of a single consumer group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConsumerGroup(GetConsumerGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConsumerGroup(ConsumerGroupName name)
 *           <li><p> getConsumerGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConsumerGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConsumerGroup</td>
 *      <td><p> Updates the properties of a single consumer group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConsumerGroup(UpdateConsumerGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateConsumerGroup(ConsumerGroup consumerGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConsumerGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConsumerGroup</td>
 *      <td><p> Deletes a single consumer group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConsumerGroup(DeleteConsumerGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConsumerGroup(ConsumerGroupName name)
 *           <li><p> deleteConsumerGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConsumerGroupCallable()
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
 * <p>This class can be customized by passing in a custom instance of ManagedKafkaSettings to
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
 * ManagedKafkaSettings managedKafkaSettings =
 *     ManagedKafkaSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create(managedKafkaSettings);
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
 * ManagedKafkaSettings managedKafkaSettings =
 *     ManagedKafkaSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create(managedKafkaSettings);
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
 * ManagedKafkaSettings managedKafkaSettings = ManagedKafkaSettings.newHttpJsonBuilder().build();
 * ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create(managedKafkaSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaClient implements BackgroundResource {
  private final ManagedKafkaSettings settings;
  private final ManagedKafkaStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ManagedKafkaClient with default settings. */
  public static final ManagedKafkaClient create() throws IOException {
    return create(ManagedKafkaSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ManagedKafkaClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ManagedKafkaClient create(ManagedKafkaSettings settings) throws IOException {
    return new ManagedKafkaClient(settings);
  }

  /**
   * Constructs an instance of ManagedKafkaClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ManagedKafkaSettings).
   */
  public static final ManagedKafkaClient create(ManagedKafkaStub stub) {
    return new ManagedKafkaClient(stub);
  }

  /**
   * Constructs an instance of ManagedKafkaClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ManagedKafkaClient(ManagedKafkaSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ManagedKafkaStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ManagedKafkaClient(ManagedKafkaStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ManagedKafkaSettings getSettings() {
    return settings;
  }

  public ManagedKafkaStub getStub() {
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
   * Lists the clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Cluster element : managedKafkaClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location whose clusters are to be listed. Structured like
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(LocationName parent) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Cluster element : managedKafkaClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location whose clusters are to be listed. Structured like
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Cluster element : managedKafkaClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       managedKafkaClient.listClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response = managedKafkaClient.listClustersCallable().call(request);
   *     for (Cluster element : response.getClustersList()) {
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
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Cluster response = managedKafkaClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the cluster whose configuration to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Cluster response = managedKafkaClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the cluster whose configuration to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   Cluster response = managedKafkaClient.getCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<Cluster> future = managedKafkaClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = managedKafkaClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent region in which to create the cluster. Structured like
   *     `projects/{project}/locations/{location}`.
   * @param cluster Required. Configuration of the cluster to create. Its `name` field is ignored.
   * @param clusterId Required. The ID to use for the cluster, which will become the final component
   *     of the cluster's name. The ID must be 1-63 characters long, and match the regular
   *     expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-cluster-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      LocationName parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = managedKafkaClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent region in which to create the cluster. Structured like
   *     `projects/{project}/locations/{location}`.
   * @param cluster Required. Configuration of the cluster to create. Its `name` field is ignored.
   * @param clusterId Required. The ID to use for the cluster, which will become the final component
   *     of the cluster's name. The ID must be 1-63 characters long, and match the regular
   *     expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` to comply with RFC 1035.
   *     <p>This value is structured like: `my-cluster-id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      String parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = managedKafkaClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> createClusterAsync(
      CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       managedKafkaClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = managedKafkaClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response = managedKafkaClient.updateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. The cluster to update. Its `name` field must be populated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     cluster resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The mask
   *     is required and a value of &#42; will update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      Cluster cluster, FieldMask updateMask) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder().setCluster(cluster).setUpdateMask(updateMask).build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = managedKafkaClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, OperationMetadata> updateClusterAsync(
      UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       managedKafkaClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = managedKafkaClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   managedKafkaClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the cluster to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   managedKafkaClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the cluster to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   managedKafkaClient.deleteClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(
      DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       managedKafkaClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = managedKafkaClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topics in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Topic element : managedKafkaClient.listTopics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster whose topics are to be listed. Structured like
   *     `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ClusterName parent) {
    ListTopicsRequest request =
        ListTopicsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topics in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Topic element : managedKafkaClient.listTopics(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster whose topics are to be listed. Structured like
   *     `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(String parent) {
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setParent(parent).build();
    return listTopics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topics in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Topic element : managedKafkaClient.listTopics(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTopicsPagedResponse listTopics(ListTopicsRequest request) {
    return listTopicsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topics in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Topic> future = managedKafkaClient.listTopicsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Topic element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return stub.listTopicsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topics in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListTopicsRequest request =
   *       ListTopicsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTopicsResponse response = managedKafkaClient.listTopicsCallable().call(request);
   *     for (Topic element : response.getTopicsList()) {
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
  public final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return stub.listTopicsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");
   *   Topic response = managedKafkaClient.getTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic whose configuration to return. Structured like:
   *     projects/{project}/locations/{location}/clusters/{cluster}/topics/{topic}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(TopicName name) {
    GetTopicRequest request =
        GetTopicRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString();
   *   Topic response = managedKafkaClient.getTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic whose configuration to return. Structured like:
   *     projects/{project}/locations/{location}/clusters/{cluster}/topics/{topic}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(String name) {
    GetTopicRequest request = GetTopicRequest.newBuilder().setName(name).build();
    return getTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetTopicRequest request =
   *       GetTopicRequest.newBuilder()
   *           .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
   *           .build();
   *   Topic response = managedKafkaClient.getTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic getTopic(GetTopicRequest request) {
    return getTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetTopicRequest request =
   *       GetTopicRequest.newBuilder()
   *           .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
   *           .build();
   *   ApiFuture<Topic> future = managedKafkaClient.getTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return stub.getTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new topic in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Topic topic = Topic.newBuilder().build();
   *   String topicId = "topicId-1139259734";
   *   Topic response = managedKafkaClient.createTopic(parent, topic, topicId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster in which to create the topic. Structured like
   *     `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @param topic Required. Configuration of the topic to create. Its `name` field is ignored.
   * @param topicId Required. The ID to use for the topic, which will become the final component of
   *     the topic's name.
   *     <p>This value is structured like: `my-topic-name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(ClusterName parent, Topic topic, String topicId) {
    CreateTopicRequest request =
        CreateTopicRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTopic(topic)
            .setTopicId(topicId)
            .build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new topic in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Topic topic = Topic.newBuilder().build();
   *   String topicId = "topicId-1139259734";
   *   Topic response = managedKafkaClient.createTopic(parent, topic, topicId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster in which to create the topic. Structured like
   *     `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @param topic Required. Configuration of the topic to create. Its `name` field is ignored.
   * @param topicId Required. The ID to use for the topic, which will become the final component of
   *     the topic's name.
   *     <p>This value is structured like: `my-topic-name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(String parent, Topic topic, String topicId) {
    CreateTopicRequest request =
        CreateTopicRequest.newBuilder()
            .setParent(parent)
            .setTopic(topic)
            .setTopicId(topicId)
            .build();
    return createTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new topic in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   CreateTopicRequest request =
   *       CreateTopicRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setTopicId("topicId-1139259734")
   *           .setTopic(Topic.newBuilder().build())
   *           .build();
   *   Topic response = managedKafkaClient.createTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic createTopic(CreateTopicRequest request) {
    return createTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new topic in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   CreateTopicRequest request =
   *       CreateTopicRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setTopicId("topicId-1139259734")
   *           .setTopic(Topic.newBuilder().build())
   *           .build();
   *   ApiFuture<Topic> future = managedKafkaClient.createTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTopicRequest, Topic> createTopicCallable() {
    return stub.createTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   Topic topic = Topic.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Topic response = managedKafkaClient.updateTopic(topic, updateMask);
   * }
   * }</pre>
   *
   * @param topic Required. The topic to update. Its `name` field must be populated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Topic resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. The mask
   *     is required and a value of &#42; will update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic updateTopic(Topic topic, FieldMask updateMask) {
    UpdateTopicRequest request =
        UpdateTopicRequest.newBuilder().setTopic(topic).setUpdateMask(updateMask).build();
    return updateTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateTopicRequest request =
   *       UpdateTopicRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTopic(Topic.newBuilder().build())
   *           .build();
   *   Topic response = managedKafkaClient.updateTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Topic updateTopic(UpdateTopicRequest request) {
    return updateTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateTopicRequest request =
   *       UpdateTopicRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTopic(Topic.newBuilder().build())
   *           .build();
   *   ApiFuture<Topic> future = managedKafkaClient.updateTopicCallable().futureCall(request);
   *   // Do something.
   *   Topic response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return stub.updateTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   TopicName name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]");
   *   managedKafkaClient.deleteTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic to delete.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(TopicName name) {
    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name = TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString();
   *   managedKafkaClient.deleteTopic(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the topic to delete.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(String name) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setName(name).build();
    deleteTopic(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteTopicRequest request =
   *       DeleteTopicRequest.newBuilder()
   *           .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
   *           .build();
   *   managedKafkaClient.deleteTopic(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTopic(DeleteTopicRequest request) {
    deleteTopicCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteTopicRequest request =
   *       DeleteTopicRequest.newBuilder()
   *           .setName(TopicName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[TOPIC]").toString())
   *           .build();
   *   ApiFuture<Empty> future = managedKafkaClient.deleteTopicCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return stub.deleteTopicCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the consumer groups in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (ConsumerGroup element : managedKafkaClient.listConsumerGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster whose consumer groups are to be listed. Structured
   *     like `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConsumerGroupsPagedResponse listConsumerGroups(ClusterName parent) {
    ListConsumerGroupsRequest request =
        ListConsumerGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConsumerGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the consumer groups in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (ConsumerGroup element : managedKafkaClient.listConsumerGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent cluster whose consumer groups are to be listed. Structured
   *     like `projects/{project}/locations/{location}/clusters/{cluster}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConsumerGroupsPagedResponse listConsumerGroups(String parent) {
    ListConsumerGroupsRequest request =
        ListConsumerGroupsRequest.newBuilder().setParent(parent).build();
    return listConsumerGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the consumer groups in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListConsumerGroupsRequest request =
   *       ListConsumerGroupsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ConsumerGroup element : managedKafkaClient.listConsumerGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConsumerGroupsPagedResponse listConsumerGroups(
      ListConsumerGroupsRequest request) {
    return listConsumerGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the consumer groups in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListConsumerGroupsRequest request =
   *       ListConsumerGroupsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ConsumerGroup> future =
   *       managedKafkaClient.listConsumerGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ConsumerGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsPagedResponse>
      listConsumerGroupsPagedCallable() {
    return stub.listConsumerGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the consumer groups in a given cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListConsumerGroupsRequest request =
   *       ListConsumerGroupsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListConsumerGroupsResponse response =
   *         managedKafkaClient.listConsumerGroupsCallable().call(request);
   *     for (ConsumerGroup element : response.getConsumerGroupsList()) {
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
  public final UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsResponse>
      listConsumerGroupsCallable() {
    return stub.listConsumerGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ConsumerGroupName name =
   *       ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");
   *   ConsumerGroup response = managedKafkaClient.getConsumerGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the consumer group whose configuration to return.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/consumerGroups/{consumerGroup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerGroup getConsumerGroup(ConsumerGroupName name) {
    GetConsumerGroupRequest request =
        GetConsumerGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConsumerGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name =
   *       ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *           .toString();
   *   ConsumerGroup response = managedKafkaClient.getConsumerGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the consumer group whose configuration to return.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/consumerGroups/{consumerGroup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerGroup getConsumerGroup(String name) {
    GetConsumerGroupRequest request = GetConsumerGroupRequest.newBuilder().setName(name).build();
    return getConsumerGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetConsumerGroupRequest request =
   *       GetConsumerGroupRequest.newBuilder()
   *           .setName(
   *               ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *                   .toString())
   *           .build();
   *   ConsumerGroup response = managedKafkaClient.getConsumerGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerGroup getConsumerGroup(GetConsumerGroupRequest request) {
    return getConsumerGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetConsumerGroupRequest request =
   *       GetConsumerGroupRequest.newBuilder()
   *           .setName(
   *               ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ConsumerGroup> future =
   *       managedKafkaClient.getConsumerGroupCallable().futureCall(request);
   *   // Do something.
   *   ConsumerGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupCallable() {
    return stub.getConsumerGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ConsumerGroup consumerGroup = ConsumerGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ConsumerGroup response = managedKafkaClient.updateConsumerGroup(consumerGroup, updateMask);
   * }
   * }</pre>
   *
   * @param consumerGroup Required. The consumer group to update. Its `name` field must be
   *     populated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     ConsumerGroup resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask.
   *     The mask is required and a value of &#42; will update all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerGroup updateConsumerGroup(
      ConsumerGroup consumerGroup, FieldMask updateMask) {
    UpdateConsumerGroupRequest request =
        UpdateConsumerGroupRequest.newBuilder()
            .setConsumerGroup(consumerGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateConsumerGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateConsumerGroupRequest request =
   *       UpdateConsumerGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConsumerGroup(ConsumerGroup.newBuilder().build())
   *           .build();
   *   ConsumerGroup response = managedKafkaClient.updateConsumerGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConsumerGroup updateConsumerGroup(UpdateConsumerGroupRequest request) {
    return updateConsumerGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the properties of a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   UpdateConsumerGroupRequest request =
   *       UpdateConsumerGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConsumerGroup(ConsumerGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<ConsumerGroup> future =
   *       managedKafkaClient.updateConsumerGroupCallable().futureCall(request);
   *   // Do something.
   *   ConsumerGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupCallable() {
    return stub.updateConsumerGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ConsumerGroupName name =
   *       ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]");
   *   managedKafkaClient.deleteConsumerGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the consumer group to delete.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/consumerGroups/{consumerGroup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConsumerGroup(ConsumerGroupName name) {
    DeleteConsumerGroupRequest request =
        DeleteConsumerGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConsumerGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   String name =
   *       ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *           .toString();
   *   managedKafkaClient.deleteConsumerGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the consumer group to delete.
   *     `projects/{project}/locations/{location}/clusters/{cluster}/consumerGroups/{consumerGroup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConsumerGroup(String name) {
    DeleteConsumerGroupRequest request =
        DeleteConsumerGroupRequest.newBuilder().setName(name).build();
    deleteConsumerGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteConsumerGroupRequest request =
   *       DeleteConsumerGroupRequest.newBuilder()
   *           .setName(
   *               ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *                   .toString())
   *           .build();
   *   managedKafkaClient.deleteConsumerGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConsumerGroup(DeleteConsumerGroupRequest request) {
    deleteConsumerGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single consumer group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   DeleteConsumerGroupRequest request =
   *       DeleteConsumerGroupRequest.newBuilder()
   *           .setName(
   *               ConsumerGroupName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[CONSUMER_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       managedKafkaClient.deleteConsumerGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupCallable() {
    return stub.deleteConsumerGroupCallable();
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
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : managedKafkaClient.listLocations(request).iterateAll()) {
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
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       managedKafkaClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = managedKafkaClient.listLocationsCallable().call(request);
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
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = managedKafkaClient.getLocation(request);
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
   * try (ManagedKafkaClient managedKafkaClient = ManagedKafkaClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = managedKafkaClient.getLocationCallable().futureCall(request);
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

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClustersPagedResponse(ListClustersPage page) {
      super(page, ListClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClustersPage
      extends AbstractPage<ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage> {

    private ListClustersPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      super(context, response);
    }

    private static ListClustersPage createEmptyPage() {
      return new ListClustersPage(null, null);
    }

    @Override
    protected ListClustersPage createPage(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ListClustersResponse response) {
      return new ListClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListClustersPage> createPageAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    private ListClustersFixedSizeCollection(List<ListClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClustersFixedSizeCollection createEmptyCollection() {
      return new ListClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClustersFixedSizeCollection createCollection(
        List<ListClustersPage> pages, int collectionSize) {
      return new ListClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTopicsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicsRequest,
          ListTopicsResponse,
          Topic,
          ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    public static ApiFuture<ListTopicsPagedResponse> createAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      ApiFuture<ListTopicsPage> futurePage =
          ListTopicsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTopicsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTopicsPagedResponse(ListTopicsPage page) {
      super(page, ListTopicsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTopicsPage
      extends AbstractPage<ListTopicsRequest, ListTopicsResponse, Topic, ListTopicsPage> {

    private ListTopicsPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      super(context, response);
    }

    private static ListTopicsPage createEmptyPage() {
      return new ListTopicsPage(null, null);
    }

    @Override
    protected ListTopicsPage createPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      return new ListTopicsPage(context, response);
    }

    @Override
    public ApiFuture<ListTopicsPage> createPageAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTopicsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicsRequest,
          ListTopicsResponse,
          Topic,
          ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    private ListTopicsFixedSizeCollection(List<ListTopicsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicsFixedSizeCollection createEmptyCollection() {
      return new ListTopicsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicsFixedSizeCollection createCollection(
        List<ListTopicsPage> pages, int collectionSize) {
      return new ListTopicsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConsumerGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListConsumerGroupsRequest,
          ListConsumerGroupsResponse,
          ConsumerGroup,
          ListConsumerGroupsPage,
          ListConsumerGroupsFixedSizeCollection> {

    public static ApiFuture<ListConsumerGroupsPagedResponse> createAsync(
        PageContext<ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup> context,
        ApiFuture<ListConsumerGroupsResponse> futureResponse) {
      ApiFuture<ListConsumerGroupsPage> futurePage =
          ListConsumerGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConsumerGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConsumerGroupsPagedResponse(ListConsumerGroupsPage page) {
      super(page, ListConsumerGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConsumerGroupsPage
      extends AbstractPage<
          ListConsumerGroupsRequest,
          ListConsumerGroupsResponse,
          ConsumerGroup,
          ListConsumerGroupsPage> {

    private ListConsumerGroupsPage(
        PageContext<ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup> context,
        ListConsumerGroupsResponse response) {
      super(context, response);
    }

    private static ListConsumerGroupsPage createEmptyPage() {
      return new ListConsumerGroupsPage(null, null);
    }

    @Override
    protected ListConsumerGroupsPage createPage(
        PageContext<ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup> context,
        ListConsumerGroupsResponse response) {
      return new ListConsumerGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListConsumerGroupsPage> createPageAsync(
        PageContext<ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup> context,
        ApiFuture<ListConsumerGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConsumerGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConsumerGroupsRequest,
          ListConsumerGroupsResponse,
          ConsumerGroup,
          ListConsumerGroupsPage,
          ListConsumerGroupsFixedSizeCollection> {

    private ListConsumerGroupsFixedSizeCollection(
        List<ListConsumerGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConsumerGroupsFixedSizeCollection createEmptyCollection() {
      return new ListConsumerGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConsumerGroupsFixedSizeCollection createCollection(
        List<ListConsumerGroupsPage> pages, int collectionSize) {
      return new ListConsumerGroupsFixedSizeCollection(pages, collectionSize);
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
