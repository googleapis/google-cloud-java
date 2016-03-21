/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withAcl;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withCacheControl;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withContentDisposition;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withContentEncoding;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withMimeType;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withUserMetadata;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withoutCaching;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.testing.NullPointerTester;
import com.google.gcloud.storage.Acl;
import com.google.gcloud.storage.testing.FakeStorageRpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Unit tests for {@link CloudStorageOptions}.
 */
@RunWith(JUnit4.class)
public class CloudStorageOptionsTest {

  private final FakeStorageRpc storage = new FakeStorageRpc(true);
  private final NioTestHelper helper = new NioTestHelper(storage);

  @Test
  public void testWithoutCaching() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withoutCaching());
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
          .isEqualTo("no-cache");
    }
  }

  @Test
  public void testCacheControl() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withCacheControl("potato"));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
          .isEqualTo("potato");
    }
  }

  @Test
  public void testWithAcl() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Acl acl = Acl.of(new Acl.User("king@example.com"), Acl.Role.OWNER);
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withAcl(acl));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
          .contains(acl);
    }
  }

  @Test
  public void testWithContentDisposition() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withContentDisposition("bubbly fun"));
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class).contentDisposition().get())
          .isEqualTo("bubbly fun");
    }
  }

  @Test
  public void testWithContentEncoding() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withContentEncoding("gzip"));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
          .isEqualTo("gzip");
    }
  }

  @Test
  public void testWithUserMetadata() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(
          path,
          "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
          withUserMetadata("nolo", "contendere"),
          withUserMetadata("eternal", "sadness"));
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class).userMetadata().get("nolo"))
          .isEqualTo("contendere");
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class)
                  .userMetadata()
                  .get("eternal"))
          .isEqualTo("sadness");
    }
  }

  @Test
  public void testWithMimeType_string() throws IOException {
    try (FileSystem fs = helper.forBucket("bucket")) {
      Path path = fs.getPath("/path");
      Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8), withMimeType("text/plain"));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
          .isEqualTo("text/plain");
    }
  }

  @Test
  public void testNullness() {
    NullPointerTester tester = new NullPointerTester();
    tester.testAllPublicStaticMethods(CloudStorageOptions.class);
  }
}
