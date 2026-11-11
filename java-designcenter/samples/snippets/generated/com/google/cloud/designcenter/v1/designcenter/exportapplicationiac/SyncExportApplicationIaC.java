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

package com.google.cloud.designcenter.v1.samples;

// [START designcenter_v1_generated_DesignCenter_ExportApplicationIaC_sync]
import com.google.cloud.designcenter.v1.ApplicationName;
import com.google.cloud.designcenter.v1.ArtifactLocation;
import com.google.cloud.designcenter.v1.DesignCenterClient;
import com.google.cloud.designcenter.v1.ExportApplicationIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationIaCResponse;
import com.google.cloud.designcenter.v1.ExportIaCConfig;
import com.google.cloud.designcenter.v1.IACFormat;

public class SyncExportApplicationIaC {

  public static void main(String[] args) throws Exception {
    syncExportApplicationIaC();
  }

  public static void syncExportApplicationIaC() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
      ExportApplicationIaCRequest request =
          ExportApplicationIaCRequest.newBuilder()
              .setName(
                  ApplicationName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[APPLICATION]")
                      .toString())
              .setIacFormat(IACFormat.forNumber(0))
              .setArtifactLocation(ArtifactLocation.newBuilder().build())
              .setExportIacConfig(ExportIaCConfig.newBuilder().build())
              .build();
      ExportApplicationIaCResponse response =
          designCenterClient.exportApplicationIaCAsync(request).get();
    }
  }
}
// [END designcenter_v1_generated_DesignCenter_ExportApplicationIaC_sync]
