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
 * A client to Cloud Run Admin API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= RevisionsClient =======================
 *
 * <p>Service Description: Cloud Run Revision Control Plane API.
 *
 * <p>Sample for RevisionsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (RevisionsClient revisionsClient = RevisionsClient.create()) {
 *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[SERVICE]", "[REVISION]");
 *   Revision response = revisionsClient.getRevision(name);
 * }
 * }</pre>
 *
 * <p>======================= ServicesClient =======================
 *
 * <p>Service Description: Cloud Run Service Control Plane API
 *
 * <p>Sample for ServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (ServicesClient servicesClient = ServicesClient.create()) {
 *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
 *   Service response = servicesClient.getService(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.run.v2;

import javax.annotation.Generated;
