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

  /** Set the offset to read from. */
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

  /**
   * Limit the maximum number of bytes to be read from the objects content, counting from the
   * beginning of the object, which will be available to read from this channel. If the limit is
   * larger than the actual size of the content this will have no material impact.
   *
   * <p>If used in conjunction with {@link #seek(long)} the total number of returned bytes from this
   * channel will be reduced by the number of bytes specified to seek.
   *
   * <p>The value provided as {@code limit} will define a <a target="_blank" rel="noopener
   * noreferrer"
   * href="https://en.wikipedia.org/wiki/Interval_(mathematics)#Classification_of_intervals">left-closed,
   * right-open</a> interval along with either {@code 0} or any value provided to {@link
   * #seek(long)}, i.e. {@code [}{@link #seek(long)}{@code , }{@link #limit(long)}{@code )}.
   *
   * <h3>An example to help illustrate the relationship</h3>
   *
   * Imagine some data {@code [A, B, C, D, E, F, G, H, I, J]}, 10 bytes total.
   *
   * <ol>
   *   <li>{@code limit(5)} would produce {@code [A, B, C, D, E]}
   *   <li>{@code seek(8)} would produce {@code [I, J]}
   *   <li>{@code seek(2)} {@code limit(5)} would produce {@code [C, D, E]}
   *   <li>{@code seek(3)} {@code limit(3)} would produce {@code []}
   * </ol>
   *
   * <p><i>NOTE:</i>Implementers are not required to return a new instance from this method, however
   * they are allowed to. Users of this method should always use the instance returned from this
   * method.
   *
   * <p><i>Default Implementation:</i>By default, this method will simply return {@code this}.
   *
   * @param limit the maximum number of bytes to limit this channel to
   * @return The instance of channel which will respect the limit.
   * @throws UnsupportedOperationException If the {@code this} instances does not support limiting
   * @since 2.4.0
   */
  default ReadChannel limit(long limit) {
    return this;
  }

  /**
   * The currently defined limit for this channel. Initial value is {@link Long#MAX_VALUE}
   *
   * @return the current limit for this channel
   * @throws UnsupportedOperationException If the {@code this} instances does not support limiting
   * @since 2.4.0
   */
  default long limit() {
    return Long.MAX_VALUE;
  }
}
