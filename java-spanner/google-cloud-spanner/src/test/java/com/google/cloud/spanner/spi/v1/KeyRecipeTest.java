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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.TextFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyRecipeTest {

  @Test
  public void queryParamsUsesStructIdentifiers() throws Exception {
    com.google.spanner.v1.KeyRecipe recipeProto =
        createRecipe(
            "part { tag: 1 }\n"
                + "part {\n"
                + "  order: ASCENDING\n"
                + "  null_order: NULLS_FIRST\n"
                + "  type { code: STRING }\n"
                + "  identifier: \"p0\"\n"
                + "  struct_identifiers: 1\n"
                + "}\n");

    Struct params =
        parseStruct(
            "fields {\n"
                + "  key: \"p0\"\n"
                + "  value {\n"
                + "    list_value { values { string_value: \"a\" } values { string_value: \"b\" }"
                + " }\n"
                + "  }\n"
                + "}\n");

    KeyRecipe recipe = KeyRecipe.create(recipeProto);
    TargetRange target = recipe.queryParamsToTargetRange(params);
    assertEquals(expectedKey("b"), target.start);
    assertTrue(target.limit.isEmpty());
  }

  @Test
  public void queryParamsUsesConstantValue() throws Exception {
    com.google.spanner.v1.KeyRecipe recipeProto =
        createRecipe(
            "part { tag: 1 }\n"
                + "part {\n"
                + "  order: ASCENDING\n"
                + "  null_order: NULLS_FIRST\n"
                + "  type { code: STRING }\n"
                + "  value { string_value: \"const\" }\n"
                + "}\n");

    KeyRecipe recipe = KeyRecipe.create(recipeProto);
    TargetRange target = recipe.queryParamsToTargetRange(Struct.getDefaultInstance());
    assertEquals(expectedKey("const"), target.start);
    assertTrue(target.limit.isEmpty());
  }

  @Test
  public void queryParamsCaseInsensitiveFallback() throws Exception {
    com.google.spanner.v1.KeyRecipe recipeProto =
        createRecipe(
            "part { tag: 1 }\n"
                + "part {\n"
                + "  order: ASCENDING\n"
                + "  null_order: NULLS_FIRST\n"
                + "  type { code: STRING }\n"
                + "  identifier: \"id\"\n"
                + "}\n");

    Struct params =
        parseStruct(
            "fields {\n" + "  key: \"Id\"\n" + "  value { string_value: \"foo\" }\n" + "}\n");

    KeyRecipe recipe = KeyRecipe.create(recipeProto);
    TargetRange target = recipe.queryParamsToTargetRange(params);
    assertEquals(expectedKey("foo"), target.start);
    assertTrue(target.limit.isEmpty());
  }

  @Test
  public void queryParamsCaseInsensitiveDuplicateUsesLastValue() throws Exception {
    com.google.spanner.v1.KeyRecipe recipeProto =
        createRecipe(
            "part { tag: 1 }\n"
                + "part {\n"
                + "  order: ASCENDING\n"
                + "  null_order: NULLS_FIRST\n"
                + "  type { code: STRING }\n"
                + "  identifier: \"ID\"\n"
                + "}\n");

    // Both "Id" and "id" normalize to "id"; the last one ("id"→"bar") wins.
    Struct params =
        parseStruct(
            "fields {\n"
                + "  key: \"Id\"\n"
                + "  value { string_value: \"foo\" }\n"
                + "}\n"
                + "fields {\n"
                + "  key: \"id\"\n"
                + "  value { string_value: \"bar\" }\n"
                + "}\n");

    KeyRecipe recipe = KeyRecipe.create(recipeProto);
    TargetRange target = recipe.queryParamsToTargetRange(params);
    assertEquals(expectedKey("bar"), target.start);
    assertFalse(target.approximate);
    assertTrue(target.limit.isEmpty());
  }

  @Test
  public void queryParamsCaseInsensitiveSafeForTurkishDotI() throws Exception {
    // Turkish upper-case İ (U+0130) lower-cases to two characters under Locale.ROOT
    // (i + combining dot above), so "SİCİL".length() != "SİCİL".toLowerCase(ROOT).length()
    // and "SİCİL".equalsIgnoreCase("SİCİL".toLowerCase(ROOT)) is false.
    // This is still safe because both the recipe identifier (server-sent) and the user's
    // bound parameter name go through the same Locale.ROOT lower-casing before the
    // HashMap lookup, so they produce the same string on both sides and the match succeeds.
    com.google.spanner.v1.KeyRecipe recipeProto =
        createRecipe(
            "part { tag: 1 }\n"
                + "part {\n"
                + "  order: ASCENDING\n"
                + "  null_order: NULLS_FIRST\n"
                + "  type { code: STRING }\n"
                + "  identifier: \"SİCİL\"\n"
                + "}\n");

    Struct params =
        parseStruct(
            "fields {\n" + "  key: \"SİCİL\"\n" + "  value { string_value: \"test\" }\n" + "}\n");

    KeyRecipe recipe = KeyRecipe.create(recipeProto);
    TargetRange target = recipe.queryParamsToTargetRange(params);
    assertEquals(expectedKey("test"), target.start);
    assertTrue(target.limit.isEmpty());
  }

  private static com.google.spanner.v1.KeyRecipe createRecipe(String text)
      throws TextFormat.ParseException {
    com.google.spanner.v1.KeyRecipe.Builder builder = com.google.spanner.v1.KeyRecipe.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static Struct parseStruct(String text) throws TextFormat.ParseException {
    Struct.Builder builder = Struct.newBuilder();
    TextFormat.merge(text, builder);
    return builder.build();
  }

  private static ByteString expectedKey(String value) {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendCompositeTag(out, 1);
    SsFormat.appendNotNullMarkerNullOrderedFirst(out);
    SsFormat.appendStringIncreasing(out, value);
    return ByteString.copyFrom(out.toByteArray());
  }
}
