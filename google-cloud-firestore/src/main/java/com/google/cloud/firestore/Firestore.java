/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import com.google.cloud.Service;
import java.util.List;
import javax.annotation.Nonnull;

/** Represents a Firestore Database and is the entry point for all Firestore operations */
public interface Firestore extends Service<FirestoreOptions> {

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
   * @return An ApiFuture that will be resolved with the list of collections.
   */
  @Nonnull
  ApiFuture<List<CollectionReference>> getCollections();

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
   * Retrieves multiple documents from Firestore.
   *
   * @param documentReferences List of Document References to fetch.
   */
  @Nonnull
  ApiFuture<List<DocumentSnapshot>> getAll(final DocumentReference... documentReferences);

  /**
   * Gets a Firestore {@see WriteBatch} instance that can be used to combine multiple writes.
   *
   * @return A WriteBatch that operates on this Firestore client.
   */
  @Nonnull
  WriteBatch batch();
}
