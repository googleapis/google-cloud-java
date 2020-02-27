package com.google.cloud.examples.storage.buckets;

// [START storage_remove_bucket_conditional_iam_binding]
import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.util.ArrayList;
import java.util.List;

public class RemoveBucketIamConditionalBinding {
    /** Example of adding a conditional binding to the Bucket-level IAM */
    public static void removeBucketIamConditionalBinding(String projectId, String bucketName) {
        // The ID of your GCP project
        // String projectId = "your-project-id";

        // The ID of your GCS bucket
        // String bucketName = "your-unique-bucket-name";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        Policy originalPolicy =
                storage.getIamPolicy(bucketName, Storage.BucketSourceOption.requestedPolicyVersion(3));

        String role = "roles/storage.objectViewer";

        List<Binding> bindings = new ArrayList(originalPolicy.getBindingsList());
        Condition.Builder conditionBuilder = Condition.newBuilder();
        conditionBuilder.setTitle("Title");
        conditionBuilder.setDescription("Description");
        conditionBuilder.setExpression(
                "resource.name.startsWith(\"projects/_/buckets/bucket-name/objects/prefix-a-\")");
        for (int index = 0; index < bindings.size(); ++index) {
            Binding binding = bindings.get(index);
            if (binding.getRole().equals(role) && binding.getCondition().equals(conditionBuilder.build())) {
                bindings.remove(index);
                break;
            }
        }

        Policy updatedPolicy =
                storage.setIamPolicy(
                        bucketName, originalPolicy.toBuilder().setBindings(bindings).setVersion(3).build());

        bindings = new ArrayList(updatedPolicy.getBindingsList());
        boolean found = false;
        for (Binding binding : bindings) {
            if (binding.getRole().equals(role) && binding.getCondition().equals(conditionBuilder.build())) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Conditional Binding was removed.");
        }
    }
}
// [END storage_remove_bucket_conditional_iam_binding]