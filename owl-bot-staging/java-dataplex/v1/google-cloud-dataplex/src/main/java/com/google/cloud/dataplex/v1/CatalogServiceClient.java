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

package com.google.cloud.dataplex.v1;

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
import com.google.cloud.dataplex.v1.stub.CatalogServiceStub;
import com.google.cloud.dataplex.v1.stub.CatalogServiceStubSettings;
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
 * Service Description: The primary resources offered by this service are EntryGroups, EntryTypes,
 * AspectTypes, Entry and Aspect which collectively allow a data administrator to organize, manage,
 * secure and catalog data across their organization located across cloud projects in a variety of
 * storage systems including Cloud Storage and BigQuery.
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
 * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
 *   EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
 *   EntryType response = catalogServiceClient.getEntryType(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CatalogServiceClient object to clean up resources such
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
 *      <td><p> CreateEntryType</td>
 *      <td><p> Creates an EntryType</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntryTypeAsync(CreateEntryTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEntryTypeAsync(LocationName parent, EntryType entryType, String entryTypeId)
 *           <li><p> createEntryTypeAsync(String parent, EntryType entryType, String entryTypeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntryTypeOperationCallable()
 *           <li><p> createEntryTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntryType</td>
 *      <td><p> Updates a EntryType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntryTypeAsync(UpdateEntryTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEntryTypeAsync(EntryType entryType, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntryTypeOperationCallable()
 *           <li><p> updateEntryTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntryType</td>
 *      <td><p> Deletes a EntryType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntryTypeAsync(DeleteEntryTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEntryTypeAsync(EntryTypeName name)
 *           <li><p> deleteEntryTypeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntryTypeOperationCallable()
 *           <li><p> deleteEntryTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntryTypes</td>
 *      <td><p> Lists EntryType resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntryTypes(ListEntryTypesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntryTypes(LocationName parent)
 *           <li><p> listEntryTypes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntryTypesPagedCallable()
 *           <li><p> listEntryTypesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntryType</td>
 *      <td><p> Retrieves a EntryType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntryType(GetEntryTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntryType(EntryTypeName name)
 *           <li><p> getEntryType(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntryTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAspectType</td>
 *      <td><p> Creates an AspectType</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAspectTypeAsync(CreateAspectTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAspectTypeAsync(LocationName parent, AspectType aspectType, String aspectTypeId)
 *           <li><p> createAspectTypeAsync(String parent, AspectType aspectType, String aspectTypeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAspectTypeOperationCallable()
 *           <li><p> createAspectTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAspectType</td>
 *      <td><p> Updates a AspectType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAspectTypeAsync(UpdateAspectTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAspectTypeAsync(AspectType aspectType, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAspectTypeOperationCallable()
 *           <li><p> updateAspectTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAspectType</td>
 *      <td><p> Deletes a AspectType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAspectTypeAsync(DeleteAspectTypeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAspectTypeAsync(AspectTypeName name)
 *           <li><p> deleteAspectTypeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAspectTypeOperationCallable()
 *           <li><p> deleteAspectTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAspectTypes</td>
 *      <td><p> Lists AspectType resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAspectTypes(ListAspectTypesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAspectTypes(LocationName parent)
 *           <li><p> listAspectTypes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAspectTypesPagedCallable()
 *           <li><p> listAspectTypesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAspectType</td>
 *      <td><p> Retrieves a AspectType resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAspectType(GetAspectTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAspectType(AspectTypeName name)
 *           <li><p> getAspectType(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAspectTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntryGroup</td>
 *      <td><p> Creates an EntryGroup</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntryGroupAsync(CreateEntryGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEntryGroupAsync(LocationName parent, EntryGroup entryGroup, String entryGroupId)
 *           <li><p> createEntryGroupAsync(String parent, EntryGroup entryGroup, String entryGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntryGroupOperationCallable()
 *           <li><p> createEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntryGroup</td>
 *      <td><p> Updates a EntryGroup resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntryGroupAsync(UpdateEntryGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEntryGroupAsync(EntryGroup entryGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntryGroupOperationCallable()
 *           <li><p> updateEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntryGroup</td>
 *      <td><p> Deletes a EntryGroup resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntryGroupAsync(DeleteEntryGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEntryGroupAsync(EntryGroupName name)
 *           <li><p> deleteEntryGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntryGroupOperationCallable()
 *           <li><p> deleteEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntryGroups</td>
 *      <td><p> Lists EntryGroup resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntryGroups(ListEntryGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntryGroups(LocationName parent)
 *           <li><p> listEntryGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntryGroupsPagedCallable()
 *           <li><p> listEntryGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntryGroup</td>
 *      <td><p> Retrieves a EntryGroup resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntryGroup(GetEntryGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntryGroup(EntryGroupName name)
 *           <li><p> getEntryGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntry</td>
 *      <td><p> Creates an Entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntry(CreateEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEntry(EntryGroupName parent, Entry entry, String entryId)
 *           <li><p> createEntry(String parent, Entry entry, String entryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntry</td>
 *      <td><p> Updates an Entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntry(UpdateEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEntry(Entry entry, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntry</td>
 *      <td><p> Deletes an Entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntry(DeleteEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEntry(EntryName name)
 *           <li><p> deleteEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntries</td>
 *      <td><p> Lists entries within an entry group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntries(ListEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntries(EntryGroupName parent)
 *           <li><p> listEntries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntriesPagedCallable()
 *           <li><p> listEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntry</td>
 *      <td><p> Gets a single entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntry(GetEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntry(EntryName name)
 *           <li><p> getEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupEntry</td>
 *      <td><p> Looks up a single entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupEntry(LookupEntryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchEntries</td>
 *      <td><p> Searches for entries matching given query and scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchEntries(SearchEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchEntries(String name, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchEntriesPagedCallable()
 *           <li><p> searchEntriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of CatalogServiceSettings to
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
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
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
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
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
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newHttpJsonBuilder().build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CatalogServiceClient implements BackgroundResource {
  private final CatalogServiceSettings settings;
  private final CatalogServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CatalogServiceClient with default settings. */
  public static final CatalogServiceClient create() throws IOException {
    return create(CatalogServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CatalogServiceClient create(CatalogServiceSettings settings)
      throws IOException {
    return new CatalogServiceClient(settings);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CatalogServiceSettings).
   */
  public static final CatalogServiceClient create(CatalogServiceStub stub) {
    return new CatalogServiceClient(stub);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CatalogServiceClient(CatalogServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CatalogServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CatalogServiceClient(CatalogServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CatalogServiceSettings getSettings() {
    return settings;
  }

  public CatalogServiceStub getStub() {
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
   * Creates an EntryType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EntryType entryType = EntryType.newBuilder().build();
   *   String entryTypeId = "entryTypeId-1105721081";
   *   EntryType response =
   *       catalogServiceClient.createEntryTypeAsync(parent, entryType, entryTypeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the EntryType, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param entryType Required. EntryType Resource
   * @param entryTypeId Required. EntryType identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryType, OperationMetadata> createEntryTypeAsync(
      LocationName parent, EntryType entryType, String entryTypeId) {
    CreateEntryTypeRequest request =
        CreateEntryTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryType(entryType)
            .setEntryTypeId(entryTypeId)
            .build();
    return createEntryTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   EntryType entryType = EntryType.newBuilder().build();
   *   String entryTypeId = "entryTypeId-1105721081";
   *   EntryType response =
   *       catalogServiceClient.createEntryTypeAsync(parent, entryType, entryTypeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the EntryType, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param entryType Required. EntryType Resource
   * @param entryTypeId Required. EntryType identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryType, OperationMetadata> createEntryTypeAsync(
      String parent, EntryType entryType, String entryTypeId) {
    CreateEntryTypeRequest request =
        CreateEntryTypeRequest.newBuilder()
            .setParent(parent)
            .setEntryType(entryType)
            .setEntryTypeId(entryTypeId)
            .build();
    return createEntryTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryTypeRequest request =
   *       CreateEntryTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryTypeId("entryTypeId-1105721081")
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EntryType response = catalogServiceClient.createEntryTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryType, OperationMetadata> createEntryTypeAsync(
      CreateEntryTypeRequest request) {
    return createEntryTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryTypeRequest request =
   *       CreateEntryTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryTypeId("entryTypeId-1105721081")
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<EntryType, OperationMetadata> future =
   *       catalogServiceClient.createEntryTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   EntryType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable() {
    return stub.createEntryTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryTypeRequest request =
   *       CreateEntryTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryTypeId("entryTypeId-1105721081")
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.createEntryTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable() {
    return stub.createEntryTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryType entryType = EntryType.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntryType response = catalogServiceClient.updateEntryTypeAsync(entryType, updateMask).get();
   * }
   * }</pre>
   *
   * @param entryType Required. EntryType Resource
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryType, OperationMetadata> updateEntryTypeAsync(
      EntryType entryType, FieldMask updateMask) {
    UpdateEntryTypeRequest request =
        UpdateEntryTypeRequest.newBuilder()
            .setEntryType(entryType)
            .setUpdateMask(updateMask)
            .build();
    return updateEntryTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryTypeRequest request =
   *       UpdateEntryTypeRequest.newBuilder()
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EntryType response = catalogServiceClient.updateEntryTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryType, OperationMetadata> updateEntryTypeAsync(
      UpdateEntryTypeRequest request) {
    return updateEntryTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryTypeRequest request =
   *       UpdateEntryTypeRequest.newBuilder()
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<EntryType, OperationMetadata> future =
   *       catalogServiceClient.updateEntryTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   EntryType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable() {
    return stub.updateEntryTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryTypeRequest request =
   *       UpdateEntryTypeRequest.newBuilder()
   *           .setEntryType(EntryType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.updateEntryTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable() {
    return stub.updateEntryTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
   *   catalogServiceClient.deleteEntryTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryType:
   *     `projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryTypeAsync(EntryTypeName name) {
    DeleteEntryTypeRequest request =
        DeleteEntryTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEntryTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString();
   *   catalogServiceClient.deleteEntryTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryType:
   *     `projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryTypeAsync(String name) {
    DeleteEntryTypeRequest request = DeleteEntryTypeRequest.newBuilder().setName(name).build();
    return deleteEntryTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryTypeRequest request =
   *       DeleteEntryTypeRequest.newBuilder()
   *           .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   catalogServiceClient.deleteEntryTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryTypeAsync(
      DeleteEntryTypeRequest request) {
    return deleteEntryTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryTypeRequest request =
   *       DeleteEntryTypeRequest.newBuilder()
   *           .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       catalogServiceClient.deleteEntryTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable() {
    return stub.deleteEntryTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryTypeRequest request =
   *       DeleteEntryTypeRequest.newBuilder()
   *           .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.deleteEntryTypeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable() {
    return stub.deleteEntryTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EntryType element : catalogServiceClient.listEntryTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the EntryType location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryTypesPagedResponse listEntryTypes(LocationName parent) {
    ListEntryTypesRequest request =
        ListEntryTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntryTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EntryType element : catalogServiceClient.listEntryTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the EntryType location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryTypesPagedResponse listEntryTypes(String parent) {
    ListEntryTypesRequest request = ListEntryTypesRequest.newBuilder().setParent(parent).build();
    return listEntryTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryTypesRequest request =
   *       ListEntryTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EntryType element : catalogServiceClient.listEntryTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryTypesPagedResponse listEntryTypes(ListEntryTypesRequest request) {
    return listEntryTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryTypesRequest request =
   *       ListEntryTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EntryType> future =
   *       catalogServiceClient.listEntryTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EntryType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable() {
    return stub.listEntryTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryTypesRequest request =
   *       ListEntryTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEntryTypesResponse response =
   *         catalogServiceClient.listEntryTypesCallable().call(request);
   *     for (EntryType element : response.getEntryTypesList()) {
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
  public final UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse>
      listEntryTypesCallable() {
    return stub.listEntryTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
   *   EntryType response = catalogServiceClient.getEntryType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryType:
   *     `projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryType getEntryType(EntryTypeName name) {
    GetEntryTypeRequest request =
        GetEntryTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntryType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString();
   *   EntryType response = catalogServiceClient.getEntryType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryType:
   *     `projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryType getEntryType(String name) {
    GetEntryTypeRequest request = GetEntryTypeRequest.newBuilder().setName(name).build();
    return getEntryType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryTypeRequest request =
   *       GetEntryTypeRequest.newBuilder()
   *           .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
   *           .build();
   *   EntryType response = catalogServiceClient.getEntryType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryType getEntryType(GetEntryTypeRequest request) {
    return getEntryTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryTypeRequest request =
   *       GetEntryTypeRequest.newBuilder()
   *           .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
   *           .build();
   *   ApiFuture<EntryType> future = catalogServiceClient.getEntryTypeCallable().futureCall(request);
   *   // Do something.
   *   EntryType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable() {
    return stub.getEntryTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AspectType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AspectType aspectType = AspectType.newBuilder().build();
   *   String aspectTypeId = "aspectTypeId-423030675";
   *   AspectType response =
   *       catalogServiceClient.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AspectType, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param aspectType Required. AspectType Resource
   * @param aspectTypeId Required. AspectType identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AspectType, OperationMetadata> createAspectTypeAsync(
      LocationName parent, AspectType aspectType, String aspectTypeId) {
    CreateAspectTypeRequest request =
        CreateAspectTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAspectType(aspectType)
            .setAspectTypeId(aspectTypeId)
            .build();
    return createAspectTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AspectType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AspectType aspectType = AspectType.newBuilder().build();
   *   String aspectTypeId = "aspectTypeId-423030675";
   *   AspectType response =
   *       catalogServiceClient.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AspectType, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param aspectType Required. AspectType Resource
   * @param aspectTypeId Required. AspectType identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AspectType, OperationMetadata> createAspectTypeAsync(
      String parent, AspectType aspectType, String aspectTypeId) {
    CreateAspectTypeRequest request =
        CreateAspectTypeRequest.newBuilder()
            .setParent(parent)
            .setAspectType(aspectType)
            .setAspectTypeId(aspectTypeId)
            .build();
    return createAspectTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AspectType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateAspectTypeRequest request =
   *       CreateAspectTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAspectTypeId("aspectTypeId-423030675")
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   AspectType response = catalogServiceClient.createAspectTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AspectType, OperationMetadata> createAspectTypeAsync(
      CreateAspectTypeRequest request) {
    return createAspectTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AspectType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateAspectTypeRequest request =
   *       CreateAspectTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAspectTypeId("aspectTypeId-423030675")
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AspectType, OperationMetadata> future =
   *       catalogServiceClient.createAspectTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   AspectType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable() {
    return stub.createAspectTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an AspectType
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateAspectTypeRequest request =
   *       CreateAspectTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAspectTypeId("aspectTypeId-423030675")
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.createAspectTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable() {
    return stub.createAspectTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AspectType aspectType = AspectType.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AspectType response =
   *       catalogServiceClient.updateAspectTypeAsync(aspectType, updateMask).get();
   * }
   * }</pre>
   *
   * @param aspectType Required. AspectType Resource
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AspectType, OperationMetadata> updateAspectTypeAsync(
      AspectType aspectType, FieldMask updateMask) {
    UpdateAspectTypeRequest request =
        UpdateAspectTypeRequest.newBuilder()
            .setAspectType(aspectType)
            .setUpdateMask(updateMask)
            .build();
    return updateAspectTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateAspectTypeRequest request =
   *       UpdateAspectTypeRequest.newBuilder()
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   AspectType response = catalogServiceClient.updateAspectTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AspectType, OperationMetadata> updateAspectTypeAsync(
      UpdateAspectTypeRequest request) {
    return updateAspectTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateAspectTypeRequest request =
   *       UpdateAspectTypeRequest.newBuilder()
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<AspectType, OperationMetadata> future =
   *       catalogServiceClient.updateAspectTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   AspectType response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable() {
    return stub.updateAspectTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateAspectTypeRequest request =
   *       UpdateAspectTypeRequest.newBuilder()
   *           .setAspectType(AspectType.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.updateAspectTypeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable() {
    return stub.updateAspectTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
   *   catalogServiceClient.deleteAspectTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AspectType:
   *     `projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAspectTypeAsync(
      AspectTypeName name) {
    DeleteAspectTypeRequest request =
        DeleteAspectTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAspectTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString();
   *   catalogServiceClient.deleteAspectTypeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AspectType:
   *     `projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAspectTypeAsync(String name) {
    DeleteAspectTypeRequest request = DeleteAspectTypeRequest.newBuilder().setName(name).build();
    return deleteAspectTypeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteAspectTypeRequest request =
   *       DeleteAspectTypeRequest.newBuilder()
   *           .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   catalogServiceClient.deleteAspectTypeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAspectTypeAsync(
      DeleteAspectTypeRequest request) {
    return deleteAspectTypeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteAspectTypeRequest request =
   *       DeleteAspectTypeRequest.newBuilder()
   *           .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       catalogServiceClient.deleteAspectTypeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable() {
    return stub.deleteAspectTypeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteAspectTypeRequest request =
   *       DeleteAspectTypeRequest.newBuilder()
   *           .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.deleteAspectTypeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable() {
    return stub.deleteAspectTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AspectType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AspectType element : catalogServiceClient.listAspectTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AspectType location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAspectTypesPagedResponse listAspectTypes(LocationName parent) {
    ListAspectTypesRequest request =
        ListAspectTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAspectTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AspectType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AspectType element : catalogServiceClient.listAspectTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the AspectType location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAspectTypesPagedResponse listAspectTypes(String parent) {
    ListAspectTypesRequest request = ListAspectTypesRequest.newBuilder().setParent(parent).build();
    return listAspectTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AspectType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListAspectTypesRequest request =
   *       ListAspectTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AspectType element : catalogServiceClient.listAspectTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAspectTypesPagedResponse listAspectTypes(ListAspectTypesRequest request) {
    return listAspectTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AspectType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListAspectTypesRequest request =
   *       ListAspectTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AspectType> future =
   *       catalogServiceClient.listAspectTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AspectType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable() {
    return stub.listAspectTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AspectType resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListAspectTypesRequest request =
   *       ListAspectTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAspectTypesResponse response =
   *         catalogServiceClient.listAspectTypesCallable().call(request);
   *     for (AspectType element : response.getAspectTypesList()) {
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
  public final UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse>
      listAspectTypesCallable() {
    return stub.listAspectTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
   *   AspectType response = catalogServiceClient.getAspectType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AspectType:
   *     `projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AspectType getAspectType(AspectTypeName name) {
    GetAspectTypeRequest request =
        GetAspectTypeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAspectType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString();
   *   AspectType response = catalogServiceClient.getAspectType(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AspectType:
   *     `projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AspectType getAspectType(String name) {
    GetAspectTypeRequest request = GetAspectTypeRequest.newBuilder().setName(name).build();
    return getAspectType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetAspectTypeRequest request =
   *       GetAspectTypeRequest.newBuilder()
   *           .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .build();
   *   AspectType response = catalogServiceClient.getAspectType(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AspectType getAspectType(GetAspectTypeRequest request) {
    return getAspectTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a AspectType resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetAspectTypeRequest request =
   *       GetAspectTypeRequest.newBuilder()
   *           .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
   *           .build();
   *   ApiFuture<AspectType> future =
   *       catalogServiceClient.getAspectTypeCallable().futureCall(request);
   *   // Do something.
   *   AspectType response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable() {
    return stub.getAspectTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryGroup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup response =
   *       catalogServiceClient.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the entryGroup, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param entryGroup Required. EntryGroup Resource
   * @param entryGroupId Required. EntryGroup identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryGroup, OperationMetadata> createEntryGroupAsync(
      LocationName parent, EntryGroup entryGroup, String entryGroupId) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryGroup(entryGroup)
            .setEntryGroupId(entryGroupId)
            .build();
    return createEntryGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryGroup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup response =
   *       catalogServiceClient.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the entryGroup, of the form:
   *     projects/{project_number}/locations/{location_id} where `location_id` refers to a GCP
   *     region.
   * @param entryGroup Required. EntryGroup Resource
   * @param entryGroupId Required. EntryGroup identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryGroup, OperationMetadata> createEntryGroupAsync(
      String parent, EntryGroup entryGroup, String entryGroupId) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent)
            .setEntryGroup(entryGroup)
            .setEntryGroupId(entryGroupId)
            .build();
    return createEntryGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryGroup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EntryGroup response = catalogServiceClient.createEntryGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryGroup, OperationMetadata> createEntryGroupAsync(
      CreateEntryGroupRequest request) {
    return createEntryGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryGroup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<EntryGroup, OperationMetadata> future =
   *       catalogServiceClient.createEntryGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable() {
    return stub.createEntryGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an EntryGroup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.createEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable() {
    return stub.createEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntryGroup response =
   *       catalogServiceClient.updateEntryGroupAsync(entryGroup, updateMask).get();
   * }
   * }</pre>
   *
   * @param entryGroup Required. EntryGroup Resource
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryGroup, OperationMetadata> updateEntryGroupAsync(
      EntryGroup entryGroup, FieldMask updateMask) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder()
            .setEntryGroup(entryGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateEntryGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EntryGroup response = catalogServiceClient.updateEntryGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EntryGroup, OperationMetadata> updateEntryGroupAsync(
      UpdateEntryGroupRequest request) {
    return updateEntryGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<EntryGroup, OperationMetadata> future =
   *       catalogServiceClient.updateEntryGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable() {
    return stub.updateEntryGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.updateEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable() {
    return stub.updateEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   catalogServiceClient.deleteEntryGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryGroup:
   *     `projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryGroupAsync(
      EntryGroupName name) {
    DeleteEntryGroupRequest request =
        DeleteEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEntryGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   catalogServiceClient.deleteEntryGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryGroup:
   *     `projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryGroupAsync(String name) {
    DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder().setName(name).build();
    return deleteEntryGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   catalogServiceClient.deleteEntryGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEntryGroupAsync(
      DeleteEntryGroupRequest request) {
    return deleteEntryGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       catalogServiceClient.deleteEntryGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable() {
    return stub.deleteEntryGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       catalogServiceClient.deleteEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable() {
    return stub.deleteEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryGroup resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EntryGroup element : catalogServiceClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the entryGroup location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(LocationName parent) {
    ListEntryGroupsRequest request =
        ListEntryGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryGroup resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EntryGroup element : catalogServiceClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the entryGroup location, of the form:
   *     `projects/{project_number}/locations/{location_id}` where `location_id` refers to a GCP
   *     region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(String parent) {
    ListEntryGroupsRequest request = ListEntryGroupsRequest.newBuilder().setParent(parent).build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryGroup resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (EntryGroup element : catalogServiceClient.listEntryGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(ListEntryGroupsRequest request) {
    return listEntryGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryGroup resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       catalogServiceClient.listEntryGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EntryGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return stub.listEntryGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EntryGroup resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEntryGroupsResponse response =
   *         catalogServiceClient.listEntryGroupsCallable().call(request);
   *     for (EntryGroup element : response.getEntryGroupsList()) {
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
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable() {
    return stub.listEntryGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   EntryGroup response = catalogServiceClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryGroup:
   *     `projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(EntryGroupName name) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   EntryGroup response = catalogServiceClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntryGroup:
   *     `projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name) {
    GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder().setName(name).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .build();
   *   EntryGroup response = catalogServiceClient.getEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(GetEntryGroupRequest request) {
    return getEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a EntryGroup resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       catalogServiceClient.getEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return stub.getEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   Entry entry = Entry.newBuilder().build();
   *   String entryId = "entryId-1591558867";
   *   Entry response = catalogServiceClient.createEntry(parent, entry, entryId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent Entry Group:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}`.
   * @param entry Required. Entry resource.
   * @param entryId Required. Entry identifier. It has to be unique within an Entry Group.
   *     <p>Entries corresponding to Google Cloud resources use Entry ID format based on Full
   *     Resource Names (https://cloud.google.com/apis/design/resource_names#full_resource_name).
   *     The format is a Full Resource Name of the resource without the prefix double slashes in the
   *     API Service Name part of Full Resource Name. This allows retrieval of entries using their
   *     associated resource name.
   *     <p>For example if the Full Resource Name of a resource is
   *     `//library.googleapis.com/shelves/shelf1/books/book2`, then the suggested entry_id is
   *     `library.googleapis.com/shelves/shelf1/books/book2`.
   *     <p>It is also suggested to follow the same convention for entries corresponding to
   *     resources from other providers or systems than Google Cloud.
   *     <p>The maximum size of the field is 4000 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(EntryGroupName parent, Entry entry, String entryId) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntry(entry)
            .setEntryId(entryId)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   Entry entry = Entry.newBuilder().build();
   *   String entryId = "entryId-1591558867";
   *   Entry response = catalogServiceClient.createEntry(parent, entry, entryId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent Entry Group:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}`.
   * @param entry Required. Entry resource.
   * @param entryId Required. Entry identifier. It has to be unique within an Entry Group.
   *     <p>Entries corresponding to Google Cloud resources use Entry ID format based on Full
   *     Resource Names (https://cloud.google.com/apis/design/resource_names#full_resource_name).
   *     The format is a Full Resource Name of the resource without the prefix double slashes in the
   *     API Service Name part of Full Resource Name. This allows retrieval of entries using their
   *     associated resource name.
   *     <p>For example if the Full Resource Name of a resource is
   *     `//library.googleapis.com/shelves/shelf1/books/book2`, then the suggested entry_id is
   *     `library.googleapis.com/shelves/shelf1/books/book2`.
   *     <p>It is also suggested to follow the same convention for entries corresponding to
   *     resources from other providers or systems than Google Cloud.
   *     <p>The maximum size of the field is 4000 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(String parent, Entry entry, String entryId) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent)
            .setEntry(entry)
            .setEntryId(entryId)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   Entry response = catalogServiceClient.createEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(CreateEntryRequest request) {
    return createEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.createEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return stub.createEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entry response = catalogServiceClient.updateEntry(entry, updateMask);
   * }
   * }</pre>
   *
   * @param entry Required. Entry resource.
   * @param updateMask Optional. Mask of fields to update. To update Aspects, the update_mask must
   *     contain the value "aspects".
   *     <p>If the update_mask is empty, all modifiable fields present in the request will be
   *     updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(Entry entry, FieldMask updateMask) {
    UpdateEntryRequest request =
        UpdateEntryRequest.newBuilder().setEntry(entry).setUpdateMask(updateMask).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setDeleteMissingAspects(true)
   *           .addAllAspectKeys(new ArrayList<String>())
   *           .build();
   *   Entry response = catalogServiceClient.updateEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(UpdateEntryRequest request) {
    return updateEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setDeleteMissingAspects(true)
   *           .addAllAspectKeys(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.updateEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return stub.updateEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = catalogServiceClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Entry:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry deleteEntry(EntryName name) {
    DeleteEntryRequest request =
        DeleteEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Entry response = catalogServiceClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Entry:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry deleteEntry(String name) {
    DeleteEntryRequest request = DeleteEntryRequest.newBuilder().setName(name).build();
    return deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   Entry response = catalogServiceClient.deleteEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry deleteEntry(DeleteEntryRequest request) {
    return deleteEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.deleteEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable() {
    return stub.deleteEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries within an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   for (Entry element : catalogServiceClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent Entry Group:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(EntryGroupName parent) {
    ListEntriesRequest request =
        ListEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries within an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   for (Entry element : catalogServiceClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent Entry Group:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(String parent) {
    ListEntriesRequest request = ListEntriesRequest.newBuilder().setParent(parent).build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries within an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Entry element : catalogServiceClient.listEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(ListEntriesRequest request) {
    return listEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries within an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.listEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable() {
    return stub.listEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries within an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListEntriesResponse response = catalogServiceClient.listEntriesCallable().call(request);
   *     for (Entry element : response.getEntriesList()) {
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
  public final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return stub.listEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = catalogServiceClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Entry:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(EntryName name) {
    GetEntryRequest request =
        GetEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Entry response = catalogServiceClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Entry:
   *     `projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(String name) {
    GetEntryRequest request = GetEntryRequest.newBuilder().setName(name).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setView(EntryView.forNumber(0))
   *           .addAllAspectTypes(new ArrayList<String>())
   *           .addAllPaths(new ArrayList<String>())
   *           .build();
   *   Entry response = catalogServiceClient.getEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(GetEntryRequest request) {
    return getEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setView(EntryView.forNumber(0))
   *           .addAllAspectTypes(new ArrayList<String>())
   *           .addAllPaths(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.getEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return stub.getEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LookupEntryRequest request =
   *       LookupEntryRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(EntryView.forNumber(0))
   *           .addAllAspectTypes(new ArrayList<String>())
   *           .addAllPaths(new ArrayList<String>())
   *           .setEntry(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   Entry response = catalogServiceClient.lookupEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry lookupEntry(LookupEntryRequest request) {
    return lookupEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up a single entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LookupEntryRequest request =
   *       LookupEntryRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(EntryView.forNumber(0))
   *           .addAllAspectTypes(new ArrayList<String>())
   *           .addAllPaths(new ArrayList<String>())
   *           .setEntry(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Entry> future = catalogServiceClient.lookupEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return stub.lookupEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for entries matching given query and scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = "name3373707";
   *   String query = "query107944136";
   *   for (SearchEntriesResult element :
   *       catalogServiceClient.searchEntries(name, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The project to which the request should be attributed in the following
   *     form: `projects/{project}/locations/{location}`.
   * @param query Required. The query against which entries in scope should be matched.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEntriesPagedResponse searchEntries(String name, String query) {
    SearchEntriesRequest request =
        SearchEntriesRequest.newBuilder().setName(name).setQuery(query).build();
    return searchEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for entries matching given query and scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   SearchEntriesRequest request =
   *       SearchEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setScope("scope109264468")
   *           .build();
   *   for (SearchEntriesResult element : catalogServiceClient.searchEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchEntriesPagedResponse searchEntries(SearchEntriesRequest request) {
    return searchEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for entries matching given query and scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   SearchEntriesRequest request =
   *       SearchEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setScope("scope109264468")
   *           .build();
   *   ApiFuture<SearchEntriesResult> future =
   *       catalogServiceClient.searchEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchEntriesResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable() {
    return stub.searchEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for entries matching given query and scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   SearchEntriesRequest request =
   *       SearchEntriesRequest.newBuilder()
   *           .setName("name3373707")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setScope("scope109264468")
   *           .build();
   *   while (true) {
   *     SearchEntriesResponse response = catalogServiceClient.searchEntriesCallable().call(request);
   *     for (SearchEntriesResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable() {
    return stub.searchEntriesCallable();
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : catalogServiceClient.listLocations(request).iterateAll()) {
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       catalogServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = catalogServiceClient.listLocationsCallable().call(request);
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = catalogServiceClient.getLocation(request);
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = catalogServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListEntryTypesPagedResponse
      extends AbstractPagedListResponse<
          ListEntryTypesRequest,
          ListEntryTypesResponse,
          EntryType,
          ListEntryTypesPage,
          ListEntryTypesFixedSizeCollection> {

    public static ApiFuture<ListEntryTypesPagedResponse> createAsync(
        PageContext<ListEntryTypesRequest, ListEntryTypesResponse, EntryType> context,
        ApiFuture<ListEntryTypesResponse> futureResponse) {
      ApiFuture<ListEntryTypesPage> futurePage =
          ListEntryTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntryTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntryTypesPagedResponse(ListEntryTypesPage page) {
      super(page, ListEntryTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntryTypesPage
      extends AbstractPage<
          ListEntryTypesRequest, ListEntryTypesResponse, EntryType, ListEntryTypesPage> {

    private ListEntryTypesPage(
        PageContext<ListEntryTypesRequest, ListEntryTypesResponse, EntryType> context,
        ListEntryTypesResponse response) {
      super(context, response);
    }

    private static ListEntryTypesPage createEmptyPage() {
      return new ListEntryTypesPage(null, null);
    }

    @Override
    protected ListEntryTypesPage createPage(
        PageContext<ListEntryTypesRequest, ListEntryTypesResponse, EntryType> context,
        ListEntryTypesResponse response) {
      return new ListEntryTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntryTypesPage> createPageAsync(
        PageContext<ListEntryTypesRequest, ListEntryTypesResponse, EntryType> context,
        ApiFuture<ListEntryTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntryTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntryTypesRequest,
          ListEntryTypesResponse,
          EntryType,
          ListEntryTypesPage,
          ListEntryTypesFixedSizeCollection> {

    private ListEntryTypesFixedSizeCollection(List<ListEntryTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntryTypesFixedSizeCollection createEmptyCollection() {
      return new ListEntryTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntryTypesFixedSizeCollection createCollection(
        List<ListEntryTypesPage> pages, int collectionSize) {
      return new ListEntryTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAspectTypesPagedResponse
      extends AbstractPagedListResponse<
          ListAspectTypesRequest,
          ListAspectTypesResponse,
          AspectType,
          ListAspectTypesPage,
          ListAspectTypesFixedSizeCollection> {

    public static ApiFuture<ListAspectTypesPagedResponse> createAsync(
        PageContext<ListAspectTypesRequest, ListAspectTypesResponse, AspectType> context,
        ApiFuture<ListAspectTypesResponse> futureResponse) {
      ApiFuture<ListAspectTypesPage> futurePage =
          ListAspectTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAspectTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAspectTypesPagedResponse(ListAspectTypesPage page) {
      super(page, ListAspectTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAspectTypesPage
      extends AbstractPage<
          ListAspectTypesRequest, ListAspectTypesResponse, AspectType, ListAspectTypesPage> {

    private ListAspectTypesPage(
        PageContext<ListAspectTypesRequest, ListAspectTypesResponse, AspectType> context,
        ListAspectTypesResponse response) {
      super(context, response);
    }

    private static ListAspectTypesPage createEmptyPage() {
      return new ListAspectTypesPage(null, null);
    }

    @Override
    protected ListAspectTypesPage createPage(
        PageContext<ListAspectTypesRequest, ListAspectTypesResponse, AspectType> context,
        ListAspectTypesResponse response) {
      return new ListAspectTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListAspectTypesPage> createPageAsync(
        PageContext<ListAspectTypesRequest, ListAspectTypesResponse, AspectType> context,
        ApiFuture<ListAspectTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAspectTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAspectTypesRequest,
          ListAspectTypesResponse,
          AspectType,
          ListAspectTypesPage,
          ListAspectTypesFixedSizeCollection> {

    private ListAspectTypesFixedSizeCollection(
        List<ListAspectTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAspectTypesFixedSizeCollection createEmptyCollection() {
      return new ListAspectTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAspectTypesFixedSizeCollection createCollection(
        List<ListAspectTypesPage> pages, int collectionSize) {
      return new ListAspectTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntryGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    public static ApiFuture<ListEntryGroupsPagedResponse> createAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      ApiFuture<ListEntryGroupsPage> futurePage =
          ListEntryGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntryGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntryGroupsPagedResponse(ListEntryGroupsPage page) {
      super(page, ListEntryGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntryGroupsPage
      extends AbstractPage<
          ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup, ListEntryGroupsPage> {

    private ListEntryGroupsPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      super(context, response);
    }

    private static ListEntryGroupsPage createEmptyPage() {
      return new ListEntryGroupsPage(null, null);
    }

    @Override
    protected ListEntryGroupsPage createPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      return new ListEntryGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntryGroupsPage> createPageAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntryGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    private ListEntryGroupsFixedSizeCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntryGroupsFixedSizeCollection createEmptyCollection() {
      return new ListEntryGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntryGroupsFixedSizeCollection createCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      return new ListEntryGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    public static ApiFuture<ListEntriesPagedResponse> createAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      ApiFuture<ListEntriesPage> futurePage =
          ListEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEntriesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEntriesPagedResponse(ListEntriesPage page) {
      super(page, ListEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntriesPage
      extends AbstractPage<ListEntriesRequest, ListEntriesResponse, Entry, ListEntriesPage> {

    private ListEntriesPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      super(context, response);
    }

    private static ListEntriesPage createEmptyPage() {
      return new ListEntriesPage(null, null);
    }

    @Override
    protected ListEntriesPage createPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      return new ListEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntriesPage> createPageAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    private ListEntriesFixedSizeCollection(List<ListEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntriesFixedSizeCollection createEmptyCollection() {
      return new ListEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntriesFixedSizeCollection createCollection(
        List<ListEntriesPage> pages, int collectionSize) {
      return new ListEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchEntriesPagedResponse
      extends AbstractPagedListResponse<
          SearchEntriesRequest,
          SearchEntriesResponse,
          SearchEntriesResult,
          SearchEntriesPage,
          SearchEntriesFixedSizeCollection> {

    public static ApiFuture<SearchEntriesPagedResponse> createAsync(
        PageContext<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult> context,
        ApiFuture<SearchEntriesResponse> futureResponse) {
      ApiFuture<SearchEntriesPage> futurePage =
          SearchEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchEntriesPagedResponse(SearchEntriesPage page) {
      super(page, SearchEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchEntriesPage
      extends AbstractPage<
          SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult, SearchEntriesPage> {

    private SearchEntriesPage(
        PageContext<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult> context,
        SearchEntriesResponse response) {
      super(context, response);
    }

    private static SearchEntriesPage createEmptyPage() {
      return new SearchEntriesPage(null, null);
    }

    @Override
    protected SearchEntriesPage createPage(
        PageContext<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult> context,
        SearchEntriesResponse response) {
      return new SearchEntriesPage(context, response);
    }

    @Override
    public ApiFuture<SearchEntriesPage> createPageAsync(
        PageContext<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult> context,
        ApiFuture<SearchEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchEntriesRequest,
          SearchEntriesResponse,
          SearchEntriesResult,
          SearchEntriesPage,
          SearchEntriesFixedSizeCollection> {

    private SearchEntriesFixedSizeCollection(List<SearchEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchEntriesFixedSizeCollection createEmptyCollection() {
      return new SearchEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchEntriesFixedSizeCollection createCollection(
        List<SearchEntriesPage> pages, int collectionSize) {
      return new SearchEntriesFixedSizeCollection(pages, collectionSize);
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
