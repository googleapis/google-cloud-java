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

import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.common.base.Strings;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link Quickstart}. */
@RunWith(JUnit4.class)
public class QuickstartIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String SECRET_ID = "java-quickstart-" + UUID.randomUUID().toString();

  @BeforeClass
  public static void beforeAll() throws Exception {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));
  }

  @AfterClass
  public static void afterAll() throws Exception {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));

    try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {

      // Delete the secret created by quickstart
      SecretName name = SecretName.of(PROJECT_ID, SECRET_ID);
      DeleteSecretRequest deleteRequest =
          DeleteSecretRequest.newBuilder().setName(name.toString()).build();

      client.deleteSecret(deleteRequest);
    }
  }

  @Test
  public void quickstart_test() throws Exception {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream redirected = new ByteArrayOutputStream();

    System.setOut(new PrintStream(redirected));

    try {
      new Quickstart().quickstart(PROJECT_ID, SECRET_ID);
      assertThat(redirected.toString()).contains("Plaintext: hello world!");
    } finally {
      System.setOut(originalOut);
    }
  }
}
