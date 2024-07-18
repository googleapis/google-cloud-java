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

import static com.google.cloud.firestore.telemetry.TraceUtil.*;

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.NanoClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.DatabaseRootName;
import com.google.protobuf.ByteString;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Main implementation of the Firestore client. This is the entry point for all Firestore
 * operations.
 */
class FirestoreImpl implements Firestore, FirestoreRpcContext<FirestoreImpl> {

  private static final Random RANDOM = new SecureRandom();
  private static final int AUTO_ID_LENGTH = 20;
  private static final String AUTO_ID_ALPHABET =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private final FirestoreRpc firestoreClient;
  private final FirestoreOptions firestoreOptions;
  private final ResourcePath databasePath;

  /**
   * A lazy-loaded BulkWriter instance to be used with recursiveDelete() if no BulkWriter instance
   * is provided.
   */
  @Nullable private BulkWriter bulkWriterInstance;

  private boolean closed;

  FirestoreImpl(FirestoreOptions options) {
    this(options, options.getFirestoreRpc());
  }

  FirestoreImpl(FirestoreOptions options, FirestoreRpc firestoreRpc) {
    this.firestoreClient = firestoreRpc;
    this.firestoreOptions = options;
    Preconditions.checkNotNull(
        options.getProjectId(),
        "Failed to detect Project ID. "
            + "Please explicitly set your Project ID in FirestoreOptions.");
    this.databasePath =
        ResourcePath.create(DatabaseRootName.of(options.getProjectId(), options.getDatabaseId()));
  }

  /** Gets the TraceUtil object associated with this Firestore instance. */
  @Nonnull
  private TraceUtil getTraceUtil() {
    return getOptions().getTraceUtil();
  }

  /** Lazy-load the Firestore's default BulkWriter. */
  private BulkWriter getBulkWriter() {
    if (bulkWriterInstance == null) {
      bulkWriterInstance = bulkWriter();
    }
    return bulkWriterInstance;
  }

  /** Creates a pseudo-random 20-character ID that can be used for Firestore documents. */
  static String autoId() {
    StringBuilder builder = new StringBuilder();
    int maxRandom = AUTO_ID_ALPHABET.length();
    for (int i = 0; i < AUTO_ID_LENGTH; i++) {
      builder.append(AUTO_ID_ALPHABET.charAt(RANDOM.nextInt(maxRandom)));
    }
    return builder.toString();
  }

  @Nonnull
  @Override
  public WriteBatch batch() {
    return new WriteBatch(this);
  }

  @Nonnull
  public BulkWriter bulkWriter() {
    return new BulkWriter(this, BulkWriterOptions.builder().setThrottlingEnabled(true).build());
  }

  @Nonnull
  public BulkWriter bulkWriter(BulkWriterOptions options) {
    return new BulkWriter(this, options);
  }

  @Nonnull
  public ApiFuture<Void> recursiveDelete(CollectionReference reference) {
    BulkWriter writer = getBulkWriter();
    return recursiveDelete(reference.getResourcePath(), writer);
  }

  @Nonnull
  public ApiFuture<Void> recursiveDelete(CollectionReference reference, BulkWriter bulkWriter) {
    return recursiveDelete(reference.getResourcePath(), bulkWriter);
  }

  @Nonnull
  public ApiFuture<Void> recursiveDelete(DocumentReference reference) {
    BulkWriter writer = getBulkWriter();
    return recursiveDelete(reference.getResourcePath(), writer);
  }

  @Nonnull
  public ApiFuture<Void> recursiveDelete(
      DocumentReference reference, @Nonnull BulkWriter bulkWriter) {
    return recursiveDelete(reference.getResourcePath(), bulkWriter);
  }

  @Nonnull
  public ApiFuture<Void> recursiveDelete(ResourcePath path, BulkWriter bulkWriter) {
    return recursiveDelete(
        path, bulkWriter, RecursiveDelete.MAX_PENDING_OPS, RecursiveDelete.MIN_PENDING_OPS);
  }

  /**
   * This overload is not private in order to test the query resumption with startAfter() once the
   * RecursiveDelete instance has MAX_PENDING_OPS pending.
   */
  @Nonnull
  @VisibleForTesting
  ApiFuture<Void> recursiveDelete(
      ResourcePath path, @Nonnull BulkWriter bulkWriter, int maxLimit, int minLimit) {
    RecursiveDelete deleter = new RecursiveDelete(this, bulkWriter, path, maxLimit, minLimit);
    return deleter.run();
  }

  @Nonnull
  @Override
  public CollectionReference collection(@Nonnull String collectionPath) {
    ResourcePath path = databasePath.append(collectionPath);
    Preconditions.checkArgument(
        path.isCollection(), "Invalid path specified. Path should point to a collection");
    return new CollectionReference(this, path);
  }

  @Nonnull
  @Override
  public DocumentReference document(@Nonnull String documentPath) {
    ResourcePath document = databasePath.append(documentPath);
    Preconditions.checkArgument(
        document.isDocument(), "Path should point to a Document Reference: %s", documentPath);
    return new DocumentReference(this, document);
  }

  @Nonnull
  @Override
  public Iterable<CollectionReference> listCollections() {
    DocumentReference rootDocument = new DocumentReference(this, this.databasePath);
    return rootDocument.listCollections();
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference... documentReferences) {
    return this.getAll(documentReferences, null, (ByteString) null);
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask) {
    return this.getAll(documentReferences, fieldMask, (ByteString) null);
  }

  @Override
  public void getAll(
      final @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nonnull final ApiStreamObserver<DocumentSnapshot> apiStreamObserver) {
    this.getAll(documentReferences, fieldMask, null, null, apiStreamObserver);
  }

  void getAll(
      final @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nullable ByteString transactionId,
      @Nullable com.google.protobuf.Timestamp readTime,
      final ApiStreamObserver<DocumentSnapshot> apiStreamObserver) {
    // To reduce the size of traces, we only register one event for every 100 responses
    // that we receive from the server.
    final int NUM_RESPONSES_PER_TRACE_EVENT = 100;

    ResponseObserver<BatchGetDocumentsResponse> responseObserver =
        new ResponseObserver<BatchGetDocumentsResponse>() {
          int numResponses = 0;
          boolean hasCompleted = false;

          @Override
          public void onStart(StreamController streamController) {
            getTraceUtil()
                .currentSpan()
                .addEvent(
                    TraceUtil.SPAN_NAME_BATCH_GET_DOCUMENTS + ": Start",
                    new ImmutableMap.Builder<String, Object>()
                        .put(ATTRIBUTE_KEY_DOC_COUNT, documentReferences.length)
                        .put(ATTRIBUTE_KEY_IS_TRANSACTIONAL, transactionId != null)
                        .build());
          }

          @Override
          public void onResponse(BatchGetDocumentsResponse response) {
            DocumentReference documentReference;
            DocumentSnapshot documentSnapshot;

            numResponses++;
            if (numResponses == 1) {
              getTraceUtil()
                  .currentSpan()
                  .addEvent(TraceUtil.SPAN_NAME_BATCH_GET_DOCUMENTS + ": First response received");
            } else if (numResponses % NUM_RESPONSES_PER_TRACE_EVENT == 0) {
              getTraceUtil()
                  .currentSpan()
                  .addEvent(
                      TraceUtil.SPAN_NAME_BATCH_GET_DOCUMENTS
                          + ": Received "
                          + numResponses
                          + " responses");
            }

            switch (response.getResultCase()) {
              case FOUND:
                documentSnapshot =
                    DocumentSnapshot.fromDocument(
                        FirestoreImpl.this,
                        Timestamp.fromProto(response.getReadTime()),
                        response.getFound());
                break;
              case MISSING:
                documentReference =
                    new DocumentReference(
                        FirestoreImpl.this, ResourcePath.create(response.getMissing()));
                documentSnapshot =
                    DocumentSnapshot.fromMissing(
                        FirestoreImpl.this,
                        documentReference,
                        Timestamp.fromProto(response.getReadTime()));
                break;
              default:
                return;
            }
            apiStreamObserver.onNext(documentSnapshot);

            // Logical termination: if we have already received as many documents as we had
            // requested, we can
            // raise the results without waiting for the termination from the server.
            if (numResponses == documentReferences.length) {
              onComplete();
            }
          }

          @Override
          public void onError(Throwable throwable) {
            getTraceUtil().currentSpan().end(throwable);
            apiStreamObserver.onError(throwable);
          }

          @Override
          public void onComplete() {
            if (hasCompleted) return;
            hasCompleted = true;
            getTraceUtil()
                .currentSpan()
                .addEvent(
                    TraceUtil.SPAN_NAME_BATCH_GET_DOCUMENTS
                        + ": Completed with "
                        + numResponses
                        + " responses.",
                    Collections.singletonMap(ATTRIBUTE_KEY_NUM_RESPONSES, numResponses));
            apiStreamObserver.onCompleted();
          }
        };

    BatchGetDocumentsRequest.Builder request = BatchGetDocumentsRequest.newBuilder();
    request.setDatabase(getDatabaseName());

    if (fieldMask != null) {
      request.setMask(fieldMask.toPb());
    }

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    if (readTime != null) {
      request.setReadTime(readTime);
    }

    for (DocumentReference docRef : documentReferences) {
      request.addDocuments(docRef.getName());
    }

    streamRequest(request.build(), responseObserver, firestoreClient.batchGetDocumentsCallable());
  }

  final ApiFuture<List<DocumentSnapshot>> getAll(
      final @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nullable com.google.protobuf.Timestamp readTime) {
    return getAll(documentReferences, fieldMask, null, readTime);
  }

  private ApiFuture<List<DocumentSnapshot>> getAll(
      final @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nullable ByteString transactionId) {
    return getAll(documentReferences, fieldMask, transactionId, null);
  }

  /** Internal getAll() method that accepts an optional transaction id. */
  ApiFuture<List<DocumentSnapshot>> getAll(
      final @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nullable ByteString transactionId,
      @Nullable com.google.protobuf.Timestamp readTime) {
    final SettableApiFuture<List<DocumentSnapshot>> futureList = SettableApiFuture.create();
    final Map<DocumentReference, DocumentSnapshot> documentSnapshotMap = new HashMap<>();
    getAll(
        documentReferences,
        fieldMask,
        transactionId,
        readTime,
        new ApiStreamObserver<DocumentSnapshot>() {
          @Override
          public void onNext(DocumentSnapshot documentSnapshot) {
            documentSnapshotMap.put(documentSnapshot.getReference(), documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            futureList.setException(throwable);
          }

          @Override
          public void onCompleted() {
            List<DocumentSnapshot> documentSnapshotsList = new ArrayList<>();
            for (DocumentReference documentReference : documentReferences) {
              documentSnapshotsList.add(documentSnapshotMap.get(documentReference));
            }
            futureList.set(documentSnapshotsList);
          }
        });
    return futureList;
  }

  @Nonnull
  @Override
  public CollectionGroup collectionGroup(@Nonnull final String collectionId) {
    Preconditions.checkArgument(
        !collectionId.contains("/"),
        "Invalid collectionId '%s'. Collection IDs must not contain '/'.",
        collectionId);
    return new CollectionGroup(this, collectionId);
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runTransaction(@Nonnull final Transaction.Function<T> updateFunction) {
    return runAsyncTransaction(
        new TransactionAsyncAdapter<>(updateFunction), TransactionOptions.create());
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runTransaction(
      @Nonnull final Transaction.Function<T> updateFunction,
      @Nonnull TransactionOptions transactionOptions) {
    return runAsyncTransaction(new TransactionAsyncAdapter<>(updateFunction), transactionOptions);
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runAsyncTransaction(
      @Nonnull final Transaction.AsyncFunction<T> updateFunction) {
    return runAsyncTransaction(updateFunction, TransactionOptions.create());
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runAsyncTransaction(
      @Nonnull final Transaction.AsyncFunction<T> updateFunction,
      @Nonnull TransactionOptions transactionOptions) {

    if (transactionOptions.getReadTime() != null) {
      // READ_ONLY transactions with readTime have no retry, nor transaction state, so we don't need
      // a runner.
      return updateFunction.updateCallback(
          new ReadTimeTransaction(this, transactionOptions.getReadTime()));
    } else {
      // For READ_ONLY transactions without readTime, there is still strong consistency applied,
      // that cannot be tracked client side.
      return new ServerSideTransactionRunner<>(this, updateFunction, transactionOptions).run();
    }
  }

  @Nonnull
  @Override
  public FirestoreBundle.Builder bundleBuilder() {
    return bundleBuilder(null);
  }

  @Nonnull
  @Override
  public FirestoreBundle.Builder bundleBuilder(@Nullable String bundleId) {
    String id = bundleId == null ? autoId() : bundleId;
    return new FirestoreBundle.Builder(id);
  }

  /** Returns the name of the Firestore project associated with this client. */
  @Override
  public String getDatabaseName() {
    return databasePath.getDatabaseName().toString();
  }

  /** Returns a path to the Firestore project associated with this client. */
  @Override
  public ResourcePath getResourcePath() {
    return databasePath;
  }

  /** Returns the underlying RPC client. */
  @Override
  public FirestoreRpc getClient() {
    return firestoreClient;
  }

  @Override
  public Duration getTotalRequestTimeout() {
    return firestoreOptions.getRetrySettings().getTotalTimeout();
  }

  @Override
  public ApiClock getClock() {
    return NanoClock.getDefaultClock();
  }

  /** Request funnel for all read/write requests. */
  @Override
  public <RequestT, ResponseT> ApiFuture<ResponseT> sendRequest(
      RequestT requestT, UnaryCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    return callable.futureCall(requestT);
  }

  /** Request funnel for all unidirectional streaming requests. */
  @Override
  public <RequestT, ResponseT> void streamRequest(
      RequestT requestT,
      ResponseObserver<ResponseT> responseObserverT,
      ServerStreamingCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    callable.call(requestT, responseObserverT);
  }

  /** Request funnel for all bidirectional streaming requests. */
  @Override
  public <RequestT, ResponseT> ClientStream<RequestT> streamRequest(
      BidiStreamObserver<RequestT, ResponseT> responseObserverT,
      BidiStreamingCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    return callable.splitCall(responseObserverT);
  }

  @Override
  public FirestoreImpl getFirestore() {
    return this;
  }

  @Override
  public FirestoreOptions getOptions() {
    return firestoreOptions;
  }

  @Override
  public void close() throws Exception {
    firestoreClient.close();
    closed = true;
  }

  @Override
  public void shutdown() {
    firestoreClient.shutdown();
    closed = true;
  }

  @Override
  public void shutdownNow() {
    firestoreClient.shutdownNow();
    closed = true;
  }

  private static class TransactionAsyncAdapter<T> implements Transaction.AsyncFunction<T> {
    private final Transaction.Function<T> syncFunction;

    public TransactionAsyncAdapter(Transaction.Function<T> syncFunction) {
      this.syncFunction = syncFunction;
    }

    @Override
    public ApiFuture<T> updateCallback(Transaction transaction) {
      SettableApiFuture<T> callbackResult = SettableApiFuture.create();
      try {
        callbackResult.set(syncFunction.updateCallback(transaction));
      } catch (Throwable e) {
        callbackResult.setException(e);
      }
      return callbackResult;
    }
  }
}
