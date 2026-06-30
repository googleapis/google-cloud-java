/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.object;

// [START storage_print_file_acl_for_user]

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class PrintBlobAclForUser {

  public static void printBlobAclForUser(String bucketName, String blobName, String userEmail)
      throws Exception {

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the blob/file that you wish to view Acls of
    // String blobName = "your-blob-name";

    // The email of the user whose acl is being retrieved.
    // String userEmail = "someuser@domain.com"

    try (Storage storage = StorageOptions.newBuilder().build().getService()) {
      Blob blob = storage.get(BlobId.of(bucketName, blobName));
      Acl blobAcl = blob.getAcl(new User(userEmail));
      if (blobAcl != null) {
        String userRole = blobAcl.getRole().name();
        System.out.println("User " + userEmail + " has role " + userRole);
      } else {
        System.out.println("User " + userEmail + " not found");
      }
    }
  }
}
// [END storage_print_file_acl_for_user]
