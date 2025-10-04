/*
 * Copyright 2025 Google LLC
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
 * A client to Config Delivery API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ConfigDeliveryClient =======================
 *
 * <p>Service Description: ConfigDelivery service manages the deployment of kubernetes configuration
 * to a fleet of kubernetes clusters.
 *
 * <p>Sample for ConfigDeliveryClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
 *   ResourceBundleName name =
 *       ResourceBundleName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]");
 *   ResourceBundle response = configDeliveryClient.getResourceBundle(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.configdelivery.v1beta;

import javax.annotation.Generated;
