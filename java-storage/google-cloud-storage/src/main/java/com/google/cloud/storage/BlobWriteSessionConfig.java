/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import java.io.IOException;
import java.io.Serializable;
import java.time.Clock;

/**
 * A sealed internal implementation only class which provides the means of configuring a {@link
 * BlobWriteSession}.
 *
 * <p>A {@code BlobWriteSessionConfig} will be used to configure all {@link BlobWriteSession}s
 * produced by an instance of {@link Storage}.
 *
 * @see BlobWriteSessionConfigs
 * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
 * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
 * @since 2.26.0 This new api is in preview and is subject to breaking changes.
 */
// When we have java modules, actually seal this to internal extension only
@InternalApi
public abstract class BlobWriteSessionConfig implements Serializable {

  @InternalApi
  BlobWriteSessionConfig() {}

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(Object obj);

  @InternalApi
  abstract WriterFactory createFactory(Clock clock) throws IOException;

  @InternalApi
  interface WriterFactory {
    @InternalApi
    WritableByteChannelSession<?, BlobInfo> writeSession(
        StorageInternal s, BlobInfo info, Opts<ObjectTargetOpt> opts);
  }

  /**
   * Internal marker interface to signify an implementation of {@link BlobWriteSessionConfig} is
   * compatible with {@link com.google.cloud.storage.TransportCompatibility.Transport#HTTP}
   *
   * <p>We could evaluate the annotations, but the code for that is more complicated and probably
   * not worth the effort.
   */
  interface HttpCompatible {}

  /**
   * Internal marker interface to signify an implementation of {@link BlobWriteSessionConfig} is
   * compatible with {@link com.google.cloud.storage.TransportCompatibility.Transport#GRPC}
   *
   * <p>We could evaluate the annotations, but the code for that is more complicated and probably
   * not worth the effort.
   */
  interface GrpcCompatible {}
}
