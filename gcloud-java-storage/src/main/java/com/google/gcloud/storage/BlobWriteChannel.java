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

import java.io.Closeable;
import java.nio.channels.WritableByteChannel;

/**
 * A channel for writing data to a Google Cloud Storage object.
 *
 * Implementations of this class may further buffer data internally to reduce remote calls. Written
 * data will only be visible after calling {@link #close()}. This class is serializable, to allow
 * incremental writes.
 */
public interface BlobWriteChannel extends WritableByteChannel, Closeable {

  /**
   * Sets the minimum size that will be written by a single RPC.
   * Written data will be buffered and only flushed upon reaching this size or closing the channel.
   */
  void chunkSize(int chunkSize);

  /**
   * Saves the write channel state.
   *
   * @return an object that contains the write channel state and can restore it afterwards. State
   *     object must implement {@link java.io.Serializable}.
   */
  public State save();

  /**
   * A common interface for all classes that implement the internal state of a
   * {@code BlobWriteChannel}.
   *
   * Implementations of this class must implement {@link java.io.Serializable} to ensure that the
   * state of a channel can be correctly serialized.
   */
  public interface State {

    /**
     * Returns a {@code BlobWriteChannel} whose internal state reflects the one saved in the
     * invocation object.
     *
     * The original {@code BlobWriteChannel} and the restored one should not both be used. Closing
     * one channel causes the other channel to close, subsequent writes will fail.
     */
    public BlobWriteChannel restore();
  }
}
