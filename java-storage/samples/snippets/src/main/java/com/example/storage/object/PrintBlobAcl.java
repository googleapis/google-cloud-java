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

// [START storage_print_file_acl]

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.List;

public class PrintBlobAcl {

  public static void printBlobAcl(String bucketName, String blobName) {

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of the blob/file that you wish to view Acls of
    // String blobName = "your-blob-name";

    Storage storage = StorageOptions.newBuilder().build().getService();
    Blob blob = storage.get(BlobId.of(bucketName, blobName));
    List<Acl> blobAcls = blob.getAcl();

    for (Acl acl : blobAcls) {

      // This will give you the role.
      // See https://cloud.google.com/storage/docs/access-control/lists#permissions
      String role = acl.getRole().name();

      // This will give you the Entity type (i.e. User, Group, Project etc.)
      // See https://cloud.google.com/storage/docs/access-control/lists#scopes
      String entityType = acl.getEntity().getType().name();

      System.out.printf("%s: %s %n", role, entityType);
    }
  }
}
// [END storage_print_file_acl]
