/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.common.base.MoreObjects;
import java.io.Closeable;
import java.io.IOException;

/**
 * Specialized sub-interface to AutoClosable narrowing the exception from {@link #close} to be an
 * {@link IOException}. Also implements {@link Closeable} for ease of cross usage.
 */
@FunctionalInterface
@InternalApi
@InternalExtensionOnly
interface IOAutoCloseable extends AutoCloseable, Closeable {

  @Override
  void close() throws IOException;

  @InternalApi
  default IOAutoCloseable andThen(IOAutoCloseable then) {
    if (NoOpIOAutoCloseable.INSTANCE.equals(this)) {
      return then;
    } else if (NoOpIOAutoCloseable.INSTANCE.equals(then)) {
      return this;
    } else {
      return new AndThenIOAutoClosable(this, then);
    }
  }

  @InternalApi
  static IOAutoCloseable noOp() {
    return NoOpIOAutoCloseable.INSTANCE;
  }

  final class NoOpIOAutoCloseable implements IOAutoCloseable {
    private static final NoOpIOAutoCloseable INSTANCE = new NoOpIOAutoCloseable();

    private NoOpIOAutoCloseable() {}

    @Override
    public void close() throws IOException {}
  }

  final class AndThenIOAutoClosable implements IOAutoCloseable {
    private final IOAutoCloseable first;
    private final IOAutoCloseable second;

    private AndThenIOAutoClosable(IOAutoCloseable first, IOAutoCloseable second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public void close() throws IOException {
      //noinspection EmptyTryBlock
      try (IOAutoCloseable ignore2 = second;
          IOAutoCloseable ignore1 = first) {}
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("first", first).add("second", second).toString();
    }
  }
}
