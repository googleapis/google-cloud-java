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

// [START storage_v2_generated_Storage_WriteObject_async]
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;

public class AsyncWriteObject {

  public static void main(String[] args) throws Exception {
    asyncWriteObject();
  }

  public static void asyncWriteObject() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageClient storageClient = StorageClient.create()) {
      ApiStreamObserver<WriteObjectRequest> responseObserver =
          new ApiStreamObserver<WriteObjectRequest>() {
            @Override
            public void onNext(WriteObjectResponse response) {
              // Do something when a response is received.
            }

            @Override
            public void onError(Throwable t) {
              // Add error-handling
            }

            @Override
            public void onCompleted() {
              // Do something when complete.
            }
          };
      ApiStreamObserver<WriteObjectRequest> requestObserver =
          storageClient.writeObject().clientStreamingCall(responseObserver);
      WriteObjectRequest request =
          WriteObjectRequest.newBuilder()
              .setWriteOffset(-1559543565)
              .setObjectChecksums(ObjectChecksums.newBuilder().build())
              .setFinishWrite(true)
              .setCommonObjectRequestParams(CommonObjectRequestParams.newBuilder().build())
              .build();
      requestObserver.onNext(request);
    }
  }
}
// [END storage_v2_generated_Storage_WriteObject_async]
