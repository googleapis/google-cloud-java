/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.MultipartUploadClient;
import com.google.cloud.storage.MultipartUploadSettings;
import com.google.cloud.storage.RequestBody;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompletedMultipartUpload;
import com.google.cloud.storage.multipartupload.model.CompletedPart;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP},
    backends = {Backend.PROD})
public final class ITMultipartUploadClientTest {

  private static final int _5MiB = 5 * 1024 * 1024;

  @Inject public BucketInfo bucket;

  @Inject public Storage injectedStorage;

  @Inject public Transport transport;

  @Inject public Generator generator;

  private MultipartUploadClient multipartUploadClient;

  @Before
  public void setUp() {
    multipartUploadClient =
        MultipartUploadClient.create(
            MultipartUploadSettings.of((HttpStorageOptions) injectedStorage.getOptions()));
  }

  @Test
  public void testMultipartUpload() throws IOException {
    doTest(12 * _5MiB + 37);
  }

  @Test
  public void testMultipartUpload_parallel() throws Exception {
    // This test is slow and resource-intensive.
    long objectSize = 513 * 1024 * 1024 + 29; // 513 MiB + 29 bytes
    int partSize = 8 * 1024 * 1024; // 8 MiB

    Path tempFile = Files.createTempFile("multipart-upload-it", ".bin");
    try {
      createRandomFile(tempFile, objectSize);

      BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
      CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
      String uploadId = createResponse.uploadId();

      List<CompletedPart> completedParts =
          parallelUpload(info, uploadId, tempFile, objectSize, partSize);

      completeMultipartUpload(info, uploadId, completedParts);

      Blob result = injectedStorage.get(info.getBlobId());
      assertThat(result).isNotNull();
      assertThat(result.getSize()).isEqualTo(objectSize);

      verifyContents(info, tempFile);
    } finally {
      Files.deleteIfExists(tempFile);
    }
  }

  @Test
  public void testAbort() {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    byte[] bytes = DataGenerator.rand(new Random()).genBytes(_5MiB);

    uploadPart(info, uploadId, 1, bytes);
    abortMultipartUpload(info, uploadId);

    Blob blob = injectedStorage.get(info.getBlobId());
    assertThat(blob).isNull();
  }

  @Test
  public void testMultipartUpload_singlePart() throws IOException {
    doTest(_5MiB - 1);
  }

  @Test
  public void testMultipartUpload_zeroByteFile() {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();
    byte[] bytes = new byte[0];

    UploadPartResponse uploadPartResponse = uploadPart(info, uploadId, 1, bytes);

    List<CompletedPart> completedParts = new ArrayList<>();
    completedParts.add(
        CompletedPart.builder().partNumber(1).eTag(uploadPartResponse.eTag()).build());

    completeMultipartUpload(info, uploadId, completedParts);

    Blob result = injectedStorage.get(info.getBlobId());
    byte[] actual = injectedStorage.readAllBytes(info.getBlobId());

    assertThat(result).isNotNull();
    assertThat(result.getSize()).isEqualTo(0);
    assertBytesEqual(actual, new byte[0]);
  }

  @Test
  public void testComplete_noParts() {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    List<CompletedPart> completedParts = new ArrayList<>();
    try {
      completeMultipartUpload(info, uploadId, completedParts);
      fail("Expected StorageException");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("MalformedCompleteMultipartUploadRequest");
    } finally {
      // cleanup
      abortMultipartUpload(info, uploadId);
    }
  }

  @Test
  public void testListParts_afterAbort() {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    byte[] bytes = DataGenerator.rand(new Random()).genBytes(_5MiB);
    uploadPart(info, uploadId, 1, bytes);

    abortMultipartUpload(info, uploadId);

    try {
      ListPartsRequest.Builder listPartsBuilder =
          ListPartsRequest.builder()
              .bucket(info.getBucket())
              .key(info.getName())
              .uploadId(uploadId);
      multipartUploadClient.listParts(listPartsBuilder.build());
      fail("Expected StorageException");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("The requested upload was not found.");
    }
  }

  @Test
  public void testComplete_wrongETag() {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    Random rand = new Random();
    byte[] bytes1 = DataGenerator.rand(rand).genBytes(_5MiB);
    UploadPartResponse uploadPartResponse1 = uploadPart(info, uploadId, 1, bytes1);

    byte[] bytes2 = DataGenerator.rand(rand).genBytes(_5MiB);
    uploadPart(info, uploadId, 2, bytes2);

    List<CompletedPart> completedParts = new ArrayList<>();
    completedParts.add(
        CompletedPart.builder().partNumber(1).eTag(uploadPartResponse1.eTag()).build());
    completedParts.add(
        CompletedPart.builder().partNumber(2).eTag("\"dummytag\"").build()); // wrong etag

    try {
      completeMultipartUpload(info, uploadId, completedParts);
      fail("Expected StorageException");
    } catch (StorageException e) {
      assertThat(e.getMessage()).contains("The requested upload part was not found.");
    } finally {
      abortMultipartUpload(info, uploadId);
    }
  }

  @Test
  public void testUploadPart_withCustomChecksum() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    ChecksummedTestContent content =
        ChecksummedTestContent.of("hello world".getBytes(StandardCharsets.UTF_8));

    UploadPartRequest request =
        UploadPartRequest.builder()
            .bucket(info.getBucket())
            .key(info.getName())
            .uploadId(uploadId)
            .partNumber(1)
            .crc32c(content.getCrc32cBase64())
            .build();
    UploadPartResponse response =
        multipartUploadClient.uploadPart(request, RequestBody.of(content.asByteBuffer()));
    assertThat(response).isNotNull();
    assertThat(response.eTag()).isNotNull();

    abortMultipartUpload(info, uploadId);
  }

  @Test
  public void testUploadPart_withCustomChecksum_fail() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();

    ChecksummedTestContent content =
        ChecksummedTestContent.of("hello world".getBytes(StandardCharsets.UTF_8));

    UploadPartRequest request =
        UploadPartRequest.builder()
            .bucket(info.getBucket())
            .key(info.getName())
            .uploadId(uploadId)
            .partNumber(1)
            .crc32c("1234") // Invalid checksum
            .build();
    try {
      multipartUploadClient.uploadPart(request, RequestBody.of(content.asByteBuffer()));
      fail("Expected StorageException");
    } catch (StorageException e) {
      assertThat(e.getMessage())
          .contains("The CRC32C you specified did not match what we computed.");
    } finally {
      abortMultipartUpload(info, uploadId);
    }
  }

  private void doTest(int objectSizeBytes) throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    CreateMultipartUploadResponse createResponse = createMultipartUpload(info);
    String uploadId = createResponse.uploadId();
    byte[] bytes = DataGenerator.rand(new Random()).genBytes(objectSizeBytes);

    List<CompletedPart> completedParts = new ArrayList<>();
    int partNumber = 1;
    for (int i = 0; i < objectSizeBytes; i += _5MiB) {
      int len = Math.min(_5MiB, objectSizeBytes - i);
      byte[] partBuffer = java.util.Arrays.copyOfRange(bytes, i, i + len);
      UploadPartResponse uploadPartResponse = uploadPart(info, uploadId, partNumber, partBuffer);
      completedParts.add(
          CompletedPart.builder().partNumber(partNumber).eTag(uploadPartResponse.eTag()).build());
      partNumber++;
    }
    completedParts.sort(Comparator.comparingInt(CompletedPart::partNumber));

    ListPartsRequest.Builder listPartsBuilder =
        ListPartsRequest.builder().bucket(info.getBucket()).key(info.getName()).uploadId(uploadId);
    ListPartsResponse listPartsResponse = multipartUploadClient.listParts(listPartsBuilder.build());
    assertThat(listPartsResponse.parts()).hasSize(completedParts.size());

    completeMultipartUpload(info, uploadId, completedParts);

    Blob result = injectedStorage.get(info.getBlobId());
    byte[] actual = injectedStorage.readAllBytes(info.getBlobId());

    assertThat(result).isNotNull();
    assertBytesEqual(actual, bytes);
  }

  private void assertBytesEqual(byte[] actual, byte[] expected) {
    assertThat(actual).isEqualTo(expected);
    assertThat(xxd(actual)).isEqualTo(xxd(expected));
  }

  private CreateMultipartUploadResponse createMultipartUpload(BlobInfo info) {
    CreateMultipartUploadRequest createRequest =
        CreateMultipartUploadRequest.builder().bucket(info.getBucket()).key(info.getName()).build();
    return multipartUploadClient.createMultipartUpload(createRequest);
  }

  private UploadPartResponse uploadPart(
      BlobInfo info, String uploadId, int partNumber, byte[] bytes) {
    RequestBody body = RequestBody.of(ByteBuffer.wrap(bytes));
    return uploadPart(info, uploadId, partNumber, body);
  }

  private UploadPartResponse uploadPart(
      BlobInfo info, String uploadId, int partNumber, RequestBody body) {
    UploadPartRequest uploadPartRequest =
        UploadPartRequest.builder()
            .partNumber(partNumber)
            .uploadId(uploadId)
            .bucket(info.getBucket())
            .key(info.getName())
            .build();
    return multipartUploadClient.uploadPart(uploadPartRequest, body);
  }

  private void completeMultipartUpload(BlobInfo info, String uploadId, List<CompletedPart> parts) {
    CompletedMultipartUpload completedMultipartUpload =
        CompletedMultipartUpload.builder().parts(parts).build();
    CompleteMultipartUploadRequest completeRequest =
        CompleteMultipartUploadRequest.builder()
            .bucket(info.getBucket())
            .key(info.getName())
            .uploadId(uploadId)
            .multipartUpload(completedMultipartUpload)
            .build();
    multipartUploadClient.completeMultipartUpload(completeRequest);
  }

  private void abortMultipartUpload(BlobInfo info, String uploadId) {
    AbortMultipartUploadRequest abortRequest =
        AbortMultipartUploadRequest.builder()
            .bucket(info.getBucket())
            .key(info.getName())
            .uploadId(uploadId)
            .build();
    multipartUploadClient.abortMultipartUpload(abortRequest);
  }

  private void createRandomFile(Path path, long size) throws IOException {
    try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(path))) {
      byte[] buffer = new byte[1024 * 1024]; // 1MB buffer
      Random random = new Random();
      for (long i = 0; i < size; i += buffer.length) {
        random.nextBytes(buffer);
        int len = (int) Math.min(buffer.length, size - i);
        os.write(buffer, 0, len);
      }
    }
  }

  private List<CompletedPart> parallelUpload(
      BlobInfo info, String uploadId, Path localFile, long objectSize, int partSize)
      throws ExecutionException, InterruptedException {
    int numThreads = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    List<Future<CompletedPart>> futures = new ArrayList<>();

    long numParts = (objectSize + partSize - 1) / partSize;

    for (int i = 0; i < numParts; i++) {
      final int partNumber = i + 1;
      final long offset = (long) i * partSize;
      final long len = Math.min(partSize, objectSize - offset);

      Callable<CompletedPart> uploadTask =
          () -> {
            ByteBuffer partBuffer = ByteBuffer.allocate((int) len);
            try (FileChannel fileChannel = FileChannel.open(localFile, StandardOpenOption.READ)) {
              fileChannel.read(partBuffer, offset);
            }
            partBuffer.flip();
            RequestBody partBody = RequestBody.of(partBuffer);
            UploadPartResponse uploadPartResponse =
                uploadPart(info, uploadId, partNumber, partBody);
            return CompletedPart.builder()
                .partNumber(partNumber)
                .eTag(uploadPartResponse.eTag())
                .build();
          };
      futures.add(executor.submit(uploadTask));
    }

    List<CompletedPart> completedParts = new ArrayList<>();
    for (Future<CompletedPart> future : futures) {
      completedParts.add(future.get());
    }
    executor.shutdown();

    completedParts.sort(Comparator.comparingInt(CompletedPart::partNumber));
    return completedParts;
  }

  private void verifyContents(BlobInfo info, Path expectedFile) throws IOException {
    try (ReadChannel reader = injectedStorage.reader(info.getBlobId());
        InputStream expectedStream = new BufferedInputStream(Files.newInputStream(expectedFile))) {

      ByteBuffer cloudBuffer = ByteBuffer.allocate(1024 * 1024); // 1MB buffer

      while (reader.read(cloudBuffer) > 0) {
        cloudBuffer.flip();

        byte[] actualBytes = new byte[cloudBuffer.remaining()];
        cloudBuffer.get(actualBytes);

        byte[] expectedBytes = new byte[actualBytes.length];
        int bytesRead = 0;
        while (bytesRead < expectedBytes.length) {
          int readResult =
              expectedStream.read(expectedBytes, bytesRead, expectedBytes.length - bytesRead);
          if (readResult == -1) {
            break;
          }
          bytesRead += readResult;
        }

        assertThat(bytesRead).isEqualTo(expectedBytes.length);
        assertBytesEqual(actualBytes, expectedBytes);
        cloudBuffer.clear();
      }
      assertThat(expectedStream.read()).isEqualTo(-1); // Ensure we have read the whole local file
    }
  }
}
