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
package com.google.cloud.firestore.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsResponse;
import com.google.firestore.v1beta1.ListDocumentsRequest;
import com.google.firestore.v1beta1.ListDocumentsResponse;
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

  public static class ListDocumentsPagedResponse
      extends AbstractPagedListResponse<
          ListDocumentsRequest, ListDocumentsResponse, Document, ListDocumentsPage,
          ListDocumentsFixedSizeCollection> {

    public static ApiFuture<ListDocumentsPagedResponse> createAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ApiFuture<ListDocumentsResponse> futureResponse) {
      ApiFuture<ListDocumentsPage> futurePage =
          ListDocumentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDocumentsPage, ListDocumentsPagedResponse>() {
            @Override
            public ListDocumentsPagedResponse apply(ListDocumentsPage input) {
              return new ListDocumentsPagedResponse(input);
            }
          });
    }

    private ListDocumentsPagedResponse(ListDocumentsPage page) {
      super(page, ListDocumentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDocumentsPage
      extends AbstractPage<
          ListDocumentsRequest, ListDocumentsResponse, Document, ListDocumentsPage> {

    private ListDocumentsPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ListDocumentsResponse response) {
      super(context, response);
    }

    private static ListDocumentsPage createEmptyPage() {
      return new ListDocumentsPage(null, null);
    }

    @Override
    protected ListDocumentsPage createPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ListDocumentsResponse response) {
      return new ListDocumentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDocumentsPage> createPageAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ApiFuture<ListDocumentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDocumentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDocumentsRequest, ListDocumentsResponse, Document, ListDocumentsPage,
          ListDocumentsFixedSizeCollection> {

    private ListDocumentsFixedSizeCollection(List<ListDocumentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDocumentsFixedSizeCollection createEmptyCollection() {
      return new ListDocumentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDocumentsFixedSizeCollection createCollection(
        List<ListDocumentsPage> pages, int collectionSize) {
      return new ListDocumentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCollectionIdsPagedResponse
      extends AbstractPagedListResponse<
          ListCollectionIdsRequest, ListCollectionIdsResponse, String, ListCollectionIdsPage,
          ListCollectionIdsFixedSizeCollection> {

    public static ApiFuture<ListCollectionIdsPagedResponse> createAsync(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ApiFuture<ListCollectionIdsResponse> futureResponse) {
      ApiFuture<ListCollectionIdsPage> futurePage =
          ListCollectionIdsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCollectionIdsPage, ListCollectionIdsPagedResponse>() {
            @Override
            public ListCollectionIdsPagedResponse apply(ListCollectionIdsPage input) {
              return new ListCollectionIdsPagedResponse(input);
            }
          });
    }

    private ListCollectionIdsPagedResponse(ListCollectionIdsPage page) {
      super(page, ListCollectionIdsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCollectionIdsPage
      extends AbstractPage<
          ListCollectionIdsRequest, ListCollectionIdsResponse, String, ListCollectionIdsPage> {

    private ListCollectionIdsPage(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ListCollectionIdsResponse response) {
      super(context, response);
    }

    private static ListCollectionIdsPage createEmptyPage() {
      return new ListCollectionIdsPage(null, null);
    }

    @Override
    protected ListCollectionIdsPage createPage(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ListCollectionIdsResponse response) {
      return new ListCollectionIdsPage(context, response);
    }

    @Override
    public ApiFuture<ListCollectionIdsPage> createPageAsync(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ApiFuture<ListCollectionIdsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCollectionIdsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCollectionIdsRequest, ListCollectionIdsResponse, String, ListCollectionIdsPage,
          ListCollectionIdsFixedSizeCollection> {

    private ListCollectionIdsFixedSizeCollection(
        List<ListCollectionIdsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCollectionIdsFixedSizeCollection createEmptyCollection() {
      return new ListCollectionIdsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCollectionIdsFixedSizeCollection createCollection(
        List<ListCollectionIdsPage> pages, int collectionSize) {
      return new ListCollectionIdsFixedSizeCollection(pages, collectionSize);
    }
  }
}
