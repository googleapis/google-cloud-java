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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenTableRequest;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.MaterializedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.MaterializedViewId;
import com.google.cloud.bigtable.data.v2.models.TableId;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessionPoolMapTest {

  private Client client;

  @BeforeEach
  void setUp() {
    client = mock(Client.class);
  }

  private static TableAsync fakeTable() {
    TableAsync t = mock(TableAsync.class);
    when(t.getSessionPool()).thenReturn(mock(SessionPool.class));
    return t;
  }

  private static AuthorizedViewAsync fakeAuthView() {
    AuthorizedViewAsync v = mock(AuthorizedViewAsync.class);
    when(v.getSessionPool()).thenReturn(mock(SessionPool.class));
    return v;
  }

  private static MaterializedViewAsync fakeMatView() {
    MaterializedViewAsync v = mock(MaterializedViewAsync.class);
    when(v.getSessionPool()).thenReturn(mock(SessionPool.class));
    return v;
  }

  // --- error-unwrapping behavior (loader throws) ---

  @Test
  void get_unwrapsLoaderRuntimeException() {
    // Production trigger: Client.openTableAsync throws IllegalStateException after Client.close.
    // The Guava LoadingCache wraps it in UncheckedExecutionException; SessionPoolMap.get must
    // surface the original IllegalStateException so callers can pattern-match on it.
    when(client.openTableAsync(any(), any()))
        .thenThrow(new IllegalStateException("Client is closed"));
    SessionPoolMap map = new SessionPoolMap(client);

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> map.get(TableId.of("t1"), SessionKey.Permission.READ));
    assertThat(thrown).hasMessageThat().isEqualTo("Client is closed");
  }

  @Test
  void apply_convertsLoaderThrowToFailedFuture() throws Exception {
    // The async surface must not throw — callers wire onFailure handlers on the returned future.
    when(client.openTableAsync(any(), any()))
        .thenThrow(new IllegalStateException("Client is closed"));
    SessionPoolMap map = new SessionPoolMap(client);

    CompletableFuture<String> result =
        map.apply(
            TableId.of("t1"),
            SessionKey.Permission.READ,
            t -> CompletableFuture.completedFuture("unreached"));

    assertThat(result.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> result.get(1, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().isEqualTo("Client is closed");
  }

  @Test
  void apply_convertsOpSyncThrowToFailedFuture() throws Exception {
    // op.apply may throw synchronously (NPE on malformed input, REE during shutdown, any
    // RuntimeException from the wrapped call chain). The async surface must not propagate
    // the throw — same contract as the loader-throw path above.
    TableAsync handle = fakeTable();
    when(client.openTableAsync(any(), any())).thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    CompletableFuture<String> result =
        map.apply(
            TableId.of("t1"),
            SessionKey.Permission.READ,
            t -> {
              throw new IllegalStateException("op blew up");
            });

    assertThat(result.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> result.get(1, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().isEqualTo("op blew up");
  }

  @Test
  void apply_happyPathInvokesOp() throws Exception {
    TableAsync handle = fakeTable();
    when(client.openTableAsync(any(), any())).thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    String result =
        map.apply(
                TableId.of("t1"),
                SessionKey.Permission.READ,
                t -> CompletableFuture.completedFuture("ok"))
            .get(1, TimeUnit.SECONDS);

    assertThat(result).isEqualTo("ok");
  }

  @Test
  void apply_matView_happyPathInvokesOp() throws Exception {
    MaterializedViewAsync handle = fakeMatView();
    when(client.openMaterializedViewAsync(any(), any())).thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    String result =
        map.apply(
                MaterializedViewId.of("mv1"),
                SessionKey.Permission.READ,
                v -> CompletableFuture.completedFuture("ok"))
            .get(1, TimeUnit.SECONDS);

    assertThat(result).isEqualTo("ok");
  }

  // --- caching / pool-sharing behavior ---

  @Test
  void get_table_samePermission_returnsCachedHandle() {
    TableAsync handle = fakeTable();
    when(client.openTableAsync(eq("t1"), eq(OpenTableRequest.Permission.PERMISSION_READ)))
        .thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    TableId id = TableId.of("t1");
    assertThat(map.get(id, SessionKey.Permission.READ)).isSameInstanceAs(handle);
    assertThat(map.get(id, SessionKey.Permission.READ)).isSameInstanceAs(handle);
    verify(client, times(1)).openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ);
  }

  @Test
  void get_table_differentPermissions_returnsDifferentHandles() {
    TableAsync readHandle = fakeTable();
    TableAsync writeHandle = fakeTable();
    when(client.openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ))
        .thenReturn(readHandle);
    when(client.openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_WRITE))
        .thenReturn(writeHandle);
    SessionPoolMap map = new SessionPoolMap(client);

    TableId id = TableId.of("t1");
    assertThat(map.get(id, SessionKey.Permission.READ)).isSameInstanceAs(readHandle);
    assertThat(map.get(id, SessionKey.Permission.WRITE)).isSameInstanceAs(writeHandle);
  }

  @Test
  void get_sharedMap_samePermission_sharesSingleHandle() {
    // Two shims sharing one SessionPoolMap with the same (id, permission) get the same handle,
    // i.e. the same session pool — the key motivation for this refactor.
    TableAsync handle = fakeTable();
    when(client.openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ_WRITE))
        .thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    TableId id = TableId.of("t1");
    assertThat(map.get(id, SessionKey.Permission.READ_WRITE))
        .isSameInstanceAs(map.get(id, SessionKey.Permission.READ_WRITE));
    verify(client, times(1))
        .openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ_WRITE);
  }

  @Test
  void get_authView_cachedPerPermission() {
    AuthorizedViewAsync handle = fakeAuthView();
    when(client.openAuthorizedViewAsync(
            eq("t1"), eq("v1"), eq(OpenAuthorizedViewRequest.Permission.PERMISSION_WRITE)))
        .thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    AuthorizedViewId id = AuthorizedViewId.of("t1", "v1");
    assertThat(map.get(id, SessionKey.Permission.WRITE)).isSameInstanceAs(handle);
    assertThat(map.get(id, SessionKey.Permission.WRITE)).isSameInstanceAs(handle);
    verify(client, times(1))
        .openAuthorizedViewAsync("t1", "v1", OpenAuthorizedViewRequest.Permission.PERMISSION_WRITE);
  }

  @Test
  void get_matView_cachedForRead() {
    MaterializedViewAsync handle = fakeMatView();
    when(client.openMaterializedViewAsync(
            eq("mv1"), eq(OpenMaterializedViewRequest.Permission.PERMISSION_READ)))
        .thenReturn(handle);
    SessionPoolMap map = new SessionPoolMap(client);

    MaterializedViewId id = MaterializedViewId.of("mv1");
    assertThat(map.get(id, SessionKey.Permission.READ)).isSameInstanceAs(handle);
    assertThat(map.get(id, SessionKey.Permission.READ)).isSameInstanceAs(handle);
    verify(client, times(1))
        .openMaterializedViewAsync("mv1", OpenMaterializedViewRequest.Permission.PERMISSION_READ);
  }

  @Test
  void invalidateAll_closesCachedValues() {
    // After invalidateAll the Guava cache evicts and the removal listener calls close()
    // on the handles. A second get() should re-invoke the loader.
    TableAsync first = fakeTable();
    TableAsync second = fakeTable();
    when(client.openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ))
        .thenReturn(first)
        .thenReturn(second);
    SessionPoolMap map = new SessionPoolMap(client);

    TableId id = TableId.of("t1");
    map.get(id, SessionKey.Permission.READ);
    map.invalidateAll();

    verify(first, times(1)).close();
    TableAsync afterInvalidate = map.get(id, SessionKey.Permission.READ);
    verify(client, times(2)).openTableAsync("t1", OpenTableRequest.Permission.PERMISSION_READ);
    assertThat(afterInvalidate).isSameInstanceAs(second);
  }

  // --- SessionKey.Permission matView constraints ---

  @Test
  void sessionPermission_matViewWrite_throwsUnsupported() {
    assertThrows(
        UnsupportedOperationException.class, SessionKey.Permission.WRITE::matViewPermission);
  }

  @Test
  void sessionPermission_matViewReadWrite_throwsUnsupported() {
    assertThrows(
        UnsupportedOperationException.class, SessionKey.Permission.READ_WRITE::matViewPermission);
  }
}
