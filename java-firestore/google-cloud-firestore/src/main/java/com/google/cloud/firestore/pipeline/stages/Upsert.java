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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
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

@InternalApi
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

  @BetaApi
  public Upsert() {
    this((ImmutableList<Selectable>) null, null, null, InternalOptions.EMPTY);
  }

  @BetaApi
  public Upsert(Selectable... additionalFields) {
    this(
        additionalFields != null ? ImmutableList.copyOf(additionalFields) : null,
        null,
        null,
        InternalOptions.EMPTY);
  }

  @BetaApi
  public Upsert withAdditionalFields(Selectable... additionalFields) {
    return new Upsert(
        ImmutableList.copyOf(additionalFields),
        this.collectionPath,
        this.documentIdExpression,
        this.options);
  }

  @BetaApi
  public Upsert withAdditionalFields(List<Selectable> additionalFields) {
    return new Upsert(
        ImmutableList.copyOf(additionalFields),
        this.collectionPath,
        this.documentIdExpression,
        this.options);
  }

  @BetaApi
  public Upsert withTransformedFields(Selectable... transformedFields) {
    return withAdditionalFields(transformedFields);
  }

  @BetaApi
  public Upsert withTransformedFields(List<Selectable> transformedFields) {
    return withAdditionalFields(transformedFields);
  }

  @BetaApi
  public Upsert withCollection(String collectionPath) {
    return new Upsert(
        this.additionalFields, collectionPath, this.documentIdExpression, this.options);
  }

  @BetaApi
  public Upsert withDocumentIdExpression(Expression documentIdExpression) {
    return new Upsert(
        this.additionalFields, this.collectionPath, documentIdExpression, this.options);
  }

  @BetaApi
  public Upsert withDocumentId(Expression documentIdExpression) {
    return withDocumentIdExpression(documentIdExpression);
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
    }
    return args;
  }
}
