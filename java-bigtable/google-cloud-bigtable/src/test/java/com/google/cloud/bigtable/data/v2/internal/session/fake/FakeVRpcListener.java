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

import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import java.time.Duration;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeVRpcListener<RespT> implements VRpcListener<RespT> {
  private BlockingDeque<Object> msgs = new LinkedBlockingDeque<>();
  private final AtomicInteger onMessageCount = new AtomicInteger(0);

  @Override
  public void onMessage(RespT msg) {
    onMessageCount.getAndIncrement();
    msgs.add(msg);
  }

  @Override
  public void onClose(VRpcResult result) {
    msgs.add(result);
  }

  @SuppressWarnings("unchecked")
  public <T> T popUntil(Class<T> cls) throws InterruptedException {
    Object obj = null;
    while (!cls.isInstance(obj)) {
      obj = popNext();
    }
    return (T) obj;
  }

  public Object popNext() throws InterruptedException {
    return popNext(Duration.ofSeconds(1));
  }

  public Object popNext(Duration timeout) throws InterruptedException {
    return msgs.poll(timeout.toMillis(), TimeUnit.MILLISECONDS);
  }

  public int getOnMessageCount() {
    return onMessageCount.get();
  }
}
