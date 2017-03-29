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
package com.google.cloud.errorreporting.spi.v1beta1;

import com.google.api.gax.core.FixedSizeCollection;
import com.google.api.gax.core.Page;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PageContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseContext;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
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

  public static class ListGroupStatsPagedResponse implements PagedListResponse<ErrorGroupStats> {

    private final PagedListResponseContext<
            ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
        context;
    private final ListGroupStatsPage page;

    public ListGroupStatsPagedResponse(
        UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> callable,
        PagedListDescriptor<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
            pageDescriptor,
        ListGroupStatsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListGroupStatsPage(this.context);
    }

    public Iterable<ErrorGroupStats> iterateAll() {
      return context.iterateAll();
    }

    public Page<ErrorGroupStats> getPage() {
      return page;
    }

    public Iterable<ListGroupStatsPage> iteratePages() {
      return new Iterable<ListGroupStatsPage>() {
        @Override
        public Iterator<ListGroupStatsPage> iterator() {
          return new PageContext.PageIterator<ListGroupStatsPage>(
              new PageContext.PageFetcher<ListGroupStatsPage>() {
                @Override
                public ListGroupStatsPage getNextPage(ListGroupStatsPage currentPage) {
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

    public FixedSizeCollection<ErrorGroupStats> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<ErrorGroupStats>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListGroupStatsPage implements Page<ErrorGroupStats> {
    private final PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats>
        context;

    public ListGroupStatsPage(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context) {
      this.context = context;
    }

    @Override
    public Iterator<ErrorGroupStats> iterator() {
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
    public ListGroupStatsPage getNextPage() {
      return new ListGroupStatsPage(context.getNextPageContext());
    }

    public ListGroupStatsPage getNextPage(int pageSize) {
      return new ListGroupStatsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<ErrorGroupStats> iterateAll() {
      return context.iterateAll();
    }

    public ListGroupStatsResponse getResponse() {
      return context.getResponse();
    }

    public ListGroupStatsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListEventsPagedResponse implements PagedListResponse<ErrorEvent> {

    private final PagedListResponseContext<ListEventsRequest, ListEventsResponse, ErrorEvent>
        context;
    private final ListEventsPage page;

    public ListEventsPagedResponse(
        UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
        PagedListDescriptor<ListEventsRequest, ListEventsResponse, ErrorEvent> pageDescriptor,
        ListEventsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListEventsPage(this.context);
    }

    public Iterable<ErrorEvent> iterateAll() {
      return context.iterateAll();
    }

    public Page<ErrorEvent> getPage() {
      return page;
    }

    public Iterable<ListEventsPage> iteratePages() {
      return new Iterable<ListEventsPage>() {
        @Override
        public Iterator<ListEventsPage> iterator() {
          return new PageContext.PageIterator<ListEventsPage>(
              new PageContext.PageFetcher<ListEventsPage>() {
                @Override
                public ListEventsPage getNextPage(ListEventsPage currentPage) {
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

    public FixedSizeCollection<ErrorEvent> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<ErrorEvent>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListEventsPage implements Page<ErrorEvent> {
    private final PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context;

    public ListEventsPage(PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context) {
      this.context = context;
    }

    @Override
    public Iterator<ErrorEvent> iterator() {
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
    public ListEventsPage getNextPage() {
      return new ListEventsPage(context.getNextPageContext());
    }

    public ListEventsPage getNextPage(int pageSize) {
      return new ListEventsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<ErrorEvent> iterateAll() {
      return context.iterateAll();
    }

    public ListEventsResponse getResponse() {
      return context.getResponse();
    }

    public ListEventsRequest getRequest() {
      return context.getRequest();
    }
  }
}
