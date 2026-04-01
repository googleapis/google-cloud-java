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

// [START storage_remove_bucket_default_owner]

import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class RemoveBucketDefaultOwner {

  public static void removeBucketDefaultOwner(String bucketName, String userEmail) {

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The email of the user you wish to remove as a default owner
    // String userEmail = "someuser@domain.com"

    Storage storage = StorageOptions.newBuilder().build().getService();
    Bucket bucket = storage.get(bucketName);
    User userToRemove = new User(userEmail);

    boolean success = bucket.deleteDefaultAcl(userToRemove);
    if (success) {
      System.out.println("Removed user " + userEmail + " as an owner on " + bucketName);
    } else {
      System.out.println("User " + userEmail + " was not found");
    }
  }
}
// [END storage_remove_bucket_default_owner]
