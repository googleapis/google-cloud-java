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

// [START secretmanager_quickstart]
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.ProjectName;
import com.google.cloud.secretmanager.v1.Replication;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.protobuf.ByteString;

public class Quickstart {

  public void quickstart() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String secretId = "your-secret-id";
    quickstart(projectId, secretId);
  }

  public void quickstart(String projectId, String secretId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      // Build the parent name from the project.
      ProjectName projectName = ProjectName.of(projectId);

      // Create the parent secret.
      Secret secret =
          Secret.newBuilder()
              .setReplication(
                  Replication.newBuilder()
                      .setAutomatic(Replication.Automatic.newBuilder().build())
                      .build())
              .build();

      Secret createdSecret = client.createSecret(projectName, secretId, secret);

      // Add a secret version.
      SecretPayload payload =
          SecretPayload.newBuilder().setData(ByteString.copyFromUtf8("hello world!")).build();
      SecretVersion addedVersion = client.addSecretVersion(createdSecret.getName(), payload);

      // Access the secret version.
      AccessSecretVersionResponse response = client.accessSecretVersion(addedVersion.getName());

      // Print the secret payload.
      //
      // WARNING: Do not print the secret in a production environment - this
      // snippet is showing how to access the secret material.
      String data = response.getPayload().getData().toStringUtf8();
      System.out.printf("Plaintext: %s\n", data);
    }
  }
}
// [END secretmanager_quickstart]
