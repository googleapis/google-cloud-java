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

import com.google.protobuf.TextFormat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import spanner.cloud.location.RecipeTestCase;
import spanner.cloud.location.RecipeTestCases;

@RunWith(JUnit4.class)
public class RecipeGoldenTest {

  // Pattern to match unknown TypeCode enum values (e.g., TOKENLIST) and replace with
  // TYPE_CODE_UNSPECIFIED. This handles cases where the textproto contains enum values
  // not yet available in the public API.
  private static final Pattern UNKNOWN_TYPE_CODE_PATTERN = Pattern.compile("code:\\s*TOKENLIST");

  @Test
  public void goldenTest() throws Exception {
    String content;
    try (InputStream inputStream =
            getClass().getClassLoader().getResourceAsStream("recipe_test.textproto");
        BufferedReader reader =
            new BufferedReader(
                new InputStreamReader(
                    Objects.requireNonNull(inputStream), StandardCharsets.UTF_8))) {
      content = reader.lines().collect(Collectors.joining("\n"));
    }

    // Replace unknown enum values with TYPE_CODE_UNSPECIFIED so parsing succeeds.
    // Test cases with unrecognized types will produce invalid recipes that get skipped.
    content = UNKNOWN_TYPE_CODE_PATTERN.matcher(content).replaceAll("code: TYPE_CODE_UNSPECIFIED");

    RecipeTestCases.Builder builder = RecipeTestCases.newBuilder();
    TextFormat.merge(content, builder);

    RecipeTestCases testCases = builder.build();

    for (RecipeTestCase testCase : testCases.getTestCaseList()) {
      if (testCase.getName().contains("Random")) {
        continue;
      }

      if (testCase.getRecipes().getRecipeCount() == 0) {
        continue;
      }

      KeyRecipe recipe;
      try {
        recipe = KeyRecipe.create(testCase.getRecipes().getRecipe(0));
      } catch (IllegalArgumentException e) {
        for (RecipeTestCase.Test test : testCase.getTestList()) {
          assertEquals(
              "Invalid recipe should result in approximate=true in test case: "
                  + testCase.getName(),
              true,
              test.getApproximate());
        }
        continue;
      }

      int testNum = 0;
      for (RecipeTestCase.Test test : testCase.getTestList()) {
        testNum++;

        TargetRange target;
        switch (test.getOperationCase()) {
          case KEY:
            target = recipe.keyToTargetRange(test.getKey());
            break;
          case KEY_RANGE:
            target = recipe.keyRangeToTargetRange(test.getKeyRange());
            break;
          case KEY_SET:
            target = recipe.keySetToTargetRange(test.getKeySet());
            break;
          case MUTATION:
            target = recipe.mutationToTargetRange(test.getMutation());
            break;
          case QUERY_PARAMS:
            target = recipe.queryParamsToTargetRange(test.getQueryParams());
            break;
          case OPERATION_NOT_SET:
          default:
            throw new UnsupportedOperationException("Unsupported operation in test case");
        }

        assertEquals(
            "Start mismatch in test case: " + testCase.getName() + " test #" + testNum,
            test.getStart(),
            target.start);
        assertEquals(
            "Limit mismatch in test case: " + testCase.getName() + " test #" + testNum,
            test.getLimit(),
            target.limit);
        assertEquals(
            "Approximate mismatch in test case: " + testCase.getName() + " test #" + testNum,
            test.getApproximate(),
            target.approximate);
      }
    }
  }
}
