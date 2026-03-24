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

package com.google.storage.v2.samples;

// [START storage_v2_generated_Storage_RewriteObject_sync]
import com.google.protobuf.ByteString;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.CryptoKeyName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.RewriteResponse;
import com.google.storage.v2.StorageClient;

public class SyncRewriteObject {

  public static void main(String[] args) throws Exception {
    syncRewriteObject();
  }

  public static void syncRewriteObject() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageClient storageClient = StorageClient.create()) {
      RewriteObjectRequest request =
          RewriteObjectRequest.newBuilder()
              .setDestinationName("destinationName-1762755655")
              .setDestinationBucket(BucketName.of("[PROJECT]", "[BUCKET]").toString())
              .setDestinationKmsKey(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setDestination(Object.newBuilder().build())
              .setSourceBucket("sourceBucket841604581")
              .setSourceObject("sourceObject1196439354")
              .setSourceGeneration(1232209852)
              .setRewriteToken("rewriteToken80654285")
              .setDestinationPredefinedAcl("destinationPredefinedAcl1111125814")
              .setIfGenerationMatch(-1086241088)
              .setIfGenerationNotMatch(1475720404)
              .setIfMetagenerationMatch(1043427781)
              .setIfMetagenerationNotMatch(1025430873)
              .setIfSourceGenerationMatch(-1427877280)
              .setIfSourceGenerationNotMatch(1575612532)
              .setIfSourceMetagenerationMatch(1143319909)
              .setIfSourceMetagenerationNotMatch(1900822777)
              .setMaxBytesRewrittenPerCall(1178170730)
              .setCopySourceEncryptionAlgorithm("copySourceEncryptionAlgorithm-1524952548")
              .setCopySourceEncryptionKeyBytes(ByteString.EMPTY)
              .setCopySourceEncryptionKeySha256Bytes(ByteString.EMPTY)
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .build();
      RewriteResponse response = storageClient.rewriteObject(request);
    }
  }
}
// [END storage_v2_generated_Storage_RewriteObject_sync]
