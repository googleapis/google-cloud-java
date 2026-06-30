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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import com.google.api.gax.rpc.internal.QuotaProjectIdHidingCredentials;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageFileSystem}. */
@RunWith(JUnit4.class)
public class CloudStorageFileSystemTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  private static final String ALONE =
      "To be, or not to be, that is the question—\n"
          + "Whether 'tis Nobler in the mind to suffer\n"
          + "The Slings and Arrows of outrageous Fortune,\n"
          + "Or to take Arms against a Sea of troubles,\n"
          + "And by opposing, end them? To die, to sleep—\n"
          + "No more; and by a sleep, to say we end\n"
          + "The Heart-ache, and the thousand Natural shocks\n"
          + "That Flesh is heir to? 'Tis a consummation\n";

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
  }

  @After
  public void after() {
    CloudStorageFileSystemProvider.setStorageOptions(StorageOptionsUtil.getDefaultInstance());
  }

  @Test
  public void checkDefaultOptions() throws IOException {
    // 1. We get the normal default if we don't do anything special.
    Path path = Paths.get(URI.create("gs://bucket/file"));
    CloudStorageFileSystem gcs = (CloudStorageFileSystem) path.getFileSystem();
    assertThat(gcs.config().maxChannelReopens()).isEqualTo(0);

    // 2(a). Override the default, and see it reflected.
    CloudStorageFileSystemProvider.setDefaultCloudStorageConfiguration(
        CloudStorageConfiguration.builder().maxChannelReopens(123).build());
    Path path2 = Paths.get(URI.create("gs://newbucket/file"));
    CloudStorageFileSystem gcs2 = (CloudStorageFileSystem) path2.getFileSystem();
    assertThat(gcs2.config().maxChannelReopens()).isEqualTo(123);

    // 2(b) ...even reflected if we try to open a file.
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      CloudStorageFileSystem csfs = (CloudStorageFileSystem) fs;
      assertThat(csfs.config().maxChannelReopens()).isEqualTo(123);
      Files.write(fs.getPath("/angel"), ALONE.getBytes(UTF_8));
      path2 = Paths.get(URI.create("gs://bucket/angel"));
      try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(path2)) {
        CloudStorageReadChannel cloudChannel = (CloudStorageReadChannel) seekableByteChannel;
        assertThat(cloudChannel.maxChannelReopens).isEqualTo(123);
      }
    }

    // 4. Clean up.
    CloudStorageFileSystemProvider.setDefaultCloudStorageConfiguration(null);
    Path path3 = Paths.get(URI.create("gs://newbucket/file"));
    CloudStorageFileSystem gcs3 = (CloudStorageFileSystem) path3.getFileSystem();
    assertThat(gcs3.config().maxChannelReopens()).isEqualTo(0);
  }

  @Test
  public void canOverrideDefaultOptions() throws IOException {
    // Set a new default.
    CloudStorageFileSystemProvider.setDefaultCloudStorageConfiguration(
        CloudStorageConfiguration.builder().maxChannelReopens(123).build());

    // This code wants its own value.
    try (FileSystem fs =
        CloudStorageFileSystem.forBucket(
            "bucket", CloudStorageConfiguration.builder().maxChannelReopens(7).build())) {
      CloudStorageFileSystem csfs = (CloudStorageFileSystem) fs;
      assertThat(csfs.config().maxChannelReopens()).isEqualTo(7);
    }

    // Clean up.
    CloudStorageFileSystemProvider.setDefaultCloudStorageConfiguration(null);
  }

  @Test
  public void testGetPath() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      assertThat(fs.getPath("/angel").toString()).isEqualTo("/angel");
      assertThat(fs.getPath("/angel").toUri().toString()).isEqualTo("gs://bucket/angel");
    }
  }

  @Test
  public void testGetHost_valid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket-with-host")) {
      assertThat(fs.getPath("/angel").toUri().getHost()).isEqualTo("bucket-with-host");
    }
  }

  @Test
  public void testGetHost_invalid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket_with_authority")) {
      assertThat(fs.getPath("/angel").toUri().getHost()).isNull();
    }
  }

  @Test
  public void testGetAuthority_valid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket-with-host")) {
      assertThat(fs.getPath("/angel").toUri().getAuthority()).isEqualTo("bucket-with-host");
    }
  }

  @Test
  public void testGetAuthority_invalid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket_with_authority")) {
      assertThat(fs.getPath("/angel").toUri().getAuthority()).isEqualTo("bucket_with_authority");
    }
  }

  @Test
  public void testToString_valid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket-with-host")) {
      assertThat(fs.toString()).isEqualTo("gs://bucket-with-host");
    }
  }

  @Test
  public void testToString_invalid_dns() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket_with_authority")) {
      assertThat(fs.toString()).isEqualTo("gs://bucket_with_authority");
    }
  }

  @Test
  public void testWrite() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      Files.write(fs.getPath("/angel"), ALONE.getBytes(UTF_8));
    }
    assertThat(new String(Files.readAllBytes(Paths.get(URI.create("gs://bucket/angel"))), UTF_8))
        .isEqualTo(ALONE);
  }

  @Test
  public void testRead() throws IOException {
    Files.write(Paths.get(URI.create("gs://bucket/angel")), ALONE.getBytes(UTF_8));
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      assertThat(new String(Files.readAllBytes(fs.getPath("/angel")), UTF_8)).isEqualTo(ALONE);
    }
  }

  @Test
  public void testExists_false() throws IOException {
    try (FileSystem fs = FileSystems.getFileSystem(URI.create("gs://bucket"))) {
      assertThat(Files.exists(fs.getPath("/angel"))).isFalse();
    }
  }

  @Test
  public void testExists_true() throws IOException {
    Files.write(Paths.get(URI.create("gs://bucket/angel")), ALONE.getBytes(UTF_8));
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      assertThat(Files.exists(fs.getPath("/angel"))).isTrue();
    }
  }

  @Test
  public void testGetters() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      assertThat(fs.isOpen()).isTrue();
      assertThat(fs.isReadOnly()).isFalse();
      assertThat(fs.getRootDirectories()).containsExactly(fs.getPath("/"));
      assertThat(fs.getFileStores()).isEmpty();
      assertThat(fs.getSeparator()).isEqualTo("/");
      assertThat(fs.supportedFileAttributeViews()).containsExactly("basic", "gcs", "posix");
    }
  }

  @Test
  public void testEquals() throws IOException {
    try (FileSystem bucket1 = CloudStorageFileSystem.forBucket("bucket");
        FileSystem bucket2 = FileSystems.getFileSystem(URI.create("gs://bucket"));
        FileSystem doge1 = CloudStorageFileSystem.forBucket("doge");
        FileSystem doge2 = FileSystems.getFileSystem(URI.create("gs://doge"))) {
      new EqualsTester()
          .addEqualityGroup(bucket1, bucket2)
          .addEqualityGroup(doge1, doge2)
          .testEquals();
    }
  }

  @Test
  public void testNullness() throws IOException, NoSuchMethodException, SecurityException {
    try (FileSystem fs = FileSystems.getFileSystem(URI.create("gs://bucket"))) {
      NullPointerTester tester =
          new NullPointerTester()
              .ignore(CloudStorageFileSystem.class.getMethod("equals", Object.class))
              .setDefault(CloudStorageConfiguration.class, CloudStorageConfiguration.DEFAULT)
              .setDefault(StorageOptions.class, LocalStorageHelper.getOptions());
      tester.testAllPublicStaticMethods(CloudStorageFileSystem.class);
      tester.testAllPublicInstanceMethods(fs);
    }
  }

  @Test
  public void testListFiles() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      List<Path> goodPaths = new ArrayList<>();
      List<Path> paths = new ArrayList<>();
      goodPaths.add(fs.getPath("dir/angel"));
      goodPaths.add(fs.getPath("dir/alone"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("atroot"));
      paths.addAll(goodPaths);
      goodPaths.add(fs.getPath("dir/dir2/"));
      for (Path path : paths) {
        Files.write(path, ALONE.getBytes(UTF_8));
      }

      List<Path> got = new ArrayList<>();
      for (Path path : Files.newDirectoryStream(fs.getPath("/dir/"))) {
        got.add(path);
      }
      assertThat(got).containsExactlyElementsIn(goodPaths);

      // Must also work with relative path
      got.clear();
      for (Path path : Files.newDirectoryStream(fs.getPath("dir/"))) {
        got.add(path);
      }
      assertThat(got).containsExactlyElementsIn(goodPaths);
    }
  }

  @Test
  public void testMatcher() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      String pattern1 = "glob:*.java";
      PathMatcher javaFileMatcher = fs.getPathMatcher(pattern1);
      assertMatches(fs, javaFileMatcher, "a.java", true);
      assertMatches(fs, javaFileMatcher, "a.text", false);
      assertMatches(fs, javaFileMatcher, "folder/c.java", true);
      assertMatches(fs, javaFileMatcher, "d", false);

      String pattern2 = "glob:*.{java,text}";
      PathMatcher javaAndTextFileMatcher = fs.getPathMatcher(pattern2);
      assertMatches(fs, javaAndTextFileMatcher, "a.java", true);
      assertMatches(fs, javaAndTextFileMatcher, "a.text", true);
      assertMatches(fs, javaAndTextFileMatcher, "folder/c.java", true);
      assertMatches(fs, javaAndTextFileMatcher, "d", false);
    }
  }

  @Test
  public void testDeleteEmptyFolder() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("dir/angel"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("atroot"));
      for (Path path : paths) {
        Files.write(path, ALONE.getBytes(UTF_8));
      }
      // we can delete non-existent folders, because they are not represented on disk anyways.
      Files.delete(fs.getPath("ghost/"));
      Files.delete(fs.getPath("dir/ghost/"));
      Files.delete(fs.getPath("dir/dir2/ghost/"));
      // likewise, deleteIfExists works.
      Files.deleteIfExists(fs.getPath("ghost/"));
      Files.deleteIfExists(fs.getPath("dir/ghost/"));
      Files.deleteIfExists(fs.getPath("dir/dir2/ghost/"));
    }
  }

  @Test
  public void testDeleteFullFolder() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      Files.write(fs.getPath("dir/angel"), ALONE.getBytes(UTF_8));
      // we cannot delete existing folders if they contain something
      Files.delete(fs.getPath("dir/"));
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage())
          .isEqualTo("Can't perform I/O on pseudo-directories (trailing slash): dir/");
    }
  }

  @Test
  public void testDelete() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("dir/angel"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("atroot"));
      for (Path path : paths) {
        Files.write(path, ALONE.getBytes(UTF_8));
      }
      Files.delete(fs.getPath("atroot"));
      Files.delete(fs.getPath("dir/angel"));
      Files.deleteIfExists(fs.getPath("dir/dir2/another_angel"));

      for (Path path : paths) {
        assertThat(Files.exists(path)).isFalse();
      }
    }
  }

  @Test
  public void testDeleteEmptiedFolder() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("dir/angel"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      for (Path path : paths) {
        Files.write(path, ALONE.getBytes(UTF_8));
      }
      Files.delete(fs.getPath("dir/angel"));
      Files.deleteIfExists(fs.getPath("dir/dir2/another_angel"));
      // delete folder (trailing slash is required)
      Path dir2 = fs.getPath("dir/dir2/");
      Files.deleteIfExists(dir2);
      Path dir = fs.getPath("dir/");
      Files.deleteIfExists(dir);
      // We can't check Files.exists on a folder (since GCS fakes folders)
    }
  }

  @Test
  public void testDeleteRecursive() throws IOException {
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("atroot"));
      paths.add(fs.getPath("dir/angel"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("dir/dir2/angel3"));
      paths.add(fs.getPath("dir/dir3/cloud"));
      for (Path path : paths) {
        Files.write(path, ALONE.getBytes(UTF_8));
      }

      deleteRecursive(fs.getPath("dir/"));
      assertThat(Files.exists(fs.getPath("dir/angel"))).isFalse();
      assertThat(Files.exists(fs.getPath("dir/dir3/cloud"))).isFalse();
      assertThat(Files.exists(fs.getPath("atroot"))).isTrue();
    }
  }

  @Test
  public void testSameProvider() throws IOException {
    try (CloudStorageFileSystem sourceFileSystem =
        CloudStorageFileSystem.forBucket(
            "bucket",
            CloudStorageConfiguration.builder().permitEmptyPathComponents(true).build())) {
      CloudStorageFileSystem destFileSystem =
          CloudStorageFileSystem.forBucket(
              "new-bucket",
              CloudStorageConfiguration.builder().permitEmptyPathComponents(true).build());
      assertSame(sourceFileSystem.provider(), destFileSystem.provider());
      assertEquals(sourceFileSystem.config(), destFileSystem.config());
      assertEquals("bucket", sourceFileSystem.bucket());
      assertEquals("new-bucket", destFileSystem.bucket());
    }
  }

  @Test
  public void testDifferentProvider() throws IOException {
    try (CloudStorageFileSystem sourceFileSystem =
        CloudStorageFileSystem.forBucket(
            "bucket",
            CloudStorageConfiguration.builder().permitEmptyPathComponents(true).build())) {
      CloudStorageFileSystem destFileSystem =
          CloudStorageFileSystem.forBucket(
              "new-bucket",
              CloudStorageConfiguration.builder().permitEmptyPathComponents(false).build());
      assertNotSame(sourceFileSystem.provider(), destFileSystem.provider());
      assertNotEquals(sourceFileSystem.config(), destFileSystem.config());
      assertEquals("bucket", sourceFileSystem.bucket());
      assertEquals("new-bucket", destFileSystem.bucket());
    }
  }

  // port of test from
  // https://github.com/broadinstitute/cromwell/pull/6491/files#diff-758dbbe823e71cc26fee7bc89cd5c434dfb76e604d51005b8327db59aab96068R300-R336
  @Test
  public void ensureMultipleInstancesDoNotCorruptCredentials() throws Exception {

    CloudStorageConfiguration config =
        CloudStorageConfiguration.builder()
            .permitEmptyPathComponents(true)
            .stripPrefixSlash(true)
            .usePseudoDirectories(true)
            .build();

    Credentials noCredentials = NoCredentials.getInstance();
    Credentials saCredentials = new QuotaProjectIdHidingCredentials(noCredentials);

    StorageOptions noOptions =
        StorageOptions.newBuilder()
            .setProjectId("public-project")
            .setCredentials(noCredentials)
            .build();

    StorageOptions saOptions =
        StorageOptions.newBuilder()
            .setProjectId("private-project")
            .setCredentials(saCredentials)
            .build();

    CloudStorageFileSystem noFs =
        CloudStorageFileSystem.forBucket("public-bucket", config, noOptions);
    CloudStorageFileSystem saFs =
        CloudStorageFileSystem.forBucket("private-bucket", config, saOptions);

    CloudStoragePath noPath = noFs.getPath("public-file");
    CloudStoragePath saPath = saFs.getPath("private-file");

    assertThat(credentialsForPath(noPath)).isEqualTo(noCredentials);
    assertThat(credentialsForPath(saPath)).isEqualTo(saCredentials);
  }

  /**
   * Delete the given directory and all of its contents if non-empty.
   *
   * @param directory the directory to delete
   * @throws IOException
   */
  private static void deleteRecursive(Path directory) throws IOException {
    Files.walkFileTree(
        directory,
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            Files.delete(file);
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
          }
        });
  }

  private void assertMatches(FileSystem fs, PathMatcher matcher, String toMatch, boolean expected) {
    assertThat(matcher.matches(fs.getPath(toMatch).getFileName())).isEqualTo(expected);
  }

  private static Credentials credentialsForPath(Path p)
      throws NoSuchFieldException, IllegalAccessException {
    CloudStorageFileSystemProvider cloudFilesystemProvider =
        (CloudStorageFileSystemProvider) p.getFileSystem().provider();
    Field storageOptionsField =
        cloudFilesystemProvider.getClass().getDeclaredField("storageOptions");
    storageOptionsField.setAccessible(true);
    StorageOptions storageOptions =
        (StorageOptions) storageOptionsField.get(cloudFilesystemProvider);
    Field credentialsField = ServiceOptions.class.getDeclaredField("credentials");
    credentialsField.setAccessible(true);
    return (Credentials) credentialsField.get(storageOptions);
  }
}
