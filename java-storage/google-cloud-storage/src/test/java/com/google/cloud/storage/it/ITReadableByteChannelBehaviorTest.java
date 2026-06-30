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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.ReadProjectionConfig;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITReadableByteChannelBehaviorTest {

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;
  @Inject public ObjectsFixture objectsFixture;

  @Test
  public void eofReturnedMultipleTimes_reader() throws IOException {
    BlobId id = objectsFixture.getObj512KiB().getInfo().getBlobId();

    try (ReadChannel reader = storage.reader(id)) {
      eofReturnedMultipleTimes_doTest(reader);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void eofReturnedMultipleTimes_blobReadSession_channel()
      throws ExecutionException, InterruptedException, TimeoutException, IOException {
    eofReturnedMultipleTimes_doTestBlobReadSession(ReadProjectionConfigs.asChannel());
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void eofReturnedMultipleTimes_blobReadSession_seekableChannel()
      throws ExecutionException, InterruptedException, TimeoutException, IOException {
    eofReturnedMultipleTimes_doTestBlobReadSession(ReadProjectionConfigs.asSeekableChannel());
  }

  private void eofReturnedMultipleTimes_doTestBlobReadSession(
      ReadProjectionConfig<? extends ReadableByteChannel> config)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    BlobId id = objectsFixture.getObj512KiB().getInfo().getBlobId();

    try (BlobReadSession session = storage.blobReadSession(id).get(3, TimeUnit.SECONDS)) {
      try (ReadableByteChannel c = session.readAs(config)) {
        eofReturnedMultipleTimes_doTest(c);
      }
    }
  }

  private void eofReturnedMultipleTimes_doTest(ReadableByteChannel c) throws IOException {
    long copy = ByteStreams.copy(c, Channels.newChannel(ByteStreams.nullOutputStream()));
    assertThat(copy).isEqualTo(objectsFixture.getObj512KiB().getInfo().getSize());

    ByteBuffer buf = ByteBuffer.allocate(8);
    int i = ThreadLocalRandom.current().nextInt(3, 10);
    for (int j = 0; j < i; j++) {
      assertWithMessage("expected EOF " + j).that(c.read(buf)).isEqualTo(-1);
    }
  }
}
