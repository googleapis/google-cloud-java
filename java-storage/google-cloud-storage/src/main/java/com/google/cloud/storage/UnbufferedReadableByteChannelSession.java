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

import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;

interface UnbufferedReadableByteChannelSession<ResultT>
    extends ReadableByteChannelSession<UnbufferedReadableByteChannel, ResultT> {

  interface UnbufferedReadableByteChannel extends ReadableByteChannel, ScatteringByteChannel {
    @Override
    default int read(ByteBuffer dst) throws IOException {
      return Math.toIntExact(read(new ByteBuffer[] {dst}, 0, 1));
    }

    @Override
    default long read(ByteBuffer[] dsts) throws IOException {
      return read(dsts, 0, dsts.length);
    }
  }
}
