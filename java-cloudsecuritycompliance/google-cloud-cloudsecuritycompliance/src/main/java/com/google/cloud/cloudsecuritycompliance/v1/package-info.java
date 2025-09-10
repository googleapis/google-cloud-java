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
 * A client to Cloud Security Compliance API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ConfigClient =======================
 *
 * <p>Service Description: Service describing handlers for config resources
 *
 * <p>Sample for ConfigClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   FrameworkName name = FrameworkName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK]");
 *   Framework response = configClient.getFramework(name);
 * }
 * }</pre>
 *
 * <p>======================= DeploymentClient =======================
 *
 * <p>Service Description: Service describing handlers for resources
 *
 * <p>Sample for DeploymentClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DeploymentClient deploymentClient = DeploymentClient.create()) {
 *   FrameworkDeploymentName name =
 *       FrameworkDeploymentName.of("[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]");
 *   FrameworkDeployment response = deploymentClient.getFrameworkDeployment(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.cloudsecuritycompliance.v1;

import javax.annotation.Generated;
