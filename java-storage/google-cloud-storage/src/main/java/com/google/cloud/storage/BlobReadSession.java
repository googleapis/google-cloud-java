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
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import java.io.Closeable;
import java.io.IOException;

/**
 * A session for reading bytes from a Blob
 *
 * @see Storage#blobReadSession(BlobId, BlobSourceOption...)
 * @see ReadProjectionConfigs
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@InternalExtensionOnly
@TransportCompatibility({Transport.GRPC})
public interface BlobReadSession extends AutoCloseable, Closeable {

  /**
   * The resolved metadata for the object being read
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  BlobInfo getBlobInfo();

  /**
   * Read from this session as a specific {@code Projection} as dictated by the provided {@code
   * config}
   *
   * @see ReadProjectionConfig
   * @see ReadProjectionConfigs
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  <Projection> Projection readAs(ReadProjectionConfig<Projection> config);

  /**
   * Close this session and any {@code Projection}s produced by {@link
   * #readAs(ReadProjectionConfig)}.
   *
   * <p>If a projection is not fully consumed/resolved it will be transitioned to a failed state.
   *
   * <p>This method MUST be called to ensure cleanup of any inflight buffers, and to avoid a memory
   * leak.
   *
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @Override
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  void close() throws IOException;
}
