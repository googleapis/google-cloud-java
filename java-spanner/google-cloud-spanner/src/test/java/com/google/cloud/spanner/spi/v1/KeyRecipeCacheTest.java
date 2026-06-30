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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.TextFormat;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyRecipeCacheTest {

  @Test
  public void fingerprintReadUsesShape() throws Exception {
    ReadRequest req =
        parseRead(
            "table: \"T\"\n"
                + "columns: \"c1\"\n"
                + "columns: \"c2\"\n"
                + "key_set { keys { values { string_value: \"foo\" } } }\n");

    long fp = KeyRecipeCache.fingerprint(req);
    assertNotEquals(0, fp);
    assertEquals(fp, KeyRecipeCache.fingerprint(req));

    ReadRequest diffTable = ReadRequest.newBuilder(req).setTable("U").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(diffTable));

    ReadRequest diffIndex = ReadRequest.newBuilder(req).setIndex("I").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(diffIndex));

    ReadRequest diffColumn = ReadRequest.newBuilder(req).setColumns(0, "c3").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(diffColumn));

    ReadRequest extraColumn = ReadRequest.newBuilder(req).addColumns("c4").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(extraColumn));

    ReadRequest removeColumn = ReadRequest.newBuilder(req).clearColumns().addColumns("c1").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(removeColumn));

    ReadRequest sameShape =
        ReadRequest.newBuilder(req)
            .clearKeySet()
            .setKeySet(req.getKeySet().toBuilder().build())
            .build();
    assertEquals(fp, KeyRecipeCache.fingerprint(sameShape));

    ReadRequest.Builder diffKeyValueBuilder = ReadRequest.newBuilder(req);
    diffKeyValueBuilder
        .getKeySetBuilder()
        .getKeysBuilder(0)
        .getValuesBuilder(0)
        .setStringValue("bar");
    ReadRequest diffKeyValue = diffKeyValueBuilder.build();
    assertEquals(fp, KeyRecipeCache.fingerprint(diffKeyValue));
  }

  @Test
  public void fingerprintExecuteSqlUsesParamShape() throws Exception {
    ExecuteSqlRequest req =
        parseExecuteSql(
            "sql: \"SELECT * FROM T WHERE p1 = @p1 AND p2 = @p2\"\n"
                + "params {\n"
                + "  fields { key: \"p1\" value { string_value: \"foo\" } }\n"
                + "  fields { key: \"p2\" value { string_value: \"99\" } }\n"
                + "}\n"
                + "param_types { key: \"p2\" value { code: INT64 } }\n"
                + "query_options {\n"
                + "  optimizer_version: \"1\"\n"
                + "  optimizer_statistics_package: \"stats\"\n"
                + "}\n");

    long fp = KeyRecipeCache.fingerprint(req);
    assertNotEquals(0, fp);
    assertEquals(fp, KeyRecipeCache.fingerprint(req));

    ExecuteSqlRequest diffSql = ExecuteSqlRequest.newBuilder(req).setSql("SELECT * FROM U").build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(diffSql));

    ExecuteSqlRequest.Builder removeParamBuilder = ExecuteSqlRequest.newBuilder(req);
    removeParamBuilder.getParamsBuilder().removeFields("p1");
    ExecuteSqlRequest removeParam = removeParamBuilder.build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(removeParam));

    ExecuteSqlRequest.Builder addParamBuilder = ExecuteSqlRequest.newBuilder(req);
    addParamBuilder.getParamsBuilder().putFields("p3", parseValue("string_value: \"foo\""));
    ExecuteSqlRequest addParam = addParamBuilder.build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(addParam));

    ExecuteSqlRequest changeType =
        ExecuteSqlRequest.newBuilder(req).putParamTypes("p1", parseType("code: BYTES")).build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(changeType));

    ExecuteSqlRequest.Builder changeParamValueBuilder = ExecuteSqlRequest.newBuilder(req);
    changeParamValueBuilder.getParamsBuilder().putFields("p1", parseValue("string_value: \"bar\""));
    ExecuteSqlRequest changeParamValue = changeParamValueBuilder.build();
    assertEquals(fp, KeyRecipeCache.fingerprint(changeParamValue));

    ExecuteSqlRequest.Builder changeKindBuilder = ExecuteSqlRequest.newBuilder(req);
    changeKindBuilder.getParamsBuilder().putFields("p1", parseValue("bool_value: true"));
    ExecuteSqlRequest changeKind = changeKindBuilder.build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(changeKind));

    ExecuteSqlRequest.Builder changeOptionsBuilder = ExecuteSqlRequest.newBuilder(req);
    changeOptionsBuilder.getQueryOptionsBuilder().setOptimizerStatisticsPackage("stats_v2");
    ExecuteSqlRequest changeOptions = changeOptionsBuilder.build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(changeOptions));

    ExecuteSqlRequest.Builder changeOptimizerBuilder = ExecuteSqlRequest.newBuilder(req);
    changeOptimizerBuilder.getQueryOptionsBuilder().setOptimizerVersion("2");
    ExecuteSqlRequest changeOptimizer = changeOptimizerBuilder.build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(changeOptimizer));

    ExecuteSqlRequest clearOptions = ExecuteSqlRequest.newBuilder(req).clearQueryOptions().build();
    assertNotEquals(fp, KeyRecipeCache.fingerprint(clearOptions));
  }

  @Test
  public void computeKeysSetsRoutingHint() throws Exception {
    KeyRecipeCache cache = new KeyRecipeCache();
    cache.addRecipes(
        parseRecipeList(
            "schema_generation: \"1\"\n"
                + "recipe {\n"
                + "  table_name: \"T\"\n"
                + "  part { tag: 1 }\n"
                + "  part {\n"
                + "    order: ASCENDING\n"
                + "    null_order: NULLS_FIRST\n"
                + "    type { code: STRING }\n"
                + "    identifier: \"k\"\n"
                + "  }\n"
                + "}\n"));

    ReadRequest.Builder request =
        parseRead(
            "table: \"T\"\n"
                + "columns: \"c1\"\n"
                + "key_set { keys { values { string_value: \"foo\" } } }\n")
            .toBuilder();

    cache.computeKeys(request);
    assertTrue(request.getRoutingHint().getOperationUid() > 0);
    assertEquals("1", request.getRoutingHint().getSchemaGeneration().toStringUtf8());
    assertTrue(request.getRoutingHint().getKey().size() > 0);
  }

  private static ReadRequest parseRead(String text) throws TextFormat.ParseException {
    ReadRequest.Builder builder = ReadRequest.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static ExecuteSqlRequest parseExecuteSql(String text) throws TextFormat.ParseException {
    ExecuteSqlRequest.Builder builder = ExecuteSqlRequest.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static com.google.protobuf.Value parseValue(String text)
      throws TextFormat.ParseException {
    com.google.protobuf.Value.Builder builder = com.google.protobuf.Value.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static com.google.spanner.v1.Type parseType(String text)
      throws TextFormat.ParseException {
    com.google.spanner.v1.Type.Builder builder = com.google.spanner.v1.Type.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static com.google.spanner.v1.RecipeList parseRecipeList(String text)
      throws TextFormat.ParseException {
    com.google.spanner.v1.RecipeList.Builder builder =
        com.google.spanner.v1.RecipeList.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }
}
