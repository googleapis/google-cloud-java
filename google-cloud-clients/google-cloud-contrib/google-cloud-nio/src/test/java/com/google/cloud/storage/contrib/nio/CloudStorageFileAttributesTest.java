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
import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageFileAttributes}. */
@RunWith(JUnit4.class)
public class CloudStorageFileAttributesTest {

  private static final byte[] HAPPY = "(✿◕ ‿◕ )ノ".getBytes(UTF_8);

  private Path path;
  private Path dir;

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
    path = Paths.get(URI.create("gs://bucket/randompath"));
    dir = Paths.get(URI.create("gs://bucket/randompath/"));
  }

  @Test
  public void testCacheControl() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withCacheControl("potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("potato");
  }

  @Test
  public void testMimeType() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withMimeType("text/potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
        .isEqualTo("text/potato");
  }

  @Test
  public void testAcl() throws IOException {
    Acl acl = Acl.of(new Acl.User("serf@example.com"), Acl.Role.READER);
    Files.write(path, HAPPY, CloudStorageOptions.withAcl(acl));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
        .contains(acl);
  }

  @Test
  public void testContentDisposition() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withContentDisposition("crash call"));
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class).contentDisposition().get())
        .isEqualTo("crash call");
  }

  @Test
  public void testContentEncoding() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withContentEncoding("my content encoding"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
        .isEqualTo("my content encoding");
  }

  @Test
  public void testUserMetadata() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withUserMetadata("green", "bean"));
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class)
                .userMetadata()
                .get("green"))
        .isEqualTo("bean");
  }

  @Test
  public void testIsDirectory() throws IOException {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isDirectory())
        .isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isDirectory()).isTrue();
  }

  @Test
  public void testIsRegularFile() throws IOException {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isRegularFile())
        .isTrue();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isRegularFile())
        .isFalse();
  }

  @Test
  public void testIsOther() throws IOException {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isOther()).isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isOther()).isFalse();
  }

  @Test
  public void testIsSymbolicLink() throws IOException {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isSymbolicLink())
        .isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isSymbolicLink())
        .isFalse();
  }

  @Test
  public void testEquals_equalsTester() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withMimeType("text/plain"));
    CloudStorageFileAttributes a1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes a2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    Files.write(path, HAPPY, CloudStorageOptions.withMimeType("text/potato"));
    CloudStorageFileAttributes b1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes b2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    new EqualsTester().addEqualityGroup(a1, a2).addEqualityGroup(b1, b2).testEquals();
  }

  @Test
  public void testFilekey() throws IOException {
    Files.write(path, HAPPY, CloudStorageOptions.withMimeType("text/plain"));
    Path path2 = Paths.get(URI.create("gs://bucket/anotherrandompath"));
    Files.write(path2, HAPPY, CloudStorageOptions.withMimeType("text/plain"));

    // diff files cannot have same filekey
    CloudStorageFileAttributes a1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes a2 = Files.readAttributes(path2, CloudStorageFileAttributes.class);
    assertThat(a1.fileKey()).isNotEqualTo(a2.fileKey());

    // same for directories
    CloudStorageFileAttributes b1 = Files.readAttributes(dir, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes b2 =
        Files.readAttributes(
            Paths.get(URI.create("gs://bucket/jacket/")), CloudStorageFileAttributes.class);
    assertThat(a1.fileKey()).isNotEqualTo(b1.fileKey());
    assertThat(b1.fileKey()).isNotEqualTo(b2.fileKey());
  }

  @Test
  public void testNullness() throws IOException, NoSuchMethodException, SecurityException {
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
