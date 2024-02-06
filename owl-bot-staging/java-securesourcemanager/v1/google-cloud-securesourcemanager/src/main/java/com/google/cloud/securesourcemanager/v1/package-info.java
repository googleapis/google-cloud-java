/*
 * Copyright 2023 Google LLC
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
 * A client to Secure Source Manager API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SecureSourceManagerClient =======================
 *
 * <p>Service Description: Secure Source Manager API
 *
 * <p>Access Secure Source Manager instances, resources, and repositories.
 *
 * <p>This API is split across two servers: the Control Plane and the Data Plane.
 *
 * <p>Data Plane endpoints are hosted directly by your Secure Source Manager instance, so you must
 * connect to your instance's API hostname to access them. The API hostname looks like the
 * following:
 *
 * <p>https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
 *
 * <p>For example,
 *
 * <p>https://my-instance-702770452863-api.us-central1.sourcemanager.dev
 *
 * <p>Data Plane endpoints are denoted with &#42;&#42;Host: Data Plane&#42;&#42;.
 *
 * <p>All other endpoints are found in the normal Cloud API location, namely,
 * `securcesourcemanager.googleapis.com`.
 *
 * <p>Sample for SecureSourceManagerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SecureSourceManagerClient secureSourceManagerClient = SecureSourceManagerClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = secureSourceManagerClient.getInstance(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.securesourcemanager.v1;

import javax.annotation.Generated;
