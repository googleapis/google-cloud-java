/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import com.google.auth.Credentials;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AccessTokenFileCredentialsTest {

  @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

  @Before
  public void setUp() {
    WorkerProxy.serviceKeyFile = "";
    WorkerProxy.accessTokenFile = "";
  }

  @After
  public void tearDown() {
    WorkerProxy.serviceKeyFile = "";
    WorkerProxy.accessTokenFile = "";
  }

  @Test
  public void getRequestMetadata_readsAndTrimsBearerTokenFromFile() throws IOException {
    File tokenFile = tempFolder.newFile("access_token");
    FileUtils.writeStringToFile(tokenFile, "  test-token-123 \n", StandardCharsets.UTF_8);
    AccessTokenFileCredentials credentials = new AccessTokenFileCredentials(tokenFile);

    Map<String, List<String>> metadata = credentials.getRequestMetadata(null);

    Assert.assertEquals(
        Collections.singletonList("Bearer test-token-123"), metadata.get("Authorization"));
  }

  @Test
  public void getRequestMetadata_cachesWhileFreshAndUpdatesOnExplicitRefresh() throws IOException {
    File tokenFile = tempFolder.newFile("access_token");
    FileUtils.writeStringToFile(tokenFile, "token-v1\n", StandardCharsets.UTF_8);
    AccessTokenFileCredentials credentials = new AccessTokenFileCredentials(tokenFile);

    Assert.assertEquals(
        Collections.singletonList("Bearer token-v1"),
        credentials.getRequestMetadata(null).get("Authorization"));

    FileUtils.writeStringToFile(tokenFile, "token-v2\n", StandardCharsets.UTF_8);
    Assert.assertEquals(
        Collections.singletonList("Bearer token-v1"),
        credentials.getRequestMetadata(null).get("Authorization"));

    credentials.refresh();
    Assert.assertEquals(
        Collections.singletonList("Bearer token-v2"),
        credentials.getRequestMetadata(null).get("Authorization"));
  }

  @Test
  public void getRequestMetadata_automaticallyReReadsAtomicallyRotatedFileWhenExpired()
      throws IOException {
    File tokenFile = tempFolder.newFile("access_token");
    FileUtils.writeStringToFile(tokenFile, "token-v1\n", StandardCharsets.UTF_8);
    AccessTokenFileCredentials credentials =
        new AccessTokenFileCredentials(tokenFile, Duration.ZERO, Duration.ZERO, Duration.ZERO);

    Assert.assertEquals(
        Collections.singletonList("Bearer token-v1"),
        credentials.getRequestMetadata(null).get("Authorization"));

    File stagedTokenFile = tempFolder.newFile("access_token.tmp");
    FileUtils.writeStringToFile(stagedTokenFile, "token-v2\n", StandardCharsets.UTF_8);
    Files.move(stagedTokenFile.toPath(), tokenFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    Assert.assertEquals(
        Collections.singletonList("Bearer token-v2"),
        credentials.getRequestMetadata(null).get("Authorization"));
  }

  @Test
  public void refresh_throwsIOExceptionForInvalidTokenFiles() throws IOException {
    File missingFile = new File(tempFolder.getRoot(), "does_not_exist");
    AccessTokenFileCredentials missingCredentials = new AccessTokenFileCredentials(missingFile);
    try {
      missingCredentials.refresh();
      Assert.fail("Expected IOException for missing token file");
    } catch (IOException expected) {
      // Expected.
    }

    File directory = tempFolder.newFolder("token_dir");
    AccessTokenFileCredentials dirCredentials = new AccessTokenFileCredentials(directory);
    try {
      dirCredentials.refresh();
      Assert.fail("Expected IOException for directory token path");
    } catch (IOException expected) {
      // Expected.
    }

    File emptyFile = tempFolder.newFile("empty_token");
    FileUtils.writeStringToFile(emptyFile, "   \n", StandardCharsets.UTF_8);
    AccessTokenFileCredentials emptyCredentials = new AccessTokenFileCredentials(emptyFile);
    try {
      emptyCredentials.refresh();
      Assert.fail("Expected IOException for empty token file");
    } catch (IOException expected) {
      // Expected.
    }
  }

  @Test
  public void workerProxyBuildOptions_parsesAccessTokenFileAndRejectsBothCredentialFlags() {
    CommandLine parsed =
        WorkerProxy.buildOptions(
            new String[] {
              "--spanner_port", "1234",
              "--proxy_port", "5678",
              "--cert", "/tmp/cert.pem",
              "--access_token_file", "/files/auth/access_token"
            });
    Assert.assertEquals(
        "/files/auth/access_token", parsed.getOptionValue(WorkerProxy.OPTION_ACCESS_TOKEN_FILE));

    try {
      WorkerProxy.buildOptions(
          new String[] {
            "--service_key_file", "/files/key.json",
            "--access_token_file", "/files/auth/access_token"
          });
      Assert.fail("Expected IllegalArgumentException when both credential flags are provided");
    } catch (IllegalArgumentException expected) {
      // Expected.
    }
  }

  @Test
  public void workerProxyGetCredentialsFromFlags_resolvesExpectedCredentials() throws IOException {
    Assert.assertNull(WorkerProxy.getCredentialsFromFlags());

    WorkerProxy.serviceKeyFile = new File(tempFolder.getRoot(), "missing.json").getPath();
    Assert.assertNull(WorkerProxy.getCredentialsFromFlags());
    WorkerProxy.serviceKeyFile = "";

    File tokenFile = tempFolder.newFile("access_token");
    FileUtils.writeStringToFile(tokenFile, "proxy-token\n", StandardCharsets.UTF_8);
    WorkerProxy.accessTokenFile = tokenFile.getPath();

    Credentials credentials = WorkerProxy.getCredentialsFromFlags();
    Assert.assertNotNull(credentials);
    Assert.assertEquals(
        Collections.singletonList("Bearer proxy-token"),
        credentials.getRequestMetadata(null).get("Authorization"));

    WorkerProxy.serviceKeyFile = "/files/key.json";
    try {
      WorkerProxy.getCredentialsFromFlags();
      Assert.fail("Expected IllegalArgumentException when both credential fields are non-empty");
    } catch (IllegalArgumentException expected) {
      // Expected.
    }
  }
}
