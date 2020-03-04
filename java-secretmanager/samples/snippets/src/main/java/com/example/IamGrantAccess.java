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

package com.example;

// [START secretmanager_iam_grant_access]
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import java.io.IOException;

public class IamGrantAccess {

  public void iamGrantAccess() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String secretId = "your-secret-id";
    String member = "user:foo@example.com";
    iamGrantAccess(projectId, secretId, member);
  }

  // Grant a member access to a particular secret.
  public void iamGrantAccess(String projectId, String secretId, String member) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      // Build the name from the version.
      SecretName name = SecretName.of(projectId, secretId);

      // Create a request to get the current IAM policy.
      GetIamPolicyRequest getRequest =
          GetIamPolicyRequest.newBuilder().setResource(name.toString()).build();

      // Request the current IAM policy.
      Policy currentPolicy = client.getIamPolicy(getRequest);

      // Build the new binding.
      Binding binding =
          Binding.newBuilder()
              .setRole("roles/secretmanager.secretAccessor")
              .addMembers(member)
              .build();

      // Create a new IAM policy from the current policy, adding the binding.
      Policy newPolicy = Policy.newBuilder().mergeFrom(currentPolicy).addBindings(binding).build();

      // Create a request to update the IAM policy.
      SetIamPolicyRequest setRequest =
          SetIamPolicyRequest.newBuilder()
              .setResource(name.toString())
              .setPolicy(newPolicy)
              .build();

      // Save the updated IAM policy.
      client.setIamPolicy(setRequest);

      System.out.printf("Updated IAM policy for %s\n", secretId);
    }
  }
}
// [END secretmanager_iam_grant_access]
