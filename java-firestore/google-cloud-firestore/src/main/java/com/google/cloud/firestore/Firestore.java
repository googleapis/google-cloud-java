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
import com.google.api.core.BetaApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.Service;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Represents a Firestore Database and is the entry point for all Firestore operations */
@InternalExtensionOnly
public interface Firestore extends Service<FirestoreOptions>, AutoCloseable {

  /**
   * Gets a {@link CollectionReference} that refers to the collection at the specified path.
   *
   * @param path A slash-separated path to a collection.
   * @return The CollectionReference instance.
   */
  @Nonnull
  CollectionReference collection(@Nonnull String path);

  /**
   * Gets a {@link DocumentReference} that refers to the document at the specified path.
   *
   * @param path A slash-separated path to a document.
   * @return The DocumentReference instance.
   */
  @Nonnull
  DocumentReference document(@Nonnull String path);

  /**
   * Fetches the root collections that are associated with this Firestore database.
   *
   * @throws FirestoreException if the Iterable could not be initialized.
   * @return An Iterable that can be used to fetch all collections.
   */
  @Nonnull
  Iterable<CollectionReference> listCollections();

  /**
   * Creates and returns a new {@link CollectionGroup} that includes all documents in the database
   * that are contained in a collection or subcollection with the given @code{collectionId}.
   *
   * @param collectionId Identifies the collections to query over. Every collection or subcollection
   *     with this ID as the last segment of its path will be included. Cannot contain a slash.
   * @return The created Query.
   */
  CollectionGroup collectionGroup(@Nonnull String collectionId);

  /**
   * Creates a new {@link PipelineSource} to build and execute a data pipeline.
   *
   * <p>A pipeline is composed of a sequence of stages. Each stage processes the output from the
   * previous one, and the final stage's output is the result of the pipeline's execution.
   *
   * <p><b>Example usage:</b>
   *
   * <pre>{@code
   * Pipeline pipeline = firestore.pipeline()
   * .collection("books")
   * .where(Field("rating").isGreaterThan(4.5))
   * .sort(Field("rating").descending())
   * .limit(2);
   * }</pre>
   *
   * <p><b>Note on Execution:</b> The stages are conceptual. The Firestore backend may optimize
   * execution (e.g., reordering or merging stages) as long as the final result remains the same.
   *
   * <p><b>Important Limitations:</b>
   *
   * <ul>
   *   <li>Pipelines operate on a <b>request/response basis only</b>.
   *   <li>They do <b>not</b> utilize or update the local SDK cache.
   *   <li>They do <b>not</b> support realtime snapshot listeners.
   * </ul>
   *
   * @return A {@code PipelineSource} to begin defining the pipeline's stages.
   */
  PipelineSource pipeline();

  /**
   * Executes the given updateFunction and then attempts to commit the changes applied within the
   * transaction. If any document read within the transaction has changed, the updateFunction will
   * be retried. If it fails to commit after 5 attempts, the transaction will fail.
   *
   * @param updateFunction The function to execute within the transaction context.
   * @return An ApiFuture that will be resolved with the result from updateFunction.
   */
  @Nonnull
  <T> ApiFuture<T> runTransaction(@Nonnull final Transaction.Function<T> updateFunction);

  /**
   * Executes the given updateFunction and then attempts to commit the changes applied within the
   * transaction. If any document read within the transaction has changed, the updateFunction will
   * be retried. If it fails to commit after the maxmimum number of attemps specified in
   * transactionOptions, the transaction will fail.
   *
   * @param updateFunction The function to execute within the transaction context.
   * @return An ApiFuture that will be resolved with the result from updateFunction.
   */
  @Nonnull
  <T> ApiFuture<T> runTransaction(
      @Nonnull final Transaction.Function<T> updateFunction,
      @Nonnull TransactionOptions transactionOptions);

  /**
   * Executes the given updateFunction and then attempts to commit the changes applied within the
   * transaction. If any document read within the transaction has changed, the updateFunction will
   * be retried. If it fails to commit after 5 attempts, the transaction will fail. <br>
   * <br>
   * Running a transaction places locks all consumed documents. To unblock other clients, the
   * Firestore backend automatically releases all locks after 60 seconds of inactivity and fails all
   * transactions that last longer than 270 seconds (see <a
   * href="https://firebase.google.com/docs/firestore/quotas#writes_and_transactions">Firestore
   * Quotas</a>).
   *
   * @param updateFunction The function to execute within the transaction context.
   * @return An ApiFuture that will be resolved with the result from updateFunction.
   */
  @Nonnull
  <T> ApiFuture<T> runAsyncTransaction(@Nonnull final Transaction.AsyncFunction<T> updateFunction);

  /**
   * Executes the given updateFunction and then attempts to commit the changes applied within the
   * transaction. If any document read within the transaction has changed, the updateFunction will
   * be retried. If it fails to commit after the maxmimum number of attemps specified in
   * transactionOptions, the transaction will fail. <br>
   * <br>
   * Running a transaction places locks all consumed documents. To unblock other clients, the
   * Firestore backend automatically releases all locks after 60 seconds of inactivity and fails all
   * transactions that last longer than 270 seconds (see <a
   * href="https://firebase.google.com/docs/firestore/quotas#writes_and_transactions">Firestore
   * Quotas</a>).
   *
   * @param updateFunction The function to execute within the transaction context.
   * @return An ApiFuture that will be resolved with the result from updateFunction.
   */
  @Nonnull
  <T> ApiFuture<T> runAsyncTransaction(
      @Nonnull final Transaction.AsyncFunction<T> updateFunction,
      @Nonnull TransactionOptions transactionOptions);

  /**
   * Retrieves multiple documents from Firestore.
   *
   * @param documentReferences List of Document References to fetch.
   */
  @Nonnull
  ApiFuture<List<DocumentSnapshot>> getAll(@Nonnull DocumentReference... documentReferences);

  /**
   * Retrieves multiple documents from Firestore, while optionally applying a field mask to reduce
   * the amount of data transmitted.
   *
   * @param documentReferences Array with Document References to fetch.
   * @param fieldMask If set, specifies the subset of fields to return.
   */
  @Nonnull
  ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask);

  /**
   * Retrieves multiple documents from Firestore while optionally applying a field mask to reduce
   * the amount of data transmitted. Returned documents will be out of order.
   *
   * @param documentReferences Array with Document References to fetch.
   * @param fieldMask If not null, specifies the subset of fields to return.
   * @param responseObserver The observer to be notified when {@link DocumentSnapshot} details
   *     arrive.
   */
  void getAll(
      @Nonnull DocumentReference[] documentReferences,
      @Nullable FieldMask fieldMask,
      final ApiStreamObserver<DocumentSnapshot> responseObserver);

  /**
   * Gets a Firestore {@link WriteBatch} instance that can be used to combine multiple writes.
   *
   * @return A WriteBatch that operates on this Firestore client.
   */
  @Nonnull
  WriteBatch batch();

  /**
   * Creates a {@link BulkWriter} instance, used for performing multiple writes in parallel.
   * Gradually ramps up writes as specified by the 500/50/5 rule.
   *
   * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping
   *     up traffic</a>
   */
  @Nonnull
  BulkWriter bulkWriter();

  /**
   * Creates a {@link BulkWriter} instance, used for performing multiple writes in parallel.
   * Gradually ramps up writes as specified by the 500/50/5 rule unless otherwise configured by a
   * BulkWriterOptions object.
   *
   * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping
   *     up traffic</a>
   * @param options An options object to configure BulkWriter.
   */
  @Nonnull
  BulkWriter bulkWriter(BulkWriterOptions options);

  /**
   * Recursively deletes all documents and subcollections at and under the specified level.
   *
   * <p>If any delete fails, the ApiFuture contains an error with an error message containing the
   * number of failed deletes and the stack trace of the last failed delete. The provided reference
   * is deleted regardless of whether all deletes succeeded.
   *
   * <p>recursiveDelete() uses a {@link BulkWriter} instance with default settings to perform the
   * deletes. To customize throttling rates or add success/error callbacks, pass in a custom
   * BulkWriter instance.
   *
   * @param reference The reference of the collection to delete.
   * @return An ApiFuture that completes when all deletes have been performed. The future fails with
   *     an error if any of the deletes fail.
   */
  @BetaApi
  @Nonnull
  ApiFuture<Void> recursiveDelete(CollectionReference reference);

  /**
   * Recursively deletes all documents and subcollections at and under the specified level.
   *
   * <p>If any delete fails, the ApiFuture contains an error with an error message containing the
   * number of failed deletes and the stack trace of the last failed delete. The provided reference
   * is deleted regardless of whether all deletes succeeded.
   *
   * <p>recursiveDelete() uses a {@link BulkWriter} instance with default settings to perform the
   * deletes. To customize throttling rates or add success/error callbacks, pass in a custom
   * BulkWriter instance.
   *
   * @param reference The reference of the collection to delete.
   * @param bulkWriter A custom BulkWriter instance used to perform the deletes.
   * @return An ApiFuture that completes when all deletes have been performed. The future fails with
   *     an error if any of the deletes fail.
   */
  @BetaApi
  @Nonnull
  ApiFuture<Void> recursiveDelete(CollectionReference reference, BulkWriter bulkWriter);

  /**
   * Recursively deletes all documents and subcollections at and under the specified level.
   *
   * <p>If any delete fails, the ApiFuture contains an error with an error message containing the
   * number of failed deletes and the stack trace of the last failed delete. The provided reference
   * is deleted regardless of whether all deletes succeeded.
   *
   * <p>recursiveDelete() uses a {@link BulkWriter} instance with default settings to perform the
   * deletes. To customize throttling rates or add success/error callbacks, pass in a custom
   * BulkWriter instance.
   *
   * @param reference The reference of the document to delete.
   * @return An ApiFuture that completes when all deletes have been performed. The future fails with
   *     an error if any of the deletes fail.
   */
  @BetaApi
  @Nonnull
  ApiFuture<Void> recursiveDelete(DocumentReference reference);

  /**
   * Recursively deletes all documents and subcollections at and under the specified level.
   *
   * <p>If any delete fails, the ApiFuture contains an error with an error message containing the
   * number of failed deletes and the stack trace of the last failed delete. The provided reference
   * is deleted regardless of whether all deletes succeeded.
   *
   * <p>recursiveDelete() uses a {@link BulkWriter} instance with default settings to perform the
   * deletes. To customize throttling rates or add success/error callbacks, pass in a custom
   * BulkWriter instance.
   *
   * @param reference The reference of the document to delete.
   * @param bulkWriter A custom BulkWriter instance used to perform the deletes.
   * @return An ApiFuture that completes when all deletes have been performed. The future fails with
   *     an error if any of the deletes fail.
   */
  @BetaApi
  @Nonnull
  ApiFuture<Void> recursiveDelete(DocumentReference reference, BulkWriter bulkWriter);

  /**
   * Returns a FirestoreBundle.Builder {@link FirestoreBundle.Builder} instance using an
   * automatically generated bundle ID. When loaded on clients, client SDKs use the bundle ID and
   * the timestamp associated with the built bundle to tell if it has been loaded already.
   */
  @Nonnull
  FirestoreBundle.Builder bundleBuilder();

  /**
   * Returns a FirestoreBundle.Builder {@link FirestoreBundle.Builder} instance for the given bundle
   * ID.
   *
   * @param bundleId The ID of the bundle. When loaded on clients, client SDKs use this id and the
   *     timestamp associated with the built bundle to tell if it has been loaded already.
   */
  @Nonnull
  FirestoreBundle.Builder bundleBuilder(@Nonnull String bundleId);

  /**
   * Closes the gRPC channels associated with this instance and frees up their resources. This
   * method blocks until all channels are closed. Once this method is called, this Firestore client
   * is no longer usable.
   */
  @Override
  void close() throws Exception;

  /**
   * Initiates an orderly shutdown in which previously submitted work is finished, but no new work
   * will be accepted.
   */
  void shutdown();

  /** Attempts to stop all actively executing work and halts the processing of waiting work. */
  void shutdownNow();
}
