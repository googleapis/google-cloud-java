/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.api.services.storage.model.StorageObject;
import com.google.gcloud.spi.StorageRpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Default implementation for BlobReadChannel.
 */
class BlobReadChannelImpl implements BlobReadChannel {

  private static final int DEFAULT_CHUNK_SIZE = 2 * 1024 * 1024;
  private static final long serialVersionUID = 4821762590742862669L;

  private final StorageOptions serviceOptions;
  private final BlobInfo blobInfo;
  private final Map<StorageRpc.Option, ?> requestOptions;
  private int position;
  private boolean isOpen;
  private boolean endOfStream;
  private int chunkSize = DEFAULT_CHUNK_SIZE;

  private transient StorageRpc storageRpc;
  private transient StorageObject storageObject;
  private transient int bufferPos;
  private transient byte[] buffer;

  BlobReadChannelImpl(StorageOptions serviceOptions, BlobInfo blobInfo,
      Map<StorageRpc.Option, ?> requestOptions) {
    this.serviceOptions = serviceOptions;
    this.blobInfo = blobInfo;
    this.requestOptions = requestOptions;
    isOpen = true;
    initTransients();
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    if (buffer != null) {
      position += bufferPos;
      buffer = null;
      bufferPos = 0;
      endOfStream = false;
    }
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    initTransients();
  }

  private void initTransients() {
    storageRpc = serviceOptions.storageRpc();
    storageObject = blobInfo.toPb();
  }

  @Override
  public boolean isOpen() {
    return isOpen;
  }

  @Override
  public void close() {
    if (isOpen) {
      buffer = null;
      isOpen = false;
    }
  }

  private void validateOpen() throws IOException {
    if (!isOpen) {
      throw new IOException("stream is closed");
    }
  }

  @Override
  public void seek(int position) throws IOException {
    validateOpen();
    this.position = position;
    buffer = null;
    bufferPos = 0;
    endOfStream = false;
  }

  @Override
  public void chunkSize(int chunkSize) {
    this.chunkSize = chunkSize <= 0 ? DEFAULT_CHUNK_SIZE : chunkSize;
  }

  @Override
  public int read(ByteBuffer byteBuffer) throws IOException {
    validateOpen();
    if (buffer == null) {
      if (endOfStream) {
        return -1;
      }
      final int toRead = Math.max(byteBuffer.remaining(), chunkSize);
      buffer = runWithRetries(new Callable<byte[]>() {
        @Override
        public byte[] call() {
          return storageRpc.read(storageObject, requestOptions, position, toRead);
        }
      }, serviceOptions.retryParams(), StorageImpl.EXCEPTION_HANDLER);
      if (toRead > buffer.length) {
        endOfStream = true;
        if (buffer.length == 0) {
          buffer = null;
          return -1;
        }
      }
    }
    int toWrite = Math.min(buffer.length - bufferPos, byteBuffer.remaining());
    byteBuffer.put(buffer, bufferPos, toWrite);
    bufferPos += toWrite;
    if (bufferPos >= buffer.length) {
      position += buffer.length;
      buffer = null;
      bufferPos = 0;
    }
    return toWrite;
  }
}
