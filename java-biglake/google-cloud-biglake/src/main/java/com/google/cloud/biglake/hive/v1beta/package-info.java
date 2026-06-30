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
 * A client to BigLake API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= HiveMetastoreServiceClient =======================
 *
 * <p>Service Description: Hive Metastore Service is a biglake service that allows users to manage
 * their external Hive catalogs. Full API compatibility with OSS Hive Metastore APIs is not
 * supported. The methods match the Hive Metastore API spec mostly except for a few exceptions.
 * These include listing resources with pattern, environment context which are combined in a single
 * List API, return of ListResponse object instead of a list of resources, transactions, locks, etc.
 *
 * <p>The BigLake Hive Metastore API defines the following resources:
 *
 * <ul>
 *   <li>A collection of Google Cloud projects: `/projects/&#42;`
 *   <li>Each project has a collection of catalogs: `/catalogs/&#42;`
 *   <li>Each catalog has a collection of databases: `/databases/&#42;`
 *   <li>Each database has a collection of tables: `/tables/&#42;`
 * </ul>
 *
 * <p>Sample for HiveMetastoreServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
 *     HiveMetastoreServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
 *   String hiveCatalogId = "hiveCatalogId-575314556";
 *   HiveCatalog response =
 *       hiveMetastoreServiceClient.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.biglake.hive.v1beta;

import javax.annotation.Generated;
