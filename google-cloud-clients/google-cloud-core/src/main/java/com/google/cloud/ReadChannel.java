/*
 * Copyright 2015 Google LLC
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

package com.google.cloud;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

/**
 * A channel for reading data from a Google Cloud object.
 *
 * <p>Implementations of this class may buffer data internally to reduce remote calls. This
 * interface implements {@link Restorable} to allow saving the reader's state to continue reading
 * afterwards.
 */
public interface ReadChannel extends ReadableByteChannel, Closeable, Restorable<ReadChannel> {

  /**
   * Overridden to remove IOException.
   *
   * @see java.nio.channels.Channel#close()
   */
  @Override
  void close();

  void seek(long position) throws IOException;

  /**
   * Sets the minimum size that will be read by a single RPC. Read data will be locally buffered
   * until consumed.
   */
  void setChunkSize(int chunkSize);

  /**
   * Captures the read channel state so that it can be saved and restored afterwards.
   *
   * @return a {@link RestorableState} object that contains the read channel state and can restore
   *     it afterwards.
   */
  @Override
  RestorableState<ReadChannel> capture();
}
