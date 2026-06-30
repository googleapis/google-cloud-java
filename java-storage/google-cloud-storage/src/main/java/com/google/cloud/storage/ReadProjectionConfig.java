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
import com.google.cloud.storage.ReadProjectionConfigs.BaseConfig;
import com.google.cloud.storage.Storage.BlobSourceOption;
import java.util.Locale;

/**
 * Base class to represent a config for reading from a {@link BlobReadSession}.
 *
 * @param <Projection> The type used to provide access to the bytes being read
 * @see ReadProjectionConfigs
 * @see BlobReadSession
 * @see Storage#blobReadSession(BlobId, BlobSourceOption...)
 * @since 2.51.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
@InternalExtensionOnly
public abstract class ReadProjectionConfig<Projection> {

  ReadProjectionConfig() {}

  BaseConfig<Projection, ?> cast() {
    throw new UnsupportedOperationException(String.format("%s#cast()", this.getClass().getName()));
  }

  abstract ProjectionType getType();

  Projection project(ObjectReadSession session, IOAutoCloseable closeAlongWith) {
    throw new UnsupportedOperationException(
        String.format(Locale.US, "%s#project()", this.getClass().getName()));
  }

  enum ProjectionType {
    /** Those projections which translate to a direct read registered in the state of the stream */
    STREAM_READ,
    /**
     * Those projections which use an ObjectReadSession rather than directly registering a read in
     * the stream state.
     */
    SESSION_USER
  }
}
