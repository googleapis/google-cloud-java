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

package com.google.cloud.webrisk.v1beta1.samples;

// [START webrisk_v1beta1_generated_webriskservicev1beta1client_searchhashes_bytestringlistthreattype_sync]
import com.google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1Client;
import com.google.protobuf.ByteString;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.ThreatType;
import java.util.ArrayList;
import java.util.List;

public class SyncSearchHashesBytestringListthreattype {

  public static void main(String[] args) throws Exception {
    syncSearchHashesBytestringListthreattype();
  }

  public static void syncSearchHashesBytestringListthreattype() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WebRiskServiceV1Beta1Client webRiskServiceV1Beta1Client =
        WebRiskServiceV1Beta1Client.create()) {
      ByteString hashPrefix = ByteString.EMPTY;
      List<ThreatType> threatTypes = new ArrayList<>();
      SearchHashesResponse response =
          webRiskServiceV1Beta1Client.searchHashes(hashPrefix, threatTypes);
    }
  }
}
// [END webrisk_v1beta1_generated_webriskservicev1beta1client_searchhashes_bytestringlistthreattype_sync]
