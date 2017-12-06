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
package com.google.cloud.monitoring.v3;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResource;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
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

  public static class ListGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    public static ApiFuture<ListGroupsPagedResponse> createAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      ApiFuture<ListGroupsPage> futurePage =
          ListGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupsPage, ListGroupsPagedResponse>() {
            @Override
            public ListGroupsPagedResponse apply(ListGroupsPage input) {
              return new ListGroupsPagedResponse(input);
            }
          });
    }

    private ListGroupsPagedResponse(ListGroupsPage page) {
      super(page, ListGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupsPage
      extends AbstractPage<ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage> {

    private ListGroupsPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      super(context, response);
    }

    private static ListGroupsPage createEmptyPage() {
      return new ListGroupsPage(null, null);
    }

    @Override
    protected ListGroupsPage createPage(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ListGroupsResponse response) {
      return new ListGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupsPage> createPageAsync(
        PageContext<ListGroupsRequest, ListGroupsResponse, Group> context,
        ApiFuture<ListGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupsRequest, ListGroupsResponse, Group, ListGroupsPage,
          ListGroupsFixedSizeCollection> {

    private ListGroupsFixedSizeCollection(List<ListGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupsFixedSizeCollection createEmptyCollection() {
      return new ListGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupsFixedSizeCollection createCollection(
        List<ListGroupsPage> pages, int collectionSize) {
      return new ListGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGroupMembersPagedResponse
      extends AbstractPagedListResponse<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage, ListGroupMembersFixedSizeCollection> {

    public static ApiFuture<ListGroupMembersPagedResponse> createAsync(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ApiFuture<ListGroupMembersResponse> futureResponse) {
      ApiFuture<ListGroupMembersPage> futurePage =
          ListGroupMembersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupMembersPage, ListGroupMembersPagedResponse>() {
            @Override
            public ListGroupMembersPagedResponse apply(ListGroupMembersPage input) {
              return new ListGroupMembersPagedResponse(input);
            }
          });
    }

    private ListGroupMembersPagedResponse(ListGroupMembersPage page) {
      super(page, ListGroupMembersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupMembersPage
      extends AbstractPage<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage> {

    private ListGroupMembersPage(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ListGroupMembersResponse response) {
      super(context, response);
    }

    private static ListGroupMembersPage createEmptyPage() {
      return new ListGroupMembersPage(null, null);
    }

    @Override
    protected ListGroupMembersPage createPage(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ListGroupMembersResponse response) {
      return new ListGroupMembersPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupMembersPage> createPageAsync(
        PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource> context,
        ApiFuture<ListGroupMembersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupMembersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource,
          ListGroupMembersPage, ListGroupMembersFixedSizeCollection> {

    private ListGroupMembersFixedSizeCollection(
        List<ListGroupMembersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupMembersFixedSizeCollection createEmptyCollection() {
      return new ListGroupMembersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupMembersFixedSizeCollection createCollection(
        List<ListGroupMembersPage> pages, int collectionSize) {
      return new ListGroupMembersFixedSizeCollection(pages, collectionSize);
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
    public ApiFuture<ListMonitoredResourceDescriptorsPage> createPageAsync(
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

  public static class ListMetricDescriptorsPagedResponse
      extends AbstractPagedListResponse<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor,
          ListMetricDescriptorsPage, ListMetricDescriptorsFixedSizeCollection> {

    public static ApiFuture<ListMetricDescriptorsPagedResponse> createAsync(
        PageContext<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            context,
        ApiFuture<ListMetricDescriptorsResponse> futureResponse) {
      ApiFuture<ListMetricDescriptorsPage> futurePage =
          ListMetricDescriptorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListMetricDescriptorsPage, ListMetricDescriptorsPagedResponse>() {
            @Override
            public ListMetricDescriptorsPagedResponse apply(ListMetricDescriptorsPage input) {
              return new ListMetricDescriptorsPagedResponse(input);
            }
          });
    }

    private ListMetricDescriptorsPagedResponse(ListMetricDescriptorsPage page) {
      super(page, ListMetricDescriptorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMetricDescriptorsPage
      extends AbstractPage<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor,
          ListMetricDescriptorsPage> {

    private ListMetricDescriptorsPage(
        PageContext<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            context,
        ListMetricDescriptorsResponse response) {
      super(context, response);
    }

    private static ListMetricDescriptorsPage createEmptyPage() {
      return new ListMetricDescriptorsPage(null, null);
    }

    @Override
    protected ListMetricDescriptorsPage createPage(
        PageContext<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            context,
        ListMetricDescriptorsResponse response) {
      return new ListMetricDescriptorsPage(context, response);
    }

    @Override
    public ApiFuture<ListMetricDescriptorsPage> createPageAsync(
        PageContext<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor>
            context,
        ApiFuture<ListMetricDescriptorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMetricDescriptorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMetricDescriptorsRequest, ListMetricDescriptorsResponse, MetricDescriptor,
          ListMetricDescriptorsPage, ListMetricDescriptorsFixedSizeCollection> {

    private ListMetricDescriptorsFixedSizeCollection(
        List<ListMetricDescriptorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMetricDescriptorsFixedSizeCollection createEmptyCollection() {
      return new ListMetricDescriptorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMetricDescriptorsFixedSizeCollection createCollection(
        List<ListMetricDescriptorsPage> pages, int collectionSize) {
      return new ListMetricDescriptorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTimeSeriesPagedResponse
      extends AbstractPagedListResponse<
          ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries, ListTimeSeriesPage,
          ListTimeSeriesFixedSizeCollection> {

    public static ApiFuture<ListTimeSeriesPagedResponse> createAsync(
        PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context,
        ApiFuture<ListTimeSeriesResponse> futureResponse) {
      ApiFuture<ListTimeSeriesPage> futurePage =
          ListTimeSeriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTimeSeriesPage, ListTimeSeriesPagedResponse>() {
            @Override
            public ListTimeSeriesPagedResponse apply(ListTimeSeriesPage input) {
              return new ListTimeSeriesPagedResponse(input);
            }
          });
    }

    private ListTimeSeriesPagedResponse(ListTimeSeriesPage page) {
      super(page, ListTimeSeriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTimeSeriesPage
      extends AbstractPage<
          ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries, ListTimeSeriesPage> {

    private ListTimeSeriesPage(
        PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context,
        ListTimeSeriesResponse response) {
      super(context, response);
    }

    private static ListTimeSeriesPage createEmptyPage() {
      return new ListTimeSeriesPage(null, null);
    }

    @Override
    protected ListTimeSeriesPage createPage(
        PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context,
        ListTimeSeriesResponse response) {
      return new ListTimeSeriesPage(context, response);
    }

    @Override
    public ApiFuture<ListTimeSeriesPage> createPageAsync(
        PageContext<ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries> context,
        ApiFuture<ListTimeSeriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTimeSeriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTimeSeriesRequest, ListTimeSeriesResponse, TimeSeries, ListTimeSeriesPage,
          ListTimeSeriesFixedSizeCollection> {

    private ListTimeSeriesFixedSizeCollection(List<ListTimeSeriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTimeSeriesFixedSizeCollection createEmptyCollection() {
      return new ListTimeSeriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTimeSeriesFixedSizeCollection createCollection(
        List<ListTimeSeriesPage> pages, int collectionSize) {
      return new ListTimeSeriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
