package com.google.gcloud.storage.contrib.nio;

import static com.google.appengine.tools.cloudstorage.GcsServiceFactory.createGcsService;
import static com.google.common.truth.Truth.assertThat;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withAcl;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withCacheControl;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withContentDisposition;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withContentEncoding;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withMimeType;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withUserMetadata;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withoutCaching;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.common.testing.NullPointerTester;

import org.junit.Rule;
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

  @Rule
  public final AppEngineRule appEngineRule = new AppEngineRule();

  @Test
  public void testWithoutCaching() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withoutCaching());
    assertThat(getMetadata("bucket", "path").getOptions().getCacheControl()).isEqualTo("no-cache");
  }

  @Test
  public void testCacheControl() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withCacheControl("potato"));
    assertThat(getMetadata("bucket", "path").getOptions().getCacheControl()).isEqualTo("potato");
  }

  @Test
  public void testWithAcl() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withAcl("mine empire of dirt"));
    assertThat(getMetadata("bucket", "path").getOptions().getAcl())
        .isEqualTo("mine empire of dirt");
  }

  @Test
  public void testWithContentDisposition() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withContentDisposition("bubbly fun"));
    assertThat(getMetadata("bucket", "path").getOptions().getContentDisposition())
        .isEqualTo("bubbly fun");
  }

  @Test
  public void testWithContentEncoding() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withContentEncoding("gzip"));
    assertThat(getMetadata("bucket", "path").getOptions().getContentEncoding()).isEqualTo("gzip");
  }

  @Test
  public void testWithUserMetadata() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withUserMetadata("nolo", "contendere"),
        withUserMetadata("eternal", "sadness"));
    GcsFileMetadata metadata = getMetadata("bucket", "path");
    assertThat(metadata.getOptions().getUserMetadata().get("nolo")).isEqualTo("contendere");
    assertThat(metadata.getOptions().getUserMetadata().get("eternal")).isEqualTo("sadness");
  }

  @Test
  public void testWithMimeType_string() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/path"));
    Files.write(path, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withMimeType("text/plain"));
    assertThat(getMetadata("bucket", "path").getOptions().getMimeType()).isEqualTo("text/plain");
  }

  private static GcsFileMetadata getMetadata(String bucket, String objectName) throws Exception {
    return createGcsService().getMetadata(new GcsFilename(bucket, objectName));
  }

  @Test
  public void testNullness() throws Exception {
    NullPointerTester tester = new NullPointerTester();
    tester.testAllPublicStaticMethods(CloudStorageOptions.class);
  }
}
