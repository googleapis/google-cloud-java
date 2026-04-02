/*
 * Copyright 2023 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage;

// [START storage_grpc_quickstart]
// Imports the Google Cloud client library
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class QuickstartGrpcSample {
  public static void main(String... args) throws Exception {

    // Create an instance of options which will use the Google Cloud Storage gRPC API for all
    // operations
    StorageOptions options = StorageOptions.grpc().build();

    // Instantiates a client in a try-with-resource to automatically cleanup underlying resources
    try (Storage storage = options.getService()) {
      // The name for the new bucket
      String bucketName = args[0]; // "my-new-bucket";

      // Creates the new bucket using a request to the gRPC API
      Bucket bucket = storage.create(BucketInfo.of(bucketName));

      System.out.printf("Bucket %s created.%n", bucket.getName());
    }
  }
}
// [END storage_grpc_quickstart]
