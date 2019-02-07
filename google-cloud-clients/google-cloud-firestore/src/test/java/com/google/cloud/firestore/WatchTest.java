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

import static com.google.cloud.firestore.LocalFirestoreHelper.DATABASE_NAME;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.SINGLE_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATED_FIELD_MAP;
import static com.google.cloud.firestore.LocalFirestoreHelper.UPDATED_FIELD_PROTO;
import static com.google.cloud.firestore.LocalFirestoreHelper.map;
import static com.google.cloud.firestore.LocalFirestoreHelper.string;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.WatchTest.SnapshotDocument.ChangeType;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.TargetChange;
import com.google.firestore.v1.TargetChange.TargetChangeType;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class WatchTest {
  /** The Target ID used by the Java Firestore SDK. */
  private static final int TARGET_ID = 0x1;

  /** The resume token used by this test harness. */
  private static final ByteString RESUME_TOKEN = ByteString.copyFromUtf8("token");

  /** A counter of all document sent. Used to generate a unique update time. */
  private static int documentCount;

  @Spy private FirestoreRpc firestoreRpc = Mockito.mock(FirestoreRpc.class);

  @Spy
  private FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(), firestoreRpc);

  @Captor private ArgumentCaptor<ApiStreamObserver<ListenResponse>> streamObserverCapture;

  /** Executor that executes delayed tasks without delay. */
  private final ScheduledExecutorService immediateExecutor =
      new ScheduledThreadPoolExecutor(1) {
        @Override
        @Nonnull
        public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
          return super.schedule(command, 0, TimeUnit.MILLISECONDS);
        }
      };

  private BlockingQueue<ListenRequest> requests = new LinkedBlockingDeque<>();
  private BlockingQueue<FirestoreException> exceptions = new LinkedBlockingDeque<>();
  private BlockingQueue<DocumentSnapshot> documentSnapshots = new LinkedBlockingDeque<>();
  private BlockingQueue<QuerySnapshot> querySnapshots = new LinkedBlockingDeque<>();
  private Semaphore closes = new Semaphore(0);
  private QuerySnapshot lastSnapshot = null;

  private ListenerRegistration listenerRegistration;

  /** Holder class for the expected state of a document in a snapshot. */
  static class SnapshotDocument {
    enum ChangeType {
      UNCHANGED,
      ADDED,
      REMOVED,
      MODIFIED
    }

    ChangeType type;
    String name;
    Map<String, Object> data;

    SnapshotDocument(ChangeType type, String name, Map<String, Object> data) {
      this.type = type;
      this.name = name;
      this.data = data;
    }
  }

  @Before
  public void before() {
    requests.clear();
    documentSnapshots.clear();
    exceptions.clear();
    querySnapshots.clear();
    closes.drainPermits();
    lastSnapshot = null;

    doReturn(immediateExecutor).when(firestoreRpc).getExecutor();
    doAnswer(newRequestObserver())
        .when(firestoreMock)
        .streamRequest(streamObserverCapture.capture(), Matchers.<BidiStreamingCallable>any());
  }

  @After
  public void after() {
    assertTrue(exceptions.isEmpty());
    assertTrue(requests.isEmpty());
    assertTrue(documentSnapshots.isEmpty());
    assertTrue(querySnapshots.isEmpty());
    listenerRegistration.remove();
  }

  /** Initializes a document listener at 'coll/doc'. */
  private void addDocumentListener() {
    listenerRegistration =
        firestoreMock
            .document("coll/doc")
            .addSnapshotListener(
                new EventListener<DocumentSnapshot>() {
                  @Override
                  public void onEvent(
                      @Nullable DocumentSnapshot value, @Nullable FirestoreException error) {
                    if (value != null) {
                      documentSnapshots.add(value);
                    } else {
                      exceptions.add(error);
                    }
                  }
                });
  }

  /** Initializes a collection listener at 'coll'. */
  private void addQueryListener() {
    listenerRegistration =
        firestoreMock
            .collection("coll")
            .addSnapshotListener(
                new EventListener<QuerySnapshot>() {
                  @Override
                  public void onEvent(
                      @Nullable QuerySnapshot value, @Nullable FirestoreException error) {
                    if (value != null) {
                      querySnapshots.add(value);
                    } else {
                      exceptions.add(error);
                    }
                  }
                });
  }

  @Test
  public void documentWatchChange() throws InterruptedException {
    addDocumentListener();

    awaitAddTarget();
    send(addTarget());
    send(current());
    send(snapshot());

    awaitDocumentSnapshot();

    send(doc("coll/doc", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitDocumentSnapshot("coll/doc", SINGLE_FIELD_MAP);

    send(doc("coll/doc", UPDATED_FIELD_PROTO));
    send(snapshot());

    awaitDocumentSnapshot("coll/doc", UPDATED_FIELD_MAP);

    send(docDelete("coll/doc"));
    send(snapshot());

    awaitDocumentSnapshot();
  }

  @Test
  public void documentWatchIgnoresNonMatchingDocument() throws InterruptedException {
    addDocumentListener();

    awaitAddTarget();
    send(addTarget());
    send(current());
    send(doc("coll/nondoc", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitDocumentSnapshot();
  }

  @Test
  public void documentWatchCombinesEventsForDocument() throws InterruptedException {
    addDocumentListener();

    awaitAddTarget();
    send(addTarget());
    send(current());
    send(doc("coll/doc", SINGLE_FIELD_PROTO));
    send(doc("coll/doc", UPDATED_FIELD_PROTO));
    send(snapshot());

    awaitDocumentSnapshot("coll/doc", UPDATED_FIELD_MAP);
  }

  @Test
  public void queryWatchRemoveTarget() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();
    send(removeTarget(null));

    awaitException(null);
  }

  @Test
  public void queryWatchRemoveTargetWithStatus() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();
    send(removeTarget(Code.ABORTED));

    awaitException(Code.ABORTED);
  }

  @Test
  public void queryWatchReopensOnUnexceptedStreamEnd() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();

    send(addTarget());
    send(current());
    send(snapshot());

    awaitQuerySnapshot();

    close();
    awaitClose();
    awaitAddTarget();

    send(addTarget());
    send(current());
    send(doc("coll/doc", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchDoesntSendRaiseSnapshotOnReset() throws InterruptedException {
    // This test is meant to reproduce https://github.com/googleapis/google-cloud-dotnet/issues/2542
    addQueryListener();

    awaitAddTarget();

    send(addTarget());
    send(current());
    send(snapshot());

    awaitQuerySnapshot();

    close();
    awaitClose();
    awaitAddTarget();

    send(addTarget());
    send(current());
    // This should not raise a snapshot, since nothing has changed since the last snapshot.
    send(snapshot());

    send(doc("coll/doc", SINGLE_FIELD_PROTO));
    send(snapshot());

    // Verify that we only receveived one snapshot.
    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchDoesntReopenInactiveStream() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();

    send(addTarget());
    send(current());
    send(snapshot());

    awaitQuerySnapshot();

    close();
    listenerRegistration.remove();
  }

  @Test
  public void queryWatchRetriesBasedOnErrorCode() throws InterruptedException {
    Map<Code, Boolean> expectRetry = new HashMap<>();
    expectRetry.put(Code.CANCELLED, true);
    expectRetry.put(Code.UNKNOWN, true);
    expectRetry.put(Code.INVALID_ARGUMENT, false);
    expectRetry.put(Code.DEADLINE_EXCEEDED, true);
    expectRetry.put(Code.NOT_FOUND, false);
    expectRetry.put(Code.ALREADY_EXISTS, false);
    expectRetry.put(Code.PERMISSION_DENIED, false);
    expectRetry.put(Code.RESOURCE_EXHAUSTED, true);
    expectRetry.put(Code.FAILED_PRECONDITION, false);
    expectRetry.put(Code.ABORTED, false);
    expectRetry.put(Code.OUT_OF_RANGE, false);
    expectRetry.put(Code.UNIMPLEMENTED, false);
    expectRetry.put(Code.INTERNAL, true);
    expectRetry.put(Code.UNAVAILABLE, true);
    expectRetry.put(Code.DATA_LOSS, false);
    expectRetry.put(Code.UNAUTHENTICATED, true);

    for (Entry<Code, Boolean> entry : expectRetry.entrySet()) {
      addQueryListener();
      awaitAddTarget();
      send(addTarget());
      send(current());
      destroy(entry.getKey());

      if (entry.getValue()) {
        awaitAddTarget();
        send(addTarget());
        send(current());
        send(snapshot());
        awaitQuerySnapshot();
        listenerRegistration.remove();
      } else {
        awaitException(null);
      }
    }
  }

  @Test
  public void queryWatchHandlesDocumentChange() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();

    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));

    send(doc("coll/doc1", UPDATED_FIELD_PROTO));
    send(doc("coll/doc3", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.MODIFIED, "coll/doc1", UPDATED_FIELD_MAP),
        new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc2", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc3", SINGLE_FIELD_MAP));

    send(docDelete("coll/doc1"));
    send(docRemove("coll/doc3"));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.REMOVED, "coll/doc1", null),
        new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc2", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.REMOVED, "coll/doc3", null));
  }

  @Test
  public void queryWatchReconnectsWithResumeToken() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();

    send(addTarget());
    send(current());
    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    // This update gets ignored.
    send(doc("coll/doc1", UPDATED_FIELD_PROTO));
    close();

    awaitResumeToken();
    send(addTarget());
    send(current());
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchSortsDocuments() throws InterruptedException {
    listenerRegistration =
        firestoreMock
            .collection("coll")
            .orderBy("foo")
            .orderBy("bar", Direction.DESCENDING)
            .addSnapshotListener(
                new EventListener<QuerySnapshot>() {
                  @Override
                  public void onEvent(
                      @Nullable QuerySnapshot value, @Nullable FirestoreException error) {
                    querySnapshots.add(value);
                  }
                });

    ListenResponse[] documents =
        new ListenResponse[] {
          doc("coll/doc1", map("foo", string("a"), "bar", string("b"))),
          doc("coll/doc2", map("foo", string("a"), "bar", string("a"))),
          doc("coll/doc3", map("foo", string("b"), "bar", string("b"))),
          doc("coll/doc5", map("foo", string("b"), "bar", string("a"))),
          // doc4 sorts after doc5 because __name__ uses the last specified sort direction.
          doc("coll/doc4", map("foo", string("b"), "bar", string("a")))
        };

    awaitAddTarget();

    send(addTarget());
    send(current());

    // Send document in any order
    send(documents[4]);
    send(documents[3]);
    send(documents[2]);
    send(documents[0]);
    send(documents[1]);

    send(snapshot());

    QuerySnapshot querySnapshot = querySnapshots.take();
    verifyOrder(
        Arrays.asList("coll/doc1", "coll/doc2", "coll/doc3", "coll/doc5", "coll/doc4"),
        querySnapshot.getDocuments());
  }

  @Test
  public void queryWatchCombinesChangesForSameDocument() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(doc("coll/doc1", UPDATED_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", UPDATED_FIELD_MAP));

    send(doc("coll/doc1", UPDATED_FIELD_PROTO));
    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.MODIFIED, "coll/doc1", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesDeletingNonExistingDocument() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(docDelete("coll/doc2"));
    send(doc("coll/doc1", UPDATED_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.MODIFIED, "coll/doc1", UPDATED_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesDeletesAndAddInSingleSnapshot() throws InterruptedException {
    ListenResponse document = doc("coll/doc1", SINGLE_FIELD_PROTO);

    addQueryListener();

    awaitAddTarget();
    send(addTarget());
    send(current());

    send(document);
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(docDelete("coll/doc1"));
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(document);

    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesAddAndDeleteInSingleSnapshot() throws InterruptedException {
    addQueryListener();

    awaitAddTarget();
    send(addTarget());
    send(current());

    send(snapshot());

    awaitQuerySnapshot();

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(docDelete("coll/doc1"));

    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesReset() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(reset());

    send(current());
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.REMOVED, "coll/doc1", null),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesFilterMatch() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(filter(1));
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesFilterMismatch() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(filter(2));
    awaitClose();

    awaitAddTarget();
    send(doc("coll/doc2", SINGLE_FIELD_PROTO));
    send(current());
    send(snapshot());

    awaitQuerySnapshot(
        new SnapshotDocument(ChangeType.REMOVED, "coll/doc1", null),
        new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
  }

  @Test
  public void queryWatchHandlesTargetRemoval() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());

    send(doc("coll/doc1", SINGLE_FIELD_PROTO));
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    ListenResponse.Builder request = doc("coll/doc1", SINGLE_FIELD_PROTO).toBuilder();
    request.getDocumentChangeBuilder().clearTargetIds();
    request.getDocumentChangeBuilder().addRemovedTargetIds(TARGET_ID);

    send(request.build());
    send(snapshot());

    awaitQuerySnapshot(new SnapshotDocument(ChangeType.REMOVED, "coll/doc1", null));
  }

  @Test
  public void queryWatchHandlesIgnoresDifferentTarget() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());

    ListenResponse.Builder request = doc("coll/doc1", SINGLE_FIELD_PROTO).toBuilder();
    request.getDocumentChangeBuilder().clearTargetIds();
    request.getDocumentChangeBuilder().addTargetIds(0x2);

    send(request.build());
    send(snapshot());

    awaitQuerySnapshot();
  }

  @Test
  public void emptySnapshotEquals() throws InterruptedException {
    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());
    send(snapshot());
    QuerySnapshot firstSnapshot = awaitQuerySnapshot();

    restartWatch();

    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(current());
    send(snapshot());
    QuerySnapshot secondSnapshot = awaitQuerySnapshot();

    assertEquals(firstSnapshot, firstSnapshot);
    assertEquals(firstSnapshot, secondSnapshot);
  }

  @Test
  public void snapshotWithChangesEquals() throws InterruptedException {
    ListenResponse doc1 = doc("coll/doc1", SINGLE_FIELD_PROTO);
    ListenResponse doc2 = doc("coll/doc2", SINGLE_FIELD_PROTO);
    ListenResponse doc3 = doc("coll/doc3", SINGLE_FIELD_PROTO);

    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(doc1);
    send(current());
    send(snapshot());
    QuerySnapshot firstSnapshot =
        awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP));

    send(doc2);
    send(doc3);
    send(snapshot());
    QuerySnapshot secondSnapshot =
        awaitQuerySnapshot(
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.ADDED, "coll/doc3", SINGLE_FIELD_MAP));
    assertNotEquals(secondSnapshot, firstSnapshot);

    send(docDelete("coll/doc3"));
    send(snapshot());
    QuerySnapshot thirdSnapshot =
        awaitQuerySnapshot(
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc2", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.REMOVED, "coll/doc3", null));
    assertNotEquals(thirdSnapshot, firstSnapshot);
    assertNotEquals(thirdSnapshot, secondSnapshot);

    restartWatch();

    addQueryListener();
    awaitAddTarget();
    send(addTarget());
    send(doc2);
    send(current());
    send(snapshot());
    QuerySnapshot currentSnapshot =
        awaitQuerySnapshot(new SnapshotDocument(ChangeType.ADDED, "coll/doc2", SINGLE_FIELD_MAP));
    assertNotEquals(currentSnapshot, firstSnapshot);

    send(doc3);
    send(doc1);
    send(snapshot());
    currentSnapshot =
        awaitQuerySnapshot(
            new SnapshotDocument(ChangeType.ADDED, "coll/doc1", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc2", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.ADDED, "coll/doc3", SINGLE_FIELD_MAP));
    assertNotEquals(currentSnapshot, secondSnapshot);

    send(docDelete("coll/doc3"));
    send(snapshot());
    currentSnapshot =
        awaitQuerySnapshot(
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc1", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.UNCHANGED, "coll/doc2", SINGLE_FIELD_MAP),
            new SnapshotDocument(ChangeType.REMOVED, "coll/doc3", null));
    assertEquals(currentSnapshot, thirdSnapshot);
  }

  private void restartWatch() {
    after();
    before();
  }

  private void awaitException(Code expectedCode) throws InterruptedException {
    FirestoreException exception = exceptions.take();

    if (expectedCode != null) {
      assertEquals(expectedCode, exception.getStatus().getCode());
    }
  }

  /** Awaits a DocumentSnapshot and validates its contents based on the provided document. */
  private void awaitDocumentSnapshot(String docPath, Map<String, Object> data)
      throws InterruptedException {
    DocumentSnapshot documentSnapshot = documentSnapshots.take();
    assertEquals(docPath, documentSnapshot.getReference().getPath());
    assertEquals(data, documentSnapshot.getData());
  }

  /** Awaits a QuerySnapshot and validates its contents based on the provided documents. */
  private QuerySnapshot awaitQuerySnapshot(SnapshotDocument... documents)
      throws InterruptedException {
    QuerySnapshot querySnapshot = querySnapshots.take();

    // List of documents to use a base to replay all changes. Verifies oldIndex and newIndex.
    List<QueryDocumentSnapshot> updatedDocuments = new ArrayList<>();

    if (lastSnapshot != null) {
      updatedDocuments.addAll(lastSnapshot.getDocuments());
    }

    // List of document names in the expected sorted order.
    List<String> expectedOrder = new ArrayList<>();

    Iterator<QueryDocumentSnapshot> snapshotIterator = querySnapshot.getDocuments().iterator();

    for (SnapshotDocument expected : documents) {
      if (expected.type != ChangeType.REMOVED) {
        DocumentSnapshot actual = snapshotIterator.next();
        assertEquals(expected.name, actual.getReference().getPath());
        assertEquals(expected.data, actual.getData());
        assertNotNull(actual.getReadTime());
        expectedOrder.add(expected.name);
      }

      boolean found = false;

      for (com.google.cloud.firestore.DocumentChange change : querySnapshot.getDocumentChanges()) {
        if (change.getDocument().getReference().getPath().equals(expected.name)) {
          if (change.getOldIndex() != -1) {
            updatedDocuments.remove(change.getOldIndex());
          }
          if (change.getNewIndex() != -1) {
            updatedDocuments.add(change.getNewIndex(), change.getDocument());
          }
          assertEquals(expected.type.name(), change.getType().name());
          found = true;
          break;
        }
      }

      if (!found) {
        assertEquals(ChangeType.UNCHANGED, expected.type);
      }
    }

    assertFalse(snapshotIterator.hasNext());

    lastSnapshot = querySnapshot;

    verifyOrder(expectedOrder, updatedDocuments);

    return querySnapshot;
  }

  private void verifyOrder(
      List<String> expectedOrder, List<QueryDocumentSnapshot> updatedDocuments) {
    assertEquals(expectedOrder.size(), updatedDocuments.size());

    for (int i = 0; i < expectedOrder.size(); ++i) {
      assertEquals(expectedOrder.get(i), updatedDocuments.get(i).getReference().getPath());
    }
  }

  private void awaitDocumentSnapshot() throws InterruptedException {
    DocumentSnapshot documentSnapshot = documentSnapshots.take();
    assertFalse(documentSnapshot.exists());
  }

  private void awaitClose() throws InterruptedException {
    closes.acquire();
  }

  private void awaitAddTarget() throws InterruptedException {
    ListenRequest listenRequest = requests.take();
    assertEquals(DATABASE_NAME, listenRequest.getDatabase());
    assertEquals(TARGET_ID, listenRequest.getAddTarget().getTargetId());
  }

  private void awaitResumeToken() throws InterruptedException {
    ListenRequest listenRequest = requests.take();
    assertEquals(DATABASE_NAME, listenRequest.getDatabase());
    assertEquals(TARGET_ID, listenRequest.getAddTarget().getTargetId());
    assertEquals(RESUME_TOKEN, listenRequest.getAddTarget().getResumeToken());
  }

  private ListenResponse removeTarget(@Nullable Code code) {
    TargetChange.Builder targetChange =
        TargetChange.newBuilder()
            .setTargetChangeType(TargetChangeType.REMOVE)
            .addTargetIds(TARGET_ID);

    if (code != null) {
      targetChange.setCause(Status.newBuilder().setCode(code.value()));
    }

    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setTargetChange(targetChange);
    return response.build();
  }

  private ListenResponse addTarget() {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setTargetChange(
        TargetChange.newBuilder()
            .setTargetChangeType(TargetChangeType.ADD)
            .addTargetIds(TARGET_ID));
    return response.build();
  }

  private ListenResponse current() {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setTargetChange(
        TargetChange.newBuilder()
            .setTargetChangeType(TargetChangeType.CURRENT)
            .addTargetIds(TARGET_ID));
    return response.build();
  }

  private ListenResponse reset() {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setTargetChange(
        TargetChange.newBuilder()
            .setTargetChangeType(TargetChangeType.RESET)
            .addTargetIds(TARGET_ID));
    return response.build();
  }

  private ListenResponse filter(int documentCount) {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setFilter(ExistenceFilter.newBuilder().setCount(documentCount).build());
    return response.build();
  }

  private ListenResponse snapshot() {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setTargetChange(
        TargetChange.newBuilder()
            .setTargetChangeType(TargetChangeType.NO_CHANGE)
            .setReadTime(Timestamp.getDefaultInstance())
            .setResumeToken(RESUME_TOKEN));
    return response.build();
  }

  private ListenResponse doc(String docPath, Map<String, Value> singleFieldProto) {
    DocumentChange.Builder documentChange = DocumentChange.newBuilder();
    documentChange.addTargetIds(TARGET_ID);
    documentChange.setDocument(
        Document.newBuilder()
            .setName(String.format("%s/documents/%s", DATABASE_NAME, docPath))
            .putAllFields(singleFieldProto)
            .setUpdateTime(updateTime()));

    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setDocumentChange(documentChange);

    return response.build();
  }

  private Timestamp updateTime() {
    return Timestamp.newBuilder().setSeconds(++documentCount).build();
  }

  private ListenResponse docDelete(String docPath) {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setDocumentDelete(
        DocumentDelete.newBuilder()
            .addRemovedTargetIds(TARGET_ID)
            .setDocument(String.format("%s/documents/%s", DATABASE_NAME, docPath)));

    return response.build();
  }

  private ListenResponse docRemove(String docPath) {
    ListenResponse.Builder response = ListenResponse.newBuilder();
    response.setDocumentRemove(
        DocumentRemove.newBuilder()
            .addRemovedTargetIds(TARGET_ID)
            .setDocument(String.format("%s/documents/%s", DATABASE_NAME, docPath)));

    return response.build();
  }

  private void send(ListenResponse response) throws InterruptedException {
    streamObserverCapture.getValue().onNext(response);
  }

  private void destroy(Code code) throws InterruptedException {
    streamObserverCapture.getValue().onError(new StatusException(io.grpc.Status.fromCode(code)));
  }

  private void close() throws InterruptedException {
    streamObserverCapture.getValue().onCompleted();
  }

  /** Returns a new request observer that persists its input. */
  private Answer newRequestObserver() {
    return new Answer() {
      @Override
      public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        return new ApiStreamObserver<ListenRequest>() {
          @Override
          public void onNext(ListenRequest listenRequest) {
            requests.add(listenRequest);
          }

          @Override
          public void onError(Throwable throwable) {
            fail("Received unexpected error");
          }

          @Override
          public void onCompleted() {
            closes.release();
          }
        };
      }
    };
  }
}
