/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.edgenetwork.v1;

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
import com.google.cloud.edgenetwork.v1.stub.EdgeNetworkStub;
import com.google.cloud.edgenetwork.v1.stub.EdgeNetworkStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Service Description: EdgeNetwork API provides managed, highly available cloud dynamic network
 * configuration service to the GEC customer to enable edge application and network function
 * solutions. This allows the customers to easily define and configure the network setup and
 * property to meet the workload requirement.
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
 * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
 *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
 *   InitializeZoneResponse response = edgeNetworkClient.initializeZone(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EdgeNetworkClient object to clean up resources such as
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
 *      <td><p> InitializeZone</td>
 *      <td><p> InitializeZone will initialize resources for a zone in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> initializeZone(InitializeZoneRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> initializeZone(ZoneName name)
 *           <li><p> initializeZone(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> initializeZoneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListZones</td>
 *      <td><p> Lists Zones in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listZones(ListZonesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listZones(LocationName parent)
 *           <li><p> listZones(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listZonesPagedCallable()
 *           <li><p> listZonesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetZone</td>
 *      <td><p> Gets details of a single Zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getZone(GetZoneRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getZone(ZoneName name)
 *           <li><p> getZone(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getZoneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNetworks</td>
 *      <td><p> Lists Networks in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNetworks(ListNetworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNetworks(ZoneName parent)
 *           <li><p> listNetworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNetworksPagedCallable()
 *           <li><p> listNetworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNetwork</td>
 *      <td><p> Gets details of a single Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNetwork(GetNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNetwork(NetworkName name)
 *           <li><p> getNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiagnoseNetwork</td>
 *      <td><p> Get the diagnostics of a single network resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> diagnoseNetwork(DiagnoseNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> diagnoseNetwork(NetworkName name)
 *           <li><p> diagnoseNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> diagnoseNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNetwork</td>
 *      <td><p> Creates a new Network in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNetworkAsync(CreateNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNetworkAsync(ZoneName parent, Network network, String networkId)
 *           <li><p> createNetworkAsync(String parent, Network network, String networkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNetworkOperationCallable()
 *           <li><p> createNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNetwork</td>
 *      <td><p> Deletes a single Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNetworkAsync(DeleteNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkAsync(NetworkName name)
 *           <li><p> deleteNetworkAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNetworkOperationCallable()
 *           <li><p> deleteNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSubnets</td>
 *      <td><p> Lists Subnets in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSubnets(ListSubnetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSubnets(ZoneName parent)
 *           <li><p> listSubnets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSubnetsPagedCallable()
 *           <li><p> listSubnetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSubnet</td>
 *      <td><p> Gets details of a single Subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSubnet(GetSubnetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSubnet(SubnetName name)
 *           <li><p> getSubnet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSubnet</td>
 *      <td><p> Creates a new Subnet in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSubnetAsync(CreateSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSubnetAsync(ZoneName parent, Subnet subnet, String subnetId)
 *           <li><p> createSubnetAsync(String parent, Subnet subnet, String subnetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSubnetOperationCallable()
 *           <li><p> createSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSubnet</td>
 *      <td><p> Updates the parameters of a single Subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSubnetAsync(UpdateSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSubnetAsync(Subnet subnet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSubnetOperationCallable()
 *           <li><p> updateSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSubnet</td>
 *      <td><p> Deletes a single Subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSubnetAsync(DeleteSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSubnetAsync(SubnetName name)
 *           <li><p> deleteSubnetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSubnetOperationCallable()
 *           <li><p> deleteSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInterconnects</td>
 *      <td><p> Lists Interconnects in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterconnects(ListInterconnectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterconnects(ZoneName parent)
 *           <li><p> listInterconnects(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterconnectsPagedCallable()
 *           <li><p> listInterconnectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterconnect</td>
 *      <td><p> Gets details of a single Interconnect.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterconnect(GetInterconnectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterconnect(InterconnectName name)
 *           <li><p> getInterconnect(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterconnectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiagnoseInterconnect</td>
 *      <td><p> Get the diagnostics of a single interconnect resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> diagnoseInterconnect(DiagnoseInterconnectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> diagnoseInterconnect(InterconnectName name)
 *           <li><p> diagnoseInterconnect(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> diagnoseInterconnectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListInterconnectAttachments</td>
 *      <td><p> Lists InterconnectAttachments in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInterconnectAttachments(ListInterconnectAttachmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInterconnectAttachments(ZoneName parent)
 *           <li><p> listInterconnectAttachments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInterconnectAttachmentsPagedCallable()
 *           <li><p> listInterconnectAttachmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInterconnectAttachment</td>
 *      <td><p> Gets details of a single InterconnectAttachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInterconnectAttachment(GetInterconnectAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInterconnectAttachment(InterconnectAttachmentName name)
 *           <li><p> getInterconnectAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInterconnectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateInterconnectAttachment</td>
 *      <td><p> Creates a new InterconnectAttachment in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInterconnectAttachmentAsync(CreateInterconnectAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInterconnectAttachmentAsync(ZoneName parent, InterconnectAttachment interconnectAttachment, String interconnectAttachmentId)
 *           <li><p> createInterconnectAttachmentAsync(String parent, InterconnectAttachment interconnectAttachment, String interconnectAttachmentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInterconnectAttachmentOperationCallable()
 *           <li><p> createInterconnectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteInterconnectAttachment</td>
 *      <td><p> Deletes a single InterconnectAttachment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInterconnectAttachmentAsync(DeleteInterconnectAttachmentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInterconnectAttachmentAsync(InterconnectAttachmentName name)
 *           <li><p> deleteInterconnectAttachmentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInterconnectAttachmentOperationCallable()
 *           <li><p> deleteInterconnectAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRouters</td>
 *      <td><p> Lists Routers in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRouters(ListRoutersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRouters(ZoneName parent)
 *           <li><p> listRouters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRoutersPagedCallable()
 *           <li><p> listRoutersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRouter</td>
 *      <td><p> Gets details of a single Router.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRouter(GetRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRouter(RouterName name)
 *           <li><p> getRouter(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRouterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DiagnoseRouter</td>
 *      <td><p> Get the diagnostics of a single router resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> diagnoseRouter(DiagnoseRouterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> diagnoseRouter(RouterName name)
 *           <li><p> diagnoseRouter(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> diagnoseRouterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRouter</td>
 *      <td><p> Creates a new Router in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRouterAsync(CreateRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRouterAsync(ZoneName parent, Router router, String routerId)
 *           <li><p> createRouterAsync(String parent, Router router, String routerId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRouterOperationCallable()
 *           <li><p> createRouterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRouter</td>
 *      <td><p> Updates the parameters of a single Router.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRouterAsync(UpdateRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRouterAsync(Router router, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRouterOperationCallable()
 *           <li><p> updateRouterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRouter</td>
 *      <td><p> Deletes a single Router.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRouterAsync(DeleteRouterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRouterAsync(RouterName name)
 *           <li><p> deleteRouterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRouterOperationCallable()
 *           <li><p> deleteRouterCallable()
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
 * <p>This class can be customized by passing in a custom instance of EdgeNetworkSettings to
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
 * EdgeNetworkSettings edgeNetworkSettings =
 *     EdgeNetworkSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create(edgeNetworkSettings);
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
 * EdgeNetworkSettings edgeNetworkSettings =
 *     EdgeNetworkSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create(edgeNetworkSettings);
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
 * EdgeNetworkSettings edgeNetworkSettings = EdgeNetworkSettings.newHttpJsonBuilder().build();
 * EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create(edgeNetworkSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EdgeNetworkClient implements BackgroundResource {
  private final EdgeNetworkSettings settings;
  private final EdgeNetworkStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EdgeNetworkClient with default settings. */
  public static final EdgeNetworkClient create() throws IOException {
    return create(EdgeNetworkSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EdgeNetworkClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EdgeNetworkClient create(EdgeNetworkSettings settings) throws IOException {
    return new EdgeNetworkClient(settings);
  }

  /**
   * Constructs an instance of EdgeNetworkClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(EdgeNetworkSettings).
   */
  public static final EdgeNetworkClient create(EdgeNetworkStub stub) {
    return new EdgeNetworkClient(stub);
  }

  /**
   * Constructs an instance of EdgeNetworkClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EdgeNetworkClient(EdgeNetworkSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EdgeNetworkStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EdgeNetworkClient(EdgeNetworkStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EdgeNetworkSettings getSettings() {
    return settings;
  }

  public EdgeNetworkStub getStub() {
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
   * InitializeZone will initialize resources for a zone in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   InitializeZoneResponse response = edgeNetworkClient.initializeZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InitializeZoneResponse initializeZone(ZoneName name) {
    InitializeZoneRequest request =
        InitializeZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return initializeZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * InitializeZone will initialize resources for a zone in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   InitializeZoneResponse response = edgeNetworkClient.initializeZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InitializeZoneResponse initializeZone(String name) {
    InitializeZoneRequest request = InitializeZoneRequest.newBuilder().setName(name).build();
    return initializeZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * InitializeZone will initialize resources for a zone in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InitializeZoneRequest request =
   *       InitializeZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   InitializeZoneResponse response = edgeNetworkClient.initializeZone(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InitializeZoneResponse initializeZone(InitializeZoneRequest request) {
    return initializeZoneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * InitializeZone will initialize resources for a zone in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InitializeZoneRequest request =
   *       InitializeZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   ApiFuture<InitializeZoneResponse> future =
   *       edgeNetworkClient.initializeZoneCallable().futureCall(request);
   *   // Do something.
   *   InitializeZoneResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InitializeZoneRequest, InitializeZoneResponse>
      initializeZoneCallable() {
    return stub.initializeZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Zone element : edgeNetworkClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListZonesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(LocationName parent) {
    ListZonesRequest request =
        ListZonesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Zone element : edgeNetworkClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListZonesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(String parent) {
    ListZonesRequest request = ListZonesRequest.newBuilder().setParent(parent).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Zone element : edgeNetworkClient.listZones(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(ListZonesRequest request) {
    return listZonesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Zone> future = edgeNetworkClient.listZonesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Zone element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return stub.listZonesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListZonesResponse response = edgeNetworkClient.listZonesCallable().call(request);
   *     for (Zone element : response.getZonesList()) {
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
  public final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return stub.listZonesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   Zone response = edgeNetworkClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(ZoneName name) {
    GetZoneRequest request =
        GetZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   Zone response = edgeNetworkClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(String name) {
    GetZoneRequest request = GetZoneRequest.newBuilder().setName(name).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   Zone response = edgeNetworkClient.getZone(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(GetZoneRequest request) {
    return getZoneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   ApiFuture<Zone> future = edgeNetworkClient.getZoneCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return stub.getZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   for (Network element : edgeNetworkClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(ZoneName parent) {
    ListNetworksRequest request =
        ListNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   for (Network element : edgeNetworkClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(String parent) {
    ListNetworksRequest request = ListNetworksRequest.newBuilder().setParent(parent).build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Network element : edgeNetworkClient.listNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(ListNetworksRequest request) {
    return listNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Network> future = edgeNetworkClient.listNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Network element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable() {
    return stub.listNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNetworksResponse response = edgeNetworkClient.listNetworksCallable().call(request);
   *     for (Network element : response.getNetworksList()) {
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
  public final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return stub.listNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
   *   Network response = edgeNetworkClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(NetworkName name) {
    GetNetworkRequest request =
        GetNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString();
   *   Network response = edgeNetworkClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(String name) {
    GetNetworkRequest request = GetNetworkRequest.newBuilder().setName(name).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .build();
   *   Network response = edgeNetworkClient.getNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(GetNetworkRequest request) {
    return getNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .build();
   *   ApiFuture<Network> future = edgeNetworkClient.getNetworkCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return stub.getNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single network resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
   *   DiagnoseNetworkResponse response = edgeNetworkClient.diagnoseNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the network resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseNetworkResponse diagnoseNetwork(NetworkName name) {
    DiagnoseNetworkRequest request =
        DiagnoseNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return diagnoseNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single network resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString();
   *   DiagnoseNetworkResponse response = edgeNetworkClient.diagnoseNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the network resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseNetworkResponse diagnoseNetwork(String name) {
    DiagnoseNetworkRequest request = DiagnoseNetworkRequest.newBuilder().setName(name).build();
    return diagnoseNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single network resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseNetworkRequest request =
   *       DiagnoseNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .build();
   *   DiagnoseNetworkResponse response = edgeNetworkClient.diagnoseNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseNetworkResponse diagnoseNetwork(DiagnoseNetworkRequest request) {
    return diagnoseNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single network resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseNetworkRequest request =
   *       DiagnoseNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .build();
   *   ApiFuture<DiagnoseNetworkResponse> future =
   *       edgeNetworkClient.diagnoseNetworkCallable().futureCall(request);
   *   // Do something.
   *   DiagnoseNetworkResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiagnoseNetworkRequest, DiagnoseNetworkResponse>
      diagnoseNetworkCallable() {
    return stub.diagnoseNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   Network network = Network.newBuilder().build();
   *   String networkId = "networkId2062782441";
   *   Network response = edgeNetworkClient.createNetworkAsync(parent, network, networkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param network Required. The resource being created
   * @param networkId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and network_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> createNetworkAsync(
      ZoneName parent, Network network, String networkId) {
    CreateNetworkRequest request =
        CreateNetworkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNetwork(network)
            .setNetworkId(networkId)
            .build();
    return createNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   Network network = Network.newBuilder().build();
   *   String networkId = "networkId2062782441";
   *   Network response = edgeNetworkClient.createNetworkAsync(parent, network, networkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param network Required. The resource being created
   * @param networkId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and network_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> createNetworkAsync(
      String parent, Network network, String networkId) {
    CreateNetworkRequest request =
        CreateNetworkRequest.newBuilder()
            .setParent(parent)
            .setNetwork(network)
            .setNetworkId(networkId)
            .build();
    return createNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateNetworkRequest request =
   *       CreateNetworkRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setNetworkId("networkId2062782441")
   *           .setNetwork(Network.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Network response = edgeNetworkClient.createNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> createNetworkAsync(
      CreateNetworkRequest request) {
    return createNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateNetworkRequest request =
   *       CreateNetworkRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setNetworkId("networkId2062782441")
   *           .setNetwork(Network.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Network, OperationMetadata> future =
   *       edgeNetworkClient.createNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNetworkRequest, Network, OperationMetadata>
      createNetworkOperationCallable() {
    return stub.createNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateNetworkRequest request =
   *       CreateNetworkRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setNetworkId("networkId2062782441")
   *           .setNetwork(Network.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.createNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNetworkRequest, Operation> createNetworkCallable() {
    return stub.createNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]");
   *   edgeNetworkClient.deleteNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkAsync(NetworkName name) {
    DeleteNetworkRequest request =
        DeleteNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString();
   *   edgeNetworkClient.deleteNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkAsync(String name) {
    DeleteNetworkRequest request = DeleteNetworkRequest.newBuilder().setName(name).build();
    return deleteNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteNetworkRequest request =
   *       DeleteNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   edgeNetworkClient.deleteNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNetworkAsync(
      DeleteNetworkRequest request) {
    return deleteNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteNetworkRequest request =
   *       DeleteNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       edgeNetworkClient.deleteNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNetworkRequest, Empty, OperationMetadata>
      deleteNetworkOperationCallable() {
    return stub.deleteNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteNetworkRequest request =
   *       DeleteNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.deleteNetworkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNetworkRequest, Operation> deleteNetworkCallable() {
    return stub.deleteNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Subnets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   for (Subnet element : edgeNetworkClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSubnetsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(ZoneName parent) {
    ListSubnetsRequest request =
        ListSubnetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Subnets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   for (Subnet element : edgeNetworkClient.listSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSubnetsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(String parent) {
    ListSubnetsRequest request = ListSubnetsRequest.newBuilder().setParent(parent).build();
    return listSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Subnets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Subnet element : edgeNetworkClient.listSubnets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubnetsPagedResponse listSubnets(ListSubnetsRequest request) {
    return listSubnetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Subnets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Subnet> future = edgeNetworkClient.listSubnetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Subnet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsPagedResponse>
      listSubnetsPagedCallable() {
    return stub.listSubnetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Subnets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListSubnetsRequest request =
   *       ListSubnetsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSubnetsResponse response = edgeNetworkClient.listSubnetsCallable().call(request);
   *     for (Subnet element : response.getSubnetsList()) {
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
  public final UnaryCallable<ListSubnetsRequest, ListSubnetsResponse> listSubnetsCallable() {
    return stub.listSubnetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");
   *   Subnet response = edgeNetworkClient.getSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(SubnetName name) {
    GetSubnetRequest request =
        GetSubnetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString();
   *   Subnet response = edgeNetworkClient.getSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(String name) {
    GetSubnetRequest request = GetSubnetRequest.newBuilder().setName(name).build();
    return getSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetSubnetRequest request =
   *       GetSubnetRequest.newBuilder()
   *           .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
   *           .build();
   *   Subnet response = edgeNetworkClient.getSubnet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Subnet getSubnet(GetSubnetRequest request) {
    return getSubnetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetSubnetRequest request =
   *       GetSubnetRequest.newBuilder()
   *           .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
   *           .build();
   *   ApiFuture<Subnet> future = edgeNetworkClient.getSubnetCallable().futureCall(request);
   *   // Do something.
   *   Subnet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSubnetRequest, Subnet> getSubnetCallable() {
    return stub.getSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Subnet in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   Subnet subnet = Subnet.newBuilder().build();
   *   String subnetId = "subnetId-2066159272";
   *   Subnet response = edgeNetworkClient.createSubnetAsync(parent, subnet, subnetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param subnet Required. The resource being created
   * @param subnetId Required. Id of the requesting object If auto-generating Id server-side, remove
   *     this field and subnet_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> createSubnetAsync(
      ZoneName parent, Subnet subnet, String subnetId) {
    CreateSubnetRequest request =
        CreateSubnetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSubnet(subnet)
            .setSubnetId(subnetId)
            .build();
    return createSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Subnet in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   Subnet subnet = Subnet.newBuilder().build();
   *   String subnetId = "subnetId-2066159272";
   *   Subnet response = edgeNetworkClient.createSubnetAsync(parent, subnet, subnetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param subnet Required. The resource being created
   * @param subnetId Required. Id of the requesting object If auto-generating Id server-side, remove
   *     this field and subnet_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> createSubnetAsync(
      String parent, Subnet subnet, String subnetId) {
    CreateSubnetRequest request =
        CreateSubnetRequest.newBuilder()
            .setParent(parent)
            .setSubnet(subnet)
            .setSubnetId(subnetId)
            .build();
    return createSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Subnet in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateSubnetRequest request =
   *       CreateSubnetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setSubnetId("subnetId-2066159272")
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Subnet response = edgeNetworkClient.createSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> createSubnetAsync(
      CreateSubnetRequest request) {
    return createSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Subnet in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateSubnetRequest request =
   *       CreateSubnetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setSubnetId("subnetId-2066159272")
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Subnet, OperationMetadata> future =
   *       edgeNetworkClient.createSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   Subnet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSubnetRequest, Subnet, OperationMetadata>
      createSubnetOperationCallable() {
    return stub.createSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Subnet in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateSubnetRequest request =
   *       CreateSubnetRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setSubnetId("subnetId-2066159272")
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.createSubnetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubnetRequest, Operation> createSubnetCallable() {
    return stub.createSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   Subnet subnet = Subnet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Subnet response = edgeNetworkClient.updateSubnetAsync(subnet, updateMask).get();
   * }
   * }</pre>
   *
   * @param subnet Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Subnet resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> updateSubnetAsync(
      Subnet subnet, FieldMask updateMask) {
    UpdateSubnetRequest request =
        UpdateSubnetRequest.newBuilder().setSubnet(subnet).setUpdateMask(updateMask).build();
    return updateSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Subnet response = edgeNetworkClient.updateSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Subnet, OperationMetadata> updateSubnetAsync(
      UpdateSubnetRequest request) {
    return updateSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Subnet, OperationMetadata> future =
   *       edgeNetworkClient.updateSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   Subnet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSubnetRequest, Subnet, OperationMetadata>
      updateSubnetOperationCallable() {
    return stub.updateSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateSubnetRequest request =
   *       UpdateSubnetRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSubnet(Subnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.updateSubnetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSubnetRequest, Operation> updateSubnetCallable() {
    return stub.updateSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   SubnetName name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]");
   *   edgeNetworkClient.deleteSubnetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubnetAsync(SubnetName name) {
    DeleteSubnetRequest request =
        DeleteSubnetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString();
   *   edgeNetworkClient.deleteSubnetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubnetAsync(String name) {
    DeleteSubnetRequest request = DeleteSubnetRequest.newBuilder().setName(name).build();
    return deleteSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteSubnetRequest request =
   *       DeleteSubnetRequest.newBuilder()
   *           .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   edgeNetworkClient.deleteSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSubnetAsync(
      DeleteSubnetRequest request) {
    return deleteSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteSubnetRequest request =
   *       DeleteSubnetRequest.newBuilder()
   *           .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       edgeNetworkClient.deleteSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSubnetRequest, Empty, OperationMetadata>
      deleteSubnetOperationCallable() {
    return stub.deleteSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteSubnetRequest request =
   *       DeleteSubnetRequest.newBuilder()
   *           .setName(SubnetName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[SUBNET]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.deleteSubnetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSubnetRequest, Operation> deleteSubnetCallable() {
    return stub.deleteSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Interconnects in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   for (Interconnect element : edgeNetworkClient.listInterconnects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInterconnectsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectsPagedResponse listInterconnects(ZoneName parent) {
    ListInterconnectsRequest request =
        ListInterconnectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterconnects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Interconnects in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   for (Interconnect element : edgeNetworkClient.listInterconnects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInterconnectsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectsPagedResponse listInterconnects(String parent) {
    ListInterconnectsRequest request =
        ListInterconnectsRequest.newBuilder().setParent(parent).build();
    return listInterconnects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Interconnects in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectsRequest request =
   *       ListInterconnectsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Interconnect element : edgeNetworkClient.listInterconnects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectsPagedResponse listInterconnects(ListInterconnectsRequest request) {
    return listInterconnectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Interconnects in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectsRequest request =
   *       ListInterconnectsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Interconnect> future =
   *       edgeNetworkClient.listInterconnectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Interconnect element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInterconnectsRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    return stub.listInterconnectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Interconnects in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectsRequest request =
   *       ListInterconnectsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterconnectsResponse response =
   *         edgeNetworkClient.listInterconnectsCallable().call(request);
   *     for (Interconnect element : response.getInterconnectsList()) {
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
  public final UnaryCallable<ListInterconnectsRequest, ListInterconnectsResponse>
      listInterconnectsCallable() {
    return stub.listInterconnectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Interconnect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InterconnectName name =
   *       InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");
   *   Interconnect response = edgeNetworkClient.getInterconnect(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Interconnect getInterconnect(InterconnectName name) {
    GetInterconnectRequest request =
        GetInterconnectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Interconnect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name =
   *       InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]").toString();
   *   Interconnect response = edgeNetworkClient.getInterconnect(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Interconnect getInterconnect(String name) {
    GetInterconnectRequest request = GetInterconnectRequest.newBuilder().setName(name).build();
    return getInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Interconnect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetInterconnectRequest request =
   *       GetInterconnectRequest.newBuilder()
   *           .setName(
   *               InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
   *                   .toString())
   *           .build();
   *   Interconnect response = edgeNetworkClient.getInterconnect(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Interconnect getInterconnect(GetInterconnectRequest request) {
    return getInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Interconnect.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetInterconnectRequest request =
   *       GetInterconnectRequest.newBuilder()
   *           .setName(
   *               InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Interconnect> future =
   *       edgeNetworkClient.getInterconnectCallable().futureCall(request);
   *   // Do something.
   *   Interconnect response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterconnectRequest, Interconnect> getInterconnectCallable() {
    return stub.getInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single interconnect resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InterconnectName name =
   *       InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]");
   *   DiagnoseInterconnectResponse response = edgeNetworkClient.diagnoseInterconnect(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the interconnect resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseInterconnectResponse diagnoseInterconnect(InterconnectName name) {
    DiagnoseInterconnectRequest request =
        DiagnoseInterconnectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return diagnoseInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single interconnect resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name =
   *       InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]").toString();
   *   DiagnoseInterconnectResponse response = edgeNetworkClient.diagnoseInterconnect(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the interconnect resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseInterconnectResponse diagnoseInterconnect(String name) {
    DiagnoseInterconnectRequest request =
        DiagnoseInterconnectRequest.newBuilder().setName(name).build();
    return diagnoseInterconnect(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single interconnect resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseInterconnectRequest request =
   *       DiagnoseInterconnectRequest.newBuilder()
   *           .setName(
   *               InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
   *                   .toString())
   *           .build();
   *   DiagnoseInterconnectResponse response = edgeNetworkClient.diagnoseInterconnect(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseInterconnectResponse diagnoseInterconnect(
      DiagnoseInterconnectRequest request) {
    return diagnoseInterconnectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single interconnect resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseInterconnectRequest request =
   *       DiagnoseInterconnectRequest.newBuilder()
   *           .setName(
   *               InterconnectName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiagnoseInterconnectResponse> future =
   *       edgeNetworkClient.diagnoseInterconnectCallable().futureCall(request);
   *   // Do something.
   *   DiagnoseInterconnectResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiagnoseInterconnectRequest, DiagnoseInterconnectResponse>
      diagnoseInterconnectCallable() {
    return stub.diagnoseInterconnectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InterconnectAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   for (InterconnectAttachment element :
   *       edgeNetworkClient.listInterconnectAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInterconnectAttachmentsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(
      ZoneName parent) {
    ListInterconnectAttachmentsRequest request =
        ListInterconnectAttachmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InterconnectAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   for (InterconnectAttachment element :
   *       edgeNetworkClient.listInterconnectAttachments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInterconnectAttachmentsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(String parent) {
    ListInterconnectAttachmentsRequest request =
        ListInterconnectAttachmentsRequest.newBuilder().setParent(parent).build();
    return listInterconnectAttachments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InterconnectAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (InterconnectAttachment element :
   *       edgeNetworkClient.listInterconnectAttachments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInterconnectAttachmentsPagedResponse listInterconnectAttachments(
      ListInterconnectAttachmentsRequest request) {
    return listInterconnectAttachmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InterconnectAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<InterconnectAttachment> future =
   *       edgeNetworkClient.listInterconnectAttachmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InterconnectAttachment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    return stub.listInterconnectAttachmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists InterconnectAttachments in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListInterconnectAttachmentsRequest request =
   *       ListInterconnectAttachmentsRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInterconnectAttachmentsResponse response =
   *         edgeNetworkClient.listInterconnectAttachmentsCallable().call(request);
   *     for (InterconnectAttachment element : response.getInterconnectAttachmentsList()) {
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
  public final UnaryCallable<
          ListInterconnectAttachmentsRequest, ListInterconnectAttachmentsResponse>
      listInterconnectAttachmentsCallable() {
    return stub.listInterconnectAttachmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InterconnectAttachmentName name =
   *       InterconnectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");
   *   InterconnectAttachment response = edgeNetworkClient.getInterconnectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment getInterconnectAttachment(InterconnectAttachmentName name) {
    GetInterconnectAttachmentRequest request =
        GetInterconnectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name =
   *       InterconnectAttachmentName.of(
   *               "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *           .toString();
   *   InterconnectAttachment response = edgeNetworkClient.getInterconnectAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment getInterconnectAttachment(String name) {
    GetInterconnectAttachmentRequest request =
        GetInterconnectAttachmentRequest.newBuilder().setName(name).build();
    return getInterconnectAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetInterconnectAttachmentRequest request =
   *       GetInterconnectAttachmentRequest.newBuilder()
   *           .setName(
   *               InterconnectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   InterconnectAttachment response = edgeNetworkClient.getInterconnectAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectAttachment getInterconnectAttachment(
      GetInterconnectAttachmentRequest request) {
    return getInterconnectAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetInterconnectAttachmentRequest request =
   *       GetInterconnectAttachmentRequest.newBuilder()
   *           .setName(
   *               InterconnectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<InterconnectAttachment> future =
   *       edgeNetworkClient.getInterconnectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   InterconnectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInterconnectAttachmentRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    return stub.getInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InterconnectAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
   *   String interconnectAttachmentId = "interconnectAttachmentId1053538636";
   *   InterconnectAttachment response =
   *       edgeNetworkClient
   *           .createInterconnectAttachmentAsync(
   *               parent, interconnectAttachment, interconnectAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param interconnectAttachment Required. The resource being created
   * @param interconnectAttachmentId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and interconnect_attachment_id from the method_signature of
   *     Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentAsync(
          ZoneName parent,
          InterconnectAttachment interconnectAttachment,
          String interconnectAttachmentId) {
    CreateInterconnectAttachmentRequest request =
        CreateInterconnectAttachmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInterconnectAttachment(interconnectAttachment)
            .setInterconnectAttachmentId(interconnectAttachmentId)
            .build();
    return createInterconnectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InterconnectAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   InterconnectAttachment interconnectAttachment = InterconnectAttachment.newBuilder().build();
   *   String interconnectAttachmentId = "interconnectAttachmentId1053538636";
   *   InterconnectAttachment response =
   *       edgeNetworkClient
   *           .createInterconnectAttachmentAsync(
   *               parent, interconnectAttachment, interconnectAttachmentId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param interconnectAttachment Required. The resource being created
   * @param interconnectAttachmentId Required. Id of the requesting object If auto-generating Id
   *     server-side, remove this field and interconnect_attachment_id from the method_signature of
   *     Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentAsync(
          String parent,
          InterconnectAttachment interconnectAttachment,
          String interconnectAttachmentId) {
    CreateInterconnectAttachmentRequest request =
        CreateInterconnectAttachmentRequest.newBuilder()
            .setParent(parent)
            .setInterconnectAttachment(interconnectAttachment)
            .setInterconnectAttachmentId(interconnectAttachmentId)
            .build();
    return createInterconnectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InterconnectAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateInterconnectAttachmentRequest request =
   *       CreateInterconnectAttachmentRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setInterconnectAttachmentId("interconnectAttachmentId1053538636")
   *           .setInterconnectAttachment(InterconnectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InterconnectAttachment response =
   *       edgeNetworkClient.createInterconnectAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentAsync(CreateInterconnectAttachmentRequest request) {
    return createInterconnectAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InterconnectAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateInterconnectAttachmentRequest request =
   *       CreateInterconnectAttachmentRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setInterconnectAttachmentId("interconnectAttachmentId1053538636")
   *           .setInterconnectAttachment(InterconnectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InterconnectAttachment, OperationMetadata> future =
   *       edgeNetworkClient.createInterconnectAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   InterconnectAttachment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateInterconnectAttachmentRequest, InterconnectAttachment, OperationMetadata>
      createInterconnectAttachmentOperationCallable() {
    return stub.createInterconnectAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new InterconnectAttachment in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateInterconnectAttachmentRequest request =
   *       CreateInterconnectAttachmentRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setInterconnectAttachmentId("interconnectAttachmentId1053538636")
   *           .setInterconnectAttachment(InterconnectAttachment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       edgeNetworkClient.createInterconnectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInterconnectAttachmentRequest, Operation>
      createInterconnectAttachmentCallable() {
    return stub.createInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   InterconnectAttachmentName name =
   *       InterconnectAttachmentName.of(
   *           "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]");
   *   edgeNetworkClient.deleteInterconnectAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterconnectAttachmentAsync(
      InterconnectAttachmentName name) {
    DeleteInterconnectAttachmentRequest request =
        DeleteInterconnectAttachmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteInterconnectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name =
   *       InterconnectAttachmentName.of(
   *               "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *           .toString();
   *   edgeNetworkClient.deleteInterconnectAttachmentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterconnectAttachmentAsync(
      String name) {
    DeleteInterconnectAttachmentRequest request =
        DeleteInterconnectAttachmentRequest.newBuilder().setName(name).build();
    return deleteInterconnectAttachmentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setName(
   *               InterconnectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   edgeNetworkClient.deleteInterconnectAttachmentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInterconnectAttachmentAsync(
      DeleteInterconnectAttachmentRequest request) {
    return deleteInterconnectAttachmentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setName(
   *               InterconnectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       edgeNetworkClient.deleteInterconnectAttachmentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInterconnectAttachmentRequest, Empty, OperationMetadata>
      deleteInterconnectAttachmentOperationCallable() {
    return stub.deleteInterconnectAttachmentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single InterconnectAttachment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteInterconnectAttachmentRequest request =
   *       DeleteInterconnectAttachmentRequest.newBuilder()
   *           .setName(
   *               InterconnectAttachmentName.of(
   *                       "[PROJECT]", "[LOCATION]", "[ZONE]", "[INTERCONNECT_ATTACHMENT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       edgeNetworkClient.deleteInterconnectAttachmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInterconnectAttachmentRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    return stub.deleteInterconnectAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Routers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   for (Router element : edgeNetworkClient.listRouters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRoutersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutersPagedResponse listRouters(ZoneName parent) {
    ListRoutersRequest request =
        ListRoutersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRouters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Routers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   for (Router element : edgeNetworkClient.listRouters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListRoutersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutersPagedResponse listRouters(String parent) {
    ListRoutersRequest request = ListRoutersRequest.newBuilder().setParent(parent).build();
    return listRouters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Routers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Router element : edgeNetworkClient.listRouters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRoutersPagedResponse listRouters(ListRoutersRequest request) {
    return listRoutersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Routers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Router> future = edgeNetworkClient.listRoutersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Router element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRoutersRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable() {
    return stub.listRoutersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Routers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListRoutersRequest request =
   *       ListRoutersRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRoutersResponse response = edgeNetworkClient.listRoutersCallable().call(request);
   *     for (Router element : response.getRoutersList()) {
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
  public final UnaryCallable<ListRoutersRequest, ListRoutersResponse> listRoutersCallable() {
    return stub.listRoutersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
   *   Router response = edgeNetworkClient.getRouter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Router getRouter(RouterName name) {
    GetRouterRequest request =
        GetRouterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRouter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString();
   *   Router response = edgeNetworkClient.getRouter(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Router getRouter(String name) {
    GetRouterRequest request = GetRouterRequest.newBuilder().setName(name).build();
    return getRouter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetRouterRequest request =
   *       GetRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .build();
   *   Router response = edgeNetworkClient.getRouter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Router getRouter(GetRouterRequest request) {
    return getRouterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetRouterRequest request =
   *       GetRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .build();
   *   ApiFuture<Router> future = edgeNetworkClient.getRouterCallable().futureCall(request);
   *   // Do something.
   *   Router response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRouterRequest, Router> getRouterCallable() {
    return stub.getRouterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
   *   DiagnoseRouterResponse response = edgeNetworkClient.diagnoseRouter(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the router resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseRouterResponse diagnoseRouter(RouterName name) {
    DiagnoseRouterRequest request =
        DiagnoseRouterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return diagnoseRouter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString();
   *   DiagnoseRouterResponse response = edgeNetworkClient.diagnoseRouter(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the router resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseRouterResponse diagnoseRouter(String name) {
    DiagnoseRouterRequest request = DiagnoseRouterRequest.newBuilder().setName(name).build();
    return diagnoseRouter(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseRouterRequest request =
   *       DiagnoseRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .build();
   *   DiagnoseRouterResponse response = edgeNetworkClient.diagnoseRouter(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiagnoseRouterResponse diagnoseRouter(DiagnoseRouterRequest request) {
    return diagnoseRouterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the diagnostics of a single router resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DiagnoseRouterRequest request =
   *       DiagnoseRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .build();
   *   ApiFuture<DiagnoseRouterResponse> future =
   *       edgeNetworkClient.diagnoseRouterCallable().futureCall(request);
   *   // Do something.
   *   DiagnoseRouterResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DiagnoseRouterRequest, DiagnoseRouterResponse>
      diagnoseRouterCallable() {
    return stub.diagnoseRouterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Router in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   Router router = Router.newBuilder().build();
   *   String routerId = "routerId5435972";
   *   Router response = edgeNetworkClient.createRouterAsync(parent, router, routerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param router Required. The resource being created
   * @param routerId Required. Id of the requesting object If auto-generating Id server-side, remove
   *     this field and router_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Router, OperationMetadata> createRouterAsync(
      ZoneName parent, Router router, String routerId) {
    CreateRouterRequest request =
        CreateRouterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRouter(router)
            .setRouterId(routerId)
            .build();
    return createRouterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Router in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   Router router = Router.newBuilder().build();
   *   String routerId = "routerId5435972";
   *   Router response = edgeNetworkClient.createRouterAsync(parent, router, routerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param router Required. The resource being created
   * @param routerId Required. Id of the requesting object If auto-generating Id server-side, remove
   *     this field and router_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Router, OperationMetadata> createRouterAsync(
      String parent, Router router, String routerId) {
    CreateRouterRequest request =
        CreateRouterRequest.newBuilder()
            .setParent(parent)
            .setRouter(router)
            .setRouterId(routerId)
            .build();
    return createRouterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Router in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateRouterRequest request =
   *       CreateRouterRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRouterId("routerId5435972")
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Router response = edgeNetworkClient.createRouterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Router, OperationMetadata> createRouterAsync(
      CreateRouterRequest request) {
    return createRouterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Router in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateRouterRequest request =
   *       CreateRouterRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRouterId("routerId5435972")
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Router, OperationMetadata> future =
   *       edgeNetworkClient.createRouterOperationCallable().futureCall(request);
   *   // Do something.
   *   Router response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRouterRequest, Router, OperationMetadata>
      createRouterOperationCallable() {
    return stub.createRouterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Router in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   CreateRouterRequest request =
   *       CreateRouterRequest.newBuilder()
   *           .setParent(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRouterId("routerId5435972")
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.createRouterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRouterRequest, Operation> createRouterCallable() {
    return stub.createRouterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   Router router = Router.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Router response = edgeNetworkClient.updateRouterAsync(router, updateMask).get();
   * }
   * }</pre>
   *
   * @param router Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Router resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Router, OperationMetadata> updateRouterAsync(
      Router router, FieldMask updateMask) {
    UpdateRouterRequest request =
        UpdateRouterRequest.newBuilder().setRouter(router).setUpdateMask(updateMask).build();
    return updateRouterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Router response = edgeNetworkClient.updateRouterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Router, OperationMetadata> updateRouterAsync(
      UpdateRouterRequest request) {
    return updateRouterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Router, OperationMetadata> future =
   *       edgeNetworkClient.updateRouterOperationCallable().futureCall(request);
   *   // Do something.
   *   Router response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRouterRequest, Router, OperationMetadata>
      updateRouterOperationCallable() {
    return stub.updateRouterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   UpdateRouterRequest request =
   *       UpdateRouterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRouter(Router.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.updateRouterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRouterRequest, Operation> updateRouterCallable() {
    return stub.updateRouterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   RouterName name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]");
   *   edgeNetworkClient.deleteRouterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouterAsync(RouterName name) {
    DeleteRouterRequest request =
        DeleteRouterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRouterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   String name = RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString();
   *   edgeNetworkClient.deleteRouterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouterAsync(String name) {
    DeleteRouterRequest request = DeleteRouterRequest.newBuilder().setName(name).build();
    return deleteRouterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   edgeNetworkClient.deleteRouterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRouterAsync(
      DeleteRouterRequest request) {
    return deleteRouterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       edgeNetworkClient.deleteRouterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRouterRequest, Empty, OperationMetadata>
      deleteRouterOperationCallable() {
    return stub.deleteRouterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Router.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   DeleteRouterRequest request =
   *       DeleteRouterRequest.newBuilder()
   *           .setName(RouterName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[ROUTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = edgeNetworkClient.deleteRouterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRouterRequest, Operation> deleteRouterCallable() {
    return stub.deleteRouterCallable();
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
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : edgeNetworkClient.listLocations(request).iterateAll()) {
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
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       edgeNetworkClient.listLocationsPagedCallable().futureCall(request);
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
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = edgeNetworkClient.listLocationsCallable().call(request);
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
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = edgeNetworkClient.getLocation(request);
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
   * try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = edgeNetworkClient.getLocationCallable().futureCall(request);
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

  public static class ListZonesPagedResponse
      extends AbstractPagedListResponse<
          ListZonesRequest, ListZonesResponse, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    public static ApiFuture<ListZonesPagedResponse> createAsync(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ApiFuture<ListZonesResponse> futureResponse) {
      ApiFuture<ListZonesPage> futurePage =
          ListZonesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListZonesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListZonesPagedResponse(ListZonesPage page) {
      super(page, ListZonesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListZonesPage
      extends AbstractPage<ListZonesRequest, ListZonesResponse, Zone, ListZonesPage> {

    private ListZonesPage(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ListZonesResponse response) {
      super(context, response);
    }

    private static ListZonesPage createEmptyPage() {
      return new ListZonesPage(null, null);
    }

    @Override
    protected ListZonesPage createPage(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ListZonesResponse response) {
      return new ListZonesPage(context, response);
    }

    @Override
    public ApiFuture<ListZonesPage> createPageAsync(
        PageContext<ListZonesRequest, ListZonesResponse, Zone> context,
        ApiFuture<ListZonesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListZonesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListZonesRequest, ListZonesResponse, Zone, ListZonesPage, ListZonesFixedSizeCollection> {

    private ListZonesFixedSizeCollection(List<ListZonesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListZonesFixedSizeCollection createEmptyCollection() {
      return new ListZonesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListZonesFixedSizeCollection createCollection(
        List<ListZonesPage> pages, int collectionSize) {
      return new ListZonesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    public static ApiFuture<ListNetworksPagedResponse> createAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      ApiFuture<ListNetworksPage> futurePage =
          ListNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworksPagedResponse(ListNetworksPage page) {
      super(page, ListNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworksPage
      extends AbstractPage<ListNetworksRequest, ListNetworksResponse, Network, ListNetworksPage> {

    private ListNetworksPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      super(context, response);
    }

    private static ListNetworksPage createEmptyPage() {
      return new ListNetworksPage(null, null);
    }

    @Override
    protected ListNetworksPage createPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      return new ListNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworksPage> createPageAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    private ListNetworksFixedSizeCollection(List<ListNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworksFixedSizeCollection createEmptyCollection() {
      return new ListNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworksFixedSizeCollection createCollection(
        List<ListNetworksPage> pages, int collectionSize) {
      return new ListNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubnetsPagedResponse
      extends AbstractPagedListResponse<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    public static ApiFuture<ListSubnetsPagedResponse> createAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      ApiFuture<ListSubnetsPage> futurePage =
          ListSubnetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSubnetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSubnetsPagedResponse(ListSubnetsPage page) {
      super(page, ListSubnetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubnetsPage
      extends AbstractPage<ListSubnetsRequest, ListSubnetsResponse, Subnet, ListSubnetsPage> {

    private ListSubnetsPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      super(context, response);
    }

    private static ListSubnetsPage createEmptyPage() {
      return new ListSubnetsPage(null, null);
    }

    @Override
    protected ListSubnetsPage createPage(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ListSubnetsResponse response) {
      return new ListSubnetsPage(context, response);
    }

    @Override
    public ApiFuture<ListSubnetsPage> createPageAsync(
        PageContext<ListSubnetsRequest, ListSubnetsResponse, Subnet> context,
        ApiFuture<ListSubnetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubnetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubnetsRequest,
          ListSubnetsResponse,
          Subnet,
          ListSubnetsPage,
          ListSubnetsFixedSizeCollection> {

    private ListSubnetsFixedSizeCollection(List<ListSubnetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubnetsFixedSizeCollection createEmptyCollection() {
      return new ListSubnetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubnetsFixedSizeCollection createCollection(
        List<ListSubnetsPage> pages, int collectionSize) {
      return new ListSubnetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterconnectsPagedResponse
      extends AbstractPagedListResponse<
          ListInterconnectsRequest,
          ListInterconnectsResponse,
          Interconnect,
          ListInterconnectsPage,
          ListInterconnectsFixedSizeCollection> {

    public static ApiFuture<ListInterconnectsPagedResponse> createAsync(
        PageContext<ListInterconnectsRequest, ListInterconnectsResponse, Interconnect> context,
        ApiFuture<ListInterconnectsResponse> futureResponse) {
      ApiFuture<ListInterconnectsPage> futurePage =
          ListInterconnectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterconnectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterconnectsPagedResponse(ListInterconnectsPage page) {
      super(page, ListInterconnectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterconnectsPage
      extends AbstractPage<
          ListInterconnectsRequest,
          ListInterconnectsResponse,
          Interconnect,
          ListInterconnectsPage> {

    private ListInterconnectsPage(
        PageContext<ListInterconnectsRequest, ListInterconnectsResponse, Interconnect> context,
        ListInterconnectsResponse response) {
      super(context, response);
    }

    private static ListInterconnectsPage createEmptyPage() {
      return new ListInterconnectsPage(null, null);
    }

    @Override
    protected ListInterconnectsPage createPage(
        PageContext<ListInterconnectsRequest, ListInterconnectsResponse, Interconnect> context,
        ListInterconnectsResponse response) {
      return new ListInterconnectsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterconnectsPage> createPageAsync(
        PageContext<ListInterconnectsRequest, ListInterconnectsResponse, Interconnect> context,
        ApiFuture<ListInterconnectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterconnectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectsRequest,
          ListInterconnectsResponse,
          Interconnect,
          ListInterconnectsPage,
          ListInterconnectsFixedSizeCollection> {

    private ListInterconnectsFixedSizeCollection(
        List<ListInterconnectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterconnectsFixedSizeCollection createEmptyCollection() {
      return new ListInterconnectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterconnectsFixedSizeCollection createCollection(
        List<ListInterconnectsPage> pages, int collectionSize) {
      return new ListInterconnectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInterconnectAttachmentsPagedResponse
      extends AbstractPagedListResponse<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage,
          ListInterconnectAttachmentsFixedSizeCollection> {

    public static ApiFuture<ListInterconnectAttachmentsPagedResponse> createAsync(
        PageContext<
                ListInterconnectAttachmentsRequest,
                ListInterconnectAttachmentsResponse,
                InterconnectAttachment>
            context,
        ApiFuture<ListInterconnectAttachmentsResponse> futureResponse) {
      ApiFuture<ListInterconnectAttachmentsPage> futurePage =
          ListInterconnectAttachmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInterconnectAttachmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInterconnectAttachmentsPagedResponse(ListInterconnectAttachmentsPage page) {
      super(page, ListInterconnectAttachmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInterconnectAttachmentsPage
      extends AbstractPage<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage> {

    private ListInterconnectAttachmentsPage(
        PageContext<
                ListInterconnectAttachmentsRequest,
                ListInterconnectAttachmentsResponse,
                InterconnectAttachment>
            context,
        ListInterconnectAttachmentsResponse response) {
      super(context, response);
    }

    private static ListInterconnectAttachmentsPage createEmptyPage() {
      return new ListInterconnectAttachmentsPage(null, null);
    }

    @Override
    protected ListInterconnectAttachmentsPage createPage(
        PageContext<
                ListInterconnectAttachmentsRequest,
                ListInterconnectAttachmentsResponse,
                InterconnectAttachment>
            context,
        ListInterconnectAttachmentsResponse response) {
      return new ListInterconnectAttachmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListInterconnectAttachmentsPage> createPageAsync(
        PageContext<
                ListInterconnectAttachmentsRequest,
                ListInterconnectAttachmentsResponse,
                InterconnectAttachment>
            context,
        ApiFuture<ListInterconnectAttachmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInterconnectAttachmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectAttachmentsRequest,
          ListInterconnectAttachmentsResponse,
          InterconnectAttachment,
          ListInterconnectAttachmentsPage,
          ListInterconnectAttachmentsFixedSizeCollection> {

    private ListInterconnectAttachmentsFixedSizeCollection(
        List<ListInterconnectAttachmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInterconnectAttachmentsFixedSizeCollection createEmptyCollection() {
      return new ListInterconnectAttachmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInterconnectAttachmentsFixedSizeCollection createCollection(
        List<ListInterconnectAttachmentsPage> pages, int collectionSize) {
      return new ListInterconnectAttachmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRoutersPagedResponse
      extends AbstractPagedListResponse<
          ListRoutersRequest,
          ListRoutersResponse,
          Router,
          ListRoutersPage,
          ListRoutersFixedSizeCollection> {

    public static ApiFuture<ListRoutersPagedResponse> createAsync(
        PageContext<ListRoutersRequest, ListRoutersResponse, Router> context,
        ApiFuture<ListRoutersResponse> futureResponse) {
      ApiFuture<ListRoutersPage> futurePage =
          ListRoutersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRoutersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRoutersPagedResponse(ListRoutersPage page) {
      super(page, ListRoutersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRoutersPage
      extends AbstractPage<ListRoutersRequest, ListRoutersResponse, Router, ListRoutersPage> {

    private ListRoutersPage(
        PageContext<ListRoutersRequest, ListRoutersResponse, Router> context,
        ListRoutersResponse response) {
      super(context, response);
    }

    private static ListRoutersPage createEmptyPage() {
      return new ListRoutersPage(null, null);
    }

    @Override
    protected ListRoutersPage createPage(
        PageContext<ListRoutersRequest, ListRoutersResponse, Router> context,
        ListRoutersResponse response) {
      return new ListRoutersPage(context, response);
    }

    @Override
    public ApiFuture<ListRoutersPage> createPageAsync(
        PageContext<ListRoutersRequest, ListRoutersResponse, Router> context,
        ApiFuture<ListRoutersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRoutersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRoutersRequest,
          ListRoutersResponse,
          Router,
          ListRoutersPage,
          ListRoutersFixedSizeCollection> {

    private ListRoutersFixedSizeCollection(List<ListRoutersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRoutersFixedSizeCollection createEmptyCollection() {
      return new ListRoutersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRoutersFixedSizeCollection createCollection(
        List<ListRoutersPage> pages, int collectionSize) {
      return new ListRoutersFixedSizeCollection(pages, collectionSize);
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
