/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.TEST_BENCH},
    transports = Transport.GRPC)
public final class ITBidiAppendableUnbufferedWritableByteChannelTest {

  @Inject public Generator generator;

  @Inject public Storage storage;

  @Inject
  @BucketFixture(BucketType.RAPID)
  public BucketInfo bucket;

  @Inject public Backend backend;

  @Test
  public void nonBufferAlignedWritesLeaveBuffersInTheCorrectState() throws Exception {
    BlobId bid = BlobId.of(bucket.getName(), UUID.randomUUID().toString());
    BlobAppendableUploadConfig config =
        BlobAppendableUploadConfig.of()
            .withFlushPolicy(FlushPolicy.minFlushSize(8 * 1024).withMaxPendingBytes(16 * 1024))
            .withCloseAction(CloseAction.CLOSE_WITHOUT_FINALIZING);
    ChecksummedTestContent ctc = ChecksummedTestContent.gen(16 * 1024 + 5);
    BlobAppendableUpload upload =
        storage.blobAppendableUpload(BlobInfo.newBuilder(bid).build(), config);
    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      // enqueue 4 bytes, this makes it so the following 8K writes don't evenly fit
      checkedEmptyTo(ctc.slice(0, 4).asByteBuffer(), channel);
      checkedEmptyTo(ctc.slice(4, 8192).asByteBuffer(), channel);
      checkedEmptyTo(ctc.slice(4 + 8192, 8192).asByteBuffer(), channel);
      checkedEmptyTo(ctc.slice(4 + 8192 + 8192, 1).asByteBuffer(), channel);
    }
    BlobInfo done1 = upload.getResult().get(5, TimeUnit.SECONDS);
    assertThat(done1.getSize()).isEqualTo(ctc.length());
    assertThat(done1.getCrc32c()).isEqualTo(Utils.crc32cCodec.encode(ctc.getCrc32c()));
  }

  private static int checkedEmptyTo(ByteBuffer buf, WritableByteChannel c) throws Exception {
    int remaining = buf.remaining();
    int position = buf.position();
    int remaining1 = buf.remaining();
    int written = StorageChannelUtils.blockingEmptyTo(buf, c);
    assertAll(
        () -> assertThat(written).isEqualTo(position + remaining1),
        () -> assertThat(buf.position()).isEqualTo(position + written),
        () -> assertThat(buf.remaining()).isEqualTo(remaining1 - written));
    assertThat(written).isEqualTo(remaining);
    return written;
  }
}
