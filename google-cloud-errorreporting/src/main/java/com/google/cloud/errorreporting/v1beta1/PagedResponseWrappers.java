/*
 * Copyright 2017, Google LLC All rights reserved.
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
package com.google.cloud.errorreporting.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
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

  public static class ListGroupStatsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats, ListGroupStatsPage,
          ListGroupStatsFixedSizeCollection> {

    public static ApiFuture<ListGroupStatsPagedResponse> createAsync(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ApiFuture<ListGroupStatsResponse> futureResponse) {
      ApiFuture<ListGroupStatsPage> futurePage =
          ListGroupStatsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupStatsPage, ListGroupStatsPagedResponse>() {
            @Override
            public ListGroupStatsPagedResponse apply(ListGroupStatsPage input) {
              return new ListGroupStatsPagedResponse(input);
            }
          });
    }

    private ListGroupStatsPagedResponse(ListGroupStatsPage page) {
      super(page, ListGroupStatsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupStatsPage
      extends AbstractPage<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats, ListGroupStatsPage> {

    private ListGroupStatsPage(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ListGroupStatsResponse response) {
      super(context, response);
    }

    private static ListGroupStatsPage createEmptyPage() {
      return new ListGroupStatsPage(null, null);
    }

    @Override
    protected ListGroupStatsPage createPage(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ListGroupStatsResponse response) {
      return new ListGroupStatsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupStatsPage> createPageAsync(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ApiFuture<ListGroupStatsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupStatsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats, ListGroupStatsPage,
          ListGroupStatsFixedSizeCollection> {

    private ListGroupStatsFixedSizeCollection(List<ListGroupStatsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupStatsFixedSizeCollection createEmptyCollection() {
      return new ListGroupStatsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupStatsFixedSizeCollection createCollection(
        List<ListGroupStatsPage> pages, int collectionSize) {
      return new ListGroupStatsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEventsPagedResponse
      extends AbstractPagedListResponse<
          ListEventsRequest, ListEventsResponse, ErrorEvent, ListEventsPage,
          ListEventsFixedSizeCollection> {

    public static ApiFuture<ListEventsPagedResponse> createAsync(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      ApiFuture<ListEventsPage> futurePage =
          ListEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEventsPage, ListEventsPagedResponse>() {
            @Override
            public ListEventsPagedResponse apply(ListEventsPage input) {
              return new ListEventsPagedResponse(input);
            }
          });
    }

    private ListEventsPagedResponse(ListEventsPage page) {
      super(page, ListEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventsPage
      extends AbstractPage<ListEventsRequest, ListEventsResponse, ErrorEvent, ListEventsPage> {

    private ListEventsPage(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ListEventsResponse response) {
      super(context, response);
    }

    private static ListEventsPage createEmptyPage() {
      return new ListEventsPage(null, null);
    }

    @Override
    protected ListEventsPage createPage(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ListEventsResponse response) {
      return new ListEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListEventsPage> createPageAsync(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventsRequest, ListEventsResponse, ErrorEvent, ListEventsPage,
          ListEventsFixedSizeCollection> {

    private ListEventsFixedSizeCollection(List<ListEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventsFixedSizeCollection createEmptyCollection() {
      return new ListEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventsFixedSizeCollection createCollection(
        List<ListEventsPage> pages, int collectionSize) {
      return new ListEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
