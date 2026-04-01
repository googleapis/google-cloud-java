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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.protobuf.ByteString;
import java.io.Closeable;
import java.io.IOException;

/**
 * Public components which exist to support zero-copy data access
 *
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
public abstract class ZeroCopySupport {

  private ZeroCopySupport() {}

  /**
   * Represents an object that can be accessed as a {@link ByteString}, but has a lifecycle that
   * requires being explicitly closed in order to free up resources.
   *
   * <p>Instances of this class should be used in a try-with-resources to ensure they are released.
   *
   * <pre>{@code
   * try (DisposableByteString disposableByteString = ...) {
   *   System.out.println(disposableByteString.byteString().size());
   * }
   * }</pre>
   *
   * @see ReadProjectionConfigs#asFutureByteString()
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @InternalExtensionOnly
  public interface DisposableByteString extends AutoCloseable, Closeable {

    /** Get the ByteString representation of the underlying resources */
    ByteString byteString();

    /** Signal the underlying resources that they can be released. */
    @Override
    void close() throws IOException;
  }
}
