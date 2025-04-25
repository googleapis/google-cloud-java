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

package com.google.cloud.gdchardwaremanagement.v1alpha;

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
import com.google.cloud.gdchardwaremanagement.v1alpha.stub.GDCHardwareManagementStub;
import com.google.cloud.gdchardwaremanagement.v1alpha.stub.GDCHardwareManagementStubSettings;
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
 * Service Description: The GDC Hardware Management service.
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
 * try (GDCHardwareManagementClient gDCHardwareManagementClient =
 *     GDCHardwareManagementClient.create()) {
 *   OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
 *   Order response = gDCHardwareManagementClient.getOrder(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GDCHardwareManagementClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListOrders</td>
 *      <td><p> Lists orders in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrders(ListOrdersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrders(LocationName parent)
 *           <li><p> listOrders(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrdersPagedCallable()
 *           <li><p> listOrdersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrder</td>
 *      <td><p> Gets details of an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrder(GetOrderRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrder(OrderName name)
 *           <li><p> getOrder(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOrder</td>
 *      <td><p> Creates a new order in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOrderAsync(CreateOrderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOrderAsync(LocationName parent, Order order, String orderId)
 *           <li><p> createOrderAsync(String parent, Order order, String orderId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOrderOperationCallable()
 *           <li><p> createOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateOrder</td>
 *      <td><p> Updates the parameters of an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateOrderAsync(UpdateOrderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateOrderAsync(Order order, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOrderOperationCallable()
 *           <li><p> updateOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOrder</td>
 *      <td><p> Deletes an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOrderAsync(DeleteOrderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteOrderAsync(OrderName name)
 *           <li><p> deleteOrderAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOrderOperationCallable()
 *           <li><p> deleteOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SubmitOrder</td>
 *      <td><p> Submits an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> submitOrderAsync(SubmitOrderRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> submitOrderAsync(OrderName name)
 *           <li><p> submitOrderAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> submitOrderOperationCallable()
 *           <li><p> submitOrderCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSites</td>
 *      <td><p> Lists sites in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSites(ListSitesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSites(LocationName parent)
 *           <li><p> listSites(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSitesPagedCallable()
 *           <li><p> listSitesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSite</td>
 *      <td><p> Gets details of a site.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSite(GetSiteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSite(SiteName name)
 *           <li><p> getSite(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSite</td>
 *      <td><p> Creates a new site in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSiteAsync(CreateSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSiteAsync(LocationName parent, Site site, String siteId)
 *           <li><p> createSiteAsync(String parent, Site site, String siteId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSiteOperationCallable()
 *           <li><p> createSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSite</td>
 *      <td><p> Updates the parameters of a site.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSiteAsync(UpdateSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSiteAsync(Site site, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSiteOperationCallable()
 *           <li><p> updateSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSite</td>
 *      <td><p> Deletes a site.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSiteAsync(DeleteSiteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSiteAsync(SiteName name)
 *           <li><p> deleteSiteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSiteOperationCallable()
 *           <li><p> deleteSiteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHardwareGroups</td>
 *      <td><p> Lists hardware groups in a given order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHardwareGroups(ListHardwareGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHardwareGroups(OrderName parent)
 *           <li><p> listHardwareGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHardwareGroupsPagedCallable()
 *           <li><p> listHardwareGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHardwareGroup</td>
 *      <td><p> Gets details of a hardware group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHardwareGroup(GetHardwareGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHardwareGroup(HardwareGroupName name)
 *           <li><p> getHardwareGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHardwareGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHardwareGroup</td>
 *      <td><p> Creates a new hardware group in a given order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHardwareGroupAsync(CreateHardwareGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHardwareGroupAsync(OrderName parent, HardwareGroup hardwareGroup, String hardwareGroupId)
 *           <li><p> createHardwareGroupAsync(String parent, HardwareGroup hardwareGroup, String hardwareGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHardwareGroupOperationCallable()
 *           <li><p> createHardwareGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHardwareGroup</td>
 *      <td><p> Updates the parameters of a hardware group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHardwareGroupAsync(UpdateHardwareGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateHardwareGroupAsync(HardwareGroup hardwareGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHardwareGroupOperationCallable()
 *           <li><p> updateHardwareGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHardwareGroup</td>
 *      <td><p> Deletes a hardware group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHardwareGroupAsync(DeleteHardwareGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteHardwareGroupAsync(HardwareGroupName name)
 *           <li><p> deleteHardwareGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHardwareGroupOperationCallable()
 *           <li><p> deleteHardwareGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHardware</td>
 *      <td><p> Lists hardware in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHardware(ListHardwareRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHardware(LocationName parent)
 *           <li><p> listHardware(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHardwarePagedCallable()
 *           <li><p> listHardwareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHardware</td>
 *      <td><p> Gets hardware details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHardware(GetHardwareRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHardware(HardwareName name)
 *           <li><p> getHardware(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHardwareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHardware</td>
 *      <td><p> Creates new hardware in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHardwareAsync(CreateHardwareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHardwareAsync(LocationName parent, Hardware hardware, String hardwareId)
 *           <li><p> createHardwareAsync(String parent, Hardware hardware, String hardwareId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHardwareOperationCallable()
 *           <li><p> createHardwareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHardware</td>
 *      <td><p> Updates hardware parameters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHardwareAsync(UpdateHardwareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateHardwareAsync(Hardware hardware, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHardwareOperationCallable()
 *           <li><p> updateHardwareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHardware</td>
 *      <td><p> Deletes hardware.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHardwareAsync(DeleteHardwareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteHardwareAsync(HardwareName name)
 *           <li><p> deleteHardwareAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHardwareOperationCallable()
 *           <li><p> deleteHardwareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListComments</td>
 *      <td><p> Lists the comments on an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listComments(ListCommentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listComments(OrderName parent)
 *           <li><p> listComments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCommentsPagedCallable()
 *           <li><p> listCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetComment</td>
 *      <td><p> Gets the content of a comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getComment(GetCommentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getComment(CommentName name)
 *           <li><p> getComment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateComment</td>
 *      <td><p> Creates a new comment on an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCommentAsync(CreateCommentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCommentAsync(OrderName parent, Comment comment, String commentId)
 *           <li><p> createCommentAsync(String parent, Comment comment, String commentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCommentOperationCallable()
 *           <li><p> createCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RecordActionOnComment</td>
 *      <td><p> Record Action on a Comment. If the Action specified in the request is READ, the viewed time in the comment is set to the time the request was received. If the comment is already marked as read, subsequent calls will be ignored. If the Action is UNREAD, the viewed time is cleared from the comment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> recordActionOnComment(RecordActionOnCommentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> recordActionOnComment(CommentName name, RecordActionOnCommentRequest.ActionType actionType)
 *           <li><p> recordActionOnComment(String name, RecordActionOnCommentRequest.ActionType actionType)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> recordActionOnCommentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChangeLogEntries</td>
 *      <td><p> Lists the changes made to an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChangeLogEntries(ListChangeLogEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChangeLogEntries(OrderName parent)
 *           <li><p> listChangeLogEntries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChangeLogEntriesPagedCallable()
 *           <li><p> listChangeLogEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetChangeLogEntry</td>
 *      <td><p> Gets details of a change to an order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChangeLogEntry(GetChangeLogEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChangeLogEntry(ChangeLogEntryName name)
 *           <li><p> getChangeLogEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChangeLogEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSkus</td>
 *      <td><p> Lists SKUs for a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSkus(ListSkusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSkus(LocationName parent)
 *           <li><p> listSkus(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSkusPagedCallable()
 *           <li><p> listSkusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSku</td>
 *      <td><p> Gets details of an SKU.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSku(GetSkuRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSku(SkuName name)
 *           <li><p> getSku(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkuCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListZones</td>
 *      <td><p> Lists zones in a given project and location.</td>
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
 *      <td><p> Gets details of a zone.</td>
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
 *      <td><p> CreateZone</td>
 *      <td><p> Creates a new zone in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createZoneAsync(CreateZoneRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createZoneAsync(LocationName parent, Zone zone, String zoneId)
 *           <li><p> createZoneAsync(String parent, Zone zone, String zoneId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createZoneOperationCallable()
 *           <li><p> createZoneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateZone</td>
 *      <td><p> Updates the parameters of a zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateZoneAsync(UpdateZoneRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateZoneAsync(Zone zone, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateZoneOperationCallable()
 *           <li><p> updateZoneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteZone</td>
 *      <td><p> Deletes a zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteZoneAsync(DeleteZoneRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteZoneAsync(ZoneName name)
 *           <li><p> deleteZoneAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteZoneOperationCallable()
 *           <li><p> deleteZoneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SignalZoneState</td>
 *      <td><p> Signals the state of a zone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> signalZoneStateAsync(SignalZoneStateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> signalZoneStateAsync(ZoneName name, SignalZoneStateRequest.StateSignal stateSignal)
 *           <li><p> signalZoneStateAsync(String name, SignalZoneStateRequest.StateSignal stateSignal)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> signalZoneStateOperationCallable()
 *           <li><p> signalZoneStateCallable()
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
 * <p>This class can be customized by passing in a custom instance of GDCHardwareManagementSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GDCHardwareManagementSettings gDCHardwareManagementSettings =
 *     GDCHardwareManagementSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GDCHardwareManagementClient gDCHardwareManagementClient =
 *     GDCHardwareManagementClient.create(gDCHardwareManagementSettings);
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
 * GDCHardwareManagementSettings gDCHardwareManagementSettings =
 *     GDCHardwareManagementSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GDCHardwareManagementClient gDCHardwareManagementClient =
 *     GDCHardwareManagementClient.create(gDCHardwareManagementSettings);
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
 * GDCHardwareManagementSettings gDCHardwareManagementSettings =
 *     GDCHardwareManagementSettings.newHttpJsonBuilder().build();
 * GDCHardwareManagementClient gDCHardwareManagementClient =
 *     GDCHardwareManagementClient.create(gDCHardwareManagementSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GDCHardwareManagementClient implements BackgroundResource {
  private final GDCHardwareManagementSettings settings;
  private final GDCHardwareManagementStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of GDCHardwareManagementClient with default settings. */
  public static final GDCHardwareManagementClient create() throws IOException {
    return create(GDCHardwareManagementSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GDCHardwareManagementClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GDCHardwareManagementClient create(GDCHardwareManagementSettings settings)
      throws IOException {
    return new GDCHardwareManagementClient(settings);
  }

  /**
   * Constructs an instance of GDCHardwareManagementClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(GDCHardwareManagementSettings).
   */
  public static final GDCHardwareManagementClient create(GDCHardwareManagementStub stub) {
    return new GDCHardwareManagementClient(stub);
  }

  /**
   * Constructs an instance of GDCHardwareManagementClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GDCHardwareManagementClient(GDCHardwareManagementSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GDCHardwareManagementStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected GDCHardwareManagementClient(GDCHardwareManagementStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final GDCHardwareManagementSettings getSettings() {
    return settings;
  }

  public GDCHardwareManagementStub getStub() {
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
   * Lists orders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Order element : gDCHardwareManagementClient.listOrders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list orders in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list orders across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(LocationName parent) {
    ListOrdersRequest request =
        ListOrdersRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists orders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Order element : gDCHardwareManagementClient.listOrders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list orders in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list orders across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(String parent) {
    ListOrdersRequest request = ListOrdersRequest.newBuilder().setParent(parent).build();
    return listOrders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists orders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Order element : gDCHardwareManagementClient.listOrders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrdersPagedResponse listOrders(ListOrdersRequest request) {
    return listOrdersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists orders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Order> future =
   *       gDCHardwareManagementClient.listOrdersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Order element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return stub.listOrdersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists orders in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListOrdersRequest request =
   *       ListOrdersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListOrdersResponse response =
   *         gDCHardwareManagementClient.listOrdersCallable().call(request);
   *     for (Order element : response.getOrdersList()) {
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
  public final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return stub.listOrdersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   Order response = gDCHardwareManagementClient.getOrder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(OrderName name) {
    GetOrderRequest request =
        GetOrderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   Order response = gDCHardwareManagementClient.getOrder(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(String name) {
    GetOrderRequest request = GetOrderRequest.newBuilder().setName(name).build();
    return getOrder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetOrderRequest request =
   *       GetOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .build();
   *   Order response = gDCHardwareManagementClient.getOrder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Order getOrder(GetOrderRequest request) {
    return getOrderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetOrderRequest request =
   *       GetOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .build();
   *   ApiFuture<Order> future = gDCHardwareManagementClient.getOrderCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return stub.getOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new order in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Order order = Order.newBuilder().build();
   *   String orderId = "orderId-1207110391";
   *   Order response = gDCHardwareManagementClient.createOrderAsync(parent, order, orderId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the order in. Format:
   *     `projects/{project}/locations/{location}`
   * @param order Required. The order to create.
   * @param orderId Optional. ID used to uniquely identify the Order within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The order.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> createOrderAsync(
      LocationName parent, Order order, String orderId) {
    CreateOrderRequest request =
        CreateOrderRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOrder(order)
            .setOrderId(orderId)
            .build();
    return createOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new order in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Order order = Order.newBuilder().build();
   *   String orderId = "orderId-1207110391";
   *   Order response = gDCHardwareManagementClient.createOrderAsync(parent, order, orderId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the order in. Format:
   *     `projects/{project}/locations/{location}`
   * @param order Required. The order to create.
   * @param orderId Optional. ID used to uniquely identify the Order within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The order.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> createOrderAsync(
      String parent, Order order, String orderId) {
    CreateOrderRequest request =
        CreateOrderRequest.newBuilder()
            .setParent(parent)
            .setOrder(order)
            .setOrderId(orderId)
            .build();
    return createOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new order in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateOrderRequest request =
   *       CreateOrderRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrderId("orderId-1207110391")
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Order response = gDCHardwareManagementClient.createOrderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> createOrderAsync(
      CreateOrderRequest request) {
    return createOrderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new order in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateOrderRequest request =
   *       CreateOrderRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrderId("orderId-1207110391")
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Order, OperationMetadata> future =
   *       gDCHardwareManagementClient.createOrderOperationCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable() {
    return stub.createOrderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new order in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateOrderRequest request =
   *       CreateOrderRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOrderId("orderId-1207110391")
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createOrderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOrderRequest, Operation> createOrderCallable() {
    return stub.createOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   Order order = Order.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Order response = gDCHardwareManagementClient.updateOrderAsync(order, updateMask).get();
   * }
   * }</pre>
   *
   * @param order Required. The order to update.
   * @param updateMask Required. A mask to specify the fields in the Order to overwrite with this
   *     update. The fields specified in the update_mask are relative to the order, not the full
   *     request. A field will be overwritten if it is in the mask. If you don't provide a mask then
   *     all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> updateOrderAsync(
      Order order, FieldMask updateMask) {
    UpdateOrderRequest request =
        UpdateOrderRequest.newBuilder().setOrder(order).setUpdateMask(updateMask).build();
    return updateOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateOrderRequest request =
   *       UpdateOrderRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Order response = gDCHardwareManagementClient.updateOrderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> updateOrderAsync(
      UpdateOrderRequest request) {
    return updateOrderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateOrderRequest request =
   *       UpdateOrderRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Order, OperationMetadata> future =
   *       gDCHardwareManagementClient.updateOrderOperationCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable() {
    return stub.updateOrderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateOrderRequest request =
   *       UpdateOrderRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setOrder(Order.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.updateOrderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable() {
    return stub.updateOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   gDCHardwareManagementClient.deleteOrderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the order. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrderAsync(OrderName name) {
    DeleteOrderRequest request =
        DeleteOrderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   gDCHardwareManagementClient.deleteOrderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the order. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrderAsync(String name) {
    DeleteOrderRequest request = DeleteOrderRequest.newBuilder().setName(name).build();
    return deleteOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteOrderRequest request =
   *       DeleteOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   gDCHardwareManagementClient.deleteOrderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOrderAsync(
      DeleteOrderRequest request) {
    return deleteOrderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteOrderRequest request =
   *       DeleteOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gDCHardwareManagementClient.deleteOrderOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable() {
    return stub.deleteOrderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteOrderRequest request =
   *       DeleteOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.deleteOrderCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable() {
    return stub.deleteOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   Order response = gDCHardwareManagementClient.submitOrderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the order. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> submitOrderAsync(OrderName name) {
    SubmitOrderRequest request =
        SubmitOrderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return submitOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   Order response = gDCHardwareManagementClient.submitOrderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the order. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> submitOrderAsync(String name) {
    SubmitOrderRequest request = SubmitOrderRequest.newBuilder().setName(name).build();
    return submitOrderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SubmitOrderRequest request =
   *       SubmitOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Order response = gDCHardwareManagementClient.submitOrderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Order, OperationMetadata> submitOrderAsync(
      SubmitOrderRequest request) {
    return submitOrderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SubmitOrderRequest request =
   *       SubmitOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Order, OperationMetadata> future =
   *       gDCHardwareManagementClient.submitOrderOperationCallable().futureCall(request);
   *   // Do something.
   *   Order response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable() {
    return stub.submitOrderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submits an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SubmitOrderRequest request =
   *       SubmitOrderRequest.newBuilder()
   *           .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.submitOrderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable() {
    return stub.submitOrderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sites in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Site element : gDCHardwareManagementClient.listSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list sites in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list sites across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(LocationName parent) {
    ListSitesRequest request =
        ListSitesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sites in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Site element : gDCHardwareManagementClient.listSites(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list sites in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list sites across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(String parent) {
    ListSitesRequest request = ListSitesRequest.newBuilder().setParent(parent).build();
    return listSites(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sites in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Site element : gDCHardwareManagementClient.listSites(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSitesPagedResponse listSites(ListSitesRequest request) {
    return listSitesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sites in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Site> future =
   *       gDCHardwareManagementClient.listSitesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Site element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    return stub.listSitesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists sites in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSitesRequest request =
   *       ListSitesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSitesResponse response = gDCHardwareManagementClient.listSitesCallable().call(request);
   *     for (Site element : response.getSitesList()) {
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
  public final UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    return stub.listSitesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");
   *   Site response = gDCHardwareManagementClient.getSite(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site. Format:
   *     `projects/{project}/locations/{location}/sites/{site}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(SiteName name) {
    GetSiteRequest request =
        GetSiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString();
   *   Site response = gDCHardwareManagementClient.getSite(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the site. Format:
   *     `projects/{project}/locations/{location}/sites/{site}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(String name) {
    GetSiteRequest request = GetSiteRequest.newBuilder().setName(name).build();
    return getSite(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetSiteRequest request =
   *       GetSiteRequest.newBuilder()
   *           .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
   *           .build();
   *   Site response = gDCHardwareManagementClient.getSite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Site getSite(GetSiteRequest request) {
    return getSiteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetSiteRequest request =
   *       GetSiteRequest.newBuilder()
   *           .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
   *           .build();
   *   ApiFuture<Site> future = gDCHardwareManagementClient.getSiteCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    return stub.getSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new site in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Site site = Site.newBuilder().build();
   *   String siteId = "siteId-902090046";
   *   Site response = gDCHardwareManagementClient.createSiteAsync(parent, site, siteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the site in. Format:
   *     `projects/{project}/locations/{location}`
   * @param site Required. The site to create.
   * @param siteId Optional. ID used to uniquely identify the Site within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The site.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Site, OperationMetadata> createSiteAsync(
      LocationName parent, Site site, String siteId) {
    CreateSiteRequest request =
        CreateSiteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSite(site)
            .setSiteId(siteId)
            .build();
    return createSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new site in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Site site = Site.newBuilder().build();
   *   String siteId = "siteId-902090046";
   *   Site response = gDCHardwareManagementClient.createSiteAsync(parent, site, siteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the site in. Format:
   *     `projects/{project}/locations/{location}`
   * @param site Required. The site to create.
   * @param siteId Optional. ID used to uniquely identify the Site within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The site.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Site, OperationMetadata> createSiteAsync(
      String parent, Site site, String siteId) {
    CreateSiteRequest request =
        CreateSiteRequest.newBuilder().setParent(parent).setSite(site).setSiteId(siteId).build();
    return createSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new site in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateSiteRequest request =
   *       CreateSiteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSiteId("siteId-902090046")
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Site response = gDCHardwareManagementClient.createSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Site, OperationMetadata> createSiteAsync(CreateSiteRequest request) {
    return createSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new site in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateSiteRequest request =
   *       CreateSiteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSiteId("siteId-902090046")
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Site, OperationMetadata> future =
   *       gDCHardwareManagementClient.createSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable() {
    return stub.createSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new site in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateSiteRequest request =
   *       CreateSiteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSiteId("siteId-902090046")
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createSiteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSiteRequest, Operation> createSiteCallable() {
    return stub.createSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   Site site = Site.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Site response = gDCHardwareManagementClient.updateSiteAsync(site, updateMask).get();
   * }
   * }</pre>
   *
   * @param site Required. The site to update.
   * @param updateMask Required. A mask to specify the fields in the Site to overwrite with this
   *     update. The fields specified in the update_mask are relative to the site, not the full
   *     request. A field will be overwritten if it is in the mask. If you don't provide a mask then
   *     all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Site, OperationMetadata> updateSiteAsync(
      Site site, FieldMask updateMask) {
    UpdateSiteRequest request =
        UpdateSiteRequest.newBuilder().setSite(site).setUpdateMask(updateMask).build();
    return updateSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateSiteRequest request =
   *       UpdateSiteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Site response = gDCHardwareManagementClient.updateSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Site, OperationMetadata> updateSiteAsync(UpdateSiteRequest request) {
    return updateSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateSiteRequest request =
   *       UpdateSiteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Site, OperationMetadata> future =
   *       gDCHardwareManagementClient.updateSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   Site response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable() {
    return stub.updateSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateSiteRequest request =
   *       UpdateSiteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSite(Site.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.updateSiteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable() {
    return stub.updateSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SiteName name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]");
   *   gDCHardwareManagementClient.deleteSiteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the site. Format:
   *     `projects/{project}/locations/{location}/sites/{site}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSiteAsync(SiteName name) {
    DeleteSiteRequest request =
        DeleteSiteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString();
   *   gDCHardwareManagementClient.deleteSiteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the site. Format:
   *     `projects/{project}/locations/{location}/sites/{site}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSiteAsync(String name) {
    DeleteSiteRequest request = DeleteSiteRequest.newBuilder().setName(name).build();
    return deleteSiteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteSiteRequest request =
   *       DeleteSiteRequest.newBuilder()
   *           .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gDCHardwareManagementClient.deleteSiteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSiteAsync(
      DeleteSiteRequest request) {
    return deleteSiteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteSiteRequest request =
   *       DeleteSiteRequest.newBuilder()
   *           .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gDCHardwareManagementClient.deleteSiteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationCallable() {
    return stub.deleteSiteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a site.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteSiteRequest request =
   *       DeleteSiteRequest.newBuilder()
   *           .setName(SiteName.of("[PROJECT]", "[LOCATION]", "[SITE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.deleteSiteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSiteRequest, Operation> deleteSiteCallable() {
    return stub.deleteSiteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware groups in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   for (HardwareGroup element :
   *       gDCHardwareManagementClient.listHardwareGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list hardware groups in. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwareGroupsPagedResponse listHardwareGroups(OrderName parent) {
    ListHardwareGroupsRequest request =
        ListHardwareGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHardwareGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware groups in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   for (HardwareGroup element :
   *       gDCHardwareManagementClient.listHardwareGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list hardware groups in. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwareGroupsPagedResponse listHardwareGroups(String parent) {
    ListHardwareGroupsRequest request =
        ListHardwareGroupsRequest.newBuilder().setParent(parent).build();
    return listHardwareGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware groups in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareGroupsRequest request =
   *       ListHardwareGroupsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (HardwareGroup element :
   *       gDCHardwareManagementClient.listHardwareGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwareGroupsPagedResponse listHardwareGroups(
      ListHardwareGroupsRequest request) {
    return listHardwareGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware groups in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareGroupsRequest request =
   *       ListHardwareGroupsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<HardwareGroup> future =
   *       gDCHardwareManagementClient.listHardwareGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HardwareGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable() {
    return stub.listHardwareGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware groups in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareGroupsRequest request =
   *       ListHardwareGroupsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListHardwareGroupsResponse response =
   *         gDCHardwareManagementClient.listHardwareGroupsCallable().call(request);
   *     for (HardwareGroup element : response.getHardwareGroupsList()) {
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
  public final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable() {
    return stub.listHardwareGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   HardwareGroupName name =
   *       HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");
   *   HardwareGroup response = gDCHardwareManagementClient.getHardwareGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware group. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HardwareGroup getHardwareGroup(HardwareGroupName name) {
    GetHardwareGroupRequest request =
        GetHardwareGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHardwareGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name =
   *       HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]").toString();
   *   HardwareGroup response = gDCHardwareManagementClient.getHardwareGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware group. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HardwareGroup getHardwareGroup(String name) {
    GetHardwareGroupRequest request = GetHardwareGroupRequest.newBuilder().setName(name).build();
    return getHardwareGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetHardwareGroupRequest request =
   *       GetHardwareGroupRequest.newBuilder()
   *           .setName(
   *               HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
   *                   .toString())
   *           .build();
   *   HardwareGroup response = gDCHardwareManagementClient.getHardwareGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HardwareGroup getHardwareGroup(GetHardwareGroupRequest request) {
    return getHardwareGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetHardwareGroupRequest request =
   *       GetHardwareGroupRequest.newBuilder()
   *           .setName(
   *               HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HardwareGroup> future =
   *       gDCHardwareManagementClient.getHardwareGroupCallable().futureCall(request);
   *   // Do something.
   *   HardwareGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable() {
    return stub.getHardwareGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hardware group in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
   *   String hardwareGroupId = "hardwareGroupId-1961682702";
   *   HardwareGroup response =
   *       gDCHardwareManagementClient
   *           .createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The order to create the hardware group in. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @param hardwareGroup Required. The hardware group to create.
   * @param hardwareGroupId Optional. ID used to uniquely identify the HardwareGroup within its
   *     parent scope. This field should contain at most 63 characters and must start with lowercase
   *     characters. Only lowercase characters, numbers and `-` are accepted. The `-` character
   *     cannot be the first or the last one. A system generated ID will be used if the field is not
   *     set.
   *     <p>The hardware_group.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HardwareGroup, OperationMetadata> createHardwareGroupAsync(
      OrderName parent, HardwareGroup hardwareGroup, String hardwareGroupId) {
    CreateHardwareGroupRequest request =
        CreateHardwareGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHardwareGroup(hardwareGroup)
            .setHardwareGroupId(hardwareGroupId)
            .build();
    return createHardwareGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hardware group in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
   *   String hardwareGroupId = "hardwareGroupId-1961682702";
   *   HardwareGroup response =
   *       gDCHardwareManagementClient
   *           .createHardwareGroupAsync(parent, hardwareGroup, hardwareGroupId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The order to create the hardware group in. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @param hardwareGroup Required. The hardware group to create.
   * @param hardwareGroupId Optional. ID used to uniquely identify the HardwareGroup within its
   *     parent scope. This field should contain at most 63 characters and must start with lowercase
   *     characters. Only lowercase characters, numbers and `-` are accepted. The `-` character
   *     cannot be the first or the last one. A system generated ID will be used if the field is not
   *     set.
   *     <p>The hardware_group.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HardwareGroup, OperationMetadata> createHardwareGroupAsync(
      String parent, HardwareGroup hardwareGroup, String hardwareGroupId) {
    CreateHardwareGroupRequest request =
        CreateHardwareGroupRequest.newBuilder()
            .setParent(parent)
            .setHardwareGroup(hardwareGroup)
            .setHardwareGroupId(hardwareGroupId)
            .build();
    return createHardwareGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hardware group in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareGroupRequest request =
   *       CreateHardwareGroupRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setHardwareGroupId("hardwareGroupId-1961682702")
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   HardwareGroup response = gDCHardwareManagementClient.createHardwareGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HardwareGroup, OperationMetadata> createHardwareGroupAsync(
      CreateHardwareGroupRequest request) {
    return createHardwareGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hardware group in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareGroupRequest request =
   *       CreateHardwareGroupRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setHardwareGroupId("hardwareGroupId-1961682702")
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<HardwareGroup, OperationMetadata> future =
   *       gDCHardwareManagementClient.createHardwareGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   HardwareGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable() {
    return stub.createHardwareGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hardware group in a given order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareGroupRequest request =
   *       CreateHardwareGroupRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setHardwareGroupId("hardwareGroupId-1961682702")
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createHardwareGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable() {
    return stub.createHardwareGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   HardwareGroup hardwareGroup = HardwareGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HardwareGroup response =
   *       gDCHardwareManagementClient.updateHardwareGroupAsync(hardwareGroup, updateMask).get();
   * }
   * }</pre>
   *
   * @param hardwareGroup Required. The hardware group to update.
   * @param updateMask Required. A mask to specify the fields in the HardwareGroup to overwrite with
   *     this update. The fields specified in the update_mask are relative to the hardware group,
   *     not the full request. A field will be overwritten if it is in the mask. If you don't
   *     provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HardwareGroup, OperationMetadata> updateHardwareGroupAsync(
      HardwareGroup hardwareGroup, FieldMask updateMask) {
    UpdateHardwareGroupRequest request =
        UpdateHardwareGroupRequest.newBuilder()
            .setHardwareGroup(hardwareGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateHardwareGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareGroupRequest request =
   *       UpdateHardwareGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   HardwareGroup response = gDCHardwareManagementClient.updateHardwareGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HardwareGroup, OperationMetadata> updateHardwareGroupAsync(
      UpdateHardwareGroupRequest request) {
    return updateHardwareGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareGroupRequest request =
   *       UpdateHardwareGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<HardwareGroup, OperationMetadata> future =
   *       gDCHardwareManagementClient.updateHardwareGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   HardwareGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable() {
    return stub.updateHardwareGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareGroupRequest request =
   *       UpdateHardwareGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardwareGroup(HardwareGroup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.updateHardwareGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable() {
    return stub.updateHardwareGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   HardwareGroupName name =
   *       HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]");
   *   gDCHardwareManagementClient.deleteHardwareGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware group. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareGroupAsync(
      HardwareGroupName name) {
    DeleteHardwareGroupRequest request =
        DeleteHardwareGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteHardwareGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name =
   *       HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]").toString();
   *   gDCHardwareManagementClient.deleteHardwareGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware group. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareGroupAsync(String name) {
    DeleteHardwareGroupRequest request =
        DeleteHardwareGroupRequest.newBuilder().setName(name).build();
    return deleteHardwareGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareGroupRequest request =
   *       DeleteHardwareGroupRequest.newBuilder()
   *           .setName(
   *               HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gDCHardwareManagementClient.deleteHardwareGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareGroupAsync(
      DeleteHardwareGroupRequest request) {
    return deleteHardwareGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareGroupRequest request =
   *       DeleteHardwareGroupRequest.newBuilder()
   *           .setName(
   *               HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gDCHardwareManagementClient.deleteHardwareGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable() {
    return stub.deleteHardwareGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a hardware group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareGroupRequest request =
   *       DeleteHardwareGroupRequest.newBuilder()
   *           .setName(
   *               HardwareGroupName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[HARDWARE_GROUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.deleteHardwareGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable() {
    return stub.deleteHardwareGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Hardware element : gDCHardwareManagementClient.listHardware(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list hardware in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list hardware across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwarePagedResponse listHardware(LocationName parent) {
    ListHardwareRequest request =
        ListHardwareRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHardware(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Hardware element : gDCHardwareManagementClient.listHardware(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list hardware in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list hardware across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwarePagedResponse listHardware(String parent) {
    ListHardwareRequest request = ListHardwareRequest.newBuilder().setParent(parent).build();
    return listHardware(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareRequest request =
   *       ListHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Hardware element : gDCHardwareManagementClient.listHardware(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHardwarePagedResponse listHardware(ListHardwareRequest request) {
    return listHardwarePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareRequest request =
   *       ListHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Hardware> future =
   *       gDCHardwareManagementClient.listHardwarePagedCallable().futureCall(request);
   *   // Do something.
   *   for (Hardware element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse>
      listHardwarePagedCallable() {
    return stub.listHardwarePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListHardwareRequest request =
   *       ListHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListHardwareResponse response =
   *         gDCHardwareManagementClient.listHardwareCallable().call(request);
   *     for (Hardware element : response.getHardwareList()) {
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
  public final UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable() {
    return stub.listHardwareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets hardware details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");
   *   Hardware response = gDCHardwareManagementClient.getHardware(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware. Format:
   *     `projects/{project}/locations/{location}/hardware/{hardware}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hardware getHardware(HardwareName name) {
    GetHardwareRequest request =
        GetHardwareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHardware(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets hardware details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString();
   *   Hardware response = gDCHardwareManagementClient.getHardware(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware. Format:
   *     `projects/{project}/locations/{location}/hardware/{hardware}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hardware getHardware(String name) {
    GetHardwareRequest request = GetHardwareRequest.newBuilder().setName(name).build();
    return getHardware(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets hardware details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetHardwareRequest request =
   *       GetHardwareRequest.newBuilder()
   *           .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
   *           .build();
   *   Hardware response = gDCHardwareManagementClient.getHardware(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Hardware getHardware(GetHardwareRequest request) {
    return getHardwareCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets hardware details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetHardwareRequest request =
   *       GetHardwareRequest.newBuilder()
   *           .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
   *           .build();
   *   ApiFuture<Hardware> future =
   *       gDCHardwareManagementClient.getHardwareCallable().futureCall(request);
   *   // Do something.
   *   Hardware response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable() {
    return stub.getHardwareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Hardware hardware = Hardware.newBuilder().build();
   *   String hardwareId = "hardwareId680924451";
   *   Hardware response =
   *       gDCHardwareManagementClient.createHardwareAsync(parent, hardware, hardwareId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create hardware in. Format:
   *     `projects/{project}/locations/{location}`
   * @param hardware Required. The resource to create.
   * @param hardwareId Optional. ID used to uniquely identify the Hardware within its parent scope.
   *     This field should contain at most 63 characters and must start with lowercase characters.
   *     Only lowercase characters, numbers and `-` are accepted. The `-` character cannot be the
   *     first or the last one. A system generated ID will be used if the field is not set.
   *     <p>The hardware.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hardware, OperationMetadata> createHardwareAsync(
      LocationName parent, Hardware hardware, String hardwareId) {
    CreateHardwareRequest request =
        CreateHardwareRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHardware(hardware)
            .setHardwareId(hardwareId)
            .build();
    return createHardwareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Hardware hardware = Hardware.newBuilder().build();
   *   String hardwareId = "hardwareId680924451";
   *   Hardware response =
   *       gDCHardwareManagementClient.createHardwareAsync(parent, hardware, hardwareId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create hardware in. Format:
   *     `projects/{project}/locations/{location}`
   * @param hardware Required. The resource to create.
   * @param hardwareId Optional. ID used to uniquely identify the Hardware within its parent scope.
   *     This field should contain at most 63 characters and must start with lowercase characters.
   *     Only lowercase characters, numbers and `-` are accepted. The `-` character cannot be the
   *     first or the last one. A system generated ID will be used if the field is not set.
   *     <p>The hardware.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hardware, OperationMetadata> createHardwareAsync(
      String parent, Hardware hardware, String hardwareId) {
    CreateHardwareRequest request =
        CreateHardwareRequest.newBuilder()
            .setParent(parent)
            .setHardware(hardware)
            .setHardwareId(hardwareId)
            .build();
    return createHardwareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareRequest request =
   *       CreateHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHardwareId("hardwareId680924451")
   *           .setHardware(Hardware.newBuilder().build())
   *           .build();
   *   Hardware response = gDCHardwareManagementClient.createHardwareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hardware, OperationMetadata> createHardwareAsync(
      CreateHardwareRequest request) {
    return createHardwareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareRequest request =
   *       CreateHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHardwareId("hardwareId680924451")
   *           .setHardware(Hardware.newBuilder().build())
   *           .build();
   *   OperationFuture<Hardware, OperationMetadata> future =
   *       gDCHardwareManagementClient.createHardwareOperationCallable().futureCall(request);
   *   // Do something.
   *   Hardware response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable() {
    return stub.createHardwareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new hardware in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateHardwareRequest request =
   *       CreateHardwareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHardwareId("hardwareId680924451")
   *           .setHardware(Hardware.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createHardwareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable() {
    return stub.createHardwareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates hardware parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   Hardware hardware = Hardware.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Hardware response =
   *       gDCHardwareManagementClient.updateHardwareAsync(hardware, updateMask).get();
   * }
   * }</pre>
   *
   * @param hardware Required. The hardware to update.
   * @param updateMask Required. A mask to specify the fields in the Hardware to overwrite with this
   *     update. The fields specified in the update_mask are relative to the hardware, not the full
   *     request. A field will be overwritten if it is in the mask. If you don't provide a mask then
   *     all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hardware, OperationMetadata> updateHardwareAsync(
      Hardware hardware, FieldMask updateMask) {
    UpdateHardwareRequest request =
        UpdateHardwareRequest.newBuilder().setHardware(hardware).setUpdateMask(updateMask).build();
    return updateHardwareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates hardware parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareRequest request =
   *       UpdateHardwareRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardware(Hardware.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Hardware response = gDCHardwareManagementClient.updateHardwareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Hardware, OperationMetadata> updateHardwareAsync(
      UpdateHardwareRequest request) {
    return updateHardwareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates hardware parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareRequest request =
   *       UpdateHardwareRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardware(Hardware.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Hardware, OperationMetadata> future =
   *       gDCHardwareManagementClient.updateHardwareOperationCallable().futureCall(request);
   *   // Do something.
   *   Hardware response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable() {
    return stub.updateHardwareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates hardware parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateHardwareRequest request =
   *       UpdateHardwareRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHardware(Hardware.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.updateHardwareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable() {
    return stub.updateHardwareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes hardware.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   HardwareName name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]");
   *   gDCHardwareManagementClient.deleteHardwareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware. Format:
   *     `projects/{project}/locations/{location}/hardware/{hardware}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareAsync(HardwareName name) {
    DeleteHardwareRequest request =
        DeleteHardwareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteHardwareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes hardware.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString();
   *   gDCHardwareManagementClient.deleteHardwareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the hardware. Format:
   *     `projects/{project}/locations/{location}/hardware/{hardware}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareAsync(String name) {
    DeleteHardwareRequest request = DeleteHardwareRequest.newBuilder().setName(name).build();
    return deleteHardwareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes hardware.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareRequest request =
   *       DeleteHardwareRequest.newBuilder()
   *           .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gDCHardwareManagementClient.deleteHardwareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHardwareAsync(
      DeleteHardwareRequest request) {
    return deleteHardwareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes hardware.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareRequest request =
   *       DeleteHardwareRequest.newBuilder()
   *           .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gDCHardwareManagementClient.deleteHardwareOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable() {
    return stub.deleteHardwareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes hardware.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteHardwareRequest request =
   *       DeleteHardwareRequest.newBuilder()
   *           .setName(HardwareName.of("[PROJECT]", "[LOCATION]", "[HARDWARE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.deleteHardwareCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable() {
    return stub.deleteHardwareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the comments on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   for (Comment element : gDCHardwareManagementClient.listComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list comments on. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(OrderName parent) {
    ListCommentsRequest request =
        ListCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the comments on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   for (Comment element : gDCHardwareManagementClient.listComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list comments on. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(String parent) {
    ListCommentsRequest request = ListCommentsRequest.newBuilder().setParent(parent).build();
    return listComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the comments on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Comment element : gDCHardwareManagementClient.listComments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(ListCommentsRequest request) {
    return listCommentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the comments on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Comment> future =
   *       gDCHardwareManagementClient.listCommentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Comment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable() {
    return stub.listCommentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the comments on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCommentsResponse response =
   *         gDCHardwareManagementClient.listCommentsCallable().call(request);
   *     for (Comment element : response.getCommentsList()) {
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
  public final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    return stub.listCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the content of a comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");
   *   Comment response = gDCHardwareManagementClient.getComment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the comment. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/comments/{comment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment getComment(CommentName name) {
    GetCommentRequest request =
        GetCommentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the content of a comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString();
   *   Comment response = gDCHardwareManagementClient.getComment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the comment. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/comments/{comment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment getComment(String name) {
    GetCommentRequest request = GetCommentRequest.newBuilder().setName(name).build();
    return getComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the content of a comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetCommentRequest request =
   *       GetCommentRequest.newBuilder()
   *           .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
   *           .build();
   *   Comment response = gDCHardwareManagementClient.getComment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment getComment(GetCommentRequest request) {
    return getCommentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the content of a comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetCommentRequest request =
   *       GetCommentRequest.newBuilder()
   *           .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
   *           .build();
   *   ApiFuture<Comment> future =
   *       gDCHardwareManagementClient.getCommentCallable().futureCall(request);
   *   // Do something.
   *   Comment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCommentRequest, Comment> getCommentCallable() {
    return stub.getCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new comment on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   Comment comment = Comment.newBuilder().build();
   *   String commentId = "commentId-1495016486";
   *   Comment response =
   *       gDCHardwareManagementClient.createCommentAsync(parent, comment, commentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The order to create the comment on. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @param comment Required. The comment to create.
   * @param commentId Optional. ID used to uniquely identify the Comment within its parent scope.
   *     This field should contain at most 63 characters and must start with lowercase characters.
   *     Only lowercase characters, numbers and `-` are accepted. The `-` character cannot be the
   *     first or the last one. A system generated ID will be used if the field is not set.
   *     <p>The comment.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Comment, OperationMetadata> createCommentAsync(
      OrderName parent, Comment comment, String commentId) {
    CreateCommentRequest request =
        CreateCommentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setComment(comment)
            .setCommentId(commentId)
            .build();
    return createCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new comment on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   Comment comment = Comment.newBuilder().build();
   *   String commentId = "commentId-1495016486";
   *   Comment response =
   *       gDCHardwareManagementClient.createCommentAsync(parent, comment, commentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The order to create the comment on. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @param comment Required. The comment to create.
   * @param commentId Optional. ID used to uniquely identify the Comment within its parent scope.
   *     This field should contain at most 63 characters and must start with lowercase characters.
   *     Only lowercase characters, numbers and `-` are accepted. The `-` character cannot be the
   *     first or the last one. A system generated ID will be used if the field is not set.
   *     <p>The comment.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Comment, OperationMetadata> createCommentAsync(
      String parent, Comment comment, String commentId) {
    CreateCommentRequest request =
        CreateCommentRequest.newBuilder()
            .setParent(parent)
            .setComment(comment)
            .setCommentId(commentId)
            .build();
    return createCommentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new comment on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateCommentRequest request =
   *       CreateCommentRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setCommentId("commentId-1495016486")
   *           .setComment(Comment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Comment response = gDCHardwareManagementClient.createCommentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Comment, OperationMetadata> createCommentAsync(
      CreateCommentRequest request) {
    return createCommentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new comment on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateCommentRequest request =
   *       CreateCommentRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setCommentId("commentId-1495016486")
   *           .setComment(Comment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Comment, OperationMetadata> future =
   *       gDCHardwareManagementClient.createCommentOperationCallable().futureCall(request);
   *   // Do something.
   *   Comment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable() {
    return stub.createCommentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new comment on an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateCommentRequest request =
   *       CreateCommentRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setCommentId("commentId-1495016486")
   *           .setComment(Comment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createCommentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCommentRequest, Operation> createCommentCallable() {
    return stub.createCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Record Action on a Comment. If the Action specified in the request is READ, the viewed time in
   * the comment is set to the time the request was received. If the comment is already marked as
   * read, subsequent calls will be ignored. If the Action is UNREAD, the viewed time is cleared
   * from the comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CommentName name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]");
   *   RecordActionOnCommentRequest.ActionType actionType =
   *       RecordActionOnCommentRequest.ActionType.forNumber(0);
   *   Comment response = gDCHardwareManagementClient.recordActionOnComment(name, actionType);
   * }
   * }</pre>
   *
   * @param name Required. The name of the comment. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/comments/{comment}`
   * @param actionType Required. The action type of the recorded action.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment recordActionOnComment(
      CommentName name, RecordActionOnCommentRequest.ActionType actionType) {
    RecordActionOnCommentRequest request =
        RecordActionOnCommentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setActionType(actionType)
            .build();
    return recordActionOnComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Record Action on a Comment. If the Action specified in the request is READ, the viewed time in
   * the comment is set to the time the request was received. If the comment is already marked as
   * read, subsequent calls will be ignored. If the Action is UNREAD, the viewed time is cleared
   * from the comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString();
   *   RecordActionOnCommentRequest.ActionType actionType =
   *       RecordActionOnCommentRequest.ActionType.forNumber(0);
   *   Comment response = gDCHardwareManagementClient.recordActionOnComment(name, actionType);
   * }
   * }</pre>
   *
   * @param name Required. The name of the comment. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/comments/{comment}`
   * @param actionType Required. The action type of the recorded action.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment recordActionOnComment(
      String name, RecordActionOnCommentRequest.ActionType actionType) {
    RecordActionOnCommentRequest request =
        RecordActionOnCommentRequest.newBuilder().setName(name).setActionType(actionType).build();
    return recordActionOnComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Record Action on a Comment. If the Action specified in the request is READ, the viewed time in
   * the comment is set to the time the request was received. If the comment is already marked as
   * read, subsequent calls will be ignored. If the Action is UNREAD, the viewed time is cleared
   * from the comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   RecordActionOnCommentRequest request =
   *       RecordActionOnCommentRequest.newBuilder()
   *           .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
   *           .build();
   *   Comment response = gDCHardwareManagementClient.recordActionOnComment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment recordActionOnComment(RecordActionOnCommentRequest request) {
    return recordActionOnCommentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Record Action on a Comment. If the Action specified in the request is READ, the viewed time in
   * the comment is set to the time the request was received. If the comment is already marked as
   * read, subsequent calls will be ignored. If the Action is UNREAD, the viewed time is cleared
   * from the comment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   RecordActionOnCommentRequest request =
   *       RecordActionOnCommentRequest.newBuilder()
   *           .setName(CommentName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[COMMENT]").toString())
   *           .build();
   *   ApiFuture<Comment> future =
   *       gDCHardwareManagementClient.recordActionOnCommentCallable().futureCall(request);
   *   // Do something.
   *   Comment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecordActionOnCommentRequest, Comment>
      recordActionOnCommentCallable() {
    return stub.recordActionOnCommentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changes made to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   OrderName parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]");
   *   for (ChangeLogEntry element :
   *       gDCHardwareManagementClient.listChangeLogEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list change log entries for. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeLogEntriesPagedResponse listChangeLogEntries(OrderName parent) {
    ListChangeLogEntriesRequest request =
        ListChangeLogEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChangeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changes made to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString();
   *   for (ChangeLogEntry element :
   *       gDCHardwareManagementClient.listChangeLogEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The order to list change log entries for. Format:
   *     `projects/{project}/locations/{location}/orders/{order}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeLogEntriesPagedResponse listChangeLogEntries(String parent) {
    ListChangeLogEntriesRequest request =
        ListChangeLogEntriesRequest.newBuilder().setParent(parent).build();
    return listChangeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changes made to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListChangeLogEntriesRequest request =
   *       ListChangeLogEntriesRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ChangeLogEntry element :
   *       gDCHardwareManagementClient.listChangeLogEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangeLogEntriesPagedResponse listChangeLogEntries(
      ListChangeLogEntriesRequest request) {
    return listChangeLogEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changes made to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListChangeLogEntriesRequest request =
   *       ListChangeLogEntriesRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ChangeLogEntry> future =
   *       gDCHardwareManagementClient.listChangeLogEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChangeLogEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable() {
    return stub.listChangeLogEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changes made to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListChangeLogEntriesRequest request =
   *       ListChangeLogEntriesRequest.newBuilder()
   *           .setParent(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChangeLogEntriesResponse response =
   *         gDCHardwareManagementClient.listChangeLogEntriesCallable().call(request);
   *     for (ChangeLogEntry element : response.getChangeLogEntriesList()) {
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
  public final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable() {
    return stub.listChangeLogEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a change to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ChangeLogEntryName name =
   *       ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]");
   *   ChangeLogEntry response = gDCHardwareManagementClient.getChangeLogEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the change log entry. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/changeLogEntries/{change_log_entry}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeLogEntry getChangeLogEntry(ChangeLogEntryName name) {
    GetChangeLogEntryRequest request =
        GetChangeLogEntryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getChangeLogEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a change to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name =
   *       ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]")
   *           .toString();
   *   ChangeLogEntry response = gDCHardwareManagementClient.getChangeLogEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the change log entry. Format:
   *     `projects/{project}/locations/{location}/orders/{order}/changeLogEntries/{change_log_entry}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeLogEntry getChangeLogEntry(String name) {
    GetChangeLogEntryRequest request = GetChangeLogEntryRequest.newBuilder().setName(name).build();
    return getChangeLogEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a change to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetChangeLogEntryRequest request =
   *       GetChangeLogEntryRequest.newBuilder()
   *           .setName(
   *               ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]")
   *                   .toString())
   *           .build();
   *   ChangeLogEntry response = gDCHardwareManagementClient.getChangeLogEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChangeLogEntry getChangeLogEntry(GetChangeLogEntryRequest request) {
    return getChangeLogEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a change to an order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetChangeLogEntryRequest request =
   *       GetChangeLogEntryRequest.newBuilder()
   *           .setName(
   *               ChangeLogEntryName.of("[PROJECT]", "[LOCATION]", "[ORDER]", "[CHANGE_LOG_ENTRY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ChangeLogEntry> future =
   *       gDCHardwareManagementClient.getChangeLogEntryCallable().futureCall(request);
   *   // Do something.
   *   ChangeLogEntry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable() {
    return stub.getChangeLogEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKUs for a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Sku element : gDCHardwareManagementClient.listSkus(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list SKUs in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list SKUs across all locations, substitute `-` (the hyphen or dash character) for the
   *     location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(LocationName parent) {
    ListSkusRequest request =
        ListSkusRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSkus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKUs for a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Sku element : gDCHardwareManagementClient.listSkus(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list SKUs in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list SKUs across all locations, substitute `-` (the hyphen or dash character) for the
   *     location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(String parent) {
    ListSkusRequest request = ListSkusRequest.newBuilder().setParent(parent).build();
    return listSkus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKUs for a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Sku element : gDCHardwareManagementClient.listSkus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(ListSkusRequest request) {
    return listSkusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKUs for a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Sku> future =
   *       gDCHardwareManagementClient.listSkusPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Sku element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return stub.listSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists SKUs for a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSkusResponse response = gDCHardwareManagementClient.listSkusCallable().call(request);
   *     for (Sku element : response.getSkusList()) {
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
  public final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return stub.listSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SkuName name = SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]");
   *   Sku response = gDCHardwareManagementClient.getSku(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SKU. Format:
   *     `projects/{project}/locations/{location}/skus/{sku}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(SkuName name) {
    GetSkuRequest request =
        GetSkuRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSku(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]").toString();
   *   Sku response = gDCHardwareManagementClient.getSku(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SKU. Format:
   *     `projects/{project}/locations/{location}/skus/{sku}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(String name) {
    GetSkuRequest request = GetSkuRequest.newBuilder().setName(name).build();
    return getSku(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetSkuRequest request =
   *       GetSkuRequest.newBuilder()
   *           .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]").toString())
   *           .build();
   *   Sku response = gDCHardwareManagementClient.getSku(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Sku getSku(GetSkuRequest request) {
    return getSkuCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of an SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetSkuRequest request =
   *       GetSkuRequest.newBuilder()
   *           .setName(SkuName.of("[PROJECT]", "[LOCATION]", "[SKU]").toString())
   *           .build();
   *   ApiFuture<Sku> future = gDCHardwareManagementClient.getSkuCallable().futureCall(request);
   *   // Do something.
   *   Sku response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    return stub.getSkuCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Zone element : gDCHardwareManagementClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list zones in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list zones across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(LocationName parent) {
    ListZonesRequest request =
        ListZonesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Zone element : gDCHardwareManagementClient.listZones(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list zones in. Format:
   *     `projects/{project}/locations/{location}`
   *     <p>To list zones across all locations, substitute `-` (the hyphen or dash character) for
   *     the location and check the unreachable field in the response message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListZonesPagedResponse listZones(String parent) {
    ListZonesRequest request = ListZonesRequest.newBuilder().setParent(parent).build();
    return listZones(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Zone element : gDCHardwareManagementClient.listZones(request).iterateAll()) {
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
   * Lists zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Zone> future =
   *       gDCHardwareManagementClient.listZonesPagedCallable().futureCall(request);
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
   * Lists zones in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListZonesRequest request =
   *       ListZonesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListZonesResponse response = gDCHardwareManagementClient.listZonesCallable().call(request);
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
   * Gets details of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   Zone response = gDCHardwareManagementClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(ZoneName name) {
    GetZoneRequest request =
        GetZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   Zone response = gDCHardwareManagementClient.getZone(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Zone getZone(String name) {
    GetZoneRequest request = GetZoneRequest.newBuilder().setName(name).build();
    return getZone(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   Zone response = gDCHardwareManagementClient.getZone(request);
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
   * Gets details of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetZoneRequest request =
   *       GetZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .build();
   *   ApiFuture<Zone> future = gDCHardwareManagementClient.getZoneCallable().futureCall(request);
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
   * Creates a new zone in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Zone zone = Zone.newBuilder().build();
   *   String zoneId = "zoneId-696323609";
   *   Zone response = gDCHardwareManagementClient.createZoneAsync(parent, zone, zoneId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the zone in. Format:
   *     `projects/{project}/locations/{location}`
   * @param zone Required. The zone to create.
   * @param zoneId Optional. ID used to uniquely identify the Zone within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The zone.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(
      LocationName parent, Zone zone, String zoneId) {
    CreateZoneRequest request =
        CreateZoneRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setZone(zone)
            .setZoneId(zoneId)
            .build();
    return createZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Zone zone = Zone.newBuilder().build();
   *   String zoneId = "zoneId-696323609";
   *   Zone response = gDCHardwareManagementClient.createZoneAsync(parent, zone, zoneId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the zone in. Format:
   *     `projects/{project}/locations/{location}`
   * @param zone Required. The zone to create.
   * @param zoneId Optional. ID used to uniquely identify the Zone within its parent scope. This
   *     field should contain at most 63 characters and must start with lowercase characters. Only
   *     lowercase characters, numbers and `-` are accepted. The `-` character cannot be the first
   *     or the last one. A system generated ID will be used if the field is not set.
   *     <p>The zone.name field in the request will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(
      String parent, Zone zone, String zoneId) {
    CreateZoneRequest request =
        CreateZoneRequest.newBuilder().setParent(parent).setZone(zone).setZoneId(zoneId).build();
    return createZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Zone response = gDCHardwareManagementClient.createZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> createZoneAsync(CreateZoneRequest request) {
    return createZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Zone, OperationMetadata> future =
   *       gDCHardwareManagementClient.createZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    return stub.createZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new zone in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   CreateZoneRequest request =
   *       CreateZoneRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setZoneId("zoneId-696323609")
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.createZoneCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    return stub.createZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   Zone zone = Zone.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Zone response = gDCHardwareManagementClient.updateZoneAsync(zone, updateMask).get();
   * }
   * }</pre>
   *
   * @param zone Required. The zone to update.
   * @param updateMask Required. A mask to specify the fields in the Zone to overwrite with this
   *     update. The fields specified in the update_mask are relative to the zone, not the full
   *     request. A field will be overwritten if it is in the mask. If you don't provide a mask then
   *     all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> updateZoneAsync(
      Zone zone, FieldMask updateMask) {
    UpdateZoneRequest request =
        UpdateZoneRequest.newBuilder().setZone(zone).setUpdateMask(updateMask).build();
    return updateZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Zone response = gDCHardwareManagementClient.updateZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> updateZoneAsync(UpdateZoneRequest request) {
    return updateZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Zone, OperationMetadata> future =
   *       gDCHardwareManagementClient.updateZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    return stub.updateZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   UpdateZoneRequest request =
   *       UpdateZoneRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setZone(Zone.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.updateZoneCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    return stub.updateZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   gDCHardwareManagementClient.deleteZoneAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(ZoneName name) {
    DeleteZoneRequest request =
        DeleteZoneRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   gDCHardwareManagementClient.deleteZoneAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(String name) {
    DeleteZoneRequest request = DeleteZoneRequest.newBuilder().setName(name).build();
    return deleteZoneAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   gDCHardwareManagementClient.deleteZoneAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteZoneAsync(
      DeleteZoneRequest request) {
    return deleteZoneOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       gDCHardwareManagementClient.deleteZoneOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    return stub.deleteZoneOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   DeleteZoneRequest request =
   *       DeleteZoneRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.deleteZoneCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    return stub.deleteZoneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signals the state of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]");
   *   SignalZoneStateRequest.StateSignal stateSignal =
   *       SignalZoneStateRequest.StateSignal.forNumber(0);
   *   Zone response = gDCHardwareManagementClient.signalZoneStateAsync(name, stateSignal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @param stateSignal Optional. The state signal to send for this zone. Either state_signal or
   *     provisioning_state_signal must be set, but not both.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> signalZoneStateAsync(
      ZoneName name, SignalZoneStateRequest.StateSignal stateSignal) {
    SignalZoneStateRequest request =
        SignalZoneStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setStateSignal(stateSignal)
            .build();
    return signalZoneStateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signals the state of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   String name = ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString();
   *   SignalZoneStateRequest.StateSignal stateSignal =
   *       SignalZoneStateRequest.StateSignal.forNumber(0);
   *   Zone response = gDCHardwareManagementClient.signalZoneStateAsync(name, stateSignal).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the zone. Format:
   *     `projects/{project}/locations/{location}/zones/{zone}`
   * @param stateSignal Optional. The state signal to send for this zone. Either state_signal or
   *     provisioning_state_signal must be set, but not both.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> signalZoneStateAsync(
      String name, SignalZoneStateRequest.StateSignal stateSignal) {
    SignalZoneStateRequest request =
        SignalZoneStateRequest.newBuilder().setName(name).setStateSignal(stateSignal).build();
    return signalZoneStateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signals the state of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SignalZoneStateRequest request =
   *       SignalZoneStateRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Zone response = gDCHardwareManagementClient.signalZoneStateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Zone, OperationMetadata> signalZoneStateAsync(
      SignalZoneStateRequest request) {
    return signalZoneStateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signals the state of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SignalZoneStateRequest request =
   *       SignalZoneStateRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Zone, OperationMetadata> future =
   *       gDCHardwareManagementClient.signalZoneStateOperationCallable().futureCall(request);
   *   // Do something.
   *   Zone response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable() {
    return stub.signalZoneStateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signals the state of a zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   SignalZoneStateRequest request =
   *       SignalZoneStateRequest.newBuilder()
   *           .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[ZONE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       gDCHardwareManagementClient.signalZoneStateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable() {
    return stub.signalZoneStateCallable();
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
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : gDCHardwareManagementClient.listLocations(request).iterateAll()) {
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
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       gDCHardwareManagementClient.listLocationsPagedCallable().futureCall(request);
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
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         gDCHardwareManagementClient.listLocationsCallable().call(request);
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
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = gDCHardwareManagementClient.getLocation(request);
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
   * try (GDCHardwareManagementClient gDCHardwareManagementClient =
   *     GDCHardwareManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       gDCHardwareManagementClient.getLocationCallable().futureCall(request);
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

  public static class ListOrdersPagedResponse
      extends AbstractPagedListResponse<
          ListOrdersRequest,
          ListOrdersResponse,
          Order,
          ListOrdersPage,
          ListOrdersFixedSizeCollection> {

    public static ApiFuture<ListOrdersPagedResponse> createAsync(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ApiFuture<ListOrdersResponse> futureResponse) {
      ApiFuture<ListOrdersPage> futurePage =
          ListOrdersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListOrdersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListOrdersPagedResponse(ListOrdersPage page) {
      super(page, ListOrdersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrdersPage
      extends AbstractPage<ListOrdersRequest, ListOrdersResponse, Order, ListOrdersPage> {

    private ListOrdersPage(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ListOrdersResponse response) {
      super(context, response);
    }

    private static ListOrdersPage createEmptyPage() {
      return new ListOrdersPage(null, null);
    }

    @Override
    protected ListOrdersPage createPage(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ListOrdersResponse response) {
      return new ListOrdersPage(context, response);
    }

    @Override
    public ApiFuture<ListOrdersPage> createPageAsync(
        PageContext<ListOrdersRequest, ListOrdersResponse, Order> context,
        ApiFuture<ListOrdersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrdersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrdersRequest,
          ListOrdersResponse,
          Order,
          ListOrdersPage,
          ListOrdersFixedSizeCollection> {

    private ListOrdersFixedSizeCollection(List<ListOrdersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrdersFixedSizeCollection createEmptyCollection() {
      return new ListOrdersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrdersFixedSizeCollection createCollection(
        List<ListOrdersPage> pages, int collectionSize) {
      return new ListOrdersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSitesPagedResponse
      extends AbstractPagedListResponse<
          ListSitesRequest, ListSitesResponse, Site, ListSitesPage, ListSitesFixedSizeCollection> {

    public static ApiFuture<ListSitesPagedResponse> createAsync(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ApiFuture<ListSitesResponse> futureResponse) {
      ApiFuture<ListSitesPage> futurePage =
          ListSitesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSitesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSitesPagedResponse(ListSitesPage page) {
      super(page, ListSitesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSitesPage
      extends AbstractPage<ListSitesRequest, ListSitesResponse, Site, ListSitesPage> {

    private ListSitesPage(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ListSitesResponse response) {
      super(context, response);
    }

    private static ListSitesPage createEmptyPage() {
      return new ListSitesPage(null, null);
    }

    @Override
    protected ListSitesPage createPage(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ListSitesResponse response) {
      return new ListSitesPage(context, response);
    }

    @Override
    public ApiFuture<ListSitesPage> createPageAsync(
        PageContext<ListSitesRequest, ListSitesResponse, Site> context,
        ApiFuture<ListSitesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSitesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSitesRequest, ListSitesResponse, Site, ListSitesPage, ListSitesFixedSizeCollection> {

    private ListSitesFixedSizeCollection(List<ListSitesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSitesFixedSizeCollection createEmptyCollection() {
      return new ListSitesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSitesFixedSizeCollection createCollection(
        List<ListSitesPage> pages, int collectionSize) {
      return new ListSitesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHardwareGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListHardwareGroupsRequest,
          ListHardwareGroupsResponse,
          HardwareGroup,
          ListHardwareGroupsPage,
          ListHardwareGroupsFixedSizeCollection> {

    public static ApiFuture<ListHardwareGroupsPagedResponse> createAsync(
        PageContext<ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup> context,
        ApiFuture<ListHardwareGroupsResponse> futureResponse) {
      ApiFuture<ListHardwareGroupsPage> futurePage =
          ListHardwareGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHardwareGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHardwareGroupsPagedResponse(ListHardwareGroupsPage page) {
      super(page, ListHardwareGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHardwareGroupsPage
      extends AbstractPage<
          ListHardwareGroupsRequest,
          ListHardwareGroupsResponse,
          HardwareGroup,
          ListHardwareGroupsPage> {

    private ListHardwareGroupsPage(
        PageContext<ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup> context,
        ListHardwareGroupsResponse response) {
      super(context, response);
    }

    private static ListHardwareGroupsPage createEmptyPage() {
      return new ListHardwareGroupsPage(null, null);
    }

    @Override
    protected ListHardwareGroupsPage createPage(
        PageContext<ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup> context,
        ListHardwareGroupsResponse response) {
      return new ListHardwareGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListHardwareGroupsPage> createPageAsync(
        PageContext<ListHardwareGroupsRequest, ListHardwareGroupsResponse, HardwareGroup> context,
        ApiFuture<ListHardwareGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHardwareGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHardwareGroupsRequest,
          ListHardwareGroupsResponse,
          HardwareGroup,
          ListHardwareGroupsPage,
          ListHardwareGroupsFixedSizeCollection> {

    private ListHardwareGroupsFixedSizeCollection(
        List<ListHardwareGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHardwareGroupsFixedSizeCollection createEmptyCollection() {
      return new ListHardwareGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHardwareGroupsFixedSizeCollection createCollection(
        List<ListHardwareGroupsPage> pages, int collectionSize) {
      return new ListHardwareGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHardwarePagedResponse
      extends AbstractPagedListResponse<
          ListHardwareRequest,
          ListHardwareResponse,
          Hardware,
          ListHardwarePage,
          ListHardwareFixedSizeCollection> {

    public static ApiFuture<ListHardwarePagedResponse> createAsync(
        PageContext<ListHardwareRequest, ListHardwareResponse, Hardware> context,
        ApiFuture<ListHardwareResponse> futureResponse) {
      ApiFuture<ListHardwarePage> futurePage =
          ListHardwarePage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHardwarePagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHardwarePagedResponse(ListHardwarePage page) {
      super(page, ListHardwareFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHardwarePage
      extends AbstractPage<ListHardwareRequest, ListHardwareResponse, Hardware, ListHardwarePage> {

    private ListHardwarePage(
        PageContext<ListHardwareRequest, ListHardwareResponse, Hardware> context,
        ListHardwareResponse response) {
      super(context, response);
    }

    private static ListHardwarePage createEmptyPage() {
      return new ListHardwarePage(null, null);
    }

    @Override
    protected ListHardwarePage createPage(
        PageContext<ListHardwareRequest, ListHardwareResponse, Hardware> context,
        ListHardwareResponse response) {
      return new ListHardwarePage(context, response);
    }

    @Override
    public ApiFuture<ListHardwarePage> createPageAsync(
        PageContext<ListHardwareRequest, ListHardwareResponse, Hardware> context,
        ApiFuture<ListHardwareResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHardwareFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHardwareRequest,
          ListHardwareResponse,
          Hardware,
          ListHardwarePage,
          ListHardwareFixedSizeCollection> {

    private ListHardwareFixedSizeCollection(List<ListHardwarePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHardwareFixedSizeCollection createEmptyCollection() {
      return new ListHardwareFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHardwareFixedSizeCollection createCollection(
        List<ListHardwarePage> pages, int collectionSize) {
      return new ListHardwareFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCommentsPagedResponse
      extends AbstractPagedListResponse<
          ListCommentsRequest,
          ListCommentsResponse,
          Comment,
          ListCommentsPage,
          ListCommentsFixedSizeCollection> {

    public static ApiFuture<ListCommentsPagedResponse> createAsync(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ApiFuture<ListCommentsResponse> futureResponse) {
      ApiFuture<ListCommentsPage> futurePage =
          ListCommentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCommentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCommentsPagedResponse(ListCommentsPage page) {
      super(page, ListCommentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCommentsPage
      extends AbstractPage<ListCommentsRequest, ListCommentsResponse, Comment, ListCommentsPage> {

    private ListCommentsPage(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ListCommentsResponse response) {
      super(context, response);
    }

    private static ListCommentsPage createEmptyPage() {
      return new ListCommentsPage(null, null);
    }

    @Override
    protected ListCommentsPage createPage(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ListCommentsResponse response) {
      return new ListCommentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCommentsPage> createPageAsync(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ApiFuture<ListCommentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCommentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCommentsRequest,
          ListCommentsResponse,
          Comment,
          ListCommentsPage,
          ListCommentsFixedSizeCollection> {

    private ListCommentsFixedSizeCollection(List<ListCommentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCommentsFixedSizeCollection createEmptyCollection() {
      return new ListCommentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCommentsFixedSizeCollection createCollection(
        List<ListCommentsPage> pages, int collectionSize) {
      return new ListCommentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChangeLogEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ChangeLogEntry,
          ListChangeLogEntriesPage,
          ListChangeLogEntriesFixedSizeCollection> {

    public static ApiFuture<ListChangeLogEntriesPagedResponse> createAsync(
        PageContext<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
            context,
        ApiFuture<ListChangeLogEntriesResponse> futureResponse) {
      ApiFuture<ListChangeLogEntriesPage> futurePage =
          ListChangeLogEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChangeLogEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChangeLogEntriesPagedResponse(ListChangeLogEntriesPage page) {
      super(page, ListChangeLogEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChangeLogEntriesPage
      extends AbstractPage<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ChangeLogEntry,
          ListChangeLogEntriesPage> {

    private ListChangeLogEntriesPage(
        PageContext<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
            context,
        ListChangeLogEntriesResponse response) {
      super(context, response);
    }

    private static ListChangeLogEntriesPage createEmptyPage() {
      return new ListChangeLogEntriesPage(null, null);
    }

    @Override
    protected ListChangeLogEntriesPage createPage(
        PageContext<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
            context,
        ListChangeLogEntriesResponse response) {
      return new ListChangeLogEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListChangeLogEntriesPage> createPageAsync(
        PageContext<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse, ChangeLogEntry>
            context,
        ApiFuture<ListChangeLogEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChangeLogEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChangeLogEntriesRequest,
          ListChangeLogEntriesResponse,
          ChangeLogEntry,
          ListChangeLogEntriesPage,
          ListChangeLogEntriesFixedSizeCollection> {

    private ListChangeLogEntriesFixedSizeCollection(
        List<ListChangeLogEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChangeLogEntriesFixedSizeCollection createEmptyCollection() {
      return new ListChangeLogEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChangeLogEntriesFixedSizeCollection createCollection(
        List<ListChangeLogEntriesPage> pages, int collectionSize) {
      return new ListChangeLogEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkusPagedResponse
      extends AbstractPagedListResponse<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    public static ApiFuture<ListSkusPagedResponse> createAsync(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      ApiFuture<ListSkusPage> futurePage =
          ListSkusPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSkusPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSkusPagedResponse(ListSkusPage page) {
      super(page, ListSkusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkusPage
      extends AbstractPage<ListSkusRequest, ListSkusResponse, Sku, ListSkusPage> {

    private ListSkusPage(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context, ListSkusResponse response) {
      super(context, response);
    }

    private static ListSkusPage createEmptyPage() {
      return new ListSkusPage(null, null);
    }

    @Override
    protected ListSkusPage createPage(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context, ListSkusResponse response) {
      return new ListSkusPage(context, response);
    }

    @Override
    public ApiFuture<ListSkusPage> createPageAsync(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    private ListSkusFixedSizeCollection(List<ListSkusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkusFixedSizeCollection createEmptyCollection() {
      return new ListSkusFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkusFixedSizeCollection createCollection(
        List<ListSkusPage> pages, int collectionSize) {
      return new ListSkusFixedSizeCollection(pages, collectionSize);
    }
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
