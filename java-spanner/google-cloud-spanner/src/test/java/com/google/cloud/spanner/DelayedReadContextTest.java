/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DelayedReadContextTest {

  @Test
  public void closeAsyncDelegatesToReadContextCloseAsyncWhenFutureAlreadyResolved()
      throws Exception {
    ReadContext mockReadContext = mock(ReadContext.class);
    when(mockReadContext.closeAsync()).thenReturn(ApiFutures.immediateFuture(null));

    SettableApiFuture<ReadContext> readContextFuture = SettableApiFuture.create();
    readContextFuture.set(mockReadContext);
    DelayedReadContext<ReadContext> delayedReadContext =
        new DelayedReadContext<>(readContextFuture);

    ApiFuture<Void> closeFuture = delayedReadContext.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
    verify(mockReadContext).closeAsync();
    verify(mockReadContext, never()).close();
  }

  @Test
  public void closeAsyncCancelsPendingReadContextFutureWhenNotYetDone() throws Exception {
    SettableApiFuture<ReadContext> readContextFuture = SettableApiFuture.create();
    DelayedReadContext<ReadContext> delayedReadContext =
        new DelayedReadContext<>(readContextFuture);

    ApiFuture<Void> closeFuture = delayedReadContext.closeAsync();
    assertTrue(closeFuture.isDone());
    assertTrue(readContextFuture.isCancelled());
  }

  @Test
  public void closeAsyncSuppressesExceptionWhenUnderlyingCloseAsyncFails() throws Exception {
    ReadContext mockReadContext = mock(ReadContext.class);
    when(mockReadContext.closeAsync())
        .thenReturn(ApiFutures.immediateFailedFuture(new RuntimeException("Close failed")));

    SettableApiFuture<ReadContext> readContextFuture = SettableApiFuture.create();
    readContextFuture.set(mockReadContext);
    DelayedReadContext<ReadContext> delayedReadContext =
        new DelayedReadContext<>(readContextFuture);

    ApiFuture<Void> closeFuture = delayedReadContext.closeAsync();
    closeFuture.get(10, TimeUnit.SECONDS);
    assertTrue(closeFuture.isDone());
  }

  @Test
  public void syncCloseCancelsPendingReadContextFutureWhenNotYetDone() {
    SettableApiFuture<ReadContext> readContextFuture = SettableApiFuture.create();
    DelayedReadContext<ReadContext> delayedReadContext =
        new DelayedReadContext<>(readContextFuture);

    delayedReadContext.close();
    assertTrue(readContextFuture.isCancelled());
  }

  @Test
  public void syncCloseDelegatesToReadContextCloseWhenFutureAlreadyResolved() {
    ReadContext mockReadContext = mock(ReadContext.class);
    SettableApiFuture<ReadContext> readContextFuture = SettableApiFuture.create();
    readContextFuture.set(mockReadContext);

    DelayedReadContext<ReadContext> delayedReadContext =
        new DelayedReadContext<>(readContextFuture);
    delayedReadContext.close();

    verify(mockReadContext).close();
  }
}
