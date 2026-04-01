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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.function.BiFunction;

class ChannelSession<StartT, ResultT, ChannelT> {
  private final Object channelInitSyncObj = new ChannelSessionInitLockObject();

  private final ApiFuture<StartT> startFuture;
  private final ApiFunction<StartT, ChannelT> f;
  private final SettableApiFuture<ResultT> resultFuture;

  private volatile ApiFuture<ChannelT> channelFuture;

  ChannelSession(
      ApiFuture<StartT> startFuture, BiFunction<StartT, SettableApiFuture<ResultT>, ChannelT> f) {
    this(startFuture, f, SettableApiFuture.create());
  }

  ChannelSession(
      ApiFuture<StartT> startFuture,
      BiFunction<StartT, SettableApiFuture<ResultT>, ChannelT> f,
      SettableApiFuture<ResultT> resultFuture) {
    this.startFuture = startFuture;
    this.resultFuture = resultFuture;
    this.f = (s) -> f.apply(s, this.resultFuture);
  }

  public ApiFuture<ChannelT> openAsync() {
    ApiFuture<ChannelT> result = channelFuture;
    if (result != null) {
      return result;
    }

    synchronized (channelInitSyncObj) {
      if (channelFuture == null) {
        channelFuture = ApiFutures.transform(startFuture, f, MoreExecutors.directExecutor());
      }
      return channelFuture;
    }
  }

  public ApiFuture<ResultT> getResult() {
    return resultFuture;
  }

  static final class UnbufferedReadSession<S, R>
      extends ChannelSession<S, R, UnbufferedReadableByteChannel>
      implements UnbufferedReadableByteChannelSession<R> {

    UnbufferedReadSession(
        ApiFuture<S> startFuture,
        BiFunction<S, SettableApiFuture<R>, UnbufferedReadableByteChannel> f) {
      super(startFuture, f);
    }
  }

  static final class BufferedReadSession<S, R>
      extends ChannelSession<S, R, BufferedReadableByteChannel>
      implements BufferedReadableByteChannelSession<R> {

    BufferedReadSession(
        ApiFuture<S> startFuture,
        BiFunction<S, SettableApiFuture<R>, BufferedReadableByteChannel> f) {
      super(startFuture, f);
    }
  }

  static final class UnbufferedWriteSession<S, R>
      extends ChannelSession<S, R, UnbufferedWritableByteChannel>
      implements UnbufferedWritableByteChannelSession<R> {

    UnbufferedWriteSession(
        ApiFuture<S> startFuture,
        BiFunction<S, SettableApiFuture<R>, UnbufferedWritableByteChannel> f) {
      super(startFuture, f);
    }
  }

  static final class BufferedWriteSession<S, R>
      extends ChannelSession<S, R, BufferedWritableByteChannel>
      implements BufferedWritableByteChannelSession<R> {

    BufferedWriteSession(
        ApiFuture<S> startFuture,
        BiFunction<S, SettableApiFuture<R>, BufferedWritableByteChannel> f) {
      super(startFuture, f);
    }
  }

  private static final class ChannelSessionInitLockObject {
    private ChannelSessionInitLockObject() {}

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).toString();
    }
  }
}
