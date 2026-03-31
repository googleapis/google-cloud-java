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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture.ObjectAndContent;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITReadChannelGzipHandlingTest {

  @Inject public Storage storage;
  @Inject public ObjectsFixture objFixture;

  @Test
  public void nonGzipObjectReadOneByteAtATimeNoLibraryBuffering() throws IOException {
    ObjectAndContent obj512KiB = objFixture.getObj512KiB();
    BlobInfo info = obj512KiB.getInfo();
    BlobId blobId = info.getBlobId();
    byte[] bytes = new byte[1];
    BlobSourceOption attemptGzipDecompression = BlobSourceOption.shouldReturnRawInputStream(false);
    try (ReadChannel reader = storage.reader(blobId, attemptGzipDecompression)) {
      reader.setChunkSize(0);

      // read zero bytes, to trigger things to startup but don't actually pull out any bytes yes
      reader.read(ByteBuffer.allocate(0));

      byte[] content = obj512KiB.getContent().getBytes();
      for (int i = 0; i < info.getSize(); i++) {
        int read = reader.read(ByteBuffer.wrap(bytes));
        assertThat(read).isEqualTo(1);
        byte b = bytes[0];
        assertThat(b).isEqualTo(content[i]);
      }
    }
  }
}
