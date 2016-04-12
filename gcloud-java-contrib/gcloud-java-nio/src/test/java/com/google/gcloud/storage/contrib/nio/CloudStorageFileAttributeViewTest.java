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
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withCacheControl;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;
import com.google.gcloud.storage.testing.FakeStorageRpc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

/**
 * Unit tests for {@link CloudStorageFileAttributeView}.
 */
@RunWith(JUnit4.class)
public class CloudStorageFileAttributeViewTest {

  private static final byte[] HAPPY = "(✿◕ ‿◕ )ノ".getBytes(UTF_8);

  @Rule public final ExpectedException thrown = ExpectedException.none();

  private final FakeStorageRpc storage = new FakeStorageRpc(true);
  private final NioTestHelper helper = new NioTestHelper(storage);

  @Test
  public void testReadAttributes() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withCacheControl("potato"));
      CloudStorageFileAttributeView lazyAttributes =
          Files.getFileAttributeView(path, CloudStorageFileAttributeView.class);
      assertThat(lazyAttributes.readAttributes().cacheControl().get()).isEqualTo("potato");
    }
  }

  @Test
  public void testReadAttributes_notFound_throwsNoSuchFileException() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      CloudStorageFileAttributeView lazyAttributes =
          Files.getFileAttributeView(path, CloudStorageFileAttributeView.class);
      thrown.expect(NoSuchFileException.class);
      lazyAttributes.readAttributes();
    }
  }

  @Test
  public void testReadAttributes_pseudoDirectory() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path dir = fs.getPath("/rum/");
      CloudStorageFileAttributeView lazyAttributes =
          Files.getFileAttributeView(dir, CloudStorageFileAttributeView.class);
      assertThat(lazyAttributes.readAttributes())
          .isInstanceOf(CloudStoragePseudoDirectoryAttributes.class);
    }
  }

  @Test
  public void testName() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      Files.write(path, HAPPY, withCacheControl("potato"));
      CloudStorageFileAttributeView lazyAttributes =
          Files.getFileAttributeView(path, CloudStorageFileAttributeView.class);
      assertThat(lazyAttributes.name()).isEqualTo("gcs");
    }
  }

  @Test
  public void testEquals_equalsTester() throws IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      new EqualsTester()
          .addEqualityGroup(
              Files.getFileAttributeView(fs.getPath("/rum"), CloudStorageFileAttributeView.class),
              Files.getFileAttributeView(fs.getPath("/rum"), CloudStorageFileAttributeView.class))
          .addEqualityGroup(
              Files.getFileAttributeView(
                  fs.getPath("/lol/dog"), CloudStorageFileAttributeView.class))
          .testEquals();
    }
  }

  @Test
  public void testNullness() throws NoSuchMethodException, SecurityException, IOException {
    try (FileSystem fs = helper.forBucket("red")) {
      Path path = fs.getPath("/water");
      new NullPointerTester()
          .ignore(CloudStorageFileAttributeView.class.getMethod("equals", Object.class))
          .setDefault(FileTime.class, FileTime.fromMillis(0))
          .testAllPublicInstanceMethods(
              Files.getFileAttributeView(path, CloudStorageFileAttributeView.class));
    }
  }
}
