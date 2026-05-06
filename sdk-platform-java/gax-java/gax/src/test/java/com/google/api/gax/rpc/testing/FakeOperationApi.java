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

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.OperationCallable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@InternalApi("for testing")
public class FakeOperationApi {
  public static class OperationStashCallable extends OperationCallable<Integer, String, Long> {

    private ApiCallContext context;
    private Integer request;
    private Map<String, FakeOperationFuture> operations = new HashMap<>();
    private ApiCallContext resumeContext;
    private ApiCallContext cancelContext;
    private boolean wasCancelCalled = false;

    @Override
    public OperationFuture<String, Long> futureCall(Integer request, ApiCallContext context) {
      this.request = request;
      this.context = context;
      String opName = "opName-" + request;
      FakeOperationFuture opFuture = new FakeOperationFuture(request.toString(), opName);
      operations.put(opName, opFuture);
      return opFuture;
    }

    @Override
    public OperationFuture<String, Long> resumeFutureCall(
        String operationName, ApiCallContext context) {
      if (!operations.containsKey(operationName)) {
        throw new IllegalArgumentException("Operation not found: " + operationName);
      }
      resumeContext = context;
      return operations.get(operationName);
    }

    @Override
    public ApiFuture<Void> cancel(String operationName, ApiCallContext context) {
      wasCancelCalled = true;
      cancelContext = context;
      return ApiFutures.immediateFuture(null);
    }

    public ApiCallContext getContext() {
      return context;
    }

    public Integer getRequest() {
      return request;
    }

    public ApiCallContext getResumeContext() {
      return resumeContext;
    }

    public boolean wasCancelCalled() {
      return wasCancelCalled;
    }

    public ApiCallContext getCancelContext() {
      return cancelContext;
    }
  }

  public static class FakeOperationFuture extends AbstractApiFuture<String>
      implements OperationFuture<String, Long> {

    private final String result;
    private final String operationName;

    public FakeOperationFuture(String result, String operationName) {
      this.result = result;
      this.operationName = operationName;
    }

    @Override
    public String get() {
      return result;
    }

    @Override
    public String getName() throws InterruptedException, ExecutionException {
      return operationName;
    }

    @Override
    public ApiFuture<OperationSnapshot> getInitialFuture() {
      throw new UnsupportedOperationException("getInitialFuture() not implemented");
    }

    @Override
    public RetryingFuture<OperationSnapshot> getPollingFuture() {
      throw new UnsupportedOperationException("getPollingFuture() not implemented");
    }

    @Override
    public ApiFuture<Long> peekMetadata() {
      return null;
    }

    @Override
    public ApiFuture<Long> getMetadata() {
      return null;
    }
  }

  public static class FakeOperation {}
}
