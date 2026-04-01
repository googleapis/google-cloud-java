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

package com.google.cloud.storage;

import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** A FileChannel decorator that will fsync after every {@link #write(ByteBuffer)} */
final class SyncingFileChannel implements UnbufferedWritableByteChannel {

  private final FileChannel fc;

  SyncingFileChannel(FileChannel fc) {
    this.fc = fc;
  }

  @Override
  public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
    long written = fc.write(srcs, offset, length);
    // metadata in this case are things like mtime, atime etc. Those are not important to our needs
    // simply force the file contents to by synced.
    fc.force(/* includeMetaData= */ false);
    return written;
  }

  @Override
  public boolean isOpen() {
    return fc.isOpen();
  }

  @Override
  public void close() throws IOException {
    fc.close();
  }
}
