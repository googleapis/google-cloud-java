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

package com.google.cloud.video.livestream.v1;

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
import com.google.cloud.video.livestream.v1.stub.LivestreamServiceStub;
import com.google.cloud.video.livestream.v1.stub.LivestreamServiceStubSettings;
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
 * Service Description: Using Live Stream API, you can generate live streams in the various
 * renditions and streaming formats. The streaming format include HTTP Live Streaming (HLS) and
 * Dynamic Adaptive Streaming over HTTP (DASH). You can send a source stream in the various ways,
 * including Real-Time Messaging Protocol (RTMP) and Secure Reliable Transport (SRT).
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
 * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
 *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
 *   Channel response = livestreamServiceClient.getChannel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LivestreamServiceClient object to clean up resources
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
 *      <td><p> CreateChannel</td>
 *      <td><p> Creates a channel with the provided unique ID in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createChannelAsync(CreateChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createChannelAsync(LocationName parent, Channel channel, String channelId)
 *           <li><p> createChannelAsync(String parent, Channel channel, String channelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createChannelOperationCallable()
 *           <li><p> createChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChannels</td>
 *      <td><p> Returns a list of all channels in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChannels(ListChannelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChannels(LocationName parent)
 *           <li><p> listChannels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChannelsPagedCallable()
 *           <li><p> listChannelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetChannel</td>
 *      <td><p> Returns the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChannel(GetChannelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChannel(ChannelName name)
 *           <li><p> getChannel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteChannel</td>
 *      <td><p> Deletes the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteChannelAsync(DeleteChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteChannelAsync(ChannelName name)
 *           <li><p> deleteChannelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteChannelOperationCallable()
 *           <li><p> deleteChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateChannel</td>
 *      <td><p> Updates the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateChannelAsync(UpdateChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateChannelAsync(Channel channel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateChannelOperationCallable()
 *           <li><p> updateChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartChannel</td>
 *      <td><p> Starts the specified channel. Part of the video pipeline will be created only when the StartChannel request is received by the server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startChannelAsync(StartChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startChannelAsync(ChannelName name)
 *           <li><p> startChannelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startChannelOperationCallable()
 *           <li><p> startChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopChannel</td>
 *      <td><p> Stops the specified channel. Part of the video pipeline will be released when the StopChannel request is received by the server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopChannelAsync(StopChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> stopChannelAsync(ChannelName name)
 *           <li><p> stopChannelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopChannelOperationCallable()
 *           <li><p> stopChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartDistribution</td>
 *      <td><p> Starts distribution which delivers outputs to the destination indicated by the Distribution configuration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startDistributionAsync(StartDistributionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startDistributionAsync(ChannelName name, List&lt;String&gt; distributionKeys)
 *           <li><p> startDistributionAsync(String name, List&lt;String&gt; distributionKeys)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startDistributionOperationCallable()
 *           <li><p> startDistributionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopDistribution</td>
 *      <td><p> Stops the specified distribution.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopDistributionAsync(StopDistributionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> stopDistributionAsync(ChannelName name, List&lt;String&gt; distributionKeys)
 *           <li><p> stopDistributionAsync(String name, List&lt;String&gt; distributionKeys)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopDistributionOperationCallable()
 *           <li><p> stopDistributionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInput</td>
 *      <td><p> Creates an input with the provided unique ID in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInputAsync(CreateInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInputAsync(LocationName parent, Input input, String inputId)
 *           <li><p> createInputAsync(String parent, Input input, String inputId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInputOperationCallable()
 *           <li><p> createInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInputs</td>
 *      <td><p> Returns a list of all inputs in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInputs(ListInputsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInputs(LocationName parent)
 *           <li><p> listInputs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInputsPagedCallable()
 *           <li><p> listInputsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInput</td>
 *      <td><p> Returns the specified input.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInput(GetInputRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInput(InputName name)
 *           <li><p> getInput(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInput</td>
 *      <td><p> Deletes the specified input.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInputAsync(DeleteInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInputAsync(InputName name)
 *           <li><p> deleteInputAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInputOperationCallable()
 *           <li><p> deleteInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInput</td>
 *      <td><p> Updates the specified input.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInputAsync(UpdateInputRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInputAsync(Input input, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInputOperationCallable()
 *           <li><p> updateInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PreviewInput</td>
 *      <td><p> Preview the streaming content of the specified input.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> previewInput(PreviewInputRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> previewInput(InputName name)
 *           <li><p> previewInput(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> previewInputCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEvent</td>
 *      <td><p> Creates an event with the provided unique ID in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEvent(CreateEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEvent(ChannelName parent, Event event, String eventId)
 *           <li><p> createEvent(String parent, Event event, String eventId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEvents</td>
 *      <td><p> Returns a list of all events in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEvents(ListEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEvents(ChannelName parent)
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
 *      <td><p> Returns the specified event.</td>
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
 *      <td><p> DeleteEvent</td>
 *      <td><p> Deletes the specified event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEvent(DeleteEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEvent(EventName name)
 *           <li><p> deleteEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListClips</td>
 *      <td><p> Returns a list of all clips in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClips(ListClipsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClips(ChannelName parent)
 *           <li><p> listClips(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClipsPagedCallable()
 *           <li><p> listClipsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetClip</td>
 *      <td><p> Returns the specified clip.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getClip(GetClipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getClip(ClipName name)
 *           <li><p> getClip(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateClip</td>
 *      <td><p> Creates a clip with the provided clip ID in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClipAsync(CreateClipRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClipAsync(ChannelName parent, Clip clip, String clipId)
 *           <li><p> createClipAsync(String parent, Clip clip, String clipId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClipOperationCallable()
 *           <li><p> createClipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteClip</td>
 *      <td><p> Deletes the specified clip job resource. This method only deletes the clip job and does not delete the VOD clip stored in Cloud Storage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClipAsync(DeleteClipRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClipAsync(ClipName name)
 *           <li><p> deleteClipAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClipOperationCallable()
 *           <li><p> deleteClipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDvrSession</td>
 *      <td><p> Creates a DVR session with the provided unique ID in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDvrSessionAsync(CreateDvrSessionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDvrSessionAsync(ChannelName parent, DvrSession dvrSession, String dvrSessionId)
 *           <li><p> createDvrSessionAsync(String parent, DvrSession dvrSession, String dvrSessionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDvrSessionOperationCallable()
 *           <li><p> createDvrSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDvrSessions</td>
 *      <td><p> Returns a list of all DVR sessions in the specified channel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDvrSessions(ListDvrSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDvrSessions(ChannelName parent)
 *           <li><p> listDvrSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDvrSessionsPagedCallable()
 *           <li><p> listDvrSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDvrSession</td>
 *      <td><p> Returns the specified DVR session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDvrSession(GetDvrSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDvrSession(DvrSessionName name)
 *           <li><p> getDvrSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDvrSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDvrSession</td>
 *      <td><p> Deletes the specified DVR session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDvrSessionAsync(DeleteDvrSessionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDvrSessionAsync(DvrSessionName name)
 *           <li><p> deleteDvrSessionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDvrSessionOperationCallable()
 *           <li><p> deleteDvrSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDvrSession</td>
 *      <td><p> Updates the specified DVR session.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDvrSessionAsync(UpdateDvrSessionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDvrSessionAsync(DvrSession dvrSession, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDvrSessionOperationCallable()
 *           <li><p> updateDvrSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAsset</td>
 *      <td><p> Creates a Asset with the provided unique ID in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAssetAsync(CreateAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAssetAsync(LocationName parent, Asset asset, String assetId)
 *           <li><p> createAssetAsync(String parent, Asset asset, String assetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAssetOperationCallable()
 *           <li><p> createAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAsset</td>
 *      <td><p> Deletes the specified asset if it is not used.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAssetAsync(DeleteAssetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAssetAsync(AssetName name)
 *           <li><p> deleteAssetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAssetOperationCallable()
 *           <li><p> deleteAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAsset</td>
 *      <td><p> Returns the specified asset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAsset(GetAssetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAsset(AssetName name)
 *           <li><p> getAsset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAssetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssets</td>
 *      <td><p> Returns a list of all assets in the specified region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssets(ListAssetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssets(LocationName parent)
 *           <li><p> listAssets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssetsPagedCallable()
 *           <li><p> listAssetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPool</td>
 *      <td><p> Returns the specified pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPool(GetPoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPool(PoolName name)
 *           <li><p> getPool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePool</td>
 *      <td><p> Updates the specified pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePoolAsync(UpdatePoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePoolAsync(Pool pool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePoolOperationCallable()
 *           <li><p> updatePoolCallable()
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
 * <p>This class can be customized by passing in a custom instance of LivestreamServiceSettings to
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newHttpJsonBuilder().build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LivestreamServiceClient implements BackgroundResource {
  private final LivestreamServiceSettings settings;
  private final LivestreamServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of LivestreamServiceClient with default settings. */
  public static final LivestreamServiceClient create() throws IOException {
    return create(LivestreamServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LivestreamServiceClient create(LivestreamServiceSettings settings)
      throws IOException {
    return new LivestreamServiceClient(settings);
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(LivestreamServiceSettings).
   */
  public static final LivestreamServiceClient create(LivestreamServiceStub stub) {
    return new LivestreamServiceClient(stub);
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LivestreamServiceClient(LivestreamServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LivestreamServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected LivestreamServiceClient(LivestreamServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final LivestreamServiceSettings getSettings() {
    return settings;
  }

  public LivestreamServiceStub getStub() {
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
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       livestreamServiceClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param channel Required. The channel resource to be created.
   * @param channelId Required. The ID of the channel resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      LocationName parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       livestreamServiceClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param channel Required. The channel resource to be created.
   * @param channelId Required. The ID of the channel resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      String parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent)
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Channel response = livestreamServiceClient.createChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      CreateChannelRequest request) {
    return createChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       livestreamServiceClient.createChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return stub.createChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return stub.createChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Channel element : livestreamServiceClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(LocationName parent) {
    ListChannelsRequest request =
        ListChannelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Channel element : livestreamServiceClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(String parent) {
    ListChannelsRequest request = ListChannelsRequest.newBuilder().setParent(parent).build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Channel element : livestreamServiceClient.listChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(ListChannelsRequest request) {
    return listChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Channel> future =
   *       livestreamServiceClient.listChannelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Channel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable() {
    return stub.listChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChannelsResponse response =
   *         livestreamServiceClient.listChannelsCallable().call(request);
   *     for (Channel element : response.getChannelsList()) {
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
  public final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    return stub.listChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = livestreamServiceClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(ChannelName name) {
    GetChannelRequest request =
        GetChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = livestreamServiceClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(String name) {
    GetChannelRequest request = GetChannelRequest.newBuilder().setName(name).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   Channel response = livestreamServiceClient.getChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(GetChannelRequest request) {
    return getChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   ApiFuture<Channel> future = livestreamServiceClient.getChannelCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return stub.getChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   livestreamServiceClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(ChannelName name) {
    DeleteChannelRequest request =
        DeleteChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   livestreamServiceClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(String name) {
    DeleteChannelRequest request = DeleteChannelRequest.newBuilder().setName(name).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   livestreamServiceClient.deleteChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(
      DeleteChannelRequest request) {
    return deleteChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationCallable() {
    return stub.deleteChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteChannelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return stub.deleteChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   Channel channel = Channel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Channel response = livestreamServiceClient.updateChannelAsync(channel, updateMask).get();
   * }
   * }</pre>
   *
   * @param channel Required. The channel resource to be updated.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Channel
   *     resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>[`inputAttachments`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#inputattachment)
   *       <li>[`inputConfig`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#inputconfig)
   *       <li>[`output`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#output)
   *       <li>[`elementaryStreams`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#elementarystream)
   *       <li>[`muxStreams`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#muxstream)
   *       <li>[`manifests`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#manifest)
   *       <li>[`spriteSheets`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#spritesheet)
   *       <li>[`logConfig`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#logconfig)
   *       <li>[`timecodeConfig`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#timecodeconfig)
   *       <li>[`encryptions`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#encryption)
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the mask is not present, then each field from the list above is updated if the field
   *     appears in the request payload. To unset a field, add the field to the update mask and
   *     remove it from the request payload.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      Channel channel, FieldMask updateMask) {
    UpdateChannelRequest request =
        UpdateChannelRequest.newBuilder().setChannel(channel).setUpdateMask(updateMask).build();
    return updateChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Channel response = livestreamServiceClient.updateChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      UpdateChannelRequest request) {
    return updateChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       livestreamServiceClient.updateChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    return stub.updateChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updateChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    return stub.updateChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      ChannelName name) {
    StartChannelRequest request =
        StartChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      String name) {
    StartChannelRequest request = StartChannelRequest.newBuilder().setName(name).build();
    return startChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      StartChannelRequest request) {
    return startChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.startChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationCallable() {
    return stub.startChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.startChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartChannelRequest, Operation> startChannelCallable() {
    return stub.startChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      ChannelName name) {
    StopChannelRequest request =
        StopChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      String name) {
    StopChannelRequest request = StopChannelRequest.newBuilder().setName(name).build();
    return stopChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      StopChannelRequest request) {
    return stopChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.stopChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationCallable() {
    return stub.stopChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.stopChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopChannelRequest, Operation> stopChannelCallable() {
    return stub.stopChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts distribution which delivers outputs to the destination indicated by the Distribution
   * configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   List<String> distributionKeys = new ArrayList<>();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.startDistributionAsync(name, distributionKeys).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param distributionKeys Optional. A list of keys to identify the distribution configuration in
   *     the channel resource. If left empty, all the distributions in the channel specification
   *     will be started.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startDistributionAsync(
      ChannelName name, List<String> distributionKeys) {
    StartDistributionRequest request =
        StartDistributionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDistributionKeys(distributionKeys)
            .build();
    return startDistributionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts distribution which delivers outputs to the destination indicated by the Distribution
   * configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   List<String> distributionKeys = new ArrayList<>();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.startDistributionAsync(name, distributionKeys).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param distributionKeys Optional. A list of keys to identify the distribution configuration in
   *     the channel resource. If left empty, all the distributions in the channel specification
   *     will be started.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startDistributionAsync(
      String name, List<String> distributionKeys) {
    StartDistributionRequest request =
        StartDistributionRequest.newBuilder()
            .setName(name)
            .addAllDistributionKeys(distributionKeys)
            .build();
    return startDistributionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts distribution which delivers outputs to the destination indicated by the Distribution
   * configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartDistributionRequest request =
   *       StartDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.startDistributionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startDistributionAsync(
      StartDistributionRequest request) {
    return startDistributionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts distribution which delivers outputs to the destination indicated by the Distribution
   * configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartDistributionRequest request =
   *       StartDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.startDistributionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StartDistributionRequest, ChannelOperationResponse, OperationMetadata>
      startDistributionOperationCallable() {
    return stub.startDistributionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts distribution which delivers outputs to the destination indicated by the Distribution
   * configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartDistributionRequest request =
   *       StartDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.startDistributionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartDistributionRequest, Operation> startDistributionCallable() {
    return stub.startDistributionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified distribution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   List<String> distributionKeys = new ArrayList<>();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.stopDistributionAsync(name, distributionKeys).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param distributionKeys Optional. A list of key to identify the distribution configuration in
   *     the channel resource. If left empty, all the distributions in the channel specification
   *     will be stopped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopDistributionAsync(
      ChannelName name, List<String> distributionKeys) {
    StopDistributionRequest request =
        StopDistributionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDistributionKeys(distributionKeys)
            .build();
    return stopDistributionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified distribution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   List<String> distributionKeys = new ArrayList<>();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.stopDistributionAsync(name, distributionKeys).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param distributionKeys Optional. A list of key to identify the distribution configuration in
   *     the channel resource. If left empty, all the distributions in the channel specification
   *     will be stopped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopDistributionAsync(
      String name, List<String> distributionKeys) {
    StopDistributionRequest request =
        StopDistributionRequest.newBuilder()
            .setName(name)
            .addAllDistributionKeys(distributionKeys)
            .build();
    return stopDistributionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified distribution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopDistributionRequest request =
   *       StopDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response =
   *       livestreamServiceClient.stopDistributionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopDistributionAsync(
      StopDistributionRequest request) {
    return stopDistributionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified distribution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopDistributionRequest request =
   *       StopDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.stopDistributionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StopDistributionRequest, ChannelOperationResponse, OperationMetadata>
      stopDistributionOperationCallable() {
    return stub.stopDistributionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified distribution.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopDistributionRequest request =
   *       StopDistributionRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllDistributionKeys(new ArrayList<String>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.stopDistributionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopDistributionRequest, Operation> stopDistributionCallable() {
    return stub.stopDistributionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Input input = Input.newBuilder().build();
   *   String inputId = "inputId1954846341";
   *   Input response = livestreamServiceClient.createInputAsync(parent, input, inputId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param input Required. The input resource to be created.
   * @param inputId Required. The ID of the input resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      LocationName parent, Input input, String inputId) {
    CreateInputRequest request =
        CreateInputRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInput(input)
            .setInputId(inputId)
            .build();
    return createInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Input input = Input.newBuilder().build();
   *   String inputId = "inputId1954846341";
   *   Input response = livestreamServiceClient.createInputAsync(parent, input, inputId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param input Required. The input resource to be created.
   * @param inputId Required. The ID of the input resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      String parent, Input input, String inputId) {
    CreateInputRequest request =
        CreateInputRequest.newBuilder()
            .setParent(parent)
            .setInput(input)
            .setInputId(inputId)
            .build();
    return createInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Input response = livestreamServiceClient.createInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      CreateInputRequest request) {
    return createInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Input, OperationMetadata> future =
   *       livestreamServiceClient.createInputOperationCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInputRequest, Input, OperationMetadata>
      createInputOperationCallable() {
    return stub.createInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInputRequest, Operation> createInputCallable() {
    return stub.createInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Input element : livestreamServiceClient.listInputs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(LocationName parent) {
    ListInputsRequest request =
        ListInputsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listInputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Input element : livestreamServiceClient.listInputs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(String parent) {
    ListInputsRequest request = ListInputsRequest.newBuilder().setParent(parent).build();
    return listInputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Input element : livestreamServiceClient.listInputs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(ListInputsRequest request) {
    return listInputsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Input> future =
   *       livestreamServiceClient.listInputsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Input element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInputsRequest, ListInputsPagedResponse> listInputsPagedCallable() {
    return stub.listInputsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInputsResponse response = livestreamServiceClient.listInputsCallable().call(request);
   *     for (Input element : response.getInputsList()) {
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
  public final UnaryCallable<ListInputsRequest, ListInputsResponse> listInputsCallable() {
    return stub.listInputsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
   *   Input response = livestreamServiceClient.getInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(InputName name) {
    GetInputRequest request =
        GetInputRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString();
   *   Input response = livestreamServiceClient.getInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(String name) {
    GetInputRequest request = GetInputRequest.newBuilder().setName(name).build();
    return getInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetInputRequest request =
   *       GetInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   Input response = livestreamServiceClient.getInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(GetInputRequest request) {
    return getInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetInputRequest request =
   *       GetInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   ApiFuture<Input> future = livestreamServiceClient.getInputCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInputRequest, Input> getInputCallable() {
    return stub.getInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
   *   livestreamServiceClient.deleteInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(InputName name) {
    DeleteInputRequest request =
        DeleteInputRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString();
   *   livestreamServiceClient.deleteInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(String name) {
    DeleteInputRequest request = DeleteInputRequest.newBuilder().setName(name).build();
    return deleteInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(
      DeleteInputRequest request) {
    return deleteInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteInputOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationCallable() {
    return stub.deleteInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteInputCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInputRequest, Operation> deleteInputCallable() {
    return stub.deleteInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   Input input = Input.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Input response = livestreamServiceClient.updateInputAsync(input, updateMask).get();
   * }
   * }</pre>
   *
   * @param input Required. The input resource to be updated.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Input
   *     resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>[`tier`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.inputs#Tier)
   *       <li>[`preprocessingConfig`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.inputs#PreprocessingConfig)
   *       <li>[`securityRules`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.inputs#SecurityRule)
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the mask is not present, then each field from the list above is updated if the field
   *     appears in the request payload. To unset a field, add the field to the update mask and
   *     remove it from the request payload.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> updateInputAsync(
      Input input, FieldMask updateMask) {
    UpdateInputRequest request =
        UpdateInputRequest.newBuilder().setInput(input).setUpdateMask(updateMask).build();
    return updateInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Input response = livestreamServiceClient.updateInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> updateInputAsync(
      UpdateInputRequest request) {
    return updateInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Input, OperationMetadata> future =
   *       livestreamServiceClient.updateInputOperationCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationCallable() {
    return stub.updateInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updateInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInputRequest, Operation> updateInputCallable() {
    return stub.updateInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview the streaming content of the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
   *   PreviewInputResponse response = livestreamServiceClient.previewInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewInputResponse previewInput(InputName name) {
    PreviewInputRequest request =
        PreviewInputRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return previewInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview the streaming content of the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString();
   *   PreviewInputResponse response = livestreamServiceClient.previewInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewInputResponse previewInput(String name) {
    PreviewInputRequest request = PreviewInputRequest.newBuilder().setName(name).build();
    return previewInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview the streaming content of the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   PreviewInputRequest request =
   *       PreviewInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   PreviewInputResponse response = livestreamServiceClient.previewInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewInputResponse previewInput(PreviewInputRequest request) {
    return previewInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Preview the streaming content of the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   PreviewInputRequest request =
   *       PreviewInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   ApiFuture<PreviewInputResponse> future =
   *       livestreamServiceClient.previewInputCallable().futureCall(request);
   *   // Do something.
   *   PreviewInputResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PreviewInputRequest, PreviewInputResponse> previewInputCallable() {
    return stub.previewInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = livestreamServiceClient.createEvent(parent, event, eventId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param event Required. The event resource to be created.
   * @param eventId Required. The ID of the event resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(ChannelName parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = livestreamServiceClient.createEvent(parent, event, eventId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param event Required. The event resource to be created.
   * @param eventId Required. The ID of the event resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(String parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent)
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setEvent(Event.newBuilder().build())
   *           .setEventId("eventId-1376502443")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Event response = livestreamServiceClient.createEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(CreateEventRequest request) {
    return createEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setEvent(Event.newBuilder().build())
   *           .setEventId("eventId-1376502443")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Event> future = livestreamServiceClient.createEventCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEventRequest, Event> createEventCallable() {
    return stub.createEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   for (Event element : livestreamServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ChannelName parent) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   for (Event element : livestreamServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(String parent) {
    ListEventsRequest request = ListEventsRequest.newBuilder().setParent(parent).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Event element : livestreamServiceClient.listEvents(request).iterateAll()) {
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
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Event> future =
   *       livestreamServiceClient.listEventsPagedCallable().futureCall(request);
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
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEventsResponse response = livestreamServiceClient.listEventsCallable().call(request);
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
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
   *   Event response = livestreamServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(EventName name) {
    GetEventRequest request =
        GetEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString();
   *   Event response = livestreamServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(String name) {
    GetEventRequest request = GetEventRequest.newBuilder().setName(name).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .build();
   *   Event response = livestreamServiceClient.getEvent(request);
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
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .build();
   *   ApiFuture<Event> future = livestreamServiceClient.getEventCallable().futureCall(request);
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
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
   *   livestreamServiceClient.deleteEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(EventName name) {
    DeleteEventRequest request =
        DeleteEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString();
   *   livestreamServiceClient.deleteEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(String name) {
    DeleteEventRequest request = DeleteEventRequest.newBuilder().setName(name).build();
    deleteEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(DeleteEventRequest request) {
    deleteEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = livestreamServiceClient.deleteEventCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEventRequest, Empty> deleteEventCallable() {
    return stub.deleteEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all clips in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   for (Clip element : livestreamServiceClient.listClips(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClipsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClipsPagedResponse listClips(ChannelName parent) {
    ListClipsRequest request =
        ListClipsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listClips(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all clips in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   for (Clip element : livestreamServiceClient.listClips(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListClipsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClipsPagedResponse listClips(String parent) {
    ListClipsRequest request = ListClipsRequest.newBuilder().setParent(parent).build();
    return listClips(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all clips in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListClipsRequest request =
   *       ListClipsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Clip element : livestreamServiceClient.listClips(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClipsPagedResponse listClips(ListClipsRequest request) {
    return listClipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all clips in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListClipsRequest request =
   *       ListClipsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Clip> future = livestreamServiceClient.listClipsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Clip element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClipsRequest, ListClipsPagedResponse> listClipsPagedCallable() {
    return stub.listClipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all clips in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListClipsRequest request =
   *       ListClipsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListClipsResponse response = livestreamServiceClient.listClipsCallable().call(request);
   *     for (Clip element : response.getClipsList()) {
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
  public final UnaryCallable<ListClipsRequest, ListClipsResponse> listClipsCallable() {
    return stub.listClipsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified clip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");
   *   Clip response = livestreamServiceClient.getClip(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channel}/clips/{clip}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Clip getClip(ClipName name) {
    GetClipRequest request =
        GetClipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getClip(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified clip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString();
   *   Clip response = livestreamServiceClient.getClip(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channel}/clips/{clip}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Clip getClip(String name) {
    GetClipRequest request = GetClipRequest.newBuilder().setName(name).build();
    return getClip(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified clip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetClipRequest request =
   *       GetClipRequest.newBuilder()
   *           .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
   *           .build();
   *   Clip response = livestreamServiceClient.getClip(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Clip getClip(GetClipRequest request) {
    return getClipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified clip.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetClipRequest request =
   *       GetClipRequest.newBuilder()
   *           .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
   *           .build();
   *   ApiFuture<Clip> future = livestreamServiceClient.getClipCallable().futureCall(request);
   *   // Do something.
   *   Clip response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClipRequest, Clip> getClipCallable() {
    return stub.getClipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a clip with the provided clip ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Clip clip = Clip.newBuilder().build();
   *   String clipId = "clipId-1357703029";
   *   Clip response = livestreamServiceClient.createClipAsync(parent, clip, clipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channel}`.
   * @param clip Required. The resource being created
   * @param clipId Required. The ID of the clip resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Clip, OperationMetadata> createClipAsync(
      ChannelName parent, Clip clip, String clipId) {
    CreateClipRequest request =
        CreateClipRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setClip(clip)
            .setClipId(clipId)
            .build();
    return createClipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a clip with the provided clip ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Clip clip = Clip.newBuilder().build();
   *   String clipId = "clipId-1357703029";
   *   Clip response = livestreamServiceClient.createClipAsync(parent, clip, clipId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channel}`.
   * @param clip Required. The resource being created
   * @param clipId Required. The ID of the clip resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Clip, OperationMetadata> createClipAsync(
      String parent, Clip clip, String clipId) {
    CreateClipRequest request =
        CreateClipRequest.newBuilder().setParent(parent).setClip(clip).setClipId(clipId).build();
    return createClipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a clip with the provided clip ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateClipRequest request =
   *       CreateClipRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setClipId("clipId-1357703029")
   *           .setClip(Clip.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Clip response = livestreamServiceClient.createClipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Clip, OperationMetadata> createClipAsync(CreateClipRequest request) {
    return createClipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a clip with the provided clip ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateClipRequest request =
   *       CreateClipRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setClipId("clipId-1357703029")
   *           .setClip(Clip.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Clip, OperationMetadata> future =
   *       livestreamServiceClient.createClipOperationCallable().futureCall(request);
   *   // Do something.
   *   Clip response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClipRequest, Clip, OperationMetadata>
      createClipOperationCallable() {
    return stub.createClipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a clip with the provided clip ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateClipRequest request =
   *       CreateClipRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setClipId("clipId-1357703029")
   *           .setClip(Clip.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createClipCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClipRequest, Operation> createClipCallable() {
    return stub.createClipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified clip job resource. This method only deletes the clip job and does not
   * delete the VOD clip stored in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ClipName name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]");
   *   livestreamServiceClient.deleteClipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the clip resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/clips/{clipId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClipAsync(ClipName name) {
    DeleteClipRequest request =
        DeleteClipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified clip job resource. This method only deletes the clip job and does not
   * delete the VOD clip stored in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString();
   *   livestreamServiceClient.deleteClipAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the clip resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/clips/{clipId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClipAsync(String name) {
    DeleteClipRequest request = DeleteClipRequest.newBuilder().setName(name).build();
    return deleteClipAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified clip job resource. This method only deletes the clip job and does not
   * delete the VOD clip stored in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteClipRequest request =
   *       DeleteClipRequest.newBuilder()
   *           .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteClipAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteClipAsync(
      DeleteClipRequest request) {
    return deleteClipOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified clip job resource. This method only deletes the clip job and does not
   * delete the VOD clip stored in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteClipRequest request =
   *       DeleteClipRequest.newBuilder()
   *           .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteClipOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClipRequest, Empty, OperationMetadata>
      deleteClipOperationCallable() {
    return stub.deleteClipOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified clip job resource. This method only deletes the clip job and does not
   * delete the VOD clip stored in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteClipRequest request =
   *       DeleteClipRequest.newBuilder()
   *           .setName(ClipName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[CLIP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteClipCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClipRequest, Operation> deleteClipCallable() {
    return stub.deleteClipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DVR session with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   DvrSession dvrSession = DvrSession.newBuilder().build();
   *   String dvrSessionId = "dvrSessionId120568849";
   *   DvrSession response =
   *       livestreamServiceClient.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param dvrSession Required. The resource being created
   * @param dvrSessionId Required. The ID of the DVR session resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DvrSession, OperationMetadata> createDvrSessionAsync(
      ChannelName parent, DvrSession dvrSession, String dvrSessionId) {
    CreateDvrSessionRequest request =
        CreateDvrSessionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDvrSession(dvrSession)
            .setDvrSessionId(dvrSessionId)
            .build();
    return createDvrSessionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DVR session with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   DvrSession dvrSession = DvrSession.newBuilder().build();
   *   String dvrSessionId = "dvrSessionId120568849";
   *   DvrSession response =
   *       livestreamServiceClient.createDvrSessionAsync(parent, dvrSession, dvrSessionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param dvrSession Required. The resource being created
   * @param dvrSessionId Required. The ID of the DVR session resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DvrSession, OperationMetadata> createDvrSessionAsync(
      String parent, DvrSession dvrSession, String dvrSessionId) {
    CreateDvrSessionRequest request =
        CreateDvrSessionRequest.newBuilder()
            .setParent(parent)
            .setDvrSession(dvrSession)
            .setDvrSessionId(dvrSessionId)
            .build();
    return createDvrSessionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DVR session with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateDvrSessionRequest request =
   *       CreateDvrSessionRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setDvrSessionId("dvrSessionId120568849")
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DvrSession response = livestreamServiceClient.createDvrSessionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DvrSession, OperationMetadata> createDvrSessionAsync(
      CreateDvrSessionRequest request) {
    return createDvrSessionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DVR session with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateDvrSessionRequest request =
   *       CreateDvrSessionRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setDvrSessionId("dvrSessionId120568849")
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DvrSession, OperationMetadata> future =
   *       livestreamServiceClient.createDvrSessionOperationCallable().futureCall(request);
   *   // Do something.
   *   DvrSession response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDvrSessionRequest, DvrSession, OperationMetadata>
      createDvrSessionOperationCallable() {
    return stub.createDvrSessionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a DVR session with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateDvrSessionRequest request =
   *       CreateDvrSessionRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setDvrSessionId("dvrSessionId120568849")
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createDvrSessionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDvrSessionRequest, Operation> createDvrSessionCallable() {
    return stub.createDvrSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all DVR sessions in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   for (DvrSession element : livestreamServiceClient.listDvrSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDvrSessionsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDvrSessionsPagedResponse listDvrSessions(ChannelName parent) {
    ListDvrSessionsRequest request =
        ListDvrSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDvrSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all DVR sessions in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   for (DvrSession element : livestreamServiceClient.listDvrSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListDvrSessionsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDvrSessionsPagedResponse listDvrSessions(String parent) {
    ListDvrSessionsRequest request = ListDvrSessionsRequest.newBuilder().setParent(parent).build();
    return listDvrSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all DVR sessions in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListDvrSessionsRequest request =
   *       ListDvrSessionsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DvrSession element : livestreamServiceClient.listDvrSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDvrSessionsPagedResponse listDvrSessions(ListDvrSessionsRequest request) {
    return listDvrSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all DVR sessions in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListDvrSessionsRequest request =
   *       ListDvrSessionsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DvrSession> future =
   *       livestreamServiceClient.listDvrSessionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DvrSession element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDvrSessionsRequest, ListDvrSessionsPagedResponse>
      listDvrSessionsPagedCallable() {
    return stub.listDvrSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all DVR sessions in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListDvrSessionsRequest request =
   *       ListDvrSessionsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDvrSessionsResponse response =
   *         livestreamServiceClient.listDvrSessionsCallable().call(request);
   *     for (DvrSession element : response.getDvrSessionsList()) {
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
  public final UnaryCallable<ListDvrSessionsRequest, ListDvrSessionsResponse>
      listDvrSessionsCallable() {
    return stub.listDvrSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DvrSessionName name =
   *       DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");
   *   DvrSession response = livestreamServiceClient.getDvrSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channelId}/dvrSessions/{dvrSessionId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DvrSession getDvrSession(DvrSessionName name) {
    GetDvrSessionRequest request =
        GetDvrSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDvrSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name =
   *       DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]").toString();
   *   DvrSession response = livestreamServiceClient.getDvrSession(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/channels/{channelId}/dvrSessions/{dvrSessionId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DvrSession getDvrSession(String name) {
    GetDvrSessionRequest request = GetDvrSessionRequest.newBuilder().setName(name).build();
    return getDvrSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetDvrSessionRequest request =
   *       GetDvrSessionRequest.newBuilder()
   *           .setName(
   *               DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
   *                   .toString())
   *           .build();
   *   DvrSession response = livestreamServiceClient.getDvrSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DvrSession getDvrSession(GetDvrSessionRequest request) {
    return getDvrSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetDvrSessionRequest request =
   *       GetDvrSessionRequest.newBuilder()
   *           .setName(
   *               DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DvrSession> future =
   *       livestreamServiceClient.getDvrSessionCallable().futureCall(request);
   *   // Do something.
   *   DvrSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDvrSessionRequest, DvrSession> getDvrSessionCallable() {
    return stub.getDvrSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DvrSessionName name =
   *       DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]");
   *   livestreamServiceClient.deleteDvrSessionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/dvrSessions/{dvrSessionId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDvrSessionAsync(
      DvrSessionName name) {
    DeleteDvrSessionRequest request =
        DeleteDvrSessionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDvrSessionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name =
   *       DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]").toString();
   *   livestreamServiceClient.deleteDvrSessionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/dvrSessions/{dvrSessionId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDvrSessionAsync(String name) {
    DeleteDvrSessionRequest request = DeleteDvrSessionRequest.newBuilder().setName(name).build();
    return deleteDvrSessionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteDvrSessionRequest request =
   *       DeleteDvrSessionRequest.newBuilder()
   *           .setName(
   *               DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteDvrSessionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDvrSessionAsync(
      DeleteDvrSessionRequest request) {
    return deleteDvrSessionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteDvrSessionRequest request =
   *       DeleteDvrSessionRequest.newBuilder()
   *           .setName(
   *               DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteDvrSessionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDvrSessionRequest, Empty, OperationMetadata>
      deleteDvrSessionOperationCallable() {
    return stub.deleteDvrSessionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteDvrSessionRequest request =
   *       DeleteDvrSessionRequest.newBuilder()
   *           .setName(
   *               DvrSessionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[DVR_SESSION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteDvrSessionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDvrSessionRequest, Operation> deleteDvrSessionCallable() {
    return stub.deleteDvrSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DvrSession dvrSession = DvrSession.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DvrSession response =
   *       livestreamServiceClient.updateDvrSessionAsync(dvrSession, updateMask).get();
   * }
   * }</pre>
   *
   * @param dvrSession Required. The DVR session resource to be updated.
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     DvrSession resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>`dvrWindows`
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DvrSession, OperationMetadata> updateDvrSessionAsync(
      DvrSession dvrSession, FieldMask updateMask) {
    UpdateDvrSessionRequest request =
        UpdateDvrSessionRequest.newBuilder()
            .setDvrSession(dvrSession)
            .setUpdateMask(updateMask)
            .build();
    return updateDvrSessionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateDvrSessionRequest request =
   *       UpdateDvrSessionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DvrSession response = livestreamServiceClient.updateDvrSessionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DvrSession, OperationMetadata> updateDvrSessionAsync(
      UpdateDvrSessionRequest request) {
    return updateDvrSessionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateDvrSessionRequest request =
   *       UpdateDvrSessionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DvrSession, OperationMetadata> future =
   *       livestreamServiceClient.updateDvrSessionOperationCallable().futureCall(request);
   *   // Do something.
   *   DvrSession response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDvrSessionRequest, DvrSession, OperationMetadata>
      updateDvrSessionOperationCallable() {
    return stub.updateDvrSessionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified DVR session.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateDvrSessionRequest request =
   *       UpdateDvrSessionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDvrSession(DvrSession.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updateDvrSessionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDvrSessionRequest, Operation> updateDvrSessionCallable() {
    return stub.updateDvrSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Asset with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = livestreamServiceClient.createAssetAsync(parent, asset, assetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param asset Required. The asset resource to be created.
   * @param assetId Required. The ID of the asset resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      LocationName parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Asset with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Asset asset = Asset.newBuilder().build();
   *   String assetId = "assetId-704776149";
   *   Asset response = livestreamServiceClient.createAssetAsync(parent, asset, assetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param asset Required. The asset resource to be created.
   * @param assetId Required. The ID of the asset resource to be created.
   *     <p>This value must be 1-63 characters, begin and end with a lower-case letter or a number,
   *     and consist of only lower-case letters, numbers, and hyphens. In other words, it must match
   *     the following regex: `^[a-z0-9]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      String parent, Asset asset, String assetId) {
    CreateAssetRequest request =
        CreateAssetRequest.newBuilder()
            .setParent(parent)
            .setAsset(asset)
            .setAssetId(assetId)
            .build();
    return createAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Asset with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAsset(Asset.newBuilder().build())
   *           .setAssetId("assetId-704776149")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Asset response = livestreamServiceClient.createAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Asset, OperationMetadata> createAssetAsync(
      CreateAssetRequest request) {
    return createAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Asset with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAsset(Asset.newBuilder().build())
   *           .setAssetId("assetId-704776149")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Asset, OperationMetadata> future =
   *       livestreamServiceClient.createAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationCallable() {
    return stub.createAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Asset with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateAssetRequest request =
   *       CreateAssetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAsset(Asset.newBuilder().build())
   *           .setAssetId("assetId-704776149")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createAssetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssetRequest, Operation> createAssetCallable() {
    return stub.createAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified asset if it is not used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
   *   livestreamServiceClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset resource, in the form of:
   *     `projects/{project}/locations/{location}/assets/{assetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(AssetName name) {
    DeleteAssetRequest request =
        DeleteAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified asset if it is not used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString();
   *   livestreamServiceClient.deleteAssetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the asset resource, in the form of:
   *     `projects/{project}/locations/{location}/assets/{assetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(String name) {
    DeleteAssetRequest request = DeleteAssetRequest.newBuilder().setName(name).build();
    return deleteAssetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified asset if it is not used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteAssetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAssetAsync(
      DeleteAssetRequest request) {
    return deleteAssetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified asset if it is not used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteAssetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationCallable() {
    return stub.deleteAssetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified asset if it is not used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteAssetRequest request =
   *       DeleteAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteAssetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssetRequest, Operation> deleteAssetCallable() {
    return stub.deleteAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
   *   Asset response = livestreamServiceClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/assets/{asset}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(AssetName name) {
    GetAssetRequest request =
        GetAssetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString();
   *   Asset response = livestreamServiceClient.getAsset(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, in the following form:
   *     `projects/{project}/locations/{location}/assets/{asset}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(String name) {
    GetAssetRequest request = GetAssetRequest.newBuilder().setName(name).build();
    return getAsset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .build();
   *   Asset response = livestreamServiceClient.getAsset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Asset getAsset(GetAssetRequest request) {
    return getAssetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified asset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetAssetRequest request =
   *       GetAssetRequest.newBuilder()
   *           .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
   *           .build();
   *   ApiFuture<Asset> future = livestreamServiceClient.getAssetCallable().futureCall(request);
   *   // Do something.
   *   Asset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return stub.getAssetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all assets in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Asset element : livestreamServiceClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(LocationName parent) {
    ListAssetsRequest request =
        ListAssetsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all assets in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Asset element : livestreamServiceClient.listAssets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(String parent) {
    ListAssetsRequest request = ListAssetsRequest.newBuilder().setParent(parent).build();
    return listAssets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all assets in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Asset element : livestreamServiceClient.listAssets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return listAssetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all assets in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Asset> future =
   *       livestreamServiceClient.listAssetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Asset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return stub.listAssetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all assets in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListAssetsRequest request =
   *       ListAssetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAssetsResponse response = livestreamServiceClient.listAssetsCallable().call(request);
   *     for (Asset element : response.getAssetsList()) {
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
  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return stub.listAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   PoolName name = PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]");
   *   Pool response = livestreamServiceClient.getPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool resource, in the form of:
   *     `projects/{project}/locations/{location}/pools/{poolId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pool getPool(PoolName name) {
    GetPoolRequest request =
        GetPoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString();
   *   Pool response = livestreamServiceClient.getPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pool resource, in the form of:
   *     `projects/{project}/locations/{location}/pools/{poolId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pool getPool(String name) {
    GetPoolRequest request = GetPoolRequest.newBuilder().setName(name).build();
    return getPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetPoolRequest request =
   *       GetPoolRequest.newBuilder()
   *           .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
   *           .build();
   *   Pool response = livestreamServiceClient.getPool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pool getPool(GetPoolRequest request) {
    return getPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetPoolRequest request =
   *       GetPoolRequest.newBuilder()
   *           .setName(PoolName.of("[PROJECT]", "[LOCATION]", "[POOL]").toString())
   *           .build();
   *   ApiFuture<Pool> future = livestreamServiceClient.getPoolCallable().futureCall(request);
   *   // Do something.
   *   Pool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPoolRequest, Pool> getPoolCallable() {
    return stub.getPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   Pool pool = Pool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Pool response = livestreamServiceClient.updatePoolAsync(pool, updateMask).get();
   * }
   * }</pre>
   *
   * @param pool Required. The pool resource to be updated.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Pool
   *     resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>`networkConfig`
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pool, OperationMetadata> updatePoolAsync(
      Pool pool, FieldMask updateMask) {
    UpdatePoolRequest request =
        UpdatePoolRequest.newBuilder().setPool(pool).setUpdateMask(updateMask).build();
    return updatePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdatePoolRequest request =
   *       UpdatePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPool(Pool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Pool response = livestreamServiceClient.updatePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pool, OperationMetadata> updatePoolAsync(UpdatePoolRequest request) {
    return updatePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdatePoolRequest request =
   *       UpdatePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPool(Pool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Pool, OperationMetadata> future =
   *       livestreamServiceClient.updatePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   Pool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePoolRequest, Pool, OperationMetadata>
      updatePoolOperationCallable() {
    return stub.updatePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdatePoolRequest request =
   *       UpdatePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setPool(Pool.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updatePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePoolRequest, Operation> updatePoolCallable() {
    return stub.updatePoolCallable();
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
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : livestreamServiceClient.listLocations(request).iterateAll()) {
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
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       livestreamServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         livestreamServiceClient.listLocationsCallable().call(request);
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
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = livestreamServiceClient.getLocation(request);
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
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       livestreamServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    public static ApiFuture<ListChannelsPagedResponse> createAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      ApiFuture<ListChannelsPage> futurePage =
          ListChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelsPagedResponse(ListChannelsPage page) {
      super(page, ListChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelsPage
      extends AbstractPage<ListChannelsRequest, ListChannelsResponse, Channel, ListChannelsPage> {

    private ListChannelsPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      super(context, response);
    }

    private static ListChannelsPage createEmptyPage() {
      return new ListChannelsPage(null, null);
    }

    @Override
    protected ListChannelsPage createPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      return new ListChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelsPage> createPageAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    private ListChannelsFixedSizeCollection(List<ListChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelsFixedSizeCollection createEmptyCollection() {
      return new ListChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelsFixedSizeCollection createCollection(
        List<ListChannelsPage> pages, int collectionSize) {
      return new ListChannelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInputsPagedResponse
      extends AbstractPagedListResponse<
          ListInputsRequest,
          ListInputsResponse,
          Input,
          ListInputsPage,
          ListInputsFixedSizeCollection> {

    public static ApiFuture<ListInputsPagedResponse> createAsync(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ApiFuture<ListInputsResponse> futureResponse) {
      ApiFuture<ListInputsPage> futurePage =
          ListInputsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListInputsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListInputsPagedResponse(ListInputsPage page) {
      super(page, ListInputsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInputsPage
      extends AbstractPage<ListInputsRequest, ListInputsResponse, Input, ListInputsPage> {

    private ListInputsPage(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ListInputsResponse response) {
      super(context, response);
    }

    private static ListInputsPage createEmptyPage() {
      return new ListInputsPage(null, null);
    }

    @Override
    protected ListInputsPage createPage(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ListInputsResponse response) {
      return new ListInputsPage(context, response);
    }

    @Override
    public ApiFuture<ListInputsPage> createPageAsync(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ApiFuture<ListInputsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInputsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInputsRequest,
          ListInputsResponse,
          Input,
          ListInputsPage,
          ListInputsFixedSizeCollection> {

    private ListInputsFixedSizeCollection(List<ListInputsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInputsFixedSizeCollection createEmptyCollection() {
      return new ListInputsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInputsFixedSizeCollection createCollection(
        List<ListInputsPage> pages, int collectionSize) {
      return new ListInputsFixedSizeCollection(pages, collectionSize);
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

  public static class ListClipsPagedResponse
      extends AbstractPagedListResponse<
          ListClipsRequest, ListClipsResponse, Clip, ListClipsPage, ListClipsFixedSizeCollection> {

    public static ApiFuture<ListClipsPagedResponse> createAsync(
        PageContext<ListClipsRequest, ListClipsResponse, Clip> context,
        ApiFuture<ListClipsResponse> futureResponse) {
      ApiFuture<ListClipsPage> futurePage =
          ListClipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListClipsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListClipsPagedResponse(ListClipsPage page) {
      super(page, ListClipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClipsPage
      extends AbstractPage<ListClipsRequest, ListClipsResponse, Clip, ListClipsPage> {

    private ListClipsPage(
        PageContext<ListClipsRequest, ListClipsResponse, Clip> context,
        ListClipsResponse response) {
      super(context, response);
    }

    private static ListClipsPage createEmptyPage() {
      return new ListClipsPage(null, null);
    }

    @Override
    protected ListClipsPage createPage(
        PageContext<ListClipsRequest, ListClipsResponse, Clip> context,
        ListClipsResponse response) {
      return new ListClipsPage(context, response);
    }

    @Override
    public ApiFuture<ListClipsPage> createPageAsync(
        PageContext<ListClipsRequest, ListClipsResponse, Clip> context,
        ApiFuture<ListClipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClipsRequest, ListClipsResponse, Clip, ListClipsPage, ListClipsFixedSizeCollection> {

    private ListClipsFixedSizeCollection(List<ListClipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClipsFixedSizeCollection createEmptyCollection() {
      return new ListClipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClipsFixedSizeCollection createCollection(
        List<ListClipsPage> pages, int collectionSize) {
      return new ListClipsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDvrSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListDvrSessionsRequest,
          ListDvrSessionsResponse,
          DvrSession,
          ListDvrSessionsPage,
          ListDvrSessionsFixedSizeCollection> {

    public static ApiFuture<ListDvrSessionsPagedResponse> createAsync(
        PageContext<ListDvrSessionsRequest, ListDvrSessionsResponse, DvrSession> context,
        ApiFuture<ListDvrSessionsResponse> futureResponse) {
      ApiFuture<ListDvrSessionsPage> futurePage =
          ListDvrSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDvrSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDvrSessionsPagedResponse(ListDvrSessionsPage page) {
      super(page, ListDvrSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDvrSessionsPage
      extends AbstractPage<
          ListDvrSessionsRequest, ListDvrSessionsResponse, DvrSession, ListDvrSessionsPage> {

    private ListDvrSessionsPage(
        PageContext<ListDvrSessionsRequest, ListDvrSessionsResponse, DvrSession> context,
        ListDvrSessionsResponse response) {
      super(context, response);
    }

    private static ListDvrSessionsPage createEmptyPage() {
      return new ListDvrSessionsPage(null, null);
    }

    @Override
    protected ListDvrSessionsPage createPage(
        PageContext<ListDvrSessionsRequest, ListDvrSessionsResponse, DvrSession> context,
        ListDvrSessionsResponse response) {
      return new ListDvrSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDvrSessionsPage> createPageAsync(
        PageContext<ListDvrSessionsRequest, ListDvrSessionsResponse, DvrSession> context,
        ApiFuture<ListDvrSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDvrSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDvrSessionsRequest,
          ListDvrSessionsResponse,
          DvrSession,
          ListDvrSessionsPage,
          ListDvrSessionsFixedSizeCollection> {

    private ListDvrSessionsFixedSizeCollection(
        List<ListDvrSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDvrSessionsFixedSizeCollection createEmptyCollection() {
      return new ListDvrSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDvrSessionsFixedSizeCollection createCollection(
        List<ListDvrSessionsPage> pages, int collectionSize) {
      return new ListDvrSessionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssetsPagedResponse
      extends AbstractPagedListResponse<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    public static ApiFuture<ListAssetsPagedResponse> createAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      ApiFuture<ListAssetsPage> futurePage =
          ListAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAssetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAssetsPagedResponse(ListAssetsPage page) {
      super(page, ListAssetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssetsPage
      extends AbstractPage<ListAssetsRequest, ListAssetsResponse, Asset, ListAssetsPage> {

    private ListAssetsPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      super(context, response);
    }

    private static ListAssetsPage createEmptyPage() {
      return new ListAssetsPage(null, null);
    }

    @Override
    protected ListAssetsPage createPage(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ListAssetsResponse response) {
      return new ListAssetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssetsPage> createPageAsync(
        PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context,
        ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssetsRequest,
          ListAssetsResponse,
          Asset,
          ListAssetsPage,
          ListAssetsFixedSizeCollection> {

    private ListAssetsFixedSizeCollection(List<ListAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssetsFixedSizeCollection createEmptyCollection() {
      return new ListAssetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssetsFixedSizeCollection createCollection(
        List<ListAssetsPage> pages, int collectionSize) {
      return new ListAssetsFixedSizeCollection(pages, collectionSize);
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
