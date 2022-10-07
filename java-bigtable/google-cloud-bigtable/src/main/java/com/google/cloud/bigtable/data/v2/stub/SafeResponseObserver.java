/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base implementation of {@link ResponseObserver} that checks the state and catches all the
 * throwables.
 */
@InternalApi
public abstract class SafeResponseObserver<ResponseT> implements ResponseObserver<ResponseT> {

  private static final Logger LOGGER = Logger.getLogger(SafeResponseObserver.class.getName());
  private AtomicBoolean isStarted = new AtomicBoolean(false);
  private AtomicBoolean isClosed = new AtomicBoolean(false);
  private StreamController streamController;
  private ResponseObserver outerObserver;

  public SafeResponseObserver(ResponseObserver outerObserver) {
    this.outerObserver = outerObserver;
  }

  @Override
  public final void onStart(StreamController streamController) {
    if (!isStarted.compareAndSet(false, true)) {
      throw new IllegalStateException("A stream is already started");
    }

    this.streamController = streamController;
    try {
      onStartImpl(streamController);
    } catch (Throwable t) {
      if (!isClosed.compareAndSet(false, true)) {
        logException("Tried to cancel a closed stream");
        return;
      }
      streamController.cancel();
      outerObserver.onError(t);
    }
  }

  @Override
  public final void onResponse(ResponseT response) {
    if (isClosed.get()) {
      logException("Received a response after the stream is closed");
      return;
    }
    try {
      onResponseImpl(response);
    } catch (Throwable t1) {
      try {
        if (!isClosed.compareAndSet(false, true)) {
          logException("Tried to cancel a closed stream");
          return;
        }
        streamController.cancel();
      } catch (Throwable t2) {
        t1.addSuppressed(t2);
      }
      outerObserver.onError(t1);
    }
  }

  @Override
  public final void onError(Throwable throwable) {
    if (!isClosed.compareAndSet(false, true)) {
      logException("Received error after the stream is closed");
      return;
    }

    try {
      onErrorImpl(throwable);
    } catch (Throwable t) {
      throwable.addSuppressed(t);
      outerObserver.onError(throwable);
    }
  }

  @Override
  public final void onComplete() {
    if (!isClosed.compareAndSet(false, true)) {
      logException("Tried to double close the stream");
      return;
    }

    try {
      onCompleteImpl();
    } catch (Throwable t) {
      outerObserver.onError(t);
    }
  }

  private void logException(String message) {
    LOGGER.log(Level.WARNING, message, new IllegalStateException(message));
  }

  protected abstract void onStartImpl(StreamController streamController);

  protected abstract void onResponseImpl(ResponseT response);

  protected abstract void onErrorImpl(Throwable throwable);

  protected abstract void onCompleteImpl();
}
