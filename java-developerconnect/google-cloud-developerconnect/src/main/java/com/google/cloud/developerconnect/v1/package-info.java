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
 * A client to Developer Connect API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DeveloperConnectClient =======================
 *
 * <p>Service Description: Service describing handlers for resources
 *
 * <p>Sample for DeveloperConnectClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
 *   ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
 *   Connection response = developerConnectClient.getConnection(name);
 * }
 * }</pre>
 *
 * <p>======================= InsightsConfigServiceClient =======================
 *
 * <p>Service Description: Creates and manages InsightsConfigs.
 *
 * <p>The InsightsConfig resource is the core configuration object to capture events from your
 * Software Development Lifecycle. It acts as the central hub for managing how Developer connect
 * understands your application, its runtime environments, and the artifacts deployed within them. A
 * user can create an InsightsConfig, list previously-requested InsightsConfigs or get
 * InsightsConfigs by their ID to determine the status of the InsightsConfig.
 *
 * <p>Sample for InsightsConfigServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InsightsConfigServiceClient insightsConfigServiceClient =
 *     InsightsConfigServiceClient.create()) {
 *   InsightsConfigName name =
 *       InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]");
 *   InsightsConfig response = insightsConfigServiceClient.getInsightsConfig(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.developerconnect.v1;

import javax.annotation.Generated;
