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

// [START secretmanager_get_secret]
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import java.io.IOException;

public class GetSecret {

  public void getSecret() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String secretId = "your-secret-id";
    getSecret(projectId, secretId);
  }

  // Get an existing secret.
  public void getSecret(String projectId, String secretId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      // Build the name.
      SecretName secretName = SecretName.of(projectId, secretId);

      // Create the secret.
      Secret secret = client.getSecret(secretName);

      // Get the replication policy.
      String replication = "";
      if (secret.getReplication().getAutomatic() != null) {
        replication = "AUTOMATIC";
      } else if (secret.getReplication().getUserManaged() != null) {
        replication = "MANAGED";
      } else {
        throw new IllegalStateException("Unknown replication type");
      }

      System.out.printf("Secret %s, replication %s\n", secret.getName(), replication);
    }
  }
}
// [END secretmanager_get_secret]
