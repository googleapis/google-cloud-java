/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.object;

// [START storage_read_appendable_object_tail]

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.FlushPolicy;
import com.google.cloud.storage.RangeSpec;
import com.google.cloud.storage.ReadProjectionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageChannelUtils;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class ReadAppendableObjectTail {
  public static void readAppendableObjectTail(String bucketName, String objectName)
      throws Exception {
    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    try (Storage storage = StorageOptions.grpc().build().getService()) {
      BlobId blobId = BlobId.of(bucketName, objectName);
      BlobInfo info = BlobInfo.newBuilder(blobId).build();
      int totalToWrite = 64 * 1000;
      // Define our flush policy to flush small increments
      // This is useful for demonstration purposes, but you should use more appropriate values for
      // your workload.
      int flushSize = totalToWrite / 8;
      FlushPolicy.MinFlushSizeFlushPolicy flushPolicy =
          FlushPolicy.minFlushSize(flushSize).withMaxPendingBytes(flushSize);
      BlobAppendableUploadConfig appendableUploadConfig =
          BlobAppendableUploadConfig.of().withFlushPolicy(flushPolicy);
      BlobAppendableUpload upload =
          storage.blobAppendableUpload(
              info, appendableUploadConfig, Storage.BlobWriteOption.doesNotExist());
      // Create the object, we'll takeover to write for our example.
      upload.open().closeWithoutFinalizing();
      BlobInfo gen1 = upload.getResult().get();
      BlobAppendableUpload takeover = storage.blobAppendableUpload(gen1, appendableUploadConfig);

      try (AppendableUploadWriteableByteChannel channel = takeover.open()) {
        // Start a background thread to write some data on a periodic basis
        // In reality, you're application would probably be doing thing in another scope
        Thread writeThread = startWriteThread(totalToWrite, channel, flushPolicy);
        try (BlobReadSession readSession =
            storage.blobReadSession(gen1.getBlobId()).get(10, TimeUnit.SECONDS)) {
          int zeroCnt = 0;
          long read = 0;
          while (read < totalToWrite) {
            if (zeroCnt >= 30 && !channel.isOpen()) {
              System.out.println("breaking");
              break;
            }
            ApiFuture<byte[]> future =
                readSession.readAs(
                    ReadProjectionConfigs.asFutureBytes()
                        .withRangeSpec(RangeSpec.of(read, flushPolicy.getMinFlushSize())));
            byte[] bytes = future.get(20, TimeUnit.SECONDS);

            read += bytes.length;
            long defaultSleep = 1_500L;
            if (bytes.length == 0) {
              zeroCnt++;
              long millis = defaultSleep * zeroCnt;
              System.out.println("millis = " + millis);
              Thread.sleep(millis);
            } else {
              zeroCnt = 0;
              System.out.println("bytes.length = " + bytes.length + " read = " + read);
              Thread.sleep(defaultSleep);
            }
          }
          assert read == totalToWrite : "not enough bytes";
        }
        writeThread.join();
      }
    }
  }

  private static Thread startWriteThread(
      int totalToWrite,
      AppendableUploadWriteableByteChannel channel,
      FlushPolicy.MinFlushSizeFlushPolicy flushPolicy) {
    Thread writeThread =
        new Thread(
            () -> {
              try {
                for (long written = 0; written < totalToWrite; ) {
                  byte alphaOffset = (byte) (written % 0x1a);

                  ByteBuffer buf = ByteBuffer.wrap(new byte[] {(byte) (0x41 + alphaOffset)});
                  int w = StorageChannelUtils.blockingEmptyTo(buf, channel);
                  written += w;
                  if (written % flushPolicy.getMinFlushSize() == 0) {
                    channel.flush();
                    Thread.sleep(40);
                  }
                }
                channel.closeWithoutFinalizing();

              } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
              }
            });
    writeThread.start();
    return writeThread;
  }
}
// [END storage_read_appendable_object_tail]
