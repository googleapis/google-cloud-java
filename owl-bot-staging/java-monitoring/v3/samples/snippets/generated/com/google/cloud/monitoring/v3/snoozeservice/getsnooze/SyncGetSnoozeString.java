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

package com.google.cloud.monitoring.v3.samples;

// [START monitoring_v3_generated_SnoozeService_GetSnooze_String_sync]
import com.google.cloud.monitoring.v3.SnoozeServiceClient;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.SnoozeName;

public class SyncGetSnoozeString {

  public static void main(String[] args) throws Exception {
    syncGetSnoozeString();
  }

  public static void syncGetSnoozeString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SnoozeServiceClient snoozeServiceClient = SnoozeServiceClient.create()) {
      String name = SnoozeName.of("[PROJECT]", "[SNOOZE]").toString();
      Snooze response = snoozeServiceClient.getSnooze(name);
    }
  }
}
// [END monitoring_v3_generated_SnoozeService_GetSnooze_String_sync]
