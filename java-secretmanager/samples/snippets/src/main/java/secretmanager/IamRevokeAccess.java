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

package secretmanager;

// [START secretmanager_iam_revoke_access]
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import java.io.IOException;

public class IamRevokeAccess {

  public void iamRevokeAccess() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String secretId = "your-secret-id";
    String member = "user:foo@example.com";
    iamRevokeAccess(projectId, secretId, member);
  }

  // Revoke a member access to a particular secret.
  public void iamRevokeAccess(String projectId, String secretId, String member) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      // Build the name from the version.
      SecretName secretName = SecretName.of(projectId, secretId);

      // Request the current IAM policy.
      Policy policy =
          client.getIamPolicy(
              GetIamPolicyRequest.newBuilder().setResource(secretName.toString()).build());

      // Search through bindings and remove matches.
      String roleToFind = "roles/secretmanager.secretAccessor";
      for (Binding binding : policy.getBindingsList()) {
        if (binding.getRole() == roleToFind && binding.getMembersList().contains(member)) {
          binding.getMembersList().remove(member);
        }
      }

      // Save the updated IAM policy.
      client.setIamPolicy(
          SetIamPolicyRequest.newBuilder()
              .setResource(secretName.toString())
              .setPolicy(policy)
              .build());

      System.out.printf("Updated IAM policy for %s\n", secretId);
    }
  }
}
// [END secretmanager_iam_revoke_access]
