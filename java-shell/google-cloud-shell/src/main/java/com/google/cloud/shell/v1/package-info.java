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
 * <p>======================= CloudShellServiceClient =======================
 *
 * <p>Service Description: API for interacting with Google Cloud Shell. Each user of Cloud Shell has
 * at least one environment, which has the ID "default". Environment consists of a Docker image
 * defining what is installed on the environment and a home directory containing the user's data
 * that will remain across sessions. Clients use this API to start and fetch information about their
 * environment, which can then be used to connect to that environment via a separate SSH client.
 *
 * <p>Sample for CloudShellServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
 *   EnvironmentName name = EnvironmentName.of("[USER]", "[ENVIRONMENT]");
 *   Environment response = cloudShellServiceClient.getEnvironment(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.shell.v1;

import javax.annotation.Generated;
