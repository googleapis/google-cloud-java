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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.PackagePrivateMethodWorkarounds;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import java.io.IOException;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITWriteChannelTest {

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void writeChannel_isOpen_onConstruction() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    try (WriteChannel writer = storage.writer(info)) {
      assertThat(writer.isOpen()).isTrue();
    }
  }

  @Test
  public void writeChannel_createsObjectEvenIfWriteNeverCalled() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    WriteChannel w;
    try (WriteChannel writer = storage.writer(info)) {
      w = writer;
      assertThat(writer.isOpen()).isTrue();
    }

    Optional<BlobInfo> internalInfo =
        PackagePrivateMethodWorkarounds.maybeGetBlobInfoFunction().apply(w);

    assertThat(internalInfo.isPresent()).isTrue();

    Blob blob = storage.get(info.getBlobId());
    assertThat(blob).isNotNull();
  }

  @Test
  public void writeChannel_openAfterWriteSmallerThanBlockSize() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    WriteChannel w;
    try (WriteChannel writer = storage.writer(info)) {
      w = writer;
      assertThat(writer.isOpen()).isTrue();

      int write = writer.write(DataGenerator.base64Characters().genByteBuffer(10));
      assertThat(write).isEqualTo(10);

      assertThat(writer.isOpen()).isTrue();
    }

    assertThat(w.isOpen()).isFalse();
  }
}
