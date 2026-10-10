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

package com.google.cloud.redis.cluster.v1;

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
import com.google.cloud.redis.cluster.v1.stub.CloudRedisClusterStub;
import com.google.cloud.redis.cluster.v1.stub.CloudRedisClusterStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Configures and manages Cloud Memorystore for Redis clusters
 *
 * <p>Google Cloud Memorystore for Redis Cluster
 *
 * <p>The `redis.googleapis.com` service implements the Google Cloud Memorystore for Redis API and
 * defines the following resource model for managing Redis clusters:
 *
 * <ul>
 *   <li>The service works with a collection of cloud projects, named: `/projects/&#42;`
 *   <li>Each project has a collection of available locations, named: `/locations/&#42;`
 *   <li>Each location has a collection of Redis clusters, named: `/clusters/&#42;`
 *   <li>As such, Redis clusters are resources of the form:
 *       `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
 * </ul>
 *
 * <p>Note that location_id must be a GCP `region`; for example:
 *
 * <ul>
 *   <li>`projects/redpepper-1290/locations/us-central1/clusters/my-redis`
 * </ul>
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
 * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
 *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
 *   Cluster response = cloudRedisClusterClient.getCluster(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudRedisClusterClient object to clean up resources
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
 *      <td><p> ListClusters</td>
 *      <td><p> Lists all Redis clusters owned by a project in either the specified location (region) or all locations.
 * <p>  The location should have the following format:
 * <ul>
 * <li>  `projects/{project_id}/locations/{location_id}`
 * </ul>
 * <p>  If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listClusters(ListClustersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listClusters(LocationName parent)
 *           <li><p> listClusters(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listClustersPagedCallable()
 *           <li><p> listClustersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAclPolicies</td>
 *      <td><p> Lists all ACL policies owned by a project in either the specified location (region) or all locations.
 * <p>  The location should have the following format:
 * <ul>
 * <li>  `projects/{project_id}/locations/{location_id}`
 * </ul>
 * <p>  If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAclPolicies(ListAclPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAclPolicies(LocationName parent)
 *           <li><p> listAclPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAclPoliciesPagedCallable()
 *           <li><p> listAclPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCluster</td>
 *      <td><p> Gets the details of a specific Redis cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCluster(GetClusterRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCluster(ClusterName name)
 *           <li><p> getCluster(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAclPolicy</td>
 *      <td><p> Gets the details of a specific Redis Cluster ACL policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAclPolicy(GetAclPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAclPolicy(AclPolicyName name)
 *           <li><p> getAclPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAclPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCluster</td>
 *      <td><p> Updates the metadata and configuration of a specific Redis cluster.
 * <p>  Completed longrunning.Operation will contain the new cluster object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(UpdateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateClusterAsync(Cluster cluster, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateClusterOperationCallable()
 *           <li><p> updateClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAclPolicy</td>
 *      <td><p> Updates the ACL policy.
 * <p>  The operation applies the updated ACL policy to all of the linked clusters. If Memorystore can apply the policy to all clusters, then the operation returns a SUCCESS status. If Memorystore can't apply the policy to all clusters, then to ensure eventual consistency, Memorystore uses reconciliation to apply the policy to the failed clusters.
 * <p>  Completed longrunning.Operation will contain the new ACL policy object in the response field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAclPolicyAsync(UpdateAclPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAclPolicyAsync(AclPolicy aclPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAclPolicyOperationCallable()
 *           <li><p> updateAclPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCluster</td>
 *      <td><p> Deletes a specific Redis cluster. Cluster stops serving and data is deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(DeleteClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteClusterAsync(ClusterName name)
 *           <li><p> deleteClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteClusterOperationCallable()
 *           <li><p> deleteClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAclPolicy</td>
 *      <td><p> Deletes a specific ACL policy. This action will delete the ACL policy and all the rules associated with it. An ACL policy cannot be deleted if it is attached to a cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAclPolicyAsync(DeleteAclPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAclPolicyAsync(AclPolicyName name)
 *           <li><p> deleteAclPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAclPolicyOperationCallable()
 *           <li><p> deleteAclPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAclPolicyRevision</td>
 *      <td><p> Gets details of a specific ACL policy revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAclPolicyRevision(GetAclPolicyRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAclPolicyRevision(AclPolicyRevisionName name)
 *           <li><p> getAclPolicyRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAclPolicyRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAclPolicyRevisions</td>
 *      <td><p> Lists all ACL policy revisions in a given ACL policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAclPolicyRevisions(ListAclPolicyRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAclPolicyRevisions(AclPolicyName parent)
 *           <li><p> listAclPolicyRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAclPolicyRevisionsPagedCallable()
 *           <li><p> listAclPolicyRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCluster</td>
 *      <td><p> Creates a Redis cluster based on the specified properties. The creation is executed asynchronously and callers may check the returned operation to track its progress. Once the operation is completed the Redis cluster will be fully functional. The completed longrunning.Operation will contain the new cluster object in the response field.
 * <p>  The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createClusterAsync(CreateClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createClusterAsync(LocationName parent, Cluster cluster, String clusterId)
 *           <li><p> createClusterAsync(String parent, Cluster cluster, String clusterId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createClusterOperationCallable()
 *           <li><p> createClusterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAclPolicy</td>
 *      <td><p> Creates an ACL policy. The creation is executed synchronously and the policy is available for use immediately after the RPC returns.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAclPolicy(CreateAclPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAclPolicy(LocationName parent, AclPolicy aclPolicy, String aclPolicyId)
 *           <li><p> createAclPolicy(String parent, AclPolicy aclPolicy, String aclPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAclPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetClusterCertificateAuthority</td>
 *      <td><p> Gets the details of certificate authority information for Redis cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getClusterCertificateAuthority(GetClusterCertificateAuthorityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getClusterCertificateAuthority(CertificateAuthorityName name)
 *           <li><p> getClusterCertificateAuthority(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getClusterCertificateAuthorityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSharedRegionalCertificateAuthority</td>
 *      <td><p> Gets the details of regional certificate authority information for Redis cluster.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthority(GetSharedRegionalCertificateAuthorityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthority(SharedRegionalCertificateAuthorityName name)
 *           <li><p> getSharedRegionalCertificateAuthority(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthorityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RescheduleClusterMaintenance</td>
 *      <td><p> Reschedules upcoming maintenance event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rescheduleClusterMaintenanceAsync(RescheduleClusterMaintenanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> rescheduleClusterMaintenanceAsync(ClusterName name, RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType, Timestamp scheduleTime)
 *           <li><p> rescheduleClusterMaintenanceAsync(String name, RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType, Timestamp scheduleTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rescheduleClusterMaintenanceOperationCallable()
 *           <li><p> rescheduleClusterMaintenanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupCollections</td>
 *      <td><p> Lists all backup collections owned by a consumer project in either the specified location (region) or all locations.
 * <p>  If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupCollections(ListBackupCollectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupCollections(LocationName parent)
 *           <li><p> listBackupCollections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupCollectionsPagedCallable()
 *           <li><p> listBackupCollectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupCollection</td>
 *      <td><p> Get a backup collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupCollection(GetBackupCollectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupCollection(BackupCollectionName name)
 *           <li><p> getBackupCollection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackups</td>
 *      <td><p> Lists all backups owned by a backup collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(BackupCollectionName parent)
 *           <li><p> listBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupsPagedCallable()
 *           <li><p> listBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackup</td>
 *      <td><p> Gets the details of a specific backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackup(GetBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackup(BackupName name)
 *           <li><p> getBackup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes a specific backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(DeleteBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(BackupName name)
 *           <li><p> deleteBackupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupOperationCallable()
 *           <li><p> deleteBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportBackup</td>
 *      <td><p> Exports a specific backup to a customer target Cloud Storage URI.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportBackupAsync(ExportBackupRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportBackupOperationCallable()
 *           <li><p> exportBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BackupCluster</td>
 *      <td><p> Backup Redis Cluster. If this is the first time a backup is being created, a backup collection will be created at the backend, and this backup belongs to this collection. Both collection and backup will have a resource name. Backup will be executed for each shard. A replica (primary if nonHA) will be selected to perform the execution. Backup call will be rejected if there is an ongoing backup or update operation. Be aware that during preview, if the cluster's internal software version is too old, critical update will be performed before actual backup. Once the internal software version is updated to the minimum version required by the backup feature, subsequent backups will not require critical update. After preview, there will be no critical update needed for backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> backupClusterAsync(BackupClusterRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> backupClusterAsync(ClusterName name)
 *           <li><p> backupClusterAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> backupClusterOperationCallable()
 *           <li><p> backupClusterCallable()
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
 * <p>This class can be customized by passing in a custom instance of CloudRedisClusterSettings to
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
 * CloudRedisClusterSettings cloudRedisClusterSettings =
 *     CloudRedisClusterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudRedisClusterClient cloudRedisClusterClient =
 *     CloudRedisClusterClient.create(cloudRedisClusterSettings);
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
 * CloudRedisClusterSettings cloudRedisClusterSettings =
 *     CloudRedisClusterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudRedisClusterClient cloudRedisClusterClient =
 *     CloudRedisClusterClient.create(cloudRedisClusterSettings);
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
 * CloudRedisClusterSettings cloudRedisClusterSettings =
 *     CloudRedisClusterSettings.newHttpJsonBuilder().build();
 * CloudRedisClusterClient cloudRedisClusterClient =
 *     CloudRedisClusterClient.create(cloudRedisClusterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CloudRedisClusterClient implements BackgroundResource {
  private final @Nullable CloudRedisClusterSettings settings;
  private final CloudRedisClusterStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudRedisClusterClient with default settings. */
  public static final CloudRedisClusterClient create() throws IOException {
    return create(CloudRedisClusterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudRedisClusterClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudRedisClusterClient create(CloudRedisClusterSettings settings)
      throws IOException {
    return new CloudRedisClusterClient(settings);
  }

  /**
   * Constructs an instance of CloudRedisClusterClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CloudRedisClusterSettings).
   */
  public static final CloudRedisClusterClient create(CloudRedisClusterStub stub) {
    return new CloudRedisClusterClient(stub);
  }

  /**
   * Constructs an instance of CloudRedisClusterClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudRedisClusterClient(CloudRedisClusterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudRedisClusterStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudRedisClusterClient(CloudRedisClusterStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable CloudRedisClusterSettings getSettings() {
    return settings;
  }

  public CloudRedisClusterStub getStub() {
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
   * Lists all Redis clusters owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Cluster element : cloudRedisClusterClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(@Nullable LocationName parent) {
    ListClustersRequest request =
        ListClustersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis clusters owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Cluster element : cloudRedisClusterClient.listClusters(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(String parent) {
    ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
    return listClusters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis clusters owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Cluster element : cloudRedisClusterClient.listClusters(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListClustersPagedResponse listClusters(ListClustersRequest request) {
    return listClustersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis clusters owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Cluster> future =
   *       cloudRedisClusterClient.listClustersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cluster element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable() {
    return stub.listClustersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Redis clusters owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListClustersRequest request =
   *       ListClustersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListClustersResponse response =
   *         cloudRedisClusterClient.listClustersCallable().call(request);
   *     for (Cluster element : response.getClustersList()) {
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
  public final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return stub.listClustersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policies owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AclPolicy element : cloudRedisClusterClient.listAclPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ACL policy location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPoliciesPagedResponse listAclPolicies(@Nullable LocationName parent) {
    ListAclPoliciesRequest request =
        ListAclPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAclPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policies owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AclPolicy element : cloudRedisClusterClient.listAclPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ACL policy location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPoliciesPagedResponse listAclPolicies(String parent) {
    ListAclPoliciesRequest request = ListAclPoliciesRequest.newBuilder().setParent(parent).build();
    return listAclPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policies owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPoliciesRequest request =
   *       ListAclPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AclPolicy element : cloudRedisClusterClient.listAclPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPoliciesPagedResponse listAclPolicies(ListAclPoliciesRequest request) {
    return listAclPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policies owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPoliciesRequest request =
   *       ListAclPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AclPolicy> future =
   *       cloudRedisClusterClient.listAclPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AclPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAclPoliciesRequest, ListAclPoliciesPagedResponse>
      listAclPoliciesPagedCallable() {
    return stub.listAclPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policies owned by a project in either the specified location (region) or all
   * locations.
   *
   * <p>The location should have the following format:
   *
   * <ul>
   *   <li>`projects/{project_id}/locations/{location_id}`
   * </ul>
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPoliciesRequest request =
   *       ListAclPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAclPoliciesResponse response =
   *         cloudRedisClusterClient.listAclPoliciesCallable().call(request);
   *     for (AclPolicy element : response.getAclPoliciesList()) {
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
  public final UnaryCallable<ListAclPoliciesRequest, ListAclPoliciesResponse>
      listAclPoliciesCallable() {
    return stub.listAclPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Cluster response = cloudRedisClusterClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(@Nullable ClusterName name) {
    GetClusterRequest request =
        GetClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Cluster response = cloudRedisClusterClient.getCluster(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(String name) {
    GetClusterRequest request = GetClusterRequest.newBuilder().setName(name).build();
    return getCluster(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   Cluster response = cloudRedisClusterClient.getCluster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Cluster getCluster(GetClusterRequest request) {
    return getClusterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetClusterRequest request =
   *       GetClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<Cluster> future = cloudRedisClusterClient.getClusterCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return stub.getClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis Cluster ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   AclPolicyName name = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]");
   *   AclPolicy response = cloudRedisClusterClient.getAclPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy getAclPolicy(@Nullable AclPolicyName name) {
    GetAclPolicyRequest request =
        GetAclPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAclPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis Cluster ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString();
   *   AclPolicy response = cloudRedisClusterClient.getAclPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy getAclPolicy(String name) {
    GetAclPolicyRequest request = GetAclPolicyRequest.newBuilder().setName(name).build();
    return getAclPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis Cluster ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetAclPolicyRequest request =
   *       GetAclPolicyRequest.newBuilder()
   *           .setName(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .build();
   *   AclPolicy response = cloudRedisClusterClient.getAclPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy getAclPolicy(GetAclPolicyRequest request) {
    return getAclPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific Redis Cluster ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetAclPolicyRequest request =
   *       GetAclPolicyRequest.newBuilder()
   *           .setName(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .build();
   *   ApiFuture<AclPolicy> future =
   *       cloudRedisClusterClient.getAclPolicyCallable().futureCall(request);
   *   // Do something.
   *   AclPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAclPolicyRequest, AclPolicy> getAclPolicyCallable() {
    return stub.getAclPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis cluster.
   *
   * <p>Completed longrunning.Operation will contain the new cluster object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   Cluster cluster = Cluster.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Cluster response = cloudRedisClusterClient.updateClusterAsync(cluster, updateMask).get();
   * }
   * }</pre>
   *
   * @param cluster Required. Update description. Only fields specified in update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     [Cluster][google.cloud.redis.cluster.v1.Cluster]:
   *     <p>&#42; `size_gb` &#42; `replica_count`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> updateClusterAsync(
      Cluster cluster, FieldMask updateMask) {
    UpdateClusterRequest request =
        UpdateClusterRequest.newBuilder().setCluster(cluster).setUpdateMask(updateMask).build();
    return updateClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis cluster.
   *
   * <p>Completed longrunning.Operation will contain the new cluster object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = cloudRedisClusterClient.updateClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> updateClusterAsync(UpdateClusterRequest request) {
    return updateClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis cluster.
   *
   * <p>Completed longrunning.Operation will contain the new cluster object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, Any> future =
   *       cloudRedisClusterClient.updateClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateClusterRequest, Cluster, Any>
      updateClusterOperationCallable() {
    return stub.updateClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a specific Redis cluster.
   *
   * <p>Completed longrunning.Operation will contain the new cluster object in the response field.
   * The returned operation is automatically deleted after a few hours, so there is no need to call
   * DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateClusterRequest request =
   *       UpdateClusterRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.updateClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return stub.updateClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the ACL policy.
   *
   * <p>The operation applies the updated ACL policy to all of the linked clusters. If Memorystore
   * can apply the policy to all clusters, then the operation returns a SUCCESS status. If
   * Memorystore can't apply the policy to all clusters, then to ensure eventual consistency,
   * Memorystore uses reconciliation to apply the policy to the failed clusters.
   *
   * <p>Completed longrunning.Operation will contain the new ACL policy object in the response
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   AclPolicy aclPolicy = AclPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AclPolicy response =
   *       cloudRedisClusterClient.updateAclPolicyAsync(aclPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param aclPolicy Required. The ACL policy to be updated.
   * @param updateMask Optional. Mask of fields to be updated. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include these fields from
   *     `AclPolicy`:
   *     <p>&#42; `rules`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AclPolicy, OperationMetadata> updateAclPolicyAsync(
      AclPolicy aclPolicy, FieldMask updateMask) {
    UpdateAclPolicyRequest request =
        UpdateAclPolicyRequest.newBuilder()
            .setAclPolicy(aclPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateAclPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the ACL policy.
   *
   * <p>The operation applies the updated ACL policy to all of the linked clusters. If Memorystore
   * can apply the policy to all clusters, then the operation returns a SUCCESS status. If
   * Memorystore can't apply the policy to all clusters, then to ensure eventual consistency,
   * Memorystore uses reconciliation to apply the policy to the failed clusters.
   *
   * <p>Completed longrunning.Operation will contain the new ACL policy object in the response
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateAclPolicyRequest request =
   *       UpdateAclPolicyRequest.newBuilder()
   *           .setAclPolicy(AclPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AclPolicy response = cloudRedisClusterClient.updateAclPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AclPolicy, OperationMetadata> updateAclPolicyAsync(
      UpdateAclPolicyRequest request) {
    return updateAclPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the ACL policy.
   *
   * <p>The operation applies the updated ACL policy to all of the linked clusters. If Memorystore
   * can apply the policy to all clusters, then the operation returns a SUCCESS status. If
   * Memorystore can't apply the policy to all clusters, then to ensure eventual consistency,
   * Memorystore uses reconciliation to apply the policy to the failed clusters.
   *
   * <p>Completed longrunning.Operation will contain the new ACL policy object in the response
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateAclPolicyRequest request =
   *       UpdateAclPolicyRequest.newBuilder()
   *           .setAclPolicy(AclPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<AclPolicy, OperationMetadata> future =
   *       cloudRedisClusterClient.updateAclPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   AclPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateAclPolicyRequest, AclPolicy, OperationMetadata>
      updateAclPolicyOperationCallable() {
    return stub.updateAclPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the ACL policy.
   *
   * <p>The operation applies the updated ACL policy to all of the linked clusters. If Memorystore
   * can apply the policy to all clusters, then the operation returns a SUCCESS status. If
   * Memorystore can't apply the policy to all clusters, then to ensure eventual consistency,
   * Memorystore uses reconciliation to apply the policy to the failed clusters.
   *
   * <p>Completed longrunning.Operation will contain the new ACL policy object in the response
   * field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   UpdateAclPolicyRequest request =
   *       UpdateAclPolicyRequest.newBuilder()
   *           .setAclPolicy(AclPolicy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.updateAclPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAclPolicyRequest, Operation> updateAclPolicyCallable() {
    return stub.updateAclPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   cloudRedisClusterClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteClusterAsync(@Nullable ClusterName name) {
    DeleteClusterRequest request =
        DeleteClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   cloudRedisClusterClient.deleteClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteClusterAsync(String name) {
    DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
    return deleteClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   cloudRedisClusterClient.deleteClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteClusterAsync(DeleteClusterRequest request) {
    return deleteClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, Any> future =
   *       cloudRedisClusterClient.deleteClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteClusterRequest, Empty, Any>
      deleteClusterOperationCallable() {
    return stub.deleteClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteClusterRequest request =
   *       DeleteClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.deleteClusterCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return stub.deleteClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific ACL policy. This action will delete the ACL policy and all the rules
   * associated with it. An ACL policy cannot be deleted if it is attached to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   AclPolicyName name = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]");
   *   cloudRedisClusterClient.deleteAclPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAclPolicyAsync(
      @Nullable AclPolicyName name) {
    DeleteAclPolicyRequest request =
        DeleteAclPolicyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAclPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific ACL policy. This action will delete the ACL policy and all the rules
   * associated with it. An ACL policy cannot be deleted if it is attached to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString();
   *   cloudRedisClusterClient.deleteAclPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAclPolicyAsync(String name) {
    DeleteAclPolicyRequest request = DeleteAclPolicyRequest.newBuilder().setName(name).build();
    return deleteAclPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific ACL policy. This action will delete the ACL policy and all the rules
   * associated with it. An ACL policy cannot be deleted if it is attached to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteAclPolicyRequest request =
   *       DeleteAclPolicyRequest.newBuilder()
   *           .setName(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   cloudRedisClusterClient.deleteAclPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAclPolicyAsync(
      DeleteAclPolicyRequest request) {
    return deleteAclPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific ACL policy. This action will delete the ACL policy and all the rules
   * associated with it. An ACL policy cannot be deleted if it is attached to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteAclPolicyRequest request =
   *       DeleteAclPolicyRequest.newBuilder()
   *           .setName(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudRedisClusterClient.deleteAclPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAclPolicyRequest, Empty, OperationMetadata>
      deleteAclPolicyOperationCallable() {
    return stub.deleteAclPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific ACL policy. This action will delete the ACL policy and all the rules
   * associated with it. An ACL policy cannot be deleted if it is attached to a cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteAclPolicyRequest request =
   *       DeleteAclPolicyRequest.newBuilder()
   *           .setName(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setRequestId("requestId693933066")
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.deleteAclPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAclPolicyRequest, Operation> deleteAclPolicyCallable() {
    return stub.deleteAclPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specific ACL policy revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   AclPolicyRevisionName name =
   *       AclPolicyRevisionName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]", "[REVISION]");
   *   AclPolicyRevision response = cloudRedisClusterClient.getAclPolicyRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy revision resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}/revisions/{revision_id}`
   *     where `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicyRevision getAclPolicyRevision(@Nullable AclPolicyRevisionName name) {
    GetAclPolicyRevisionRequest request =
        GetAclPolicyRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAclPolicyRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specific ACL policy revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name =
   *       AclPolicyRevisionName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]", "[REVISION]")
   *           .toString();
   *   AclPolicyRevision response = cloudRedisClusterClient.getAclPolicyRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis ACL policy revision resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}/revisions/{revision_id}`
   *     where `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicyRevision getAclPolicyRevision(String name) {
    GetAclPolicyRevisionRequest request =
        GetAclPolicyRevisionRequest.newBuilder().setName(name).build();
    return getAclPolicyRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specific ACL policy revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetAclPolicyRevisionRequest request =
   *       GetAclPolicyRevisionRequest.newBuilder()
   *           .setName(
   *               AclPolicyRevisionName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   AclPolicyRevision response = cloudRedisClusterClient.getAclPolicyRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicyRevision getAclPolicyRevision(GetAclPolicyRevisionRequest request) {
    return getAclPolicyRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a specific ACL policy revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetAclPolicyRevisionRequest request =
   *       GetAclPolicyRevisionRequest.newBuilder()
   *           .setName(
   *               AclPolicyRevisionName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AclPolicyRevision> future =
   *       cloudRedisClusterClient.getAclPolicyRevisionCallable().futureCall(request);
   *   // Do something.
   *   AclPolicyRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAclPolicyRevisionRequest, AclPolicyRevision>
      getAclPolicyRevisionCallable() {
    return stub.getAclPolicyRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policy revisions in a given ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   AclPolicyName parent = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]");
   *   for (AclPolicyRevision element :
   *       cloudRedisClusterClient.listAclPolicyRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the ACL policy to list revisions for. Format:
   *     "projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPolicyRevisionsPagedResponse listAclPolicyRevisions(
      @Nullable AclPolicyName parent) {
    ListAclPolicyRevisionsRequest request =
        ListAclPolicyRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAclPolicyRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policy revisions in a given ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString();
   *   for (AclPolicyRevision element :
   *       cloudRedisClusterClient.listAclPolicyRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the ACL policy to list revisions for. Format:
   *     "projects/{project_id}/locations/{location_id}/aclPolicies/{acl_policy_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPolicyRevisionsPagedResponse listAclPolicyRevisions(String parent) {
    ListAclPolicyRevisionsRequest request =
        ListAclPolicyRevisionsRequest.newBuilder().setParent(parent).build();
    return listAclPolicyRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policy revisions in a given ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPolicyRevisionsRequest request =
   *       ListAclPolicyRevisionsRequest.newBuilder()
   *           .setParent(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AclPolicyRevision element :
   *       cloudRedisClusterClient.listAclPolicyRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAclPolicyRevisionsPagedResponse listAclPolicyRevisions(
      ListAclPolicyRevisionsRequest request) {
    return listAclPolicyRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policy revisions in a given ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPolicyRevisionsRequest request =
   *       ListAclPolicyRevisionsRequest.newBuilder()
   *           .setParent(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AclPolicyRevision> future =
   *       cloudRedisClusterClient.listAclPolicyRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AclPolicyRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsPagedResponse>
      listAclPolicyRevisionsPagedCallable() {
    return stub.listAclPolicyRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all ACL policy revisions in a given ACL policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListAclPolicyRevisionsRequest request =
   *       ListAclPolicyRevisionsRequest.newBuilder()
   *           .setParent(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAclPolicyRevisionsResponse response =
   *         cloudRedisClusterClient.listAclPolicyRevisionsCallable().call(request);
   *     for (AclPolicyRevision element : response.getAclPolicyRevisionsList()) {
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
  public final UnaryCallable<ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsResponse>
      listAclPolicyRevisionsCallable() {
    return stub.listAclPolicyRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis cluster based on the specified properties. The creation is executed
   * asynchronously and callers may check the returned operation to track its progress. Once the
   * operation is completed the Redis cluster will be fully functional. The completed
   * longrunning.Operation will contain the new cluster object in the response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response =
   *       cloudRedisClusterClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @param cluster Required. The cluster that is to be created.
   * @param clusterId Required. The logical name of the Redis cluster in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> createClusterAsync(
      @Nullable LocationName parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis cluster based on the specified properties. The creation is executed
   * asynchronously and callers may check the returned operation to track its progress. Once the
   * operation is completed the Redis cluster will be fully functional. The completed
   * longrunning.Operation will contain the new cluster object in the response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Cluster cluster = Cluster.newBuilder().build();
   *   String clusterId = "clusterId561939637";
   *   Cluster response =
   *       cloudRedisClusterClient.createClusterAsync(parent, cluster, clusterId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @param cluster Required. The cluster that is to be created.
   * @param clusterId Required. The logical name of the Redis cluster in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> createClusterAsync(
      String parent, Cluster cluster, String clusterId) {
    CreateClusterRequest request =
        CreateClusterRequest.newBuilder()
            .setParent(parent)
            .setCluster(cluster)
            .setClusterId(clusterId)
            .build();
    return createClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis cluster based on the specified properties. The creation is executed
   * asynchronously and callers may check the returned operation to track its progress. Once the
   * operation is completed the Redis cluster will be fully functional. The completed
   * longrunning.Operation will contain the new cluster object in the response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Cluster response = cloudRedisClusterClient.createClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> createClusterAsync(CreateClusterRequest request) {
    return createClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis cluster based on the specified properties. The creation is executed
   * asynchronously and callers may check the returned operation to track its progress. Once the
   * operation is completed the Redis cluster will be fully functional. The completed
   * longrunning.Operation will contain the new cluster object in the response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Cluster, Any> future =
   *       cloudRedisClusterClient.createClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateClusterRequest, Cluster, Any>
      createClusterOperationCallable() {
    return stub.createClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Redis cluster based on the specified properties. The creation is executed
   * asynchronously and callers may check the returned operation to track its progress. Once the
   * operation is completed the Redis cluster will be fully functional. The completed
   * longrunning.Operation will contain the new cluster object in the response field.
   *
   * <p>The returned operation is automatically deleted after a few hours, so there is no need to
   * call DeleteOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CreateClusterRequest request =
   *       CreateClusterRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setClusterId("clusterId561939637")
   *           .setCluster(Cluster.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.createClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return stub.createClusterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an ACL policy. The creation is executed synchronously and the policy is available for
   * use immediately after the RPC returns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AclPolicy aclPolicy = AclPolicy.newBuilder().build();
   *   String aclPolicyId = "aclPolicyId-1805591401";
   *   AclPolicy response = cloudRedisClusterClient.createAclPolicy(parent, aclPolicy, aclPolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @param aclPolicy Required. The ACL policy that is to be created.
   * @param aclPolicyId Required. The logical name of the ACL policy in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy createAclPolicy(
      @Nullable LocationName parent, AclPolicy aclPolicy, String aclPolicyId) {
    CreateAclPolicyRequest request =
        CreateAclPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAclPolicy(aclPolicy)
            .setAclPolicyId(aclPolicyId)
            .build();
    return createAclPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an ACL policy. The creation is executed synchronously and the policy is available for
   * use immediately after the RPC returns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AclPolicy aclPolicy = AclPolicy.newBuilder().build();
   *   String aclPolicyId = "aclPolicyId-1805591401";
   *   AclPolicy response = cloudRedisClusterClient.createAclPolicy(parent, aclPolicy, aclPolicyId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the cluster location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @param aclPolicy Required. The ACL policy that is to be created.
   * @param aclPolicyId Required. The logical name of the ACL policy in the customer project with
   *     the following restrictions:
   *     <ul>
   *       <li>Must contain only lowercase letters, numbers, and hyphens.
   *       <li>Must start with a letter.
   *       <li>Must be between 1-63 characters.
   *       <li>Must end with a number or a letter.
   *       <li>Must be unique within the customer project / location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy createAclPolicy(String parent, AclPolicy aclPolicy, String aclPolicyId) {
    CreateAclPolicyRequest request =
        CreateAclPolicyRequest.newBuilder()
            .setParent(parent)
            .setAclPolicy(aclPolicy)
            .setAclPolicyId(aclPolicyId)
            .build();
    return createAclPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an ACL policy. The creation is executed synchronously and the policy is available for
   * use immediately after the RPC returns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CreateAclPolicyRequest request =
   *       CreateAclPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAclPolicyId("aclPolicyId-1805591401")
   *           .setAclPolicy(AclPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   AclPolicy response = cloudRedisClusterClient.createAclPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AclPolicy createAclPolicy(CreateAclPolicyRequest request) {
    return createAclPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an ACL policy. The creation is executed synchronously and the policy is available for
   * use immediately after the RPC returns.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CreateAclPolicyRequest request =
   *       CreateAclPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAclPolicyId("aclPolicyId-1805591401")
   *           .setAclPolicy(AclPolicy.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<AclPolicy> future =
   *       cloudRedisClusterClient.createAclPolicyCallable().futureCall(request);
   *   // Do something.
   *   AclPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAclPolicyRequest, AclPolicy> createAclPolicyCallable() {
    return stub.createAclPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   CertificateAuthorityName name =
   *       CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   CertificateAuthority response = cloudRedisClusterClient.getClusterCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster certificate authority resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}/certificateAuthority`
   *     where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getClusterCertificateAuthority(
      @Nullable CertificateAuthorityName name) {
    GetClusterCertificateAuthorityRequest request =
        GetClusterCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getClusterCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   CertificateAuthority response = cloudRedisClusterClient.getClusterCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster certificate authority resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}/certificateAuthority`
   *     where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getClusterCertificateAuthority(String name) {
    GetClusterCertificateAuthorityRequest request =
        GetClusterCertificateAuthorityRequest.newBuilder().setName(name).build();
    return getClusterCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetClusterCertificateAuthorityRequest request =
   *       GetClusterCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   CertificateAuthority response =
   *       cloudRedisClusterClient.getClusterCertificateAuthority(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getClusterCertificateAuthority(
      GetClusterCertificateAuthorityRequest request) {
    return getClusterCertificateAuthorityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetClusterCertificateAuthorityRequest request =
   *       GetClusterCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .build();
   *   ApiFuture<CertificateAuthority> future =
   *       cloudRedisClusterClient.getClusterCertificateAuthorityCallable().futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetClusterCertificateAuthorityRequest, CertificateAuthority>
      getClusterCertificateAuthorityCallable() {
    return stub.getClusterCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   SharedRegionalCertificateAuthorityName name =
   *       SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]");
   *   SharedRegionalCertificateAuthority response =
   *       cloudRedisClusterClient.getSharedRegionalCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Regional certificate authority resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/sharedRegionalCertificateAuthority` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      @Nullable SharedRegionalCertificateAuthorityName name) {
    GetSharedRegionalCertificateAuthorityRequest request =
        GetSharedRegionalCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSharedRegionalCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString();
   *   SharedRegionalCertificateAuthority response =
   *       cloudRedisClusterClient.getSharedRegionalCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Regional certificate authority resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/sharedRegionalCertificateAuthority` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      String name) {
    GetSharedRegionalCertificateAuthorityRequest request =
        GetSharedRegionalCertificateAuthorityRequest.newBuilder().setName(name).build();
    return getSharedRegionalCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetSharedRegionalCertificateAuthorityRequest request =
   *       GetSharedRegionalCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   SharedRegionalCertificateAuthority response =
   *       cloudRedisClusterClient.getSharedRegionalCertificateAuthority(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      GetSharedRegionalCertificateAuthorityRequest request) {
    return getSharedRegionalCertificateAuthorityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of regional certificate authority information for Redis cluster.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetSharedRegionalCertificateAuthorityRequest request =
   *       GetSharedRegionalCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<SharedRegionalCertificateAuthority> future =
   *       cloudRedisClusterClient
   *           .getSharedRegionalCertificateAuthorityCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SharedRegionalCertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
      getSharedRegionalCertificateAuthorityCallable() {
    return stub.getSharedRegionalCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleClusterMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Cluster response =
   *       cloudRedisClusterClient
   *           .rescheduleClusterMaintenanceAsync(name, rescheduleType, scheduleTime)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. Redis Cluster instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time
   *     as well.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format, for example `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> rescheduleClusterMaintenanceAsync(
      @Nullable ClusterName name,
      RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleClusterMaintenanceRequest request =
        RescheduleClusterMaintenanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleClusterMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleClusterMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Cluster response =
   *       cloudRedisClusterClient
   *           .rescheduleClusterMaintenanceAsync(name, rescheduleType, scheduleTime)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. Redis Cluster instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time
   *     as well.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format, for example `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> rescheduleClusterMaintenanceAsync(
      String name,
      RescheduleClusterMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleClusterMaintenanceRequest request =
        RescheduleClusterMaintenanceRequest.newBuilder()
            .setName(name)
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleClusterMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   RescheduleClusterMaintenanceRequest request =
   *       RescheduleClusterMaintenanceRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   Cluster response = cloudRedisClusterClient.rescheduleClusterMaintenanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> rescheduleClusterMaintenanceAsync(
      RescheduleClusterMaintenanceRequest request) {
    return rescheduleClusterMaintenanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   RescheduleClusterMaintenanceRequest request =
   *       RescheduleClusterMaintenanceRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<Cluster, Any> future =
   *       cloudRedisClusterClient
   *           .rescheduleClusterMaintenanceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RescheduleClusterMaintenanceRequest, Cluster, Any>
      rescheduleClusterMaintenanceOperationCallable() {
    return stub.rescheduleClusterMaintenanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   RescheduleClusterMaintenanceRequest request =
   *       RescheduleClusterMaintenanceRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.rescheduleClusterMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RescheduleClusterMaintenanceRequest, Operation>
      rescheduleClusterMaintenanceCallable() {
    return stub.rescheduleClusterMaintenanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupCollection element :
   *       cloudRedisClusterClient.listBackupCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(
      @Nullable LocationName parent) {
    ListBackupCollectionsRequest request =
        ListBackupCollectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupCollection element :
   *       cloudRedisClusterClient.listBackupCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(String parent) {
    ListBackupCollectionsRequest request =
        ListBackupCollectionsRequest.newBuilder().setParent(parent).build();
    return listBackupCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BackupCollection element :
   *       cloudRedisClusterClient.listBackupCollections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(
      ListBackupCollectionsRequest request) {
    return listBackupCollectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BackupCollection> future =
   *       cloudRedisClusterClient.listBackupCollectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupCollection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable() {
    return stub.listBackupCollectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupCollectionsResponse response =
   *         cloudRedisClusterClient.listBackupCollectionsCallable().call(request);
   *     for (BackupCollection element : response.getBackupCollectionsList()) {
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
  public final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable() {
    return stub.listBackupCollectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupCollectionName name =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
   *   BackupCollection response = cloudRedisClusterClient.getBackupCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis backupCollection resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   *     where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(@Nullable BackupCollectionName name) {
    GetBackupCollectionRequest request =
        GetBackupCollectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]").toString();
   *   BackupCollection response = cloudRedisClusterClient.getBackupCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis backupCollection resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   *     where `location_id` refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(String name) {
    GetBackupCollectionRequest request =
        GetBackupCollectionRequest.newBuilder().setName(name).build();
    return getBackupCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetBackupCollectionRequest request =
   *       GetBackupCollectionRequest.newBuilder()
   *           .setName(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .build();
   *   BackupCollection response = cloudRedisClusterClient.getBackupCollection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(GetBackupCollectionRequest request) {
    return getBackupCollectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetBackupCollectionRequest request =
   *       GetBackupCollectionRequest.newBuilder()
   *           .setName(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupCollection> future =
   *       cloudRedisClusterClient.getBackupCollectionCallable().futureCall(request);
   *   // Do something.
   *   BackupCollection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionCallable() {
    return stub.getBackupCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupCollectionName parent =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
   *   for (Backup element : cloudRedisClusterClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(@Nullable BackupCollectionName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String parent =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]").toString();
   *   for (Backup element : cloudRedisClusterClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Backup element : cloudRedisClusterClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Backup> future =
   *       cloudRedisClusterClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = cloudRedisClusterClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
   *   Backup response = cloudRedisClusterClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(@Nullable BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]").toString();
   *   Backup response = cloudRedisClusterClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Redis backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   Backup response = cloudRedisClusterClient.getBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Backup> future = cloudRedisClusterClient.getBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
   *   cloudRedisClusterClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteBackupAsync(@Nullable BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]").toString();
   *   cloudRedisClusterClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   cloudRedisClusterClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Any> deleteBackupAsync(DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, Any> future =
   *       cloudRedisClusterClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Empty, Any> deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   Backup response = cloudRedisClusterClient.exportBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, Any> exportBackupAsync(ExportBackupRequest request) {
    return exportBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Backup, Any> future =
   *       cloudRedisClusterClient.exportBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportBackupRequest, Backup, Any> exportBackupOperationCallable() {
    return stub.exportBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.exportBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    return stub.exportBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Redis Cluster. If this is the first time a backup is being created, a backup collection
   * will be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the cluster's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
   *   Cluster response = cloudRedisClusterClient.backupClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> backupClusterAsync(@Nullable ClusterName name) {
    BackupClusterRequest request =
        BackupClusterRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return backupClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Redis Cluster. If this is the first time a backup is being created, a backup collection
   * will be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the cluster's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   String name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
   *   Cluster response = cloudRedisClusterClient.backupClusterAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Redis cluster resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id`
   *     refers to a GCP region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> backupClusterAsync(String name) {
    BackupClusterRequest request = BackupClusterRequest.newBuilder().setName(name).build();
    return backupClusterAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Redis Cluster. If this is the first time a backup is being created, a backup collection
   * will be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the cluster's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupClusterRequest request =
   *       BackupClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   Cluster response = cloudRedisClusterClient.backupClusterAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Cluster, Any> backupClusterAsync(BackupClusterRequest request) {
    return backupClusterOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Redis Cluster. If this is the first time a backup is being created, a backup collection
   * will be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the cluster's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupClusterRequest request =
   *       BackupClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   OperationFuture<Cluster, Any> future =
   *       cloudRedisClusterClient.backupClusterOperationCallable().futureCall(request);
   *   // Do something.
   *   Cluster response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BackupClusterRequest, Cluster, Any>
      backupClusterOperationCallable() {
    return stub.backupClusterOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Redis Cluster. If this is the first time a backup is being created, a backup collection
   * will be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the cluster's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   BackupClusterRequest request =
   *       BackupClusterRequest.newBuilder()
   *           .setName(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudRedisClusterClient.backupClusterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BackupClusterRequest, Operation> backupClusterCallable() {
    return stub.backupClusterCallable();
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
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cloudRedisClusterClient.listLocations(request).iterateAll()) {
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
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cloudRedisClusterClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         cloudRedisClusterClient.listLocationsCallable().call(request);
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
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cloudRedisClusterClient.getLocation(request);
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
   * try (CloudRedisClusterClient cloudRedisClusterClient = CloudRedisClusterClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       cloudRedisClusterClient.getLocationCallable().futureCall(request);
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

  public static class ListClustersPagedResponse
      extends AbstractPagedListResponse<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    public static ApiFuture<ListClustersPagedResponse> createAsync(
        PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      ApiFuture<ListClustersPage> futurePage =
          ListClustersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListClustersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListClustersPagedResponse(ListClustersPage page) {
      super(page, ListClustersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListClustersPage
      extends AbstractPage<ListClustersRequest, ListClustersResponse, Cluster, ListClustersPage> {

    private ListClustersPage(
        @Nullable PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        @Nullable ListClustersResponse response) {
      super(context, response);
    }

    private static ListClustersPage createEmptyPage() {
      return new ListClustersPage(null, null);
    }

    @Override
    protected ListClustersPage createPage(
        @Nullable PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        @Nullable ListClustersResponse response) {
      return new ListClustersPage(context, response);
    }

    @Override
    public ApiFuture<ListClustersPage> createPageAsync(
        @Nullable PageContext<ListClustersRequest, ListClustersResponse, Cluster> context,
        ApiFuture<ListClustersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListClustersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListClustersRequest,
          ListClustersResponse,
          Cluster,
          ListClustersPage,
          ListClustersFixedSizeCollection> {

    private ListClustersFixedSizeCollection(
        @Nullable List<ListClustersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListClustersFixedSizeCollection createEmptyCollection() {
      return new ListClustersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListClustersFixedSizeCollection createCollection(
        @Nullable List<ListClustersPage> pages, int collectionSize) {
      return new ListClustersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAclPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAclPoliciesRequest,
          ListAclPoliciesResponse,
          AclPolicy,
          ListAclPoliciesPage,
          ListAclPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAclPoliciesPagedResponse> createAsync(
        PageContext<ListAclPoliciesRequest, ListAclPoliciesResponse, AclPolicy> context,
        ApiFuture<ListAclPoliciesResponse> futureResponse) {
      ApiFuture<ListAclPoliciesPage> futurePage =
          ListAclPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAclPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAclPoliciesPagedResponse(ListAclPoliciesPage page) {
      super(page, ListAclPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAclPoliciesPage
      extends AbstractPage<
          ListAclPoliciesRequest, ListAclPoliciesResponse, AclPolicy, ListAclPoliciesPage> {

    private ListAclPoliciesPage(
        @Nullable PageContext<ListAclPoliciesRequest, ListAclPoliciesResponse, AclPolicy> context,
        @Nullable ListAclPoliciesResponse response) {
      super(context, response);
    }

    private static ListAclPoliciesPage createEmptyPage() {
      return new ListAclPoliciesPage(null, null);
    }

    @Override
    protected ListAclPoliciesPage createPage(
        @Nullable PageContext<ListAclPoliciesRequest, ListAclPoliciesResponse, AclPolicy> context,
        @Nullable ListAclPoliciesResponse response) {
      return new ListAclPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAclPoliciesPage> createPageAsync(
        @Nullable PageContext<ListAclPoliciesRequest, ListAclPoliciesResponse, AclPolicy> context,
        ApiFuture<ListAclPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAclPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAclPoliciesRequest,
          ListAclPoliciesResponse,
          AclPolicy,
          ListAclPoliciesPage,
          ListAclPoliciesFixedSizeCollection> {

    private ListAclPoliciesFixedSizeCollection(
        @Nullable List<ListAclPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAclPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAclPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAclPoliciesFixedSizeCollection createCollection(
        @Nullable List<ListAclPoliciesPage> pages, int collectionSize) {
      return new ListAclPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAclPolicyRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListAclPolicyRevisionsRequest,
          ListAclPolicyRevisionsResponse,
          AclPolicyRevision,
          ListAclPolicyRevisionsPage,
          ListAclPolicyRevisionsFixedSizeCollection> {

    public static ApiFuture<ListAclPolicyRevisionsPagedResponse> createAsync(
        PageContext<
                ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsResponse, AclPolicyRevision>
            context,
        ApiFuture<ListAclPolicyRevisionsResponse> futureResponse) {
      ApiFuture<ListAclPolicyRevisionsPage> futurePage =
          ListAclPolicyRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAclPolicyRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAclPolicyRevisionsPagedResponse(ListAclPolicyRevisionsPage page) {
      super(page, ListAclPolicyRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAclPolicyRevisionsPage
      extends AbstractPage<
          ListAclPolicyRevisionsRequest,
          ListAclPolicyRevisionsResponse,
          AclPolicyRevision,
          ListAclPolicyRevisionsPage> {

    private ListAclPolicyRevisionsPage(
        @Nullable
            PageContext<
                ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsResponse, AclPolicyRevision>
            context,
        @Nullable ListAclPolicyRevisionsResponse response) {
      super(context, response);
    }

    private static ListAclPolicyRevisionsPage createEmptyPage() {
      return new ListAclPolicyRevisionsPage(null, null);
    }

    @Override
    protected ListAclPolicyRevisionsPage createPage(
        @Nullable
            PageContext<
                ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsResponse, AclPolicyRevision>
            context,
        @Nullable ListAclPolicyRevisionsResponse response) {
      return new ListAclPolicyRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAclPolicyRevisionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListAclPolicyRevisionsRequest, ListAclPolicyRevisionsResponse, AclPolicyRevision>
            context,
        ApiFuture<ListAclPolicyRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAclPolicyRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAclPolicyRevisionsRequest,
          ListAclPolicyRevisionsResponse,
          AclPolicyRevision,
          ListAclPolicyRevisionsPage,
          ListAclPolicyRevisionsFixedSizeCollection> {

    private ListAclPolicyRevisionsFixedSizeCollection(
        @Nullable List<ListAclPolicyRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAclPolicyRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListAclPolicyRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAclPolicyRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListAclPolicyRevisionsPage> pages, int collectionSize) {
      return new ListAclPolicyRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupCollectionsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage,
          ListBackupCollectionsFixedSizeCollection> {

    public static ApiFuture<ListBackupCollectionsPagedResponse> createAsync(
        PageContext<ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        ApiFuture<ListBackupCollectionsResponse> futureResponse) {
      ApiFuture<ListBackupCollectionsPage> futurePage =
          ListBackupCollectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupCollectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupCollectionsPagedResponse(ListBackupCollectionsPage page) {
      super(page, ListBackupCollectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupCollectionsPage
      extends AbstractPage<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage> {

    private ListBackupCollectionsPage(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        @Nullable ListBackupCollectionsResponse response) {
      super(context, response);
    }

    private static ListBackupCollectionsPage createEmptyPage() {
      return new ListBackupCollectionsPage(null, null);
    }

    @Override
    protected ListBackupCollectionsPage createPage(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        @Nullable ListBackupCollectionsResponse response) {
      return new ListBackupCollectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupCollectionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        ApiFuture<ListBackupCollectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupCollectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage,
          ListBackupCollectionsFixedSizeCollection> {

    private ListBackupCollectionsFixedSizeCollection(
        @Nullable List<ListBackupCollectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupCollectionsFixedSizeCollection createEmptyCollection() {
      return new ListBackupCollectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupCollectionsFixedSizeCollection createCollection(
        @Nullable List<ListBackupCollectionsPage> pages, int collectionSize) {
      return new ListBackupCollectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBackupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
