/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client for Cloud Bigtable.
 *
 * <h2>Concepts
 *
 * <p>Conceptually Cloud Bigtable is composed of instances, clusters nodes and Tables.
 *
 * <dl>
 *   <dt>Instances
 *   <dd>Instances are mostly containers for your clusters, nodes and tables, which do all of the
 *       real work.
 *   <dt>Clusters
 *   <dd>Clusters represent the actual Cloud Bigtable service. Each cluster belongs to a single
 *       Cloud Bigtable instance, and an instance can have up to 4 clusters. When your application
 *       sends requests to a Cloud Bigtable instance, those requests are actually handled by one of
 *       the clusters in the instance.
 *   <dt>Nodes
 *   <dd>Each cluster in a production instance has 3 or more nodes, which are compute resources that
 *       Cloud Bigtable uses to manage your data.
 *   <dt>Tables
 *   <dd>Tables contain the actual data and are replicated across all of the clusters in an
 *       instance.
 * </dl>
 *
 * <h2>Clients</h2>
 *
 * <p>The Cloud Bigtable API consists of 2 parts:
 *
 * <dl>
 *   <dt>Data API
 *   <dd>Allows callers to persist and query data in a table. It's exposed by {@link
 *       com.google.cloud.bigtable.data.v2.BigtableDataClient}.
 *   <dt>Admin API
 *   <dd>Allows callers to create and manage Instances, Clusters, etc. This api is exposed by:
 *       <ul>
 *         <li>{@link com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient} for Instance
 *             and Cluster level resources.
 *         <li>{@link com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient} for table
 *             management
 *       </ul>
 * </dl>
 *
 * @see com.google.cloud.bigtable.data.v2.BigtableDataClient For the data client.
 * @see com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings For the instance admin
 *     client.
 * @see com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient For the table admin client.
 */
package com.google.cloud.bigtable;
