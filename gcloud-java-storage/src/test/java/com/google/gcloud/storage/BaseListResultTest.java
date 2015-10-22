/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.Collections;

public class BaseListResultTest {

  @Test
  public void testListResult() throws Exception {
    ImmutableList<String> values = ImmutableList.of("1", "2");
    final BaseListResult<String> nextResult =
        new BaseListResult<>(null, "c", Collections.<String>emptyList());
    BaseListResult.NextPageFetcher<String> fetcher = new BaseListResult.NextPageFetcher<String>() {

      @Override
      public BaseListResult<String> nextPage() {
        return nextResult;
      }
    };
    BaseListResult<String> result = new BaseListResult<>(fetcher, "c", values);
    assertEquals(nextResult, result.nextPage());
    assertEquals("c", result.nextPageCursor());
    assertEquals(values, ImmutableList.copyOf(result.iterator()));

  }
}
