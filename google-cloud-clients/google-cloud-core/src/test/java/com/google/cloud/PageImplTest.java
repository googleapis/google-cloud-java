/*
 * Copyright 2015 Google LLC
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

package com.google.cloud;

import static org.junit.Assert.assertEquals;

import com.google.api.gax.paging.Page;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class PageImplTest {

  private static final ImmutableList<String> VALUES = ImmutableList.of("1", "2");
  private static final ImmutableList<String> NEXT_VALUES = ImmutableList.of("3", "4");
  private static final ImmutableList<String> ALL_VALUES =
      ImmutableList.<String>builder().addAll(VALUES).addAll(NEXT_VALUES).build();

  private static class TestPageFetcher implements PageImpl.NextPageFetcher<String> {
    private static final long serialVersionUID = -8316752901403429976L;

    private final PageImpl<String> nextResult;

    TestPageFetcher(PageImpl<String> nextResult) {
      this.nextResult = nextResult;
    }

    @Override
    public Page<String> getNextPage() {
      return nextResult;
    }
  }

  @Test
  public void testPage() {
    final PageImpl<String> nextResult = new PageImpl<>(null, "c", NEXT_VALUES);
    PageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    PageImpl<String> result = new PageImpl<>(fetcher, "c", VALUES);
    assertEquals(nextResult, result.getNextPage());
    assertEquals("c", result.getNextPageToken());
    assertEquals(VALUES, result.getValues());
  }

  @Test
  public void testIterateAll() {
    final PageImpl<String> nextResult = new PageImpl<>(null, "c", NEXT_VALUES);
    PageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    PageImpl<String> result = new PageImpl<>(fetcher, "c", VALUES);
    assertEquals(ALL_VALUES, ImmutableList.copyOf(result.iterateAll()));
  }
}
