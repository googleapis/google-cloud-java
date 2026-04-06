/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TestUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

// Intentionally avoid StorageITRunner here. It touches lots of code at a semi-static level making
// native-test have a hard time.
public final class StorageNativeCanary {

  private static final int _256KiB = 256 * 1024;
  private static final byte[] bytes = DataGenerator.base64Characters().genBytes(512 * 1024);

  @Test
  public void canary_happyPath_http() throws Throwable {
    assertBehaviorOfPrimaryStorageActions(StorageOptions.http().build().getService());
  }

  @Test
  public void canary_happyPath_grpc() throws Throwable {
    assertBehaviorOfPrimaryStorageActions(StorageOptions.grpc().build().getService());
  }

  /**
   * When testing on Native Image, we're primarily wanting to verify the primary code paths are
   * properly detected by the native image compiler.
   *
   * <p>For Storage, we have a few "primary code paths" we want to ensure are validated:
   *
   * <ul>
   *   <li>Can a (Unary) Request Succeed?
   *   <li>Can a (ServerStream) Object Read Request Succeed?
   *   <li>Can a (ClientStream) Object Write Request Succeed?
   *   <li>Can a (Page over Unary) Paginated Request Succeed?
   * </ul>
   *
   * To validate this, our happy path test is as follows:
   *
   * <ul>
   *   <li>Create a temporary bucket (Unary)
   *   <li>Insert two (2) objects (Unary, ServerStream)
   *   <li>List all objects, using a pageSize of 1 (Page over Unary)
   *   <li>Read all bytes of each object (ServerStream)
   *   <li>Delete each object (Unary)
   *   <li>Delete temporary bucket (Unary)
   * </ul>
   */
  private static void assertBehaviorOfPrimaryStorageActions(Storage storage) throws Throwable {
    // create a temporary bucket
    try (TemporaryBucket temporaryBucket =
        TemporaryBucket.newBuilder()
            .setStorage(storage)
            .setBucketInfo(BucketInfo.of("java-storage-grpc-" + UUID.randomUUID()))
            .build()) {
      String bucketName = temporaryBucket.getBucket().getName();
      String obj1Name = UUID.randomUUID().toString();
      String obj2Name = UUID.randomUUID().toString();

      // insert 2 objects
      BlobInfo info1 = BlobInfo.newBuilder(bucketName, obj1Name).build();
      BlobInfo info2 = BlobInfo.newBuilder(bucketName, obj2Name).build();
      uploadUsingWriter(storage, info1);
      uploadUsingWriter(storage, info2);

      // list objects
      Page<Blob> page = storage.list(bucketName, BlobListOption.pageSize(1));
      List<Blob> blobs = ImmutableList.copyOf(page.iterateAll());

      // read all bytes of each object
      List<BlobWithContent> actual =
          blobs.stream()
              .map(info -> readAll(storage, info))
              .collect(ImmutableList.toImmutableList());

      List<Boolean> deletes =
          blobs.stream()
              .map(b -> storage.delete(b.getBlobId(), BlobSourceOption.generationMatch()))
              .collect(ImmutableList.toImmutableList());

      assertAll(
          () -> {
            List<String> actualNames =
                actual.stream()
                    .map(BlobWithContent::getInfo)
                    .map(BlobInfo::getBlobId)
                    .map(BlobId::getName)
                    .collect(ImmutableList.toImmutableList());

            assertThat(actualNames).containsExactly(info1.getName(), info2.getName());
          },
          () -> assertThat(actual.get(0).getContent()).isEqualTo(bytes),
          () -> assertThat(actual.get(1).getContent()).isEqualTo(bytes),
          () -> assertThat(deletes.get(0)).isTrue(),
          () -> assertThat(deletes.get(1)).isTrue());
    } catch (Throwable e) {
      String hintMessage =
          "Possible missing reflect-config configuration. Run the following to regenerate grpc"
              + " reflect-config: mvn -Dmaven.test.skip.exec=true clean install && cd"
              + " google-cloud-storage && mvn -Pregen-grpc-graalvm-reflect-config exec:exec";
      Throwable linkageError = TestUtils.findThrowable(LinkageError.class, e);
      Throwable roe = TestUtils.findThrowable(ReflectiveOperationException.class, e);
      if (linkageError != null) {
        throw new RuntimeException(hintMessage, linkageError);
      } else if (roe != null) {
        throw new RuntimeException(hintMessage, roe);
      } else {
        throw e;
      }
    }
  }

  private static void uploadUsingWriter(Storage storage, BlobInfo info) throws IOException {
    try (WriteChannel writeChannel = storage.writer(info, BlobWriteOption.doesNotExist())) {
      // set our size to the smallest resumable size, so we can send multiple requests
      writeChannel.setChunkSize(_256KiB);
      ByteStreams.copy(Channels.newChannel(new ByteArrayInputStream(bytes)), writeChannel);
    }
  }

  private static BlobWithContent readAll(Storage storage, BlobInfo info) {
    try (ReadChannel readChannel =
            storage.reader(info.getBlobId(), BlobSourceOption.generationMatch());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WritableByteChannel writeChannel = Channels.newChannel(outputStream)) {
      // only buffer up to half the object
      readChannel.setChunkSize(_256KiB);
      ByteStreams.copy(readChannel, writeChannel);
      return new BlobWithContent(info, outputStream.toByteArray());
    } catch (IOException e) {
      throw new RuntimeIOException(e);
    }
  }

  private static final class BlobWithContent {
    private final BlobInfo info;
    private final byte[] content;

    private BlobWithContent(BlobInfo info, byte[] content) {
      this.info = info;
      this.content = content;
    }

    public BlobInfo getInfo() {
      return info;
    }

    public byte[] getContent() {
      return content;
    }
  }

  private static final class RuntimeIOException extends RuntimeException {
    private RuntimeIOException(IOException cause) {
      super(cause);
    }
  }
}
