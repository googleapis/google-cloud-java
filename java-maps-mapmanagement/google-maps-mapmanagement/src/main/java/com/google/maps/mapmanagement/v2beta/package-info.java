/*
 * Copyright 2026 Google LLC
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
 * A client to Map Management API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= MapManagementClient =======================
 *
 * <p>Service Description: The Map Management API uses your inputs to create and manage Google Cloud
 * based styling resources for Google Maps.
 *
 * <p>Using this API, you can can create and manage MapConfigs (Map IDs), StyleConfigs (JSON-based
 * styling), and MapContextConfigs (associations between styles, datasets, and map variants).
 *
 * <p>This API offers features through three channels:
 *
 * <ul>
 *   <li>`v2alpha`: Experimental features.
 *   <li>`v2beta`: Preview features, recommended for early adoption.
 *   <li>`v2`: General Availability (GA) features.
 * </ul>
 *
 * <p>Capabilities described here are generally available across both the v2alpha and v2beta
 * endpoints.
 *
 * <p>Sample for MapManagementClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MapManagementClient mapManagementClient = MapManagementClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   MapConfig mapConfig = MapConfig.newBuilder().build();
 *   MapConfig response = mapManagementClient.createMapConfig(parent, mapConfig);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.maps.mapmanagement.v2beta;

import javax.annotation.Generated;
