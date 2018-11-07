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

package com.google.cloud.storage.contrib.nio.it;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.client.http.HttpResponseException;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.contrib.nio.CloudStorageConfiguration;
import com.google.cloud.storage.contrib.nio.CloudStorageFileSystem;
import com.google.cloud.storage.contrib.nio.CloudStoragePath;
import com.google.common.collect.ImmutableList;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.testing.RemoteStorageHelper;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Integration test for google-cloud-nio.
 *
 * <p>This test actually talks to Google Cloud Storage (you need an account) and tests both reading
 * and writing. You *must* set the {@code GOOGLE_APPLICATION_CREDENTIALS} environment variable for
 * this test to work. It must contain the name of a local file that contains your Service Account
 * JSON Key. We use the project in those credentials.
 *
 * <p>See <a href="https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts">
 * Service Accounts</a> for instructions on how to get the Service Account JSON Key.
 *
 * <p>The short version is this: go to cloud.google.com/console, select your project, search for
 * "API manager", click "Credentials", click "create credentials/service account key", new service
 * account, JSON. The contents of the file that's sent to your browsers is your
 * "Service Account JSON Key".
 */
@RunWith(JUnit4.class)
public class ITGcsNio {

  private static final List<String> FILE_CONTENTS =
      ImmutableList.of(
        "Tous les êtres humains naissent libres et égaux en dignité et en droits.",
        "Ils sont doués de raison et de conscience et doivent agir ",
        "les uns envers les autres dans un esprit de fraternité.");

  private static final Logger log = Logger.getLogger(ITGcsNio.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String REQUESTER_PAYS_BUCKET = RemoteStorageHelper.generateBucketName()+"_rp";
  private static final String SML_FILE = "tmp-test-small-file.txt";
  private static final String TMP_FILE = "tmp/tmp-test-rnd-file.txt";
  private static final int SML_SIZE = 100;
  private static final String BIG_FILE = "tmp-test-big-file.txt"; // it's big, relatively speaking.
  private static final int BIG_SIZE = 2 * 1024 * 1024 - 50; // arbitrary size that's not too round.
  private static final String PREFIX = "tmp-test-file";
  private static String project;
  private static Storage storage;
  private static StorageOptions storageOptions;

  private final Random rnd = new Random();

  @BeforeClass
  public static void beforeClass() throws IOException {
    // loads the credentials from local disk as par README
    RemoteStorageHelper gcsHelper = RemoteStorageHelper.create();
    storageOptions = gcsHelper.getOptions();
    project = storageOptions.getProjectId();
    storage = storageOptions.getService();
    // create and populate test bucket
    storage.create(BucketInfo.of(BUCKET));
    fillFile(storage, BUCKET, SML_FILE, SML_SIZE);
    fillFile(storage, BUCKET, BIG_FILE, BIG_SIZE);
    BucketInfo requesterPaysBucket = BucketInfo.newBuilder(REQUESTER_PAYS_BUCKET).setRequesterPays(true).build();
    storage.create(requesterPaysBucket);
    fillRequesterPaysFile(storage, SML_FILE, SML_SIZE);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (storage != null) {
      for (String bucket : new String[]{BUCKET, REQUESTER_PAYS_BUCKET}) {
        if (!RemoteStorageHelper.forceDelete(storage, bucket, 5, TimeUnit.SECONDS, project) &&
            log.isLoggable(Level.WARNING)) {
          log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", bucket);
        }
      }
    }
  }

  private static byte[] randomContents(int size) {
    byte[] bytes = new byte[size];
    new Random(size).nextBytes(bytes);
    return bytes;
  }

  private static void fillFile(Storage storage, String bucket, String fname, int size) throws IOException {
    storage.create(BlobInfo.newBuilder(bucket, fname).build(), randomContents(size));
  }

  private static void fillRequesterPaysFile(Storage storage, String fname, int size) throws IOException {
    storage.create(BlobInfo.newBuilder(REQUESTER_PAYS_BUCKET, fname).build(), randomContents(size),
        BlobTargetOption.userProject(project));
  }

  // Start of tests related to the "requester pays" feature
  @Ignore("blocked by #3448")
  @Test
  public void testFileExistsRequesterPaysNoUserProject() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, "");
    Path path = testBucket.getPath(SML_FILE);
    try {
      // fails because we must pay for every access, including metadata.
      Files.exists(path);
      Assert.fail("It should have thrown an exception.");
    } catch (StorageException sex) {
      assertIsRequesterPaysException("testFileExistsRequesterPaysNoUserProject", sex);
    }
  }

  @Test
  public void testFileExistsRequesterPays() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, project);
    Path path = testBucket.getPath(SML_FILE);
    // should succeed because we specified a project
    Files.exists(path);
  }

  @Test
  public void testFileExistsRequesterPaysWithAutodetect() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(true, project);
    Path path = testBucket.getPath(SML_FILE);
    // should succeed because we specified a project
    Files.exists(path);
  }

  @Ignore("blocked by #3448")
  @Test
  public void testCantCreateWithoutUserProject() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, "");
    Path path = testBucket.getPath(SML_FILE);
    try {
      // fails
      Files.write(path, "I would like to write".getBytes());
      Assert.fail("It should have thrown an exception.");
    } catch (StorageException sex) {
      assertIsRequesterPaysException("testCantCreateWithoutUserProject", sex);
    }
  }

  @Test
  public void testCanCreateWithUserProject() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, project);
    Path path = testBucket.getPath(TMP_FILE);
    // should succeed because we specified a project
    Files.write(path, "I would like to write, please?".getBytes());
  }
  
  @Ignore("blocked by #3448")
  @Test
  public void testCantReadWithoutUserProject() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, "");
    Path path = testBucket.getPath(SML_FILE);
    try {
      // fails
      Files.readAllBytes(path);
      Assert.fail("It should have thrown an exception.");
    } catch (StorageException sex) {
      assertIsRequesterPaysException("testCantReadWithoutUserProject", sex);
    }
  }

  @Test
  public void testCanReadWithUserProject() throws IOException {
    CloudStorageFileSystem testBucket = getRequesterPaysBucket(false, project);
    Path path = testBucket.getPath(SML_FILE);
    // should succeed because we specified a project
    Files.readAllBytes(path);
  }

  @Ignore("blocked by #3448")
  @Test
  public void testCantCopyWithoutUserProject() throws IOException {
    CloudStorageFileSystem testRPBucket = getRequesterPaysBucket(false, "");
    CloudStorageFileSystem testBucket = getTestBucket();
    CloudStoragePath[] sources = new CloudStoragePath[] { testBucket.getPath(SML_FILE), testRPBucket.getPath(SML_FILE) };
    CloudStoragePath[] dests = new CloudStoragePath[] {testBucket.getPath(TMP_FILE), testRPBucket.getPath(TMP_FILE) };
    for (int s=0; s<2; s++) {
      for (int d=0; d<2; d++) {
        // normal to normal is out of scope of RP testing.
        if (s==0 && d==0) {
          continue;
        }
        innerTestCantCopyWithoutUserProject(s==0, d==0, sources[s], dests[d]);
      }
    }
  }

  // Try to copy the file, make sure that we were prevented.
  private void innerTestCantCopyWithoutUserProject(boolean sourceNormal, boolean destNormal, Path source, Path dest) throws IOException {
    String sdesc = (sourceNormal?"normal bucket":"requester-pays bucket");
    String ddesc = (destNormal?"normal bucket":"requester-pays bucket");
    String description = "Copying from " + sdesc + " to " + ddesc;
    try {
      Files.copy(source, dest);
      Assert.fail("Shouldn't have been able to copy from " + sdesc + " to " + ddesc);
      // for some reason this throws "GoogleJsonResponseException" instead of "StorageException"
      // when going from requester pays bucket to requester pays bucket, but otherwise we get a
      // normal StorageException.
    } catch (HttpResponseException hex) {
      Assert.assertEquals(description, hex.getStatusCode(), 400);
      Assert.assertTrue(description, hex.getMessage().contains("Bucket is requester pays bucket but no user project provided"));
    } catch (StorageException sex) {
      assertIsRequesterPaysException(description, sex);
    }
  }

  @Test
  public void testCanCopyWithUserProject() throws IOException {
    CloudStorageFileSystem testRPBucket = getRequesterPaysBucket(false, project);
    CloudStorageFileSystem testBucket = getTestBucket();
    CloudStoragePath[] sources = new CloudStoragePath[] {testBucket.getPath(SML_FILE), testRPBucket.getPath(SML_FILE)};
    CloudStoragePath[] dests = new CloudStoragePath[] {testBucket.getPath(TMP_FILE), testRPBucket.getPath(TMP_FILE)};
    for (int s = 0; s < 2; s++) {
      for (int d = 0; d < 2; d++) {
        // normal to normal is out of scope of RP testing.
        if (s == 0 && d == 0) {
          continue;
        }
        Files.copy(sources[s], dests[d], StandardCopyOption.REPLACE_EXISTING);
      }
    }
  }

  @Test
  public void testAutodetectWhenRequesterPays() throws IOException {
    CloudStorageFileSystem testRPBucket = getRequesterPaysBucket(true, project);
    Assert.assertEquals("Autodetect should have detected the RP bucket", testRPBucket.config().userProject(), project);

  }

  @Test
  public void testAutodetectWhenNotRequesterPays() throws IOException {
    CloudStorageConfiguration config = CloudStorageConfiguration.builder()
        .autoDetectRequesterPays(true)
        .userProject(project).build();
    CloudStorageFileSystem testBucket = CloudStorageFileSystem.forBucket(BUCKET, config, storageOptions);
    Assert.assertEquals("Autodetect should have detected the bucket is not RP", testBucket.config().userProject(), "");
  }

  private void assertIsRequesterPaysException(String message, StorageException sex) {
    Assert.assertEquals(message, sex.getCode(), 400);
    Assert.assertTrue(message, sex.getMessage().contains("Bucket is requester pays bucket but no user project provided"));
  }

  // End of tests related to the "requester pays" feature

  @Test
  public void testListBuckets() throws IOException {
    boolean bucketFound = false;
    boolean rpBucketFound = false;
    for (Bucket b : CloudStorageFileSystem.listBuckets(project).iterateAll()) {
      bucketFound |= BUCKET.equals(b.getName());
      rpBucketFound |= REQUESTER_PAYS_BUCKET.equals(b.getName());
    }
    assertWithMessage("listBucket should have found the test bucket")
        .that(bucketFound).isTrue();
    assertWithMessage("listBucket should have found the test requester-pays bucket")
        .that(rpBucketFound).isTrue();
  }


  @Test
  public void testFileExists() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(SML_FILE);
    assertThat(Files.exists(path)).isTrue();
  }

  @Test
  public void testFileSize() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(SML_FILE);
    assertThat(Files.size(path)).isEqualTo(SML_SIZE);
  }

  @Test(timeout = 60_000)
  public void testReadByteChannel() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(SML_FILE);
    long size = Files.size(path);
    SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.READ);
    assertThat(chan.size()).isEqualTo(size);
    ByteBuffer buf = ByteBuffer.allocate(SML_SIZE);
    int read = 0;
    while (chan.isOpen()) {
      int rc = chan.read(buf);
      assertThat(chan.size()).isEqualTo(size);
      if (rc < 0) {
        // EOF
        break;
      }
      assertThat(rc).isGreaterThan(0);
      read += rc;
      assertThat(chan.position()).isEqualTo(read);
    }
    assertThat(read).isEqualTo(size);
    byte[] expected = new byte[SML_SIZE];
    new Random(SML_SIZE).nextBytes(expected);
    assertThat(Arrays.equals(buf.array(), expected)).isTrue();
  }

  @Test
  public void testSeek() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(BIG_FILE);
    int size = BIG_SIZE;
    byte[] contents = randomContents(size);
    byte[] sample = new byte[100];
    byte[] wanted;
    byte[] wanted2;
    SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.READ);
    assertThat(chan.size()).isEqualTo(size);

    // check seek
    int dest = size / 2;
    chan.position(dest);
    readFully(chan, sample);
    wanted = Arrays.copyOfRange(contents, dest, dest + 100);
    assertThat(wanted).isEqualTo(sample);
    // now go back and check the beginning
    // (we do 2 locations because 0 is sometimes a special case).
    chan.position(0);
    readFully(chan, sample);
    wanted2 = Arrays.copyOf(contents, 100);
    assertThat(wanted2).isEqualTo(sample);
    // if the two spots in the file have the same contents, then this isn't a good file for this
    // test.
    assertThat(wanted).isNotEqualTo(wanted2);
  }

  @Test
  public void testCreate() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(PREFIX + randomSuffix());
    // file shouldn't exist initially. If it does it's either because it's a leftover
    // from a previous run (so we should delete the file)
    // or because we're misconfigured and pointing to an actually important file
    // (so we should absolutely not delete it).
    // So if the file's here, don't try to fix it automatically, let the user deal with it.
    assertThat(Files.exists(path)).isFalse();
    try {
      Files.createFile(path);
      // now it does, and it has size 0.
      assertThat(Files.exists(path)).isTrue();
      long size = Files.size(path);
      assertThat(size).isEqualTo(0);
    } finally {
      // let's not leave files around
      Files.deleteIfExists(path);
    }
  }

  @Test
  public void testWrite() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(PREFIX + randomSuffix());
    // file shouldn't exist initially. If it does it's either because it's a leftover
    // from a previous run (so we should delete the file)
    // or because we're misconfigured and pointing to an actually important file
    // (so we should absolutely not delete it).
    // So if the file's here, don't try to fix it automatically, let the user deal with it.
    assertThat(Files.exists(path)).isFalse();
    try {
      Files.write(path, FILE_CONTENTS, UTF_8);
      // now it does.
      assertThat(Files.exists(path)).isTrue();

      // let's check that the contents is OK.
      ByteArrayOutputStream wantBytes = new ByteArrayOutputStream();
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(wantBytes, UTF_8));
      for (String content : FILE_CONTENTS) {
        writer.println(content);
      }
      writer.close();
      SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.READ);
      byte[] gotBytes = new byte[(int) chan.size()];
      readFully(chan, gotBytes);
      assertThat(gotBytes).isEqualTo(wantBytes.toByteArray());
    } finally {
      // let's not leave files around
      Files.deleteIfExists(path);
    }
  }

  @Test
  public void testCreateAndWrite() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(PREFIX + randomSuffix());
    // file shouldn't exist initially (see above).
    assertThat(Files.exists(path)).isFalse();
    try {
      Files.createFile(path);
      Files.write(path, FILE_CONTENTS, UTF_8);
      // now it does.
      assertThat(Files.exists(path)).isTrue();

      // let's check that the contents is OK.
      ByteArrayOutputStream wantBytes = new ByteArrayOutputStream();
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(wantBytes, UTF_8));
      for (String content : FILE_CONTENTS) {
        writer.println(content);
      }
      writer.close();
      SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.READ);
      byte[] gotBytes = new byte[(int) chan.size()];
      readFully(chan, gotBytes);
      assertThat(gotBytes).isEqualTo(wantBytes.toByteArray());
    } finally {
      // let's not leave files around
      Files.deleteIfExists(path);
    }
  }

  @Test
  public void testWriteOnClose() throws Exception {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path path = testBucket.getPath(PREFIX + randomSuffix());
    // file shouldn't exist initially (see above)
    assertThat(Files.exists(path)).isFalse();
    try {
      long expectedSize = 0;
      try (SeekableByteChannel chan = Files.newByteChannel(path, StandardOpenOption.WRITE)) {
        // writing lots of contents to defeat channel-internal buffering.
        for (String s : FILE_CONTENTS) {
          byte[] sBytes = s.getBytes(UTF_8);
          expectedSize += sBytes.length * 9999;
          for (int i = 0; i < 9999; i++) {
            chan.write(ByteBuffer.wrap(sBytes));
          }
        }
        try {
          Files.size(path);
          // we shouldn't make it to this line. Not using thrown.expect because
          // I still want to run a few lines after the exception.
          Assert.fail("Files.size should have thrown an exception");
        } catch (NoSuchFileException nsf) {
          // that's what we wanted, we're good.
        }
      }
      // channel now closed, the file should be there and with the new contents.
      assertThat(Files.exists(path)).isTrue();
      assertThat(Files.size(path)).isEqualTo(expectedSize);
    } finally {
      Files.deleteIfExists(path);
    }
  }

  @Test
  public void testCopy() throws IOException {
    CloudStorageFileSystem testBucket = getTestBucket();
    Path src = testBucket.getPath(SML_FILE);
    Path dst = testBucket.getPath(PREFIX + randomSuffix());
    // file shouldn't exist initially (see above).
    assertThat(Files.exists(dst)).isFalse();
    try {
      Files.copy(src, dst);

      assertThat(Files.exists(dst)).isTrue();
      assertThat(Files.size(dst)).isEqualTo(SML_SIZE);
      byte[] got = new byte[SML_SIZE];
      readFully(Files.newByteChannel(dst), got);
      assertThat(got).isEqualTo(randomContents(SML_SIZE));
    } finally {
      // let's not leave files around
      Files.deleteIfExists(dst);
    }
  }

  @Test
  public void testListFiles() throws IOException {
    try (FileSystem fs = getTestBucket()) {
      List<Path> goodPaths = new ArrayList<>();
      List<Path> paths = new ArrayList<>();
      goodPaths.add(fs.getPath("dir/angel"));
      goodPaths.add(fs.getPath("dir/alone"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("atroot"));
      paths.addAll(goodPaths);
      goodPaths.add(fs.getPath("dir/dir2/"));
      for (Path path : paths) {
        fillFile(storage, BUCKET, path.toString(), SML_SIZE);
      }

      List<Path> got = new ArrayList<>();
      for (String folder : new String[]{"/dir/", "/dir", "dir/", "dir"}) {
        got.clear();
        for (Path path : Files.newDirectoryStream(fs.getPath(folder))) {
          got.add(path);
        }
        assertWithMessage("Listing " + folder+": ").that(got).containsExactlyElementsIn(goodPaths);
      }


      // clean up
      for (Path path : paths) {
        Files.delete(path);
      }
    }
  }

  @Test
  public void testRelativityOfResolve() throws IOException {
    try (FileSystem fs = getTestBucket()) {
      Path abs1 = fs.getPath("/dir");
      Path abs2 = abs1.resolve("subdir/");
      Path rel1 = fs.getPath("dir");
      Path rel2 = rel1.resolve("subdir/");
      // children of absolute paths are absolute,
      // children of relative paths are relative.
      assertThat(abs1.isAbsolute()).isTrue();
      assertThat(abs2.isAbsolute()).isTrue();
      assertThat(rel1.isAbsolute()).isFalse();
      assertThat(rel2.isAbsolute()).isFalse();
    }
  }

  @Test
  public void testWalkFiles() throws IOException {
    try (FileSystem fs = getTestBucket()) {
      List<Path> goodPaths = new ArrayList<>();
      List<Path> paths = new ArrayList<>();
      goodPaths.add(fs.getPath("dir/angel"));
      goodPaths.add(fs.getPath("dir/alone"));
      paths.add(fs.getPath("dir/dir2/another_angel"));
      paths.add(fs.getPath("atroot"));
      paths.addAll(goodPaths);
      for (Path path : paths) {
        fillFile(storage, BUCKET, path.toString(), SML_SIZE);
      }
      // Given a relative path as starting point, walkFileTree must return only relative paths.
      List<Path> relativePaths = PostTraversalWalker.walkFileTree(fs.getPath("dir/"));
      for (Path p : relativePaths) {
        assertWithMessage("Should have been relative: " + p.toString()).that(p.isAbsolute()).isFalse();
      }
      // The 5 paths are:
      // dir/, dir/angel, dir/alone, dir/dir2/, dir/dir2/another_angel.
      assertThat(relativePaths.size()).isEqualTo(5);

      // Given an absolute path as starting point, walkFileTree must return only relative paths.
      List<Path> absolutePaths = PostTraversalWalker.walkFileTree(fs.getPath("/dir/"));
      for (Path p : absolutePaths) {
        assertWithMessage("Should have been absolute: " + p.toString()).that(p.isAbsolute()).isTrue();
      }
      assertThat(absolutePaths.size()).isEqualTo(5);
    }
  }


  @Test
  public void testDeleteRecursive() throws IOException {
    try (FileSystem fs = getTestBucket()) {
      List<Path> paths = new ArrayList<>();
      paths.add(fs.getPath("Racine"));
      paths.add(fs.getPath("playwrights/Moliere"));
      paths.add(fs.getPath("playwrights/French/Corneille"));
      for (Path path : paths) {
        Files.write(path, FILE_CONTENTS, UTF_8);
      }
      deleteRecursive(fs.getPath("playwrights/"));
      assertThat(Files.exists(fs.getPath("playwrights/Moliere"))).isFalse();
      assertThat(Files.exists(fs.getPath("playwrights/French/Corneille"))).isFalse();
      assertThat(Files.exists(fs.getPath("Racine"))).isTrue();
      Files.deleteIfExists(fs.getPath("Racine"));
      assertThat(Files.exists(fs.getPath("Racine"))).isFalse();
    }
  }

  @Test
  public void testListFilesInRootDirectory() throws IOException {
    // We must explicitly set the storageOptions, because the unit tests
    // set the fake storage as default but we want to access the real storage.
    CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket(
      BUCKET, CloudStorageConfiguration.builder().permitEmptyPathComponents(true)
      .build(), storageOptions);

    // test absolute path, relative path.
    for (String check : new String[]{".", "/", ""}) {
      Path rootPath = fs.getPath(check);
      List<String> objectNames = new ArrayList<>();
      for (Path path : Files.newDirectoryStream(rootPath)) {
        objectNames.add(path.toString());
      }
      assertWithMessage("Listing " + check + ": ").that(objectNames).containsExactly(BIG_FILE, SML_FILE);
    }
  }

  @Test
  public void testFakeDirectories() throws IOException {
    try (FileSystem fs = getTestBucket()) {
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

      // clean up
      for (Path path : paths) {
        Files.delete(path);
      }
    }
  }

  /**
   * Delete the given directory and all of its contents if non-empty.
   * @param directory the directory to delete
   * @throws IOException
   */
  private static void deleteRecursive(Path directory) throws IOException {
    Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
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

  private int readFully(ReadableByteChannel chan, byte[] outputBuf) throws IOException {
    ByteBuffer buf = ByteBuffer.wrap(outputBuf);
    int sofar = 0;
    int bytes = buf.remaining();
    while (sofar < bytes) {
      int read = chan.read(buf);
      if (read < 0) {
        throw new EOFException("channel EOF");
      }
      sofar += read;
    }
    return sofar;
  }

  private String randomSuffix() {
    return "-" + rnd.nextInt(99999);
  }

  private static class PostTraversalWalker extends SimpleFileVisitor<Path> {
    private final List<Path> paths = new ArrayList<>();

    // Traverse the tree, return the list of files and folders.
    static public ImmutableList<Path> walkFileTree(Path start) throws IOException {
      PostTraversalWalker walker = new PostTraversalWalker();
      Files.walkFileTree(start, walker);
      return walker.getPaths();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      paths.add(file);
      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
      paths.add(dir);
      return FileVisitResult.CONTINUE;
    }

    public ImmutableList<Path> getPaths() {
      return copyOf(paths);
    }
  }

  private CloudStorageFileSystem getTestBucket() throws IOException {
    // in typical usage we use the single-argument version of forBucket
    // and rely on the user being logged into their project with the
    // gcloud tool, and then everything authenticates automagically
    // (or we just use paths that start with "gs://" and rely on NIO's magic).
    //
    // However for the tests we want to be able to run in automated environments
    // where we can set environment variables but not necessarily install gcloud
    // or run it. That's why we're setting the credentials programmatically.
    return CloudStorageFileSystem.forBucket(
        BUCKET, CloudStorageConfiguration.DEFAULT, storageOptions);
  }

  // same as getTestBucket, but for the requester-pays bucket.
  private CloudStorageFileSystem getRequesterPaysBucket(boolean autodetect, String userProject) throws IOException {
    CloudStorageConfiguration config = CloudStorageConfiguration.builder()
        .autoDetectRequesterPays(autodetect)
        .userProject(userProject).build();
    return CloudStorageFileSystem.forBucket(
        REQUESTER_PAYS_BUCKET, config, storageOptions);
  }
}
