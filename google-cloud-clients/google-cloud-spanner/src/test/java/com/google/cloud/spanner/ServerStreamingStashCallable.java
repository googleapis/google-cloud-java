/*
 * Copyright 2018 Google LLC
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

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CancellationException;

/**
 * TODO(hzyi): convert this class into a general utility class
 * This class is copied from gax and is used for testing ServerStream only.
 */
public class ServerStreamingStashCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
  private final List<ResponseT> responseList;

  public ServerStreamingStashCallable() {
    responseList = new ArrayList<>();
  }

  public ServerStreamingStashCallable(List<ResponseT> responseList) {
    this.responseList = responseList;
  }

  @Override
  public void call(
      RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
    Preconditions.checkNotNull(responseObserver);

    StreamControllerStash<ResponseT> controller =
        new StreamControllerStash<>(responseList, responseObserver);
    controller.start();
  }

  // Minimal implementation of back pressure aware stream controller. Not threadsafe
  private static class StreamControllerStash<ResponseT> implements StreamController {
    final ResponseObserver<ResponseT> observer;
    final Queue<ResponseT> queue;
    boolean autoFlowControl = true;
    long numPending;
    Throwable error;
    boolean delivering, closed;

    public StreamControllerStash(
        List<ResponseT> responseList, ResponseObserver<ResponseT> observer) {
      this.observer = observer;
      this.queue = Queues.newArrayDeque(responseList);
    }

    public void start() {
      observer.onStart(this);
      if (autoFlowControl) {
        numPending = Integer.MAX_VALUE;
      }
      deliver();
    }

    @Override
    public void disableAutoInboundFlowControl() {
      autoFlowControl = false;
    }

    @Override
    public void request(int count) {
      numPending += count;
      deliver();
    }

    @Override
    public void cancel() {
      error = new CancellationException("User cancelled stream");
      deliver();
    }

    private void deliver() {
      if (delivering || closed) return;
      delivering = true;

      try {
        while (error == null && numPending > 0 && !queue.isEmpty()) {
          numPending--;
          observer.onResponse(queue.poll());
        }

        if (error != null || queue.isEmpty()) {
          if (error != null) {
            observer.onError(error);
          } else {
            observer.onComplete();
          }
          closed = true;
        }
      } finally {
        delivering = false;
      }
    }
  }
}