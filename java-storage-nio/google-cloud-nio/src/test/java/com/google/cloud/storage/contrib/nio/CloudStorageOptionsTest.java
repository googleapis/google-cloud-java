/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.common.testing.NullPointerTester;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageOptions}. */
@RunWith(JUnit4.class)
public class CloudStorageOptionsTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
  }

  @After
  public void after() {
    CloudStorageFileSystemProvider.setStorageOptions(StorageOptionsUtil.getDefaultInstance());
  }

  @Test
  public void testWithoutCaching() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), CloudStorageOptions.withoutCaching());
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("no-cache");
  }

  @Test
  public void testCacheControl() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), CloudStorageOptions.withCacheControl("potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("potato");
  }

  @Test
  public void testWithAcl() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Acl acl = Acl.of(new Acl.User("king@example.com"), Acl.Role.OWNER);
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), CloudStorageOptions.withAcl(acl));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
        .contains(acl);
  }

  @Test
  public void testWithContentDisposition() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(
        path,
        "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        CloudStorageOptions.withContentDisposition("bubbly fun"));
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class).contentDisposition().get())
        .isEqualTo("bubbly fun");
  }

  @Test
  public void testWithContentEncoding() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), CloudStorageOptions.withContentEncoding("gzip"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
        .isEqualTo("gzip");
  }

  @Test
  public void testWithUserMetadata() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(
        path,
        "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        CloudStorageOptions.withUserMetadata("nolo", "contendere"),
        CloudStorageOptions.withUserMetadata("eternal", "sadness"));
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class).userMetadata().get("nolo"))
        .isEqualTo("contendere");
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class)
                .userMetadata()
                .get("eternal"))
        .isEqualTo("sadness");
  }

  @Test
  public void testWithMimeType_string() throws IOException {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), CloudStorageOptions.withMimeType("text/plain"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
        .isEqualTo("text/plain");
  }

  @Test
  public void testNullness() {
    NullPointerTester tester = new NullPointerTester();
    tester.testAllPublicStaticMethods(CloudStorageOptions.class);
  }
}
