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
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1beta1.FirestoreRpc;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.DatabaseRootName;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * Main implementation of the Firestore client. This is the entry point for all Firestore
 * operations.
 */
class FirestoreImpl implements Firestore {

  private static final Random RANDOM = new Random();
  private static final int AUTO_ID_LENGTH = 20;
  private static final String AUTO_ID_ALPHABET =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

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
  public Iterable<CollectionReference> getCollections() {
    DocumentReference rootDocument = new DocumentReference(this, this.databasePath);
    return rootDocument.getCollections();
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(final DocumentReference... documentReferences) {
    return this.getAll(documentReferences, null);
  }

  /** Internal getAll() method that accepts an optional transaction id. */
  ApiFuture<List<DocumentSnapshot>> getAll(
      final DocumentReference[] documentReferences, @Nullable ByteString transactionId) {
    final SettableApiFuture<List<DocumentSnapshot>> futureList = SettableApiFuture.create();
    final Map<DocumentReference, DocumentSnapshot> resultMap = new HashMap<>();

    ApiStreamObserver<BatchGetDocumentsResponse> responseObserver =
        new ApiStreamObserver<BatchGetDocumentsResponse>() {
          @Override
          public void onNext(BatchGetDocumentsResponse response) {
            DocumentReference documentReference;
            DocumentSnapshot documentSnapshot;

            switch (response.getResultCase()) {
              case FOUND:
                documentReference =
                    new DocumentReference(
                        FirestoreImpl.this, ResourcePath.create(response.getFound().getName()));
                documentSnapshot =
                    DocumentSnapshot.fromDocument(
                        FirestoreImpl.this, response.getReadTime(), response.getFound());
                break;
              case MISSING:
                documentReference =
                    new DocumentReference(
                        FirestoreImpl.this, ResourcePath.create(response.getMissing()));
                documentSnapshot =
                    DocumentSnapshot.fromMissing(
                        FirestoreImpl.this,
                        documentReference,
                        Instant.ofEpochSecond(
                            response.getReadTime().getSeconds(),
                            response.getReadTime().getNanos()));
                break;
              default:
                return;
            }

            resultMap.put(documentReference, documentSnapshot);
          }

          @Override
          public void onError(Throwable throwable) {
            futureList.setException(throwable);
          }

          @Override
          public void onCompleted() {
            List<DocumentSnapshot> documentSnapshots = new ArrayList<>();

            for (DocumentReference documentReference : documentReferences) {
              documentSnapshots.add(resultMap.get(documentReference));
            }

            futureList.set(documentSnapshots);
          }
        };

    BatchGetDocumentsRequest.Builder request = BatchGetDocumentsRequest.newBuilder();
    request.setDatabase(getDatabaseName());

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    for (DocumentReference docRef : documentReferences) {
      request.addDocuments(docRef.getName());
    }

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
    final Transaction transaction = new Transaction(this, options.getPreviousTransactionId());
    final Executor userCallbackExecutor =
        options.getExecutor() != null ? options.getExecutor() : firestoreClient.getExecutor();

    final int attemptsRemaining = options.getNumberOfAttempts() - 1;

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
                    } catch (Exception e) {
                      callbackResult.setException(e);
                    }
                  }
                });
            return callbackResult;
          }

          private void maybeRetry() {
            if (attemptsRemaining > 0) {
              runTransaction(
                  transactionCallback,
                  resultFuture,
                  new TransactionOptions(
                      attemptsRemaining, options.getExecutor(), transaction.getTransactionId()));
            } else {
              rejectTransaction(
                  FirestoreException.serverRejected(
                      Status.ABORTED, "Transaction was cancelled because of too many retries."));
            }
          }

          private void rejectTransaction(final Throwable throwable) {
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
