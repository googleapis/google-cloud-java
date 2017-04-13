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
package com.google.cloud.logging.spi.v2;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.ApiFunction;
import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutures;
import com.google.api.gax.grpc.AbstractFixedSizeCollection;
import com.google.api.gax.grpc.AbstractPage;
import com.google.api.gax.grpc.AbstractPagedListResponse;
import com.google.api.gax.grpc.PageContext;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogSink;
import com.google.protobuf.ExperimentalApi;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Wrapper class to contain paged response types for page streaming methods. Each static class
 * inside this wrapper class is used as the return type of one of an API method that implements the
 * page streaming pattern.
 */
@Generated("by GAPIC")
@ExperimentalApi
public class PagedResponseWrappers {

  public static class ListLogEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListLogEntriesRequest, ListLogEntriesResponse, LogEntry, ListLogEntriesPage,
          ListLogEntriesFixedSizeCollection> {

    public static ApiFuture<ListLogEntriesPagedResponse> createAsync(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ApiFuture<ListLogEntriesResponse> futureResponse) {
      ApiFuture<ListLogEntriesPage> futurePage =
          ListLogEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListLogEntriesPage, ListLogEntriesPagedResponse>() {
            @Override
            public ListLogEntriesPagedResponse apply(ListLogEntriesPage input) {
              return new ListLogEntriesPagedResponse(input);
            }
          });
    }

    private ListLogEntriesPagedResponse(ListLogEntriesPage page) {
      super(page, ListLogEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogEntriesPage
      extends AbstractPage<
          ListLogEntriesRequest, ListLogEntriesResponse, LogEntry, ListLogEntriesPage> {

    private ListLogEntriesPage(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ListLogEntriesResponse response) {
      super(context, response);
    }

    private static ListLogEntriesPage createEmptyPage() {
      return new ListLogEntriesPage(null, null);
    }

    @Override
    protected ListLogEntriesPage createPage(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ListLogEntriesResponse response) {
      return new ListLogEntriesPage(context, response);
    }

    @Override
    protected ApiFuture<ListLogEntriesPage> createPageAsync(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ApiFuture<ListLogEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogEntriesRequest, ListLogEntriesResponse, LogEntry, ListLogEntriesPage,
          ListLogEntriesFixedSizeCollection> {

    private ListLogEntriesFixedSizeCollection(List<ListLogEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogEntriesFixedSizeCollection createEmptyCollection() {
      return new ListLogEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogEntriesFixedSizeCollection createCollection(
        List<ListLogEntriesPage> pages, int collectionSize) {
      return new ListLogEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMonitoredResourceDescriptorsPagedResponse
      extends AbstractPagedListResponse<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor, ListMonitoredResourceDescriptorsPage,
          ListMonitoredResourceDescriptorsFixedSizeCollection> {

    public static ApiFuture<ListMonitoredResourceDescriptorsPagedResponse> createAsync(
        PageContext<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse) {
      ApiFuture<ListMonitoredResourceDescriptorsPage> futurePage =
          ListMonitoredResourceDescriptorsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListMonitoredResourceDescriptorsPage,
              ListMonitoredResourceDescriptorsPagedResponse>() {
            @Override
            public ListMonitoredResourceDescriptorsPagedResponse apply(
                ListMonitoredResourceDescriptorsPage input) {
              return new ListMonitoredResourceDescriptorsPagedResponse(input);
            }
          });
    }

    private ListMonitoredResourceDescriptorsPagedResponse(
        ListMonitoredResourceDescriptorsPage page) {
      super(page, ListMonitoredResourceDescriptorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMonitoredResourceDescriptorsPage
      extends AbstractPage<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor, ListMonitoredResourceDescriptorsPage> {

    private ListMonitoredResourceDescriptorsPage(
        PageContext<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ListMonitoredResourceDescriptorsResponse response) {
      super(context, response);
    }

    private static ListMonitoredResourceDescriptorsPage createEmptyPage() {
      return new ListMonitoredResourceDescriptorsPage(null, null);
    }

    @Override
    protected ListMonitoredResourceDescriptorsPage createPage(
        PageContext<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ListMonitoredResourceDescriptorsResponse response) {
      return new ListMonitoredResourceDescriptorsPage(context, response);
    }

    @Override
    protected ApiFuture<ListMonitoredResourceDescriptorsPage> createPageAsync(
        PageContext<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMonitoredResourceDescriptorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor, ListMonitoredResourceDescriptorsPage,
          ListMonitoredResourceDescriptorsFixedSizeCollection> {

    private ListMonitoredResourceDescriptorsFixedSizeCollection(
        List<ListMonitoredResourceDescriptorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMonitoredResourceDescriptorsFixedSizeCollection createEmptyCollection() {
      return new ListMonitoredResourceDescriptorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMonitoredResourceDescriptorsFixedSizeCollection createCollection(
        List<ListMonitoredResourceDescriptorsPage> pages, int collectionSize) {
      return new ListMonitoredResourceDescriptorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogsPagedResponse
      extends AbstractPagedListResponse<
          ListLogsRequest, ListLogsResponse, String, ListLogsPage, ListLogsFixedSizeCollection> {

    public static ApiFuture<ListLogsPagedResponse> createAsync(
        PageContext<ListLogsRequest, ListLogsResponse, String> context,
        ApiFuture<ListLogsResponse> futureResponse) {
      ApiFuture<ListLogsPage> futurePage =
          ListLogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListLogsPage, ListLogsPagedResponse>() {
            @Override
            public ListLogsPagedResponse apply(ListLogsPage input) {
              return new ListLogsPagedResponse(input);
            }
          });
    }

    private ListLogsPagedResponse(ListLogsPage page) {
      super(page, ListLogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogsPage
      extends AbstractPage<ListLogsRequest, ListLogsResponse, String, ListLogsPage> {

    private ListLogsPage(
        PageContext<ListLogsRequest, ListLogsResponse, String> context, ListLogsResponse response) {
      super(context, response);
    }

    private static ListLogsPage createEmptyPage() {
      return new ListLogsPage(null, null);
    }

    @Override
    protected ListLogsPage createPage(
        PageContext<ListLogsRequest, ListLogsResponse, String> context, ListLogsResponse response) {
      return new ListLogsPage(context, response);
    }

    @Override
    protected ApiFuture<ListLogsPage> createPageAsync(
        PageContext<ListLogsRequest, ListLogsResponse, String> context,
        ApiFuture<ListLogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogsRequest, ListLogsResponse, String, ListLogsPage, ListLogsFixedSizeCollection> {

    private ListLogsFixedSizeCollection(List<ListLogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogsFixedSizeCollection createEmptyCollection() {
      return new ListLogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogsFixedSizeCollection createCollection(
        List<ListLogsPage> pages, int collectionSize) {
      return new ListLogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSinksPagedResponse
      extends AbstractPagedListResponse<
          ListSinksRequest, ListSinksResponse, LogSink, ListSinksPage,
          ListSinksFixedSizeCollection> {

    public static ApiFuture<ListSinksPagedResponse> createAsync(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ApiFuture<ListSinksResponse> futureResponse) {
      ApiFuture<ListSinksPage> futurePage =
          ListSinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSinksPage, ListSinksPagedResponse>() {
            @Override
            public ListSinksPagedResponse apply(ListSinksPage input) {
              return new ListSinksPagedResponse(input);
            }
          });
    }

    private ListSinksPagedResponse(ListSinksPage page) {
      super(page, ListSinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSinksPage
      extends AbstractPage<ListSinksRequest, ListSinksResponse, LogSink, ListSinksPage> {

    private ListSinksPage(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ListSinksResponse response) {
      super(context, response);
    }

    private static ListSinksPage createEmptyPage() {
      return new ListSinksPage(null, null);
    }

    @Override
    protected ListSinksPage createPage(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ListSinksResponse response) {
      return new ListSinksPage(context, response);
    }

    @Override
    protected ApiFuture<ListSinksPage> createPageAsync(
        PageContext<ListSinksRequest, ListSinksResponse, LogSink> context,
        ApiFuture<ListSinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSinksRequest, ListSinksResponse, LogSink, ListSinksPage,
          ListSinksFixedSizeCollection> {

    private ListSinksFixedSizeCollection(List<ListSinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSinksFixedSizeCollection createEmptyCollection() {
      return new ListSinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSinksFixedSizeCollection createCollection(
        List<ListSinksPage> pages, int collectionSize) {
      return new ListSinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogMetricsPagedResponse
      extends AbstractPagedListResponse<
          ListLogMetricsRequest, ListLogMetricsResponse, LogMetric, ListLogMetricsPage,
          ListLogMetricsFixedSizeCollection> {

    public static ApiFuture<ListLogMetricsPagedResponse> createAsync(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ApiFuture<ListLogMetricsResponse> futureResponse) {
      ApiFuture<ListLogMetricsPage> futurePage =
          ListLogMetricsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListLogMetricsPage, ListLogMetricsPagedResponse>() {
            @Override
            public ListLogMetricsPagedResponse apply(ListLogMetricsPage input) {
              return new ListLogMetricsPagedResponse(input);
            }
          });
    }

    private ListLogMetricsPagedResponse(ListLogMetricsPage page) {
      super(page, ListLogMetricsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogMetricsPage
      extends AbstractPage<
          ListLogMetricsRequest, ListLogMetricsResponse, LogMetric, ListLogMetricsPage> {

    private ListLogMetricsPage(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ListLogMetricsResponse response) {
      super(context, response);
    }

    private static ListLogMetricsPage createEmptyPage() {
      return new ListLogMetricsPage(null, null);
    }

    @Override
    protected ListLogMetricsPage createPage(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ListLogMetricsResponse response) {
      return new ListLogMetricsPage(context, response);
    }

    @Override
    protected ApiFuture<ListLogMetricsPage> createPageAsync(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context,
        ApiFuture<ListLogMetricsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogMetricsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogMetricsRequest, ListLogMetricsResponse, LogMetric, ListLogMetricsPage,
          ListLogMetricsFixedSizeCollection> {

    private ListLogMetricsFixedSizeCollection(List<ListLogMetricsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogMetricsFixedSizeCollection createEmptyCollection() {
      return new ListLogMetricsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogMetricsFixedSizeCollection createCollection(
        List<ListLogMetricsPage> pages, int collectionSize) {
      return new ListLogMetricsFixedSizeCollection(pages, collectionSize);
    }
  }
}
