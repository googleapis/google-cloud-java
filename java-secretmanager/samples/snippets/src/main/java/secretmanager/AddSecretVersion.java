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

// [START secretmanager_add_secret_version]
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class AddSecretVersion {

  public void addSecretVersion() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String secretId = "your-secret-id";
    addSecretVersion(projectId, secretId);
  }

  // Add a new version to the existing secret.
  public void addSecretVersion(String projectId, String secretId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      SecretName secretName = SecretName.of(projectId, secretId);

      // Create the secret payload.
      SecretPayload payload =
          SecretPayload.newBuilder()
              .setData(ByteString.copyFromUtf8("my super secret data"))
              .build();

      // Add the secret version.
      SecretVersion version = client.addSecretVersion(secretName, payload);
      System.out.printf("Added secret version %s\n", version.getName());
    }
  }
}
// [END secretmanager_add_secret_version]
