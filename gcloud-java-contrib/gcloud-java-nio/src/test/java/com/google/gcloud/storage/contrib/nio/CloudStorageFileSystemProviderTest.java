package com.google.gcloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static com.google.gcloud.storage.contrib.nio.CloudStorageFileSystem.forBucket;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withCacheControl;
import static com.google.gcloud.storage.contrib.nio.CloudStorageOptions.withMimeType;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import static org.junit.Assume.assumeTrue;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.testing.NullPointerTester;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

/** Unit tests for {@link CloudStorageFileSystemProvider}. */
@RunWith(JUnit4.class)
public class CloudStorageFileSystemProviderTest {

  private static final List<String> FILE_CONTENTS = ImmutableList.of(
      "To be, or not to be, that is the question—",
      "Whether 'tis Nobler in the mind to suffer",
      "The Slings and Arrows of outrageous Fortune,",
      "Or to take Arms against a Sea of troubles,",
      "And by opposing, end them? To die, to sleep—",
      "No more; and by a sleep, to say we end",
      "The Heart-ache, and the thousand Natural shocks",
      "That Flesh is heir to? 'Tis a consummation");

  private static final String SINGULARITY = "A string";

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Rule
  public final AppEngineRule appEngineRule = new AppEngineRule();

  @Test
  public void testSize() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    assertThat(Files.size(path)).isEqualTo(SINGULARITY.getBytes(UTF_8).length);
  }

  @Test
  public void testSize_trailingSlash_returnsFakePseudoDirectorySize() throws Exception {
    assertThat(Files.size(Paths.get(URI.create("gs://bucket/wat/")))).isEqualTo(1);
  }

  @Test
  public void testSize_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("doodle", usePseudoDirectories(false))) {
      Path path = fs.getPath("wat/");
      byte[] rapture = SINGULARITY.getBytes(UTF_8);
      Files.write(path, rapture);
      assertThat(Files.size(path)).isEqualTo(rapture.length);
    }
  }

  @Test
  public void testReadAllBytes() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    assertThat(new String(Files.readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testReadAllBytes_trailingSlash() throws Exception {
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    Files.readAllBytes(Paths.get(URI.create("gs://bucket/wat/")));
  }

  @Test
  public void testNewByteChannelRead() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    byte[] data = SINGULARITY.getBytes(UTF_8);
    Files.write(path, data);
    try (ReadableByteChannel input = Files.newByteChannel(path)) {
      ByteBuffer buffer = ByteBuffer.allocate(data.length);
      assertThat(input.read(buffer)).isEqualTo(data.length);
      assertThat(new String(buffer.array(), UTF_8)).isEqualTo(SINGULARITY);
      buffer.rewind();
      assertThat(input.read(buffer)).isEqualTo(-1);
    }
  }

  @Test
  public void testNewByteChannelRead_seeking() throws Exception {
    Path path = Paths.get(URI.create("gs://lol/cat"));
    Files.write(path, "helloworld".getBytes(UTF_8));
    try (SeekableByteChannel input = Files.newByteChannel(path)) {
      ByteBuffer buffer = ByteBuffer.allocate(5);
      input.position(5);
      assertThat(input.position()).isEqualTo(5);
      assertThat(input.read(buffer)).isEqualTo(5);
      assertThat(input.position()).isEqualTo(10);
      assertThat(new String(buffer.array(), UTF_8)).isEqualTo("world");
      buffer.rewind();
      assertThat(input.read(buffer)).isEqualTo(-1);
      input.position(0);
      assertThat(input.position()).isEqualTo(0);
      assertThat(input.read(buffer)).isEqualTo(5);
      assertThat(input.position()).isEqualTo(5);
      assertThat(new String(buffer.array(), UTF_8)).isEqualTo("hello");
    }
  }

  @Test
  public void testNewByteChannelRead_seekBeyondSize_reportsEofOnNextRead() throws Exception {
    Path path = Paths.get(URI.create("gs://lol/cat"));
    Files.write(path, "hellocat".getBytes(UTF_8));
    try (SeekableByteChannel input = Files.newByteChannel(path)) {
      ByteBuffer buffer = ByteBuffer.allocate(5);
      input.position(10);
      assertThat(input.read(buffer)).isEqualTo(-1);
      input.position(11);
      assertThat(input.read(buffer)).isEqualTo(-1);
      assertThat(input.size()).isEqualTo(8);
    }
  }

  @Test
  public void testNewByteChannelRead_trailingSlash() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat/"));
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    Files.newByteChannel(path);
  }

  @Test
  public void testNewByteChannelRead_notFound() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wednesday"));
    thrown.expect(NoSuchFileException.class);
    Files.newByteChannel(path);
  }

  @Test
  public void testNewByteChannelWrite() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/tests"));
    try (SeekableByteChannel output = Files.newByteChannel(path, WRITE)) {
      assertThat(output.position()).isEqualTo(0);
      assertThat(output.size()).isEqualTo(0);
      ByteBuffer buffer = ByteBuffer.wrap("filec".getBytes(UTF_8));
      assertThat(output.write(buffer)).isEqualTo(5);
      assertThat(output.position()).isEqualTo(5);
      assertThat(output.size()).isEqualTo(5);
      buffer = ByteBuffer.wrap("onten".getBytes(UTF_8));
      assertThat(output.write(buffer)).isEqualTo(5);
      assertThat(output.position()).isEqualTo(10);
      assertThat(output.size()).isEqualTo(10);
    }
    assertThat(new String(Files.readAllBytes(path), UTF_8)).isEqualTo("fileconten");
  }

  @Test
  public void testNewInputStream() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    try (InputStream input = Files.newInputStream(path)) {
      byte[] data = new byte[SINGULARITY.getBytes(UTF_8).length];
      input.read(data);
      assertThat(new String(data, UTF_8)).isEqualTo(SINGULARITY);
    }
  }

  @Test
  public void testNewInputStream_trailingSlash() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat/"));
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    try (InputStream input = Files.newInputStream(path)) {
      input.read();
    }
  }

  @Test
  public void testNewInputStream_notFound() throws Exception {
    Path path = Paths.get(URI.create("gs://cry/wednesday"));
    thrown.expect(NoSuchFileException.class);
    try (InputStream input = Files.newInputStream(path)) {
      input.read();
    }
  }

  @Test
  public void testNewOutputStream() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(Files.readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_truncateByDefault() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    Files.write(path, "hello".getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(Files.readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_truncateExplicitly() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    Files.write(path, "hello".getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path, TRUNCATE_EXISTING)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(Files.readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_trailingSlash() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat/"));
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    try (OutputStream output = Files.newOutputStream(path)) {
    }
  }

  @Test
  public void testNewOutputStream_createNew() throws Exception {
    Path path = Paths.get(URI.create("gs://cry/wednesday"));
    try (OutputStream output = Files.newOutputStream(path, CREATE_NEW)) {
    }
  }

  @Test
  public void testNewOutputStream_createNew_alreadyExists() throws Exception {
    Path path = Paths.get(URI.create("gs://cry/wednesday"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    thrown.expect(FileAlreadyExistsException.class);
    try (OutputStream output = Files.newOutputStream(path, CREATE_NEW)) {
    }
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_throwsIae() throws Exception {
    Path path = Paths.get(URI.create("gs://double/slash//yep"));
    thrown.expect(IllegalArgumentException.class);
    Files.write(path, FILE_CONTENTS, UTF_8);
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_canBeNormalized() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("greenbean", permitEmptyPathComponents(false))) {
      Path path = fs.getPath("adipose//yep").normalize();
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
      GcsService gcsService = GcsServiceFactory.createGcsService();
      assertThat(gcsService.getMetadata(new GcsFilename("greenbean", "adipose/yep"))).isNotNull();
      assertThat(Files.exists(path)).isTrue();
    }
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_permitEmptyPathComponents() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("greenbean", permitEmptyPathComponents(true))) {
      Path path = fs.getPath("adipose//yep");
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
      GcsService gcsService = GcsServiceFactory.createGcsService();
      assertThat(gcsService.getMetadata(new GcsFilename("greenbean", "adipose//yep"))).isNotNull();
      assertThat(Files.exists(path)).isTrue();
    }
  }

  @Test
  public void testWrite_absoluteObjectName_prefixSlashGetsRemoved() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/adipose/yep"));
    Files.write(path, FILE_CONTENTS, UTF_8);
    assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
    GcsService gcsService = GcsServiceFactory.createGcsService();
    assertThat(gcsService.getMetadata(new GcsFilename("greenbean", "adipose/yep"))).isNotNull();
    assertThat(Files.exists(path)).isTrue();
  }

  @Test
  public void testWrite_absoluteObjectName_disableStrip_slashGetsPreserved() throws Exception {
    try (CloudStorageFileSystem fs =
        forBucket("greenbean",
            CloudStorageConfiguration.builder()
                .stripPrefixSlash(false)
                .build())) {
      Path path = fs.getPath("/adipose/yep");
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
      GcsService gcsService = GcsServiceFactory.createGcsService();
      assertThat(gcsService.getMetadata(new GcsFilename("greenbean", "/adipose/yep"))).isNotNull();
      assertThat(Files.exists(path)).isTrue();
    }
  }

  @Test
  public void testWrite() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(path, FILE_CONTENTS, UTF_8);
    assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
  }

  @Test
  public void testWrite_trailingSlash() throws Exception {
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    Files.write(Paths.get(URI.create("gs://greenbean/adipose/")), FILE_CONTENTS, UTF_8);
  }

  @Test
  public void testExists() throws Exception {
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion")))).isFalse();
    Files.write(Paths.get(URI.create("gs://military/fashion")), "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion")))).isTrue();
  }

  @Test
  public void testExists_trailingSlash() throws Exception {
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion/")))).isTrue();
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion/.")))).isTrue();
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion/..")))).isTrue();
  }

  @Test
  public void testExists_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("military", usePseudoDirectories(false))) {
      assertThat(Files.exists(fs.getPath("fashion/"))).isFalse();
    }
  }

  @Test
  public void testDelete() throws Exception {
    Files.write(Paths.get(URI.create("gs://love/fashion")), "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    assertThat(Files.exists(Paths.get(URI.create("gs://love/fashion")))).isTrue();
    Files.delete(Paths.get(URI.create("gs://love/fashion")));
    assertThat(Files.exists(Paths.get(URI.create("gs://love/fashion")))).isFalse();
  }

  @Test
  public void testDelete_dotDirNotNormalized_throwsIae() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    Files.delete(Paths.get(URI.create("gs://love/fly/../passion")));
  }

  @Test
  public void testDelete_trailingSlash() throws Exception {
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    Files.delete(Paths.get(URI.create("gs://love/passion/")));
  }

  @Test
  public void testDelete_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("pumpkin", usePseudoDirectories(false))) {
      Path path = fs.getPath("wat/");
      Files.write(path, FILE_CONTENTS, UTF_8);
      GcsService gcsService = GcsServiceFactory.createGcsService();
      assertThat(gcsService.getMetadata(new GcsFilename("pumpkin", "wat/"))).isNotNull();
      Files.delete(path);
      assertThat(gcsService.getMetadata(new GcsFilename("pumpkin", "wat/"))).isNull();
    }
  }

  @Test
  public void testDelete_notFound() throws Exception {
    GcsService gcsService = GcsServiceFactory.createGcsService();
    assumeTrue(!gcsService.delete(new GcsFilename("loveh", "passionehu")));  // XXX: b/15832793
    thrown.expect(NoSuchFileException.class);
    Files.delete(Paths.get(URI.create("gs://loveh/passionehu")));
  }

  @Test
  public void testDeleteIfExists() throws Exception {
    GcsService gcsService = GcsServiceFactory.createGcsService();
    assumeTrue(!gcsService.delete(new GcsFilename("loveh", "passionehu")));  // XXX: b/15832793
    assertThat(Files.deleteIfExists(Paths.get(URI.create("gs://love/passionz")))).isFalse();
    Files.write(Paths.get(URI.create("gs://love/passionz")), "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    assertThat(Files.deleteIfExists(Paths.get(URI.create("gs://love/passionz")))).isTrue();
  }

  @Test
  public void testDeleteIfExists_trailingSlash() throws Exception {
    thrown.expect(CloudStoragePseudoDirectoryException.class);
    Files.deleteIfExists(Paths.get(URI.create("gs://love/passion/")));
  }

  @Test
  public void testCopy() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.copy(source, target);
    assertThat(new String(Files.readAllBytes(target), UTF_8)).isEqualTo("(✿◕ ‿◕ )ノ");
    assertThat(Files.exists(source)).isTrue();
    assertThat(Files.exists(target)).isTrue();
  }

  @Test
  public void testCopy_sourceMissing_throwsNoSuchFileException() throws Exception {
    thrown.expect(NoSuchFileException.class);
    Files.copy(
        Paths.get(URI.create("gs://military/fashion.show")),
        Paths.get(URI.create("gs://greenbean/adipose")));
  }

  @Test
  public void testCopy_targetExists_throwsFileAlreadyExistsException() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.write(target, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    thrown.expect(FileAlreadyExistsException.class);
    Files.copy(source, target);
  }

  @Test
  public void testCopyReplace_targetExists_works() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.write(target, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.copy(source, target, REPLACE_EXISTING);
  }

  @Test
  public void testCopy_directory_doesNothing() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fundir/"));
    Path target = Paths.get(URI.create("gs://greenbean/loldir/"));
    Files.copy(source, target);
  }

  @Test
  public void testCopy_atomic_throwsUnsupported() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    thrown.expect(UnsupportedOperationException.class);
    Files.copy(source, target, ATOMIC_MOVE);
  }

  @Test
  public void testMove() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.move(source, target);
    assertThat(new String(Files.readAllBytes(target), UTF_8)).isEqualTo("(✿◕ ‿◕ )ノ");
    assertThat(Files.exists(source)).isFalse();
    assertThat(Files.exists(target)).isTrue();
  }

  @Test
  public void testCreateDirectory() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/dir/"));
    Files.createDirectory(path);
    assertThat(Files.exists(path)).isTrue();
  }

  @Test
  public void testMove_atomicMove_notSupported() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    thrown.expect(AtomicMoveNotSupportedException.class);
    Files.move(source, target, ATOMIC_MOVE);
  }

  @Test
  public void testIsDirectory() throws Exception {
    try (FileSystem fs = FileSystems.getFileSystem(URI.create("gs://doodle"))) {
      assertThat(Files.isDirectory(fs.getPath(""))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("/"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("."))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("./"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("cat/.."))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("hello/cat/.."))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("cat/../"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("hello/cat/../"))).isTrue();
    }
  }

  @Test
  public void testIsDirectory_trailingSlash_alwaysTrue() throws Exception {
    assertThat(Files.isDirectory(Paths.get(URI.create("gs://military/fundir/")))).isTrue();
  }

  @Test
  public void testIsDirectory_trailingSlash_pseudoDirectoriesDisabled_false() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("doodle", usePseudoDirectories(false))) {
      assertThat(Files.isDirectory(fs.getPath("fundir/"))).isFalse();
    }
  }

  @Test
  public void testCopy_withCopyAttributes_preservesAttributes() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withMimeType("text/lolcat"),
        withCacheControl("public; max-age=666"));
    Files.copy(source, target, COPY_ATTRIBUTES);
    GcsService gcsService = GcsServiceFactory.createGcsService();
    GcsFileMetadata metadata = gcsService.getMetadata(new GcsFilename("greenbean", "adipose"));
    assertThat(metadata.getOptions().getMimeType()).isEqualTo("text/lolcat");
    assertThat(metadata.getOptions().getCacheControl()).isEqualTo("public; max-age=666");
  }

  @Test
  public void testCopy_withoutOptions_doesntPreservesAttributes() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withMimeType("text/lolcat"),
        withCacheControl("public; max-age=666"));
    Files.copy(source, target);
    GcsService gcsService = GcsServiceFactory.createGcsService();
    GcsFileMetadata metadata = gcsService.getMetadata(new GcsFilename("greenbean", "adipose"));
    assertThat(metadata.getOptions().getMimeType()).isNull();
    assertThat(metadata.getOptions().getCacheControl()).isNull();
  }

  @Test
  public void testCopy_overwriteAttributes() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        withMimeType("text/lolcat"),
        withCacheControl("public; max-age=666"));
    Files.copy(source, target, COPY_ATTRIBUTES,
        withMimeType("text/palfun"));
    GcsService gcsService = GcsServiceFactory.createGcsService();
    GcsFileMetadata metadata = gcsService.getMetadata(new GcsFilename("greenbean", "adipose"));
    assertThat(metadata.getOptions().getMimeType()).isEqualTo("text/palfun");
    assertThat(metadata.getOptions().getCacheControl()).isEqualTo("public; max-age=666");
  }

  @Test
  public void testNullness() throws Exception {
    try (FileSystem fs = FileSystems.getFileSystem(URI.create("gs://blood"))) {
      NullPointerTester tester = new NullPointerTester()
          .setDefault(URI.class, URI.create("gs://blood"))
          .setDefault(Path.class, fs.getPath("and/one"))
          .setDefault(OpenOption.class, StandardOpenOption.CREATE)
          .setDefault(CopyOption.class, StandardCopyOption.COPY_ATTRIBUTES);
      tester.testAllPublicStaticMethods(CloudStorageFileSystemProvider.class);
      tester.testAllPublicInstanceMethods(new CloudStorageFileSystemProvider());
    }
  }

  private static CloudStorageConfiguration permitEmptyPathComponents(boolean value) {
    return CloudStorageConfiguration.builder()
        .permitEmptyPathComponents(value)
        .build();
  }

  private static CloudStorageConfiguration usePseudoDirectories(boolean value) {
    return CloudStorageConfiguration.builder()
        .usePseudoDirectories(value)
        .build();
  }
}
