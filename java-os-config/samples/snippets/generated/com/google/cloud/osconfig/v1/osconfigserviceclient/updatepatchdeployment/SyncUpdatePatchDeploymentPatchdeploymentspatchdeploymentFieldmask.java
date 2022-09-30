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

package com.google.cloud.osconfig.v1.samples;

// [START osconfig_v1_generated_osconfigserviceclient_updatepatchdeployment_patchdeploymentspatchdeploymentfieldmask_sync]
import com.google.cloud.osconfig.v1.OsConfigServiceClient;
import com.google.cloud.osconfig.v1.PatchDeployments;
import com.google.protobuf.FieldMask;

public class SyncUpdatePatchDeploymentPatchdeploymentspatchdeploymentFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdatePatchDeploymentPatchdeploymentspatchdeploymentFieldmask();
  }

  public static void syncUpdatePatchDeploymentPatchdeploymentspatchdeploymentFieldmask()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OsConfigServiceClient osConfigServiceClient = OsConfigServiceClient.create()) {
      PatchDeployments.PatchDeployment patchDeployment =
          PatchDeployments.PatchDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      PatchDeployments.PatchDeployment response =
          osConfigServiceClient.updatePatchDeployment(patchDeployment, updateMask);
    }
  }
}
// [END osconfig_v1_generated_osconfigserviceclient_updatepatchdeployment_patchdeploymentspatchdeploymentfieldmask_sync]
