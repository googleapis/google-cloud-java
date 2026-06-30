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

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITGzipTest {

  private static final ChecksummedTestContent CHECKSUMMED_TEST_CONTENT =
      ChecksummedTestContent.of("Hello, to the world!!!");
  private static final byte[] GZIPPED_CONTENT =
      TestUtils.gzipBytes(CHECKSUMMED_TEST_CONTENT.getBytes());

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void noMetadata_noOption() {
    String name = generator.randomObjectName();
    BlobInfo info = BlobInfo.newBuilder(bucket, name).build();
    Blob gen1 = storage.create(info, CHECKSUMMED_TEST_CONTENT.getBytes());
    assertThat(gen1.getContentEncoding()).isAnyOf(null, ""); // json null, grpc ""
    byte[] actual =
        storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(true));
    assertThat(xxd(actual)).isEqualTo(xxd(CHECKSUMMED_TEST_CONTENT.getBytes()));
  }

  @Test
  public void yesMetadata_noOption() {
    String name = generator.randomObjectName();
    BlobInfo info = BlobInfo.newBuilder(bucket, name).setContentEncoding("gzip").build();
    Blob gen1 = storage.create(info, GZIPPED_CONTENT);
    assertThat(gen1.getContentEncoding()).isEqualTo("gzip");
    byte[] actual =
        storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(true));
    assertThat(xxd(actual)).isEqualTo(xxd(GZIPPED_CONTENT));
  }

  @Test
  public void noMetadata_yesOption() {
    String name = generator.randomObjectName();
    BlobInfo info = BlobInfo.newBuilder(bucket, name).build();
    Blob gen1 =
        storage.create(
            info, CHECKSUMMED_TEST_CONTENT.getBytes(), BlobTargetOption.disableGzipContent());
    assertThat(gen1.getContentEncoding()).isAnyOf(null, ""); // json null, grpc ""
    byte[] actual =
        storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(true));
    assertThat(xxd(actual)).isEqualTo(xxd(CHECKSUMMED_TEST_CONTENT.getBytes()));
  }

  @Test
  public void yesMetadata_yesOption() {
    String name = generator.randomObjectName();
    BlobInfo info = BlobInfo.newBuilder(bucket, name).setContentEncoding("gzip").build();
    Blob gen1 = storage.create(info, GZIPPED_CONTENT, BlobTargetOption.disableGzipContent());
    assertThat(gen1.getContentEncoding()).isEqualTo("gzip");
    byte[] actual =
        storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(true));
    assertThat(xxd(actual)).isEqualTo(xxd(GZIPPED_CONTENT));

    byte[] actualUncompressed =
        storage.readAllBytes(gen1.getBlobId(), BlobSourceOption.shouldReturnRawInputStream(false));
    assertThat(xxd(actualUncompressed)).isEqualTo(xxd(CHECKSUMMED_TEST_CONTENT.getBytes()));
  }
}
