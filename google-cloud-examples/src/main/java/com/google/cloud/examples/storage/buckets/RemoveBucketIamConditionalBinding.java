package com.google.cloud.examples.storage.buckets;

// [START storage_remove_bucket_conditional_iam_binding]
import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveBucketIamConditionalBinding {
  /** Example of removing a conditional binding to the Bucket-level IAM */
  public static void removeBucketIamConditionalBinding(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // For more information please read:
    // https://cloud.google.com/storage/docs/access-control/iam
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    int policyVersion = 3;
    Policy originalPolicy =
        storage.getIamPolicy(
            bucketName, Storage.BucketSourceOption.requestedPolicyVersion(policyVersion));

    String role = "roles/storage.objectViewer";

    // Get policy bindings list as a mutable ArrayList.
    List<Binding> bindings = new ArrayList(originalPolicy.getBindingsList());

    // Create a condition to compare against
    Condition.Builder conditionBuilder = Condition.newBuilder();
    conditionBuilder.setTitle("Title");
    conditionBuilder.setDescription("Description");
    conditionBuilder.setExpression(
        "resource.name.startsWith(\"projects/_/buckets/bucket-name/objects/prefix-a-\")");

    Iterator iterator = bindings.iterator();
    while (iterator.hasNext()) {
      Binding binding = (Binding) iterator.next();
      boolean foundRole = binding.getRole().equals(role);
      boolean conditionsEqual = conditionBuilder.build().equals(binding.getCondition());

      // Remove condition when the role and condition are equal
      if (foundRole && conditionsEqual) {
        iterator.remove();
        break;
      }
    }

    // Update policy to remove conditional binding
    Policy updatedPolicy =
        storage.setIamPolicy(
            bucketName,
            originalPolicy.toBuilder().setBindings(bindings).setVersion(policyVersion).build());

    System.out.println("Conditional Binding was removed.");
  }
}
// [END storage_remove_bucket_conditional_iam_binding]
