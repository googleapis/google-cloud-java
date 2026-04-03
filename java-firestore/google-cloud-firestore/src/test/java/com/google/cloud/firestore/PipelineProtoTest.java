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

import com.google.cloud.firestore.pipeline.stages.Search;
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
                    //                    .withLimit(1)
                    .withRetrievalDepth(2)
                    //                    .withOffset(3)
                    //                    .withQueryEnhancement(Search.QueryEnhancement.REQUIRED)
                    //                    .withLanguageCode("en-US")
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
    //    assertThat(optionsMap.get("limit").getIntegerValue()).isEqualTo(1L);

    // retrieval_depth
    assertThat(optionsMap.get("retrieval_depth").getIntegerValue()).isEqualTo(2L);

    // offset
    //    assertThat(optionsMap.get("offset").getIntegerValue()).isEqualTo(3L);

    // query_enhancement
    //    assertThat(optionsMap.get("query_enhancement").getStringValue()).isEqualTo("required");

    // language_code
    //    assertThat(optionsMap.get("language_code").getStringValue()).isEqualTo("en-US");

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
}
