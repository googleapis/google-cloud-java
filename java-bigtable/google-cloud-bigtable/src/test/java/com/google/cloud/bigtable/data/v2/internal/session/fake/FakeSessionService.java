/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.session.fake;

import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeSessionService extends FakeSessionGrpc.FakeSessionImplBase {

  private final ScheduledExecutorService executor;
  private final AtomicInteger openRequestCount = new AtomicInteger(0);

  private final List<SessionRequest> sessionRequests = new ArrayList<>();

  public FakeSessionService(ScheduledExecutorService executor) {
    this.executor = executor;
  }

  @Override
  public StreamObserver<SessionRequest> openSession(
      StreamObserver<SessionResponse> responseObserver) {
    openRequestCount.incrementAndGet();
    SessionHandler handler = new SessionHandler(executor, responseObserver);
    return new StreamObserver<SessionRequest>() {
      @Override
      public void onNext(SessionRequest value) {
        sessionRequests.add(value);
        handler.onNext(value);
      }

      @Override
      public void onError(Throwable t) {
        handler.onError(t);
      }

      @Override
      public void onCompleted() {
        handler.onCompleted();
      }
    };
  }

  public AtomicInteger getOpenRequestCount() {
    return openRequestCount;
  }

  public java.util.List<SessionRequest> getSessionRequests() {
    return sessionRequests;
  }
}
