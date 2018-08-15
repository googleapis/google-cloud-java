/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_SNAPSHOT;
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
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.StructuredQuery;
import com.google.firestore.v1beta1.StructuredQuery.Direction;
import com.google.firestore.v1beta1.StructuredQuery.FieldFilter.Operator;
import com.google.firestore.v1beta1.Value;
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

@RunWith(MockitoJUnitRunner.class)
public class QueryTest {

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder()
              .setProjectId("test-project")
              .setTimestampsInSnapshotsEnabled(true)
              .build(),
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
    query.whereArrayContains("foo", "bar").get().get();

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NULL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS)))
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
    query.whereArrayContains(FieldPath.of("foo"), "bar").get().get();

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS)))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expected.next(), actual);
    }
  }

  @Test
  public void withDocumentIdFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.whereEqualTo(FieldPath.documentId(), "doc").get().get();

    RunQueryRequest expectedRequest =
        query(
            filter(
                Operator.EQUAL,
                "__name__",
                Value.newBuilder().setReferenceValue(DOCUMENT_NAME).build()));

    assertEquals(expectedRequest, runQuery.getValue());
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
  public void withDocumentSnapshotCursor() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/doc").build();

    RunQueryRequest queryRequest =
        query(
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withDocumentIdAndDocumentSnapshotCursor() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy(FieldPath.documentId()).startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/doc").build();

    RunQueryRequest queryRequest =
        query(
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withExtractedDirectionForDocumentSnapshotCursor() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo", Query.Direction.DESCENDING).startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/doc").build();

    RunQueryRequest queryRequest =
        query(
            order("foo", Direction.DESCENDING),
            order("__name__", StructuredQuery.Direction.DESCENDING),
            startAt(true),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withInequalityFilterForDocumentSnapshotCursor() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query
        .whereEqualTo("a", "b")
        .whereGreaterThanOrEqualTo("foo", "bar")
        .whereEqualTo("c", "d")
        .startAt(SINGLE_FIELD_SNAPSHOT)
        .get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/doc").build();

    RunQueryRequest queryRequest =
        query(
            filter(Operator.EQUAL, "a", "b"),
            filter(Operator.GREATER_THAN_OR_EQUAL),
            filter(Operator.EQUAL, "c", "d"),
            order("foo", Direction.ASCENDING),
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(true),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withEqualityFilterForDocumentSnapshotCursor() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.whereEqualTo("foo", "bar").startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/doc").build();

    RunQueryRequest queryRequest =
        query(
            filter(Operator.EQUAL),
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withStartAt() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(
            runQuery.capture(),
            streamObserverCapture.capture(),
            Matchers.<ServerStreamingCallable>any());

    query.orderBy("foo").orderBy(FieldPath.documentId()).startAt("bar", "foo").get().get();

    Value documentBoundary =
        Value.newBuilder().setReferenceValue(query.getResourcePath().toString() + "/foo").build();

    RunQueryRequest queryRequest =
        query(
            order("foo", StructuredQuery.Direction.ASCENDING),
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(true),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withInvalidStartAt() throws Exception {
    try {
      query.orderBy(FieldPath.documentId()).startAt(42).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The corresponding value for FieldPath.documentId() must be a String or a "
              + "DocumentReference.",
          e.getMessage());
    }

    try {
      query.orderBy(FieldPath.documentId()).startAt("coll/doc/coll").get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Only a direct child can be used as a query boundary. Found: 'coll/coll/doc/coll'",
          e.getMessage());
    }

    try {
      query.orderBy(FieldPath.documentId()).startAt(firestoreMock.document("foo/bar")).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "'foo/bar' is not part of the query result set and cannot be used as a query boundary.",
          e.getMessage());
    }
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
    doAnswer(queryResponse(DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
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

    Iterator<QueryDocumentSnapshot> docIterator = result.iterator();
    assertEquals("doc1", docIterator.next().getId());
    assertEquals("doc2", docIterator.next().getId());
    assertFalse(docIterator.hasNext());

    Iterator<DocumentChange> changeIterator = result.getDocumentChanges().iterator();

    DocumentChange documentChange = changeIterator.next();
    assertEquals("doc1", documentChange.getDocument().getId());
    assertEquals(DocumentChange.Type.ADDED, documentChange.getType());
    assertEquals(-1, documentChange.getOldIndex());
    assertEquals(0, documentChange.getNewIndex());

    documentChange = changeIterator.next();
    assertEquals("doc2", documentChange.getDocument().getId());
    assertEquals(DocumentChange.Type.ADDED, documentChange.getType());
    assertEquals(-1, documentChange.getOldIndex());
    assertEquals(1, documentChange.getNewIndex());

    assertFalse(changeIterator.hasNext());

    assertEquals(Timestamp.ofTimeSecondsAndNanos(1, 2), result.getReadTime());

    assertEquals(
        Arrays.asList(
            LocalFirestoreHelper.SINGLE_FIELD_OBJECT, LocalFirestoreHelper.SINGLE_FIELD_OBJECT),
        result.toObjects(LocalFirestoreHelper.SINGLE_FIELD_OBJECT.getClass()));

    assertEquals(2, result.getDocumentChanges().size());
  }

  @Test
  public void streamResult() throws Exception {
    doAnswer(queryResponse(DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
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
