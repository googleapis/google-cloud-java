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

package com.google.cloud.video.transcoder.v1.samples;

// [START transcoder_v1_generated_TranscoderService_CreateJobTemplate_sync]
import com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.JobTemplate;
import com.google.cloud.video.transcoder.v1.LocationName;
import com.google.cloud.video.transcoder.v1.TranscoderServiceClient;

public class SyncCreateJobTemplate {

  public static void main(String[] args) throws Exception {
    syncCreateJobTemplate();
  }

  public static void syncCreateJobTemplate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
      CreateJobTemplateRequest request =
          CreateJobTemplateRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setJobTemplate(JobTemplate.newBuilder().build())
              .setJobTemplateId("jobTemplateId-597733678")
              .build();
      JobTemplate response = transcoderServiceClient.createJobTemplate(request);
    }
  }
}
// [END transcoder_v1_generated_TranscoderService_CreateJobTemplate_sync]
