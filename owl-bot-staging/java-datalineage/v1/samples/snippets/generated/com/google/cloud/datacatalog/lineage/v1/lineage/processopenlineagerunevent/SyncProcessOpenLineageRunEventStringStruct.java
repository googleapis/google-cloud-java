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

package com.google.cloud.datacatalog.lineage.v1.samples;

// [START datalineage_v1_generated_Lineage_ProcessOpenLineageRunEvent_StringStruct_sync]
import com.google.cloud.datacatalog.lineage.v1.LineageClient;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventResponse;
import com.google.protobuf.Struct;

public class SyncProcessOpenLineageRunEventStringStruct {

  public static void main(String[] args) throws Exception {
    syncProcessOpenLineageRunEventStringStruct();
  }

  public static void syncProcessOpenLineageRunEventStringStruct() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LineageClient lineageClient = LineageClient.create()) {
      String parent = "parent-995424086";
      Struct openLineage = Struct.newBuilder().build();
      ProcessOpenLineageRunEventResponse response =
          lineageClient.processOpenLineageRunEvent(parent, openLineage);
    }
  }
}
// [END datalineage_v1_generated_Lineage_ProcessOpenLineageRunEvent_StringStruct_sync]
