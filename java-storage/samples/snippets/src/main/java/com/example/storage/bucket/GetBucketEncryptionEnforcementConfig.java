/*
 * Copyright 2026 Google LLC
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

// [START storage_get_bucket_encryption_enforcement_config]

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.CustomerManagedEncryptionEnforcementConfig;
import com.google.cloud.storage.BucketInfo.CustomerSuppliedEncryptionEnforcementConfig;
import com.google.cloud.storage.BucketInfo.GoogleManagedEncryptionEnforcementConfig;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GetBucketEncryptionEnforcementConfig {
  public static void getBucketEncryptionEnforcementConfig(String projectId, String bucketName)
      throws Exception {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    try (Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService()) {
      System.out.println(
          "\n--- Getting Encryption Enforcement Policy for bucket " + bucketName + " ---");

      Bucket bucket = storage.get(bucketName);

      if (bucket == null) {
        System.out.println("Bucket " + bucketName + " not found.");
        return;
      }

      System.out.println("Bucket Name: " + bucket.getName());

      GoogleManagedEncryptionEnforcementConfig gmekConfig =
          bucket.getGoogleManagedEncryptionEnforcementConfig();
      CustomerManagedEncryptionEnforcementConfig cmekConfig =
          bucket.getCustomerManagedEncryptionEnforcementConfig();
      CustomerSuppliedEncryptionEnforcementConfig csekConfig =
          bucket.getCustomerSuppliedEncryptionEnforcementConfig();

      System.out.println(
          "  GMEK Enforcement: "
              + (gmekConfig != null
                  ? String.format(
                      "Mode: %s, Effective Time: %s",
                      gmekConfig.getRestrictionMode(), gmekConfig.getEffectiveTime())
                  : "NOT SET (Default)"));
      System.out.println(
          "  CMEK Enforcement: "
              + (cmekConfig != null
                  ? String.format(
                      "Mode: %s, Effective Time: %s",
                      cmekConfig.getRestrictionMode(), cmekConfig.getEffectiveTime())
                  : "NOT SET (Default)"));
      System.out.println(
          "  CSEK Enforcement: "
              + (csekConfig != null
                  ? String.format(
                      "Mode: %s, Effective Time: %s",
                      csekConfig.getRestrictionMode(), csekConfig.getEffectiveTime())
                  : "NOT SET (Default)"));
    }
  }
}
// [END storage_get_bucket_encryption_enforcement_config]
