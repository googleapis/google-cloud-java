package com.google.cloud.examples.storage.buckets;

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

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    int policyVersion = 3;
    Policy originalPolicy =
        storage.getIamPolicy(
            bucketName, Storage.BucketSourceOption.requestedPolicyVersion(policyVersion));

    String role = "roles/storage.objectViewer";
    String member = "group:example@google.com";

    // Get policy bindings list as a mutable ArrayList.
    List<Binding> bindings = new ArrayList(originalPolicy.getBindingsList());

    // Create a condition
    Condition.Builder conditionBuilder = Condition.newBuilder();
    conditionBuilder.setTitle("Title");
    conditionBuilder.setDescription("Description");
    conditionBuilder.setExpression(
        "resource.name.startsWith(\"projects/_/buckets/bucket-name/objects/prefix-a-\")");

    // Add condition to a binding
    bindings.add(
        Binding.newBuilder()
            .setRole(role)
            .setMembers(Arrays.asList(member))
            .setCondition(conditionBuilder.build())
            .build());

    // Update policy with new conditional binding
    Policy updatedPolicy =
        storage.setIamPolicy(
            bucketName,
            originalPolicy.toBuilder().setBindings(bindings).setVersion(policyVersion).build());

    System.out.printf(
            "Added conditional binding with role %s to %s\n", member, role, bucketName);
  }
}
// [END storage_add_bucket_conditional_iam_binding]
