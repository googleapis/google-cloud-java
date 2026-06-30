/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.AccumulatingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.ByteArrayAccumulatingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.StreamingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.ZeroCopyByteStringAccumulatingRead;
import com.google.cloud.storage.ResponseContentLifecycleHandle.ChildRef;
import com.google.cloud.storage.RetryContext.OnFailure;
import com.google.cloud.storage.RetryContext.OnSuccess;
import com.google.storage.v2.ReadRange;
import java.io.IOException;

@InternalApi
@InternalExtensionOnly
interface ObjectReadSessionStreamRead<Projection> extends IOAutoCloseable {

  Projection project();

  long readOffset();

  boolean acceptingBytes();

  void accept(ChildRef childRef) throws IOException;

  void eof() throws IOException;

  void preFail();

  ApiFuture<?> fail(Throwable t);

  ObjectReadSessionStreamRead<Projection> withNewReadId(long newReadId);

  ReadRange makeReadRange();

  <T extends Throwable> void recordError(T t, OnSuccess onSuccess, OnFailure<T> onFailure);

  boolean readyToSend();

  Hasher hasher();

  boolean canShareStreamWith(ObjectReadSessionStreamRead<?> other);

  void setOnCloseCallback(IOAutoCloseable onCloseCallback);

  void internalClose() throws IOException;

  static AccumulatingRead<byte[]> createByteArrayAccumulatingRead(
      long readId, RangeSpec rangeSpec, Hasher hasher, RetryContext retryContext) {
    return new ByteArrayAccumulatingRead(
        readId, rangeSpec, hasher, retryContext, IOAutoCloseable.noOp());
  }

  static ZeroCopyByteStringAccumulatingRead createZeroCopyByteStringAccumulatingRead(
      long readId, RangeSpec rangeSpec, Hasher hasher, RetryContext retryContext) {
    return new ZeroCopyByteStringAccumulatingRead(
        readId, rangeSpec, hasher, retryContext, IOAutoCloseable.noOp());
  }

  static StreamingRead streamingRead(
      long readId, RangeSpec rangeSpec, Hasher hasher, RetryContext retryContext) {
    return new StreamingRead(readId, rangeSpec, hasher, retryContext, IOAutoCloseable.noOp());
  }
}
