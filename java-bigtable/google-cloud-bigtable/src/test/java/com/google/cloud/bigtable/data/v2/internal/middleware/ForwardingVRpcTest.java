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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import io.grpc.Deadline;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ForwardingVRpcTest {
  @Mock private VRpc<String, String> innerVRpc;

  @Mock private VRpcListener<String> outerListener;

  @Captor private ArgumentCaptor<VRpcListener<String>> innerListenerCaptor;

  private final VRpcTracer tracer = NoopMetrics.NoopVrpcTracer.INSTANCE;

  @Test
  void proxyOkTest() {
    ForwardingVRpc<String, String> outerVRpc = new ForwardingVRpc<>(innerVRpc);
    VRpcCallContext ctx =
        VRpcCallContext.create(Deadline.after(10, TimeUnit.SECONDS), false, tracer);
    // Start
    outerVRpc.start("req", ctx, outerListener);
    verify(innerVRpc).start(Mockito.eq("req"), Mockito.same(ctx), innerListenerCaptor.capture());

    // Listener
    VRpcListener<String> innerListener = innerListenerCaptor.getValue();

    // Listener.onMessage
    innerListener.onMessage("response");
    verify(outerListener).onMessage("response");

    // Listener.onClose
    VRpcResult result =
        VRpcResult.createServerOk(VirtualRpcResponse.newBuilder().setRpcId(1).build());
    innerListener.onClose(result);
    verify(outerListener).onClose(result);
  }

  @Test
  void proxyCancelTest() {
    ForwardingVRpc<String, String> outerVRpc = new ForwardingVRpc<>(innerVRpc);
    VRpcCallContext ctx =
        VRpcCallContext.create(Deadline.after(10, TimeUnit.SECONDS), false, tracer);
    // Start
    outerVRpc.start("req", ctx, outerListener);
    Throwable t = new RuntimeException();
    outerVRpc.cancel("reason", t);

    verify(innerVRpc).cancel("reason", t);
  }

  @Test
  void proxyRequestNextTest() {
    ForwardingVRpc<String, String> outerVRpc = new ForwardingVRpc<>(innerVRpc);
    VRpcCallContext ctx =
        VRpcCallContext.create(Deadline.after(10, TimeUnit.SECONDS), false, tracer);
    outerVRpc.start("req", ctx, outerListener);
    verify(innerVRpc).start(Mockito.anyString(), Mockito.any(), innerListenerCaptor.capture());
    VRpcListener<String> innerListener = innerListenerCaptor.getValue();
    innerListener.onMessage("s");

    outerVRpc.requestNext();
    verify(innerVRpc, times(1)).requestNext();
  }
}
