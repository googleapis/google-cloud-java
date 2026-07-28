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

/**
 * A client to Cloud SQL Admin API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SqlBackupRunsServiceClient =======================
 *
 * <p>Service Description: Service for managing database backups.
 *
 * <p>Sample for SqlBackupRunsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlBackupRunsServiceClient sqlBackupRunsServiceClient =
 *     SqlBackupRunsServiceClient.create()) {
 *   SqlBackupRunsDeleteRequest request =
 *       SqlBackupRunsDeleteRequest.newBuilder()
 *           .setId(3355)
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlBackupRunsServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlBackupsServiceClient =======================
 *
 * <p>Sample for SqlBackupsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlBackupsServiceClient sqlBackupsServiceClient = SqlBackupsServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Backup backup = Backup.newBuilder().build();
 *   Operation response = sqlBackupsServiceClient.createBackup(parent, backup);
 * }
 * }</pre>
 *
 * <p>======================= SqlConnectServiceClient =======================
 *
 * <p>Service Description: Cloud SQL connect service.
 *
 * <p>Sample for SqlConnectServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlConnectServiceClient sqlConnectServiceClient = SqlConnectServiceClient.create()) {
 *   GetConnectSettingsRequest request =
 *       GetConnectSettingsRequest.newBuilder()
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .setReadTime(Timestamp.newBuilder().build())
 *           .build();
 *   ConnectSettings response = sqlConnectServiceClient.getConnectSettings(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlDatabasesServiceClient =======================
 *
 * <p>Service Description: Service to manage databases.
 *
 * <p>Sample for SqlDatabasesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
 *   SqlDatabasesDeleteRequest request =
 *       SqlDatabasesDeleteRequest.newBuilder()
 *           .setDatabase("database1789464955")
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlDatabasesServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlFlagsServiceClient =======================
 *
 * <p>Service Description: Service to manage database flags for Cloud SQL instances.
 *
 * <p>Sample for SqlFlagsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlFlagsServiceClient sqlFlagsServiceClient = SqlFlagsServiceClient.create()) {
 *   SqlFlagsListRequest request =
 *       SqlFlagsListRequest.newBuilder()
 *           .setDatabaseVersion("databaseVersion1250955997")
 *           .setFlagScope(SqlFlagScope.forNumber(0))
 *           .build();
 *   FlagsListResponse response = sqlFlagsServiceClient.list(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlInstancesServiceClient =======================
 *
 * <p>Sample for SqlInstancesServiceClient:
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
 * <p>======================= SqlOperationsServiceClient =======================
 *
 * <p>Service Description: Service to fetch operations for database instances.
 *
 * <p>Sample for SqlOperationsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlOperationsServiceClient sqlOperationsServiceClient =
 *     SqlOperationsServiceClient.create()) {
 *   SqlOperationsGetRequest request =
 *       SqlOperationsGetRequest.newBuilder()
 *           .setOperation("operation1662702951")
 *           .setProject("project-309310695")
 *           .setLocation("location1901043637")
 *           .build();
 *   Operation response = sqlOperationsServiceClient.get(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlSslCertsServiceClient =======================
 *
 * <p>Service Description: Service to manage SSL certs for Cloud SQL instances.
 *
 * <p>Sample for SqlSslCertsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlSslCertsServiceClient sqlSslCertsServiceClient = SqlSslCertsServiceClient.create()) {
 *   SqlSslCertsDeleteRequest request =
 *       SqlSslCertsDeleteRequest.newBuilder()
 *           .setInstance("instance555127957")
 *           .setProject("project-309310695")
 *           .setSha1Fingerprint("sha1Fingerprint163009183")
 *           .build();
 *   Operation response = sqlSslCertsServiceClient.delete(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlTiersServiceClient =======================
 *
 * <p>Service Description: Service for providing machine types (tiers) for Cloud SQL instances.
 *
 * <p>Sample for SqlTiersServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlTiersServiceClient sqlTiersServiceClient = SqlTiersServiceClient.create()) {
 *   SqlTiersListRequest request =
 *       SqlTiersListRequest.newBuilder().setProject("project-309310695").build();
 *   TiersListResponse response = sqlTiersServiceClient.list(request);
 * }
 * }</pre>
 *
 * <p>======================= SqlUsersServiceClient =======================
 *
 * <p>Service Description: Cloud SQL users service.
 *
 * <p>Sample for SqlUsersServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
 *   SqlUsersDeleteRequest request =
 *       SqlUsersDeleteRequest.newBuilder()
 *           .setHost("host3208616")
 *           .setInstance("instance555127957")
 *           .setName("name3373707")
 *           .setProject("project-309310695")
 *           .build();
 *   Operation response = sqlUsersServiceClient.delete(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.sql.v1;

import javax.annotation.Generated;
