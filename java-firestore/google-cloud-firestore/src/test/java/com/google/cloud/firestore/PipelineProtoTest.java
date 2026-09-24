/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.WindowSpec;
import com.google.cloud.firestore.pipeline.stages.Search;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Function;
import com.google.firestore.v1.Pipeline.Stage;
import com.google.firestore.v1.Value;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PipelineProtoTest {

  @Test
  public void testSearchStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("foo")
            .search(
                Search.withQuery("foo")
                    .withLimit(1)
                    .withRetrievalDepth(2)
                    .withOffset(3)
                    //                    .withQueryEnhancement(Search.QueryEnhancement.REQUIRED)
                    .withLanguageCode("en-US")
                    .withSort(field("foo").ascending())
                    .withAddFields(constant(true).as("bar")));
    //                    .withSelect(field("id")));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage collectionStage = protoPipeline.getStages(0);
    assertThat(collectionStage.getName()).isEqualTo("collection");
    assertThat(collectionStage.getArgs(0).getReferenceValue()).isEqualTo("/foo");

    Stage searchStage = protoPipeline.getStages(1);
    assertThat(searchStage.getName()).isEqualTo("search");

    java.util.Map<String, Value> optionsMap = searchStage.getOptionsMap();

    // query
    Value query = optionsMap.get("query");
    assertThat(query).isNotNull();
    assertThat(query.getFunctionValue().getName()).isEqualTo("document_matches");
    assertThat(query.getFunctionValue().getArgs(0).getStringValue()).isEqualTo("foo");

    // limit
    assertThat(optionsMap.get("limit").getIntegerValue()).isEqualTo(1L);

    // retrieval_depth
    assertThat(optionsMap.get("retrieval_depth").getIntegerValue()).isEqualTo(2L);

    // offset
    assertThat(optionsMap.get("offset").getIntegerValue()).isEqualTo(3L);

    // query_enhancement
    //    assertThat(optionsMap.get("query_enhancement").getStringValue()).isEqualTo("required");

    // language_code
    assertThat(optionsMap.get("language_code").getStringValue()).isEqualTo("en-US");

    // select
    //    Value select = optionsMap.get("select");
    //    assertThat(select.getMapValue().getFieldsMap().get("id").getFieldReferenceValue())
    //        .isEqualTo("id");

    // sort
    Value sort = optionsMap.get("sort");
    java.util.Map<String, Value> sortEntry =
        sort.getArrayValue().getValues(0).getMapValue().getFieldsMap();
    assertThat(sortEntry.get("direction").getStringValue()).isEqualTo("ascending");
    assertThat(sortEntry.get("expression").getFieldReferenceValue()).isEqualTo("foo");

    // add_fields
    Value addFields = optionsMap.get("add_fields");
    assertThat(addFields.getMapValue().getFieldsMap().get("bar").getBooleanValue()).isTrue();
  }

  @Test
  public void testAddWindowFieldsProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("foo")
            .addWindowFields(
                WindowSpec.range(30, WindowSpec.CURRENT, "day")
                    .withSort(field("date").ascending())
                    .withPartition("department"),
                AggregateFunction.rawAggregate("sum", field("sales")).as("totalSales"));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage windowStage = protoPipeline.getStages(1);
    assertThat(windowStage.getName()).isEqualTo("add_window_fields");

    List<Value> args = windowStage.getArgsList();
    assertThat(args.size()).isEqualTo(2);

    // Arg 0: WindowSpec
    Map<String, Value> windowSpec = args.get(0).getMapValue().getFieldsMap();

    // Check partition
    ArrayValue partitionArray = windowSpec.get("partition").getArrayValue();
    assertThat(partitionArray.getValues(0).getFieldReferenceValue()).isEqualTo("department");

    // Check sort
    ArrayValue sortArray = windowSpec.get("sort").getArrayValue();
    Map<String, Value> sortEntry = sortArray.getValues(0).getMapValue().getFieldsMap();
    assertThat(sortEntry.get("direction").getStringValue()).isEqualTo("ascending");
    assertThat(sortEntry.get("expression").getFieldReferenceValue()).isEqualTo("date");

    // Check range frame
    Map<String, Value> rangeMap = windowSpec.get("range").getMapValue().getFieldsMap();
    assertThat(rangeMap.get("preceding").getIntegerValue()).isEqualTo(30L);
    assertThat(rangeMap.get("following").getStringValue()).isEqualTo("current");

    // Check unit. It is nested *inside* the range frame.
    assertThat(rangeMap.get("unit").getStringValue()).isEqualTo("day");
    assertThat(windowSpec).doesNotContainKey("unit");

    // Arg 1: Accumulators
    Map<String, Value> fieldsMap = args.get(1).getMapValue().getFieldsMap();
    Function totalSalesFunc = fieldsMap.get("totalSales").getFunctionValue();
    assertThat(totalSalesFunc.getName()).isEqualTo("sum");
    assertThat(totalSalesFunc.getArgs(0).getFieldReferenceValue()).isEqualTo("sales");
  }

  @Test
  public void testAccumulatorLevelOverIsWrappedInOverFunction() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("foo")
            .addWindowFields(
                WindowSpec.partition("department"),
                AggregateFunction.rawAggregate("sum", field("sales"))
                    .over(WindowSpec.documents(1, 1).withSort(field("date").ascending()))
                    .as("rollingSales"));

    Stage windowStage = pipeline.toProto().getStages(1);
    Function rolling =
        windowStage
            .getArgsList()
            .get(1)
            .getMapValue()
            .getFieldsMap()
            .get("rollingSales")
            .getFunctionValue();

    // The accumulator is wrapped: over(sum(sales), <windowSpec>).
    assertThat(rolling.getName()).isEqualTo("over");
    assertThat(rolling.getArgsCount()).isEqualTo(2);

    Function inner = rolling.getArgs(0).getFunctionValue();
    assertThat(inner.getName()).isEqualTo("sum");
    assertThat(inner.getArgs(0).getFieldReferenceValue()).isEqualTo("sales");

    // The second argument is the accumulator's own frame, not the stage's.
    Map<String, Value> innerWindow = rolling.getArgs(1).getMapValue().getFieldsMap();
    assertThat(innerWindow).doesNotContainKey("partition");
    Map<String, Value> documents = innerWindow.get("documents").getMapValue().getFieldsMap();
    assertThat(documents.get("preceding").getIntegerValue()).isEqualTo(1L);
    assertThat(documents.get("following").getIntegerValue()).isEqualTo(1L);

    // The stage-level spec still carries the partition.
    Map<String, Value> stageWindow = windowStage.getArgsList().get(0).getMapValue().getFieldsMap();
    assertThat(stageWindow.get("partition").getArrayValue().getValues(0).getFieldReferenceValue())
        .isEqualTo("department");
  }

  @Test
  public void testWindowlessAggregateUsesGlobalWindow() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("foo")
            .addWindowFields(AggregateFunction.rawAggregate("sum", field("sales")).as("total"));

    Stage windowStage = pipeline.toProto().getStages(1);
    assertThat(windowStage.getName()).isEqualTo("add_window_fields");

    // A global window encodes as an empty spec: no partition, no sort, no frame.
    assertThat(windowStage.getArgsList().get(0).getMapValue().getFieldsMap()).isEmpty();

    Function total =
        windowStage
            .getArgsList()
            .get(1)
            .getMapValue()
            .getFieldsMap()
            .get("total")
            .getFunctionValue();
    assertThat(total.getName()).isEqualTo("sum");
  }
}
