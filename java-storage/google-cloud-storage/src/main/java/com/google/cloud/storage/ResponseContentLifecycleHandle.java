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

import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ResponseContentLifecycleHandle<Response> implements Closeable {

  private final Response response;
  @Nullable private final Closeable dispose;

  private final AtomicBoolean open;
  private final AtomicInteger refs;

  private ResponseContentLifecycleHandle(Response response, @Nullable Closeable dispose) {
    this.response = response;
    this.dispose = dispose;
    this.open = new AtomicBoolean(true);
    this.refs = new AtomicInteger(1);
  }

  static <Response> ResponseContentLifecycleHandle<Response> create(
      Response response, @Nullable Closeable dispose) {
    return new ResponseContentLifecycleHandle<>(response, dispose);
  }

  ChildRef borrow(Function<Response, ByteString> toByteStringFunction) {
    Preconditions.checkState(open.get(), "only able to borrow when open");
    Preconditions.checkNotNull(toByteStringFunction);
    ChildRef childRef = new ChildRef(toByteStringFunction);
    refs.incrementAndGet();
    return childRef;
  }

  @Override
  public void close() throws IOException {
    if (open.getAndSet(false)) {
      int newCount = refs.decrementAndGet();
      if (newCount == 0) {
        dispose();
      }
    }
  }

  private void dispose() throws IOException {
    if (dispose != null) {
      dispose.close();
    }
  }

  final class ChildRef implements Closeable, DisposableByteString {

    private final Function<Response, ByteString> toByteStringFunction;

    private ChildRef(Function<Response, ByteString> toByteStringFunction) {
      this.toByteStringFunction = toByteStringFunction;
    }

    @Override
    public ByteString byteString() {
      return toByteStringFunction.apply(response);
    }

    @Override
    public void close() throws IOException {
      int newCount = refs.decrementAndGet();
      if (newCount == 0) {
        ResponseContentLifecycleHandle.this.dispose();
      }
    }
  }
}
