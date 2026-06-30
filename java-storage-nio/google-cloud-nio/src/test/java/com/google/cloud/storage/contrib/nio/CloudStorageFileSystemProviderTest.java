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

import static com.google.cloud.storage.Acl.Role.OWNER;
import static com.google.cloud.storage.contrib.nio.CloudStorageFileSystem.forBucket;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.testing.NullPointerTester;
import java.io.IOException;
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
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageFileSystemProvider}. */
@RunWith(JUnit4.class)
public class CloudStorageFileSystemProviderTest {
  // @Rule(order = 1) public final MultipleAttemptsRule multipleAttemptsRule = new
  // MultipleAttemptsRule(3);
  @Rule(order = 1)
  public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  private static final List<String> FILE_CONTENTS =
      ImmutableList.of(
          "Lorem ipsum dolor sit amet, consectetur ",
          "adipisicing elit. Ab, corporis deleniti ducimus ",
          "ea esse est fuga illum inventore itaque maiores ",
          "mollitia necessitatibus nesciunt nisi nobis non, ",
          "nulla officia omnis placeat quibusdam unde? Alias ",
          "delectus dignissimos, ducimus enim et expedita ",
          "iste molestiae mollitia porro sunt! Debitis ",
          "doloribus earum modi nam neque nulla optio ",
          "quisquam reprehenderit. Autem consequatur ",
          "delectus vitae. Aut consectetur cum eaque facere ",
          "illum in molestiae nam, nulla obcaecati officia ",
          "optio perspiciatis, quisquam reiciendis sequi ",
          "tempora, velit veritatis vitae? Alias ",
          "consequuntur dolor doloremque eius et fugiat ",
          "fugit harum illo incidunt ipsa maxime molestiae ",
          "nostrum officia pariatur, quam quidem similique ",
          "velit veniam voluptatem voluptatibus. Ab at ",
          "commodi ea expedita optio. Ab cumque eos et, ",
          "libero non quam quia recusandae tempora vitae! ",
          "Debitis libero quidem reprehenderit voluptas. ",
          "Architecto consectetur cum dignissimos, dolorem ",
          "eos, eum explicabo fugiat magnam maiores modi ",
          "numquam odio pariatur provident quae quasi quos ",
          "ratione recusandae repellendus similique ullam ",
          "velit!");

  private static final String SINGULARITY = "A string";

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
  }

  @After
  public void after() {
    CloudStorageFileSystemProvider.setStorageOptions(StorageOptionsUtil.getDefaultInstance());
  }

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
  public void test_trailingSlash_isFolder() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat/"));
    Files.write(path, SINGULARITY.getBytes(UTF_8), CloudStorageOptions.allowTrailingSlash());
    assertThat(Files.isDirectory(path)).isTrue();
  }

  @Test
  public void testSize_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("doodle", usePseudoDirectories(false))) {
      Path path = fs.getPath("wat/");
      byte[] rapture = SINGULARITY.getBytes(UTF_8);
      Files.write(path, rapture);
      assertThat(Files.size(path)).isEqualTo(rapture.length);
      Files.delete(path);
    }
  }

  @Test
  public void testReadAllBytes() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    assertThat(new String(readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
    Files.delete(path);
  }

  @Test
  public void testReadAllBytes_trailingSlash() throws Exception {
    try {
      readAllBytes(Paths.get(URI.create("gs://bucket/wat/")));
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
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
    Files.delete(path);
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
    Files.delete(path);
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
    try {
      Path path = Paths.get(URI.create("gs://bucket/wat/"));
      Files.newByteChannel(path);
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testNewByteChannelRead_notFound() throws Exception {
    try {
      Path path = Paths.get(URI.create("gs://bucket/wednesday"));
      Files.newByteChannel(path);
      Assert.fail();
    } catch (NoSuchFileException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
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
    assertThat(new String(readAllBytes(path), UTF_8)).isEqualTo("fileconten");
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
    try (InputStream input = Files.newInputStream(path)) {
      input.read();
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testNewInputStream_notFound() throws Exception {
    Path path = Paths.get(URI.create("gs://cry/wednesday"));
    try (InputStream input = Files.newInputStream(path)) {
      input.read();
      Assert.fail();
    } catch (NoSuchFileException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testNewOutputStream() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_truncateByDefault() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    Files.write(path, "hello".getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_truncateExplicitly() throws Exception {
    Path path = Paths.get(URI.create("gs://bucket/wat"));
    Files.write(path, SINGULARITY.getBytes(UTF_8));
    Files.write(path, "hello".getBytes(UTF_8));
    try (OutputStream output = Files.newOutputStream(path, TRUNCATE_EXISTING)) {
      output.write(SINGULARITY.getBytes(UTF_8));
    }
    assertThat(new String(readAllBytes(path), UTF_8)).isEqualTo(SINGULARITY);
  }

  @Test
  public void testNewOutputStream_trailingSlash() throws Exception {
    try {
      Path path = Paths.get(URI.create("gs://bucket/wat/"));
      Files.newOutputStream(path);
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testNewOutputStream_createNew() throws Exception {
    Path path = Paths.get(URI.create("gs://cry/wednesday"));
    Files.newOutputStream(path, CREATE_NEW);
  }

  @Test
  public void testNewOutputStream_createNew_alreadyExists() throws Exception {
    try {
      Path path = Paths.get(URI.create("gs://cry/wednesday"));
      Files.write(path, SINGULARITY.getBytes(UTF_8));
      Files.newOutputStream(path, CREATE_NEW);
      Assert.fail();
    } catch (FileAlreadyExistsException expected) {
    }
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_throwsIae() throws Exception {
    try {
      Path path = Paths.get(URI.create("gs://double/slash//yep"));
      Files.write(path, FILE_CONTENTS, UTF_8);
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_canBeNormalized() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("greenbean", permitEmptyPathComponents(false))) {
      Path path = fs.getPath("adipose//yep").normalize();
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
      assertThat(Files.exists(fs.getPath("adipose", "yep"))).isTrue();
    }
  }

  @Test
  public void testWrite_objectNameWithExtraSlashes_permitEmptyPathComponents() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("greenbean", permitEmptyPathComponents(true))) {
      Path path = fs.getPath("adipose//yep");
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
      assertThat(Files.exists(path)).isTrue();
    }
  }

  @Test
  public void testWrite_absoluteObjectName_prefixSlashGetsRemoved() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/adipose/yep"));
    Files.write(path, FILE_CONTENTS, UTF_8);
    assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
    assertThat(Files.exists(path)).isTrue();
  }

  @Test
  public void testWrite_absoluteObjectName_disableStrip_slashGetsPreserved() throws Exception {
    try (CloudStorageFileSystem fs =
        forBucket(
            "greenbean", CloudStorageConfiguration.builder().stripPrefixSlash(false).build())) {
      Path path = fs.getPath("/adipose/yep");
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.readAllLines(path, UTF_8)).isEqualTo(FILE_CONTENTS);
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
  public void testWriteOnClose() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/adipose"));
    try (SeekableByteChannel chan = Files.newByteChannel(path, WRITE)) {
      // writing lots of contents to defeat channel-internal buffering.
      for (int i = 0; i < 9999; i++) {
        for (String s : FILE_CONTENTS) {
          chan.write(ByteBuffer.wrap(s.getBytes(UTF_8)));
        }
      }
      try {
        Files.size(path);
        // we shouldn't make it to this line. Not using thrown.expect because
        // I still want to run a few lines after the exception.
        assertThat(false).isTrue();
      } catch (NoSuchFileException nsf) {
        // that's what we wanted, we're good.
      }
    }
    // channel now closed, the file should be there and with the new contents.
    assertThat(Files.exists(path)).isTrue();
    assertThat(Files.size(path)).isGreaterThan(100L);
  }

  @Test
  public void testWrite_trailingSlash() throws Exception {
    try {
      Files.write(Paths.get(URI.create("gs://greenbean/adipose/")), FILE_CONTENTS, UTF_8);
      Assert.fail();
    } catch (CloudStoragePseudoDirectoryException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testExists() throws Exception {
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion")))).isFalse();
    Files.write(Paths.get(URI.create("gs://military/fashion")), "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    assertThat(Files.exists(Paths.get(URI.create("gs://military/fashion")))).isTrue();
  }

  @Test
  public void testExists_trailingSlash() {
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
  public void testFakeDirectories() throws IOException {
    try (FileSystem fs = forBucket("military")) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("dir/angel"));
      paths.add(fs.getPath("dir/deepera"));
      paths.add(fs.getPath("dir/deeperb"));
      paths.add(fs.getPath("dir/deeper_"));
      paths.add(fs.getPath("dir/deeper.sea/hasfish"));
      paths.add(fs.getPath("dir/deeper/fish"));
      for (Path path : paths) {
        Files.createFile(path);
      }

      // ends with slash, must be a directory
      assertThat(Files.isDirectory(fs.getPath("dir/"))).isTrue();
      // files are not directories
      assertThat(Files.exists(fs.getPath("dir/angel"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("dir/angel"))).isFalse();
      // directories are recognized even without the trailing "/"
      assertThat(Files.isDirectory(fs.getPath("dir"))).isTrue();
      // also works for absolute paths
      assertThat(Files.isDirectory(fs.getPath("/dir"))).isTrue();
      // non-existent files are not directories (but they don't make us crash)
      assertThat(Files.isDirectory(fs.getPath("di"))).isFalse();
      assertThat(Files.isDirectory(fs.getPath("dirs"))).isFalse();
      assertThat(Files.isDirectory(fs.getPath("dir/deep"))).isFalse();
      assertThat(Files.isDirectory(fs.getPath("dir/deeper/fi"))).isFalse();
      assertThat(Files.isDirectory(fs.getPath("/dir/deeper/fi"))).isFalse();
      // also works for subdirectories
      assertThat(Files.isDirectory(fs.getPath("dir/deeper/"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("dir/deeper"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("/dir/deeper/"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("/dir/deeper"))).isTrue();
      // dot and .. folders are directories
      assertThat(Files.isDirectory(fs.getPath("dir/deeper/."))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("dir/deeper/.."))).isTrue();
      // dots in the name are fine
      assertThat(Files.isDirectory(fs.getPath("dir/deeper.sea/"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("dir/deeper.sea"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath("dir/deeper.seax"))).isFalse();
      // the root folder is a directory
      assertThat(Files.isDirectory(fs.getPath("/"))).isTrue();
      assertThat(Files.isDirectory(fs.getPath(""))).isTrue();
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
    try {
      Files.delete(Paths.get(URI.create("gs://love/fly/../passion")));
      Assert.fail();
    } catch (IllegalArgumentException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testDelete_trailingSlash() throws Exception {
    Files.delete(Paths.get(URI.create("gs://love/passion/")));
  }

  @Test
  public void testDelete_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("pumpkin", usePseudoDirectories(false))) {
      Path path = fs.getPath("wat/");
      Files.write(path, FILE_CONTENTS, UTF_8);
      assertThat(Files.exists(path));
      Files.delete(path);
      assertThat(!Files.exists(path));
    }
  }

  @Test
  public void testDelete_notFound() throws Exception {
    try {
      Files.delete(Paths.get(URI.create("gs://loveh/passionehu")));
      Assert.fail();
    } catch (NoSuchFileException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testDeleteIfExists() throws Exception {
    Files.write(Paths.get(URI.create("gs://love/passionz")), "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    assertThat(Files.deleteIfExists(Paths.get(URI.create("gs://love/passionz")))).isTrue();
    // call does not fail, the folder just doesn't exist
    Files.deleteIfExists(Paths.get(URI.create("gs://love/passion/")));
  }

  @Test
  public void testDeleteIfExists_trailingSlash_disablePseudoDirectories() throws Exception {
    try (CloudStorageFileSystem fs = forBucket("doodle", usePseudoDirectories(false))) {
      // Doesn't exist, no error
      Files.deleteIfExists(Paths.get(URI.create("gs://love/passion/")));
    }
  }

  @Test
  public void testCopy() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.copy(source, target);
    assertThat(new String(readAllBytes(target), UTF_8)).isEqualTo("(✿◕ ‿◕ )ノ");
    assertThat(Files.exists(source)).isTrue();
    assertThat(Files.exists(target)).isTrue();
  }

  @Test
  public void testCopy_sourceMissing_throwsNoSuchFileException() throws Exception {
    try {
      Files.copy(
          Paths.get(URI.create("gs://military/fashion.show")),
          Paths.get(URI.create("gs://greenbean/adipose")));
      Assert.fail();
    } catch (NoSuchFileException expected) {
    }
  }

  @Test
  public void testCopy_targetExists_throwsFileAlreadyExistsException() throws Exception {
    try {
      Path source = Paths.get(URI.create("gs://military/fashion.show"));
      Path target = Paths.get(URI.create("gs://greenbean/adipose"));
      Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
      Files.write(target, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
      Files.copy(source, target);
      Assert.fail();
    } catch (FileAlreadyExistsException expected) {
    }
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
    try {
      Path source = Paths.get(URI.create("gs://military/fashion.show"));
      Path target = Paths.get(URI.create("gs://greenbean/adipose"));
      Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
      Files.copy(source, target, ATOMIC_MOVE);
      Assert.fail();
    } catch (UnsupportedOperationException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testMove_atomic() throws Exception {
    Path source = Paths.get(URI.create("gs://greenbean/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.move(source, target, ATOMIC_MOVE);
    assertThat(Files.exists(source)).isFalse();
    assertThat(Files.exists(target)).isTrue();
  }

  @Test
  public void testMove_crossBucket() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    Files.move(source, target);
    assertThat(Files.exists(source)).isFalse();
    assertThat(Files.exists(target)).isTrue();
  }

  @Test
  public void testMove_atomicCrossBucket_throwsUnsupported() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(source, "(✿◕ ‿◕ )ノ".getBytes(UTF_8));
    try {
      Files.move(source, target, ATOMIC_MOVE);
      Assert.fail();
    } catch (AtomicMoveNotSupportedException ex) {
      assertThat(ex.getMessage()).isNotNull();
    }
  }

  @Test
  public void testCreateDirectory() throws Exception {
    Path path = Paths.get(URI.create("gs://greenbean/dir/"));
    Files.createDirectory(path);
    assertThat(Files.exists(path)).isTrue();
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
  public void testIsDirectory_trailingSlash_alwaysTrue() {
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
    Files.write(
        source,
        "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        CloudStorageOptions.withMimeType("text/lolcat"),
        CloudStorageOptions.withCacheControl("public; max-age=666"),
        CloudStorageOptions.withContentEncoding("foobar"),
        CloudStorageOptions.withContentDisposition("my-content-disposition"),
        CloudStorageOptions.withUserMetadata("answer", "42"));
    Files.copy(source, target, COPY_ATTRIBUTES);

    CloudStorageFileAttributes attributes =
        Files.readAttributes(target, CloudStorageFileAttributes.class);
    assertThat(attributes.mimeType()).hasValue("text/lolcat");
    assertThat(attributes.cacheControl()).hasValue("public; max-age=666");
    assertThat(attributes.contentEncoding()).hasValue("foobar");
    assertThat(attributes.contentDisposition()).hasValue("my-content-disposition");
    assertThat(attributes.userMetadata().containsKey("answer")).isTrue();
    assertThat(attributes.userMetadata().get("answer")).isEqualTo("42");
  }

  @Test
  public void testCopy_withoutOptions_doesntPreservesAttributes() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target = Paths.get(URI.create("gs://greenbean/adipose"));
    Files.write(
        source,
        "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        CloudStorageOptions.withMimeType("text/lolcat"),
        CloudStorageOptions.withCacheControl("public; max-age=666"),
        CloudStorageOptions.withUserMetadata("answer", "42"));
    Files.copy(source, target);

    CloudStorageFileAttributes attributes =
        Files.readAttributes(target, CloudStorageFileAttributes.class);
    String mimeType = attributes.mimeType().orNull();
    String cacheControl = attributes.cacheControl().orNull();
    assertThat(mimeType).isNotEqualTo("text/lolcat");
    assertThat(cacheControl).isNull();
    assertThat(attributes.userMetadata().containsKey("answer")).isFalse();
  }

  @Test
  public void testCopy_overwriteAttributes() throws Exception {
    Path source = Paths.get(URI.create("gs://military/fashion.show"));
    Path target1 = Paths.get(URI.create("gs://greenbean/adipose"));
    Path target2 = Paths.get(URI.create("gs://greenbean/round"));
    Files.write(
        source,
        "(✿◕ ‿◕ )ノ".getBytes(UTF_8),
        CloudStorageOptions.withMimeType("text/lolcat"),
        CloudStorageOptions.withCacheControl("public; max-age=666"));
    Files.copy(source, target1, COPY_ATTRIBUTES);
    Files.copy(source, target2, COPY_ATTRIBUTES, CloudStorageOptions.withMimeType("text/palfun"));

    CloudStorageFileAttributes attributes =
        Files.readAttributes(target1, CloudStorageFileAttributes.class);
    assertThat(attributes.mimeType()).hasValue("text/lolcat");
    assertThat(attributes.cacheControl()).hasValue("public; max-age=666");

    attributes = Files.readAttributes(target2, CloudStorageFileAttributes.class);
    assertThat(attributes.mimeType()).hasValue("text/palfun");
    assertThat(attributes.cacheControl()).hasValue("public; max-age=666");
    Files.delete(source);
    Files.delete(target1);
    Files.delete(target2);
  }

  @Test
  public void testCopy_path_toLocalFileSystem() throws IOException {
    Path source = Paths.get(URI.create("gs://mybucket/myobject"));
    byte[] helloWorldBytes = "Hello, World!".getBytes(UTF_8);
    Files.write(source, helloWorldBytes);

    Path path = temporaryFolder.newFile().toPath();
    // The new file created by temporaryFolder is an empty file on disk, specify REPLACE_EXISTING
    //  so we can overwrite its contents.
    Files.copy(source, path, REPLACE_EXISTING);
    assertThat(Files.readAllBytes(path)).isEqualTo(helloWorldBytes);
  }

  @Test
  public void testNullness() throws Exception {
    try (FileSystem fs = FileSystems.getFileSystem(URI.create("gs://blood"))) {
      NullPointerTester tester = new NullPointerTester();
      tester.ignore(CloudStorageFileSystemProvider.class.getMethod("equals", Object.class));
      tester.setDefault(URI.class, URI.create("gs://blood"));
      tester.setDefault(Path.class, fs.getPath("and/one"));
      tester.setDefault(OpenOption.class, CREATE);
      tester.setDefault(CopyOption.class, COPY_ATTRIBUTES);
      tester.testAllPublicStaticMethods(CloudStorageFileSystemProvider.class);
      tester.testAllPublicInstanceMethods(new CloudStorageFileSystemProvider());
    }
  }

  @Test
  public void testProviderEquals() {
    Path path1 = Paths.get(URI.create("gs://bucket/tuesday"));
    Path path2 = Paths.get(URI.create("gs://blood/wednesday"));
    Path path3 = Paths.get("tmp");
    assertThat(path1.getFileSystem().provider()).isEqualTo(path2.getFileSystem().provider());
    assertThat(path1.getFileSystem().provider()).isNotEqualTo(path3.getFileSystem().provider());
  }

  @Test
  public void testNewFileSystem() throws Exception {
    Map<String, String> env = new HashMap<>();
    FileSystems.newFileSystem(URI.create("gs://bucket/path/to/file"), env);
  }

  @Test
  public void testFromSpace() throws Exception {
    // User should be able to create paths to files whose name contains a space.
    // Traditional way 1: manually escape the spaces
    Path path1 = Paths.get(URI.create("gs://bucket/with/a%20space"));
    CloudStorageFileSystemProvider provider =
        (CloudStorageFileSystemProvider) path1.getFileSystem().provider();
    // Traditional way 2: use UrlEscapers.urlFragmentEscaper().escape
    // to escape the string for you.
    // (Not tested because UrlEscapers isn't the unit under test).

    // Non-traditional way: use our convenience method to work around URIs not being allowed to
    // contain spaces.
    Path path3 = provider.getPath("gs://bucket/with/a space");
    // Both approaches should be equivalent
    assertThat(path1.getFileSystem().provider()).isEqualTo(path3.getFileSystem().provider());
    assertThat(path1.toUri()).isEqualTo(path3.toUri());

    // getPath does not interpret the string at all.
    Path path4 = provider.getPath("gs://bucket/with/a%20percent");
    assertThat(path4.toString()).isEqualTo("/with/a%20percent");
  }

  @Test
  public void testBucketWithHost() {
    // User should be able to create buckets whose name contains a host name.
    Path path1 = Paths.get(URI.create("gs://bucket-with-host/path"));
    CloudStorageFileSystemProvider provider =
        (CloudStorageFileSystemProvider) path1.getFileSystem().provider();

    Path path2 = provider.getPath("gs://bucket-with-host/path");
    // Both approaches should be equivalent
    assertThat(path1.getFileSystem().provider()).isEqualTo(path2.getFileSystem().provider());
    assertThat(path1.toUri()).isEqualTo(path2.toUri());
    assertThat(path1.toUri().getHost()).isEqualTo("bucket-with-host");
    assertThat(path1.toUri().getAuthority()).isEqualTo("bucket-with-host");
  }

  @Test
  public void testBucketWithAuthority() {
    // User should be able to create buckets whose name contains an authority that is not a host.
    Path path1 = Paths.get(URI.create("gs://bucket_with_authority/path"));
    CloudStorageFileSystemProvider provider =
        (CloudStorageFileSystemProvider) path1.getFileSystem().provider();

    Path path2 = provider.getPath("gs://bucket_with_authority/path");
    // Both approaches should be equivalent
    assertThat(path1.getFileSystem().provider()).isEqualTo(path2.getFileSystem().provider());
    assertThat(path1.toUri()).isEqualTo(path2.toUri());
    assertThat(path1.toUri().getHost()).isNull();
    assertThat(path1.toUri().getAuthority()).isEqualTo("bucket_with_authority");
  }

  @Test
  public void testBucketWithoutAuthority() {
    Path path1 = Paths.get(URI.create("gs://bucket_with_authority/path"));
    CloudStorageFileSystemProvider provider =
        (CloudStorageFileSystemProvider) path1.getFileSystem().provider();

    try {
      provider.getFileSystem(URI.create("gs:///path"));
      Assert.fail();
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage()).isEqualTo("gs:// URIs must have a host: gs:///path");
    }
  }

  @Test
  public void testVersion_matchesAcceptablePatterns() {
    String acceptableVersionPattern = "|(?:\\d+\\.\\d+\\.\\d+(?:-.*?)?(?:-SNAPSHOT)?)";
    String version = StorageOptionsUtil.USER_AGENT_ENTRY_VERSION;
    assertTrue(
        String.format("the loaded version '%s' did not match the acceptable pattern", version),
        version.matches(acceptableVersionPattern));
  }

  @Test
  public void getUserAgentStartsWithCorrectToken() {
    assertThat(String.format("gcloud-java-nio/%s", StorageOptionsUtil.USER_AGENT_ENTRY_VERSION))
        .startsWith("gcloud-java-nio/");
  }

  @Test
  public void testReadAttributes() throws IOException {
    CloudStorageFileSystem fileSystem = forBucket("dummy");
    CloudStorageFileSystemProvider fileSystemProvider = spy(fileSystem.provider());

    BasicFileAttributes attributesBasic = mock(BasicFileAttributes.class);
    // BasicFileAttributes
    when(attributesBasic.creationTime()).thenReturn(FileTime.fromMillis(1L));
    when(attributesBasic.lastModifiedTime()).thenReturn(FileTime.fromMillis(2L));
    when(attributesBasic.lastAccessTime()).thenReturn(FileTime.fromMillis(3L));
    when(attributesBasic.isRegularFile()).thenReturn(true);
    when(attributesBasic.isDirectory()).thenReturn(true);
    when(attributesBasic.isSymbolicLink()).thenReturn(true);
    when(attributesBasic.isOther()).thenReturn(true);
    when(attributesBasic.size()).thenReturn(42L);

    CloudStorageFileAttributes attributesGcs = mock(CloudStorageFileAttributes.class);
    // BasicFileAttributes
    when(attributesGcs.creationTime()).thenReturn(FileTime.fromMillis(1L));
    when(attributesGcs.lastModifiedTime()).thenReturn(FileTime.fromMillis(2L));
    when(attributesGcs.lastAccessTime()).thenReturn(FileTime.fromMillis(3L));
    when(attributesGcs.isRegularFile()).thenReturn(true);
    when(attributesGcs.isDirectory()).thenReturn(true);
    when(attributesGcs.isSymbolicLink()).thenReturn(true);
    when(attributesGcs.isOther()).thenReturn(true);
    when(attributesGcs.size()).thenReturn(42L);

    List<Acl> acls = ImmutableList.of(Acl.newBuilder(new User("Foo"), OWNER).build());

    // CloudStorageFileAttributes
    when(attributesGcs.etag()).thenReturn(Optional.of("TheEtag"));
    when(attributesGcs.mimeType()).thenReturn(Optional.of("TheMimeType"));
    when(attributesGcs.acl()).thenReturn(Optional.of(acls));
    when(attributesGcs.cacheControl()).thenReturn(Optional.of("TheCacheControl"));
    when(attributesGcs.contentEncoding()).thenReturn(Optional.of("TheContentEncoding"));
    when(attributesGcs.contentDisposition()).thenReturn(Optional.of("TheContentDisposition"));
    when(attributesGcs.userMetadata()).thenReturn(new TreeMap<>());

    CloudStoragePath path1 = CloudStoragePath.getPath(fileSystem, "/");
    when(fileSystemProvider.readAttributes(path1, BasicFileAttributes.class))
        .thenReturn(attributesBasic);
    when(fileSystemProvider.readAttributes(path1, CloudStorageFileAttributes.class))
        .thenReturn(attributesGcs);

    Map<String, Object> expectedBasic = new TreeMap<>();
    // BasicFileAttributes
    expectedBasic.put("creationTime", FileTime.fromMillis(1L));
    expectedBasic.put("lastModifiedTime", FileTime.fromMillis(2L));
    expectedBasic.put("lastAccessTime", FileTime.fromMillis(3L));
    expectedBasic.put("isRegularFile", true);
    expectedBasic.put("isDirectory", true);
    expectedBasic.put("isSymbolicLink", true);
    expectedBasic.put("isOther", true);
    expectedBasic.put("size", 42L);

    assertEquals(expectedBasic, fileSystemProvider.readAttributes(path1, "basic:*"));

    Map<String, Object> expectedGcs = new TreeMap<>(expectedBasic);
    // CloudStorageFileAttributes
    expectedGcs.put("etag", Optional.of("TheEtag"));
    expectedGcs.put("mimeType", Optional.of("TheMimeType"));
    expectedGcs.put("acl", Optional.of(acls));
    expectedGcs.put("cacheControl", Optional.of("TheCacheControl"));
    expectedGcs.put("contentEncoding", Optional.of("TheContentEncoding"));
    expectedGcs.put("contentDisposition", Optional.of("TheContentDisposition"));
    expectedGcs.put("userMetadata", new TreeMap<>());

    assertEquals(expectedGcs, fileSystemProvider.readAttributes(path1, "gcs:*"));

    Map<String, Object> expectedSpecific = new TreeMap<>();
    expectedSpecific.put("lastModifiedTime", FileTime.fromMillis(2L));
    expectedSpecific.put("isSymbolicLink", true);
    expectedSpecific.put("isOther", true);

    // Asking for attributes that should NOT be known because we ask for basic view !
    assertEquals(
        expectedSpecific,
        fileSystemProvider.readAttributes(
            path1, "basic:lastModifiedTime,isSymbolicLink,isOther,etag,cacheControl,owner,group"));

    // Add the attributes that are only known in posix view
    // These are all fake values
    expectedSpecific.put(
        "owner",
        new UserPrincipal() {
          @Override
          public String getName() {
            return "fakeowner";
          }

          @Override
          public String toString() {
            return "fakeowner";
          }
        });

    expectedSpecific.put(
        "group",
        new GroupPrincipal() {
          @Override
          public String getName() {
            return "fakegroup";
          }

          @Override
          public String toString() {
            return "fakegroup";
          }
        });

    // The equals between two anonymous classes (the UserPrincipal and GroupPrincipal) is always
    // false
    // so we compare the toString() instead.
    assertEquals(
        expectedSpecific.toString(),
        fileSystemProvider
            .readAttributes(
                path1,
                "posix:lastModifiedTime,isSymbolicLink,isOther,etag,cacheControl,owner,group")
            .toString());

    expectedSpecific.remove("owner");
    expectedSpecific.remove("group");

    // Add the attributes that are only known in gcs view
    expectedSpecific.put("etag", Optional.of("TheEtag"));
    expectedSpecific.put("cacheControl", Optional.of("TheCacheControl"));

    assertEquals(
        expectedSpecific,
        fileSystemProvider.readAttributes(
            path1, "gcs:lastModifiedTime,isSymbolicLink,isOther,etag,cacheControl,owner,group"));
  }

  private static CloudStorageConfiguration permitEmptyPathComponents(boolean value) {
    return CloudStorageConfiguration.builder().permitEmptyPathComponents(value).build();
  }

  private static CloudStorageConfiguration usePseudoDirectories(boolean value) {
    return CloudStorageConfiguration.builder().usePseudoDirectories(value).build();
  }
}
