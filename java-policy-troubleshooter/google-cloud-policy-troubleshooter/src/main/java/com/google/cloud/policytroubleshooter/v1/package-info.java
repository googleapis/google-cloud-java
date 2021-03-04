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
 * <p>======================= IamCheckerClient =======================
 *
 * <p>Service Description: IAM Policy Troubleshooter service.
 *
 * <p>This service helps you troubleshoot access issues for Google Cloud resources.
 *
 * <p>Sample for IamCheckerClient:
 *
 * <pre>{@code
 * try (IamCheckerClient iamCheckerClient = IamCheckerClient.create()) {
 *   TroubleshootIamPolicyRequest request = TroubleshootIamPolicyRequest.newBuilder().build();
 *   TroubleshootIamPolicyResponse response = iamCheckerClient.troubleshootIamPolicy(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.policytroubleshooter.v1;

import javax.annotation.Generated;
