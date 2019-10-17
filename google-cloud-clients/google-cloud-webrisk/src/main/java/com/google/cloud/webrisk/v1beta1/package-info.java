/*
 * Copyright 2019 Google LLC
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
 * A client to Web Risk API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=========================== WebRiskServiceV1Beta1Client ===========================
 *
 * <p>Service Description: Web Risk v1beta1 API defines an interface to detect malicious URLs on
 * your website and in client applications.
 *
 * <p>Sample for WebRiskServiceV1Beta1Client:
 *
 * <pre>
 * <code>
 * try (WebRiskServiceV1Beta1Client webRiskServiceV1Beta1Client = WebRiskServiceV1Beta1Client.create()) {
 *   ThreatType threatType = ThreatType.THREAT_TYPE_UNSPECIFIED;
 *   ByteString versionToken = ByteString.copyFromUtf8("");
 *   ComputeThreatListDiffRequest.Constraints constraints = ComputeThreatListDiffRequest.Constraints.newBuilder().build();
 *   ComputeThreatListDiffResponse response = webRiskServiceV1Beta1Client.computeThreatListDiff(threatType, versionToken, constraints);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.webrisk.v1beta1;

import javax.annotation.Generated;
