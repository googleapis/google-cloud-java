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
package com.google.cloud.monitoring.spi.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResource;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.FixedSizeCollection;
import com.google.api.gax.core.Page;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PageContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseContext;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.TimeSeries;
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

  public static class ListGroupsPagedResponse implements PagedListResponse<Group> {

    private final PagedListResponseContext<ListGroupsRequest, ListGroupsResponse, Group> context;
    private final ListGroupsPage page;

    public ListGroupsPagedResponse(
        UnaryCallable<ListGroupsRequest, ListGroupsResponse> callable,
        PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group> pageDescriptor,
        ListGroupsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListGroupsPage(this.context);
    }

    public Iterable<Group> iterateAll() {
      return context.iterateAll();
    }

    public Page<Group> getPage() {
      return page;
    }

    public Iterable<ListGroupsPage> iteratePages() {
      return new Iterable<ListGroupsPage>() {
        @Override
        public Iterator<ListGroupsPage> iterator() {
          return new PageContext.PageIterator<ListGroupsPage>(
              new PageContext.PageFetcher<ListGroupsPage>() {
                @Override
                public ListGroupsPage getNextPage(ListGroupsPage currentPage) {
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

    public FixedSizeCollection<Group> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<Group>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListGroupsPage implements Page<Group> {
    private final PageContext<ListGroupsRequest, ListGroupsResponse, Group> context;

    public ListGroupsPage(PageContext<ListGroupsRequest, ListGroupsResponse, Group> context) {
      this.context = context;
    }

    @Override
    public Iterator<Group> iterator() {
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
    public ListGroupsPage getNextPage() {
      return new ListGroupsPage(context.getNextPageContext());
    }

    public ListGroupsPage getNextPage(int pageSize) {
      return new ListGroupsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<Group> iterateAll() {
      return context.iterateAll();
    }

    public ListGroupsResponse getResponse() {
      return context.getResponse();
    }

    public ListGroupsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListGroupMembersPagedResponse
      implements PagedListResponse<MonitoredResource> {

    private final PagedListResponseContext<
            ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
        context;
    private final ListGroupMembersPage page;

    public ListGroupMembersPagedResponse(
        UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse> callable,
        PagedListDescriptor<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
            pageDescriptor,
        ListGroupMembersRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListGroupMembersPage(this.context);
    }

    public Iterable<MonitoredResource> iterateAll() {
      return context.iterateAll();
    }

    public Page<MonitoredResource> getPage() {
      return page;
    }

    public Iterable<ListGroupMembersPage> iteratePages() {
      return new Iterable<ListGroupMembersPage>() {
        @Override
        public Iterator<ListGroupMembersPage> iterator() {
          return new PageContext.PageIterator<ListGroupMembersPage>(
              new PageContext.PageFetcher<ListGroupMembersPage>() {
                @Override
                public ListGroupMembersPage getNextPage(ListGroupMembersPage currentPage) {
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

    public FixedSizeCollection<MonitoredResource> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<MonitoredResource>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListGroupMembersPage implements Page<MonitoredResource> {
    private final PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
        context;

    public ListGroupMembersPage(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context) {
      this.context = context;
    }

    @Override
    public Iterator<MonitoredResource> iterator() {
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
    public ListGroupMembersPage getNextPage() {
      return new ListGroupMembersPage(context.getNextPageContext());
    }

    public ListGroupMembersPage getNextPage(int pageSize) {
      return new ListGroupMembersPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<MonitoredResource> iterateAll() {
      return context.iterateAll();
    }

    public ListGroupMembersResponse getResponse() {
      return context.getResponse();
    }

    public ListGroupMembersRequest getRequest() {
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

  public static class ListMetricDescriptorsPagedResponse
      implements PagedListResponse<MetricDescriptor> {

    private final PagedListResponseContext<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
        context;
    private final ListMetricDescriptorsPage page;

    public ListMetricDescriptorsPagedResponse(
        UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse> callable,
        PagedListDescriptor<
                ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            pageDescriptor,
        ListMetricDescriptorsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListMetricDescriptorsPage(this.context);
    }

    public Iterable<MetricDescriptor> iterateAll() {
      return context.iterateAll();
    }

    public Page<MetricDescriptor> getPage() {
      return page;
    }

    public Iterable<ListMetricDescriptorsPage> iteratePages() {
      return new Iterable<ListMetricDescriptorsPage>() {
        @Override
        public Iterator<ListMetricDescriptorsPage> iterator() {
          return new PageContext.PageIterator<ListMetricDescriptorsPage>(
              new PageContext.PageFetcher<ListMetricDescriptorsPage>() {
                @Override
                public ListMetricDescriptorsPage getNextPage(
                    ListMetricDescriptorsPage currentPage) {
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

    public FixedSizeCollection<MetricDescriptor> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<MetricDescriptor>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListMetricDescriptorsPage implements Page<MetricDescriptor> {
    private final PageContext<
            ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
        context;

    public ListMetricDescriptorsPage(
        PageContext<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            context) {
      this.context = context;
    }

    @Override
    public Iterator<MetricDescriptor> iterator() {
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
    public ListMetricDescriptorsPage getNextPage() {
      return new ListMetricDescriptorsPage(context.getNextPageContext());
    }

    public ListMetricDescriptorsPage getNextPage(int pageSize) {
      return new ListMetricDescriptorsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<MetricDescriptor> iterateAll() {
      return context.iterateAll();
    }

    public ListMetricDescriptorsResponse getResponse() {
      return context.getResponse();
    }

    public ListMetricDescriptorsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListTimeSeriesPagedResponse implements PagedListResponse<TimeSeries> {

    private final PagedListResponseContext<
            ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
        context;
    private final ListTimeSeriesPage page;

    public ListTimeSeriesPagedResponse(
        UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> callable,
        PagedListDescriptor<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries>
            pageDescriptor,
        ListTimeSeriesRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListTimeSeriesPage(this.context);
    }

    public Iterable<TimeSeries> iterateAll() {
      return context.iterateAll();
    }

    public Page<TimeSeries> getPage() {
      return page;
    }

    public Iterable<ListTimeSeriesPage> iteratePages() {
      return new Iterable<ListTimeSeriesPage>() {
        @Override
        public Iterator<ListTimeSeriesPage> iterator() {
          return new PageContext.PageIterator<ListTimeSeriesPage>(
              new PageContext.PageFetcher<ListTimeSeriesPage>() {
                @Override
                public ListTimeSeriesPage getNextPage(ListTimeSeriesPage currentPage) {
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

    public FixedSizeCollection<TimeSeries> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<TimeSeries>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListTimeSeriesPage implements Page<TimeSeries> {
    private final PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context;

    public ListTimeSeriesPage(
        PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context) {
      this.context = context;
    }

    @Override
    public Iterator<TimeSeries> iterator() {
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
    public ListTimeSeriesPage getNextPage() {
      return new ListTimeSeriesPage(context.getNextPageContext());
    }

    public ListTimeSeriesPage getNextPage(int pageSize) {
      return new ListTimeSeriesPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<TimeSeries> iterateAll() {
      return context.iterateAll();
    }

    public ListTimeSeriesResponse getResponse() {
      return context.getResponse();
    }

    public ListTimeSeriesRequest getRequest() {
      return context.getRequest();
    }
  }
}
