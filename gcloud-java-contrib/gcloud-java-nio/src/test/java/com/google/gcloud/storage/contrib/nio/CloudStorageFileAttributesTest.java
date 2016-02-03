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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Unit tests for {@link CloudStorageFileAttributes}. */
@RunWith(JUnit4.class)
public class CloudStorageFileAttributesTest {

  private static final byte[] HAPPY = "(✿◕ ‿◕ )ノ".getBytes(UTF_8);

  @Rule
  public final AppEngineRule appEngineRule = new AppEngineRule();

  private Path path;
  private Path dir;

  @Before
  public void before() throws Exception {
    path = Paths.get(URI.create("gs://bucket/randompath"));
    dir = Paths.get(URI.create("gs://bucket/randompath/"));
  }

  @Test
  public void testCacheControl() throws Exception {
    Files.write(path, HAPPY, withCacheControl("potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("potato");
  }

  @Test
  public void testMimeType() throws Exception {
    Files.write(path, HAPPY, withMimeType("text/potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
        .isEqualTo("text/potato");
  }

  @Test
  public void testAcl() throws Exception {
    Files.write(path, HAPPY, withAcl("potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
        .isEqualTo("potato");
  }

  @Test
  public void testContentDisposition() throws Exception {
    Files.write(path, HAPPY, withContentDisposition("crash call"));
    assertThat(
        Files.readAttributes(path, CloudStorageFileAttributes.class).contentDisposition().get())
            .isEqualTo("crash call");
  }

  @Test
  public void testContentEncoding() throws Exception {
    Files.write(path, HAPPY, withContentEncoding("my content encoding"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
        .isEqualTo("my content encoding");
  }

  @Test
  public void testUserMetadata() throws Exception {
    Files.write(path, HAPPY, withUserMetadata("green", "bean"));
    assertThat(
        Files.readAttributes(path, CloudStorageFileAttributes.class).userMetadata().get("green"))
            .isEqualTo("bean");
  }

  @Test
  public void testIsDirectory() throws Exception {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isDirectory())
        .isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isDirectory()).isTrue();
  }

  @Test
  public void testIsRegularFile() throws Exception {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isRegularFile())
        .isTrue();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isRegularFile())
        .isFalse();
  }

  @Test
  public void testIsOther() throws Exception {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isOther()).isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isOther()).isFalse();
  }

  @Test
  public void testIsSymbolicLink() throws Exception {
    Files.write(path, HAPPY);
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).isSymbolicLink())
        .isFalse();
    assertThat(Files.readAttributes(dir, CloudStorageFileAttributes.class).isSymbolicLink())
        .isFalse();
  }

  @Test
  public void testEquals_equalsTester() throws Exception {
    Files.write(path, HAPPY, withMimeType("text/plain"));
    CloudStorageFileAttributes a1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes a2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    Files.write(path, HAPPY, withMimeType("text/potato"));
    CloudStorageFileAttributes b1 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes b2 = Files.readAttributes(path, CloudStorageFileAttributes.class);
    new EqualsTester().addEqualityGroup(a1, a2).addEqualityGroup(b1, b2).testEquals();
  }

  @Test
  public void testNullness() throws Exception {
    Files.write(path, HAPPY);
    CloudStorageFileAttributes pathAttributes =
        Files.readAttributes(path, CloudStorageFileAttributes.class);
    CloudStorageFileAttributes dirAttributes =
        Files.readAttributes(dir, CloudStorageFileAttributes.class);
    NullPointerTester tester = new NullPointerTester();
    tester.testAllPublicInstanceMethods(pathAttributes);
    tester.testAllPublicInstanceMethods(dirAttributes);
  }
}
