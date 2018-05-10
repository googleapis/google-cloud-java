/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Cloud Bigtable Admin API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=========================== BigtableInstanceAdminClient ===========================
 *
 * <p>Service Description: Service for creating, configuring, and deleting Cloud Bigtable Instances
 * and Clusters. Provides access to the Instance and Cluster schemas only, not the tables' metadata
 * or data stored in those tables.
 *
 * <p>Sample for BigtableInstanceAdminClient:
 *
 * <pre>
 * <code>
 * try (BigtableInstanceAdminClient bigtableInstanceAdminClient = BigtableInstanceAdminClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
 *   Instance response = bigtableInstanceAdminClient.getInstance(name);
 * }
 * </code>
 * </pre>
 *
 * ======================== BigtableTableAdminClient ========================
 *
 * <p>Service Description: Service for creating, configuring, and deleting Cloud Bigtable tables.
 *
 * <p>Provides access to the table schemas only, not the data stored within the tables.
 *
 * <p>Sample for BigtableTableAdminClient:
 *
 * <pre>
 * <code>
 * try (BigtableTableAdminClient bigtableTableAdminClient = BigtableTableAdminClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
 *   String tableId = "";
 *   Table table = Table.newBuilder().build();
 *   Table response = bigtableTableAdminClient.createTable(parent, tableId, table);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.bigtable.admin.v2;
