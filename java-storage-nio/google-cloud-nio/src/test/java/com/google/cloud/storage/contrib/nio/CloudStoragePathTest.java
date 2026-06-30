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

import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.common.collect.Iterables;
import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStoragePath}. */
@RunWith(JUnit4.class)
public class CloudStoragePathTest {
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
  public void testCreate_neverRemoveExtraSlashes() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("lol//cat").toString()).isEqualTo("lol//cat");
      assertThat((Object) fs.getPath("lol//cat")).isEqualTo(fs.getPath("lol//cat"));
    }
  }

  @Test
  public void testCreate_preservesTrailingSlash() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("lol/cat/").toString()).isEqualTo("lol/cat/");
      assertThat((Object) fs.getPath("lol/cat/")).isEqualTo(fs.getPath("lol/cat/"));
    }
  }

  @Test
  public void testGetGcsFilename_empty_notAllowed() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("").getBlobId();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isEqualTo("Object names cannot be empty.");
    }
  }

  @Test
  public void testGetGcsFilename_stripsPrefixSlash() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi").getBlobId().getName()).isEqualTo("hi");
    }
  }

  @Test
  public void testGetGcsFilename_overrideStripPrefixSlash_doesntStripPrefixSlash()
      throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", stripPrefixSlash(false))) {
      assertThat(fs.getPath("/hi").getBlobId().getName()).isEqualTo("/hi");
    }
  }

  @Test
  public void testGetGcsFilename_extraSlashes_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("a//b").getBlobId().getName();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testGetGcsFilename_overridepermitEmptyPathComponents() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("a//b").getBlobId().getName()).isEqualTo("a//b");
    }
  }

  @Test
  public void testGetGcsFilename_freaksOutOnExtraSlashesAndDotDirs() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("a//b/..").getBlobId().getName();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testNameCount() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("").getNameCount()).isEqualTo(1);
      assertThat(fs.getPath("/").getNameCount()).isEqualTo(0);
      assertThat(fs.getPath("/hi/").getNameCount()).isEqualTo(1);
      assertThat(fs.getPath("/hi/yo").getNameCount()).isEqualTo(2);
      assertThat(fs.getPath("hi/yo").getNameCount()).isEqualTo(2);
    }
  }

  @Test
  public void testGetName() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("").getName(0).toString()).isEqualTo("");
      assertThat(fs.getPath("/hi").getName(0).toString()).isEqualTo("hi");
      assertThat(fs.getPath("hi/there").getName(1).toString()).isEqualTo("there");
    }
  }

  @Test
  public void testGetName_negative_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("angel").getName(-1);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void testGetName_overflow_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("angel").getName(1);
      Assert.fail();
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test
  public void testIterator() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(Iterables.get(fs.getPath("/dog/mog"), 0).toString()).isEqualTo("dog");
      assertThat(Iterables.get(fs.getPath("/dog/mog"), 1).toString()).isEqualTo("mog");
      assertThat(Iterables.size(fs.getPath("/"))).isEqualTo(0);
      assertThat(Iterables.size(fs.getPath(""))).isEqualTo(1);
      assertThat(Iterables.get(fs.getPath(""), 0).toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/").normalize().toString()).isEqualTo("/");
      assertThat(fs.getPath("a/x/../b/x/..").normalize().toString()).isEqualTo("a/b/");
      assertThat(fs.getPath("/x/x/../../♡").normalize().toString()).isEqualTo("/♡");
      assertThat(fs.getPath("/x/x/./.././.././♡").normalize().toString()).isEqualTo("/♡");
    }
  }

  @Test
  public void testNormalize_dot_becomesBlank() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("").normalize().toString()).isEqualTo("");
      assertThat(fs.getPath(".").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_trailingSlash_isPreserved() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("o/").normalize().toString()).isEqualTo("o/");
    }
  }

  @Test
  public void testNormalize_doubleDot_becomesBlank() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("..").normalize().toString()).isEqualTo("");
      assertThat(fs.getPath("../..").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_extraSlashes_getRemoved() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("//life///b/good//").normalize().toString()).isEqualTo("/life/b/good/");
    }
  }

  @Test
  public void testToRealPath_hasDotDir_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("a/hi./b").toRealPath();
      fs.getPath("a/.hi/b").toRealPath();
      fs.getPath("a/./b").toRealPath();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testToRealPath_hasDotDotDir_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("a/hi../b").toRealPath();
      fs.getPath("a/..hi/b").toRealPath();
      fs.getPath("a/../b").toRealPath();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage())
          .contains("I/O not allowed on dot-dirs or extra slashes when !permitEmptyPathComponents");
    }
  }

  @Test
  public void testToRealPath_extraSlashes_throwsIae() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      fs.getPath("a//b").toRealPath();
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage())
          .contains("I/O not allowed on dot-dirs or extra slashes when !permitEmptyPathComponents");
    }
  }

  @Test
  public void testToRealPath_overridePermitEmptyPathComponents_extraSlashes_slashesRemain()
      throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("/life///b/./good/").toRealPath().toString())
          .isEqualTo("life///b/./good/");
    }
  }

  @Test
  public void testToRealPath_permitEmptyPathComponents_doesNotNormalize() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("a");
      assertThat(fs.getPath("a//b").toRealPath().toString()).isEqualTo("a//b");
      assertThat(fs.getPath("a//./b//..").toRealPath().toString()).isEqualTo("a//./b//..");
    }
  }

  @Test
  public void testToRealPath_withWorkingDirectory_makesAbsolute() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", workingDirectory("/lol"))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("lol/a");
    }
  }

  @Test
  public void testToRealPath_disableStripPrefixSlash_makesPathAbsolute() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", stripPrefixSlash(false))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("/a");
      assertThat(fs.getPath("/a").toRealPath().toString()).isEqualTo("/a");
    }
  }

  @Test
  public void testToRealPath_trailingSlash_getsPreserved() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("a/b/").toRealPath().toString()).isEqualTo("a/b/");
    }
  }

  @Test
  public void testNormalize_empty_returnsEmpty() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_preserveTrailingSlash() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("a/b/../c/").normalize().toString()).isEqualTo("a/c/");
      assertThat(fs.getPath("a/b/./c/").normalize().toString()).isEqualTo("a/b/c/");
    }
  }

  @Test
  public void testGetParent_preserveTrailingSlash() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("a/b/c").getParent().toString()).isEqualTo("a/b/");
      assertThat(fs.getPath("a/b/c/").getParent().toString()).isEqualTo("a/b/");
      assertThat((Object) fs.getPath("").getParent()).isNull();
      assertThat((Object) fs.getPath("/").getParent()).isNull();
      assertThat((Object) fs.getPath("aaa").getParent()).isNull();
      assertThat((Object) (fs.getPath("aaa/").getParent())).isNull();
    }
  }

  @Test
  public void testGetRoot() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hello").getRoot().toString()).isEqualTo("/");
      assertThat((Object) fs.getPath("hello").getRoot()).isNull();
    }
  }

  @Test
  public void testRelativize() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(
              fs.getPath("/foo/bar/lol/cat").relativize(fs.getPath("/foo/a/b/../../c")).toString())
          .isEqualTo("../../../a/b/../../c");
    }
  }

  @Test
  public void testRelativize_providerMismatch() throws IOException {
    try (CloudStorageFileSystem gcs = CloudStorageFileSystem.forBucket("doodle")) {
      gcs.getPath("/etc").relativize(FileSystems.getDefault().getPath("/dog"));
      Assert.fail();
    } catch (ProviderMismatchException ex) {
      assertThat(ex.getMessage()).contains("Not a Cloud Storage path");
    }
  }

  @Test
  @SuppressWarnings("ReturnValueIgnored") // testing that an Exception is thrown
  public void testRelativize_providerMismatch2() throws IOException {
    try (CloudStorageFileSystem gcs = CloudStorageFileSystem.forBucket("doodle")) {
      gcs.getPath("/dog").relativize(FileSystems.getDefault().getPath("/etc"));
      Assert.fail();
    } catch (ProviderMismatchException ex) {
      assertThat(ex.getMessage()).contains("Not a Cloud Storage path");
    }
  }

  @Test
  public void testResolve() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi").resolve("there").toString()).isEqualTo("/hi/there");
      assertThat(fs.getPath("hi").resolve("there").toString()).isEqualTo("hi/there");
    }
  }

  @Test
  public void testResolve_providerMismatch() throws IOException {
    try (CloudStorageFileSystem gcs = CloudStorageFileSystem.forBucket("doodle")) {
      gcs.getPath("etc").resolve(FileSystems.getDefault().getPath("/dog"));
      Assert.fail();
    } catch (ProviderMismatchException ex) {
      assertThat(ex.getMessage()).contains("Not a Cloud Storage path");
    }
  }

  @Test
  public void testIsAbsolute() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi").isAbsolute()).isTrue();
      assertThat(fs.getPath("hi").isAbsolute()).isFalse();
    }
  }

  @Test
  public void testToAbsolutePath() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat((Object) fs.getPath("/hi").toAbsolutePath()).isEqualTo(fs.getPath("/hi"));
      assertThat((Object) fs.getPath("hi").toAbsolutePath()).isEqualTo(fs.getPath("/hi"));
    }
  }

  @Test
  public void testToAbsolutePath_withWorkingDirectory() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", workingDirectory("/lol"))) {
      assertThat(fs.getPath("a").toAbsolutePath().toString()).isEqualTo("/lol/a");
    }
  }

  @Test
  public void testGetFileName() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").getFileName().toString()).isEqualTo("there");
      assertThat(fs.getPath("military/fashion/show").getFileName().toString()).isEqualTo("show");
    }
  }

  @Test
  public void testCompareTo() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/there"))).isEqualTo(0);
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/therf"))).isEqualTo(-1);
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/therd"))).isEqualTo(1);
    }
  }

  @Test
  public void testStartsWith() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("/hi/there"))).isTrue();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("/hi/therf"))).isFalse();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("/hi"))).isTrue();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("/hi/"))).isTrue();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("hi"))).isFalse();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath("/"))).isTrue();
      assertThat(fs.getPath("/hi/there").startsWith(fs.getPath(""))).isFalse();
    }
  }

  @Test
  public void testEndsWith() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath("there"))).isTrue();
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath("therf"))).isFalse();
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath("/blag/therf"))).isFalse();
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath("/hi/there"))).isTrue();
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath("/there"))).isFalse();
      assertThat(fs.getPath("/human/that/you/cry").endsWith(fs.getPath("that/you/cry"))).isTrue();
      assertThat(fs.getPath("/human/that/you/cry").endsWith(fs.getPath("that/you/cry/"))).isTrue();
      assertThat(fs.getPath("/hi/there/").endsWith(fs.getPath("/"))).isFalse();
      assertThat(fs.getPath("/hi/there").endsWith(fs.getPath(""))).isFalse();
      assertThat(fs.getPath("").endsWith(fs.getPath(""))).isTrue();
    }
  }

  @Test
  public void testResolve_willWorkWithRecursiveCopy() throws IOException {
    // See: http://stackoverflow.com/a/10068306
    try (FileSystem fsSource = FileSystems.getFileSystem(URI.create("gs://hello"));
        FileSystem fsTarget = FileSystems.getFileSystem(URI.create("gs://cat"))) {
      Path targetPath = fsTarget.getPath("/some/folder/");
      Path relSrcPath = fsSource.getPath("file.txt");
      assertThat((Object) targetPath.resolve(relSrcPath))
          .isEqualTo(fsTarget.getPath("/some/folder/file.txt"));
    }
  }

  @Test
  public void testRelativize_willWorkWithRecursiveCopy() throws IOException {
    // See: http://stackoverflow.com/a/10068306
    try (FileSystem fsSource = FileSystems.getFileSystem(URI.create("gs://hello"));
        FileSystem fsTarget = FileSystems.getFileSystem(URI.create("gs://cat"))) {
      Path targetPath = fsTarget.getPath("/some/folder/");
      Path sourcePath = fsSource.getPath("/sloth/");
      Path file = fsSource.getPath("/sloth/file.txt");
      assertThat((Object) targetPath.resolve(sourcePath.relativize(file)))
          .isEqualTo(fsTarget.getPath("/some/folder/file.txt"));
    }
  }

  @Test
  public void testToFile_unsupported() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      Path path = fs.getPath("/lol");
      path.toFile();
      Assert.fail();
    } catch (UnsupportedOperationException ex) {
      assertThat(ex.getMessage()).isEqualTo("GCS objects aren't available locally");
    }
  }

  @Test
  public void testEquals() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      new EqualsTester()
          // These are obviously equal.
          .addEqualityGroup(fs.getPath("/hello/cat"), fs.getPath("/hello/cat"))
          // These are equal because equals() runs things through toRealPath()
          .addEqualityGroup(fs.getPath("great/commandment"), fs.getPath("/great/commandment"))
          .addEqualityGroup(fs.getPath("great/commandment/"), fs.getPath("/great/commandment/"))
          // Equals shouldn't do error checking or normalization.
          .addEqualityGroup(fs.getPath("foo/../bar"), fs.getPath("foo/../bar"))
          .addEqualityGroup(fs.getPath("bar"))
          .testEquals();
    }
  }

  @Test
  public void testEquals_currentDirectoryIsTakenIntoConsideration() throws IOException {
    try (CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("doodle", workingDirectory("/hello"))) {
      new EqualsTester()
          .addEqualityGroup(fs.getPath("cat"), fs.getPath("/hello/cat"))
          .addEqualityGroup(fs.getPath(""), fs.getPath("/hello"))
          .testEquals();
    }
  }

  @Test
  public void testNullness() throws IOException, NoSuchMethodException, SecurityException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      NullPointerTester tester = new NullPointerTester();
      tester.ignore(CloudStoragePath.class.getMethod("equals", Object.class));
      tester.setDefault(Path.class, fs.getPath("sup"));
      tester.testAllPublicStaticMethods(CloudStoragePath.class);
      tester.testAllPublicInstanceMethods(fs.getPath("sup"));
    }
  }

  @Test
  public void testSpaces() throws IOException {
    try (CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("doodle")) {
      Path path = fs.getPath("/with/a space");
      // we can also go via a URI. Decoding should give us the space back.
      String toUri = URLDecoder.decode(path.toUri().toString(), "UTF-8");
      assertThat(toUri).isEqualTo("gs://doodle/with/a space");

      Path path2 = fs.getPath("/with/a%20percent");
      String toUri2 = URLDecoder.decode(path2.toUri().toString(), "UTF-8");
      assertThat(toUri2).isEqualTo("gs://doodle/with/a%20percent");
    }
  }

  private static CloudStorageConfiguration stripPrefixSlash(boolean value) {
    return CloudStorageConfiguration.builder().stripPrefixSlash(value).build();
  }

  private static CloudStorageConfiguration permitEmptyPathComponents(boolean value) {
    return CloudStorageConfiguration.builder().permitEmptyPathComponents(value).build();
  }

  private static CloudStorageConfiguration workingDirectory(String value) {
    return CloudStorageConfiguration.builder().workingDirectory(value).build();
  }
}
