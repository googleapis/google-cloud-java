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

package kms;

// [START kms_iam_add_member]
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import java.io.IOException;

public class IamAddMember {

  public void iamAddMember() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String member = "user:foo@example.com";
    iamAddMember(projectId, locationId, keyRingId, keyId, member);
  }

  // Add the given IAM member to the key.
  public void iamAddMember(
      String projectId, String locationId, String keyRingId, String keyId, String member)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the key version name from the project, location, key ring, key,
      // and key version.
      CryptoKeyName resourceName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // The resource name could also be a key ring.
      // KeyRingName resourceName = KeyRingName.of(projectId, locationId, keyRingId);

      // Get the current policy.
      Policy policy = client.getIamPolicy(resourceName);

      // Create a new IAM binding for the member and role.
      Binding binding =
          Binding.newBuilder()
              .setRole("roles/cloudkms.cryptoKeyEncrypterDecrypter")
              .addMembers(member)
              .build();

      // Add the binding to the policy.
      Policy newPolicy = policy.toBuilder().addBindings(binding).build();

      client.setIamPolicy(resourceName, newPolicy);
      System.out.printf("Updated IAM policy for %s%n", resourceName.toString());
    }
  }
}
// [END kms_iam_add_member]
