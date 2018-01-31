/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.privacy.dlp.v2beta2.DeidentifyTemplate;
import com.google.privacy.dlp.v2beta2.DlpJob;
import com.google.privacy.dlp.v2beta2.InspectTemplate;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2beta2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2beta2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesResponse;
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

  public static class ListInspectTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage, ListInspectTemplatesFixedSizeCollection> {

    public static ApiFuture<ListInspectTemplatesPagedResponse> createAsync(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ApiFuture<ListInspectTemplatesResponse> futureResponse) {
      ApiFuture<ListInspectTemplatesPage> futurePage =
          ListInspectTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInspectTemplatesPage, ListInspectTemplatesPagedResponse>() {
            @Override
            public ListInspectTemplatesPagedResponse apply(ListInspectTemplatesPage input) {
              return new ListInspectTemplatesPagedResponse(input);
            }
          });
    }

    private ListInspectTemplatesPagedResponse(ListInspectTemplatesPage page) {
      super(page, ListInspectTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInspectTemplatesPage
      extends AbstractPage<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage> {

    private ListInspectTemplatesPage(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ListInspectTemplatesResponse response) {
      super(context, response);
    }

    private static ListInspectTemplatesPage createEmptyPage() {
      return new ListInspectTemplatesPage(null, null);
    }

    @Override
    protected ListInspectTemplatesPage createPage(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ListInspectTemplatesResponse response) {
      return new ListInspectTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListInspectTemplatesPage> createPageAsync(
        PageContext<ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
            context,
        ApiFuture<ListInspectTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInspectTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate,
          ListInspectTemplatesPage, ListInspectTemplatesFixedSizeCollection> {

    private ListInspectTemplatesFixedSizeCollection(
        List<ListInspectTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInspectTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListInspectTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInspectTemplatesFixedSizeCollection createCollection(
        List<ListInspectTemplatesPage> pages, int collectionSize) {
      return new ListInspectTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDeidentifyTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage, ListDeidentifyTemplatesFixedSizeCollection> {

    public static ApiFuture<ListDeidentifyTemplatesPagedResponse> createAsync(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
      ApiFuture<ListDeidentifyTemplatesPage> futurePage =
          ListDeidentifyTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDeidentifyTemplatesPage, ListDeidentifyTemplatesPagedResponse>() {
            @Override
            public ListDeidentifyTemplatesPagedResponse apply(ListDeidentifyTemplatesPage input) {
              return new ListDeidentifyTemplatesPagedResponse(input);
            }
          });
    }

    private ListDeidentifyTemplatesPagedResponse(ListDeidentifyTemplatesPage page) {
      super(page, ListDeidentifyTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeidentifyTemplatesPage
      extends AbstractPage<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage> {

    private ListDeidentifyTemplatesPage(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ListDeidentifyTemplatesResponse response) {
      super(context, response);
    }

    private static ListDeidentifyTemplatesPage createEmptyPage() {
      return new ListDeidentifyTemplatesPage(null, null);
    }

    @Override
    protected ListDeidentifyTemplatesPage createPage(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ListDeidentifyTemplatesResponse response) {
      return new ListDeidentifyTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListDeidentifyTemplatesPage> createPageAsync(
        PageContext<
                ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
            context,
        ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeidentifyTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate,
          ListDeidentifyTemplatesPage, ListDeidentifyTemplatesFixedSizeCollection> {

    private ListDeidentifyTemplatesFixedSizeCollection(
        List<ListDeidentifyTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeidentifyTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListDeidentifyTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeidentifyTemplatesFixedSizeCollection createCollection(
        List<ListDeidentifyTemplatesPage> pages, int collectionSize) {
      return new ListDeidentifyTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDlpJobsPagedResponse
      extends AbstractPagedListResponse<
          ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage,
          ListDlpJobsFixedSizeCollection> {

    public static ApiFuture<ListDlpJobsPagedResponse> createAsync(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ApiFuture<ListDlpJobsResponse> futureResponse) {
      ApiFuture<ListDlpJobsPage> futurePage =
          ListDlpJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDlpJobsPage, ListDlpJobsPagedResponse>() {
            @Override
            public ListDlpJobsPagedResponse apply(ListDlpJobsPage input) {
              return new ListDlpJobsPagedResponse(input);
            }
          });
    }

    private ListDlpJobsPagedResponse(ListDlpJobsPage page) {
      super(page, ListDlpJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDlpJobsPage
      extends AbstractPage<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage> {

    private ListDlpJobsPage(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ListDlpJobsResponse response) {
      super(context, response);
    }

    private static ListDlpJobsPage createEmptyPage() {
      return new ListDlpJobsPage(null, null);
    }

    @Override
    protected ListDlpJobsPage createPage(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ListDlpJobsResponse response) {
      return new ListDlpJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListDlpJobsPage> createPageAsync(
        PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> context,
        ApiFuture<ListDlpJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDlpJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDlpJobsRequest, ListDlpJobsResponse, DlpJob, ListDlpJobsPage,
          ListDlpJobsFixedSizeCollection> {

    private ListDlpJobsFixedSizeCollection(List<ListDlpJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDlpJobsFixedSizeCollection createEmptyCollection() {
      return new ListDlpJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDlpJobsFixedSizeCollection createCollection(
        List<ListDlpJobsPage> pages, int collectionSize) {
      return new ListDlpJobsFixedSizeCollection(pages, collectionSize);
    }
  }
}
