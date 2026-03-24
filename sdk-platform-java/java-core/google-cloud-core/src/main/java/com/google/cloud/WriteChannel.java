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
import java.nio.channels.WritableByteChannel;

/**
 * A channel for writing data to Google Cloud services.
 *
 * <p>Implementations of this class may further buffer data internally to reduce remote calls.
 * Written data might not be visible until calling {@link #close()}. This interface implements
 * {@link Restorable} to allow saving the writer's state to continue writing afterwards.
 */
public interface WriteChannel extends WritableByteChannel, Closeable, Restorable<WriteChannel> {

  /**
   * Sets the minimum size that will be written by a single RPC. Written data will be buffered and
   * only flushed upon reaching this size or closing the channel.
   */
  void setChunkSize(int chunkSize);

  /**
   * Captures the write channel state so that it can be saved and restored afterwards. The original
   * {@code WriteChannel} and the restored one should not both be used. Closing one channel causes
   * the other channel to close; subsequent writes will fail.
   *
   * @return a {@link RestorableState} object that contains the write channel state and can restore
   *     it afterwards.
   */
  @Override
  RestorableState<WriteChannel> capture();
}
