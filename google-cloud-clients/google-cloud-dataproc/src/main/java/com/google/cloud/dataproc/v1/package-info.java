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
 * A client to Google Cloud Dataproc API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ClusterControllerClient =======================
 *
 * <p>Service Description: The ClusterControllerService provides methods to manage clusters of
 * Compute Engine instances.
 *
 * <p>Sample for ClusterControllerClient:
 *
 * <pre>
 * <code>
 * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
 *   String projectId = "";
 *   String region = "";
 *   String clusterName = "";
 *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
 * }
 * </code>
 * </pre>
 *
 * =================== JobControllerClient ===================
 *
 * <p>Service Description: The JobController provides methods to manage jobs.
 *
 * <p>Sample for JobControllerClient:
 *
 * <pre>
 * <code>
 * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
 *   String projectId = "";
 *   String region = "";
 *   Job job = Job.newBuilder().build();
 *   Job response = jobControllerClient.submitJob(projectId, region, job);
 * }
 * </code>
 * </pre>
 *
 * ============================= WorkflowTemplateServiceClient =============================
 *
 * <p>Service Description: The API interface for managing Workflow Templates in the Cloud Dataproc
 * API.
 *
 * <p>Sample for WorkflowTemplateServiceClient:
 *
 * <pre>
 * <code>
 * try (WorkflowTemplateServiceClient workflowTemplateServiceClient = WorkflowTemplateServiceClient.create()) {
 *   RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
 *   WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
 *   WorkflowTemplate response = workflowTemplateServiceClient.createWorkflowTemplate(parent, template);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.dataproc.v1;
