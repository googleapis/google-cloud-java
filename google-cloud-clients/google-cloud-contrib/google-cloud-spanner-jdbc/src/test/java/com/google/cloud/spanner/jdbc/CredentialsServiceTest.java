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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.rpc.Code;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for reading and parsing key files and getting service accounts. The key files that are used
 * for this test class contain random private keys generated with the following command: <code>
 * openssl genpkey -out rsakey.pem -algorithm RSA -pkeyopt rsa_keygen_bits:2048</code> These keys
 * are not in use for anything else except these test classes.
 */
@RunWith(JUnit4.class)
public class CredentialsServiceTest {
  static final String FILE_TEST_PATH =
      CredentialsServiceTest.class.getResource("test-key.json").getFile();
  static final String CLOUD_FILE_TEST_PATH =
      CredentialsServiceTest.class.getResource("test-key-cloud-storage.json").getFile();
  static final String GS_TEST_PATH = "gs://test-bucket/test-key-cloud-storage.json";
  static final String GS_INVALID_TEST_PATH = "gs://test-bucket/non-existing-key.json";

  private final CredentialsService service =
      new CredentialsService() {
        @Override
        protected Storage internalCreateStorage() {
          Storage storage = mock(Storage.class);
          when(storage.get("test-bucket", "test-key-cloud-storage.json"))
              .thenReturn(mock(Blob.class));
          when(storage.get("test-bucket", "non-existing-key.json"))
              .thenThrow(new StorageException(Code.NOT_FOUND_VALUE, "Unknown blob"));
          return storage;
        }

        @Override
        protected InputStream internalCreateInputStream(Blob blob) {
          try {
            return new FileInputStream(CLOUD_FILE_TEST_PATH);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        }
      };

  @Test
  public void testCreateCredentials_UseDefault_NoDefaultSet() throws IOException {
    Credentials defaultCredentials = null;
    try {
      defaultCredentials = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      // ignore
    }
    Credentials credentials = null;
    try {
      credentials = service.createCredentials(null);
    } catch (Exception e) {
      // ignore
    }
    assertThat(credentials, is(equalTo(defaultCredentials)));
  }

  @Test
  public void testCreateCredentials_UseDefault_WithDefaultSet() throws Exception {
    injectEnvironmentVariable("GOOGLE_APPLICATION_CREDENTIALS", FILE_TEST_PATH);
    try {
      Credentials defaultCredentials = GoogleCredentials.getApplicationDefault();
      Credentials credentials = service.createCredentials(null);
      assertThat(credentials, is(notNullValue()));
      assertThat(credentials, is(equalTo(defaultCredentials)));
    } finally {
      injectEnvironmentVariable("GOOGLE_APPLICATION_CREDENTIALS", null);
    }
  }

  @Test
  public void testCreateCredentialsFile() throws IOException {
    Credentials credentialsFromFile = service.internalGetCredentialsFromLocalFile(FILE_TEST_PATH);
    Credentials credentials = service.createCredentials(FILE_TEST_PATH);
    assertThat(credentials, is(equalTo(credentialsFromFile)));
  }

  @Test
  public void testCreateCredentialsCloudStorage() throws IOException {
    Credentials expectedCredentials =
        service.internalGetCredentialsFromLocalFile(CLOUD_FILE_TEST_PATH);
    Credentials credentials = service.createCredentials(GS_TEST_PATH);
    assertThat(credentials, is(equalTo(expectedCredentials)));
  }

  @Test(expected = SpannerException.class)
  public void testCreateCredentialsInvalidFile() {
    service.createCredentials("invalid_file_path.json");
  }

  @Test(expected = SpannerException.class)
  public void testCreateCredentialsInvalidCloudStorage() {
    service.createCredentials(GS_INVALID_TEST_PATH);
  }

  @Test
  public void testGetCredentialsFromFile() throws IOException {
    GoogleCredentials credentials = service.internalGetCredentialsFromLocalFile(FILE_TEST_PATH);
    assertThat(credentials, is(notNullValue()));
  }

  @Test
  public void testGetCredentialsFromCloudStorage() throws IOException {
    GoogleCredentials expectedCredentials =
        service.internalGetCredentialsFromLocalFile(CLOUD_FILE_TEST_PATH);
    assertThat(
        service.internalGetCredentialsFromCloudStorage(GS_TEST_PATH),
        is(equalTo(expectedCredentials)));
  }

  @Test
  public void testGetBlob() {
    assertThat(service.internalGetBlob("gs://test-bucket/test-blob"), is(equalTo("test-blob")));
    assertThat(service.internalGetBlob("gs://test-bucket/blob-test"), is(equalTo("blob-test")));
  }

  @Test
  public void testGetBucket() {
    assertThat(service.internalGetBucket("gs://test-bucket/test-blob"), is(equalTo("test-bucket")));
    assertThat(service.internalGetBucket("gs://bucket-test/blob-test"), is(equalTo("bucket-test")));
  }

  @SuppressWarnings("unchecked")
  private static void injectEnvironmentVariable(String key, String value) throws Exception {
    Class<?> processEnvironment = Class.forName("java.lang.ProcessEnvironment");
    Field unmodifiableMapField =
        getAccessibleField(processEnvironment, "theUnmodifiableEnvironment");
    Object unmodifiableMap = unmodifiableMapField.get(null);
    injectIntoUnmodifiableMap(key, value, unmodifiableMap);

    Field mapField = getAccessibleField(processEnvironment, "theEnvironment");
    Map<String, String> map = (Map<String, String>) mapField.get(null);
    map.put(key, value);
  }

  private static Field getAccessibleField(Class<?> clazz, String fieldName)
      throws NoSuchFieldException {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return field;
  }

  @SuppressWarnings("unchecked")
  private static void injectIntoUnmodifiableMap(String key, String value, Object map)
      throws ReflectiveOperationException {
    Class<?> unmodifiableMap = Class.forName("java.util.Collections$UnmodifiableMap");
    Field field = getAccessibleField(unmodifiableMap, "m");
    Object obj = field.get(map);
    if (value == null) {
      ((Map<String, String>) obj).remove(key);
    } else {
      ((Map<String, String>) obj).put(key, value);
    }
  }
}
