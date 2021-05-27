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
 * <p>======================= BinauthzManagementServiceV1Beta1Client =======================
 *
 * <p>Service Description: Google Cloud Management Service for Binary Authorization admission
 * policies and attestation authorities.
 *
 * <p>This API implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[Policy][google.cloud.binaryauthorization.v1beta1.Policy]
 *   <li>[Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
 * </ul>
 *
 * <p>Sample for BinauthzManagementServiceV1Beta1Client:
 *
 * <pre>{@code
 * try (BinauthzManagementServiceV1Beta1Client binauthzManagementServiceV1Beta1Client =
 *     BinauthzManagementServiceV1Beta1Client.create()) {
 *   PolicyName name = PolicyName.of("[PROJECT]");
 *   Policy response = binauthzManagementServiceV1Beta1Client.getPolicy(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.binaryauthorization.v1beta1;

import javax.annotation.Generated;
