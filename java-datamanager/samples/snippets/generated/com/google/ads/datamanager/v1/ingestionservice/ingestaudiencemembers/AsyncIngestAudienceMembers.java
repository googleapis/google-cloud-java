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

package com.google.ads.datamanager.v1.samples;

// [START datamanager_v1_generated_IngestionService_IngestAudienceMembers_async]
import com.google.ads.datamanager.v1.AudienceMember;
import com.google.ads.datamanager.v1.Consent;
import com.google.ads.datamanager.v1.Destination;
import com.google.ads.datamanager.v1.Encoding;
import com.google.ads.datamanager.v1.EncryptionInfo;
import com.google.ads.datamanager.v1.IngestAudienceMembersRequest;
import com.google.ads.datamanager.v1.IngestAudienceMembersResponse;
import com.google.ads.datamanager.v1.IngestionServiceClient;
import com.google.ads.datamanager.v1.TermsOfService;
import com.google.api.core.ApiFuture;
import java.util.ArrayList;

public class AsyncIngestAudienceMembers {

  public static void main(String[] args) throws Exception {
    asyncIngestAudienceMembers();
  }

  public static void asyncIngestAudienceMembers() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
      IngestAudienceMembersRequest request =
          IngestAudienceMembersRequest.newBuilder()
              .addAllDestinations(new ArrayList<Destination>())
              .addAllAudienceMembers(new ArrayList<AudienceMember>())
              .setConsent(Consent.newBuilder().build())
              .setValidateOnly(true)
              .setEncoding(Encoding.forNumber(0))
              .setEncryptionInfo(EncryptionInfo.newBuilder().build())
              .setTermsOfService(TermsOfService.newBuilder().build())
              .build();
      ApiFuture<IngestAudienceMembersResponse> future =
          ingestionServiceClient.ingestAudienceMembersCallable().futureCall(request);
      // Do something.
      IngestAudienceMembersResponse response = future.get();
    }
  }
}
// [END datamanager_v1_generated_IngestionService_IngestAudienceMembers_async]
