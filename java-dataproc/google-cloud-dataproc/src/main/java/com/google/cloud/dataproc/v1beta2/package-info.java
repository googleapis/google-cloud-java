/*
 * Copyright 2020 Google LLC
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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AutoscalingPolicyServiceClient =======================
 *
 * <p>Service Description: The API interface for managing autoscaling policies in the Cloud Dataproc
 * API.
 *
 * <p>Sample for AutoscalingPolicyServiceClient:
 *
 * <pre>{@code
 * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
 *   AutoscalingPolicy response =
 *       autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, policy);
 * }
 * }</pre>
 *
 * <p>======================= ClusterControllerClient =======================
 *
 * <p>Service Description: The ClusterControllerService provides methods to manage clusters of
 * Compute Engine instances.
 *
 * <p>Sample for ClusterControllerClient:
 *
 * <pre>{@code
 * try (ClusterControllerClient clusterControllerClient = ClusterControllerClient.create()) {
 *   String projectId = "projectId-894832108";
 *   String region = "region-934795532";
 *   String clusterName = "clusterName-1141738587";
 *   Cluster response = clusterControllerClient.getCluster(projectId, region, clusterName);
 * }
 * }</pre>
 *
 * <p>======================= JobControllerClient =======================
 *
 * <p>Service Description: The JobController provides methods to manage jobs.
 *
 * <p>Sample for JobControllerClient:
 *
 * <pre>{@code
 * try (JobControllerClient jobControllerClient = JobControllerClient.create()) {
 *   String projectId = "projectId-894832108";
 *   String region = "region-934795532";
 *   Job job = Job.newBuilder().build();
 *   Job response = jobControllerClient.submitJob(projectId, region, job);
 * }
 * }</pre>
 *
 * <p>======================= WorkflowTemplateServiceClient =======================
 *
 * <p>Service Description: The API interface for managing Workflow Templates in the Dataproc API.
 *
 * <p>Sample for WorkflowTemplateServiceClient:
 *
 * <pre>{@code
 * try (WorkflowTemplateServiceClient workflowTemplateServiceClient =
 *     WorkflowTemplateServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   WorkflowTemplate template = WorkflowTemplate.newBuilder().build();
 *   WorkflowTemplate response =
 *       workflowTemplateServiceClient.createWorkflowTemplate(parent, template);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.dataproc.v1beta2;

import javax.annotation.Generated;
