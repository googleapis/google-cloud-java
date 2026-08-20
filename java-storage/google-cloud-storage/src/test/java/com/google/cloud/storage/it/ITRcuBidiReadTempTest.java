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
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.AsyncSessionClosedException;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public final class ITRcuBidiReadTempTest {

  private static final String PROJECT_ID = "gcs-hyd-connector-benchmarks";
  private static final String BUCKET_NAME = "java-storage-reg-rapid-preprod-3fe2bb58"; // Reusing active bucket with running cache
  private static Storage storage;

  @BeforeClass
  public static void setUpClass() throws Exception {
    System.out.println("Initializing storage client pointing to pre-prod endpoint...");
    storage = StorageOptions.grpc()
        .setHost("storage-preprod-test-grpc.googleusercontent.com:443")
        .setProjectId(PROJECT_ID)
        .build()
        .getService();
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    // No cleanup of BUCKET_NAME since it is a shared pre-created bucket
  }

  @Test
  public void readPostStreamClose() throws Exception {
    System.out.println("Running readPostStreamClose against bucket " + BUCKET_NAME);

    // Generate 5MB of random data
    int dataSize = 5 * 1024 * 1024;
    byte[] data = new byte[dataSize];
    new Random().nextBytes(data);

    BlobId blobId = BlobId.of(BUCKET_NAME, "test-bidi-read-close-temp-" + UUID.randomUUID());
    storage.create(BlobInfo.newBuilder(blobId).build(), data);

    try {
      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(blobId);
      try (BlobReadSession session = futureSession.get(10, TimeUnit.SECONDS)) {
        // Start a future read for the entire object
        ApiFuture<byte[]> readFuture = session.readAs(ReadProjectionConfigs.asFutureBytes());

        // Close the session immediately while the transfer is in flight
        session.close();

        // Resolving the future should now fail since the session is closed
        try {
          readFuture.get(5, TimeUnit.SECONDS);
          fail("Expected ExecutionException when reading after session close");
        } catch (ExecutionException e) {
          Throwable cause = e.getCause();
          assertThat(cause).isInstanceOf(StorageException.class);
          assertThat(cause.getCause()).isInstanceOf(AsyncSessionClosedException.class);
          System.out.println("Successfully caught expected exception: " + cause.getMessage());
        }
      }
    } finally {
      storage.delete(blobId);
    }
  }

  @Test
  public void zeroCopyRangeReads() throws Exception {
    System.out.println("Running zeroCopyRangeReads against bucket " + BUCKET_NAME);

    // Generate 1MB of random data
    int dataSize = 1024 * 1024;
    byte[] data = new byte[dataSize];
    new Random().nextBytes(data);

    BlobId blobId = BlobId.of(BUCKET_NAME, "test-bidi-zero-copy-temp-" + UUID.randomUUID());
    storage.create(BlobInfo.newBuilder(blobId).build(), data);

    try {
      // Define 3 non-overlapping ranges
      RangeSpec r1 = RangeSpec.of(0, 1000);
      RangeSpec r2 = RangeSpec.of(50000, 250000);
      RangeSpec r3 = RangeSpec.of(800000, 10000);

      ApiFuture<BlobReadSession> futureSession = storage.blobReadSession(blobId);
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
          byte[] expected = Arrays.copyOfRange(data, 0, 1000);
          assertThat(d1.byteString().toByteArray()).isEqualTo(expected);
        }

        // Resolve and verify Range 2
        try (DisposableByteString d2 = f2.get(10, TimeUnit.SECONDS)) {
          assertThat(d2).isNotNull();
          byte[] expected = Arrays.copyOfRange(data, 50000, 50000 + 250000);
          assertThat(d2.byteString().toByteArray()).isEqualTo(expected);
        }

        // Resolve and verify Range 3
        try (DisposableByteString d3 = f3.get(10, TimeUnit.SECONDS)) {
          assertThat(d3).isNotNull();
          byte[] expected = Arrays.copyOfRange(data, 800000, 800000 + 10000);
          assertThat(d3.byteString().toByteArray()).isEqualTo(expected);
        }
        System.out.println("Successfully validated concurrent zero-copy range reads!");
      }
    } finally {
      storage.delete(blobId);
    }
  }
}
