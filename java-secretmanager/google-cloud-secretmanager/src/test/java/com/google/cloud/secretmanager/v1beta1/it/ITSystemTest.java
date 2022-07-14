/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.secretmanager.v1beta1.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.secretmanager.v1beta1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1beta1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1beta1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1beta1.DestroySecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.DisableSecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.EnableSecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.GetSecretRequest;
import com.google.cloud.secretmanager.v1beta1.GetSecretVersionRequest;
import com.google.cloud.secretmanager.v1beta1.ListSecretVersionsRequest;
import com.google.cloud.secretmanager.v1beta1.ListSecretsRequest;
import com.google.cloud.secretmanager.v1beta1.ProjectName;
import com.google.cloud.secretmanager.v1beta1.Replication;
import com.google.cloud.secretmanager.v1beta1.Secret;
import com.google.cloud.secretmanager.v1beta1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1beta1.SecretName;
import com.google.cloud.secretmanager.v1beta1.SecretPayload;
import com.google.cloud.secretmanager.v1beta1.SecretVersion;
import com.google.cloud.secretmanager.v1beta1.SecretVersionName;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String PROJECT_NAME = ProjectName.of(PROJECT_ID).toString();
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String SECRET_ID = "test-secret-id-" + ID;
  private static final String LOCATION = "us-central1";
  private static final SecretPayload PAYLOAD =
      SecretPayload.newBuilder().setData(ByteString.copyFromUtf8("test-payload")).build();
  private static SecretManagerServiceClient client;
  private static Secret secret;
  private static String secretId;
  private static String formattedSecretName;
  private static SecretVersion secretVersion;
  private static String secretVersionId;
  private static String formattedSecretVersion;

  @BeforeClass
  public static void setUp() throws IOException {

    /* create secret */
    client = SecretManagerServiceClient.create();
    Replication createReplication =
        Replication.newBuilder()
            .setUserManaged(
                Replication.UserManaged.newBuilder()
                    .addReplicas(
                        Replication.UserManaged.Replica.newBuilder().setLocation(LOCATION).build()))
            .build();
    Secret createSecret = Secret.newBuilder().setReplication(createReplication).build();
    CreateSecretRequest secretRequest =
        CreateSecretRequest.newBuilder()
            .setParent(PROJECT_NAME)
            .setSecretId(SECRET_ID)
            .setSecret(createSecret)
            .build();
    secret = client.createSecret(secretRequest);
    secretId = getName(secret.getName());
    formattedSecretName = SecretName.of(PROJECT_ID, secretId).toString();

    /* create secret version */
    AddSecretVersionRequest versionRequest =
        AddSecretVersionRequest.newBuilder()
            .setParent(formattedSecretName)
            .setPayload(PAYLOAD)
            .build();
    secretVersion = client.addSecretVersion(versionRequest);
    secretVersionId = getName(secretVersion.getName());
    formattedSecretVersion = SecretVersionName.of(PROJECT_ID, secretId, secretVersionId).toString();
  }

  @AfterClass
  public static void tearDown() {

    /* destroy secret version */
    DestroySecretVersionRequest versionRequest =
        DestroySecretVersionRequest.newBuilder().setName(formattedSecretVersion).build();
    SecretVersion actualSecretVersion = client.destroySecretVersion(versionRequest);
    assertEquals(secretVersion.getCreateTime(), actualSecretVersion.getCreateTime());
    assertEquals(SecretVersion.State.DESTROYED, actualSecretVersion.getState());

    /* delete secret */
    DeleteSecretRequest secretRequest =
        DeleteSecretRequest.newBuilder().setName(formattedSecretName).build();
    client.deleteSecret(secretRequest);
    client.close();
  }

  @Test
  public void listSecretsTest() {
    ListSecretsRequest request = ListSecretsRequest.newBuilder().setParent(PROJECT_NAME).build();
    for (Secret actualSecret : client.listSecrets(request).iterateAll()) {
      if (secret.getName().equals(actualSecret.getName())) {
        assertEquals(secret.getReplication(), actualSecret.getReplication());
        assertEquals(secret.getCreateTime(), actualSecret.getCreateTime());
      }
    }
  }

  @Test
  public void getSecretTest() {
    GetSecretRequest request = GetSecretRequest.newBuilder().setName(formattedSecretName).build();
    Secret actualSecret = client.getSecret(request);
    assertEquals(secret.getName(), actualSecret.getName());
    assertEquals(secret.getReplication(), actualSecret.getReplication());
    assertEquals(secret.getCreateTime(), actualSecret.getCreateTime());
  }

  @Test
  public void listSecretVersionsTest() {
    ListSecretVersionsRequest request =
        ListSecretVersionsRequest.newBuilder().setParent(formattedSecretName).build();
    for (SecretVersion actualSecretVersion : client.listSecretVersions(request).iterateAll()) {
      if (secretVersion.getName().equals(actualSecretVersion.getName())) {
        assertEquals(secretVersion.getCreateTime(), actualSecretVersion.getCreateTime());
        assertEquals(SecretVersion.State.ENABLED, actualSecretVersion.getState());
      }
    }
  }

  @Test
  public void getSecretVersionTest() {
    GetSecretVersionRequest request =
        GetSecretVersionRequest.newBuilder().setName(formattedSecretVersion).build();
    SecretVersion actualSecretVersion = client.getSecretVersion(request);
    assertEquals(secretVersion.getName(), actualSecretVersion.getName());
    assertEquals(secretVersion.getCreateTime(), actualSecretVersion.getCreateTime());
    assertEquals(SecretVersion.State.ENABLED, actualSecretVersion.getState());
  }

  @Test
  public void accessSecretVersionTest() {
    AccessSecretVersionRequest request =
        AccessSecretVersionRequest.newBuilder().setName(formattedSecretVersion).build();
    AccessSecretVersionResponse response = client.accessSecretVersion(request);
    assertEquals(secretVersion.getName(), response.getName());
    assertEquals(PAYLOAD, response.getPayload());
  }

  @Test
  public void disableAndEnableSecretVersionTest() {
    DisableSecretVersionRequest disableSecretVersionRequest =
        DisableSecretVersionRequest.newBuilder().setName(formattedSecretVersion).build();
    SecretVersion disableSecretVersion = client.disableSecretVersion(disableSecretVersionRequest);
    assertEquals(secretVersion.getName(), disableSecretVersion.getName());
    assertEquals(secretVersion.getCreateTime(), disableSecretVersion.getCreateTime());
    assertEquals(SecretVersion.State.DISABLED, disableSecretVersion.getState());

    EnableSecretVersionRequest enableSecretVersionRequest =
        EnableSecretVersionRequest.newBuilder().setName(formattedSecretVersion).build();
    SecretVersion enableSecretVersion = client.enableSecretVersion(enableSecretVersionRequest);
    assertEquals(secretVersion.getName(), enableSecretVersion.getName());
    assertEquals(secretVersion.getCreateTime(), enableSecretVersion.getCreateTime());
    assertEquals(SecretVersion.State.ENABLED, enableSecretVersion.getState());
  }

  private static String getName(String name) {
    return name.substring(name.lastIndexOf("/")).replace("/", "");
  }
}
