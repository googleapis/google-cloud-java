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
package com.google.cloud.bigquery.datatransfer.v1;

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

  public static class ListDataSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    public static ApiFuture<ListDataSourcesPagedResponse> createAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      ApiFuture<ListDataSourcesPage> futurePage =
          ListDataSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDataSourcesPage, ListDataSourcesPagedResponse>() {
            @Override
            public ListDataSourcesPagedResponse apply(ListDataSourcesPage input) {
              return new ListDataSourcesPagedResponse(input);
            }
          });
    }

    private ListDataSourcesPagedResponse(ListDataSourcesPage page) {
      super(page, ListDataSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataSourcesPage
      extends AbstractPage<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage> {

    private ListDataSourcesPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      super(context, response);
    }

    private static ListDataSourcesPage createEmptyPage() {
      return new ListDataSourcesPage(null, null);
    }

    @Override
    protected ListDataSourcesPage createPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      return new ListDataSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataSourcesPage> createPageAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    private ListDataSourcesFixedSizeCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataSourcesFixedSizeCollection createEmptyCollection() {
      return new ListDataSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataSourcesFixedSizeCollection createCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      return new ListDataSourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage, ListTransferConfigsFixedSizeCollection> {

    public static ApiFuture<ListTransferConfigsPagedResponse> createAsync(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ApiFuture<ListTransferConfigsResponse> futureResponse) {
      ApiFuture<ListTransferConfigsPage> futurePage =
          ListTransferConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferConfigsPage, ListTransferConfigsPagedResponse>() {
            @Override
            public ListTransferConfigsPagedResponse apply(ListTransferConfigsPage input) {
              return new ListTransferConfigsPagedResponse(input);
            }
          });
    }

    private ListTransferConfigsPagedResponse(ListTransferConfigsPage page) {
      super(page, ListTransferConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferConfigsPage
      extends AbstractPage<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage> {

    private ListTransferConfigsPage(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ListTransferConfigsResponse response) {
      super(context, response);
    }

    private static ListTransferConfigsPage createEmptyPage() {
      return new ListTransferConfigsPage(null, null);
    }

    @Override
    protected ListTransferConfigsPage createPage(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ListTransferConfigsResponse response) {
      return new ListTransferConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferConfigsPage> createPageAsync(
        PageContext<ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig>
            context,
        ApiFuture<ListTransferConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferConfigsRequest, ListTransferConfigsResponse, TransferConfig,
          ListTransferConfigsPage, ListTransferConfigsFixedSizeCollection> {

    private ListTransferConfigsFixedSizeCollection(
        List<ListTransferConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferConfigsFixedSizeCollection createEmptyCollection() {
      return new ListTransferConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferConfigsFixedSizeCollection createCollection(
        List<ListTransferConfigsPage> pages, int collectionSize) {
      return new ListTransferConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferRunsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage,
          ListTransferRunsFixedSizeCollection> {

    public static ApiFuture<ListTransferRunsPagedResponse> createAsync(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ApiFuture<ListTransferRunsResponse> futureResponse) {
      ApiFuture<ListTransferRunsPage> futurePage =
          ListTransferRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferRunsPage, ListTransferRunsPagedResponse>() {
            @Override
            public ListTransferRunsPagedResponse apply(ListTransferRunsPage input) {
              return new ListTransferRunsPagedResponse(input);
            }
          });
    }

    private ListTransferRunsPagedResponse(ListTransferRunsPage page) {
      super(page, ListTransferRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferRunsPage
      extends AbstractPage<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage> {

    private ListTransferRunsPage(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ListTransferRunsResponse response) {
      super(context, response);
    }

    private static ListTransferRunsPage createEmptyPage() {
      return new ListTransferRunsPage(null, null);
    }

    @Override
    protected ListTransferRunsPage createPage(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ListTransferRunsResponse response) {
      return new ListTransferRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferRunsPage> createPageAsync(
        PageContext<ListTransferRunsRequest, ListTransferRunsResponse, TransferRun> context,
        ApiFuture<ListTransferRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferRunsRequest, ListTransferRunsResponse, TransferRun, ListTransferRunsPage,
          ListTransferRunsFixedSizeCollection> {

    private ListTransferRunsFixedSizeCollection(
        List<ListTransferRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferRunsFixedSizeCollection createEmptyCollection() {
      return new ListTransferRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferRunsFixedSizeCollection createCollection(
        List<ListTransferRunsPage> pages, int collectionSize) {
      return new ListTransferRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferLogsPagedResponse
      extends AbstractPagedListResponse<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage, ListTransferLogsPage,
          ListTransferLogsFixedSizeCollection> {

    public static ApiFuture<ListTransferLogsPagedResponse> createAsync(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ApiFuture<ListTransferLogsResponse> futureResponse) {
      ApiFuture<ListTransferLogsPage> futurePage =
          ListTransferLogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTransferLogsPage, ListTransferLogsPagedResponse>() {
            @Override
            public ListTransferLogsPagedResponse apply(ListTransferLogsPage input) {
              return new ListTransferLogsPagedResponse(input);
            }
          });
    }

    private ListTransferLogsPagedResponse(ListTransferLogsPage page) {
      super(page, ListTransferLogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferLogsPage
      extends AbstractPage<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage,
          ListTransferLogsPage> {

    private ListTransferLogsPage(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ListTransferLogsResponse response) {
      super(context, response);
    }

    private static ListTransferLogsPage createEmptyPage() {
      return new ListTransferLogsPage(null, null);
    }

    @Override
    protected ListTransferLogsPage createPage(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ListTransferLogsResponse response) {
      return new ListTransferLogsPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferLogsPage> createPageAsync(
        PageContext<ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage> context,
        ApiFuture<ListTransferLogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferLogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferLogsRequest, ListTransferLogsResponse, TransferMessage, ListTransferLogsPage,
          ListTransferLogsFixedSizeCollection> {

    private ListTransferLogsFixedSizeCollection(
        List<ListTransferLogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferLogsFixedSizeCollection createEmptyCollection() {
      return new ListTransferLogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferLogsFixedSizeCollection createCollection(
        List<ListTransferLogsPage> pages, int collectionSize) {
      return new ListTransferLogsFixedSizeCollection(pages, collectionSize);
    }
  }
}
