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

package com.google.cloud.vmmigration.v1;

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
import com.google.cloud.vmmigration.v1.stub.VmMigrationStub;
import com.google.cloud.vmmigration.v1.stub.VmMigrationStubSettings;
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
 * Service Description: VM Migration Service
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
 * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
 *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
 *   Source response = vmMigrationClient.getSource(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VmMigrationClient object to clean up resources such as
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
 *      <td><p> ListSources</td>
 *      <td><p> Lists Sources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSources(ListSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSources(LocationName parent)
 *           <li><p> listSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSourcesPagedCallable()
 *           <li><p> listSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSource</td>
 *      <td><p> Gets details of a single Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSource(GetSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSource(SourceName name)
 *           <li><p> getSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSource</td>
 *      <td><p> Creates a new Source in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSourceAsync(CreateSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSourceAsync(LocationName parent, Source source, String sourceId)
 *           <li><p> createSourceAsync(String parent, Source source, String sourceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSourceOperationCallable()
 *           <li><p> createSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSource</td>
 *      <td><p> Updates the parameters of a single Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSourceAsync(UpdateSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSourceAsync(Source source, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSourceOperationCallable()
 *           <li><p> updateSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSource</td>
 *      <td><p> Deletes a single Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSourceAsync(DeleteSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSourceAsync(SourceName name)
 *           <li><p> deleteSourceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSourceOperationCallable()
 *           <li><p> deleteSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchInventory</td>
 *      <td><p> List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the sense it's not in Compute Engine). The inventory describes the list of existing VMs in that source. Note that this operation lists the VMs on the remote source, as opposed to listing the MigratingVms resources in the vmmigration service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchInventory(FetchInventoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchInventory(SourceName source)
 *           <li><p> fetchInventory(String source)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchInventoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchStorageInventory</td>
 *      <td><p> List remote source's inventory of storage resources. The remote source is another cloud vendor (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that source. Note that this operation lists the resources on the remote source, as opposed to listing the MigratingVms resources in the vmmigration service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchStorageInventory(FetchStorageInventoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchStorageInventory(SourceName source, FetchStorageInventoryRequest.StorageType type)
 *           <li><p> fetchStorageInventory(String source, FetchStorageInventoryRequest.StorageType type)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchStorageInventoryPagedCallable()
 *           <li><p> fetchStorageInventoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUtilizationReports</td>
 *      <td><p> Lists Utilization Reports of the given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUtilizationReports(ListUtilizationReportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUtilizationReports(SourceName parent)
 *           <li><p> listUtilizationReports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUtilizationReportsPagedCallable()
 *           <li><p> listUtilizationReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUtilizationReport</td>
 *      <td><p> Gets a single Utilization Report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUtilizationReport(GetUtilizationReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUtilizationReport(UtilizationReportName name)
 *           <li><p> getUtilizationReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUtilizationReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUtilizationReport</td>
 *      <td><p> Creates a new UtilizationReport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUtilizationReportAsync(CreateUtilizationReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createUtilizationReportAsync(SourceName parent, UtilizationReport utilizationReport, String utilizationReportId)
 *           <li><p> createUtilizationReportAsync(String parent, UtilizationReport utilizationReport, String utilizationReportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUtilizationReportOperationCallable()
 *           <li><p> createUtilizationReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUtilizationReport</td>
 *      <td><p> Deletes a single Utilization Report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUtilizationReportAsync(DeleteUtilizationReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteUtilizationReportAsync(UtilizationReportName name)
 *           <li><p> deleteUtilizationReportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUtilizationReportOperationCallable()
 *           <li><p> deleteUtilizationReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatacenterConnectors</td>
 *      <td><p> Lists DatacenterConnectors in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatacenterConnectors(ListDatacenterConnectorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatacenterConnectors(SourceName parent)
 *           <li><p> listDatacenterConnectors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatacenterConnectorsPagedCallable()
 *           <li><p> listDatacenterConnectorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatacenterConnector</td>
 *      <td><p> Gets details of a single DatacenterConnector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatacenterConnector(GetDatacenterConnectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatacenterConnector(DatacenterConnectorName name)
 *           <li><p> getDatacenterConnector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatacenterConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDatacenterConnector</td>
 *      <td><p> Creates a new DatacenterConnector in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatacenterConnectorAsync(CreateDatacenterConnectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatacenterConnectorAsync(SourceName parent, DatacenterConnector datacenterConnector, String datacenterConnectorId)
 *           <li><p> createDatacenterConnectorAsync(String parent, DatacenterConnector datacenterConnector, String datacenterConnectorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatacenterConnectorOperationCallable()
 *           <li><p> createDatacenterConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDatacenterConnector</td>
 *      <td><p> Deletes a single DatacenterConnector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatacenterConnectorAsync(DeleteDatacenterConnectorRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDatacenterConnectorAsync(DatacenterConnectorName name)
 *           <li><p> deleteDatacenterConnectorAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatacenterConnectorOperationCallable()
 *           <li><p> deleteDatacenterConnectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpgradeAppliance</td>
 *      <td><p> Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> upgradeApplianceAsync(UpgradeApplianceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> upgradeApplianceOperationCallable()
 *           <li><p> upgradeApplianceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMigratingVm</td>
 *      <td><p> Creates a new MigratingVm in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMigratingVmAsync(CreateMigratingVmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMigratingVmAsync(SourceName parent, MigratingVm migratingVm, String migratingVmId)
 *           <li><p> createMigratingVmAsync(String parent, MigratingVm migratingVm, String migratingVmId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMigratingVmOperationCallable()
 *           <li><p> createMigratingVmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMigratingVms</td>
 *      <td><p> Lists MigratingVms in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMigratingVms(ListMigratingVmsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMigratingVms(SourceName parent)
 *           <li><p> listMigratingVms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMigratingVmsPagedCallable()
 *           <li><p> listMigratingVmsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMigratingVm</td>
 *      <td><p> Gets details of a single MigratingVm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMigratingVm(GetMigratingVmRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMigratingVm(MigratingVmName name)
 *           <li><p> getMigratingVm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMigratingVmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMigratingVm</td>
 *      <td><p> Updates the parameters of a single MigratingVm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMigratingVmAsync(UpdateMigratingVmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMigratingVmAsync(MigratingVm migratingVm, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMigratingVmOperationCallable()
 *           <li><p> updateMigratingVmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMigratingVm</td>
 *      <td><p> Deletes a single MigratingVm.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMigratingVmAsync(DeleteMigratingVmRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMigratingVmAsync(MigratingVmName name)
 *           <li><p> deleteMigratingVmAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMigratingVmOperationCallable()
 *           <li><p> deleteMigratingVmCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartMigration</td>
 *      <td><p> Starts migration for a VM. Starts the process of uploading data and creating snapshots, in replication cycles scheduled by the policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startMigrationAsync(StartMigrationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startMigrationAsync(MigratingVmName migratingVm)
 *           <li><p> startMigrationAsync(String migratingVm)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startMigrationOperationCallable()
 *           <li><p> startMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeMigration</td>
 *      <td><p> Resumes a migration for a VM. When called on a paused migration, will start the process of uploading data and creating snapshots; when called on a completed cut-over migration, will update the migration to active state and start the process of uploading data and creating snapshots.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeMigrationAsync(ResumeMigrationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeMigrationOperationCallable()
 *           <li><p> resumeMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PauseMigration</td>
 *      <td><p> Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving source task data. Further replication cycles will not be triggered while the VM is paused.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pauseMigrationAsync(PauseMigrationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pauseMigrationOperationCallable()
 *           <li><p> pauseMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FinalizeMigration</td>
 *      <td><p> Marks a migration as completed, deleting migration resources that are no longer being used. Only applicable after cutover is done.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> finalizeMigrationAsync(FinalizeMigrationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> finalizeMigrationAsync(MigratingVmName migratingVm)
 *           <li><p> finalizeMigrationAsync(String migratingVm)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> finalizeMigrationOperationCallable()
 *           <li><p> finalizeMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExtendMigration</td>
 *      <td><p> Extend the migrating VM time to live.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> extendMigrationAsync(ExtendMigrationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> extendMigrationOperationCallable()
 *           <li><p> extendMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCloneJob</td>
 *      <td><p> Initiates a Clone of a specific migrating VM.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCloneJobAsync(CreateCloneJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCloneJobAsync(MigratingVmName parent, CloneJob cloneJob, String cloneJobId)
 *           <li><p> createCloneJobAsync(String parent, CloneJob cloneJob, String cloneJobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCloneJobOperationCallable()
 *           <li><p> createCloneJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelCloneJob</td>
 *      <td><p> Initiates the cancellation of a running clone job.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelCloneJobAsync(CancelCloneJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cancelCloneJobAsync(CloneJobName name)
 *           <li><p> cancelCloneJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelCloneJobOperationCallable()
 *           <li><p> cancelCloneJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCloneJobs</td>
 *      <td><p> Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloneJobs(ListCloneJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloneJobs(MigratingVmName parent)
 *           <li><p> listCloneJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloneJobsPagedCallable()
 *           <li><p> listCloneJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloneJob</td>
 *      <td><p> Gets details of a single CloneJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloneJob(GetCloneJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloneJob(CloneJobName name)
 *           <li><p> getCloneJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloneJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCutoverJob</td>
 *      <td><p> Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover job resource is created and the job is initiated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCutoverJobAsync(CreateCutoverJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCutoverJobAsync(MigratingVmName parent, CutoverJob cutoverJob, String cutoverJobId)
 *           <li><p> createCutoverJobAsync(String parent, CutoverJob cutoverJob, String cutoverJobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCutoverJobOperationCallable()
 *           <li><p> createCutoverJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelCutoverJob</td>
 *      <td><p> Initiates the cancellation of a running cutover job.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelCutoverJobAsync(CancelCutoverJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cancelCutoverJobAsync(CutoverJobName name)
 *           <li><p> cancelCutoverJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelCutoverJobOperationCallable()
 *           <li><p> cancelCutoverJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCutoverJobs</td>
 *      <td><p> Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCutoverJobs(ListCutoverJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCutoverJobs(MigratingVmName parent)
 *           <li><p> listCutoverJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCutoverJobsPagedCallable()
 *           <li><p> listCutoverJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCutoverJob</td>
 *      <td><p> Gets details of a single CutoverJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCutoverJob(GetCutoverJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCutoverJob(CutoverJobName name)
 *           <li><p> getCutoverJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCutoverJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGroups</td>
 *      <td><p> Lists Groups in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGroups(ListGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGroups(LocationName parent)
 *           <li><p> listGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGroupsPagedCallable()
 *           <li><p> listGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGroup</td>
 *      <td><p> Gets details of a single Group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGroup(GetGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGroup(GroupName name)
 *           <li><p> getGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGroup</td>
 *      <td><p> Creates a new Group in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGroupAsync(CreateGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGroupAsync(LocationName parent, Group group, String groupId)
 *           <li><p> createGroupAsync(String parent, Group group, String groupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGroupOperationCallable()
 *           <li><p> createGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGroup</td>
 *      <td><p> Updates the parameters of a single Group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGroupAsync(UpdateGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGroupAsync(Group group, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGroupOperationCallable()
 *           <li><p> updateGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGroup</td>
 *      <td><p> Deletes a single Group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGroupAsync(DeleteGroupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGroupAsync(GroupName name)
 *           <li><p> deleteGroupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGroupOperationCallable()
 *           <li><p> deleteGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddGroupMigration</td>
 *      <td><p> Adds a MigratingVm to a Group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addGroupMigrationAsync(AddGroupMigrationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addGroupMigrationAsync(GroupName group)
 *           <li><p> addGroupMigrationAsync(String group)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addGroupMigrationOperationCallable()
 *           <li><p> addGroupMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveGroupMigration</td>
 *      <td><p> Removes a MigratingVm from a Group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeGroupMigrationAsync(RemoveGroupMigrationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeGroupMigrationAsync(GroupName group)
 *           <li><p> removeGroupMigrationAsync(String group)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeGroupMigrationOperationCallable()
 *           <li><p> removeGroupMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTargetProjects</td>
 *      <td><p> Lists TargetProjects in a given project.
 * <p>  NOTE: TargetProject is a global resource; hence the only supported value for location is `global`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTargetProjects(ListTargetProjectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTargetProjects(LocationName parent)
 *           <li><p> listTargetProjects(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTargetProjectsPagedCallable()
 *           <li><p> listTargetProjectsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTargetProject</td>
 *      <td><p> Gets details of a single TargetProject.
 * <p>  NOTE: TargetProject is a global resource; hence the only supported value for location is `global`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTargetProject(GetTargetProjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTargetProject(TargetProjectName name)
 *           <li><p> getTargetProject(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTargetProjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTargetProject</td>
 *      <td><p> Creates a new TargetProject in a given project.
 * <p>  NOTE: TargetProject is a global resource; hence the only supported value for location is `global`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTargetProjectAsync(CreateTargetProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTargetProjectAsync(LocationName parent, TargetProject targetProject, String targetProjectId)
 *           <li><p> createTargetProjectAsync(String parent, TargetProject targetProject, String targetProjectId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTargetProjectOperationCallable()
 *           <li><p> createTargetProjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTargetProject</td>
 *      <td><p> Updates the parameters of a single TargetProject.
 * <p>  NOTE: TargetProject is a global resource; hence the only supported value for location is `global`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTargetProjectAsync(UpdateTargetProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTargetProjectAsync(TargetProject targetProject, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTargetProjectOperationCallable()
 *           <li><p> updateTargetProjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTargetProject</td>
 *      <td><p> Deletes a single TargetProject.
 * <p>  NOTE: TargetProject is a global resource; hence the only supported value for location is `global`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTargetProjectAsync(DeleteTargetProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTargetProjectAsync(TargetProjectName name)
 *           <li><p> deleteTargetProjectAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTargetProjectOperationCallable()
 *           <li><p> deleteTargetProjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReplicationCycles</td>
 *      <td><p> Lists ReplicationCycles in a given MigratingVM.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReplicationCycles(ListReplicationCyclesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReplicationCycles(MigratingVmName parent)
 *           <li><p> listReplicationCycles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReplicationCyclesPagedCallable()
 *           <li><p> listReplicationCyclesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReplicationCycle</td>
 *      <td><p> Gets details of a single ReplicationCycle.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReplicationCycle(GetReplicationCycleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReplicationCycle(ReplicationCycleName name)
 *           <li><p> getReplicationCycle(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReplicationCycleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListImageImports</td>
 *      <td><p> Lists ImageImports in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listImageImports(ListImageImportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listImageImports(LocationName parent)
 *           <li><p> listImageImports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listImageImportsPagedCallable()
 *           <li><p> listImageImportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetImageImport</td>
 *      <td><p> Gets details of a single ImageImport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getImageImport(GetImageImportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getImageImport(ImageImportName name)
 *           <li><p> getImageImport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getImageImportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateImageImport</td>
 *      <td><p> Creates a new ImageImport in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createImageImportAsync(CreateImageImportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createImageImportAsync(LocationName parent, ImageImport imageImport, String imageImportId)
 *           <li><p> createImageImportAsync(String parent, ImageImport imageImport, String imageImportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createImageImportOperationCallable()
 *           <li><p> createImageImportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteImageImport</td>
 *      <td><p> Deletes a single ImageImport.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteImageImportAsync(DeleteImageImportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteImageImportAsync(ImageImportName name)
 *           <li><p> deleteImageImportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteImageImportOperationCallable()
 *           <li><p> deleteImageImportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListImageImportJobs</td>
 *      <td><p> Lists ImageImportJobs in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listImageImportJobs(ListImageImportJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listImageImportJobs(ImageImportName parent)
 *           <li><p> listImageImportJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listImageImportJobsPagedCallable()
 *           <li><p> listImageImportJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetImageImportJob</td>
 *      <td><p> Gets details of a single ImageImportJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getImageImportJob(GetImageImportJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getImageImportJob(ImageImportJobName name)
 *           <li><p> getImageImportJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getImageImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelImageImportJob</td>
 *      <td><p> Initiates the cancellation of a running clone job.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelImageImportJobAsync(CancelImageImportJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> cancelImageImportJobAsync(ImageImportJobName name)
 *           <li><p> cancelImageImportJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelImageImportJobOperationCallable()
 *           <li><p> cancelImageImportJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDiskMigrationJob</td>
 *      <td><p> Creates a new disk migration job in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDiskMigrationJobAsync(CreateDiskMigrationJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDiskMigrationJobAsync(SourceName parent, DiskMigrationJob diskMigrationJob, String diskMigrationJobId)
 *           <li><p> createDiskMigrationJobAsync(String parent, DiskMigrationJob diskMigrationJob, String diskMigrationJobId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDiskMigrationJobOperationCallable()
 *           <li><p> createDiskMigrationJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDiskMigrationJobs</td>
 *      <td><p> Lists DiskMigrationJobs in a given Source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiskMigrationJobs(ListDiskMigrationJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiskMigrationJobs(SourceName parent)
 *           <li><p> listDiskMigrationJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiskMigrationJobsPagedCallable()
 *           <li><p> listDiskMigrationJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiskMigrationJob</td>
 *      <td><p> Gets details of a single DiskMigrationJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiskMigrationJob(GetDiskMigrationJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiskMigrationJob(DiskMigrationJobName name)
 *           <li><p> getDiskMigrationJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiskMigrationJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDiskMigrationJob</td>
 *      <td><p> Updates the parameters of a single DiskMigrationJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDiskMigrationJobAsync(UpdateDiskMigrationJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDiskMigrationJobAsync(DiskMigrationJob diskMigrationJob, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDiskMigrationJobOperationCallable()
 *           <li><p> updateDiskMigrationJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDiskMigrationJob</td>
 *      <td><p> Deletes a single DiskMigrationJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDiskMigrationJobAsync(DeleteDiskMigrationJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDiskMigrationJobAsync(DiskMigrationJobName name)
 *           <li><p> deleteDiskMigrationJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDiskMigrationJobOperationCallable()
 *           <li><p> deleteDiskMigrationJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunDiskMigrationJob</td>
 *      <td><p> Runs the disk migration job.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runDiskMigrationJobAsync(RunDiskMigrationJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runDiskMigrationJobAsync(DiskMigrationJobName name)
 *           <li><p> runDiskMigrationJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runDiskMigrationJobOperationCallable()
 *           <li><p> runDiskMigrationJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CancelDiskMigrationJob</td>
 *      <td><p> Cancels the disk migration job.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> cancelDiskMigrationJobAsync(CancelDiskMigrationJobRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cancelDiskMigrationJobOperationCallable()
 *           <li><p> cancelDiskMigrationJobCallable()
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
 * <p>This class can be customized by passing in a custom instance of VmMigrationSettings to
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
 * VmMigrationSettings vmMigrationSettings =
 *     VmMigrationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
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
 * VmMigrationSettings vmMigrationSettings =
 *     VmMigrationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
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
 * VmMigrationSettings vmMigrationSettings = VmMigrationSettings.newHttpJsonBuilder().build();
 * VmMigrationClient vmMigrationClient = VmMigrationClient.create(vmMigrationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class VmMigrationClient implements BackgroundResource {
  private final VmMigrationSettings settings;
  private final VmMigrationStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of VmMigrationClient with default settings. */
  public static final VmMigrationClient create() throws IOException {
    return create(VmMigrationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VmMigrationClient create(VmMigrationSettings settings) throws IOException {
    return new VmMigrationClient(settings);
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(VmMigrationSettings).
   */
  public static final VmMigrationClient create(VmMigrationStub stub) {
    return new VmMigrationClient(stub);
  }

  /**
   * Constructs an instance of VmMigrationClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected VmMigrationClient(VmMigrationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VmMigrationStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected VmMigrationClient(VmMigrationStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final VmMigrationSettings getSettings() {
    return settings;
  }

  public VmMigrationStub getStub() {
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
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Source element : vmMigrationClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of sources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(LocationName parent) {
    ListSourcesRequest request =
        ListSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Source element : vmMigrationClient.listSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of sources.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(String parent) {
    ListSourcesRequest request = ListSourcesRequest.newBuilder().setParent(parent).build();
    return listSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Source element : vmMigrationClient.listSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSourcesPagedResponse listSources(ListSourcesRequest request) {
    return listSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Source> future = vmMigrationClient.listSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Source element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable() {
    return stub.listSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Sources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListSourcesRequest request =
   *       ListSourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSourcesResponse response = vmMigrationClient.listSourcesCallable().call(request);
   *     for (Source element : response.getSourcesList()) {
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
  public final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return stub.listSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   Source response = vmMigrationClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(SourceName name) {
    GetSourceRequest request =
        GetSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   Source response = vmMigrationClient.getSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(String name) {
    GetSourceRequest request = GetSourceRequest.newBuilder().setName(name).build();
    return getSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   Source response = vmMigrationClient.getSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Source getSource(GetSourceRequest request) {
    return getSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetSourceRequest request =
   *       GetSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .build();
   *   ApiFuture<Source> future = vmMigrationClient.getSourceCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return stub.getSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = vmMigrationClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Source's parent.
   * @param source Required. The create request body.
   * @param sourceId Required. The source identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      LocationName parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Source source = Source.newBuilder().build();
   *   String sourceId = "sourceId1746327190";
   *   Source response = vmMigrationClient.createSourceAsync(parent, source, sourceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Source's parent.
   * @param source Required. The create request body.
   * @param sourceId Required. The source identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      String parent, Source source, String sourceId) {
    CreateSourceRequest request =
        CreateSourceRequest.newBuilder()
            .setParent(parent)
            .setSource(source)
            .setSourceId(sourceId)
            .build();
    return createSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = vmMigrationClient.createSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> createSourceAsync(
      CreateSourceRequest request) {
    return createSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       vmMigrationClient.createSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    return stub.createSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Source in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateSourceRequest request =
   *       CreateSourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceId("sourceId1746327190")
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    return stub.createSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   Source source = Source.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Source response = vmMigrationClient.updateSourceAsync(source, updateMask).get();
   * }
   * }</pre>
   *
   * @param source Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Source
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      Source source, FieldMask updateMask) {
    UpdateSourceRequest request =
        UpdateSourceRequest.newBuilder().setSource(source).setUpdateMask(updateMask).build();
    return updateSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Source response = vmMigrationClient.updateSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Source, OperationMetadata> updateSourceAsync(
      UpdateSourceRequest request) {
    return updateSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Source, OperationMetadata> future =
   *       vmMigrationClient.updateSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Source response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    return stub.updateSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateSourceRequest request =
   *       UpdateSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSource(Source.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.updateSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    return stub.updateSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   vmMigrationClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(SourceName name) {
    DeleteSourceRequest request =
        DeleteSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   vmMigrationClient.deleteSourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Source name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(String name) {
    DeleteSourceRequest request = DeleteSourceRequest.newBuilder().setName(name).build();
    return deleteSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSourceAsync(
      DeleteSourceRequest request) {
    return deleteSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    return stub.deleteSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteSourceRequest request =
   *       DeleteSourceRequest.newBuilder()
   *           .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.deleteSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    return stub.deleteSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(source);
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(SourceName source) {
    FetchInventoryRequest request =
        FetchInventoryRequest.newBuilder()
            .setSource(source == null ? null : source.toString())
            .build();
    return fetchInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(source);
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(String source) {
    FetchInventoryRequest request = FetchInventoryRequest.newBuilder().setSource(source).build();
    return fetchInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchInventoryRequest request =
   *       FetchInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .build();
   *   FetchInventoryResponse response = vmMigrationClient.fetchInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchInventoryResponse fetchInventory(FetchInventoryRequest request) {
    return fetchInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the
   * sense it's not in Compute Engine). The inventory describes the list of existing VMs in that
   * source. Note that this operation lists the VMs on the remote source, as opposed to listing the
   * MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchInventoryRequest request =
   *       FetchInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .build();
   *   ApiFuture<FetchInventoryResponse> future =
   *       vmMigrationClient.fetchInventoryCallable().futureCall(request);
   *   // Do something.
   *   FetchInventoryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchInventoryRequest, FetchInventoryResponse>
      fetchInventoryCallable() {
    return stub.fetchInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of storage resources. The remote source is another cloud vendor
   * (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that
   * source. Note that this operation lists the resources on the remote source, as opposed to
   * listing the MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   FetchStorageInventoryRequest.StorageType type =
   *       FetchStorageInventoryRequest.StorageType.forNumber(0);
   *   for (SourceStorageResource element :
   *       vmMigrationClient.fetchStorageInventory(source, type).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @param type Required. The type of the storage inventory to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStorageInventoryPagedResponse fetchStorageInventory(
      SourceName source, FetchStorageInventoryRequest.StorageType type) {
    FetchStorageInventoryRequest request =
        FetchStorageInventoryRequest.newBuilder()
            .setSource(source == null ? null : source.toString())
            .setType(type)
            .build();
    return fetchStorageInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of storage resources. The remote source is another cloud vendor
   * (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that
   * source. Note that this operation lists the resources on the remote source, as opposed to
   * listing the MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String source = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   FetchStorageInventoryRequest.StorageType type =
   *       FetchStorageInventoryRequest.StorageType.forNumber(0);
   *   for (SourceStorageResource element :
   *       vmMigrationClient.fetchStorageInventory(source, type).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param source Required. The name of the Source.
   * @param type Required. The type of the storage inventory to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStorageInventoryPagedResponse fetchStorageInventory(
      String source, FetchStorageInventoryRequest.StorageType type) {
    FetchStorageInventoryRequest request =
        FetchStorageInventoryRequest.newBuilder().setSource(source).setType(type).build();
    return fetchStorageInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of storage resources. The remote source is another cloud vendor
   * (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that
   * source. Note that this operation lists the resources on the remote source, as opposed to
   * listing the MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchStorageInventoryRequest request =
   *       FetchStorageInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SourceStorageResource element :
   *       vmMigrationClient.fetchStorageInventory(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchStorageInventoryPagedResponse fetchStorageInventory(
      FetchStorageInventoryRequest request) {
    return fetchStorageInventoryPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of storage resources. The remote source is another cloud vendor
   * (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that
   * source. Note that this operation lists the resources on the remote source, as opposed to
   * listing the MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchStorageInventoryRequest request =
   *       FetchStorageInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SourceStorageResource> future =
   *       vmMigrationClient.fetchStorageInventoryPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SourceStorageResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryPagedResponse>
      fetchStorageInventoryPagedCallable() {
    return stub.fetchStorageInventoryPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List remote source's inventory of storage resources. The remote source is another cloud vendor
   * (e.g. AWS, Azure). The inventory describes the list of existing storage resources in that
   * source. Note that this operation lists the resources on the remote source, as opposed to
   * listing the MigratingVms resources in the vmmigration service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FetchStorageInventoryRequest request =
   *       FetchStorageInventoryRequest.newBuilder()
   *           .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setForceRefresh(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchStorageInventoryResponse response =
   *         vmMigrationClient.fetchStorageInventoryCallable().call(request);
   *     for (SourceStorageResource element : response.getResourcesList()) {
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
  public final UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryResponse>
      fetchStorageInventoryCallable() {
    return stub.fetchStorageInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Reports parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(SourceName parent) {
    ListUtilizationReportsRequest request =
        ListUtilizationReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUtilizationReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Reports parent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(String parent) {
    ListUtilizationReportsRequest request =
        ListUtilizationReportsRequest.newBuilder().setParent(parent).build();
    return listUtilizationReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (UtilizationReport element :
   *       vmMigrationClient.listUtilizationReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUtilizationReportsPagedResponse listUtilizationReports(
      ListUtilizationReportsRequest request) {
    return listUtilizationReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<UtilizationReport> future =
   *       vmMigrationClient.listUtilizationReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UtilizationReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable() {
    return stub.listUtilizationReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Utilization Reports of the given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListUtilizationReportsRequest request =
   *       ListUtilizationReportsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListUtilizationReportsResponse response =
   *         vmMigrationClient.listUtilizationReportsCallable().call(request);
   *     for (UtilizationReport element : response.getUtilizationReportsList()) {
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
  public final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable() {
    return stub.listUtilizationReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UtilizationReportName name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(UtilizationReportName name) {
    GetUtilizationReportRequest request =
        GetUtilizationReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUtilizationReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *           .toString();
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(String name) {
    GetUtilizationReportRequest request =
        GetUtilizationReportRequest.newBuilder().setName(name).build();
    return getUtilizationReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetUtilizationReportRequest request =
   *       GetUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .build();
   *   UtilizationReport response = vmMigrationClient.getUtilizationReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UtilizationReport getUtilizationReport(GetUtilizationReportRequest request) {
    return getUtilizationReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetUtilizationReportRequest request =
   *       GetUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setView(UtilizationReportView.forNumber(0))
   *           .build();
   *   ApiFuture<UtilizationReport> future =
   *       vmMigrationClient.getUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   UtilizationReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable() {
    return stub.getUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
   *   String utilizationReportId = "utilizationReportId1215771057";
   *   UtilizationReport response =
   *       vmMigrationClient
   *           .createUtilizationReportAsync(parent, utilizationReport, utilizationReportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Report's parent.
   * @param utilizationReport Required. The report to create.
   * @param utilizationReportId Required. The ID to use for the report, which will become the final
   *     component of the reports's resource name.
   *     <p>This value maximum length is 63 characters, and valid characters are /[a-z][0-9]-/. It
   *     must start with an english letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      SourceName parent, UtilizationReport utilizationReport, String utilizationReportId) {
    CreateUtilizationReportRequest request =
        CreateUtilizationReportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUtilizationReport(utilizationReport)
            .setUtilizationReportId(utilizationReportId)
            .build();
    return createUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   UtilizationReport utilizationReport = UtilizationReport.newBuilder().build();
   *   String utilizationReportId = "utilizationReportId1215771057";
   *   UtilizationReport response =
   *       vmMigrationClient
   *           .createUtilizationReportAsync(parent, utilizationReport, utilizationReportId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The Utilization Report's parent.
   * @param utilizationReport Required. The report to create.
   * @param utilizationReportId Required. The ID to use for the report, which will become the final
   *     component of the reports's resource name.
   *     <p>This value maximum length is 63 characters, and valid characters are /[a-z][0-9]-/. It
   *     must start with an english letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      String parent, UtilizationReport utilizationReport, String utilizationReportId) {
    CreateUtilizationReportRequest request =
        CreateUtilizationReportRequest.newBuilder()
            .setParent(parent)
            .setUtilizationReport(utilizationReport)
            .setUtilizationReportId(utilizationReportId)
            .build();
    return createUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UtilizationReport response = vmMigrationClient.createUtilizationReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UtilizationReport, OperationMetadata> createUtilizationReportAsync(
      CreateUtilizationReportRequest request) {
    return createUtilizationReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<UtilizationReport, OperationMetadata> future =
   *       vmMigrationClient.createUtilizationReportOperationCallable().futureCall(request);
   *   // Do something.
   *   UtilizationReport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable() {
    return stub.createUtilizationReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new UtilizationReport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateUtilizationReportRequest request =
   *       CreateUtilizationReportRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setUtilizationReport(UtilizationReport.newBuilder().build())
   *           .setUtilizationReportId("utilizationReportId1215771057")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable() {
    return stub.createUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UtilizationReportName name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]");
   *   vmMigrationClient.deleteUtilizationReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(
      UtilizationReportName name) {
    DeleteUtilizationReportRequest request =
        DeleteUtilizationReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       UtilizationReportName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *           .toString();
   *   vmMigrationClient.deleteUtilizationReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Utilization Report name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(String name) {
    DeleteUtilizationReportRequest request =
        DeleteUtilizationReportRequest.newBuilder().setName(name).build();
    return deleteUtilizationReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteUtilizationReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteUtilizationReportAsync(
      DeleteUtilizationReportRequest request) {
    return deleteUtilizationReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteUtilizationReportOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable() {
    return stub.deleteUtilizationReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Utilization Report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteUtilizationReportRequest request =
   *       DeleteUtilizationReportRequest.newBuilder()
   *           .setName(
   *               UtilizationReportName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[UTILIZATION_REPORT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteUtilizationReportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable() {
    return stub.deleteUtilizationReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connectors.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(SourceName parent) {
    ListDatacenterConnectorsRequest request =
        ListDatacenterConnectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatacenterConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of connectors.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(String parent) {
    ListDatacenterConnectorsRequest request =
        ListDatacenterConnectorsRequest.newBuilder().setParent(parent).build();
    return listDatacenterConnectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DatacenterConnector element :
   *       vmMigrationClient.listDatacenterConnectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatacenterConnectorsPagedResponse listDatacenterConnectors(
      ListDatacenterConnectorsRequest request) {
    return listDatacenterConnectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DatacenterConnector> future =
   *       vmMigrationClient.listDatacenterConnectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatacenterConnector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable() {
    return stub.listDatacenterConnectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DatacenterConnectors in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDatacenterConnectorsRequest request =
   *       ListDatacenterConnectorsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDatacenterConnectorsResponse response =
   *         vmMigrationClient.listDatacenterConnectorsCallable().call(request);
   *     for (DatacenterConnector element : response.getDatacenterConnectorsList()) {
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
  public final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable() {
    return stub.listDatacenterConnectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DatacenterConnectorName name =
   *       DatacenterConnectorName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatacenterConnector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(DatacenterConnectorName name) {
    GetDatacenterConnectorRequest request =
        GetDatacenterConnectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDatacenterConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DatacenterConnectorName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *           .toString();
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DatacenterConnector.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(String name) {
    GetDatacenterConnectorRequest request =
        GetDatacenterConnectorRequest.newBuilder().setName(name).build();
    return getDatacenterConnector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDatacenterConnectorRequest request =
   *       GetDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .build();
   *   DatacenterConnector response = vmMigrationClient.getDatacenterConnector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatacenterConnector getDatacenterConnector(GetDatacenterConnectorRequest request) {
    return getDatacenterConnectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDatacenterConnectorRequest request =
   *       GetDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DatacenterConnector> future =
   *       vmMigrationClient.getDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   DatacenterConnector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable() {
    return stub.getDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
   *   String datacenterConnectorId = "datacenterConnectorId-761889719";
   *   DatacenterConnector response =
   *       vmMigrationClient
   *           .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DatacenterConnector's parent. Required. The Source in where the new
   *     DatacenterConnector will be created. For example:
   *     `projects/my-project/locations/us-central1/sources/my-source`
   * @param datacenterConnector Required. The create request body.
   * @param datacenterConnectorId Required. The datacenterConnector identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(
          SourceName parent,
          DatacenterConnector datacenterConnector,
          String datacenterConnectorId) {
    CreateDatacenterConnectorRequest request =
        CreateDatacenterConnectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatacenterConnector(datacenterConnector)
            .setDatacenterConnectorId(datacenterConnectorId)
            .build();
    return createDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   DatacenterConnector datacenterConnector = DatacenterConnector.newBuilder().build();
   *   String datacenterConnectorId = "datacenterConnectorId-761889719";
   *   DatacenterConnector response =
   *       vmMigrationClient
   *           .createDatacenterConnectorAsync(parent, datacenterConnector, datacenterConnectorId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DatacenterConnector's parent. Required. The Source in where the new
   *     DatacenterConnector will be created. For example:
   *     `projects/my-project/locations/us-central1/sources/my-source`
   * @param datacenterConnector Required. The create request body.
   * @param datacenterConnectorId Required. The datacenterConnector identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(
          String parent, DatacenterConnector datacenterConnector, String datacenterConnectorId) {
    CreateDatacenterConnectorRequest request =
        CreateDatacenterConnectorRequest.newBuilder()
            .setParent(parent)
            .setDatacenterConnector(datacenterConnector)
            .setDatacenterConnectorId(datacenterConnectorId)
            .build();
    return createDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DatacenterConnector response =
   *       vmMigrationClient.createDatacenterConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DatacenterConnector, OperationMetadata>
      createDatacenterConnectorAsync(CreateDatacenterConnectorRequest request) {
    return createDatacenterConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DatacenterConnector, OperationMetadata> future =
   *       vmMigrationClient.createDatacenterConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   DatacenterConnector response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable() {
    return stub.createDatacenterConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DatacenterConnector in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDatacenterConnectorRequest request =
   *       CreateDatacenterConnectorRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDatacenterConnectorId("datacenterConnectorId-761889719")
   *           .setDatacenterConnector(DatacenterConnector.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable() {
    return stub.createDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DatacenterConnectorName name =
   *       DatacenterConnectorName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]");
   *   vmMigrationClient.deleteDatacenterConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The DatacenterConnector name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      DatacenterConnectorName name) {
    DeleteDatacenterConnectorRequest request =
        DeleteDatacenterConnectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DatacenterConnectorName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *           .toString();
   *   vmMigrationClient.deleteDatacenterConnectorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The DatacenterConnector name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      String name) {
    DeleteDatacenterConnectorRequest request =
        DeleteDatacenterConnectorRequest.newBuilder().setName(name).build();
    return deleteDatacenterConnectorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteDatacenterConnectorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDatacenterConnectorAsync(
      DeleteDatacenterConnectorRequest request) {
    return deleteDatacenterConnectorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteDatacenterConnectorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable() {
    return stub.deleteDatacenterConnectorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DatacenterConnector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDatacenterConnectorRequest request =
   *       DeleteDatacenterConnectorRequest.newBuilder()
   *           .setName(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteDatacenterConnectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable() {
    return stub.deleteDatacenterConnectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   UpgradeApplianceResponse response = vmMigrationClient.upgradeApplianceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UpgradeApplianceResponse, OperationMetadata> upgradeApplianceAsync(
      UpgradeApplianceRequest request) {
    return upgradeApplianceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<UpgradeApplianceResponse, OperationMetadata> future =
   *       vmMigrationClient.upgradeApplianceOperationCallable().futureCall(request);
   *   // Do something.
   *   UpgradeApplianceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable() {
    return stub.upgradeApplianceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpgradeApplianceRequest request =
   *       UpgradeApplianceRequest.newBuilder()
   *           .setDatacenterConnector(
   *               DatacenterConnectorName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DATACENTER_CONNECTOR]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.upgradeApplianceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable() {
    return stub.upgradeApplianceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   String migratingVmId = "migratingVmId441244154";
   *   MigratingVm response =
   *       vmMigrationClient.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The MigratingVm's parent.
   * @param migratingVm Required. The create request body.
   * @param migratingVmId Required. The migratingVm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      SourceName parent, MigratingVm migratingVm, String migratingVmId) {
    CreateMigratingVmRequest request =
        CreateMigratingVmRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMigratingVm(migratingVm)
            .setMigratingVmId(migratingVmId)
            .build();
    return createMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   String migratingVmId = "migratingVmId441244154";
   *   MigratingVm response =
   *       vmMigrationClient.createMigratingVmAsync(parent, migratingVm, migratingVmId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The MigratingVm's parent.
   * @param migratingVm Required. The create request body.
   * @param migratingVmId Required. The migratingVm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      String parent, MigratingVm migratingVm, String migratingVmId) {
    CreateMigratingVmRequest request =
        CreateMigratingVmRequest.newBuilder()
            .setParent(parent)
            .setMigratingVm(migratingVm)
            .setMigratingVmId(migratingVmId)
            .build();
    return createMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigratingVm response = vmMigrationClient.createMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> createMigratingVmAsync(
      CreateMigratingVmRequest request) {
    return createMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigratingVm, OperationMetadata> future =
   *       vmMigrationClient.createMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable() {
    return stub.createMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new MigratingVm in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateMigratingVmRequest request =
   *       CreateMigratingVmRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setMigratingVmId("migratingVmId441244154")
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable() {
    return stub.createMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MigratingVms.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(SourceName parent) {
    ListMigratingVmsRequest request =
        ListMigratingVmsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMigratingVms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of MigratingVms.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(String parent) {
    ListMigratingVmsRequest request =
        ListMigratingVmsRequest.newBuilder().setParent(parent).build();
    return listMigratingVms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   for (MigratingVm element : vmMigrationClient.listMigratingVms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMigratingVmsPagedResponse listMigratingVms(ListMigratingVmsRequest request) {
    return listMigratingVmsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   ApiFuture<MigratingVm> future =
   *       vmMigrationClient.listMigratingVmsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MigratingVm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable() {
    return stub.listMigratingVmsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MigratingVms in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListMigratingVmsRequest request =
   *       ListMigratingVmsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListMigratingVmsResponse response =
   *         vmMigrationClient.listMigratingVmsCallable().call(request);
   *     for (MigratingVm element : response.getMigratingVmsList()) {
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
  public final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable() {
    return stub.listMigratingVmsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   MigratingVm response = vmMigrationClient.getMigratingVm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(MigratingVmName name) {
    GetMigratingVmRequest request =
        GetMigratingVmRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMigratingVm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   MigratingVm response = vmMigrationClient.getMigratingVm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(String name) {
    GetMigratingVmRequest request = GetMigratingVmRequest.newBuilder().setName(name).build();
    return getMigratingVm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetMigratingVmRequest request =
   *       GetMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   MigratingVm response = vmMigrationClient.getMigratingVm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MigratingVm getMigratingVm(GetMigratingVmRequest request) {
    return getMigratingVmCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetMigratingVmRequest request =
   *       GetMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setView(MigratingVmView.forNumber(0))
   *           .build();
   *   ApiFuture<MigratingVm> future =
   *       vmMigrationClient.getMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable() {
    return stub.getMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVm migratingVm = MigratingVm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MigratingVm response =
   *       vmMigrationClient.updateMigratingVmAsync(migratingVm, updateMask).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the MigratingVm
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> updateMigratingVmAsync(
      MigratingVm migratingVm, FieldMask updateMask) {
    UpdateMigratingVmRequest request =
        UpdateMigratingVmRequest.newBuilder()
            .setMigratingVm(migratingVm)
            .setUpdateMask(updateMask)
            .build();
    return updateMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   MigratingVm response = vmMigrationClient.updateMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MigratingVm, OperationMetadata> updateMigratingVmAsync(
      UpdateMigratingVmRequest request) {
    return updateMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<MigratingVm, OperationMetadata> future =
   *       vmMigrationClient.updateMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   MigratingVm response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable() {
    return stub.updateMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateMigratingVmRequest request =
   *       UpdateMigratingVmRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMigratingVm(MigratingVm.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.updateMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable() {
    return stub.updateMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   vmMigrationClient.deleteMigratingVmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(
      MigratingVmName name) {
    DeleteMigratingVmRequest request =
        DeleteMigratingVmRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   vmMigrationClient.deleteMigratingVmAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(String name) {
    DeleteMigratingVmRequest request = DeleteMigratingVmRequest.newBuilder().setName(name).build();
    return deleteMigratingVmAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   vmMigrationClient.deleteMigratingVmAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMigratingVmAsync(
      DeleteMigratingVmRequest request) {
    return deleteMigratingVmOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteMigratingVmOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable() {
    return stub.deleteMigratingVmOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single MigratingVm.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteMigratingVmRequest request =
   *       DeleteMigratingVmRequest.newBuilder()
   *           .setName(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteMigratingVmCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable() {
    return stub.deleteMigratingVmCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      MigratingVmName migratingVm) {
    StartMigrationRequest request =
        StartMigrationRequest.newBuilder()
            .setMigratingVm(migratingVm == null ? null : migratingVm.toString())
            .build();
    return startMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      String migratingVm) {
    StartMigrationRequest request =
        StartMigrationRequest.newBuilder().setMigratingVm(migratingVm).build();
    return startMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   StartMigrationResponse response = vmMigrationClient.startMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartMigrationResponse, OperationMetadata> startMigrationAsync(
      StartMigrationRequest request) {
    return startMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<StartMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.startMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   StartMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable() {
    return stub.startMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts migration for a VM. Starts the process of uploading data and creating snapshots, in
   * replication cycles scheduled by the policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.startMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return stub.startMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ResumeMigrationResponse response = vmMigrationClient.resumeMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResumeMigrationResponse, OperationMetadata> resumeMigrationAsync(
      ResumeMigrationRequest request) {
    return resumeMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ResumeMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.resumeMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   ResumeMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable() {
    return stub.resumeMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a migration for a VM. When called on a paused migration, will start the process of
   * uploading data and creating snapshots; when called on a completed cut-over migration, will
   * update the migration to active state and start the process of uploading data and creating
   * snapshots.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ResumeMigrationRequest request =
   *       ResumeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.resumeMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable() {
    return stub.resumeMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   PauseMigrationResponse response = vmMigrationClient.pauseMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PauseMigrationResponse, OperationMetadata> pauseMigrationAsync(
      PauseMigrationRequest request) {
    return pauseMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PauseMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.pauseMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   PauseMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable() {
    return stub.pauseMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving
   * source task data. Further replication cycles will not be triggered while the VM is paused.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   PauseMigrationRequest request =
   *       PauseMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.pauseMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable() {
    return stub.pauseMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   FinalizeMigrationResponse response =
   *       vmMigrationClient.finalizeMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      MigratingVmName migratingVm) {
    FinalizeMigrationRequest request =
        FinalizeMigrationRequest.newBuilder()
            .setMigratingVm(migratingVm == null ? null : migratingVm.toString())
            .build();
    return finalizeMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String migratingVm =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   FinalizeMigrationResponse response =
   *       vmMigrationClient.finalizeMigrationAsync(migratingVm).get();
   * }
   * }</pre>
   *
   * @param migratingVm Required. The name of the MigratingVm.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      String migratingVm) {
    FinalizeMigrationRequest request =
        FinalizeMigrationRequest.newBuilder().setMigratingVm(migratingVm).build();
    return finalizeMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   FinalizeMigrationResponse response = vmMigrationClient.finalizeMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<FinalizeMigrationResponse, OperationMetadata> finalizeMigrationAsync(
      FinalizeMigrationRequest request) {
    return finalizeMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<FinalizeMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.finalizeMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   FinalizeMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable() {
    return stub.finalizeMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a migration as completed, deleting migration resources that are no longer being used.
   * Only applicable after cutover is done.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   FinalizeMigrationRequest request =
   *       FinalizeMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.finalizeMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable() {
    return stub.finalizeMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extend the migrating VM time to live.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ExtendMigrationRequest request =
   *       ExtendMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ExtendMigrationResponse response = vmMigrationClient.extendMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExtendMigrationResponse, OperationMetadata> extendMigrationAsync(
      ExtendMigrationRequest request) {
    return extendMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extend the migrating VM time to live.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ExtendMigrationRequest request =
   *       ExtendMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ExtendMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.extendMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   ExtendMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationCallable() {
    return stub.extendMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Extend the migrating VM time to live.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ExtendMigrationRequest request =
   *       ExtendMigrationRequest.newBuilder()
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.extendMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExtendMigrationRequest, Operation> extendMigrationCallable() {
    return stub.extendMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   CloneJob cloneJob = CloneJob.newBuilder().build();
   *   String cloneJobId = "cloneJobId2071309915";
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Clone's parent.
   * @param cloneJob Required. The clone request body.
   * @param cloneJobId Required. The clone job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      MigratingVmName parent, CloneJob cloneJob, String cloneJobId) {
    CreateCloneJobRequest request =
        CreateCloneJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCloneJob(cloneJob)
            .setCloneJobId(cloneJobId)
            .build();
    return createCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   CloneJob cloneJob = CloneJob.newBuilder().build();
   *   String cloneJobId = "cloneJobId2071309915";
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(parent, cloneJob, cloneJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Clone's parent.
   * @param cloneJob Required. The clone request body.
   * @param cloneJobId Required. The clone job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      String parent, CloneJob cloneJob, String cloneJobId) {
    CreateCloneJobRequest request =
        CreateCloneJobRequest.newBuilder()
            .setParent(parent)
            .setCloneJob(cloneJob)
            .setCloneJobId(cloneJobId)
            .build();
    return createCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CloneJob response = vmMigrationClient.createCloneJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloneJob, OperationMetadata> createCloneJobAsync(
      CreateCloneJobRequest request) {
    return createCloneJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CloneJob, OperationMetadata> future =
   *       vmMigrationClient.createCloneJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CloneJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable() {
    return stub.createCloneJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Clone of a specific migrating VM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCloneJobRequest request =
   *       CreateCloneJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCloneJobId("cloneJobId2071309915")
   *           .setCloneJob(CloneJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createCloneJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable() {
    return stub.createCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CloneJobName name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The clone job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      CloneJobName name) {
    CancelCloneJobRequest request =
        CancelCloneJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *           .toString();
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The clone job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      String name) {
    CancelCloneJobRequest request = CancelCloneJobRequest.newBuilder().setName(name).build();
    return cancelCloneJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   CancelCloneJobResponse response = vmMigrationClient.cancelCloneJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCloneJobResponse, OperationMetadata> cancelCloneJobAsync(
      CancelCloneJobRequest request) {
    return cancelCloneJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<CancelCloneJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelCloneJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelCloneJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable() {
    return stub.cancelCloneJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCloneJobRequest request =
   *       CancelCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.cancelCloneJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable() {
    return stub.cancelCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of source VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(MigratingVmName parent) {
    ListCloneJobsRequest request =
        ListCloneJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloneJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of source VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(String parent) {
    ListCloneJobsRequest request = ListCloneJobsRequest.newBuilder().setParent(parent).build();
    return listCloneJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CloneJob element : vmMigrationClient.listCloneJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloneJobsPagedResponse listCloneJobs(ListCloneJobsRequest request) {
    return listCloneJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CloneJob> future =
   *       vmMigrationClient.listCloneJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloneJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable() {
    return stub.listCloneJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCloneJobsRequest request =
   *       ListCloneJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCloneJobsResponse response = vmMigrationClient.listCloneJobsCallable().call(request);
   *     for (CloneJob element : response.getCloneJobsList()) {
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
  public final UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable() {
    return stub.listCloneJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CloneJobName name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]");
   *   CloneJob response = vmMigrationClient.getCloneJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CloneJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(CloneJobName name) {
    GetCloneJobRequest request =
        GetCloneJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCloneJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CloneJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *           .toString();
   *   CloneJob response = vmMigrationClient.getCloneJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CloneJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(String name) {
    GetCloneJobRequest request = GetCloneJobRequest.newBuilder().setName(name).build();
    return getCloneJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCloneJobRequest request =
   *       GetCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   CloneJob response = vmMigrationClient.getCloneJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloneJob getCloneJob(GetCloneJobRequest request) {
    return getCloneJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CloneJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCloneJobRequest request =
   *       GetCloneJobRequest.newBuilder()
   *           .setName(
   *               CloneJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CLONE_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CloneJob> future = vmMigrationClient.getCloneJobCallable().futureCall(request);
   *   // Do something.
   *   CloneJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable() {
    return stub.getCloneJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   CutoverJob cutoverJob = CutoverJob.newBuilder().build();
   *   String cutoverJobId = "cutoverJobId-2003089086";
   *   CutoverJob response =
   *       vmMigrationClient.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Cutover's parent.
   * @param cutoverJob Required. The cutover request body.
   * @param cutoverJobId Required. The cutover job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      MigratingVmName parent, CutoverJob cutoverJob, String cutoverJobId) {
    CreateCutoverJobRequest request =
        CreateCutoverJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCutoverJob(cutoverJob)
            .setCutoverJobId(cutoverJobId)
            .build();
    return createCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   CutoverJob cutoverJob = CutoverJob.newBuilder().build();
   *   String cutoverJobId = "cutoverJobId-2003089086";
   *   CutoverJob response =
   *       vmMigrationClient.createCutoverJobAsync(parent, cutoverJob, cutoverJobId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Cutover's parent.
   * @param cutoverJob Required. The cutover request body.
   * @param cutoverJobId Required. The cutover job identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      String parent, CutoverJob cutoverJob, String cutoverJobId) {
    CreateCutoverJobRequest request =
        CreateCutoverJobRequest.newBuilder()
            .setParent(parent)
            .setCutoverJob(cutoverJob)
            .setCutoverJobId(cutoverJobId)
            .build();
    return createCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CutoverJob response = vmMigrationClient.createCutoverJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CutoverJob, OperationMetadata> createCutoverJobAsync(
      CreateCutoverJobRequest request) {
    return createCutoverJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CutoverJob, OperationMetadata> future =
   *       vmMigrationClient.createCutoverJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CutoverJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable() {
    return stub.createCutoverJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover
   * job resource is created and the job is initiated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateCutoverJobRequest request =
   *       CreateCutoverJobRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setCutoverJobId("cutoverJobId-2003089086")
   *           .setCutoverJob(CutoverJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable() {
    return stub.createCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CutoverJobName name =
   *       CutoverJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The cutover job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      CutoverJobName name) {
    CancelCutoverJobRequest request =
        CancelCutoverJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CutoverJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *           .toString();
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The cutover job id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      String name) {
    CancelCutoverJobRequest request = CancelCutoverJobRequest.newBuilder().setName(name).build();
    return cancelCutoverJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   CancelCutoverJobResponse response = vmMigrationClient.cancelCutoverJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelCutoverJobResponse, OperationMetadata> cancelCutoverJobAsync(
      CancelCutoverJobRequest request) {
    return cancelCutoverJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<CancelCutoverJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelCutoverJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelCutoverJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable() {
    return stub.cancelCutoverJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running cutover job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelCutoverJobRequest request =
   *       CancelCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.cancelCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable() {
    return stub.cancelCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrating VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(MigratingVmName parent) {
    ListCutoverJobsRequest request =
        ListCutoverJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCutoverJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of migrating VMs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(String parent) {
    ListCutoverJobsRequest request = ListCutoverJobsRequest.newBuilder().setParent(parent).build();
    return listCutoverJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CutoverJob element : vmMigrationClient.listCutoverJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCutoverJobsPagedResponse listCutoverJobs(ListCutoverJobsRequest request) {
    return listCutoverJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CutoverJob> future =
   *       vmMigrationClient.listCutoverJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CutoverJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable() {
    return stub.listCutoverJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListCutoverJobsRequest request =
   *       ListCutoverJobsRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCutoverJobsResponse response =
   *         vmMigrationClient.listCutoverJobsCallable().call(request);
   *     for (CutoverJob element : response.getCutoverJobsList()) {
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
  public final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsCallable() {
    return stub.listCutoverJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CutoverJobName name =
   *       CutoverJobName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]");
   *   CutoverJob response = vmMigrationClient.getCutoverJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CutoverJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(CutoverJobName name) {
    GetCutoverJobRequest request =
        GetCutoverJobRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCutoverJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       CutoverJobName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *           .toString();
   *   CutoverJob response = vmMigrationClient.getCutoverJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the CutoverJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(String name) {
    GetCutoverJobRequest request = GetCutoverJobRequest.newBuilder().setName(name).build();
    return getCutoverJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCutoverJobRequest request =
   *       GetCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   CutoverJob response = vmMigrationClient.getCutoverJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CutoverJob getCutoverJob(GetCutoverJobRequest request) {
    return getCutoverJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single CutoverJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetCutoverJobRequest request =
   *       GetCutoverJobRequest.newBuilder()
   *           .setName(
   *               CutoverJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[CUTOVER_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CutoverJob> future = vmMigrationClient.getCutoverJobCallable().futureCall(request);
   *   // Do something.
   *   CutoverJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable() {
    return stub.getCutoverJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Group element : vmMigrationClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of groups.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(LocationName parent) {
    ListGroupsRequest request =
        ListGroupsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Group element : vmMigrationClient.listGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of groups.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(String parent) {
    ListGroupsRequest request = ListGroupsRequest.newBuilder().setParent(parent).build();
    return listGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Group element : vmMigrationClient.listGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupsPagedResponse listGroups(ListGroupsRequest request) {
    return listGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Group> future = vmMigrationClient.listGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Group element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return stub.listGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Groups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListGroupsRequest request =
   *       ListGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGroupsResponse response = vmMigrationClient.listGroupsCallable().call(request);
   *     for (Group element : response.getGroupsList()) {
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
  public final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return stub.listGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   Group response = vmMigrationClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GroupName name) {
    GetGroupRequest request =
        GetGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   Group response = vmMigrationClient.getGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(String name) {
    GetGroupRequest request = GetGroupRequest.newBuilder().setName(name).build();
    return getGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   Group response = vmMigrationClient.getGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Group getGroup(GetGroupRequest request) {
    return getGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetGroupRequest request =
   *       GetGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .build();
   *   ApiFuture<Group> future = vmMigrationClient.getGroupCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return stub.getGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = vmMigrationClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Group's parent.
   * @param group Required. The create request body.
   * @param groupId Required. The group identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      LocationName parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Group group = Group.newBuilder().build();
   *   String groupId = "groupId293428218";
   *   Group response = vmMigrationClient.createGroupAsync(parent, group, groupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The Group's parent.
   * @param group Required. The create request body.
   * @param groupId Required. The group identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      String parent, Group group, String groupId) {
    CreateGroupRequest request =
        CreateGroupRequest.newBuilder()
            .setParent(parent)
            .setGroup(group)
            .setGroupId(groupId)
            .build();
    return createGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = vmMigrationClient.createGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> createGroupAsync(
      CreateGroupRequest request) {
    return createGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       vmMigrationClient.createGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    return stub.createGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Group in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateGroupRequest request =
   *       CreateGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGroupId("groupId293428218")
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.createGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    return stub.createGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   Group group = Group.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Group response = vmMigrationClient.updateGroupAsync(group, updateMask).get();
   * }
   * }</pre>
   *
   * @param group Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Group
   *     resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      Group group, FieldMask updateMask) {
    UpdateGroupRequest request =
        UpdateGroupRequest.newBuilder().setGroup(group).setUpdateMask(updateMask).build();
    return updateGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Group response = vmMigrationClient.updateGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Group, OperationMetadata> updateGroupAsync(
      UpdateGroupRequest request) {
    return updateGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Group, OperationMetadata> future =
   *       vmMigrationClient.updateGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   Group response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return stub.updateGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateGroupRequest request =
   *       UpdateGroupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGroup(Group.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.updateGroupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return stub.updateGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   vmMigrationClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(GroupName name) {
    DeleteGroupRequest request =
        DeleteGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   vmMigrationClient.deleteGroupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The Group name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(String name) {
    DeleteGroupRequest request = DeleteGroupRequest.newBuilder().setName(name).build();
    return deleteGroupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteGroupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGroupAsync(
      DeleteGroupRequest request) {
    return deleteGroupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteGroupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    return stub.deleteGroupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteGroupRequest request =
   *       DeleteGroupRequest.newBuilder()
   *           .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = vmMigrationClient.deleteGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    return stub.deleteGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The full path name of the Group to add to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      GroupName group) {
    AddGroupMigrationRequest request =
        AddGroupMigrationRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return addGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The full path name of the Group to add to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      String group) {
    AddGroupMigrationRequest request =
        AddGroupMigrationRequest.newBuilder().setGroup(group).build();
    return addGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   AddGroupMigrationResponse response = vmMigrationClient.addGroupMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AddGroupMigrationResponse, OperationMetadata> addGroupMigrationAsync(
      AddGroupMigrationRequest request) {
    return addGroupMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AddGroupMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.addGroupMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   AddGroupMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable() {
    return stub.addGroupMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a MigratingVm to a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   AddGroupMigrationRequest request =
   *       AddGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.addGroupMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable() {
    return stub.addGroupMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The name of the Group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(GroupName group) {
    RemoveGroupMigrationRequest request =
        RemoveGroupMigrationRequest.newBuilder()
            .setGroup(group == null ? null : group.toString())
            .build();
    return removeGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString();
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(group).get();
   * }
   * }</pre>
   *
   * @param group Required. The name of the Group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(String group) {
    RemoveGroupMigrationRequest request =
        RemoveGroupMigrationRequest.newBuilder().setGroup(group).build();
    return removeGroupMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   RemoveGroupMigrationResponse response =
   *       vmMigrationClient.removeGroupMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationAsync(RemoveGroupMigrationRequest request) {
    return removeGroupMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RemoveGroupMigrationResponse, OperationMetadata> future =
   *       vmMigrationClient.removeGroupMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   RemoveGroupMigrationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable() {
    return stub.removeGroupMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a MigratingVm from a Group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RemoveGroupMigrationRequest request =
   *       RemoveGroupMigrationRequest.newBuilder()
   *           .setGroup(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
   *           .setMigratingVm(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.removeGroupMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveGroupMigrationRequest, Operation>
      removeGroupMigrationCallable() {
    return stub.removeGroupMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(LocationName parent) {
    ListTargetProjectsRequest request =
        ListTargetProjectsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargetProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(String parent) {
    ListTargetProjectsRequest request =
        ListTargetProjectsRequest.newBuilder().setParent(parent).build();
    return listTargetProjects(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TargetProject element : vmMigrationClient.listTargetProjects(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetProjectsPagedResponse listTargetProjects(
      ListTargetProjectsRequest request) {
    return listTargetProjectsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TargetProject> future =
   *       vmMigrationClient.listTargetProjectsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetProject element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable() {
    return stub.listTargetProjectsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TargetProjects in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListTargetProjectsRequest request =
   *       ListTargetProjectsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTargetProjectsResponse response =
   *         vmMigrationClient.listTargetProjectsCallable().call(request);
   *     for (TargetProject element : response.getTargetProjectsList()) {
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
  public final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable() {
    return stub.listTargetProjectsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
   *   TargetProject response = vmMigrationClient.getTargetProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(TargetProjectName name) {
    GetTargetProjectRequest request =
        GetTargetProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTargetProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString();
   *   TargetProject response = vmMigrationClient.getTargetProject(name);
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(String name) {
    GetTargetProjectRequest request = GetTargetProjectRequest.newBuilder().setName(name).build();
    return getTargetProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetTargetProjectRequest request =
   *       GetTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .build();
   *   TargetProject response = vmMigrationClient.getTargetProject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetProject getTargetProject(GetTargetProjectRequest request) {
    return getTargetProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetTargetProjectRequest request =
   *       GetTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .build();
   *   ApiFuture<TargetProject> future =
   *       vmMigrationClient.getTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable() {
    return stub.getTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   String targetProjectId = "targetProjectId1290130307";
   *   TargetProject response =
   *       vmMigrationClient.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The TargetProject's parent.
   * @param targetProject Required. The create request body.
   * @param targetProjectId Required. The target_project identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      LocationName parent, TargetProject targetProject, String targetProjectId) {
    CreateTargetProjectRequest request =
        CreateTargetProjectRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetProject(targetProject)
            .setTargetProjectId(targetProjectId)
            .build();
    return createTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   String targetProjectId = "targetProjectId1290130307";
   *   TargetProject response =
   *       vmMigrationClient.createTargetProjectAsync(parent, targetProject, targetProjectId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The TargetProject's parent.
   * @param targetProject Required. The create request body.
   * @param targetProjectId Required. The target_project identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      String parent, TargetProject targetProject, String targetProjectId) {
    CreateTargetProjectRequest request =
        CreateTargetProjectRequest.newBuilder()
            .setParent(parent)
            .setTargetProject(targetProject)
            .setTargetProjectId(targetProjectId)
            .build();
    return createTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TargetProject response = vmMigrationClient.createTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> createTargetProjectAsync(
      CreateTargetProjectRequest request) {
    return createTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<TargetProject, OperationMetadata> future =
   *       vmMigrationClient.createTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable() {
    return stub.createTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TargetProject in a given project.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateTargetProjectRequest request =
   *       CreateTargetProjectRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTargetProjectId("targetProjectId1290130307")
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable() {
    return stub.createTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProject targetProject = TargetProject.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TargetProject response =
   *       vmMigrationClient.updateTargetProjectAsync(targetProject, updateMask).get();
   * }
   * }</pre>
   *
   * @param targetProject Required. The update request body.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the
   *     TargetProject resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> updateTargetProjectAsync(
      TargetProject targetProject, FieldMask updateMask) {
    UpdateTargetProjectRequest request =
        UpdateTargetProjectRequest.newBuilder()
            .setTargetProject(targetProject)
            .setUpdateMask(updateMask)
            .build();
    return updateTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TargetProject response = vmMigrationClient.updateTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TargetProject, OperationMetadata> updateTargetProjectAsync(
      UpdateTargetProjectRequest request) {
    return updateTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<TargetProject, OperationMetadata> future =
   *       vmMigrationClient.updateTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   TargetProject response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable() {
    return stub.updateTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateTargetProjectRequest request =
   *       UpdateTargetProjectRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTargetProject(TargetProject.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.updateTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable() {
    return stub.updateTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   TargetProjectName name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]");
   *   vmMigrationClient.deleteTargetProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(
      TargetProjectName name) {
    DeleteTargetProjectRequest request =
        DeleteTargetProjectRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString();
   *   vmMigrationClient.deleteTargetProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The TargetProject name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(String name) {
    DeleteTargetProjectRequest request =
        DeleteTargetProjectRequest.newBuilder().setName(name).build();
    return deleteTargetProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteTargetProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTargetProjectAsync(
      DeleteTargetProjectRequest request) {
    return deleteTargetProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteTargetProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable() {
    return stub.deleteTargetProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TargetProject.
   *
   * <p>NOTE: TargetProject is a global resource; hence the only supported value for location is
   * `global`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteTargetProjectRequest request =
   *       DeleteTargetProjectRequest.newBuilder()
   *           .setName(
   *               TargetProjectName.of("[PROJECT]", "[LOCATION]", "[TARGET_PROJECT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteTargetProjectCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable() {
    return stub.deleteTargetProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReplicationCycles in a given MigratingVM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   MigratingVmName parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]");
   *   for (ReplicationCycle element :
   *       vmMigrationClient.listReplicationCycles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ReplicationCycles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationCyclesPagedResponse listReplicationCycles(MigratingVmName parent) {
    ListReplicationCyclesRequest request =
        ListReplicationCyclesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReplicationCycles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReplicationCycles in a given MigratingVM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent =
   *       MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]").toString();
   *   for (ReplicationCycle element :
   *       vmMigrationClient.listReplicationCycles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ReplicationCycles.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationCyclesPagedResponse listReplicationCycles(String parent) {
    ListReplicationCyclesRequest request =
        ListReplicationCyclesRequest.newBuilder().setParent(parent).build();
    return listReplicationCycles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReplicationCycles in a given MigratingVM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListReplicationCyclesRequest request =
   *       ListReplicationCyclesRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ReplicationCycle element :
   *       vmMigrationClient.listReplicationCycles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationCyclesPagedResponse listReplicationCycles(
      ListReplicationCyclesRequest request) {
    return listReplicationCyclesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReplicationCycles in a given MigratingVM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListReplicationCyclesRequest request =
   *       ListReplicationCyclesRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ReplicationCycle> future =
   *       vmMigrationClient.listReplicationCyclesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReplicationCycle element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesPagedResponse>
      listReplicationCyclesPagedCallable() {
    return stub.listReplicationCyclesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ReplicationCycles in a given MigratingVM.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListReplicationCyclesRequest request =
   *       ListReplicationCyclesRequest.newBuilder()
   *           .setParent(
   *               MigratingVmName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListReplicationCyclesResponse response =
   *         vmMigrationClient.listReplicationCyclesCallable().call(request);
   *     for (ReplicationCycle element : response.getReplicationCyclesList()) {
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
  public final UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesResponse>
      listReplicationCyclesCallable() {
    return stub.listReplicationCyclesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReplicationCycle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ReplicationCycleName name =
   *       ReplicationCycleName.of(
   *           "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[REPLICATION_CYCLE]");
   *   ReplicationCycle response = vmMigrationClient.getReplicationCycle(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReplicationCycle.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReplicationCycle getReplicationCycle(ReplicationCycleName name) {
    GetReplicationCycleRequest request =
        GetReplicationCycleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReplicationCycle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReplicationCycle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       ReplicationCycleName.of(
   *               "[PROJECT]", "[LOCATION]", "[SOURCE]", "[MIGRATING_VM]", "[REPLICATION_CYCLE]")
   *           .toString();
   *   ReplicationCycle response = vmMigrationClient.getReplicationCycle(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReplicationCycle.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReplicationCycle getReplicationCycle(String name) {
    GetReplicationCycleRequest request =
        GetReplicationCycleRequest.newBuilder().setName(name).build();
    return getReplicationCycle(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReplicationCycle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetReplicationCycleRequest request =
   *       GetReplicationCycleRequest.newBuilder()
   *           .setName(
   *               ReplicationCycleName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SOURCE]",
   *                       "[MIGRATING_VM]",
   *                       "[REPLICATION_CYCLE]")
   *                   .toString())
   *           .build();
   *   ReplicationCycle response = vmMigrationClient.getReplicationCycle(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReplicationCycle getReplicationCycle(GetReplicationCycleRequest request) {
    return getReplicationCycleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ReplicationCycle.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetReplicationCycleRequest request =
   *       GetReplicationCycleRequest.newBuilder()
   *           .setName(
   *               ReplicationCycleName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[SOURCE]",
   *                       "[MIGRATING_VM]",
   *                       "[REPLICATION_CYCLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReplicationCycle> future =
   *       vmMigrationClient.getReplicationCycleCallable().futureCall(request);
   *   // Do something.
   *   ReplicationCycle response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReplicationCycleRequest, ReplicationCycle>
      getReplicationCycleCallable() {
    return stub.getReplicationCycleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImports in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ImageImport element : vmMigrationClient.listImageImports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportsPagedResponse listImageImports(LocationName parent) {
    ListImageImportsRequest request =
        ListImageImportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listImageImports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImports in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ImageImport element : vmMigrationClient.listImageImports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportsPagedResponse listImageImports(String parent) {
    ListImageImportsRequest request =
        ListImageImportsRequest.newBuilder().setParent(parent).build();
    return listImageImports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImports in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportsRequest request =
   *       ListImageImportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ImageImport element : vmMigrationClient.listImageImports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportsPagedResponse listImageImports(ListImageImportsRequest request) {
    return listImageImportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImports in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportsRequest request =
   *       ListImageImportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ImageImport> future =
   *       vmMigrationClient.listImageImportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImageImport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImageImportsRequest, ListImageImportsPagedResponse>
      listImageImportsPagedCallable() {
    return stub.listImageImportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImports in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportsRequest request =
   *       ListImageImportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListImageImportsResponse response =
   *         vmMigrationClient.listImageImportsCallable().call(request);
   *     for (ImageImport element : response.getImageImportsList()) {
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
  public final UnaryCallable<ListImageImportsRequest, ListImageImportsResponse>
      listImageImportsCallable() {
    return stub.listImageImportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ImageImportName name = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   ImageImport response = vmMigrationClient.getImageImport(name);
   * }
   * }</pre>
   *
   * @param name Required. The ImageImport name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImport getImageImport(ImageImportName name) {
    GetImageImportRequest request =
        GetImageImportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getImageImport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   ImageImport response = vmMigrationClient.getImageImport(name);
   * }
   * }</pre>
   *
   * @param name Required. The ImageImport name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImport getImageImport(String name) {
    GetImageImportRequest request = GetImageImportRequest.newBuilder().setName(name).build();
    return getImageImport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetImageImportRequest request =
   *       GetImageImportRequest.newBuilder()
   *           .setName(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   ImageImport response = vmMigrationClient.getImageImport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImport getImageImport(GetImageImportRequest request) {
    return getImageImportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetImageImportRequest request =
   *       GetImageImportRequest.newBuilder()
   *           .setName(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .build();
   *   ApiFuture<ImageImport> future =
   *       vmMigrationClient.getImageImportCallable().futureCall(request);
   *   // Do something.
   *   ImageImport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImageImportRequest, ImageImport> getImageImportCallable() {
    return stub.getImageImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ImageImport in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImageImport imageImport = ImageImport.newBuilder().build();
   *   String imageImportId = "imageImportId943893019";
   *   ImageImport response =
   *       vmMigrationClient.createImageImportAsync(parent, imageImport, imageImportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The ImageImport's parent.
   * @param imageImport Required. The create request body.
   * @param imageImportId Required. The image import identifier. This value maximum length is 63
   *     characters, and valid characters are /[a-z][0-9]-/. It must start with an english letter
   *     and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImageImport, OperationMetadata> createImageImportAsync(
      LocationName parent, ImageImport imageImport, String imageImportId) {
    CreateImageImportRequest request =
        CreateImageImportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImageImport(imageImport)
            .setImageImportId(imageImportId)
            .build();
    return createImageImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ImageImport in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ImageImport imageImport = ImageImport.newBuilder().build();
   *   String imageImportId = "imageImportId943893019";
   *   ImageImport response =
   *       vmMigrationClient.createImageImportAsync(parent, imageImport, imageImportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The ImageImport's parent.
   * @param imageImport Required. The create request body.
   * @param imageImportId Required. The image import identifier. This value maximum length is 63
   *     characters, and valid characters are /[a-z][0-9]-/. It must start with an english letter
   *     and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImageImport, OperationMetadata> createImageImportAsync(
      String parent, ImageImport imageImport, String imageImportId) {
    CreateImageImportRequest request =
        CreateImageImportRequest.newBuilder()
            .setParent(parent)
            .setImageImport(imageImport)
            .setImageImportId(imageImportId)
            .build();
    return createImageImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ImageImport in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateImageImportRequest request =
   *       CreateImageImportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImageImportId("imageImportId943893019")
   *           .setImageImport(ImageImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ImageImport response = vmMigrationClient.createImageImportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImageImport, OperationMetadata> createImageImportAsync(
      CreateImageImportRequest request) {
    return createImageImportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ImageImport in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateImageImportRequest request =
   *       CreateImageImportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImageImportId("imageImportId943893019")
   *           .setImageImport(ImageImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ImageImport, OperationMetadata> future =
   *       vmMigrationClient.createImageImportOperationCallable().futureCall(request);
   *   // Do something.
   *   ImageImport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationCallable() {
    return stub.createImageImportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ImageImport in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateImageImportRequest request =
   *       CreateImageImportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setImageImportId("imageImportId943893019")
   *           .setImageImport(ImageImport.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createImageImportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateImageImportRequest, Operation> createImageImportCallable() {
    return stub.createImageImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ImageImportName name = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   vmMigrationClient.deleteImageImportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The ImageImport name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImageImportAsync(
      ImageImportName name) {
    DeleteImageImportRequest request =
        DeleteImageImportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteImageImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   vmMigrationClient.deleteImageImportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The ImageImport name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImageImportAsync(String name) {
    DeleteImageImportRequest request = DeleteImageImportRequest.newBuilder().setName(name).build();
    return deleteImageImportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteImageImportRequest request =
   *       DeleteImageImportRequest.newBuilder()
   *           .setName(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   vmMigrationClient.deleteImageImportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteImageImportAsync(
      DeleteImageImportRequest request) {
    return deleteImageImportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteImageImportRequest request =
   *       DeleteImageImportRequest.newBuilder()
   *           .setName(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteImageImportOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationCallable() {
    return stub.deleteImageImportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ImageImport.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteImageImportRequest request =
   *       DeleteImageImportRequest.newBuilder()
   *           .setName(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteImageImportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteImageImportRequest, Operation> deleteImageImportCallable() {
    return stub.deleteImageImportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImportJobs in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ImageImportName parent = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]");
   *   for (ImageImportJob element : vmMigrationClient.listImageImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportJobsPagedResponse listImageImportJobs(ImageImportName parent) {
    ListImageImportJobsRequest request =
        ListImageImportJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listImageImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImportJobs in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
   *   for (ImageImportJob element : vmMigrationClient.listImageImportJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of targets.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportJobsPagedResponse listImageImportJobs(String parent) {
    ListImageImportJobsRequest request =
        ListImageImportJobsRequest.newBuilder().setParent(parent).build();
    return listImageImportJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImportJobs in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportJobsRequest request =
   *       ListImageImportJobsRequest.newBuilder()
   *           .setParent(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ImageImportJob element : vmMigrationClient.listImageImportJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageImportJobsPagedResponse listImageImportJobs(
      ListImageImportJobsRequest request) {
    return listImageImportJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImportJobs in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportJobsRequest request =
   *       ListImageImportJobsRequest.newBuilder()
   *           .setParent(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ImageImportJob> future =
   *       vmMigrationClient.listImageImportJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImageImportJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsPagedResponse>
      listImageImportJobsPagedCallable() {
    return stub.listImageImportJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ImageImportJobs in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListImageImportJobsRequest request =
   *       ListImageImportJobsRequest.newBuilder()
   *           .setParent(ImageImportName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListImageImportJobsResponse response =
   *         vmMigrationClient.listImageImportJobsCallable().call(request);
   *     for (ImageImportJob element : response.getImageImportJobsList()) {
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
  public final UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsResponse>
      listImageImportJobsCallable() {
    return stub.listImageImportJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImportJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ImageImportJobName name =
   *       ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]");
   *   ImageImportJob response = vmMigrationClient.getImageImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The ImageImportJob name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImportJob getImageImportJob(ImageImportJobName name) {
    GetImageImportJobRequest request =
        GetImageImportJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getImageImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImportJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString();
   *   ImageImportJob response = vmMigrationClient.getImageImportJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The ImageImportJob name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImportJob getImageImportJob(String name) {
    GetImageImportJobRequest request = GetImageImportJobRequest.newBuilder().setName(name).build();
    return getImageImportJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImportJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetImageImportJobRequest request =
   *       GetImageImportJobRequest.newBuilder()
   *           .setName(
   *               ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString())
   *           .build();
   *   ImageImportJob response = vmMigrationClient.getImageImportJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImageImportJob getImageImportJob(GetImageImportJobRequest request) {
    return getImageImportJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ImageImportJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetImageImportJobRequest request =
   *       GetImageImportJobRequest.newBuilder()
   *           .setName(
   *               ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString())
   *           .build();
   *   ApiFuture<ImageImportJob> future =
   *       vmMigrationClient.getImageImportJobCallable().futureCall(request);
   *   // Do something.
   *   ImageImportJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetImageImportJobRequest, ImageImportJob> getImageImportJobCallable() {
    return stub.getImageImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ImageImportJobName name =
   *       ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]");
   *   CancelImageImportJobResponse response =
   *       vmMigrationClient.cancelImageImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The image import job id.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobAsync(ImageImportJobName name) {
    CancelImageImportJobRequest request =
        CancelImageImportJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return cancelImageImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString();
   *   CancelImageImportJobResponse response =
   *       vmMigrationClient.cancelImageImportJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The image import job id.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobAsync(String name) {
    CancelImageImportJobRequest request =
        CancelImageImportJobRequest.newBuilder().setName(name).build();
    return cancelImageImportJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelImageImportJobRequest request =
   *       CancelImageImportJobRequest.newBuilder()
   *           .setName(
   *               ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString())
   *           .build();
   *   CancelImageImportJobResponse response =
   *       vmMigrationClient.cancelImageImportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobAsync(CancelImageImportJobRequest request) {
    return cancelImageImportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelImageImportJobRequest request =
   *       CancelImageImportJobRequest.newBuilder()
   *           .setName(
   *               ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString())
   *           .build();
   *   OperationFuture<CancelImageImportJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelImageImportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelImageImportJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationCallable() {
    return stub.cancelImageImportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the cancellation of a running clone job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelImageImportJobRequest request =
   *       CancelImageImportJobRequest.newBuilder()
   *           .setName(
   *               ImageImportJobName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[RESULT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.cancelImageImportJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelImageImportJobRequest, Operation>
      cancelImageImportJobCallable() {
    return stub.cancelImageImportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new disk migration job in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   DiskMigrationJob diskMigrationJob = DiskMigrationJob.newBuilder().build();
   *   String diskMigrationJobId = "diskMigrationJobId-173409913";
   *   DiskMigrationJob response =
   *       vmMigrationClient
   *           .createDiskMigrationJobAsync(parent, diskMigrationJob, diskMigrationJobId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DiskMigrationJob's parent.
   * @param diskMigrationJob Required. The create request body.
   * @param diskMigrationJobId Required. The DiskMigrationJob identifier. The maximum length of this
   *     value is 63 characters. Valid characters are lower case Latin letters, digits and hyphen.
   *     It must start with a Latin letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiskMigrationJob, OperationMetadata> createDiskMigrationJobAsync(
      SourceName parent, DiskMigrationJob diskMigrationJob, String diskMigrationJobId) {
    CreateDiskMigrationJobRequest request =
        CreateDiskMigrationJobRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDiskMigrationJob(diskMigrationJob)
            .setDiskMigrationJobId(diskMigrationJobId)
            .build();
    return createDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new disk migration job in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   DiskMigrationJob diskMigrationJob = DiskMigrationJob.newBuilder().build();
   *   String diskMigrationJobId = "diskMigrationJobId-173409913";
   *   DiskMigrationJob response =
   *       vmMigrationClient
   *           .createDiskMigrationJobAsync(parent, diskMigrationJob, diskMigrationJobId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The DiskMigrationJob's parent.
   * @param diskMigrationJob Required. The create request body.
   * @param diskMigrationJobId Required. The DiskMigrationJob identifier. The maximum length of this
   *     value is 63 characters. Valid characters are lower case Latin letters, digits and hyphen.
   *     It must start with a Latin letter and must not end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiskMigrationJob, OperationMetadata> createDiskMigrationJobAsync(
      String parent, DiskMigrationJob diskMigrationJob, String diskMigrationJobId) {
    CreateDiskMigrationJobRequest request =
        CreateDiskMigrationJobRequest.newBuilder()
            .setParent(parent)
            .setDiskMigrationJob(diskMigrationJob)
            .setDiskMigrationJobId(diskMigrationJobId)
            .build();
    return createDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new disk migration job in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDiskMigrationJobRequest request =
   *       CreateDiskMigrationJobRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDiskMigrationJobId("diskMigrationJobId-173409913")
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DiskMigrationJob response = vmMigrationClient.createDiskMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiskMigrationJob, OperationMetadata> createDiskMigrationJobAsync(
      CreateDiskMigrationJobRequest request) {
    return createDiskMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new disk migration job in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDiskMigrationJobRequest request =
   *       CreateDiskMigrationJobRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDiskMigrationJobId("diskMigrationJobId-173409913")
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DiskMigrationJob, OperationMetadata> future =
   *       vmMigrationClient.createDiskMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   DiskMigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationCallable() {
    return stub.createDiskMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new disk migration job in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CreateDiskMigrationJobRequest request =
   *       CreateDiskMigrationJobRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setDiskMigrationJobId("diskMigrationJobId-173409913")
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.createDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDiskMigrationJobRequest, Operation>
      createDiskMigrationJobCallable() {
    return stub.createDiskMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiskMigrationJobs in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
   *   for (DiskMigrationJob element :
   *       vmMigrationClient.listDiskMigrationJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DiskMigrationJobs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiskMigrationJobsPagedResponse listDiskMigrationJobs(SourceName parent) {
    ListDiskMigrationJobsRequest request =
        ListDiskMigrationJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiskMigrationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiskMigrationJobs in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString();
   *   for (DiskMigrationJob element :
   *       vmMigrationClient.listDiskMigrationJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DiskMigrationJobs.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiskMigrationJobsPagedResponse listDiskMigrationJobs(String parent) {
    ListDiskMigrationJobsRequest request =
        ListDiskMigrationJobsRequest.newBuilder().setParent(parent).build();
    return listDiskMigrationJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiskMigrationJobs in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDiskMigrationJobsRequest request =
   *       ListDiskMigrationJobsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DiskMigrationJob element :
   *       vmMigrationClient.listDiskMigrationJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiskMigrationJobsPagedResponse listDiskMigrationJobs(
      ListDiskMigrationJobsRequest request) {
    return listDiskMigrationJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiskMigrationJobs in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDiskMigrationJobsRequest request =
   *       ListDiskMigrationJobsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DiskMigrationJob> future =
   *       vmMigrationClient.listDiskMigrationJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiskMigrationJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsPagedCallable() {
    return stub.listDiskMigrationJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DiskMigrationJobs in a given Source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListDiskMigrationJobsRequest request =
   *       ListDiskMigrationJobsRequest.newBuilder()
   *           .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDiskMigrationJobsResponse response =
   *         vmMigrationClient.listDiskMigrationJobsCallable().call(request);
   *     for (DiskMigrationJob element : response.getDiskMigrationJobsList()) {
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
  public final UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
      listDiskMigrationJobsCallable() {
    return stub.listDiskMigrationJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DiskMigrationJobName name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]");
   *   DiskMigrationJob response = vmMigrationClient.getDiskMigrationJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiskMigrationJob getDiskMigrationJob(DiskMigrationJobName name) {
    GetDiskMigrationJobRequest request =
        GetDiskMigrationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiskMigrationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *           .toString();
   *   DiskMigrationJob response = vmMigrationClient.getDiskMigrationJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiskMigrationJob getDiskMigrationJob(String name) {
    GetDiskMigrationJobRequest request =
        GetDiskMigrationJobRequest.newBuilder().setName(name).build();
    return getDiskMigrationJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDiskMigrationJobRequest request =
   *       GetDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   DiskMigrationJob response = vmMigrationClient.getDiskMigrationJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiskMigrationJob getDiskMigrationJob(GetDiskMigrationJobRequest request) {
    return getDiskMigrationJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetDiskMigrationJobRequest request =
   *       GetDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiskMigrationJob> future =
   *       vmMigrationClient.getDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   DiskMigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiskMigrationJobRequest, DiskMigrationJob>
      getDiskMigrationJobCallable() {
    return stub.getDiskMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DiskMigrationJob diskMigrationJob = DiskMigrationJob.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DiskMigrationJob response =
   *       vmMigrationClient.updateDiskMigrationJobAsync(diskMigrationJob, updateMask).get();
   * }
   * }</pre>
   *
   * @param diskMigrationJob Required. The update request body.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     DiskMigrationJob resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask, then a mask equivalent to all fields that are
   *     populated (have a non-empty value), will be implied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiskMigrationJob, OperationMetadata> updateDiskMigrationJobAsync(
      DiskMigrationJob diskMigrationJob, FieldMask updateMask) {
    UpdateDiskMigrationJobRequest request =
        UpdateDiskMigrationJobRequest.newBuilder()
            .setDiskMigrationJob(diskMigrationJob)
            .setUpdateMask(updateMask)
            .build();
    return updateDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateDiskMigrationJobRequest request =
   *       UpdateDiskMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DiskMigrationJob response = vmMigrationClient.updateDiskMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DiskMigrationJob, OperationMetadata> updateDiskMigrationJobAsync(
      UpdateDiskMigrationJobRequest request) {
    return updateDiskMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateDiskMigrationJobRequest request =
   *       UpdateDiskMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DiskMigrationJob, OperationMetadata> future =
   *       vmMigrationClient.updateDiskMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   DiskMigrationJob response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationCallable() {
    return stub.updateDiskMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   UpdateDiskMigrationJobRequest request =
   *       UpdateDiskMigrationJobRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDiskMigrationJob(DiskMigrationJob.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.updateDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDiskMigrationJobRequest, Operation>
      updateDiskMigrationJobCallable() {
    return stub.updateDiskMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DiskMigrationJobName name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]");
   *   vmMigrationClient.deleteDiskMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDiskMigrationJobAsync(
      DiskMigrationJobName name) {
    DeleteDiskMigrationJobRequest request =
        DeleteDiskMigrationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *           .toString();
   *   vmMigrationClient.deleteDiskMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDiskMigrationJobAsync(String name) {
    DeleteDiskMigrationJobRequest request =
        DeleteDiskMigrationJobRequest.newBuilder().setName(name).build();
    return deleteDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDiskMigrationJobRequest request =
   *       DeleteDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   vmMigrationClient.deleteDiskMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDiskMigrationJobAsync(
      DeleteDiskMigrationJobRequest request) {
    return deleteDiskMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDiskMigrationJobRequest request =
   *       DeleteDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       vmMigrationClient.deleteDiskMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationCallable() {
    return stub.deleteDiskMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DiskMigrationJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DeleteDiskMigrationJobRequest request =
   *       DeleteDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.deleteDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDiskMigrationJobRequest, Operation>
      deleteDiskMigrationJobCallable() {
    return stub.deleteDiskMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   DiskMigrationJobName name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]");
   *   RunDiskMigrationJobResponse response = vmMigrationClient.runDiskMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobAsync(DiskMigrationJobName name) {
    RunDiskMigrationJobRequest request =
        RunDiskMigrationJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return runDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   String name =
   *       DiskMigrationJobName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *           .toString();
   *   RunDiskMigrationJobResponse response = vmMigrationClient.runDiskMigrationJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiskMigrationJob.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobAsync(String name) {
    RunDiskMigrationJobRequest request =
        RunDiskMigrationJobRequest.newBuilder().setName(name).build();
    return runDiskMigrationJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RunDiskMigrationJobRequest request =
   *       RunDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   RunDiskMigrationJobResponse response =
   *       vmMigrationClient.runDiskMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobAsync(RunDiskMigrationJobRequest request) {
    return runDiskMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RunDiskMigrationJobRequest request =
   *       RunDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<RunDiskMigrationJobResponse, OperationMetadata> future =
   *       vmMigrationClient.runDiskMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   RunDiskMigrationJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationCallable() {
    return stub.runDiskMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   RunDiskMigrationJobRequest request =
   *       RunDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.runDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunDiskMigrationJobRequest, Operation> runDiskMigrationJobCallable() {
    return stub.runDiskMigrationJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelDiskMigrationJobRequest request =
   *       CancelDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   CancelDiskMigrationJobResponse response =
   *       vmMigrationClient.cancelDiskMigrationJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobAsync(CancelDiskMigrationJobRequest request) {
    return cancelDiskMigrationJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelDiskMigrationJobRequest request =
   *       CancelDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<CancelDiskMigrationJobResponse, OperationMetadata> future =
   *       vmMigrationClient.cancelDiskMigrationJobOperationCallable().futureCall(request);
   *   // Do something.
   *   CancelDiskMigrationJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationCallable() {
    return stub.cancelDiskMigrationJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the disk migration job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   CancelDiskMigrationJobRequest request =
   *       CancelDiskMigrationJobRequest.newBuilder()
   *           .setName(
   *               DiskMigrationJobName.of(
   *                       "[PROJECT]", "[LOCATION]", "[SOURCE]", "[DISK_MIGRATION_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vmMigrationClient.cancelDiskMigrationJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelDiskMigrationJobRequest, Operation>
      cancelDiskMigrationJobCallable() {
    return stub.cancelDiskMigrationJobCallable();
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
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vmMigrationClient.listLocations(request).iterateAll()) {
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
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vmMigrationClient.listLocationsPagedCallable().futureCall(request);
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
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = vmMigrationClient.listLocationsCallable().call(request);
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
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vmMigrationClient.getLocation(request);
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
   * try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = vmMigrationClient.getLocationCallable().futureCall(request);
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

  public static class ListSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    public static ApiFuture<ListSourcesPagedResponse> createAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      ApiFuture<ListSourcesPage> futurePage =
          ListSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSourcesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSourcesPagedResponse(ListSourcesPage page) {
      super(page, ListSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSourcesPage
      extends AbstractPage<ListSourcesRequest, ListSourcesResponse, Source, ListSourcesPage> {

    private ListSourcesPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      super(context, response);
    }

    private static ListSourcesPage createEmptyPage() {
      return new ListSourcesPage(null, null);
    }

    @Override
    protected ListSourcesPage createPage(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ListSourcesResponse response) {
      return new ListSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListSourcesPage> createPageAsync(
        PageContext<ListSourcesRequest, ListSourcesResponse, Source> context,
        ApiFuture<ListSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSourcesRequest,
          ListSourcesResponse,
          Source,
          ListSourcesPage,
          ListSourcesFixedSizeCollection> {

    private ListSourcesFixedSizeCollection(List<ListSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSourcesFixedSizeCollection createEmptyCollection() {
      return new ListSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSourcesFixedSizeCollection createCollection(
        List<ListSourcesPage> pages, int collectionSize) {
      return new ListSourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchStorageInventoryPagedResponse
      extends AbstractPagedListResponse<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          SourceStorageResource,
          FetchStorageInventoryPage,
          FetchStorageInventoryFixedSizeCollection> {

    public static ApiFuture<FetchStorageInventoryPagedResponse> createAsync(
        PageContext<
                FetchStorageInventoryRequest, FetchStorageInventoryResponse, SourceStorageResource>
            context,
        ApiFuture<FetchStorageInventoryResponse> futureResponse) {
      ApiFuture<FetchStorageInventoryPage> futurePage =
          FetchStorageInventoryPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchStorageInventoryPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchStorageInventoryPagedResponse(FetchStorageInventoryPage page) {
      super(page, FetchStorageInventoryFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchStorageInventoryPage
      extends AbstractPage<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          SourceStorageResource,
          FetchStorageInventoryPage> {

    private FetchStorageInventoryPage(
        PageContext<
                FetchStorageInventoryRequest, FetchStorageInventoryResponse, SourceStorageResource>
            context,
        FetchStorageInventoryResponse response) {
      super(context, response);
    }

    private static FetchStorageInventoryPage createEmptyPage() {
      return new FetchStorageInventoryPage(null, null);
    }

    @Override
    protected FetchStorageInventoryPage createPage(
        PageContext<
                FetchStorageInventoryRequest, FetchStorageInventoryResponse, SourceStorageResource>
            context,
        FetchStorageInventoryResponse response) {
      return new FetchStorageInventoryPage(context, response);
    }

    @Override
    public ApiFuture<FetchStorageInventoryPage> createPageAsync(
        PageContext<
                FetchStorageInventoryRequest, FetchStorageInventoryResponse, SourceStorageResource>
            context,
        ApiFuture<FetchStorageInventoryResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchStorageInventoryFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchStorageInventoryRequest,
          FetchStorageInventoryResponse,
          SourceStorageResource,
          FetchStorageInventoryPage,
          FetchStorageInventoryFixedSizeCollection> {

    private FetchStorageInventoryFixedSizeCollection(
        List<FetchStorageInventoryPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchStorageInventoryFixedSizeCollection createEmptyCollection() {
      return new FetchStorageInventoryFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchStorageInventoryFixedSizeCollection createCollection(
        List<FetchStorageInventoryPage> pages, int collectionSize) {
      return new FetchStorageInventoryFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUtilizationReportsPagedResponse
      extends AbstractPagedListResponse<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage,
          ListUtilizationReportsFixedSizeCollection> {

    public static ApiFuture<ListUtilizationReportsPagedResponse> createAsync(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ApiFuture<ListUtilizationReportsResponse> futureResponse) {
      ApiFuture<ListUtilizationReportsPage> futurePage =
          ListUtilizationReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUtilizationReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUtilizationReportsPagedResponse(ListUtilizationReportsPage page) {
      super(page, ListUtilizationReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUtilizationReportsPage
      extends AbstractPage<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage> {

    private ListUtilizationReportsPage(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ListUtilizationReportsResponse response) {
      super(context, response);
    }

    private static ListUtilizationReportsPage createEmptyPage() {
      return new ListUtilizationReportsPage(null, null);
    }

    @Override
    protected ListUtilizationReportsPage createPage(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ListUtilizationReportsResponse response) {
      return new ListUtilizationReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListUtilizationReportsPage> createPageAsync(
        PageContext<
                ListUtilizationReportsRequest, ListUtilizationReportsResponse, UtilizationReport>
            context,
        ApiFuture<ListUtilizationReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUtilizationReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUtilizationReportsRequest,
          ListUtilizationReportsResponse,
          UtilizationReport,
          ListUtilizationReportsPage,
          ListUtilizationReportsFixedSizeCollection> {

    private ListUtilizationReportsFixedSizeCollection(
        List<ListUtilizationReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUtilizationReportsFixedSizeCollection createEmptyCollection() {
      return new ListUtilizationReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUtilizationReportsFixedSizeCollection createCollection(
        List<ListUtilizationReportsPage> pages, int collectionSize) {
      return new ListUtilizationReportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatacenterConnectorsPagedResponse
      extends AbstractPagedListResponse<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage,
          ListDatacenterConnectorsFixedSizeCollection> {

    public static ApiFuture<ListDatacenterConnectorsPagedResponse> createAsync(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ApiFuture<ListDatacenterConnectorsResponse> futureResponse) {
      ApiFuture<ListDatacenterConnectorsPage> futurePage =
          ListDatacenterConnectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatacenterConnectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatacenterConnectorsPagedResponse(ListDatacenterConnectorsPage page) {
      super(page, ListDatacenterConnectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatacenterConnectorsPage
      extends AbstractPage<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage> {

    private ListDatacenterConnectorsPage(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ListDatacenterConnectorsResponse response) {
      super(context, response);
    }

    private static ListDatacenterConnectorsPage createEmptyPage() {
      return new ListDatacenterConnectorsPage(null, null);
    }

    @Override
    protected ListDatacenterConnectorsPage createPage(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ListDatacenterConnectorsResponse response) {
      return new ListDatacenterConnectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatacenterConnectorsPage> createPageAsync(
        PageContext<
                ListDatacenterConnectorsRequest,
                ListDatacenterConnectorsResponse,
                DatacenterConnector>
            context,
        ApiFuture<ListDatacenterConnectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatacenterConnectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatacenterConnectorsRequest,
          ListDatacenterConnectorsResponse,
          DatacenterConnector,
          ListDatacenterConnectorsPage,
          ListDatacenterConnectorsFixedSizeCollection> {

    private ListDatacenterConnectorsFixedSizeCollection(
        List<ListDatacenterConnectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatacenterConnectorsFixedSizeCollection createEmptyCollection() {
      return new ListDatacenterConnectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatacenterConnectorsFixedSizeCollection createCollection(
        List<ListDatacenterConnectorsPage> pages, int collectionSize) {
      return new ListDatacenterConnectorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMigratingVmsPagedResponse
      extends AbstractPagedListResponse<
          ListMigratingVmsRequest,
          ListMigratingVmsResponse,
          MigratingVm,
          ListMigratingVmsPage,
          ListMigratingVmsFixedSizeCollection> {

    public static ApiFuture<ListMigratingVmsPagedResponse> createAsync(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ApiFuture<ListMigratingVmsResponse> futureResponse) {
      ApiFuture<ListMigratingVmsPage> futurePage =
          ListMigratingVmsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMigratingVmsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMigratingVmsPagedResponse(ListMigratingVmsPage page) {
      super(page, ListMigratingVmsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMigratingVmsPage
      extends AbstractPage<
          ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm, ListMigratingVmsPage> {

    private ListMigratingVmsPage(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ListMigratingVmsResponse response) {
      super(context, response);
    }

    private static ListMigratingVmsPage createEmptyPage() {
      return new ListMigratingVmsPage(null, null);
    }

    @Override
    protected ListMigratingVmsPage createPage(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ListMigratingVmsResponse response) {
      return new ListMigratingVmsPage(context, response);
    }

    @Override
    public ApiFuture<ListMigratingVmsPage> createPageAsync(
        PageContext<ListMigratingVmsRequest, ListMigratingVmsResponse, MigratingVm> context,
        ApiFuture<ListMigratingVmsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMigratingVmsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMigratingVmsRequest,
          ListMigratingVmsResponse,
          MigratingVm,
          ListMigratingVmsPage,
          ListMigratingVmsFixedSizeCollection> {

    private ListMigratingVmsFixedSizeCollection(
        List<ListMigratingVmsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMigratingVmsFixedSizeCollection createEmptyCollection() {
      return new ListMigratingVmsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMigratingVmsFixedSizeCollection createCollection(
        List<ListMigratingVmsPage> pages, int collectionSize) {
      return new ListMigratingVmsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCloneJobsPagedResponse
      extends AbstractPagedListResponse<
          ListCloneJobsRequest,
          ListCloneJobsResponse,
          CloneJob,
          ListCloneJobsPage,
          ListCloneJobsFixedSizeCollection> {

    public static ApiFuture<ListCloneJobsPagedResponse> createAsync(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ApiFuture<ListCloneJobsResponse> futureResponse) {
      ApiFuture<ListCloneJobsPage> futurePage =
          ListCloneJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloneJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloneJobsPagedResponse(ListCloneJobsPage page) {
      super(page, ListCloneJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloneJobsPage
      extends AbstractPage<
          ListCloneJobsRequest, ListCloneJobsResponse, CloneJob, ListCloneJobsPage> {

    private ListCloneJobsPage(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ListCloneJobsResponse response) {
      super(context, response);
    }

    private static ListCloneJobsPage createEmptyPage() {
      return new ListCloneJobsPage(null, null);
    }

    @Override
    protected ListCloneJobsPage createPage(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ListCloneJobsResponse response) {
      return new ListCloneJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListCloneJobsPage> createPageAsync(
        PageContext<ListCloneJobsRequest, ListCloneJobsResponse, CloneJob> context,
        ApiFuture<ListCloneJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloneJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloneJobsRequest,
          ListCloneJobsResponse,
          CloneJob,
          ListCloneJobsPage,
          ListCloneJobsFixedSizeCollection> {

    private ListCloneJobsFixedSizeCollection(List<ListCloneJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloneJobsFixedSizeCollection createEmptyCollection() {
      return new ListCloneJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloneJobsFixedSizeCollection createCollection(
        List<ListCloneJobsPage> pages, int collectionSize) {
      return new ListCloneJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCutoverJobsPagedResponse
      extends AbstractPagedListResponse<
          ListCutoverJobsRequest,
          ListCutoverJobsResponse,
          CutoverJob,
          ListCutoverJobsPage,
          ListCutoverJobsFixedSizeCollection> {

    public static ApiFuture<ListCutoverJobsPagedResponse> createAsync(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ApiFuture<ListCutoverJobsResponse> futureResponse) {
      ApiFuture<ListCutoverJobsPage> futurePage =
          ListCutoverJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCutoverJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCutoverJobsPagedResponse(ListCutoverJobsPage page) {
      super(page, ListCutoverJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCutoverJobsPage
      extends AbstractPage<
          ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob, ListCutoverJobsPage> {

    private ListCutoverJobsPage(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ListCutoverJobsResponse response) {
      super(context, response);
    }

    private static ListCutoverJobsPage createEmptyPage() {
      return new ListCutoverJobsPage(null, null);
    }

    @Override
    protected ListCutoverJobsPage createPage(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ListCutoverJobsResponse response) {
      return new ListCutoverJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListCutoverJobsPage> createPageAsync(
        PageContext<ListCutoverJobsRequest, ListCutoverJobsResponse, CutoverJob> context,
        ApiFuture<ListCutoverJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCutoverJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCutoverJobsRequest,
          ListCutoverJobsResponse,
          CutoverJob,
          ListCutoverJobsPage,
          ListCutoverJobsFixedSizeCollection> {

    private ListCutoverJobsFixedSizeCollection(
        List<ListCutoverJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCutoverJobsFixedSizeCollection createEmptyCollection() {
      return new ListCutoverJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCutoverJobsFixedSizeCollection createCollection(
        List<ListCutoverJobsPage> pages, int collectionSize) {
      return new ListCutoverJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListGroupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest,
          ListGroupsResponse,
          Group,
          ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetProjectsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage,
          ListTargetProjectsFixedSizeCollection> {

    public static ApiFuture<ListTargetProjectsPagedResponse> createAsync(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ApiFuture<ListTargetProjectsResponse> futureResponse) {
      ApiFuture<ListTargetProjectsPage> futurePage =
          ListTargetProjectsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTargetProjectsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTargetProjectsPagedResponse(ListTargetProjectsPage page) {
      super(page, ListTargetProjectsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetProjectsPage
      extends AbstractPage<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage> {

    private ListTargetProjectsPage(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ListTargetProjectsResponse response) {
      super(context, response);
    }

    private static ListTargetProjectsPage createEmptyPage() {
      return new ListTargetProjectsPage(null, null);
    }

    @Override
    protected ListTargetProjectsPage createPage(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ListTargetProjectsResponse response) {
      return new ListTargetProjectsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetProjectsPage> createPageAsync(
        PageContext<ListTargetProjectsRequest, ListTargetProjectsResponse, TargetProject> context,
        ApiFuture<ListTargetProjectsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetProjectsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetProjectsRequest,
          ListTargetProjectsResponse,
          TargetProject,
          ListTargetProjectsPage,
          ListTargetProjectsFixedSizeCollection> {

    private ListTargetProjectsFixedSizeCollection(
        List<ListTargetProjectsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetProjectsFixedSizeCollection createEmptyCollection() {
      return new ListTargetProjectsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetProjectsFixedSizeCollection createCollection(
        List<ListTargetProjectsPage> pages, int collectionSize) {
      return new ListTargetProjectsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReplicationCyclesPagedResponse
      extends AbstractPagedListResponse<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ReplicationCycle,
          ListReplicationCyclesPage,
          ListReplicationCyclesFixedSizeCollection> {

    public static ApiFuture<ListReplicationCyclesPagedResponse> createAsync(
        PageContext<ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
            context,
        ApiFuture<ListReplicationCyclesResponse> futureResponse) {
      ApiFuture<ListReplicationCyclesPage> futurePage =
          ListReplicationCyclesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReplicationCyclesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReplicationCyclesPagedResponse(ListReplicationCyclesPage page) {
      super(page, ListReplicationCyclesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReplicationCyclesPage
      extends AbstractPage<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ReplicationCycle,
          ListReplicationCyclesPage> {

    private ListReplicationCyclesPage(
        PageContext<ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
            context,
        ListReplicationCyclesResponse response) {
      super(context, response);
    }

    private static ListReplicationCyclesPage createEmptyPage() {
      return new ListReplicationCyclesPage(null, null);
    }

    @Override
    protected ListReplicationCyclesPage createPage(
        PageContext<ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
            context,
        ListReplicationCyclesResponse response) {
      return new ListReplicationCyclesPage(context, response);
    }

    @Override
    public ApiFuture<ListReplicationCyclesPage> createPageAsync(
        PageContext<ListReplicationCyclesRequest, ListReplicationCyclesResponse, ReplicationCycle>
            context,
        ApiFuture<ListReplicationCyclesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReplicationCyclesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReplicationCyclesRequest,
          ListReplicationCyclesResponse,
          ReplicationCycle,
          ListReplicationCyclesPage,
          ListReplicationCyclesFixedSizeCollection> {

    private ListReplicationCyclesFixedSizeCollection(
        List<ListReplicationCyclesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReplicationCyclesFixedSizeCollection createEmptyCollection() {
      return new ListReplicationCyclesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReplicationCyclesFixedSizeCollection createCollection(
        List<ListReplicationCyclesPage> pages, int collectionSize) {
      return new ListReplicationCyclesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListImageImportsPagedResponse
      extends AbstractPagedListResponse<
          ListImageImportsRequest,
          ListImageImportsResponse,
          ImageImport,
          ListImageImportsPage,
          ListImageImportsFixedSizeCollection> {

    public static ApiFuture<ListImageImportsPagedResponse> createAsync(
        PageContext<ListImageImportsRequest, ListImageImportsResponse, ImageImport> context,
        ApiFuture<ListImageImportsResponse> futureResponse) {
      ApiFuture<ListImageImportsPage> futurePage =
          ListImageImportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImageImportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImageImportsPagedResponse(ListImageImportsPage page) {
      super(page, ListImageImportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImageImportsPage
      extends AbstractPage<
          ListImageImportsRequest, ListImageImportsResponse, ImageImport, ListImageImportsPage> {

    private ListImageImportsPage(
        PageContext<ListImageImportsRequest, ListImageImportsResponse, ImageImport> context,
        ListImageImportsResponse response) {
      super(context, response);
    }

    private static ListImageImportsPage createEmptyPage() {
      return new ListImageImportsPage(null, null);
    }

    @Override
    protected ListImageImportsPage createPage(
        PageContext<ListImageImportsRequest, ListImageImportsResponse, ImageImport> context,
        ListImageImportsResponse response) {
      return new ListImageImportsPage(context, response);
    }

    @Override
    public ApiFuture<ListImageImportsPage> createPageAsync(
        PageContext<ListImageImportsRequest, ListImageImportsResponse, ImageImport> context,
        ApiFuture<ListImageImportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImageImportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImageImportsRequest,
          ListImageImportsResponse,
          ImageImport,
          ListImageImportsPage,
          ListImageImportsFixedSizeCollection> {

    private ListImageImportsFixedSizeCollection(
        List<ListImageImportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImageImportsFixedSizeCollection createEmptyCollection() {
      return new ListImageImportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImageImportsFixedSizeCollection createCollection(
        List<ListImageImportsPage> pages, int collectionSize) {
      return new ListImageImportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListImageImportJobsPagedResponse
      extends AbstractPagedListResponse<
          ListImageImportJobsRequest,
          ListImageImportJobsResponse,
          ImageImportJob,
          ListImageImportJobsPage,
          ListImageImportJobsFixedSizeCollection> {

    public static ApiFuture<ListImageImportJobsPagedResponse> createAsync(
        PageContext<ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
            context,
        ApiFuture<ListImageImportJobsResponse> futureResponse) {
      ApiFuture<ListImageImportJobsPage> futurePage =
          ListImageImportJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImageImportJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImageImportJobsPagedResponse(ListImageImportJobsPage page) {
      super(page, ListImageImportJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImageImportJobsPage
      extends AbstractPage<
          ListImageImportJobsRequest,
          ListImageImportJobsResponse,
          ImageImportJob,
          ListImageImportJobsPage> {

    private ListImageImportJobsPage(
        PageContext<ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
            context,
        ListImageImportJobsResponse response) {
      super(context, response);
    }

    private static ListImageImportJobsPage createEmptyPage() {
      return new ListImageImportJobsPage(null, null);
    }

    @Override
    protected ListImageImportJobsPage createPage(
        PageContext<ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
            context,
        ListImageImportJobsResponse response) {
      return new ListImageImportJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListImageImportJobsPage> createPageAsync(
        PageContext<ListImageImportJobsRequest, ListImageImportJobsResponse, ImageImportJob>
            context,
        ApiFuture<ListImageImportJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImageImportJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImageImportJobsRequest,
          ListImageImportJobsResponse,
          ImageImportJob,
          ListImageImportJobsPage,
          ListImageImportJobsFixedSizeCollection> {

    private ListImageImportJobsFixedSizeCollection(
        List<ListImageImportJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImageImportJobsFixedSizeCollection createEmptyCollection() {
      return new ListImageImportJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImageImportJobsFixedSizeCollection createCollection(
        List<ListImageImportJobsPage> pages, int collectionSize) {
      return new ListImageImportJobsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiskMigrationJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          DiskMigrationJob,
          ListDiskMigrationJobsPage,
          ListDiskMigrationJobsFixedSizeCollection> {

    public static ApiFuture<ListDiskMigrationJobsPagedResponse> createAsync(
        PageContext<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
            context,
        ApiFuture<ListDiskMigrationJobsResponse> futureResponse) {
      ApiFuture<ListDiskMigrationJobsPage> futurePage =
          ListDiskMigrationJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiskMigrationJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiskMigrationJobsPagedResponse(ListDiskMigrationJobsPage page) {
      super(page, ListDiskMigrationJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiskMigrationJobsPage
      extends AbstractPage<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          DiskMigrationJob,
          ListDiskMigrationJobsPage> {

    private ListDiskMigrationJobsPage(
        PageContext<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
            context,
        ListDiskMigrationJobsResponse response) {
      super(context, response);
    }

    private static ListDiskMigrationJobsPage createEmptyPage() {
      return new ListDiskMigrationJobsPage(null, null);
    }

    @Override
    protected ListDiskMigrationJobsPage createPage(
        PageContext<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
            context,
        ListDiskMigrationJobsResponse response) {
      return new ListDiskMigrationJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListDiskMigrationJobsPage> createPageAsync(
        PageContext<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse, DiskMigrationJob>
            context,
        ApiFuture<ListDiskMigrationJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiskMigrationJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiskMigrationJobsRequest,
          ListDiskMigrationJobsResponse,
          DiskMigrationJob,
          ListDiskMigrationJobsPage,
          ListDiskMigrationJobsFixedSizeCollection> {

    private ListDiskMigrationJobsFixedSizeCollection(
        List<ListDiskMigrationJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiskMigrationJobsFixedSizeCollection createEmptyCollection() {
      return new ListDiskMigrationJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiskMigrationJobsFixedSizeCollection createCollection(
        List<ListDiskMigrationJobsPage> pages, int collectionSize) {
      return new ListDiskMigrationJobsFixedSizeCollection(pages, collectionSize);
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
