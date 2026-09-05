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
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@InternalApi
public final class Upsert extends Stage {

  @Nullable private final Selectable[] transformedFields;
  @Nullable private final String collectionPath;
  @Nullable private final Expression documentIdExpr;

  private Upsert(
      @Nullable Selectable[] transformedFields,
      @Nullable String collectionPath,
      @Nullable Expression documentIdExpr,
      InternalOptions options) {
    super("upsert", buildOptions(collectionPath, documentIdExpr, options));
    this.transformedFields = transformedFields;
    this.collectionPath = collectionPath;
    this.documentIdExpr = documentIdExpr;
  }

  @BetaApi
  public Upsert() {
    this(null, null, null, InternalOptions.EMPTY);
  }

  @BetaApi
  public Upsert(Selectable... transformedFields) {
    this(transformedFields, null, null, InternalOptions.EMPTY);
  }

  @BetaApi
  public Upsert withCollection(String collectionPath) {
    return new Upsert(this.transformedFields, collectionPath, this.documentIdExpr, this.options);
  }

  @BetaApi
  public Upsert withDocumentId(Expression documentIdExpr) {
    return new Upsert(this.transformedFields, this.collectionPath, documentIdExpr, this.options);
  }

  private static InternalOptions buildOptions(
      @Nullable String collectionPath,
      @Nullable Expression documentIdExpr,
      InternalOptions baseOptions) {
    Map<String, Value> optsMap = new HashMap<>(baseOptions.options);
    if (collectionPath != null) {
      String path = collectionPath.startsWith("/") ? collectionPath : "/" + collectionPath;
      optsMap.put("collection", Value.newBuilder().setReferenceValue(path).build());
    }
    if (documentIdExpr != null) {
      optsMap.put("document_id", PipelineUtils.encodeValue(documentIdExpr));
    }
    return new InternalOptions(ImmutableMap.copyOf(optsMap));
  }

  @Override
  Iterable<Value> toStageArgs() {
    List<Value> args = new ArrayList<>();
    if (transformedFields != null && transformedFields.length > 0) {
      Map<String, Expression> map = PipelineUtils.selectablesToMap(transformedFields);
      Map<String, Value> encodedMap = new HashMap<>();
      for (Map.Entry<String, Expression> entry : map.entrySet()) {
        encodedMap.put(entry.getKey(), PipelineUtils.encodeValue(entry.getValue()));
      }
      args.add(PipelineUtils.encodeValue(encodedMap));
    }
    return args;
  }
}
