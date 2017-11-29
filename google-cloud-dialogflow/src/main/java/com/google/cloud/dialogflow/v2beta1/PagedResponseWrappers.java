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
package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
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

  public static class SearchAgentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage,
          SearchAgentsFixedSizeCollection> {

    public static ApiFuture<SearchAgentsPagedResponse> createAsync(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        ApiFuture<SearchAgentsResponse> futureResponse) {
      ApiFuture<SearchAgentsPage> futurePage =
          SearchAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAgentsPage, SearchAgentsPagedResponse>() {
            @Override
            public SearchAgentsPagedResponse apply(SearchAgentsPage input) {
              return new SearchAgentsPagedResponse(input);
            }
          });
    }

    private SearchAgentsPagedResponse(SearchAgentsPage page) {
      super(page, SearchAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAgentsPage
      extends AbstractPage<SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage> {

    private SearchAgentsPage(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        SearchAgentsResponse response) {
      super(context, response);
    }

    private static SearchAgentsPage createEmptyPage() {
      return new SearchAgentsPage(null, null);
    }

    @Override
    protected SearchAgentsPage createPage(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        SearchAgentsResponse response) {
      return new SearchAgentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAgentsPage> createPageAsync(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        ApiFuture<SearchAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage,
          SearchAgentsFixedSizeCollection> {

    private SearchAgentsFixedSizeCollection(List<SearchAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAgentsFixedSizeCollection createEmptyCollection() {
      return new SearchAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAgentsFixedSizeCollection createCollection(
        List<SearchAgentsPage> pages, int collectionSize) {
      return new SearchAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListContextsPagedResponse
      extends AbstractPagedListResponse<
          ListContextsRequest, ListContextsResponse, Context, ListContextsPage,
          ListContextsFixedSizeCollection> {

    public static ApiFuture<ListContextsPagedResponse> createAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      ApiFuture<ListContextsPage> futurePage =
          ListContextsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListContextsPage, ListContextsPagedResponse>() {
            @Override
            public ListContextsPagedResponse apply(ListContextsPage input) {
              return new ListContextsPagedResponse(input);
            }
          });
    }

    private ListContextsPagedResponse(ListContextsPage page) {
      super(page, ListContextsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContextsPage
      extends AbstractPage<ListContextsRequest, ListContextsResponse, Context, ListContextsPage> {

    private ListContextsPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      super(context, response);
    }

    private static ListContextsPage createEmptyPage() {
      return new ListContextsPage(null, null);
    }

    @Override
    protected ListContextsPage createPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      return new ListContextsPage(context, response);
    }

    @Override
    public ApiFuture<ListContextsPage> createPageAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContextsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContextsRequest, ListContextsResponse, Context, ListContextsPage,
          ListContextsFixedSizeCollection> {

    private ListContextsFixedSizeCollection(List<ListContextsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContextsFixedSizeCollection createEmptyCollection() {
      return new ListContextsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContextsFixedSizeCollection createCollection(
        List<ListContextsPage> pages, int collectionSize) {
      return new ListContextsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntityTypesPagedResponse
      extends AbstractPagedListResponse<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType, ListEntityTypesPage,
          ListEntityTypesFixedSizeCollection> {

    public static ApiFuture<ListEntityTypesPagedResponse> createAsync(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ApiFuture<ListEntityTypesResponse> futureResponse) {
      ApiFuture<ListEntityTypesPage> futurePage =
          ListEntityTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEntityTypesPage, ListEntityTypesPagedResponse>() {
            @Override
            public ListEntityTypesPagedResponse apply(ListEntityTypesPage input) {
              return new ListEntityTypesPagedResponse(input);
            }
          });
    }

    private ListEntityTypesPagedResponse(ListEntityTypesPage page) {
      super(page, ListEntityTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntityTypesPage
      extends AbstractPage<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType, ListEntityTypesPage> {

    private ListEntityTypesPage(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ListEntityTypesResponse response) {
      super(context, response);
    }

    private static ListEntityTypesPage createEmptyPage() {
      return new ListEntityTypesPage(null, null);
    }

    @Override
    protected ListEntityTypesPage createPage(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ListEntityTypesResponse response) {
      return new ListEntityTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntityTypesPage> createPageAsync(
        PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> context,
        ApiFuture<ListEntityTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntityTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType, ListEntityTypesPage,
          ListEntityTypesFixedSizeCollection> {

    private ListEntityTypesFixedSizeCollection(
        List<ListEntityTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntityTypesFixedSizeCollection createEmptyCollection() {
      return new ListEntityTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntityTypesFixedSizeCollection createCollection(
        List<ListEntityTypesPage> pages, int collectionSize) {
      return new ListEntityTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListIntentsPagedResponse
      extends AbstractPagedListResponse<
          ListIntentsRequest, ListIntentsResponse, Intent, ListIntentsPage,
          ListIntentsFixedSizeCollection> {

    public static ApiFuture<ListIntentsPagedResponse> createAsync(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ApiFuture<ListIntentsResponse> futureResponse) {
      ApiFuture<ListIntentsPage> futurePage =
          ListIntentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIntentsPage, ListIntentsPagedResponse>() {
            @Override
            public ListIntentsPagedResponse apply(ListIntentsPage input) {
              return new ListIntentsPagedResponse(input);
            }
          });
    }

    private ListIntentsPagedResponse(ListIntentsPage page) {
      super(page, ListIntentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIntentsPage
      extends AbstractPage<ListIntentsRequest, ListIntentsResponse, Intent, ListIntentsPage> {

    private ListIntentsPage(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ListIntentsResponse response) {
      super(context, response);
    }

    private static ListIntentsPage createEmptyPage() {
      return new ListIntentsPage(null, null);
    }

    @Override
    protected ListIntentsPage createPage(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ListIntentsResponse response) {
      return new ListIntentsPage(context, response);
    }

    @Override
    public ApiFuture<ListIntentsPage> createPageAsync(
        PageContext<ListIntentsRequest, ListIntentsResponse, Intent> context,
        ApiFuture<ListIntentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIntentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIntentsRequest, ListIntentsResponse, Intent, ListIntentsPage,
          ListIntentsFixedSizeCollection> {

    private ListIntentsFixedSizeCollection(List<ListIntentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIntentsFixedSizeCollection createEmptyCollection() {
      return new ListIntentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIntentsFixedSizeCollection createCollection(
        List<ListIntentsPage> pages, int collectionSize) {
      return new ListIntentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSessionEntityTypesPagedResponse
      extends AbstractPagedListResponse<
          ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType,
          ListSessionEntityTypesPage, ListSessionEntityTypesFixedSizeCollection> {

    public static ApiFuture<ListSessionEntityTypesPagedResponse> createAsync(
        PageContext<
                ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType>
            context,
        ApiFuture<ListSessionEntityTypesResponse> futureResponse) {
      ApiFuture<ListSessionEntityTypesPage> futurePage =
          ListSessionEntityTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSessionEntityTypesPage, ListSessionEntityTypesPagedResponse>() {
            @Override
            public ListSessionEntityTypesPagedResponse apply(ListSessionEntityTypesPage input) {
              return new ListSessionEntityTypesPagedResponse(input);
            }
          });
    }

    private ListSessionEntityTypesPagedResponse(ListSessionEntityTypesPage page) {
      super(page, ListSessionEntityTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSessionEntityTypesPage
      extends AbstractPage<
          ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType,
          ListSessionEntityTypesPage> {

    private ListSessionEntityTypesPage(
        PageContext<
                ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType>
            context,
        ListSessionEntityTypesResponse response) {
      super(context, response);
    }

    private static ListSessionEntityTypesPage createEmptyPage() {
      return new ListSessionEntityTypesPage(null, null);
    }

    @Override
    protected ListSessionEntityTypesPage createPage(
        PageContext<
                ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType>
            context,
        ListSessionEntityTypesResponse response) {
      return new ListSessionEntityTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListSessionEntityTypesPage> createPageAsync(
        PageContext<
                ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType>
            context,
        ApiFuture<ListSessionEntityTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSessionEntityTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSessionEntityTypesRequest, ListSessionEntityTypesResponse, SessionEntityType,
          ListSessionEntityTypesPage, ListSessionEntityTypesFixedSizeCollection> {

    private ListSessionEntityTypesFixedSizeCollection(
        List<ListSessionEntityTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSessionEntityTypesFixedSizeCollection createEmptyCollection() {
      return new ListSessionEntityTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSessionEntityTypesFixedSizeCollection createCollection(
        List<ListSessionEntityTypesPage> pages, int collectionSize) {
      return new ListSessionEntityTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
