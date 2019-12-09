/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for reading and parsing test key files and getting service accounts. */
@RunWith(JUnit4.class)
public class CredentialsServiceTest {
  private static final String FILE_TEST_PATH =
      CredentialsServiceTest.class.getResource("test-key.json").getFile();
  private static final String APP_DEFAULT_FILE_TEST_PATH =
      CredentialsServiceTest.class.getResource("test-key-app-default.json").getFile();

  private static final String TEST_PROJECT_ID = "test-project";
  private static final String APP_DEFAULT_PROJECT_ID = "app-default-test-project";

  private final CredentialsService service =
      new CredentialsService() {

        @Override
        GoogleCredentials internalGetApplicationDefault() throws IOException {
          // Read application default credentials directly from a specific file instead of actually
          // fetching the default from the environment.
          return GoogleCredentials.fromStream(new FileInputStream(APP_DEFAULT_FILE_TEST_PATH));
        }
      };

  @Test
  public void testCreateCredentialsDefault() throws Exception {
    ServiceAccountCredentials credentials =
        (ServiceAccountCredentials) service.createCredentials(null);
    assertThat(credentials.getProjectId(), is(equalTo(APP_DEFAULT_PROJECT_ID)));
  }

  @Test
  public void testCreateCredentialsFile() throws IOException {
    ServiceAccountCredentials credentials =
        (ServiceAccountCredentials) service.createCredentials(FILE_TEST_PATH);
    assertThat(credentials.getProjectId(), is(equalTo(TEST_PROJECT_ID)));
  }

  @Test(expected = SpannerException.class)
  public void testCreateCredentialsInvalidFile() {
    service.createCredentials("invalid_file_path.json");
  }

  @Test
  public void testCreateCredentialsInvalidCloudStorage() {
    try {
      service.createCredentials("gs://test-bucket/test-blob");
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.INVALID_ARGUMENT)));
      assertThat(e.getCause().getMessage(), is(equalTo(CredentialsService.GCS_NOT_SUPPORTED_MSG)));
    }
  }
}
