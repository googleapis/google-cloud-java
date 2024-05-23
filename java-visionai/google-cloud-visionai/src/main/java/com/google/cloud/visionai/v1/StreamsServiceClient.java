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

package com.google.cloud.visionai.v1;

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
import com.google.cloud.visionai.v1.stub.StreamsServiceStub;
import com.google.cloud.visionai.v1.stub.StreamsServiceStubSettings;
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
 * Service Description: Service describing handlers for resources. Vision API and Vision AI API are
 * two independent APIs developed by the same team. Vision API is for people to annotate their image
 * while Vision AI is an e2e solution for customer to build their own computer vision application.
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
 * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
 *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
 *   Cluster response = streamsServiceClient.getCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the StreamsServiceClient object to clean up resources such
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
 *      <td><p> Lists Clusters in a given project and location.</td>
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
 *      <td><p> Gets details of a single Cluster.</td>
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
 *      <td><p> Creates a new Cluster in a given project and location.</td>
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
 *      <td><p> Updates the parameters of a single Cluster.</td>
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
 *      <td><p> Deletes a single Cluster.</td>
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
 *      <td><p> ListStreams</td>
 *      <td><p> Lists Streams in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listStreams(ListStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listStreams(ClusterName parent)
 *           <li><p> listStreams(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listStreamsPagedCallable()
 *           <li><p> listStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStream</td>
 *      <td><p> Gets details of a single Stream.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStream(GetStreamRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getStream(StreamName name)
 *           <li><p> getStream(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateStream</td>
 *      <td><p> Creates a new Stream in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createStreamAsync(CreateStreamRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createStreamAsync(ClusterName parent, Stream stream, String streamId)
 *           <li><p> createStreamAsync(String parent, Stream stream, String streamId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createStreamOperationCallable()
 *           <li><p> createStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateStream</td>
 *      <td><p> Updates the parameters of a single Stream.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateStreamAsync(UpdateStreamRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateStreamAsync(Stream stream, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateStreamOperationCallable()
 *           <li><p> updateStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteStream</td>
 *      <td><p> Deletes a single Stream.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteStreamAsync(DeleteStreamRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteStreamAsync(StreamName name)
 *           <li><p> deleteStreamAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteStreamOperationCallable()
 *           <li><p> deleteStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetStreamThumbnail</td>
 *      <td><p> Gets the thumbnail (image snapshot) of a single Stream.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getStreamThumbnailAsync(GetStreamThumbnailRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> getStreamThumbnailAsync(String stream, String gcsObjectName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getStreamThumbnailOperationCallable()
 *           <li><p> getStreamThumbnailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateStreamHlsToken</td>
 *      <td><p> Generate the JWT auth token required to get the stream HLS contents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateStreamHlsToken(GenerateStreamHlsTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateStreamHlsToken(String stream)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateStreamHlsTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvents</td>
 *      <td><p> Lists Events in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvents(ListEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvents(ClusterName parent)
 *           <li><p> listEvents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEventsPagedCallable()
 *           <li><p> listEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEvent</td>
 *      <td><p> Gets details of a single Event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEvent(GetEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEvent(EventName name)
 *           <li><p> getEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvent</td>
 *      <td><p> Creates a new Event in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEventAsync(CreateEventRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEventAsync(ClusterName parent, Event event, String eventId)
 *           <li><p> createEventAsync(String parent, Event event, String eventId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEventOperationCallable()
 *           <li><p> createEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEvent</td>
 *      <td><p> Updates the parameters of a single Event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEventAsync(UpdateEventRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEventAsync(Event event, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEventOperationCallable()
 *           <li><p> updateEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEvent</td>
 *      <td><p> Deletes a single Event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEventAsync(DeleteEventRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEventAsync(EventName name)
 *           <li><p> deleteEventAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEventOperationCallable()
 *           <li><p> deleteEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSeries</td>
 *      <td><p> Lists Series in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSeries(ListSeriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSeries(ClusterName parent)
 *           <li><p> listSeries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSeriesPagedCallable()
 *           <li><p> listSeriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSeries</td>
 *      <td><p> Gets details of a single Series.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSeries(GetSeriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSeries(SeriesName name)
 *           <li><p> getSeries(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSeriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSeries</td>
 *      <td><p> Creates a new Series in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSeriesAsync(CreateSeriesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSeriesAsync(ClusterName parent, Series series, String seriesId)
 *           <li><p> createSeriesAsync(String parent, Series series, String seriesId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSeriesOperationCallable()
 *           <li><p> createSeriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSeries</td>
 *      <td><p> Updates the parameters of a single Event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSeriesAsync(UpdateSeriesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSeriesAsync(Series series, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSeriesOperationCallable()
 *           <li><p> updateSeriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSeries</td>
 *      <td><p> Deletes a single Series.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSeriesAsync(DeleteSeriesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSeriesAsync(SeriesName name)
 *           <li><p> deleteSeriesAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSeriesOperationCallable()
 *           <li><p> deleteSeriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MaterializeChannel</td>
 *      <td><p> Materialize a channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> materializeChannelAsync(MaterializeChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> materializeChannelAsync(ClusterName parent, Channel channel, String channelId)
 *           <li><p> materializeChannelAsync(String parent, Channel channel, String channelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> materializeChannelOperationCallable()
 *           <li><p> materializeChannelCallable()
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
 * <p>This class can be customized by passing in a custom instance of StreamsServiceSettings to
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
 * StreamsServiceSettings streamsServiceSettings =
 *     StreamsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * StreamsServiceClient streamsServiceClient = StreamsServiceClient.create(streamsServiceSettings);
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
 * StreamsServiceSettings streamsServiceSettings =
 *     StreamsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * StreamsServiceClient streamsServiceClient = StreamsServiceClient.create(streamsServiceSettings);
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
 * StreamsServiceSettings streamsServiceSettings =
 *     StreamsServiceSettings.newHttpJsonBuilder().build();
 * StreamsServiceClient streamsServiceClient = StreamsServiceClient.create(streamsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class StreamsServiceClient implements BackgroundResource {
  private final StreamsServiceSettings settings;
  private final StreamsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of StreamsServiceClient with default settings. */
  public static final StreamsServiceClient create() throws IOException {
    return create(StreamsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of StreamsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final StreamsServiceClient create(StreamsServiceSettings settings)
      throws IOException {
    return new StreamsServiceClient(settings);
  }

  /**
   * Constructs an instance of StreamsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(StreamsServiceSettings).
   */
  public static final StreamsServiceClient create(StreamsServiceStub stub) {
    return new StreamsServiceClient(stub);
  }

  /**
   * Constructs an instance of StreamsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected StreamsServiceClient(StreamsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((StreamsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected StreamsServiceClient(StreamsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final StreamsServiceSettings getSettings() {
    return settings;
  }

  public StreamsServiceStub getStub() {
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
   * Lists Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Cluster element : streamsServiceClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClustersRequest.
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
   * Lists Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Cluster element : streamsServiceClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClustersRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Cluster element : streamsServiceClient.listClusters(request).iterateAll()) {
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
   * Lists Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       streamsServiceClient.listClustersPagedCallable().futureCall(request);
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
   * Lists Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response = streamsServiceClient.listClustersCallable().call(request);
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
   * Gets details of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Cluster response = streamsServiceClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Cluster response = streamsServiceClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   Cluster response = streamsServiceClient.getCluster(request);
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
   * Gets details of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<Cluster> future = streamsServiceClient.getClusterCallable().futureCall(request);
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
   * Creates a new Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = streamsServiceClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param cluster Required. The resource being created.
   * @param clusterId Required. Id of the requesting object.
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
   * Creates a new Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response = streamsServiceClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param cluster Required. The resource being created.
   * @param clusterId Required. Id of the requesting object.
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
   * Creates a new Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = streamsServiceClient.createClusterAsync(request).get();
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
   * Creates a new Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       streamsServiceClient.createClusterOperationCallable().futureCall(request);
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
   * Creates a new Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       streamsServiceClient.createClusterCallable().futureCall(request);
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
   * Updates the parameters of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response = streamsServiceClient.updateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Cluster resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
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
   * Updates the parameters of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = streamsServiceClient.updateClusterAsync(request).get();
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
   * Updates the parameters of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, OperationMetadata> future =
   *       streamsServiceClient.updateClusterOperationCallable().futureCall(request);
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
   * Updates the parameters of a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       streamsServiceClient.updateClusterCallable().futureCall(request);
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
   * Deletes a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   streamsServiceClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   streamsServiceClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClusterAsync(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   streamsServiceClient.deleteClusterAsync(request).get();
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
   * Deletes a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       streamsServiceClient.deleteClusterOperationCallable().futureCall(request);
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
   * Deletes a single Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       streamsServiceClient.deleteClusterCallable().futureCall(request);
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
   * Lists Streams in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Stream element : streamsServiceClient.listStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListStreamsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(ClusterName parent) {
    ListStreamsRequest request =
        ListStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Streams in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Stream element : streamsServiceClient.listStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListStreamsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(String parent) {
    ListStreamsRequest request = ListStreamsRequest.newBuilder().setParent(parent).build();
    return listStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Streams in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Stream element : streamsServiceClient.listStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStreamsPagedResponse listStreams(ListStreamsRequest request) {
    return listStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Streams in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Stream> future =
   *       streamsServiceClient.listStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Stream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse>
      listStreamsPagedCallable() {
    return stub.listStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Streams in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListStreamsRequest request =
   *       ListStreamsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListStreamsResponse response = streamsServiceClient.listStreamsCallable().call(request);
   *     for (Stream element : response.getStreamsList()) {
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
  public final UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    return stub.listStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");
   *   Stream response = streamsServiceClient.getStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(StreamName name) {
    GetStreamRequest request =
        GetStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString();
   *   Stream response = streamsServiceClient.getStream(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(String name) {
    GetStreamRequest request = GetStreamRequest.newBuilder().setName(name).build();
    return getStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetStreamRequest request =
   *       GetStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
   *           .build();
   *   Stream response = streamsServiceClient.getStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Stream getStream(GetStreamRequest request) {
    return getStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetStreamRequest request =
   *       GetStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
   *           .build();
   *   ApiFuture<Stream> future = streamsServiceClient.getStreamCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    return stub.getStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Stream in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Stream stream = Stream.newBuilder().build();
   *   String streamId = "streamId1790933179";
   *   Stream response = streamsServiceClient.createStreamAsync(parent, stream, streamId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param stream Required. The resource being created.
   * @param streamId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      ClusterName parent, Stream stream, String streamId) {
    CreateStreamRequest request =
        CreateStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStream(stream)
            .setStreamId(streamId)
            .build();
    return createStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Stream in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Stream stream = Stream.newBuilder().build();
   *   String streamId = "streamId1790933179";
   *   Stream response = streamsServiceClient.createStreamAsync(parent, stream, streamId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param stream Required. The resource being created.
   * @param streamId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      String parent, Stream stream, String streamId) {
    CreateStreamRequest request =
        CreateStreamRequest.newBuilder()
            .setParent(parent)
            .setStream(stream)
            .setStreamId(streamId)
            .build();
    return createStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Stream in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Stream response = streamsServiceClient.createStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> createStreamAsync(
      CreateStreamRequest request) {
    return createStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Stream in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Stream, OperationMetadata> future =
   *       streamsServiceClient.createStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    return stub.createStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Stream in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateStreamRequest request =
   *       CreateStreamRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setStreamId("streamId1790933179")
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.createStreamCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    return stub.createStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   Stream stream = Stream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Stream response = streamsServiceClient.updateStreamAsync(stream, updateMask).get();
   * }
   * }</pre>
   *
   * @param stream Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Stream resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> updateStreamAsync(
      Stream stream, FieldMask updateMask) {
    UpdateStreamRequest request =
        UpdateStreamRequest.newBuilder().setStream(stream).setUpdateMask(updateMask).build();
    return updateStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Stream response = streamsServiceClient.updateStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Stream, OperationMetadata> updateStreamAsync(
      UpdateStreamRequest request) {
    return updateStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Stream, OperationMetadata> future =
   *       streamsServiceClient.updateStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   Stream response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    return stub.updateStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateStreamRequest request =
   *       UpdateStreamRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStream(Stream.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.updateStreamCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    return stub.updateStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   StreamName name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]");
   *   streamsServiceClient.deleteStreamAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(StreamName name) {
    DeleteStreamRequest request =
        DeleteStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString();
   *   streamsServiceClient.deleteStreamAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(String name) {
    DeleteStreamRequest request = DeleteStreamRequest.newBuilder().setName(name).build();
    return deleteStreamAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   streamsServiceClient.deleteStreamAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStreamAsync(
      DeleteStreamRequest request) {
    return deleteStreamOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       streamsServiceClient.deleteStreamOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    return stub.deleteStreamOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteStreamRequest request =
   *       DeleteStreamRequest.newBuilder()
   *           .setName(StreamName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[STREAM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.deleteStreamCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    return stub.deleteStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the thumbnail (image snapshot) of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String stream = "stream-891990144";
   *   String gcsObjectName = "gcsObjectName-1987275551";
   *   GetStreamThumbnailResponse response =
   *       streamsServiceClient.getStreamThumbnailAsync(stream, gcsObjectName).get();
   * }
   * }</pre>
   *
   * @param stream Required. The name of the stream for to get the thumbnail from.
   * @param gcsObjectName Required. The name of the GCS object to store the thumbnail image.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailAsync(String stream, String gcsObjectName) {
    GetStreamThumbnailRequest request =
        GetStreamThumbnailRequest.newBuilder()
            .setStream(stream)
            .setGcsObjectName(gcsObjectName)
            .build();
    return getStreamThumbnailAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the thumbnail (image snapshot) of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetStreamThumbnailRequest request =
   *       GetStreamThumbnailRequest.newBuilder()
   *           .setStream("stream-891990144")
   *           .setGcsObjectName("gcsObjectName-1987275551")
   *           .setEvent("event96891546")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   GetStreamThumbnailResponse response =
   *       streamsServiceClient.getStreamThumbnailAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailAsync(GetStreamThumbnailRequest request) {
    return getStreamThumbnailOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the thumbnail (image snapshot) of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetStreamThumbnailRequest request =
   *       GetStreamThumbnailRequest.newBuilder()
   *           .setStream("stream-891990144")
   *           .setGcsObjectName("gcsObjectName-1987275551")
   *           .setEvent("event96891546")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<GetStreamThumbnailResponse, OperationMetadata> future =
   *       streamsServiceClient.getStreamThumbnailOperationCallable().futureCall(request);
   *   // Do something.
   *   GetStreamThumbnailResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationCallable() {
    return stub.getStreamThumbnailOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the thumbnail (image snapshot) of a single Stream.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetStreamThumbnailRequest request =
   *       GetStreamThumbnailRequest.newBuilder()
   *           .setStream("stream-891990144")
   *           .setGcsObjectName("gcsObjectName-1987275551")
   *           .setEvent("event96891546")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       streamsServiceClient.getStreamThumbnailCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStreamThumbnailRequest, Operation> getStreamThumbnailCallable() {
    return stub.getStreamThumbnailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the JWT auth token required to get the stream HLS contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String stream = "stream-891990144";
   *   GenerateStreamHlsTokenResponse response = streamsServiceClient.generateStreamHlsToken(stream);
   * }
   * }</pre>
   *
   * @param stream Required. The name of the stream.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateStreamHlsTokenResponse generateStreamHlsToken(String stream) {
    GenerateStreamHlsTokenRequest request =
        GenerateStreamHlsTokenRequest.newBuilder().setStream(stream).build();
    return generateStreamHlsToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the JWT auth token required to get the stream HLS contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GenerateStreamHlsTokenRequest request =
   *       GenerateStreamHlsTokenRequest.newBuilder().setStream("stream-891990144").build();
   *   GenerateStreamHlsTokenResponse response =
   *       streamsServiceClient.generateStreamHlsToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateStreamHlsTokenResponse generateStreamHlsToken(
      GenerateStreamHlsTokenRequest request) {
    return generateStreamHlsTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the JWT auth token required to get the stream HLS contents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GenerateStreamHlsTokenRequest request =
   *       GenerateStreamHlsTokenRequest.newBuilder().setStream("stream-891990144").build();
   *   ApiFuture<GenerateStreamHlsTokenResponse> future =
   *       streamsServiceClient.generateStreamHlsTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateStreamHlsTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenCallable() {
    return stub.generateStreamHlsTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Events in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Event element : streamsServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEventsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ClusterName parent) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Events in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Event element : streamsServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListEventsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(String parent) {
    ListEventsRequest request = ListEventsRequest.newBuilder().setParent(parent).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Events in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Event element : streamsServiceClient.listEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Events in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Event> future = streamsServiceClient.listEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Event element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return stub.listEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Events in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEventsResponse response = streamsServiceClient.listEventsCallable().call(request);
   *     for (Event element : response.getEventsList()) {
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
  public final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return stub.listEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");
   *   Event response = streamsServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(EventName name) {
    GetEventRequest request =
        GetEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString();
   *   Event response = streamsServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(String name) {
    GetEventRequest request = GetEventRequest.newBuilder().setName(name).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
   *           .build();
   *   Event response = streamsServiceClient.getEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(GetEventRequest request) {
    return getEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
   *           .build();
   *   ApiFuture<Event> future = streamsServiceClient.getEventCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEventRequest, Event> getEventCallable() {
    return stub.getEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Event in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = streamsServiceClient.createEventAsync(parent, event, eventId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param event Required. The resource being created.
   * @param eventId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Event, OperationMetadata> createEventAsync(
      ClusterName parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Event in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = streamsServiceClient.createEventAsync(parent, event, eventId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param event Required. The resource being created.
   * @param eventId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Event, OperationMetadata> createEventAsync(
      String parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent)
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Event in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setEventId("eventId-1376502443")
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Event response = streamsServiceClient.createEventAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Event, OperationMetadata> createEventAsync(
      CreateEventRequest request) {
    return createEventOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Event in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setEventId("eventId-1376502443")
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Event, OperationMetadata> future =
   *       streamsServiceClient.createEventOperationCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEventRequest, Event, OperationMetadata>
      createEventOperationCallable() {
    return stub.createEventOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Event in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setEventId("eventId-1376502443")
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.createEventCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEventRequest, Operation> createEventCallable() {
    return stub.createEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   Event event = Event.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Event response = streamsServiceClient.updateEventAsync(event, updateMask).get();
   * }
   * }</pre>
   *
   * @param event Required. The resource being updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Event resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Event, OperationMetadata> updateEventAsync(
      Event event, FieldMask updateMask) {
    UpdateEventRequest request =
        UpdateEventRequest.newBuilder().setEvent(event).setUpdateMask(updateMask).build();
    return updateEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateEventRequest request =
   *       UpdateEventRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Event response = streamsServiceClient.updateEventAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Event, OperationMetadata> updateEventAsync(
      UpdateEventRequest request) {
    return updateEventOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateEventRequest request =
   *       UpdateEventRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Event, OperationMetadata> future =
   *       streamsServiceClient.updateEventOperationCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationCallable() {
    return stub.updateEventOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateEventRequest request =
   *       UpdateEventRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEvent(Event.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.updateEventCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEventRequest, Operation> updateEventCallable() {
    return stub.updateEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]");
   *   streamsServiceClient.deleteEventAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEventAsync(EventName name) {
    DeleteEventRequest request =
        DeleteEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString();
   *   streamsServiceClient.deleteEventAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEventAsync(String name) {
    DeleteEventRequest request = DeleteEventRequest.newBuilder().setName(name).build();
    return deleteEventAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   streamsServiceClient.deleteEventAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEventAsync(
      DeleteEventRequest request) {
    return deleteEventOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       streamsServiceClient.deleteEventOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationCallable() {
    return stub.deleteEventOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.deleteEventCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEventRequest, Operation> deleteEventCallable() {
    return stub.deleteEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   for (Series element : streamsServiceClient.listSeries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSeriesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSeriesPagedResponse listSeries(ClusterName parent) {
    ListSeriesRequest request =
        ListSeriesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   for (Series element : streamsServiceClient.listSeries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSeriesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSeriesPagedResponse listSeries(String parent) {
    ListSeriesRequest request = ListSeriesRequest.newBuilder().setParent(parent).build();
    return listSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListSeriesRequest request =
   *       ListSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Series element : streamsServiceClient.listSeries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSeriesPagedResponse listSeries(ListSeriesRequest request) {
    return listSeriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListSeriesRequest request =
   *       ListSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Series> future = streamsServiceClient.listSeriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Series element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSeriesRequest, ListSeriesPagedResponse> listSeriesPagedCallable() {
    return stub.listSeriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ListSeriesRequest request =
   *       ListSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSeriesResponse response = streamsServiceClient.listSeriesCallable().call(request);
   *     for (Series element : response.getSeriesList()) {
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
  public final UnaryCallable<ListSeriesRequest, ListSeriesResponse> listSeriesCallable() {
    return stub.listSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");
   *   Series response = streamsServiceClient.getSeries(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Series getSeries(SeriesName name) {
    GetSeriesRequest request =
        GetSeriesRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString();
   *   Series response = streamsServiceClient.getSeries(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Series getSeries(String name) {
    GetSeriesRequest request = GetSeriesRequest.newBuilder().setName(name).build();
    return getSeries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetSeriesRequest request =
   *       GetSeriesRequest.newBuilder()
   *           .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
   *           .build();
   *   Series response = streamsServiceClient.getSeries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Series getSeries(GetSeriesRequest request) {
    return getSeriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   GetSeriesRequest request =
   *       GetSeriesRequest.newBuilder()
   *           .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
   *           .build();
   *   ApiFuture<Series> future = streamsServiceClient.getSeriesCallable().futureCall(request);
   *   // Do something.
   *   Series response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSeriesRequest, Series> getSeriesCallable() {
    return stub.getSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Series series = Series.newBuilder().build();
   *   String seriesId = "seriesId1367098866";
   *   Series response = streamsServiceClient.createSeriesAsync(parent, series, seriesId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param series Required. The resource being created.
   * @param seriesId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Series, OperationMetadata> createSeriesAsync(
      ClusterName parent, Series series, String seriesId) {
    CreateSeriesRequest request =
        CreateSeriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSeries(series)
            .setSeriesId(seriesId)
            .build();
    return createSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Series series = Series.newBuilder().build();
   *   String seriesId = "seriesId1367098866";
   *   Series response = streamsServiceClient.createSeriesAsync(parent, series, seriesId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param series Required. The resource being created.
   * @param seriesId Required. Id of the requesting object.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Series, OperationMetadata> createSeriesAsync(
      String parent, Series series, String seriesId) {
    CreateSeriesRequest request =
        CreateSeriesRequest.newBuilder()
            .setParent(parent)
            .setSeries(series)
            .setSeriesId(seriesId)
            .build();
    return createSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateSeriesRequest request =
   *       CreateSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setSeriesId("seriesId1367098866")
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Series response = streamsServiceClient.createSeriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Series, OperationMetadata> createSeriesAsync(
      CreateSeriesRequest request) {
    return createSeriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateSeriesRequest request =
   *       CreateSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setSeriesId("seriesId1367098866")
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Series, OperationMetadata> future =
   *       streamsServiceClient.createSeriesOperationCallable().futureCall(request);
   *   // Do something.
   *   Series response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationCallable() {
    return stub.createSeriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Series in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   CreateSeriesRequest request =
   *       CreateSeriesRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setSeriesId("seriesId1367098866")
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.createSeriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSeriesRequest, Operation> createSeriesCallable() {
    return stub.createSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   Series series = Series.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Series response = streamsServiceClient.updateSeriesAsync(series, updateMask).get();
   * }
   * }</pre>
   *
   * @param series Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Series resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Series, OperationMetadata> updateSeriesAsync(
      Series series, FieldMask updateMask) {
    UpdateSeriesRequest request =
        UpdateSeriesRequest.newBuilder().setSeries(series).setUpdateMask(updateMask).build();
    return updateSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateSeriesRequest request =
   *       UpdateSeriesRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Series response = streamsServiceClient.updateSeriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Series, OperationMetadata> updateSeriesAsync(
      UpdateSeriesRequest request) {
    return updateSeriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateSeriesRequest request =
   *       UpdateSeriesRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Series, OperationMetadata> future =
   *       streamsServiceClient.updateSeriesOperationCallable().futureCall(request);
   *   // Do something.
   *   Series response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationCallable() {
    return stub.updateSeriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   UpdateSeriesRequest request =
   *       UpdateSeriesRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSeries(Series.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.updateSeriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSeriesRequest, Operation> updateSeriesCallable() {
    return stub.updateSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   SeriesName name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]");
   *   streamsServiceClient.deleteSeriesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSeriesAsync(SeriesName name) {
    DeleteSeriesRequest request =
        DeleteSeriesRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String name = SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString();
   *   streamsServiceClient.deleteSeriesAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSeriesAsync(String name) {
    DeleteSeriesRequest request = DeleteSeriesRequest.newBuilder().setName(name).build();
    return deleteSeriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteSeriesRequest request =
   *       DeleteSeriesRequest.newBuilder()
   *           .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   streamsServiceClient.deleteSeriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSeriesAsync(
      DeleteSeriesRequest request) {
    return deleteSeriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteSeriesRequest request =
   *       DeleteSeriesRequest.newBuilder()
   *           .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       streamsServiceClient.deleteSeriesOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationCallable() {
    return stub.deleteSeriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Series.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   DeleteSeriesRequest request =
   *       DeleteSeriesRequest.newBuilder()
   *           .setName(SeriesName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[SERIES]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = streamsServiceClient.deleteSeriesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSeriesRequest, Operation> deleteSeriesCallable() {
    return stub.deleteSeriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Materialize a channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   ClusterName parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       streamsServiceClient.materializeChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param channel Required. The resource being created.
   * @param channelId Required. Id of the channel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> materializeChannelAsync(
      ClusterName parent, Channel channel, String channelId) {
    MaterializeChannelRequest request =
        MaterializeChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return materializeChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Materialize a channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       streamsServiceClient.materializeChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param channel Required. The resource being created.
   * @param channelId Required. Id of the channel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> materializeChannelAsync(
      String parent, Channel channel, String channelId) {
    MaterializeChannelRequest request =
        MaterializeChannelRequest.newBuilder()
            .setParent(parent)
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return materializeChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Materialize a channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   MaterializeChannelRequest request =
   *       MaterializeChannelRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setChannelId("channelId1461735806")
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Channel response = streamsServiceClient.materializeChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> materializeChannelAsync(
      MaterializeChannelRequest request) {
    return materializeChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Materialize a channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   MaterializeChannelRequest request =
   *       MaterializeChannelRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setChannelId("channelId1461735806")
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       streamsServiceClient.materializeChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationCallable() {
    return stub.materializeChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Materialize a channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
   *   MaterializeChannelRequest request =
   *       MaterializeChannelRequest.newBuilder()
   *           .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setChannelId("channelId1461735806")
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       streamsServiceClient.materializeChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MaterializeChannelRequest, Operation> materializeChannelCallable() {
    return stub.materializeChannelCallable();
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

  public static class ListStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListStreamsRequest,
          ListStreamsResponse,
          Stream,
          ListStreamsPage,
          ListStreamsFixedSizeCollection> {

    public static ApiFuture<ListStreamsPagedResponse> createAsync(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ApiFuture<ListStreamsResponse> futureResponse) {
      ApiFuture<ListStreamsPage> futurePage =
          ListStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListStreamsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListStreamsPagedResponse(ListStreamsPage page) {
      super(page, ListStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStreamsPage
      extends AbstractPage<ListStreamsRequest, ListStreamsResponse, Stream, ListStreamsPage> {

    private ListStreamsPage(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ListStreamsResponse response) {
      super(context, response);
    }

    private static ListStreamsPage createEmptyPage() {
      return new ListStreamsPage(null, null);
    }

    @Override
    protected ListStreamsPage createPage(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ListStreamsResponse response) {
      return new ListStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListStreamsPage> createPageAsync(
        PageContext<ListStreamsRequest, ListStreamsResponse, Stream> context,
        ApiFuture<ListStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStreamsRequest,
          ListStreamsResponse,
          Stream,
          ListStreamsPage,
          ListStreamsFixedSizeCollection> {

    private ListStreamsFixedSizeCollection(List<ListStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStreamsFixedSizeCollection createEmptyCollection() {
      return new ListStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStreamsFixedSizeCollection createCollection(
        List<ListStreamsPage> pages, int collectionSize) {
      return new ListStreamsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEventsPagedResponse
      extends AbstractPagedListResponse<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    public static ApiFuture<ListEventsPagedResponse> createAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      ApiFuture<ListEventsPage> futurePage =
          ListEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEventsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEventsPagedResponse(ListEventsPage page) {
      super(page, ListEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventsPage
      extends AbstractPage<ListEventsRequest, ListEventsResponse, Event, ListEventsPage> {

    private ListEventsPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      super(context, response);
    }

    private static ListEventsPage createEmptyPage() {
      return new ListEventsPage(null, null);
    }

    @Override
    protected ListEventsPage createPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      return new ListEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListEventsPage> createPageAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    private ListEventsFixedSizeCollection(List<ListEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventsFixedSizeCollection createEmptyCollection() {
      return new ListEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventsFixedSizeCollection createCollection(
        List<ListEventsPage> pages, int collectionSize) {
      return new ListEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSeriesPagedResponse
      extends AbstractPagedListResponse<
          ListSeriesRequest,
          ListSeriesResponse,
          Series,
          ListSeriesPage,
          ListSeriesFixedSizeCollection> {

    public static ApiFuture<ListSeriesPagedResponse> createAsync(
        PageContext<ListSeriesRequest, ListSeriesResponse, Series> context,
        ApiFuture<ListSeriesResponse> futureResponse) {
      ApiFuture<ListSeriesPage> futurePage =
          ListSeriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSeriesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSeriesPagedResponse(ListSeriesPage page) {
      super(page, ListSeriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSeriesPage
      extends AbstractPage<ListSeriesRequest, ListSeriesResponse, Series, ListSeriesPage> {

    private ListSeriesPage(
        PageContext<ListSeriesRequest, ListSeriesResponse, Series> context,
        ListSeriesResponse response) {
      super(context, response);
    }

    private static ListSeriesPage createEmptyPage() {
      return new ListSeriesPage(null, null);
    }

    @Override
    protected ListSeriesPage createPage(
        PageContext<ListSeriesRequest, ListSeriesResponse, Series> context,
        ListSeriesResponse response) {
      return new ListSeriesPage(context, response);
    }

    @Override
    public ApiFuture<ListSeriesPage> createPageAsync(
        PageContext<ListSeriesRequest, ListSeriesResponse, Series> context,
        ApiFuture<ListSeriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSeriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSeriesRequest,
          ListSeriesResponse,
          Series,
          ListSeriesPage,
          ListSeriesFixedSizeCollection> {

    private ListSeriesFixedSizeCollection(List<ListSeriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSeriesFixedSizeCollection createEmptyCollection() {
      return new ListSeriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSeriesFixedSizeCollection createCollection(
        List<ListSeriesPage> pages, int collectionSize) {
      return new ListSeriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
