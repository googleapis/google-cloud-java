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

package com.google.cloud.iam.admin.v1.samples;

// [START iam_v1_generated_IAM_GetServiceAccountKey_KeynameServiceaccountpublickeytype_sync]
import com.google.cloud.iam.admin.v1.IAMClient;
import com.google.iam.admin.v1.KeyName;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.ServiceAccountPublicKeyType;

public class SyncGetServiceAccountKeyKeynameServiceaccountpublickeytype {

  public static void main(String[] args) throws Exception {
    syncGetServiceAccountKeyKeynameServiceaccountpublickeytype();
  }

  public static void syncGetServiceAccountKeyKeynameServiceaccountpublickeytype() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IAMClient iAMClient = IAMClient.create()) {
      KeyName name = KeyName.of("[PROJECT]", "[SERVICE_ACCOUNT]", "[KEY]");
      ServiceAccountPublicKeyType publicKeyType = ServiceAccountPublicKeyType.forNumber(0);
      ServiceAccountKey response = iAMClient.getServiceAccountKey(name, publicKeyType);
    }
  }
}
// [END iam_v1_generated_IAM_GetServiceAccountKey_KeynameServiceaccountpublickeytype_sync]
