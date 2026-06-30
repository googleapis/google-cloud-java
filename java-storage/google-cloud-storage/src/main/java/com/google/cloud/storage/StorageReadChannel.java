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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.ApiFuture;
import com.google.cloud.ReadChannel;
import java.io.IOException;

interface StorageReadChannel extends ReadChannel {

  StorageReadChannel setByteRangeSpec(ByteRangeSpec byteRangeSpec);

  /**
   * Return a Future which resolves to the sparse object metadata included in the response headers
   * when opening the read.
   */
  ApiFuture<BlobInfo> getObject();

  default ByteRangeSpec getByteRangeSpec() {
    return ByteRangeSpec.nullRange();
  }

  /**
   * @deprecated Use {@link #setByteRangeSpec(ByteRangeSpec)}
   */
  @Deprecated
  @SuppressWarnings("resource")
  @Override
  default void seek(long position) throws IOException {
    try {
      setByteRangeSpec(getByteRangeSpec().withNewBeginOffset(position));
    } catch (StorageException e) {
      Throwable cause = e.getCause();
      if (cause instanceof IOException) {
        throw (IOException) cause;
      } else {
        throw e;
      }
    }
  }

  /**
   * @deprecated Use {@link #setByteRangeSpec(ByteRangeSpec)}
   */
  @SuppressWarnings("resource")
  @Deprecated
  @Override
  default ReadChannel limit(long limit) {
    checkArgument(limit >= 0, "limit must be >= 0");
    setByteRangeSpec(getByteRangeSpec().withNewEndOffset(limit));
    return this;
  }

  /**
   * @deprecated Use {@link #getByteRangeSpec()}
   */
  @Deprecated
  @Override
  default long limit() {
    return getByteRangeSpec().endOffset();
  }
}
