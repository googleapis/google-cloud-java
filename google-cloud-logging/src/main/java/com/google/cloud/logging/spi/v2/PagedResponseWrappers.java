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
import com.google.api.gax.core.FixedSizeCollection;
import com.google.api.gax.core.Page;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PageContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseContext;
import com.google.api.gax.grpc.UnaryCallable;
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
import java.util.Iterator;
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

  public static class ListLogEntriesPagedResponse implements PagedListResponse<LogEntry> {

    private final PagedListResponseContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        context;
    private final ListLogEntriesPage page;

    public ListLogEntriesPagedResponse(
        UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> callable,
        PagedListDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> pageDescriptor,
        ListLogEntriesRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListLogEntriesPage(this.context);
    }

    public Iterable<LogEntry> iterateAll() {
      return context.iterateAll();
    }

    public Page<LogEntry> getPage() {
      return page;
    }

    public Iterable<ListLogEntriesPage> iteratePages() {
      return new Iterable<ListLogEntriesPage>() {
        @Override
        public Iterator<ListLogEntriesPage> iterator() {
          return new PageContext.PageIterator<ListLogEntriesPage>(
              new PageContext.PageFetcher<ListLogEntriesPage>() {
                @Override
                public ListLogEntriesPage getNextPage(ListLogEntriesPage currentPage) {
                  return currentPage.getNextPage();
                }
              },
              page);
        }
      };
    }

    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    public FixedSizeCollection<LogEntry> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<LogEntry>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListLogEntriesPage implements Page<LogEntry> {
    private final PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context;

    public ListLogEntriesPage(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context) {
      this.context = context;
    }

    @Override
    public Iterator<LogEntry> iterator() {
      return context.getResourceIterable().iterator();
    }

    @Override
    public boolean hasNextPage() {
      return context.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    @Override
    public ListLogEntriesPage getNextPage() {
      return new ListLogEntriesPage(context.getNextPageContext());
    }

    public ListLogEntriesPage getNextPage(int pageSize) {
      return new ListLogEntriesPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<LogEntry> iterateAll() {
      return context.iterateAll();
    }

    public ListLogEntriesResponse getResponse() {
      return context.getResponse();
    }

    public ListLogEntriesRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListMonitoredResourceDescriptorsPagedResponse
      implements PagedListResponse<MonitoredResourceDescriptor> {

    private final PagedListResponseContext<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        context;
    private final ListMonitoredResourceDescriptorsPage page;

    public ListMonitoredResourceDescriptorsPagedResponse(
        UnaryCallable<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
            callable,
        PagedListDescriptor<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            pageDescriptor,
        ListMonitoredResourceDescriptorsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListMonitoredResourceDescriptorsPage(this.context);
    }

    public Iterable<MonitoredResourceDescriptor> iterateAll() {
      return context.iterateAll();
    }

    public Page<MonitoredResourceDescriptor> getPage() {
      return page;
    }

    public Iterable<ListMonitoredResourceDescriptorsPage> iteratePages() {
      return new Iterable<ListMonitoredResourceDescriptorsPage>() {
        @Override
        public Iterator<ListMonitoredResourceDescriptorsPage> iterator() {
          return new PageContext.PageIterator<ListMonitoredResourceDescriptorsPage>(
              new PageContext.PageFetcher<ListMonitoredResourceDescriptorsPage>() {
                @Override
                public ListMonitoredResourceDescriptorsPage getNextPage(
                    ListMonitoredResourceDescriptorsPage currentPage) {
                  return currentPage.getNextPage();
                }
              },
              page);
        }
      };
    }

    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    public FixedSizeCollection<MonitoredResourceDescriptor> expandToFixedSizeCollection(
        int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<MonitoredResourceDescriptor>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListMonitoredResourceDescriptorsPage
      implements Page<MonitoredResourceDescriptor> {
    private final PageContext<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        context;

    public ListMonitoredResourceDescriptorsPage(
        PageContext<
                ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context) {
      this.context = context;
    }

    @Override
    public Iterator<MonitoredResourceDescriptor> iterator() {
      return context.getResourceIterable().iterator();
    }

    @Override
    public boolean hasNextPage() {
      return context.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    @Override
    public ListMonitoredResourceDescriptorsPage getNextPage() {
      return new ListMonitoredResourceDescriptorsPage(context.getNextPageContext());
    }

    public ListMonitoredResourceDescriptorsPage getNextPage(int pageSize) {
      return new ListMonitoredResourceDescriptorsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<MonitoredResourceDescriptor> iterateAll() {
      return context.iterateAll();
    }

    public ListMonitoredResourceDescriptorsResponse getResponse() {
      return context.getResponse();
    }

    public ListMonitoredResourceDescriptorsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListLogsPagedResponse implements PagedListResponse<String> {

    private final PagedListResponseContext<ListLogsRequest, ListLogsResponse, String> context;
    private final ListLogsPage page;

    public ListLogsPagedResponse(
        UnaryCallable<ListLogsRequest, ListLogsResponse> callable,
        PagedListDescriptor<ListLogsRequest, ListLogsResponse, String> pageDescriptor,
        ListLogsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListLogsPage(this.context);
    }

    public Iterable<String> iterateAll() {
      return context.iterateAll();
    }

    public Page<String> getPage() {
      return page;
    }

    public Iterable<ListLogsPage> iteratePages() {
      return new Iterable<ListLogsPage>() {
        @Override
        public Iterator<ListLogsPage> iterator() {
          return new PageContext.PageIterator<ListLogsPage>(
              new PageContext.PageFetcher<ListLogsPage>() {
                @Override
                public ListLogsPage getNextPage(ListLogsPage currentPage) {
                  return currentPage.getNextPage();
                }
              },
              page);
        }
      };
    }

    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    public FixedSizeCollection<String> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<String>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListLogsPage implements Page<String> {
    private final PageContext<ListLogsRequest, ListLogsResponse, String> context;

    public ListLogsPage(PageContext<ListLogsRequest, ListLogsResponse, String> context) {
      this.context = context;
    }

    @Override
    public Iterator<String> iterator() {
      return context.getResourceIterable().iterator();
    }

    @Override
    public boolean hasNextPage() {
      return context.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    @Override
    public ListLogsPage getNextPage() {
      return new ListLogsPage(context.getNextPageContext());
    }

    public ListLogsPage getNextPage(int pageSize) {
      return new ListLogsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<String> iterateAll() {
      return context.iterateAll();
    }

    public ListLogsResponse getResponse() {
      return context.getResponse();
    }

    public ListLogsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListSinksPagedResponse implements PagedListResponse<LogSink> {

    private final PagedListResponseContext<ListSinksRequest, ListSinksResponse, LogSink> context;
    private final ListSinksPage page;

    public ListSinksPagedResponse(
        UnaryCallable<ListSinksRequest, ListSinksResponse> callable,
        PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink> pageDescriptor,
        ListSinksRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListSinksPage(this.context);
    }

    public Iterable<LogSink> iterateAll() {
      return context.iterateAll();
    }

    public Page<LogSink> getPage() {
      return page;
    }

    public Iterable<ListSinksPage> iteratePages() {
      return new Iterable<ListSinksPage>() {
        @Override
        public Iterator<ListSinksPage> iterator() {
          return new PageContext.PageIterator<ListSinksPage>(
              new PageContext.PageFetcher<ListSinksPage>() {
                @Override
                public ListSinksPage getNextPage(ListSinksPage currentPage) {
                  return currentPage.getNextPage();
                }
              },
              page);
        }
      };
    }

    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    public FixedSizeCollection<LogSink> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<LogSink>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListSinksPage implements Page<LogSink> {
    private final PageContext<ListSinksRequest, ListSinksResponse, LogSink> context;

    public ListSinksPage(PageContext<ListSinksRequest, ListSinksResponse, LogSink> context) {
      this.context = context;
    }

    @Override
    public Iterator<LogSink> iterator() {
      return context.getResourceIterable().iterator();
    }

    @Override
    public boolean hasNextPage() {
      return context.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    @Override
    public ListSinksPage getNextPage() {
      return new ListSinksPage(context.getNextPageContext());
    }

    public ListSinksPage getNextPage(int pageSize) {
      return new ListSinksPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<LogSink> iterateAll() {
      return context.iterateAll();
    }

    public ListSinksResponse getResponse() {
      return context.getResponse();
    }

    public ListSinksRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListLogMetricsPagedResponse implements PagedListResponse<LogMetric> {

    private final PagedListResponseContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
        context;
    private final ListLogMetricsPage page;

    public ListLogMetricsPagedResponse(
        UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> callable,
        PagedListDescriptor<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric>
            pageDescriptor,
        ListLogMetricsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListLogMetricsPage(this.context);
    }

    public Iterable<LogMetric> iterateAll() {
      return context.iterateAll();
    }

    public Page<LogMetric> getPage() {
      return page;
    }

    public Iterable<ListLogMetricsPage> iteratePages() {
      return new Iterable<ListLogMetricsPage>() {
        @Override
        public Iterator<ListLogMetricsPage> iterator() {
          return new PageContext.PageIterator<ListLogMetricsPage>(
              new PageContext.PageFetcher<ListLogMetricsPage>() {
                @Override
                public ListLogMetricsPage getNextPage(ListLogMetricsPage currentPage) {
                  return currentPage.getNextPage();
                }
              },
              page);
        }
      };
    }

    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    public FixedSizeCollection<LogMetric> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<LogMetric>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListLogMetricsPage implements Page<LogMetric> {
    private final PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context;

    public ListLogMetricsPage(
        PageContext<ListLogMetricsRequest, ListLogMetricsResponse, LogMetric> context) {
      this.context = context;
    }

    @Override
    public Iterator<LogMetric> iterator() {
      return context.getResourceIterable().iterator();
    }

    @Override
    public boolean hasNextPage() {
      return context.hasNextPage();
    }

    @Override
    public String getNextPageToken() {
      return context.getNextPageToken();
    }

    @Override
    public ListLogMetricsPage getNextPage() {
      return new ListLogMetricsPage(context.getNextPageContext());
    }

    public ListLogMetricsPage getNextPage(int pageSize) {
      return new ListLogMetricsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<LogMetric> iterateAll() {
      return context.iterateAll();
    }

    public ListLogMetricsResponse getResponse() {
      return context.getResponse();
    }

    public ListLogMetricsRequest getRequest() {
      return context.getRequest();
    }
  }
}
