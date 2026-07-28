/*
 * Copyright 2021 Google LLC
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

import com.google.api.core.ApiAsyncFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.Query.QueryOptions;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * Class used to store state required for running a recursive delete operation. Each recursive
 * delete call should use a new instance of the class.
 */
@BetaApi
public final class RecursiveDelete {
  /**
   * Datastore allowed numeric IDs where Firestore only allows strings. Numeric IDs are exposed to
   * Firestore as __idNUM__, so this is the lowest possible negative numeric value expressed in that
   * format.
   *
   * <p>This constant is used to specify startAt/endAt values when querying for all descendants in a
   * single collection.
   */
  public static final String REFERENCE_NAME_MIN_ID = "__id-9223372036854775808__";

  /**
   * The query limit used for recursive deletes when fetching all descendants of the specified
   * reference to delete. This is done to prevent the query stream from streaming documents faster
   * than Firestore can delete.
   */
  public static final int MAX_PENDING_OPS = 5000;

  /**
   * The number of pending BulkWriter operations at which RecursiveDelete starts the next limit
   * query to fetch descendants. By starting the query while there are pending operations, Firestore
   * can improve BulkWriter throughput. This helps prevent BulkWriter from idling while Firestore
   * fetches the next query.
   */
  public static final int MIN_PENDING_OPS = 1000;

  private final FirestoreRpcContext<?> firestoreRpcContext;
  private final BulkWriter writer;

  /** The resource path of the reference to recursively delete */
  private final ResourcePath path;

  /** Lock object for all BulkWriter operations and callbacks. */
  private final Object lock = new Object();

  /** The number of deletes that failed with a permanent error. */
  @GuardedBy("lock")
  private int errorCount = 0;

  /**
   * The most recently thrown error. Used to populate the developer-facing error message when the
   * recursive delete operation completes.
   */
  @GuardedBy("lock")
  @Nullable
  private Throwable lastError;

  /** Whether there are still documents to delete that still need to be fetched. */
  @GuardedBy("lock")
  private boolean documentsPending = true;

  /** A deferred promise that resolves when the recursive delete operation is completed. */
  private final SettableApiFuture<Void> completionFuture = SettableApiFuture.create();

  /** Whether a query stream is currently in progress. Only one stream can be run at a time. */
  @GuardedBy("lock")
  private boolean streamInProgress = false;

  /** Whether run() has been called. */
  private boolean started = false;

  /** Query limit to use when fetching all descendants. */
  private final int maxPendingOps;

  /**
   * The number of pending BulkWriter operations at which RecursiveDelete starts the next limit
   * query to fetch descendants.
   */
  private final int minPendingOps;

  /**
   * The last document snapshot returned by the stream. Used to set the startAfter() field in the
   * subsequent stream.
   */
  @Nullable private DocumentSnapshot lastDocumentSnap;

  /**
   * The number of pending BulkWriter operations. Used to determine when the next query can be run.
   */
  private int pendingOperationsCount = 0;

  RecursiveDelete(
      FirestoreRpcContext<?> firestoreRpcContext,
      BulkWriter writer,
      ResourcePath path,
      int maxLimit,
      int minLimit) {
    this.firestoreRpcContext = firestoreRpcContext;
    this.writer = writer;
    this.path = path;
    this.maxPendingOps = maxLimit;
    this.minPendingOps = minLimit;
  }

  public ApiFuture<Void> run() {
    Preconditions.checkState(!started, "RecursiveDelete.run() should only be called once");
    started = true;

    writer.verifyNotClosed();

    streamDescendants();
    return completionFuture;
  }

  private void streamDescendants() {
    Query query = getAllDescendantsQuery();
    synchronized (lock) {
      streamInProgress = true;
    }
    final int[] streamedDocsCount = {0};
    final ApiStreamObserver<DocumentSnapshot> responseObserver =
        new ApiStreamObserver<DocumentSnapshot>() {
          public void onNext(DocumentSnapshot snapshot) {
            streamedDocsCount[0]++;
            lastDocumentSnap = snapshot;
            deleteReference(snapshot.getReference());
          }

          public void onError(Throwable throwable) {
            String message = "Failed to fetch children documents";
            synchronized (lock) {
              lastError =
                  FirestoreException.forServerRejection(Status.UNAVAILABLE, throwable, message);
            }
            onQueryEnd();
          }

          public void onCompleted() {
            synchronized (lock) {
              streamInProgress = false;
            }
            // If there are fewer than the number of documents specified in the limit() field, we
            // know that the query is complete.
            if (streamedDocsCount[0] < maxPendingOps) {
              onQueryEnd();
            } else if (pendingOperationsCount == 0) {
              // Start a new stream if all documents from this stream were deleted before the
              // `onCompleted()` handler was called.
              streamDescendants();
            }
          }
        };

    query.stream(responseObserver);
  }

  private Query getAllDescendantsQuery() {
    ResourcePath parentPath;
    String collectionId;
    if (path.isDocument()) {
      // The parent is the closest ancestor document to the location we're deleting. Since we are
      // deleting a document, the parent is the path of that document.
      parentPath = path;
      Preconditions.checkState(
          path.getParent() != null, "Parent of a document should not be null.");
      collectionId = path.getParent().getId();
    } else {
      // The parent is the closest ancestor document to the location we're deleting. Since we are
      // deleting a collection, the parent is the path of the document containing that collection
      // (or the database root, if it is a root collection).
      parentPath = path.popLast();
      collectionId = path.getId();
    }

    Query query =
        new Query(
            firestoreRpcContext,
            QueryOptions.builder()
                .setParentPath(parentPath)
                .setCollectionId(collectionId)
                .setAllDescendants(true)
                .setKindless(true)
                .setRequireConsistency(false)
                .build());

    // Query for names only to fetch empty snapshots.
    query = query.select(FieldPath.documentId()).limit(maxPendingOps);

    // To find all descendants of a collection reference, we need to use a
    // composite filter that captures all documents that start with the
    // collection prefix. The MIN_ID constant represents the minimum key in
    // this collection, and a null byte + the MIN_ID represents the minimum
    // key is the next possible collection.
    if (path.isCollection()) {
      char nullChar = '\0';
      String startAt = collectionId + "/" + REFERENCE_NAME_MIN_ID;
      String endAt = collectionId + nullChar + "/" + REFERENCE_NAME_MIN_ID;
      query =
          query
              .whereGreaterThanOrEqualTo(FieldPath.documentId(), startAt)
              .whereLessThan(FieldPath.documentId(), endAt);
    }

    // startAfter() needs to be added after the where() filters since it creates an implicit
    // orderBy.
    if (lastDocumentSnap != null) {
      query = query.startAfter(lastDocumentSnap);
    }

    return query;
  }

  /**
   * Called when all descendants of the provided reference have been streamed or if a permanent
   * error occurs during the stream. Deletes the developer provided reference and wraps any errors
   * that occurred.
   */
  private void onQueryEnd() {
    synchronized (lock) {
      documentsPending = false;
    }

    // Used to aggregate flushFuture and deleteFuture to use with ApiFutures.allAsList(), in order
    // to ensure that the delete catchingAsync() callback is run before the flushFuture callback.
    List<ApiFuture<Void>> pendingFutures = new ArrayList<>();

    // Delete the provided document reference if one was provided.
    if (path.isDocument()) {
      pendingFutures.add(deleteReference(new DocumentReference(firestoreRpcContext, path)));
    }

    pendingFutures.add(writer.flush());

    // Completes the future returned by run() and sets the exception if an error occurred.
    ApiFutures.transformAsync(
        ApiFutures.allAsList(pendingFutures),
        (ApiAsyncFunction<List<Void>, Void>)
            unused -> {
              synchronized (lock) {
                if (lastError == null) {
                  completionFuture.set(null);
                } else {
                  String message =
                      errorCount
                          + (errorCount != 1 ? " deletes" : " delete")
                          + " failed. "
                          + lastError.getMessage();
                  if (lastError instanceof FirestoreException) {
                    lastError =
                        new FirestoreException(
                            message, ((FirestoreException) lastError).getStatus());
                  } else {
                    lastError = new Throwable(message, lastError);
                  }
                  completionFuture.setException(lastError);
                }
                return ApiFutures.immediateFuture(null);
              }
            },
        MoreExecutors.directExecutor());
  }

  /** Deletes the provided reference and starts the next stream if conditions are met. */
  private ApiFuture<Void> deleteReference(final DocumentReference reference) {
    synchronized (lock) {
      pendingOperationsCount++;
    }

    ApiFuture<WriteResult> catchingDeleteFuture =
        ApiFutures.catchingAsync(
            writer.delete(reference),
            Throwable.class,
            e -> {
              synchronized (lock) {
                errorCount++;
                lastError = e;
                return ApiFutures.immediateFuture(null);
              }
            },
            MoreExecutors.directExecutor());

    return ApiFutures.transformAsync(
        catchingDeleteFuture,
        result -> {
          synchronized (lock) {
            pendingOperationsCount--;
            // We wait until the previous stream has ended in order to ensure the
            // startAfter document is correct. Starting the next stream while
            // there are pending operations allows Firestore to maximize
            // BulkWriter throughput.
            if (documentsPending && !streamInProgress && pendingOperationsCount < minPendingOps) {
              streamDescendants();
            }
            return ApiFutures.immediateFuture(null);
          }
        },
        MoreExecutors.directExecutor());
  }
}
