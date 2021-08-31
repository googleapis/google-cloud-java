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
 * <p>======================= DatasetServiceClient =======================
 *
 * <p>Service Description: The service that handles the CRUD of Vertex AI Dataset and its child
 * resources.
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
 * <p>Service Description: A service for managing Vertex AI's Endpoints.
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
 * <p>======================= FeaturestoreOnlineServingServiceClient =======================
 *
 * <p>Service Description: A service for serving online feature values.
 *
 * <p>Sample for FeaturestoreOnlineServingServiceClient:
 *
 * <pre>{@code
 * try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
 *     FeaturestoreOnlineServingServiceClient.create()) {
 *   EntityTypeName entityType =
 *       EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
 *   ReadFeatureValuesResponse response =
 *       featurestoreOnlineServingServiceClient.readFeatureValues(entityType);
 * }
 * }</pre>
 *
 * <p>======================= FeaturestoreServiceClient =======================
 *
 * <p>Service Description: The service that handles CRUD and List for resources for Featurestore.
 *
 * <p>Sample for FeaturestoreServiceClient:
 *
 * <pre>{@code
 * try (FeaturestoreServiceClient featurestoreServiceClient = FeaturestoreServiceClient.create()) {
 *   FeaturestoreName name = FeaturestoreName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]");
 *   Featurestore response = featurestoreServiceClient.getFeaturestore(name);
 * }
 * }</pre>
 *
 * <p>======================= IndexEndpointServiceClient =======================
 *
 * <p>Service Description: A service for managing Vertex AI's IndexEndpoints.
 *
 * <p>Sample for IndexEndpointServiceClient:
 *
 * <pre>{@code
 * try (IndexEndpointServiceClient indexEndpointServiceClient =
 *     IndexEndpointServiceClient.create()) {
 *   IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
 *   IndexEndpoint response = indexEndpointServiceClient.getIndexEndpoint(name);
 * }
 * }</pre>
 *
 * <p>======================= IndexServiceClient =======================
 *
 * <p>Service Description: A service for creating and managing Vertex AI's Index resources.
 *
 * <p>Sample for IndexServiceClient:
 *
 * <pre>{@code
 * try (IndexServiceClient indexServiceClient = IndexServiceClient.create()) {
 *   IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[INDEX]");
 *   Index response = indexServiceClient.getIndex(name);
 * }
 * }</pre>
 *
 * <p>======================= JobServiceClient =======================
 *
 * <p>Service Description: A service for creating and managing Vertex AI's jobs.
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
 * <p>======================= MetadataServiceClient =======================
 *
 * <p>Service Description: Service for reading and writing metadata entries.
 *
 * <p>Sample for MetadataServiceClient:
 *
 * <pre>{@code
 * try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
 *   MetadataStoreName name = MetadataStoreName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]");
 *   MetadataStore response = metadataServiceClient.getMetadataStore(name);
 * }
 * }</pre>
 *
 * <p>======================= MigrationServiceClient =======================
 *
 * <p>Service Description: A service that migrates resources from automl.googleapis.com,
 * datalabeling.googleapis.com and ml.googleapis.com to Vertex AI.
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
 * <p>Service Description: A service for managing Vertex AI's machine learning Models.
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
 * <p>Service Description: A service for creating and managing Vertex AI's pipelines. This includes
 * both `TrainingPipeline` resources (used for AutoML and custom training) and `PipelineJob`
 * resources (used for Vertex Pipelines).
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
 *
 * <p>======================= TensorboardServiceClient =======================
 *
 * <p>Service Description: TensorboardService
 *
 * <p>Sample for TensorboardServiceClient:
 *
 * <pre>{@code
 * try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
 *   TensorboardName name = TensorboardName.of("[PROJECT]", "[LOCATION]", "[TENSORBOARD]");
 *   Tensorboard response = tensorboardServiceClient.getTensorboard(name);
 * }
 * }</pre>
 *
 * <p>======================= VizierServiceClient =======================
 *
 * <p>Service Description: Vertex Vizier API.
 *
 * <p>Vizier service is a GCP service to solve blackbox optimization problems, such as tuning
 * machine learning hyperparameters and searching over deep learning architectures.
 *
 * <p>Sample for VizierServiceClient:
 *
 * <pre>{@code
 * try (VizierServiceClient vizierServiceClient = VizierServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Study study = Study.newBuilder().build();
 *   Study response = vizierServiceClient.createStudy(parent, study);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.aiplatform.v1beta1;

import javax.annotation.Generated;
