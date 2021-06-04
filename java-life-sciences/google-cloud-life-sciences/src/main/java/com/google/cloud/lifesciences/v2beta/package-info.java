/*
 * Copyright 2021 Google LLC
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
 * <p>======================= WorkflowsServiceV2BetaClient =======================
 *
 * <p>Service Description: A service for running workflows, such as pipelines consisting of Docker
 * containers.
 *
 * <p>Sample for WorkflowsServiceV2BetaClient:
 *
 * <pre>{@code
 * try (WorkflowsServiceV2BetaClient workflowsServiceV2BetaClient =
 *     WorkflowsServiceV2BetaClient.create()) {
 *   RunPipelineRequest request =
 *       RunPipelineRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setPipeline(Pipeline.newBuilder().build())
 *           .putAllLabels(new HashMap<String, String>())
 *           .setPubSubTopic("pubSubTopic320524524")
 *           .build();
 *   RunPipelineResponse response = workflowsServiceV2BetaClient.runPipelineAsync(request).get();
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.lifesciences.v2beta;

import javax.annotation.Generated;
