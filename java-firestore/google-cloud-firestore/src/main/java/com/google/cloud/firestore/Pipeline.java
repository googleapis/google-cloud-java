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

import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_DOC_COUNT;
import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_IS_TRANSACTIONAL;

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.AliasedAggregate;
import com.google.cloud.firestore.pipeline.expressions.AliasedExpression;
import com.google.cloud.firestore.pipeline.expressions.BooleanExpression;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.expressions.FunctionExpression;
import com.google.cloud.firestore.pipeline.expressions.Ordering;
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.cloud.firestore.pipeline.stages.AddFields;
import com.google.cloud.firestore.pipeline.stages.Aggregate;
import com.google.cloud.firestore.pipeline.stages.AggregateOptions;
import com.google.cloud.firestore.pipeline.stages.Distinct;
import com.google.cloud.firestore.pipeline.stages.FindNearest;
import com.google.cloud.firestore.pipeline.stages.FindNearestOptions;
import com.google.cloud.firestore.pipeline.stages.Limit;
import com.google.cloud.firestore.pipeline.stages.Offset;
import com.google.cloud.firestore.pipeline.stages.PipelineExecuteOptions;
import com.google.cloud.firestore.pipeline.stages.RawStage;
import com.google.cloud.firestore.pipeline.stages.RemoveFields;
import com.google.cloud.firestore.pipeline.stages.ReplaceWith;
import com.google.cloud.firestore.pipeline.stages.Sample;
import com.google.cloud.firestore.pipeline.stages.Select;
import com.google.cloud.firestore.pipeline.stages.Sort;
import com.google.cloud.firestore.pipeline.stages.Stage;
import com.google.cloud.firestore.pipeline.stages.StageUtils;
import com.google.cloud.firestore.pipeline.stages.Union;
import com.google.cloud.firestore.pipeline.stages.Unnest;
import com.google.cloud.firestore.pipeline.stages.UnnestOptions;
import com.google.cloud.firestore.pipeline.stages.Where;
import com.google.cloud.firestore.telemetry.MetricsUtil.MetricsContext;
import com.google.cloud.firestore.telemetry.TelemetryConstants;
import com.google.cloud.firestore.telemetry.TelemetryConstants.MetricType;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.StructuredPipeline;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The Pipeline class provides a flexible and expressive framework for building complex data
 * transformation and query pipelines for Firestore.
 *
 * <p>A pipeline takes data sources, such as Firestore collections or collection groups, and applies
 * a series of stages that are chained together. Each stage takes the output from the previous stage
 * (or the data source) and produces an output for the next stage (or as the final output of the
 * pipeline).
 *
 * <p>Expressions from {@link com.google.cloud.firestore.pipeline.expressions} can be used within
 * each stages to filter and transform data through the stage.
 *
 * <p>NOTE: The chained stages do not prescribe exactly how Firestore will execute the pipeline.
 * Instead, Firestore only guarantees that the result is the same as if the chained stages were
 * executed in order.
 *
 * <p>Usage Examples:
 *
 * <pre>{@code
 * Firestore firestore; // A valid firestore instance.
 *
 * // Example 1: Select specific fields and rename 'rating' to 'bookRating'
 * Snapshot results1 = firestore.pipeline()
 *     .collection("books")
 *     .select(field("title"), field("author"), field("rating").as("bookRating"))
 *     .execute()
 *     .get();
 *
 * // Example 2: Filter documents where 'genre' is "Science Fiction" and
 * // 'published' is after 1950
 * Snapshot results2 = firestore.pipeline()
 *     .collection("books")
 *     .where(and(equal("genre", "Science Fiction"), greaterThan("published", 1950)))
 *     .execute()
 *     .get();
 * // Same as above but using methods on expressions as opposed to static
 * // functions.
 * results2 = firestore.pipeline()
 *     .collection("books")
 *     .where(and(field("genre").equal("Science Fiction"), field("published").greaterThan(1950)))
 *     .execute()
 *     .get();
 *
 * // Example 3: Calculate the average rating of books published after 1980
 * Snapshot results3 = firestore.pipeline()
 *     .collection("books")
 *     .where(greaterThan("published", 1980))
 *     .aggregate(average("rating").as("averageRating"))
 *     .execute()
 *     .get();
 * }</pre>
 */
@BetaApi
public final class Pipeline {
  /**
   * A Snapshot contains the results of a pipeline execution. It can be used to access the
   * documents, execution time, and explain stats.
   */
  @BetaApi
  public static final class Snapshot {

    private final Pipeline pipeline;
    private final Timestamp executionTime;
    private final List<PipelineResult> results;
    private final ExplainStats explainStats;

    Snapshot(
        @Nonnull Pipeline pipeline,
        @Nonnull List<PipelineResult> results,
        @Nonnull Timestamp executionTime,
        @Nullable ExplainStats explainStats) {
      this.pipeline = pipeline;
      this.results = results;
      this.executionTime = executionTime;
      this.explainStats = explainStats;
    }

    /**
     * The Pipeline on which you called `execute()` in order to get this `Snapshot`.
     *
     * @return The pipeline that was executed.
     */
    @Nonnull
    Pipeline getPipeline() {
      return pipeline;
    }

    /**
     * An array of all the results in the `Snapshot`.
     *
     * @return The list of results.
     */
    @Nonnull
    public List<PipelineResult> getResults() {
      return results;
    }

    /**
     * The time at which the pipeline producing this result is executed.
     *
     * @return The execution time of the pipeline.
     */
    @Nonnull
    public Timestamp getExecutionTime() {
      return executionTime;
    }

    /**
     * Return stats from query explain.
     *
     * <p>If `explainOptions.mode` was set to `execute` or left unset, then this returns `null`.
     *
     * @return The explain stats, or `null` if not available.
     */
    @Nullable
    public ExplainStats getExplainStats() {
      return explainStats;
    }
  }

  private static Logger logger = Logger.getLogger(Pipeline.class.getName());
  private final FluentIterable<Stage> stages;
  private final FirestoreRpcContext<?> rpcContext;

  private Pipeline(FirestoreRpcContext<?> rpcContext, FluentIterable<Stage> stages) {
    this.rpcContext = rpcContext;
    this.stages = stages;
  }

  @InternalApi
  Pipeline(FirestoreRpcContext<?> rpcContext, Stage stage) {
    this(rpcContext, FluentIterable.of(stage));
  }

  private Pipeline append(Stage stage) {
    return new Pipeline(this.rpcContext, stages.append(stage));
  }

  /**
   * Adds new fields to outputs from previous stages.
   *
   * <p>This stage allows you to compute values on-the-fly based on existing data from previous
   * stages or constants. You can use this to create new fields or overwrite existing ones (if there
   * is name overlaps).
   *
   * <p>The added fields are defined using {@link Selectable} expressions, which can be:
   *
   * <ul>
   *   <li>{@link Field}: References an existing document field.
   *   <li>{@link FunctionExpression}: Performs a calculation using functions like `add`, `multiply`
   *       with assigned aliases using {@link Expression#as(String)}.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *     .addFields(
   *         field("rating").as("bookRating"), // Rename 'rating' to 'bookRating'
   *         add(5, field("quantity")).as("totalCost") // Calculate 'totalCost'
   *     );
   * }</pre>
   *
   * @param field The field to add to the documents, specified as {@link Selectable} expressions.
   * @param additionalFields The additional fields to add to the documents, specified as {@link
   *     Selectable} expressions.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline addFields(Selectable field, Selectable... additionalFields) {
    return append(
        new AddFields(
            PipelineUtils.selectablesToMap(
                ImmutableList.<Selectable>builder()
                    .add(field)
                    .add(additionalFields)
                    .build()
                    .toArray(new Selectable[0]))));
  }

  /**
   * Remove fields from outputs of previous stages.
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *     .removeFields(
   *         "rating", "cost");
   * }</pre>
   *
   * @param field The fields to remove.
   * @param additionalFields The additional fields to remove.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline removeFields(String field, String... additionalFields) {
    return append(
        new RemoveFields(
            ImmutableList.<Field>builder()
                .add(Field.ofUserPath(field))
                .addAll(Arrays.stream(additionalFields).map(f -> Field.ofUserPath(f)).iterator())
                .build()));
  }

  /**
   * Remove fields from outputs of previous stages.
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *     .removeFields(
   *         field("rating"), field("cost"));
   * }</pre>
   *
   * @param field The field to remove.
   * @param additionalFields The additional fields to remove.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline removeFields(Field field, Field... additionalFields) {
    return append(
        new RemoveFields(
            ImmutableList.<Field>builder()
                .add(field)
                .addAll(Arrays.stream(additionalFields).iterator())
                .build()));
  }

  /**
   * Selects or creates a set of fields from the outputs of previous stages.
   *
   * <p>The selected fields are defined using {@link Selectable} expressions, which can be:
   *
   * <ul>
   *   <li>{@link Field}: References an existing document field.
   *   <li>{@link FunctionExpression}: Represents the result of a function with an assigned alias
   *       name using {@link Expression#as(String)}
   * </ul>
   *
   * <p>If no selections are provided, the output of this stage is empty. Use {@link
   * com.google.cloud.firestore.Pipeline#addFields(Selectable, Selectable...)} instead if only
   * additions are desired.
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *   .select(
   *     field("name"),
   *     field("address").toUppercase().as("upperAddress"),
   *   );
   * }</pre>
   *
   * @param selection The field to include in the output documents, specified as {@link Selectable}
   *     expressions.
   * @param additionalSelections The additional fields to include in the output documents,
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline select(Selectable selection, Selectable... additionalSelections) {
    return append(
        new Select(
            PipelineUtils.selectablesToMap(
                ImmutableList.<Selectable>builder()
                    .add(selection)
                    .add(additionalSelections)
                    .build()
                    .toArray(new Selectable[0]))));
  }

  /**
   * Selects a set of fields from the outputs of previous stages.
   *
   * <p>If no selections are provided, the output of this stage is empty. Use {@link
   * com.google.cloud.firestore.Pipeline#addFields(Selectable, Selectable...)} instead if only
   * additions are desired.
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.collection("books")
   *     .select("name", "address");
   *
   * // The above is a shorthand of this:
   * firestore.pipeline().collection("books")
   *     .select(field("name"), field("address"));
   * }</pre>
   *
   * @param field The name of the field to include in the output documents.
   * @param additionalFields The additional fields to include in the output documents.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline select(String field, String... additionalFields) {
    return append(
        new Select(
            PipelineUtils.fieldNamesToMap(
                ImmutableList.<String>builder()
                    .add(field)
                    .add(additionalFields)
                    .build()
                    .toArray(new String[0]))));
  }

  /**
   * Filters the documents from previous stages to only include those matching the specified {@link
   * BooleanExpression}.
   *
   * <p>This stage allows you to apply conditions to the data, similar to a "WHERE" clause in SQL.
   * You can filter documents based on their field values, using implementions of {@link
   * BooleanExpression}, typically including but not limited to:
   *
   * <ul>
   *   <li>field comparators: {@link FunctionExpression#equal}, {@link FunctionExpression#lessThan}
   *       (less than), {@link FunctionExpression#greaterThan} (greater than), etc.
   *   <li>logical operators: {@link FunctionExpression#and}, {@link FunctionExpression#or}, {@link
   *       FunctionExpression#not}, etc.
   *   <li>advanced functions: {@link FunctionExpression#regexMatch(String, String)}, {@link
   *       FunctionExpression#arrayContains(Expression, Expression)}, etc.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *   .where(
   *     and(
   *         gt("rating", 4.0),   // Filter for ratings greater than 4.0
   *         field("genre").eq("Science Fiction") // Equivalent to eq("genre", "Science Fiction")
   *     )
   *   );
   * }</pre>
   *
   * @param condition The {@link BooleanExpression} to apply.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline where(BooleanExpression condition) {
    return append(new Where(condition));
  }

  /**
   * Skips the first `offset` number of documents from the results of previous stages.
   *
   * <p>This stage is useful for implementing pagination in your pipelines, allowing you to retrieve
   * results in chunks. It is typically used in conjunction with {@link #limit(int)} to control the
   * size of each page.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Retrieve the second page of 20 results
   * firestore.pipeline().collection("books")
   *     .sort(field("published").descending())
   *     .offset(20)  // Skip the first 20 results
   *     .limit(20);   // Take the next 20 results
   * }</pre>
   *
   * @param offset The number of documents to skip.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline offset(int offset) {
    return append(new Offset(offset));
  }

  /**
   * Limits the maximum number of documents returned by previous stages to `limit`.
   *
   * <p>This stage is particularly useful when you want to retrieve a controlled subset of data from
   * a potentially large result set. It's often used for:
   *
   * <ul>
   *   <li>**Pagination:** In combination with {@link #offset(int)} to retrieve specific pages of
   *       results.
   *   <li>**Limiting Data Retrieval:** To prevent excessive data transfer and improve performance,
   *       especially when dealing with large collections.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Limit the results to the top 10 highest-rated books
   * firestore.pipeline().collection("books")
   *     .sort(field("rating").descending())
   *     .limit(10);
   * }</pre>
   *
   * @param limit The maximum number of documents to return.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline limit(int limit) {
    return append(new Limit(limit));
  }

  /**
   * Performs aggregation operations on the documents from previous stages.
   *
   * <p>This stage allows you to calculate aggregate values over a set of documents. You define the
   * aggregations to perform using {@link AliasedExpression} expressions which are typically results
   * of calling {@link Expression#as(String)} on {@link AggregateFunction} instances.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Calculate the average rating and the total number of books
   * firestore.pipeline().collection("books")
   *     .aggregate(
   *         field("rating").average().as("averageRating"),
   *         countAll().as("totalBooks"));
   * }</pre>
   *
   * @param accumulators The {@link AliasedExpression} expressions, each wrapping an {@link
   *     AggregateFunction} and provide a name for the accumulated results.
   * @return A new Pipeline object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline aggregate(AliasedAggregate... accumulators) {
    return append(Aggregate.withAccumulators(accumulators));
  }

  /**
   * Performs optionally grouped aggregation operations on the documents from previous stages.
   *
   * <p>This stage allows you to calculate aggregate values over a set of documents, optionally
   * grouped by one or more fields or functions. You can specify:
   *
   * <ul>
   *   <li>**Grouping Fields or Functions:** One or more fields or functions to group the documents
   *       by. For each distinct combination of values in these fields, a separate group is created.
   *       If no grouping fields are provided, a single group containing all documents is used. Not
   *       specifying groups is the same as putting the entire inputs into one group.
   *   <li>**Accumulators:** One or more accumulation operations to perform within each group. These
   *       are defined using {@link AliasedExpression} expressions, which are typically created by
   *       calling {@link Expression#as(String)} on {@link AggregateFunction} instances. Each
   *       aggregation calculates a value (e.g., sum, average, count) based on the documents within
   *       its group.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Calculate the average rating for each genre.
   * firestore.pipeline().collection("books")
   *     .aggregate(
   *         Aggregate
   *             .withAccumulators(average("rating").as("avg_rating"))
   *             .withGroups("genre"));
   * }</pre>
   *
   * @param aggregate An {@link Aggregate} object that specifies the grouping fields (if any) and
   *     the aggregation operations to perform.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline aggregate(Aggregate aggregate) {
    return append(aggregate);
  }

  @BetaApi
  public Pipeline aggregate(Aggregate aggregate, AggregateOptions options) {
    return append(aggregate.withOptions(options));
  }

  /**
   * Returns a set of distinct field values from the inputs to this stage.
   *
   * <p>This stage run through the results from previous stages to include only results with unique
   * combinations of values for the specified fields and produce these fields as the output.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Get a list of unique genres.
   * firestore.pipeline().collection("books")
   *     .distinct("genre");
   * }</pre>
   *
   * @param fields The fields to consider when determining distinct values.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline distinct(String... fields) {
    return append(new Distinct(PipelineUtils.fieldNamesToMap(fields)));
  }

  /**
   * Returns a set of distinct {@link Expression} values from the inputs to this stage.
   *
   * <p>This stage run through the results from previous stages to include only results with unique
   * combinations of {@link Expression} values ({@link Field}, {@link FunctionExpression}, etc).
   *
   * <p>The parameters to this stage are defined using {@link Selectable} expressions, which can be:
   *
   * <ul>
   *   <li>{@link Field}: References an existing document field.
   *   <li>{@link FunctionExpression}: Represents the result of a function with an assigned alias
   *       name using {@link Expression#as(String)}
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Get a list of unique author names in uppercase and genre combinations.
   * firestore.pipeline().collection("books")
   *     .distinct(toUppercase(field("author")).as("authorName"), field("genre"))
   *     .select("authorName");
   * }</pre>
   *
   * @param selectables The {@link Selectable} expressions to consider when determining distinct
   *     value combinations.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline distinct(Selectable... selectables) {
    return append(new Distinct(PipelineUtils.selectablesToMap(selectables)));
  }

  /**
   * Performs vector distance (similarity) search with given parameters to the stage inputs.
   *
   * <p>This stage adds a "nearest neighbor search" capability to your pipelines. Given a field that
   * stores vectors and a target vector, this stage will identify and return the inputs whose vector
   * field is closest to the target vector, using the parameters specified in `options`.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Find books with similar "topicVectors" to the given targetVector
   * firestore.pipeline().collection("books")
   *     .findNearest("topicVectors", targetVector, FindNearest.DistanceMeasure.COSINE,
   *        new FindNearestOptions()
   *          .withLimit(10)
   *          .withDistanceField("distance"));
   * }</pre>
   *
   * @param fieldName The name of the field containing the vector data. This field should store
   *     {@link VectorValue}.
   * @param vector The target vector to compare against.
   * @param distanceMeasure The distance measure to use: cosine, euclidean, etc.
   * @param options Configuration options for the nearest neighbor search, such as limit and output
   *     distance field name.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline findNearest(
      String fieldName,
      double[] vector,
      FindNearest.DistanceMeasure distanceMeasure,
      FindNearestOptions options) {
    return findNearest(field(fieldName), vector, distanceMeasure, options);
  }

  /**
   * Performs vector distance (similarity) search with given parameters to the stage inputs.
   *
   * <p>This stage adds a "nearest neighbor search" capability to your pipelines. Given an
   * expression that evaluates to a vector and a target vector, this stage will identify and return
   * the inputs whose vector expression is closest to the target vector, using the parameters
   * specified in `options`.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Find books with similar "topicVectors" to the given targetVector
   * firestore.pipeline().collection("books")
   *     .findNearest(
   *        field("topicVectors"),
   *        targetVector,
   *        FindNearest.DistanceMeasure.COSINE,
   *        new FindNearestOptions()
   *          .withLimit(10)
   *          .withDistanceField("distance"));
   * }</pre>
   *
   * @param property The expression that evaluates to a vector value using the stage inputs.
   * @param vector The target vector to compare against.
   * @param distanceMeasure The distance measure to use: cosine, euclidean, etc.
   * @param options Configuration options for the nearest neighbor search, such as limit and output
   *     distance field name.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline findNearest(
      Expression property,
      double[] vector,
      FindNearest.DistanceMeasure distanceMeasure,
      FindNearestOptions options) {
    // Implementation for findNearest (add the FindNearest stage if needed)
    return append(new FindNearest(property, new VectorValue(vector), distanceMeasure, options));
  }

  /**
   * Sorts the documents from previous stages based on one or more {@link Ordering} criteria.
   *
   * <p>This stage allows you to order the results of your pipeline. You can specify multiple {@link
   * Ordering} instances to sort by multiple fields in ascending or descending order. If documents
   * have the same value for a field used for sorting, the next specified ordering will be used. If
   * all orderings result in equal comparison, the documents are considered equal and the order is
   * unspecified.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Sort books by rating in descending order, and then by title in ascending order for books with the same rating
   * firestore.pipeline().collection("books")
   *     .sort(
   *         Ordering.of("rating").descending(),
   *         Ordering.of("title")  // Ascending order is the default
   *     );
   * }</pre>
   *
   * @param orders One or more {@link Ordering} instances specifying the sorting criteria.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline sort(Ordering... orders) {
    return append(new Sort(ImmutableList.copyOf(orders)));
  }

  /**
   * Fully overwrites all fields in a document with those coming from a nested map.
   *
   * <p>This stage allows you to emit a map value as a document. Each key of the map becomes a field
   * on the document that contains the corresponding value.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input.
   * // {
   * //  "name": "John Doe Jr.",
   * //  "parents": {
   * //    "father": "John Doe Sr.",
   * //    "mother": "Jane Doe"
   * //   }
   * // }
   *
   * // Emit parents as document.
   * firestore.pipeline().collection("people").replaceWith("parents");
   *
   * // Output
   * // {
   * //  "father": "John Doe Sr.",
   * //  "mother": "Jane Doe"
   * // }
   * }</pre>
   *
   * @param fieldName The name of the field containing the nested map.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline replaceWith(String fieldName) {
    return replaceWith(field(fieldName));
  }

  /**
   * Fully overwrites all fields in a document with those coming from a nested map.
   *
   * <p>This stage allows you to emit a map value as a document. Each key of the map becomes a field
   * on the document that contains the corresponding value.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input.
   * // {
   * //  "name": "John Doe Jr.",
   * //  "parents": {
   * //    "father": "John Doe Sr.",
   * //    "mother": "Jane Doe"
   * //  }
   * // }
   *
   * // Emit parents as document.
   * firestore.pipeline().collection("people").replaceWith(field("parents"));
   *
   * // Output
   * // {
   * //  "father": "John Doe Sr.",
   * //  "mother": "Jane Doe"
   * // }
   * }</pre>
   *
   * @param expr The {@link Expression} field containing the nested map.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline replaceWith(Expression expr) {
    return append(new ReplaceWith(expr));
  }

  /**
   * Performs a pseudo-random sampling of the documents from the previous stage.
   *
   * <p>This stage will filter documents pseudo-randomly. The 'limit' parameter specifies the number
   * of documents to emit from this stage, but if there are fewer documents from previous stage than
   * the 'limit' parameter, then no filtering will occur and all documents will pass through.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Sample 10 books, if available.
   * firestore.pipeline().collection("books")
   *     .sample(10);
   * }</pre>
   *
   * @param limit The number of documents to emit, if possible.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline sample(int limit) {
    return sample(Sample.withDocLimit(limit));
  }

  /**
   * Performs a pseudo-random sampling of the documents from the previous stage.
   *
   * <p>This stage will filter documents pseudo-randomly. The 'options' parameter specifies how
   * sampling will be performed. See {@code SampleOptions} for more information.
   *
   * <p>Examples:
   *
   * <pre>{@code
   * // Sample 10 books, if available.
   * firestore.pipeline().collection("books")
   *     .sample(Sample.withDocLimit(10));
   *
   * // Sample 50% of books.
   * firestore.pipeline().collection("books")
   *     .sample(Sample.withPercentage(0.5));
   * }</pre>
   *
   * @param sample The {@code Sample} specifies how sampling is performed.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline sample(Sample sample) {
    return append(sample);
  }

  /**
   * Performs union of all documents from two pipelines, including duplicates.
   *
   * <p>This stage will pass through documents from previous stage, and also pass through documents
   * from previous stage of the `other` {@code Pipeline} given in parameter. The order of documents
   * emitted from this stage is undefined.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Emit documents from books collection and magazines collection.
   * firestore.pipeline().collection("books")
   *     .union(firestore.pipeline().collection("magazines"));
   * }</pre>
   *
   * @param other The other {@code Pipeline} that is part of union.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline union(Pipeline other) {
    return append(new Union(other));
  }

  /**
   * Produces a document for each element in array found in previous stage document.
   *
   * <p>For each previous stage document, this stage will emit zero or more augmented documents. The
   * input array found in the previous stage document field specified by the `fieldName` parameter,
   * will for each input array element produce an augmented document. The input array element will
   * augment the previous stage document by replacing the field specified by `fieldName` parameter
   * with the element value.
   *
   * <p>In other words, the field containing the input array will be removed from the augmented
   * document and replaced by the corresponding array element.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tags": [ "comedy", "space", "adventure" ], ... }
   *
   * // Emit a book document for each tag of the book.
   * firestore.pipeline().collection("books")
   *     .unnest("tags", "tag");
   *
   * // Output:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tag": "comedy", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tag": "space", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tag": "adventure", ... }
   * }</pre>
   *
   * @param fieldName The name of the field containing the array.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline unnest(String fieldName, String alias) {
    //    return unnest(field(fieldName));
    return append(new Unnest(field(fieldName), alias));
  }

  /**
   * Produces a document for each element in array found in previous stage document.
   *
   * <p>For each previous stage document, this stage will emit zero or more augmented documents. The
   * input array found in the previous stage document field specified by the `fieldName` parameter,
   * will for each input array element produce an augmented document. The input array element will
   * augment the previous stage document by replacing the field specified by `fieldName` parameter
   * with the element value.
   *
   * <p>In other words, the field containing the input array will be removed from the augmented
   * document and replaced by the corresponding array element.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tags": [ "comedy", "space", "adventure" ], ... }
   *
   * // Emit a book document for each tag of the book.
   * firestore.pipeline().collection("books")
   *     .unnest("tags", "tag", new UnnestOptions().withIndexField("tagIndex"));
   *
   * // Output:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 0, "tag": "comedy", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 1, "tag": "space", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 2, "tag": "adventure", ... }
   * }</pre>
   *
   * @param fieldName The name of the field containing the array.
   * @param options The {@code UnnestOptions} options.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline unnest(String fieldName, String alias, UnnestOptions options) {
    return append(new Unnest(field(fieldName), alias, options));
  }

  /**
   * Produces a document for each element in array found in previous stage document.
   *
   * <p>For each previous stage document, this stage will emit zero or more augmented documents. The
   * input array found in the previous stage document field specified by the `fieldName` parameter,
   * will for each input array element produce an augmented document. The input array element will
   * augment the previous stage document by replacing the field specified by `fieldName` parameter
   * with the element value.
   *
   * <p>In other words, the field containing the input array will be removed from the augmented
   * document and replaced by the corresponding array element.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tags": [ "comedy", "space", "adventure" ], ... }
   *
   * // Emit a book document for each tag of the book.
   * firestore.pipeline().collection("books")
   *     .unnest(field("tags").as("tag"));
   *
   * // Output:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 0, "tag": "comedy", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 1, "tag": "space", ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 2, "tag": "adventure", ... }
   * }</pre>
   *
   * @param expr The name of the expression containing the array.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline unnest(Selectable expr) {
    return append(new Unnest(expr));
  }

  /**
   * Produces a document for each element in array found in previous stage document.
   *
   * <p>For each previous stage document, this stage will emit zero or more augmented documents. The
   * input array found in the specified by {@code Selectable} expression parameter, will for each
   * input array element produce an augmented document. The input array element will augment the
   * previous stage document by assigning the {@code Selectable} alias the element value.
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Input:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tags": [ "comedy", "space",
   * "adventure" ], ... }
   *
   * // Emit a book document for each tag of the book.
   * firestore.pipeline().collection("books")
   *     .unnest(field("tags").as("tag"), UnnestOptions.indexField("tagIndex"));
   *
   * // Output:
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 0, "tag": "comedy",
   * "tags": [ "comedy", "space", "adventure" ], ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 1, "tag": "space", "tags":
   * [ "comedy", "space", "adventure" ], ... }
   * // { "title": "The Hitchhiker's Guide to the Galaxy", "tagIndex": 2, "tag": "adventure",
   * "tags": [ "comedy", "space", "adventure" ], ... }
   * }</pre>
   *
   * @param field The expression that evaluates to the input array.
   * @param options The {@code UnnestOptions} options.
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline unnest(Selectable field, UnnestOptions options) {
    return append(new Unnest(field, options));
  }

  /**
   * Adds a generic stage to the pipeline.
   *
   * <p>This method provides a flexible way to extend the pipeline's functionality by adding custom
   * stages. Each generic stage is defined by a unique `name` and a set of `params` that control its
   * behavior.
   *
   * <p>Example (Assuming there is no "where" stage available in SDK):
   *
   * <pre>{@code
   * // Assume we don't have a built-in "where" stage
   * Map<String, Object> whereParams = new HashMap<>();
   * whereParams.put("condition", field("published").lt(1900));
   *
   * firestore.pipeline().collection("books")
   *     .genericStage("where", Lists.newArrayList(field("published").lt(1900)), new RawOptions()) // Custom "where" stage
   *     .select("title", "author");
   * }</pre>
   *
   * @return A new {@code Pipeline} object with this stage appended to the stage list.
   */
  @BetaApi
  public Pipeline rawStage(RawStage stage) {
    return append(stage);
  }

  /**
   * Executes this pipeline and returns a future to represent the asynchronous operation.
   *
   * <p>The returned {@link ApiFuture} can be used to track the progress of the pipeline execution
   * and retrieve the results (or handle any errors) asynchronously.
   *
   * <p>The pipeline results are returned as a list of {@link PipelineResult} objects. Each {@link
   * PipelineResult} typically represents a single key/value map that has passed through all the
   * stages of the pipeline, however this might differ depends on the stages involved in the
   * pipeline. For example:
   *
   * <ul>
   *   <li>If there are no stages or only transformation stages, each {@link PipelineResult}
   *       represents a single document.
   *   <li>If there is an aggregation, only a single {@link PipelineResult} is returned,
   *       representing the aggregated results over the entire dataset .
   *   <li>If there is an aggregation stage with grouping, each {@link PipelineResult} represents a
   *       distinct group and its associated aggregated values.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * ApiFuture<Snapshot> futureResults = firestore.pipeline().collection("books")
   *     .where(gt("rating", 4.5))
   *     .select("title", "author", "rating")
   *     .execute();
   * }</pre>
   *
   * @return An {@link ApiFuture} representing the asynchronous pipeline execution.
   */
  @BetaApi
  public ApiFuture<Snapshot> execute() {
    return execute(new PipelineExecuteOptions(), null, null);
  }

  @BetaApi
  public ApiFuture<Snapshot> execute(PipelineExecuteOptions options) {
    return execute(options, null, null);
  }

  MetricsContext createMetricsContext(String methodName) {
    return rpcContext.getFirestore().getOptions().getMetricsUtil().createMetricsContext(methodName);
  }

  /**
   * Executes this pipeline, providing results to the given {@link ApiStreamObserver} as they become
   * available.
   *
   * <p>This method allows you to process pipeline results in a streaming fashion, rather than
   * waiting for the entire pipeline execution to complete. The provided {@link ApiStreamObserver}
   * will receive:
   *
   * <ul>
   *   <li>**onNext(PipelineResult):** Called for each {@link PipelineResult} produced by the
   *       pipeline. Each {@link PipelineResult} typically represents a single key/value map that
   *       has passed through all the stages. However, the exact structure might differ based on the
   *       stages involved in the pipeline (as described in {@link #execute()}).
   *   <li>**onError(Throwable):** Called if an error occurs during pipeline execution.
   *   <li>**onCompleted():** Called when the pipeline has finished processing all documents.
   * </ul>
   *
   * <p>Example:
   *
   * <pre>{@code
   * firestore.pipeline().collection("books")
   *     .where(gt("rating", 4.5))
   *     .select("title", "author", "rating")
   *     .execute(new ApiStreamObserver<PipelineResult>() {
   *         @Override
   *         public void onNext(PipelineResult result) {
   *             // Process each result as it arrives
   *             System.out.println(result.getData());
   *         }
   *
   *         @Override
   *         public void onError(Throwable t) {
   *             // Handle errors during execution
   *             t.printStackTrace();
   *         }
   *
   *         @Override
   *         public void onCompleted() {
   *             System.out.println("Pipeline execution completed.");
   *         }
   *     });
   * }</pre>
   *
   * @param observer The {@link ApiStreamObserver} to receive pipeline results and events.
   */
  @BetaApi
  public void execute(ApiStreamObserver<PipelineResult> observer) {
    MetricsContext metricsContext =
        createMetricsContext(TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE_EXECUTE);

    executeInternal(
        new PipelineExecuteOptions(),
        null,
        null,
        new PipelineResultObserver() {
          @Override
          public void onNext(PipelineResult result) {
            observer.onNext(result);
          }

          @Override
          public void onError(Throwable t) {
            observer.onError(t);
          }

          @Override
          public void onCompleted() {
            observer.onCompleted();
          }
        },
        metricsContext);
  }

  ApiFuture<Snapshot> execute(
      @Nonnull PipelineExecuteOptions options,
      @Nullable final ByteString transactionId,
      @Nullable com.google.protobuf.Timestamp readTime) {
    TraceUtil.Span span =
        rpcContext
            .getFirestore()
            .getOptions()
            .getTraceUtil()
            .startSpan(TelemetryConstants.METHOD_NAME_PIPELINE_EXECUTE);

    MetricsContext metricsContext =
        createMetricsContext(TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE_EXECUTE);

    try (Scope ignored = span.makeCurrent()) {
      SettableApiFuture<Snapshot> futureResult = SettableApiFuture.create();

      executeInternal(
          options,
          transactionId,
          readTime,
          new PipelineResultObserver() {
            final List<PipelineResult> results = new ArrayList<>();

            @Override
            public void onCompleted() {
              futureResult.set(
                  new Snapshot(Pipeline.this, results, getExecutionTime(), getExplainStats()));
            }

            @Override
            public void onNext(PipelineResult result) {
              results.add(result);
            }

            @Override
            public void onError(Throwable t) {
              futureResult.setException(t);
            }
          },
          metricsContext);

      span.endAtFuture(futureResult);
      return futureResult;
    } catch (Exception error) {
      span.end(error);
      metricsContext.recordLatency(MetricType.END_TO_END_LATENCY, error);
      throw error;
    }
  }

  void executeInternal(
      @Nonnull PipelineExecuteOptions options,
      @Nullable final ByteString transactionId,
      @Nullable com.google.protobuf.Timestamp readTime,
      PipelineResultObserver observer,
      MetricsContext metricsContext) {
    ExecutePipelineRequest.Builder request =
        ExecutePipelineRequest.newBuilder()
            .setDatabase(rpcContext.getDatabaseName())
            .setStructuredPipeline(
                StructuredPipeline.newBuilder()
                    .setPipeline(toProto())
                    .putAllOptions(StageUtils.toMap(options))
                    .build());

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    if (readTime != null) {
      request.setReadTime(readTime);
    }

    pipelineInternalStream(
        request.build(),
        new PipelineResultObserver() {
          @Override
          public void onCompleted() {
            observer.setExplainStats(getExplainStats());
            observer.setExecutionTime(getExecutionTime());
            observer.onCompleted();
          }

          @Override
          public void onNext(PipelineResult result) {
            observer.onNext(result);
          }

          @Override
          public void onError(Throwable t) {
            observer.onError(t);
          }
        },
        metricsContext);
  }

  @InternalApi
  private com.google.firestore.v1.Pipeline toProto() {
    return com.google.firestore.v1.Pipeline.newBuilder()
        .addAllStages(stages.transform(StageUtils::toStageProto))
        .build();
  }

  @InternalApi
  public com.google.firestore.v1.Value toProtoValue() {
    return Value.newBuilder().setPipelineValue(toProto()).build();
  }

  private void pipelineInternalStream(
      ExecutePipelineRequest request,
      PipelineResultObserver resultObserver,
      MetricsContext metricsContext) {
    TraceUtil traceUtil = rpcContext.getFirestore().getOptions().getTraceUtil();

    // To reduce the size of traces, we only register one event for every 100 responses
    // that we receive from the server.
    final int NUM_RESPONSES_PER_TRACE_EVENT = 100;

    TraceUtil.Span currentSpan = traceUtil.currentSpan();
    currentSpan.addEvent(
        TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE,
        new ImmutableMap.Builder<String, Object>()
            .put(ATTRIBUTE_KEY_IS_TRANSACTIONAL, request.hasTransaction())
            .build());

    ResponseObserver<ExecutePipelineResponse> observer =
        new ResponseObserver<ExecutePipelineResponse>() {
          Timestamp executionTime = null;
          boolean firstResponse = false;
          int numDocuments = 0;
          boolean hasCompleted = false;

          @Override
          public void onStart(StreamController controller) {
            // No action needed in onStart
          }

          @Override
          public void onResponse(ExecutePipelineResponse response) {
            if (!firstResponse) {
              firstResponse = true;
              currentSpan.addEvent(
                  TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE + ": First Response");
              metricsContext.recordLatency(MetricType.FIRST_RESPONSE_LATENCY);
            }

            if (response.hasExplainStats()) {
              resultObserver.setExplainStats(
                  new ExplainStats(response.getExplainStats().getData()));
            }

            if (response.hasExecutionTime()) {
              executionTime = Timestamp.fromProto(response.getExecutionTime());
            }

            if (response.getResultsCount() > 0) {
              numDocuments += response.getResultsCount();
              if (numDocuments % NUM_RESPONSES_PER_TRACE_EVENT == 0) {
                currentSpan.addEvent(
                    TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE
                        + ": Received "
                        + numDocuments
                        + " results");
              }

              for (Document doc : response.getResultsList()) {
                resultObserver.onNext(PipelineResult.fromDocument(rpcContext, executionTime, doc));
              }
            }
          }

          @Override
          public void onError(Throwable throwable) {
            currentSpan.addEvent(
                TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE + ": Error",
                ImmutableMap.of("error.message", throwable.toString()));
            metricsContext.recordLatency(MetricType.END_TO_END_LATENCY, throwable);
            resultObserver.onError(throwable);
          }

          @Override
          public void onComplete() {
            if (hasCompleted) {
              return;
            }
            hasCompleted = true;

            metricsContext.recordLatency(MetricType.END_TO_END_LATENCY);

            currentSpan.addEvent(
                TelemetryConstants.METHOD_NAME_EXECUTE_PIPELINE + ": Completed",
                ImmutableMap.of(ATTRIBUTE_KEY_DOC_COUNT, numDocuments));
            resultObserver.onCompleted(executionTime);
          }
        };

    logger.log(Level.FINEST, "Sending pipeline request: " + request.getStructuredPipeline());

    rpcContext.streamRequest(request, observer, rpcContext.getClient().executePipelineCallable());
  }

  private interface ResultObserver extends ApiStreamObserver<PipelineResult> {
    void onCompleted(Timestamp executionTime);

    void setExplainStats(ExplainStats explainStats);

    void setExecutionTime(Timestamp executionTime);
  }

  @InternalExtensionOnly
  abstract static class PipelineResultObserver implements ResultObserver {
    private Timestamp executionTime;
    private ExplainStats explainStats;

    @Override
    public void onCompleted(Timestamp executionTime) {
      this.executionTime = executionTime;
      this.onCompleted();
    }

    public Timestamp getExecutionTime() {
      return executionTime;
    }

    public ExplainStats getExplainStats() {
      return explainStats;
    }

    @Override
    public void setExplainStats(ExplainStats explainStats) {
      this.explainStats = explainStats;
    }

    @Override
    public void setExecutionTime(Timestamp executionTime) {
      this.executionTime = executionTime;
    }
  }
}
