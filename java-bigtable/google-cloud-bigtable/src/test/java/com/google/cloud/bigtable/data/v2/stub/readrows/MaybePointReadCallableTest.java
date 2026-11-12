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
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
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
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
  public void observerCancel_cancelsFutureAndPropagatesCancellation() {
    Query query = Query.create(TABLE_ID).rowKey("a");

    callable.call(query, observer, null);
    observer.controller.cancel();

    assertThat(pointReader.response.isCancelled()).isTrue();
    assertThat(observer.error).isInstanceOf(CancellationException.class);
    assertThat(observer.completed).isFalse();
  }

  @Test
  public void cancelBeforeFutureReturns_cancelsAfterFutureAttaches() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    pointReader.onCall = () -> observer.controller.cancel();

    callable.call(query, observer, null);

    assertThat(pointReader.response.isCancelled()).isTrue();
    assertThat(observer.error).isInstanceOf(CancellationException.class);
    assertThat(observer.completed).isFalse();
  }

  @Test
  public void cancelWhenFutureAlreadyCompleted_propagatesCancellationWithoutResponse() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    pointReader.response.set(ROW_A);
    pointReader.onCall = () -> observer.controller.cancel();

    callable.call(query, observer, null);

    assertThat(observer.responses).isEmpty();
    assertThat(observer.error).isInstanceOf(CancellationException.class);
    assertThat(observer.completed).isFalse();
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
  public void futureCallThrowsAfterCancel_propagatesCancellation() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    pointReader.syncFailure = new RuntimeException("sync boom");
    pointReader.onCall = () -> observer.controller.cancel();

    callable.call(query, observer, null);

    assertThat(observer.error).isInstanceOf(CancellationException.class);
    assertThat(observer.completed).isFalse();
  }

  @Test
  public void cancelInsideOnResponse_deliversCancellationAndNotOnComplete() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    RecordingObserver cancellingObserver =
        new RecordingObserver() {
          @Override
          public void onResponse(Row response) {
            super.onResponse(response);
            controller.cancel();
          }
        };

    callable.call(query, cancellingObserver, null);
    pointReader.response.set(ROW_A);

    assertThat(cancellingObserver.responses).containsExactly(ROW_A);
    assertThat(cancellingObserver.completed).isFalse();
    assertThat(cancellingObserver.error).isInstanceOf(CancellationException.class);
  }

  @Test
  public void serverStreamCancel_unblocksBlockedHasNext() throws Exception {
    Query query = Query.create(TABLE_ID).rowKey("a");
    ServerStream<Row> stream = callable.call(query);

    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      CountDownLatch entered = new CountDownLatch(1);
      Future<Boolean> hasNextFuture =
          executor.submit(
              () -> {
                entered.countDown();
                return stream.iterator().hasNext();
              });
      assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue();
      Thread.sleep(20);

      stream.cancel();

      ExecutionException thrown =
          assertThrows(ExecutionException.class, () -> hasNextFuture.get(5, TimeUnit.SECONDS));
      assertThat(thrown.getCause()).isInstanceOf(CancellationException.class);
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void manualFlowControl_gatesDeliveryUntilRequested() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    RecordingObserver manualObserver =
        new RecordingObserver() {
          @Override
          public void onStart(StreamController controller) {
            super.onStart(controller);
            controller.disableAutoInboundFlowControl();
          }
        };

    callable.call(query, manualObserver, null);
    pointReader.response.set(ROW_A);

    // Demand is 0, so row must not be delivered yet
    assertThat(manualObserver.responses).isEmpty();
    assertThat(manualObserver.completed).isFalse();
    assertThat(manualObserver.error).isNull();

    manualObserver.controller.request(1);

    assertThat(manualObserver.responses).containsExactly(ROW_A);
    assertThat(manualObserver.completed).isTrue();
    assertThat(manualObserver.error).isNull();
  }

  @Test
  public void manualFlowControl_cancelBeforeRequestDeliversCancellationWithoutRow() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    RecordingObserver manualObserver =
        new RecordingObserver() {
          @Override
          public void onStart(StreamController controller) {
            super.onStart(controller);
            controller.disableAutoInboundFlowControl();
          }
        };

    callable.call(query, manualObserver, null);
    pointReader.response.set(ROW_A);

    manualObserver.controller.cancel();

    assertThat(manualObserver.responses).isEmpty();
    assertThat(manualObserver.completed).isFalse();
    assertThat(manualObserver.error).isInstanceOf(CancellationException.class);
  }

  @Test
  public void flowControlPreconditions_enforced() {
    Query query = Query.create(TABLE_ID).rowKey("a");
    callable.call(query, observer, null);

    // Cannot disable auto flow control after onStart has finished
    assertThrows(
        IllegalStateException.class, () -> observer.controller.disableAutoInboundFlowControl());
    // Cannot call request(int) while auto flow control is enabled
    assertThrows(IllegalStateException.class, () -> observer.controller.request(1));

    RecordingObserver manualObserver =
        new RecordingObserver() {
          @Override
          public void onStart(StreamController controller) {
            super.onStart(controller);
            controller.disableAutoInboundFlowControl();
          }
        };
    callable.call(query, manualObserver, null);
    assertThrows(IllegalArgumentException.class, () -> manualObserver.controller.request(0));
    assertThrows(IllegalArgumentException.class, () -> manualObserver.controller.request(-1));
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
