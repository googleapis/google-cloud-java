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

import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.cloud.bigtable.data.v2.internal.session.Session;
import com.google.cloud.bigtable.data.v2.internal.session.Session.SessionState;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FakeSessionListener implements Session.Listener {
  private BlockingDeque<Object> msgs = new LinkedBlockingDeque<>();

  @Override
  public void onReady(OpenSessionResponse msg) {
    msgs.add(msg);
  }

  @Override
  public void onGoAway(GoAwayResponse msg) {
    msgs.add(msg);
  }

  @Override
  public void onClose(SessionState prevState, Status status, Metadata trailers) {
    msgs.add(status);
  }

  @SuppressWarnings("unchecked")
  public <T> T popUntil(Class<T> cls) throws InterruptedException, TimeoutException {
    List<Object> seen = new ArrayList<>();

    Object msg = null;
    while (!cls.isInstance(msg)) {
      try {
        msg = popNext();
        seen.add(msg);
      } catch (TimeoutException e) {
        throw new TimeoutException(
            "Timed out waiting to popUntil event of: " + cls + ", seen: " + seen);
      }
    }
    return (T) msg;
  }

  public Object popNext() throws InterruptedException, TimeoutException {
    return popNext(Duration.ofSeconds(1));
  }

  public Object popNext(Duration timeout) throws InterruptedException, TimeoutException {
    Object obj = msgs.poll(timeout.toMillis(), TimeUnit.MILLISECONDS);
    if (obj == null) {
      throw new TimeoutException("Timed out waiting to popNext Session event");
    }
    return obj;
  }
}
