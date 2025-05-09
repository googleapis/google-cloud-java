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

package com.google.cloud.eventarc.v1;

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
import com.google.cloud.eventarc.v1.stub.EventarcStub;
import com.google.cloud.eventarc.v1.stub.EventarcStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Eventarc allows users to subscribe to various events that are provided by
 * Google Cloud services and forward them to supported destinations.
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
 * try (EventarcClient eventarcClient = EventarcClient.create()) {
 *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
 *   Trigger response = eventarcClient.getTrigger(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EventarcClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetTrigger</td>
 *      <td><p> Get a single trigger.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTrigger(GetTriggerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTrigger(TriggerName name)
 *           <li><p> getTrigger(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTriggerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTriggers</td>
 *      <td><p> List triggers.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTriggers(ListTriggersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTriggers(LocationName parent)
 *           <li><p> listTriggers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTriggersPagedCallable()
 *           <li><p> listTriggersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTrigger</td>
 *      <td><p> Create a new trigger in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTriggerAsync(CreateTriggerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTriggerAsync(LocationName parent, Trigger trigger, String triggerId)
 *           <li><p> createTriggerAsync(String parent, Trigger trigger, String triggerId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTriggerOperationCallable()
 *           <li><p> createTriggerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTrigger</td>
 *      <td><p> Update a single trigger.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTriggerAsync(UpdateTriggerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTriggerAsync(Trigger trigger, FieldMask updateMask, boolean allowMissing)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTriggerOperationCallable()
 *           <li><p> updateTriggerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTrigger</td>
 *      <td><p> Delete a single trigger.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTriggerAsync(DeleteTriggerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTriggerAsync(TriggerName name, boolean allowMissing)
 *           <li><p> deleteTriggerAsync(String name, boolean allowMissing)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTriggerOperationCallable()
 *           <li><p> deleteTriggerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetChannel</td>
 *      <td><p> Get a single Channel.</td>
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
 *      <td><p> ListChannels</td>
 *      <td><p> List channels.</td>
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
 *      <td><p> CreateChannel</td>
 *      <td><p> Create a new channel in a particular project and location.</td>
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
 *      <td><p> UpdateChannel</td>
 *      <td><p> Update a single channel.</td>
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
 *      <td><p> DeleteChannel</td>
 *      <td><p> Delete a single channel.</td>
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
 *      <td><p> GetProvider</td>
 *      <td><p> Get a single Provider.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProvider(GetProviderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProvider(ProviderName name)
 *           <li><p> getProvider(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProviderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProviders</td>
 *      <td><p> List providers.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProviders(ListProvidersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProviders(LocationName parent)
 *           <li><p> listProviders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProvidersPagedCallable()
 *           <li><p> listProvidersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetChannelConnection</td>
 *      <td><p> Get a single ChannelConnection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChannelConnection(GetChannelConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChannelConnection(ChannelConnectionName name)
 *           <li><p> getChannelConnection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChannelConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChannelConnections</td>
 *      <td><p> List channel connections.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChannelConnections(ListChannelConnectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChannelConnections(LocationName parent)
 *           <li><p> listChannelConnections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChannelConnectionsPagedCallable()
 *           <li><p> listChannelConnectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateChannelConnection</td>
 *      <td><p> Create a new ChannelConnection in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createChannelConnectionAsync(CreateChannelConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createChannelConnectionAsync(LocationName parent, ChannelConnection channelConnection, String channelConnectionId)
 *           <li><p> createChannelConnectionAsync(String parent, ChannelConnection channelConnection, String channelConnectionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createChannelConnectionOperationCallable()
 *           <li><p> createChannelConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteChannelConnection</td>
 *      <td><p> Delete a single ChannelConnection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteChannelConnectionAsync(DeleteChannelConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteChannelConnectionAsync(ChannelConnectionName name)
 *           <li><p> deleteChannelConnectionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteChannelConnectionOperationCallable()
 *           <li><p> deleteChannelConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGoogleChannelConfig</td>
 *      <td><p> Get a GoogleChannelConfig</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGoogleChannelConfig(GetGoogleChannelConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGoogleChannelConfig(GoogleChannelConfigName name)
 *           <li><p> getGoogleChannelConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGoogleChannelConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGoogleChannelConfig</td>
 *      <td><p> Update a single GoogleChannelConfig</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGoogleChannelConfig(UpdateGoogleChannelConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGoogleChannelConfig(GoogleChannelConfig googleChannelConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGoogleChannelConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMessageBus</td>
 *      <td><p> Get a single MessageBus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMessageBus(GetMessageBusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMessageBus(MessageBusName name)
 *           <li><p> getMessageBus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMessageBusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMessageBuses</td>
 *      <td><p> List message buses.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMessageBuses(ListMessageBusesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMessageBuses(LocationName parent)
 *           <li><p> listMessageBuses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMessageBusesPagedCallable()
 *           <li><p> listMessageBusesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMessageBusEnrollments</td>
 *      <td><p> List message bus enrollments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMessageBusEnrollments(ListMessageBusEnrollmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMessageBusEnrollments(MessageBusName parent)
 *           <li><p> listMessageBusEnrollments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMessageBusEnrollmentsPagedCallable()
 *           <li><p> listMessageBusEnrollmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMessageBus</td>
 *      <td><p> Create a new MessageBus in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMessageBusAsync(CreateMessageBusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMessageBusAsync(LocationName parent, MessageBus messageBus, String messageBusId)
 *           <li><p> createMessageBusAsync(String parent, MessageBus messageBus, String messageBusId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMessageBusOperationCallable()
 *           <li><p> createMessageBusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMessageBus</td>
 *      <td><p> Update a single message bus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMessageBusAsync(UpdateMessageBusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMessageBusAsync(MessageBus messageBus, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMessageBusOperationCallable()
 *           <li><p> updateMessageBusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMessageBus</td>
 *      <td><p> Delete a single message bus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMessageBusAsync(DeleteMessageBusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMessageBusAsync(MessageBusName name, String etag)
 *           <li><p> deleteMessageBusAsync(String name, String etag)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMessageBusOperationCallable()
 *           <li><p> deleteMessageBusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEnrollment</td>
 *      <td><p> Get a single Enrollment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEnrollment(GetEnrollmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEnrollment(EnrollmentName name)
 *           <li><p> getEnrollment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEnrollmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEnrollments</td>
 *      <td><p> List Enrollments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEnrollments(ListEnrollmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEnrollments(LocationName parent)
 *           <li><p> listEnrollments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEnrollmentsPagedCallable()
 *           <li><p> listEnrollmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEnrollment</td>
 *      <td><p> Create a new Enrollment in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEnrollmentAsync(CreateEnrollmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEnrollmentAsync(LocationName parent, Enrollment enrollment, String enrollmentId)
 *           <li><p> createEnrollmentAsync(String parent, Enrollment enrollment, String enrollmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEnrollmentOperationCallable()
 *           <li><p> createEnrollmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEnrollment</td>
 *      <td><p> Update a single Enrollment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEnrollmentAsync(UpdateEnrollmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEnrollmentAsync(Enrollment enrollment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEnrollmentOperationCallable()
 *           <li><p> updateEnrollmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEnrollment</td>
 *      <td><p> Delete a single Enrollment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEnrollmentAsync(DeleteEnrollmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEnrollmentAsync(EnrollmentName name, String etag)
 *           <li><p> deleteEnrollmentAsync(String name, String etag)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEnrollmentOperationCallable()
 *           <li><p> deleteEnrollmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPipeline</td>
 *      <td><p> Get a single Pipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPipeline(GetPipelineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPipeline(PipelineName name)
 *           <li><p> getPipeline(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPipelines</td>
 *      <td><p> List pipelines.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPipelines(ListPipelinesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPipelines(LocationName parent)
 *           <li><p> listPipelines(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPipelinesPagedCallable()
 *           <li><p> listPipelinesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePipeline</td>
 *      <td><p> Create a new Pipeline in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPipelineAsync(CreatePipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPipelineAsync(LocationName parent, Pipeline pipeline, String pipelineId)
 *           <li><p> createPipelineAsync(String parent, Pipeline pipeline, String pipelineId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPipelineOperationCallable()
 *           <li><p> createPipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePipeline</td>
 *      <td><p> Update a single pipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePipelineAsync(UpdatePipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePipelineAsync(Pipeline pipeline, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePipelineOperationCallable()
 *           <li><p> updatePipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePipeline</td>
 *      <td><p> Delete a single pipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePipelineAsync(DeletePipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePipelineAsync(PipelineName name, String etag)
 *           <li><p> deletePipelineAsync(String name, String etag)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePipelineOperationCallable()
 *           <li><p> deletePipelineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGoogleApiSource</td>
 *      <td><p> Get a single GoogleApiSource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGoogleApiSource(GetGoogleApiSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGoogleApiSource(GoogleApiSourceName name)
 *           <li><p> getGoogleApiSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGoogleApiSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGoogleApiSources</td>
 *      <td><p> List GoogleApiSources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGoogleApiSources(ListGoogleApiSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGoogleApiSources(LocationName parent)
 *           <li><p> listGoogleApiSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGoogleApiSourcesPagedCallable()
 *           <li><p> listGoogleApiSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGoogleApiSource</td>
 *      <td><p> Create a new GoogleApiSource in a particular project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGoogleApiSourceAsync(CreateGoogleApiSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGoogleApiSourceAsync(LocationName parent, GoogleApiSource googleApiSource, String googleApiSourceId)
 *           <li><p> createGoogleApiSourceAsync(String parent, GoogleApiSource googleApiSource, String googleApiSourceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGoogleApiSourceOperationCallable()
 *           <li><p> createGoogleApiSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGoogleApiSource</td>
 *      <td><p> Update a single GoogleApiSource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGoogleApiSourceAsync(UpdateGoogleApiSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGoogleApiSourceAsync(GoogleApiSource googleApiSource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGoogleApiSourceOperationCallable()
 *           <li><p> updateGoogleApiSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGoogleApiSource</td>
 *      <td><p> Delete a single GoogleApiSource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGoogleApiSourceAsync(DeleteGoogleApiSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGoogleApiSourceAsync(GoogleApiSourceName name, String etag)
 *           <li><p> deleteGoogleApiSourceAsync(String name, String etag)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGoogleApiSourceOperationCallable()
 *           <li><p> deleteGoogleApiSourceCallable()
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of EventarcSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EventarcSettings eventarcSettings =
 *     EventarcSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
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
 * EventarcSettings eventarcSettings =
 *     EventarcSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
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
 * EventarcSettings eventarcSettings = EventarcSettings.newHttpJsonBuilder().build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EventarcClient implements BackgroundResource {
  private final EventarcSettings settings;
  private final EventarcStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EventarcClient with default settings. */
  public static final EventarcClient create() throws IOException {
    return create(EventarcSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EventarcClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EventarcClient create(EventarcSettings settings) throws IOException {
    return new EventarcClient(settings);
  }

  /**
   * Constructs an instance of EventarcClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(EventarcSettings).
   */
  public static final EventarcClient create(EventarcStub stub) {
    return new EventarcClient(stub);
  }

  /**
   * Constructs an instance of EventarcClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected EventarcClient(EventarcSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EventarcStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EventarcClient(EventarcStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EventarcSettings getSettings() {
    return settings;
  }

  public EventarcStub getStub() {
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
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
   *   Trigger response = eventarcClient.getTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(TriggerName name) {
    GetTriggerRequest request =
        GetTriggerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
   *   Trigger response = eventarcClient.getTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(String name) {
    GetTriggerRequest request = GetTriggerRequest.newBuilder().setName(name).build();
    return getTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetTriggerRequest request =
   *       GetTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .build();
   *   Trigger response = eventarcClient.getTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(GetTriggerRequest request) {
    return getTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetTriggerRequest request =
   *       GetTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .build();
   *   ApiFuture<Trigger> future = eventarcClient.getTriggerCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    return stub.getTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Trigger element : eventarcClient.listTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(LocationName parent) {
    ListTriggersRequest request =
        ListTriggersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Trigger element : eventarcClient.listTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(String parent) {
    ListTriggersRequest request = ListTriggersRequest.newBuilder().setParent(parent).build();
    return listTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Trigger element : eventarcClient.listTriggers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(ListTriggersRequest request) {
    return listTriggersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Trigger> future = eventarcClient.listTriggersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Trigger element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse>
      listTriggersPagedCallable() {
    return stub.listTriggersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListTriggersResponse response = eventarcClient.listTriggersCallable().call(request);
   *     for (Trigger element : response.getTriggersList()) {
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
  public final UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    return stub.listTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Trigger trigger = Trigger.newBuilder().build();
   *   String triggerId = "triggerId-648752909";
   *   Trigger response = eventarcClient.createTriggerAsync(parent, trigger, triggerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this trigger.
   * @param trigger Required. The trigger to create.
   * @param triggerId Required. The user-provided ID to be assigned to the trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      LocationName parent, Trigger trigger, String triggerId) {
    CreateTriggerRequest request =
        CreateTriggerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrigger(trigger)
            .setTriggerId(triggerId)
            .build();
    return createTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Trigger trigger = Trigger.newBuilder().build();
   *   String triggerId = "triggerId-648752909";
   *   Trigger response = eventarcClient.createTriggerAsync(parent, trigger, triggerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this trigger.
   * @param trigger Required. The trigger to create.
   * @param triggerId Required. The user-provided ID to be assigned to the trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      String parent, Trigger trigger, String triggerId) {
    CreateTriggerRequest request =
        CreateTriggerRequest.newBuilder()
            .setParent(parent)
            .setTrigger(trigger)
            .setTriggerId(triggerId)
            .build();
    return createTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.createTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      CreateTriggerRequest request) {
    return createTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.createTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    return stub.createTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    return stub.createTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Trigger trigger = Trigger.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.updateTriggerAsync(trigger, updateMask, allowMissing).get();
   * }
   * }</pre>
   *
   * @param trigger The trigger to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided are updated. If no
   *     field mask is provided, all provided fields in the request are updated. To update all
   *     fields, provide a field mask of "&#42;".
   * @param allowMissing If set to true, and the trigger is not found, a new trigger will be
   *     created. In this situation, `update_mask` is ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> updateTriggerAsync(
      Trigger trigger, FieldMask updateMask, boolean allowMissing) {
    UpdateTriggerRequest request =
        UpdateTriggerRequest.newBuilder()
            .setTrigger(trigger)
            .setUpdateMask(updateMask)
            .setAllowMissing(allowMissing)
            .build();
    return updateTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.updateTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> updateTriggerAsync(
      UpdateTriggerRequest request) {
    return updateTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.updateTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    return stub.updateTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    return stub.updateTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.deleteTriggerAsync(name, allowMissing).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to be deleted.
   * @param allowMissing If set to true, and the trigger is not found, the request will succeed but
   *     no action will be taken on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      TriggerName name, boolean allowMissing) {
    DeleteTriggerRequest request =
        DeleteTriggerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAllowMissing(allowMissing)
            .build();
    return deleteTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.deleteTriggerAsync(name, allowMissing).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to be deleted.
   * @param allowMissing If set to true, and the trigger is not found, the request will succeed but
   *     no action will be taken on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      String name, boolean allowMissing) {
    DeleteTriggerRequest request =
        DeleteTriggerRequest.newBuilder().setName(name).setAllowMissing(allowMissing).build();
    return deleteTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.deleteTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      DeleteTriggerRequest request) {
    return deleteTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.deleteTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    return stub.deleteTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    return stub.deleteTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = eventarcClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(ChannelName name) {
    GetChannelRequest request =
        GetChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = eventarcClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(String name) {
    GetChannelRequest request = GetChannelRequest.newBuilder().setName(name).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   Channel response = eventarcClient.getChannel(request);
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
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   ApiFuture<Channel> future = eventarcClient.getChannelCallable().futureCall(request);
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
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Channel element : eventarcClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list channels on.
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
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Channel element : eventarcClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list channels on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(String parent) {
    ListChannelsRequest request = ListChannelsRequest.newBuilder().setParent(parent).build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Channel element : eventarcClient.listChannels(request).iterateAll()) {
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
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Channel> future = eventarcClient.listChannelsPagedCallable().futureCall(request);
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
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChannelsResponse response = eventarcClient.listChannelsCallable().call(request);
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
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response = eventarcClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel.
   * @param channel Required. The channel to create.
   * @param channelId Required. The user-provided ID to be assigned to the channel.
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
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response = eventarcClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel.
   * @param channel Required. The channel to create.
   * @param channelId Required. The user-provided ID to be assigned to the channel.
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
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.createChannelAsync(request).get();
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
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.createChannelOperationCallable().futureCall(request);
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
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createChannelCallable().futureCall(request);
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
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Channel channel = Channel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Channel response = eventarcClient.updateChannelAsync(channel, updateMask).get();
   * }
   * }</pre>
   *
   * @param channel The channel to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided are updated. If no
   *     field mask is provided, all provided fields in the request are updated. To update all
   *     fields, provide a field mask of "&#42;".
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
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.updateChannelAsync(request).get();
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
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.updateChannelOperationCallable().futureCall(request);
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
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateChannelCallable().futureCall(request);
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
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = eventarcClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(ChannelName name) {
    DeleteChannelRequest request =
        DeleteChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = eventarcClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(String name) {
    DeleteChannelRequest request = DeleteChannelRequest.newBuilder().setName(name).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.deleteChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(
      DeleteChannelRequest request) {
    return deleteChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.deleteChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable() {
    return stub.deleteChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return stub.deleteChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ProviderName name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]");
   *   Provider response = eventarcClient.getProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(ProviderName name) {
    GetProviderRequest request =
        GetProviderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString();
   *   Provider response = eventarcClient.getProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(String name) {
    GetProviderRequest request = GetProviderRequest.newBuilder().setName(name).build();
    return getProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetProviderRequest request =
   *       GetProviderRequest.newBuilder()
   *           .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
   *           .build();
   *   Provider response = eventarcClient.getProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(GetProviderRequest request) {
    return getProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetProviderRequest request =
   *       GetProviderRequest.newBuilder()
   *           .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
   *           .build();
   *   ApiFuture<Provider> future = eventarcClient.getProviderCallable().futureCall(request);
   *   // Do something.
   *   Provider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProviderRequest, Provider> getProviderCallable() {
    return stub.getProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Provider element : eventarcClient.listProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(LocationName parent) {
    ListProvidersRequest request =
        ListProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Provider element : eventarcClient.listProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(String parent) {
    ListProvidersRequest request = ListProvidersRequest.newBuilder().setParent(parent).build();
    return listProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Provider element : eventarcClient.listProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(ListProvidersRequest request) {
    return listProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Provider> future = eventarcClient.listProvidersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Provider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable() {
    return stub.listProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListProvidersResponse response = eventarcClient.listProvidersCallable().call(request);
   *     for (Provider element : response.getProvidersList()) {
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
  public final UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable() {
    return stub.listProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelConnectionName name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
   *   ChannelConnection response = eventarcClient.getChannelConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(ChannelConnectionName name) {
    GetChannelConnectionRequest request =
        GetChannelConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getChannelConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]").toString();
   *   ChannelConnection response = eventarcClient.getChannelConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(String name) {
    GetChannelConnectionRequest request =
        GetChannelConnectionRequest.newBuilder().setName(name).build();
    return getChannelConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelConnectionRequest request =
   *       GetChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ChannelConnection response = eventarcClient.getChannelConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(GetChannelConnectionRequest request) {
    return getChannelConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelConnectionRequest request =
   *       GetChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ChannelConnection> future =
   *       eventarcClient.getChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable() {
    return stub.getChannelConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ChannelConnection element : eventarcClient.listChannelConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection from which to list channel connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(LocationName parent) {
    ListChannelConnectionsRequest request =
        ListChannelConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannelConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ChannelConnection element : eventarcClient.listChannelConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection from which to list channel connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(String parent) {
    ListChannelConnectionsRequest request =
        ListChannelConnectionsRequest.newBuilder().setParent(parent).build();
    return listChannelConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ChannelConnection element :
   *       eventarcClient.listChannelConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(
      ListChannelConnectionsRequest request) {
    return listChannelConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ChannelConnection> future =
   *       eventarcClient.listChannelConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChannelConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable() {
    return stub.listChannelConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChannelConnectionsResponse response =
   *         eventarcClient.listChannelConnectionsCallable().call(request);
   *     for (ChannelConnection element : response.getChannelConnectionsList()) {
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
  public final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable() {
    return stub.listChannelConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
   *   String channelConnectionId = "channelConnectionId-1246974660";
   *   ChannelConnection response =
   *       eventarcClient
   *           .createChannelConnectionAsync(parent, channelConnection, channelConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel connection.
   * @param channelConnection Required. Channel connection to create.
   * @param channelConnectionId Required. The user-provided ID to be assigned to the channel
   *     connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      LocationName parent, ChannelConnection channelConnection, String channelConnectionId) {
    CreateChannelConnectionRequest request =
        CreateChannelConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannelConnection(channelConnection)
            .setChannelConnectionId(channelConnectionId)
            .build();
    return createChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
   *   String channelConnectionId = "channelConnectionId-1246974660";
   *   ChannelConnection response =
   *       eventarcClient
   *           .createChannelConnectionAsync(parent, channelConnection, channelConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel connection.
   * @param channelConnection Required. Channel connection to create.
   * @param channelConnectionId Required. The user-provided ID to be assigned to the channel
   *     connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      String parent, ChannelConnection channelConnection, String channelConnectionId) {
    CreateChannelConnectionRequest request =
        CreateChannelConnectionRequest.newBuilder()
            .setParent(parent)
            .setChannelConnection(channelConnection)
            .setChannelConnectionId(channelConnectionId)
            .build();
    return createChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   ChannelConnection response = eventarcClient.createChannelConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      CreateChannelConnectionRequest request) {
    return createChannelConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   OperationFuture<ChannelConnection, OperationMetadata> future =
   *       eventarcClient.createChannelConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable() {
    return stub.createChannelConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.createChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable() {
    return stub.createChannelConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelConnectionName name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      ChannelConnectionName name) {
    DeleteChannelConnectionRequest request =
        DeleteChannelConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]").toString();
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      String name) {
    DeleteChannelConnectionRequest request =
        DeleteChannelConnectionRequest.newBuilder().setName(name).build();
    return deleteChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      DeleteChannelConnectionRequest request) {
    return deleteChannelConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ChannelConnection, OperationMetadata> future =
   *       eventarcClient.deleteChannelConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable() {
    return stub.deleteChannelConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.deleteChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable() {
    return stub.deleteChannelConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GoogleChannelConfigName name = GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]");
   *   GoogleChannelConfig response = eventarcClient.getGoogleChannelConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the config to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleChannelConfig getGoogleChannelConfig(GoogleChannelConfigName name) {
    GetGoogleChannelConfigRequest request =
        GetGoogleChannelConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGoogleChannelConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   GoogleChannelConfig response = eventarcClient.getGoogleChannelConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the config to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleChannelConfig getGoogleChannelConfig(String name) {
    GetGoogleChannelConfigRequest request =
        GetGoogleChannelConfigRequest.newBuilder().setName(name).build();
    return getGoogleChannelConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetGoogleChannelConfigRequest request =
   *       GetGoogleChannelConfigRequest.newBuilder()
   *           .setName(GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   GoogleChannelConfig response = eventarcClient.getGoogleChannelConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleChannelConfig getGoogleChannelConfig(GetGoogleChannelConfigRequest request) {
    return getGoogleChannelConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetGoogleChannelConfigRequest request =
   *       GetGoogleChannelConfigRequest.newBuilder()
   *           .setName(GoogleChannelConfigName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<GoogleChannelConfig> future =
   *       eventarcClient.getGoogleChannelConfigCallable().futureCall(request);
   *   // Do something.
   *   GoogleChannelConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigCallable() {
    return stub.getGoogleChannelConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GoogleChannelConfig googleChannelConfig = GoogleChannelConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GoogleChannelConfig response =
   *       eventarcClient.updateGoogleChannelConfig(googleChannelConfig, updateMask);
   * }
   * }</pre>
   *
   * @param googleChannelConfig Required. The config to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided are updated. If no
   *     field mask is provided, all provided fields in the request are updated. To update all
   *     fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleChannelConfig updateGoogleChannelConfig(
      GoogleChannelConfig googleChannelConfig, FieldMask updateMask) {
    UpdateGoogleChannelConfigRequest request =
        UpdateGoogleChannelConfigRequest.newBuilder()
            .setGoogleChannelConfig(googleChannelConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateGoogleChannelConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateGoogleChannelConfigRequest request =
   *       UpdateGoogleChannelConfigRequest.newBuilder()
   *           .setGoogleChannelConfig(GoogleChannelConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GoogleChannelConfig response = eventarcClient.updateGoogleChannelConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleChannelConfig updateGoogleChannelConfig(
      UpdateGoogleChannelConfigRequest request) {
    return updateGoogleChannelConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleChannelConfig
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateGoogleChannelConfigRequest request =
   *       UpdateGoogleChannelConfigRequest.newBuilder()
   *           .setGoogleChannelConfig(GoogleChannelConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GoogleChannelConfig> future =
   *       eventarcClient.updateGoogleChannelConfigCallable().futureCall(request);
   *   // Do something.
   *   GoogleChannelConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigCallable() {
    return stub.updateGoogleChannelConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single MessageBus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
   *   MessageBus response = eventarcClient.getMessageBus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the message bus to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MessageBus getMessageBus(MessageBusName name) {
    GetMessageBusRequest request =
        GetMessageBusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMessageBus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single MessageBus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString();
   *   MessageBus response = eventarcClient.getMessageBus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the message bus to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MessageBus getMessageBus(String name) {
    GetMessageBusRequest request = GetMessageBusRequest.newBuilder().setName(name).build();
    return getMessageBus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single MessageBus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetMessageBusRequest request =
   *       GetMessageBusRequest.newBuilder()
   *           .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .build();
   *   MessageBus response = eventarcClient.getMessageBus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MessageBus getMessageBus(GetMessageBusRequest request) {
    return getMessageBusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single MessageBus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetMessageBusRequest request =
   *       GetMessageBusRequest.newBuilder()
   *           .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .build();
   *   ApiFuture<MessageBus> future = eventarcClient.getMessageBusCallable().futureCall(request);
   *   // Do something.
   *   MessageBus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMessageBusRequest, MessageBus> getMessageBusCallable() {
    return stub.getMessageBusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message buses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MessageBus element : eventarcClient.listMessageBuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusesPagedResponse listMessageBuses(LocationName parent) {
    ListMessageBusesRequest request =
        ListMessageBusesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMessageBuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message buses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MessageBus element : eventarcClient.listMessageBuses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusesPagedResponse listMessageBuses(String parent) {
    ListMessageBusesRequest request =
        ListMessageBusesRequest.newBuilder().setParent(parent).build();
    return listMessageBuses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message buses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusesRequest request =
   *       ListMessageBusesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MessageBus element : eventarcClient.listMessageBuses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusesPagedResponse listMessageBuses(ListMessageBusesRequest request) {
    return listMessageBusesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message buses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusesRequest request =
   *       ListMessageBusesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MessageBus> future =
   *       eventarcClient.listMessageBusesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MessageBus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMessageBusesRequest, ListMessageBusesPagedResponse>
      listMessageBusesPagedCallable() {
    return stub.listMessageBusesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message buses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusesRequest request =
   *       ListMessageBusesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMessageBusesResponse response = eventarcClient.listMessageBusesCallable().call(request);
   *     for (MessageBus element : response.getMessageBusesList()) {
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
  public final UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse>
      listMessageBusesCallable() {
    return stub.listMessageBusesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message bus enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   MessageBusName parent = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
   *   for (String element : eventarcClient.listMessageBusEnrollments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent message bus to list enrollments on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusEnrollmentsPagedResponse listMessageBusEnrollments(
      MessageBusName parent) {
    ListMessageBusEnrollmentsRequest request =
        ListMessageBusEnrollmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMessageBusEnrollments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message bus enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString();
   *   for (String element : eventarcClient.listMessageBusEnrollments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent message bus to list enrollments on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusEnrollmentsPagedResponse listMessageBusEnrollments(String parent) {
    ListMessageBusEnrollmentsRequest request =
        ListMessageBusEnrollmentsRequest.newBuilder().setParent(parent).build();
    return listMessageBusEnrollments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message bus enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusEnrollmentsRequest request =
   *       ListMessageBusEnrollmentsRequest.newBuilder()
   *           .setParent(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : eventarcClient.listMessageBusEnrollments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessageBusEnrollmentsPagedResponse listMessageBusEnrollments(
      ListMessageBusEnrollmentsRequest request) {
    return listMessageBusEnrollmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message bus enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusEnrollmentsRequest request =
   *       ListMessageBusEnrollmentsRequest.newBuilder()
   *           .setParent(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       eventarcClient.listMessageBusEnrollmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsPagedCallable() {
    return stub.listMessageBusEnrollmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List message bus enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListMessageBusEnrollmentsRequest request =
   *       ListMessageBusEnrollmentsRequest.newBuilder()
   *           .setParent(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMessageBusEnrollmentsResponse response =
   *         eventarcClient.listMessageBusEnrollmentsCallable().call(request);
   *     for (String element : response.getEnrollmentsList()) {
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
  public final UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
      listMessageBusEnrollmentsCallable() {
    return stub.listMessageBusEnrollmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new MessageBus in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   MessageBus messageBus = MessageBus.newBuilder().build();
   *   String messageBusId = "messageBusId-1312824332";
   *   MessageBus response =
   *       eventarcClient.createMessageBusAsync(parent, messageBus, messageBusId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this message bus.
   * @param messageBus Required. The message bus to create.
   * @param messageBusId Required. The user-provided ID to be assigned to the MessageBus. It should
   *     match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> createMessageBusAsync(
      LocationName parent, MessageBus messageBus, String messageBusId) {
    CreateMessageBusRequest request =
        CreateMessageBusRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMessageBus(messageBus)
            .setMessageBusId(messageBusId)
            .build();
    return createMessageBusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new MessageBus in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   MessageBus messageBus = MessageBus.newBuilder().build();
   *   String messageBusId = "messageBusId-1312824332";
   *   MessageBus response =
   *       eventarcClient.createMessageBusAsync(parent, messageBus, messageBusId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this message bus.
   * @param messageBus Required. The message bus to create.
   * @param messageBusId Required. The user-provided ID to be assigned to the MessageBus. It should
   *     match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> createMessageBusAsync(
      String parent, MessageBus messageBus, String messageBusId) {
    CreateMessageBusRequest request =
        CreateMessageBusRequest.newBuilder()
            .setParent(parent)
            .setMessageBus(messageBus)
            .setMessageBusId(messageBusId)
            .build();
    return createMessageBusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new MessageBus in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateMessageBusRequest request =
   *       CreateMessageBusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setMessageBusId("messageBusId-1312824332")
   *           .setValidateOnly(true)
   *           .build();
   *   MessageBus response = eventarcClient.createMessageBusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> createMessageBusAsync(
      CreateMessageBusRequest request) {
    return createMessageBusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new MessageBus in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateMessageBusRequest request =
   *       CreateMessageBusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setMessageBusId("messageBusId-1312824332")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<MessageBus, OperationMetadata> future =
   *       eventarcClient.createMessageBusOperationCallable().futureCall(request);
   *   // Do something.
   *   MessageBus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationCallable() {
    return stub.createMessageBusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new MessageBus in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateMessageBusRequest request =
   *       CreateMessageBusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setMessageBusId("messageBusId-1312824332")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createMessageBusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMessageBusRequest, Operation> createMessageBusCallable() {
    return stub.createMessageBusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   MessageBus messageBus = MessageBus.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MessageBus response = eventarcClient.updateMessageBusAsync(messageBus, updateMask).get();
   * }
   * }</pre>
   *
   * @param messageBus Required. The MessageBus to be updated.
   * @param updateMask Optional. The fields to be updated; only fields explicitly provided are
   *     updated. If no field mask is provided, all provided fields in the request are updated. To
   *     update all fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> updateMessageBusAsync(
      MessageBus messageBus, FieldMask updateMask) {
    UpdateMessageBusRequest request =
        UpdateMessageBusRequest.newBuilder()
            .setMessageBus(messageBus)
            .setUpdateMask(updateMask)
            .build();
    return updateMessageBusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateMessageBusRequest request =
   *       UpdateMessageBusRequest.newBuilder()
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   MessageBus response = eventarcClient.updateMessageBusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> updateMessageBusAsync(
      UpdateMessageBusRequest request) {
    return updateMessageBusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateMessageBusRequest request =
   *       UpdateMessageBusRequest.newBuilder()
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<MessageBus, OperationMetadata> future =
   *       eventarcClient.updateMessageBusOperationCallable().futureCall(request);
   *   // Do something.
   *   MessageBus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationCallable() {
    return stub.updateMessageBusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateMessageBusRequest request =
   *       UpdateMessageBusRequest.newBuilder()
   *           .setMessageBus(MessageBus.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateMessageBusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMessageBusRequest, Operation> updateMessageBusCallable() {
    return stub.updateMessageBusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   MessageBusName name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]");
   *   String etag = "etag3123477";
   *   MessageBus response = eventarcClient.deleteMessageBusAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MessageBus to be deleted.
   * @param etag Optional. If provided, the MessageBus will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> deleteMessageBusAsync(
      MessageBusName name, String etag) {
    DeleteMessageBusRequest request =
        DeleteMessageBusRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setEtag(etag)
            .build();
    return deleteMessageBusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString();
   *   String etag = "etag3123477";
   *   MessageBus response = eventarcClient.deleteMessageBusAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MessageBus to be deleted.
   * @param etag Optional. If provided, the MessageBus will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> deleteMessageBusAsync(
      String name, String etag) {
    DeleteMessageBusRequest request =
        DeleteMessageBusRequest.newBuilder().setName(name).setEtag(etag).build();
    return deleteMessageBusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteMessageBusRequest request =
   *       DeleteMessageBusRequest.newBuilder()
   *           .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   MessageBus response = eventarcClient.deleteMessageBusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MessageBus, OperationMetadata> deleteMessageBusAsync(
      DeleteMessageBusRequest request) {
    return deleteMessageBusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteMessageBusRequest request =
   *       DeleteMessageBusRequest.newBuilder()
   *           .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<MessageBus, OperationMetadata> future =
   *       eventarcClient.deleteMessageBusOperationCallable().futureCall(request);
   *   // Do something.
   *   MessageBus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationCallable() {
    return stub.deleteMessageBusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single message bus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteMessageBusRequest request =
   *       DeleteMessageBusRequest.newBuilder()
   *           .setName(MessageBusName.of("[PROJECT]", "[LOCATION]", "[MESSAGE_BUS]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteMessageBusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMessageBusRequest, Operation> deleteMessageBusCallable() {
    return stub.deleteMessageBusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");
   *   Enrollment response = eventarcClient.getEnrollment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Enrollment to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Enrollment getEnrollment(EnrollmentName name) {
    GetEnrollmentRequest request =
        GetEnrollmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEnrollment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString();
   *   Enrollment response = eventarcClient.getEnrollment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Enrollment to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Enrollment getEnrollment(String name) {
    GetEnrollmentRequest request = GetEnrollmentRequest.newBuilder().setName(name).build();
    return getEnrollment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetEnrollmentRequest request =
   *       GetEnrollmentRequest.newBuilder()
   *           .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
   *           .build();
   *   Enrollment response = eventarcClient.getEnrollment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Enrollment getEnrollment(GetEnrollmentRequest request) {
    return getEnrollmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetEnrollmentRequest request =
   *       GetEnrollmentRequest.newBuilder()
   *           .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
   *           .build();
   *   ApiFuture<Enrollment> future = eventarcClient.getEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   Enrollment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEnrollmentRequest, Enrollment> getEnrollmentCallable() {
    return stub.getEnrollmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Enrollment element : eventarcClient.listEnrollments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrollmentsPagedResponse listEnrollments(LocationName parent) {
    ListEnrollmentsRequest request =
        ListEnrollmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEnrollments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Enrollment element : eventarcClient.listEnrollments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrollmentsPagedResponse listEnrollments(String parent) {
    ListEnrollmentsRequest request = ListEnrollmentsRequest.newBuilder().setParent(parent).build();
    return listEnrollments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListEnrollmentsRequest request =
   *       ListEnrollmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Enrollment element : eventarcClient.listEnrollments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrollmentsPagedResponse listEnrollments(ListEnrollmentsRequest request) {
    return listEnrollmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListEnrollmentsRequest request =
   *       ListEnrollmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Enrollment> future =
   *       eventarcClient.listEnrollmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Enrollment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsPagedResponse>
      listEnrollmentsPagedCallable() {
    return stub.listEnrollmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Enrollments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListEnrollmentsRequest request =
   *       ListEnrollmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListEnrollmentsResponse response = eventarcClient.listEnrollmentsCallable().call(request);
   *     for (Enrollment element : response.getEnrollmentsList()) {
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
  public final UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse>
      listEnrollmentsCallable() {
    return stub.listEnrollmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Enrollment in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Enrollment enrollment = Enrollment.newBuilder().build();
   *   String enrollmentId = "enrollmentId-107037889";
   *   Enrollment response =
   *       eventarcClient.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this enrollment.
   * @param enrollment Required. The enrollment to create.
   * @param enrollmentId Required. The user-provided ID to be assigned to the Enrollment. It should
   *     match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> createEnrollmentAsync(
      LocationName parent, Enrollment enrollment, String enrollmentId) {
    CreateEnrollmentRequest request =
        CreateEnrollmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEnrollment(enrollment)
            .setEnrollmentId(enrollmentId)
            .build();
    return createEnrollmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Enrollment in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Enrollment enrollment = Enrollment.newBuilder().build();
   *   String enrollmentId = "enrollmentId-107037889";
   *   Enrollment response =
   *       eventarcClient.createEnrollmentAsync(parent, enrollment, enrollmentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this enrollment.
   * @param enrollment Required. The enrollment to create.
   * @param enrollmentId Required. The user-provided ID to be assigned to the Enrollment. It should
   *     match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> createEnrollmentAsync(
      String parent, Enrollment enrollment, String enrollmentId) {
    CreateEnrollmentRequest request =
        CreateEnrollmentRequest.newBuilder()
            .setParent(parent)
            .setEnrollment(enrollment)
            .setEnrollmentId(enrollmentId)
            .build();
    return createEnrollmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Enrollment in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateEnrollmentRequest request =
   *       CreateEnrollmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setEnrollmentId("enrollmentId-107037889")
   *           .setValidateOnly(true)
   *           .build();
   *   Enrollment response = eventarcClient.createEnrollmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> createEnrollmentAsync(
      CreateEnrollmentRequest request) {
    return createEnrollmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Enrollment in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateEnrollmentRequest request =
   *       CreateEnrollmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setEnrollmentId("enrollmentId-107037889")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Enrollment, OperationMetadata> future =
   *       eventarcClient.createEnrollmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Enrollment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationCallable() {
    return stub.createEnrollmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Enrollment in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateEnrollmentRequest request =
   *       CreateEnrollmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setEnrollmentId("enrollmentId-107037889")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEnrollmentRequest, Operation> createEnrollmentCallable() {
    return stub.createEnrollmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Enrollment enrollment = Enrollment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Enrollment response = eventarcClient.updateEnrollmentAsync(enrollment, updateMask).get();
   * }
   * }</pre>
   *
   * @param enrollment Required. The Enrollment to be updated.
   * @param updateMask Optional. The fields to be updated; only fields explicitly provided are
   *     updated. If no field mask is provided, all provided fields in the request are updated. To
   *     update all fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> updateEnrollmentAsync(
      Enrollment enrollment, FieldMask updateMask) {
    UpdateEnrollmentRequest request =
        UpdateEnrollmentRequest.newBuilder()
            .setEnrollment(enrollment)
            .setUpdateMask(updateMask)
            .build();
    return updateEnrollmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateEnrollmentRequest request =
   *       UpdateEnrollmentRequest.newBuilder()
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Enrollment response = eventarcClient.updateEnrollmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> updateEnrollmentAsync(
      UpdateEnrollmentRequest request) {
    return updateEnrollmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateEnrollmentRequest request =
   *       UpdateEnrollmentRequest.newBuilder()
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Enrollment, OperationMetadata> future =
   *       eventarcClient.updateEnrollmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Enrollment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationCallable() {
    return stub.updateEnrollmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateEnrollmentRequest request =
   *       UpdateEnrollmentRequest.newBuilder()
   *           .setEnrollment(Enrollment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEnrollmentRequest, Operation> updateEnrollmentCallable() {
    return stub.updateEnrollmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   EnrollmentName name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]");
   *   String etag = "etag3123477";
   *   Enrollment response = eventarcClient.deleteEnrollmentAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Enrollment to be deleted.
   * @param etag Optional. If provided, the Enrollment will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> deleteEnrollmentAsync(
      EnrollmentName name, String etag) {
    DeleteEnrollmentRequest request =
        DeleteEnrollmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setEtag(etag)
            .build();
    return deleteEnrollmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString();
   *   String etag = "etag3123477";
   *   Enrollment response = eventarcClient.deleteEnrollmentAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Enrollment to be deleted.
   * @param etag Optional. If provided, the Enrollment will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> deleteEnrollmentAsync(
      String name, String etag) {
    DeleteEnrollmentRequest request =
        DeleteEnrollmentRequest.newBuilder().setName(name).setEtag(etag).build();
    return deleteEnrollmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteEnrollmentRequest request =
   *       DeleteEnrollmentRequest.newBuilder()
   *           .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Enrollment response = eventarcClient.deleteEnrollmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Enrollment, OperationMetadata> deleteEnrollmentAsync(
      DeleteEnrollmentRequest request) {
    return deleteEnrollmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteEnrollmentRequest request =
   *       DeleteEnrollmentRequest.newBuilder()
   *           .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Enrollment, OperationMetadata> future =
   *       eventarcClient.deleteEnrollmentOperationCallable().futureCall(request);
   *   // Do something.
   *   Enrollment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationCallable() {
    return stub.deleteEnrollmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single Enrollment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteEnrollmentRequest request =
   *       DeleteEnrollmentRequest.newBuilder()
   *           .setName(EnrollmentName.of("[PROJECT]", "[LOCATION]", "[ENROLLMENT]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEnrollmentRequest, Operation> deleteEnrollmentCallable() {
    return stub.deleteEnrollmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");
   *   Pipeline response = eventarcClient.getPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pipeline to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pipeline getPipeline(PipelineName name) {
    GetPipelineRequest request =
        GetPipelineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString();
   *   Pipeline response = eventarcClient.getPipeline(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the pipeline to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pipeline getPipeline(String name) {
    GetPipelineRequest request = GetPipelineRequest.newBuilder().setName(name).build();
    return getPipeline(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetPipelineRequest request =
   *       GetPipelineRequest.newBuilder()
   *           .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
   *           .build();
   *   Pipeline response = eventarcClient.getPipeline(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Pipeline getPipeline(GetPipelineRequest request) {
    return getPipelineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetPipelineRequest request =
   *       GetPipelineRequest.newBuilder()
   *           .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
   *           .build();
   *   ApiFuture<Pipeline> future = eventarcClient.getPipelineCallable().futureCall(request);
   *   // Do something.
   *   Pipeline response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPipelineRequest, Pipeline> getPipelineCallable() {
    return stub.getPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List pipelines.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Pipeline element : eventarcClient.listPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list pipelines on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelinesPagedResponse listPipelines(LocationName parent) {
    ListPipelinesRequest request =
        ListPipelinesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List pipelines.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Pipeline element : eventarcClient.listPipelines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list pipelines on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelinesPagedResponse listPipelines(String parent) {
    ListPipelinesRequest request = ListPipelinesRequest.newBuilder().setParent(parent).build();
    return listPipelines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List pipelines.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListPipelinesRequest request =
   *       ListPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Pipeline element : eventarcClient.listPipelines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPipelinesPagedResponse listPipelines(ListPipelinesRequest request) {
    return listPipelinesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List pipelines.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListPipelinesRequest request =
   *       ListPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Pipeline> future = eventarcClient.listPipelinesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Pipeline element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPipelinesRequest, ListPipelinesPagedResponse>
      listPipelinesPagedCallable() {
    return stub.listPipelinesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List pipelines.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListPipelinesRequest request =
   *       ListPipelinesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPipelinesResponse response = eventarcClient.listPipelinesCallable().call(request);
   *     for (Pipeline element : response.getPipelinesList()) {
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
  public final UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> listPipelinesCallable() {
    return stub.listPipelinesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Pipeline in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Pipeline pipeline = Pipeline.newBuilder().build();
   *   String pipelineId = "pipelineId-1076718755";
   *   Pipeline response = eventarcClient.createPipelineAsync(parent, pipeline, pipelineId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this pipeline.
   * @param pipeline Required. The pipeline to create.
   * @param pipelineId Required. The user-provided ID to be assigned to the Pipeline.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> createPipelineAsync(
      LocationName parent, Pipeline pipeline, String pipelineId) {
    CreatePipelineRequest request =
        CreatePipelineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPipeline(pipeline)
            .setPipelineId(pipelineId)
            .build();
    return createPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Pipeline in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Pipeline pipeline = Pipeline.newBuilder().build();
   *   String pipelineId = "pipelineId-1076718755";
   *   Pipeline response = eventarcClient.createPipelineAsync(parent, pipeline, pipelineId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this pipeline.
   * @param pipeline Required. The pipeline to create.
   * @param pipelineId Required. The user-provided ID to be assigned to the Pipeline.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> createPipelineAsync(
      String parent, Pipeline pipeline, String pipelineId) {
    CreatePipelineRequest request =
        CreatePipelineRequest.newBuilder()
            .setParent(parent)
            .setPipeline(pipeline)
            .setPipelineId(pipelineId)
            .build();
    return createPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Pipeline in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreatePipelineRequest request =
   *       CreatePipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setPipelineId("pipelineId-1076718755")
   *           .setValidateOnly(true)
   *           .build();
   *   Pipeline response = eventarcClient.createPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> createPipelineAsync(
      CreatePipelineRequest request) {
    return createPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Pipeline in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreatePipelineRequest request =
   *       CreatePipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setPipelineId("pipelineId-1076718755")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Pipeline, OperationMetadata> future =
   *       eventarcClient.createPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   Pipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationCallable() {
    return stub.createPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new Pipeline in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreatePipelineRequest request =
   *       CreatePipelineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setPipelineId("pipelineId-1076718755")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePipelineRequest, Operation> createPipelineCallable() {
    return stub.createPipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Pipeline pipeline = Pipeline.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Pipeline response = eventarcClient.updatePipelineAsync(pipeline, updateMask).get();
   * }
   * }</pre>
   *
   * @param pipeline Required. The Pipeline to be updated.
   * @param updateMask Optional. The fields to be updated; only fields explicitly provided are
   *     updated. If no field mask is provided, all provided fields in the request are updated. To
   *     update all fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> updatePipelineAsync(
      Pipeline pipeline, FieldMask updateMask) {
    UpdatePipelineRequest request =
        UpdatePipelineRequest.newBuilder().setPipeline(pipeline).setUpdateMask(updateMask).build();
    return updatePipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdatePipelineRequest request =
   *       UpdatePipelineRequest.newBuilder()
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Pipeline response = eventarcClient.updatePipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> updatePipelineAsync(
      UpdatePipelineRequest request) {
    return updatePipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdatePipelineRequest request =
   *       UpdatePipelineRequest.newBuilder()
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Pipeline, OperationMetadata> future =
   *       eventarcClient.updatePipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   Pipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationCallable() {
    return stub.updatePipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdatePipelineRequest request =
   *       UpdatePipelineRequest.newBuilder()
   *           .setPipeline(Pipeline.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updatePipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePipelineRequest, Operation> updatePipelineCallable() {
    return stub.updatePipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   PipelineName name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]");
   *   String etag = "etag3123477";
   *   Pipeline response = eventarcClient.deletePipelineAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Pipeline to be deleted.
   * @param etag Optional. If provided, the Pipeline will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> deletePipelineAsync(
      PipelineName name, String etag) {
    DeletePipelineRequest request =
        DeletePipelineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setEtag(etag)
            .build();
    return deletePipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString();
   *   String etag = "etag3123477";
   *   Pipeline response = eventarcClient.deletePipelineAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Pipeline to be deleted.
   * @param etag Optional. If provided, the Pipeline will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> deletePipelineAsync(
      String name, String etag) {
    DeletePipelineRequest request =
        DeletePipelineRequest.newBuilder().setName(name).setEtag(etag).build();
    return deletePipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeletePipelineRequest request =
   *       DeletePipelineRequest.newBuilder()
   *           .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Pipeline response = eventarcClient.deletePipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Pipeline, OperationMetadata> deletePipelineAsync(
      DeletePipelineRequest request) {
    return deletePipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeletePipelineRequest request =
   *       DeletePipelineRequest.newBuilder()
   *           .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Pipeline, OperationMetadata> future =
   *       eventarcClient.deletePipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   Pipeline response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationCallable() {
    return stub.deletePipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeletePipelineRequest request =
   *       DeletePipelineRequest.newBuilder()
   *           .setName(PipelineName.of("[PROJECT]", "[LOCATION]", "[PIPELINE]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deletePipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePipelineRequest, Operation> deletePipelineCallable() {
    return stub.deletePipelineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GoogleApiSourceName name =
   *       GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");
   *   GoogleApiSource response = eventarcClient.getGoogleApiSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the google api source to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleApiSource getGoogleApiSource(GoogleApiSourceName name) {
    GetGoogleApiSourceRequest request =
        GetGoogleApiSourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGoogleApiSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString();
   *   GoogleApiSource response = eventarcClient.getGoogleApiSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the google api source to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleApiSource getGoogleApiSource(String name) {
    GetGoogleApiSourceRequest request =
        GetGoogleApiSourceRequest.newBuilder().setName(name).build();
    return getGoogleApiSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetGoogleApiSourceRequest request =
   *       GetGoogleApiSourceRequest.newBuilder()
   *           .setName(
   *               GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]")
   *                   .toString())
   *           .build();
   *   GoogleApiSource response = eventarcClient.getGoogleApiSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GoogleApiSource getGoogleApiSource(GetGoogleApiSourceRequest request) {
    return getGoogleApiSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetGoogleApiSourceRequest request =
   *       GetGoogleApiSourceRequest.newBuilder()
   *           .setName(
   *               GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GoogleApiSource> future =
   *       eventarcClient.getGoogleApiSourceCallable().futureCall(request);
   *   // Do something.
   *   GoogleApiSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceCallable() {
    return stub.getGoogleApiSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List GoogleApiSources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (GoogleApiSource element : eventarcClient.listGoogleApiSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list GoogleApiSources on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleApiSourcesPagedResponse listGoogleApiSources(LocationName parent) {
    ListGoogleApiSourcesRequest request =
        ListGoogleApiSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGoogleApiSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List GoogleApiSources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (GoogleApiSource element : eventarcClient.listGoogleApiSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list GoogleApiSources on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleApiSourcesPagedResponse listGoogleApiSources(String parent) {
    ListGoogleApiSourcesRequest request =
        ListGoogleApiSourcesRequest.newBuilder().setParent(parent).build();
    return listGoogleApiSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List GoogleApiSources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListGoogleApiSourcesRequest request =
   *       ListGoogleApiSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (GoogleApiSource element : eventarcClient.listGoogleApiSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGoogleApiSourcesPagedResponse listGoogleApiSources(
      ListGoogleApiSourcesRequest request) {
    return listGoogleApiSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List GoogleApiSources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListGoogleApiSourcesRequest request =
   *       ListGoogleApiSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<GoogleApiSource> future =
   *       eventarcClient.listGoogleApiSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GoogleApiSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesPagedCallable() {
    return stub.listGoogleApiSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List GoogleApiSources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListGoogleApiSourcesRequest request =
   *       ListGoogleApiSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListGoogleApiSourcesResponse response =
   *         eventarcClient.listGoogleApiSourcesCallable().call(request);
   *     for (GoogleApiSource element : response.getGoogleApiSourcesList()) {
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
  public final UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse>
      listGoogleApiSourcesCallable() {
    return stub.listGoogleApiSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new GoogleApiSource in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
   *   String googleApiSourceId = "googleApiSourceId-1417062697";
   *   GoogleApiSource response =
   *       eventarcClient
   *           .createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this google api source.
   * @param googleApiSource Required. The google api source to create.
   * @param googleApiSourceId Required. The user-provided ID to be assigned to the GoogleApiSource.
   *     It should match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> createGoogleApiSourceAsync(
      LocationName parent, GoogleApiSource googleApiSource, String googleApiSourceId) {
    CreateGoogleApiSourceRequest request =
        CreateGoogleApiSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGoogleApiSource(googleApiSource)
            .setGoogleApiSourceId(googleApiSourceId)
            .build();
    return createGoogleApiSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new GoogleApiSource in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
   *   String googleApiSourceId = "googleApiSourceId-1417062697";
   *   GoogleApiSource response =
   *       eventarcClient
   *           .createGoogleApiSourceAsync(parent, googleApiSource, googleApiSourceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this google api source.
   * @param googleApiSource Required. The google api source to create.
   * @param googleApiSourceId Required. The user-provided ID to be assigned to the GoogleApiSource.
   *     It should match the format (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> createGoogleApiSourceAsync(
      String parent, GoogleApiSource googleApiSource, String googleApiSourceId) {
    CreateGoogleApiSourceRequest request =
        CreateGoogleApiSourceRequest.newBuilder()
            .setParent(parent)
            .setGoogleApiSource(googleApiSource)
            .setGoogleApiSourceId(googleApiSourceId)
            .build();
    return createGoogleApiSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new GoogleApiSource in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateGoogleApiSourceRequest request =
   *       CreateGoogleApiSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setGoogleApiSourceId("googleApiSourceId-1417062697")
   *           .setValidateOnly(true)
   *           .build();
   *   GoogleApiSource response = eventarcClient.createGoogleApiSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> createGoogleApiSourceAsync(
      CreateGoogleApiSourceRequest request) {
    return createGoogleApiSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new GoogleApiSource in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateGoogleApiSourceRequest request =
   *       CreateGoogleApiSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setGoogleApiSourceId("googleApiSourceId-1417062697")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<GoogleApiSource, OperationMetadata> future =
   *       eventarcClient.createGoogleApiSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   GoogleApiSource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationCallable() {
    return stub.createGoogleApiSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new GoogleApiSource in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateGoogleApiSourceRequest request =
   *       CreateGoogleApiSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setGoogleApiSourceId("googleApiSourceId-1417062697")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.createGoogleApiSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceCallable() {
    return stub.createGoogleApiSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GoogleApiSource googleApiSource = GoogleApiSource.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GoogleApiSource response =
   *       eventarcClient.updateGoogleApiSourceAsync(googleApiSource, updateMask).get();
   * }
   * }</pre>
   *
   * @param googleApiSource Required. The GoogleApiSource to be updated.
   * @param updateMask Optional. The fields to be updated; only fields explicitly provided are
   *     updated. If no field mask is provided, all provided fields in the request are updated. To
   *     update all fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> updateGoogleApiSourceAsync(
      GoogleApiSource googleApiSource, FieldMask updateMask) {
    UpdateGoogleApiSourceRequest request =
        UpdateGoogleApiSourceRequest.newBuilder()
            .setGoogleApiSource(googleApiSource)
            .setUpdateMask(updateMask)
            .build();
    return updateGoogleApiSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateGoogleApiSourceRequest request =
   *       UpdateGoogleApiSourceRequest.newBuilder()
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   GoogleApiSource response = eventarcClient.updateGoogleApiSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> updateGoogleApiSourceAsync(
      UpdateGoogleApiSourceRequest request) {
    return updateGoogleApiSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateGoogleApiSourceRequest request =
   *       UpdateGoogleApiSourceRequest.newBuilder()
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<GoogleApiSource, OperationMetadata> future =
   *       eventarcClient.updateGoogleApiSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   GoogleApiSource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationCallable() {
    return stub.updateGoogleApiSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateGoogleApiSourceRequest request =
   *       UpdateGoogleApiSourceRequest.newBuilder()
   *           .setGoogleApiSource(GoogleApiSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.updateGoogleApiSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceCallable() {
    return stub.updateGoogleApiSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GoogleApiSourceName name =
   *       GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]");
   *   String etag = "etag3123477";
   *   GoogleApiSource response = eventarcClient.deleteGoogleApiSourceAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the GoogleApiSource to be deleted.
   * @param etag Optional. If provided, the MessageBus will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> deleteGoogleApiSourceAsync(
      GoogleApiSourceName name, String etag) {
    DeleteGoogleApiSourceRequest request =
        DeleteGoogleApiSourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setEtag(etag)
            .build();
    return deleteGoogleApiSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]").toString();
   *   String etag = "etag3123477";
   *   GoogleApiSource response = eventarcClient.deleteGoogleApiSourceAsync(name, etag).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the GoogleApiSource to be deleted.
   * @param etag Optional. If provided, the MessageBus will only be deleted if the etag matches the
   *     current etag on the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> deleteGoogleApiSourceAsync(
      String name, String etag) {
    DeleteGoogleApiSourceRequest request =
        DeleteGoogleApiSourceRequest.newBuilder().setName(name).setEtag(etag).build();
    return deleteGoogleApiSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteGoogleApiSourceRequest request =
   *       DeleteGoogleApiSourceRequest.newBuilder()
   *           .setName(
   *               GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   GoogleApiSource response = eventarcClient.deleteGoogleApiSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GoogleApiSource, OperationMetadata> deleteGoogleApiSourceAsync(
      DeleteGoogleApiSourceRequest request) {
    return deleteGoogleApiSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteGoogleApiSourceRequest request =
   *       DeleteGoogleApiSourceRequest.newBuilder()
   *           .setName(
   *               GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<GoogleApiSource, OperationMetadata> future =
   *       eventarcClient.deleteGoogleApiSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   GoogleApiSource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationCallable() {
    return stub.deleteGoogleApiSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single GoogleApiSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteGoogleApiSourceRequest request =
   *       DeleteGoogleApiSourceRequest.newBuilder()
   *           .setName(
   *               GoogleApiSourceName.of("[PROJECT]", "[LOCATION]", "[GOOGLE_API_SOURCE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.deleteGoogleApiSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceCallable() {
    return stub.deleteGoogleApiSourceCallable();
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : eventarcClient.listLocations(request).iterateAll()) {
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = eventarcClient.listLocationsPagedCallable().futureCall(request);
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = eventarcClient.listLocationsCallable().call(request);
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = eventarcClient.getLocation(request);
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = eventarcClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = eventarcClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = eventarcClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = eventarcClient.getIamPolicy(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = eventarcClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = eventarcClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       eventarcClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListTriggersPagedResponse
      extends AbstractPagedListResponse<
          ListTriggersRequest,
          ListTriggersResponse,
          Trigger,
          ListTriggersPage,
          ListTriggersFixedSizeCollection> {

    public static ApiFuture<ListTriggersPagedResponse> createAsync(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ApiFuture<ListTriggersResponse> futureResponse) {
      ApiFuture<ListTriggersPage> futurePage =
          ListTriggersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTriggersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTriggersPagedResponse(ListTriggersPage page) {
      super(page, ListTriggersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTriggersPage
      extends AbstractPage<ListTriggersRequest, ListTriggersResponse, Trigger, ListTriggersPage> {

    private ListTriggersPage(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ListTriggersResponse response) {
      super(context, response);
    }

    private static ListTriggersPage createEmptyPage() {
      return new ListTriggersPage(null, null);
    }

    @Override
    protected ListTriggersPage createPage(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ListTriggersResponse response) {
      return new ListTriggersPage(context, response);
    }

    @Override
    public ApiFuture<ListTriggersPage> createPageAsync(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ApiFuture<ListTriggersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTriggersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTriggersRequest,
          ListTriggersResponse,
          Trigger,
          ListTriggersPage,
          ListTriggersFixedSizeCollection> {

    private ListTriggersFixedSizeCollection(List<ListTriggersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTriggersFixedSizeCollection createEmptyCollection() {
      return new ListTriggersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTriggersFixedSizeCollection createCollection(
        List<ListTriggersPage> pages, int collectionSize) {
      return new ListTriggersFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListProvidersPagedResponse
      extends AbstractPagedListResponse<
          ListProvidersRequest,
          ListProvidersResponse,
          Provider,
          ListProvidersPage,
          ListProvidersFixedSizeCollection> {

    public static ApiFuture<ListProvidersPagedResponse> createAsync(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ApiFuture<ListProvidersResponse> futureResponse) {
      ApiFuture<ListProvidersPage> futurePage =
          ListProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProvidersPagedResponse(ListProvidersPage page) {
      super(page, ListProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProvidersPage
      extends AbstractPage<
          ListProvidersRequest, ListProvidersResponse, Provider, ListProvidersPage> {

    private ListProvidersPage(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ListProvidersResponse response) {
      super(context, response);
    }

    private static ListProvidersPage createEmptyPage() {
      return new ListProvidersPage(null, null);
    }

    @Override
    protected ListProvidersPage createPage(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ListProvidersResponse response) {
      return new ListProvidersPage(context, response);
    }

    @Override
    public ApiFuture<ListProvidersPage> createPageAsync(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ApiFuture<ListProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProvidersRequest,
          ListProvidersResponse,
          Provider,
          ListProvidersPage,
          ListProvidersFixedSizeCollection> {

    private ListProvidersFixedSizeCollection(List<ListProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProvidersFixedSizeCollection createEmptyCollection() {
      return new ListProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProvidersFixedSizeCollection createCollection(
        List<ListProvidersPage> pages, int collectionSize) {
      return new ListProvidersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage,
          ListChannelConnectionsFixedSizeCollection> {

    public static ApiFuture<ListChannelConnectionsPagedResponse> createAsync(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ApiFuture<ListChannelConnectionsResponse> futureResponse) {
      ApiFuture<ListChannelConnectionsPage> futurePage =
          ListChannelConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelConnectionsPagedResponse(ListChannelConnectionsPage page) {
      super(page, ListChannelConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelConnectionsPage
      extends AbstractPage<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage> {

    private ListChannelConnectionsPage(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ListChannelConnectionsResponse response) {
      super(context, response);
    }

    private static ListChannelConnectionsPage createEmptyPage() {
      return new ListChannelConnectionsPage(null, null);
    }

    @Override
    protected ListChannelConnectionsPage createPage(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ListChannelConnectionsResponse response) {
      return new ListChannelConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelConnectionsPage> createPageAsync(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ApiFuture<ListChannelConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage,
          ListChannelConnectionsFixedSizeCollection> {

    private ListChannelConnectionsFixedSizeCollection(
        List<ListChannelConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListChannelConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelConnectionsFixedSizeCollection createCollection(
        List<ListChannelConnectionsPage> pages, int collectionSize) {
      return new ListChannelConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMessageBusesPagedResponse
      extends AbstractPagedListResponse<
          ListMessageBusesRequest,
          ListMessageBusesResponse,
          MessageBus,
          ListMessageBusesPage,
          ListMessageBusesFixedSizeCollection> {

    public static ApiFuture<ListMessageBusesPagedResponse> createAsync(
        PageContext<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus> context,
        ApiFuture<ListMessageBusesResponse> futureResponse) {
      ApiFuture<ListMessageBusesPage> futurePage =
          ListMessageBusesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMessageBusesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMessageBusesPagedResponse(ListMessageBusesPage page) {
      super(page, ListMessageBusesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMessageBusesPage
      extends AbstractPage<
          ListMessageBusesRequest, ListMessageBusesResponse, MessageBus, ListMessageBusesPage> {

    private ListMessageBusesPage(
        PageContext<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus> context,
        ListMessageBusesResponse response) {
      super(context, response);
    }

    private static ListMessageBusesPage createEmptyPage() {
      return new ListMessageBusesPage(null, null);
    }

    @Override
    protected ListMessageBusesPage createPage(
        PageContext<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus> context,
        ListMessageBusesResponse response) {
      return new ListMessageBusesPage(context, response);
    }

    @Override
    public ApiFuture<ListMessageBusesPage> createPageAsync(
        PageContext<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus> context,
        ApiFuture<ListMessageBusesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMessageBusesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMessageBusesRequest,
          ListMessageBusesResponse,
          MessageBus,
          ListMessageBusesPage,
          ListMessageBusesFixedSizeCollection> {

    private ListMessageBusesFixedSizeCollection(
        List<ListMessageBusesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMessageBusesFixedSizeCollection createEmptyCollection() {
      return new ListMessageBusesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMessageBusesFixedSizeCollection createCollection(
        List<ListMessageBusesPage> pages, int collectionSize) {
      return new ListMessageBusesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMessageBusEnrollmentsPagedResponse
      extends AbstractPagedListResponse<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          String,
          ListMessageBusEnrollmentsPage,
          ListMessageBusEnrollmentsFixedSizeCollection> {

    public static ApiFuture<ListMessageBusEnrollmentsPagedResponse> createAsync(
        PageContext<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
            context,
        ApiFuture<ListMessageBusEnrollmentsResponse> futureResponse) {
      ApiFuture<ListMessageBusEnrollmentsPage> futurePage =
          ListMessageBusEnrollmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMessageBusEnrollmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMessageBusEnrollmentsPagedResponse(ListMessageBusEnrollmentsPage page) {
      super(page, ListMessageBusEnrollmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMessageBusEnrollmentsPage
      extends AbstractPage<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          String,
          ListMessageBusEnrollmentsPage> {

    private ListMessageBusEnrollmentsPage(
        PageContext<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
            context,
        ListMessageBusEnrollmentsResponse response) {
      super(context, response);
    }

    private static ListMessageBusEnrollmentsPage createEmptyPage() {
      return new ListMessageBusEnrollmentsPage(null, null);
    }

    @Override
    protected ListMessageBusEnrollmentsPage createPage(
        PageContext<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
            context,
        ListMessageBusEnrollmentsResponse response) {
      return new ListMessageBusEnrollmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListMessageBusEnrollmentsPage> createPageAsync(
        PageContext<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
            context,
        ApiFuture<ListMessageBusEnrollmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMessageBusEnrollmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          String,
          ListMessageBusEnrollmentsPage,
          ListMessageBusEnrollmentsFixedSizeCollection> {

    private ListMessageBusEnrollmentsFixedSizeCollection(
        List<ListMessageBusEnrollmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMessageBusEnrollmentsFixedSizeCollection createEmptyCollection() {
      return new ListMessageBusEnrollmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMessageBusEnrollmentsFixedSizeCollection createCollection(
        List<ListMessageBusEnrollmentsPage> pages, int collectionSize) {
      return new ListMessageBusEnrollmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEnrollmentsPagedResponse
      extends AbstractPagedListResponse<
          ListEnrollmentsRequest,
          ListEnrollmentsResponse,
          Enrollment,
          ListEnrollmentsPage,
          ListEnrollmentsFixedSizeCollection> {

    public static ApiFuture<ListEnrollmentsPagedResponse> createAsync(
        PageContext<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment> context,
        ApiFuture<ListEnrollmentsResponse> futureResponse) {
      ApiFuture<ListEnrollmentsPage> futurePage =
          ListEnrollmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEnrollmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEnrollmentsPagedResponse(ListEnrollmentsPage page) {
      super(page, ListEnrollmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnrollmentsPage
      extends AbstractPage<
          ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment, ListEnrollmentsPage> {

    private ListEnrollmentsPage(
        PageContext<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment> context,
        ListEnrollmentsResponse response) {
      super(context, response);
    }

    private static ListEnrollmentsPage createEmptyPage() {
      return new ListEnrollmentsPage(null, null);
    }

    @Override
    protected ListEnrollmentsPage createPage(
        PageContext<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment> context,
        ListEnrollmentsResponse response) {
      return new ListEnrollmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListEnrollmentsPage> createPageAsync(
        PageContext<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment> context,
        ApiFuture<ListEnrollmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnrollmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnrollmentsRequest,
          ListEnrollmentsResponse,
          Enrollment,
          ListEnrollmentsPage,
          ListEnrollmentsFixedSizeCollection> {

    private ListEnrollmentsFixedSizeCollection(
        List<ListEnrollmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnrollmentsFixedSizeCollection createEmptyCollection() {
      return new ListEnrollmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnrollmentsFixedSizeCollection createCollection(
        List<ListEnrollmentsPage> pages, int collectionSize) {
      return new ListEnrollmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPipelinesPagedResponse
      extends AbstractPagedListResponse<
          ListPipelinesRequest,
          ListPipelinesResponse,
          Pipeline,
          ListPipelinesPage,
          ListPipelinesFixedSizeCollection> {

    public static ApiFuture<ListPipelinesPagedResponse> createAsync(
        PageContext<ListPipelinesRequest, ListPipelinesResponse, Pipeline> context,
        ApiFuture<ListPipelinesResponse> futureResponse) {
      ApiFuture<ListPipelinesPage> futurePage =
          ListPipelinesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPipelinesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPipelinesPagedResponse(ListPipelinesPage page) {
      super(page, ListPipelinesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPipelinesPage
      extends AbstractPage<
          ListPipelinesRequest, ListPipelinesResponse, Pipeline, ListPipelinesPage> {

    private ListPipelinesPage(
        PageContext<ListPipelinesRequest, ListPipelinesResponse, Pipeline> context,
        ListPipelinesResponse response) {
      super(context, response);
    }

    private static ListPipelinesPage createEmptyPage() {
      return new ListPipelinesPage(null, null);
    }

    @Override
    protected ListPipelinesPage createPage(
        PageContext<ListPipelinesRequest, ListPipelinesResponse, Pipeline> context,
        ListPipelinesResponse response) {
      return new ListPipelinesPage(context, response);
    }

    @Override
    public ApiFuture<ListPipelinesPage> createPageAsync(
        PageContext<ListPipelinesRequest, ListPipelinesResponse, Pipeline> context,
        ApiFuture<ListPipelinesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPipelinesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPipelinesRequest,
          ListPipelinesResponse,
          Pipeline,
          ListPipelinesPage,
          ListPipelinesFixedSizeCollection> {

    private ListPipelinesFixedSizeCollection(List<ListPipelinesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPipelinesFixedSizeCollection createEmptyCollection() {
      return new ListPipelinesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPipelinesFixedSizeCollection createCollection(
        List<ListPipelinesPage> pages, int collectionSize) {
      return new ListPipelinesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGoogleApiSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          GoogleApiSource,
          ListGoogleApiSourcesPage,
          ListGoogleApiSourcesFixedSizeCollection> {

    public static ApiFuture<ListGoogleApiSourcesPagedResponse> createAsync(
        PageContext<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
            context,
        ApiFuture<ListGoogleApiSourcesResponse> futureResponse) {
      ApiFuture<ListGoogleApiSourcesPage> futurePage =
          ListGoogleApiSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGoogleApiSourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGoogleApiSourcesPagedResponse(ListGoogleApiSourcesPage page) {
      super(page, ListGoogleApiSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGoogleApiSourcesPage
      extends AbstractPage<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          GoogleApiSource,
          ListGoogleApiSourcesPage> {

    private ListGoogleApiSourcesPage(
        PageContext<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
            context,
        ListGoogleApiSourcesResponse response) {
      super(context, response);
    }

    private static ListGoogleApiSourcesPage createEmptyPage() {
      return new ListGoogleApiSourcesPage(null, null);
    }

    @Override
    protected ListGoogleApiSourcesPage createPage(
        PageContext<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
            context,
        ListGoogleApiSourcesResponse response) {
      return new ListGoogleApiSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListGoogleApiSourcesPage> createPageAsync(
        PageContext<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
            context,
        ApiFuture<ListGoogleApiSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGoogleApiSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          GoogleApiSource,
          ListGoogleApiSourcesPage,
          ListGoogleApiSourcesFixedSizeCollection> {

    private ListGoogleApiSourcesFixedSizeCollection(
        List<ListGoogleApiSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGoogleApiSourcesFixedSizeCollection createEmptyCollection() {
      return new ListGoogleApiSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGoogleApiSourcesFixedSizeCollection createCollection(
        List<ListGoogleApiSourcesPage> pages, int collectionSize) {
      return new ListGoogleApiSourcesFixedSizeCollection(pages, collectionSize);
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
