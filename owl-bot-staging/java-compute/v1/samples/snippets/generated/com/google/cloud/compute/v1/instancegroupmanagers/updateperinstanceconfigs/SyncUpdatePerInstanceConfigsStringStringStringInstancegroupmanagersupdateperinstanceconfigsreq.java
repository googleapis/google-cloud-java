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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_InstanceGroupManagers_UpdatePerInstanceConfigs_StringStringStringInstancegroupmanagersupdateperinstanceconfigsreq_sync]
import com.google.cloud.compute.v1.InstanceGroupManagersClient;
import com.google.cloud.compute.v1.InstanceGroupManagersUpdatePerInstanceConfigsReq;
import com.google.cloud.compute.v1.Operation;

public
class SyncUpdatePerInstanceConfigsStringStringStringInstancegroupmanagersupdateperinstanceconfigsreq {

  public static void main(String[] args) throws Exception {
    syncUpdatePerInstanceConfigsStringStringStringInstancegroupmanagersupdateperinstanceconfigsreq();
  }

  public static void
      syncUpdatePerInstanceConfigsStringStringStringInstancegroupmanagersupdateperinstanceconfigsreq()
          throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InstanceGroupManagersClient instanceGroupManagersClient =
        InstanceGroupManagersClient.create()) {
      String project = "project-309310695";
      String zone = "zone3744684";
      String instanceGroupManager = "instanceGroupManager-388242077";
      InstanceGroupManagersUpdatePerInstanceConfigsReq
          instanceGroupManagersUpdatePerInstanceConfigsReqResource =
              InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
      Operation response =
          instanceGroupManagersClient
              .updatePerInstanceConfigsAsync(
                  project,
                  zone,
                  instanceGroupManager,
                  instanceGroupManagersUpdatePerInstanceConfigsReqResource)
              .get();
    }
  }
}
// [END compute_v1_generated_InstanceGroupManagers_UpdatePerInstanceConfigs_StringStringStringInstancegroupmanagersupdateperinstanceconfigsreq_sync]
