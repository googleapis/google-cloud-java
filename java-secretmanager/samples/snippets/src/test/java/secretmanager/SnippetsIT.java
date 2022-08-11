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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.DisableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.ProjectName;
import com.google.cloud.secretmanager.v1.Replication;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import com.google.common.base.Strings;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link Snippets}. */
@RunWith(JUnit4.class)
public class SnippetsIT {
  private static final String IAM_USER =
      "serviceAccount:iam-samples@java-docs-samples-testing.iam.gserviceaccount.com";
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  private static Secret TEST_SECRET;
  private static Secret TEST_SECRET_TO_DELETE;
  private static Secret TEST_SECRET_WITH_VERSIONS;
  private static SecretName TEST_SECRET_TO_CREATE_NAME;
  private static SecretVersion TEST_SECRET_VERSION;
  private static SecretVersion TEST_SECRET_VERSION_TO_DESTROY;
  private static SecretVersion TEST_SECRET_VERSION_TO_DISABLE;
  private static SecretVersion TEST_SECRET_VERSION_TO_ENABLE;

  private ByteArrayOutputStream stdOut;

  @BeforeClass
  public static void beforeAll() throws IOException {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));

    TEST_SECRET = createSecret();
    TEST_SECRET_TO_DELETE = createSecret();
    TEST_SECRET_WITH_VERSIONS = createSecret();
    TEST_SECRET_TO_CREATE_NAME = SecretName.of(PROJECT_ID, randomSecretId());

    TEST_SECRET_VERSION = addSecretVersion(TEST_SECRET_WITH_VERSIONS);
    TEST_SECRET_VERSION_TO_DESTROY = addSecretVersion(TEST_SECRET_WITH_VERSIONS);
    TEST_SECRET_VERSION_TO_DISABLE = addSecretVersion(TEST_SECRET_WITH_VERSIONS);
    TEST_SECRET_VERSION_TO_ENABLE = addSecretVersion(TEST_SECRET_WITH_VERSIONS);
    disableSecretVersion(TEST_SECRET_VERSION_TO_ENABLE);
  }

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  @AfterClass
  public static void afterAll() throws IOException {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));

    deleteSecret(TEST_SECRET.getName());
    deleteSecret(TEST_SECRET_TO_CREATE_NAME.toString());
    deleteSecret(TEST_SECRET_TO_DELETE.getName());
    deleteSecret(TEST_SECRET_WITH_VERSIONS.getName());
  }

  private static String randomSecretId() {
    return "java-" + System.currentTimeMillis();
  }

  private static Secret createSecret() throws IOException {
    ProjectName parent = ProjectName.of(PROJECT_ID);

    CreateSecretRequest request =
        CreateSecretRequest.newBuilder()
            .setParent(parent.toString())
            .setSecretId(randomSecretId())
            .setSecret(
                Secret.newBuilder()
                    .setReplication(
                        Replication.newBuilder()
                            .setAutomatic(Replication.Automatic.newBuilder().build())
                            .build())
                    .build())
            .build();

    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      return client.createSecret(request);
    }
  }

  private static SecretVersion addSecretVersion(Secret secret) throws IOException {
    SecretName parent = SecretName.parse(secret.getName());

    AddSecretVersionRequest request =
        AddSecretVersionRequest.newBuilder()
            .setParent(parent.toString())
            .setPayload(
                SecretPayload.newBuilder()
                    .setData(ByteString.copyFromUtf8("my super secret data"))
                    .build())
            .build();

    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      return client.addSecretVersion(request);
    }
  }

  private static void deleteSecret(String secretId) throws IOException {
    DeleteSecretRequest request = DeleteSecretRequest.newBuilder().setName(secretId).build();
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      try {
        client.deleteSecret(request);
      } catch (com.google.api.gax.rpc.NotFoundException e) {
        // Ignore not found error - secret was already deleted
      } catch (io.grpc.StatusRuntimeException e) {
        if (e.getStatus().getCode() != io.grpc.Status.Code.NOT_FOUND) {
          throw e;
        }
      }
    }
  }

  private static SecretVersion disableSecretVersion(SecretVersion version) throws IOException {
    DisableSecretVersionRequest request =
        DisableSecretVersionRequest.newBuilder().setName(version.getName()).build();
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      return client.disableSecretVersion(request);
    }
  }

  @Test
  public void testAccessSecretVersion() throws IOException {
    SecretVersionName name = SecretVersionName.parse(TEST_SECRET_VERSION.getName());
    new AccessSecretVersion()
        .accessSecretVersion(name.getProject(), name.getSecret(), name.getSecretVersion());

    assertThat(stdOut.toString()).contains("my super secret data");
  }

  @Test
  public void testAddSecretVersion() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET_WITH_VERSIONS.getName());
    new AddSecretVersion().addSecretVersion(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Added secret version");
  }

  @Test
  public void testCreateSecret() throws IOException {
    SecretName name = TEST_SECRET_TO_CREATE_NAME;
    new CreateSecret().createSecret(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Created secret");
  }

  @Test
  public void testDeleteSecret() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET_TO_DELETE.getName());
    new DeleteSecret().deleteSecret(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Deleted secret");
  }

  @Test
  public void testDestroySecretVersion() throws IOException {
    SecretVersionName name = SecretVersionName.parse(TEST_SECRET_VERSION_TO_DESTROY.getName());
    new DestroySecretVersion()
        .destroySecretVersion(name.getProject(), name.getSecret(), name.getSecretVersion());

    assertThat(stdOut.toString()).contains("Destroyed secret version");
  }

  @Test
  public void testDisableSecretVersion() throws IOException {
    SecretVersionName name = SecretVersionName.parse(TEST_SECRET_VERSION_TO_DISABLE.getName());
    new DisableSecretVersion()
        .disableSecretVersion(name.getProject(), name.getSecret(), name.getSecretVersion());

    assertThat(stdOut.toString()).contains("Disabled secret version");
  }

  @Test
  public void testEnableSecretVersion() throws IOException {
    SecretVersionName name = SecretVersionName.parse(TEST_SECRET_VERSION_TO_ENABLE.getName());
    new EnableSecretVersion()
        .enableSecretVersion(name.getProject(), name.getSecret(), name.getSecretVersion());

    assertThat(stdOut.toString()).contains("Enabled secret version");
  }

  @Test
  public void testGetSecretVersion() throws IOException {
    SecretVersionName name = SecretVersionName.parse(TEST_SECRET_VERSION.getName());
    new GetSecretVersion()
        .getSecretVersion(name.getProject(), name.getSecret(), name.getSecretVersion());

    assertThat(stdOut.toString()).contains("Secret version");
    assertThat(stdOut.toString()).contains("state ENABLED");
  }

  @Test
  public void testGetSecret() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET.getName());
    new GetSecret().getSecret(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Secret");
    assertThat(stdOut.toString()).contains("replication AUTOMATIC");
  }

  @Test
  public void testIamGrantAccess() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET.getName());
    new IamGrantAccess().iamGrantAccess(name.getProject(), name.getSecret(), IAM_USER);

    assertThat(stdOut.toString()).contains("Updated IAM policy");
  }

  @Test
  public void testIamRevokeAccess() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET.getName());
    new IamRevokeAccess().iamRevokeAccess(name.getProject(), name.getSecret(), IAM_USER);

    assertThat(stdOut.toString()).contains("Updated IAM policy");
  }

  @Test
  public void testListSecretVersions() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET_WITH_VERSIONS.getName());
    new ListSecretVersions().listSecretVersions(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Secret version");
  }

  @Test
  public void testListSecrets() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET.getName());
    new ListSecrets().listSecrets(name.getProject());

    assertThat(stdOut.toString()).contains("Secret projects/");
    assertThat(stdOut.toString()).contains(name.getSecret());
  }

  @Test
  public void testUpdateSecret() throws IOException {
    SecretName name = SecretName.parse(TEST_SECRET.getName());
    new UpdateSecret().updateSecret(name.getProject(), name.getSecret());

    assertThat(stdOut.toString()).contains("Updated secret");
  }
}
