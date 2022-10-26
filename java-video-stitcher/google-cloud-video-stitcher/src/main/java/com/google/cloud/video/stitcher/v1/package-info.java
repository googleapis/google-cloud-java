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
 * A client to Video Stitcher API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= VideoStitcherServiceClient =======================
 *
 * <p>Service Description: Video-On-Demand content stitching API allows you to insert ads into (VoD)
 * video on demand files. You will be able to render custom scrubber bars with highlighted ads,
 * enforce ad policies, allow seamless playback and tracking on native players and monetize content
 * with any standard VMAP compliant ad server.
 *
 * <p>Sample for VideoStitcherServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VideoStitcherServiceClient videoStitcherServiceClient =
 *     VideoStitcherServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   CdnKey cdnKey = CdnKey.newBuilder().build();
 *   String cdnKeyId = "cdnKeyId-1777782867";
 *   CdnKey response = videoStitcherServiceClient.createCdnKey(parent, cdnKey, cdnKeyId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.video.stitcher.v1;

import javax.annotation.Generated;
