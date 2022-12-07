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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= TranscoderServiceClient =======================
 *
 * <p>Service Description: Using the Transcoder API, you can queue asynchronous jobs for transcoding
 * media into various output formats. Output formats may include different streaming standards such
 * as HTTP Live Streaming (HLS) and Dynamic Adaptive Streaming over HTTP (DASH). You can also
 * customize jobs using advanced features such as Digital Rights Management (DRM), audio
 * equalization, content concatenation, and digital ad-stitch ready content generation.
 *
 * <p>Sample for TranscoderServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Job job = Job.newBuilder().build();
 *   Job response = transcoderServiceClient.createJob(parent, job);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.video.transcoder.v1;

import javax.annotation.Generated;
