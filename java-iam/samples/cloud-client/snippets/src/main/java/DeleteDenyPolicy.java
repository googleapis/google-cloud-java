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

// [START iam_delete_deny_policy]

import com.google.iam.v2beta.DeletePolicyRequest;
import com.google.iam.v2beta.PoliciesClient;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DeleteDenyPolicy {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.

    // ID or number of the Google Cloud project you want to use.
    String projectId = "your-google-cloud-project-id";

    // Specify the ID of the deny policy you want to retrieve.
    String policyId = "deny-policy-id";

    deleteDenyPolicy(projectId, policyId);
  }

  // Delete the policy if you no longer want to enforce the rules in a deny policy.
  public static void deleteDenyPolicy(String projectId, String policyId)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    try (PoliciesClient policiesClient = PoliciesClient.create()) {

      // Each deny policy is attached to an organization, folder, or project.
      // To work with deny policies, specify the attachment point.
      //
      // Its format can be one of the following:
      // 1. cloudresourcemanager.googleapis.com/organizations/ORG_ID
      // 2. cloudresourcemanager.googleapis.com/folders/FOLDER_ID
      // 3. cloudresourcemanager.googleapis.com/projects/PROJECT_ID
      //
      // The attachment point is identified by its URL-encoded resource name.
      String urlEncodedResource =
          URLEncoder.encode(
              "cloudresourcemanager.googleapis.com/projects/", StandardCharsets.UTF_8);
      String attachmentPoint = String.format("%s%s", urlEncodedResource, projectId);

      // Construct the full path of the resource to which the policy is attached.
      // Its format is: "policies/{attachmentPoint}/denypolicies/{policyId}"
      String policyParent = String.format("policies/%s/denypolicies/%s", attachmentPoint, policyId);

      // Create the DeletePolicy request.
      DeletePolicyRequest deletePolicyRequest =
          DeletePolicyRequest.newBuilder().setName(policyParent).build();

      // Delete the policy and wait for the operation to complete.
      Operation operation =
          policiesClient
              .deletePolicyCallable()
              .futureCall(deletePolicyRequest)
              .get(3, TimeUnit.MINUTES);

      if (!operation.getDone() || operation.hasError()) {
        System.out.println("Error in deleting the policy " + operation.getError());
        return;
      }

      System.out.println("Deleted the deny policy: " + policyId);
    }
  }
}
// [END iam_delete_deny_policy]
