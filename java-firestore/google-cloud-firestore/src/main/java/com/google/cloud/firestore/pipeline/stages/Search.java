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

import static com.google.cloud.firestore.PipelineUtils.encodeValue;
import static com.google.cloud.firestore.pipeline.expressions.Expression.documentMatches;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.PipelineUtils;
import com.google.cloud.firestore.pipeline.expressions.BooleanExpression;
import com.google.cloud.firestore.pipeline.expressions.Ordering;
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Search stage executes full-text search or geo search operations.
 *
 * <p>The Search stage must be the first stage in a Pipeline.
 *
 * <p>Example:
 *
 * <pre>{@code
 * db.pipeline().collection("restaurants").search(
 *   Search.withQuery(documentMatches("waffles OR pancakes"))
 *     .withSort(score().descending())
 *     .withLimit(10)
 * );
 * }</pre>
 */
@BetaApi
public final class Search extends Stage {

  /**
   * Specifies if the `matches` and `snippet` expressions will enhance the user provided query to
   * perform matching of synonyms, misspellings, lemmatization, stemming.
   */
  @BetaApi
  @InternalApi
  static final class QueryEnhancement {
    final String protoString;

    private QueryEnhancement(String protoString) {
      this.protoString = protoString;
    }

    /**
     * Search will fall back to the un-enhanced, user provided query, if the query enhancement
     * fails.
     */
    public static final QueryEnhancement PREFERRED = new QueryEnhancement("preferred");

    /**
     * Search will fail if the query enhancement times out or if the query enhancement is not
     * supported by the project's DRZ compliance requirements.
     */
    public static final QueryEnhancement REQUIRED = new QueryEnhancement("required");

    /** Search will use the un-enhanced, user provided query. */
    public static final QueryEnhancement DISABLED = new QueryEnhancement("disabled");

    Value toProto() {
      return encodeValue(protoString);
    }
  }

  @InternalApi
  public Search(InternalOptions options) {
    super("search", options);
  }

  /**
   * Create {@link Search} with an expression search query.
   *
   * <p>{@code query} specifies the search query that will be used to query and score documents by
   * the search stage.
   */
  public static Search withQuery(BooleanExpression query) {
    return new Search(InternalOptions.of("query", encodeValue(query)));
  }

  /**
   * Create {@link Search} with an expression search query.
   *
   * <p>{@code query} specifies the search query that will be used to query and score documents by
   * the search stage.
   */
  public static Search withQuery(String rquery) {
    return withQuery(documentMatches(rquery));
  }

  /** Specify the fields to add to each document. */
  public Search withAddFields(Selectable field, Selectable... additionalFields) {
    Selectable[] allFields = new Selectable[additionalFields.length + 1];
    allFields[0] = field;
    System.arraycopy(additionalFields, 0, allFields, 1, additionalFields.length);
    Map<String, Value> map =
        PipelineUtils.selectablesToMap(allFields).entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> encodeValue(e.getValue())));
    return new Search(options.with("add_fields", encodeValue(map)));
  }

  // TODO(search) enable with backend support
  //  /** Specify the fields to keep or add to each document. */
  //  public Search withSelect(Selectable selection, Object... additionalSelections) {
  //    Selectable[] allSelections = new Selectable[additionalSelections.length + 1];
  //    allSelections[0] = selection;
  //    for (int i = 0; i < additionalSelections.length; i++) {
  //      allSelections[i + 1] = Selectable.toSelectable(additionalSelections[i]);
  //    }
  //    Map<String, Value> map =
  //        PipelineUtils.selectablesToMap(allSelections).entrySet().stream()
  //            .collect(Collectors.toMap(Map.Entry::getKey, e -> encodeValue(e.getValue())));
  //    return new Search(options.with("select", encodeValue(map)));
  //  }

  //  /** Specify the fields to keep or add to each document. */
  //  public Search withSelect(String fieldName, Object... additionalSelections) {
  //    return withSelect(field(fieldName), additionalSelections);
  //  }

  /** Specify how the returned documents are sorted. One or more ordering are required. */
  public Search withSort(Ordering order, Ordering... additionalOrderings) {
    Ordering[] allOrderings = new Ordering[additionalOrderings.length + 1];
    allOrderings[0] = order;
    System.arraycopy(additionalOrderings, 0, allOrderings, 1, additionalOrderings.length);
    return new Search(
        options.with("sort", Lists.transform(Arrays.asList(allOrderings), Ordering::toProto)));
  }

  /**
   * Specify the maximum number of documents to return from the `search` stage. The `limit` is
   * applied after documents are scored and sorted.
   */
  public Search withLimit(long limit) {
    return new Search(options.with("limit", encodeValue(limit)));
  }

  /**
   * Specify the maximum number of documents to retrieve from the search index. Documents will be
   * retrieved in the pre-sort order specified by the search index. The `retrievalDepth` is a limit
   * applied before documents are scored and sorted, which can reduce costs of expensive scoring and
   * sorting operations.
   */
  public Search withRetrievalDepth(long retrievalDepth) {
    return new Search(options.with("retrieval_depth", encodeValue(retrievalDepth)));
  }

  /** Specify the number of documents to skip from the beginning of the search result set. */
  public Search withOffset(long offset) {
    return new Search(options.with("offset", encodeValue(offset)));
  }

  /** Specify the BCP-47 language code of text in the search query, such as “en” or “sr”. */
  public Search withLanguageCode(String value) {
    return new Search(options.with("language_code", encodeValue(value)));
  }

  // TODO(search) enable with backend support
  //  /**
  //   * Specify the query expansion behavior used by full-text search expressions in this search
  // stage.
  //   * Default: {@code .PREFERRED}
  //   */
  //  public Search withQueryEnhancement(QueryEnhancement queryEnhancement) {
  //    return new Search(options.with("query_enhancement", queryEnhancement.toProto()));
  //  }

  @Override
  Iterable<Value> toStageArgs() {
    return ImmutableList.of();
  }
}
