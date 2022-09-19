/*
 * Copyright 2022 Google LLC
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
 * A client to Dataproc Metastore API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DataprocMetastoreClient =======================
 *
 * <p>Service Description: Configures and manages metastore services. Metastore services are fully
 * managed, highly available, autoscaled, autohealing, OSS-native deployments of technical metadata
 * management software. Each metastore service exposes a network endpoint through which metadata
 * queries are served. Metadata queries can originate from a variety of sources, including Apache
 * Hive, Apache Presto, and Apache Spark.
 *
 * <p>The Dataproc Metastore API defines the following resource model:
 *
 * <ul>
 *   <li>The service works with a collection of Google Cloud projects, named: `/projects/&#42;`
 *   <li>Each project has a collection of available locations, named: `/locations/&#42;` (a location
 *       must refer to a Google Cloud `region`)
 *   <li>Each location has a collection of services, named: `/services/&#42;`
 *   <li>Dataproc Metastore services are resources with names of the form:
 * </ul>
 *
 * <p>`/projects/{project_number}/locations/{location_id}/services/{service_id}`.
 *
 * <p>Sample for DataprocMetastoreClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataprocMetastoreClient dataprocMetastoreClient = DataprocMetastoreClient.create()) {
 *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
 *   Service response = dataprocMetastoreClient.getService(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.metastore.v1alpha;

import javax.annotation.Generated;
