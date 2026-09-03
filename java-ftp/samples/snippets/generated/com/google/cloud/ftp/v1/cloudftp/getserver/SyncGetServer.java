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

package com.google.cloud.ftp.v1.samples;

// [START ftp_v1_generated_CloudFtp_GetServer_sync]
import com.google.cloud.ftp.v1.CloudFtpClient;
import com.google.cloud.ftp.v1.GetServerRequest;
import com.google.cloud.ftp.v1.Server;
import com.google.cloud.ftp.v1.ServerName;
import com.google.cloud.ftp.v1.ServerView;

public class SyncGetServer {

  public static void main(String[] args) throws Exception {
    syncGetServer();
  }

  public static void syncGetServer() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudFtpClient cloudFtpClient = CloudFtpClient.create()) {
      GetServerRequest request =
          GetServerRequest.newBuilder()
              .setName(ServerName.of("[PROJECT]", "[LOCATION]", "[SERVER]").toString())
              .setView(ServerView.forNumber(0))
              .build();
      Server response = cloudFtpClient.getServer(request);
    }
  }
}
// [END ftp_v1_generated_CloudFtp_GetServer_sync]
