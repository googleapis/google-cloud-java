/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncPageImplTest {

  private static final ImmutableList<String> VALUES1 = ImmutableList.of("1", "2");
  private static final ImmutableList<String> VALUES2 = ImmutableList.of("3", "4");
  private static final ImmutableList<String> VALUES3 = ImmutableList.of("5", "6");
  private static final ImmutableList<String> ALL_VALUES = ImmutableList.<String>builder()
      .addAll(VALUES1)
      .addAll(VALUES2)
      .addAll(VALUES3)
      .build();
  private static final ImmutableList<String> SOME_VALUES = ImmutableList.<String>builder()
      .addAll(VALUES2)
      .addAll(VALUES3)
      .build();

  private static class TestPageFetcher implements AsyncPageImpl.NextPageFetcher<String> {
    private static final long serialVersionUID = 4703765400378593176L;

    private final AsyncPageImpl<String> nextResult;

    TestPageFetcher(AsyncPageImpl<String> nextResult) {
      this.nextResult = nextResult;
    }

    @Override
    public Future<AsyncPage<String>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<String>> getNextPage() {
      return Futures.<AsyncPage<String>>immediateFuture(nextResult);
    }
  }

  @Test
  public void testPage() {
    final AsyncPageImpl<String> nextResult = new AsyncPageImpl<>(null, "c", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher, "c", VALUES1);
    assertEquals(nextResult, result.getNextPage());
    assertEquals("c", result.getNextPageCursor());
    assertEquals(VALUES1, result.getValues());
  }

  @Test
  public void testPageDeprecated() {
    final AsyncPageImpl<String> nextResult = new AsyncPageImpl<>(null, "c", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher, "c", VALUES1);
    assertEquals(nextResult, result.nextPage());
    assertEquals("c", result.nextPageCursor());
    assertEquals(VALUES1, result.values());
  }

  @Test
  public void testPageAsync() throws ExecutionException, InterruptedException {
    final AsyncPageImpl<String> nextResult = new AsyncPageImpl<>(null, "c", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher, "c", VALUES1);
    assertEquals(nextResult, result.getNextPageAsync().get());
    assertEquals("c", result.getNextPageCursor());
    assertEquals(VALUES1, result.getValues());
  }

  @Test
  public void testPageAsyncDeprecated() throws ExecutionException, InterruptedException {
    final AsyncPageImpl<String> nextResult = new AsyncPageImpl<>(null, "c", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher = new TestPageFetcher(nextResult);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher, "c", VALUES1);
    assertEquals(nextResult, result.nextPageAsync().get());
    assertEquals("c", result.nextPageCursor());
    assertEquals(VALUES1, result.values());
  }

  @Test
  public void testIterateAll() {
    final AsyncPageImpl<String> nextResult2 = new AsyncPageImpl<>(null, "c3", VALUES3);
    AsyncPageImpl.NextPageFetcher<String> fetcher2 = new TestPageFetcher(nextResult2);
    final AsyncPageImpl<String> nextResult1 = new AsyncPageImpl<>(fetcher2, "c2", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher1 = new TestPageFetcher(nextResult1);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher1, "c1", VALUES1);
    assertEquals(ALL_VALUES, ImmutableList.copyOf(result.iterateAll()));
  }

  @Test
  public void testAsyncPageAndIterateAll() throws ExecutionException, InterruptedException {
    final AsyncPageImpl<String> nextResult2 = new AsyncPageImpl<>(null, "c3", VALUES3);
    AsyncPageImpl.NextPageFetcher<String> fetcher2 = new TestPageFetcher(nextResult2);
    final AsyncPageImpl<String> nextResult1 = new AsyncPageImpl<>(fetcher2, "c2", VALUES2);
    AsyncPageImpl.NextPageFetcher<String> fetcher1 = new TestPageFetcher(nextResult1);
    AsyncPageImpl<String> result = new AsyncPageImpl<>(fetcher1, "c1", VALUES1);
    assertEquals(nextResult1, result.getNextPageAsync().get());
    assertEquals("c1", result.getNextPageCursor());
    assertEquals(VALUES1, result.getValues());
    assertEquals(SOME_VALUES, ImmutableList.copyOf(result.getNextPageAsync().get().iterateAll()));
  }
}
