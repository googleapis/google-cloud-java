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

// [START ftp_v1_generated_CloudFtp_CreateUser_ServernameUserString_sync]
import com.google.cloud.ftp.v1.CloudFtpClient;
import com.google.cloud.ftp.v1.ServerName;
import com.google.cloud.ftp.v1.User;

public class SyncCreateUserServernameUserString {

  public static void main(String[] args) throws Exception {
    syncCreateUserServernameUserString();
  }

  public static void syncCreateUserServernameUserString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudFtpClient cloudFtpClient = CloudFtpClient.create()) {
      ServerName parent = ServerName.of("[PROJECT]", "[LOCATION]", "[SERVER]");
      User user = User.newBuilder().build();
      String userId = "userId-836030906";
      User response = cloudFtpClient.createUserAsync(parent, user, userId).get();
    }
  }
}
// [END ftp_v1_generated_CloudFtp_CreateUser_ServernameUserString_sync]
