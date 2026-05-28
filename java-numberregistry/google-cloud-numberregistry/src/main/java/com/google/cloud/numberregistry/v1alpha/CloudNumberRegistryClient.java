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

package com.google.cloud.numberregistry.v1alpha;

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
import com.google.cloud.numberregistry.v1alpha.stub.CloudNumberRegistryStub;
import com.google.cloud.numberregistry.v1alpha.stub.CloudNumberRegistryStubSettings;
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
 * Service Description: The Cloud Number Registry service manages IP address space visibility and
 * tracking. It enables the discovery, organization, and monitoring of IP address ranges across
 * different cloud infrastructure platforms.
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
 * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
 *   IpamAdminScopeName name =
 *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
 *   IpamAdminScope response = cloudNumberRegistryClient.getIpamAdminScope(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudNumberRegistryClient object to clean up resources
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
 *      <td><p> ListIpamAdminScopes</td>
 *      <td><p> Lists IpamAdminScopes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIpamAdminScopes(ListIpamAdminScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIpamAdminScopes(LocationName parent)
 *           <li><p> listIpamAdminScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIpamAdminScopesPagedCallable()
 *           <li><p> listIpamAdminScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIpamAdminScope</td>
 *      <td><p> Gets details of a single IpamAdminScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIpamAdminScope(GetIpamAdminScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIpamAdminScope(IpamAdminScopeName name)
 *           <li><p> getIpamAdminScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CheckAvailabilityIpamAdminScopes</td>
 *      <td><p> Checks the availability of IpamAdminScopes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> checkAvailabilityIpamAdminScopes(CheckAvailabilityIpamAdminScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> checkAvailabilityIpamAdminScopes(LocationName parent, List&lt;String&gt; scopes)
 *           <li><p> checkAvailabilityIpamAdminScopes(String parent, List&lt;String&gt; scopes)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> checkAvailabilityIpamAdminScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateIpamAdminScope</td>
 *      <td><p> Creates a new IpamAdminScope in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIpamAdminScopeAsync(CreateIpamAdminScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIpamAdminScopeAsync(LocationName parent, IpamAdminScope ipamAdminScope, String ipamAdminScopeId)
 *           <li><p> createIpamAdminScopeAsync(String parent, IpamAdminScope ipamAdminScope, String ipamAdminScopeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIpamAdminScopeOperationCallable()
 *           <li><p> createIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIpamAdminScope</td>
 *      <td><p> Updates the parameters of a single IpamAdminScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIpamAdminScopeAsync(UpdateIpamAdminScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateIpamAdminScopeAsync(IpamAdminScope ipamAdminScope, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIpamAdminScopeOperationCallable()
 *           <li><p> updateIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIpamAdminScope</td>
 *      <td><p> Deletes a single IpamAdminScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIpamAdminScopeAsync(DeleteIpamAdminScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteIpamAdminScopeAsync(IpamAdminScopeName name)
 *           <li><p> deleteIpamAdminScopeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIpamAdminScopeOperationCallable()
 *           <li><p> deleteIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableIpamAdminScope</td>
 *      <td><p> Disables a single IpamAdminScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableIpamAdminScopeAsync(DisableIpamAdminScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disableIpamAdminScopeAsync(IpamAdminScopeName name)
 *           <li><p> disableIpamAdminScopeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableIpamAdminScopeOperationCallable()
 *           <li><p> disableIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CleanupIpamAdminScope</td>
 *      <td><p> Cleans up a single IpamAdminScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cleanupIpamAdminScopeAsync(CleanupIpamAdminScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cleanupIpamAdminScopeAsync(IpamAdminScopeName name)
 *           <li><p> cleanupIpamAdminScopeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cleanupIpamAdminScopeOperationCallable()
 *           <li><p> cleanupIpamAdminScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRegistryBooks</td>
 *      <td><p> Lists RegistryBooks in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRegistryBooks(ListRegistryBooksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRegistryBooks(LocationName parent)
 *           <li><p> listRegistryBooks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRegistryBooksPagedCallable()
 *           <li><p> listRegistryBooksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRegistryBook</td>
 *      <td><p> Gets details of a single RegistryBook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRegistryBook(GetRegistryBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRegistryBook(RegistryBookName name)
 *           <li><p> getRegistryBook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRegistryBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchIpResources</td>
 *      <td><p> Searches IP resources in a given RegistryBook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchIpResources(SearchIpResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchIpResources(RegistryBookName name)
 *           <li><p> searchIpResources(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchIpResourcesPagedCallable()
 *           <li><p> searchIpResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRegistryBook</td>
 *      <td><p> Creates a new RegistryBook in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRegistryBookAsync(CreateRegistryBookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRegistryBookAsync(LocationName parent, RegistryBook registryBook, String registryBookId)
 *           <li><p> createRegistryBookAsync(String parent, RegistryBook registryBook, String registryBookId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRegistryBookOperationCallable()
 *           <li><p> createRegistryBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRegistryBook</td>
 *      <td><p> Updates the parameters of a single RegistryBook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRegistryBookAsync(UpdateRegistryBookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRegistryBookAsync(RegistryBook registryBook, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRegistryBookOperationCallable()
 *           <li><p> updateRegistryBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRegistryBook</td>
 *      <td><p> Deletes a single RegistryBook.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRegistryBookAsync(DeleteRegistryBookRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRegistryBookAsync(RegistryBookName name)
 *           <li><p> deleteRegistryBookAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRegistryBookOperationCallable()
 *           <li><p> deleteRegistryBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRealms</td>
 *      <td><p> Lists Realms in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRealms(ListRealmsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRealms(LocationName parent)
 *           <li><p> listRealms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRealmsPagedCallable()
 *           <li><p> listRealmsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRealm</td>
 *      <td><p> Gets details of a single Realm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRealm(GetRealmRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRealm(RealmName name)
 *           <li><p> getRealm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRealm</td>
 *      <td><p> Creates a new Realm in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRealmAsync(CreateRealmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRealmAsync(LocationName parent, Realm realm, String realmId)
 *           <li><p> createRealmAsync(String parent, Realm realm, String realmId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRealmOperationCallable()
 *           <li><p> createRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRealm</td>
 *      <td><p> Updates the parameters of a single Realm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRealmAsync(UpdateRealmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRealmAsync(Realm realm, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRealmOperationCallable()
 *           <li><p> updateRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRealm</td>
 *      <td><p> Deletes a single Realm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRealmAsync(DeleteRealmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRealmAsync(RealmName name)
 *           <li><p> deleteRealmAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRealmOperationCallable()
 *           <li><p> deleteRealmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDiscoveredRanges</td>
 *      <td><p> Lists DiscoveredRanges in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiscoveredRanges(ListDiscoveredRangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiscoveredRanges(LocationName parent)
 *           <li><p> listDiscoveredRanges(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiscoveredRangesPagedCallable()
 *           <li><p> listDiscoveredRangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiscoveredRange</td>
 *      <td><p> Gets details of a single DiscoveredRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiscoveredRange(GetDiscoveredRangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiscoveredRange(DiscoveredRangeName name)
 *           <li><p> getDiscoveredRange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiscoveredRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FindDiscoveredRangeFreeIpRanges</td>
 *      <td><p> Finds free IP ranges in a single DiscoveredRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findDiscoveredRangeFreeIpRanges(FindDiscoveredRangeFreeIpRangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> findDiscoveredRangeFreeIpRanges(DiscoveredRangeName name, int cidrPrefixLength)
 *           <li><p> findDiscoveredRangeFreeIpRanges(String name, int cidrPrefixLength)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findDiscoveredRangeFreeIpRangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomRanges</td>
 *      <td><p> Lists CustomRanges in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomRanges(ListCustomRangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomRanges(LocationName parent)
 *           <li><p> listCustomRanges(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomRangesPagedCallable()
 *           <li><p> listCustomRangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCustomRange</td>
 *      <td><p> Gets details of a single CustomRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomRange(GetCustomRangeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomRange(CustomRangeName name)
 *           <li><p> getCustomRange(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ShowCustomRangeUtilization</td>
 *      <td><p> Gets the details of a single CustomRange and its utilization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showCustomRangeUtilization(ShowCustomRangeUtilizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showCustomRangeUtilization(CustomRangeName name)
 *           <li><p> showCustomRangeUtilization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showCustomRangeUtilizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ShowDiscoveredRangeUtilization</td>
 *      <td><p> Gets the details of a single DiscoveredRange and its utilization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showDiscoveredRangeUtilization(ShowDiscoveredRangeUtilizationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showDiscoveredRangeUtilization(DiscoveredRangeName name)
 *           <li><p> showDiscoveredRangeUtilization(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showDiscoveredRangeUtilizationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FindCustomRangeFreeIpRanges</td>
 *      <td><p> Finds free IP ranges in a single CustomRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findCustomRangeFreeIpRanges(FindCustomRangeFreeIpRangesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> findCustomRangeFreeIpRanges(CustomRangeName name, int cidrPrefixLength)
 *           <li><p> findCustomRangeFreeIpRanges(String name, int cidrPrefixLength)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findCustomRangeFreeIpRangesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCustomRange</td>
 *      <td><p> Creates a new CustomRange in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCustomRangeAsync(CreateCustomRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCustomRangeAsync(LocationName parent, CustomRange customRange, String customRangeId)
 *           <li><p> createCustomRangeAsync(String parent, CustomRange customRange, String customRangeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCustomRangeOperationCallable()
 *           <li><p> createCustomRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCustomRange</td>
 *      <td><p> Updates the parameters of a single CustomRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCustomRangeAsync(UpdateCustomRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateCustomRangeAsync(CustomRange customRange, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCustomRangeOperationCallable()
 *           <li><p> updateCustomRangeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCustomRange</td>
 *      <td><p> Deletes a single CustomRange.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCustomRangeAsync(DeleteCustomRangeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCustomRangeAsync(CustomRangeName name)
 *           <li><p> deleteCustomRangeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCustomRangeOperationCallable()
 *           <li><p> deleteCustomRangeCallable()
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
 * <p>This class can be customized by passing in a custom instance of CloudNumberRegistrySettings to
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
 * CloudNumberRegistrySettings cloudNumberRegistrySettings =
 *     CloudNumberRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudNumberRegistryClient cloudNumberRegistryClient =
 *     CloudNumberRegistryClient.create(cloudNumberRegistrySettings);
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
 * CloudNumberRegistrySettings cloudNumberRegistrySettings =
 *     CloudNumberRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudNumberRegistryClient cloudNumberRegistryClient =
 *     CloudNumberRegistryClient.create(cloudNumberRegistrySettings);
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
 * CloudNumberRegistrySettings cloudNumberRegistrySettings =
 *     CloudNumberRegistrySettings.newHttpJsonBuilder().build();
 * CloudNumberRegistryClient cloudNumberRegistryClient =
 *     CloudNumberRegistryClient.create(cloudNumberRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudNumberRegistryClient implements BackgroundResource {
  private final CloudNumberRegistrySettings settings;
  private final CloudNumberRegistryStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudNumberRegistryClient with default settings. */
  public static final CloudNumberRegistryClient create() throws IOException {
    return create(CloudNumberRegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudNumberRegistryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudNumberRegistryClient create(CloudNumberRegistrySettings settings)
      throws IOException {
    return new CloudNumberRegistryClient(settings);
  }

  /**
   * Constructs an instance of CloudNumberRegistryClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CloudNumberRegistrySettings).
   */
  public static final CloudNumberRegistryClient create(CloudNumberRegistryStub stub) {
    return new CloudNumberRegistryClient(stub);
  }

  /**
   * Constructs an instance of CloudNumberRegistryClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudNumberRegistryClient(CloudNumberRegistrySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudNumberRegistryStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudNumberRegistryClient(CloudNumberRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudNumberRegistrySettings getSettings() {
    return settings;
  }

  public CloudNumberRegistryStub getStub() {
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
   * Lists IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (IpamAdminScope element :
   *       cloudNumberRegistryClient.listIpamAdminScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIpamAdminScopesPagedResponse listIpamAdminScopes(LocationName parent) {
    ListIpamAdminScopesRequest request =
        ListIpamAdminScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIpamAdminScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (IpamAdminScope element :
   *       cloudNumberRegistryClient.listIpamAdminScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIpamAdminScopesPagedResponse listIpamAdminScopes(String parent) {
    ListIpamAdminScopesRequest request =
        ListIpamAdminScopesRequest.newBuilder().setParent(parent).build();
    return listIpamAdminScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListIpamAdminScopesRequest request =
   *       ListIpamAdminScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (IpamAdminScope element :
   *       cloudNumberRegistryClient.listIpamAdminScopes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIpamAdminScopesPagedResponse listIpamAdminScopes(
      ListIpamAdminScopesRequest request) {
    return listIpamAdminScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListIpamAdminScopesRequest request =
   *       ListIpamAdminScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<IpamAdminScope> future =
   *       cloudNumberRegistryClient.listIpamAdminScopesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (IpamAdminScope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesPagedCallable() {
    return stub.listIpamAdminScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListIpamAdminScopesRequest request =
   *       ListIpamAdminScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListIpamAdminScopesResponse response =
   *         cloudNumberRegistryClient.listIpamAdminScopesCallable().call(request);
   *     for (IpamAdminScope element : response.getIpamAdminScopesList()) {
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
  public final UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesCallable() {
    return stub.listIpamAdminScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   IpamAdminScopeName name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
   *   IpamAdminScope response = cloudNumberRegistryClient.getIpamAdminScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IpamAdminScope getIpamAdminScope(IpamAdminScopeName name) {
    GetIpamAdminScopeRequest request =
        GetIpamAdminScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getIpamAdminScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString();
   *   IpamAdminScope response = cloudNumberRegistryClient.getIpamAdminScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IpamAdminScope getIpamAdminScope(String name) {
    GetIpamAdminScopeRequest request = GetIpamAdminScopeRequest.newBuilder().setName(name).build();
    return getIpamAdminScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetIpamAdminScopeRequest request =
   *       GetIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .build();
   *   IpamAdminScope response = cloudNumberRegistryClient.getIpamAdminScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IpamAdminScope getIpamAdminScope(GetIpamAdminScopeRequest request) {
    return getIpamAdminScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetIpamAdminScopeRequest request =
   *       GetIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .build();
   *   ApiFuture<IpamAdminScope> future =
   *       cloudNumberRegistryClient.getIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   IpamAdminScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeCallable() {
    return stub.getIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the availability of IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<String> scopes = new ArrayList<>();
   *   CheckAvailabilityIpamAdminScopesResponse response =
   *       cloudNumberRegistryClient.checkAvailabilityIpamAdminScopes(parent, scopes);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @param scopes Required. The administrative scopes to check for availability.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckAvailabilityIpamAdminScopesResponse checkAvailabilityIpamAdminScopes(
      LocationName parent, List<String> scopes) {
    CheckAvailabilityIpamAdminScopesRequest request =
        CheckAvailabilityIpamAdminScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllScopes(scopes)
            .build();
    return checkAvailabilityIpamAdminScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the availability of IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> scopes = new ArrayList<>();
   *   CheckAvailabilityIpamAdminScopesResponse response =
   *       cloudNumberRegistryClient.checkAvailabilityIpamAdminScopes(parent, scopes);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @param scopes Required. The administrative scopes to check for availability.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckAvailabilityIpamAdminScopesResponse checkAvailabilityIpamAdminScopes(
      String parent, List<String> scopes) {
    CheckAvailabilityIpamAdminScopesRequest request =
        CheckAvailabilityIpamAdminScopesRequest.newBuilder()
            .setParent(parent)
            .addAllScopes(scopes)
            .build();
    return checkAvailabilityIpamAdminScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the availability of IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CheckAvailabilityIpamAdminScopesRequest request =
   *       CheckAvailabilityIpamAdminScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllScopes(new ArrayList<String>())
   *           .build();
   *   CheckAvailabilityIpamAdminScopesResponse response =
   *       cloudNumberRegistryClient.checkAvailabilityIpamAdminScopes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckAvailabilityIpamAdminScopesResponse checkAvailabilityIpamAdminScopes(
      CheckAvailabilityIpamAdminScopesRequest request) {
    return checkAvailabilityIpamAdminScopesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks the availability of IpamAdminScopes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CheckAvailabilityIpamAdminScopesRequest request =
   *       CheckAvailabilityIpamAdminScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllScopes(new ArrayList<String>())
   *           .build();
   *   ApiFuture<CheckAvailabilityIpamAdminScopesResponse> future =
   *       cloudNumberRegistryClient.checkAvailabilityIpamAdminScopesCallable().futureCall(request);
   *   // Do something.
   *   CheckAvailabilityIpamAdminScopesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesCallable() {
    return stub.checkAvailabilityIpamAdminScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new IpamAdminScope in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
   *   String ipamAdminScopeId = "ipamAdminScopeId1628703603";
   *   IpamAdminScope response =
   *       cloudNumberRegistryClient
   *           .createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the IpamAdminScope will be created.
   * @param ipamAdminScope Required. The IpamAdminScope resource to create.
   * @param ipamAdminScopeId Required. The ID to use for the IpamAdminScope, which will become the
   *     final segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> createIpamAdminScopeAsync(
      LocationName parent, IpamAdminScope ipamAdminScope, String ipamAdminScopeId) {
    CreateIpamAdminScopeRequest request =
        CreateIpamAdminScopeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIpamAdminScope(ipamAdminScope)
            .setIpamAdminScopeId(ipamAdminScopeId)
            .build();
    return createIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new IpamAdminScope in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
   *   String ipamAdminScopeId = "ipamAdminScopeId1628703603";
   *   IpamAdminScope response =
   *       cloudNumberRegistryClient
   *           .createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the IpamAdminScope will be created.
   * @param ipamAdminScope Required. The IpamAdminScope resource to create.
   * @param ipamAdminScopeId Required. The ID to use for the IpamAdminScope, which will become the
   *     final segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> createIpamAdminScopeAsync(
      String parent, IpamAdminScope ipamAdminScope, String ipamAdminScopeId) {
    CreateIpamAdminScopeRequest request =
        CreateIpamAdminScopeRequest.newBuilder()
            .setParent(parent)
            .setIpamAdminScope(ipamAdminScope)
            .setIpamAdminScopeId(ipamAdminScopeId)
            .build();
    return createIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new IpamAdminScope in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateIpamAdminScopeRequest request =
   *       CreateIpamAdminScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIpamAdminScopeId("ipamAdminScopeId1628703603")
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IpamAdminScope response = cloudNumberRegistryClient.createIpamAdminScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> createIpamAdminScopeAsync(
      CreateIpamAdminScopeRequest request) {
    return createIpamAdminScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new IpamAdminScope in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateIpamAdminScopeRequest request =
   *       CreateIpamAdminScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIpamAdminScopeId("ipamAdminScopeId1628703603")
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<IpamAdminScope, OperationMetadata> future =
   *       cloudNumberRegistryClient.createIpamAdminScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   IpamAdminScope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationCallable() {
    return stub.createIpamAdminScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new IpamAdminScope in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateIpamAdminScopeRequest request =
   *       CreateIpamAdminScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setIpamAdminScopeId("ipamAdminScopeId1628703603")
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.createIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIpamAdminScopeRequest, Operation>
      createIpamAdminScopeCallable() {
    return stub.createIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   IpamAdminScope response =
   *       cloudNumberRegistryClient.updateIpamAdminScopeAsync(ipamAdminScope, updateMask).get();
   * }
   * }</pre>
   *
   * @param ipamAdminScope Required. The IpamAdminScope resource to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     IpamAdminScope resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> updateIpamAdminScopeAsync(
      IpamAdminScope ipamAdminScope, FieldMask updateMask) {
    UpdateIpamAdminScopeRequest request =
        UpdateIpamAdminScopeRequest.newBuilder()
            .setIpamAdminScope(ipamAdminScope)
            .setUpdateMask(updateMask)
            .build();
    return updateIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateIpamAdminScopeRequest request =
   *       UpdateIpamAdminScopeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IpamAdminScope response = cloudNumberRegistryClient.updateIpamAdminScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> updateIpamAdminScopeAsync(
      UpdateIpamAdminScopeRequest request) {
    return updateIpamAdminScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateIpamAdminScopeRequest request =
   *       UpdateIpamAdminScopeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<IpamAdminScope, OperationMetadata> future =
   *       cloudNumberRegistryClient.updateIpamAdminScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   IpamAdminScope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationCallable() {
    return stub.updateIpamAdminScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateIpamAdminScopeRequest request =
   *       UpdateIpamAdminScopeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setIpamAdminScope(IpamAdminScope.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.updateIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIpamAdminScopeRequest, Operation>
      updateIpamAdminScopeCallable() {
    return stub.updateIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   IpamAdminScopeName name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
   *   cloudNumberRegistryClient.deleteIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIpamAdminScopeAsync(
      IpamAdminScopeName name) {
    DeleteIpamAdminScopeRequest request =
        DeleteIpamAdminScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString();
   *   cloudNumberRegistryClient.deleteIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIpamAdminScopeAsync(String name) {
    DeleteIpamAdminScopeRequest request =
        DeleteIpamAdminScopeRequest.newBuilder().setName(name).build();
    return deleteIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteIpamAdminScopeRequest request =
   *       DeleteIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   cloudNumberRegistryClient.deleteIpamAdminScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteIpamAdminScopeAsync(
      DeleteIpamAdminScopeRequest request) {
    return deleteIpamAdminScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteIpamAdminScopeRequest request =
   *       DeleteIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudNumberRegistryClient.deleteIpamAdminScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationCallable() {
    return stub.deleteIpamAdminScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteIpamAdminScopeRequest request =
   *       DeleteIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.deleteIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIpamAdminScopeRequest, Operation>
      deleteIpamAdminScopeCallable() {
    return stub.deleteIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   IpamAdminScopeName name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
   *   IpamAdminScope response = cloudNumberRegistryClient.disableIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to disable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> disableIpamAdminScopeAsync(
      IpamAdminScopeName name) {
    DisableIpamAdminScopeRequest request =
        DisableIpamAdminScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString();
   *   IpamAdminScope response = cloudNumberRegistryClient.disableIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to disable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> disableIpamAdminScopeAsync(
      String name) {
    DisableIpamAdminScopeRequest request =
        DisableIpamAdminScopeRequest.newBuilder().setName(name).build();
    return disableIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DisableIpamAdminScopeRequest request =
   *       DisableIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IpamAdminScope response = cloudNumberRegistryClient.disableIpamAdminScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> disableIpamAdminScopeAsync(
      DisableIpamAdminScopeRequest request) {
    return disableIpamAdminScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DisableIpamAdminScopeRequest request =
   *       DisableIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<IpamAdminScope, OperationMetadata> future =
   *       cloudNumberRegistryClient.disableIpamAdminScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   IpamAdminScope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationCallable() {
    return stub.disableIpamAdminScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DisableIpamAdminScopeRequest request =
   *       DisableIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.disableIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeCallable() {
    return stub.disableIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cleans up a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   IpamAdminScopeName name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
   *   IpamAdminScope response = cloudNumberRegistryClient.cleanupIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to clean up.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> cleanupIpamAdminScopeAsync(
      IpamAdminScopeName name) {
    CleanupIpamAdminScopeRequest request =
        CleanupIpamAdminScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return cleanupIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cleans up a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString();
   *   IpamAdminScope response = cloudNumberRegistryClient.cleanupIpamAdminScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IpamAdminScope to clean up.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> cleanupIpamAdminScopeAsync(
      String name) {
    CleanupIpamAdminScopeRequest request =
        CleanupIpamAdminScopeRequest.newBuilder().setName(name).build();
    return cleanupIpamAdminScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cleans up a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CleanupIpamAdminScopeRequest request =
   *       CleanupIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   IpamAdminScope response = cloudNumberRegistryClient.cleanupIpamAdminScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<IpamAdminScope, OperationMetadata> cleanupIpamAdminScopeAsync(
      CleanupIpamAdminScopeRequest request) {
    return cleanupIpamAdminScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cleans up a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CleanupIpamAdminScopeRequest request =
   *       CleanupIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<IpamAdminScope, OperationMetadata> future =
   *       cloudNumberRegistryClient.cleanupIpamAdminScopeOperationCallable().futureCall(request);
   *   // Do something.
   *   IpamAdminScope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationCallable() {
    return stub.cleanupIpamAdminScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cleans up a single IpamAdminScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CleanupIpamAdminScopeRequest request =
   *       CleanupIpamAdminScopeRequest.newBuilder()
   *           .setName(
   *               IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.cleanupIpamAdminScopeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeCallable() {
    return stub.cleanupIpamAdminScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RegistryBooks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RegistryBook element :
   *       cloudNumberRegistryClient.listRegistryBooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistryBooksPagedResponse listRegistryBooks(LocationName parent) {
    ListRegistryBooksRequest request =
        ListRegistryBooksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRegistryBooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RegistryBooks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RegistryBook element :
   *       cloudNumberRegistryClient.listRegistryBooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistryBooksPagedResponse listRegistryBooks(String parent) {
    ListRegistryBooksRequest request =
        ListRegistryBooksRequest.newBuilder().setParent(parent).build();
    return listRegistryBooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RegistryBooks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRegistryBooksRequest request =
   *       ListRegistryBooksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(RegistryBookView.forNumber(0))
   *           .build();
   *   for (RegistryBook element :
   *       cloudNumberRegistryClient.listRegistryBooks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistryBooksPagedResponse listRegistryBooks(ListRegistryBooksRequest request) {
    return listRegistryBooksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RegistryBooks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRegistryBooksRequest request =
   *       ListRegistryBooksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(RegistryBookView.forNumber(0))
   *           .build();
   *   ApiFuture<RegistryBook> future =
   *       cloudNumberRegistryClient.listRegistryBooksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RegistryBook element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksPagedResponse>
      listRegistryBooksPagedCallable() {
    return stub.listRegistryBooksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RegistryBooks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRegistryBooksRequest request =
   *       ListRegistryBooksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(RegistryBookView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListRegistryBooksResponse response =
   *         cloudNumberRegistryClient.listRegistryBooksCallable().call(request);
   *     for (RegistryBook element : response.getRegistryBooksList()) {
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
  public final UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksCallable() {
    return stub.listRegistryBooksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
   *   RegistryBook response = cloudNumberRegistryClient.getRegistryBook(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegistryBook getRegistryBook(RegistryBookName name) {
    GetRegistryBookRequest request =
        GetRegistryBookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRegistryBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString();
   *   RegistryBook response = cloudNumberRegistryClient.getRegistryBook(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegistryBook getRegistryBook(String name) {
    GetRegistryBookRequest request = GetRegistryBookRequest.newBuilder().setName(name).build();
    return getRegistryBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetRegistryBookRequest request =
   *       GetRegistryBookRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setView(RegistryBookView.forNumber(0))
   *           .build();
   *   RegistryBook response = cloudNumberRegistryClient.getRegistryBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegistryBook getRegistryBook(GetRegistryBookRequest request) {
    return getRegistryBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetRegistryBookRequest request =
   *       GetRegistryBookRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setView(RegistryBookView.forNumber(0))
   *           .build();
   *   ApiFuture<RegistryBook> future =
   *       cloudNumberRegistryClient.getRegistryBookCallable().futureCall(request);
   *   // Do something.
   *   RegistryBook response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegistryBookRequest, RegistryBook> getRegistryBookCallable() {
    return stub.getRegistryBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches IP resources in a given RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
   *   for (Range element : cloudNumberRegistryClient.searchIpResources(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to search in.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIpResourcesPagedResponse searchIpResources(RegistryBookName name) {
    SearchIpResourcesRequest request =
        SearchIpResourcesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return searchIpResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches IP resources in a given RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString();
   *   for (Range element : cloudNumberRegistryClient.searchIpResources(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to search in.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIpResourcesPagedResponse searchIpResources(String name) {
    SearchIpResourcesRequest request = SearchIpResourcesRequest.newBuilder().setName(name).build();
    return searchIpResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches IP resources in a given RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   SearchIpResourcesRequest request =
   *       SearchIpResourcesRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowUtilization(true)
   *           .addAllSearchResourceTypes(
   *               new ArrayList<SearchIpResourcesRequest.SearchResourceType>())
   *           .build();
   *   for (Range element : cloudNumberRegistryClient.searchIpResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchIpResourcesPagedResponse searchIpResources(SearchIpResourcesRequest request) {
    return searchIpResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches IP resources in a given RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   SearchIpResourcesRequest request =
   *       SearchIpResourcesRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowUtilization(true)
   *           .addAllSearchResourceTypes(
   *               new ArrayList<SearchIpResourcesRequest.SearchResourceType>())
   *           .build();
   *   ApiFuture<Range> future =
   *       cloudNumberRegistryClient.searchIpResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Range element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesPagedResponse>
      searchIpResourcesPagedCallable() {
    return stub.searchIpResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches IP resources in a given RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   SearchIpResourcesRequest request =
   *       SearchIpResourcesRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowUtilization(true)
   *           .addAllSearchResourceTypes(
   *               new ArrayList<SearchIpResourcesRequest.SearchResourceType>())
   *           .build();
   *   while (true) {
   *     SearchIpResourcesResponse response =
   *         cloudNumberRegistryClient.searchIpResourcesCallable().call(request);
   *     for (Range element : response.getRangesList()) {
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
  public final UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesCallable() {
    return stub.searchIpResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RegistryBook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RegistryBook registryBook = RegistryBook.newBuilder().build();
   *   String registryBookId = "registryBookId2126801025";
   *   RegistryBook response =
   *       cloudNumberRegistryClient
   *           .createRegistryBookAsync(parent, registryBook, registryBookId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the RegistryBook will be created.
   * @param registryBook Required. The RegistryBook resource to create.
   * @param registryBookId Required. The ID to use for the RegistryBook, which will become the final
   *     segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegistryBook, OperationMetadata> createRegistryBookAsync(
      LocationName parent, RegistryBook registryBook, String registryBookId) {
    CreateRegistryBookRequest request =
        CreateRegistryBookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRegistryBook(registryBook)
            .setRegistryBookId(registryBookId)
            .build();
    return createRegistryBookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RegistryBook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RegistryBook registryBook = RegistryBook.newBuilder().build();
   *   String registryBookId = "registryBookId2126801025";
   *   RegistryBook response =
   *       cloudNumberRegistryClient
   *           .createRegistryBookAsync(parent, registryBook, registryBookId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the RegistryBook will be created.
   * @param registryBook Required. The RegistryBook resource to create.
   * @param registryBookId Required. The ID to use for the RegistryBook, which will become the final
   *     segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegistryBook, OperationMetadata> createRegistryBookAsync(
      String parent, RegistryBook registryBook, String registryBookId) {
    CreateRegistryBookRequest request =
        CreateRegistryBookRequest.newBuilder()
            .setParent(parent)
            .setRegistryBook(registryBook)
            .setRegistryBookId(registryBookId)
            .build();
    return createRegistryBookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RegistryBook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRegistryBookRequest request =
   *       CreateRegistryBookRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistryBookId("registryBookId2126801025")
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   RegistryBook response = cloudNumberRegistryClient.createRegistryBookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegistryBook, OperationMetadata> createRegistryBookAsync(
      CreateRegistryBookRequest request) {
    return createRegistryBookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RegistryBook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRegistryBookRequest request =
   *       CreateRegistryBookRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistryBookId("registryBookId2126801025")
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<RegistryBook, OperationMetadata> future =
   *       cloudNumberRegistryClient.createRegistryBookOperationCallable().futureCall(request);
   *   // Do something.
   *   RegistryBook response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationCallable() {
    return stub.createRegistryBookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RegistryBook in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRegistryBookRequest request =
   *       CreateRegistryBookRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistryBookId("registryBookId2126801025")
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.createRegistryBookCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRegistryBookRequest, Operation> createRegistryBookCallable() {
    return stub.createRegistryBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RegistryBook registryBook = RegistryBook.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RegistryBook response =
   *       cloudNumberRegistryClient.updateRegistryBookAsync(registryBook, updateMask).get();
   * }
   * }</pre>
   *
   * @param registryBook Required. The RegistryBook resource to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     RegistryBook resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegistryBook, OperationMetadata> updateRegistryBookAsync(
      RegistryBook registryBook, FieldMask updateMask) {
    UpdateRegistryBookRequest request =
        UpdateRegistryBookRequest.newBuilder()
            .setRegistryBook(registryBook)
            .setUpdateMask(updateMask)
            .build();
    return updateRegistryBookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRegistryBookRequest request =
   *       UpdateRegistryBookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   RegistryBook response = cloudNumberRegistryClient.updateRegistryBookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RegistryBook, OperationMetadata> updateRegistryBookAsync(
      UpdateRegistryBookRequest request) {
    return updateRegistryBookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRegistryBookRequest request =
   *       UpdateRegistryBookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<RegistryBook, OperationMetadata> future =
   *       cloudNumberRegistryClient.updateRegistryBookOperationCallable().futureCall(request);
   *   // Do something.
   *   RegistryBook response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationCallable() {
    return stub.updateRegistryBookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRegistryBookRequest request =
   *       UpdateRegistryBookRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRegistryBook(RegistryBook.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.updateRegistryBookCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegistryBookRequest, Operation> updateRegistryBookCallable() {
    return stub.updateRegistryBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
   *   cloudNumberRegistryClient.deleteRegistryBookAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistryBookAsync(
      RegistryBookName name) {
    DeleteRegistryBookRequest request =
        DeleteRegistryBookRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteRegistryBookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString();
   *   cloudNumberRegistryClient.deleteRegistryBookAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RegistryBook to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistryBookAsync(String name) {
    DeleteRegistryBookRequest request =
        DeleteRegistryBookRequest.newBuilder().setName(name).build();
    return deleteRegistryBookAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRegistryBookRequest request =
   *       DeleteRegistryBookRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   cloudNumberRegistryClient.deleteRegistryBookAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistryBookAsync(
      DeleteRegistryBookRequest request) {
    return deleteRegistryBookOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRegistryBookRequest request =
   *       DeleteRegistryBookRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudNumberRegistryClient.deleteRegistryBookOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationCallable() {
    return stub.deleteRegistryBookOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single RegistryBook.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRegistryBookRequest request =
   *       DeleteRegistryBookRequest.newBuilder()
   *           .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.deleteRegistryBookCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegistryBookRequest, Operation> deleteRegistryBookCallable() {
    return stub.deleteRegistryBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Realm element : cloudNumberRegistryClient.listRealms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(LocationName parent) {
    ListRealmsRequest request =
        ListRealmsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Realm element : cloudNumberRegistryClient.listRealms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(String parent) {
    ListRealmsRequest request = ListRealmsRequest.newBuilder().setParent(parent).build();
    return listRealms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRealmsRequest request =
   *       ListRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Realm element : cloudNumberRegistryClient.listRealms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRealmsPagedResponse listRealms(ListRealmsRequest request) {
    return listRealmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRealmsRequest request =
   *       ListRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Realm> future =
   *       cloudNumberRegistryClient.listRealmsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Realm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return stub.listRealmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Realms in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListRealmsRequest request =
   *       ListRealmsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRealmsResponse response = cloudNumberRegistryClient.listRealmsCallable().call(request);
   *     for (Realm element : response.getRealmsList()) {
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
  public final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return stub.listRealmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
   *   Realm response = cloudNumberRegistryClient.getRealm(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Realm to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(RealmName name) {
    GetRealmRequest request =
        GetRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString();
   *   Realm response = cloudNumberRegistryClient.getRealm(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Realm to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(String name) {
    GetRealmRequest request = GetRealmRequest.newBuilder().setName(name).build();
    return getRealm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetRealmRequest request =
   *       GetRealmRequest.newBuilder()
   *           .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
   *           .build();
   *   Realm response = cloudNumberRegistryClient.getRealm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Realm getRealm(GetRealmRequest request) {
    return getRealmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetRealmRequest request =
   *       GetRealmRequest.newBuilder()
   *           .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
   *           .build();
   *   ApiFuture<Realm> future = cloudNumberRegistryClient.getRealmCallable().futureCall(request);
   *   // Do something.
   *   Realm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return stub.getRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Realm realm = Realm.newBuilder().build();
   *   String realmId = "realmId1080654858";
   *   Realm response = cloudNumberRegistryClient.createRealmAsync(parent, realm, realmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the Realm will be created.
   * @param realm Required. The Realm resource to create.
   * @param realmId Required. The ID to use for the Realm, which will become the final segment of
   *     the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      LocationName parent, Realm realm, String realmId) {
    CreateRealmRequest request =
        CreateRealmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRealm(realm)
            .setRealmId(realmId)
            .build();
    return createRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Realm realm = Realm.newBuilder().build();
   *   String realmId = "realmId1080654858";
   *   Realm response = cloudNumberRegistryClient.createRealmAsync(parent, realm, realmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the Realm will be created.
   * @param realm Required. The Realm resource to create.
   * @param realmId Required. The ID to use for the Realm, which will become the final segment of
   *     the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      String parent, Realm realm, String realmId) {
    CreateRealmRequest request =
        CreateRealmRequest.newBuilder()
            .setParent(parent)
            .setRealm(realm)
            .setRealmId(realmId)
            .build();
    return createRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRealmRequest request =
   *       CreateRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRealmId("realmId1080654858")
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Realm response = cloudNumberRegistryClient.createRealmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> createRealmAsync(
      CreateRealmRequest request) {
    return createRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRealmRequest request =
   *       CreateRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRealmId("realmId1080654858")
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Realm, OperationMetadata> future =
   *       cloudNumberRegistryClient.createRealmOperationCallable().futureCall(request);
   *   // Do something.
   *   Realm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    return stub.createRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Realm in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateRealmRequest request =
   *       CreateRealmRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRealmId("realmId1080654858")
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.createRealmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return stub.createRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   Realm realm = Realm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Realm response = cloudNumberRegistryClient.updateRealmAsync(realm, updateMask).get();
   * }
   * }</pre>
   *
   * @param realm Required. The Realm resource to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Realm resource by the update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> updateRealmAsync(
      Realm realm, FieldMask updateMask) {
    UpdateRealmRequest request =
        UpdateRealmRequest.newBuilder().setRealm(realm).setUpdateMask(updateMask).build();
    return updateRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRealmRequest request =
   *       UpdateRealmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Realm response = cloudNumberRegistryClient.updateRealmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Realm, OperationMetadata> updateRealmAsync(
      UpdateRealmRequest request) {
    return updateRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRealmRequest request =
   *       UpdateRealmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Realm, OperationMetadata> future =
   *       cloudNumberRegistryClient.updateRealmOperationCallable().futureCall(request);
   *   // Do something.
   *   Realm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    return stub.updateRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateRealmRequest request =
   *       UpdateRealmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRealm(Realm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.updateRealmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return stub.updateRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
   *   cloudNumberRegistryClient.deleteRealmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Realm to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(RealmName name) {
    DeleteRealmRequest request =
        DeleteRealmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString();
   *   cloudNumberRegistryClient.deleteRealmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Realm to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(String name) {
    DeleteRealmRequest request = DeleteRealmRequest.newBuilder().setName(name).build();
    return deleteRealmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRealmRequest request =
   *       DeleteRealmRequest.newBuilder()
   *           .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   cloudNumberRegistryClient.deleteRealmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRealmAsync(
      DeleteRealmRequest request) {
    return deleteRealmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRealmRequest request =
   *       DeleteRealmRequest.newBuilder()
   *           .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudNumberRegistryClient.deleteRealmOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    return stub.deleteRealmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Realm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteRealmRequest request =
   *       DeleteRealmRequest.newBuilder()
   *           .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.deleteRealmCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return stub.deleteRealmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiscoveredRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DiscoveredRange element :
   *       cloudNumberRegistryClient.listDiscoveredRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredRangesPagedResponse listDiscoveredRanges(LocationName parent) {
    ListDiscoveredRangesRequest request =
        ListDiscoveredRangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiscoveredRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiscoveredRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DiscoveredRange element :
   *       cloudNumberRegistryClient.listDiscoveredRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredRangesPagedResponse listDiscoveredRanges(String parent) {
    ListDiscoveredRangesRequest request =
        ListDiscoveredRangesRequest.newBuilder().setParent(parent).build();
    return listDiscoveredRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiscoveredRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListDiscoveredRangesRequest request =
   *       ListDiscoveredRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DiscoveredRange element :
   *       cloudNumberRegistryClient.listDiscoveredRanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredRangesPagedResponse listDiscoveredRanges(
      ListDiscoveredRangesRequest request) {
    return listDiscoveredRangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiscoveredRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListDiscoveredRangesRequest request =
   *       ListDiscoveredRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DiscoveredRange> future =
   *       cloudNumberRegistryClient.listDiscoveredRangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiscoveredRange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesPagedCallable() {
    return stub.listDiscoveredRangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiscoveredRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListDiscoveredRangesRequest request =
   *       ListDiscoveredRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDiscoveredRangesResponse response =
   *         cloudNumberRegistryClient.listDiscoveredRangesCallable().call(request);
   *     for (DiscoveredRange element : response.getDiscoveredRangesList()) {
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
  public final UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesCallable() {
    return stub.listDiscoveredRangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DiscoveredRangeName name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
   *   DiscoveredRange response = cloudNumberRegistryClient.getDiscoveredRange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredRange getDiscoveredRange(DiscoveredRangeName name) {
    GetDiscoveredRangeRequest request =
        GetDiscoveredRangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiscoveredRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString();
   *   DiscoveredRange response = cloudNumberRegistryClient.getDiscoveredRange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredRange getDiscoveredRange(String name) {
    GetDiscoveredRangeRequest request =
        GetDiscoveredRangeRequest.newBuilder().setName(name).build();
    return getDiscoveredRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetDiscoveredRangeRequest request =
   *       GetDiscoveredRangeRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .build();
   *   DiscoveredRange response = cloudNumberRegistryClient.getDiscoveredRange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredRange getDiscoveredRange(GetDiscoveredRangeRequest request) {
    return getDiscoveredRangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetDiscoveredRangeRequest request =
   *       GetDiscoveredRangeRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscoveredRange> future =
   *       cloudNumberRegistryClient.getDiscoveredRangeCallable().futureCall(request);
   *   // Do something.
   *   DiscoveredRange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeCallable() {
    return stub.getDiscoveredRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DiscoveredRangeName name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
   *   int cidrPrefixLength = -954389592;
   *   FindDiscoveredRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange to search within.
   * @param cidrPrefixLength Required. The prefix length of the free IP ranges to find.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindDiscoveredRangeFreeIpRangesResponse findDiscoveredRangeFreeIpRanges(
      DiscoveredRangeName name, int cidrPrefixLength) {
    FindDiscoveredRangeFreeIpRangesRequest request =
        FindDiscoveredRangeFreeIpRangesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCidrPrefixLength(cidrPrefixLength)
            .build();
    return findDiscoveredRangeFreeIpRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString();
   *   int cidrPrefixLength = -954389592;
   *   FindDiscoveredRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange to search within.
   * @param cidrPrefixLength Required. The prefix length of the free IP ranges to find.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindDiscoveredRangeFreeIpRangesResponse findDiscoveredRangeFreeIpRanges(
      String name, int cidrPrefixLength) {
    FindDiscoveredRangeFreeIpRangesRequest request =
        FindDiscoveredRangeFreeIpRangesRequest.newBuilder()
            .setName(name)
            .setCidrPrefixLength(cidrPrefixLength)
            .build();
    return findDiscoveredRangeFreeIpRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   FindDiscoveredRangeFreeIpRangesRequest request =
   *       FindDiscoveredRangeFreeIpRangesRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .setCidrPrefixLength(-954389592)
   *           .setRangeCount(-448443507)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FindDiscoveredRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findDiscoveredRangeFreeIpRanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindDiscoveredRangeFreeIpRangesResponse findDiscoveredRangeFreeIpRanges(
      FindDiscoveredRangeFreeIpRangesRequest request) {
    return findDiscoveredRangeFreeIpRangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single DiscoveredRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   FindDiscoveredRangeFreeIpRangesRequest request =
   *       FindDiscoveredRangeFreeIpRangesRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .setCidrPrefixLength(-954389592)
   *           .setRangeCount(-448443507)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<FindDiscoveredRangeFreeIpRangesResponse> future =
   *       cloudNumberRegistryClient.findDiscoveredRangeFreeIpRangesCallable().futureCall(request);
   *   // Do something.
   *   FindDiscoveredRangeFreeIpRangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesCallable() {
    return stub.findDiscoveredRangeFreeIpRangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CustomRange element : cloudNumberRegistryClient.listCustomRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomRangesPagedResponse listCustomRanges(LocationName parent) {
    ListCustomRangesRequest request =
        ListCustomRangesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CustomRange element : cloudNumberRegistryClient.listCustomRanges(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, for example `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomRangesPagedResponse listCustomRanges(String parent) {
    ListCustomRangesRequest request =
        ListCustomRangesRequest.newBuilder().setParent(parent).build();
    return listCustomRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListCustomRangesRequest request =
   *       ListCustomRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CustomRange element : cloudNumberRegistryClient.listCustomRanges(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomRangesPagedResponse listCustomRanges(ListCustomRangesRequest request) {
    return listCustomRangesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListCustomRangesRequest request =
   *       ListCustomRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CustomRange> future =
   *       cloudNumberRegistryClient.listCustomRangesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomRange element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomRangesRequest, ListCustomRangesPagedResponse>
      listCustomRangesPagedCallable() {
    return stub.listCustomRangesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists CustomRanges in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ListCustomRangesRequest request =
   *       ListCustomRangesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCustomRangesResponse response =
   *         cloudNumberRegistryClient.listCustomRangesCallable().call(request);
   *     for (CustomRange element : response.getCustomRangesList()) {
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
  public final UnaryCallable<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesCallable() {
    return stub.listCustomRangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
   *   CustomRange response = cloudNumberRegistryClient.getCustomRange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomRange getCustomRange(CustomRangeName name) {
    GetCustomRangeRequest request =
        GetCustomRangeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString();
   *   CustomRange response = cloudNumberRegistryClient.getCustomRange(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomRange getCustomRange(String name) {
    GetCustomRangeRequest request = GetCustomRangeRequest.newBuilder().setName(name).build();
    return getCustomRange(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetCustomRangeRequest request =
   *       GetCustomRangeRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .build();
   *   CustomRange response = cloudNumberRegistryClient.getCustomRange(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomRange getCustomRange(GetCustomRangeRequest request) {
    return getCustomRangeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   GetCustomRangeRequest request =
   *       GetCustomRangeRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .build();
   *   ApiFuture<CustomRange> future =
   *       cloudNumberRegistryClient.getCustomRangeCallable().futureCall(request);
   *   // Do something.
   *   CustomRange response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomRangeRequest, CustomRange> getCustomRangeCallable() {
    return stub.getCustomRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single CustomRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
   *   ShowCustomRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showCustomRangeUtilization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowCustomRangeUtilizationResponse showCustomRangeUtilization(CustomRangeName name) {
    ShowCustomRangeUtilizationRequest request =
        ShowCustomRangeUtilizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return showCustomRangeUtilization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single CustomRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString();
   *   ShowCustomRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showCustomRangeUtilization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowCustomRangeUtilizationResponse showCustomRangeUtilization(String name) {
    ShowCustomRangeUtilizationRequest request =
        ShowCustomRangeUtilizationRequest.newBuilder().setName(name).build();
    return showCustomRangeUtilization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single CustomRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ShowCustomRangeUtilizationRequest request =
   *       ShowCustomRangeUtilizationRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .build();
   *   ShowCustomRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showCustomRangeUtilization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowCustomRangeUtilizationResponse showCustomRangeUtilization(
      ShowCustomRangeUtilizationRequest request) {
    return showCustomRangeUtilizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single CustomRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ShowCustomRangeUtilizationRequest request =
   *       ShowCustomRangeUtilizationRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .build();
   *   ApiFuture<ShowCustomRangeUtilizationResponse> future =
   *       cloudNumberRegistryClient.showCustomRangeUtilizationCallable().futureCall(request);
   *   // Do something.
   *   ShowCustomRangeUtilizationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationCallable() {
    return stub.showCustomRangeUtilizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DiscoveredRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DiscoveredRangeName name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
   *   ShowDiscoveredRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showDiscoveredRangeUtilization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowDiscoveredRangeUtilizationResponse showDiscoveredRangeUtilization(
      DiscoveredRangeName name) {
    ShowDiscoveredRangeUtilizationRequest request =
        ShowDiscoveredRangeUtilizationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return showDiscoveredRangeUtilization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DiscoveredRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name =
   *       DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString();
   *   ShowDiscoveredRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showDiscoveredRangeUtilization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the DiscoveredRange.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowDiscoveredRangeUtilizationResponse showDiscoveredRangeUtilization(String name) {
    ShowDiscoveredRangeUtilizationRequest request =
        ShowDiscoveredRangeUtilizationRequest.newBuilder().setName(name).build();
    return showDiscoveredRangeUtilization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DiscoveredRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ShowDiscoveredRangeUtilizationRequest request =
   *       ShowDiscoveredRangeUtilizationRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .build();
   *   ShowDiscoveredRangeUtilizationResponse response =
   *       cloudNumberRegistryClient.showDiscoveredRangeUtilization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowDiscoveredRangeUtilizationResponse showDiscoveredRangeUtilization(
      ShowDiscoveredRangeUtilizationRequest request) {
    return showDiscoveredRangeUtilizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DiscoveredRange and its utilization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   ShowDiscoveredRangeUtilizationRequest request =
   *       ShowDiscoveredRangeUtilizationRequest.newBuilder()
   *           .setName(
   *               DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ShowDiscoveredRangeUtilizationResponse> future =
   *       cloudNumberRegistryClient.showDiscoveredRangeUtilizationCallable().futureCall(request);
   *   // Do something.
   *   ShowDiscoveredRangeUtilizationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationCallable() {
    return stub.showDiscoveredRangeUtilizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
   *   int cidrPrefixLength = -954389592;
   *   FindCustomRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to search within.
   * @param cidrPrefixLength Required. The prefix length of the free IP ranges to find.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindCustomRangeFreeIpRangesResponse findCustomRangeFreeIpRanges(
      CustomRangeName name, int cidrPrefixLength) {
    FindCustomRangeFreeIpRangesRequest request =
        FindCustomRangeFreeIpRangesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCidrPrefixLength(cidrPrefixLength)
            .build();
    return findCustomRangeFreeIpRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString();
   *   int cidrPrefixLength = -954389592;
   *   FindCustomRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to search within.
   * @param cidrPrefixLength Required. The prefix length of the free IP ranges to find.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindCustomRangeFreeIpRangesResponse findCustomRangeFreeIpRanges(
      String name, int cidrPrefixLength) {
    FindCustomRangeFreeIpRangesRequest request =
        FindCustomRangeFreeIpRangesRequest.newBuilder()
            .setName(name)
            .setCidrPrefixLength(cidrPrefixLength)
            .build();
    return findCustomRangeFreeIpRanges(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   FindCustomRangeFreeIpRangesRequest request =
   *       FindCustomRangeFreeIpRangesRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .setCidrPrefixLength(-954389592)
   *           .setRangeCount(-448443507)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   FindCustomRangeFreeIpRangesResponse response =
   *       cloudNumberRegistryClient.findCustomRangeFreeIpRanges(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FindCustomRangeFreeIpRangesResponse findCustomRangeFreeIpRanges(
      FindCustomRangeFreeIpRangesRequest request) {
    return findCustomRangeFreeIpRangesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finds free IP ranges in a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   FindCustomRangeFreeIpRangesRequest request =
   *       FindCustomRangeFreeIpRangesRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .setCidrPrefixLength(-954389592)
   *           .setRangeCount(-448443507)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<FindCustomRangeFreeIpRangesResponse> future =
   *       cloudNumberRegistryClient.findCustomRangeFreeIpRangesCallable().futureCall(request);
   *   // Do something.
   *   FindCustomRangeFreeIpRangesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesCallable() {
    return stub.findCustomRangeFreeIpRangesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomRange in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CustomRange customRange = CustomRange.newBuilder().build();
   *   String customRangeId = "customRangeId1995399815";
   *   CustomRange response =
   *       cloudNumberRegistryClient
   *           .createCustomRangeAsync(parent, customRange, customRangeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the CustomRange will be created.
   * @param customRange Required. The CustomRange resource to create.
   * @param customRangeId Required. The ID to use for the CustomRange, which will become the final
   *     segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomRange, OperationMetadata> createCustomRangeAsync(
      LocationName parent, CustomRange customRange, String customRangeId) {
    CreateCustomRangeRequest request =
        CreateCustomRangeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomRange(customRange)
            .setCustomRangeId(customRangeId)
            .build();
    return createCustomRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomRange in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CustomRange customRange = CustomRange.newBuilder().build();
   *   String customRangeId = "customRangeId1995399815";
   *   CustomRange response =
   *       cloudNumberRegistryClient
   *           .createCustomRangeAsync(parent, customRange, customRangeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name where the CustomRange will be created.
   * @param customRange Required. The CustomRange resource to create.
   * @param customRangeId Required. The ID to use for the CustomRange, which will become the final
   *     segment of the resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomRange, OperationMetadata> createCustomRangeAsync(
      String parent, CustomRange customRange, String customRangeId) {
    CreateCustomRangeRequest request =
        CreateCustomRangeRequest.newBuilder()
            .setParent(parent)
            .setCustomRange(customRange)
            .setCustomRangeId(customRangeId)
            .build();
    return createCustomRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomRange in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateCustomRangeRequest request =
   *       CreateCustomRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomRangeId("customRangeId1995399815")
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CustomRange response = cloudNumberRegistryClient.createCustomRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomRange, OperationMetadata> createCustomRangeAsync(
      CreateCustomRangeRequest request) {
    return createCustomRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomRange in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateCustomRangeRequest request =
   *       CreateCustomRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomRangeId("customRangeId1995399815")
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CustomRange, OperationMetadata> future =
   *       cloudNumberRegistryClient.createCustomRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomRange response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationCallable() {
    return stub.createCustomRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new CustomRange in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CreateCustomRangeRequest request =
   *       CreateCustomRangeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCustomRangeId("customRangeId1995399815")
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.createCustomRangeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomRangeRequest, Operation> createCustomRangeCallable() {
    return stub.createCustomRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CustomRange customRange = CustomRange.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomRange response =
   *       cloudNumberRegistryClient.updateCustomRangeAsync(customRange, updateMask).get();
   * }
   * }</pre>
   *
   * @param customRange Required. The CustomRange resource to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     CustomRange resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomRange, OperationMetadata> updateCustomRangeAsync(
      CustomRange customRange, FieldMask updateMask) {
    UpdateCustomRangeRequest request =
        UpdateCustomRangeRequest.newBuilder()
            .setCustomRange(customRange)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateCustomRangeRequest request =
   *       UpdateCustomRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CustomRange response = cloudNumberRegistryClient.updateCustomRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CustomRange, OperationMetadata> updateCustomRangeAsync(
      UpdateCustomRangeRequest request) {
    return updateCustomRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateCustomRangeRequest request =
   *       UpdateCustomRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CustomRange, OperationMetadata> future =
   *       cloudNumberRegistryClient.updateCustomRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   CustomRange response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationCallable() {
    return stub.updateCustomRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   UpdateCustomRangeRequest request =
   *       UpdateCustomRangeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCustomRange(CustomRange.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.updateCustomRangeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomRangeRequest, Operation> updateCustomRangeCallable() {
    return stub.updateCustomRangeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
   *   cloudNumberRegistryClient.deleteCustomRangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomRangeAsync(
      CustomRangeName name) {
    DeleteCustomRangeRequest request =
        DeleteCustomRangeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCustomRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   String name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString();
   *   cloudNumberRegistryClient.deleteCustomRangeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomRange to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomRangeAsync(String name) {
    DeleteCustomRangeRequest request = DeleteCustomRangeRequest.newBuilder().setName(name).build();
    return deleteCustomRangeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteCustomRangeRequest request =
   *       DeleteCustomRangeRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   cloudNumberRegistryClient.deleteCustomRangeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCustomRangeAsync(
      DeleteCustomRangeRequest request) {
    return deleteCustomRangeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteCustomRangeRequest request =
   *       DeleteCustomRangeRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudNumberRegistryClient.deleteCustomRangeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationCallable() {
    return stub.deleteCustomRangeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single CustomRange.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
   *   DeleteCustomRangeRequest request =
   *       DeleteCustomRangeRequest.newBuilder()
   *           .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudNumberRegistryClient.deleteCustomRangeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomRangeRequest, Operation> deleteCustomRangeCallable() {
    return stub.deleteCustomRangeCallable();
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

  public static class ListIpamAdminScopesPagedResponse
      extends AbstractPagedListResponse<
          ListIpamAdminScopesRequest,
          ListIpamAdminScopesResponse,
          IpamAdminScope,
          ListIpamAdminScopesPage,
          ListIpamAdminScopesFixedSizeCollection> {

    public static ApiFuture<ListIpamAdminScopesPagedResponse> createAsync(
        PageContext<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
            context,
        ApiFuture<ListIpamAdminScopesResponse> futureResponse) {
      ApiFuture<ListIpamAdminScopesPage> futurePage =
          ListIpamAdminScopesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListIpamAdminScopesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListIpamAdminScopesPagedResponse(ListIpamAdminScopesPage page) {
      super(page, ListIpamAdminScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIpamAdminScopesPage
      extends AbstractPage<
          ListIpamAdminScopesRequest,
          ListIpamAdminScopesResponse,
          IpamAdminScope,
          ListIpamAdminScopesPage> {

    private ListIpamAdminScopesPage(
        PageContext<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
            context,
        ListIpamAdminScopesResponse response) {
      super(context, response);
    }

    private static ListIpamAdminScopesPage createEmptyPage() {
      return new ListIpamAdminScopesPage(null, null);
    }

    @Override
    protected ListIpamAdminScopesPage createPage(
        PageContext<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
            context,
        ListIpamAdminScopesResponse response) {
      return new ListIpamAdminScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListIpamAdminScopesPage> createPageAsync(
        PageContext<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, IpamAdminScope>
            context,
        ApiFuture<ListIpamAdminScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIpamAdminScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIpamAdminScopesRequest,
          ListIpamAdminScopesResponse,
          IpamAdminScope,
          ListIpamAdminScopesPage,
          ListIpamAdminScopesFixedSizeCollection> {

    private ListIpamAdminScopesFixedSizeCollection(
        List<ListIpamAdminScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIpamAdminScopesFixedSizeCollection createEmptyCollection() {
      return new ListIpamAdminScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIpamAdminScopesFixedSizeCollection createCollection(
        List<ListIpamAdminScopesPage> pages, int collectionSize) {
      return new ListIpamAdminScopesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRegistryBooksPagedResponse
      extends AbstractPagedListResponse<
          ListRegistryBooksRequest,
          ListRegistryBooksResponse,
          RegistryBook,
          ListRegistryBooksPage,
          ListRegistryBooksFixedSizeCollection> {

    public static ApiFuture<ListRegistryBooksPagedResponse> createAsync(
        PageContext<ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook> context,
        ApiFuture<ListRegistryBooksResponse> futureResponse) {
      ApiFuture<ListRegistryBooksPage> futurePage =
          ListRegistryBooksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRegistryBooksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRegistryBooksPagedResponse(ListRegistryBooksPage page) {
      super(page, ListRegistryBooksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegistryBooksPage
      extends AbstractPage<
          ListRegistryBooksRequest,
          ListRegistryBooksResponse,
          RegistryBook,
          ListRegistryBooksPage> {

    private ListRegistryBooksPage(
        PageContext<ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook> context,
        ListRegistryBooksResponse response) {
      super(context, response);
    }

    private static ListRegistryBooksPage createEmptyPage() {
      return new ListRegistryBooksPage(null, null);
    }

    @Override
    protected ListRegistryBooksPage createPage(
        PageContext<ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook> context,
        ListRegistryBooksResponse response) {
      return new ListRegistryBooksPage(context, response);
    }

    @Override
    public ApiFuture<ListRegistryBooksPage> createPageAsync(
        PageContext<ListRegistryBooksRequest, ListRegistryBooksResponse, RegistryBook> context,
        ApiFuture<ListRegistryBooksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegistryBooksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegistryBooksRequest,
          ListRegistryBooksResponse,
          RegistryBook,
          ListRegistryBooksPage,
          ListRegistryBooksFixedSizeCollection> {

    private ListRegistryBooksFixedSizeCollection(
        List<ListRegistryBooksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegistryBooksFixedSizeCollection createEmptyCollection() {
      return new ListRegistryBooksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegistryBooksFixedSizeCollection createCollection(
        List<ListRegistryBooksPage> pages, int collectionSize) {
      return new ListRegistryBooksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchIpResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchIpResourcesRequest,
          SearchIpResourcesResponse,
          Range,
          SearchIpResourcesPage,
          SearchIpResourcesFixedSizeCollection> {

    public static ApiFuture<SearchIpResourcesPagedResponse> createAsync(
        PageContext<SearchIpResourcesRequest, SearchIpResourcesResponse, Range> context,
        ApiFuture<SearchIpResourcesResponse> futureResponse) {
      ApiFuture<SearchIpResourcesPage> futurePage =
          SearchIpResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchIpResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchIpResourcesPagedResponse(SearchIpResourcesPage page) {
      super(page, SearchIpResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchIpResourcesPage
      extends AbstractPage<
          SearchIpResourcesRequest, SearchIpResourcesResponse, Range, SearchIpResourcesPage> {

    private SearchIpResourcesPage(
        PageContext<SearchIpResourcesRequest, SearchIpResourcesResponse, Range> context,
        SearchIpResourcesResponse response) {
      super(context, response);
    }

    private static SearchIpResourcesPage createEmptyPage() {
      return new SearchIpResourcesPage(null, null);
    }

    @Override
    protected SearchIpResourcesPage createPage(
        PageContext<SearchIpResourcesRequest, SearchIpResourcesResponse, Range> context,
        SearchIpResourcesResponse response) {
      return new SearchIpResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchIpResourcesPage> createPageAsync(
        PageContext<SearchIpResourcesRequest, SearchIpResourcesResponse, Range> context,
        ApiFuture<SearchIpResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchIpResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchIpResourcesRequest,
          SearchIpResourcesResponse,
          Range,
          SearchIpResourcesPage,
          SearchIpResourcesFixedSizeCollection> {

    private SearchIpResourcesFixedSizeCollection(
        List<SearchIpResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchIpResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchIpResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchIpResourcesFixedSizeCollection createCollection(
        List<SearchIpResourcesPage> pages, int collectionSize) {
      return new SearchIpResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRealmsPagedResponse
      extends AbstractPagedListResponse<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    public static ApiFuture<ListRealmsPagedResponse> createAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      ApiFuture<ListRealmsPage> futurePage =
          ListRealmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListRealmsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListRealmsPagedResponse(ListRealmsPage page) {
      super(page, ListRealmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRealmsPage
      extends AbstractPage<ListRealmsRequest, ListRealmsResponse, Realm, ListRealmsPage> {

    private ListRealmsPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      super(context, response);
    }

    private static ListRealmsPage createEmptyPage() {
      return new ListRealmsPage(null, null);
    }

    @Override
    protected ListRealmsPage createPage(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ListRealmsResponse response) {
      return new ListRealmsPage(context, response);
    }

    @Override
    public ApiFuture<ListRealmsPage> createPageAsync(
        PageContext<ListRealmsRequest, ListRealmsResponse, Realm> context,
        ApiFuture<ListRealmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRealmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRealmsRequest,
          ListRealmsResponse,
          Realm,
          ListRealmsPage,
          ListRealmsFixedSizeCollection> {

    private ListRealmsFixedSizeCollection(List<ListRealmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRealmsFixedSizeCollection createEmptyCollection() {
      return new ListRealmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRealmsFixedSizeCollection createCollection(
        List<ListRealmsPage> pages, int collectionSize) {
      return new ListRealmsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiscoveredRangesPagedResponse
      extends AbstractPagedListResponse<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          DiscoveredRange,
          ListDiscoveredRangesPage,
          ListDiscoveredRangesFixedSizeCollection> {

    public static ApiFuture<ListDiscoveredRangesPagedResponse> createAsync(
        PageContext<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
            context,
        ApiFuture<ListDiscoveredRangesResponse> futureResponse) {
      ApiFuture<ListDiscoveredRangesPage> futurePage =
          ListDiscoveredRangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiscoveredRangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiscoveredRangesPagedResponse(ListDiscoveredRangesPage page) {
      super(page, ListDiscoveredRangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiscoveredRangesPage
      extends AbstractPage<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          DiscoveredRange,
          ListDiscoveredRangesPage> {

    private ListDiscoveredRangesPage(
        PageContext<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
            context,
        ListDiscoveredRangesResponse response) {
      super(context, response);
    }

    private static ListDiscoveredRangesPage createEmptyPage() {
      return new ListDiscoveredRangesPage(null, null);
    }

    @Override
    protected ListDiscoveredRangesPage createPage(
        PageContext<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
            context,
        ListDiscoveredRangesResponse response) {
      return new ListDiscoveredRangesPage(context, response);
    }

    @Override
    public ApiFuture<ListDiscoveredRangesPage> createPageAsync(
        PageContext<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse, DiscoveredRange>
            context,
        ApiFuture<ListDiscoveredRangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiscoveredRangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          DiscoveredRange,
          ListDiscoveredRangesPage,
          ListDiscoveredRangesFixedSizeCollection> {

    private ListDiscoveredRangesFixedSizeCollection(
        List<ListDiscoveredRangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiscoveredRangesFixedSizeCollection createEmptyCollection() {
      return new ListDiscoveredRangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiscoveredRangesFixedSizeCollection createCollection(
        List<ListDiscoveredRangesPage> pages, int collectionSize) {
      return new ListDiscoveredRangesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomRangesPagedResponse
      extends AbstractPagedListResponse<
          ListCustomRangesRequest,
          ListCustomRangesResponse,
          CustomRange,
          ListCustomRangesPage,
          ListCustomRangesFixedSizeCollection> {

    public static ApiFuture<ListCustomRangesPagedResponse> createAsync(
        PageContext<ListCustomRangesRequest, ListCustomRangesResponse, CustomRange> context,
        ApiFuture<ListCustomRangesResponse> futureResponse) {
      ApiFuture<ListCustomRangesPage> futurePage =
          ListCustomRangesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomRangesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomRangesPagedResponse(ListCustomRangesPage page) {
      super(page, ListCustomRangesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomRangesPage
      extends AbstractPage<
          ListCustomRangesRequest, ListCustomRangesResponse, CustomRange, ListCustomRangesPage> {

    private ListCustomRangesPage(
        PageContext<ListCustomRangesRequest, ListCustomRangesResponse, CustomRange> context,
        ListCustomRangesResponse response) {
      super(context, response);
    }

    private static ListCustomRangesPage createEmptyPage() {
      return new ListCustomRangesPage(null, null);
    }

    @Override
    protected ListCustomRangesPage createPage(
        PageContext<ListCustomRangesRequest, ListCustomRangesResponse, CustomRange> context,
        ListCustomRangesResponse response) {
      return new ListCustomRangesPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomRangesPage> createPageAsync(
        PageContext<ListCustomRangesRequest, ListCustomRangesResponse, CustomRange> context,
        ApiFuture<ListCustomRangesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomRangesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomRangesRequest,
          ListCustomRangesResponse,
          CustomRange,
          ListCustomRangesPage,
          ListCustomRangesFixedSizeCollection> {

    private ListCustomRangesFixedSizeCollection(
        List<ListCustomRangesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomRangesFixedSizeCollection createEmptyCollection() {
      return new ListCustomRangesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomRangesFixedSizeCollection createCollection(
        List<ListCustomRangesPage> pages, int collectionSize) {
      return new ListCustomRangesFixedSizeCollection(pages, collectionSize);
    }
  }
}
