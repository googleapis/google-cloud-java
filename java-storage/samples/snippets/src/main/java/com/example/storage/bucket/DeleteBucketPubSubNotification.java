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

// [START storage_delete_bucket_notification]
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class DeleteBucketPubSubNotification {

  public static void deleteBucketPubSubNotification(String bucketName, String notificationId) {
    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The NotificationId for the notification you would like to delete
    // String notificationId = "your-unique-notification-id"

    Storage storage = StorageOptions.newBuilder().build().getService();
    boolean success = storage.deleteNotification(bucketName, notificationId);
    if (success) {
      System.out.println("Successfully deleted notification");
    } else {
      System.out.println("Failed to find notification");
    }
  }
}
// [END storage_delete_bucket_notification]
