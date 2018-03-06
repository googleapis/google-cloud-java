/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.gaxx.testing;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

@InternalApi("for testing")
public class FakeStreamingApi {

  public static class BidiStreamingStashCallable<RequestT, ResponseT>
      extends BidiStreamingCallable<RequestT, ResponseT> {
    private ApiCallContext context;
    private ApiStreamObserver<ResponseT> responseObserver;
    private AccumulatingStreamObserver<RequestT> requestObserver;
    private List<ResponseT> responseList;

    public BidiStreamingStashCallable() {
      responseList = new ArrayList<>();
    }

    public BidiStreamingStashCallable(List<ResponseT> responseList) {
      this.responseList = responseList;
    }

    @Override
    public ApiStreamObserver<RequestT> bidiStreamingCall(
        ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {
      Preconditions.checkNotNull(responseObserver);
      this.responseObserver = responseObserver;
      this.context = context;
      this.requestObserver = new AccumulatingStreamObserver<>();
      return requestObserver;
    }

    public ApiCallContext getContext() {
      return context;
    }

    public ApiStreamObserver<ResponseT> getActualObserver() {
      return responseObserver;
    }

    public List<RequestT> getActualRequests() {
      return requestObserver.getValues();
    }

    private void sendResponses() {
      for (ResponseT response : responseList) {
        responseObserver.onNext(response);
      }
      responseObserver.onCompleted();
    }

    private class AccumulatingStreamObserver<T> implements ApiStreamObserver<T> {
      private List<T> requestList = new ArrayList<>();
      private Throwable error;
      private boolean completed = false;

      @Override
      public void onNext(T value) {
        requestList.add(value);
      }

      @Override
      public void onError(Throwable t) {
        error = t;
      }

      @Override
      public void onCompleted() {
        completed = true;
        BidiStreamingStashCallable.this.sendResponses();
      }

      public List<T> getValues() {
        if (!completed) {
          throw new IllegalStateException("Stream not completed.");
        }
        if (error != null) {
          throw ApiExceptionFactory.createException(error, FakeStatusCode.of(Code.UNKNOWN), false);
        }
        return requestList;
      }
    }
  }

  public static class ServerStreamingStashCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
    private ApiCallContext context;
    private ResponseObserver<ResponseT> actualObserver;
    private RequestT actualRequest;
    private List<ResponseT> responseList;
    private final BlockingQueue<StreamControllerStash<ResponseT>> calls =
        Queues.newLinkedBlockingQueue();

    public ServerStreamingStashCallable() {
      responseList = new ArrayList<>();
    }

    public ServerStreamingStashCallable(List<ResponseT> responseList) {
      this.responseList = responseList;
    }

    @Override
    public void call(
        RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      Preconditions.checkNotNull(request);
      Preconditions.checkNotNull(responseObserver);
      this.actualRequest = request;
      this.actualObserver = responseObserver;
      this.context = context;

      StreamControllerStash<ResponseT> controller =
          new StreamControllerStash<>(responseList, responseObserver);
      calls.add(controller);
      controller.start();
    }

    public StreamControllerStash<ResponseT> popLastCall() {
      try {
        return calls.poll(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }

    public ApiCallContext getContext() {
      return context;
    }

    public ResponseObserver<ResponseT> getActualObserver() {
      return actualObserver;
    }

    public RequestT getActualRequest() {
      return actualRequest;
    }

    // Minimal implementation of back pressure aware stream controller. Not threadsafe
    public static class StreamControllerStash<ResponseT> implements StreamController {
      final ResponseObserver<ResponseT> observer;
      final Queue<ResponseT> queue;
      boolean autoFlowControl = true;
      long numPending;
      long numDelivered;
      Throwable error;
      boolean delivering, closed;

      public StreamControllerStash(
          List<ResponseT> responseList, ResponseObserver<ResponseT> observer) {
        this.observer = observer;
        this.queue = Queues.newArrayDeque(responseList);
      }

      public Throwable getError() {
        return error;
      }

      public long getNumDelivered() {
        return numDelivered;
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
            numDelivered++;
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

  public static class ClientStreamingStashCallable<RequestT, ResponseT>
      extends ClientStreamingCallable<RequestT, ResponseT> {
    private ApiCallContext context;
    private ApiStreamObserver<ResponseT> responseObserver;
    private AccumulatingStreamObserver<RequestT> requestObserver;
    private ResponseT response;

    public ClientStreamingStashCallable() {}

    public ClientStreamingStashCallable(ResponseT response) {
      this.response = response;
    }

    @Override
    public ApiStreamObserver<RequestT> clientStreamingCall(
        ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {
      Preconditions.checkNotNull(responseObserver);
      this.responseObserver = responseObserver;
      this.context = context;
      this.requestObserver = new AccumulatingStreamObserver<>();
      return requestObserver;
    }

    public ApiCallContext getContext() {
      return context;
    }

    public ApiStreamObserver<ResponseT> getActualObserver() {
      return responseObserver;
    }

    public List<RequestT> getActualRequests() {
      return requestObserver.getValues();
    }

    private void sendResponses() {
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }

    private class AccumulatingStreamObserver<T> implements ApiStreamObserver<T> {
      private List<T> requestList = new ArrayList<>();
      private Throwable error;
      private boolean completed = false;

      @Override
      public void onNext(T value) {
        requestList.add(value);
      }

      @Override
      public void onError(Throwable t) {
        error = t;
      }

      @Override
      public void onCompleted() {
        completed = true;
        ClientStreamingStashCallable.this.sendResponses();
      }

      public List<T> getValues() {
        if (!completed) {
          throw new IllegalStateException("Stream not completed.");
        }
        if (error != null) {
          throw ApiExceptionFactory.createException(error, FakeStatusCode.of(Code.UNKNOWN), false);
        }
        return requestList;
      }
    }
  }
}
