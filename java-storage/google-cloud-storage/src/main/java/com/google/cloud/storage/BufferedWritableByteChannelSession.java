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

import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

interface BufferedWritableByteChannelSession<ResultT>
    extends WritableByteChannelSession<BufferedWritableByteChannel, ResultT> {

  interface BufferedWritableByteChannel extends WritableByteChannel {

    /** Block the invoking thread until all written bytes are accepted by the lower layer */
    void flush() throws IOException;
  }
}
