/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.core.ApiFuture;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.List;
import java.util.concurrent.Executor;

/** Forwarding implementation of {@link AsyncResultSet} that forwards all calls to a delegate. */
public class ForwardingAsyncResultSet extends ForwardingResultSet implements AsyncResultSet {

  public ForwardingAsyncResultSet(AsyncResultSet delegate) {
    super(Preconditions.checkNotNull(delegate));
  }

  ForwardingAsyncResultSet(Supplier<AsyncResultSet> delegateSupplier) {
    super(Preconditions.checkNotNull(delegateSupplier));
  }

  @Override
  AsyncResultSet getDelegate() {
    return (AsyncResultSet) super.getDelegate();
  }

  @Override
  public CursorState tryNext() throws SpannerException {
    return getDelegate().tryNext();
  }

  @Override
  public ApiFuture<Void> setCallback(Executor exec, ReadyCallback cb) {
    return getDelegate().setCallback(exec, cb);
  }

  @Override
  public void cancel() {
    getDelegate().cancel();
  }

  @Override
  public void resume() {
    getDelegate().resume();
  }

  @Override
  public <T> ApiFuture<List<T>> toListAsync(
      Function<StructReader, T> transformer, Executor executor) {
    return getDelegate().toListAsync(transformer, executor);
  }

  @Override
  public <T> List<T> toList(Function<StructReader, T> transformer) throws SpannerException {
    return getDelegate().toList(transformer);
  }
}
