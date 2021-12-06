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
 * A client to Google Cloud Deploy API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudDeployClient =======================
 *
 * <p>Service Description: CloudDeploy service creates and manages Continuous Delivery operations on
 * Google Cloud Platform via Skaffold (https://skaffold.dev).
 *
 * <p>Sample for CloudDeployClient:
 *
 * <pre>{@code
 * try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
 *   DeliveryPipelineName name =
 *       DeliveryPipelineName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]");
 *   DeliveryPipeline response = cloudDeployClient.getDeliveryPipeline(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.deploy.v1;

import javax.annotation.Generated;
