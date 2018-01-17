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

import com.google.api.core.CurrentMillisClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.DocumentChange.Type;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.ListenRequest;
import com.google.firestore.v1beta1.ListenResponse;
import com.google.firestore.v1beta1.Target;
import com.google.firestore.v1beta1.Target.QueryTarget;
import com.google.firestore.v1beta1.TargetChange;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

/**
 * Watch provides listen functionality and exposes snapshot listeners. It can be used with any valid
 * Firestore Listen target.
 *
 * <p>This class is thread-compatible when called through the methods defined in ApiStreamObserver.
 * It synchronizes on its own instance so it is advisable not to use this class for external
 * synchronization.
 */
class Watch implements ApiStreamObserver<ListenResponse> {
  /**
   * Target ID used by watch. Watch uses a fixed target id since we only support one target per
   * stream. The actual target ID we use is arbitrary.
   */
  private static final int WATCH_TARGET_ID = 0xD0;

  private static RetrySettings RETRY_SETTINGS =
      RetrySettings.newBuilder()
          // The initial backoff time in seconds after an error.
          // Set to 1s according to https://cloud.google.com/apis/design/errors.
          .setInitialRetryDelay(Duration.ofSeconds(1))
          // The maximum backoff time in minutes.
          .setMaxRetryDelay(Duration.ofMinutes(1))
          // The factor to increase the backup by after each failed attempt.
          .setRetryDelayMultiplier(1.5)
          .setJittered(true)
          .build();

  private final FirestoreImpl firestore;
  private final ScheduledExecutorService firestoreExecutor;
  private final Comparator<QueryDocumentSnapshot> comparator;
  private final ExponentialRetryAlgorithm backoff;
  private final Target target;
  private TimedAttemptSettings nextAttempt;
  private ApiStreamObserver<ListenRequest> stream;

  /** The sorted tree of DocumentSnapshots as sent in the last snapshot. */
  private DocumentSet documentSet;

  /** The accumulates map of document changes (keyed by document name) for the current snapshot. */
  private Map<ResourcePath, Document> changeMap;

  /** The server-assigned resume token. */
  private ByteString resumeToken;

  /** The user-provided listener. */
  private EventListener<QuerySnapshot> listener;

  /** The user-provided callback executor. */
  private Executor userCallbackExecutor;

  /**
   * Whether the retrieved result set has been marked 'CURRENT' (has caught up with the backend
   * state at target initialization).
   */
  private boolean current;

  /**
   * Tracks whether we've pushed an initial set of changes. This is needed since we should push
   * those even when there are none.
   */
  private boolean hasPushed;

  /**
   * Indicates whether we are interested in data from the stream. Set to false in the
   * 'unsubscribe()' callback.
   */
  private AtomicBoolean isActive;

  /** The list of document changes in a snapshot separated by change type. */
  static class ChangeSet {
    List<QueryDocumentSnapshot> deletes = new ArrayList<>();
    List<QueryDocumentSnapshot> adds = new ArrayList<>();
    List<QueryDocumentSnapshot> updates = new ArrayList<>();
  }

  /**
   * @param firestore The Firestore Database client.
   * @param target A Firestore 'Target' proto denoting the target to listen on.
   * @param comparator A comparator for DocumentSnapshots that is used to order the document
   *     snapshots returned by this watch.
   */
  private Watch(
      FirestoreImpl firestore, Target target, Comparator<QueryDocumentSnapshot> comparator) {
    this.firestore = firestore;
    this.target = target;
    this.comparator = comparator;
    this.backoff =
        new ExponentialRetryAlgorithm(RETRY_SETTINGS, CurrentMillisClock.getDefaultClock());
    this.firestoreExecutor = firestore.getClient().getExecutor();
    this.isActive = new AtomicBoolean();
    this.nextAttempt = backoff.createFirstAttempt();
  }

  /**
   * Creates a new Watch instance that listens on DocumentReferences.
   *
   * @param documentReference The document reference for this watch.
   * @return A newly created Watch instance.
   */
  static Watch forDocument(DocumentReference documentReference) {
    Target.Builder target = Target.newBuilder();
    target.getDocumentsBuilder().addDocuments(documentReference.getName());
    target.setTargetId(WATCH_TARGET_ID);

    return new Watch(
        (FirestoreImpl) documentReference.getFirestore(),
        target.build(),
        new Comparator<QueryDocumentSnapshot>() {
          @Override
          public int compare(QueryDocumentSnapshot o1, QueryDocumentSnapshot o2) {
            // We should only ever receive one document for DocumentReference listeners.
            Preconditions.checkState(o1.equals(o2));
            return 0;
          }
        });
  }

  /**
   * Creates a new Watch instance that listens listen on Queries.
   *
   * @param query The query used for this watch.
   * @return A newly created Watch instance.
   */
  static Watch forQuery(Query query) {
    Target.Builder target = Target.newBuilder();
    target.setQuery(
        QueryTarget.newBuilder()
            .setStructuredQuery(query.buildQuery())
            .setParent(query.getResourcePath().getParent().getName())
            .build());
    target.setTargetId(WATCH_TARGET_ID);

    return new Watch((FirestoreImpl) query.getFirestore(), target.build(), query.comparator());
  }

  @Override
  public synchronized void onNext(ListenResponse listenResponse) {
    switch (listenResponse.getResponseTypeCase()) {
      case TARGET_CHANGE:
        TargetChange change = listenResponse.getTargetChange();
        boolean noTargetIds = change.getTargetIdsCount() == 0;

        switch (change.getTargetChangeType()) {
          case NO_CHANGE:
            if (noTargetIds && change.hasReadTime() && current) {
              // This means everything is up-to-date, so emit the current set of docs as a snapshot,
              // if there were changes.
              pushSnapshot(change.getReadTime(), change.getResumeToken());
            }
            break;
          case ADD:
            Preconditions.checkState(
                WATCH_TARGET_ID == change.getTargetIds(0), "Target ID must be 0xD0");
            break;
          case REMOVE:
            Status status =
                change.hasCause()
                    ? Status.fromCodeValue(change.getCause().getCode())
                    : Status.CANCELLED;
            closeStream(
                FirestoreException.serverRejected(
                    status, "Backend ended Listen stream: " + change.getCause().getMessage()));
            break;
          case CURRENT:
            current = true;
            break;
          case RESET:
            resetDocs();
            break;
          default:
            closeStream(
                FirestoreException.invalidState(
                    "Encountered invalid target change type: " + change.getTargetChangeType()));
        }

        if (change.getResumeToken() != null
            && affectsTarget(change.getTargetIdsList(), WATCH_TARGET_ID)) {
          nextAttempt = backoff.createFirstAttempt();
        }

        break;
      case DOCUMENT_CHANGE:
        // No other targetIds can show up here, but we still need to see if the targetId was in the
        // added list or removed list.
        List<Integer> targetIds = listenResponse.getDocumentChange().getTargetIdsList();
        List<Integer> removedTargetIds =
            listenResponse.getDocumentChange().getRemovedTargetIdsList();
        boolean changed = targetIds.contains(WATCH_TARGET_ID);
        boolean removed = removedTargetIds.contains(WATCH_TARGET_ID);

        Document document = listenResponse.getDocumentChange().getDocument();
        ResourcePath name = ResourcePath.create(document.getName());

        if (changed) {
          changeMap.put(name, document);
        } else if (removed) {
          changeMap.put(name, null);
        }
        break;
      case DOCUMENT_DELETE:
        changeMap.put(ResourcePath.create(listenResponse.getDocumentDelete().getDocument()), null);
        break;
      case DOCUMENT_REMOVE:
        changeMap.put(ResourcePath.create(listenResponse.getDocumentRemove().getDocument()), null);
        break;
      case FILTER:
        if (listenResponse.getFilter().getCount() != currentSize()) {
          // We need to remove all the current results.
          resetDocs();
          // The filter didn't match, so re-issue the query.
          resetStream();
        }
        break;
      default:
        closeStream(FirestoreException.invalidState("Encountered invalid listen response type"));
        break;
    }
  }

  @Override
  public synchronized void onError(Throwable throwable) {
    maybeReopenStream(throwable);
  }

  @Override
  public synchronized void onCompleted() {
    maybeReopenStream(new StatusException(Status.fromCode(Code.UNKNOWN)));
  }

  /** API entry point that starts the Watch stream. */
  ListenerRegistration runWatch(
      final Executor userCallbackExecutor, EventListener<QuerySnapshot> listener) {
    boolean watchStarted = isActive.compareAndSet(false, true);

    Preconditions.checkState(watchStarted, "Can't restart an already active watch");

    this.userCallbackExecutor = userCallbackExecutor;
    this.listener = listener;

    this.stream = null;
    this.documentSet = DocumentSet.emptySet(comparator);
    this.changeMap = new HashMap<>();
    this.resumeToken = null;
    this.current = false;

    initStream();

    return new ListenerRegistration() {
      @Override
      public void remove() {
        isActive.set(false);

        firestore
            .getClient()
            .getExecutor()
            .execute(
                new Runnable() {
                  @Override
                  public void run() {
                    synchronized (Watch.this) {
                      stream.onCompleted();
                      stream = null;
                    }
                  }
                });
      }
    };
  }

  /**
   * Returns the current count of all documents, including the changes from the current changeMap.
   */
  private int currentSize() {
    ChangeSet changeSet = extractChanges(Timestamp.getDefaultInstance());
    return documentSet.size() + changeSet.adds.size() - changeSet.deletes.size();
  }

  /** Helper to clear the docs on RESET or filter mismatch. */
  private void resetDocs() {
    changeMap.clear();
    resumeToken = null;

    for (DocumentSnapshot snapshot : documentSet) {
      // Mark each document as deleted. If documents are not deleted, they  will be send again by
      // the server.
      changeMap.put(snapshot.getReference().getResourcePath(), null);
    }

    current = false;
  }

  /** Closes the stream and calls onError() if the stream is still active. */
  private void closeStream(final Throwable throwable) {
    if (stream != null) {
      stream.onCompleted();
      stream = null;
    }

    if (isActive.getAndSet(false)) {
      userCallbackExecutor.execute(
          new Runnable() {
            @Override
            public void run() {
              listener.onEvent(
                  null,
                  throwable instanceof FirestoreException
                      ? (FirestoreException) throwable
                      : FirestoreException.apiException(
                          new ApiException(
                              throwable,
                              GrpcStatusCode.of(getStatus(throwable).getCode()),
                              false)));
            }
          });
    }
  }

  /**
   * Re-opens the stream unless the specified error is considered permanent. Clears the change map.
   */
  private void maybeReopenStream(Throwable throwable) {
    if (isActive.get() && !isPermanentError(throwable)) {
      if (isResourceExhaustedError(throwable)) {
        nextAttempt = backoff.createNextAttempt(nextAttempt);
      }

      changeMap.clear();
      resetStream();
    } else {
      closeStream(throwable);
    }
  }

  /** Helper to restart the outgoing stream to the backend. */
  private void resetStream() {
    if (stream != null) {
      stream.onCompleted();
      stream = null;
    }

    initStream();
  }

  /** Initializes a new stream to the backend with backoff. */
  private void initStream() {
    firestoreExecutor.schedule(
        new Runnable() {
          @Override
          public void run() {
            if (!isActive.get()) {
              return;
            }

            synchronized (Watch.this) {
              if (!isActive.get()) {
                return;
              }

              Preconditions.checkState(stream == null);

              current = false;
              hasPushed = false;
              nextAttempt = backoff.createNextAttempt(nextAttempt);

              stream = firestore.streamRequest(Watch.this, firestore.getClient().listenCallable());

              ListenRequest.Builder request = ListenRequest.newBuilder();
              request.setDatabase(firestore.getDatabaseName());
              request.setAddTarget(target);
              if (resumeToken != null) {
                request.getAddTargetBuilder().setResumeToken(resumeToken);
              }

              stream.onNext(request.build());
            }
          }
        },
        nextAttempt.getRandomizedRetryDelay().toMillis(),
        TimeUnit.MILLISECONDS);
  }

  /**
   * Checks if the current target id is included in the list of target ids. Returns true if no
   * targetIds are provided.
   */
  private boolean affectsTarget(List<Integer> targetIds, int currentId) {
    return targetIds == null || targetIds.isEmpty() || targetIds.contains(currentId);
  }

  /** Splits up document changes into removals, additions, and updates. */
  private ChangeSet extractChanges(Timestamp readTime) {
    ChangeSet changeSet = new ChangeSet();

    for (Entry<ResourcePath, Document> change : changeMap.entrySet()) {
      if (change.getValue() == null) {
        if (documentSet.contains(change.getKey())) {
          changeSet.deletes.add(documentSet.getDocument(change.getKey()));
        }
        continue;
      }

      QueryDocumentSnapshot snapshot =
          QueryDocumentSnapshot.fromDocument(firestore, readTime, change.getValue());

      if (documentSet.contains(change.getKey())) {
        changeSet.updates.add(snapshot);
      } else {
        changeSet.adds.add(snapshot);
      }
    }

    return changeSet;
  }

  /**
   * Assembles a new snapshot from the current set of changes and invokes the user's callback.
   * Clears the current changes on completion.
   */
  private void pushSnapshot(final Timestamp readTime, ByteString nextResumeToken) {
    final List<DocumentChange> changes = computeSnapshot(readTime);
    final DocumentSet documents = documentSet;

    if (!hasPushed || !changes.isEmpty()) {
      userCallbackExecutor.execute(
          new Runnable() {
            @Override
            public void run() {
              QuerySnapshot querySnapshot =
                  new QuerySnapshot(
                      null,
                      Instant.ofEpochSecond(readTime.getSeconds(), readTime.getNanos()),
                      documents,
                      changes);
              listener.onEvent(querySnapshot, null);
            }
          });
      hasPushed = true;
    }

    changeMap.clear();
    resumeToken = nextResumeToken;
  }

  /**
   * Applies a document delete to the document tree. Returns the corresponding DocumentChange event.
   */
  private DocumentChange deleteDoc(QueryDocumentSnapshot oldDocument) {
    ResourcePath resourcePath = oldDocument.getReference().getResourcePath();
    int oldIndex = documentSet.indexOf(resourcePath);
    documentSet = documentSet.remove(resourcePath);
    return new DocumentChange(oldDocument, Type.REMOVED, oldIndex, -1);
  }

  /**
   * Applies a document add to the document tree. Returns the corresponding DocumentChange event.
   */
  private DocumentChange addDoc(QueryDocumentSnapshot newDocument) {
    ResourcePath resourcePath = newDocument.getReference().getResourcePath();
    documentSet = documentSet.add(newDocument);
    int newIndex = documentSet.indexOf(resourcePath);
    return new DocumentChange(newDocument, Type.ADDED, -1, newIndex);
  };

  /**
   * Applies a document modification to the document tree. Returns the DocumentChange event for
   * successful modifications.
   */
  @Nullable
  private DocumentChange modifyDoc(QueryDocumentSnapshot newDocument) {
    ResourcePath resourcePath = newDocument.getReference().getResourcePath();
    DocumentSnapshot oldDocument = documentSet.getDocument(resourcePath);

    if (!oldDocument.getUpdateTime().equals(newDocument.getUpdateTime())) {
      int oldIndex = documentSet.indexOf(resourcePath);
      documentSet = documentSet.remove(resourcePath);
      documentSet = documentSet.add(newDocument);
      int newIndex = documentSet.indexOf(resourcePath);
      return new DocumentChange(newDocument, Type.MODIFIED, oldIndex, newIndex);
    }
    return null;
  };

  /**
   * Applies the mutations in changeMap to the document tree. Modified 'documentSet' in-place and
   * returns the changed documents.
   *
   * @param readTime The time at which this snapshot was obtained.
   */
  private List<DocumentChange> computeSnapshot(Timestamp readTime) {
    List<DocumentChange> appliedChanges = new ArrayList<>();

    ChangeSet changeSet = extractChanges(readTime);

    // Process the sorted changes in the order that is expected by our clients (removals, additions,
    // and then modifications). We also need to sort the individual changes to assure that
    // oldIndex/newIndex keep incrementing.
    Collections.sort(changeSet.deletes, comparator);
    for (QueryDocumentSnapshot delete : changeSet.deletes) {
      appliedChanges.add(deleteDoc(delete));
    }

    Collections.sort(changeSet.adds, comparator);
    for (QueryDocumentSnapshot add : changeSet.adds) {
      appliedChanges.add(addDoc(add));
    }

    Collections.sort(changeSet.updates, comparator);
    for (QueryDocumentSnapshot update : changeSet.updates) {
      DocumentChange change = modifyDoc(update);
      if (change != null) {
        appliedChanges.add(change);
      }
    }

    return appliedChanges;
  }

  /** Determines whether a GRPC Error is considered permanent and should not be retried. */
  private static boolean isPermanentError(Throwable throwable) {
    Status status = getStatus(throwable);

    switch (status.getCode()) {
      case CANCELLED:
      case UNKNOWN:
      case DEADLINE_EXCEEDED:
      case RESOURCE_EXHAUSTED:
      case INTERNAL:
      case UNAVAILABLE:
      case UNAUTHENTICATED:
        return false;
      default:
        return true;
    }
  }

  /** Extracts the GRPC status code if available. Returns UNKNOWN for non-GRPC exceptions. */
  private static Status getStatus(Throwable throwable) {
    Status status = Status.UNKNOWN;

    if (throwable instanceof StatusRuntimeException) {
      status = ((StatusRuntimeException) throwable).getStatus();
    } else if (throwable instanceof StatusException) {
      status = ((StatusException) throwable).getStatus();
    }
    return status;
  }

  /** Determines whether we need to initiate a longer backoff due to system overload. */
  private static boolean isResourceExhaustedError(Throwable throwable) {
    return getStatus(throwable).getCode().equals(Code.RESOURCE_EXHAUSTED);
  };
}
