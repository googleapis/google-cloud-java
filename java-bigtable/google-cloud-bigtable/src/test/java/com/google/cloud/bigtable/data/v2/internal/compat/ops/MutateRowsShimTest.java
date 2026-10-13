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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MutateRowsShimTest {

  private Client client;
  private TableAsync tableAsync;
  private AuthorizedViewAsync authViewAsync;
  private SessionPool<?> tablePool;
  private SessionPool<?> authViewPool;
  private MutateRowsShim shim;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    client = mock(Client.class);
    tableAsync = mock(TableAsync.class);
    authViewAsync = mock(AuthorizedViewAsync.class);
    tablePool = mock(SessionPool.class);
    authViewPool = mock(SessionPool.class);

    when(client.openTableAsync(any(), any())).thenReturn(tableAsync);
    when(client.openAuthorizedViewAsync(any(), any(), any())).thenReturn(authViewAsync);
    doReturn(tablePool).when(tableAsync).getSessionPool();
    doReturn(authViewPool).when(authViewAsync).getSessionPool();

    shim = new MutateRowsShim(new SessionPoolMap(client));
  }

  @Test
  void supports_tableId_belowThreshold_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_tableId_atThresholdNoSession_returnsFalse() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(false);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void supports_tableId_atThresholdWithSession_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(true);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_authorizedViewId_belowThreshold_returnsTrue() {
    when(authViewPool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    BulkMutation request = BulkMutation.create(AuthorizedViewId.of("table1", "view1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_unsupportedTargetId_returnsFalse() {
    TargetId unsupported = mock(TargetId.class);
    BulkMutation request = BulkMutation.create(unsupported);
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void call_tableId_returnsNull() throws Exception {
    SessionMutateRowsResponse response = SessionMutateRowsResponse.getDefaultInstance();
    when(tableAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    assertNull(shim.call(request, deadline).get());
  }

  @Test
  void call_authorizedViewId_returnsNull() throws Exception {
    SessionMutateRowsResponse response = SessionMutateRowsResponse.getDefaultInstance();
    when(authViewAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request = BulkMutation.create(AuthorizedViewId.of("table1", "view1"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    assertNull(shim.call(request, deadline).get());
  }

  @Test
  void call_unsupportedTargetId_futureFailsWithUnsupportedOperationException() {
    TargetId unsupported = mock(TargetId.class);
    BulkMutation request = BulkMutation.create(unsupported);
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    CompletableFuture<Void> future = shim.call(request, deadline);

    assertThat(future.isCompletedExceptionally()).isTrue();
    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(UnsupportedOperationException.class);
  }
}
