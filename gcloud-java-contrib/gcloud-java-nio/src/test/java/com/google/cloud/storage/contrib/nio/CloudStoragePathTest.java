package com.google.cloud.storage.contrib.nio;

import static com.google.cloud.storage.contrib.nio.CloudStorageFileSystem.forBucket;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.testing.LocalGcsHelper;
import com.google.common.collect.Iterables;
import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderMismatchException;

/** Unit tests for {@link CloudStoragePath}. */
@RunWith(JUnit4.class)
public class CloudStoragePathTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setGCloudOptions(LocalGcsHelper.options());
  }

  @Test
  public void testCreate_neverRemoveExtraSlashes() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("lol//cat").toString()).isEqualTo("lol//cat");
      assertThat((Object) fs.getPath("lol//cat")).isEqualTo(fs.getPath("lol//cat"));
    }
  }

  @Test
  public void testCreate_preservesTrailingSlash() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("lol/cat/").toString()).isEqualTo("lol/cat/");
      assertThat((Object) fs.getPath("lol/cat/")).isEqualTo(fs.getPath("lol/cat/"));
    }
  }

  @Test
  public void testGetGcsFilename_empty_notAllowed() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      fs.getPath("").getBlobId();
    }
  }

  @Test
  public void testGetGcsFilename_stripsPrefixSlash() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hi").getBlobId().name()).isEqualTo("hi");
    }
  }

  @Test
  public void testGetGcsFilename_overrideStripPrefixSlash_doesntStripPrefixSlash() {
    try (CloudStorageFileSystem fs = forBucket("doodle", stripPrefixSlash(false))) {
      assertThat(fs.getPath("/hi").getBlobId().name()).isEqualTo("/hi");
    }
  }

  @Test
  public void testGetGcsFilename_extraSlashes_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      fs.getPath("a//b").getBlobId().name();
    }
  }

  @Test
  public void testGetGcsFilename_overridepermitEmptyPathComponents() {
    try (CloudStorageFileSystem fs = forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("a//b").getBlobId().name()).isEqualTo("a//b");
    }
  }

  @Test
  public void testGetGcsFilename_freaksOutOnExtraSlashesAndDotDirs() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      fs.getPath("a//b/..").getBlobId().name();
    }
  }

  @Test
  public void testNameCount() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("").getNameCount()).isEqualTo(1);
      assertThat(fs.getPath("/").getNameCount()).isEqualTo(0);
      assertThat(fs.getPath("/hi/").getNameCount()).isEqualTo(1);
      assertThat(fs.getPath("/hi/yo").getNameCount()).isEqualTo(2);
      assertThat(fs.getPath("hi/yo").getNameCount()).isEqualTo(2);
    }
  }

  @Test
  public void testGetName() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("").getName(0).toString()).isEqualTo("");
      assertThat(fs.getPath("/hi").getName(0).toString()).isEqualTo("hi");
      assertThat(fs.getPath("hi/there").getName(1).toString()).isEqualTo("there");
    }
  }

  @Test
  public void testGetName_negative_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      fs.getPath("angel").getName(-1);
    }
  }

  @Test
  public void testGetName_overflow_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      fs.getPath("angel").getName(1);
    }
  }

  @Test
  public void testIterator() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(Iterables.get(fs.getPath("/dog/mog"), 0).toString()).isEqualTo("dog");
      assertThat(Iterables.get(fs.getPath("/dog/mog"), 1).toString()).isEqualTo("mog");
      assertThat(Iterables.size(fs.getPath("/"))).isEqualTo(0);
      assertThat(Iterables.size(fs.getPath(""))).isEqualTo(1);
      assertThat(Iterables.get(fs.getPath(""), 0).toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/").normalize().toString()).isEqualTo("/");
      assertThat(fs.getPath("a/x/../b/x/..").normalize().toString()).isEqualTo("a/b/");
      assertThat(fs.getPath("/x/x/../../♡").normalize().toString()).isEqualTo("/♡");
      assertThat(fs.getPath("/x/x/./.././.././♡").normalize().toString()).isEqualTo("/♡");
    }
  }

  @Test
  public void testNormalize_dot_becomesBlank() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("").normalize().toString()).isEqualTo("");
      assertThat(fs.getPath(".").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_trailingSlash_isPreserved() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("o/").normalize().toString()).isEqualTo("o/");
    }
  }

  @Test
  public void testNormalize_doubleDot_becomesBlank() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("..").normalize().toString()).isEqualTo("");
      assertThat(fs.getPath("../..").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_extraSlashes_getRemoved() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("//life///b/good//").normalize().toString()).isEqualTo("/life/b/good/");
    }
  }

  @Test
  public void testToRealPath_hasDotDir_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      fs.getPath("a/hi./b").toRealPath();
      fs.getPath("a/.hi/b").toRealPath();
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage("dot-dir");
      fs.getPath("a/./b").toRealPath();
    }
  }

  @Test
  public void testToRealPath_hasDotDotDir_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      fs.getPath("a/hi../b").toRealPath();
      fs.getPath("a/..hi/b").toRealPath();
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage("dot-dir");
      fs.getPath("a/../b").toRealPath();
    }
  }

  @Test
  public void testToRealPath_extraSlashes_throwsIae() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(IllegalArgumentException.class);
      thrown.expectMessage("extra slashes");
      fs.getPath("a//b").toRealPath();
    }
  }

  @Test
  public void testToRealPath_overridePermitEmptyPathComponents_extraSlashes_slashesRemain() {
    try (CloudStorageFileSystem fs = forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("/life///b/./good/").toRealPath().toString())
          .isEqualTo("life///b/./good/");
    }
  }

  @Test
  public void testToRealPath_permitEmptyPathComponents_doesNotNormalize() {
    try (CloudStorageFileSystem fs = forBucket("doodle", permitEmptyPathComponents(true))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("a");
      assertThat(fs.getPath("a//b").toRealPath().toString()).isEqualTo("a//b");
      assertThat(fs.getPath("a//./b//..").toRealPath().toString()).isEqualTo("a//./b//..");
    }
  }

  @Test
  public void testToRealPath_withWorkingDirectory_makesAbsolute() {
    try (CloudStorageFileSystem fs = forBucket("doodle", workingDirectory("/lol"))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("lol/a");
    }
  }

  @Test
  public void testToRealPath_disableStripPrefixSlash_makesPathAbsolute() {
    try (CloudStorageFileSystem fs = forBucket("doodle", stripPrefixSlash(false))) {
      assertThat(fs.getPath("a").toRealPath().toString()).isEqualTo("/a");
      assertThat(fs.getPath("/a").toRealPath().toString()).isEqualTo("/a");
    }
  }

  @Test
  public void testToRealPath_trailingSlash_getsPreserved() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("a/b/").toRealPath().toString()).isEqualTo("a/b/");
    }
  }

  @Test
  public void testNormalize_empty_returnsEmpty() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("").normalize().toString()).isEqualTo("");
    }
  }

  @Test
  public void testNormalize_preserveTrailingSlash() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("a/b/../c/").normalize().toString()).isEqualTo("a/c/");
      assertThat(fs.getPath("a/b/./c/").normalize().toString()).isEqualTo("a/b/c/");
    }
  }

  @Test
  @SuppressWarnings("null")
  public void testGetParent_preserveTrailingSlash() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("a/b/c").getParent().toString()).isEqualTo("a/b/");
      assertThat(fs.getPath("a/b/c/").getParent().toString()).isEqualTo("a/b/");
      assertThat((Object) fs.getPath("").getParent()).isNull();
      assertThat((Object) fs.getPath("/").getParent()).isNull();
      assertThat((Object) fs.getPath("aaa").getParent()).isNull();
      assertThat((Object) (fs.getPath("aaa/").getParent())).isNull();
    }
  }

  @Test
  @SuppressWarnings("null")
  public void testGetRoot() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hello").getRoot().toString()).isEqualTo("/");
      assertThat((Object) fs.getPath("hello").getRoot()).isNull();
    }
  }

  @Test
  public void testRelativize() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/foo/bar/lol/cat")
          .relativize(fs.getPath("/foo/a/b/../../c")).toString())
              .isEqualTo("../../../a/b/../../c");
    }
  }

  @Test
  public void testRelativize_providerMismatch() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(ProviderMismatchException.class);
      fs.getPath("/etc").relativize(Paths.get("/dog"));
    }
  }

  @Test
  @SuppressWarnings("ReturnValueIgnored")   // testing that an Exception is thrown
  public void testRelativize_providerMismatch2() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(ProviderMismatchException.class);
      Paths.get("/dog").relativize(fs.getPath("/etc"));
    }
  }

  @Test
  public void testResolve() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hi").resolve("there").toString()).isEqualTo("/hi/there");
      assertThat(fs.getPath("hi").resolve("there").toString()).isEqualTo("hi/there");
    }
  }

  @Test
  public void testResolve_providerMismatch() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      thrown.expect(ProviderMismatchException.class);
      fs.getPath("etc").resolve(Paths.get("/dog"));
    }
  }

  @Test
  public void testIsAbsolute() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hi").isAbsolute()).isTrue();
      assertThat(fs.getPath("hi").isAbsolute()).isFalse();
    }
  }

  @Test
  public void testToAbsolutePath() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat((Object) fs.getPath("/hi").toAbsolutePath()).isEqualTo(fs.getPath("/hi"));
      assertThat((Object) fs.getPath("hi").toAbsolutePath()).isEqualTo(fs.getPath("/hi"));
    }
  }

  @Test
  public void testToAbsolutePath_withWorkingDirectory() {
    try (CloudStorageFileSystem fs = forBucket("doodle", workingDirectory("/lol"))) {
      assertThat(fs.getPath("a").toAbsolutePath().toString()).isEqualTo("/lol/a");
    }
  }

  @Test
  @SuppressWarnings("null")
  public void testGetFileName() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").getFileName().toString()).isEqualTo("there");
      assertThat(fs.getPath("military/fashion/show").getFileName().toString()).isEqualTo("show");
    }
  }

  @Test
  public void testCompareTo() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/there"))).isEqualTo(0);
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/therf"))).isEqualTo(-1);
      assertThat(fs.getPath("/hi/there").compareTo(fs.getPath("/hi/therd"))).isEqualTo(1);
    }
  }

  @Test
  public void testStartsWith() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
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
  public void testEndsWith() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
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

  /** @see "http://stackoverflow.com/a/10068306".
   */
  @Test
  public void testResolve_willWorkWithRecursiveCopy() throws Exception {
    try (FileSystem fsSource = FileSystems.getFileSystem(URI.create("gs://hello"));
        FileSystem fsTarget = FileSystems.getFileSystem(URI.create("gs://cat"))) {
      Path targetPath = fsTarget.getPath("/some/folder/");
      Path relSrcPath = fsSource.getPath("file.txt");
      assertThat((Object) targetPath.resolve(relSrcPath))
          .isEqualTo(fsTarget.getPath("/some/folder/file.txt"));
    }
  }

  /** @see "http://stackoverflow.com/a/10068306".
   */
  @Test
  public void testRelativize_willWorkWithRecursiveCopy() throws Exception {
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
  public void testToFile_unsupported() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      Path path = fs.getPath("/lol");
      thrown.expect(UnsupportedOperationException.class);
      path.toFile();
    }
  }

  @Test
  public void testEquals() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
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
  public void testEquals_currentDirectoryIsTakenIntoConsideration() {
    try (CloudStorageFileSystem fs = forBucket("doodle", workingDirectory("/hello"))) {
      new EqualsTester()
          .addEqualityGroup(fs.getPath("cat"), fs.getPath("/hello/cat"))
          .addEqualityGroup(fs.getPath(""), fs.getPath("/hello"))
          .testEquals();
    }
  }

  @Test
  public void testNullness() {
    try (CloudStorageFileSystem fs = forBucket("doodle")) {
      NullPointerTester tester = new NullPointerTester()
          .setDefault(Path.class, fs.getPath("sup"));
      tester.testAllPublicStaticMethods(CloudStoragePath.class);
      tester.testAllPublicInstanceMethods(fs.getPath("sup"));
    }
  }

  private static CloudStorageConfiguration stripPrefixSlash(boolean value) {
    return CloudStorageConfiguration.builder()
        .stripPrefixSlash(value)
        .build();
  }

  private static CloudStorageConfiguration permitEmptyPathComponents(boolean value) {
    return CloudStorageConfiguration.builder()
        .permitEmptyPathComponents(value)
        .build();
  }

  private static CloudStorageConfiguration workingDirectory(String value) {
    return CloudStorageConfiguration.builder()
        .workingDirectory(value)
        .build();
  }
}
