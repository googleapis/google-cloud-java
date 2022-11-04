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
 * A client to Cloud Run Admin API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ExecutionsClient =======================
 *
 * <p>Service Description: Cloud Run Execution Control Plane API.
 *
 * <p>Sample for ExecutionsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
 *   ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");
 *   Execution response = executionsClient.getExecution(name);
 * }
 * }</pre>
 *
 * <p>======================= JobsClient =======================
 *
 * <p>Service Description: Cloud Run Job Control Plane API.
 *
 * <p>Sample for JobsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (JobsClient jobsClient = JobsClient.create()) {
 *   JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]");
 *   Job response = jobsClient.getJob(name);
 * }
 * }</pre>
 *
 * <p>======================= RevisionsClient =======================
 *
 * <p>Service Description: Cloud Run Revision Control Plane API.
 *
 * <p>Sample for RevisionsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
 *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]");
 *   Revision response = revisionsClient.getRevision(name);
 * }
 * }</pre>
 *
 * <p>======================= ServicesClient =======================
 *
 * <p>Service Description: Cloud Run Service Control Plane API
 *
 * <p>Sample for ServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServicesClient servicesClient = ServicesClient.create()) {
 *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
 *   Service response = servicesClient.getService(name);
 * }
 * }</pre>
 *
 * <p>======================= TasksClient =======================
 *
 * <p>Service Description: Cloud Run Task Control Plane API.
 *
 * <p>Sample for TasksClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TasksClient tasksClient = TasksClient.create()) {
 *   TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]");
 *   Task response = tasksClient.getTask(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.run.v2;

import javax.annotation.Generated;
