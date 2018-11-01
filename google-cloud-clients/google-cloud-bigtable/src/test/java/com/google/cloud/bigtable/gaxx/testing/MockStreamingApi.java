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

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.common.collect.Queues;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MockStreamingApi {
  public static class MockServerStreamingCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
    private final BlockingQueue<MockServerStreamingCall<RequestT, ResponseT>> calls =
        Queues.newLinkedBlockingDeque();

    @Override
    public void call(
        RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      MockStreamController<ResponseT> controller = new MockStreamController<>(responseObserver);
      calls.add(new MockServerStreamingCall<>(request, controller));
      responseObserver.onStart(controller);
    }

    public MockServerStreamingCall<RequestT, ResponseT> popLastCall() {
      try {
        return calls.poll(1, TimeUnit.SECONDS);
      } catch (Throwable e) {
        return null;
      }
    }
  }

  public static class MockServerStreamingCall<RequestT, ResponseT> {
    private final RequestT request;
    private final MockStreamController<ResponseT> controller;

    public MockServerStreamingCall(RequestT request, MockStreamController<ResponseT> controller) {
      this.request = request;
      this.controller = controller;
    }

    public RequestT getRequest() {
      return request;
    }

    public MockStreamController<ResponseT> getController() {
      return controller;
    }
  }

  public static class MockStreamController<ResponseT> implements StreamController {
    private final ResponseObserver<ResponseT> downstreamObserver;
    private final BlockingQueue<Integer> pulls = Queues.newLinkedBlockingQueue();
    private SettableApiFuture<Boolean> cancelFuture = SettableApiFuture.create();
    private boolean autoFlowControl = true;

    public MockStreamController(ResponseObserver<ResponseT> downstreamObserver) {
      this.downstreamObserver = downstreamObserver;
    }

    @Override
    public void disableAutoInboundFlowControl() {
      autoFlowControl = false;
    }

    @Override
    public void request(int count) {
      pulls.add(count);
    }

    @Override
    public void cancel() {
      cancelFuture.set(true);
    }

    public ResponseObserver<ResponseT> getObserver() {
      return downstreamObserver;
    }

    public boolean isAutoFlowControlEnabled() {
      return autoFlowControl;
    }

    public boolean isCancelled() {
      return cancelFuture.isDone();
    }

    public void waitForCancel() {
      try {
        cancelFuture.get(1, TimeUnit.SECONDS);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    public int popLastPull() {
      Integer results;

      try {
        results = pulls.poll(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }

      if (results == null) {
        return 0;
      } else {
        return results;
      }
    }
  }

  public static class MockResponseObserver<T> extends StateCheckingResponseObserver<T> {
    private final boolean autoFlowControl;
    private StreamController controller;
    private final BlockingQueue<T> responses = Queues.newLinkedBlockingDeque();
    private final SettableApiFuture<Void> done = SettableApiFuture.create();

    public MockResponseObserver(boolean autoFlowControl) {
      this.autoFlowControl = autoFlowControl;
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      this.controller = controller;
      if (!autoFlowControl) {
        controller.disableAutoInboundFlowControl();
      }
    }

    @Override
    protected void onResponseImpl(T response) {
      responses.add(response);
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      done.setException(t);
    }

    @Override
    protected void onCompleteImpl() {
      done.set(null);
    }

    public StreamController getController() {
      return controller;
    }

    public T popNextResponse() {
      try {
        return responses.poll(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }

    public Throwable getFinalError() {
      try {
        done.get(1, TimeUnit.SECONDS);
        return null;
      } catch (ExecutionException e) {
        return e.getCause();
      } catch (Throwable t) {
        return t;
      }
    }

    public boolean isDone() {
      return done.isDone();
    }
  }
}
