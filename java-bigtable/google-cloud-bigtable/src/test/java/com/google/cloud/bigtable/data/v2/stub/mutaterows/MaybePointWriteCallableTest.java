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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaybePointWriteCallableTest {

  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("my-project", "my-instance", "my-profile");
  private static final TableId TABLE_ID = TableId.of("fake-table");

  private FakeBulkCallable classic;
  private FakePointWriter pointWriter;
  private MaybePointWriteCallable callable;

  @BeforeEach
  public void setUp() {
    classic = new FakeBulkCallable();
    pointWriter = new FakePointWriter();
    callable = new MaybePointWriteCallable(classic, pointWriter, REQUEST_CONTEXT);
  }

  @Test
  public void singleEntry_routesToPointWriter() throws Exception {
    BulkMutation request =
        BulkMutation.create(TABLE_ID).add("row-key", Mutation.create().deleteRow());

    ApiFuture<Void> future = callable.futureCall(request, null);
    pointWriter.response.set(null);

    assertThat((Object) future.get()).isNull();
    assertThat(classic.request).isNull();
    assertThat(pointWriter.request).isNotNull();
    // The single entry is converted back into a RowMutation targeting the same row.
    assertThat(pointWriter.request.getTargetId()).isEqualTo(TABLE_ID);
  }

  @Test
  public void multipleEntries_fallsThroughToClassic() {
    BulkMutation request =
        BulkMutation.create(TABLE_ID)
            .add("row-a", Mutation.create().deleteRow())
            .add("row-b", Mutation.create().deleteRow());

    callable.futureCall(request, null);

    assertThat(pointWriter.request).isNull();
    assertThat(classic.request).isEqualTo(request);
  }

  @Test
  public void pointWriterFails_propagates() {
    BulkMutation request =
        BulkMutation.create(TABLE_ID).add("row-key", Mutation.create().deleteRow());
    RuntimeException failure = new RuntimeException("point boom");

    ApiFuture<Void> future = callable.futureCall(request, null);
    pointWriter.response.setException(failure);

    ExecutionException thrown = assertThrows(ExecutionException.class, future::get);
    assertThat(thrown).hasCauseThat().isSameInstanceAs(failure);
  }

  @Test
  public void classicFailure_propagates() {
    BulkMutation request =
        BulkMutation.create(TABLE_ID)
            .add("row-a", Mutation.create().deleteRow())
            .add("row-b", Mutation.create().deleteRow());
    RuntimeException failure = new RuntimeException("classic boom");
    classic.response.setException(failure);

    ApiFuture<Void> future = callable.futureCall(request, null);

    ExecutionException thrown = assertThrows(ExecutionException.class, future::get);
    assertThat(thrown).hasCauseThat().isSameInstanceAs(failure);
  }

  private static class FakeBulkCallable extends UnaryCallable<BulkMutation, Void> {
    BulkMutation request;
    final SettableApiFuture<Void> response = SettableApiFuture.create();

    @Override
    public ApiFuture<Void> futureCall(BulkMutation request, ApiCallContext context) {
      this.request = request;
      return response;
    }
  }

  private static class FakePointWriter extends UnaryCallable<RowMutation, Void> {
    RowMutation request;
    final SettableApiFuture<Void> response = SettableApiFuture.create();

    @Override
    public ApiFuture<Void> futureCall(RowMutation request, ApiCallContext context) {
      this.request = request;
      return response;
    }
  }
}
