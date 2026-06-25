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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaybePointReadCallableTest {

  private static final TableId TABLE_ID = TableId.of("fake-table");
  private static final Row ROW_A =
      Row.create(ByteString.copyFromUtf8("a"), ImmutableList.<RowCell>of());
  private static final Row ROW_B =
      Row.create(ByteString.copyFromUtf8("b"), ImmutableList.<RowCell>of());

  private ServerStreamingStashCallable<Query, Row> classic;
  private FakePointReader pointReader;
  private MaybePointReadCallable<Row> callable;
  private RecordingObserver observer;

  @BeforeEach
  public void setUp() {
    classic = new ServerStreamingStashCallable<>(ImmutableList.of(ROW_A, ROW_B));
    pointReader = new FakePointReader();
    callable = new MaybePointReadCallable<>(classic, pointReader);
    observer = new RecordingObserver();
  }

  @Test
  public void singleRowKey_routesToPointReader() {
    Query query = Query.create(TABLE_ID).rowKey("a");

    callable.call(query, observer, null);
    pointReader.response.set(ROW_A);

    assertThat(pointReader.request).isEqualTo(query);
    assertThat(observer.responses).containsExactly(ROW_A);
    assertThat(observer.completed).isTrue();
    assertThat(observer.error).isNull();
    assertThat(classic.getActualRequest()).isNull();
  }

  @Test
  public void singleClosedRange_routesToPointReader() {
    Query query =
        Query.create(TABLE_ID).range(ByteStringRange.unbounded().startClosed("a").endClosed("a"));

    callable.call(query, observer, null);
    pointReader.response.set(ROW_A);

    assertThat(pointReader.request).isEqualTo(query);
    assertThat(observer.responses).containsExactly(ROW_A);
    assertThat(observer.completed).isTrue();
  }

  @Test
  public void multipleRowKeys_fallsThroughToClassic() {
    Query query = Query.create(TABLE_ID).rowKey("a").rowKey("b");

    callable.call(query, observer, null);

    assertThat(pointReader.request).isNull();
    assertThat(classic.getActualRequest()).isEqualTo(query);
    assertThat(observer.responses).containsExactly(ROW_A, ROW_B).inOrder();
    assertThat(observer.completed).isTrue();
  }

  @Test
  public void unboundedRange_fallsThroughToClassic() {
    Query query = Query.create(TABLE_ID);

    callable.call(query, observer, null);

    assertThat(pointReader.request).isNull();
    assertThat(classic.getActualRequest()).isEqualTo(query);
  }

  @Test
  public void pointReaderReturnsNull_completesWithoutResponse() {
    Query query = Query.create(TABLE_ID).rowKey("missing");

    callable.call(query, observer, null);
    pointReader.response.set(null);

    assertThat(observer.responses).isEmpty();
    assertThat(observer.completed).isTrue();
    assertThat(observer.error).isNull();
  }

  @Test
  public void pointReaderFails_propagatesErrorToObserver() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    RuntimeException failure = new RuntimeException("boom");

    callable.call(query, observer, null);
    pointReader.response.setException(failure);

    assertThat(observer.responses).isEmpty();
    assertThat(observer.completed).isFalse();
    assertThat(observer.error).isSameInstanceAs(failure);
  }

  @Test
  public void observerCancel_cancelsFutureAndSuppressesError() {
    Query query = Query.create(TABLE_ID).rowKey("a");

    callable.call(query, observer, null);
    observer.controller.cancel();

    assertThat(pointReader.response.isCancelled()).isTrue();
    assertThat(observer.error).isNull();
    assertThat(observer.completed).isFalse();
  }

  @Test
  public void cancelBeforeFutureReturns_cancelsAfterFutureAttaches() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    pointReader.onCall = () -> observer.controller.cancel();

    callable.call(query, observer, null);

    assertThat(pointReader.response.isCancelled()).isTrue();
    assertThat(observer.error).isNull();
  }

  @Test
  public void futureCallThrows_routesThroughOnError() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    RuntimeException failure = new RuntimeException("sync boom");
    pointReader.syncFailure = failure;

    callable.call(query, observer, null);

    assertThat(observer.controller).isNotNull();
    assertThat(observer.error).isSameInstanceAs(failure);
    assertThat(observer.completed).isFalse();
  }

  @Test
  public void futureCallThrowsAfterCancel_suppressesError() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    pointReader.syncFailure = new RuntimeException("sync boom");
    pointReader.onCall = () -> observer.controller.cancel();

    callable.call(query, observer, null);

    assertThat(observer.error).isNull();
  }

  private static class FakePointReader extends UnaryCallable<Query, Row> {
    Query request;
    final SettableApiFuture<Row> response = SettableApiFuture.create();
    RuntimeException syncFailure;
    Runnable onCall;

    @Override
    public ApiFuture<Row> futureCall(Query request, ApiCallContext context) {
      this.request = request;
      if (onCall != null) {
        onCall.run();
      }
      if (syncFailure != null) {
        throw syncFailure;
      }
      return response;
    }
  }

  private static class RecordingObserver implements ResponseObserver<Row> {
    final List<Row> responses = new ArrayList<>();
    boolean completed;
    Throwable error;
    StreamController controller;

    @Override
    public void onStart(StreamController controller) {
      this.controller = controller;
    }

    @Override
    public void onResponse(Row response) {
      responses.add(response);
    }

    @Override
    public void onError(Throwable t) {
      error = t;
    }

    @Override
    public void onComplete() {
      completed = true;
    }
  }
}
