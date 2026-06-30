/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc.testing;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.UnaryCallable;
import java.util.List;

@InternalApi("for testing")
public class FakePagedApi {
  public static class PagedStashCallable extends UnaryCallable<Integer, List<Integer>> {

    ApiCallContext context;
    Integer request;
    List<List<Integer>> results;
    int currentResultToReturn = 0;

    public PagedStashCallable(List<List<Integer>> results) {
      this.results = results;
    }

    @Override
    public ApiFuture<List<Integer>> futureCall(Integer request, ApiCallContext context) {
      this.request = request;
      this.context = context;
      List<Integer> result = results.get(currentResultToReturn);
      currentResultToReturn += 1;
      return ApiFutures.immediateFuture(result);
    }
  }

  private static class StashPagedListDescriptor
      implements PagedListDescriptor<Integer, List<Integer>, Integer> {
    @Override
    public String emptyToken() {
      return "";
    }

    @Override
    public Integer injectToken(Integer payload, String token) {
      return Integer.parseInt(token);
    }

    @Override
    public String extractNextToken(List<Integer> payload) {
      int size = payload.size();
      return size == 0 ? emptyToken() : payload.get(size - 1).toString();
    }

    @Override
    public Iterable<Integer> extractResources(List<Integer> payload) {
      return payload;
    }

    @Override
    public Integer injectPageSize(Integer payload, int pageSize) {
      return payload;
    }

    @Override
    public Integer extractPageSize(Integer payload) {
      return 3;
    }
  }

  public static class ListIntegersPagedResponse
      extends AbstractPagedListResponse<
          Integer, List<Integer>, Integer, ListIntegersPage, ListIntegersSizedPage> {

    protected ListIntegersPagedResponse(ListIntegersPage page) {
      super(page, ListIntegersSizedPage.createEmptyCollection());
    }

    public static ListIntegersPagedResponse create(
        PageContext<Integer, List<Integer>, Integer> context, List<Integer> response) {
      ListIntegersPage page = new ListIntegersPage(context, response);
      return new ListIntegersPagedResponse(page);
    }

    public static ApiFuture<ListIntegersPagedResponse> create(
        PageContext<Integer, List<Integer>, Integer> context,
        ApiFuture<List<Integer>> futureResponse) {
      ApiFuture<ListIntegersPage> futurePage =
          new ListIntegersPage(null, null).createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIntegersPage, ListIntegersPagedResponse>() {
            @Override
            public ListIntegersPagedResponse apply(ListIntegersPage input) {
              return new ListIntegersPagedResponse(input);
            }
          },
          directExecutor());
    }
  }

  private static class ListIntegersPage
      extends AbstractPage<Integer, List<Integer>, Integer, ListIntegersPage> {

    public ListIntegersPage(
        PageContext<Integer, List<Integer>, Integer> context, List<Integer> response) {
      super(context, response);
    }

    @Override
    protected ListIntegersPage createPage(
        PageContext<Integer, List<Integer>, Integer> context, List<Integer> response) {
      return new ListIntegersPage(context, response);
    }
  }

  private static class ListIntegersSizedPage
      extends AbstractFixedSizeCollection<
          Integer, List<Integer>, Integer, ListIntegersPage, ListIntegersSizedPage> {

    private ListIntegersSizedPage(List<ListIntegersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIntegersSizedPage createEmptyCollection() {
      return new ListIntegersSizedPage(null, 0);
    }

    @Override
    protected ListIntegersSizedPage createCollection(
        List<ListIntegersPage> pages, int collectionSize) {
      return new ListIntegersSizedPage(pages, collectionSize);
    }
  }

  public static class ListIntegersPagedResponseFactory
      implements PagedListResponseFactory<Integer, List<Integer>, ListIntegersPagedResponse> {

    private final StashPagedListDescriptor streamingDescriptor = new StashPagedListDescriptor();

    @Override
    public ApiFuture<ListIntegersPagedResponse> getFuturePagedResponse(
        UnaryCallable<Integer, List<Integer>> callable,
        Integer request,
        ApiCallContext context,
        ApiFuture<List<Integer>> futureResponse) {
      PageContext<Integer, List<Integer>, Integer> pageContext =
          PageContext.create(callable, streamingDescriptor, request, context);
      return ListIntegersPagedResponse.create(pageContext, futureResponse);
    }
  }
}
