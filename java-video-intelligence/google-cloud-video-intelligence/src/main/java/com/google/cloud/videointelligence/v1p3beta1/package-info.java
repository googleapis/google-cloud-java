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
 * <p>======================= VideoIntelligenceServiceClient =======================
 *
 * <p>Service Description: Service that implements the Video Intelligence API.
 *
 * <p>Sample for VideoIntelligenceServiceClient:
 *
 * <pre>{@code
 * try (VideoIntelligenceServiceClient videoIntelligenceServiceClient =
 *     VideoIntelligenceServiceClient.create()) {
 *   String inputUri = "inputUri470706498";
 *   List<Feature> features = new ArrayList<>();
 *   AnnotateVideoResponse response =
 *       videoIntelligenceServiceClient.annotateVideoAsync(inputUri, features).get();
 * }
 * }</pre>
 *
 * <p>======================= StreamingVideoIntelligenceServiceClient =======================
 *
 * <p>Service Description: Service that implements streaming Video Intelligence API.
 *
 * <p>Sample for StreamingVideoIntelligenceServiceClient:
 *
 * <pre>{@code
 * try (StreamingVideoIntelligenceServiceClient streamingVideoIntelligenceServiceClient =
 *     StreamingVideoIntelligenceServiceClient.create()) {
 *   BidiStream<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse> bidiStream =
 *       streamingVideoIntelligenceServiceClient.streamingAnnotateVideoCallable().call();
 *   StreamingAnnotateVideoRequest request = StreamingAnnotateVideoRequest.newBuilder().build();
 *   bidiStream.send(request);
 *   for (StreamingAnnotateVideoResponse response : bidiStream) {
 *     // Do something when a response is received.
 *   }
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.videointelligence.v1p3beta1;

import javax.annotation.Generated;
