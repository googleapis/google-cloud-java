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

// [START kms_iam_remove_member]
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import java.io.IOException;

public class IamRemoveMember {

  public void iamRemoveMember() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String member = "user:foo@example.com";
    iamRemoveMember(projectId, locationId, keyRingId, keyId, member);
  }

  // Remove the given IAM membership on the resource, if it exists.
  public void iamRemoveMember(
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

      // Search through the bindings and remove matches.
      String roleToFind = "roles/cloudkms.cryptoKeyEncrypterDecrypter";
      for (Binding binding : policy.getBindingsList()) {
        if (binding.getRole().equals(roleToFind) && binding.getMembersList().contains(member)) {
          binding.getMembersList().remove(member);
        }
      }

      client.setIamPolicy(resourceName, policy);
      System.out.printf("Updated IAM policy for %s%n", resourceName.toString());
    }
  }
}
// [END kms_iam_remove_member]
