/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.pipeline.stages.Collection;
import com.google.cloud.firestore.pipeline.stages.CollectionGroup;
import com.google.cloud.firestore.pipeline.stages.CollectionGroupOptions;
import com.google.cloud.firestore.pipeline.stages.CollectionOptions;
import com.google.cloud.firestore.pipeline.stages.Database;
import com.google.cloud.firestore.pipeline.stages.Documents;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.Nonnull;

/**
 * A factory for creating {@link Pipeline} instances, which provide a framework for building data
 * transformation and query pipelines for Firestore.
 *
 * <p>Start by calling {@link Firestore#pipeline()} to obtain an instance of {@code PipelineSource}.
 * From there, you can use the provided methods (like {@link #collection(String)}) to specify the
 * data source for your pipeline.
 *
 * <p>This class is typically used to start building Firestore pipelines. It allows you to define
 * the initial data source for a pipeline.
 *
 * <p>Example Usage:
 *
 * <pre>{@code
 * firestore.pipeline() // Get a PipelineSource instance
 *   .collection("users") // Create a pipeline that operates on a collection
 *   .select("name"); // Add stages to the pipeline
 * }</pre>
 */
@BetaApi
public final class PipelineSource {
  private final FirestoreRpcContext<?> rpcContext;

  @InternalApi
  PipelineSource(FirestoreRpcContext<?> rpcContext) {
    this.rpcContext = rpcContext;
  }

  /**
   * Creates a new {@link Pipeline} that operates on the specified Firestore collection.
   *
   * @param path The path to the Firestore collection (e.g., "users").
   * @return A new {@code Pipeline} instance targeting the specified collection.
   */
  @Nonnull
  @BetaApi
  public Pipeline collection(@Nonnull String path) {
    return collection(path, new CollectionOptions());
  }

  @Nonnull
  @BetaApi
  public Pipeline collection(@Nonnull String path, CollectionOptions options) {
    return new Pipeline(this.rpcContext, new Collection(path, options));
  }

  @Nonnull
  @BetaApi
  public Pipeline collection(@Nonnull CollectionReference ref) {
    if (!this.rpcContext.getFirestore().equals(ref.getFirestore())) {
      throw new IllegalArgumentException(
          "Invalid CollectionReference. The Firestore instance of the CollectionReference must"
              + " match the Firestore instance of the PipelineSource.");
    }

    return collection(ref.getPath(), new CollectionOptions());
  }

  /**
   * Creates a new {@link Pipeline} that operates on all documents in a collection group.
   *
   * <p>A collection group consists of all collections with the same ID. For example, if you have
   * collections named "users" under different documents, you can query them together using a
   * collection group query.
   *
   * @param collectionId The ID of the collection group.
   * @return A new {@code Pipeline} instance targeting the specified collection group.
   */
  @Nonnull
  @BetaApi
  public Pipeline collectionGroup(@Nonnull String collectionId) {
    return collectionGroup(collectionId, new CollectionGroupOptions());
  }

  @Nonnull
  @BetaApi
  public Pipeline collectionGroup(@Nonnull String collectionId, CollectionGroupOptions options) {
    Preconditions.checkArgument(
        !collectionId.contains("/"),
        "Invalid collectionId '%s'. Collection IDs must not contain '/'.",
        collectionId);
    return new Pipeline(this.rpcContext, new CollectionGroup(collectionId, options));
  }

  /**
   * Creates a new {@link Pipeline} that operates on all documents in the Firestore database.
   *
   * <p>Use this method with caution as it can lead to very large result sets. It is usually only
   * useful at development stage.
   *
   * @return A new {@code Pipeline} instance targeting all documents in the database.
   */
  @Nonnull
  @BetaApi
  public Pipeline database() {
    return new Pipeline(this.rpcContext, new Database());
  }

  /**
   * Creates a new {@link Pipeline} that operates on a specific set of Firestore documents.
   *
   * @param docs The {@link DocumentReference} instances representing the documents to include in
   *     the pipeline.
   * @return A new {@code Pipeline} instance targeting the specified documents.
   */
  @Nonnull
  @BetaApi
  public Pipeline documents(DocumentReference... docs) {
    return new Pipeline(this.rpcContext, Documents.of(docs));
  }

  /**
   * Creates a new {@link Pipeline} that operates on a specific set of Firestore documents.
   *
   * @param docs The {@link DocumentReference} instances representing the documents to include in
   *     the pipeline.
   * @return A new {@code Pipeline} instance targeting the specified documents.
   */
  @Nonnull
  @BetaApi
  public Pipeline documents(String... docs) {
    return new Pipeline(
        this.rpcContext,
        Documents.of(
            Arrays.stream(docs)
                .map(d -> this.rpcContext.getFirestore().document(d))
                .toArray(DocumentReference[]::new)));
  }

  /**
   * Creates a new {@link Pipeline} from the given {@link Query}. Under the hood, this will
   * translate the query semantics (order by document ID, etc.) to an equivalent pipeline.
   *
   * @param query The {@link Query} to translate into the resulting pipeline.
   * @return A new {@code Pipeline} that is equivalent to the given query.
   */
  @Nonnull
  @BetaApi
  public Pipeline createFrom(Query query) {
    return query.pipeline();
  }

  /**
   * Creates a new {@link Pipeline} from the given {@link AggregateQuery}. Under the hood, this will
   * translate the query semantics (order by document ID, etc.) to an equivalent pipeline.
   *
   * @param query The {@link AggregateQuery} to translate into the resulting pipeline.
   * @return A new {@code Pipeline} that is equivalent to the given query.
   */
  @Nonnull
  @BetaApi
  public Pipeline createFrom(AggregateQuery query) {
    return query.pipeline();
  }
}
