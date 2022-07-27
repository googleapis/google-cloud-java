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

package com.google.cloud.deploy.v1.samples;

// [START deploy_v1_generated_clouddeployclient_listrollouts_string_sync]
import com.google.cloud.deploy.v1.CloudDeployClient;
import com.google.cloud.deploy.v1.ReleaseName;
import com.google.cloud.deploy.v1.Rollout;

public class SyncListRolloutsString {

  public static void main(String[] args) throws Exception {
    syncListRolloutsString();
  }

  public static void syncListRolloutsString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
      String parent =
          ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]").toString();
      for (Rollout element : cloudDeployClient.listRollouts(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END deploy_v1_generated_clouddeployclient_listrollouts_string_sync]
