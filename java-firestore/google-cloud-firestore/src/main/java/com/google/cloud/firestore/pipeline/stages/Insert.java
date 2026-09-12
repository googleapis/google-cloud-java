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
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@InternalApi
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

  @BetaApi
  public Insert() {
    this(null, null, InternalOptions.EMPTY);
  }

  @BetaApi
  public Insert withCollection(String collectionPath) {
    return new Insert(collectionPath, this.documentIdExpression, this.options);
  }

  @BetaApi
  public Insert withDocumentIdExpression(Expression documentIdExpression) {
    return new Insert(this.collectionPath, documentIdExpression, this.options);
  }

  @BetaApi
  public Insert withDocumentId(Expression documentIdExpression) {
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
    return new ArrayList<>();
  }
}
