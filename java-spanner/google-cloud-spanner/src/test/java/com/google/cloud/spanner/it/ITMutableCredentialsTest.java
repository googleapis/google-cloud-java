/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.it;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.MutableCredentials;
import com.google.cloud.spanner.SerialIntegrationTest;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.spanner.admin.instance.v1.ProjectName;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(SerialIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITMutableCredentialsTest {

  private static final String INVALID_CERT_PATH =
      "/com/google/cloud/spanner/connection/test-key.json";

  @ClassRule public static final IntegrationTestEnv env = new IntegrationTestEnv();

  @Test
  public void testMutableCredentialsUpdateAuthorizationForRunningClient() throws IOException {
    GoogleCredentials validCredentials = null;

    // accept cert path overridden by environment variable for local testing
    if (System.getenv("GOOGLE_ACCOUNT_CREDENTIALS") != null) {
      try (InputStream stream =
          Files.newInputStream(Paths.get(System.getenv("GOOGLE_ACCOUNT_CREDENTIALS")))) {
        validCredentials = GoogleCredentials.fromStream(stream);
      }
    } else {
      try {
        validCredentials = GoogleCredentials.getApplicationDefault();
      } catch (IOException e) {
      }
    }

    // credentials must be ServiceAccountCredentials
    assumeTrue(validCredentials instanceof ServiceAccountCredentials);

    ServiceAccountCredentials invalidCredentials;
    try (InputStream stream =
        ITMutableCredentialsTest.class.getResourceAsStream(INVALID_CERT_PATH)) {
      invalidCredentials = ServiceAccountCredentials.fromStream(stream);
    }

    // create MutableCredentials first with valid credentials
    MutableCredentials mutableCredentials =
        new MutableCredentials((ServiceAccountCredentials) validCredentials);

    SpannerOptions options =
        env.getTestHelper().getOptions().toBuilder()
            // this setting is required in the scenario SPANNER_EMULATOR_HOST is set otherwise
            // SpannerOptions overrides credentials to NoCredentials
            .setEmulatorHost(null)
            .setCredentials(mutableCredentials)
            .build();

    ProjectName projectName = ProjectName.of(options.getProjectId());
    try (Spanner spanner = options.getService();
        InstanceAdminClient instanceAdminClient = spanner.createInstanceAdminClient()) {
      instanceAdminClient.listInstances(projectName);

      // update mutableCredentials now to use an invalid credentials
      mutableCredentials.updateCredentials(invalidCredentials);

      try {
        // this call should now fail with new invalid credentials
        instanceAdminClient.listInstances(projectName);
        fail("Expected UNAUTHENTICATED after switching to invalid credentials");
      } catch (Exception e) {
        assertTrue(e.getMessage().contains("UNAUTHENTICATED"));
      }
    }
  }
}
