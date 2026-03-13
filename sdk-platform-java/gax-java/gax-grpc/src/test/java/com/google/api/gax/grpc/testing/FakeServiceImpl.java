/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc.testing;

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.testing.FakeServiceGrpc.FakeServiceImplBase;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

@BetaApi
public class FakeServiceImpl extends FakeServiceImplBase {
  private Throwable receivedError;

  public Throwable getLastRecievedError() {
    return receivedError;
  }

  @Override
  public StreamObserver<Color> streamingRecognize(StreamObserver<Money> responseObserver) {
    return new RequestStreamObserver(responseObserver);
  }

  public StreamObserver<Color> streamingRecognizeError(
      final StreamObserver<Money> responseObserver) {
    return new StreamObserver<Color>() {
      @Override
      public void onNext(Color color) {
        responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
      }

      @Override
      public void onError(Throwable throwable) {
        receivedError = throwable;
      }

      @Override
      public void onCompleted() {}
    };
  }

  @Override
  public void serverStreamingRecognize(
      final Color color, final StreamObserver<Money> responseObserver) {
    if (color.getRed() < 0) {
      responseObserver.onError(
          Status.INVALID_ARGUMENT.withDescription("red must be positive").asRuntimeException());
      return;
    }

    // Defer the execution using the green channel. This is necessary when testing cancellation,
    // because the InProcessServer uses a direct executor and will buffer the results ignoring
    // cancellation
    Runnable runnable =
        () -> {
          try {
            Thread.sleep((long) color.getGreen());
            responseObserver.onNext(convert(color));
            responseObserver.onCompleted();
          } catch (Exception e) {
            Thread.interrupted();
            responseObserver.onError(e);
          }
        };

    if (color.getGreen() > 0) {
      new Thread(runnable).start();
    } else {
      runnable.run();
    }
  }

  public StreamObserver<Color> clientStreamingRecognize(StreamObserver<Money> responseObserver) {
    return new RequestStreamObserver(responseObserver);
  }

  private static Money convert(Color color) {
    return Money.newBuilder()
        .setCurrencyCode("USD")
        .setUnits((long) (color.getRed() * 255))
        .build();
  }

  private static class RequestStreamObserver implements StreamObserver<Color> {
    private StreamObserver<Money> responseObserver;

    public RequestStreamObserver(StreamObserver<Money> responseObserver) {
      this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(Color color) {
      responseObserver.onNext(convert(color));
    }

    @Override
    public void onError(Throwable throwable) {
      throwable.printStackTrace(System.err);
    }

    @Override
    public void onCompleted() {
      responseObserver.onCompleted();
    }
  }
  ;
}
