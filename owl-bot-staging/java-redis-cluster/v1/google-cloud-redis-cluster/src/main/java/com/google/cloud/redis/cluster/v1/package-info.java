/*
 * Copyright 2023 Google LLC
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
 * A client to Google Cloud Memorystore for Redis API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudRedisClusterClient =======================
 *
 * <p>Service Description: Configures and manages Cloud Memorystore for Redis clusters
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
 * <p>We use API version selector for Flex APIs
 *
 * <ul>
 *   <li>The versioning strategy is release-based versioning
 *   <li>Our backend CLH only deals with the superset version (called v1main)
 *   <li>Existing backend for Redis Gen1 and MRR is not touched.
 *   <li>More details in go/redis-flex-api-versioning
 * </ul>
 *
 * <p>Sample for CloudRedisClusterClient:
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
 */
@Generated("by gapic-generator-java")
package com.google.cloud.redis.cluster.v1;

import javax.annotation.Generated;
