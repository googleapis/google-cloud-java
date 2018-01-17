/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.examples.storage.snippets;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.util.Map;
import java.util.Set;

/**
 * This class contains Bucket-level IAM snippets for the {@link Storage} interface.
 */
public class BucketIamSnippets {

  /**
   * Example of listing the Bucket-Level IAM Roles and Members
   */
  public Policy listBucketIamMembers(String bucketName) {
    // [START view_bucket_iam_members]
    // Initialize a Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get IAM Policy for a bucket
    Policy policy = storage.getIamPolicy(bucketName);

    // Print Roles and its identities
    Map<Role, Set<Identity>> policyBindings = policy.getBindings();
    for(Map.Entry<Role, Set<Identity>> entry : policyBindings.entrySet()) {
        System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
    }
    // [END view_bucket_iam_members]
    return policy;
  }

  /**
   * Example of adding a member to the Bucket-level IAM
   */
  public Policy addBucketIamMember(String bucketName, Role role, Identity identity) {
    // [START add_bucket_iam_member]
    // Initialize a Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get IAM Policy for a bucket
    Policy policy = storage.getIamPolicy(bucketName);

    // Add identity to Bucket-level IAM role
    Policy updatedPolicy = storage.setIamPolicy(bucketName,
        policy.toBuilder().addIdentity(role, identity).build());

    if (updatedPolicy.getBindings().get(role).contains(identity)) {
      System.out.printf("Added %s with role %s to %s\n", identity, role, bucketName);
    }
    // [END add_bucket_iam_member]
    return updatedPolicy;
  }

  /**
   * Example of removing a member from the Bucket-level IAM
   */
  public Policy removeBucketIamMember(String bucketName, Role role, Identity identity) {
    // [START remove_bucket_iam_member]
    // Initialize a Cloud Storage client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // Get IAM Policy for a bucket
    Policy policy = storage.getIamPolicy(bucketName);

    // Remove an identity from a Bucket-level IAM role
    Policy updatedPolicy = storage.setIamPolicy(bucketName,
        policy.toBuilder().removeIdentity(role, identity).build());

    if (updatedPolicy.getBindings().get(role) == null ||
        !updatedPolicy.getBindings().get(role).contains(identity)) {
      System.out.printf("Removed %s with role %s from %s\n", identity, role, bucketName);
    }
    // [END remove_bucket_iam_member]
    return updatedPolicy;
  }
}
