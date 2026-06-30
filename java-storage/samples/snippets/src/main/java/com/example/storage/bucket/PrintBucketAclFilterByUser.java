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

package com.example.storage.bucket;

// [START storage_print_bucket_acl_for_user]

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class PrintBucketAclFilterByUser {

  public static void printBucketAclFilterByUser(String bucketName, String userEmail) {

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The email of the user whose acl is being retrieved.
    // String userEmail = "someuser@domain.com"

    Storage storage = StorageOptions.newBuilder().build().getService();
    Bucket bucket = storage.get(bucketName);

    Acl userAcl = bucket.getAcl(new User(userEmail));
    String userRole = userAcl.getRole().name();
    System.out.println("User " + userEmail + " has role " + userRole);
  }
}

// [END storage_print_bucket_acl_for_user]
