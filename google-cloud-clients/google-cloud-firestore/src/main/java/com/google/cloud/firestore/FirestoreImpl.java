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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.DatabaseRootName;
import com.google.protobuf.ByteString;
import io.grpc.Context;
import io.grpc.Status;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Main implementation of the Firestore client. This is the entry point for all Firestore
 * operations.
 */
class FirestoreImpl implements Firestore {

  private static final Random RANDOM = new Random();
  private static final int AUTO_ID_LENGTH = 20;
  private static final String AUTO_ID_ALPHABET =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private static final Logger LOGGER = Logger.getLogger("Firestore");
  private static final Tracer tracer = Tracing.getTracer();
  private static final io.opencensus.trace.Status TOO_MANY_RETRIES_STATUS =
      io.opencensus.trace.Status.ABORTED.withDescription("too many retries");

  private final FirestoreRpc firestoreClient;
  private final FirestoreOptions firestoreOptions;
  private final ResourcePath databasePath;

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

    if (!options.areTimestampsInSnapshotsEnabled()) {
      LOGGER.warning(
          "The behavior for java.util.Date objects stored in Firestore is going to change "
              + "AND YOUR APP MAY BREAK.\n"
              + "To hide this warning and ensure your app does not break, you need to add "
              + "the following code to your app before calling any other Cloud Firestore "
              + "methods:\n"
              + "\n"
              + "FirestoreOptions options = \n"
              + "  FirestoreOptions.newBuilder().setTimestampsInSnapshotsEnabled(true).build();\n"
              + "Firestore firestore = options.getService();\n"
              + "\n"
              + "With this change, timestamps stored in Cloud Firestore will be read back as "
              + "com.google.cloud.Timestamp objects instead of as system java.util.Date "
              + "objects. So you will also need to update code expecting a java.util.Date to "
              + "instead expect a Timestamp. For example:\n"
              + "\n"
              + "// Old:\n"
              + "java.util.Date date = (java.util.Date) snapshot.get(\"created_at\");\n"
              + "// New:\n"
              + "Timestamp timestamp = (Timestamp) snapshot.get(\"created_at\");\n"
              + "java.util.Date date = timestamp.toDate();\n"
              + "\n"
              + "Please audit all existing usages of java.util.Date when you enable the new "
              + "behavior. In a future release, the behavior will be changed to the new "
              + "behavior, so if you do not follow these steps, YOUR APP MAY BREAK.");
    }
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
  @Override
  public CollectionReference collection(@Nonnull String collectionPath) {
    return new CollectionReference(this, databasePath.append(collectionPath));
  }

  @Nonnull
  @Override
  public DocumentReference document(@Nonnull String documentPath) {
    ResourcePath document = databasePath.append(documentPath);
    Preconditions.checkArgument(
        document.isDocument(),
        String.format("Path should point to a Document Reference: %s", documentPath));
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
  public Iterable<CollectionReference> getCollections() {
    return listCollections();
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference... documentReferences) {
    return this.getAll(documentReferences, null, null);
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask) {
    return this.getAll(documentReferences, fieldMask, null);
  }

  /** Internal getAll() method that accepts an optional transaction id. */
  ApiFuture<List<DocumentSnapshot>> getAll(
      final DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      @Nullable ByteString transactionId) {
    final SettableApiFuture<List<DocumentSnapshot>> futureList = SettableApiFuture.create();
    final Map<DocumentReference, DocumentSnapshot> resultMap = new HashMap<>();

    ApiStreamObserver<BatchGetDocumentsResponse> responseObserver =
        new ApiStreamObserver<BatchGetDocumentsResponse>() {
          int numResponses;

          @Override
          public void onNext(BatchGetDocumentsResponse response) {
            DocumentReference documentReference;
            DocumentSnapshot documentSnapshot;

            numResponses++;
            if (numResponses == 1) {
              tracer.getCurrentSpan().addAnnotation("Firestore.BatchGet: First response");
            } else if (numResponses % 100 == 0) {
              tracer.getCurrentSpan().addAnnotation("Firestore.BatchGet: Received 100 responses");
            }

            switch (response.getResultCase()) {
              case FOUND:
                documentReference =
                    new DocumentReference(
                        FirestoreImpl.this, ResourcePath.create(response.getFound().getName()));
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

            resultMap.put(documentReference, documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            tracer.getCurrentSpan().addAnnotation("Firestore.BatchGet: Error");
            futureList.setException(throwable);
          }

          @Override
          public void onCompleted() {
            tracer.getCurrentSpan().addAnnotation("Firestore.BatchGet: Complete");
            List<DocumentSnapshot> documentSnapshots = new ArrayList<>();

            for (DocumentReference documentReference : documentReferences) {
              documentSnapshots.add(resultMap.get(documentReference));
            }

            futureList.set(documentSnapshots);
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

    for (DocumentReference docRef : documentReferences) {
      request.addDocuments(docRef.getName());
    }

    tracer
        .getCurrentSpan()
        .addAnnotation(
            "Firestore.BatchGet: Start",
            ImmutableMap.of(
                "numDocuments", AttributeValue.longAttributeValue(documentReferences.length)));

    streamRequest(request.build(), responseObserver, firestoreClient.batchGetDocumentsCallable());

    return futureList;
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runTransaction(@Nonnull final Transaction.Function<T> updateFunction) {
    return runTransaction(updateFunction, TransactionOptions.create());
  }

  @Nonnull
  @Override
  public <T> ApiFuture<T> runTransaction(
      @Nonnull final Transaction.Function<T> updateFunction,
      @Nonnull TransactionOptions transactionOptions) {
    SettableApiFuture<T> resultFuture = SettableApiFuture.create();
    runTransaction(updateFunction, resultFuture, transactionOptions);
    return resultFuture;
  }

  /** Transaction functions that returns its result in the provided SettableFuture. */
  private <T> void runTransaction(
      final Transaction.Function<T> transactionCallback,
      final SettableApiFuture<T> resultFuture,
      final TransactionOptions options) {
    // span is intentionally not ended here. It will be ended by runTransactionAttempt on success
    // or error.
    Span span = tracer.spanBuilder("CloudFirestore.Transaction").startSpan();
    try (Scope s = tracer.withSpan(span)) {
      runTransactionAttempt(transactionCallback, resultFuture, options, span);
    }
  }

  private <T> void runTransactionAttempt(
      final Transaction.Function<T> transactionCallback,
      final SettableApiFuture<T> resultFuture,
      final TransactionOptions options,
      final Span span) {
    final Transaction transaction = new Transaction(this, options.getPreviousTransactionId());
    final Executor userCallbackExecutor =
        Context.currentContextExecutor(
            options.getExecutor() != null ? options.getExecutor() : firestoreClient.getExecutor());

    final int attemptsRemaining = options.getNumberOfAttempts() - 1;
    span.addAnnotation(
        "Start runTransaction",
        ImmutableMap.of("attemptsRemaining", AttributeValue.longAttributeValue(attemptsRemaining)));

    ApiFutures.addCallback(
        transaction.begin(),
        new ApiFutureCallback<Void>() {
          @Override
          public void onFailure(Throwable throwable) {
            // Don't retry failed BeginTransaction requests.
            rejectTransaction(throwable);
          }

          @Override
          public void onSuccess(Void ignored) {
            ApiFutures.addCallback(
                invokeUserCallback(),
                new ApiFutureCallback<T>() {
                  @Override
                  public void onFailure(Throwable throwable) {
                    // This was a error in the user callback, forward the throwable.
                    rejectTransaction(throwable);
                  }

                  @Override
                  public void onSuccess(final T userResult) {
                    // Commit the transaction
                    ApiFutures.addCallback(
                        transaction.commit(),
                        new ApiFutureCallback<List<WriteResult>>() {
                          @Override
                          public void onFailure(Throwable throwable) {
                            // Retry failed commits.
                            maybeRetry();
                          }

                          @Override
                          public void onSuccess(List<WriteResult> writeResults) {
                            span.setStatus(io.opencensus.trace.Status.OK);
                            span.end();
                            resultFuture.set(userResult);
                          }
                        });
                  }
                });
          }

          private SettableApiFuture<T> invokeUserCallback() {
            // Execute the user callback on the provided executor.
            final SettableApiFuture<T> callbackResult = SettableApiFuture.create();
            userCallbackExecutor.execute(
                new Runnable() {
                  @Override
                  public void run() {
                    try {
                      callbackResult.set(transactionCallback.updateCallback(transaction));
                    } catch (Throwable t) {
                      callbackResult.setException(t);
                    }
                  }
                });
            return callbackResult;
          }

          private void maybeRetry() {
            if (attemptsRemaining > 0) {
              span.addAnnotation("retrying");
              runTransactionAttempt(
                  transactionCallback,
                  resultFuture,
                  new TransactionOptions(
                      attemptsRemaining, options.getExecutor(), transaction.getTransactionId()),
                  span);
            } else {
              span.setStatus(TOO_MANY_RETRIES_STATUS);
              rejectTransaction(
                  FirestoreException.serverRejected(
                      Status.ABORTED, "Transaction was cancelled because of too many retries."));
            }
          }

          private void rejectTransaction(final Throwable throwable) {
            if (throwable instanceof ApiException) {
              span.setStatus(TraceUtil.statusFromApiException((ApiException) throwable));
            }
            span.end();
            if (transaction.isPending()) {
              ApiFutures.addCallback(
                  transaction.rollback(),
                  new ApiFutureCallback<Void>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                      resultFuture.setException(throwable);
                    }

                    @Override
                    public void onSuccess(Void ignored) {
                      resultFuture.setException(throwable);
                    }
                  });
            } else {
              resultFuture.setException(throwable);
            }
          }
        });
  }

  /** Returns whether the user has opted into receiving dates as com.google.cloud.Timestamp. */
  boolean areTimestampsInSnapshotsEnabled() {
    return this.firestoreOptions.areTimestampsInSnapshotsEnabled();
  }

  /** Returns the name of the Firestore project associated with this client. */
  String getDatabaseName() {
    return databasePath.toString();
  }

  /** Returns the underlying RPC client. */
  FirestoreRpc getClient() {
    return firestoreClient;
  }

  /** Request funnel for all read/write requests. */
  <RequestT, ResponseT> ApiFuture<ResponseT> sendRequest(
      RequestT requestT, UnaryCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    return callable.futureCall(requestT);
  }

  /** Request funnel for all unidirectional streaming requests. */
  <RequestT, ResponseT> void streamRequest(
      RequestT requestT,
      ApiStreamObserver<ResponseT> responseObserverT,
      ServerStreamingCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    callable.serverStreamingCall(requestT, responseObserverT);
  }

  /** Request funnel for all bidirectional streaming requests. */
  <RequestT, ResponseT> ApiStreamObserver<RequestT> streamRequest(
      ApiStreamObserver<ResponseT> responseObserverT,
      BidiStreamingCallable<RequestT, ResponseT> callable) {
    Preconditions.checkState(!closed, "Firestore client has already been closed");
    return callable.bidiStreamingCall(responseObserverT);
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
}
