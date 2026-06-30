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
package com.google.api.gax.rpc.testing;

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
