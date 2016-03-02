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
import com.google.gcloud.storage.testing.LocalGcsHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Unit tests for {@link CloudStorageOptions}. */
@RunWith(JUnit4.class)
public class CloudStorageOptionsTest {

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setGCloudOptions(LocalGcsHelper.options());
  }

  @Test
  public void testWithoutCaching() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withoutCaching());
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("no-cache");
  }

  @Test
  public void testCacheControl() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withCacheControl("potato"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).cacheControl().get())
        .isEqualTo("potato");
  }

  @Test
  public void testWithAcl() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Acl acl = Acl.of(new Acl.User("king@example.com"), Acl.Role.OWNER);
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withAcl(acl));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).acl().get())
        .contains(acl);
  }

  @Test
  public void testWithContentDisposition() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withContentDisposition("bubbly fun"));
    assertThat(
        Files.readAttributes(path, CloudStorageFileAttributes.class).contentDisposition().get())
        .isEqualTo("bubbly fun");
  }

  @Test
  public void testWithContentEncoding() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withContentEncoding("gzip"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).contentEncoding().get())
        .isEqualTo("gzip");
  }

  @Test
  public void testWithUserMetadata() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withUserMetadata("nolo", "contendere"),
        withUserMetadata("eternal", "sadness"));
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class)
                .userMetadata().get("nolo"))
        .isEqualTo("contendere");
    assertThat(
            Files.readAttributes(path, CloudStorageFileAttributes.class)
                .userMetadata().get("eternal"))
        .isEqualTo("sadness");
  }

  @Test
  public void testWithMimeType_string() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withMimeType("text/plain"));
    assertThat(Files.readAttributes(path, CloudStorageFileAttributes.class).mimeType().get())
        .isEqualTo("text/plain");
  }

  @Test
  public void testNullness() throws Exception {
    NullPointerTester tester = new NullPointerTester();
    tester.testAllPublicStaticMethods(CloudStorageOptions.class);
  }
}
