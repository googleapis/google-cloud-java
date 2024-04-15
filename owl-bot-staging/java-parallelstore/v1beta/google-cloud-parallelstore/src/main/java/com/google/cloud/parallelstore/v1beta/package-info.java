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

/**
 * A client to Parallelstore API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ParallelstoreClient =======================
 *
 * <p>Service Description: Service describing handlers for resources Configures and manages
 * parallelstore resources.
 *
 * <p>Parallelstore service.
 *
 * <p>The `parallelstore.googleapis.com` service implements the parallelstore API and defines the
 * following resource model for managing instances:
 *
 * <ul>
 *   <li>The service works with a collection of cloud projects, named: `/projects/&#42;`
 *   <li>Each project has a collection of available locations, named: `/locations/&#42;`
 *   <li>Each location has a collection of instances named `/instances/&#42;`.
 *   <li>Parallelstore instances are resources of the form:
 *       `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 * </ul>
 *
 * <p>Note that location_id must be a Google Cloud `zone`; for example:
 *
 * <ul>
 *   <li>`projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
 * </ul>
 *
 * <p>Sample for ParallelstoreClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ParallelstoreClient parallelstoreClient = ParallelstoreClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = parallelstoreClient.getInstance(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.parallelstore.v1beta;

import javax.annotation.Generated;
