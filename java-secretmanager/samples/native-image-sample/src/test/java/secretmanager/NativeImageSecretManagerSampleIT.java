/*
 * Copyright 2022 Google LLC
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

package secretmanager;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ServiceOptions;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretVersion;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class NativeImageSecretManagerSampleIT {

  private static final String NATIVE_TEST_SECRET_ID = "native-test-secret" + UUID.randomUUID();
  private static String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private ByteArrayOutputStream bout;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @AfterClass
  public static void afterAll() throws Exception {
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {

      // Delete the secret created by quickstart
      SecretName name = SecretName.of(PROJECT_ID, NATIVE_TEST_SECRET_ID);
      DeleteSecretRequest deleteRequest =
          DeleteSecretRequest.newBuilder().setName(name.toString()).build();

      client.deleteSecret(deleteRequest);
    }
  }

  @Test
  public void testCreateAndPrintSecret() throws IOException {
    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
      NativeImageSecretManagerSample.createSecret(client, PROJECT_ID, NATIVE_TEST_SECRET_ID);
      SecretVersion version =
          NativeImageSecretManagerSample.addSecretVersion(
              client, PROJECT_ID, NATIVE_TEST_SECRET_ID);
      NativeImageSecretManagerSample.printSecretVersion(client, version);
      assertThat(bout.toString()).contains("Reading secret value: Hello World");
    }
  }
}
