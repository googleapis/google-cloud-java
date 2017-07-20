/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.Trace;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Wrapper class to contain paged response types for page streaming methods. Each static class
 * inside this wrapper class is used as the return type of one of an API method that implements the
 * page streaming pattern.
 */
@Generated("by GAPIC")
@BetaApi
public class PagedResponseWrappers {

  public static class ListTracesPagedResponse
      extends AbstractPagedListResponse<
          ListTracesRequest, ListTracesResponse, Trace, ListTracesPage,
          ListTracesFixedSizeCollection> {

    public static ApiFuture<ListTracesPagedResponse> createAsync(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ApiFuture<ListTracesResponse> futureResponse) {
      ApiFuture<ListTracesPage> futurePage =
          ListTracesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTracesPage, ListTracesPagedResponse>() {
            @Override
            public ListTracesPagedResponse apply(ListTracesPage input) {
              return new ListTracesPagedResponse(input);
            }
          });
    }

    private ListTracesPagedResponse(ListTracesPage page) {
      super(page, ListTracesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTracesPage
      extends AbstractPage<ListTracesRequest, ListTracesResponse, Trace, ListTracesPage> {

    private ListTracesPage(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ListTracesResponse response) {
      super(context, response);
    }

    private static ListTracesPage createEmptyPage() {
      return new ListTracesPage(null, null);
    }

    @Override
    protected ListTracesPage createPage(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ListTracesResponse response) {
      return new ListTracesPage(context, response);
    }

    @Override
    public ApiFuture<ListTracesPage> createPageAsync(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ApiFuture<ListTracesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTracesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTracesRequest, ListTracesResponse, Trace, ListTracesPage,
          ListTracesFixedSizeCollection> {

    private ListTracesFixedSizeCollection(List<ListTracesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTracesFixedSizeCollection createEmptyCollection() {
      return new ListTracesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTracesFixedSizeCollection createCollection(
        List<ListTracesPage> pages, int collectionSize) {
      return new ListTracesFixedSizeCollection(pages, collectionSize);
    }
  }
}
