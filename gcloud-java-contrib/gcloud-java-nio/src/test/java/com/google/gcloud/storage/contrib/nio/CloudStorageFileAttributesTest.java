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
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.testing.EqualsTester;
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
 * Unit tests for {@link CloudStorageFileAttributes}.
 */
@RunWith(JUnit4.class)
public class CloudStorageFileAttributesTest {

  private static final byte[] HAPPY = "(✿◕ ‿◕ )ノ".getBytes(UTF_8);

  private final FakeStorageRpc storage = new FakeStorageRpc(true);
  private final NioTestHelper helper = new NioTestHelper(storage);

  @Test
  public void testCacheControl() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withCacheControl("potato"));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
          .isEqualTo("potato");
    }
  }

  @Test
  public void testMimeType() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withMimeType("text/potato"));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
          .isEqualTo("text/potato");
    }
  }

  @Test
  public void testAcl() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Acl acl = Acl.of(new Acl.User("serf@example.com"), Acl.Role.READER);
      Files.write(path, HAPPY, withAcl(acl));
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
          .contains(acl);
    }
  }

  @Test
  public void testContentDisposition() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withContentDisposition("crash call"));
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class)
                  .contentDisposition()
                  .get())
          .isEqualTo("crash call");
    }
  }

  @Test
  public void testContentEncoding() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withContentEncoding("my content encoding"));
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
          .isEqualTo("my content encoding");
    }
  }

  @Test
  public void testUserMetadata() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withUserMetadata("green", "bean"));
      assertThat(
              Files.readAttributes(path, CloudStorageFileAttributes.class)
                  .userMetadata()
                  .get("green"))
          .isEqualTo("bean");
    }
  }

  @Test
  public void testIsDirectory() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Path dir = fs.getPath("/rum/");
      Files.write(path, HAPPY);
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isDirectory())
          .isFalse();
      assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isDirectory())
          .isTrue();
    }
  }

  @Test
  public void testIsRegularFile() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Path dir = fs.getPath("/rum/");
      Files.write(path, HAPPY);
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isRegularFile())
          .isTrue();
      assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isRegularFile())
          .isFalse();
    }
  }

  @Test
  public void testIsOther() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Path dir = fs.getPath("/rum/");
      Files.write(path, HAPPY);
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isOther()).isFalse();
      assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isOther()).isFalse();
    }
  }

  @Test
  public void testIsSymbolicLink() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Path dir = fs.getPath("/rum/");
      Files.write(path, HAPPY);
      assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isSymbolicLink())
          .isFalse();
      assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isSymbolicLink())
          .isFalse();
    }
  }

  @Test
  public void testEquals_equalsTester() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withMimeType("text/plain"));
      CloudStorageFileAttributes a1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
      CloudStorageFileAttributes a2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
      Files.write(path, HAPPY, withMimeType("text/potato"));
      CloudStorageFileAttributes b1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
      CloudStorageFileAttributes b2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
      new EqualsTester().addEqualityGroup(a1, a2).addEqualityGroup(b1, b2).testEquals();
    }
  }

  @Test
  public void testFilekey() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path dir = fs.getPath("/rum/");
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withMimeType("text/plain"));
      Path path2 = fs.getPath("/anotherrandompath");
      Files.write(path2, HAPPY, withMimeType("text/plain"));

      // diff files cannot have same filekey
      CloudStorageFileAttributes a1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
      CloudStorageFileAttributes a2 = Files.readAttributes(path2, CloudStorageFileAttributes.class);
      assertThat(a1.fileKey()).isNotEqualTo(a2.fileKey());

      // same for directories
      CloudStorageFileAttributes b1 = Files.readAttributes(dir, CloudStorageFileAttributes.class);
      CloudStorageFileAttributes b2 =
          Files.readAttributes(fs.getPath("/jacket/"), CloudStorageFileAttributes.class);
      assertThat(a1.fileKey()).isNotEqualTo(b1.fileKey());
      assertThat(b1.fileKey()).isNotEqualTo(b2.fileKey());
    }
  }

  @Test
  public void testNullness() throws IOException, NoSuchMethodException, SecurityException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Path dir = fs.getPath("/rum/");
      Files.write(path, HAPPY);
      CloudStorageFileAttributes pathAttributes =
          Files.readAttributes(path, CloudStorageFileAttributes.class);
      CloudStorageFileAttributes dirAttributes =
          Files.readAttributes(dir, CloudStorageFileAttributes.class);
      NullPointerTester tester = new NullPointerTester();
      tester.ignore(CloudStorageObjectAttributes.class.getMethod("equals", Object.class));
      tester.testAllPublicInstanceMethods(pathAttributes);
      tester.testAllPublicInstanceMethods(dirAttributes);
    }
  }
}
