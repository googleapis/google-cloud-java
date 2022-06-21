/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.stats;

import static com.google.common.truth.Truth.assertWithMessage;

import io.opencensus.stats.View;
import org.junit.Test;

public class BuiltinViewConstantsTest {
  @Test
  public void testBasicTagsExistForAllViews() {
    for (View v : BuiltinViews.BIGTABLE_BUILTIN_VIEWS) {
      assertWithMessage(v.getName() + " should have all basic tags")
          .that(v.getColumns())
          .containsAtLeast(
              BuiltinMeasureConstants.PROJECT_ID,
              BuiltinMeasureConstants.INSTANCE_ID,
              BuiltinMeasureConstants.APP_PROFILE,
              BuiltinMeasureConstants.METHOD,
              BuiltinMeasureConstants.ZONE,
              BuiltinMeasureConstants.CLUSTER,
              BuiltinMeasureConstants.TABLE);
    }
  }
}
