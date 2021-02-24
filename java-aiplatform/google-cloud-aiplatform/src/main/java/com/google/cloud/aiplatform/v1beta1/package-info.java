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
 * <p>======================= DatasetServiceClient =======================
 *
 * <p>Sample for DatasetServiceClient:
 *
 * <pre>{@code
 * try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create()) {
 *   DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[DATASET]");
 *   Dataset response = datasetServiceClient.getDataset(name);
 * }
 * }</pre>
 *
 * <p>======================= EndpointServiceClient =======================
 *
 * <p>Sample for EndpointServiceClient:
 *
 * <pre>{@code
 * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
 *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   Endpoint response = endpointServiceClient.getEndpoint(name);
 * }
 * }</pre>
 *
 * <p>======================= JobServiceClient =======================
 *
 * <p>Service Description: A service for creating and managing AI Platform's jobs.
 *
 * <p>Sample for JobServiceClient:
 *
 * <pre>{@code
 * try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   CustomJob customJob = CustomJob.newBuilder().build();
 *   CustomJob response = jobServiceClient.createCustomJob(parent, customJob);
 * }
 * }</pre>
 *
 * <p>======================= MigrationServiceClient =======================
 *
 * <p>Service Description: A service that migrates resources from automl.googleapis.com,
 * datalabeling.googleapis.com and ml.googleapis.com to AI Platform.
 *
 * <p>Sample for MigrationServiceClient:
 *
 * <pre>{@code
 * try (MigrationServiceClient migrationServiceClient = MigrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   for (MigratableResource element :
 *       migrationServiceClient.searchMigratableResources(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= ModelServiceClient =======================
 *
 * <p>Service Description: A service for managing AI Platform's machine learning Models.
 *
 * <p>Sample for ModelServiceClient:
 *
 * <pre>{@code
 * try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
 *   Model response = modelServiceClient.getModel(name);
 * }
 * }</pre>
 *
 * <p>======================= PipelineServiceClient =======================
 *
 * <p>Service Description: A service for creating and managing AI Platform's pipelines.
 *
 * <p>Sample for PipelineServiceClient:
 *
 * <pre>{@code
 * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   TrainingPipeline trainingPipeline = TrainingPipeline.newBuilder().build();
 *   TrainingPipeline response =
 *       pipelineServiceClient.createTrainingPipeline(parent, trainingPipeline);
 * }
 * }</pre>
 *
 * <p>======================= PredictionServiceClient =======================
 *
 * <p>Service Description: A service for online predictions and explanations.
 *
 * <p>Sample for PredictionServiceClient:
 *
 * <pre>{@code
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   List<Value> instances = new ArrayList<>();
 *   Value parameters = Value.newBuilder().build();
 *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
 * }
 * }</pre>
 *
 * <p>======================= SpecialistPoolServiceClient =======================
 *
 * <p>Service Description: A service for creating and managing Customer SpecialistPools. When
 * customers start Data Labeling jobs, they can reuse/create Specialist Pools to bring their own
 * Specialists to label the data. Customers can add/remove Managers for the Specialist Pool on Cloud
 * console, then Managers will get email notifications to manage Specialists and tasks on
 * CrowdCompute console.
 *
 * <p>Sample for SpecialistPoolServiceClient:
 *
 * <pre>{@code
 * try (SpecialistPoolServiceClient specialistPoolServiceClient =
 *     SpecialistPoolServiceClient.create()) {
 *   SpecialistPoolName name =
 *       SpecialistPoolName.of("[PROJECT]", "[LOCATION]", "[SPECIALIST_POOL]");
 *   SpecialistPool response = specialistPoolServiceClient.getSpecialistPool(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.aiplatform.v1beta1;

import javax.annotation.Generated;
