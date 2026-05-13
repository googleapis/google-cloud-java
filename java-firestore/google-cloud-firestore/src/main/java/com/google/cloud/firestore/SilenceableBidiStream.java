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

package com.google.cloud.firestore;

import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.StreamController;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * Conditionally pass through callbacks to wrapped `BidiStreamObserver`.
 *
 * <p>Due to the asynchronous nature of a stream, there can be a delay between closing a stream and
 * the upstream no longer sending responses. Receiving callbacks after closing upstream can have
 * undesirable consequences.
 *
 * <p>The underlying `ClientStream` can be called through the `SilenceableBidiStream`. Methods such
 * as `send()` and `closeSend()` are exposed.
 *
 * <p>The `SilenceableBidiStream` wraps a `BidiStreamObserver`. This is helpful for situations where
 * the observer should be detached from a stream. Instead of calling the `closeSend()` method, the
 * `closeSendAndSilence()` method will silence the stream by preventing further callbacks including
 * `onError` and `onComplete`.
 *
 * <p>If silenced, the observer could be safely attached to a new stream. This is useful for error
 * handling where upstream must be stopped, but a new stream can continue to service the observer.
 * In these cases, the old stream cannot be allowed to send more responses, and especially cannot be
 * allowed to send `onError` or `onComplete` since that would signal the downstream that the stream
 * is finished.
 */
final class SilenceableBidiStream<RequestT, ResponseT>
    implements BidiStreamObserver<RequestT, ResponseT> {
  private static final Logger LOGGER = Logger.getLogger(SilenceableBidiStream.class.getName());

  private final ClientStream<RequestT> stream;
  private final BidiStreamObserver<RequestT, ResponseT> delegate;
  private boolean silence = false;

  SilenceableBidiStream(
      BidiStreamObserver<RequestT, ResponseT> responseObserverT,
      Function<BidiStreamObserver<RequestT, ResponseT>, ClientStream<RequestT>> streamSupplier) {
    this.delegate = responseObserverT;
    stream = streamSupplier.apply(this);
  }

  public boolean isSilenced() {
    return silence;
  }

  public void send(RequestT request) {
    LOGGER.fine(stream::toString);
    stream.send(request);
  }

  public void closeSend() {
    LOGGER.fine(stream::toString);
    stream.closeSend();
  }

  public void closeSendAndSilence() {
    LOGGER.fine(stream::toString);
    silence = true;
    stream.closeSend();
  }

  @Override
  public void onReady(ClientStream<RequestT> stream) {
    if (silence) {
      LOGGER.info(() -> String.format("Silenced: %s", stream));
    } else {
      delegate.onReady(stream);
    }
  }

  @Override
  public void onStart(StreamController controller) {
    if (silence) {
      LOGGER.info(() -> String.format("Silenced: %s", stream));
    } else {
      delegate.onStart(controller);
    }
  }

  @Override
  public void onResponse(ResponseT response) {
    if (silence) {
      LOGGER.info(() -> String.format("Silenced: %s", stream));
    } else {
      delegate.onResponse(response);
    }
  }

  @Override
  public void onError(Throwable t) {
    if (silence) {
      LOGGER.info(() -> String.format("Silenced: %s", stream));
    } else {
      delegate.onError(t);
    }
  }

  @Override
  public void onComplete() {
    if (silence) {
      LOGGER.info(() -> String.format("Silenced: %s", stream));
    } else {
      delegate.onComplete();
    }
  }
}
