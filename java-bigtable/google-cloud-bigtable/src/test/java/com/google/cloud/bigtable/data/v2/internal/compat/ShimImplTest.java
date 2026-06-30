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
package com.google.cloud.bigtable.data.v2.internal.compat;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.Client.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ShimImplTest {

  private static final InstantiatingGrpcChannelProvider EMPTY_TRANSPORT =
      InstantiatingGrpcChannelProvider.newBuilder().build();

  @Test
  public void selectUserCallbackExecutor_transportSet_returnsSharedTransportExecutor() {
    Executor userExec = mock(Executor.class);
    InstantiatingGrpcChannelProvider transport =
        InstantiatingGrpcChannelProvider.newBuilder().setExecutor(userExec).build();

    Resource<Executor> resource = ShimImpl.selectUserCallbackExecutor(transport, null);

    assertThat(resource.get()).isSameInstanceAs(userExec);
    // Shared resources have a no-op closer; close() must not throw.
    resource.close();
  }

  @Test
  public void selectUserCallbackExecutor_legacyNoAutoClose_returnsSharedExecutor() {
    ScheduledExecutorService userExec = mock(ScheduledExecutorService.class);

    Resource<Executor> resource =
        ShimImpl.selectUserCallbackExecutor(
            EMPTY_TRANSPORT, FixedExecutorProvider.create(userExec, /* shouldAutoClose= */ false));

    assertThat(resource.get()).isSameInstanceAs(userExec);
    resource.close();
    verify(userExec, never()).shutdown();
  }

  @Test
  public void selectUserCallbackExecutor_legacyAutoClose_returnsOwnedExecutor() {
    ScheduledExecutorService userExec = mock(ScheduledExecutorService.class);

    Resource<Executor> resource =
        ShimImpl.selectUserCallbackExecutor(
            EMPTY_TRANSPORT, FixedExecutorProvider.create(userExec, /* shouldAutoClose= */ true));

    assertThat(resource.get()).isSameInstanceAs(userExec);
    resource.close();
    verify(userExec).shutdown();
  }

  @Test
  public void selectUserCallbackExecutor_unset_allocatesOwnedCachedPool() throws Exception {
    Resource<Executor> resource = ShimImpl.selectUserCallbackExecutor(EMPTY_TRANSPORT, null);

    Executor exec = resource.get();
    assertThat(exec).isInstanceOf(ExecutorService.class);

    String[] threadName = new String[1];
    CountDownLatch done = new CountDownLatch(1);
    exec.execute(
        () -> {
          threadName[0] = Thread.currentThread().getName();
          done.countDown();
        });
    assertThat(done.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(threadName[0]).startsWith("bigtable-callback-shim-");

    resource.close();
    assertThat(((ExecutorService) exec).isShutdown()).isTrue();
  }
}
