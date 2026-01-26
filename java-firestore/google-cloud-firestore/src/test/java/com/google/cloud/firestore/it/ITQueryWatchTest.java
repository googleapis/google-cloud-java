/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.LocalFirestoreHelper;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.it.ITQueryWatchTest.QuerySnapshotEventListener.ListenerAssertions;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.ListenResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ITQueryWatchTest extends ITBaseTest {
  @Rule public TestName testName = new TestName();

  private CollectionReference randomColl;

  @Before
  public void before() throws Exception {
    super.before();
    useFirestoreSpy();
    String autoId = LocalFirestoreHelper.autoId();
    String collPath = String.format("java-%s-%s", testName.getMethodName(), autoId);
    randomColl = firestore.collection(collPath);
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with empty results.
   *   <li>Verify the listener receives an empty event.
   * </ol>
   */
  @Test
  public void emptyResults() throws InterruptedException {
    final Query query = randomColl.whereEqualTo("foo", "bar");
    // register the snapshot listener for the query
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(1, 1));
    listenerAssertions.addedIdsIsEmpty();
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsEmpty();
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with non-empty results.
   *   <li>Verify the listener receives an event including the expected document.
   * </ol>
   */
  @Test
  public void nonEmptyResults() throws Exception {
    // create a document in our collection that will match the query
    setDocument("doc", map("foo", "bar"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(1, 1));
    listenerAssertions.addedIdsIsAnyOf("doc");
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsEmpty();
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with empty results.
   *   <li>Create a new document that matches the query.
   *   <li>Verify newly created document results in an ADDED event.
   * </ol>
   */
  @Test
  public void emptyResults_newDocument_ADDED()
      throws InterruptedException, TimeoutException, ExecutionException {

    final Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).setAddedEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      randomColl.document("doc").set(map("foo", "bar")).get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.ADDED);
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(2, 2));
    listenerAssertions.addedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsEmpty();
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with empty results.
   *   <li>Modify an existing document so that it matches the query.
   *   <li>Verify newly created document results in an ADDED event.
   * </ol>
   */
  @Test
  public void emptyResults_modifiedDocument_ADDED() throws Exception {
    // create our "existing non-matching document"
    DocumentReference testDoc = setDocument("doc", map("baz", "baz"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).setAddedEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      testDoc.update("foo", "bar").get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.ADDED);
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(2, 2));
    listenerAssertions.addedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsEmpty();

    ListenerEvent event = listener.lastListenerEvent();
    //noinspection ConstantConditions guarded by "assertNoError" above
    QueryDocumentSnapshot doc = event.value.getDocumentChanges().get(0).getDocument();
    assertThat(doc.get("foo")).isEqualTo("bar");
    assertThat(doc.get("baz")).isEqualTo("baz");
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with non-empty results.
   *   <li>Modify an existing document that is part of the results.
   *   <li>Verify modified document results in a MODIFIED event.
   * </ol>
   */
  @Test
  public void nonEmptyResults_modifiedDocument_MODIFIED() throws Exception {
    DocumentReference testDoc = setDocument("doc", map("foo", "bar"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    // register the snapshot listener for the query
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder()
            .setInitialEventCount(1)
            .setModifiedEventCount(1)
            .build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      testDoc.update("baz", "baz").get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.MODIFIED);
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(2, 2));
    listenerAssertions.addedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.modifiedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.removedIdsIsEmpty();

    ListenerEvent event = listener.lastListenerEvent();
    //noinspection ConstantConditions guarded by "assertNoError" above
    QueryDocumentSnapshot doc = event.value.getDocumentChanges().get(0).getDocument();
    assertThat(doc.get("foo")).isEqualTo("bar");
    assertThat(doc.get("baz")).isEqualTo("baz");
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with non-empty results.
   *   <li>Delete an existing document that is part of the results.
   *   <li>Verify deleted document results in a REMOVED event.
   * </ol>
   */
  @Test
  public void nonEmptyResults_deletedDocument_REMOVED() throws Exception {
    DocumentReference testDoc = setDocument("doc", map("foo", "bar"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    // register the snapshot listener for the query
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder()
            .setInitialEventCount(1)
            .setRemovedEventCount(1)
            .build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      testDoc.delete().get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.REMOVED);
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(2, 2));
    listenerAssertions.addedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsAnyOf(emptyList(), singletonList("doc"));

    ListenerEvent event = listener.lastListenerEvent();
    //noinspection ConstantConditions guarded by "assertNoError" above
    QueryDocumentSnapshot doc = event.value.getDocumentChanges().get(0).getDocument();
    assertThat(doc.get("foo")).isEqualTo("bar");
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with non-empty results.
   *   <li>Modify an existing document that is part of the results to no longer match the query.
   *   <li>Verify modified document results in a REMOVED event.
   * </ol>
   */
  @Test
  public void nonEmptyResults_modifiedDocument_REMOVED() throws Exception {
    DocumentReference testDoc = setDocument("doc", map("foo", "bar"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    // register the snapshot listener for the query
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder()
            .setInitialEventCount(1)
            .setRemovedEventCount(1)
            .build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      testDoc.set(map("bar", "foo")).get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.REMOVED);
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.closed(2, 2));
    listenerAssertions.addedIdsIsAnyOf(emptyList(), singletonList("doc"));
    listenerAssertions.modifiedIdsIsEmpty();
    listenerAssertions.removedIdsIsAnyOf(emptyList(), singletonList("doc"));

    ListenerEvent event = listener.lastListenerEvent();
    //noinspection ConstantConditions guarded by "assertNoError" above
    QueryDocumentSnapshot doc = event.value.getDocumentChanges().get(0).getDocument();
    assertThat(doc.get("foo")).isEqualTo("bar");
  }

  /**
   *
   *
   * <ol>
   *   <li>Attach a listener to a query with non-empty results.
   *   <li>Trigger existence filter mismatch, thereby invoking retry behavior.
   *   <li>Add and remove documents.
   *   <li>Verify expected snapshots are raised.
   * </ol>
   */
  @Test
  public void restartAfterFailedFilter() throws Exception {
    // create a document in our collection that will match the query
    DocumentReference testDoc1 = setDocument("doc1", map("foo", "bar"));
    DocumentReference testDoc2 = setDocument("doc2", map("foo", "bar"));

    final Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder()
            .setInitialEventCount(1)
            .setAddedEventCount(3)
            .setRemovedEventCount(1)
            .build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
      listener
          .assertionsForLastEvent()
          .noError()
          .addedIdsIsAnyOf("doc1", "doc2")
          .modifiedIdsIsEmpty()
          .removedIdsIsEmpty();
      listener.lastDocumentIdsIsAnyOf("doc1", "doc2");

      // Trigger existence filter mismatch, thereby invoking retry behavior.
      // Prompting Firestore to send filter mismatch is difficult, so we hack
      // in the response. All we are concerned about is invoking retry.
      firestoreSpy.streamRequestBidiStreamObserver.onResponse(filter(0));

      // A race condition will sometimes throw an error if the SuppressibleBidiStream does not
      // silence the old stream. This can be caused by `Preconditions.checkState(stream == null)`
      // in Watch class.

      setDocument("doc3", map("foo", "bar"));
      listener.eventsCountDownLatch.await(DocumentChange.Type.ADDED);
      listener
          .assertionsForLastEvent()
          .noError()
          .addedIdsIsAnyOf("doc3")
          .modifiedIdsIsEmpty()
          .removedIdsIsEmpty();
      listener.lastDocumentIdsIsAnyOf("doc1", "doc2", "doc3");

      testDoc1.set(map("bar", "foo")).get(5, TimeUnit.SECONDS);
      listener.eventsCountDownLatch.await(DocumentChange.Type.REMOVED);
      listener
          .assertionsForLastEvent()
          .noError()
          .addedIdsIsEmpty()
          .modifiedIdsIsEmpty()
          .removedIdsIsAnyOf("doc1");
      listener.lastDocumentIdsIsAnyOf("doc2", "doc3");

    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.eventCountIsAnyOf(Range.singleton(3));
  }

  /** Verifies that QuerySnapshot for limitToLast() queries are ordered correctly. */
  @Test
  public void limitToLast() throws Exception {
    setDocument("doc1", Collections.singletonMap("counter", 1));
    setDocument("doc2", Collections.singletonMap("counter", 2));
    setDocument("doc3", Collections.singletonMap("counter", 3));

    final Query query = randomColl.orderBy("counter").limitToLast(2);
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    listenerAssertions.addedIdsIsAnyOf(emptyList(), asList("doc2", "doc3"));
  }

  /** Verifies that the SDK orders vector fields the same way as the backend. */
  @Test
  public void vectorFieldOrder() throws Exception {
    // We validate that the SDK orders the vector field the same way as the backend
    // by comparing the sort order of vector fields from a Query.get() and
    // Query.addSnapshotListener(). Query.addSnapshotListener() will return sort order
    // of the SDK, and Query.get() will return sort order of the backend.

    // Test data in the order that we expect the backend to sort it.
    List<Map<String, Object>> docsInOrder =
        Arrays.asList(
            map("embedding", Arrays.asList(1, 2, 3, 4, 5, 6)),
            map("embedding", Arrays.asList(100)),
            map("embedding", FieldValue.vector(new double[] {Double.NEGATIVE_INFINITY})),
            map("embedding", FieldValue.vector(new double[] {-100})),
            map("embedding", FieldValue.vector(new double[] {100})),
            map("embedding", FieldValue.vector(new double[] {Double.POSITIVE_INFINITY})),
            map("embedding", FieldValue.vector(new double[] {1, 2})),
            map("embedding", FieldValue.vector(new double[] {2, 2})),
            map("embedding", FieldValue.vector(new double[] {1, 2, 3})),
            map("embedding", FieldValue.vector(new double[] {1, 2, 3, 4})),
            map("embedding", FieldValue.vector(new double[] {1, 2, 3, 4, 5})),
            map("embedding", FieldValue.vector(new double[] {1, 2, 100, 4, 4})),
            map("embedding", FieldValue.vector(new double[] {100, 2, 3, 4, 5})),
            map("embedding", map()),
            map("embedding", map("HELLO", "WORLD")),
            map("embedding", map("hello", "world")));

    // Add docs and store doc IDs
    List<String> docIds = new ArrayList<String>();
    for (int i = 0; i < docsInOrder.size(); i++) {
      DocumentReference docRef = randomColl.add(docsInOrder.get(i)).get();
      docIds.add(docRef.getId());
    }

    // Test query
    Query orderedQuery = randomColl.orderBy("embedding");

    // Run query with snapshot listener
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).build();
    ListenerRegistration registration = orderedQuery.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
    } finally {
      registration.remove();
    }

    // Get doc IDs from snapshot listener
    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();
    List<String> listenerIds = listenerAssertions.addedIds;

    // Run query with get() and get doc IDs
    QuerySnapshot querySnapshot = orderedQuery.get().get();
    List<String> getIds =
        querySnapshot.getDocuments().stream().map(ds -> ds.getId()).collect(Collectors.toList());

    // Assert that get and snapshot listener requests sort docs in the same, expected order
    assertArrayEquals(docIds.toArray(new String[0]), getIds.toArray(new String[0]));
    assertArrayEquals(docIds.toArray(new String[0]), listenerIds.toArray(new String[0]));
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with startAt when the full limit is
   * used in the result set.
   */
  @Test
  public void limitToLastWithStartAtFullLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAt(5).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc7", "doc8", "doc9");
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with startAt when the partial limit
   * is used in the result set.
   */
  @Test
  public void limitToLastWithStartAtPartialLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAt(8).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc8", "doc9");
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with startAfter when the full limit
   * is used in the result set.
   */
  @Test
  public void limitToLastWithStartAfterFullLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAfter(5).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc7", "doc8", "doc9");
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with startAfter when the partial
   * limit is used in the result set.
   */
  @Test
  public void limitToLastWithStartAfterPartialLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAfter(7).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc8", "doc9");
  }

  /** Verifies that QuerySnapshot for limitToLast() queries work with endAt. */
  @Test
  public void limitToLastWithEndAt() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").endAt(5).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc3", "doc4", "doc5");
  }

  /** Verifies that QuerySnapshot for limitToLast() queries work with endBefore. */
  @Test
  public void limitToLastWithEndBefore() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").endBefore(5).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc2", "doc3", "doc4");
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with both startAt and endAt when the
   * full limit is used in the result set.
   */
  @Test
  public void limitToLastWithStartAtAndEndAtFullLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAt(3).endAt(6).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc4", "doc5", "doc6");
  }

  /**
   * Verifies that QuerySnapshot for limitToLast() queries work with both startAt and endAt when the
   * partial limit is used in the result set.
   */
  @Test
  public void limitToLastWithStartAtAndEndAtPartialLimit() throws Exception {
    for (int i = 0; i < 10; i++) {
      setDocument("doc" + i, Collections.singletonMap("counter", i));
    }
    Query query = randomColl.orderBy("counter").startAt(5).endAt(6).limitToLast(3);
    assertQueryResultContainsDocsInOrder(query, "doc5", "doc6");
  }

  private static void assertQueryResultContainsDocsInOrder(Query query, String... docIds)
      throws ExecutionException, InterruptedException {
    QuerySnapshot snapshot = query.get().get();
    ImmutableList<String> actualDocIds =
        snapshot.getDocuments().stream().map(DocumentSnapshot::getId).collect(toImmutableList());
    assertThat(actualDocIds).containsExactlyElementsIn(docIds).inOrder();
  }

  @Test
  public void shutdownNowTerminatesActiveListener() throws Exception {
    Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setExpectError().build();

    query.addSnapshotListener(listener);
    firestore.shutdownNow();

    listener.eventsCountDownLatch.awaitError();

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.hasError();
  }

  @Test
  public void shutdownNowPreventsAddingNewListener() throws Exception {
    Query query = randomColl.whereEqualTo("foo", "bar");
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setExpectError().build();

    firestore.shutdownNow();
    query.addSnapshotListener(listener);

    listener.eventsCountDownLatch.awaitError();

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.hasError();
  }

  @Test
  public void snapshotListenerSortsQueryByDocumentIdInTheSameOrderAsServer() throws Exception {
    CollectionReference col = randomColl;

    firestore
        .batch()
        .set(col.document("A"), Collections.singletonMap("a", 1))
        .set(col.document("a"), Collections.singletonMap("a", 1))
        .set(col.document("Aa"), Collections.singletonMap("a", 1))
        .set(col.document("7"), Collections.singletonMap("a", 1))
        .set(col.document("12"), Collections.singletonMap("a", 1))
        .set(col.document("__id7__"), Collections.singletonMap("a", 1))
        .set(col.document("__id12__"), Collections.singletonMap("a", 1))
        .set(col.document("__id-2__"), Collections.singletonMap("a", 1))
        .set(col.document("_id1__"), Collections.singletonMap("a", 1))
        .set(col.document("__id1_"), Collections.singletonMap("a", 1))
        .set(col.document("__id"), Collections.singletonMap("a", 1))
        .commit()
        .get();

    Query query = col.orderBy("__name__", Direction.ASCENDING);
    List<String> expectedOrder =
        Arrays.asList(
            "__id-2__",
            "__id7__",
            "__id12__",
            "12",
            "7",
            "A",
            "Aa",
            "__id",
            "__id1_",
            "_id1__",
            "a");

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());
    assertEquals(expectedOrder, queryOrder); // Assert order from backend

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();

    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));

              latch.countDown();
            });

    latch.await();
    registration.remove();

    assertEquals(expectedOrder, listenerOrder); // Assert order in the SDK
  }

  @Test
  public void snapshotListenerSortsFilteredQueryByDocumentIdInTheSameOrderAsServer()
      throws Exception {
    CollectionReference col = randomColl;

    firestore
        .batch()
        .set(col.document("A"), Collections.singletonMap("a", 1))
        .set(col.document("a"), Collections.singletonMap("a", 1))
        .set(col.document("Aa"), Collections.singletonMap("a", 1))
        .set(col.document("7"), Collections.singletonMap("a", 1))
        .set(col.document("12"), Collections.singletonMap("a", 1))
        .set(col.document("__id7__"), Collections.singletonMap("a", 1))
        .set(col.document("__id12__"), Collections.singletonMap("a", 1))
        .set(col.document("__id-2__"), Collections.singletonMap("a", 1))
        .set(col.document("_id1__"), Collections.singletonMap("a", 1))
        .set(col.document("__id1_"), Collections.singletonMap("a", 1))
        .set(col.document("__id"), Collections.singletonMap("a", 1))
        .commit()
        .get();

    Query query =
        col.whereGreaterThan(FieldPath.documentId(), "__id7__")
            .whereLessThanOrEqualTo(FieldPath.documentId(), "A")
            .orderBy("__name__", Direction.ASCENDING);
    List<String> expectedOrder = Arrays.asList("__id12__", "12", "7", "A");

    QuerySnapshot snapshot = query.get().get();
    List<String> queryOrder =
        snapshot.getDocuments().stream().map(doc -> doc.getId()).collect(Collectors.toList());
    assertEquals(expectedOrder, queryOrder); // Assert order from backend

    CountDownLatch latch = new CountDownLatch(1);
    List<String> listenerOrder = new ArrayList<>();

    ListenerRegistration registration =
        query.addSnapshotListener(
            (value, error) -> {
              listenerOrder.addAll(
                  value.getDocuments().stream()
                      .map(doc -> doc.getId())
                      .collect(Collectors.toList()));

              latch.countDown();
            });

    latch.await();
    registration.remove();

    assertEquals(expectedOrder, listenerOrder); // Assert order in the SDK
  }

  /**
   * A tuple class used by {@code #queryWatch}. This class represents an event delivered to the
   * registered query listener.
   */
  private static final class ListenerEvent {

    @Nullable private final QuerySnapshot value;
    @Nullable private final FirestoreException error;

    ListenerEvent(@Nullable QuerySnapshot value, @Nullable FirestoreException error) {
      this.value = value;
      this.error = error;
    }
  }

  private static final class EventsCountDownLatch {
    private final CountDownLatch initialEventsCountDownLatch;
    private final int initialEventCount;
    private final CountDownLatch errorCountDownLatch;
    private final EnumMap<DocumentChange.Type, Integer> eventsCounts;
    private final EnumMap<DocumentChange.Type, CountDownLatch> eventsCountDownLatches;

    EventsCountDownLatch(
        int initialEventCount,
        int addedInitialCount,
        int modifiedInitialCount,
        int removedInitialCount,
        int errorCount) {
      initialEventsCountDownLatch = new CountDownLatch(initialEventCount);
      this.initialEventCount = initialEventCount;
      this.errorCountDownLatch = new CountDownLatch(errorCount);
      eventsCounts = new EnumMap<>(DocumentChange.Type.class);
      eventsCounts.put(DocumentChange.Type.ADDED, addedInitialCount);
      eventsCounts.put(DocumentChange.Type.MODIFIED, modifiedInitialCount);
      eventsCounts.put(DocumentChange.Type.REMOVED, removedInitialCount);
      eventsCountDownLatches = new EnumMap<>(DocumentChange.Type.class);
      eventsCountDownLatches.put(DocumentChange.Type.ADDED, new CountDownLatch(addedInitialCount));
      eventsCountDownLatches.put(
          DocumentChange.Type.MODIFIED, new CountDownLatch(modifiedInitialCount));
      eventsCountDownLatches.put(
          DocumentChange.Type.REMOVED, new CountDownLatch(removedInitialCount));
    }

    void countDown() {
      initialEventsCountDownLatch.countDown();
    }

    void countDown(DocumentChange.Type type) {
      eventsCountDownLatches.get(type).countDown();
    }

    void countError() {
      errorCountDownLatch.countDown();
    }

    void awaitInitialEvents() throws InterruptedException {
      initialEventsCountDownLatch.await(5 * initialEventCount, TimeUnit.SECONDS);
    }

    void awaitError() throws InterruptedException {
      errorCountDownLatch.await(5, TimeUnit.SECONDS);
    }

    void await(DocumentChange.Type type) throws InterruptedException {
      int count = eventsCounts.get(type);
      eventsCountDownLatches.get(type).await(5 * count, TimeUnit.SECONDS);
    }
  }

  static class QuerySnapshotEventListener implements EventListener<QuerySnapshot> {
    final List<ListenerEvent> receivedEvents;
    final EventsCountDownLatch eventsCountDownLatch;

    private QuerySnapshotEventListener(
        int initialCount,
        int addedEventCount,
        int modifiedEventCount,
        int removedEventCount,
        int errorCount) {
      this.receivedEvents = Collections.synchronizedList(new ArrayList<>());
      this.eventsCountDownLatch =
          new EventsCountDownLatch(
              initialCount, addedEventCount, modifiedEventCount, removedEventCount, errorCount);
    }

    @Override
    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirestoreException error) {
      receivedEvents.add(new ListenerEvent(value, error));
      if (value != null) {
        List<DocumentChange> documentChanges = value.getDocumentChanges();
        for (DocumentChange docChange : documentChanges) {
          eventsCountDownLatch.countDown(docChange.getType());
        }
      }
      if (error != null) {
        eventsCountDownLatch.countError();
      }
      eventsCountDownLatch.countDown();
    }

    ListenerAssertions assertions() {
      return new ListenerAssertions(receivedEvents);
    }

    ListenerAssertions assertionsForLastEvent() {
      return new ListenerAssertions(singletonList(lastListenerEvent()));
    }

    ListenerEvent lastListenerEvent() {
      return receivedEvents.get(receivedEvents.size() - 1);
    }

    void lastDocumentIdsIsAnyOf(String... s) {
      List<String> ids =
          Lists.transform(lastListenerEvent().value.getDocuments(), DocumentSnapshot::getId);
      Truth.assertThat(ids).containsExactlyElementsIn(s);
    }

    static Builder builder() {
      return new Builder();
    }

    @SuppressWarnings("SameParameterValue")
    static final class Builder {
      private int initialEventCount = 0;
      private int addedEventCount = 0;
      private int modifiedEventCount = 0;
      private int removedEventCount = 0;
      private int errorCount = 0;

      private Builder() {}

      Builder setInitialEventCount(int initialEventCount) {
        this.initialEventCount = initialEventCount;
        return this;
      }

      Builder setAddedEventCount(int addedEventCount) {
        this.addedEventCount = addedEventCount;
        return this;
      }

      Builder setModifiedEventCount(int modifiedEventCount) {
        this.modifiedEventCount = modifiedEventCount;
        return this;
      }

      Builder setRemovedEventCount(int removedEventCount) {
        this.removedEventCount = removedEventCount;
        return this;
      }

      Builder setExpectError() {
        this.errorCount = 1;
        return this;
      }

      public QuerySnapshotEventListener build() {
        return new QuerySnapshotEventListener(
            initialEventCount, addedEventCount, modifiedEventCount, removedEventCount, errorCount);
      }
    }

    static final class ListenerAssertions {
      private static final MapJoiner MAP_JOINER = Joiner.on(",").withKeyValueSeparator("=");
      private final List<String> addedIds;
      private final List<String> modifiedIds;
      private final List<String> removedIds;
      private final List<ListenerEvent> receivedEvents;

      ListenerAssertions(List<ListenerEvent> receivedEvents) {
        this.receivedEvents = receivedEvents;
        List<QuerySnapshot> querySnapshots = getQuerySnapshots(receivedEvents);
        addedIds = getIds(querySnapshots, DocumentChange.Type.ADDED);
        modifiedIds = getIds(querySnapshots, DocumentChange.Type.MODIFIED);
        removedIds = getIds(querySnapshots, DocumentChange.Type.REMOVED);
      }

      private ListenerAssertions noError() {
        final Optional<ListenerEvent> anyError =
            receivedEvents.stream().filter(input -> input.error != null).findFirst();
        if (anyError.isPresent()) {
          throw new Error("snapshotListener received an error", anyError.get().error);
        }
        return this;
      }

      private ListenerAssertions hasError() {
        final Optional<ListenerEvent> anyError =
            receivedEvents.stream().filter(input -> input.error != null).findFirst();
        assertWithMessage("snapshotListener did not receive an expected error")
            .that(anyError.isPresent())
            .isTrue();
        return this;
      }

      private static List<QuerySnapshot> getQuerySnapshots(List<ListenerEvent> events) {
        return events.stream()
            .filter(input -> input.value != null)
            .map(input -> input.value)
            .collect(Collectors.toList());
      }

      private static List<String> getIds(
          List<QuerySnapshot> querySnapshots, DocumentChange.Type type) {
        final List<String> documentIds = new ArrayList<>();
        for (QuerySnapshot querySnapshot : querySnapshots) {
          final List<DocumentChange> changes = querySnapshot.getDocumentChanges();
          for (DocumentChange change : changes) {
            if (change.getType() == type) {
              documentIds.add(change.getDocument().getId());
            }
          }
        }
        return documentIds;
      }

      ListenerAssertions addedIdsIsEmpty() {
        Truth.assertWithMessage(debugMessage()).that(addedIds).isEmpty();
        return this;
      }

      ListenerAssertions addedIdsIsAnyOf(String... s) {
        Truth.assertWithMessage(debugMessage()).that(addedIds).containsExactlyElementsIn(s);
        return this;
      }

      ListenerAssertions addedIdsIsAnyOf(List<?> s1, List<?> s2) {
        Truth.assertWithMessage(debugMessage()).that(addedIds).isAnyOf(s1, s2);
        return this;
      }

      ListenerAssertions modifiedIdsIsEmpty() {
        Truth.assertWithMessage(debugMessage()).that(modifiedIds).isEmpty();
        return this;
      }

      ListenerAssertions modifiedIdsIsAnyOf(String... s) {
        Truth.assertWithMessage(debugMessage()).that(modifiedIds).containsExactlyElementsIn(s);
        return this;
      }

      ListenerAssertions modifiedIdsIsAnyOf(List<?> s1, List<?> s2) {
        Truth.assertWithMessage(debugMessage()).that(modifiedIds).isAnyOf(s1, s2);
        return this;
      }

      ListenerAssertions removedIdsIsEmpty() {
        Truth.assertWithMessage(debugMessage()).that(removedIds).isEmpty();
        return this;
      }

      ListenerAssertions removedIdsIsAnyOf(String... s) {
        Truth.assertWithMessage(debugMessage()).that(removedIds).containsExactlyElementsIn(s);
        return this;
      }

      ListenerAssertions removedIdsIsAnyOf(List<?> s1, List<?> s2) {
        Truth.assertWithMessage(debugMessage()).that(removedIds).isAnyOf(s1, s2);
        return this;
      }

      ListenerAssertions eventCountIsAnyOf(Range<Integer> range) {
        Truth.assertWithMessage(debugMessage()).that((int) receivedEvents.size()).isIn(range);
        return this;
      }

      private String debugMessage() {
        final StringBuilder builder = new StringBuilder();
        builder.append("events[\n");
        for (ListenerEvent receivedEvent : receivedEvents) {
          builder.append("event{");
          builder.append("error=").append(receivedEvent.error);
          builder.append(",");
          builder.append("value=");
          debugMessage(builder, receivedEvent.value);
          builder.append("},\n");
        }
        builder.append("]");
        return builder.toString();
      }

      private static void debugMessage(StringBuilder builder, QuerySnapshot qs) {
        if (qs == null) {
          builder.append("null");
        } else {
          builder.append("{");
          List<QueryDocumentSnapshot> documents = qs.getDocuments();
          builder.append("documents[");
          for (QueryDocumentSnapshot document : documents) {
            debugMessage(builder, document);
          }
          builder.append("],");
          List<DocumentChange> changes = qs.getDocumentChanges();
          builder.append("documentChanges[");
          for (DocumentChange change : changes) {
            debugMessage(builder, change.getDocument());
          }
          builder.append("]");
          builder.append("}");
        }
      }

      private static void debugMessage(
          StringBuilder builder, QueryDocumentSnapshot queryDocumentSnapshot) {
        if (queryDocumentSnapshot == null) {
          builder.append("null");
        } else {
          builder.append("{");
          builder.append("path=").append(queryDocumentSnapshot.getReference().getPath());
          builder.append(",");
          builder.append("data=");
          debugMessage(builder, queryDocumentSnapshot.getData());
          builder.append("}");
        }
      }

      private static void debugMessage(StringBuilder builder, Map<String, Object> data) {
        builder.append("{");
        MAP_JOINER.appendTo(builder, data);
        builder.append("}");
      }
    }
  }

  private DocumentReference setDocument(String documentId, Map<String, ?> fields) throws Exception {
    DocumentReference documentReference = randomColl.document(documentId);
    documentReference.set(fields).get();
    return documentReference;
  }

  private ListenResponse filter(int documentCount) {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setFilter(ExistenceFilter.newBuilder().setCount(documentCount).build());
    return response.build();
  }

  @Test
  public void testInequalityIncludesAndSortsMissingFields() throws Exception {
    setDocument("doc1", map("key", 1));
    setDocument("doc2", map("key", 2));
    setDocument("doc3", map("other", 1)); // missing "key"
    setDocument("doc4", map("key", null));

    final Query query = randomColl.whereNotEqualTo("key", 1);
    QuerySnapshotEventListener listener =
        QuerySnapshotEventListener.builder().setInitialEventCount(1).build();
    ListenerRegistration registration = query.addSnapshotListener(listener);

    try {
      listener.eventsCountDownLatch.awaitInitialEvents();
    } finally {
      registration.remove();
    }

    ListenerAssertions listenerAssertions = listener.assertions();
    listenerAssertions.noError();

    if (getFirestoreEdition() == FirestoreEdition.ENTERPRISE) {
      // Expect doc2, doc3, doc4. doc1 excluded.
      // Order: Missing/Null (which are equal in sort) < Number.
      // Missing/Null sorted by __name__.
      // doc3 < doc4.
      // So: doc3, doc4, doc2.
      List<String> expectedOrder = Arrays.asList("doc3", "doc4", "doc2");
      assertEquals(expectedOrder, listenerAssertions.addedIds);
    } else {
      List<String> expectedOrder = singletonList("doc2");
      assertEquals(expectedOrder, listenerAssertions.addedIds);
    }
  }
}
