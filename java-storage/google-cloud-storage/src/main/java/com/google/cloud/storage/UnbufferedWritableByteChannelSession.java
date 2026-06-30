/*
 * Copyright 2022 Google LLC
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
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.WritableByteChannel;

interface UnbufferedWritableByteChannelSession<ResultT>
    extends WritableByteChannelSession<UnbufferedWritableByteChannel, ResultT> {

  interface UnbufferedWritableByteChannel extends WritableByteChannel, GatheringByteChannel {

    /** Default assumed to be blocking, non-blocking allowed but must be documented. */
    @Override
    default int write(ByteBuffer src) throws IOException {
      return Math.toIntExact(write(new ByteBuffer[] {src}, 0, 1));
    }

    /** Default assumed to be blocking, non-blocking allowed but must be documented. */
    @Override
    default long write(ByteBuffer[] srcs) throws IOException {
      return write(srcs, 0, srcs.length);
    }

    /** This method must block until terminal state is reached. */
    default int writeAndClose(ByteBuffer src) throws IOException {
      return Math.toIntExact(writeAndClose(new ByteBuffer[] {src}, 0, 1));
    }

    /** This method must block until terminal state is reached. */
    default long writeAndClose(ByteBuffer[] srcs) throws IOException {
      return writeAndClose(srcs, 0, srcs.length);
    }

    /** This method must block until terminal state is reached. */
    default long writeAndClose(ByteBuffer[] srcs, int offset, int length) throws IOException {
      long write = write(srcs, offset, length);
      close();
      return write;
    }
  }
}
