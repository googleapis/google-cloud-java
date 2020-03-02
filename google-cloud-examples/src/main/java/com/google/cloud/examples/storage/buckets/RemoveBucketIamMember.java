/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.examples.storage.buckets;

// [START storage_remove_bucket_iam_member]
import com.google.cloud.Binding;
import com.google.cloud.Policy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.List;

public class RemoveBucketIamMember {
  public static void removeBucketIamMember(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // For more information please read:
    // https://cloud.google.com/storage/docs/access-control/iam
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Policy originalPolicy =
        storage.getIamPolicy(bucketName, Storage.BucketSourceOption.requestedPolicyVersion(3));

    String role = "roles/storage.objectViewer";
    String member = "group:example@google.com";

    // getBindingsList() returns an ImmutableList and copying over to an ArrayList so it's mutable.
    List<Binding> bindings = new ArrayList(originalPolicy.getBindingsList());

    // Remove role-member binding without a condition.
    for (int index = 0; index < bindings.size(); index++) {
      Binding binding = bindings.get(index);
      boolean foundRole = binding.getRole().equals(role);
      boolean foundMember = binding.getMembers().contains(member);
      boolean bindingIsNotConditional = binding.getCondition() == null;

      if (foundRole && foundMember && bindingIsNotConditional) {
        bindings.set(index, binding.toBuilder().removeMembers(member).build());
        break;
      }
    }

    // Update policy to remove member
    Policy.Builder updatedPolicyBuilder = originalPolicy.toBuilder();
    updatedPolicyBuilder.setBindings(bindings).setVersion(3);
    Policy updatedPolicy = storage.setIamPolicy(bucketName, updatedPolicyBuilder.build());

    System.out.printf("Removed %s with role %s from %s\n", member, role, bucketName);
  }
}
// [END storage_remove_bucket_iam_member]
