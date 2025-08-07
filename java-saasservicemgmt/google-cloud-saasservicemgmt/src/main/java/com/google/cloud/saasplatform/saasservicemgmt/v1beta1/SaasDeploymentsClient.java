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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasDeploymentsStub;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasDeploymentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages the deployment of SaaS services.
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
 * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
 *   SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
 *   Saas response = saasDeploymentsClient.getSaas(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SaasDeploymentsClient object to clean up resources
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
 *      <td><p> ListSaas</td>
 *      <td><p> Retrieve a collection of saas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSaas(ListSaasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSaas(LocationName parent)
 *           <li><p> listSaas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSaasPagedCallable()
 *           <li><p> listSaasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSaas</td>
 *      <td><p> Retrieve a single saas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSaas(GetSaasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSaas(SaasName name)
 *           <li><p> getSaas(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSaasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSaas</td>
 *      <td><p> Create a new saas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSaas(CreateSaasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSaas(LocationName parent, Saas saas, String saasId)
 *           <li><p> createSaas(String parent, Saas saas, String saasId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSaasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSaas</td>
 *      <td><p> Update a single saas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSaas(UpdateSaasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSaas(Saas saas, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSaasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSaas</td>
 *      <td><p> Delete a single saas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSaas(DeleteSaasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSaas(SaasName name)
 *           <li><p> deleteSaas(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSaasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTenants</td>
 *      <td><p> Retrieve a collection of tenants.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTenants(ListTenantsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTenants(LocationName parent)
 *           <li><p> listTenants(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTenantsPagedCallable()
 *           <li><p> listTenantsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTenant</td>
 *      <td><p> Retrieve a single tenant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTenant(GetTenantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTenant(TenantName name)
 *           <li><p> getTenant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTenantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTenant</td>
 *      <td><p> Create a new tenant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTenant(CreateTenantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTenant(LocationName parent, Tenant tenant, String tenantId)
 *           <li><p> createTenant(String parent, Tenant tenant, String tenantId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTenantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTenant</td>
 *      <td><p> Update a single tenant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTenant(UpdateTenantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTenant(Tenant tenant, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTenantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTenant</td>
 *      <td><p> Delete a single tenant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTenant(DeleteTenantRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTenant(TenantName name)
 *           <li><p> deleteTenant(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTenantCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUnitKinds</td>
 *      <td><p> Retrieve a collection of unit kinds.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUnitKinds(ListUnitKindsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUnitKinds(LocationName parent)
 *           <li><p> listUnitKinds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUnitKindsPagedCallable()
 *           <li><p> listUnitKindsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUnitKind</td>
 *      <td><p> Retrieve a single unit kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUnitKind(GetUnitKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUnitKind(UnitKindName name)
 *           <li><p> getUnitKind(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUnitKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUnitKind</td>
 *      <td><p> Create a new unit kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUnitKind(CreateUnitKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUnitKind(LocationName parent, UnitKind unitKind, String unitKindId)
 *           <li><p> createUnitKind(String parent, UnitKind unitKind, String unitKindId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUnitKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUnitKind</td>
 *      <td><p> Update a single unit kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUnitKind(UpdateUnitKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUnitKind(UnitKind unitKind, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUnitKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUnitKind</td>
 *      <td><p> Delete a single unit kind.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUnitKind(DeleteUnitKindRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUnitKind(UnitKindName name)
 *           <li><p> deleteUnitKind(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUnitKindCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUnits</td>
 *      <td><p> Retrieve a collection of units.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUnits(ListUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUnits(LocationName parent)
 *           <li><p> listUnits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUnitsPagedCallable()
 *           <li><p> listUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUnit</td>
 *      <td><p> Retrieve a single unit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUnit(GetUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUnit(UnitName name)
 *           <li><p> getUnit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUnit</td>
 *      <td><p> Create a new unit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUnit(CreateUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUnit(LocationName parent, Unit unit, String unitId)
 *           <li><p> createUnit(String parent, Unit unit, String unitId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUnit</td>
 *      <td><p> Update a single unit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUnit(UpdateUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUnit(Unit unit, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUnit</td>
 *      <td><p> Delete a single unit.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUnit(DeleteUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUnit(UnitName name)
 *           <li><p> deleteUnit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUnitOperations</td>
 *      <td><p> Retrieve a collection of unit operations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUnitOperations(ListUnitOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUnitOperations(LocationName parent)
 *           <li><p> listUnitOperations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUnitOperationsPagedCallable()
 *           <li><p> listUnitOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUnitOperation</td>
 *      <td><p> Retrieve a single unit operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUnitOperation(GetUnitOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUnitOperation(UnitOperationName name)
 *           <li><p> getUnitOperation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUnitOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUnitOperation</td>
 *      <td><p> Create a new unit operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUnitOperation(CreateUnitOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUnitOperation(LocationName parent, UnitOperation unitOperation, String unitOperationId)
 *           <li><p> createUnitOperation(String parent, UnitOperation unitOperation, String unitOperationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUnitOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUnitOperation</td>
 *      <td><p> Update a single unit operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUnitOperation(UpdateUnitOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUnitOperation(UnitOperation unitOperation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUnitOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUnitOperation</td>
 *      <td><p> Delete a single unit operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUnitOperation(DeleteUnitOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUnitOperation(UnitOperationName name)
 *           <li><p> deleteUnitOperation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUnitOperationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReleases</td>
 *      <td><p> Retrieve a collection of releases.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReleases(ListReleasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReleases(LocationName parent)
 *           <li><p> listReleases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReleasesPagedCallable()
 *           <li><p> listReleasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRelease</td>
 *      <td><p> Retrieve a single release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRelease(GetReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRelease(ReleaseName name)
 *           <li><p> getRelease(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRelease</td>
 *      <td><p> Create a new release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRelease(CreateReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createRelease(LocationName parent, Release release, String releaseId)
 *           <li><p> createRelease(String parent, Release release, String releaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRelease</td>
 *      <td><p> Update a single release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRelease(UpdateReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateRelease(Release release, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReleaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRelease</td>
 *      <td><p> Delete a single release.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRelease(DeleteReleaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteRelease(ReleaseName name)
 *           <li><p> deleteRelease(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReleaseCallable()
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
 * <p>This class can be customized by passing in a custom instance of SaasDeploymentsSettings to
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
 * SaasDeploymentsSettings saasDeploymentsSettings =
 *     SaasDeploymentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SaasDeploymentsClient saasDeploymentsClient =
 *     SaasDeploymentsClient.create(saasDeploymentsSettings);
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
 * SaasDeploymentsSettings saasDeploymentsSettings =
 *     SaasDeploymentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SaasDeploymentsClient saasDeploymentsClient =
 *     SaasDeploymentsClient.create(saasDeploymentsSettings);
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
 * SaasDeploymentsSettings saasDeploymentsSettings =
 *     SaasDeploymentsSettings.newHttpJsonBuilder().build();
 * SaasDeploymentsClient saasDeploymentsClient =
 *     SaasDeploymentsClient.create(saasDeploymentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasDeploymentsClient implements BackgroundResource {
  private final SaasDeploymentsSettings settings;
  private final SaasDeploymentsStub stub;

  /** Constructs an instance of SaasDeploymentsClient with default settings. */
  public static final SaasDeploymentsClient create() throws IOException {
    return create(SaasDeploymentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SaasDeploymentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SaasDeploymentsClient create(SaasDeploymentsSettings settings)
      throws IOException {
    return new SaasDeploymentsClient(settings);
  }

  /**
   * Constructs an instance of SaasDeploymentsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SaasDeploymentsSettings).
   */
  public static final SaasDeploymentsClient create(SaasDeploymentsStub stub) {
    return new SaasDeploymentsClient(stub);
  }

  /**
   * Constructs an instance of SaasDeploymentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SaasDeploymentsClient(SaasDeploymentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SaasDeploymentsStubSettings) settings.getStubSettings()).createStub();
  }

  protected SaasDeploymentsClient(SaasDeploymentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SaasDeploymentsSettings getSettings() {
    return settings;
  }

  public SaasDeploymentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Saas element : saasDeploymentsClient.listSaas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the saas.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSaasPagedResponse listSaas(LocationName parent) {
    ListSaasRequest request =
        ListSaasRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Saas element : saasDeploymentsClient.listSaas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the saas.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSaasPagedResponse listSaas(String parent) {
    ListSaasRequest request = ListSaasRequest.newBuilder().setParent(parent).build();
    return listSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListSaasRequest request =
   *       ListSaasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Saas element : saasDeploymentsClient.listSaas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSaasPagedResponse listSaas(ListSaasRequest request) {
    return listSaasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListSaasRequest request =
   *       ListSaasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Saas> future = saasDeploymentsClient.listSaasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Saas element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSaasRequest, ListSaasPagedResponse> listSaasPagedCallable() {
    return stub.listSaasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListSaasRequest request =
   *       ListSaasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSaasResponse response = saasDeploymentsClient.listSaasCallable().call(request);
   *     for (Saas element : response.getSaasList()) {
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
  public final UnaryCallable<ListSaasRequest, ListSaasResponse> listSaasCallable() {
    return stub.listSaasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
   *   Saas response = saasDeploymentsClient.getSaas(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas getSaas(SaasName name) {
    GetSaasRequest request =
        GetSaasRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString();
   *   Saas response = saasDeploymentsClient.getSaas(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas getSaas(String name) {
    GetSaasRequest request = GetSaasRequest.newBuilder().setName(name).build();
    return getSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetSaasRequest request =
   *       GetSaasRequest.newBuilder()
   *           .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
   *           .build();
   *   Saas response = saasDeploymentsClient.getSaas(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas getSaas(GetSaasRequest request) {
    return getSaasCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetSaasRequest request =
   *       GetSaasRequest.newBuilder()
   *           .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
   *           .build();
   *   ApiFuture<Saas> future = saasDeploymentsClient.getSaasCallable().futureCall(request);
   *   // Do something.
   *   Saas response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSaasRequest, Saas> getSaasCallable() {
    return stub.getSaasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Saas saas = Saas.newBuilder().build();
   *   String saasId = "saasId-910030789";
   *   Saas response = saasDeploymentsClient.createSaas(parent, saas, saasId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the saas.
   * @param saas Required. The desired state for the saas.
   * @param saasId Required. The ID value for the new saas.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas createSaas(LocationName parent, Saas saas, String saasId) {
    CreateSaasRequest request =
        CreateSaasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSaas(saas)
            .setSaasId(saasId)
            .build();
    return createSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Saas saas = Saas.newBuilder().build();
   *   String saasId = "saasId-910030789";
   *   Saas response = saasDeploymentsClient.createSaas(parent, saas, saasId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the saas.
   * @param saas Required. The desired state for the saas.
   * @param saasId Required. The ID value for the new saas.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas createSaas(String parent, Saas saas, String saasId) {
    CreateSaasRequest request =
        CreateSaasRequest.newBuilder().setParent(parent).setSaas(saas).setSaasId(saasId).build();
    return createSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateSaasRequest request =
   *       CreateSaasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSaasId("saasId-910030789")
   *           .setSaas(Saas.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Saas response = saasDeploymentsClient.createSaas(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas createSaas(CreateSaasRequest request) {
    return createSaasCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateSaasRequest request =
   *       CreateSaasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSaasId("saasId-910030789")
   *           .setSaas(Saas.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Saas> future = saasDeploymentsClient.createSaasCallable().futureCall(request);
   *   // Do something.
   *   Saas response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSaasRequest, Saas> createSaasCallable() {
    return stub.createSaasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   Saas saas = Saas.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Saas response = saasDeploymentsClient.updateSaas(saas, updateMask);
   * }
   * }</pre>
   *
   * @param saas Required. The desired state for the saas.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Saas
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the Saas will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas updateSaas(Saas saas, FieldMask updateMask) {
    UpdateSaasRequest request =
        UpdateSaasRequest.newBuilder().setSaas(saas).setUpdateMask(updateMask).build();
    return updateSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateSaasRequest request =
   *       UpdateSaasRequest.newBuilder()
   *           .setSaas(Saas.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Saas response = saasDeploymentsClient.updateSaas(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Saas updateSaas(UpdateSaasRequest request) {
    return updateSaasCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateSaasRequest request =
   *       UpdateSaasRequest.newBuilder()
   *           .setSaas(Saas.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Saas> future = saasDeploymentsClient.updateSaasCallable().futureCall(request);
   *   // Do something.
   *   Saas response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSaasRequest, Saas> updateSaasCallable() {
    return stub.updateSaasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
   *   saasDeploymentsClient.deleteSaas(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSaas(SaasName name) {
    DeleteSaasRequest request =
        DeleteSaasRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString();
   *   saasDeploymentsClient.deleteSaas(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSaas(String name) {
    DeleteSaasRequest request = DeleteSaasRequest.newBuilder().setName(name).build();
    deleteSaas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteSaasRequest request =
   *       DeleteSaasRequest.newBuilder()
   *           .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteSaas(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSaas(DeleteSaasRequest request) {
    deleteSaasCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single saas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteSaasRequest request =
   *       DeleteSaasRequest.newBuilder()
   *           .setName(SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasDeploymentsClient.deleteSaasCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSaasRequest, Empty> deleteSaasCallable() {
    return stub.deleteSaasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of tenants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Tenant element : saasDeploymentsClient.listTenants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the tenant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(LocationName parent) {
    ListTenantsRequest request =
        ListTenantsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTenants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of tenants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Tenant element : saasDeploymentsClient.listTenants(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the tenant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(String parent) {
    ListTenantsRequest request = ListTenantsRequest.newBuilder().setParent(parent).build();
    return listTenants(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of tenants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListTenantsRequest request =
   *       ListTenantsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Tenant element : saasDeploymentsClient.listTenants(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTenantsPagedResponse listTenants(ListTenantsRequest request) {
    return listTenantsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of tenants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListTenantsRequest request =
   *       ListTenantsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Tenant> future =
   *       saasDeploymentsClient.listTenantsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tenant element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse>
      listTenantsPagedCallable() {
    return stub.listTenantsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of tenants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListTenantsRequest request =
   *       ListTenantsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTenantsResponse response = saasDeploymentsClient.listTenantsCallable().call(request);
   *     for (Tenant element : response.getTenantsList()) {
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
  public final UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    return stub.listTenantsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");
   *   Tenant response = saasDeploymentsClient.getTenant(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(TenantName name) {
    GetTenantRequest request =
        GetTenantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString();
   *   Tenant response = saasDeploymentsClient.getTenant(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(String name) {
    GetTenantRequest request = GetTenantRequest.newBuilder().setName(name).build();
    return getTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetTenantRequest request =
   *       GetTenantRequest.newBuilder()
   *           .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
   *           .build();
   *   Tenant response = saasDeploymentsClient.getTenant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant getTenant(GetTenantRequest request) {
    return getTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetTenantRequest request =
   *       GetTenantRequest.newBuilder()
   *           .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
   *           .build();
   *   ApiFuture<Tenant> future = saasDeploymentsClient.getTenantCallable().futureCall(request);
   *   // Do something.
   *   Tenant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    return stub.getTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Tenant tenant = Tenant.newBuilder().build();
   *   String tenantId = "tenantId-1306693787";
   *   Tenant response = saasDeploymentsClient.createTenant(parent, tenant, tenantId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the tenant.
   * @param tenant Required. The desired state for the tenant.
   * @param tenantId Required. The ID value for the new tenant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(LocationName parent, Tenant tenant, String tenantId) {
    CreateTenantRequest request =
        CreateTenantRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTenant(tenant)
            .setTenantId(tenantId)
            .build();
    return createTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Tenant tenant = Tenant.newBuilder().build();
   *   String tenantId = "tenantId-1306693787";
   *   Tenant response = saasDeploymentsClient.createTenant(parent, tenant, tenantId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the tenant.
   * @param tenant Required. The desired state for the tenant.
   * @param tenantId Required. The ID value for the new tenant.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(String parent, Tenant tenant, String tenantId) {
    CreateTenantRequest request =
        CreateTenantRequest.newBuilder()
            .setParent(parent)
            .setTenant(tenant)
            .setTenantId(tenantId)
            .build();
    return createTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateTenantRequest request =
   *       CreateTenantRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTenantId("tenantId-1306693787")
   *           .setTenant(Tenant.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Tenant response = saasDeploymentsClient.createTenant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant createTenant(CreateTenantRequest request) {
    return createTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateTenantRequest request =
   *       CreateTenantRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTenantId("tenantId-1306693787")
   *           .setTenant(Tenant.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Tenant> future = saasDeploymentsClient.createTenantCallable().futureCall(request);
   *   // Do something.
   *   Tenant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    return stub.createTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   Tenant tenant = Tenant.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tenant response = saasDeploymentsClient.updateTenant(tenant, updateMask);
   * }
   * }</pre>
   *
   * @param tenant Required. The desired state for the tenant.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Tenant
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the Tenant will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant updateTenant(Tenant tenant, FieldMask updateMask) {
    UpdateTenantRequest request =
        UpdateTenantRequest.newBuilder().setTenant(tenant).setUpdateMask(updateMask).build();
    return updateTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateTenantRequest request =
   *       UpdateTenantRequest.newBuilder()
   *           .setTenant(Tenant.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tenant response = saasDeploymentsClient.updateTenant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tenant updateTenant(UpdateTenantRequest request) {
    return updateTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateTenantRequest request =
   *       UpdateTenantRequest.newBuilder()
   *           .setTenant(Tenant.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tenant> future = saasDeploymentsClient.updateTenantCallable().futureCall(request);
   *   // Do something.
   *   Tenant response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    return stub.updateTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   TenantName name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]");
   *   saasDeploymentsClient.deleteTenant(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(TenantName name) {
    DeleteTenantRequest request =
        DeleteTenantRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString();
   *   saasDeploymentsClient.deleteTenant(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(String name) {
    DeleteTenantRequest request = DeleteTenantRequest.newBuilder().setName(name).build();
    deleteTenant(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteTenantRequest request =
   *       DeleteTenantRequest.newBuilder()
   *           .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteTenant(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTenant(DeleteTenantRequest request) {
    deleteTenantCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single tenant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteTenantRequest request =
   *       DeleteTenantRequest.newBuilder()
   *           .setName(TenantName.of("[PROJECT]", "[LOCATION]", "[TENANT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasDeploymentsClient.deleteTenantCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    return stub.deleteTenantCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (UnitKind element : saasDeploymentsClient.listUnitKinds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitKindsPagedResponse listUnitKinds(LocationName parent) {
    ListUnitKindsRequest request =
        ListUnitKindsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUnitKinds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (UnitKind element : saasDeploymentsClient.listUnitKinds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitKindsPagedResponse listUnitKinds(String parent) {
    ListUnitKindsRequest request = ListUnitKindsRequest.newBuilder().setParent(parent).build();
    return listUnitKinds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitKindsRequest request =
   *       ListUnitKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (UnitKind element : saasDeploymentsClient.listUnitKinds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitKindsPagedResponse listUnitKinds(ListUnitKindsRequest request) {
    return listUnitKindsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitKindsRequest request =
   *       ListUnitKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<UnitKind> future =
   *       saasDeploymentsClient.listUnitKindsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UnitKind element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUnitKindsRequest, ListUnitKindsPagedResponse>
      listUnitKindsPagedCallable() {
    return stub.listUnitKindsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit kinds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitKindsRequest request =
   *       ListUnitKindsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListUnitKindsResponse response =
   *         saasDeploymentsClient.listUnitKindsCallable().call(request);
   *     for (UnitKind element : response.getUnitKindsList()) {
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
  public final UnaryCallable<ListUnitKindsRequest, ListUnitKindsResponse> listUnitKindsCallable() {
    return stub.listUnitKindsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");
   *   UnitKind response = saasDeploymentsClient.getUnitKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind getUnitKind(UnitKindName name) {
    GetUnitKindRequest request =
        GetUnitKindRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString();
   *   UnitKind response = saasDeploymentsClient.getUnitKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind getUnitKind(String name) {
    GetUnitKindRequest request = GetUnitKindRequest.newBuilder().setName(name).build();
    return getUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitKindRequest request =
   *       GetUnitKindRequest.newBuilder()
   *           .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
   *           .build();
   *   UnitKind response = saasDeploymentsClient.getUnitKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind getUnitKind(GetUnitKindRequest request) {
    return getUnitKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitKindRequest request =
   *       GetUnitKindRequest.newBuilder()
   *           .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
   *           .build();
   *   ApiFuture<UnitKind> future = saasDeploymentsClient.getUnitKindCallable().futureCall(request);
   *   // Do something.
   *   UnitKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUnitKindRequest, UnitKind> getUnitKindCallable() {
    return stub.getUnitKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   UnitKind unitKind = UnitKind.newBuilder().build();
   *   String unitKindId = "unitKindId1956463219";
   *   UnitKind response = saasDeploymentsClient.createUnitKind(parent, unitKind, unitKindId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit kind.
   * @param unitKind Required. The desired state for the unit kind.
   * @param unitKindId Required. The ID value for the new unit kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind createUnitKind(LocationName parent, UnitKind unitKind, String unitKindId) {
    CreateUnitKindRequest request =
        CreateUnitKindRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUnitKind(unitKind)
            .setUnitKindId(unitKindId)
            .build();
    return createUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   UnitKind unitKind = UnitKind.newBuilder().build();
   *   String unitKindId = "unitKindId1956463219";
   *   UnitKind response = saasDeploymentsClient.createUnitKind(parent, unitKind, unitKindId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit kind.
   * @param unitKind Required. The desired state for the unit kind.
   * @param unitKindId Required. The ID value for the new unit kind.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind createUnitKind(String parent, UnitKind unitKind, String unitKindId) {
    CreateUnitKindRequest request =
        CreateUnitKindRequest.newBuilder()
            .setParent(parent)
            .setUnitKind(unitKind)
            .setUnitKindId(unitKindId)
            .build();
    return createUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitKindRequest request =
   *       CreateUnitKindRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitKindId("unitKindId1956463219")
   *           .setUnitKind(UnitKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UnitKind response = saasDeploymentsClient.createUnitKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind createUnitKind(CreateUnitKindRequest request) {
    return createUnitKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitKindRequest request =
   *       CreateUnitKindRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitKindId("unitKindId1956463219")
   *           .setUnitKind(UnitKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<UnitKind> future =
   *       saasDeploymentsClient.createUnitKindCallable().futureCall(request);
   *   // Do something.
   *   UnitKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUnitKindRequest, UnitKind> createUnitKindCallable() {
    return stub.createUnitKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitKind unitKind = UnitKind.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UnitKind response = saasDeploymentsClient.updateUnitKind(unitKind, updateMask);
   * }
   * }</pre>
   *
   * @param unitKind Required. The desired state for the unit kind.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the UnitKind
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the UnitKind will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind updateUnitKind(UnitKind unitKind, FieldMask updateMask) {
    UpdateUnitKindRequest request =
        UpdateUnitKindRequest.newBuilder().setUnitKind(unitKind).setUpdateMask(updateMask).build();
    return updateUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitKindRequest request =
   *       UpdateUnitKindRequest.newBuilder()
   *           .setUnitKind(UnitKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UnitKind response = saasDeploymentsClient.updateUnitKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitKind updateUnitKind(UpdateUnitKindRequest request) {
    return updateUnitKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitKindRequest request =
   *       UpdateUnitKindRequest.newBuilder()
   *           .setUnitKind(UnitKind.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UnitKind> future =
   *       saasDeploymentsClient.updateUnitKindCallable().futureCall(request);
   *   // Do something.
   *   UnitKind response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUnitKindRequest, UnitKind> updateUnitKindCallable() {
    return stub.updateUnitKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitKindName name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]");
   *   saasDeploymentsClient.deleteUnitKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitKind(UnitKindName name) {
    DeleteUnitKindRequest request =
        DeleteUnitKindRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString();
   *   saasDeploymentsClient.deleteUnitKind(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitKind(String name) {
    DeleteUnitKindRequest request = DeleteUnitKindRequest.newBuilder().setName(name).build();
    deleteUnitKind(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitKindRequest request =
   *       DeleteUnitKindRequest.newBuilder()
   *           .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteUnitKind(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitKind(DeleteUnitKindRequest request) {
    deleteUnitKindCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit kind.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitKindRequest request =
   *       DeleteUnitKindRequest.newBuilder()
   *           .setName(UnitKindName.of("[PROJECT]", "[LOCATION]", "[UNITKIND]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasDeploymentsClient.deleteUnitKindCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUnitKindRequest, Empty> deleteUnitKindCallable() {
    return stub.deleteUnitKindCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of units.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Unit element : saasDeploymentsClient.listUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitsPagedResponse listUnits(LocationName parent) {
    ListUnitsRequest request =
        ListUnitsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of units.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Unit element : saasDeploymentsClient.listUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitsPagedResponse listUnits(String parent) {
    ListUnitsRequest request = ListUnitsRequest.newBuilder().setParent(parent).build();
    return listUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of units.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitsRequest request =
   *       ListUnitsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Unit element : saasDeploymentsClient.listUnits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitsPagedResponse listUnits(ListUnitsRequest request) {
    return listUnitsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of units.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitsRequest request =
   *       ListUnitsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Unit> future = saasDeploymentsClient.listUnitsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Unit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUnitsRequest, ListUnitsPagedResponse> listUnitsPagedCallable() {
    return stub.listUnitsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of units.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitsRequest request =
   *       ListUnitsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListUnitsResponse response = saasDeploymentsClient.listUnitsCallable().call(request);
   *     for (Unit element : response.getUnitsList()) {
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
  public final UnaryCallable<ListUnitsRequest, ListUnitsResponse> listUnitsCallable() {
    return stub.listUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");
   *   Unit response = saasDeploymentsClient.getUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit getUnit(UnitName name) {
    GetUnitRequest request =
        GetUnitRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString();
   *   Unit response = saasDeploymentsClient.getUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit getUnit(String name) {
    GetUnitRequest request = GetUnitRequest.newBuilder().setName(name).build();
    return getUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitRequest request =
   *       GetUnitRequest.newBuilder()
   *           .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
   *           .build();
   *   Unit response = saasDeploymentsClient.getUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit getUnit(GetUnitRequest request) {
    return getUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitRequest request =
   *       GetUnitRequest.newBuilder()
   *           .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
   *           .build();
   *   ApiFuture<Unit> future = saasDeploymentsClient.getUnitCallable().futureCall(request);
   *   // Do something.
   *   Unit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUnitRequest, Unit> getUnitCallable() {
    return stub.getUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Unit unit = Unit.newBuilder().build();
   *   String unitId = "unitId-840527425";
   *   Unit response = saasDeploymentsClient.createUnit(parent, unit, unitId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit.
   * @param unit Required. The desired state for the unit.
   * @param unitId Required. The ID value for the new unit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit createUnit(LocationName parent, Unit unit, String unitId) {
    CreateUnitRequest request =
        CreateUnitRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUnit(unit)
            .setUnitId(unitId)
            .build();
    return createUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Unit unit = Unit.newBuilder().build();
   *   String unitId = "unitId-840527425";
   *   Unit response = saasDeploymentsClient.createUnit(parent, unit, unitId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit.
   * @param unit Required. The desired state for the unit.
   * @param unitId Required. The ID value for the new unit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit createUnit(String parent, Unit unit, String unitId) {
    CreateUnitRequest request =
        CreateUnitRequest.newBuilder().setParent(parent).setUnit(unit).setUnitId(unitId).build();
    return createUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitRequest request =
   *       CreateUnitRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitId("unitId-840527425")
   *           .setUnit(Unit.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Unit response = saasDeploymentsClient.createUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit createUnit(CreateUnitRequest request) {
    return createUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitRequest request =
   *       CreateUnitRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitId("unitId-840527425")
   *           .setUnit(Unit.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Unit> future = saasDeploymentsClient.createUnitCallable().futureCall(request);
   *   // Do something.
   *   Unit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUnitRequest, Unit> createUnitCallable() {
    return stub.createUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   Unit unit = Unit.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Unit response = saasDeploymentsClient.updateUnit(unit, updateMask);
   * }
   * }</pre>
   *
   * @param unit Required. The desired state for the unit.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Unit
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the Unit will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit updateUnit(Unit unit, FieldMask updateMask) {
    UpdateUnitRequest request =
        UpdateUnitRequest.newBuilder().setUnit(unit).setUpdateMask(updateMask).build();
    return updateUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitRequest request =
   *       UpdateUnitRequest.newBuilder()
   *           .setUnit(Unit.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Unit response = saasDeploymentsClient.updateUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Unit updateUnit(UpdateUnitRequest request) {
    return updateUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitRequest request =
   *       UpdateUnitRequest.newBuilder()
   *           .setUnit(Unit.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Unit> future = saasDeploymentsClient.updateUnitCallable().futureCall(request);
   *   // Do something.
   *   Unit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUnitRequest, Unit> updateUnitCallable() {
    return stub.updateUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitName name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]");
   *   saasDeploymentsClient.deleteUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnit(UnitName name) {
    DeleteUnitRequest request =
        DeleteUnitRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString();
   *   saasDeploymentsClient.deleteUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnit(String name) {
    DeleteUnitRequest request = DeleteUnitRequest.newBuilder().setName(name).build();
    deleteUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitRequest request =
   *       DeleteUnitRequest.newBuilder()
   *           .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnit(DeleteUnitRequest request) {
    deleteUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitRequest request =
   *       DeleteUnitRequest.newBuilder()
   *           .setName(UnitName.of("[PROJECT]", "[LOCATION]", "[UNIT]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasDeploymentsClient.deleteUnitCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUnitRequest, Empty> deleteUnitCallable() {
    return stub.deleteUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (UnitOperation element : saasDeploymentsClient.listUnitOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitOperationsPagedResponse listUnitOperations(LocationName parent) {
    ListUnitOperationsRequest request =
        ListUnitOperationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUnitOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (UnitOperation element : saasDeploymentsClient.listUnitOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitOperationsPagedResponse listUnitOperations(String parent) {
    ListUnitOperationsRequest request =
        ListUnitOperationsRequest.newBuilder().setParent(parent).build();
    return listUnitOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitOperationsRequest request =
   *       ListUnitOperationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (UnitOperation element : saasDeploymentsClient.listUnitOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUnitOperationsPagedResponse listUnitOperations(
      ListUnitOperationsRequest request) {
    return listUnitOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitOperationsRequest request =
   *       ListUnitOperationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<UnitOperation> future =
   *       saasDeploymentsClient.listUnitOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UnitOperation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsPagedResponse>
      listUnitOperationsPagedCallable() {
    return stub.listUnitOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of unit operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListUnitOperationsRequest request =
   *       ListUnitOperationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListUnitOperationsResponse response =
   *         saasDeploymentsClient.listUnitOperationsCallable().call(request);
   *     for (UnitOperation element : response.getUnitOperationsList()) {
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
  public final UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsCallable() {
    return stub.listUnitOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");
   *   UnitOperation response = saasDeploymentsClient.getUnitOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation getUnitOperation(UnitOperationName name) {
    GetUnitOperationRequest request =
        GetUnitOperationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString();
   *   UnitOperation response = saasDeploymentsClient.getUnitOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation getUnitOperation(String name) {
    GetUnitOperationRequest request = GetUnitOperationRequest.newBuilder().setName(name).build();
    return getUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitOperationRequest request =
   *       GetUnitOperationRequest.newBuilder()
   *           .setName(
   *               UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
   *           .build();
   *   UnitOperation response = saasDeploymentsClient.getUnitOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation getUnitOperation(GetUnitOperationRequest request) {
    return getUnitOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetUnitOperationRequest request =
   *       GetUnitOperationRequest.newBuilder()
   *           .setName(
   *               UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
   *           .build();
   *   ApiFuture<UnitOperation> future =
   *       saasDeploymentsClient.getUnitOperationCallable().futureCall(request);
   *   // Do something.
   *   UnitOperation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUnitOperationRequest, UnitOperation> getUnitOperationCallable() {
    return stub.getUnitOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   UnitOperation unitOperation = UnitOperation.newBuilder().build();
   *   String unitOperationId = "unitOperationId-638217026";
   *   UnitOperation response =
   *       saasDeploymentsClient.createUnitOperation(parent, unitOperation, unitOperationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit operation.
   * @param unitOperation Required. The desired state for the unit operation.
   * @param unitOperationId Required. The ID value for the new unit operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation createUnitOperation(
      LocationName parent, UnitOperation unitOperation, String unitOperationId) {
    CreateUnitOperationRequest request =
        CreateUnitOperationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUnitOperation(unitOperation)
            .setUnitOperationId(unitOperationId)
            .build();
    return createUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   UnitOperation unitOperation = UnitOperation.newBuilder().build();
   *   String unitOperationId = "unitOperationId-638217026";
   *   UnitOperation response =
   *       saasDeploymentsClient.createUnitOperation(parent, unitOperation, unitOperationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the unit operation.
   * @param unitOperation Required. The desired state for the unit operation.
   * @param unitOperationId Required. The ID value for the new unit operation.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation createUnitOperation(
      String parent, UnitOperation unitOperation, String unitOperationId) {
    CreateUnitOperationRequest request =
        CreateUnitOperationRequest.newBuilder()
            .setParent(parent)
            .setUnitOperation(unitOperation)
            .setUnitOperationId(unitOperationId)
            .build();
    return createUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitOperationRequest request =
   *       CreateUnitOperationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitOperationId("unitOperationId-638217026")
   *           .setUnitOperation(UnitOperation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UnitOperation response = saasDeploymentsClient.createUnitOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation createUnitOperation(CreateUnitOperationRequest request) {
    return createUnitOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateUnitOperationRequest request =
   *       CreateUnitOperationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setUnitOperationId("unitOperationId-638217026")
   *           .setUnitOperation(UnitOperation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<UnitOperation> future =
   *       saasDeploymentsClient.createUnitOperationCallable().futureCall(request);
   *   // Do something.
   *   UnitOperation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationCallable() {
    return stub.createUnitOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitOperation unitOperation = UnitOperation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UnitOperation response = saasDeploymentsClient.updateUnitOperation(unitOperation, updateMask);
   * }
   * }</pre>
   *
   * @param unitOperation Required. The desired state for the unit operation.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the
   *     UnitOperation resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the UnitOperation will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation updateUnitOperation(
      UnitOperation unitOperation, FieldMask updateMask) {
    UpdateUnitOperationRequest request =
        UpdateUnitOperationRequest.newBuilder()
            .setUnitOperation(unitOperation)
            .setUpdateMask(updateMask)
            .build();
    return updateUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitOperationRequest request =
   *       UpdateUnitOperationRequest.newBuilder()
   *           .setUnitOperation(UnitOperation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UnitOperation response = saasDeploymentsClient.updateUnitOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnitOperation updateUnitOperation(UpdateUnitOperationRequest request) {
    return updateUnitOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateUnitOperationRequest request =
   *       UpdateUnitOperationRequest.newBuilder()
   *           .setUnitOperation(UnitOperation.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UnitOperation> future =
   *       saasDeploymentsClient.updateUnitOperationCallable().futureCall(request);
   *   // Do something.
   *   UnitOperation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationCallable() {
    return stub.updateUnitOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UnitOperationName name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]");
   *   saasDeploymentsClient.deleteUnitOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitOperation(UnitOperationName name) {
    DeleteUnitOperationRequest request =
        DeleteUnitOperationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString();
   *   saasDeploymentsClient.deleteUnitOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitOperation(String name) {
    DeleteUnitOperationRequest request =
        DeleteUnitOperationRequest.newBuilder().setName(name).build();
    deleteUnitOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitOperationRequest request =
   *       DeleteUnitOperationRequest.newBuilder()
   *           .setName(
   *               UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteUnitOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUnitOperation(DeleteUnitOperationRequest request) {
    deleteUnitOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single unit operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteUnitOperationRequest request =
   *       DeleteUnitOperationRequest.newBuilder()
   *           .setName(
   *               UnitOperationName.of("[PROJECT]", "[LOCATION]", "[UNITOPERATION]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future =
   *       saasDeploymentsClient.deleteUnitOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUnitOperationRequest, Empty> deleteUnitOperationCallable() {
    return stub.deleteUnitOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of releases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Release element : saasDeploymentsClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the release.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(LocationName parent) {
    ListReleasesRequest request =
        ListReleasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of releases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Release element : saasDeploymentsClient.listReleases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the release.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(String parent) {
    ListReleasesRequest request = ListReleasesRequest.newBuilder().setParent(parent).build();
    return listReleases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of releases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Release element : saasDeploymentsClient.listReleases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReleasesPagedResponse listReleases(ListReleasesRequest request) {
    return listReleasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of releases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Release> future =
   *       saasDeploymentsClient.listReleasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Release element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable() {
    return stub.listReleasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of releases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListReleasesRequest request =
   *       ListReleasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReleasesResponse response = saasDeploymentsClient.listReleasesCallable().call(request);
   *     for (Release element : response.getReleasesList()) {
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
  public final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return stub.listReleasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");
   *   Release response = saasDeploymentsClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(ReleaseName name) {
    GetReleaseRequest request =
        GetReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString();
   *   Release response = saasDeploymentsClient.getRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(String name) {
    GetReleaseRequest request = GetReleaseRequest.newBuilder().setName(name).build();
    return getRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
   *           .build();
   *   Release response = saasDeploymentsClient.getRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release getRelease(GetReleaseRequest request) {
    return getReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetReleaseRequest request =
   *       GetReleaseRequest.newBuilder()
   *           .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
   *           .build();
   *   ApiFuture<Release> future = saasDeploymentsClient.getReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return stub.getReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = saasDeploymentsClient.createRelease(parent, release, releaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the release.
   * @param release Required. The desired state for the release.
   * @param releaseId Required. The ID value for the new release.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release createRelease(LocationName parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Release release = Release.newBuilder().build();
   *   String releaseId = "releaseId89607042";
   *   Release response = saasDeploymentsClient.createRelease(parent, release, releaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the release.
   * @param release Required. The desired state for the release.
   * @param releaseId Required. The ID value for the new release.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release createRelease(String parent, Release release, String releaseId) {
    CreateReleaseRequest request =
        CreateReleaseRequest.newBuilder()
            .setParent(parent)
            .setRelease(release)
            .setReleaseId(releaseId)
            .build();
    return createRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Release response = saasDeploymentsClient.createRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release createRelease(CreateReleaseRequest request) {
    return createReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   CreateReleaseRequest request =
   *       CreateReleaseRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReleaseId("releaseId89607042")
   *           .setRelease(Release.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Release> future = saasDeploymentsClient.createReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReleaseRequest, Release> createReleaseCallable() {
    return stub.createReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   Release release = Release.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Release response = saasDeploymentsClient.updateRelease(release, updateMask);
   * }
   * }</pre>
   *
   * @param release Required. The desired state for the release.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Release
   *     resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   *     <p>If the user does not provide a mask then all fields in the Release will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release updateRelease(Release release, FieldMask updateMask) {
    UpdateReleaseRequest request =
        UpdateReleaseRequest.newBuilder().setRelease(release).setUpdateMask(updateMask).build();
    return updateRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateReleaseRequest request =
   *       UpdateReleaseRequest.newBuilder()
   *           .setRelease(Release.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Release response = saasDeploymentsClient.updateRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Release updateRelease(UpdateReleaseRequest request) {
    return updateReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   UpdateReleaseRequest request =
   *       UpdateReleaseRequest.newBuilder()
   *           .setRelease(Release.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Release> future = saasDeploymentsClient.updateReleaseCallable().futureCall(request);
   *   // Do something.
   *   Release response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReleaseRequest, Release> updateReleaseCallable() {
    return stub.updateReleaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ReleaseName name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]");
   *   saasDeploymentsClient.deleteRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRelease(ReleaseName name) {
    DeleteReleaseRequest request =
        DeleteReleaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   String name = ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString();
   *   saasDeploymentsClient.deleteRelease(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRelease(String name) {
    DeleteReleaseRequest request = DeleteReleaseRequest.newBuilder().setName(name).build();
    deleteRelease(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteReleaseRequest request =
   *       DeleteReleaseRequest.newBuilder()
   *           .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   saasDeploymentsClient.deleteRelease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRelease(DeleteReleaseRequest request) {
    deleteReleaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single release.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   DeleteReleaseRequest request =
   *       DeleteReleaseRequest.newBuilder()
   *           .setName(ReleaseName.of("[PROJECT]", "[LOCATION]", "[RELEASE]").toString())
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = saasDeploymentsClient.deleteReleaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReleaseRequest, Empty> deleteReleaseCallable() {
    return stub.deleteReleaseCallable();
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
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : saasDeploymentsClient.listLocations(request).iterateAll()) {
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
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       saasDeploymentsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         saasDeploymentsClient.listLocationsCallable().call(request);
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
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = saasDeploymentsClient.getLocation(request);
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
   * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = saasDeploymentsClient.getLocationCallable().futureCall(request);
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

  public static class ListSaasPagedResponse
      extends AbstractPagedListResponse<
          ListSaasRequest, ListSaasResponse, Saas, ListSaasPage, ListSaasFixedSizeCollection> {

    public static ApiFuture<ListSaasPagedResponse> createAsync(
        PageContext<ListSaasRequest, ListSaasResponse, Saas> context,
        ApiFuture<ListSaasResponse> futureResponse) {
      ApiFuture<ListSaasPage> futurePage =
          ListSaasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSaasPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSaasPagedResponse(ListSaasPage page) {
      super(page, ListSaasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSaasPage
      extends AbstractPage<ListSaasRequest, ListSaasResponse, Saas, ListSaasPage> {

    private ListSaasPage(
        PageContext<ListSaasRequest, ListSaasResponse, Saas> context, ListSaasResponse response) {
      super(context, response);
    }

    private static ListSaasPage createEmptyPage() {
      return new ListSaasPage(null, null);
    }

    @Override
    protected ListSaasPage createPage(
        PageContext<ListSaasRequest, ListSaasResponse, Saas> context, ListSaasResponse response) {
      return new ListSaasPage(context, response);
    }

    @Override
    public ApiFuture<ListSaasPage> createPageAsync(
        PageContext<ListSaasRequest, ListSaasResponse, Saas> context,
        ApiFuture<ListSaasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSaasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSaasRequest, ListSaasResponse, Saas, ListSaasPage, ListSaasFixedSizeCollection> {

    private ListSaasFixedSizeCollection(List<ListSaasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSaasFixedSizeCollection createEmptyCollection() {
      return new ListSaasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSaasFixedSizeCollection createCollection(
        List<ListSaasPage> pages, int collectionSize) {
      return new ListSaasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTenantsPagedResponse
      extends AbstractPagedListResponse<
          ListTenantsRequest,
          ListTenantsResponse,
          Tenant,
          ListTenantsPage,
          ListTenantsFixedSizeCollection> {

    public static ApiFuture<ListTenantsPagedResponse> createAsync(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ApiFuture<ListTenantsResponse> futureResponse) {
      ApiFuture<ListTenantsPage> futurePage =
          ListTenantsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTenantsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTenantsPagedResponse(ListTenantsPage page) {
      super(page, ListTenantsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTenantsPage
      extends AbstractPage<ListTenantsRequest, ListTenantsResponse, Tenant, ListTenantsPage> {

    private ListTenantsPage(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ListTenantsResponse response) {
      super(context, response);
    }

    private static ListTenantsPage createEmptyPage() {
      return new ListTenantsPage(null, null);
    }

    @Override
    protected ListTenantsPage createPage(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ListTenantsResponse response) {
      return new ListTenantsPage(context, response);
    }

    @Override
    public ApiFuture<ListTenantsPage> createPageAsync(
        PageContext<ListTenantsRequest, ListTenantsResponse, Tenant> context,
        ApiFuture<ListTenantsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTenantsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTenantsRequest,
          ListTenantsResponse,
          Tenant,
          ListTenantsPage,
          ListTenantsFixedSizeCollection> {

    private ListTenantsFixedSizeCollection(List<ListTenantsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTenantsFixedSizeCollection createEmptyCollection() {
      return new ListTenantsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTenantsFixedSizeCollection createCollection(
        List<ListTenantsPage> pages, int collectionSize) {
      return new ListTenantsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUnitKindsPagedResponse
      extends AbstractPagedListResponse<
          ListUnitKindsRequest,
          ListUnitKindsResponse,
          UnitKind,
          ListUnitKindsPage,
          ListUnitKindsFixedSizeCollection> {

    public static ApiFuture<ListUnitKindsPagedResponse> createAsync(
        PageContext<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind> context,
        ApiFuture<ListUnitKindsResponse> futureResponse) {
      ApiFuture<ListUnitKindsPage> futurePage =
          ListUnitKindsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUnitKindsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUnitKindsPagedResponse(ListUnitKindsPage page) {
      super(page, ListUnitKindsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUnitKindsPage
      extends AbstractPage<
          ListUnitKindsRequest, ListUnitKindsResponse, UnitKind, ListUnitKindsPage> {

    private ListUnitKindsPage(
        PageContext<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind> context,
        ListUnitKindsResponse response) {
      super(context, response);
    }

    private static ListUnitKindsPage createEmptyPage() {
      return new ListUnitKindsPage(null, null);
    }

    @Override
    protected ListUnitKindsPage createPage(
        PageContext<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind> context,
        ListUnitKindsResponse response) {
      return new ListUnitKindsPage(context, response);
    }

    @Override
    public ApiFuture<ListUnitKindsPage> createPageAsync(
        PageContext<ListUnitKindsRequest, ListUnitKindsResponse, UnitKind> context,
        ApiFuture<ListUnitKindsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUnitKindsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUnitKindsRequest,
          ListUnitKindsResponse,
          UnitKind,
          ListUnitKindsPage,
          ListUnitKindsFixedSizeCollection> {

    private ListUnitKindsFixedSizeCollection(List<ListUnitKindsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUnitKindsFixedSizeCollection createEmptyCollection() {
      return new ListUnitKindsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUnitKindsFixedSizeCollection createCollection(
        List<ListUnitKindsPage> pages, int collectionSize) {
      return new ListUnitKindsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUnitsPagedResponse
      extends AbstractPagedListResponse<
          ListUnitsRequest, ListUnitsResponse, Unit, ListUnitsPage, ListUnitsFixedSizeCollection> {

    public static ApiFuture<ListUnitsPagedResponse> createAsync(
        PageContext<ListUnitsRequest, ListUnitsResponse, Unit> context,
        ApiFuture<ListUnitsResponse> futureResponse) {
      ApiFuture<ListUnitsPage> futurePage =
          ListUnitsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListUnitsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListUnitsPagedResponse(ListUnitsPage page) {
      super(page, ListUnitsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUnitsPage
      extends AbstractPage<ListUnitsRequest, ListUnitsResponse, Unit, ListUnitsPage> {

    private ListUnitsPage(
        PageContext<ListUnitsRequest, ListUnitsResponse, Unit> context,
        ListUnitsResponse response) {
      super(context, response);
    }

    private static ListUnitsPage createEmptyPage() {
      return new ListUnitsPage(null, null);
    }

    @Override
    protected ListUnitsPage createPage(
        PageContext<ListUnitsRequest, ListUnitsResponse, Unit> context,
        ListUnitsResponse response) {
      return new ListUnitsPage(context, response);
    }

    @Override
    public ApiFuture<ListUnitsPage> createPageAsync(
        PageContext<ListUnitsRequest, ListUnitsResponse, Unit> context,
        ApiFuture<ListUnitsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUnitsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUnitsRequest, ListUnitsResponse, Unit, ListUnitsPage, ListUnitsFixedSizeCollection> {

    private ListUnitsFixedSizeCollection(List<ListUnitsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUnitsFixedSizeCollection createEmptyCollection() {
      return new ListUnitsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUnitsFixedSizeCollection createCollection(
        List<ListUnitsPage> pages, int collectionSize) {
      return new ListUnitsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUnitOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListUnitOperationsRequest,
          ListUnitOperationsResponse,
          UnitOperation,
          ListUnitOperationsPage,
          ListUnitOperationsFixedSizeCollection> {

    public static ApiFuture<ListUnitOperationsPagedResponse> createAsync(
        PageContext<ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation> context,
        ApiFuture<ListUnitOperationsResponse> futureResponse) {
      ApiFuture<ListUnitOperationsPage> futurePage =
          ListUnitOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUnitOperationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUnitOperationsPagedResponse(ListUnitOperationsPage page) {
      super(page, ListUnitOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUnitOperationsPage
      extends AbstractPage<
          ListUnitOperationsRequest,
          ListUnitOperationsResponse,
          UnitOperation,
          ListUnitOperationsPage> {

    private ListUnitOperationsPage(
        PageContext<ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation> context,
        ListUnitOperationsResponse response) {
      super(context, response);
    }

    private static ListUnitOperationsPage createEmptyPage() {
      return new ListUnitOperationsPage(null, null);
    }

    @Override
    protected ListUnitOperationsPage createPage(
        PageContext<ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation> context,
        ListUnitOperationsResponse response) {
      return new ListUnitOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListUnitOperationsPage> createPageAsync(
        PageContext<ListUnitOperationsRequest, ListUnitOperationsResponse, UnitOperation> context,
        ApiFuture<ListUnitOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUnitOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUnitOperationsRequest,
          ListUnitOperationsResponse,
          UnitOperation,
          ListUnitOperationsPage,
          ListUnitOperationsFixedSizeCollection> {

    private ListUnitOperationsFixedSizeCollection(
        List<ListUnitOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUnitOperationsFixedSizeCollection createEmptyCollection() {
      return new ListUnitOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUnitOperationsFixedSizeCollection createCollection(
        List<ListUnitOperationsPage> pages, int collectionSize) {
      return new ListUnitOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReleasesPagedResponse
      extends AbstractPagedListResponse<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    public static ApiFuture<ListReleasesPagedResponse> createAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      ApiFuture<ListReleasesPage> futurePage =
          ListReleasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReleasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReleasesPagedResponse(ListReleasesPage page) {
      super(page, ListReleasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReleasesPage
      extends AbstractPage<ListReleasesRequest, ListReleasesResponse, Release, ListReleasesPage> {

    private ListReleasesPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      super(context, response);
    }

    private static ListReleasesPage createEmptyPage() {
      return new ListReleasesPage(null, null);
    }

    @Override
    protected ListReleasesPage createPage(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ListReleasesResponse response) {
      return new ListReleasesPage(context, response);
    }

    @Override
    public ApiFuture<ListReleasesPage> createPageAsync(
        PageContext<ListReleasesRequest, ListReleasesResponse, Release> context,
        ApiFuture<ListReleasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReleasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReleasesRequest,
          ListReleasesResponse,
          Release,
          ListReleasesPage,
          ListReleasesFixedSizeCollection> {

    private ListReleasesFixedSizeCollection(List<ListReleasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReleasesFixedSizeCollection createEmptyCollection() {
      return new ListReleasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReleasesFixedSizeCollection createCollection(
        List<ListReleasesPage> pages, int collectionSize) {
      return new ListReleasesFixedSizeCollection(pages, collectionSize);
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
