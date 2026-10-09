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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.SessionReadModifyWriteRowResponse;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadModifyWriteRowShimTest {

  private Client client;
  private TableAsync tableAsync;
  private AuthorizedViewAsync authViewAsync;
  private SessionPool<?> tablePool;
  private SessionPool<?> authViewPool;
  private ReadModifyWriteRowShim shim;

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

    shim = new ReadModifyWriteRowShim(new ReadWriteSessionPools(client));
  }

  @Test
  void supports_tableId_belowThreshold_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    ReadModifyWriteRow request = ReadModifyWriteRow.create("table1", "key");
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_tableId_atThresholdNoSession_returnsFalse() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(false);

    ReadModifyWriteRow request = ReadModifyWriteRow.create("table1", "key");
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void supports_tableId_atThresholdWithSession_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(true);

    ReadModifyWriteRow request = ReadModifyWriteRow.create("table1", "key");
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_authorizedViewId_belowThreshold_returnsTrue() {
    when(authViewPool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    ReadModifyWriteRow request =
        ReadModifyWriteRow.create(AuthorizedViewId.of("table1", "view1"), "key");
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_unsupportedTargetId_returnsFalse() {
    TargetId unsupported = mock(TargetId.class);
    ReadModifyWriteRow request = ReadModifyWriteRow.create(unsupported, "key");
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void call_tableId_returnsResponse() throws Exception {
    SessionReadModifyWriteRowResponse response =
        SessionReadModifyWriteRowResponse.getDefaultInstance();
    CompletableFuture<SessionReadModifyWriteRowResponse> future =
        CompletableFuture.completedFuture(response);
    when(tableAsync.readModifyWriteRow(any(), any())).thenReturn(future);

    ReadModifyWriteRow request = ReadModifyWriteRow.create("table1", "key");
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    SessionReadModifyWriteRowResponse result = shim.call(request, deadline).get();
    assertThat(result).isEqualTo(response);
  }

  @Test
  void call_authorizedViewId_returnsResponse() throws Exception {
    SessionReadModifyWriteRowResponse response =
        SessionReadModifyWriteRowResponse.getDefaultInstance();
    CompletableFuture<SessionReadModifyWriteRowResponse> future =
        CompletableFuture.completedFuture(response);
    when(authViewAsync.readModifyWriteRow(any(), any())).thenReturn(future);

    ReadModifyWriteRow request =
        ReadModifyWriteRow.create(AuthorizedViewId.of("table1", "view1"), "key");
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    SessionReadModifyWriteRowResponse result = shim.call(request, deadline).get();
    assertThat(result).isEqualTo(response);
  }

  @Test
  void call_unsupportedTargetId_futureFailsWithUnsupportedOperationException() {
    TargetId unsupported = mock(TargetId.class);
    ReadModifyWriteRow request = ReadModifyWriteRow.create(unsupported, "key");
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    CompletableFuture<SessionReadModifyWriteRowResponse> future = shim.call(request, deadline);

    assertThat(future.isCompletedExceptionally()).isTrue();
    ExecutionException ex =
        org.junit.jupiter.api.Assertions.assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(UnsupportedOperationException.class);
  }
}
