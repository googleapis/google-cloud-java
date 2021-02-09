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
 * <p>======================= DataLabelingServiceClient =======================
 *
 * <p>Service Description: Service for the AI Platform Data Labeling API.
 *
 * <p>Sample for DataLabelingServiceClient:
 *
 * <pre>{@code
 * try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Dataset dataset = Dataset.newBuilder().build();
 *   Dataset response = dataLabelingServiceClient.createDataset(parent, dataset);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.datalabeling.v1beta1;

import javax.annotation.Generated;
