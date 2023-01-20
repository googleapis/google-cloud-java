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
 * <p>======================= ProfilerServiceClient =======================
 *
 * <p>Service Description: Manage the collection of continuous profiling data provided by profiling
 * agents running in the cloud or by an offline provider of profiling data.
 *
 * <p>General guidelines:
 *
 * <ul>
 *   <li>Profiles for a single deployment must be created in ascending time order.
 *   <li>Profiles can be created in either online or offline mode, see below.
 * </ul>
 *
 * <p>Sample for ProfilerServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProfilerServiceClient profilerServiceClient = ProfilerServiceClient.create()) {
 *   CreateProfileRequest request =
 *       CreateProfileRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setDeployment(Deployment.newBuilder().build())
 *           .addAllProfileType(new ArrayList<ProfileType>())
 *           .build();
 *   Profile response = profilerServiceClient.createProfile(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.devtools.cloudprofiler.v2;

import javax.annotation.Generated;
