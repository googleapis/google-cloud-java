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
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A pipeline stage that writes each document produced by the previous stages, creating the target
 * document if it doesn't exist and replacing it if it does. Stored fields are not merged.
 *
 * <p>The target path of each document is determined as follows:
 *
 * <ul>
 *   <li>With neither a collection nor a document ID expression, the input document's own path (its
 *       {@code __name__} field) is used. A document without a {@code __name__} field fails with
 *       {@code INVALID_ARGUMENT}.
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
 * // Set "status" on each matching document and write it to the path given by its __name__ field.
 * firestore.pipeline()
 *     .collection("books")
 *     .where(field("rating").greaterThan(4))
 *     .addFields(constant("Featured").as("status"))
 *     .upsert()
 *     .execute()
 *     .get();
 * }</pre>
 *
 * @see com.google.cloud.firestore.Pipeline#upsert(Upsert)
 */
public final class Upsert extends Stage {

  @Nullable private final ImmutableList<Selectable> additionalFields;
  @Nullable private final String collectionPath;
  @Nullable private final Expression documentIdExpression;

  private Upsert(
      @Nullable ImmutableList<Selectable> additionalFields,
      @Nullable String collectionPath,
      @Nullable Expression documentIdExpression,
      InternalOptions options) {
    super("upsert", buildOptions(collectionPath, documentIdExpression, options));
    this.additionalFields = additionalFields;
    this.collectionPath = collectionPath;
    this.documentIdExpression = documentIdExpression;
  }

  /**
   * Creates an upsert stage with no additional fields, no target collection and no document ID
   * expression, so each document is written to the path given by its {@code __name__} field.
   */
  public Upsert() {
    this((ImmutableList<Selectable>) null, null, null, InternalOptions.EMPTY);
  }

  /**
   * Creates an upsert stage that adds the given fields to each input document before it is written
   * to the path given by its {@code __name__} field.
   *
   * @param additionalFields Fields to add to each input document. A field with the same name as an
   *     existing input field overwrites that field.
   */
  public Upsert(Selectable... additionalFields) {
    this(
        additionalFields != null ? ImmutableList.copyOf(additionalFields) : null,
        null,
        null,
        InternalOptions.EMPTY);
  }

  /**
   * Sets the fields to add to each input document before it is written.
   *
   * @param additionalFields Fields to add to each input document. A field with the same name as an
   *     existing input field overwrites that field.
   * @return A new {@code Upsert} stage with the additional fields set.
   */
  public Upsert withAdditionalFields(Selectable... additionalFields) {
    return new Upsert(
        ImmutableList.copyOf(additionalFields),
        this.collectionPath,
        this.documentIdExpression,
        this.options);
  }

  /**
   * Sets the fields to add to each input document before it is written.
   *
   * @param additionalFields Fields to add to each input document. A field with the same name as an
   *     existing input field overwrites that field.
   * @return A new {@code Upsert} stage with the additional fields set.
   */
  public Upsert withAdditionalFields(List<Selectable> additionalFields) {
    return new Upsert(
        ImmutableList.copyOf(additionalFields),
        this.collectionPath,
        this.documentIdExpression,
        this.options);
  }

  /**
   * Sets the collection that documents are written to.
   *
   * @param collectionPath The path of the target collection, for example {@code "books"} or {@code
   *     "users/alice/books"}.
   * @return A new {@code Upsert} stage with the target collection set.
   */
  public Upsert withCollection(String collectionPath) {
    return new Upsert(
        this.additionalFields, collectionPath, this.documentIdExpression, this.options);
  }

  /**
   * Sets the expression that produces the ID of each target document.
   *
   * @param documentIdExpression An expression that is evaluated against each input document and
   *     must evaluate to a document ID (not a document path). Use {@code constant("id")} for a
   *     fixed ID.
   * @return A new {@code Upsert} stage with the document ID expression set.
   */
  public Upsert withDocumentIdExpression(Expression documentIdExpression) {
    return new Upsert(
        this.additionalFields, this.collectionPath, documentIdExpression, this.options);
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
    List<Value> args = new ArrayList<>();
    if (additionalFields != null && !additionalFields.isEmpty()) {
      Map<String, Expression> map =
          PipelineUtils.selectablesToMap(additionalFields.toArray(new Selectable[0]));
      Map<String, Value> encodedMap = new HashMap<>();
      for (Map.Entry<String, Expression> entry : map.entrySet()) {
        encodedMap.put(entry.getKey(), PipelineUtils.encodeValue(entry.getValue()));
      }
      args.add(PipelineUtils.encodeValue(encodedMap));
    } else {
      args.add(PipelineUtils.encodeValue(new HashMap<String, Value>()));
    }
    return args;
  }
}
