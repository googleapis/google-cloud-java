/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.LocalFirestoreHelper.endAt;
import static com.google.cloud.firestore.LocalFirestoreHelper.filter;
import static com.google.cloud.firestore.LocalFirestoreHelper.limit;
import static com.google.cloud.firestore.LocalFirestoreHelper.offset;
import static com.google.cloud.firestore.LocalFirestoreHelper.order;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.select;
import static com.google.cloud.firestore.LocalFirestoreHelper.startAt;
import static com.google.cloud.firestore.LocalFirestoreHelper.unaryFilter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.StructuredQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.threeten.bp.Instant;

@RunWith(MockitoJUnitRunner.class)
public class QueryTest {

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<RunQueryRequest> runQuery;

  @Captor private ArgumentCaptor<ApiStreamObserver> streamObserverCapture;

  private Query query;

  @Before
  public void before() {
    query = firestoreMock.collection("coll");
  }

  @Test
  public void withLimit() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.limit(42).get().get();

    assertEquals(query(limit(42)), runQuery.getValue());
  }

  @Test
  public void withOffset() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.offset(42).get().get();

    assertEquals(query(offset(42)), runQuery.getValue());
  }

  @Test
  public void withFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.whereEqualTo("foo", "bar").get().get();
    query.whereEqualTo("foo", null).get().get();
    query.whereEqualTo("foo", Double.NaN).get().get();
    query.whereEqualTo("foo", Float.NaN).get().get();
    query.whereGreaterThan("foo", "bar").get().get();
    query.whereGreaterThanOrEqualTo("foo", "bar").get().get();
    query.whereLessThan("foo", "bar").get().get();
    query.whereLessThanOrEqualTo("foo", "bar").get().get();

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NULL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expected.next(), actual);
    }
  }

  @Test
  public void withFieldPathFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.whereEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereGreaterThan(FieldPath.of("foo"), "bar").get().get();
    query.whereGreaterThanOrEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereLessThan(FieldPath.of("foo"), "bar").get().get();
    query.whereLessThanOrEqualTo(FieldPath.of("foo"), "bar").get().get();

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expected.next(), actual);
    }
  }

  @Test
  public void withOrderBy() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").orderBy("foo.bar", Query.Direction.DESCENDING).get().get();

    assertEquals(
        query(
            order("foo", StructuredQuery.Direction.ASCENDING),
            order("foo.bar", StructuredQuery.Direction.DESCENDING)),
        runQuery.getValue());
  }

  @Test
  public void withFieldPathOrderBy() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query
        .orderBy(FieldPath.of("foo"))
        .orderBy(FieldPath.of("foo", "bar"), Query.Direction.DESCENDING)
        .get()
        .get();

    assertEquals(
        query(
            order("foo", StructuredQuery.Direction.ASCENDING),
            order("foo.bar", StructuredQuery.Direction.DESCENDING)),
        runQuery.getValue());
  }

  @Test
  public void withSelect() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.select(new String[] {}).get().get();
    query.select("foo", "foo.bar").get().get();

    Iterator<RunQueryRequest> expectedQuery =
        Arrays.asList(
                query(select(FieldPath.documentId())), query(select("foo"), select("foo.bar")))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expectedQuery.next(), actual);
    }
  }

  @Test
  public void withFieldPathSelect() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.select(new FieldPath[] {}).get().get();
    query.select(FieldPath.of("foo"), FieldPath.of("foo", "bar")).get().get();

    Iterator<RunQueryRequest> expectedQuery =
        Arrays.asList(
                query(select(FieldPath.documentId())), query(select("foo"), select("foo.bar")))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expectedQuery.next(), actual);
    }
  }

  @Test
  public void withStartAt() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").startAt("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), startAt(true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withStartAfter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").startAfter("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), startAt(false));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withEndBefore() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").endBefore("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), endAt(true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withEndAt() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").endAt("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), endAt(false));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test(expected = IllegalStateException.class)
  public void overspecifiedCursor() throws Exception {
    query.orderBy("foo").startAt("foo", "bar", "bar", "foo");
  }

  @Test(expected = IllegalStateException.class)
  public void orderByWithCursor() throws Exception {
    query.startAt("foo").orderBy("foo");
  }

  @Test
  public void getResult() throws Exception {
    doAnswer(
            queryResponse(
                LocalFirestoreHelper.DOCUMENT_NAME + "1", LocalFirestoreHelper.DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    QuerySnapshot result = query.get().get();

    assertEquals(query, result.getQuery());

    assertFalse(result.isEmpty());
    assertEquals(2, result.size());
    assertEquals(2, result.getDocuments().size());

    Iterator<DocumentSnapshot> iterator = result.iterator();
    assertEquals("doc1", iterator.next().getId());
    assertEquals("doc2", iterator.next().getId());
    assertFalse(iterator.hasNext());

    assertEquals(Instant.ofEpochSecond(1, 2), result.getReadTime());

    assertEquals(
        Arrays.asList(
            LocalFirestoreHelper.SINGLE_FIELD_OBJECT, LocalFirestoreHelper.SINGLE_FIELD_OBJECT),
        result.toObjects(LocalFirestoreHelper.SINGLE_FIELD_OBJECT.getClass()));
  }

  @Test
  public void streamResult() throws Exception {
    doAnswer(
            queryResponse(
                LocalFirestoreHelper.DOCUMENT_NAME + "1", LocalFirestoreHelper.DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("doc1", "doc2").iterator();

    query.stream(
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            assertEquals(iterator.next(), documentSnapshot.getId());
          }

          @Override
          public void onError(Throwable throwable) {
            fail();
          }

          @Override
          public void onCompleted() {
            semaphore.release();
          }
        });

    semaphore.acquire();
  }

  @Test
  public void equalsTest() throws Exception {
    assertEquals(query.limit(42).offset(1337), query.offset(1337).limit(42));
    assertEquals(query.limit(42).offset(1337).hashCode(), query.offset(1337).limit(42).hashCode());
  }
}
