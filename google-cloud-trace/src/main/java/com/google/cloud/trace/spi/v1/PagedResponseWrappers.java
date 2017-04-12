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
package com.google.cloud.trace.spi.v1;

import com.google.api.gax.core.FixedSizeCollection;
import com.google.api.gax.core.Page;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PageContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseContext;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.Trace;
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

  public static class ListTracesPagedResponse implements PagedListResponse<Trace> {

    private final PagedListResponseContext<ListTracesRequest, ListTracesResponse, Trace> context;
    private final ListTracesPage page;

    public ListTracesPagedResponse(
        UnaryCallable<ListTracesRequest, ListTracesResponse> callable,
        PagedListDescriptor<ListTracesRequest, ListTracesResponse, Trace> pageDescriptor,
        ListTracesRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListTracesPage(this.context);
    }

    public Iterable<Trace> iterateAll() {
      return context.iterateAll();
    }

    public Page<Trace> getPage() {
      return page;
    }

    public Iterable<ListTracesPage> iteratePages() {
      return new Iterable<ListTracesPage>() {
        @Override
        public Iterator<ListTracesPage> iterator() {
          return new PageContext.PageIterator<ListTracesPage>(
              new PageContext.PageFetcher<ListTracesPage>() {
                @Override
                public ListTracesPage getNextPage(ListTracesPage currentPage) {
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

    public FixedSizeCollection<Trace> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<Trace>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListTracesPage implements Page<Trace> {
    private final PageContext<ListTracesRequest, ListTracesResponse, Trace> context;

    public ListTracesPage(PageContext<ListTracesRequest, ListTracesResponse, Trace> context) {
      this.context = context;
    }

    @Override
    public Iterator<Trace> iterator() {
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
    public ListTracesPage getNextPage() {
      return new ListTracesPage(context.getNextPageContext());
    }

    public ListTracesPage getNextPage(int pageSize) {
      return new ListTracesPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<Trace> iterateAll() {
      return context.iterateAll();
    }

    public ListTracesResponse getResponse() {
      return context.getResponse();
    }

    public ListTracesRequest getRequest() {
      return context.getRequest();
    }
  }
}
