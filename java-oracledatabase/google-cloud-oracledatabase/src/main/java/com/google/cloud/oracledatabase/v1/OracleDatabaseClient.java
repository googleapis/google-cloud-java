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

package com.google.cloud.oracledatabase.v1;

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
import com.google.cloud.oracledatabase.v1.stub.OracleDatabaseStub;
import com.google.cloud.oracledatabase.v1.stub.OracleDatabaseStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
 *   CloudExadataInfrastructureName name =
 *       CloudExadataInfrastructureName.of(
 *           "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
 *   CloudExadataInfrastructure response =
 *       oracleDatabaseClient.getCloudExadataInfrastructure(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OracleDatabaseClient object to clean up resources such
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
 *      <td><p> ListCloudExadataInfrastructures</td>
 *      <td><p> Lists Exadata Infrastructures in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloudExadataInfrastructures(ListCloudExadataInfrastructuresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloudExadataInfrastructures(LocationName parent)
 *           <li><p> listCloudExadataInfrastructures(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloudExadataInfrastructuresPagedCallable()
 *           <li><p> listCloudExadataInfrastructuresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloudExadataInfrastructure</td>
 *      <td><p> Gets details of a single Exadata Infrastructure.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloudExadataInfrastructure(GetCloudExadataInfrastructureRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloudExadataInfrastructure(CloudExadataInfrastructureName name)
 *           <li><p> getCloudExadataInfrastructure(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloudExadataInfrastructureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCloudExadataInfrastructure</td>
 *      <td><p> Creates a new Exadata Infrastructure in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCloudExadataInfrastructureAsync(CreateCloudExadataInfrastructureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCloudExadataInfrastructureAsync(LocationName parent, CloudExadataInfrastructure cloudExadataInfrastructure, String cloudExadataInfrastructureId)
 *           <li><p> createCloudExadataInfrastructureAsync(String parent, CloudExadataInfrastructure cloudExadataInfrastructure, String cloudExadataInfrastructureId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCloudExadataInfrastructureOperationCallable()
 *           <li><p> createCloudExadataInfrastructureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCloudExadataInfrastructure</td>
 *      <td><p> Deletes a single Exadata Infrastructure.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCloudExadataInfrastructureAsync(DeleteCloudExadataInfrastructureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCloudExadataInfrastructureAsync(CloudExadataInfrastructureName name)
 *           <li><p> deleteCloudExadataInfrastructureAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCloudExadataInfrastructureOperationCallable()
 *           <li><p> deleteCloudExadataInfrastructureCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCloudVmClusters</td>
 *      <td><p> Lists the VM Clusters in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloudVmClusters(ListCloudVmClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloudVmClusters(LocationName parent)
 *           <li><p> listCloudVmClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloudVmClustersPagedCallable()
 *           <li><p> listCloudVmClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloudVmCluster</td>
 *      <td><p> Gets details of a single VM Cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloudVmCluster(GetCloudVmClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloudVmCluster(CloudVmClusterName name)
 *           <li><p> getCloudVmCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloudVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCloudVmCluster</td>
 *      <td><p> Creates a new VM Cluster in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCloudVmClusterAsync(CreateCloudVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createCloudVmClusterAsync(LocationName parent, CloudVmCluster cloudVmCluster, String cloudVmClusterId)
 *           <li><p> createCloudVmClusterAsync(String parent, CloudVmCluster cloudVmCluster, String cloudVmClusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCloudVmClusterOperationCallable()
 *           <li><p> createCloudVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCloudVmCluster</td>
 *      <td><p> Deletes a single VM Cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCloudVmClusterAsync(DeleteCloudVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCloudVmClusterAsync(CloudVmClusterName name)
 *           <li><p> deleteCloudVmClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCloudVmClusterOperationCallable()
 *           <li><p> deleteCloudVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntitlements</td>
 *      <td><p> Lists the entitlements in a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntitlements(ListEntitlementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntitlements(LocationName parent)
 *           <li><p> listEntitlements(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntitlementsPagedCallable()
 *           <li><p> listEntitlementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbServers</td>
 *      <td><p> Lists the database servers of an Exadata Infrastructure instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbServers(ListDbServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbServers(CloudExadataInfrastructureName parent)
 *           <li><p> listDbServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbServersPagedCallable()
 *           <li><p> listDbServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbNodes</td>
 *      <td><p> Lists the database nodes of a VM Cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbNodes(ListDbNodesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbNodes(CloudVmClusterName parent)
 *           <li><p> listDbNodes(ExadbVmClusterName parent)
 *           <li><p> listDbNodes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbNodesPagedCallable()
 *           <li><p> listDbNodesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGiVersions</td>
 *      <td><p> Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGiVersions(ListGiVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGiVersions(LocationName parent)
 *           <li><p> listGiVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGiVersionsPagedCallable()
 *           <li><p> listGiVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMinorVersions</td>
 *      <td><p> Lists all the valid minor versions for the given project, location, gi version and shape family.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMinorVersions(ListMinorVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMinorVersions(GiVersionName parent)
 *           <li><p> listMinorVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMinorVersionsPagedCallable()
 *           <li><p> listMinorVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbSystemShapes</td>
 *      <td><p> Lists the database system shapes available for the project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbSystemShapes(ListDbSystemShapesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbSystemShapes(LocationName parent)
 *           <li><p> listDbSystemShapes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbSystemShapesPagedCallable()
 *           <li><p> listDbSystemShapesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutonomousDatabases</td>
 *      <td><p> Lists the Autonomous Databases in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabases(ListAutonomousDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabases(LocationName parent)
 *           <li><p> listAutonomousDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabasesPagedCallable()
 *           <li><p> listAutonomousDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAutonomousDatabase</td>
 *      <td><p> Gets the details of a single Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutonomousDatabase(GetAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutonomousDatabase(AutonomousDatabaseName name)
 *           <li><p> getAutonomousDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAutonomousDatabase</td>
 *      <td><p> Creates a new Autonomous Database in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAutonomousDatabaseAsync(CreateAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAutonomousDatabaseAsync(LocationName parent, AutonomousDatabase autonomousDatabase, String autonomousDatabaseId)
 *           <li><p> createAutonomousDatabaseAsync(String parent, AutonomousDatabase autonomousDatabase, String autonomousDatabaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAutonomousDatabaseOperationCallable()
 *           <li><p> createAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutonomousDatabase</td>
 *      <td><p> Updates the parameters of a single Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutonomousDatabaseAsync(UpdateAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAutonomousDatabaseAsync(AutonomousDatabase autonomousDatabase, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutonomousDatabaseOperationCallable()
 *           <li><p> updateAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAutonomousDatabase</td>
 *      <td><p> Deletes a single Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAutonomousDatabaseAsync(DeleteAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAutonomousDatabaseAsync(AutonomousDatabaseName name)
 *           <li><p> deleteAutonomousDatabaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAutonomousDatabaseOperationCallable()
 *           <li><p> deleteAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreAutonomousDatabase</td>
 *      <td><p> Restores a single Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreAutonomousDatabaseAsync(RestoreAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreAutonomousDatabaseAsync(AutonomousDatabaseName name, Timestamp restoreTime)
 *           <li><p> restoreAutonomousDatabaseAsync(String name, Timestamp restoreTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreAutonomousDatabaseOperationCallable()
 *           <li><p> restoreAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateAutonomousDatabaseWallet</td>
 *      <td><p> Generates a wallet for an Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateAutonomousDatabaseWallet(GenerateAutonomousDatabaseWalletRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateAutonomousDatabaseWallet(AutonomousDatabaseName name, GenerateType type, boolean isRegional, String password)
 *           <li><p> generateAutonomousDatabaseWallet(String name, GenerateType type, boolean isRegional, String password)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateAutonomousDatabaseWalletCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutonomousDbVersions</td>
 *      <td><p> Lists all the available Autonomous Database versions for a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutonomousDbVersions(ListAutonomousDbVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutonomousDbVersions(LocationName parent)
 *           <li><p> listAutonomousDbVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutonomousDbVersionsPagedCallable()
 *           <li><p> listAutonomousDbVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutonomousDatabaseCharacterSets</td>
 *      <td><p> Lists Autonomous Database Character Sets in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseCharacterSets(ListAutonomousDatabaseCharacterSetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseCharacterSets(LocationName parent)
 *           <li><p> listAutonomousDatabaseCharacterSets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseCharacterSetsPagedCallable()
 *           <li><p> listAutonomousDatabaseCharacterSetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutonomousDatabaseBackups</td>
 *      <td><p> Lists the long-term and automatic backups of an Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseBackups(ListAutonomousDatabaseBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseBackups(LocationName parent)
 *           <li><p> listAutonomousDatabaseBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutonomousDatabaseBackupsPagedCallable()
 *           <li><p> listAutonomousDatabaseBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopAutonomousDatabase</td>
 *      <td><p> Stops an Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopAutonomousDatabaseAsync(StopAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> stopAutonomousDatabaseAsync(AutonomousDatabaseName name)
 *           <li><p> stopAutonomousDatabaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopAutonomousDatabaseOperationCallable()
 *           <li><p> stopAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartAutonomousDatabase</td>
 *      <td><p> Starts an Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startAutonomousDatabaseAsync(StartAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startAutonomousDatabaseAsync(AutonomousDatabaseName name)
 *           <li><p> startAutonomousDatabaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startAutonomousDatabaseOperationCallable()
 *           <li><p> startAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestartAutonomousDatabase</td>
 *      <td><p> Restarts an Autonomous Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restartAutonomousDatabaseAsync(RestartAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restartAutonomousDatabaseAsync(AutonomousDatabaseName name)
 *           <li><p> restartAutonomousDatabaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restartAutonomousDatabaseOperationCallable()
 *           <li><p> restartAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SwitchoverAutonomousDatabase</td>
 *      <td><p> Initiates a switchover of specified autonomous database to the associated peer database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> switchoverAutonomousDatabaseAsync(SwitchoverAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> switchoverAutonomousDatabaseAsync(AutonomousDatabaseName name, AutonomousDatabaseName peerAutonomousDatabase)
 *           <li><p> switchoverAutonomousDatabaseAsync(AutonomousDatabaseName name, String peerAutonomousDatabase)
 *           <li><p> switchoverAutonomousDatabaseAsync(String name, AutonomousDatabaseName peerAutonomousDatabase)
 *           <li><p> switchoverAutonomousDatabaseAsync(String name, String peerAutonomousDatabase)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> switchoverAutonomousDatabaseOperationCallable()
 *           <li><p> switchoverAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FailoverAutonomousDatabase</td>
 *      <td><p> Initiates a failover to target autonomous database from the associated primary database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> failoverAutonomousDatabaseAsync(FailoverAutonomousDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> failoverAutonomousDatabaseAsync(AutonomousDatabaseName name, AutonomousDatabaseName peerAutonomousDatabase)
 *           <li><p> failoverAutonomousDatabaseAsync(AutonomousDatabaseName name, String peerAutonomousDatabase)
 *           <li><p> failoverAutonomousDatabaseAsync(String name, AutonomousDatabaseName peerAutonomousDatabase)
 *           <li><p> failoverAutonomousDatabaseAsync(String name, String peerAutonomousDatabase)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> failoverAutonomousDatabaseOperationCallable()
 *           <li><p> failoverAutonomousDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOdbNetworks</td>
 *      <td><p> Lists the ODB Networks in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOdbNetworks(ListOdbNetworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOdbNetworks(LocationName parent)
 *           <li><p> listOdbNetworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOdbNetworksPagedCallable()
 *           <li><p> listOdbNetworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOdbNetwork</td>
 *      <td><p> Gets details of a single ODB Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOdbNetwork(GetOdbNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOdbNetwork(OdbNetworkName name)
 *           <li><p> getOdbNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOdbNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOdbNetwork</td>
 *      <td><p> Creates a new ODB Network in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOdbNetworkAsync(CreateOdbNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOdbNetworkAsync(LocationName parent, OdbNetwork odbNetwork, String odbNetworkId)
 *           <li><p> createOdbNetworkAsync(String parent, OdbNetwork odbNetwork, String odbNetworkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOdbNetworkOperationCallable()
 *           <li><p> createOdbNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOdbNetwork</td>
 *      <td><p> Deletes a single ODB Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOdbNetworkAsync(DeleteOdbNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteOdbNetworkAsync(OdbNetworkName name)
 *           <li><p> deleteOdbNetworkAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOdbNetworkOperationCallable()
 *           <li><p> deleteOdbNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOdbSubnets</td>
 *      <td><p> Lists all the ODB Subnets in a given ODB Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOdbSubnets(ListOdbSubnetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOdbSubnets(OdbNetworkName parent)
 *           <li><p> listOdbSubnets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOdbSubnetsPagedCallable()
 *           <li><p> listOdbSubnetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOdbSubnet</td>
 *      <td><p> Gets details of a single ODB Subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOdbSubnet(GetOdbSubnetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOdbSubnet(OdbSubnetName name)
 *           <li><p> getOdbSubnet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOdbSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOdbSubnet</td>
 *      <td><p> Creates a new ODB Subnet in a given ODB Network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOdbSubnetAsync(CreateOdbSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOdbSubnetAsync(OdbNetworkName parent, OdbSubnet odbSubnet, String odbSubnetId)
 *           <li><p> createOdbSubnetAsync(String parent, OdbSubnet odbSubnet, String odbSubnetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOdbSubnetOperationCallable()
 *           <li><p> createOdbSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteOdbSubnet</td>
 *      <td><p> Deletes a single ODB Subnet.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteOdbSubnetAsync(DeleteOdbSubnetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteOdbSubnetAsync(OdbSubnetName name)
 *           <li><p> deleteOdbSubnetAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOdbSubnetOperationCallable()
 *           <li><p> deleteOdbSubnetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExadbVmClusters</td>
 *      <td><p> Lists all the Exadb (Exascale) VM Clusters for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExadbVmClusters(ListExadbVmClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExadbVmClusters(LocationName parent)
 *           <li><p> listExadbVmClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExadbVmClustersPagedCallable()
 *           <li><p> listExadbVmClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExadbVmCluster</td>
 *      <td><p> Gets details of a single Exadb (Exascale) VM Cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExadbVmCluster(GetExadbVmClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExadbVmCluster(ExadbVmClusterName name)
 *           <li><p> getExadbVmCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExadbVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExadbVmCluster</td>
 *      <td><p> Creates a new Exadb (Exascale) VM Cluster resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExadbVmClusterAsync(CreateExadbVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createExadbVmClusterAsync(LocationName parent, ExadbVmCluster exadbVmCluster, String exadbVmClusterId)
 *           <li><p> createExadbVmClusterAsync(String parent, ExadbVmCluster exadbVmCluster, String exadbVmClusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExadbVmClusterOperationCallable()
 *           <li><p> createExadbVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExadbVmCluster</td>
 *      <td><p> Deletes a single Exadb (Exascale) VM Cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExadbVmClusterAsync(DeleteExadbVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExadbVmClusterAsync(ExadbVmClusterName name)
 *           <li><p> deleteExadbVmClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExadbVmClusterOperationCallable()
 *           <li><p> deleteExadbVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExadbVmCluster</td>
 *      <td><p> Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to existing exadb vm cluster, only pass the node count.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExadbVmClusterAsync(UpdateExadbVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateExadbVmClusterAsync(ExadbVmCluster exadbVmCluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExadbVmClusterOperationCallable()
 *           <li><p> updateExadbVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveVirtualMachineExadbVmCluster</td>
 *      <td><p> Removes virtual machines from an existing exadb vm cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeVirtualMachineExadbVmClusterAsync(RemoveVirtualMachineExadbVmClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> removeVirtualMachineExadbVmClusterAsync(ExadbVmClusterName name, List&lt;String&gt; hostnames)
 *           <li><p> removeVirtualMachineExadbVmClusterAsync(String name, List&lt;String&gt; hostnames)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeVirtualMachineExadbVmClusterOperationCallable()
 *           <li><p> removeVirtualMachineExadbVmClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExascaleDbStorageVaults</td>
 *      <td><p> Lists all the ExascaleDB Storage Vaults for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExascaleDbStorageVaults(ListExascaleDbStorageVaultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExascaleDbStorageVaults(LocationName parent)
 *           <li><p> listExascaleDbStorageVaults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExascaleDbStorageVaultsPagedCallable()
 *           <li><p> listExascaleDbStorageVaultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExascaleDbStorageVault</td>
 *      <td><p> Gets details of a single ExascaleDB Storage Vault.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExascaleDbStorageVault(GetExascaleDbStorageVaultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExascaleDbStorageVault(ExascaleDbStorageVaultName name)
 *           <li><p> getExascaleDbStorageVault(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExascaleDbStorageVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExascaleDbStorageVault</td>
 *      <td><p> Creates a new ExascaleDB Storage Vault resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExascaleDbStorageVaultAsync(CreateExascaleDbStorageVaultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createExascaleDbStorageVaultAsync(LocationName parent, ExascaleDbStorageVault exascaleDbStorageVault, String exascaleDbStorageVaultId)
 *           <li><p> createExascaleDbStorageVaultAsync(String parent, ExascaleDbStorageVault exascaleDbStorageVault, String exascaleDbStorageVaultId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExascaleDbStorageVaultOperationCallable()
 *           <li><p> createExascaleDbStorageVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExascaleDbStorageVault</td>
 *      <td><p> Deletes a single ExascaleDB Storage Vault.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExascaleDbStorageVaultAsync(DeleteExascaleDbStorageVaultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExascaleDbStorageVaultAsync(ExascaleDbStorageVaultName name)
 *           <li><p> deleteExascaleDbStorageVaultAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExascaleDbStorageVaultOperationCallable()
 *           <li><p> deleteExascaleDbStorageVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbSystemInitialStorageSizes</td>
 *      <td><p> Lists all the DbSystemInitialStorageSizes for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbSystemInitialStorageSizes(ListDbSystemInitialStorageSizesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbSystemInitialStorageSizes(LocationName parent)
 *           <li><p> listDbSystemInitialStorageSizes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbSystemInitialStorageSizesPagedCallable()
 *           <li><p> listDbSystemInitialStorageSizesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatabases</td>
 *      <td><p> Lists all the Databases for the given project, location and DbSystem.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabases(ListDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabases(LocationName parent)
 *           <li><p> listDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabasesPagedCallable()
 *           <li><p> listDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatabase</td>
 *      <td><p> Gets details of a single Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatabase(GetDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatabase(DatabaseName name)
 *           <li><p> getDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPluggableDatabases</td>
 *      <td><p> Lists all the PluggableDatabases for the given project, location and Container Database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPluggableDatabases(ListPluggableDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPluggableDatabases(LocationName parent)
 *           <li><p> listPluggableDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPluggableDatabasesPagedCallable()
 *           <li><p> listPluggableDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPluggableDatabase</td>
 *      <td><p> Gets details of a single PluggableDatabase.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPluggableDatabase(GetPluggableDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPluggableDatabase(PluggableDatabaseName name)
 *           <li><p> getPluggableDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPluggableDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbSystems</td>
 *      <td><p> Lists all the DbSystems for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbSystems(ListDbSystemsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbSystems(LocationName parent)
 *           <li><p> listDbSystems(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbSystemsPagedCallable()
 *           <li><p> listDbSystemsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDbSystem</td>
 *      <td><p> Gets details of a single DbSystem.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDbSystem(GetDbSystemRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDbSystem(DbSystemName name)
 *           <li><p> getDbSystem(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDbSystemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDbSystem</td>
 *      <td><p> Creates a new DbSystem in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDbSystemAsync(CreateDbSystemRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDbSystemAsync(LocationName parent, DbSystem dbSystem, String dbSystemId)
 *           <li><p> createDbSystemAsync(String parent, DbSystem dbSystem, String dbSystemId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDbSystemOperationCallable()
 *           <li><p> createDbSystemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDbSystem</td>
 *      <td><p> Deletes a single DbSystem.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDbSystemAsync(DeleteDbSystemRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDbSystemAsync(DbSystemName name)
 *           <li><p> deleteDbSystemAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDbSystemOperationCallable()
 *           <li><p> deleteDbSystemCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDbVersions</td>
 *      <td><p> List DbVersions for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDbVersions(ListDbVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDbVersions(LocationName parent)
 *           <li><p> listDbVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDbVersionsPagedCallable()
 *           <li><p> listDbVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatabaseCharacterSets</td>
 *      <td><p> List DatabaseCharacterSets for the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabaseCharacterSets(ListDatabaseCharacterSetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabaseCharacterSets(LocationName parent)
 *           <li><p> listDatabaseCharacterSets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabaseCharacterSetsPagedCallable()
 *           <li><p> listDatabaseCharacterSetsCallable()
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
 * <p>This class can be customized by passing in a custom instance of OracleDatabaseSettings to
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
 * OracleDatabaseSettings oracleDatabaseSettings =
 *     OracleDatabaseSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create(oracleDatabaseSettings);
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
 * OracleDatabaseSettings oracleDatabaseSettings =
 *     OracleDatabaseSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create(oracleDatabaseSettings);
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
 * OracleDatabaseSettings oracleDatabaseSettings =
 *     OracleDatabaseSettings.newHttpJsonBuilder().build();
 * OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create(oracleDatabaseSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OracleDatabaseClient implements BackgroundResource {
  private final OracleDatabaseSettings settings;
  private final OracleDatabaseStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of OracleDatabaseClient with default settings. */
  public static final OracleDatabaseClient create() throws IOException {
    return create(OracleDatabaseSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OracleDatabaseClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OracleDatabaseClient create(OracleDatabaseSettings settings)
      throws IOException {
    return new OracleDatabaseClient(settings);
  }

  /**
   * Constructs an instance of OracleDatabaseClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(OracleDatabaseSettings).
   */
  public static final OracleDatabaseClient create(OracleDatabaseStub stub) {
    return new OracleDatabaseClient(stub);
  }

  /**
   * Constructs an instance of OracleDatabaseClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OracleDatabaseClient(OracleDatabaseSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OracleDatabaseStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected OracleDatabaseClient(OracleDatabaseStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final OracleDatabaseSettings getSettings() {
    return settings;
  }

  public OracleDatabaseStub getStub() {
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
   * Lists Exadata Infrastructures in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CloudExadataInfrastructure element :
   *       oracleDatabaseClient.listCloudExadataInfrastructures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for CloudExadataInfrastructure in the following
   *     format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudExadataInfrastructuresPagedResponse listCloudExadataInfrastructures(
      LocationName parent) {
    ListCloudExadataInfrastructuresRequest request =
        ListCloudExadataInfrastructuresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloudExadataInfrastructures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Exadata Infrastructures in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CloudExadataInfrastructure element :
   *       oracleDatabaseClient.listCloudExadataInfrastructures(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for CloudExadataInfrastructure in the following
   *     format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudExadataInfrastructuresPagedResponse listCloudExadataInfrastructures(
      String parent) {
    ListCloudExadataInfrastructuresRequest request =
        ListCloudExadataInfrastructuresRequest.newBuilder().setParent(parent).build();
    return listCloudExadataInfrastructures(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Exadata Infrastructures in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudExadataInfrastructuresRequest request =
   *       ListCloudExadataInfrastructuresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (CloudExadataInfrastructure element :
   *       oracleDatabaseClient.listCloudExadataInfrastructures(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudExadataInfrastructuresPagedResponse listCloudExadataInfrastructures(
      ListCloudExadataInfrastructuresRequest request) {
    return listCloudExadataInfrastructuresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Exadata Infrastructures in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudExadataInfrastructuresRequest request =
   *       ListCloudExadataInfrastructuresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<CloudExadataInfrastructure> future =
   *       oracleDatabaseClient.listCloudExadataInfrastructuresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudExadataInfrastructure element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresPagedResponse>
      listCloudExadataInfrastructuresPagedCallable() {
    return stub.listCloudExadataInfrastructuresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Exadata Infrastructures in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudExadataInfrastructuresRequest request =
   *       ListCloudExadataInfrastructuresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListCloudExadataInfrastructuresResponse response =
   *         oracleDatabaseClient.listCloudExadataInfrastructuresCallable().call(request);
   *     for (CloudExadataInfrastructure element : response.getCloudExadataInfrastructuresList()) {
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
          ListCloudExadataInfrastructuresRequest, ListCloudExadataInfrastructuresResponse>
      listCloudExadataInfrastructuresCallable() {
    return stub.listCloudExadataInfrastructuresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudExadataInfrastructureName name =
   *       CloudExadataInfrastructureName.of(
   *           "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient.getCloudExadataInfrastructure(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud Exadata Infrastructure in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloud_exadata_infrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudExadataInfrastructure getCloudExadataInfrastructure(
      CloudExadataInfrastructureName name) {
    GetCloudExadataInfrastructureRequest request =
        GetCloudExadataInfrastructureRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCloudExadataInfrastructure(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       CloudExadataInfrastructureName.of(
   *               "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *           .toString();
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient.getCloudExadataInfrastructure(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud Exadata Infrastructure in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloud_exadata_infrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudExadataInfrastructure getCloudExadataInfrastructure(String name) {
    GetCloudExadataInfrastructureRequest request =
        GetCloudExadataInfrastructureRequest.newBuilder().setName(name).build();
    return getCloudExadataInfrastructure(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetCloudExadataInfrastructureRequest request =
   *       GetCloudExadataInfrastructureRequest.newBuilder()
   *           .setName(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .build();
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient.getCloudExadataInfrastructure(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudExadataInfrastructure getCloudExadataInfrastructure(
      GetCloudExadataInfrastructureRequest request) {
    return getCloudExadataInfrastructureCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetCloudExadataInfrastructureRequest request =
   *       GetCloudExadataInfrastructureRequest.newBuilder()
   *           .setName(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CloudExadataInfrastructure> future =
   *       oracleDatabaseClient.getCloudExadataInfrastructureCallable().futureCall(request);
   *   // Do something.
   *   CloudExadataInfrastructure response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloudExadataInfrastructureRequest, CloudExadataInfrastructure>
      getCloudExadataInfrastructureCallable() {
    return stub.getCloudExadataInfrastructureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadata Infrastructure in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CloudExadataInfrastructure cloudExadataInfrastructure =
   *       CloudExadataInfrastructure.newBuilder().build();
   *   String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient
   *           .createCloudExadataInfrastructureAsync(
   *               parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for CloudExadataInfrastructure in the following
   *     format: projects/{project}/locations/{location}.
   * @param cloudExadataInfrastructure Required. Details of the Exadata Infrastructure instance to
   *     create.
   * @param cloudExadataInfrastructureId Required. The ID of the Exadata Infrastructure to create.
   *     This value is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63
   *     characters in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureAsync(
          LocationName parent,
          CloudExadataInfrastructure cloudExadataInfrastructure,
          String cloudExadataInfrastructureId) {
    CreateCloudExadataInfrastructureRequest request =
        CreateCloudExadataInfrastructureRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCloudExadataInfrastructure(cloudExadataInfrastructure)
            .setCloudExadataInfrastructureId(cloudExadataInfrastructureId)
            .build();
    return createCloudExadataInfrastructureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadata Infrastructure in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CloudExadataInfrastructure cloudExadataInfrastructure =
   *       CloudExadataInfrastructure.newBuilder().build();
   *   String cloudExadataInfrastructureId = "cloudExadataInfrastructureId975345409";
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient
   *           .createCloudExadataInfrastructureAsync(
   *               parent, cloudExadataInfrastructure, cloudExadataInfrastructureId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for CloudExadataInfrastructure in the following
   *     format: projects/{project}/locations/{location}.
   * @param cloudExadataInfrastructure Required. Details of the Exadata Infrastructure instance to
   *     create.
   * @param cloudExadataInfrastructureId Required. The ID of the Exadata Infrastructure to create.
   *     This value is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63
   *     characters in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureAsync(
          String parent,
          CloudExadataInfrastructure cloudExadataInfrastructure,
          String cloudExadataInfrastructureId) {
    CreateCloudExadataInfrastructureRequest request =
        CreateCloudExadataInfrastructureRequest.newBuilder()
            .setParent(parent)
            .setCloudExadataInfrastructure(cloudExadataInfrastructure)
            .setCloudExadataInfrastructureId(cloudExadataInfrastructureId)
            .build();
    return createCloudExadataInfrastructureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadata Infrastructure in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudExadataInfrastructureRequest request =
   *       CreateCloudExadataInfrastructureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudExadataInfrastructureId("cloudExadataInfrastructureId975345409")
   *           .setCloudExadataInfrastructure(CloudExadataInfrastructure.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CloudExadataInfrastructure response =
   *       oracleDatabaseClient.createCloudExadataInfrastructureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureAsync(CreateCloudExadataInfrastructureRequest request) {
    return createCloudExadataInfrastructureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadata Infrastructure in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudExadataInfrastructureRequest request =
   *       CreateCloudExadataInfrastructureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudExadataInfrastructureId("cloudExadataInfrastructureId975345409")
   *           .setCloudExadataInfrastructure(CloudExadataInfrastructure.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CloudExadataInfrastructure, OperationMetadata> future =
   *       oracleDatabaseClient
   *           .createCloudExadataInfrastructureOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CloudExadataInfrastructure response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateCloudExadataInfrastructureRequest, CloudExadataInfrastructure, OperationMetadata>
      createCloudExadataInfrastructureOperationCallable() {
    return stub.createCloudExadataInfrastructureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadata Infrastructure in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudExadataInfrastructureRequest request =
   *       CreateCloudExadataInfrastructureRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudExadataInfrastructureId("cloudExadataInfrastructureId975345409")
   *           .setCloudExadataInfrastructure(CloudExadataInfrastructure.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createCloudExadataInfrastructureCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCloudExadataInfrastructureRequest, Operation>
      createCloudExadataInfrastructureCallable() {
    return stub.createCloudExadataInfrastructureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudExadataInfrastructureName name =
   *       CloudExadataInfrastructureName.of(
   *           "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
   *   oracleDatabaseClient.deleteCloudExadataInfrastructureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud Exadata Infrastructure in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloud_exadata_infrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudExadataInfrastructureAsync(
      CloudExadataInfrastructureName name) {
    DeleteCloudExadataInfrastructureRequest request =
        DeleteCloudExadataInfrastructureRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCloudExadataInfrastructureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       CloudExadataInfrastructureName.of(
   *               "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *           .toString();
   *   oracleDatabaseClient.deleteCloudExadataInfrastructureAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud Exadata Infrastructure in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloud_exadata_infrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudExadataInfrastructureAsync(
      String name) {
    DeleteCloudExadataInfrastructureRequest request =
        DeleteCloudExadataInfrastructureRequest.newBuilder().setName(name).build();
    return deleteCloudExadataInfrastructureAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudExadataInfrastructureRequest request =
   *       DeleteCloudExadataInfrastructureRequest.newBuilder()
   *           .setName(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   oracleDatabaseClient.deleteCloudExadataInfrastructureAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudExadataInfrastructureAsync(
      DeleteCloudExadataInfrastructureRequest request) {
    return deleteCloudExadataInfrastructureOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudExadataInfrastructureRequest request =
   *       DeleteCloudExadataInfrastructureRequest.newBuilder()
   *           .setName(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient
   *           .deleteCloudExadataInfrastructureOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCloudExadataInfrastructureRequest, Empty, OperationMetadata>
      deleteCloudExadataInfrastructureOperationCallable() {
    return stub.deleteCloudExadataInfrastructureOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadata Infrastructure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudExadataInfrastructureRequest request =
   *       DeleteCloudExadataInfrastructureRequest.newBuilder()
   *           .setName(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteCloudExadataInfrastructureCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCloudExadataInfrastructureRequest, Operation>
      deleteCloudExadataInfrastructureCallable() {
    return stub.deleteCloudExadataInfrastructureCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VM Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CloudVmCluster element : oracleDatabaseClient.listCloudVmClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudVmClustersPagedResponse listCloudVmClusters(LocationName parent) {
    ListCloudVmClustersRequest request =
        ListCloudVmClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloudVmClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VM Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CloudVmCluster element : oracleDatabaseClient.listCloudVmClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudVmClustersPagedResponse listCloudVmClusters(String parent) {
    ListCloudVmClustersRequest request =
        ListCloudVmClustersRequest.newBuilder().setParent(parent).build();
    return listCloudVmClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VM Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudVmClustersRequest request =
   *       ListCloudVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (CloudVmCluster element :
   *       oracleDatabaseClient.listCloudVmClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudVmClustersPagedResponse listCloudVmClusters(
      ListCloudVmClustersRequest request) {
    return listCloudVmClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VM Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudVmClustersRequest request =
   *       ListCloudVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CloudVmCluster> future =
   *       oracleDatabaseClient.listCloudVmClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudVmCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersPagedResponse>
      listCloudVmClustersPagedCallable() {
    return stub.listCloudVmClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VM Clusters in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListCloudVmClustersRequest request =
   *       ListCloudVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListCloudVmClustersResponse response =
   *         oracleDatabaseClient.listCloudVmClustersCallable().call(request);
   *     for (CloudVmCluster element : response.getCloudVmClustersList()) {
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
  public final UnaryCallable<ListCloudVmClustersRequest, ListCloudVmClustersResponse>
      listCloudVmClustersCallable() {
    return stub.listCloudVmClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudVmClusterName name =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
   *   CloudVmCluster response = oracleDatabaseClient.getCloudVmCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud VM Cluster in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudVmCluster getCloudVmCluster(CloudVmClusterName name) {
    GetCloudVmClusterRequest request =
        GetCloudVmClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCloudVmCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString();
   *   CloudVmCluster response = oracleDatabaseClient.getCloudVmCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud VM Cluster in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudVmCluster getCloudVmCluster(String name) {
    GetCloudVmClusterRequest request = GetCloudVmClusterRequest.newBuilder().setName(name).build();
    return getCloudVmCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetCloudVmClusterRequest request =
   *       GetCloudVmClusterRequest.newBuilder()
   *           .setName(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .build();
   *   CloudVmCluster response = oracleDatabaseClient.getCloudVmCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudVmCluster getCloudVmCluster(GetCloudVmClusterRequest request) {
    return getCloudVmClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetCloudVmClusterRequest request =
   *       GetCloudVmClusterRequest.newBuilder()
   *           .setName(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<CloudVmCluster> future =
   *       oracleDatabaseClient.getCloudVmClusterCallable().futureCall(request);
   *   // Do something.
   *   CloudVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloudVmClusterRequest, CloudVmCluster> getCloudVmClusterCallable() {
    return stub.getCloudVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VM Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
   *   String cloudVmClusterId = "cloudVmClusterId-1217103287";
   *   CloudVmCluster response =
   *       oracleDatabaseClient
   *           .createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @param cloudVmCluster Required. The resource being created
   * @param cloudVmClusterId Required. The ID of the VM Cluster to create. This value is restricted
   *     to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length.
   *     The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudVmCluster, OperationMetadata> createCloudVmClusterAsync(
      LocationName parent, CloudVmCluster cloudVmCluster, String cloudVmClusterId) {
    CreateCloudVmClusterRequest request =
        CreateCloudVmClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCloudVmCluster(cloudVmCluster)
            .setCloudVmClusterId(cloudVmClusterId)
            .build();
    return createCloudVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VM Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CloudVmCluster cloudVmCluster = CloudVmCluster.newBuilder().build();
   *   String cloudVmClusterId = "cloudVmClusterId-1217103287";
   *   CloudVmCluster response =
   *       oracleDatabaseClient
   *           .createCloudVmClusterAsync(parent, cloudVmCluster, cloudVmClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @param cloudVmCluster Required. The resource being created
   * @param cloudVmClusterId Required. The ID of the VM Cluster to create. This value is restricted
   *     to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length.
   *     The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudVmCluster, OperationMetadata> createCloudVmClusterAsync(
      String parent, CloudVmCluster cloudVmCluster, String cloudVmClusterId) {
    CreateCloudVmClusterRequest request =
        CreateCloudVmClusterRequest.newBuilder()
            .setParent(parent)
            .setCloudVmCluster(cloudVmCluster)
            .setCloudVmClusterId(cloudVmClusterId)
            .build();
    return createCloudVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VM Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudVmClusterRequest request =
   *       CreateCloudVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudVmClusterId("cloudVmClusterId-1217103287")
   *           .setCloudVmCluster(CloudVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   CloudVmCluster response = oracleDatabaseClient.createCloudVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<CloudVmCluster, OperationMetadata> createCloudVmClusterAsync(
      CreateCloudVmClusterRequest request) {
    return createCloudVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VM Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudVmClusterRequest request =
   *       CreateCloudVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudVmClusterId("cloudVmClusterId-1217103287")
   *           .setCloudVmCluster(CloudVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<CloudVmCluster, OperationMetadata> future =
   *       oracleDatabaseClient.createCloudVmClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   CloudVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateCloudVmClusterRequest, CloudVmCluster, OperationMetadata>
      createCloudVmClusterOperationCallable() {
    return stub.createCloudVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new VM Cluster in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateCloudVmClusterRequest request =
   *       CreateCloudVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCloudVmClusterId("cloudVmClusterId-1217103287")
   *           .setCloudVmCluster(CloudVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createCloudVmClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCloudVmClusterRequest, Operation>
      createCloudVmClusterCallable() {
    return stub.createCloudVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudVmClusterName name =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
   *   oracleDatabaseClient.deleteCloudVmClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud VM Cluster in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudVmClusterAsync(
      CloudVmClusterName name) {
    DeleteCloudVmClusterRequest request =
        DeleteCloudVmClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteCloudVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString();
   *   oracleDatabaseClient.deleteCloudVmClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Cloud VM Cluster in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudVmClusterAsync(String name) {
    DeleteCloudVmClusterRequest request =
        DeleteCloudVmClusterRequest.newBuilder().setName(name).build();
    return deleteCloudVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudVmClusterRequest request =
   *       DeleteCloudVmClusterRequest.newBuilder()
   *           .setName(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   oracleDatabaseClient.deleteCloudVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteCloudVmClusterAsync(
      DeleteCloudVmClusterRequest request) {
    return deleteCloudVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudVmClusterRequest request =
   *       DeleteCloudVmClusterRequest.newBuilder()
   *           .setName(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteCloudVmClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCloudVmClusterRequest, Empty, OperationMetadata>
      deleteCloudVmClusterOperationCallable() {
    return stub.deleteCloudVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteCloudVmClusterRequest request =
   *       DeleteCloudVmClusterRequest.newBuilder()
   *           .setName(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteCloudVmClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCloudVmClusterRequest, Operation>
      deleteCloudVmClusterCallable() {
    return stub.deleteCloudVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the entitlements in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Entitlement element : oracleDatabaseClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the entitlement in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(LocationName parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the entitlements in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Entitlement element : oracleDatabaseClient.listEntitlements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the entitlement in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(String parent) {
    ListEntitlementsRequest request =
        ListEntitlementsRequest.newBuilder().setParent(parent).build();
    return listEntitlements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the entitlements in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Entitlement element : oracleDatabaseClient.listEntitlements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(ListEntitlementsRequest request) {
    return listEntitlementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the entitlements in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       oracleDatabaseClient.listEntitlementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entitlement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return stub.listEntitlementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the entitlements in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEntitlementsResponse response =
   *         oracleDatabaseClient.listEntitlementsCallable().call(request);
   *     for (Entitlement element : response.getEntitlementsList()) {
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
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return stub.listEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database servers of an Exadata Infrastructure instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudExadataInfrastructureName parent =
   *       CloudExadataInfrastructureName.of(
   *           "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]");
   *   for (DbServer element : oracleDatabaseClient.listDbServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database server in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloudExadataInfrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbServersPagedResponse listDbServers(CloudExadataInfrastructureName parent) {
    ListDbServersRequest request =
        ListDbServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database servers of an Exadata Infrastructure instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent =
   *       CloudExadataInfrastructureName.of(
   *               "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *           .toString();
   *   for (DbServer element : oracleDatabaseClient.listDbServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database server in the following format:
   *     projects/{project}/locations/{location}/cloudExadataInfrastructures/{cloudExadataInfrastructure}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbServersPagedResponse listDbServers(String parent) {
    ListDbServersRequest request = ListDbServersRequest.newBuilder().setParent(parent).build();
    return listDbServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database servers of an Exadata Infrastructure instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbServersRequest request =
   *       ListDbServersRequest.newBuilder()
   *           .setParent(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DbServer element : oracleDatabaseClient.listDbServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbServersPagedResponse listDbServers(ListDbServersRequest request) {
    return listDbServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database servers of an Exadata Infrastructure instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbServersRequest request =
   *       ListDbServersRequest.newBuilder()
   *           .setParent(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DbServer> future =
   *       oracleDatabaseClient.listDbServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDbServersRequest, ListDbServersPagedResponse>
      listDbServersPagedCallable() {
    return stub.listDbServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database servers of an Exadata Infrastructure instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbServersRequest request =
   *       ListDbServersRequest.newBuilder()
   *           .setParent(
   *               CloudExadataInfrastructureName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CLOUD_EXADATA_INFRASTRUCTURE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDbServersResponse response = oracleDatabaseClient.listDbServersCallable().call(request);
   *     for (DbServer element : response.getDbServersList()) {
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
  public final UnaryCallable<ListDbServersRequest, ListDbServersResponse> listDbServersCallable() {
    return stub.listDbServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CloudVmClusterName parent =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]");
   *   for (DbNode element : oracleDatabaseClient.listDbNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database node in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloudVmCluster}. .
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbNodesPagedResponse listDbNodes(CloudVmClusterName parent) {
    ListDbNodesRequest request =
        ListDbNodesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExadbVmClusterName parent =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
   *   for (DbNode element : oracleDatabaseClient.listDbNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database node in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloudVmCluster}. .
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbNodesPagedResponse listDbNodes(ExadbVmClusterName parent) {
    ListDbNodesRequest request =
        ListDbNodesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString();
   *   for (DbNode element : oracleDatabaseClient.listDbNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database node in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloudVmCluster}. .
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbNodesPagedResponse listDbNodes(String parent) {
    ListDbNodesRequest request = ListDbNodesRequest.newBuilder().setParent(parent).build();
    return listDbNodes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbNodesRequest request =
   *       ListDbNodesRequest.newBuilder()
   *           .setParent(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DbNode element : oracleDatabaseClient.listDbNodes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbNodesPagedResponse listDbNodes(ListDbNodesRequest request) {
    return listDbNodesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbNodesRequest request =
   *       ListDbNodesRequest.newBuilder()
   *           .setParent(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DbNode> future =
   *       oracleDatabaseClient.listDbNodesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbNode element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDbNodesRequest, ListDbNodesPagedResponse>
      listDbNodesPagedCallable() {
    return stub.listDbNodesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database nodes of a VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbNodesRequest request =
   *       ListDbNodesRequest.newBuilder()
   *           .setParent(
   *               CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDbNodesResponse response = oracleDatabaseClient.listDbNodesCallable().call(request);
   *     for (DbNode element : response.getDbNodesList()) {
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
  public final UnaryCallable<ListDbNodesRequest, ListDbNodesResponse> listDbNodesCallable() {
    return stub.listDbNodesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (GiVersion element : oracleDatabaseClient.listGiVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for Grid Infrastructure Version in the following
   *     format: Format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGiVersionsPagedResponse listGiVersions(LocationName parent) {
    ListGiVersionsRequest request =
        ListGiVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGiVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (GiVersion element : oracleDatabaseClient.listGiVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for Grid Infrastructure Version in the following
   *     format: Format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGiVersionsPagedResponse listGiVersions(String parent) {
    ListGiVersionsRequest request = ListGiVersionsRequest.newBuilder().setParent(parent).build();
    return listGiVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListGiVersionsRequest request =
   *       ListGiVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (GiVersion element : oracleDatabaseClient.listGiVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGiVersionsPagedResponse listGiVersions(ListGiVersionsRequest request) {
    return listGiVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListGiVersionsRequest request =
   *       ListGiVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<GiVersion> future =
   *       oracleDatabaseClient.listGiVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GiVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGiVersionsRequest, ListGiVersionsPagedResponse>
      listGiVersionsPagedCallable() {
    return stub.listGiVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid Oracle Grid Infrastructure (GI) versions for the given project and
   * location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListGiVersionsRequest request =
   *       ListGiVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListGiVersionsResponse response =
   *         oracleDatabaseClient.listGiVersionsCallable().call(request);
   *     for (GiVersion element : response.getGiVersionsList()) {
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
  public final UnaryCallable<ListGiVersionsRequest, ListGiVersionsResponse>
      listGiVersionsCallable() {
    return stub.listGiVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid minor versions for the given project, location, gi version and shape
   * family.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GiVersionName parent = GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]");
   *   for (MinorVersion element : oracleDatabaseClient.listMinorVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the MinorVersion resource with the format:
   *     projects/{project}/locations/{location}/giVersions/{gi_version}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMinorVersionsPagedResponse listMinorVersions(GiVersionName parent) {
    ListMinorVersionsRequest request =
        ListMinorVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMinorVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid minor versions for the given project, location, gi version and shape
   * family.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]").toString();
   *   for (MinorVersion element : oracleDatabaseClient.listMinorVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the MinorVersion resource with the format:
   *     projects/{project}/locations/{location}/giVersions/{gi_version}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMinorVersionsPagedResponse listMinorVersions(String parent) {
    ListMinorVersionsRequest request =
        ListMinorVersionsRequest.newBuilder().setParent(parent).build();
    return listMinorVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid minor versions for the given project, location, gi version and shape
   * family.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListMinorVersionsRequest request =
   *       ListMinorVersionsRequest.newBuilder()
   *           .setParent(GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MinorVersion element : oracleDatabaseClient.listMinorVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMinorVersionsPagedResponse listMinorVersions(ListMinorVersionsRequest request) {
    return listMinorVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid minor versions for the given project, location, gi version and shape
   * family.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListMinorVersionsRequest request =
   *       ListMinorVersionsRequest.newBuilder()
   *           .setParent(GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MinorVersion> future =
   *       oracleDatabaseClient.listMinorVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MinorVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsPagedResponse>
      listMinorVersionsPagedCallable() {
    return stub.listMinorVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the valid minor versions for the given project, location, gi version and shape
   * family.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListMinorVersionsRequest request =
   *       ListMinorVersionsRequest.newBuilder()
   *           .setParent(GiVersionName.of("[PROJECT]", "[LOCATION]", "[GI_VERSION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMinorVersionsResponse response =
   *         oracleDatabaseClient.listMinorVersionsCallable().call(request);
   *     for (MinorVersion element : response.getMinorVersionsList()) {
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
  public final UnaryCallable<ListMinorVersionsRequest, ListMinorVersionsResponse>
      listMinorVersionsCallable() {
    return stub.listMinorVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database system shapes available for the project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DbSystemShape element : oracleDatabaseClient.listDbSystemShapes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for Database System Shapes in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemShapesPagedResponse listDbSystemShapes(LocationName parent) {
    ListDbSystemShapesRequest request =
        ListDbSystemShapesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbSystemShapes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database system shapes available for the project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DbSystemShape element : oracleDatabaseClient.listDbSystemShapes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for Database System Shapes in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemShapesPagedResponse listDbSystemShapes(String parent) {
    ListDbSystemShapesRequest request =
        ListDbSystemShapesRequest.newBuilder().setParent(parent).build();
    return listDbSystemShapes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database system shapes available for the project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemShapesRequest request =
   *       ListDbSystemShapesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DbSystemShape element : oracleDatabaseClient.listDbSystemShapes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemShapesPagedResponse listDbSystemShapes(
      ListDbSystemShapesRequest request) {
    return listDbSystemShapesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database system shapes available for the project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemShapesRequest request =
   *       ListDbSystemShapesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DbSystemShape> future =
   *       oracleDatabaseClient.listDbSystemShapesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbSystemShape element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesPagedResponse>
      listDbSystemShapesPagedCallable() {
    return stub.listDbSystemShapesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the database system shapes available for the project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemShapesRequest request =
   *       ListDbSystemShapesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDbSystemShapesResponse response =
   *         oracleDatabaseClient.listDbSystemShapesCallable().call(request);
   *     for (DbSystemShape element : response.getDbSystemShapesList()) {
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
  public final UnaryCallable<ListDbSystemShapesRequest, ListDbSystemShapesResponse>
      listDbSystemShapesCallable() {
    return stub.listDbSystemShapesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Autonomous Databases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AutonomousDatabase element :
   *       oracleDatabaseClient.listAutonomousDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabasesPagedResponse listAutonomousDatabases(LocationName parent) {
    ListAutonomousDatabasesRequest request =
        ListAutonomousDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutonomousDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Autonomous Databases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AutonomousDatabase element :
   *       oracleDatabaseClient.listAutonomousDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabasesPagedResponse listAutonomousDatabases(String parent) {
    ListAutonomousDatabasesRequest request =
        ListAutonomousDatabasesRequest.newBuilder().setParent(parent).build();
    return listAutonomousDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Autonomous Databases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabasesRequest request =
   *       ListAutonomousDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AutonomousDatabase element :
   *       oracleDatabaseClient.listAutonomousDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabasesPagedResponse listAutonomousDatabases(
      ListAutonomousDatabasesRequest request) {
    return listAutonomousDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Autonomous Databases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabasesRequest request =
   *       ListAutonomousDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AutonomousDatabase> future =
   *       oracleDatabaseClient.listAutonomousDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AutonomousDatabase element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesPagedResponse>
      listAutonomousDatabasesPagedCallable() {
    return stub.listAutonomousDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Autonomous Databases in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabasesRequest request =
   *       ListAutonomousDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAutonomousDatabasesResponse response =
   *         oracleDatabaseClient.listAutonomousDatabasesCallable().call(request);
   *     for (AutonomousDatabase element : response.getAutonomousDatabasesList()) {
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
  public final UnaryCallable<ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse>
      listAutonomousDatabasesCallable() {
    return stub.listAutonomousDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response = oracleDatabaseClient.getAutonomousDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutonomousDatabase getAutonomousDatabase(AutonomousDatabaseName name) {
    GetAutonomousDatabaseRequest request =
        GetAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAutonomousDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response = oracleDatabaseClient.getAutonomousDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutonomousDatabase getAutonomousDatabase(String name) {
    GetAutonomousDatabaseRequest request =
        GetAutonomousDatabaseRequest.newBuilder().setName(name).build();
    return getAutonomousDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetAutonomousDatabaseRequest request =
   *       GetAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response = oracleDatabaseClient.getAutonomousDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutonomousDatabase getAutonomousDatabase(GetAutonomousDatabaseRequest request) {
    return getAutonomousDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetAutonomousDatabaseRequest request =
   *       GetAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AutonomousDatabase> future =
   *       oracleDatabaseClient.getAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutonomousDatabaseRequest, AutonomousDatabase>
      getAutonomousDatabaseCallable() {
    return stub.getAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Autonomous Database in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
   *   String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @param autonomousDatabase Required. The Autonomous Database being created.
   * @param autonomousDatabaseId Required. The ID of the Autonomous Database to create. This value
   *     is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters
   *     in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> createAutonomousDatabaseAsync(
      LocationName parent, AutonomousDatabase autonomousDatabase, String autonomousDatabaseId) {
    CreateAutonomousDatabaseRequest request =
        CreateAutonomousDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAutonomousDatabase(autonomousDatabase)
            .setAutonomousDatabaseId(autonomousDatabaseId)
            .build();
    return createAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Autonomous Database in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
   *   String autonomousDatabaseId = "autonomousDatabaseId-1972693114";
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .createAutonomousDatabaseAsync(parent, autonomousDatabase, autonomousDatabaseId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the parent in the following format:
   *     projects/{project}/locations/{location}.
   * @param autonomousDatabase Required. The Autonomous Database being created.
   * @param autonomousDatabaseId Required. The ID of the Autonomous Database to create. This value
   *     is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters
   *     in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> createAutonomousDatabaseAsync(
      String parent, AutonomousDatabase autonomousDatabase, String autonomousDatabaseId) {
    CreateAutonomousDatabaseRequest request =
        CreateAutonomousDatabaseRequest.newBuilder()
            .setParent(parent)
            .setAutonomousDatabase(autonomousDatabase)
            .setAutonomousDatabaseId(autonomousDatabaseId)
            .build();
    return createAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Autonomous Database in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateAutonomousDatabaseRequest request =
   *       CreateAutonomousDatabaseRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAutonomousDatabaseId("autonomousDatabaseId-1972693114")
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.createAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> createAutonomousDatabaseAsync(
      CreateAutonomousDatabaseRequest request) {
    return createAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Autonomous Database in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateAutonomousDatabaseRequest request =
   *       CreateAutonomousDatabaseRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAutonomousDatabaseId("autonomousDatabaseId-1972693114")
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.createAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      createAutonomousDatabaseOperationCallable() {
    return stub.createAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Autonomous Database in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateAutonomousDatabaseRequest request =
   *       CreateAutonomousDatabaseRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAutonomousDatabaseId("autonomousDatabaseId-1972693114")
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAutonomousDatabaseRequest, Operation>
      createAutonomousDatabaseCallable() {
    return stub.createAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabase autonomousDatabase = AutonomousDatabase.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.updateAutonomousDatabaseAsync(autonomousDatabase, updateMask).get();
   * }
   * }</pre>
   *
   * @param autonomousDatabase Required. The resource being updated
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Exadata resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> updateAutonomousDatabaseAsync(
      AutonomousDatabase autonomousDatabase, FieldMask updateMask) {
    UpdateAutonomousDatabaseRequest request =
        UpdateAutonomousDatabaseRequest.newBuilder()
            .setAutonomousDatabase(autonomousDatabase)
            .setUpdateMask(updateMask)
            .build();
    return updateAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateAutonomousDatabaseRequest request =
   *       UpdateAutonomousDatabaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.updateAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> updateAutonomousDatabaseAsync(
      UpdateAutonomousDatabaseRequest request) {
    return updateAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateAutonomousDatabaseRequest request =
   *       UpdateAutonomousDatabaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.updateAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      updateAutonomousDatabaseOperationCallable() {
    return stub.updateAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateAutonomousDatabaseRequest request =
   *       UpdateAutonomousDatabaseRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutonomousDatabase(AutonomousDatabase.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.updateAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutonomousDatabaseRequest, Operation>
      updateAutonomousDatabaseCallable() {
    return stub.updateAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   oracleDatabaseClient.deleteAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutonomousDatabaseAsync(
      AutonomousDatabaseName name) {
    DeleteAutonomousDatabaseRequest request =
        DeleteAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   oracleDatabaseClient.deleteAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutonomousDatabaseAsync(
      String name) {
    DeleteAutonomousDatabaseRequest request =
        DeleteAutonomousDatabaseRequest.newBuilder().setName(name).build();
    return deleteAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteAutonomousDatabaseRequest request =
   *       DeleteAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAutonomousDatabaseAsync(
      DeleteAutonomousDatabaseRequest request) {
    return deleteAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteAutonomousDatabaseRequest request =
   *       DeleteAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAutonomousDatabaseRequest, Empty, OperationMetadata>
      deleteAutonomousDatabaseOperationCallable() {
    return stub.deleteAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteAutonomousDatabaseRequest request =
   *       DeleteAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAutonomousDatabaseRequest, Operation>
      deleteAutonomousDatabaseCallable() {
    return stub.deleteAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   Timestamp restoreTime = Timestamp.newBuilder().build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.restoreAutonomousDatabaseAsync(name, restoreTime).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param restoreTime Required. The time and date to restore the database to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseAsync(AutonomousDatabaseName name, Timestamp restoreTime) {
    RestoreAutonomousDatabaseRequest request =
        RestoreAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRestoreTime(restoreTime)
            .build();
    return restoreAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   Timestamp restoreTime = Timestamp.newBuilder().build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.restoreAutonomousDatabaseAsync(name, restoreTime).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param restoreTime Required. The time and date to restore the database to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseAsync(String name, Timestamp restoreTime) {
    RestoreAutonomousDatabaseRequest request =
        RestoreAutonomousDatabaseRequest.newBuilder()
            .setName(name)
            .setRestoreTime(restoreTime)
            .build();
    return restoreAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestoreAutonomousDatabaseRequest request =
   *       RestoreAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRestoreTime(Timestamp.newBuilder().build())
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.restoreAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseAsync(RestoreAutonomousDatabaseRequest request) {
    return restoreAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestoreAutonomousDatabaseRequest request =
   *       RestoreAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRestoreTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.restoreAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RestoreAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restoreAutonomousDatabaseOperationCallable() {
    return stub.restoreAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a single Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestoreAutonomousDatabaseRequest request =
   *       RestoreAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setRestoreTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.restoreAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreAutonomousDatabaseRequest, Operation>
      restoreAutonomousDatabaseCallable() {
    return stub.restoreAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a wallet for an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   GenerateType type = GenerateType.forNumber(0);
   *   boolean isRegional = true;
   *   String password = "password1216985755";
   *   GenerateAutonomousDatabaseWalletResponse response =
   *       oracleDatabaseClient.generateAutonomousDatabaseWallet(name, type, isRegional, password);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param type Optional. The type of wallet generation for the Autonomous Database. The default
   *     value is SINGLE.
   * @param isRegional Optional. True when requesting regional connection strings in PDB connect
   *     info, applicable to cross-region Data Guard only.
   * @param password Required. The password used to encrypt the keys inside the wallet. The password
   *     must be a minimum of 8 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAutonomousDatabaseWalletResponse generateAutonomousDatabaseWallet(
      AutonomousDatabaseName name, GenerateType type, boolean isRegional, String password) {
    GenerateAutonomousDatabaseWalletRequest request =
        GenerateAutonomousDatabaseWalletRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setType(type)
            .setIsRegional(isRegional)
            .setPassword(password)
            .build();
    return generateAutonomousDatabaseWallet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a wallet for an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   GenerateType type = GenerateType.forNumber(0);
   *   boolean isRegional = true;
   *   String password = "password1216985755";
   *   GenerateAutonomousDatabaseWalletResponse response =
   *       oracleDatabaseClient.generateAutonomousDatabaseWallet(name, type, isRegional, password);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param type Optional. The type of wallet generation for the Autonomous Database. The default
   *     value is SINGLE.
   * @param isRegional Optional. True when requesting regional connection strings in PDB connect
   *     info, applicable to cross-region Data Guard only.
   * @param password Required. The password used to encrypt the keys inside the wallet. The password
   *     must be a minimum of 8 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAutonomousDatabaseWalletResponse generateAutonomousDatabaseWallet(
      String name, GenerateType type, boolean isRegional, String password) {
    GenerateAutonomousDatabaseWalletRequest request =
        GenerateAutonomousDatabaseWalletRequest.newBuilder()
            .setName(name)
            .setType(type)
            .setIsRegional(isRegional)
            .setPassword(password)
            .build();
    return generateAutonomousDatabaseWallet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a wallet for an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GenerateAutonomousDatabaseWalletRequest request =
   *       GenerateAutonomousDatabaseWalletRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setType(GenerateType.forNumber(0))
   *           .setIsRegional(true)
   *           .setPassword("password1216985755")
   *           .build();
   *   GenerateAutonomousDatabaseWalletResponse response =
   *       oracleDatabaseClient.generateAutonomousDatabaseWallet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAutonomousDatabaseWalletResponse generateAutonomousDatabaseWallet(
      GenerateAutonomousDatabaseWalletRequest request) {
    return generateAutonomousDatabaseWalletCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a wallet for an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GenerateAutonomousDatabaseWalletRequest request =
   *       GenerateAutonomousDatabaseWalletRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setType(GenerateType.forNumber(0))
   *           .setIsRegional(true)
   *           .setPassword("password1216985755")
   *           .build();
   *   ApiFuture<GenerateAutonomousDatabaseWalletResponse> future =
   *       oracleDatabaseClient.generateAutonomousDatabaseWalletCallable().futureCall(request);
   *   // Do something.
   *   GenerateAutonomousDatabaseWalletResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateAutonomousDatabaseWalletRequest, GenerateAutonomousDatabaseWalletResponse>
      generateAutonomousDatabaseWalletCallable() {
    return stub.generateAutonomousDatabaseWalletCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the available Autonomous Database versions for a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AutonomousDbVersion element :
   *       oracleDatabaseClient.listAutonomousDbVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDbVersionsPagedResponse listAutonomousDbVersions(LocationName parent) {
    ListAutonomousDbVersionsRequest request =
        ListAutonomousDbVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutonomousDbVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the available Autonomous Database versions for a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AutonomousDbVersion element :
   *       oracleDatabaseClient.listAutonomousDbVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDbVersionsPagedResponse listAutonomousDbVersions(String parent) {
    ListAutonomousDbVersionsRequest request =
        ListAutonomousDbVersionsRequest.newBuilder().setParent(parent).build();
    return listAutonomousDbVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the available Autonomous Database versions for a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDbVersionsRequest request =
   *       ListAutonomousDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AutonomousDbVersion element :
   *       oracleDatabaseClient.listAutonomousDbVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDbVersionsPagedResponse listAutonomousDbVersions(
      ListAutonomousDbVersionsRequest request) {
    return listAutonomousDbVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the available Autonomous Database versions for a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDbVersionsRequest request =
   *       ListAutonomousDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AutonomousDbVersion> future =
   *       oracleDatabaseClient.listAutonomousDbVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AutonomousDbVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsPagedResponse>
      listAutonomousDbVersionsPagedCallable() {
    return stub.listAutonomousDbVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the available Autonomous Database versions for a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDbVersionsRequest request =
   *       ListAutonomousDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAutonomousDbVersionsResponse response =
   *         oracleDatabaseClient.listAutonomousDbVersionsCallable().call(request);
   *     for (AutonomousDbVersion element : response.getAutonomousDbVersionsList()) {
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
  public final UnaryCallable<ListAutonomousDbVersionsRequest, ListAutonomousDbVersionsResponse>
      listAutonomousDbVersionsCallable() {
    return stub.listAutonomousDbVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Autonomous Database Character Sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AutonomousDatabaseCharacterSet element :
   *       oracleDatabaseClient.listAutonomousDatabaseCharacterSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseCharacterSetsPagedResponse listAutonomousDatabaseCharacterSets(
      LocationName parent) {
    ListAutonomousDatabaseCharacterSetsRequest request =
        ListAutonomousDatabaseCharacterSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutonomousDatabaseCharacterSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Autonomous Database Character Sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AutonomousDatabaseCharacterSet element :
   *       oracleDatabaseClient.listAutonomousDatabaseCharacterSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseCharacterSetsPagedResponse listAutonomousDatabaseCharacterSets(
      String parent) {
    ListAutonomousDatabaseCharacterSetsRequest request =
        ListAutonomousDatabaseCharacterSetsRequest.newBuilder().setParent(parent).build();
    return listAutonomousDatabaseCharacterSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Autonomous Database Character Sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseCharacterSetsRequest request =
   *       ListAutonomousDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (AutonomousDatabaseCharacterSet element :
   *       oracleDatabaseClient.listAutonomousDatabaseCharacterSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseCharacterSetsPagedResponse listAutonomousDatabaseCharacterSets(
      ListAutonomousDatabaseCharacterSetsRequest request) {
    return listAutonomousDatabaseCharacterSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Autonomous Database Character Sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseCharacterSetsRequest request =
   *       ListAutonomousDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<AutonomousDatabaseCharacterSet> future =
   *       oracleDatabaseClient
   *           .listAutonomousDatabaseCharacterSetsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AutonomousDatabaseCharacterSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsPagedResponse>
      listAutonomousDatabaseCharacterSetsPagedCallable() {
    return stub.listAutonomousDatabaseCharacterSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Autonomous Database Character Sets in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseCharacterSetsRequest request =
   *       ListAutonomousDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListAutonomousDatabaseCharacterSetsResponse response =
   *         oracleDatabaseClient.listAutonomousDatabaseCharacterSetsCallable().call(request);
   *     for (AutonomousDatabaseCharacterSet element :
   *         response.getAutonomousDatabaseCharacterSetsList()) {
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
          ListAutonomousDatabaseCharacterSetsRequest, ListAutonomousDatabaseCharacterSetsResponse>
      listAutonomousDatabaseCharacterSetsCallable() {
    return stub.listAutonomousDatabaseCharacterSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the long-term and automatic backups of an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AutonomousDatabaseBackup element :
   *       oracleDatabaseClient.listAutonomousDatabaseBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ListAutonomousDatabaseBackups in the following
   *     format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseBackupsPagedResponse listAutonomousDatabaseBackups(
      LocationName parent) {
    ListAutonomousDatabaseBackupsRequest request =
        ListAutonomousDatabaseBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutonomousDatabaseBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the long-term and automatic backups of an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AutonomousDatabaseBackup element :
   *       oracleDatabaseClient.listAutonomousDatabaseBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ListAutonomousDatabaseBackups in the following
   *     format: projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseBackupsPagedResponse listAutonomousDatabaseBackups(
      String parent) {
    ListAutonomousDatabaseBackupsRequest request =
        ListAutonomousDatabaseBackupsRequest.newBuilder().setParent(parent).build();
    return listAutonomousDatabaseBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the long-term and automatic backups of an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseBackupsRequest request =
   *       ListAutonomousDatabaseBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AutonomousDatabaseBackup element :
   *       oracleDatabaseClient.listAutonomousDatabaseBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutonomousDatabaseBackupsPagedResponse listAutonomousDatabaseBackups(
      ListAutonomousDatabaseBackupsRequest request) {
    return listAutonomousDatabaseBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the long-term and automatic backups of an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseBackupsRequest request =
   *       ListAutonomousDatabaseBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AutonomousDatabaseBackup> future =
   *       oracleDatabaseClient.listAutonomousDatabaseBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AutonomousDatabaseBackup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsPagedResponse>
      listAutonomousDatabaseBackupsPagedCallable() {
    return stub.listAutonomousDatabaseBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the long-term and automatic backups of an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListAutonomousDatabaseBackupsRequest request =
   *       ListAutonomousDatabaseBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAutonomousDatabaseBackupsResponse response =
   *         oracleDatabaseClient.listAutonomousDatabaseBackupsCallable().call(request);
   *     for (AutonomousDatabaseBackup element : response.getAutonomousDatabaseBackupsList()) {
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
          ListAutonomousDatabaseBackupsRequest, ListAutonomousDatabaseBackupsResponse>
      listAutonomousDatabaseBackupsCallable() {
    return stub.listAutonomousDatabaseBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response = oracleDatabaseClient.stopAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> stopAutonomousDatabaseAsync(
      AutonomousDatabaseName name) {
    StopAutonomousDatabaseRequest request =
        StopAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return stopAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response = oracleDatabaseClient.stopAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> stopAutonomousDatabaseAsync(
      String name) {
    StopAutonomousDatabaseRequest request =
        StopAutonomousDatabaseRequest.newBuilder().setName(name).build();
    return stopAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StopAutonomousDatabaseRequest request =
   *       StopAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response = oracleDatabaseClient.stopAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> stopAutonomousDatabaseAsync(
      StopAutonomousDatabaseRequest request) {
    return stopAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StopAutonomousDatabaseRequest request =
   *       StopAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.stopAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StopAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      stopAutonomousDatabaseOperationCallable() {
    return stub.stopAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StopAutonomousDatabaseRequest request =
   *       StopAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.stopAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopAutonomousDatabaseRequest, Operation>
      stopAutonomousDatabaseCallable() {
    return stub.stopAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response = oracleDatabaseClient.startAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> startAutonomousDatabaseAsync(
      AutonomousDatabaseName name) {
    StartAutonomousDatabaseRequest request =
        StartAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return startAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response = oracleDatabaseClient.startAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> startAutonomousDatabaseAsync(
      String name) {
    StartAutonomousDatabaseRequest request =
        StartAutonomousDatabaseRequest.newBuilder().setName(name).build();
    return startAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StartAutonomousDatabaseRequest request =
   *       StartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.startAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata> startAutonomousDatabaseAsync(
      StartAutonomousDatabaseRequest request) {
    return startAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StartAutonomousDatabaseRequest request =
   *       StartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.startAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      startAutonomousDatabaseOperationCallable() {
    return stub.startAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   StartAutonomousDatabaseRequest request =
   *       StartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.startAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartAutonomousDatabaseRequest, Operation>
      startAutonomousDatabaseCallable() {
    return stub.startAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response = oracleDatabaseClient.restartAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseAsync(AutonomousDatabaseName name) {
    RestartAutonomousDatabaseRequest request =
        RestartAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restartAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response = oracleDatabaseClient.restartAutonomousDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseAsync(String name) {
    RestartAutonomousDatabaseRequest request =
        RestartAutonomousDatabaseRequest.newBuilder().setName(name).build();
    return restartAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestartAutonomousDatabaseRequest request =
   *       RestartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.restartAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseAsync(RestartAutonomousDatabaseRequest request) {
    return restartAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestartAutonomousDatabaseRequest request =
   *       RestartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.restartAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RestartAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      restartAutonomousDatabaseOperationCallable() {
    return stub.restartAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts an Autonomous Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RestartAutonomousDatabaseRequest request =
   *       RestartAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.restartAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartAutonomousDatabaseRequest, Operation>
      restartAutonomousDatabaseCallable() {
    return stub.restartAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabaseName peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to switch over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseAsync(
          AutonomousDatabaseName name, AutonomousDatabaseName peerAutonomousDatabase) {
    SwitchoverAutonomousDatabaseRequest request =
        SwitchoverAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPeerAutonomousDatabase(
                peerAutonomousDatabase == null ? null : peerAutonomousDatabase.toString())
            .build();
    return switchoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   String peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to switch over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseAsync(
          AutonomousDatabaseName name, String peerAutonomousDatabase) {
    SwitchoverAutonomousDatabaseRequest request =
        SwitchoverAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPeerAutonomousDatabase(peerAutonomousDatabase)
            .build();
    return switchoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabaseName peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to switch over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseAsync(
          String name, AutonomousDatabaseName peerAutonomousDatabase) {
    SwitchoverAutonomousDatabaseRequest request =
        SwitchoverAutonomousDatabaseRequest.newBuilder()
            .setName(name)
            .setPeerAutonomousDatabase(
                peerAutonomousDatabase == null ? null : peerAutonomousDatabase.toString())
            .build();
    return switchoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   String peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient
   *           .switchoverAutonomousDatabaseAsync(name, peerAutonomousDatabase)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to switch over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseAsync(String name, String peerAutonomousDatabase) {
    SwitchoverAutonomousDatabaseRequest request =
        SwitchoverAutonomousDatabaseRequest.newBuilder()
            .setName(name)
            .setPeerAutonomousDatabase(peerAutonomousDatabase)
            .build();
    return switchoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   SwitchoverAutonomousDatabaseRequest request =
   *       SwitchoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.switchoverAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseAsync(SwitchoverAutonomousDatabaseRequest request) {
    return switchoverAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   SwitchoverAutonomousDatabaseRequest request =
   *       SwitchoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.switchoverAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SwitchoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      switchoverAutonomousDatabaseOperationCallable() {
    return stub.switchoverAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a switchover of specified autonomous database to the associated peer database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   SwitchoverAutonomousDatabaseRequest request =
   *       SwitchoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.switchoverAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SwitchoverAutonomousDatabaseRequest, Operation>
      switchoverAutonomousDatabaseCallable() {
    return stub.switchoverAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabaseName peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to fail over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseAsync(
          AutonomousDatabaseName name, AutonomousDatabaseName peerAutonomousDatabase) {
    FailoverAutonomousDatabaseRequest request =
        FailoverAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPeerAutonomousDatabase(
                peerAutonomousDatabase == null ? null : peerAutonomousDatabase.toString())
            .build();
    return failoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   AutonomousDatabaseName name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   String peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to fail over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseAsync(AutonomousDatabaseName name, String peerAutonomousDatabase) {
    FailoverAutonomousDatabaseRequest request =
        FailoverAutonomousDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPeerAutonomousDatabase(peerAutonomousDatabase)
            .build();
    return failoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabaseName peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]");
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to fail over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseAsync(String name, AutonomousDatabaseName peerAutonomousDatabase) {
    FailoverAutonomousDatabaseRequest request =
        FailoverAutonomousDatabaseRequest.newBuilder()
            .setName(name)
            .setPeerAutonomousDatabase(
                peerAutonomousDatabase == null ? null : peerAutonomousDatabase.toString())
            .build();
    return failoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   String peerAutonomousDatabase =
   *       AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]").toString();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.failoverAutonomousDatabaseAsync(name, peerAutonomousDatabase).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Autonomous Database in the following format:
   *     projects/{project}/locations/{location}/autonomousDatabases/{autonomous_database}.
   * @param peerAutonomousDatabase Required. The peer database name to fail over to.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseAsync(String name, String peerAutonomousDatabase) {
    FailoverAutonomousDatabaseRequest request =
        FailoverAutonomousDatabaseRequest.newBuilder()
            .setName(name)
            .setPeerAutonomousDatabase(peerAutonomousDatabase)
            .build();
    return failoverAutonomousDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   FailoverAutonomousDatabaseRequest request =
   *       FailoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   AutonomousDatabase response =
   *       oracleDatabaseClient.failoverAutonomousDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseAsync(FailoverAutonomousDatabaseRequest request) {
    return failoverAutonomousDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   FailoverAutonomousDatabaseRequest request =
   *       FailoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<AutonomousDatabase, OperationMetadata> future =
   *       oracleDatabaseClient.failoverAutonomousDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   AutonomousDatabase response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          FailoverAutonomousDatabaseRequest, AutonomousDatabase, OperationMetadata>
      failoverAutonomousDatabaseOperationCallable() {
    return stub.failoverAutonomousDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a failover to target autonomous database from the associated primary database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   FailoverAutonomousDatabaseRequest request =
   *       FailoverAutonomousDatabaseRequest.newBuilder()
   *           .setName(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .setPeerAutonomousDatabase(
   *               AutonomousDatabaseName.of("[PROJECT]", "[LOCATION]", "[AUTONOMOUS_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.failoverAutonomousDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FailoverAutonomousDatabaseRequest, Operation>
      failoverAutonomousDatabaseCallable() {
    return stub.failoverAutonomousDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the ODB Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (OdbNetwork element : oracleDatabaseClient.listOdbNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the ODB Network in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbNetworksPagedResponse listOdbNetworks(LocationName parent) {
    ListOdbNetworksRequest request =
        ListOdbNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOdbNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the ODB Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (OdbNetwork element : oracleDatabaseClient.listOdbNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the ODB Network in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbNetworksPagedResponse listOdbNetworks(String parent) {
    ListOdbNetworksRequest request = ListOdbNetworksRequest.newBuilder().setParent(parent).build();
    return listOdbNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the ODB Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbNetworksRequest request =
   *       ListOdbNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (OdbNetwork element : oracleDatabaseClient.listOdbNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbNetworksPagedResponse listOdbNetworks(ListOdbNetworksRequest request) {
    return listOdbNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the ODB Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbNetworksRequest request =
   *       ListOdbNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<OdbNetwork> future =
   *       oracleDatabaseClient.listOdbNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OdbNetwork element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksPagedResponse>
      listOdbNetworksPagedCallable() {
    return stub.listOdbNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the ODB Networks in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbNetworksRequest request =
   *       ListOdbNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListOdbNetworksResponse response =
   *         oracleDatabaseClient.listOdbNetworksCallable().call(request);
   *     for (OdbNetwork element : response.getOdbNetworksList()) {
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
  public final UnaryCallable<ListOdbNetworksRequest, ListOdbNetworksResponse>
      listOdbNetworksCallable() {
    return stub.listOdbNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
   *   OdbNetwork response = oracleDatabaseClient.getOdbNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OdbNetwork in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbNetwork getOdbNetwork(OdbNetworkName name) {
    GetOdbNetworkRequest request =
        GetOdbNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOdbNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString();
   *   OdbNetwork response = oracleDatabaseClient.getOdbNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OdbNetwork in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbNetwork getOdbNetwork(String name) {
    GetOdbNetworkRequest request = GetOdbNetworkRequest.newBuilder().setName(name).build();
    return getOdbNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetOdbNetworkRequest request =
   *       GetOdbNetworkRequest.newBuilder()
   *           .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .build();
   *   OdbNetwork response = oracleDatabaseClient.getOdbNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbNetwork getOdbNetwork(GetOdbNetworkRequest request) {
    return getOdbNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetOdbNetworkRequest request =
   *       GetOdbNetworkRequest.newBuilder()
   *           .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .build();
   *   ApiFuture<OdbNetwork> future =
   *       oracleDatabaseClient.getOdbNetworkCallable().futureCall(request);
   *   // Do something.
   *   OdbNetwork response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOdbNetworkRequest, OdbNetwork> getOdbNetworkCallable() {
    return stub.getOdbNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
   *   String odbNetworkId = "odbNetworkId-169900740";
   *   OdbNetwork response =
   *       oracleDatabaseClient.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbNetwork in the following format:
   *     projects/{project}/locations/{location}.
   * @param odbNetwork Required. Details of the OdbNetwork instance to create.
   * @param odbNetworkId Required. The ID of the OdbNetwork to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbNetwork, OperationMetadata> createOdbNetworkAsync(
      LocationName parent, OdbNetwork odbNetwork, String odbNetworkId) {
    CreateOdbNetworkRequest request =
        CreateOdbNetworkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOdbNetwork(odbNetwork)
            .setOdbNetworkId(odbNetworkId)
            .build();
    return createOdbNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   OdbNetwork odbNetwork = OdbNetwork.newBuilder().build();
   *   String odbNetworkId = "odbNetworkId-169900740";
   *   OdbNetwork response =
   *       oracleDatabaseClient.createOdbNetworkAsync(parent, odbNetwork, odbNetworkId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbNetwork in the following format:
   *     projects/{project}/locations/{location}.
   * @param odbNetwork Required. Details of the OdbNetwork instance to create.
   * @param odbNetworkId Required. The ID of the OdbNetwork to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbNetwork, OperationMetadata> createOdbNetworkAsync(
      String parent, OdbNetwork odbNetwork, String odbNetworkId) {
    CreateOdbNetworkRequest request =
        CreateOdbNetworkRequest.newBuilder()
            .setParent(parent)
            .setOdbNetwork(odbNetwork)
            .setOdbNetworkId(odbNetworkId)
            .build();
    return createOdbNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbNetworkRequest request =
   *       CreateOdbNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOdbNetworkId("odbNetworkId-169900740")
   *           .setOdbNetwork(OdbNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OdbNetwork response = oracleDatabaseClient.createOdbNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbNetwork, OperationMetadata> createOdbNetworkAsync(
      CreateOdbNetworkRequest request) {
    return createOdbNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbNetworkRequest request =
   *       CreateOdbNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOdbNetworkId("odbNetworkId-169900740")
   *           .setOdbNetwork(OdbNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<OdbNetwork, OperationMetadata> future =
   *       oracleDatabaseClient.createOdbNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   OdbNetwork response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateOdbNetworkRequest, OdbNetwork, OperationMetadata>
      createOdbNetworkOperationCallable() {
    return stub.createOdbNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbNetworkRequest request =
   *       CreateOdbNetworkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOdbNetworkId("odbNetworkId-169900740")
   *           .setOdbNetwork(OdbNetwork.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createOdbNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOdbNetworkRequest, Operation> createOdbNetworkCallable() {
    return stub.createOdbNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbNetworkName name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
   *   oracleDatabaseClient.deleteOdbNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbNetworkAsync(
      OdbNetworkName name) {
    DeleteOdbNetworkRequest request =
        DeleteOdbNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteOdbNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString();
   *   oracleDatabaseClient.deleteOdbNetworkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbNetworkAsync(String name) {
    DeleteOdbNetworkRequest request = DeleteOdbNetworkRequest.newBuilder().setName(name).build();
    return deleteOdbNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbNetworkRequest request =
   *       DeleteOdbNetworkRequest.newBuilder()
   *           .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteOdbNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbNetworkAsync(
      DeleteOdbNetworkRequest request) {
    return deleteOdbNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbNetworkRequest request =
   *       DeleteOdbNetworkRequest.newBuilder()
   *           .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteOdbNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOdbNetworkRequest, Empty, OperationMetadata>
      deleteOdbNetworkOperationCallable() {
    return stub.deleteOdbNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbNetworkRequest request =
   *       DeleteOdbNetworkRequest.newBuilder()
   *           .setName(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteOdbNetworkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOdbNetworkRequest, Operation> deleteOdbNetworkCallable() {
    return stub.deleteOdbNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ODB Subnets in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
   *   for (OdbSubnet element : oracleDatabaseClient.listOdbSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbSubnetsPagedResponse listOdbSubnets(OdbNetworkName parent) {
    ListOdbSubnetsRequest request =
        ListOdbSubnetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOdbSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ODB Subnets in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString();
   *   for (OdbSubnet element : oracleDatabaseClient.listOdbSubnets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbSubnetsPagedResponse listOdbSubnets(String parent) {
    ListOdbSubnetsRequest request = ListOdbSubnetsRequest.newBuilder().setParent(parent).build();
    return listOdbSubnets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ODB Subnets in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbSubnetsRequest request =
   *       ListOdbSubnetsRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (OdbSubnet element : oracleDatabaseClient.listOdbSubnets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOdbSubnetsPagedResponse listOdbSubnets(ListOdbSubnetsRequest request) {
    return listOdbSubnetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ODB Subnets in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbSubnetsRequest request =
   *       ListOdbSubnetsRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<OdbSubnet> future =
   *       oracleDatabaseClient.listOdbSubnetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OdbSubnet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsPagedResponse>
      listOdbSubnetsPagedCallable() {
    return stub.listOdbSubnetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ODB Subnets in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListOdbSubnetsRequest request =
   *       ListOdbSubnetsRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListOdbSubnetsResponse response =
   *         oracleDatabaseClient.listOdbSubnetsCallable().call(request);
   *     for (OdbSubnet element : response.getOdbSubnetsList()) {
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
  public final UnaryCallable<ListOdbSubnetsRequest, ListOdbSubnetsResponse>
      listOdbSubnetsCallable() {
    return stub.listOdbSubnetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbSubnetName name =
   *       OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");
   *   OdbSubnet response = oracleDatabaseClient.getOdbSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbSubnet getOdbSubnet(OdbSubnetName name) {
    GetOdbSubnetRequest request =
        GetOdbSubnetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOdbSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]").toString();
   *   OdbSubnet response = oracleDatabaseClient.getOdbSubnet(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbSubnet getOdbSubnet(String name) {
    GetOdbSubnetRequest request = GetOdbSubnetRequest.newBuilder().setName(name).build();
    return getOdbSubnet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetOdbSubnetRequest request =
   *       GetOdbSubnetRequest.newBuilder()
   *           .setName(
   *               OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
   *                   .toString())
   *           .build();
   *   OdbSubnet response = oracleDatabaseClient.getOdbSubnet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OdbSubnet getOdbSubnet(GetOdbSubnetRequest request) {
    return getOdbSubnetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetOdbSubnetRequest request =
   *       GetOdbSubnetRequest.newBuilder()
   *           .setName(
   *               OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OdbSubnet> future = oracleDatabaseClient.getOdbSubnetCallable().futureCall(request);
   *   // Do something.
   *   OdbSubnet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOdbSubnetRequest, OdbSubnet> getOdbSubnetCallable() {
    return stub.getOdbSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Subnet in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbNetworkName parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]");
   *   OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
   *   String odbSubnetId = "odbSubnetId1186954661";
   *   OdbSubnet response =
   *       oracleDatabaseClient.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @param odbSubnet Required. Details of the OdbSubnet instance to create.
   * @param odbSubnetId Required. The ID of the OdbSubnet to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbSubnet, OperationMetadata> createOdbSubnetAsync(
      OdbNetworkName parent, OdbSubnet odbSubnet, String odbSubnetId) {
    CreateOdbSubnetRequest request =
        CreateOdbSubnetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOdbSubnet(odbSubnet)
            .setOdbSubnetId(odbSubnetId)
            .build();
    return createOdbSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Subnet in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString();
   *   OdbSubnet odbSubnet = OdbSubnet.newBuilder().build();
   *   String odbSubnetId = "odbSubnetId1186954661";
   *   OdbSubnet response =
   *       oracleDatabaseClient.createOdbSubnetAsync(parent, odbSubnet, odbSubnetId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the OdbSubnet in the following format:
   *     projects/{project}/locations/{location}/odbNetworks/{odb_network}.
   * @param odbSubnet Required. Details of the OdbSubnet instance to create.
   * @param odbSubnetId Required. The ID of the OdbSubnet to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbSubnet, OperationMetadata> createOdbSubnetAsync(
      String parent, OdbSubnet odbSubnet, String odbSubnetId) {
    CreateOdbSubnetRequest request =
        CreateOdbSubnetRequest.newBuilder()
            .setParent(parent)
            .setOdbSubnet(odbSubnet)
            .setOdbSubnetId(odbSubnetId)
            .build();
    return createOdbSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Subnet in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbSubnetRequest request =
   *       CreateOdbSubnetRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setOdbSubnetId("odbSubnetId1186954661")
   *           .setOdbSubnet(OdbSubnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OdbSubnet response = oracleDatabaseClient.createOdbSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<OdbSubnet, OperationMetadata> createOdbSubnetAsync(
      CreateOdbSubnetRequest request) {
    return createOdbSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Subnet in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbSubnetRequest request =
   *       CreateOdbSubnetRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setOdbSubnetId("odbSubnetId1186954661")
   *           .setOdbSubnet(OdbSubnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<OdbSubnet, OperationMetadata> future =
   *       oracleDatabaseClient.createOdbSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   OdbSubnet response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateOdbSubnetRequest, OdbSubnet, OperationMetadata>
      createOdbSubnetOperationCallable() {
    return stub.createOdbSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ODB Subnet in a given ODB Network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateOdbSubnetRequest request =
   *       CreateOdbSubnetRequest.newBuilder()
   *           .setParent(OdbNetworkName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]").toString())
   *           .setOdbSubnetId("odbSubnetId1186954661")
   *           .setOdbSubnet(OdbSubnet.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createOdbSubnetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOdbSubnetRequest, Operation> createOdbSubnetCallable() {
    return stub.createOdbSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   OdbSubnetName name =
   *       OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]");
   *   oracleDatabaseClient.deleteOdbSubnetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{region}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbSubnetAsync(OdbSubnetName name) {
    DeleteOdbSubnetRequest request =
        DeleteOdbSubnetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteOdbSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]").toString();
   *   oracleDatabaseClient.deleteOdbSubnetAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the resource in the following format:
   *     projects/{project}/locations/{region}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbSubnetAsync(String name) {
    DeleteOdbSubnetRequest request = DeleteOdbSubnetRequest.newBuilder().setName(name).build();
    return deleteOdbSubnetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbSubnetRequest request =
   *       DeleteOdbSubnetRequest.newBuilder()
   *           .setName(
   *               OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteOdbSubnetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteOdbSubnetAsync(
      DeleteOdbSubnetRequest request) {
    return deleteOdbSubnetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbSubnetRequest request =
   *       DeleteOdbSubnetRequest.newBuilder()
   *           .setName(
   *               OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteOdbSubnetOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteOdbSubnetRequest, Empty, OperationMetadata>
      deleteOdbSubnetOperationCallable() {
    return stub.deleteOdbSubnetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ODB Subnet.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteOdbSubnetRequest request =
   *       DeleteOdbSubnetRequest.newBuilder()
   *           .setName(
   *               OdbSubnetName.of("[PROJECT]", "[LOCATION]", "[ODB_NETWORK]", "[ODB_SUBNET]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteOdbSubnetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteOdbSubnetRequest, Operation> deleteOdbSubnetCallable() {
    return stub.deleteOdbSubnetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Exadb (Exascale) VM Clusters for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ExadbVmCluster element : oracleDatabaseClient.listExadbVmClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ExadbVmClusters in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExadbVmClustersPagedResponse listExadbVmClusters(LocationName parent) {
    ListExadbVmClustersRequest request =
        ListExadbVmClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExadbVmClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Exadb (Exascale) VM Clusters for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ExadbVmCluster element : oracleDatabaseClient.listExadbVmClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ExadbVmClusters in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExadbVmClustersPagedResponse listExadbVmClusters(String parent) {
    ListExadbVmClustersRequest request =
        ListExadbVmClustersRequest.newBuilder().setParent(parent).build();
    return listExadbVmClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Exadb (Exascale) VM Clusters for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExadbVmClustersRequest request =
   *       ListExadbVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ExadbVmCluster element :
   *       oracleDatabaseClient.listExadbVmClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExadbVmClustersPagedResponse listExadbVmClusters(
      ListExadbVmClustersRequest request) {
    return listExadbVmClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Exadb (Exascale) VM Clusters for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExadbVmClustersRequest request =
   *       ListExadbVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ExadbVmCluster> future =
   *       oracleDatabaseClient.listExadbVmClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExadbVmCluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersPagedResponse>
      listExadbVmClustersPagedCallable() {
    return stub.listExadbVmClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Exadb (Exascale) VM Clusters for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExadbVmClustersRequest request =
   *       ListExadbVmClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExadbVmClustersResponse response =
   *         oracleDatabaseClient.listExadbVmClustersCallable().call(request);
   *     for (ExadbVmCluster element : response.getExadbVmClustersList()) {
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
  public final UnaryCallable<ListExadbVmClustersRequest, ListExadbVmClustersResponse>
      listExadbVmClustersCallable() {
    return stub.listExadbVmClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExadbVmClusterName name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
   *   ExadbVmCluster response = oracleDatabaseClient.getExadbVmCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExadbVmCluster getExadbVmCluster(ExadbVmClusterName name) {
    GetExadbVmClusterRequest request =
        GetExadbVmClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getExadbVmCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString();
   *   ExadbVmCluster response = oracleDatabaseClient.getExadbVmCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExadbVmCluster getExadbVmCluster(String name) {
    GetExadbVmClusterRequest request = GetExadbVmClusterRequest.newBuilder().setName(name).build();
    return getExadbVmCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetExadbVmClusterRequest request =
   *       GetExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .build();
   *   ExadbVmCluster response = oracleDatabaseClient.getExadbVmCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExadbVmCluster getExadbVmCluster(GetExadbVmClusterRequest request) {
    return getExadbVmClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetExadbVmClusterRequest request =
   *       GetExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .build();
   *   ApiFuture<ExadbVmCluster> future =
   *       oracleDatabaseClient.getExadbVmClusterCallable().futureCall(request);
   *   // Do something.
   *   ExadbVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExadbVmClusterRequest, ExadbVmCluster> getExadbVmClusterCallable() {
    return stub.getExadbVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadb (Exascale) VM Cluster resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
   *   String exadbVmClusterId = "exadbVmClusterId1890152722";
   *   ExadbVmCluster response =
   *       oracleDatabaseClient
   *           .createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}.
   * @param exadbVmCluster Required. The resource being created.
   * @param exadbVmClusterId Required. The ID of the ExadbVmCluster to create. This value is
   *     restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in
   *     length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata> createExadbVmClusterAsync(
      LocationName parent, ExadbVmCluster exadbVmCluster, String exadbVmClusterId) {
    CreateExadbVmClusterRequest request =
        CreateExadbVmClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExadbVmCluster(exadbVmCluster)
            .setExadbVmClusterId(exadbVmClusterId)
            .build();
    return createExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadb (Exascale) VM Cluster resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
   *   String exadbVmClusterId = "exadbVmClusterId1890152722";
   *   ExadbVmCluster response =
   *       oracleDatabaseClient
   *           .createExadbVmClusterAsync(parent, exadbVmCluster, exadbVmClusterId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}.
   * @param exadbVmCluster Required. The resource being created.
   * @param exadbVmClusterId Required. The ID of the ExadbVmCluster to create. This value is
   *     restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in
   *     length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata> createExadbVmClusterAsync(
      String parent, ExadbVmCluster exadbVmCluster, String exadbVmClusterId) {
    CreateExadbVmClusterRequest request =
        CreateExadbVmClusterRequest.newBuilder()
            .setParent(parent)
            .setExadbVmCluster(exadbVmCluster)
            .setExadbVmClusterId(exadbVmClusterId)
            .build();
    return createExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadb (Exascale) VM Cluster resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExadbVmClusterRequest request =
   *       CreateExadbVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExadbVmClusterId("exadbVmClusterId1890152722")
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExadbVmCluster response = oracleDatabaseClient.createExadbVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata> createExadbVmClusterAsync(
      CreateExadbVmClusterRequest request) {
    return createExadbVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadb (Exascale) VM Cluster resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExadbVmClusterRequest request =
   *       CreateExadbVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExadbVmClusterId("exadbVmClusterId1890152722")
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExadbVmCluster, OperationMetadata> future =
   *       oracleDatabaseClient.createExadbVmClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   ExadbVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      createExadbVmClusterOperationCallable() {
    return stub.createExadbVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Exadb (Exascale) VM Cluster resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExadbVmClusterRequest request =
   *       CreateExadbVmClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExadbVmClusterId("exadbVmClusterId1890152722")
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createExadbVmClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExadbVmClusterRequest, Operation>
      createExadbVmClusterCallable() {
    return stub.createExadbVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExadbVmClusterName name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
   *   oracleDatabaseClient.deleteExadbVmClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExadbVmClusterAsync(
      ExadbVmClusterName name) {
    DeleteExadbVmClusterRequest request =
        DeleteExadbVmClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString();
   *   oracleDatabaseClient.deleteExadbVmClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExadbVmClusterAsync(String name) {
    DeleteExadbVmClusterRequest request =
        DeleteExadbVmClusterRequest.newBuilder().setName(name).build();
    return deleteExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExadbVmClusterRequest request =
   *       DeleteExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteExadbVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExadbVmClusterAsync(
      DeleteExadbVmClusterRequest request) {
    return deleteExadbVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExadbVmClusterRequest request =
   *       DeleteExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteExadbVmClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExadbVmClusterRequest, Empty, OperationMetadata>
      deleteExadbVmClusterOperationCallable() {
    return stub.deleteExadbVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Exadb (Exascale) VM Cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExadbVmClusterRequest request =
   *       DeleteExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteExadbVmClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExadbVmClusterRequest, Operation>
      deleteExadbVmClusterCallable() {
    return stub.deleteExadbVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to existing exadb vm
   * cluster, only pass the node count.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExadbVmCluster exadbVmCluster = ExadbVmCluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExadbVmCluster response =
   *       oracleDatabaseClient.updateExadbVmClusterAsync(exadbVmCluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param exadbVmCluster Required. The resource being updated.
   * @param updateMask Optional. A mask specifying which fields in th VM Cluster should be updated.
   *     A field specified in the mask is overwritten. If a mask isn't provided then all the fields
   *     in the VM Cluster are overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata> updateExadbVmClusterAsync(
      ExadbVmCluster exadbVmCluster, FieldMask updateMask) {
    UpdateExadbVmClusterRequest request =
        UpdateExadbVmClusterRequest.newBuilder()
            .setExadbVmCluster(exadbVmCluster)
            .setUpdateMask(updateMask)
            .build();
    return updateExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to existing exadb vm
   * cluster, only pass the node count.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateExadbVmClusterRequest request =
   *       UpdateExadbVmClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExadbVmCluster response = oracleDatabaseClient.updateExadbVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata> updateExadbVmClusterAsync(
      UpdateExadbVmClusterRequest request) {
    return updateExadbVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to existing exadb vm
   * cluster, only pass the node count.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateExadbVmClusterRequest request =
   *       UpdateExadbVmClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExadbVmCluster, OperationMetadata> future =
   *       oracleDatabaseClient.updateExadbVmClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   ExadbVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      updateExadbVmClusterOperationCallable() {
    return stub.updateExadbVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Exadb (Exascale) VM Cluster. To add virtual machines to existing exadb vm
   * cluster, only pass the node count.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   UpdateExadbVmClusterRequest request =
   *       UpdateExadbVmClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setExadbVmCluster(ExadbVmCluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.updateExadbVmClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExadbVmClusterRequest, Operation>
      updateExadbVmClusterCallable() {
    return stub.updateExadbVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes virtual machines from an existing exadb vm cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExadbVmClusterName name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]");
   *   List<String> hostnames = new ArrayList<>();
   *   ExadbVmCluster response =
   *       oracleDatabaseClient.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @param hostnames Required. The list of host names of db nodes to be removed from the
   *     ExadbVmCluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterAsync(ExadbVmClusterName name, List<String> hostnames) {
    RemoveVirtualMachineExadbVmClusterRequest request =
        RemoveVirtualMachineExadbVmClusterRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllHostnames(hostnames)
            .build();
    return removeVirtualMachineExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes virtual machines from an existing exadb vm cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString();
   *   List<String> hostnames = new ArrayList<>();
   *   ExadbVmCluster response =
   *       oracleDatabaseClient.removeVirtualMachineExadbVmClusterAsync(name, hostnames).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExadbVmCluster in the following format:
   *     projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}.
   * @param hostnames Required. The list of host names of db nodes to be removed from the
   *     ExadbVmCluster.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterAsync(String name, List<String> hostnames) {
    RemoveVirtualMachineExadbVmClusterRequest request =
        RemoveVirtualMachineExadbVmClusterRequest.newBuilder()
            .setName(name)
            .addAllHostnames(hostnames)
            .build();
    return removeVirtualMachineExadbVmClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes virtual machines from an existing exadb vm cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RemoveVirtualMachineExadbVmClusterRequest request =
   *       RemoveVirtualMachineExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .addAllHostnames(new ArrayList<String>())
   *           .build();
   *   ExadbVmCluster response =
   *       oracleDatabaseClient.removeVirtualMachineExadbVmClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterAsync(RemoveVirtualMachineExadbVmClusterRequest request) {
    return removeVirtualMachineExadbVmClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes virtual machines from an existing exadb vm cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RemoveVirtualMachineExadbVmClusterRequest request =
   *       RemoveVirtualMachineExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .addAllHostnames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<ExadbVmCluster, OperationMetadata> future =
   *       oracleDatabaseClient
   *           .removeVirtualMachineExadbVmClusterOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ExadbVmCluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RemoveVirtualMachineExadbVmClusterRequest, ExadbVmCluster, OperationMetadata>
      removeVirtualMachineExadbVmClusterOperationCallable() {
    return stub.removeVirtualMachineExadbVmClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes virtual machines from an existing exadb vm cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   RemoveVirtualMachineExadbVmClusterRequest request =
   *       RemoveVirtualMachineExadbVmClusterRequest.newBuilder()
   *           .setName(
   *               ExadbVmClusterName.of("[PROJECT]", "[LOCATION]", "[EXADB_VM_CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .addAllHostnames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.removeVirtualMachineExadbVmClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveVirtualMachineExadbVmClusterRequest, Operation>
      removeVirtualMachineExadbVmClusterCallable() {
    return stub.removeVirtualMachineExadbVmClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ExascaleDB Storage Vaults for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ExascaleDbStorageVault element :
   *       oracleDatabaseClient.listExascaleDbStorageVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExascaleDbStorageVaultsPagedResponse listExascaleDbStorageVaults(
      LocationName parent) {
    ListExascaleDbStorageVaultsRequest request =
        ListExascaleDbStorageVaultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExascaleDbStorageVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ExascaleDB Storage Vaults for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ExascaleDbStorageVault element :
   *       oracleDatabaseClient.listExascaleDbStorageVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExascaleDbStorageVaultsPagedResponse listExascaleDbStorageVaults(String parent) {
    ListExascaleDbStorageVaultsRequest request =
        ListExascaleDbStorageVaultsRequest.newBuilder().setParent(parent).build();
    return listExascaleDbStorageVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ExascaleDB Storage Vaults for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExascaleDbStorageVaultsRequest request =
   *       ListExascaleDbStorageVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ExascaleDbStorageVault element :
   *       oracleDatabaseClient.listExascaleDbStorageVaults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExascaleDbStorageVaultsPagedResponse listExascaleDbStorageVaults(
      ListExascaleDbStorageVaultsRequest request) {
    return listExascaleDbStorageVaultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ExascaleDB Storage Vaults for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExascaleDbStorageVaultsRequest request =
   *       ListExascaleDbStorageVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ExascaleDbStorageVault> future =
   *       oracleDatabaseClient.listExascaleDbStorageVaultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExascaleDbStorageVault element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsPagedResponse>
      listExascaleDbStorageVaultsPagedCallable() {
    return stub.listExascaleDbStorageVaultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the ExascaleDB Storage Vaults for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListExascaleDbStorageVaultsRequest request =
   *       ListExascaleDbStorageVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExascaleDbStorageVaultsResponse response =
   *         oracleDatabaseClient.listExascaleDbStorageVaultsCallable().call(request);
   *     for (ExascaleDbStorageVault element : response.getExascaleDbStorageVaultsList()) {
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
          ListExascaleDbStorageVaultsRequest, ListExascaleDbStorageVaultsResponse>
      listExascaleDbStorageVaultsCallable() {
    return stub.listExascaleDbStorageVaultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExascaleDbStorageVaultName name =
   *       ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");
   *   ExascaleDbStorageVault response = oracleDatabaseClient.getExascaleDbStorageVault(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExascaleDbStorageVault getExascaleDbStorageVault(ExascaleDbStorageVaultName name) {
    GetExascaleDbStorageVaultRequest request =
        GetExascaleDbStorageVaultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getExascaleDbStorageVault(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *           .toString();
   *   ExascaleDbStorageVault response = oracleDatabaseClient.getExascaleDbStorageVault(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExascaleDbStorageVault getExascaleDbStorageVault(String name) {
    GetExascaleDbStorageVaultRequest request =
        GetExascaleDbStorageVaultRequest.newBuilder().setName(name).build();
    return getExascaleDbStorageVault(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetExascaleDbStorageVaultRequest request =
   *       GetExascaleDbStorageVaultRequest.newBuilder()
   *           .setName(
   *               ExascaleDbStorageVaultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *                   .toString())
   *           .build();
   *   ExascaleDbStorageVault response = oracleDatabaseClient.getExascaleDbStorageVault(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExascaleDbStorageVault getExascaleDbStorageVault(
      GetExascaleDbStorageVaultRequest request) {
    return getExascaleDbStorageVaultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetExascaleDbStorageVaultRequest request =
   *       GetExascaleDbStorageVaultRequest.newBuilder()
   *           .setName(
   *               ExascaleDbStorageVaultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ExascaleDbStorageVault> future =
   *       oracleDatabaseClient.getExascaleDbStorageVaultCallable().futureCall(request);
   *   // Do something.
   *   ExascaleDbStorageVault response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExascaleDbStorageVaultRequest, ExascaleDbStorageVault>
      getExascaleDbStorageVaultCallable() {
    return stub.getExascaleDbStorageVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ExascaleDB Storage Vault resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
   *   String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";
   *   ExascaleDbStorageVault response =
   *       oracleDatabaseClient
   *           .createExascaleDbStorageVaultAsync(
   *               parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the ExascaleDbStorageVault in the following
   *     format: projects/{project}/locations/{location}.
   * @param exascaleDbStorageVault Required. The resource being created.
   * @param exascaleDbStorageVaultId Required. The ID of the ExascaleDbStorageVault to create. This
   *     value is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63
   *     characters in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultAsync(
          LocationName parent,
          ExascaleDbStorageVault exascaleDbStorageVault,
          String exascaleDbStorageVaultId) {
    CreateExascaleDbStorageVaultRequest request =
        CreateExascaleDbStorageVaultRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExascaleDbStorageVault(exascaleDbStorageVault)
            .setExascaleDbStorageVaultId(exascaleDbStorageVaultId)
            .build();
    return createExascaleDbStorageVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ExascaleDB Storage Vault resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExascaleDbStorageVault exascaleDbStorageVault = ExascaleDbStorageVault.newBuilder().build();
   *   String exascaleDbStorageVaultId = "exascaleDbStorageVaultId-24370132";
   *   ExascaleDbStorageVault response =
   *       oracleDatabaseClient
   *           .createExascaleDbStorageVaultAsync(
   *               parent, exascaleDbStorageVault, exascaleDbStorageVaultId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the ExascaleDbStorageVault in the following
   *     format: projects/{project}/locations/{location}.
   * @param exascaleDbStorageVault Required. The resource being created.
   * @param exascaleDbStorageVaultId Required. The ID of the ExascaleDbStorageVault to create. This
   *     value is restricted to (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63
   *     characters in length. The value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultAsync(
          String parent,
          ExascaleDbStorageVault exascaleDbStorageVault,
          String exascaleDbStorageVaultId) {
    CreateExascaleDbStorageVaultRequest request =
        CreateExascaleDbStorageVaultRequest.newBuilder()
            .setParent(parent)
            .setExascaleDbStorageVault(exascaleDbStorageVault)
            .setExascaleDbStorageVaultId(exascaleDbStorageVaultId)
            .build();
    return createExascaleDbStorageVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ExascaleDB Storage Vault resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExascaleDbStorageVaultRequest request =
   *       CreateExascaleDbStorageVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExascaleDbStorageVaultId("exascaleDbStorageVaultId-24370132")
   *           .setExascaleDbStorageVault(ExascaleDbStorageVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ExascaleDbStorageVault response =
   *       oracleDatabaseClient.createExascaleDbStorageVaultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultAsync(CreateExascaleDbStorageVaultRequest request) {
    return createExascaleDbStorageVaultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ExascaleDB Storage Vault resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExascaleDbStorageVaultRequest request =
   *       CreateExascaleDbStorageVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExascaleDbStorageVaultId("exascaleDbStorageVaultId-24370132")
   *           .setExascaleDbStorageVault(ExascaleDbStorageVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ExascaleDbStorageVault, OperationMetadata> future =
   *       oracleDatabaseClient.createExascaleDbStorageVaultOperationCallable().futureCall(request);
   *   // Do something.
   *   ExascaleDbStorageVault response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateExascaleDbStorageVaultRequest, ExascaleDbStorageVault, OperationMetadata>
      createExascaleDbStorageVaultOperationCallable() {
    return stub.createExascaleDbStorageVaultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ExascaleDB Storage Vault resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateExascaleDbStorageVaultRequest request =
   *       CreateExascaleDbStorageVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExascaleDbStorageVaultId("exascaleDbStorageVaultId-24370132")
   *           .setExascaleDbStorageVault(ExascaleDbStorageVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createExascaleDbStorageVaultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExascaleDbStorageVaultRequest, Operation>
      createExascaleDbStorageVaultCallable() {
    return stub.createExascaleDbStorageVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ExascaleDbStorageVaultName name =
   *       ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]");
   *   oracleDatabaseClient.deleteExascaleDbStorageVaultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExascaleDbStorageVaultAsync(
      ExascaleDbStorageVaultName name) {
    DeleteExascaleDbStorageVaultRequest request =
        DeleteExascaleDbStorageVaultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteExascaleDbStorageVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       ExascaleDbStorageVaultName.of("[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *           .toString();
   *   oracleDatabaseClient.deleteExascaleDbStorageVaultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ExascaleDbStorageVault in the following format:
   *     projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExascaleDbStorageVaultAsync(
      String name) {
    DeleteExascaleDbStorageVaultRequest request =
        DeleteExascaleDbStorageVaultRequest.newBuilder().setName(name).build();
    return deleteExascaleDbStorageVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExascaleDbStorageVaultRequest request =
   *       DeleteExascaleDbStorageVaultRequest.newBuilder()
   *           .setName(
   *               ExascaleDbStorageVaultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteExascaleDbStorageVaultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteExascaleDbStorageVaultAsync(
      DeleteExascaleDbStorageVaultRequest request) {
    return deleteExascaleDbStorageVaultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExascaleDbStorageVaultRequest request =
   *       DeleteExascaleDbStorageVaultRequest.newBuilder()
   *           .setName(
   *               ExascaleDbStorageVaultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteExascaleDbStorageVaultOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExascaleDbStorageVaultRequest, Empty, OperationMetadata>
      deleteExascaleDbStorageVaultOperationCallable() {
    return stub.deleteExascaleDbStorageVaultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ExascaleDB Storage Vault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteExascaleDbStorageVaultRequest request =
   *       DeleteExascaleDbStorageVaultRequest.newBuilder()
   *           .setName(
   *               ExascaleDbStorageVaultName.of(
   *                       "[PROJECT]", "[LOCATION]", "[EXASCALE_DB_STORAGE_VAULT]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteExascaleDbStorageVaultCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExascaleDbStorageVaultRequest, Operation>
      deleteExascaleDbStorageVaultCallable() {
    return stub.deleteExascaleDbStorageVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystemInitialStorageSizes for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DbSystemInitialStorageSize element :
   *       oracleDatabaseClient.listDbSystemInitialStorageSizes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the DbSystemInitialStorageSize resource with the
   *     format: projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemInitialStorageSizesPagedResponse listDbSystemInitialStorageSizes(
      LocationName parent) {
    ListDbSystemInitialStorageSizesRequest request =
        ListDbSystemInitialStorageSizesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbSystemInitialStorageSizes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystemInitialStorageSizes for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DbSystemInitialStorageSize element :
   *       oracleDatabaseClient.listDbSystemInitialStorageSizes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the DbSystemInitialStorageSize resource with the
   *     format: projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemInitialStorageSizesPagedResponse listDbSystemInitialStorageSizes(
      String parent) {
    ListDbSystemInitialStorageSizesRequest request =
        ListDbSystemInitialStorageSizesRequest.newBuilder().setParent(parent).build();
    return listDbSystemInitialStorageSizes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystemInitialStorageSizes for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemInitialStorageSizesRequest request =
   *       ListDbSystemInitialStorageSizesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DbSystemInitialStorageSize element :
   *       oracleDatabaseClient.listDbSystemInitialStorageSizes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemInitialStorageSizesPagedResponse listDbSystemInitialStorageSizes(
      ListDbSystemInitialStorageSizesRequest request) {
    return listDbSystemInitialStorageSizesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystemInitialStorageSizes for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemInitialStorageSizesRequest request =
   *       ListDbSystemInitialStorageSizesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DbSystemInitialStorageSize> future =
   *       oracleDatabaseClient.listDbSystemInitialStorageSizesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbSystemInitialStorageSize element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesPagedResponse>
      listDbSystemInitialStorageSizesPagedCallable() {
    return stub.listDbSystemInitialStorageSizesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystemInitialStorageSizes for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemInitialStorageSizesRequest request =
   *       ListDbSystemInitialStorageSizesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDbSystemInitialStorageSizesResponse response =
   *         oracleDatabaseClient.listDbSystemInitialStorageSizesCallable().call(request);
   *     for (DbSystemInitialStorageSize element : response.getDbSystemInitialStorageSizesList()) {
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
          ListDbSystemInitialStorageSizesRequest, ListDbSystemInitialStorageSizesResponse>
      listDbSystemInitialStorageSizesCallable() {
    return stub.listDbSystemInitialStorageSizesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Databases for the given project, location and DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Database element : oracleDatabaseClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name in the following format:
   *     projects/{project}/locations/{region}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(LocationName parent) {
    ListDatabasesRequest request =
        ListDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Databases for the given project, location and DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Database element : oracleDatabaseClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name in the following format:
   *     projects/{project}/locations/{region}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(String parent) {
    ListDatabasesRequest request = ListDatabasesRequest.newBuilder().setParent(parent).build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Databases for the given project, location and DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Database element : oracleDatabaseClient.listDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(ListDatabasesRequest request) {
    return listDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Databases for the given project, location and DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Database> future =
   *       oracleDatabaseClient.listDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Database element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return stub.listDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the Databases for the given project, location and DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDatabasesResponse response = oracleDatabaseClient.listDatabasesCallable().call(request);
   *     for (Database element : response.getDatabasesList()) {
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
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return stub.listDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]");
   *   Database response = oracleDatabaseClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Database resource in the following format:
   *     projects/{project}/locations/{region}/databases/{database}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(DatabaseName name) {
    GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]").toString();
   *   Database response = oracleDatabaseClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Database resource in the following format:
   *     projects/{project}/locations/{region}/databases/{database}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(String name) {
    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(name).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]").toString())
   *           .build();
   *   Database response = oracleDatabaseClient.getDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(GetDatabaseRequest request) {
    return getDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[LOCATION]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Database> future = oracleDatabaseClient.getDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return stub.getDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the PluggableDatabases for the given project, location and Container Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PluggableDatabase element :
   *       oracleDatabaseClient.listPluggableDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PluggableDatabases. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluggableDatabasesPagedResponse listPluggableDatabases(LocationName parent) {
    ListPluggableDatabasesRequest request =
        ListPluggableDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPluggableDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the PluggableDatabases for the given project, location and Container Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PluggableDatabase element :
   *       oracleDatabaseClient.listPluggableDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PluggableDatabases. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluggableDatabasesPagedResponse listPluggableDatabases(String parent) {
    ListPluggableDatabasesRequest request =
        ListPluggableDatabasesRequest.newBuilder().setParent(parent).build();
    return listPluggableDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the PluggableDatabases for the given project, location and Container Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListPluggableDatabasesRequest request =
   *       ListPluggableDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (PluggableDatabase element :
   *       oracleDatabaseClient.listPluggableDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPluggableDatabasesPagedResponse listPluggableDatabases(
      ListPluggableDatabasesRequest request) {
    return listPluggableDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the PluggableDatabases for the given project, location and Container Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListPluggableDatabasesRequest request =
   *       ListPluggableDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<PluggableDatabase> future =
   *       oracleDatabaseClient.listPluggableDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PluggableDatabase element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesPagedResponse>
      listPluggableDatabasesPagedCallable() {
    return stub.listPluggableDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the PluggableDatabases for the given project, location and Container Database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListPluggableDatabasesRequest request =
   *       ListPluggableDatabasesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListPluggableDatabasesResponse response =
   *         oracleDatabaseClient.listPluggableDatabasesCallable().call(request);
   *     for (PluggableDatabase element : response.getPluggableDatabasesList()) {
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
  public final UnaryCallable<ListPluggableDatabasesRequest, ListPluggableDatabasesResponse>
      listPluggableDatabasesCallable() {
    return stub.listPluggableDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PluggableDatabase.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   PluggableDatabaseName name =
   *       PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]");
   *   PluggableDatabase response = oracleDatabaseClient.getPluggableDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PluggableDatabase resource in the following format:
   *     projects/{project}/locations/{region}/pluggableDatabases/{pluggable_database}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluggableDatabase getPluggableDatabase(PluggableDatabaseName name) {
    GetPluggableDatabaseRequest request =
        GetPluggableDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPluggableDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PluggableDatabase.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name =
   *       PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]").toString();
   *   PluggableDatabase response = oracleDatabaseClient.getPluggableDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PluggableDatabase resource in the following format:
   *     projects/{project}/locations/{region}/pluggableDatabases/{pluggable_database}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluggableDatabase getPluggableDatabase(String name) {
    GetPluggableDatabaseRequest request =
        GetPluggableDatabaseRequest.newBuilder().setName(name).build();
    return getPluggableDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PluggableDatabase.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetPluggableDatabaseRequest request =
   *       GetPluggableDatabaseRequest.newBuilder()
   *           .setName(
   *               PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]")
   *                   .toString())
   *           .build();
   *   PluggableDatabase response = oracleDatabaseClient.getPluggableDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PluggableDatabase getPluggableDatabase(GetPluggableDatabaseRequest request) {
    return getPluggableDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single PluggableDatabase.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetPluggableDatabaseRequest request =
   *       GetPluggableDatabaseRequest.newBuilder()
   *           .setName(
   *               PluggableDatabaseName.of("[PROJECT]", "[LOCATION]", "[PLUGGABLE_DATABASE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PluggableDatabase> future =
   *       oracleDatabaseClient.getPluggableDatabaseCallable().futureCall(request);
   *   // Do something.
   *   PluggableDatabase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPluggableDatabaseRequest, PluggableDatabase>
      getPluggableDatabaseCallable() {
    return stub.getPluggableDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystems for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DbSystem element : oracleDatabaseClient.listDbSystems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for DbSystems in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemsPagedResponse listDbSystems(LocationName parent) {
    ListDbSystemsRequest request =
        ListDbSystemsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbSystems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystems for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DbSystem element : oracleDatabaseClient.listDbSystems(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for DbSystems in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemsPagedResponse listDbSystems(String parent) {
    ListDbSystemsRequest request = ListDbSystemsRequest.newBuilder().setParent(parent).build();
    return listDbSystems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystems for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemsRequest request =
   *       ListDbSystemsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DbSystem element : oracleDatabaseClient.listDbSystems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbSystemsPagedResponse listDbSystems(ListDbSystemsRequest request) {
    return listDbSystemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystems for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemsRequest request =
   *       ListDbSystemsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DbSystem> future =
   *       oracleDatabaseClient.listDbSystemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbSystem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDbSystemsRequest, ListDbSystemsPagedResponse>
      listDbSystemsPagedCallable() {
    return stub.listDbSystemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DbSystems for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbSystemsRequest request =
   *       ListDbSystemsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDbSystemsResponse response = oracleDatabaseClient.listDbSystemsCallable().call(request);
   *     for (DbSystem element : response.getDbSystemsList()) {
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
  public final UnaryCallable<ListDbSystemsRequest, ListDbSystemsResponse> listDbSystemsCallable() {
    return stub.listDbSystemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");
   *   DbSystem response = oracleDatabaseClient.getDbSystem(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DbSystem in the following format:
   *     projects/{project}/locations/{location}/dbSystems/{db_system}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DbSystem getDbSystem(DbSystemName name) {
    GetDbSystemRequest request =
        GetDbSystemRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDbSystem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString();
   *   DbSystem response = oracleDatabaseClient.getDbSystem(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DbSystem in the following format:
   *     projects/{project}/locations/{location}/dbSystems/{db_system}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DbSystem getDbSystem(String name) {
    GetDbSystemRequest request = GetDbSystemRequest.newBuilder().setName(name).build();
    return getDbSystem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetDbSystemRequest request =
   *       GetDbSystemRequest.newBuilder()
   *           .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
   *           .build();
   *   DbSystem response = oracleDatabaseClient.getDbSystem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DbSystem getDbSystem(GetDbSystemRequest request) {
    return getDbSystemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetDbSystemRequest request =
   *       GetDbSystemRequest.newBuilder()
   *           .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
   *           .build();
   *   ApiFuture<DbSystem> future = oracleDatabaseClient.getDbSystemCallable().futureCall(request);
   *   // Do something.
   *   DbSystem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDbSystemRequest, DbSystem> getDbSystemCallable() {
    return stub.getDbSystemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DbSystem in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DbSystem dbSystem = DbSystem.newBuilder().build();
   *   String dbSystemId = "dbSystemId-1467630008";
   *   DbSystem response =
   *       oracleDatabaseClient.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the DbSystem in the following format:
   *     projects/{project}/locations/{location}.
   * @param dbSystem Required. The resource being created.
   * @param dbSystemId Required. The ID of the DbSystem to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DbSystem, OperationMetadata> createDbSystemAsync(
      LocationName parent, DbSystem dbSystem, String dbSystemId) {
    CreateDbSystemRequest request =
        CreateDbSystemRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDbSystem(dbSystem)
            .setDbSystemId(dbSystemId)
            .build();
    return createDbSystemAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DbSystem in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DbSystem dbSystem = DbSystem.newBuilder().build();
   *   String dbSystemId = "dbSystemId-1467630008";
   *   DbSystem response =
   *       oracleDatabaseClient.createDbSystemAsync(parent, dbSystem, dbSystemId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The value for parent of the DbSystem in the following format:
   *     projects/{project}/locations/{location}.
   * @param dbSystem Required. The resource being created.
   * @param dbSystemId Required. The ID of the DbSystem to create. This value is restricted to
   *     (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$) and must be a maximum of 63 characters in length. The
   *     value must start with a letter and end with a letter or a number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DbSystem, OperationMetadata> createDbSystemAsync(
      String parent, DbSystem dbSystem, String dbSystemId) {
    CreateDbSystemRequest request =
        CreateDbSystemRequest.newBuilder()
            .setParent(parent)
            .setDbSystem(dbSystem)
            .setDbSystemId(dbSystemId)
            .build();
    return createDbSystemAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DbSystem in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateDbSystemRequest request =
   *       CreateDbSystemRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDbSystemId("dbSystemId-1467630008")
   *           .setDbSystem(DbSystem.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   DbSystem response = oracleDatabaseClient.createDbSystemAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DbSystem, OperationMetadata> createDbSystemAsync(
      CreateDbSystemRequest request) {
    return createDbSystemOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DbSystem in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateDbSystemRequest request =
   *       CreateDbSystemRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDbSystemId("dbSystemId-1467630008")
   *           .setDbSystem(DbSystem.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<DbSystem, OperationMetadata> future =
   *       oracleDatabaseClient.createDbSystemOperationCallable().futureCall(request);
   *   // Do something.
   *   DbSystem response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDbSystemRequest, DbSystem, OperationMetadata>
      createDbSystemOperationCallable() {
    return stub.createDbSystemOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DbSystem in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   CreateDbSystemRequest request =
   *       CreateDbSystemRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDbSystemId("dbSystemId-1467630008")
   *           .setDbSystem(DbSystem.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.createDbSystemCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDbSystemRequest, Operation> createDbSystemCallable() {
    return stub.createDbSystemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DbSystemName name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]");
   *   oracleDatabaseClient.deleteDbSystemAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DbSystem in the following format:
   *     projects/{project}/locations/{location}/dbSystems/{db_system}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDbSystemAsync(DbSystemName name) {
    DeleteDbSystemRequest request =
        DeleteDbSystemRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDbSystemAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String name = DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString();
   *   oracleDatabaseClient.deleteDbSystemAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the DbSystem in the following format:
   *     projects/{project}/locations/{location}/dbSystems/{db_system}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDbSystemAsync(String name) {
    DeleteDbSystemRequest request = DeleteDbSystemRequest.newBuilder().setName(name).build();
    return deleteDbSystemAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteDbSystemRequest request =
   *       DeleteDbSystemRequest.newBuilder()
   *           .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   oracleDatabaseClient.deleteDbSystemAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteDbSystemAsync(
      DeleteDbSystemRequest request) {
    return deleteDbSystemOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteDbSystemRequest request =
   *       DeleteDbSystemRequest.newBuilder()
   *           .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       oracleDatabaseClient.deleteDbSystemOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDbSystemRequest, Empty, OperationMetadata>
      deleteDbSystemOperationCallable() {
    return stub.deleteDbSystemOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DbSystem.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   DeleteDbSystemRequest request =
   *       DeleteDbSystemRequest.newBuilder()
   *           .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       oracleDatabaseClient.deleteDbSystemCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDbSystemRequest, Operation> deleteDbSystemCallable() {
    return stub.deleteDbSystemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DbVersions for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DbVersion element : oracleDatabaseClient.listDbVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the DbVersion resource with the format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbVersionsPagedResponse listDbVersions(LocationName parent) {
    ListDbVersionsRequest request =
        ListDbVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDbVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DbVersions for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DbVersion element : oracleDatabaseClient.listDbVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for the DbVersion resource with the format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbVersionsPagedResponse listDbVersions(String parent) {
    ListDbVersionsRequest request = ListDbVersionsRequest.newBuilder().setParent(parent).build();
    return listDbVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DbVersions for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbVersionsRequest request =
   *       ListDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DbVersion element : oracleDatabaseClient.listDbVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDbVersionsPagedResponse listDbVersions(ListDbVersionsRequest request) {
    return listDbVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DbVersions for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbVersionsRequest request =
   *       ListDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DbVersion> future =
   *       oracleDatabaseClient.listDbVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DbVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDbVersionsRequest, ListDbVersionsPagedResponse>
      listDbVersionsPagedCallable() {
    return stub.listDbVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DbVersions for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDbVersionsRequest request =
   *       ListDbVersionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDbVersionsResponse response =
   *         oracleDatabaseClient.listDbVersionsCallable().call(request);
   *     for (DbVersion element : response.getDbVersionsList()) {
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
  public final UnaryCallable<ListDbVersionsRequest, ListDbVersionsResponse>
      listDbVersionsCallable() {
    return stub.listDbVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DatabaseCharacterSets for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DatabaseCharacterSet element :
   *       oracleDatabaseClient.listDatabaseCharacterSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for DatabaseCharacterSets in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseCharacterSetsPagedResponse listDatabaseCharacterSets(
      LocationName parent) {
    ListDatabaseCharacterSetsRequest request =
        ListDatabaseCharacterSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabaseCharacterSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DatabaseCharacterSets for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DatabaseCharacterSet element :
   *       oracleDatabaseClient.listDatabaseCharacterSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for DatabaseCharacterSets in the following format:
   *     projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseCharacterSetsPagedResponse listDatabaseCharacterSets(String parent) {
    ListDatabaseCharacterSetsRequest request =
        ListDatabaseCharacterSetsRequest.newBuilder().setParent(parent).build();
    return listDatabaseCharacterSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DatabaseCharacterSets for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabaseCharacterSetsRequest request =
   *       ListDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DatabaseCharacterSet element :
   *       oracleDatabaseClient.listDatabaseCharacterSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseCharacterSetsPagedResponse listDatabaseCharacterSets(
      ListDatabaseCharacterSetsRequest request) {
    return listDatabaseCharacterSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DatabaseCharacterSets for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabaseCharacterSetsRequest request =
   *       ListDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DatabaseCharacterSet> future =
   *       oracleDatabaseClient.listDatabaseCharacterSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatabaseCharacterSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsPagedResponse>
      listDatabaseCharacterSetsPagedCallable() {
    return stub.listDatabaseCharacterSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List DatabaseCharacterSets for the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListDatabaseCharacterSetsRequest request =
   *       ListDatabaseCharacterSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDatabaseCharacterSetsResponse response =
   *         oracleDatabaseClient.listDatabaseCharacterSetsCallable().call(request);
   *     for (DatabaseCharacterSet element : response.getDatabaseCharacterSetsList()) {
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
  public final UnaryCallable<ListDatabaseCharacterSetsRequest, ListDatabaseCharacterSetsResponse>
      listDatabaseCharacterSetsCallable() {
    return stub.listDatabaseCharacterSetsCallable();
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
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : oracleDatabaseClient.listLocations(request).iterateAll()) {
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
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       oracleDatabaseClient.listLocationsPagedCallable().futureCall(request);
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
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = oracleDatabaseClient.listLocationsCallable().call(request);
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
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = oracleDatabaseClient.getLocation(request);
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
   * try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = oracleDatabaseClient.getLocationCallable().futureCall(request);
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

  public static class ListCloudExadataInfrastructuresPagedResponse
      extends AbstractPagedListResponse<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          CloudExadataInfrastructure,
          ListCloudExadataInfrastructuresPage,
          ListCloudExadataInfrastructuresFixedSizeCollection> {

    public static ApiFuture<ListCloudExadataInfrastructuresPagedResponse> createAsync(
        PageContext<
                ListCloudExadataInfrastructuresRequest,
                ListCloudExadataInfrastructuresResponse,
                CloudExadataInfrastructure>
            context,
        ApiFuture<ListCloudExadataInfrastructuresResponse> futureResponse) {
      ApiFuture<ListCloudExadataInfrastructuresPage> futurePage =
          ListCloudExadataInfrastructuresPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloudExadataInfrastructuresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloudExadataInfrastructuresPagedResponse(ListCloudExadataInfrastructuresPage page) {
      super(page, ListCloudExadataInfrastructuresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloudExadataInfrastructuresPage
      extends AbstractPage<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          CloudExadataInfrastructure,
          ListCloudExadataInfrastructuresPage> {

    private ListCloudExadataInfrastructuresPage(
        PageContext<
                ListCloudExadataInfrastructuresRequest,
                ListCloudExadataInfrastructuresResponse,
                CloudExadataInfrastructure>
            context,
        ListCloudExadataInfrastructuresResponse response) {
      super(context, response);
    }

    private static ListCloudExadataInfrastructuresPage createEmptyPage() {
      return new ListCloudExadataInfrastructuresPage(null, null);
    }

    @Override
    protected ListCloudExadataInfrastructuresPage createPage(
        PageContext<
                ListCloudExadataInfrastructuresRequest,
                ListCloudExadataInfrastructuresResponse,
                CloudExadataInfrastructure>
            context,
        ListCloudExadataInfrastructuresResponse response) {
      return new ListCloudExadataInfrastructuresPage(context, response);
    }

    @Override
    public ApiFuture<ListCloudExadataInfrastructuresPage> createPageAsync(
        PageContext<
                ListCloudExadataInfrastructuresRequest,
                ListCloudExadataInfrastructuresResponse,
                CloudExadataInfrastructure>
            context,
        ApiFuture<ListCloudExadataInfrastructuresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloudExadataInfrastructuresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloudExadataInfrastructuresRequest,
          ListCloudExadataInfrastructuresResponse,
          CloudExadataInfrastructure,
          ListCloudExadataInfrastructuresPage,
          ListCloudExadataInfrastructuresFixedSizeCollection> {

    private ListCloudExadataInfrastructuresFixedSizeCollection(
        List<ListCloudExadataInfrastructuresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloudExadataInfrastructuresFixedSizeCollection createEmptyCollection() {
      return new ListCloudExadataInfrastructuresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloudExadataInfrastructuresFixedSizeCollection createCollection(
        List<ListCloudExadataInfrastructuresPage> pages, int collectionSize) {
      return new ListCloudExadataInfrastructuresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCloudVmClustersPagedResponse
      extends AbstractPagedListResponse<
          ListCloudVmClustersRequest,
          ListCloudVmClustersResponse,
          CloudVmCluster,
          ListCloudVmClustersPage,
          ListCloudVmClustersFixedSizeCollection> {

    public static ApiFuture<ListCloudVmClustersPagedResponse> createAsync(
        PageContext<ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
            context,
        ApiFuture<ListCloudVmClustersResponse> futureResponse) {
      ApiFuture<ListCloudVmClustersPage> futurePage =
          ListCloudVmClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloudVmClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloudVmClustersPagedResponse(ListCloudVmClustersPage page) {
      super(page, ListCloudVmClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloudVmClustersPage
      extends AbstractPage<
          ListCloudVmClustersRequest,
          ListCloudVmClustersResponse,
          CloudVmCluster,
          ListCloudVmClustersPage> {

    private ListCloudVmClustersPage(
        PageContext<ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
            context,
        ListCloudVmClustersResponse response) {
      super(context, response);
    }

    private static ListCloudVmClustersPage createEmptyPage() {
      return new ListCloudVmClustersPage(null, null);
    }

    @Override
    protected ListCloudVmClustersPage createPage(
        PageContext<ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
            context,
        ListCloudVmClustersResponse response) {
      return new ListCloudVmClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListCloudVmClustersPage> createPageAsync(
        PageContext<ListCloudVmClustersRequest, ListCloudVmClustersResponse, CloudVmCluster>
            context,
        ApiFuture<ListCloudVmClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloudVmClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloudVmClustersRequest,
          ListCloudVmClustersResponse,
          CloudVmCluster,
          ListCloudVmClustersPage,
          ListCloudVmClustersFixedSizeCollection> {

    private ListCloudVmClustersFixedSizeCollection(
        List<ListCloudVmClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloudVmClustersFixedSizeCollection createEmptyCollection() {
      return new ListCloudVmClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloudVmClustersFixedSizeCollection createCollection(
        List<ListCloudVmClustersPage> pages, int collectionSize) {
      return new ListCloudVmClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntitlementsPagedResponse
      extends AbstractPagedListResponse<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    public static ApiFuture<ListEntitlementsPagedResponse> createAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      ApiFuture<ListEntitlementsPage> futurePage =
          ListEntitlementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntitlementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntitlementsPagedResponse(ListEntitlementsPage page) {
      super(page, ListEntitlementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntitlementsPage
      extends AbstractPage<
          ListEntitlementsRequest, ListEntitlementsResponse, Entitlement, ListEntitlementsPage> {

    private ListEntitlementsPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      super(context, response);
    }

    private static ListEntitlementsPage createEmptyPage() {
      return new ListEntitlementsPage(null, null);
    }

    @Override
    protected ListEntitlementsPage createPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      return new ListEntitlementsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntitlementsPage> createPageAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntitlementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    private ListEntitlementsFixedSizeCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntitlementsFixedSizeCollection createEmptyCollection() {
      return new ListEntitlementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntitlementsFixedSizeCollection createCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      return new ListEntitlementsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbServersPagedResponse
      extends AbstractPagedListResponse<
          ListDbServersRequest,
          ListDbServersResponse,
          DbServer,
          ListDbServersPage,
          ListDbServersFixedSizeCollection> {

    public static ApiFuture<ListDbServersPagedResponse> createAsync(
        PageContext<ListDbServersRequest, ListDbServersResponse, DbServer> context,
        ApiFuture<ListDbServersResponse> futureResponse) {
      ApiFuture<ListDbServersPage> futurePage =
          ListDbServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDbServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDbServersPagedResponse(ListDbServersPage page) {
      super(page, ListDbServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbServersPage
      extends AbstractPage<
          ListDbServersRequest, ListDbServersResponse, DbServer, ListDbServersPage> {

    private ListDbServersPage(
        PageContext<ListDbServersRequest, ListDbServersResponse, DbServer> context,
        ListDbServersResponse response) {
      super(context, response);
    }

    private static ListDbServersPage createEmptyPage() {
      return new ListDbServersPage(null, null);
    }

    @Override
    protected ListDbServersPage createPage(
        PageContext<ListDbServersRequest, ListDbServersResponse, DbServer> context,
        ListDbServersResponse response) {
      return new ListDbServersPage(context, response);
    }

    @Override
    public ApiFuture<ListDbServersPage> createPageAsync(
        PageContext<ListDbServersRequest, ListDbServersResponse, DbServer> context,
        ApiFuture<ListDbServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbServersRequest,
          ListDbServersResponse,
          DbServer,
          ListDbServersPage,
          ListDbServersFixedSizeCollection> {

    private ListDbServersFixedSizeCollection(List<ListDbServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbServersFixedSizeCollection createEmptyCollection() {
      return new ListDbServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbServersFixedSizeCollection createCollection(
        List<ListDbServersPage> pages, int collectionSize) {
      return new ListDbServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbNodesPagedResponse
      extends AbstractPagedListResponse<
          ListDbNodesRequest,
          ListDbNodesResponse,
          DbNode,
          ListDbNodesPage,
          ListDbNodesFixedSizeCollection> {

    public static ApiFuture<ListDbNodesPagedResponse> createAsync(
        PageContext<ListDbNodesRequest, ListDbNodesResponse, DbNode> context,
        ApiFuture<ListDbNodesResponse> futureResponse) {
      ApiFuture<ListDbNodesPage> futurePage =
          ListDbNodesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListDbNodesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListDbNodesPagedResponse(ListDbNodesPage page) {
      super(page, ListDbNodesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbNodesPage
      extends AbstractPage<ListDbNodesRequest, ListDbNodesResponse, DbNode, ListDbNodesPage> {

    private ListDbNodesPage(
        PageContext<ListDbNodesRequest, ListDbNodesResponse, DbNode> context,
        ListDbNodesResponse response) {
      super(context, response);
    }

    private static ListDbNodesPage createEmptyPage() {
      return new ListDbNodesPage(null, null);
    }

    @Override
    protected ListDbNodesPage createPage(
        PageContext<ListDbNodesRequest, ListDbNodesResponse, DbNode> context,
        ListDbNodesResponse response) {
      return new ListDbNodesPage(context, response);
    }

    @Override
    public ApiFuture<ListDbNodesPage> createPageAsync(
        PageContext<ListDbNodesRequest, ListDbNodesResponse, DbNode> context,
        ApiFuture<ListDbNodesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbNodesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbNodesRequest,
          ListDbNodesResponse,
          DbNode,
          ListDbNodesPage,
          ListDbNodesFixedSizeCollection> {

    private ListDbNodesFixedSizeCollection(List<ListDbNodesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbNodesFixedSizeCollection createEmptyCollection() {
      return new ListDbNodesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbNodesFixedSizeCollection createCollection(
        List<ListDbNodesPage> pages, int collectionSize) {
      return new ListDbNodesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGiVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListGiVersionsRequest,
          ListGiVersionsResponse,
          GiVersion,
          ListGiVersionsPage,
          ListGiVersionsFixedSizeCollection> {

    public static ApiFuture<ListGiVersionsPagedResponse> createAsync(
        PageContext<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion> context,
        ApiFuture<ListGiVersionsResponse> futureResponse) {
      ApiFuture<ListGiVersionsPage> futurePage =
          ListGiVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGiVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGiVersionsPagedResponse(ListGiVersionsPage page) {
      super(page, ListGiVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGiVersionsPage
      extends AbstractPage<
          ListGiVersionsRequest, ListGiVersionsResponse, GiVersion, ListGiVersionsPage> {

    private ListGiVersionsPage(
        PageContext<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion> context,
        ListGiVersionsResponse response) {
      super(context, response);
    }

    private static ListGiVersionsPage createEmptyPage() {
      return new ListGiVersionsPage(null, null);
    }

    @Override
    protected ListGiVersionsPage createPage(
        PageContext<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion> context,
        ListGiVersionsResponse response) {
      return new ListGiVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListGiVersionsPage> createPageAsync(
        PageContext<ListGiVersionsRequest, ListGiVersionsResponse, GiVersion> context,
        ApiFuture<ListGiVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGiVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGiVersionsRequest,
          ListGiVersionsResponse,
          GiVersion,
          ListGiVersionsPage,
          ListGiVersionsFixedSizeCollection> {

    private ListGiVersionsFixedSizeCollection(List<ListGiVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGiVersionsFixedSizeCollection createEmptyCollection() {
      return new ListGiVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGiVersionsFixedSizeCollection createCollection(
        List<ListGiVersionsPage> pages, int collectionSize) {
      return new ListGiVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMinorVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListMinorVersionsRequest,
          ListMinorVersionsResponse,
          MinorVersion,
          ListMinorVersionsPage,
          ListMinorVersionsFixedSizeCollection> {

    public static ApiFuture<ListMinorVersionsPagedResponse> createAsync(
        PageContext<ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion> context,
        ApiFuture<ListMinorVersionsResponse> futureResponse) {
      ApiFuture<ListMinorVersionsPage> futurePage =
          ListMinorVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMinorVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMinorVersionsPagedResponse(ListMinorVersionsPage page) {
      super(page, ListMinorVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMinorVersionsPage
      extends AbstractPage<
          ListMinorVersionsRequest,
          ListMinorVersionsResponse,
          MinorVersion,
          ListMinorVersionsPage> {

    private ListMinorVersionsPage(
        PageContext<ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion> context,
        ListMinorVersionsResponse response) {
      super(context, response);
    }

    private static ListMinorVersionsPage createEmptyPage() {
      return new ListMinorVersionsPage(null, null);
    }

    @Override
    protected ListMinorVersionsPage createPage(
        PageContext<ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion> context,
        ListMinorVersionsResponse response) {
      return new ListMinorVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListMinorVersionsPage> createPageAsync(
        PageContext<ListMinorVersionsRequest, ListMinorVersionsResponse, MinorVersion> context,
        ApiFuture<ListMinorVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMinorVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMinorVersionsRequest,
          ListMinorVersionsResponse,
          MinorVersion,
          ListMinorVersionsPage,
          ListMinorVersionsFixedSizeCollection> {

    private ListMinorVersionsFixedSizeCollection(
        List<ListMinorVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMinorVersionsFixedSizeCollection createEmptyCollection() {
      return new ListMinorVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMinorVersionsFixedSizeCollection createCollection(
        List<ListMinorVersionsPage> pages, int collectionSize) {
      return new ListMinorVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbSystemShapesPagedResponse
      extends AbstractPagedListResponse<
          ListDbSystemShapesRequest,
          ListDbSystemShapesResponse,
          DbSystemShape,
          ListDbSystemShapesPage,
          ListDbSystemShapesFixedSizeCollection> {

    public static ApiFuture<ListDbSystemShapesPagedResponse> createAsync(
        PageContext<ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape> context,
        ApiFuture<ListDbSystemShapesResponse> futureResponse) {
      ApiFuture<ListDbSystemShapesPage> futurePage =
          ListDbSystemShapesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDbSystemShapesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDbSystemShapesPagedResponse(ListDbSystemShapesPage page) {
      super(page, ListDbSystemShapesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbSystemShapesPage
      extends AbstractPage<
          ListDbSystemShapesRequest,
          ListDbSystemShapesResponse,
          DbSystemShape,
          ListDbSystemShapesPage> {

    private ListDbSystemShapesPage(
        PageContext<ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape> context,
        ListDbSystemShapesResponse response) {
      super(context, response);
    }

    private static ListDbSystemShapesPage createEmptyPage() {
      return new ListDbSystemShapesPage(null, null);
    }

    @Override
    protected ListDbSystemShapesPage createPage(
        PageContext<ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape> context,
        ListDbSystemShapesResponse response) {
      return new ListDbSystemShapesPage(context, response);
    }

    @Override
    public ApiFuture<ListDbSystemShapesPage> createPageAsync(
        PageContext<ListDbSystemShapesRequest, ListDbSystemShapesResponse, DbSystemShape> context,
        ApiFuture<ListDbSystemShapesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbSystemShapesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbSystemShapesRequest,
          ListDbSystemShapesResponse,
          DbSystemShape,
          ListDbSystemShapesPage,
          ListDbSystemShapesFixedSizeCollection> {

    private ListDbSystemShapesFixedSizeCollection(
        List<ListDbSystemShapesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbSystemShapesFixedSizeCollection createEmptyCollection() {
      return new ListDbSystemShapesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbSystemShapesFixedSizeCollection createCollection(
        List<ListDbSystemShapesPage> pages, int collectionSize) {
      return new ListDbSystemShapesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutonomousDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          AutonomousDatabase,
          ListAutonomousDatabasesPage,
          ListAutonomousDatabasesFixedSizeCollection> {

    public static ApiFuture<ListAutonomousDatabasesPagedResponse> createAsync(
        PageContext<
                ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse, AutonomousDatabase>
            context,
        ApiFuture<ListAutonomousDatabasesResponse> futureResponse) {
      ApiFuture<ListAutonomousDatabasesPage> futurePage =
          ListAutonomousDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutonomousDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutonomousDatabasesPagedResponse(ListAutonomousDatabasesPage page) {
      super(page, ListAutonomousDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutonomousDatabasesPage
      extends AbstractPage<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          AutonomousDatabase,
          ListAutonomousDatabasesPage> {

    private ListAutonomousDatabasesPage(
        PageContext<
                ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse, AutonomousDatabase>
            context,
        ListAutonomousDatabasesResponse response) {
      super(context, response);
    }

    private static ListAutonomousDatabasesPage createEmptyPage() {
      return new ListAutonomousDatabasesPage(null, null);
    }

    @Override
    protected ListAutonomousDatabasesPage createPage(
        PageContext<
                ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse, AutonomousDatabase>
            context,
        ListAutonomousDatabasesResponse response) {
      return new ListAutonomousDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListAutonomousDatabasesPage> createPageAsync(
        PageContext<
                ListAutonomousDatabasesRequest, ListAutonomousDatabasesResponse, AutonomousDatabase>
            context,
        ApiFuture<ListAutonomousDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutonomousDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutonomousDatabasesRequest,
          ListAutonomousDatabasesResponse,
          AutonomousDatabase,
          ListAutonomousDatabasesPage,
          ListAutonomousDatabasesFixedSizeCollection> {

    private ListAutonomousDatabasesFixedSizeCollection(
        List<ListAutonomousDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutonomousDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListAutonomousDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutonomousDatabasesFixedSizeCollection createCollection(
        List<ListAutonomousDatabasesPage> pages, int collectionSize) {
      return new ListAutonomousDatabasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutonomousDbVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          AutonomousDbVersion,
          ListAutonomousDbVersionsPage,
          ListAutonomousDbVersionsFixedSizeCollection> {

    public static ApiFuture<ListAutonomousDbVersionsPagedResponse> createAsync(
        PageContext<
                ListAutonomousDbVersionsRequest,
                ListAutonomousDbVersionsResponse,
                AutonomousDbVersion>
            context,
        ApiFuture<ListAutonomousDbVersionsResponse> futureResponse) {
      ApiFuture<ListAutonomousDbVersionsPage> futurePage =
          ListAutonomousDbVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutonomousDbVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutonomousDbVersionsPagedResponse(ListAutonomousDbVersionsPage page) {
      super(page, ListAutonomousDbVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutonomousDbVersionsPage
      extends AbstractPage<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          AutonomousDbVersion,
          ListAutonomousDbVersionsPage> {

    private ListAutonomousDbVersionsPage(
        PageContext<
                ListAutonomousDbVersionsRequest,
                ListAutonomousDbVersionsResponse,
                AutonomousDbVersion>
            context,
        ListAutonomousDbVersionsResponse response) {
      super(context, response);
    }

    private static ListAutonomousDbVersionsPage createEmptyPage() {
      return new ListAutonomousDbVersionsPage(null, null);
    }

    @Override
    protected ListAutonomousDbVersionsPage createPage(
        PageContext<
                ListAutonomousDbVersionsRequest,
                ListAutonomousDbVersionsResponse,
                AutonomousDbVersion>
            context,
        ListAutonomousDbVersionsResponse response) {
      return new ListAutonomousDbVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAutonomousDbVersionsPage> createPageAsync(
        PageContext<
                ListAutonomousDbVersionsRequest,
                ListAutonomousDbVersionsResponse,
                AutonomousDbVersion>
            context,
        ApiFuture<ListAutonomousDbVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutonomousDbVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutonomousDbVersionsRequest,
          ListAutonomousDbVersionsResponse,
          AutonomousDbVersion,
          ListAutonomousDbVersionsPage,
          ListAutonomousDbVersionsFixedSizeCollection> {

    private ListAutonomousDbVersionsFixedSizeCollection(
        List<ListAutonomousDbVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutonomousDbVersionsFixedSizeCollection createEmptyCollection() {
      return new ListAutonomousDbVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutonomousDbVersionsFixedSizeCollection createCollection(
        List<ListAutonomousDbVersionsPage> pages, int collectionSize) {
      return new ListAutonomousDbVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutonomousDatabaseCharacterSetsPagedResponse
      extends AbstractPagedListResponse<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          AutonomousDatabaseCharacterSet,
          ListAutonomousDatabaseCharacterSetsPage,
          ListAutonomousDatabaseCharacterSetsFixedSizeCollection> {

    public static ApiFuture<ListAutonomousDatabaseCharacterSetsPagedResponse> createAsync(
        PageContext<
                ListAutonomousDatabaseCharacterSetsRequest,
                ListAutonomousDatabaseCharacterSetsResponse,
                AutonomousDatabaseCharacterSet>
            context,
        ApiFuture<ListAutonomousDatabaseCharacterSetsResponse> futureResponse) {
      ApiFuture<ListAutonomousDatabaseCharacterSetsPage> futurePage =
          ListAutonomousDatabaseCharacterSetsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutonomousDatabaseCharacterSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutonomousDatabaseCharacterSetsPagedResponse(
        ListAutonomousDatabaseCharacterSetsPage page) {
      super(page, ListAutonomousDatabaseCharacterSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutonomousDatabaseCharacterSetsPage
      extends AbstractPage<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          AutonomousDatabaseCharacterSet,
          ListAutonomousDatabaseCharacterSetsPage> {

    private ListAutonomousDatabaseCharacterSetsPage(
        PageContext<
                ListAutonomousDatabaseCharacterSetsRequest,
                ListAutonomousDatabaseCharacterSetsResponse,
                AutonomousDatabaseCharacterSet>
            context,
        ListAutonomousDatabaseCharacterSetsResponse response) {
      super(context, response);
    }

    private static ListAutonomousDatabaseCharacterSetsPage createEmptyPage() {
      return new ListAutonomousDatabaseCharacterSetsPage(null, null);
    }

    @Override
    protected ListAutonomousDatabaseCharacterSetsPage createPage(
        PageContext<
                ListAutonomousDatabaseCharacterSetsRequest,
                ListAutonomousDatabaseCharacterSetsResponse,
                AutonomousDatabaseCharacterSet>
            context,
        ListAutonomousDatabaseCharacterSetsResponse response) {
      return new ListAutonomousDatabaseCharacterSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListAutonomousDatabaseCharacterSetsPage> createPageAsync(
        PageContext<
                ListAutonomousDatabaseCharacterSetsRequest,
                ListAutonomousDatabaseCharacterSetsResponse,
                AutonomousDatabaseCharacterSet>
            context,
        ApiFuture<ListAutonomousDatabaseCharacterSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutonomousDatabaseCharacterSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutonomousDatabaseCharacterSetsRequest,
          ListAutonomousDatabaseCharacterSetsResponse,
          AutonomousDatabaseCharacterSet,
          ListAutonomousDatabaseCharacterSetsPage,
          ListAutonomousDatabaseCharacterSetsFixedSizeCollection> {

    private ListAutonomousDatabaseCharacterSetsFixedSizeCollection(
        List<ListAutonomousDatabaseCharacterSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutonomousDatabaseCharacterSetsFixedSizeCollection createEmptyCollection() {
      return new ListAutonomousDatabaseCharacterSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutonomousDatabaseCharacterSetsFixedSizeCollection createCollection(
        List<ListAutonomousDatabaseCharacterSetsPage> pages, int collectionSize) {
      return new ListAutonomousDatabaseCharacterSetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAutonomousDatabaseBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          AutonomousDatabaseBackup,
          ListAutonomousDatabaseBackupsPage,
          ListAutonomousDatabaseBackupsFixedSizeCollection> {

    public static ApiFuture<ListAutonomousDatabaseBackupsPagedResponse> createAsync(
        PageContext<
                ListAutonomousDatabaseBackupsRequest,
                ListAutonomousDatabaseBackupsResponse,
                AutonomousDatabaseBackup>
            context,
        ApiFuture<ListAutonomousDatabaseBackupsResponse> futureResponse) {
      ApiFuture<ListAutonomousDatabaseBackupsPage> futurePage =
          ListAutonomousDatabaseBackupsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutonomousDatabaseBackupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutonomousDatabaseBackupsPagedResponse(ListAutonomousDatabaseBackupsPage page) {
      super(page, ListAutonomousDatabaseBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutonomousDatabaseBackupsPage
      extends AbstractPage<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          AutonomousDatabaseBackup,
          ListAutonomousDatabaseBackupsPage> {

    private ListAutonomousDatabaseBackupsPage(
        PageContext<
                ListAutonomousDatabaseBackupsRequest,
                ListAutonomousDatabaseBackupsResponse,
                AutonomousDatabaseBackup>
            context,
        ListAutonomousDatabaseBackupsResponse response) {
      super(context, response);
    }

    private static ListAutonomousDatabaseBackupsPage createEmptyPage() {
      return new ListAutonomousDatabaseBackupsPage(null, null);
    }

    @Override
    protected ListAutonomousDatabaseBackupsPage createPage(
        PageContext<
                ListAutonomousDatabaseBackupsRequest,
                ListAutonomousDatabaseBackupsResponse,
                AutonomousDatabaseBackup>
            context,
        ListAutonomousDatabaseBackupsResponse response) {
      return new ListAutonomousDatabaseBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListAutonomousDatabaseBackupsPage> createPageAsync(
        PageContext<
                ListAutonomousDatabaseBackupsRequest,
                ListAutonomousDatabaseBackupsResponse,
                AutonomousDatabaseBackup>
            context,
        ApiFuture<ListAutonomousDatabaseBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutonomousDatabaseBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutonomousDatabaseBackupsRequest,
          ListAutonomousDatabaseBackupsResponse,
          AutonomousDatabaseBackup,
          ListAutonomousDatabaseBackupsPage,
          ListAutonomousDatabaseBackupsFixedSizeCollection> {

    private ListAutonomousDatabaseBackupsFixedSizeCollection(
        List<ListAutonomousDatabaseBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutonomousDatabaseBackupsFixedSizeCollection createEmptyCollection() {
      return new ListAutonomousDatabaseBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutonomousDatabaseBackupsFixedSizeCollection createCollection(
        List<ListAutonomousDatabaseBackupsPage> pages, int collectionSize) {
      return new ListAutonomousDatabaseBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOdbNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListOdbNetworksRequest,
          ListOdbNetworksResponse,
          OdbNetwork,
          ListOdbNetworksPage,
          ListOdbNetworksFixedSizeCollection> {

    public static ApiFuture<ListOdbNetworksPagedResponse> createAsync(
        PageContext<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork> context,
        ApiFuture<ListOdbNetworksResponse> futureResponse) {
      ApiFuture<ListOdbNetworksPage> futurePage =
          ListOdbNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOdbNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOdbNetworksPagedResponse(ListOdbNetworksPage page) {
      super(page, ListOdbNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOdbNetworksPage
      extends AbstractPage<
          ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork, ListOdbNetworksPage> {

    private ListOdbNetworksPage(
        PageContext<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork> context,
        ListOdbNetworksResponse response) {
      super(context, response);
    }

    private static ListOdbNetworksPage createEmptyPage() {
      return new ListOdbNetworksPage(null, null);
    }

    @Override
    protected ListOdbNetworksPage createPage(
        PageContext<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork> context,
        ListOdbNetworksResponse response) {
      return new ListOdbNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListOdbNetworksPage> createPageAsync(
        PageContext<ListOdbNetworksRequest, ListOdbNetworksResponse, OdbNetwork> context,
        ApiFuture<ListOdbNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOdbNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOdbNetworksRequest,
          ListOdbNetworksResponse,
          OdbNetwork,
          ListOdbNetworksPage,
          ListOdbNetworksFixedSizeCollection> {

    private ListOdbNetworksFixedSizeCollection(
        List<ListOdbNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOdbNetworksFixedSizeCollection createEmptyCollection() {
      return new ListOdbNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOdbNetworksFixedSizeCollection createCollection(
        List<ListOdbNetworksPage> pages, int collectionSize) {
      return new ListOdbNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOdbSubnetsPagedResponse
      extends AbstractPagedListResponse<
          ListOdbSubnetsRequest,
          ListOdbSubnetsResponse,
          OdbSubnet,
          ListOdbSubnetsPage,
          ListOdbSubnetsFixedSizeCollection> {

    public static ApiFuture<ListOdbSubnetsPagedResponse> createAsync(
        PageContext<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet> context,
        ApiFuture<ListOdbSubnetsResponse> futureResponse) {
      ApiFuture<ListOdbSubnetsPage> futurePage =
          ListOdbSubnetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOdbSubnetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOdbSubnetsPagedResponse(ListOdbSubnetsPage page) {
      super(page, ListOdbSubnetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOdbSubnetsPage
      extends AbstractPage<
          ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet, ListOdbSubnetsPage> {

    private ListOdbSubnetsPage(
        PageContext<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet> context,
        ListOdbSubnetsResponse response) {
      super(context, response);
    }

    private static ListOdbSubnetsPage createEmptyPage() {
      return new ListOdbSubnetsPage(null, null);
    }

    @Override
    protected ListOdbSubnetsPage createPage(
        PageContext<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet> context,
        ListOdbSubnetsResponse response) {
      return new ListOdbSubnetsPage(context, response);
    }

    @Override
    public ApiFuture<ListOdbSubnetsPage> createPageAsync(
        PageContext<ListOdbSubnetsRequest, ListOdbSubnetsResponse, OdbSubnet> context,
        ApiFuture<ListOdbSubnetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOdbSubnetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOdbSubnetsRequest,
          ListOdbSubnetsResponse,
          OdbSubnet,
          ListOdbSubnetsPage,
          ListOdbSubnetsFixedSizeCollection> {

    private ListOdbSubnetsFixedSizeCollection(List<ListOdbSubnetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOdbSubnetsFixedSizeCollection createEmptyCollection() {
      return new ListOdbSubnetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOdbSubnetsFixedSizeCollection createCollection(
        List<ListOdbSubnetsPage> pages, int collectionSize) {
      return new ListOdbSubnetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExadbVmClustersPagedResponse
      extends AbstractPagedListResponse<
          ListExadbVmClustersRequest,
          ListExadbVmClustersResponse,
          ExadbVmCluster,
          ListExadbVmClustersPage,
          ListExadbVmClustersFixedSizeCollection> {

    public static ApiFuture<ListExadbVmClustersPagedResponse> createAsync(
        PageContext<ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
            context,
        ApiFuture<ListExadbVmClustersResponse> futureResponse) {
      ApiFuture<ListExadbVmClustersPage> futurePage =
          ListExadbVmClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExadbVmClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExadbVmClustersPagedResponse(ListExadbVmClustersPage page) {
      super(page, ListExadbVmClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExadbVmClustersPage
      extends AbstractPage<
          ListExadbVmClustersRequest,
          ListExadbVmClustersResponse,
          ExadbVmCluster,
          ListExadbVmClustersPage> {

    private ListExadbVmClustersPage(
        PageContext<ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
            context,
        ListExadbVmClustersResponse response) {
      super(context, response);
    }

    private static ListExadbVmClustersPage createEmptyPage() {
      return new ListExadbVmClustersPage(null, null);
    }

    @Override
    protected ListExadbVmClustersPage createPage(
        PageContext<ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
            context,
        ListExadbVmClustersResponse response) {
      return new ListExadbVmClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListExadbVmClustersPage> createPageAsync(
        PageContext<ListExadbVmClustersRequest, ListExadbVmClustersResponse, ExadbVmCluster>
            context,
        ApiFuture<ListExadbVmClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExadbVmClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExadbVmClustersRequest,
          ListExadbVmClustersResponse,
          ExadbVmCluster,
          ListExadbVmClustersPage,
          ListExadbVmClustersFixedSizeCollection> {

    private ListExadbVmClustersFixedSizeCollection(
        List<ListExadbVmClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExadbVmClustersFixedSizeCollection createEmptyCollection() {
      return new ListExadbVmClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExadbVmClustersFixedSizeCollection createCollection(
        List<ListExadbVmClustersPage> pages, int collectionSize) {
      return new ListExadbVmClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListExascaleDbStorageVaultsPagedResponse
      extends AbstractPagedListResponse<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ExascaleDbStorageVault,
          ListExascaleDbStorageVaultsPage,
          ListExascaleDbStorageVaultsFixedSizeCollection> {

    public static ApiFuture<ListExascaleDbStorageVaultsPagedResponse> createAsync(
        PageContext<
                ListExascaleDbStorageVaultsRequest,
                ListExascaleDbStorageVaultsResponse,
                ExascaleDbStorageVault>
            context,
        ApiFuture<ListExascaleDbStorageVaultsResponse> futureResponse) {
      ApiFuture<ListExascaleDbStorageVaultsPage> futurePage =
          ListExascaleDbStorageVaultsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExascaleDbStorageVaultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExascaleDbStorageVaultsPagedResponse(ListExascaleDbStorageVaultsPage page) {
      super(page, ListExascaleDbStorageVaultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExascaleDbStorageVaultsPage
      extends AbstractPage<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ExascaleDbStorageVault,
          ListExascaleDbStorageVaultsPage> {

    private ListExascaleDbStorageVaultsPage(
        PageContext<
                ListExascaleDbStorageVaultsRequest,
                ListExascaleDbStorageVaultsResponse,
                ExascaleDbStorageVault>
            context,
        ListExascaleDbStorageVaultsResponse response) {
      super(context, response);
    }

    private static ListExascaleDbStorageVaultsPage createEmptyPage() {
      return new ListExascaleDbStorageVaultsPage(null, null);
    }

    @Override
    protected ListExascaleDbStorageVaultsPage createPage(
        PageContext<
                ListExascaleDbStorageVaultsRequest,
                ListExascaleDbStorageVaultsResponse,
                ExascaleDbStorageVault>
            context,
        ListExascaleDbStorageVaultsResponse response) {
      return new ListExascaleDbStorageVaultsPage(context, response);
    }

    @Override
    public ApiFuture<ListExascaleDbStorageVaultsPage> createPageAsync(
        PageContext<
                ListExascaleDbStorageVaultsRequest,
                ListExascaleDbStorageVaultsResponse,
                ExascaleDbStorageVault>
            context,
        ApiFuture<ListExascaleDbStorageVaultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExascaleDbStorageVaultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExascaleDbStorageVaultsRequest,
          ListExascaleDbStorageVaultsResponse,
          ExascaleDbStorageVault,
          ListExascaleDbStorageVaultsPage,
          ListExascaleDbStorageVaultsFixedSizeCollection> {

    private ListExascaleDbStorageVaultsFixedSizeCollection(
        List<ListExascaleDbStorageVaultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExascaleDbStorageVaultsFixedSizeCollection createEmptyCollection() {
      return new ListExascaleDbStorageVaultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExascaleDbStorageVaultsFixedSizeCollection createCollection(
        List<ListExascaleDbStorageVaultsPage> pages, int collectionSize) {
      return new ListExascaleDbStorageVaultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbSystemInitialStorageSizesPagedResponse
      extends AbstractPagedListResponse<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          DbSystemInitialStorageSize,
          ListDbSystemInitialStorageSizesPage,
          ListDbSystemInitialStorageSizesFixedSizeCollection> {

    public static ApiFuture<ListDbSystemInitialStorageSizesPagedResponse> createAsync(
        PageContext<
                ListDbSystemInitialStorageSizesRequest,
                ListDbSystemInitialStorageSizesResponse,
                DbSystemInitialStorageSize>
            context,
        ApiFuture<ListDbSystemInitialStorageSizesResponse> futureResponse) {
      ApiFuture<ListDbSystemInitialStorageSizesPage> futurePage =
          ListDbSystemInitialStorageSizesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDbSystemInitialStorageSizesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDbSystemInitialStorageSizesPagedResponse(ListDbSystemInitialStorageSizesPage page) {
      super(page, ListDbSystemInitialStorageSizesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbSystemInitialStorageSizesPage
      extends AbstractPage<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          DbSystemInitialStorageSize,
          ListDbSystemInitialStorageSizesPage> {

    private ListDbSystemInitialStorageSizesPage(
        PageContext<
                ListDbSystemInitialStorageSizesRequest,
                ListDbSystemInitialStorageSizesResponse,
                DbSystemInitialStorageSize>
            context,
        ListDbSystemInitialStorageSizesResponse response) {
      super(context, response);
    }

    private static ListDbSystemInitialStorageSizesPage createEmptyPage() {
      return new ListDbSystemInitialStorageSizesPage(null, null);
    }

    @Override
    protected ListDbSystemInitialStorageSizesPage createPage(
        PageContext<
                ListDbSystemInitialStorageSizesRequest,
                ListDbSystemInitialStorageSizesResponse,
                DbSystemInitialStorageSize>
            context,
        ListDbSystemInitialStorageSizesResponse response) {
      return new ListDbSystemInitialStorageSizesPage(context, response);
    }

    @Override
    public ApiFuture<ListDbSystemInitialStorageSizesPage> createPageAsync(
        PageContext<
                ListDbSystemInitialStorageSizesRequest,
                ListDbSystemInitialStorageSizesResponse,
                DbSystemInitialStorageSize>
            context,
        ApiFuture<ListDbSystemInitialStorageSizesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbSystemInitialStorageSizesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbSystemInitialStorageSizesRequest,
          ListDbSystemInitialStorageSizesResponse,
          DbSystemInitialStorageSize,
          ListDbSystemInitialStorageSizesPage,
          ListDbSystemInitialStorageSizesFixedSizeCollection> {

    private ListDbSystemInitialStorageSizesFixedSizeCollection(
        List<ListDbSystemInitialStorageSizesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbSystemInitialStorageSizesFixedSizeCollection createEmptyCollection() {
      return new ListDbSystemInitialStorageSizesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbSystemInitialStorageSizesFixedSizeCollection createCollection(
        List<ListDbSystemInitialStorageSizesPage> pages, int collectionSize) {
      return new ListDbSystemInitialStorageSizesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    public static ApiFuture<ListDatabasesPagedResponse> createAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      ApiFuture<ListDatabasesPage> futurePage =
          ListDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabasesPagedResponse(ListDatabasesPage page) {
      super(page, ListDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabasesPage
      extends AbstractPage<
          ListDatabasesRequest, ListDatabasesResponse, Database, ListDatabasesPage> {

    private ListDatabasesPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      super(context, response);
    }

    private static ListDatabasesPage createEmptyPage() {
      return new ListDatabasesPage(null, null);
    }

    @Override
    protected ListDatabasesPage createPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      return new ListDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabasesPage> createPageAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    private ListDatabasesFixedSizeCollection(List<ListDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabasesFixedSizeCollection createCollection(
        List<ListDatabasesPage> pages, int collectionSize) {
      return new ListDatabasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPluggableDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          PluggableDatabase,
          ListPluggableDatabasesPage,
          ListPluggableDatabasesFixedSizeCollection> {

    public static ApiFuture<ListPluggableDatabasesPagedResponse> createAsync(
        PageContext<
                ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>
            context,
        ApiFuture<ListPluggableDatabasesResponse> futureResponse) {
      ApiFuture<ListPluggableDatabasesPage> futurePage =
          ListPluggableDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPluggableDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPluggableDatabasesPagedResponse(ListPluggableDatabasesPage page) {
      super(page, ListPluggableDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPluggableDatabasesPage
      extends AbstractPage<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          PluggableDatabase,
          ListPluggableDatabasesPage> {

    private ListPluggableDatabasesPage(
        PageContext<
                ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>
            context,
        ListPluggableDatabasesResponse response) {
      super(context, response);
    }

    private static ListPluggableDatabasesPage createEmptyPage() {
      return new ListPluggableDatabasesPage(null, null);
    }

    @Override
    protected ListPluggableDatabasesPage createPage(
        PageContext<
                ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>
            context,
        ListPluggableDatabasesResponse response) {
      return new ListPluggableDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListPluggableDatabasesPage> createPageAsync(
        PageContext<
                ListPluggableDatabasesRequest, ListPluggableDatabasesResponse, PluggableDatabase>
            context,
        ApiFuture<ListPluggableDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPluggableDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPluggableDatabasesRequest,
          ListPluggableDatabasesResponse,
          PluggableDatabase,
          ListPluggableDatabasesPage,
          ListPluggableDatabasesFixedSizeCollection> {

    private ListPluggableDatabasesFixedSizeCollection(
        List<ListPluggableDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPluggableDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListPluggableDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPluggableDatabasesFixedSizeCollection createCollection(
        List<ListPluggableDatabasesPage> pages, int collectionSize) {
      return new ListPluggableDatabasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbSystemsPagedResponse
      extends AbstractPagedListResponse<
          ListDbSystemsRequest,
          ListDbSystemsResponse,
          DbSystem,
          ListDbSystemsPage,
          ListDbSystemsFixedSizeCollection> {

    public static ApiFuture<ListDbSystemsPagedResponse> createAsync(
        PageContext<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem> context,
        ApiFuture<ListDbSystemsResponse> futureResponse) {
      ApiFuture<ListDbSystemsPage> futurePage =
          ListDbSystemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDbSystemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDbSystemsPagedResponse(ListDbSystemsPage page) {
      super(page, ListDbSystemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbSystemsPage
      extends AbstractPage<
          ListDbSystemsRequest, ListDbSystemsResponse, DbSystem, ListDbSystemsPage> {

    private ListDbSystemsPage(
        PageContext<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem> context,
        ListDbSystemsResponse response) {
      super(context, response);
    }

    private static ListDbSystemsPage createEmptyPage() {
      return new ListDbSystemsPage(null, null);
    }

    @Override
    protected ListDbSystemsPage createPage(
        PageContext<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem> context,
        ListDbSystemsResponse response) {
      return new ListDbSystemsPage(context, response);
    }

    @Override
    public ApiFuture<ListDbSystemsPage> createPageAsync(
        PageContext<ListDbSystemsRequest, ListDbSystemsResponse, DbSystem> context,
        ApiFuture<ListDbSystemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbSystemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbSystemsRequest,
          ListDbSystemsResponse,
          DbSystem,
          ListDbSystemsPage,
          ListDbSystemsFixedSizeCollection> {

    private ListDbSystemsFixedSizeCollection(List<ListDbSystemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbSystemsFixedSizeCollection createEmptyCollection() {
      return new ListDbSystemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbSystemsFixedSizeCollection createCollection(
        List<ListDbSystemsPage> pages, int collectionSize) {
      return new ListDbSystemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDbVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListDbVersionsRequest,
          ListDbVersionsResponse,
          DbVersion,
          ListDbVersionsPage,
          ListDbVersionsFixedSizeCollection> {

    public static ApiFuture<ListDbVersionsPagedResponse> createAsync(
        PageContext<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion> context,
        ApiFuture<ListDbVersionsResponse> futureResponse) {
      ApiFuture<ListDbVersionsPage> futurePage =
          ListDbVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDbVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDbVersionsPagedResponse(ListDbVersionsPage page) {
      super(page, ListDbVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDbVersionsPage
      extends AbstractPage<
          ListDbVersionsRequest, ListDbVersionsResponse, DbVersion, ListDbVersionsPage> {

    private ListDbVersionsPage(
        PageContext<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion> context,
        ListDbVersionsResponse response) {
      super(context, response);
    }

    private static ListDbVersionsPage createEmptyPage() {
      return new ListDbVersionsPage(null, null);
    }

    @Override
    protected ListDbVersionsPage createPage(
        PageContext<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion> context,
        ListDbVersionsResponse response) {
      return new ListDbVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListDbVersionsPage> createPageAsync(
        PageContext<ListDbVersionsRequest, ListDbVersionsResponse, DbVersion> context,
        ApiFuture<ListDbVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDbVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDbVersionsRequest,
          ListDbVersionsResponse,
          DbVersion,
          ListDbVersionsPage,
          ListDbVersionsFixedSizeCollection> {

    private ListDbVersionsFixedSizeCollection(List<ListDbVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDbVersionsFixedSizeCollection createEmptyCollection() {
      return new ListDbVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDbVersionsFixedSizeCollection createCollection(
        List<ListDbVersionsPage> pages, int collectionSize) {
      return new ListDbVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatabaseCharacterSetsPagedResponse
      extends AbstractPagedListResponse<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          DatabaseCharacterSet,
          ListDatabaseCharacterSetsPage,
          ListDatabaseCharacterSetsFixedSizeCollection> {

    public static ApiFuture<ListDatabaseCharacterSetsPagedResponse> createAsync(
        PageContext<
                ListDatabaseCharacterSetsRequest,
                ListDatabaseCharacterSetsResponse,
                DatabaseCharacterSet>
            context,
        ApiFuture<ListDatabaseCharacterSetsResponse> futureResponse) {
      ApiFuture<ListDatabaseCharacterSetsPage> futurePage =
          ListDatabaseCharacterSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabaseCharacterSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabaseCharacterSetsPagedResponse(ListDatabaseCharacterSetsPage page) {
      super(page, ListDatabaseCharacterSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabaseCharacterSetsPage
      extends AbstractPage<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          DatabaseCharacterSet,
          ListDatabaseCharacterSetsPage> {

    private ListDatabaseCharacterSetsPage(
        PageContext<
                ListDatabaseCharacterSetsRequest,
                ListDatabaseCharacterSetsResponse,
                DatabaseCharacterSet>
            context,
        ListDatabaseCharacterSetsResponse response) {
      super(context, response);
    }

    private static ListDatabaseCharacterSetsPage createEmptyPage() {
      return new ListDatabaseCharacterSetsPage(null, null);
    }

    @Override
    protected ListDatabaseCharacterSetsPage createPage(
        PageContext<
                ListDatabaseCharacterSetsRequest,
                ListDatabaseCharacterSetsResponse,
                DatabaseCharacterSet>
            context,
        ListDatabaseCharacterSetsResponse response) {
      return new ListDatabaseCharacterSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabaseCharacterSetsPage> createPageAsync(
        PageContext<
                ListDatabaseCharacterSetsRequest,
                ListDatabaseCharacterSetsResponse,
                DatabaseCharacterSet>
            context,
        ApiFuture<ListDatabaseCharacterSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabaseCharacterSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabaseCharacterSetsRequest,
          ListDatabaseCharacterSetsResponse,
          DatabaseCharacterSet,
          ListDatabaseCharacterSetsPage,
          ListDatabaseCharacterSetsFixedSizeCollection> {

    private ListDatabaseCharacterSetsFixedSizeCollection(
        List<ListDatabaseCharacterSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabaseCharacterSetsFixedSizeCollection createEmptyCollection() {
      return new ListDatabaseCharacterSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabaseCharacterSetsFixedSizeCollection createCollection(
        List<ListDatabaseCharacterSetsPage> pages, int collectionSize) {
      return new ListDatabaseCharacterSetsFixedSizeCollection(pages, collectionSize);
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
