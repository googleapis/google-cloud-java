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

package com.google.cloud.oracledatabase.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
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
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OracleDatabaseClient implements BackgroundResource {
  private final OracleDatabaseSettings settings;
  private final OracleDatabaseStub stub;
  private final OperationsClient httpJsonOperationsClient;

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
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected OracleDatabaseClient(OracleDatabaseStub stub) {
    this.settings = null;
    this.stub = stub;
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
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloudVmCluster}.
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
   *   String parent =
   *       CloudVmClusterName.of("[PROJECT]", "[LOCATION]", "[CLOUD_VM_CLUSTER]").toString();
   *   for (DbNode element : oracleDatabaseClient.listDbNodes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for database node in the following format:
   *     projects/{project}/locations/{location}/cloudVmClusters/{cloudVmCluster}.
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
