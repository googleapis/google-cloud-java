/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.firestore.pipeline.stages;

import com.google.cloud.firestore.PipelineUtils;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A pipeline stage that inserts each document produced by the previous stages as a new document.
 *
 * <p>The insert fails with {@code ALREADY_EXISTS} if a target document already exists.
 *
 * <p>The target path of each document is determined as follows:
 *
 * <ul>
 *   <li>With neither a collection nor a document ID expression, the input document's own path (its
 *       {@code __name__} field) is used, so inserting documents read from the database fails with
 *       {@code ALREADY_EXISTS}, and a document without a {@code __name__} field fails with {@code
 *       INVALID_ARGUMENT}.
 *   <li>With only a collection, the document is written to that collection under the input
 *       document's ID, or under a generated ID if the input document has no {@code __name__}.
 *   <li>With only a document ID expression, the document is written to the input document's parent
 *       collection under the ID that the expression evaluates to.
 *   <li>With both, the document is written to the collection under the ID that the expression
 *       evaluates to.
 * </ul>
 *
 * <p>Example:
 *
 * <pre>{@code
 * // Copy a document into another collection under a new ID.
 * firestore.pipeline()
 *     .collection("books")
 *     .where(field("title").equal("Dune"))
 *     .insert(new Insert().withCollection("archive").withDocumentIdExpression(constant("dune")))
 *     .execute()
 *     .get();
 * }</pre>
 *
 * @see com.google.cloud.firestore.Pipeline#insert(Insert)
 */
public final class Insert extends Stage {

  @Nullable private final String collectionPath;
  @Nullable private final Expression documentIdExpression;

  private Insert(
      @Nullable String collectionPath,
      @Nullable Expression documentIdExpression,
      InternalOptions options) {
    super("insert", buildOptions(collectionPath, documentIdExpression, options));
    this.collectionPath = collectionPath;
    this.documentIdExpression = documentIdExpression;
  }

  /**
   * Creates an insert stage with no target collection and no document ID expression, so each
   * document is inserted at the input document's own path.
   */
  public Insert() {
    this(null, null, InternalOptions.EMPTY);
  }

  /**
   * Sets the collection that documents are inserted into.
   *
   * @param collectionPath The path of the target collection, for example {@code "books"} or {@code
   *     "users/alice/books"}.
   * @return A new {@code Insert} stage with the target collection set.
   */
  public Insert withCollection(String collectionPath) {
    return new Insert(collectionPath, this.documentIdExpression, this.options);
  }

  /**
   * Sets the expression that produces the ID of each inserted document.
   *
   * @param documentIdExpression An expression that is evaluated against each input document and
   *     must evaluate to a document ID (not a document path). Use {@code constant("id")} for a
   *     fixed ID.
   * @return A new {@code Insert} stage with the document ID expression set.
   */
  public Insert withDocumentIdExpression(Expression documentIdExpression) {
    return new Insert(this.collectionPath, documentIdExpression, this.options);
  }

  private static InternalOptions buildOptions(
      @Nullable String collectionPath,
      @Nullable Expression documentIdExpression,
      InternalOptions baseOptions) {
    Map<String, Value> optsMap = new HashMap<>(baseOptions.options);
    if (collectionPath != null) {
      String path = collectionPath.startsWith("/") ? collectionPath : "/" + collectionPath;
      optsMap.put("collection", Value.newBuilder().setReferenceValue(path).build());
    }
    if (documentIdExpression != null) {
      optsMap.put("document_id", PipelineUtils.encodeValue(documentIdExpression));
    }
    return new InternalOptions(ImmutableMap.copyOf(optsMap));
  }

  @Override
  Iterable<Value> toStageArgs() {
    return new ArrayList<>();
  }
}
