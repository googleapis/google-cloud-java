/*
 * Copyright 2020 Google LLC
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
 * A client to Cloud Video Intelligence API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>============================== VideoIntelligenceServiceClient ==============================
 *
 * <p>Service Description: Service that implements the Video Intelligence API.
 *
 * <p>Sample for VideoIntelligenceServiceClient:
 *
 * <pre>
 * <code>
 * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient = VideoIntelligenceServiceClient.create()) {
 *   String inputUri = "gs://cloud-samples-data/video/cat.mp4";
 *   Feature featuresElement = Feature.LABEL_DETECTION;
 *   List&lt;Feature&gt; features = Arrays.asList(featuresElement);
 *   AnnotateVideoResponse response = videoIntelligenceServiceClient.annotateVideoAsync(inputUri, features);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.videointelligence.v1;

import javax.annotation.Generated;
