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
 * A client to Dataflow API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= JobsV1Beta3Client =======================
 *
 * <p>Service Description: Provides a method to create and modify Google Cloud Dataflow jobs. A Job
 * is a multi-stage computation graph run by the Cloud Dataflow service.
 *
 * <p>Sample for JobsV1Beta3Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (JobsV1Beta3Client jobsV1Beta3Client = JobsV1Beta3Client.create()) {
 *   CreateJobRequest request =
 *       CreateJobRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJob(Job.newBuilder().build())
 *           .setView(JobView.forNumber(0))
 *           .setReplaceJobId("replaceJobId441554788")
 *           .setLocation("location1901043637")
 *           .build();
 *   Job response = jobsV1Beta3Client.createJob(request);
 * }
 * }</pre>
 *
 * <p>======================= MessagesV1Beta3Client =======================
 *
 * <p>Service Description: The Dataflow Messages API is used for monitoring the progress of Dataflow
 * jobs.
 *
 * <p>Sample for MessagesV1Beta3Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MessagesV1Beta3Client messagesV1Beta3Client = MessagesV1Beta3Client.create()) {
 *   ListJobMessagesRequest request =
 *       ListJobMessagesRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobId("jobId101296568")
 *           .setMinimumImportance(JobMessageImportance.forNumber(0))
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setStartTime(Timestamp.newBuilder().build())
 *           .setEndTime(Timestamp.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   for (JobMessage element : messagesV1Beta3Client.listJobMessages(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= MetricsV1Beta3Client =======================
 *
 * <p>Service Description: The Dataflow Metrics API lets you monitor the progress of Dataflow jobs.
 *
 * <p>Sample for MetricsV1Beta3Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MetricsV1Beta3Client metricsV1Beta3Client = MetricsV1Beta3Client.create()) {
 *   GetJobMetricsRequest request =
 *       GetJobMetricsRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobId("jobId101296568")
 *           .setStartTime(Timestamp.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   JobMetrics response = metricsV1Beta3Client.getJobMetrics(request);
 * }
 * }</pre>
 *
 * <p>======================= SnapshotsV1Beta3Client =======================
 *
 * <p>Service Description: Provides methods to manage snapshots of Google Cloud Dataflow jobs.
 *
 * <p>Sample for SnapshotsV1Beta3Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
 *   GetSnapshotRequest request =
 *       GetSnapshotRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setSnapshotId("snapshotId-1113817601")
 *           .setLocation("location1901043637")
 *           .build();
 *   Snapshot response = snapshotsV1Beta3Client.getSnapshot(request);
 * }
 * }</pre>
 *
 * <p>======================= TemplatesServiceClient =======================
 *
 * <p>Service Description: Provides a method to create Cloud Dataflow jobs from templates.
 *
 * <p>Sample for TemplatesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
 *   CreateJobFromTemplateRequest request =
 *       CreateJobFromTemplateRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobName("jobName-1438096408")
 *           .putAllParameters(new HashMap<String, String>())
 *           .setEnvironment(RuntimeEnvironment.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   Job response = templatesServiceClient.createJobFromTemplate(request);
 * }
 * }</pre>
 *
 * <p>======================= FlexTemplatesServiceClient =======================
 *
 * <p>Service Description: Provides a service for Flex templates. This feature is not ready yet.
 *
 * <p>Sample for FlexTemplatesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FlexTemplatesServiceClient flexTemplatesServiceClient =
 *     FlexTemplatesServiceClient.create()) {
 *   LaunchFlexTemplateRequest request =
 *       LaunchFlexTemplateRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setLaunchParameter(LaunchFlexTemplateParameter.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .setValidateOnly(true)
 *           .build();
 *   LaunchFlexTemplateResponse response = flexTemplatesServiceClient.launchFlexTemplate(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.dataflow.v1beta3;

import javax.annotation.Generated;
