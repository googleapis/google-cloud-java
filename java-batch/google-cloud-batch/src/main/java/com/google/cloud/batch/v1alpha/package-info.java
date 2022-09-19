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
 * A client to Batch API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= BatchServiceClient =======================
 *
 * <p>Service Description: Google Batch Service. The service manages user submitted batch jobs and
 * allocates Google Compute Engine VM instances to run the jobs.
 *
 * <p>Sample for BatchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BatchServiceClient batchServiceClient = BatchServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Job job = Job.newBuilder().build();
 *   String jobId = "jobId101296568";
 *   Job response = batchServiceClient.createJob(parent, job, jobId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.batch.v1alpha;

import javax.annotation.Generated;
