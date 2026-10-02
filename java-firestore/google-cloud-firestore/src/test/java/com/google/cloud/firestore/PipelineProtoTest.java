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

import static com.google.cloud.firestore.pipeline.expressions.Expression.add;
import static com.google.cloud.firestore.pipeline.expressions.Expression.constant;
import static com.google.cloud.firestore.pipeline.expressions.Expression.field;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.firestore.pipeline.stages.Insert;
import com.google.cloud.firestore.pipeline.stages.PipelineExecuteOptions;
import com.google.cloud.firestore.pipeline.stages.Search;
import com.google.cloud.firestore.pipeline.stages.Upsert;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.Pipeline.Stage;
import com.google.firestore.v1.Value;
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
  public void testInsertStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Test Book");

    Pipeline pipeline =
        firestore
            .pipeline()
            .literals(data)
            .insert(
                new com.google.cloud.firestore.pipeline.stages.Insert()
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage insertStage = protoPipeline.getStages(1);
    assertThat(insertStage.getName()).isEqualTo("insert");
    assertThat(insertStage.getArgsCount()).isEqualTo(0);

    java.util.Map<String, Value> optionsMap = insertStage.getOptionsMap();
    assertThat(optionsMap.get("collection").getReferenceValue()).isEqualTo("/books");
    assertThat(optionsMap.get("document_id").getStringValue()).isEqualTo("book1");

    // Test backward compatibility with withDocumentId
    Pipeline pipelineDeprecated =
        firestore
            .pipeline()
            .literals(data)
            .insert(
                new com.google.cloud.firestore.pipeline.stages.Insert()
                    .withCollection("books")
                    .withDocumentId(constant("book1")));
    Stage insertStageDeprecated = pipelineDeprecated.toProto().getStages(1);
    assertThat(insertStageDeprecated.getOptionsMap().get("document_id").getStringValue())
        .isEqualTo("book1");
  }

  @Test
  public void testUpsertStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Upsert Book");
    data.put("count", 1);

    Pipeline pipeline =
        firestore
            .pipeline()
            .literals(data)
            .upsert(
                new com.google.cloud.firestore.pipeline.stages.Upsert()
                    .withAdditionalFields(
                        com.google.cloud.firestore.pipeline.expressions.Expression.add(
                                field("count"), constant(1))
                            .as("count"))
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage upsertStage = protoPipeline.getStages(1);
    assertThat(upsertStage.getName()).isEqualTo("upsert");
    assertThat(upsertStage.getArgsCount()).isEqualTo(1);
    assertThat(upsertStage.getArgs(0).getMapValue().getFieldsMap()).containsKey("count");

    java.util.Map<String, Value> optionsMap = upsertStage.getOptionsMap();
    assertThat(optionsMap.get("collection").getReferenceValue()).isEqualTo("/books");
    assertThat(optionsMap.get("document_id").getStringValue()).isEqualTo("book1");

    // Test withAdditionalFields with List
    Pipeline pipelineWithList =
        firestore
            .pipeline()
            .literals(data)
            .upsert(
                new com.google.cloud.firestore.pipeline.stages.Upsert()
                    .withAdditionalFields(
                        java.util.Collections.singletonList(
                            com.google.cloud.firestore.pipeline.expressions.Expression.add(
                                    field("count"), constant(1))
                                .as("count")))
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));
    Stage upsertStageWithList = pipelineWithList.toProto().getStages(1);
    assertThat(upsertStageWithList.getArgs(0).getMapValue().getFieldsMap()).containsKey("count");

    // Test backward compatibility with withTransformedFields
    Pipeline pipelineWithTransformedFields =
        firestore
            .pipeline()
            .literals(data)
            .upsert(
                new com.google.cloud.firestore.pipeline.stages.Upsert()
                    .withTransformedFields(
                        com.google.cloud.firestore.pipeline.expressions.Expression.add(
                                field("count"), constant(1))
                            .as("count"))
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));
    Stage upsertStageWithTransformedFields = pipelineWithTransformedFields.toProto().getStages(1);
    assertThat(upsertStageWithTransformedFields.getArgs(0).getMapValue().getFieldsMap())
        .containsKey("count");

    // Test backward compatibility with withDocumentId
    Pipeline pipelineDeprecated =
        firestore
            .pipeline()
            .literals(data)
            .upsert(
                new com.google.cloud.firestore.pipeline.stages.Upsert(
                        com.google.cloud.firestore.pipeline.expressions.Expression.add(
                                field("count"), constant(1))
                            .as("count"))
                    .withCollection("books")
                    .withDocumentId(constant("book1")));
    Stage upsertStageDeprecated = pipelineDeprecated.toProto().getStages(1);
    assertThat(upsertStageDeprecated.getOptionsMap().get("document_id").getStringValue())
        .isEqualTo("book1");
  }

  @Test
  public void testAtomicExecutionOptionsConfigureNewTransactionAndAutoCommitTransaction() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Atomic Book");

    Pipeline pipeline =
        firestore
            .pipeline()
            .literals(data)
            .insert(
                new com.google.cloud.firestore.pipeline.stages.Insert()
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));

    PipelineExecuteOptions executeOptions = new PipelineExecuteOptions().withAtomic(true);
    ExecutePipelineRequest request = pipeline.toExecutePipelineRequest(executeOptions, null, null);

    assertThat(request.hasNewTransaction()).isTrue();
    assertThat(request.getNewTransaction().hasReadWrite()).isTrue();
    assertThat(request.getAutoCommitTransaction()).isTrue();
    assertThat(request.getStructuredPipeline().getOptionsMap()).doesNotContainKey("atomic");
  }

  @Test
  public void testNonAtomicExecutionOptionsDoNotConfigureNewTransactionOrAutoCommitTransaction() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Non-Atomic Book");

    Pipeline pipeline =
        firestore
            .pipeline()
            .literals(data)
            .insert(
                new com.google.cloud.firestore.pipeline.stages.Insert()
                    .withCollection("books")
                    .withDocumentIdExpression(constant("book1")));

    PipelineExecuteOptions executeOptionsDisabled = new PipelineExecuteOptions().withAtomic(false);
    ExecutePipelineRequest requestDisabled =
        pipeline.toExecutePipelineRequest(executeOptionsDisabled, null, null);
    assertThat(requestDisabled.hasNewTransaction()).isFalse();
    assertThat(requestDisabled.getAutoCommitTransaction()).isFalse();
    assertThat(requestDisabled.getStructuredPipeline().getOptionsMap()).doesNotContainKey("atomic");

    PipelineExecuteOptions executeOptionsDefault = new PipelineExecuteOptions();
    ExecutePipelineRequest requestDefault =
        pipeline.toExecutePipelineRequest(executeOptionsDefault, null, null);
    assertThat(requestDefault.hasNewTransaction()).isFalse();
    assertThat(requestDefault.getAutoCommitTransaction()).isFalse();
    assertThat(requestDefault.getStructuredPipeline().getOptionsMap()).doesNotContainKey("atomic");
  }

  @Test
  public void testDeleteStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    Pipeline pipeline = firestore.pipeline().collection("books").delete();

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage deleteStage = protoPipeline.getStages(1);
    assertThat(deleteStage.getName()).isEqualTo("delete");
    assertThat(deleteStage.getArgsCount()).isEqualTo(0);
    assertThat(deleteStage.getOptionsCount()).isEqualTo(0);
  }

  @Test
  public void testUpdateStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    // 0-arg update() produces 1 empty MapValue arg and 0 options
    Pipeline pipeline0 = firestore.pipeline().collection("books").update();
    com.google.firestore.v1.Pipeline protoPipeline0 = pipeline0.toProto();
    assertThat(protoPipeline0.getStagesCount()).isEqualTo(2);

    Stage updateStage0 = protoPipeline0.getStages(1);
    assertThat(updateStage0.getName()).isEqualTo("update");
    assertThat(updateStage0.getArgsCount()).isEqualTo(1);
    assertThat(updateStage0.getArgs(0).hasMapValue()).isTrue();
    assertThat(updateStage0.getArgs(0).getMapValue().getFieldsCount()).isEqualTo(0);
    assertThat(updateStage0.getOptionsCount()).isEqualTo(0);

    // update with vararg Selectables produces 1 MapValue arg with field mappings and 0 options
    Pipeline pipeline =
        firestore
            .pipeline()
            .collection("books")
            .update(constant("Updated").as("status"), add(field("count"), constant(1)).as("count"));
    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage updateStage = protoPipeline.getStages(1);
    assertThat(updateStage.getName()).isEqualTo("update");
    assertThat(updateStage.getArgsCount()).isEqualTo(1);
    assertThat(updateStage.getArgs(0).hasMapValue()).isTrue();
    java.util.Map<String, Value> fieldsMap = updateStage.getArgs(0).getMapValue().getFieldsMap();
    assertThat(fieldsMap).containsKey("status");
    assertThat(fieldsMap.get("status").getStringValue()).isEqualTo("Updated");
    assertThat(fieldsMap).containsKey("count");
    assertThat(updateStage.getOptionsCount()).isEqualTo(0);
  }

  @Test
  public void testInsertStageWithoutDocumentIdProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Auto ID Book");

    Pipeline pipeline =
        firestore.pipeline().literals(data).insert(new Insert().withCollection("books"));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage insertStage = protoPipeline.getStages(1);
    assertThat(insertStage.getName()).isEqualTo("insert");
    assertThat(insertStage.getArgsCount()).isEqualTo(0);

    java.util.Map<String, Value> optionsMap = insertStage.getOptionsMap();
    assertThat(optionsMap.get("collection").getReferenceValue()).isEqualTo("/books");
    assertThat(optionsMap).doesNotContainKey("document_id");
  }

  @Test
  public void testUpsertStageWithoutAdditionalFieldsProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> data = new java.util.HashMap<>();
    data.put("title", "Upsert Book");

    Pipeline pipeline =
        firestore
            .pipeline()
            .literals(data)
            .upsert(
                new Upsert().withCollection("books").withDocumentIdExpression(constant("book1")));

    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(2);

    Stage upsertStage = protoPipeline.getStages(1);
    assertThat(upsertStage.getName()).isEqualTo("upsert");
    assertThat(upsertStage.getArgsCount()).isEqualTo(1);
    assertThat(upsertStage.getArgs(0).hasMapValue()).isTrue();
    assertThat(upsertStage.getArgs(0).getMapValue().getFieldsCount()).isEqualTo(0);

    java.util.Map<String, Value> optionsMap = upsertStage.getOptionsMap();
    assertThat(optionsMap.get("collection").getReferenceValue()).isEqualTo("/books");
    assertThat(optionsMap.get("document_id").getStringValue()).isEqualTo("book1");
  }

  @Test
  public void testLiteralsStageProtoEncoding() {
    FirestoreOptions options =
        FirestoreOptions.newBuilder()
            .setProjectId("new-project")
            .setDatabaseId("(default)")
            .build();
    Firestore firestore = options.getService();

    java.util.Map<String, Object> doc1 = new java.util.HashMap<>();
    doc1.put("title", "Book 1");
    doc1.put("author", "Author 1");

    java.util.Map<String, Object> doc2 = new java.util.HashMap<>();
    doc2.put("title", "Book 2");
    doc2.put("calc", constant(42));

    Pipeline pipeline = firestore.pipeline().literals(doc1, doc2);
    com.google.firestore.v1.Pipeline protoPipeline = pipeline.toProto();
    assertThat(protoPipeline.getStagesCount()).isEqualTo(1);

    Stage literalsStage = protoPipeline.getStages(0);
    assertThat(literalsStage.getName()).isEqualTo("literals");
    assertThat(literalsStage.getArgsCount()).isEqualTo(2);
    assertThat(literalsStage.getOptionsCount()).isEqualTo(0);

    java.util.Map<String, Value> doc1Fields = literalsStage.getArgs(0).getMapValue().getFieldsMap();
    assertThat(doc1Fields.get("title").getStringValue()).isEqualTo("Book 1");
    assertThat(doc1Fields.get("author").getStringValue()).isEqualTo("Author 1");

    java.util.Map<String, Value> doc2Fields = literalsStage.getArgs(1).getMapValue().getFieldsMap();
    assertThat(doc2Fields.get("title").getStringValue()).isEqualTo("Book 2");
    assertThat(doc2Fields.get("calc").getIntegerValue()).isEqualTo(42L);
  }
}
