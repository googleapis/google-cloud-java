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

package com.google.cloud.sql.v1beta4;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.stub.SqlInstancesServiceStub;
import com.google.cloud.sql.v1beta4.stub.SqlInstancesServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
 *   SqlInstancesAddServerCaRequest request =
 *       SqlInstancesAddServerCaRequest.newBuilder()
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlInstancesServiceClient.addServerCa(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SqlInstancesServiceClient object to clean up resources
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
 *      <td><p> AddServerCa</td>
 *      <td><p> Add a new trusted Certificate Authority (CA) version for the specified instance. Required to prepare for a certificate rotation. If a CA version was previously added but never used in a certificate rotation, this operation replaces that version. There cannot be more than one CA version waiting to be rotated in. For instances that have enabled Certificate Authority Service (CAS) based server CA, use AddServerCertificate to add a new server certificate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addServerCa(SqlInstancesAddServerCaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addServerCaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddServerCertificate</td>
 *      <td><p> Add a new trusted server certificate version for the specified instance using Certificate Authority Service (CAS) server CA. Required to prepare for a certificate rotation. If a server certificate version was previously added but never used in a certificate rotation, this operation replaces that version. There cannot be more than one certificate version waiting to be rotated in. For instances not using CAS server CA, use AddServerCa instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addServerCertificate(SqlInstancesAddServerCertificateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addServerCertificateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddEntraIdCertificate</td>
 *      <td><p> Adds a new Entra ID certificate for the specified instance. If an Entra ID certificate was previously added but never used in a certificate rotation, this operation replaces that version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addEntraIdCertificate(SqlInstancesAddEntraIdCertificateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addEntraIdCertificateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Clone</td>
 *      <td><p> Creates a Cloud SQL instance as a clone of the source instance. Using this operation might cause your instance to restart.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> clone(SqlInstancesCloneRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> cloneCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> delete(SqlInstancesDeleteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DemoteMaster</td>
 *      <td><p> Demotes the stand-alone instance to be a Cloud SQL read replica for an external database server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> demoteMaster(SqlInstancesDemoteMasterRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> demoteMasterCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Demote</td>
 *      <td><p> Demotes an existing standalone instance to be a Cloud SQL read replica for an external database server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> demote(SqlInstancesDemoteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> demoteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Export</td>
 *      <td><p> Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL dump or CSV file.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> export(SqlInstancesExportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Failover</td>
 *      <td><p> Initiates a manual failover of a high availability (HA) primary instance to a standby instance, which becomes the primary instance. Users are then rerouted to the new primary. For more information, see the [Overview of high availability](https://cloud.google.com/sql/docs/mysql/high-availability) page in the Cloud SQL documentation. If using Legacy HA (MySQL only), this causes the instance to failover to its failover replica instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> failover(SqlInstancesFailoverRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> failoverCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Reencrypt</td>
 *      <td><p> Reencrypt CMEK instance with latest key version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> reencrypt(SqlInstancesReencryptRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> reencryptCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Retrieves a resource containing information about a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(SqlInstancesGetRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Import</td>
 *      <td><p> Imports data into a Cloud SQL instance from a SQL dump  or CSV file in Cloud Storage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> import_(SqlInstancesImportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> import_Callable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insert(SqlInstancesInsertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Lists instances under a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(SqlInstancesListRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServerCas</td>
 *      <td><p> Lists all of the trusted Certificate Authorities (CAs) for the specified instance. There can be up to three CAs listed: the CA that was used to sign the certificate that is currently in use, a CA that has been added but not yet used to sign a certificate, and a CA used to sign a certificate that has previously rotated out.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServerCas(SqlInstancesListServerCasRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServerCasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServerCertificates</td>
 *      <td><p> Lists all versions of server certificates and certificate authorities (CAs) for the specified instance. There can be up to three sets of certs listed: the certificate that is currently in use, a future that has been added but not yet used to sign a certificate, and a certificate that has been rotated out. For instances not using Certificate Authority Service (CAS) server CA, use ListServerCas instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServerCertificates(SqlInstancesListServerCertificatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServerCertificatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntraIdCertificates</td>
 *      <td><p> Lists all versions of EntraID certificates for the specified instance. There can be up to three sets of certificates listed: the certificate that is currently in use, a future that has been added but not yet used to sign a certificate, and a certificate that has been rotated out.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntraIdCertificates(SqlInstancesListEntraIdCertificatesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntraIdCertificatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Partially updates settings of a Cloud SQL instance by merging the request with the current configuration. This method supports patch semantics.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patch(SqlInstancesPatchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PromoteReplica</td>
 *      <td><p> Promotes the read replica instance to be an independent Cloud SQL primary instance. Using this operation might cause your instance to restart.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> promoteReplica(SqlInstancesPromoteReplicaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> promoteReplicaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Switchover</td>
 *      <td><p> Switches over from the primary instance to the DR replica instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> switchover(SqlInstancesSwitchoverRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> switchoverCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetSslConfig</td>
 *      <td><p> Deletes all client certificates and generates a new server SSL certificate for the instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetSslConfig(SqlInstancesResetSslConfigRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetSslConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Restart</td>
 *      <td><p> Restarts a Cloud SQL instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restart(SqlInstancesRestartRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreBackup</td>
 *      <td><p> Restores a backup of a Cloud SQL instance. Using this operation might cause your instance to restart.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreBackup(SqlInstancesRestoreBackupRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RotateServerCa</td>
 *      <td><p> Rotates the server certificate to one signed by the Certificate Authority (CA) version previously added with the addServerCA method. For instances that have enabled Certificate Authority Service (CAS) based server CA, use RotateServerCertificate to rotate the server certificate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rotateServerCa(SqlInstancesRotateServerCaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rotateServerCaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RotateServerCertificate</td>
 *      <td><p> Rotates the server certificate version to one previously added with the addServerCertificate method. For instances not using Certificate Authority Service (CAS) server CA, use RotateServerCa instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rotateServerCertificate(SqlInstancesRotateServerCertificateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rotateServerCertificateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RotateEntraIdCertificate</td>
 *      <td><p> Rotates the Entra Id certificate version to one previously added with the addEntraIdCertificate method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rotateEntraIdCertificate(SqlInstancesRotateEntraIdCertificateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rotateEntraIdCertificateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartReplica</td>
 *      <td><p> Starts the replication in the read replica instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startReplica(SqlInstancesStartReplicaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startReplicaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopReplica</td>
 *      <td><p> Stops the replication in the read replica instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopReplica(SqlInstancesStopReplicaRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopReplicaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TruncateLog</td>
 *      <td><p> Truncate MySQL general and slow query log tables MySQL only.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> truncateLog(SqlInstancesTruncateLogRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> truncateLogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Updates settings of a Cloud SQL instance. Using this operation might cause your instance to restart.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> update(SqlInstancesUpdateRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEphemeral</td>
 *      <td><p> Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEphemeral(SqlInstancesCreateEphemeralCertRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEphemeralCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RescheduleMaintenance</td>
 *      <td><p> Reschedules the maintenance on the given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rescheduleMaintenance(SqlInstancesRescheduleMaintenanceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rescheduleMaintenanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> VerifyExternalSyncSettings</td>
 *      <td><p> Verify External primary instance external sync settings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> verifyExternalSyncSettings(SqlInstancesVerifyExternalSyncSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> verifyExternalSyncSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartExternalSync</td>
 *      <td><p> Start External primary instance migration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startExternalSync(SqlInstancesStartExternalSyncRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startExternalSyncCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PerformDiskShrink</td>
 *      <td><p> Perform Disk Shrink on primary instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> performDiskShrink(SqlInstancesPerformDiskShrinkRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> performDiskShrinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiskShrinkConfig</td>
 *      <td><p> Get Disk Shrink Config for a given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiskShrinkConfig(SqlInstancesGetDiskShrinkConfigRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiskShrinkConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetReplicaSize</td>
 *      <td><p> Reset Replica Size to primary instance disk size.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetReplicaSize(SqlInstancesResetReplicaSizeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetReplicaSizeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLatestRecoveryTime</td>
 *      <td><p> Get Latest Recovery Time for a given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLatestRecoveryTime(SqlInstancesGetLatestRecoveryTimeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLatestRecoveryTimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExecuteSql</td>
 *      <td><p> Execute SQL statements.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> executeSql(SqlInstancesExecuteSqlRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> executeSqlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AcquireSsrsLease</td>
 *      <td><p> Acquire a lease for the setup of SQL Server Reporting Services (SSRS).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acquireSsrsLease(SqlInstancesAcquireSsrsLeaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acquireSsrsLeaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReleaseSsrsLease</td>
 *      <td><p> Release a lease for the setup of SQL Server Reporting Services (SSRS).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> releaseSsrsLease(SqlInstancesReleaseSsrsLeaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> releaseSsrsLeaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PreCheckMajorVersionUpgrade</td>
 *      <td><p> Execute MVU Pre-checks</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> preCheckMajorVersionUpgrade(SqlInstancesPreCheckMajorVersionUpgradeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> preCheckMajorVersionUpgradeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PointInTimeRestore</td>
 *      <td><p> Point in time restore for an instance managed by Google Cloud Backup and Disaster Recovery.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pointInTimeRestore(SqlInstancesPointInTimeRestoreRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pointInTimeRestoreCallable()
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
 * <p>This class can be customized by passing in a custom instance of SqlInstancesServiceSettings to
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
 * SqlInstancesServiceSettings sqlInstancesServiceSettings =
 *     SqlInstancesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SqlInstancesServiceClient sqlInstancesServiceClient =
 *     SqlInstancesServiceClient.create(sqlInstancesServiceSettings);
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
 * SqlInstancesServiceSettings sqlInstancesServiceSettings =
 *     SqlInstancesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SqlInstancesServiceClient sqlInstancesServiceClient =
 *     SqlInstancesServiceClient.create(sqlInstancesServiceSettings);
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
 * SqlInstancesServiceSettings sqlInstancesServiceSettings =
 *     SqlInstancesServiceSettings.newHttpJsonBuilder().build();
 * SqlInstancesServiceClient sqlInstancesServiceClient =
 *     SqlInstancesServiceClient.create(sqlInstancesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class SqlInstancesServiceClient implements BackgroundResource {
  private final @Nullable SqlInstancesServiceSettings settings;
  private final SqlInstancesServiceStub stub;

  /** Constructs an instance of SqlInstancesServiceClient with default settings. */
  public static final SqlInstancesServiceClient create() throws IOException {
    return create(SqlInstancesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SqlInstancesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SqlInstancesServiceClient create(SqlInstancesServiceSettings settings)
      throws IOException {
    return new SqlInstancesServiceClient(settings);
  }

  /**
   * Constructs an instance of SqlInstancesServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SqlInstancesServiceSettings).
   */
  public static final SqlInstancesServiceClient create(SqlInstancesServiceStub stub) {
    return new SqlInstancesServiceClient(stub);
  }

  /**
   * Constructs an instance of SqlInstancesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SqlInstancesServiceClient(SqlInstancesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SqlInstancesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SqlInstancesServiceClient(SqlInstancesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SqlInstancesServiceSettings getSettings() {
    return settings;
  }

  public SqlInstancesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new trusted Certificate Authority (CA) version for the specified instance. Required to
   * prepare for a certificate rotation. If a CA version was previously added but never used in a
   * certificate rotation, this operation replaces that version. There cannot be more than one CA
   * version waiting to be rotated in. For instances that have enabled Certificate Authority Service
   * (CAS) based server CA, use AddServerCertificate to add a new server certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddServerCaRequest request =
   *       SqlInstancesAddServerCaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.addServerCa(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addServerCa(SqlInstancesAddServerCaRequest request) {
    return addServerCaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new trusted Certificate Authority (CA) version for the specified instance. Required to
   * prepare for a certificate rotation. If a CA version was previously added but never used in a
   * certificate rotation, this operation replaces that version. There cannot be more than one CA
   * version waiting to be rotated in. For instances that have enabled Certificate Authority Service
   * (CAS) based server CA, use AddServerCertificate to add a new server certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddServerCaRequest request =
   *       SqlInstancesAddServerCaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.addServerCaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesAddServerCaRequest, Operation> addServerCaCallable() {
    return stub.addServerCaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new trusted server certificate version for the specified instance using Certificate
   * Authority Service (CAS) server CA. Required to prepare for a certificate rotation. If a server
   * certificate version was previously added but never used in a certificate rotation, this
   * operation replaces that version. There cannot be more than one certificate version waiting to
   * be rotated in. For instances not using CAS server CA, use AddServerCa instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddServerCertificateRequest request =
   *       SqlInstancesAddServerCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.addServerCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addServerCertificate(SqlInstancesAddServerCertificateRequest request) {
    return addServerCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new trusted server certificate version for the specified instance using Certificate
   * Authority Service (CAS) server CA. Required to prepare for a certificate rotation. If a server
   * certificate version was previously added but never used in a certificate rotation, this
   * operation replaces that version. There cannot be more than one certificate version waiting to
   * be rotated in. For instances not using CAS server CA, use AddServerCa instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddServerCertificateRequest request =
   *       SqlInstancesAddServerCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.addServerCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesAddServerCertificateRequest, Operation>
      addServerCertificateCallable() {
    return stub.addServerCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Entra ID certificate for the specified instance. If an Entra ID certificate was
   * previously added but never used in a certificate rotation, this operation replaces that
   * version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddEntraIdCertificateRequest request =
   *       SqlInstancesAddEntraIdCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.addEntraIdCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addEntraIdCertificate(SqlInstancesAddEntraIdCertificateRequest request) {
    return addEntraIdCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a new Entra ID certificate for the specified instance. If an Entra ID certificate was
   * previously added but never used in a certificate rotation, this operation replaces that
   * version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAddEntraIdCertificateRequest request =
   *       SqlInstancesAddEntraIdCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.addEntraIdCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesAddEntraIdCertificateRequest, Operation>
      addEntraIdCertificateCallable() {
    return stub.addEntraIdCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud SQL instance as a clone of the source instance. Using this operation might
   * cause your instance to restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesCloneRequest request =
   *       SqlInstancesCloneRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesCloneRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.clone(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation clone(SqlInstancesCloneRequest request) {
    return cloneCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud SQL instance as a clone of the source instance. Using this operation might
   * cause your instance to restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesCloneRequest request =
   *       SqlInstancesCloneRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesCloneRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.cloneCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesCloneRequest, Operation> cloneCallable() {
    return stub.cloneCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDeleteRequest request =
   *       SqlInstancesDeleteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setEnableFinalBackup(true)
   *           .setFinalBackupDescription("finalBackupDescription-293551612")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(SqlInstancesDeleteRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDeleteRequest request =
   *       SqlInstancesDeleteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setEnableFinalBackup(true)
   *           .setFinalBackupDescription("finalBackupDescription-293551612")
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesDeleteRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Demotes the stand-alone instance to be a Cloud SQL read replica for an external database
   * server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDemoteMasterRequest request =
   *       SqlInstancesDemoteMasterRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesDemoteMasterRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.demoteMaster(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation demoteMaster(SqlInstancesDemoteMasterRequest request) {
    return demoteMasterCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Demotes the stand-alone instance to be a Cloud SQL read replica for an external database
   * server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDemoteMasterRequest request =
   *       SqlInstancesDemoteMasterRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesDemoteMasterRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.demoteMasterCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesDemoteMasterRequest, Operation> demoteMasterCallable() {
    return stub.demoteMasterCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Demotes an existing standalone instance to be a Cloud SQL read replica for an external database
   * server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDemoteRequest request =
   *       SqlInstancesDemoteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesDemoteRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.demote(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation demote(SqlInstancesDemoteRequest request) {
    return demoteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Demotes an existing standalone instance to be a Cloud SQL read replica for an external database
   * server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesDemoteRequest request =
   *       SqlInstancesDemoteRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesDemoteRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.demoteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesDemoteRequest, Operation> demoteCallable() {
    return stub.demoteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL dump or CSV file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesExportRequest request =
   *       SqlInstancesExportRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesExportRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.export(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation export(SqlInstancesExportRequest request) {
    return exportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL dump or CSV file.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesExportRequest request =
   *       SqlInstancesExportRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesExportRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.exportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesExportRequest, Operation> exportCallable() {
    return stub.exportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a manual failover of a high availability (HA) primary instance to a standby instance,
   * which becomes the primary instance. Users are then rerouted to the new primary. For more
   * information, see the [Overview of high
   * availability](https://cloud.google.com/sql/docs/mysql/high-availability) page in the Cloud SQL
   * documentation. If using Legacy HA (MySQL only), this causes the instance to failover to its
   * failover replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesFailoverRequest request =
   *       SqlInstancesFailoverRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesFailoverRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.failover(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation failover(SqlInstancesFailoverRequest request) {
    return failoverCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a manual failover of a high availability (HA) primary instance to a standby instance,
   * which becomes the primary instance. Users are then rerouted to the new primary. For more
   * information, see the [Overview of high
   * availability](https://cloud.google.com/sql/docs/mysql/high-availability) page in the Cloud SQL
   * documentation. If using Legacy HA (MySQL only), this causes the instance to failover to its
   * failover replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesFailoverRequest request =
   *       SqlInstancesFailoverRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesFailoverRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.failoverCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesFailoverRequest, Operation> failoverCallable() {
    return stub.failoverCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reencrypt CMEK instance with latest key version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesReencryptRequest request =
   *       SqlInstancesReencryptRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesReencryptRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.reencrypt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation reencrypt(SqlInstancesReencryptRequest request) {
    return reencryptCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reencrypt CMEK instance with latest key version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesReencryptRequest request =
   *       SqlInstancesReencryptRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesReencryptRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.reencryptCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesReencryptRequest, Operation> reencryptCallable() {
    return stub.reencryptCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetRequest request =
   *       SqlInstancesGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   DatabaseInstance response = sqlInstancesServiceClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatabaseInstance get(SqlInstancesGetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetRequest request =
   *       SqlInstancesGetRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<DatabaseInstance> future =
   *       sqlInstancesServiceClient.getCallable().futureCall(request);
   *   // Do something.
   *   DatabaseInstance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesGetRequest, DatabaseInstance> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Cloud SQL instance from a SQL dump or CSV file in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesImportRequest request =
   *       SqlInstancesImportRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesImportRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.import_(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation import_(SqlInstancesImportRequest request) {
    return import_Callable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports data into a Cloud SQL instance from a SQL dump or CSV file in Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesImportRequest request =
   *       SqlInstancesImportRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesImportRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.importCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesImportRequest, Operation> import_Callable() {
    return stub.import_Callable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesInsertRequest request =
   *       SqlInstancesInsertRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(SqlInstancesInsertRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesInsertRequest request =
   *       SqlInstancesInsertRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesInsertRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances under a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListRequest request =
   *       SqlInstancesListRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   InstancesListResponse response = sqlInstancesServiceClient.list(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesListResponse list(SqlInstancesListRequest request) {
    return listCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists instances under a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListRequest request =
   *       SqlInstancesListRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<InstancesListResponse> future =
   *       sqlInstancesServiceClient.listCallable().futureCall(request);
   *   // Do something.
   *   InstancesListResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesListRequest, InstancesListResponse> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the trusted Certificate Authorities (CAs) for the specified instance. There can be
   * up to three CAs listed: the CA that was used to sign the certificate that is currently in use,
   * a CA that has been added but not yet used to sign a certificate, and a CA used to sign a
   * certificate that has previously rotated out.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListServerCasRequest request =
   *       SqlInstancesListServerCasRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   InstancesListServerCasResponse response = sqlInstancesServiceClient.listServerCas(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesListServerCasResponse listServerCas(
      SqlInstancesListServerCasRequest request) {
    return listServerCasCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all of the trusted Certificate Authorities (CAs) for the specified instance. There can be
   * up to three CAs listed: the CA that was used to sign the certificate that is currently in use,
   * a CA that has been added but not yet used to sign a certificate, and a CA used to sign a
   * certificate that has previously rotated out.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListServerCasRequest request =
   *       SqlInstancesListServerCasRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<InstancesListServerCasResponse> future =
   *       sqlInstancesServiceClient.listServerCasCallable().futureCall(request);
   *   // Do something.
   *   InstancesListServerCasResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesListServerCasRequest, InstancesListServerCasResponse>
      listServerCasCallable() {
    return stub.listServerCasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of server certificates and certificate authorities (CAs) for the specified
   * instance. There can be up to three sets of certs listed: the certificate that is currently in
   * use, a future that has been added but not yet used to sign a certificate, and a certificate
   * that has been rotated out. For instances not using Certificate Authority Service (CAS) server
   * CA, use ListServerCas instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListServerCertificatesRequest request =
   *       SqlInstancesListServerCertificatesRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   InstancesListServerCertificatesResponse response =
   *       sqlInstancesServiceClient.listServerCertificates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesListServerCertificatesResponse listServerCertificates(
      SqlInstancesListServerCertificatesRequest request) {
    return listServerCertificatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of server certificates and certificate authorities (CAs) for the specified
   * instance. There can be up to three sets of certs listed: the certificate that is currently in
   * use, a future that has been added but not yet used to sign a certificate, and a certificate
   * that has been rotated out. For instances not using Certificate Authority Service (CAS) server
   * CA, use ListServerCas instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListServerCertificatesRequest request =
   *       SqlInstancesListServerCertificatesRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<InstancesListServerCertificatesResponse> future =
   *       sqlInstancesServiceClient.listServerCertificatesCallable().futureCall(request);
   *   // Do something.
   *   InstancesListServerCertificatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesListServerCertificatesRequest, InstancesListServerCertificatesResponse>
      listServerCertificatesCallable() {
    return stub.listServerCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of EntraID certificates for the specified instance. There can be up to three
   * sets of certificates listed: the certificate that is currently in use, a future that has been
   * added but not yet used to sign a certificate, and a certificate that has been rotated out.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListEntraIdCertificatesRequest request =
   *       SqlInstancesListEntraIdCertificatesRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   InstancesListEntraIdCertificatesResponse response =
   *       sqlInstancesServiceClient.listEntraIdCertificates(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstancesListEntraIdCertificatesResponse listEntraIdCertificates(
      SqlInstancesListEntraIdCertificatesRequest request) {
    return listEntraIdCertificatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of EntraID certificates for the specified instance. There can be up to three
   * sets of certificates listed: the certificate that is currently in use, a future that has been
   * added but not yet used to sign a certificate, and a certificate that has been rotated out.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesListEntraIdCertificatesRequest request =
   *       SqlInstancesListEntraIdCertificatesRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<InstancesListEntraIdCertificatesResponse> future =
   *       sqlInstancesServiceClient.listEntraIdCertificatesCallable().futureCall(request);
   *   // Do something.
   *   InstancesListEntraIdCertificatesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesListEntraIdCertificatesRequest, InstancesListEntraIdCertificatesResponse>
      listEntraIdCertificatesCallable() {
    return stub.listEntraIdCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates settings of a Cloud SQL instance by merging the request with the current
   * configuration. This method supports patch semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPatchRequest request =
   *       SqlInstancesPatchRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setReconcilePscNetworking(true)
   *           .setReconcilePscNetworkingForce(true)
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.patch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(SqlInstancesPatchRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partially updates settings of a Cloud SQL instance by merging the request with the current
   * configuration. This method supports patch semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPatchRequest request =
   *       SqlInstancesPatchRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setReconcilePscNetworking(true)
   *           .setReconcilePscNetworkingForce(true)
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesPatchRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Promotes the read replica instance to be an independent Cloud SQL primary instance. Using this
   * operation might cause your instance to restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPromoteReplicaRequest request =
   *       SqlInstancesPromoteReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setFailover(true)
   *           .build();
   *   Operation response = sqlInstancesServiceClient.promoteReplica(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation promoteReplica(SqlInstancesPromoteReplicaRequest request) {
    return promoteReplicaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Promotes the read replica instance to be an independent Cloud SQL primary instance. Using this
   * operation might cause your instance to restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPromoteReplicaRequest request =
   *       SqlInstancesPromoteReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setFailover(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.promoteReplicaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesPromoteReplicaRequest, Operation>
      promoteReplicaCallable() {
    return stub.promoteReplicaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switches over from the primary instance to the DR replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesSwitchoverRequest request =
   *       SqlInstancesSwitchoverRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setDbTimeout(Duration.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.switchover(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation switchover(SqlInstancesSwitchoverRequest request) {
    return switchoverCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Switches over from the primary instance to the DR replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesSwitchoverRequest request =
   *       SqlInstancesSwitchoverRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setDbTimeout(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.switchoverCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesSwitchoverRequest, Operation> switchoverCallable() {
    return stub.switchoverCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all client certificates and generates a new server SSL certificate for the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesResetSslConfigRequest request =
   *       SqlInstancesResetSslConfigRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.resetSslConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resetSslConfig(SqlInstancesResetSslConfigRequest request) {
    return resetSslConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all client certificates and generates a new server SSL certificate for the instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesResetSslConfigRequest request =
   *       SqlInstancesResetSslConfigRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.resetSslConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesResetSslConfigRequest, Operation>
      resetSslConfigCallable() {
    return stub.resetSslConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRestartRequest request =
   *       SqlInstancesRestartRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.restart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation restart(SqlInstancesRestartRequest request) {
    return restartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restarts a Cloud SQL instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRestartRequest request =
   *       SqlInstancesRestartRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.restartCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRestartRequest, Operation> restartCallable() {
    return stub.restartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a backup of a Cloud SQL instance. Using this operation might cause your instance to
   * restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRestoreBackupRequest request =
   *       SqlInstancesRestoreBackupRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRestoreBackupRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.restoreBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation restoreBackup(SqlInstancesRestoreBackupRequest request) {
    return restoreBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores a backup of a Cloud SQL instance. Using this operation might cause your instance to
   * restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRestoreBackupRequest request =
   *       SqlInstancesRestoreBackupRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRestoreBackupRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.restoreBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRestoreBackupRequest, Operation> restoreBackupCallable() {
    return stub.restoreBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the server certificate to one signed by the Certificate Authority (CA) version
   * previously added with the addServerCA method. For instances that have enabled Certificate
   * Authority Service (CAS) based server CA, use RotateServerCertificate to rotate the server
   * certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateServerCaRequest request =
   *       SqlInstancesRotateServerCaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateServerCaRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.rotateServerCa(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rotateServerCa(SqlInstancesRotateServerCaRequest request) {
    return rotateServerCaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the server certificate to one signed by the Certificate Authority (CA) version
   * previously added with the addServerCA method. For instances that have enabled Certificate
   * Authority Service (CAS) based server CA, use RotateServerCertificate to rotate the server
   * certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateServerCaRequest request =
   *       SqlInstancesRotateServerCaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateServerCaRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.rotateServerCaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRotateServerCaRequest, Operation>
      rotateServerCaCallable() {
    return stub.rotateServerCaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the server certificate version to one previously added with the addServerCertificate
   * method. For instances not using Certificate Authority Service (CAS) server CA, use
   * RotateServerCa instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateServerCertificateRequest request =
   *       SqlInstancesRotateServerCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateServerCertificateRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.rotateServerCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rotateServerCertificate(
      SqlInstancesRotateServerCertificateRequest request) {
    return rotateServerCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the server certificate version to one previously added with the addServerCertificate
   * method. For instances not using Certificate Authority Service (CAS) server CA, use
   * RotateServerCa instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateServerCertificateRequest request =
   *       SqlInstancesRotateServerCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateServerCertificateRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.rotateServerCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRotateServerCertificateRequest, Operation>
      rotateServerCertificateCallable() {
    return stub.rotateServerCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the Entra Id certificate version to one previously added with the addEntraIdCertificate
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateEntraIdCertificateRequest request =
   *       SqlInstancesRotateEntraIdCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateEntraIdCertificateRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.rotateEntraIdCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rotateEntraIdCertificate(
      SqlInstancesRotateEntraIdCertificateRequest request) {
    return rotateEntraIdCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rotates the Entra Id certificate version to one previously added with the addEntraIdCertificate
   * method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRotateEntraIdCertificateRequest request =
   *       SqlInstancesRotateEntraIdCertificateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesRotateEntraIdCertificateRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.rotateEntraIdCertificateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRotateEntraIdCertificateRequest, Operation>
      rotateEntraIdCertificateCallable() {
    return stub.rotateEntraIdCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the replication in the read replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStartReplicaRequest request =
   *       SqlInstancesStartReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.startReplica(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startReplica(SqlInstancesStartReplicaRequest request) {
    return startReplicaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the replication in the read replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStartReplicaRequest request =
   *       SqlInstancesStartReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.startReplicaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesStartReplicaRequest, Operation> startReplicaCallable() {
    return stub.startReplicaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the replication in the read replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStopReplicaRequest request =
   *       SqlInstancesStopReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.stopReplica(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation stopReplica(SqlInstancesStopReplicaRequest request) {
    return stopReplicaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the replication in the read replica instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStopReplicaRequest request =
   *       SqlInstancesStopReplicaRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.stopReplicaCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesStopReplicaRequest, Operation> stopReplicaCallable() {
    return stub.stopReplicaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Truncate MySQL general and slow query log tables MySQL only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesTruncateLogRequest request =
   *       SqlInstancesTruncateLogRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesTruncateLogRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.truncateLog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation truncateLog(SqlInstancesTruncateLogRequest request) {
    return truncateLogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Truncate MySQL general and slow query log tables MySQL only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesTruncateLogRequest request =
   *       SqlInstancesTruncateLogRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesTruncateLogRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.truncateLogCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesTruncateLogRequest, Operation> truncateLogCallable() {
    return stub.truncateLogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates settings of a Cloud SQL instance. Using this operation might cause your instance to
   * restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesUpdateRequest request =
   *       SqlInstancesUpdateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.update(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(SqlInstancesUpdateRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates settings of a Cloud SQL instance. Using this operation might cause your instance to
   * restart.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesUpdateRequest request =
   *       SqlInstancesUpdateRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(DatabaseInstance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = sqlInstancesServiceClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesUpdateRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived X509 certificate containing the provided public key and signed by a
   * private key specific to the target instance. Users may use the certificate to authenticate as
   * themselves when connecting to the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesCreateEphemeralCertRequest request =
   *       SqlInstancesCreateEphemeralCertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SslCertsCreateEphemeralRequest.newBuilder().build())
   *           .build();
   *   SslCert response = sqlInstancesServiceClient.createEphemeral(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SslCert createEphemeral(SqlInstancesCreateEphemeralCertRequest request) {
    return createEphemeralCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a short-lived X509 certificate containing the provided public key and signed by a
   * private key specific to the target instance. Users may use the certificate to authenticate as
   * themselves when connecting to the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesCreateEphemeralCertRequest request =
   *       SqlInstancesCreateEphemeralCertRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SslCertsCreateEphemeralRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<SslCert> future =
   *       sqlInstancesServiceClient.createEphemeralCallable().futureCall(request);
   *   // Do something.
   *   SslCert response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesCreateEphemeralCertRequest, SslCert>
      createEphemeralCallable() {
    return stub.createEphemeralCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules the maintenance on the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRescheduleMaintenanceRequest request =
   *       SqlInstancesRescheduleMaintenanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SqlInstancesRescheduleMaintenanceRequestBody.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.rescheduleMaintenance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation rescheduleMaintenance(SqlInstancesRescheduleMaintenanceRequest request) {
    return rescheduleMaintenanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules the maintenance on the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesRescheduleMaintenanceRequest request =
   *       SqlInstancesRescheduleMaintenanceRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(SqlInstancesRescheduleMaintenanceRequestBody.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.rescheduleMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesRescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    return stub.rescheduleMaintenanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify External primary instance external sync settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesVerifyExternalSyncSettingsRequest request =
   *       SqlInstancesVerifyExternalSyncSettingsRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setVerifyConnectionOnly(true)
   *           .setVerifyReplicationOnly(true)
   *           .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
   *           .addAllSelectedObjects(new ArrayList<ExternalSyncSelectedObject>())
   *           .build();
   *   SqlInstancesVerifyExternalSyncSettingsResponse response =
   *       sqlInstancesServiceClient.verifyExternalSyncSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesVerifyExternalSyncSettingsResponse verifyExternalSyncSettings(
      SqlInstancesVerifyExternalSyncSettingsRequest request) {
    return verifyExternalSyncSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verify External primary instance external sync settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesVerifyExternalSyncSettingsRequest request =
   *       SqlInstancesVerifyExternalSyncSettingsRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setVerifyConnectionOnly(true)
   *           .setVerifyReplicationOnly(true)
   *           .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
   *           .addAllSelectedObjects(new ArrayList<ExternalSyncSelectedObject>())
   *           .build();
   *   ApiFuture<SqlInstancesVerifyExternalSyncSettingsResponse> future =
   *       sqlInstancesServiceClient.verifyExternalSyncSettingsCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesVerifyExternalSyncSettingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesVerifyExternalSyncSettingsRequest,
          SqlInstancesVerifyExternalSyncSettingsResponse>
      verifyExternalSyncSettingsCallable() {
    return stub.verifyExternalSyncSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start External primary instance migration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStartExternalSyncRequest request =
   *       SqlInstancesStartExternalSyncRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSkipVerification(true)
   *           .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
   *           .setReplicaOverwriteEnabled(true)
   *           .build();
   *   Operation response = sqlInstancesServiceClient.startExternalSync(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation startExternalSync(SqlInstancesStartExternalSyncRequest request) {
    return startExternalSyncCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start External primary instance migration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesStartExternalSyncRequest request =
   *       SqlInstancesStartExternalSyncRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSkipVerification(true)
   *           .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
   *           .setReplicaOverwriteEnabled(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.startExternalSyncCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesStartExternalSyncRequest, Operation>
      startExternalSyncCallable() {
    return stub.startExternalSyncCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform Disk Shrink on primary instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPerformDiskShrinkRequest request =
   *       SqlInstancesPerformDiskShrinkRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(PerformDiskShrinkContext.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.performDiskShrink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation performDiskShrink(SqlInstancesPerformDiskShrinkRequest request) {
    return performDiskShrinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform Disk Shrink on primary instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPerformDiskShrinkRequest request =
   *       SqlInstancesPerformDiskShrinkRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(PerformDiskShrinkContext.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.performDiskShrinkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesPerformDiskShrinkRequest, Operation>
      performDiskShrinkCallable() {
    return stub.performDiskShrinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Disk Shrink Config for a given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetDiskShrinkConfigRequest request =
   *       SqlInstancesGetDiskShrinkConfigRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   SqlInstancesGetDiskShrinkConfigResponse response =
   *       sqlInstancesServiceClient.getDiskShrinkConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesGetDiskShrinkConfigResponse getDiskShrinkConfig(
      SqlInstancesGetDiskShrinkConfigRequest request) {
    return getDiskShrinkConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Disk Shrink Config for a given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetDiskShrinkConfigRequest request =
   *       SqlInstancesGetDiskShrinkConfigRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<SqlInstancesGetDiskShrinkConfigResponse> future =
   *       sqlInstancesServiceClient.getDiskShrinkConfigCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesGetDiskShrinkConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesGetDiskShrinkConfigRequest, SqlInstancesGetDiskShrinkConfigResponse>
      getDiskShrinkConfigCallable() {
    return stub.getDiskShrinkConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset Replica Size to primary instance disk size.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesResetReplicaSizeRequest request =
   *       SqlInstancesResetReplicaSizeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   Operation response = sqlInstancesServiceClient.resetReplicaSize(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation resetReplicaSize(SqlInstancesResetReplicaSizeRequest request) {
    return resetReplicaSizeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset Replica Size to primary instance disk size.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesResetReplicaSizeRequest request =
   *       SqlInstancesResetReplicaSizeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.resetReplicaSizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesResetReplicaSizeRequest, Operation>
      resetReplicaSizeCallable() {
    return stub.resetReplicaSizeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Latest Recovery Time for a given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetLatestRecoveryTimeRequest request =
   *       SqlInstancesGetLatestRecoveryTimeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSourceInstanceDeletionTime(Timestamp.newBuilder().build())
   *           .build();
   *   SqlInstancesGetLatestRecoveryTimeResponse response =
   *       sqlInstancesServiceClient.getLatestRecoveryTime(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesGetLatestRecoveryTimeResponse getLatestRecoveryTime(
      SqlInstancesGetLatestRecoveryTimeRequest request) {
    return getLatestRecoveryTimeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Latest Recovery Time for a given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesGetLatestRecoveryTimeRequest request =
   *       SqlInstancesGetLatestRecoveryTimeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setSourceInstanceDeletionTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<SqlInstancesGetLatestRecoveryTimeResponse> future =
   *       sqlInstancesServiceClient.getLatestRecoveryTimeCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesGetLatestRecoveryTimeResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesGetLatestRecoveryTimeRequest, SqlInstancesGetLatestRecoveryTimeResponse>
      getLatestRecoveryTimeCallable() {
    return stub.getLatestRecoveryTimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute SQL statements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesExecuteSqlRequest request =
   *       SqlInstancesExecuteSqlRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(ExecuteSqlPayload.newBuilder().build())
   *           .build();
   *   SqlInstancesExecuteSqlResponse response = sqlInstancesServiceClient.executeSql(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesExecuteSqlResponse executeSql(SqlInstancesExecuteSqlRequest request) {
    return executeSqlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute SQL statements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesExecuteSqlRequest request =
   *       SqlInstancesExecuteSqlRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(ExecuteSqlPayload.newBuilder().build())
   *           .build();
   *   ApiFuture<SqlInstancesExecuteSqlResponse> future =
   *       sqlInstancesServiceClient.executeSqlCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesExecuteSqlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesExecuteSqlRequest, SqlInstancesExecuteSqlResponse>
      executeSqlCallable() {
    return stub.executeSqlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAcquireSsrsLeaseRequest request =
   *       SqlInstancesAcquireSsrsLeaseRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesAcquireSsrsLeaseRequest.newBuilder().build())
   *           .build();
   *   SqlInstancesAcquireSsrsLeaseResponse response =
   *       sqlInstancesServiceClient.acquireSsrsLease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesAcquireSsrsLeaseResponse acquireSsrsLease(
      SqlInstancesAcquireSsrsLeaseRequest request) {
    return acquireSsrsLeaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesAcquireSsrsLeaseRequest request =
   *       SqlInstancesAcquireSsrsLeaseRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesAcquireSsrsLeaseRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<SqlInstancesAcquireSsrsLeaseResponse> future =
   *       sqlInstancesServiceClient.acquireSsrsLeaseCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesAcquireSsrsLeaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesAcquireSsrsLeaseRequest, SqlInstancesAcquireSsrsLeaseResponse>
      acquireSsrsLeaseCallable() {
    return stub.acquireSsrsLeaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Release a lease for the setup of SQL Server Reporting Services (SSRS).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesReleaseSsrsLeaseRequest request =
   *       SqlInstancesReleaseSsrsLeaseRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   SqlInstancesReleaseSsrsLeaseResponse response =
   *       sqlInstancesServiceClient.releaseSsrsLease(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SqlInstancesReleaseSsrsLeaseResponse releaseSsrsLease(
      SqlInstancesReleaseSsrsLeaseRequest request) {
    return releaseSsrsLeaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Release a lease for the setup of SQL Server Reporting Services (SSRS).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesReleaseSsrsLeaseRequest request =
   *       SqlInstancesReleaseSsrsLeaseRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<SqlInstancesReleaseSsrsLeaseResponse> future =
   *       sqlInstancesServiceClient.releaseSsrsLeaseCallable().futureCall(request);
   *   // Do something.
   *   SqlInstancesReleaseSsrsLeaseResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SqlInstancesReleaseSsrsLeaseRequest, SqlInstancesReleaseSsrsLeaseResponse>
      releaseSsrsLeaseCallable() {
    return stub.releaseSsrsLeaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute MVU Pre-checks
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPreCheckMajorVersionUpgradeRequest request =
   *       SqlInstancesPreCheckMajorVersionUpgradeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesPreCheckMajorVersionUpgradeRequest.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.preCheckMajorVersionUpgrade(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation preCheckMajorVersionUpgrade(
      SqlInstancesPreCheckMajorVersionUpgradeRequest request) {
    return preCheckMajorVersionUpgradeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Execute MVU Pre-checks
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPreCheckMajorVersionUpgradeRequest request =
   *       SqlInstancesPreCheckMajorVersionUpgradeRequest.newBuilder()
   *           .setInstance("instance555127957")
   *           .setProject("project-309310695")
   *           .setBody(InstancesPreCheckMajorVersionUpgradeRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.preCheckMajorVersionUpgradeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesPreCheckMajorVersionUpgradeRequest, Operation>
      preCheckMajorVersionUpgradeCallable() {
    return stub.preCheckMajorVersionUpgradeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Point in time restore for an instance managed by Google Cloud Backup and Disaster Recovery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPointInTimeRestoreRequest request =
   *       SqlInstancesPointInTimeRestoreRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setContext(PointInTimeRestoreContext.newBuilder().build())
   *           .build();
   *   Operation response = sqlInstancesServiceClient.pointInTimeRestore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation pointInTimeRestore(SqlInstancesPointInTimeRestoreRequest request) {
    return pointInTimeRestoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Point in time restore for an instance managed by Google Cloud Backup and Disaster Recovery.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SqlInstancesServiceClient sqlInstancesServiceClient = SqlInstancesServiceClient.create()) {
   *   SqlInstancesPointInTimeRestoreRequest request =
   *       SqlInstancesPointInTimeRestoreRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setContext(PointInTimeRestoreContext.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       sqlInstancesServiceClient.pointInTimeRestoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SqlInstancesPointInTimeRestoreRequest, Operation>
      pointInTimeRestoreCallable() {
    return stub.pointInTimeRestoreCallable();
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
}
