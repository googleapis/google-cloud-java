/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.example;

import com.google.cloud.ServiceOptions;
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.ProjectName;
import com.google.cloud.secretmanager.v1.Replication;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretsPagedResponse;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.protobuf.ByteString;
import java.io.IOException;

/**
 * Sample application demonstrating Native Image compatibility with Google Cloud Secret Manager
 * APIs.
 */
public class NativeImageSecretManagerSample {

  public static void main(String[] args) throws IOException {
    String secretId = "native-secretmanager-test-secret";
    String projectId = ServiceOptions.getDefaultProjectId();

    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      if (!hasSecret(client, projectId, secretId)) {
        createSecret(client, projectId, secretId);
      } else {
        System.out.println("Project already has secret: " + secretId);
      }

      SecretVersion version = addSecretVersion(client, projectId, secretId);
      printSecretVersion(client, version);
    }
  }

  static void createSecret(SecretManagerServiceClient client, String projectId, String secretId) {
    Secret secret =
        Secret.newBuilder()
            .setReplication(
                Replication.newBuilder()
                    .setAutomatic(Replication.Automatic.newBuilder().build())
                    .build())
            .build();
    ProjectName projectName = ProjectName.of(projectId);
    Secret createdSecret = client.createSecret(projectName, secretId, secret);
    System.out.println("Created secret: " + createdSecret.getName());
  }

  static boolean hasSecret(SecretManagerServiceClient client, String projectId, String secretId) {

    ProjectName projectName = ProjectName.of(projectId);
    ListSecretsPagedResponse pagedResponse = client.listSecrets(projectName);

    for (Secret secret : pagedResponse.iterateAll()) {
      String otherSecretId = extractSecretId(secret);
      if (secretId.equals(otherSecretId)) {
        return true;
      }
    }

    return false;
  }

  static SecretVersion addSecretVersion(
      SecretManagerServiceClient client, String projectId, String secretId) {

    SecretName secretName = SecretName.of(projectId, secretId);
    SecretPayload payload =
        SecretPayload.newBuilder().setData(ByteString.copyFromUtf8("Hello World")).build();

    SecretVersion version = client.addSecretVersion(secretName, payload);
    System.out.println("Added Secret Version: " + version.getName());
    return version;
  }

  static void printSecretVersion(SecretManagerServiceClient client, SecretVersion version) {
    AccessSecretVersionResponse response = client.accessSecretVersion(version.getName());
    String payload = response.getPayload().getData().toStringUtf8();
    System.out.println("Reading secret value: " + payload);
    System.out.println("(Note: Don't print secret values in prod!)");
  }

  /**
   * Returns the secret ID from the fully-qualified secret name which has the format:
   * projects/YOUR_PROJECT_ID/secrets/YOUR_SECRET_ID.
   *
   * @param secret {@link Secret} to extract id from.
   * @return a {@link String} representing the secret id
   */
  private static String extractSecretId(Secret secret) {
    String[] secretNameTokens = secret.getName().split("/");
    return secretNameTokens[secretNameTokens.length - 1];
  }
}
