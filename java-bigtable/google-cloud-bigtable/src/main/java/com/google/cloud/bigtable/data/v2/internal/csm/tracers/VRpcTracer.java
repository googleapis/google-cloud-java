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

import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import java.time.Duration;

public interface VRpcTracer {

  void onOperationStart();

  void onAttemptStart(Object request);

  void onRequestSent(PeerInfo peerInfo);

  void onResponseReceived();

  void recordApplicationBlockingLatencies(Duration elapsed);

  void onAttemptFinish(VRpcResult result);

  void onOperationFinish(VRpcResult result);
}
