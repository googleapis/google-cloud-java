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

package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.common.collect.ImmutableList;
import io.grpc.Status;
import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CompositeVRpcTracerTest {

  @Mock VRpcTracer child1;
  @Mock VRpcTracer child2;
  private CompositeVRpcTracer compositeVRpcTracer;

  @BeforeEach
  void setup() {
    compositeVRpcTracer = new CompositeVRpcTracer(ImmutableList.of(child1, child2));
  }

  @Test
  void onOperationStartTest() {
    compositeVRpcTracer.onOperationStart();
    verify(child1, times(1)).onOperationStart();
    verify(child2, times(1)).onOperationStart();
  }

  @Test
  void onAttemptStartTest() {
    SessionReadRowRequest request = SessionReadRowRequest.getDefaultInstance();
    compositeVRpcTracer.onAttemptStart(request);
    verify(child1, times(1)).onAttemptStart(request);
    verify(child2, times(1)).onAttemptStart(request);
  }

  @Test
  void onRequestSentTest() {
    PeerInfo fakePeerInfo = PeerInfo.getDefaultInstance();
    compositeVRpcTracer.onRequestSent(fakePeerInfo);
    verify(child1, times(1)).onRequestSent(fakePeerInfo);
    verify(child2, times(1)).onRequestSent(fakePeerInfo);
  }

  @Test
  void onApplicationBlockingLatenciesTest() {
    Duration elapsed = Duration.ofMillis(5);
    compositeVRpcTracer.recordApplicationBlockingLatencies(elapsed);
    verify(child1, times(1)).recordApplicationBlockingLatencies(elapsed);
    verify(child2, times(1)).recordApplicationBlockingLatencies(elapsed);
  }

  @Test
  void onAttemptFinishTest() {
    VRpc.VRpcResult result = VRpc.VRpcResult.createLocalTransportError(Status.UNAVAILABLE);
    compositeVRpcTracer.onAttemptFinish(result);
    verify(child1, times(1)).onAttemptFinish(result);
    verify(child2, times(1)).onAttemptFinish(result);
  }

  @Test
  void onOperationFinishTest() {
    VRpc.VRpcResult result = VRpc.VRpcResult.createLocalTransportError(Status.UNAVAILABLE);
    compositeVRpcTracer.onOperationFinish(result);
    verify(child1, times(1)).onOperationFinish(result);
    verify(child2, times(1)).onOperationFinish(result);
  }
}
