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

import static com.google.cloud.firestore.Filter.*;
import static com.google.cloud.firestore.LocalFirestoreHelper.COLLECTION_ID;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.DOCUMENT_PATH;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_SNAPSHOT;
import static com.google.cloud.firestore.LocalFirestoreHelper.andFilters;
import static com.google.cloud.firestore.LocalFirestoreHelper.endAt;
import static com.google.cloud.firestore.LocalFirestoreHelper.fieldFilter;
import static com.google.cloud.firestore.LocalFirestoreHelper.filter;
import static com.google.cloud.firestore.LocalFirestoreHelper.limit;
import static com.google.cloud.firestore.LocalFirestoreHelper.offset;
import static com.google.cloud.firestore.LocalFirestoreHelper.orFilters;
import static com.google.cloud.firestore.LocalFirestoreHelper.order;
import static com.google.cloud.firestore.LocalFirestoreHelper.query;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponse;
import static com.google.cloud.firestore.LocalFirestoreHelper.queryResponseWithDone;
import static com.google.cloud.firestore.LocalFirestoreHelper.reference;
import static com.google.cloud.firestore.LocalFirestoreHelper.select;
import static com.google.cloud.firestore.LocalFirestoreHelper.startAt;
import static com.google.cloud.firestore.LocalFirestoreHelper.string;
import static com.google.cloud.firestore.LocalFirestoreHelper.unaryFilter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.core.ApiClock;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Query.ComparisonFilterInternal;
import com.google.cloud.firestore.Query.FieldOrder;
import com.google.cloud.firestore.Query.FilterInternal;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.io.BaseEncoding;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.StructuredQuery.CollectionSelector;
import com.google.firestore.v1.StructuredQuery.Direction;
import com.google.firestore.v1.StructuredQuery.FieldFilter.Operator;
import com.google.firestore.v1.Value;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Status;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QueryTest {

  static class MockClock implements ApiClock {
    long nanoTime = 0;

    public void advance(long nanos) {
      nanoTime += nanos;
    }

    @Override
    public long nanoTime() {
      return nanoTime;
    }

    @Override
    public long millisTime() {
      return nanoTime / 1000000;
    }
  }

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  @Captor private ArgumentCaptor<RunQueryRequest> runQuery;

  @Captor private ArgumentCaptor<ResponseObserver<RunQueryResponse>> streamObserverCapture;

  private Query query;

  private MockClock clock;

  @Before
  public void before() {
    clock = new MockClock();
    doReturn(clock).when(firestoreMock).getClock();
    doReturn(Duration.ZERO).when(firestoreMock).getTotalRequestTimeoutDuration();

    query = firestoreMock.collection(COLLECTION_ID);
  }

  @Test
  public void withLimit() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.limit(42).get().get();

    assertEquals(query(limit(42)), runQuery.getValue());
  }

  @Test
  public void limitToLastReversesOrderingConstraints() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").limitToLast(42).get().get();

    assertEquals(
        query(limit(42), order("foo", StructuredQuery.Direction.DESCENDING)), runQuery.getValue());
  }

  @Test
  public void limitToLastReversesCursors() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").startAt("foo").endAt("bar").limitToLast(42).get().get();

    assertEquals(
        query(
            limit(42),
            order("foo", StructuredQuery.Direction.DESCENDING),
            endAt(string("foo"), false),
            startAt(string("bar"), true)),
        runQuery.getValue());
  }

  @Test
  public void limitToLastReversesResults() throws Exception {
    doAnswer(queryResponse(DOCUMENT_NAME + "2", DOCUMENT_NAME + "1"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    QuerySnapshot querySnapshot = query.orderBy("foo").limitToLast(2).get().get();

    Iterator<QueryDocumentSnapshot> docIterator = querySnapshot.iterator();
    assertEquals("doc1", docIterator.next().getId());
    assertEquals("doc2", docIterator.next().getId());
  }

  @Test
  public void limitToLastRequiresAtLeastOneOrderingConstraint() throws Exception {
    try {
      query.limitToLast(1).get().get();
      fail("Expected exception");
    } catch (IllegalStateException e) {
      assertEquals(
          e.getMessage(),
          "limitToLast() queries require specifying at least one orderBy() clause.");
    }
  }

  @Test
  public void limitToLastRejectsStream() {
    try {
      query.orderBy("foo").limitToLast(1).stream(null);
      fail("Expected exception");
    } catch (IllegalStateException e) {
      assertEquals(
          e.getMessage(),
          "Query results for queries that include limitToLast() constraints cannot be streamed. "
              + "Use Query.get() instead.");
    }
  }

  @Test
  public void withOffset() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.offset(42).get().get();

    assertEquals(query(offset(42)), runQuery.getValue());
  }

  @Test
  public void withFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.whereEqualTo("foo", "bar").get().get();
    query.whereEqualTo("foo", null).get().get();
    query.whereEqualTo("foo", Double.NaN).get().get();
    query.whereEqualTo("foo", Float.NaN).get().get();
    query.whereNotEqualTo("foo", "bar").get().get();
    query.whereNotEqualTo("foo", null).get().get();
    query.whereNotEqualTo("foo", Double.NaN).get().get();
    query.whereNotEqualTo("foo", Float.NaN).get().get();
    query.whereGreaterThan("foo", "bar").get().get();
    query.whereGreaterThanOrEqualTo("foo", "bar").get().get();
    query.whereLessThan("foo", "bar").get().get();
    query.whereLessThanOrEqualTo("foo", "bar").get().get();
    query.whereArrayContains("foo", "bar").get().get();
    query.whereIn("foo", Collections.<Object>singletonList("bar"));
    query.whereArrayContainsAny("foo", Collections.<Object>singletonList("bar"));
    query.whereNotIn("foo", Collections.<Object>singletonList("bar"));

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NULL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.NOT_EQUAL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NOT_NULL)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NOT_NAN)),
                query(unaryFilter(StructuredQuery.UnaryFilter.Operator.IS_NOT_NAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS)),
                query(filter(StructuredQuery.FieldFilter.Operator.IN)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY)),
                query(filter(StructuredQuery.FieldFilter.Operator.NOT_IN)))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expected.next(), actual);
    }
  }

  @Test
  public void withFieldPathFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.whereEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereNotEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereGreaterThan(FieldPath.of("foo"), "bar").get().get();
    query.whereGreaterThanOrEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereLessThan(FieldPath.of("foo"), "bar").get().get();
    query.whereLessThanOrEqualTo(FieldPath.of("foo"), "bar").get().get();
    query.whereArrayContains(FieldPath.of("foo"), "bar").get().get();
    query.whereIn(FieldPath.of("foo"), Collections.<Object>singletonList("bar"));
    query.whereNotIn(FieldPath.of("foo"), Collections.<Object>singletonList("bar"));
    query.whereArrayContainsAny(FieldPath.of("foo"), Collections.<Object>singletonList("bar"));

    Iterator<RunQueryRequest> expected =
        Arrays.asList(
                query(filter(StructuredQuery.FieldFilter.Operator.EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.NOT_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN)),
                query(filter(StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS)),
                query(filter(StructuredQuery.FieldFilter.Operator.IN)),
                query(filter(StructuredQuery.FieldFilter.Operator.NOT_IN)),
                query(filter(StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY)))
            .iterator();

    for (RunQueryRequest actual : runQuery.getAllValues()) {
      assertEquals(expected.next(), actual);
    }
  }

  @Test
  public void withCompositeFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    // a == 10 && (b==20 || c==30 || (d==40 && e>50) || f==60)
    query
        .where(
            and(
                equalTo("a", "10"),
                or(
                    equalTo("b", "20"),
                    equalTo("c", "30"),
                    and(equalTo("d", "40"), greaterThan("e", "50")),
                    and(equalTo("f", "60")),
                    or(and()))))
        .get()
        .get();

    StructuredQuery.Filter a = fieldFilter("a", Operator.EQUAL, "10");
    StructuredQuery.Filter b = fieldFilter("b", Operator.EQUAL, "20");
    StructuredQuery.Filter c = fieldFilter("c", Operator.EQUAL, "30");
    StructuredQuery.Filter d = fieldFilter("d", Operator.EQUAL, "40");
    StructuredQuery.Filter e = fieldFilter("e", Operator.GREATER_THAN, "50");
    StructuredQuery.Filter f = fieldFilter("f", Operator.EQUAL, "60");
    StructuredQuery.Builder structuredQuery = StructuredQuery.newBuilder();
    structuredQuery.setWhere(andFilters(a, orFilters(b, c, andFilters(d, e), f)));
    structuredQuery.addFrom(CollectionSelector.newBuilder().setCollectionId("coll").build());

    assertEquals(structuredQuery.build(), runQuery.getValue().getStructuredQuery());
  }

  @Test
  public void inQueriesWithReferenceArray() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query
        .whereIn(FieldPath.documentId(), Arrays.asList("doc", firestoreMock.document("coll/doc")))
        .get()
        .get();

    Value value =
        Value.newBuilder()
            .setArrayValue(
                ArrayValue.newBuilder()
                    .addValues(reference(DOCUMENT_NAME))
                    .addValues(reference(DOCUMENT_NAME))
                    .build())
            .build();
    RunQueryRequest expectedRequest = query(filter(Operator.IN, "__name__", value));

    assertEquals(expectedRequest, runQuery.getValue());
  }

  @Test
  public void inQueriesFieldsNotUsedInOrderBy() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    // Field "foo" used in `whereIn` should not appear in implicit orderBys in the resulting query.
    query
        .whereIn(FieldPath.of("foo"), Arrays.<Object>asList("value1", "value2"))
        .startAt(SINGLE_FIELD_SNAPSHOT)
        .get()
        .get();

    Value value =
        Value.newBuilder()
            .setArrayValue(
                ArrayValue.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("value1").build())
                    .addValues(Value.newBuilder().setStringValue("value2").build())
                    .build())
            .build();
    RunQueryRequest expectedRequest =
        query(
            filter(Operator.IN, "foo", value),
            order("__name__", Direction.ASCENDING),
            startAt(reference(DOCUMENT_NAME), true));

    assertEquals(expectedRequest, runQuery.getValue());
  }

  @Test
  public void validatesInQueries() {
    try {
      query.whereIn(FieldPath.documentId(), Arrays.<Object>asList("foo", 42)).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The corresponding value for FieldPath.documentId() must be a String or a "
              + "DocumentReference, but was: 42.",
          e.getMessage());
    }

    try {
      query.whereIn(FieldPath.documentId(), Arrays.asList()).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Invalid Query. A non-empty array is required for 'IN' filters.", e.getMessage());
    }
  }

  @Test
  public void notInQueriesWithReferenceArray() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query
        .whereNotIn(
            FieldPath.documentId(), Arrays.asList("doc", firestoreMock.document("coll/doc")))
        .get()
        .get();

    Value value =
        Value.newBuilder()
            .setArrayValue(
                ArrayValue.newBuilder()
                    .addValues(reference(DOCUMENT_NAME))
                    .addValues(reference(DOCUMENT_NAME))
                    .build())
            .build();
    RunQueryRequest expectedRequest = query(filter(Operator.NOT_IN, "__name__", value));

    assertEquals(expectedRequest, runQuery.getValue());
  }

  @Test
  public void validatesNotInQueries() {
    try {
      query.whereNotIn(FieldPath.documentId(), Arrays.<Object>asList("foo", 42)).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The corresponding value for FieldPath.documentId() must be a String or a "
              + "DocumentReference, but was: 42.",
          e.getMessage());
    }

    try {
      query.whereNotIn(FieldPath.documentId(), Arrays.asList()).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Invalid Query. A non-empty array is required for 'NOT_IN' filters.", e.getMessage());
    }
  }

  @Test
  public void validatesQueryOperatorForFieldPathDocumentId() {
    try {
      query.whereArrayContains(FieldPath.documentId(), "bar");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Invalid query. You cannot perform 'ARRAY_CONTAINS' queries on FieldPath.documentId().",
          e.getMessage());
    }

    try {
      query.whereArrayContainsAny(FieldPath.documentId(), Collections.<Object>singletonList("bar"));
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Invalid query. You cannot perform 'ARRAY_CONTAINS_ANY' queries on"
              + " FieldPath.documentId().",
          e.getMessage());
    }
  }

  @Test
  public void withDocumentIdFilter() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.whereEqualTo(FieldPath.documentId(), "doc").get().get();

    RunQueryRequest expectedRequest =
        query(filter(Operator.EQUAL, "__name__", reference(DOCUMENT_NAME)));

    assertEquals(expectedRequest, runQuery.getValue());
  }

  @Test
  public void withOrderBy() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
  public void withDocumentSnapshotCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary = reference(DOCUMENT_NAME);

    RunQueryRequest queryRequest =
        query(
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withDocumentIdAndDocumentSnapshotCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy(FieldPath.documentId()).startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary = reference(DOCUMENT_NAME);

    RunQueryRequest queryRequest =
        query(
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withDocumentReferenceCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    DocumentReference documentCursor = firestoreMock.document(DOCUMENT_PATH);
    Value documentValue = reference(DOCUMENT_NAME);

    query.startAt(documentCursor).get();

    RunQueryRequest queryRequest =
        query(order("__name__", StructuredQuery.Direction.ASCENDING), startAt(documentValue, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withDocumentIdAndDocumentReferenceCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    DocumentReference documentCursor = firestoreMock.document(DOCUMENT_PATH);
    Value documentValue = reference(DOCUMENT_NAME);

    query.orderBy(FieldPath.documentId()).startAt(documentCursor).get();

    RunQueryRequest queryRequest =
        query(order("__name__", StructuredQuery.Direction.ASCENDING), startAt(documentValue, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withExtractedDirectionForDocumentSnapshotCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo", Query.Direction.DESCENDING).startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary = reference(DOCUMENT_NAME);

    RunQueryRequest queryRequest =
        query(
            order("foo", Direction.DESCENDING),
            order("__name__", StructuredQuery.Direction.DESCENDING),
            startAt(true),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withInequalityFilterForDocumentSnapshotCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query
        .whereEqualTo("a", "b")
        .whereGreaterThanOrEqualTo("foo", "bar")
        .whereEqualTo("c", "d")
        .startAt(SINGLE_FIELD_SNAPSHOT)
        .get();

    Value documentBoundary = reference(DOCUMENT_NAME);

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
  public void withEqualityFilterForDocumentSnapshotCursor() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.whereEqualTo("foo", "bar").startAt(SINGLE_FIELD_SNAPSHOT).get();

    Value documentBoundary = reference(DOCUMENT_NAME);

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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").orderBy(FieldPath.documentId()).startAt("bar", "doc").get().get();

    Value documentBoundary = reference(DOCUMENT_NAME);

    RunQueryRequest queryRequest =
        query(
            order("foo", StructuredQuery.Direction.ASCENDING),
            order("__name__", StructuredQuery.Direction.ASCENDING),
            startAt(true),
            startAt(documentBoundary, true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withInvalidStartAt() {
    try {
      query.orderBy(FieldPath.documentId()).startAt(42).get();
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The corresponding value for FieldPath.documentId() must be a String or a "
              + "DocumentReference, but was: 42.",
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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").startAfter("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), startAt(false));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withEndBefore() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").endBefore("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), endAt(true));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withEndAt() throws Exception {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.orderBy("foo").endAt("bar").get().get();

    RunQueryRequest queryRequest =
        query(order("foo", StructuredQuery.Direction.ASCENDING), endAt(false));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void withCollectionGroup() {
    doAnswer(queryResponse())
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    Query query = firestoreMock.collectionGroup(COLLECTION_ID);
    query = query.whereGreaterThan(FieldPath.documentId(), "coll/doc");
    query = query.orderBy(FieldPath.documentId());
    query = query.endAt("coll/doc");
    query.get();

    RunQueryRequest queryRequest =
        query(
            /* transactionId= */ null,
            /* allDescendants= */ true,
            filter(Operator.GREATER_THAN, "__name__", reference(DOCUMENT_NAME)),
            order("__name__", StructuredQuery.Direction.ASCENDING),
            endAt(reference(DOCUMENT_NAME), false));

    assertEquals(queryRequest, runQuery.getValue());
  }

  @Test
  public void collectionGroupCannotContainSlashes() {
    try {
      Query query = firestoreMock.collectionGroup("foo/bar");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Invalid collectionId 'foo/bar'. Collection IDs must not contain '/'.", e.getMessage());
    }
  }

  @Test(expected = IllegalStateException.class)
  public void overspecifiedCursor() {
    query.orderBy("foo").startAt("foo", "bar", "bar", "foo");
  }

  @Test(expected = IllegalStateException.class)
  public void orderByWithCursor() {
    query.startAt("foo").orderBy("foo");
  }

  @Test
  public void getResult() throws Exception {
    doAnswer(queryResponse(DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
  public void successfulReturnWithoutOnComplete() throws Exception {
    doAnswer(
            queryResponseWithDone(
                /* callWithoutOnComplete */ true, DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

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
  /**
   * onComplete() will be called twice. The first time is when it detects RunQueryResponse.done set
   * to true. The second time is when it receives half close
   */
  public void successfulReturnCallsOnCompleteTwice() throws Exception {
    doAnswer(
            queryResponseWithDone(
                /* callWithoutOnComplete */ false, DOCUMENT_NAME + "1", DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("doc1", "doc2").iterator();
    final int[] counter = {0};

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
            counter[0]++;
            semaphore.release();
          }
        });

    semaphore.acquire();

    // Wait for some time to see whether onCompleted() has been called more than once
    Thread.sleep(200);
    assertEquals(1, counter[0]);
  }

  @Test
  public void retriesAfterRetryableError() throws Exception {
    final boolean[] returnError = new boolean[] {true};

    doAnswer(
            invocation -> {
              if (returnError[0]) {
                returnError[0] = false;
                return queryResponse(
                        FirestoreException.forServerRejection(
                            Status.DEADLINE_EXCEEDED, "Simulated test failure"),
                        DOCUMENT_NAME + "1",
                        DOCUMENT_NAME + "2")
                    .answer(invocation);
              } else {
                return queryResponse(DOCUMENT_NAME + "3").answer(invocation);
              }
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    // Verify the responses
    final Semaphore semaphore = new Semaphore(0);
    final Iterator<String> iterator = Arrays.asList("doc1", "doc2", "doc3").iterator();

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

    // Verify the requests
    List<RunQueryRequest> requests = runQuery.getAllValues();
    assertEquals(2, requests.size());

    assertFalse(requests.get(0).hasReadTime());
    assertFalse(requests.get(0).getStructuredQuery().hasStartAt());

    assertEquals(
        com.google.protobuf.Timestamp.newBuilder().setSeconds(1).setNanos(2).build(),
        requests.get(1).getReadTime());
    assertFalse(requests.get(1).getStructuredQuery().getStartAt().getBefore());
    assertEquals(
        DOCUMENT_NAME + "2",
        requests.get(1).getStructuredQuery().getStartAt().getValues(0).getReferenceValue());
  }

  @Test
  public void doesNotRetryAfterNonRetryableError() throws Exception {
    doAnswer(
            queryResponse(
                FirestoreException.forServerRejection(
                    Status.PERMISSION_DENIED, "Simulated test failure"),
                DOCUMENT_NAME + "1",
                DOCUMENT_NAME + "2"))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    // Verify the responses
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
            semaphore.release();
          }

          @Override
          public void onCompleted() {}
        });

    semaphore.acquire();

    // Verify the request count
    assertEquals(1, runQuery.getAllValues().size());
  }

  @Test
  public void onlyRetriesWhenResultSent() throws Exception {
    doAnswer(
            queryResponse(
                FirestoreException.forServerRejection(
                    Status.DEADLINE_EXCEEDED, "Simulated test failure")))
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    assertThrows(ExecutionException.class, () -> query.get().get());

    // Verify the request count
    assertEquals(1, runQuery.getAllValues().size());
  }

  @Test
  public void retriesWithoutTimeout() throws Exception {
    final boolean[] returnError = new boolean[] {true};

    doAnswer(
            invocation -> {
              // Advance clock by an hour
              clock.advance(Duration.ofHours(1).toNanos());

              if (returnError[0]) {
                returnError[0] = false;
                return queryResponse(
                        FirestoreException.forServerRejection(
                            Status.DEADLINE_EXCEEDED, "Simulated test failure"),
                        DOCUMENT_NAME + "1")
                    .answer(invocation);
              } else {
                return queryResponse(DOCUMENT_NAME + "2").answer(invocation);
              }
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    query.get().get();

    // Verify the request count
    assertEquals(2, runQuery.getAllValues().size());
  }

  @Test
  public void doesNotRetryWithTimeout() {
    doReturn(Duration.ofMinutes(1)).when(firestoreMock).getTotalRequestTimeoutDuration();

    doAnswer(
            invocation -> {
              // Advance clock by an hour
              clock.advance(Duration.ofHours(1).toNanos());

              return queryResponse(
                      FirestoreException.forServerRejection(
                          Status.DEADLINE_EXCEEDED, "Simulated test failure"),
                      DOCUMENT_NAME + "1",
                      DOCUMENT_NAME + "2")
                  .answer(invocation);
            })
        .when(firestoreMock)
        .streamRequest(runQuery.capture(), streamObserverCapture.capture(), any());

    assertThrows(ExecutionException.class, () -> query.get().get());

    // Verify the request count
    assertEquals(1, runQuery.getAllValues().size());
  }

  @Test
  public void equalsTest() {
    assertEquals(query.limit(42).offset(1337), query.offset(1337).limit(42));
    assertEquals(query.limit(42).offset(1337).hashCode(), query.offset(1337).limit(42).hashCode());
  }

  @Test
  public void serializationTest() {
    assertSerialization(query);
    query = query.whereEqualTo("a", null);
    assertSerialization(query);
    query = query.whereEqualTo("b", Double.NaN);
    assertSerialization(query);
    query = query.whereGreaterThan("c", 1);
    assertSerialization(query);
    query = query.whereGreaterThanOrEqualTo(FieldPath.of("d", ".e."), 2);
    assertSerialization(query);
    query = query.whereLessThan("f", 3);
    assertSerialization(query);
    query = query.whereLessThanOrEqualTo(FieldPath.of("g", ".h."), 4);
    assertSerialization(query);
    query = query.whereIn("i", Collections.singletonList(5));
    assertSerialization(query);
    query = query.whereArrayContains("j", Collections.singletonList(6));
    assertSerialization(query);
    query = query.whereArrayContainsAny("k", Collections.singletonList(7));
    assertSerialization(query);
    query = query.orderBy("l");
    assertSerialization(query);
    query = query.orderBy(FieldPath.of("m", ".n."), Query.Direction.DESCENDING);
    assertSerialization(query);
    query = query.startAt("o");
    assertSerialization(query);
    query = query.startAfter("p");
    assertSerialization(query);
    query = query.endBefore("q");
    assertSerialization(query);
    query = query.endAt("r");
    assertSerialization(query);
    query = query.limit(8);
    assertSerialization(query);
    query = query.offset(9);
    assertSerialization(query);
  }

  @Test
  public void serializationTestWithEmptyCompositeFilter() {
    assertSerialization(query);
    query.where(or());
    assertSerialization(query);
    query.where(and());
    assertSerialization(query);
    query.where(and(or(and(or()))));
    assertSerialization(query);
  }

  @Test
  public void serializationTestWithSingleFilterCompositeFilters() {
    // Test the special handling of a composite filter that has only 1 filter inside it. Such filter
    // is equivalent to its sub-filter. For example: AND(a==10) is the same as a==10.
    assertSerialization(query);
    // a == 10
    query.where(or(equalTo("a", 10)));
    assertSerialization(query);

    // b > 20
    query.where(and(greaterThan("b", 20)));
    assertSerialization(query);

    // c == 30
    query.where(or(and(or(and(equalTo("c", 30))))));
    assertSerialization(query);
  }

  @Test
  public void serializationTestWithNestedCompositeFiltersOuterAnd() {
    assertSerialization(query);
    // a IN [1,2]
    query.where(inArray("a", Arrays.asList(1, 2)));
    assertSerialization(query);
    // a IN [1,2] && (b==20 || c==30 || (d==40 && e>50) || f==60)
    query.where(
        or(
            equalTo("b", 20),
            equalTo("c", 30),
            and(equalTo("d", 40), greaterThan("e", 50)),
            and(equalTo("f", 60)),
            or(and())));
    assertSerialization(query);
    query = query.orderBy("l");
    assertSerialization(query);
    query = query.startAt("o");
    assertSerialization(query);
    query = query.startAfter("p");
    assertSerialization(query);
    query = query.endBefore("q");
    assertSerialization(query);
    query = query.endAt("r");
    assertSerialization(query);
    query = query.limit(8);
    assertSerialization(query);
    query = query.offset(9);
    assertSerialization(query);
  }

  @Test
  public void serializationTestWithNestedCompositeFiltersOuterOr() {
    assertSerialization(query);
    // a IN [1,2] || (b==20 && c==30 && (d==40 || e>50) && f==60)
    query.where(
        or(
            inArray("a", Arrays.asList(1, 2)),
            and(
                equalTo("b", 20),
                equalTo("c", 30),
                or(equalTo("d", 40), greaterThan("e", 50)),
                and(equalTo("f", 60)),
                or(and()))));
    assertSerialization(query);
    query = query.orderBy("l");
    assertSerialization(query);
    query = query.startAt("o");
    assertSerialization(query);
    query = query.startAfter("p");
    assertSerialization(query);
    query = query.endBefore("q");
    assertSerialization(query);
    query = query.endAt("r");
    assertSerialization(query);
    query = query.limit(8);
    assertSerialization(query);
    query = query.offset(9);
    assertSerialization(query);
  }

  private void assertSerialization(Query query) {
    RunQueryRequest runQueryRequest = query.toProto();
    Query deserializedQuery = Query.fromProto(firestoreMock, runQueryRequest);
    assertEquals(runQueryRequest, deserializedQuery.toProto());
    assertEquals(deserializedQuery, query);
  }

  @Test
  public void serializationVerifiesDatabaseName() {
    RunQueryRequest runQueryRequest = query.toProto();
    runQueryRequest =
        runQueryRequest.toBuilder().setParent("projects/foo/databases/(default)/documents").build();

    try {
      Query.fromProto(firestoreMock, runQueryRequest);
      fail("Expected serializtion error");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "Cannot deserialize query from different Firestore project "
              + "(\"projects/test-project/databases/(default)\" vs "
              + "\"projects/foo/databases/(default)\")",
          e.getMessage());
    }
  }

  @Test
  public void ensureFromProtoWorksWithAProxy() throws InvalidProtocolBufferException {
    Object o =
        Proxy.newProxyInstance(
            QueryTest.class.getClassLoader(),
            new Class[] {Firestore.class, FirestoreRpcContext.class},
            (proxy, method, args) -> {
              // use the reflection lookup of the method name so intellij will refactor it along
              // with the method name if it ever happens.
              Method getDatabaseNameMethod =
                  FirestoreRpcContext.class.getDeclaredMethod("getDatabaseName");
              if (method.equals(getDatabaseNameMethod)) {
                return "projects/test-project/databases/(default)";
              } else {
                return null;
              }
            });

    assertTrue(o instanceof Firestore);
    assertTrue(o instanceof FirestoreRpcContext);

    // Code used to generate the below base64 encoded RunQueryRequest
    // RunQueryRequest proto = firestoreMock.collection("testing-collection")
    //     .whereEqualTo("enabled", true).toProto();
    // String base64String = BaseEncoding.base64().encode(proto.toByteArray());
    String base64Proto =
        "CjNwcm9qZWN0cy90ZXN0LXByb2plY3QvZGF0YWJhc2VzLyhkZWZhdWx0KS9kb2N1bWVudHMSKxIUEhJ0ZXN0aW5nLWNvbGxlY3Rpb24aExIRCgkSB2VuYWJsZWQQBRoCCAE=";

    byte[] bytes = BaseEncoding.base64().decode(base64Proto);
    RunQueryRequest runQueryRequest = RunQueryRequest.parseFrom(bytes);

    Query query = Query.fromProto((Firestore) o, runQueryRequest);
    ResourcePath path = query.options.getParentPath();
    assertEquals("projects/test-project/databases/(default)/documents", path.getName());
    assertEquals("testing-collection", query.options.getCollectionId());
    FilterInternal next = query.options.getFilters().iterator().next();
    assertTrue(next instanceof ComparisonFilterInternal);
    ComparisonFilterInternal comparisonFilter = (ComparisonFilterInternal) next;
    assertEquals("enabled", comparisonFilter.fieldReference.getFieldPath());
    assertFalse(comparisonFilter.isInequalityFilter());
    assertEquals(Value.newBuilder().setBooleanValue(true).build(), comparisonFilter.value);
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyOnCharacters() {
    Query query_ =
        query
            .whereLessThan("a", "value")
            .whereGreaterThanOrEqualTo("a", "value")
            .whereGreaterThan("aa", "value")
            .whereGreaterThan("b", "value")
            .whereGreaterThan("A", "value");

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("A", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("aa", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("b", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyOnCharactersAndNumbers() {
    Query query_ =
        query
            .whereLessThan("a", "value")
            .whereGreaterThan("1", "value")
            .whereGreaterThan("19", "value")
            .whereGreaterThan("2", "value");

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("1", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("19", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("2", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyOnNestedFields() {
    Query query_ =
        query
            .whereLessThan("a", "value")
            .whereGreaterThan("aa", "value")
            .whereGreaterThan("a.a", "value");

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a.a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("aa", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyOnSpecialCharacters() {
    Query query_ =
        query
            .whereLessThan("a", "value")
            .whereGreaterThan("_a", "value")
            .whereGreaterThan("a.a", "value");

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("_a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a.a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyOnFieldNameWithDot() {
    Query query_ =
        query
            .whereLessThan("a", "value")
            .whereGreaterThan(FieldPath.of("a.a"), "value")
            .whereGreaterThan("a.z", "value");

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a.z", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("`a.a`", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyInCompositeFilter() {
    Query query_ =
        query.where(
            and(
                lessThan("a", "value"),
                and(
                    or(greaterThanOrEqualTo("b", "value"), lessThanOrEqualTo("c", "value")),
                    or(greaterThan("d", "value"), equalTo("e", "value")))));

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("b", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("c", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("d", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void inequalityFiltersImplicitlyOrderedLexicographicallyWithExplicitOrderBys() {
    Query query_ =
        query
            .whereLessThan("b", "value")
            .whereGreaterThan("a", "value")
            .whereGreaterThan("z", "value")
            .orderBy("z", Query.Direction.ASCENDING);

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("z", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("b", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void
      inequalityFiltersImplicitlyOrderedLexicographicallyFollowingExplicitOrderByDirection() {
    Query query_ =
        query
            .whereLessThan("b", "value")
            .whereGreaterThan("a", "value")
            .orderBy("z", Query.Direction.DESCENDING);

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("z", Query.Direction.DESCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.DESCENDING));
    orderFields.add(new FieldOrder("b", Query.Direction.DESCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.DESCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }

  @Test
  public void
      inequalityFiltersImplicitlyOrderedLexicographicallyFollowingLastExplicitOrderByDirection() {
    Query query_ =
        query
            .whereLessThan("b", "value")
            .whereGreaterThan("a", "value")
            .orderBy("z", Query.Direction.DESCENDING)
            .orderBy("c", Query.Direction.ASCENDING);

    List<FieldOrder> orderFields = new ArrayList<>();
    orderFields.add(new FieldOrder("z", Query.Direction.DESCENDING));
    orderFields.add(new FieldOrder("c", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("a", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder("b", Query.Direction.ASCENDING));
    orderFields.add(new FieldOrder(FieldPath.documentId().toProto(), Query.Direction.ASCENDING));

    assertEquals(orderFields, query_.createImplicitOrderBy());
  }
}
