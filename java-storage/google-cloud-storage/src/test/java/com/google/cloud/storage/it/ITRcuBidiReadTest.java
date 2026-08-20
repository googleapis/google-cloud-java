/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.cloud.storage.AsyncSessionClosedException;
import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.LocationType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.GRPC},
    locations = {
      LocationType.REGIONAL_RAPID
    })
public final class ITRcuBidiReadTest {

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Backend backend;
  @Inject public Transport transport;

  private static boolean initialized = false;
  private static Storage staticStorage;
  private static BlobId closeTestBlobId;
  private static BlobId zeroCopyTestBlobId;
  private static BlobId multipleRangeTestBlobId;
  private static BlobId outOfRangeTestBlobId;

  private static byte[] closeTestData;
  private static byte[] zeroCopyTestData;
  private static byte[] multipleRangeTestData;
  private static byte[] outOfRangeTestData;

  @Before
  public void setUp() throws Exception {
    if (initialized) {
      return;
    }
    initialized = true;
    staticStorage = storage;

    // Generate test data
    closeTestData = new byte[5 * 1024 * 1024];
    new Random().nextBytes(closeTestData);

    zeroCopyTestData = new byte[1024 * 1024];
    new Random().nextBytes(zeroCopyTestData);

    multipleRangeTestData = new byte[2 * 1024 * 1024];
    new Random().nextBytes(multipleRangeTestData);

    outOfRangeTestData = new byte[100 * 1024];
    new Random().nextBytes(outOfRangeTestData);

    closeTestBlobId = BlobId.of(bucket.getName(), "test-bidi-read-close-" + UUID.randomUUID());
    zeroCopyTestBlobId = BlobId.of(bucket.getName(), "test-bidi-zero-copy-" + UUID.randomUUID());
    multipleRangeTestBlobId = BlobId.of(bucket.getName(), "test-bidi-multiple-range-" + UUID.randomUUID());
    outOfRangeTestBlobId = BlobId.of(bucket.getName(), "test-bidi-out-of-range-" + UUID.randomUUID());

    System.out.println("Pre-creating objects for read integration tests...");
    createObjectForWarming(closeTestBlobId, closeTestData);
    createObjectForWarming(zeroCopyTestBlobId, zeroCopyTestData);
    createObjectForWarming(multipleRangeTestBlobId, multipleRangeTestData);
    createObjectForWarming(outOfRangeTestBlobId, outOfRangeTestData);

    if (bucket.getName().contains("reg-rapid")) {
      System.out.println("Regional Rapid bucket detected. Triggering Ingest-On-Read on all objects...");
      triggerIngestOnRead(closeTestBlobId);
      triggerIngestOnRead(zeroCopyTestBlobId);
      triggerIngestOnRead(multipleRangeTestBlobId);
      triggerIngestOnRead(outOfRangeTestBlobId);

      System.out.println("Sleeping for 30 minutes to allow background uptiering to RZ...");
      Thread.sleep(30 * 60 * 1000); // 30 minutes
      System.out.println("Wake up! Continuing with integration test execution.");
    }
  }

  private void createObjectForWarming(BlobId blobId, byte[] data) throws Exception {
    StorageClass storageClass = bucket.getStorageClass();
    if (StorageClass.valueOf("RAPID").equals(storageClass)) {
      System.out.println("Bucket is ZONAL_RAPID, writing via Appendable upload with RAPID storage class...");
      BlobInfo info = BlobInfo.newBuilder(blobId)
          .setStorageClass(StorageClass.valueOf("RAPID"))
          .build();
      BlobAppendableUploadConfig config = BlobAppendableUploadConfig.of();
      BlobAppendableUpload upload =
          storage.blobAppendableUpload(info, config, BlobWriteOption.doesNotExist());
      try (AppendableUploadWriteableByteChannel channel = upload.open()) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        while (buffer.hasRemaining()) {
          channel.write(buffer);
        }
        channel.finalizeAndClose();
      }
      upload.getResult().get(10, TimeUnit.SECONDS);
    } else {
      System.out.println("Writing object " + blobId + " via standard create...");
      storage.create(BlobInfo.newBuilder(blobId).build(), data);
    }
  }

  private void triggerIngestOnRead(BlobId blobId) {
    try {
      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(blobId);
      try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
        ApiFuture<byte[]> readFuture = session.readAs(
            ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(0, 100)));
        readFuture.get(10, TimeUnit.SECONDS);
      }
    } catch (Exception e) {
      System.out.println("Warning: Ingest-on-read trigger failed for " + blobId + ": " + e.getMessage());
    }
  }

  @AfterClass
  public static void tearDownClass() {
    if (staticStorage != null) {
      System.out.println("Cleaning up pre-created integration test objects...");
      try {
        if (closeTestBlobId != null) staticStorage.delete(closeTestBlobId);
        if (zeroCopyTestBlobId != null) staticStorage.delete(zeroCopyTestBlobId);
        if (multipleRangeTestBlobId != null) staticStorage.delete(multipleRangeTestBlobId);
        if (outOfRangeTestBlobId != null) staticStorage.delete(outOfRangeTestBlobId);
      } catch (Exception e) {
        System.out.println("Error cleaning up integration test objects: " + e.getMessage());
      }
    }
  }

  @Test
  public void readPostStreamClose() throws Exception {
    Assume.assumeTrue(transport == Transport.GRPC);
    System.out.println(">>> START: readPostStreamClose against bucket " + bucket.getName());

    ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(closeTestBlobId);
    try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
      // Start a future read for the entire object
      ApiFuture<byte[]> readFuture = session.readAs(ReadProjectionConfigs.asFutureBytes());

      // Close the session immediately while the transfer is in flight
      session.close();

      // Resolving the future should now fail since the session is closed
      try {
        readFuture.get(5, TimeUnit.SECONDS);
        Assert.fail("Expected ExecutionException when reading after session close");
      } catch (ExecutionException e) {
        Throwable cause = e.getCause();
        assertThat(cause).isInstanceOf(StorageException.class);
        assertThat(cause.getCause()).isInstanceOf(AsyncSessionClosedException.class);
        System.out.println(">>> SUCCESS: readPostStreamClose verified AsyncSessionClosedException.");
      }
    }
  }

  @Test
  public void zeroCopyRangeReads() throws Exception {
    Assume.assumeTrue(transport == Transport.GRPC);
    System.out.println(">>> START: zeroCopyRangeReads against bucket " + bucket.getName());

    try {
      // Define 3 non-overlapping ranges
      RangeSpec r1 = RangeSpec.of(0, 1000);
      RangeSpec r2 = RangeSpec.of(50000, 250000);
      RangeSpec r3 = RangeSpec.of(800000, 10000);

      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(zeroCopyTestBlobId);
      try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
        // Start concurrent zero-copy range reads
        ApiFuture<DisposableByteString> f1 =
            session.readAs(ReadProjectionConfigs.asFutureByteString().withRangeSpec(r1));
        ApiFuture<DisposableByteString> f2 =
            session.readAs(ReadProjectionConfigs.asFutureByteString().withRangeSpec(r2));
        ApiFuture<DisposableByteString> f3 =
            session.readAs(ReadProjectionConfigs.asFutureByteString().withRangeSpec(r3));

        // Resolve and verify Range 1
        try (DisposableByteString d1 = f1.get(10, TimeUnit.SECONDS)) {
          assertThat(d1).isNotNull();
          byte[] expected = Arrays.copyOfRange(zeroCopyTestData, 0, 1000);
          assertThat(d1.byteString().toByteArray()).isEqualTo(expected);
        }

        // Resolve and verify Range 2
        try (DisposableByteString d2 = f2.get(10, TimeUnit.SECONDS)) {
          assertThat(d2).isNotNull();
          byte[] expected = Arrays.copyOfRange(zeroCopyTestData, 50000, 50000 + 250000);
          assertThat(d2.byteString().toByteArray()).isEqualTo(expected);
        }

        // Resolve and verify Range 3
        try (DisposableByteString d3 = f3.get(10, TimeUnit.SECONDS)) {
          assertThat(d3).isNotNull();
          byte[] expected = Arrays.copyOfRange(zeroCopyTestData, 800000, 800000 + 10000);
          assertThat(d3.byteString().toByteArray()).isEqualTo(expected);
        }
        System.out.println(">>> SUCCESS: zeroCopyRangeReads concurrent offsets verified.");
      }
    } finally {
      // Do not delete
    }
  }

  @Test
  public void multipleRangedRead() throws Exception {
    Assume.assumeTrue(transport == Transport.GRPC);
    System.out.println(">>> START: multipleRangedRead against bucket " + bucket.getName());

    try {
      // Define 4 non-overlapping ranges (each 512KB)
      int rangeSize = 512 * 1024;
      RangeSpec r1 = RangeSpec.of(0, rangeSize);
      RangeSpec r2 = RangeSpec.of(rangeSize, rangeSize);
      RangeSpec r3 = RangeSpec.of(2 * rangeSize, rangeSize);
      RangeSpec r4 = RangeSpec.of(3 * rangeSize, rangeSize);

      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(multipleRangeTestBlobId);
      try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
        // Start concurrent byte range reads
        ApiFuture<byte[]> f1 =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(r1));
        ApiFuture<byte[]> f2 =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(r2));
        ApiFuture<byte[]> f3 =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(r3));
        ApiFuture<byte[]> f4 =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(r4));

        // Resolve and verify Range 1
        byte[] b1 = f1.get(10, TimeUnit.SECONDS);
        assertThat(b1).isEqualTo(Arrays.copyOfRange(multipleRangeTestData, 0, rangeSize));

        // Resolve and verify Range 2
        byte[] b2 = f2.get(10, TimeUnit.SECONDS);
        assertThat(b2).isEqualTo(Arrays.copyOfRange(multipleRangeTestData, rangeSize, 2 * rangeSize));

        // Resolve and verify Range 3
        byte[] b3 = f3.get(10, TimeUnit.SECONDS);
        assertThat(b3).isEqualTo(Arrays.copyOfRange(multipleRangeTestData, 2 * rangeSize, 3 * rangeSize));

        // Resolve and verify Range 4
        byte[] b4 = f4.get(10, TimeUnit.SECONDS);
        assertThat(b4).isEqualTo(Arrays.copyOfRange(multipleRangeTestData, 3 * rangeSize, 4 * rangeSize));

        System.out.println(">>> SUCCESS: multipleRangedRead concurrent offsets verified.");
      }
    } finally {
      // Do not delete
    }
  }

  @Test
  public void readFromBucketThatDoesNotExistShouldRaiseStorageExceptionWith404() throws Exception {
    Assume.assumeTrue(transport == Transport.GRPC);
    System.out.println(">>> START: readFromBucketThatDoesNotExistShouldRaiseStorageExceptionWith404");

    String nonExistentBucketName = "java-storage-non-existent-bucket-" + UUID.randomUUID();
    BlobId blobId = BlobId.of(nonExistentBucketName, "someobject");

    ApiFuture<BlobReadSession> futureObjectReadSession = storage.blobReadSession(blobId);

    try {
      futureObjectReadSession.get(10, TimeUnit.SECONDS);
      Assert.fail("Expected ExecutionException when reading from non-existent bucket");
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      assertThat(cause).isInstanceOf(StorageException.class);
      StorageException se = (StorageException) cause;
      assertThat(se.getCode()).isIn(Arrays.asList(404, 403));
      System.out.println(">>> SUCCESS: readFromBucketThatDoesNotExistShouldRaiseStorageExceptionWith404 verified StorageException 404 or 403.");
    }
  }

  @Test
  public void outOfRange() throws Exception {
    Assume.assumeTrue(transport == Transport.GRPC);
    System.out.println(">>> START: outOfRange against bucket " + bucket.getName());

    try {
      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(outOfRangeTestBlobId);
      try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
        // Start a valid range read on the session first to verify it succeeds
        ApiFuture<byte[]> fValid =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(0, 1000)));
        byte[] bytes = fValid.get(10, TimeUnit.SECONDS);
        assertThat(bytes).isEqualTo(Arrays.copyOfRange(outOfRangeTestData, 0, 1000));

        // Start an out-of-bounds range read (offset > size)
        ApiFuture<byte[]> fOutOfRange =
            session.readAs(ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.beginAt(100 * 1024 + 1000)));

        // Verify that resolving it throws OutOfRangeException
        try {
          fOutOfRange.get(10, TimeUnit.SECONDS);
          Assert.fail("Expected ExecutionException for out-of-bounds range read");
        } catch (ExecutionException e) {
          Throwable cause = e.getCause();
          assertThat(cause).isInstanceOf(StorageException.class);
          assertThat(cause.getCause()).isInstanceOf(OutOfRangeException.class);
        }
        System.out.println(">>> SUCCESS: outOfRange verified valid read success and subsequent out of range exception.");
      }
    } finally {
      // Do not delete
    }
  }
}
