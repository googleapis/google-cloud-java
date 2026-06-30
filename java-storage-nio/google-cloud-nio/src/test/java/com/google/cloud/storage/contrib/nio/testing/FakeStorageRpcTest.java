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
package com.google.cloud.storage.contrib.nio.testing;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper.FakeStorageRpcFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.junit.Test;

public final class FakeStorageRpcTest {

  @Test
  public void overwritingAnObjectOverwritesItsContent() throws IOException {
    Storage storage =
        StorageOptions.http()
            .setServiceRpcFactory(new FakeStorageRpcFactory())
            .build()
            .getService();

    try (WriteChannel writer =
        storage.writer(
            BlobInfo.newBuilder(BlobId.of("bucket", "obj", 0L)).build(),
            BlobWriteOption.generationMatch())) {
      writer.write(ByteBuffer.wrap("abc".getBytes(StandardCharsets.UTF_8)));
    }
    Blob gen1 = storage.get(BlobId.of("bucket", "obj"));
    // get existing generation
    String gen1read1 = new String(gen1.getContent(), StandardCharsets.UTF_8);
    assertThat(gen1read1).isEqualTo("abc");
    System.out.println("gen1read1 = " + gen1read1);

    // start an upload that will overwrite the existing generation
    WriteChannel writer = storage.writer(gen1, BlobWriteOption.generationMatch());
    writer.write(ByteBuffer.wrap("def".getBytes(StandardCharsets.UTF_8)));
    // make sure we can still read the existing generations value after starting but before closing
    String gen1read2 = new String(gen1.getContent(), StandardCharsets.UTF_8);
    assertThat(gen1read2).isEqualTo("abc");
    writer.close();

    Blob gen2 = storage.get(BlobId.of("bucket", "obj"));
    String gen2read1 = new String(gen2.getContent(), StandardCharsets.UTF_8);
    System.out.println("gen2read1 = " + gen2read1);
    assertThat(gen2read1).isEqualTo("def");
  }

  @Test
  public void multiChunkUploadWorks() throws Exception {
    FakeStorageRpcFactory serviceRpcFactory = new FakeStorageRpcFactory();
    HttpStorageOptions options =
        StorageOptions.http().setServiceRpcFactory(serviceRpcFactory).build();
    try (Storage storage = options.getService()) {

      byte[] bytes = new byte[256 * 1024 + 37];
      Arrays.fill(bytes, (byte) 'A');

      BlobId id = BlobId.of("bucket", "object");
      BlobInfo info = BlobInfo.newBuilder(id).build();
      try (WriteChannel writeChannel = storage.writer(info)) {
        writeChannel.setChunkSize(256 * 1024);
        writeChannel.write(ByteBuffer.wrap(bytes));
      }
      byte[] actual = storage.readAllBytes(id);
      assertThat(actual).isEqualTo(bytes);
    }
  }
}
