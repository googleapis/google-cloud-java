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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.arrayAgg;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.arrayAggDistinct;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.average;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.count;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countAll;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countDistinct;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.countIf;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.first;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.last;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.maximum;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.minimum;
import static com.google.cloud.firestore.pipeline.expressions.AggregateFunction.sum;
import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.firestore.pipeline.expressions.WindowBound;
import com.google.cloud.firestore.pipeline.expressions.WindowFunction;
import com.google.cloud.firestore.pipeline.expressions.WindowSpec;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Function;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Pipeline.Stage;
import com.google.firestore.v1.Value;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Wire-format tests for the {@code add_window_fields} stage. */
@RunWith(JUnit4.class)
public class AddWindowFieldsProtoTest {

  // --------------------------------------------------------------------------------------------
  // Helpers
  // --------------------------------------------------------------------------------------------

  private Pipeline basePipeline() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    return options.getService().pipeline().collection("sales");
  }

  /**
   * Serializes {@code pipeline} the way {@code execute()} does and returns its {@code
   * add_window_fields} stage.
   */
  private Stage windowStage(Pipeline pipeline) {
    List<Stage> stages =
        pipeline.toProto().getStagesList().stream()
            .filter(it -> "add_window_fields".equals(it.getName()))
            .collect(Collectors.toList());
    assertThat(stages).hasSize(1);
    return stages.get(0);
  }

  /** The {@code window_spec} argument (args[0]) of the {@code add_window_fields} stage. */
  private Value windowSpecArg(Pipeline pipeline) {
    Stage stage = windowStage(pipeline);
    assertThat(stage.getArgsList()).hasSize(2);
    return stage.getArgsList().get(0);
  }

  /** The {@code fields} argument (args[1]) of the {@code add_window_fields} stage. */
  private Value fieldsArg(Pipeline pipeline) {
    Stage stage = windowStage(pipeline);
    assertThat(stage.getArgsList()).hasSize(2);
    return stage.getArgsList().get(1);
  }

  private Value fieldRef(String name) {
    return Value.newBuilder().setFieldReferenceValue(name).build();
  }

  private Value intVal(long value) {
    return Value.newBuilder().setIntegerValue(value).build();
  }

  private Value dbl(double value) {
    return Value.newBuilder().setDoubleValue(value).build();
  }

  private Value str(String value) {
    return Value.newBuilder().setStringValue(value).build();
  }

  private Map.Entry<String, Value> pair(String key, Value value) {
    return new AbstractMap.SimpleImmutableEntry<>(key, value);
  }

  @SafeVarargs
  private final Value map(Map.Entry<String, Value>... fields) {
    Map<String, Value> m = new LinkedHashMap<>();
    for (Map.Entry<String, Value> entry : fields) {
      m.put(entry.getKey(), entry.getValue());
    }
    return Value.newBuilder().setMapValue(MapValue.newBuilder().putAllFields(m)).build();
  }

  private Value array(Value... values) {
    return Value.newBuilder()
        .setArrayValue(ArrayValue.newBuilder().addAllValues(Arrays.asList(values)))
        .build();
  }

  private Value fn(String name, Value... args) {
    return Value.newBuilder()
        .setFunctionValue(Function.newBuilder().setName(name).addAllArgs(Arrays.asList(args)))
        .build();
  }

  private Value ordering(Value expression, String direction) {
    return map(pair("direction", str(direction)), pair("expression", expression));
  }

  private Value rangeSpec(Object preceding, Object following) {
    return windowSpecArg(
        basePipeline()
            .addWindowFields(
                WindowSpec.range(preceding, following).withSort(field("date").ascending()),
                countAll().as("c")));
  }

  // --------------------------------------------------------------------------------------------
  // Stage shape
  // --------------------------------------------------------------------------------------------

  @Test
  public void usesTheAddWindowFieldsStageNameAnd2Args() {
    Stage stage =
        windowStage(
            basePipeline().addWindowFields(WindowSpec.partition("product"), countAll().as("c")));

    assertThat(stage.getName()).isEqualTo("add_window_fields");
    assertThat(stage.getArgsList()).hasSize(2);
  }

  @Test
  public void doesNotSendAnyStageOptions() {
    Stage stage =
        windowStage(
            basePipeline().addWindowFields(WindowSpec.partition("product"), countAll().as("c")));

    assertThat(stage.getOptionsMap()).isEmpty();
  }

  // --------------------------------------------------------------------------------------------
  // window_spec
  // --------------------------------------------------------------------------------------------

  @Test
  public void serializesAnEmptyWindowSpecAsAnEmptyMap() {
    assertThat(windowSpecArg(basePipeline().addWindowFields(new WindowSpec(), countAll().as("c"))))
        .isEqualTo(map());
  }

  @Test
  public void serializesAPartitionOfFieldNameStrings() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product", "region"), countAll().as("c"))))
        .isEqualTo(map(pair("partition", array(fieldRef("product"), fieldRef("region")))));
  }

  @Test
  public void serializesAPartitionOfExpressions() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition(field("product"), field("region").toLower()),
                        countAll().as("c"))))
        .isEqualTo(
            map(pair("partition", array(fieldRef("product"), fn("to_lower", fieldRef("region"))))));
  }

  @Test
  public void serializesANestedFieldPathPartition() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(WindowSpec.partition("metadata.region"), countAll().as("c"))))
        .isEqualTo(map(pair("partition", array(fieldRef("metadata.region")))));
  }

  @Test
  public void serializesASingleSortOrdering() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()), countAll().as("c"))))
        .isEqualTo(map(pair("sort", array(ordering(fieldRef("date"), "ascending")))));
  }

  @Test
  public void serializesMultipleSortOrderingsWithMixedDirections() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(
                            field("date").ascending(), field("salesPrice").descending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair(
                    "sort",
                    array(
                        ordering(fieldRef("date"), "ascending"),
                        ordering(fieldRef("salesPrice"), "descending")))));
  }

  @Test
  public void serializesPartitionAndSortTogether() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product").withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("partition", array(fieldRef("product"))),
                pair("sort", array(ordering(fieldRef("date"), "ascending")))));
  }

  @Test
  public void omitsAnUnsetPartition() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()), countAll().as("c"))))
        .isEqualTo(map(pair("sort", array(ordering(fieldRef("date"), "ascending")))));
  }

  @Test
  public void omitsAnUnsetSort() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(WindowSpec.partition("product"), countAll().as("c"))))
        .isEqualTo(map(pair("partition", array(fieldRef("product")))));
  }

  @Test
  public void omitsTheFrameWhenUsingDefaultFraming() {
    Value spec =
        windowSpecArg(
            basePipeline()
                .addWindowFields(WindowSpec.sort(field("date").ascending()), countAll().as("c")));

    assertThat(spec.getMapValue().getFieldsMap()).doesNotContainKey("documents");
    assertThat(spec.getMapValue().getFieldsMap()).doesNotContainKey("range");
  }

  // --------------------------------------------------------------------------------------------
  // Stage level documents framing
  // --------------------------------------------------------------------------------------------

  @Test
  public void serializesNumericOffsetsAsIntegers() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(2, 1).withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(2)), pair("following", intVal(1))))));
  }

  /**
   * A zero offset is a real numeric bound and must not be coerced into the {@code current}
   * sentinel.
   */
  @Test
  public void serializesZeroOffsets() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(0, 0).withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(0)), pair("following", intVal(0))))));
  }

  /**
   * A zero offset and {@link WindowBound#CURRENT} are <i>different</i> frame boundaries and must
   * never be conflated.
   *
   * <p>In a {@code range} frame {@code current} cuts off strictly at the current document's
   * position, whereas an offset of {@code 0} additionally admits every document whose sort value
   * ties with the current one. Given sort values {@code [10, 10, 10]}, evaluating at the second
   * document with an unbounded lower bound yields two documents under {@code current} but three
   * under {@code 0}. They must therefore reach the backend as distinct values.
   */
  @Test
  public void distinguishesZeroOffsetFromCurrentBound() {
    Value zeroOffset = rangeSpec(0, 0);
    Value currentBound = rangeSpec(WindowSpec.CURRENT, WindowSpec.CURRENT);

    assertThat(zeroOffset)
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair("range", map(pair("preceding", intVal(0)), pair("following", intVal(0))))));
    assertThat(currentBound)
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "range",
                    map(pair("preceding", str("current")), pair("following", str("current"))))));
    assertThat(zeroOffset).isNotEqualTo(currentBound);

    // The distinction must also survive canonicalization, which backs WindowSpec equality.
    assertThat(WindowSpec.range(0, 0))
        .isNotEqualTo(WindowSpec.range(WindowSpec.CURRENT, WindowSpec.CURRENT));
  }

  /** {@code UNBOUNDED} is likewise a symbolic bound, not a reserved numeric value. */
  @Test
  public void treatsExtremeIntegerOffsetsAsNumbers() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(Integer.MAX_VALUE, Integer.MIN_VALUE)
                            .withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents",
                    map(
                        pair("preceding", intVal((long) Integer.MAX_VALUE)),
                        pair("following", intVal((long) Integer.MIN_VALUE))))));
  }

  @Test
  public void serializesNegativeOffsetsForLookAheadWindows() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(-1, 2).withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents",
                    map(pair("preceding", intVal(-1)), pair("following", intVal(2))))));
  }

  @Test
  public void serializesTheUnboundedAndCurrentSentinels() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(WindowSpec.UNBOUNDED, WindowSpec.CURRENT)
                            .withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents",
                    map(pair("preceding", str("unbounded")), pair("following", str("current"))))));
  }

  @Test
  public void serializesAnUnboundedToUnboundedFrame() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(WindowSpec.UNBOUNDED, WindowSpec.UNBOUNDED),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair(
                    "documents",
                    map(
                        pair("preceding", str("unbounded")),
                        pair("following", str("unbounded"))))));
  }

  @Test
  public void serializesConstantExpressionBounds() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents(constant(3), constant(0))
                            .withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(3)), pair("following", intVal(0))))));
  }

  // --------------------------------------------------------------------------------------------
  // Stage level range framing
  // --------------------------------------------------------------------------------------------

  @Test
  public void serializesNumericRangeOffsets() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.range(10, 10).withSort(field("salesPrice").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("salesPrice"), "ascending"))),
                pair("range", map(pair("preceding", intVal(10)), pair("following", intVal(10))))));
  }

  /**
   * Regression test for DL-4: fractional bounds must not be truncated to integers.
   *
   * <p>Uses the mixed {@code (Object, Object)} overload so that, as in JS, {@code 2.5} encodes as a
   * double while {@code 0} stays an integer.
   */
  @Test
  public void serializesFractionalRangeOffsetsAsDoubles() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.range((Object) 2.5, (Object) 0)
                            .withSort(field("salesPrice").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("salesPrice"), "ascending"))),
                pair("range", map(pair("preceding", dbl(2.5)), pair("following", intVal(0))))));
  }

  /** Regression test for DL-2: {@code unit} belongs inside the frame, not beside it. */
  @Test
  public void serializesARangeFrameWithADayTimeUnit() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.range(30, WindowSpec.CURRENT, "day")
                            .withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "range",
                    map(
                        pair("preceding", intVal(30)),
                        pair("following", str("current")),
                        pair("unit", str("day"))))));
  }

  @Test
  public void serializesEveryTimeUnit() {
    List<String> units =
        Arrays.asList(
            "microsecond",
            "millisecond",
            "second",
            "minute",
            "hour",
            "day",
            "week",
            "month",
            "quarter",
            "year");

    for (String unit : units) {
      Value spec =
          windowSpecArg(
              basePipeline()
                  .addWindowFields(
                      WindowSpec.range(1, WindowSpec.CURRENT, unit)
                          .withSort(field("date").ascending()),
                      countAll().as("c")));

      assertThat(spec.getMapValue().getFieldsMap().get("range"))
          .isEqualTo(
              map(
                  pair("preceding", intVal(1)),
                  pair("following", str("current")),
                  pair("unit", str(unit))));
    }
  }

  @Test
  public void omitsUnitWhenItIsNotSpecified() {
    Value spec =
        windowSpecArg(
            basePipeline()
                .addWindowFields(
                    WindowSpec.range(WindowSpec.UNBOUNDED, WindowSpec.CURRENT)
                        .withSort(field("salesPrice").ascending()),
                    countAll().as("c")));

    assertThat(spec.getMapValue().getFieldsMap().get("range"))
        .isEqualTo(map(pair("preceding", str("unbounded")), pair("following", str("current"))));
  }

  // --------------------------------------------------------------------------------------------
  // Fields
  // --------------------------------------------------------------------------------------------

  @Test
  public void mapsEachAliasToItsAggregateFunction() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product"),
                        sum("salesPrice").as("total"),
                        countAll().as("c"))))
        .isEqualTo(map(pair("total", fn("sum", fieldRef("salesPrice"))), pair("c", fn("count"))));
  }

  @Test
  public void supportsNestedOutputFieldPaths() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product"), sum("salesPrice").as("stats.total"))))
        .isEqualTo(map(pair("stats.total", fn("sum", fieldRef("salesPrice")))));
  }

  @Test
  public void serializesAllSupportedAggregateFunctionNames() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product"),
                        countAll().as("countAll"),
                        count("salesPrice").as("count"),
                        countIf(field("salesPrice").greaterThan(10)).as("countIf"),
                        countDistinct("salesPrice").as("countDistinct"),
                        sum("salesPrice").as("sum"),
                        average("salesPrice").as("average"),
                        minimum("salesPrice").as("minimum"),
                        maximum("salesPrice").as("maximum"),
                        first("salesPrice").as("first"),
                        last("salesPrice").as("last"),
                        arrayAgg("salesPrice").as("arrayAgg"),
                        arrayAggDistinct("salesPrice").as("arrayAggDistinct"))))
        .isEqualTo(
            map(
                pair("countAll", fn("count")),
                pair("count", fn("count", fieldRef("salesPrice"))),
                pair(
                    "countIf",
                    fn("count_if", fn("greater_than", fieldRef("salesPrice"), intVal(10)))),
                pair("countDistinct", fn("count_distinct", fieldRef("salesPrice"))),
                pair("sum", fn("sum", fieldRef("salesPrice"))),
                pair("average", fn("average", fieldRef("salesPrice"))),
                pair("minimum", fn("minimum", fieldRef("salesPrice"))),
                pair("maximum", fn("maximum", fieldRef("salesPrice"))),
                pair("first", fn("first", fieldRef("salesPrice"))),
                pair("last", fn("last", fieldRef("salesPrice"))),
                pair("arrayAgg", fn("array_agg", fieldRef("salesPrice"))),
                pair("arrayAggDistinct", fn("array_agg_distinct", fieldRef("salesPrice")))));
  }

  @Test
  public void serializesAggregatesOverComputedExpressions() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product"),
                        sum(field("salesPrice").multiply(2)).as("doubled"))))
        .isEqualTo(
            map(pair("doubled", fn("sum", fn("multiply", fieldRef("salesPrice"), intVal(2))))));
  }

  @Test
  public void serializesTheRankingWindowFunctions() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("salesPrice").descending()),
                        WindowFunction.rank().as("rank"),
                        WindowFunction.denseRank().as("denseRank"),
                        WindowFunction.rowNumber().as("rowNumber"))))
        .isEqualTo(
            map(
                pair("rank", fn("rank")),
                pair("denseRank", fn("dense_rank")),
                pair("rowNumber", fn("row_number"))));
  }

  @Test
  public void rejectsDuplicateAliases() {
    IllegalArgumentException error = null;
    try {
      basePipeline()
          .addWindowFields(
              WindowSpec.partition("product"),
              sum("salesPrice").as("total"),
              average("salesPrice").as("total"));
    } catch (IllegalArgumentException e) {
      error = e;
    }

    assertThat(error).isNotNull();
    assertThat(error).hasMessageThat().contains("total");
  }

  // --------------------------------------------------------------------------------------------
  // Accumulator level framing (over)
  // --------------------------------------------------------------------------------------------

  @Test
  public void wrapsAnAggregateInOverWithADocumentsFrame() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()),
                        average("salesPrice")
                            .over(WindowSpec.documents(1, 1))
                            .as("movingAverage"))))
        .isEqualTo(
            map(
                pair(
                    "movingAverage",
                    fn(
                        "over",
                        fn("average", fieldRef("salesPrice")),
                        map(
                            pair(
                                "documents",
                                map(
                                    pair("preceding", intVal(1)),
                                    pair("following", intVal(1)))))))));
  }

  @Test
  public void wrapsAnAggregateInOverWithARangeFrameAndTimeUnit() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()),
                        sum("salesPrice").over(WindowSpec.range(10, 0, "day")).as("tenDayTotal"))))
        .isEqualTo(
            map(
                pair(
                    "tenDayTotal",
                    fn(
                        "over",
                        fn("sum", fieldRef("salesPrice")),
                        map(
                            pair(
                                "range",
                                map(
                                    pair("preceding", intVal(10)),
                                    pair("following", intVal(0)),
                                    pair("unit", str("day")))))))));
  }

  @Test
  public void supportsDifferentFramesForDifferentAccumulators() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.partition("product").withSort(field("date").ascending()),
                        sum("salesPrice")
                            .over(WindowSpec.documents(WindowSpec.UNBOUNDED, WindowSpec.CURRENT))
                            .as("runningTotal"),
                        average("salesPrice")
                            .over(WindowSpec.documents(1, 1))
                            .as("movingAverage"))))
        .isEqualTo(
            map(
                pair(
                    "runningTotal",
                    fn(
                        "over",
                        fn("sum", fieldRef("salesPrice")),
                        map(
                            pair(
                                "documents",
                                map(
                                    pair("preceding", str("unbounded")),
                                    pair("following", str("current"))))))),
                pair(
                    "movingAverage",
                    fn(
                        "over",
                        fn("average", fieldRef("salesPrice")),
                        map(
                            pair(
                                "documents",
                                map(
                                    pair("preceding", intVal(1)),
                                    pair("following", intVal(1)))))))));
  }

  @Test
  public void doesNotWrapInOverWhenNoFrameIsProvided() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()), sum("salesPrice").as("total"))))
        .isEqualTo(map(pair("total", fn("sum", fieldRef("salesPrice")))));
  }

  @Test
  public void supportsOverOnARankingWindowFunction() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()),
                        WindowFunction.rank()
                            .over(WindowSpec.documents(WindowSpec.UNBOUNDED, WindowSpec.CURRENT))
                            .as("r"))))
        .isEqualTo(
            map(
                pair(
                    "r",
                    fn(
                        "over",
                        fn("rank"),
                        map(
                            pair(
                                "documents",
                                map(
                                    pair("preceding", str("unbounded")),
                                    pair("following", str("current")))))))));
  }

  // The SDK does not reject `partition`/`sort` in `over()`. They are encoded into the same window
  // spec map as the frame, and the backend responds with
  // `Window frame has unexpected fields: [partition]`. Leaving this to the backend means
  // accumulator level partitioning starts working without an SDK change if the backend ever
  // supports it.
  @Test
  public void encodesAPartitionSuppliedToOver() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()),
                        sum("salesPrice")
                            .over(WindowSpec.partition("product").withDocuments(1, 1))
                            .as("total"))))
        .isEqualTo(
            map(
                pair(
                    "total",
                    fn(
                        "over",
                        fn("sum", fieldRef("salesPrice")),
                        map(
                            pair("partition", array(fieldRef("product"))),
                            pair(
                                "documents",
                                map(
                                    pair("preceding", intVal(1)),
                                    pair("following", intVal(1)))))))));
  }

  @Test
  public void encodesASortSuppliedToOver() {
    assertThat(
            fieldsArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending()),
                        sum("salesPrice")
                            .over(WindowSpec.documents(1, 1).withSort(field("date").ascending()))
                            .as("total"))))
        .isEqualTo(
            map(
                pair(
                    "total",
                    fn(
                        "over",
                        fn("sum", fieldRef("salesPrice")),
                        map(
                            pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                            pair(
                                "documents",
                                map(
                                    pair("preceding", intVal(1)),
                                    pair("following", intVal(1)))))))));
  }

  // --------------------------------------------------------------------------------------------
  // Frame state, and combinations left for the backend to validate
  //
  // The frame is a one-of, so `documents`/`range` cannot both be set: the builder makes that state
  // unrepresentable rather than encoding it. Everything else that is merely *invalid* — unknown
  // bound strings, out-of-order bounds — is still encoded and sent, because the backend owns
  // validation and returns a precise error. That keeps the SDK from having to change whenever the
  // backend relaxes or extends a rule.
  // --------------------------------------------------------------------------------------------

  /**
   * {@code documents} and {@code range} are mutually exclusive, so the last frame call wins and the
   * previous frame is dropped rather than both being encoded.
   */
  @Test
  public void lastFrameCallWinsWhenSwitchingFrameKind() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending())
                            .withDocuments(1, 1)
                            .withRange(2, 2),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair("range", map(pair("preceding", intVal(2)), pair("following", intVal(2))))));

    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending())
                            .withRange(2, 2)
                            .withDocuments(1, 1),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(1)), pair("following", intVal(1))))));
  }

  /** Repeating the same frame kind also takes the last call. */
  @Test
  public void lastFrameCallWinsWhenRepeatingFrameKind() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending())
                            .withDocuments(1, 1)
                            .withDocuments(3, 4),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(3)), pair("following", intVal(4))))));
  }

  /**
   * {@code unit} belongs to the range frame, so replacing the frame must not leak a unit from an
   * earlier call into a frame that never specified one.
   */
  @Test
  public void replacingAFrameDropsAStaleUnit() {
    // range -> range without a unit
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending())
                            .withRange(1, 2, "day")
                            .withRange(3, 4),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair("range", map(pair("preceding", intVal(3)), pair("following", intVal(4))))));

    // range -> documents; the backend rejects a unit on a documents frame outright
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.sort(field("date").ascending())
                            .withRange(1, 2, "day")
                            .withDocuments(3, 4),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents", map(pair("preceding", intVal(3)), pair("following", intVal(4))))));
  }

  /** Regression test for DL-5: unknown bound strings go to the backend, not an exception. */
  @Test
  public void passesThroughAnUnrecognizedFrameBoundString() {
    assertThat(
            windowSpecArg(
                basePipeline()
                    .addWindowFields(
                        WindowSpec.documents((Object) "infinite", (Object) "current")
                            .withSort(field("date").ascending()),
                        countAll().as("c"))))
        .isEqualTo(
            map(
                pair("sort", array(ordering(fieldRef("date"), "ascending"))),
                pair(
                    "documents",
                    map(pair("preceding", str("infinite")), pair("following", str("current"))))));
  }
}
