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
 * A client to OS Config API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= OsConfigServiceClient =======================
 *
 * <p>Service Description: OS Config API
 *
 * <p>The OS Config service is a server-side component that you can use to manage package
 * installations and patch jobs for virtual machine instances.
 *
 * <p>Sample for OsConfigServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
 *   PatchJobs.ExecutePatchJobRequest request =
 *       PatchJobs.ExecutePatchJobRequest.newBuilder()
 *           .setParent(ProjectName.of("[PROJECT]").toString())
 *           .setDescription("description-1724546052")
 *           .setInstanceFilter(PatchJobs.PatchInstanceFilter.newBuilder().build())
 *           .setPatchConfig(PatchJobs.PatchConfig.newBuilder().build())
 *           .setDuration(Duration.newBuilder().build())
 *           .setDryRun(true)
 *           .setDisplayName("displayName1714148973")
 *           .setRollout(PatchJobs.PatchRollout.newBuilder().build())
 *           .build();
 *   PatchJobs.PatchJob response = osConfigServiceClient.executePatchJob(request);
 * }
 * }</pre>
 *
 * <p>======================= OsConfigZonalServiceClient =======================
 *
 * <p>Service Description: Zonal OS Config API
 *
 * <p>The OS Config service is the server-side component that allows users to manage package
 * installations and patch jobs for Compute Engine VM instances.
 *
 * <p>Sample for OsConfigZonalServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create()) {
 *   OSPolicyAssignmentName name =
 *       OSPolicyAssignmentName.of("[PROJECT]", "[LOCATION]", "[OS_POLICY_ASSIGNMENT]");
 *   OSPolicyAssignment response = osConfigZonalServiceClient.getOSPolicyAssignment(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.osconfig.v1;

import javax.annotation.Generated;
