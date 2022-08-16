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

// [START transcoder_v1_generated_transcoderserviceclient_deletejob_string_sync]
import com.google.cloud.video.transcoder.v1.JobName;
import com.google.cloud.video.transcoder.v1.TranscoderServiceClient;

public class SyncDeleteJobString {

  public static void main(String[] args) throws Exception {
    syncDeleteJobString();
  }

  public static void syncDeleteJobString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TranscoderServiceClient transcoderServiceClient = TranscoderServiceClient.create()) {
      String name = JobName.of("[PROJECT]", "[LOCATION]", "[JOB]").toString();
      transcoderServiceClient.deleteJob(name);
    }
  }
}
// [END transcoder_v1_generated_transcoderserviceclient_deletejob_string_sync]
