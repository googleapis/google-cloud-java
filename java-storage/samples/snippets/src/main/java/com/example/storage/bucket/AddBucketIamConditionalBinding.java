/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

// [START storage_add_bucket_conditional_iam_binding]

import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBucketIamConditionalBinding {
  /** Example of adding a conditional binding to the Bucket-level IAM */
  public static void addBucketIamConditionalBinding(String projectId, String bucketName) {
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

    // Create a condition
    String conditionTitle = "Title";
    String conditionDescription = "Description";
    String conditionExpression =
        "resource.name.startsWith(\"projects/_/buckets/bucket-name/objects/prefix-a-\")";
    Condition.Builder conditionBuilder = Condition.newBuilder();
    conditionBuilder.setTitle(conditionTitle);
    conditionBuilder.setDescription(conditionDescription);
    conditionBuilder.setExpression(conditionExpression);

    // getBindingsList() returns an ImmutableList, we copy over to an ArrayList so it's mutable
    List<Binding> bindings = new ArrayList(originalPolicy.getBindingsList());

    // Add condition to a binding
    Binding.Builder newBindingBuilder =
        Binding.newBuilder()
            .setRole(role)
            .setMembers(Arrays.asList(member))
            .setCondition(conditionBuilder.build());
    bindings.add(newBindingBuilder.build());

    // Update policy with new conditional binding
    Policy.Builder updatedPolicyBuilder = originalPolicy.toBuilder();
    updatedPolicyBuilder.setBindings(bindings).setVersion(3);

    storage.setIamPolicy(bucketName, updatedPolicyBuilder.build());

    System.out.printf(
        "Added %s with role %s to %s with condition %s %s %s\n",
        member, role, bucketName, conditionTitle, conditionDescription, conditionExpression);
  }
}
// [END storage_add_bucket_conditional_iam_binding]
