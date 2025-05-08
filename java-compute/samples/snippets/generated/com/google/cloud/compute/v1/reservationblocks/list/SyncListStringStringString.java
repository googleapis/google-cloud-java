/*
 * Copyright 2025 Google LLC
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

// [START compute_v1_generated_ReservationBlocks_List_StringStringString_sync]
import com.google.cloud.compute.v1.ReservationBlock;
import com.google.cloud.compute.v1.ReservationBlocksClient;

public class SyncListStringStringString {

  public static void main(String[] args) throws Exception {
    syncListStringStringString();
  }

  public static void syncListStringStringString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReservationBlocksClient reservationBlocksClient = ReservationBlocksClient.create()) {
      String project = "project-309310695";
      String zone = "zone3744684";
      String reservation = "reservation-1563081780";
      for (ReservationBlock element :
          reservationBlocksClient.list(project, zone, reservation).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END compute_v1_generated_ReservationBlocks_List_StringStringString_sync]
