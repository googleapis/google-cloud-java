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
package com.google.cloud.pubsub.spi.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.AbstractFixedSizeCollection;
import com.google.api.gax.grpc.AbstractPage;
import com.google.api.gax.grpc.AbstractPagedListResponse;
import com.google.api.gax.grpc.PageContext;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
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

  public static class ListTopicsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicsRequest, ListTopicsResponse, Topic, ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    public static ApiFuture<ListTopicsPagedResponse> createAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      ApiFuture<ListTopicsPage> futurePage =
          ListTopicsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTopicsPage, ListTopicsPagedResponse>() {
            @Override
            public ListTopicsPagedResponse apply(ListTopicsPage input) {
              return new ListTopicsPagedResponse(input);
            }
          });
    }

    private ListTopicsPagedResponse(ListTopicsPage page) {
      super(page, ListTopicsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTopicsPage
      extends AbstractPage<ListTopicsRequest, ListTopicsResponse, Topic, ListTopicsPage> {

    private ListTopicsPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      super(context, response);
    }

    private static ListTopicsPage createEmptyPage() {
      return new ListTopicsPage(null, null);
    }

    @Override
    protected ListTopicsPage createPage(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ListTopicsResponse response) {
      return new ListTopicsPage(context, response);
    }

    @Override
    protected ApiFuture<ListTopicsPage> createPageAsync(
        PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context,
        ApiFuture<ListTopicsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTopicsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicsRequest, ListTopicsResponse, Topic, ListTopicsPage,
          ListTopicsFixedSizeCollection> {

    private ListTopicsFixedSizeCollection(List<ListTopicsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicsFixedSizeCollection createEmptyCollection() {
      return new ListTopicsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicsFixedSizeCollection createCollection(
        List<ListTopicsPage> pages, int collectionSize) {
      return new ListTopicsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTopicSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String,
          ListTopicSubscriptionsPage, ListTopicSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListTopicSubscriptionsPagedResponse> createAsync(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ApiFuture<ListTopicSubscriptionsResponse> futureResponse) {
      ApiFuture<ListTopicSubscriptionsPage> futurePage =
          ListTopicSubscriptionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTopicSubscriptionsPage, ListTopicSubscriptionsPagedResponse>() {
            @Override
            public ListTopicSubscriptionsPagedResponse apply(ListTopicSubscriptionsPage input) {
              return new ListTopicSubscriptionsPagedResponse(input);
            }
          });
    }

    private ListTopicSubscriptionsPagedResponse(ListTopicSubscriptionsPage page) {
      super(page, ListTopicSubscriptionsFixedSizeCollection.createEmptyCollection());
    }

    public Iterable<SubscriptionName> iterateAllAsSubscriptionName() {
      return Iterables.transform(
          iterateAll(),
          new Function<String, SubscriptionName>() {
            @Override
            public SubscriptionName apply(String arg0) {
              return SubscriptionName.parse(arg0);
            }
          });
    }
  }

  public static class ListTopicSubscriptionsPage
      extends AbstractPage<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String,
          ListTopicSubscriptionsPage> {

    private ListTopicSubscriptionsPage(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ListTopicSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListTopicSubscriptionsPage createEmptyPage() {
      return new ListTopicSubscriptionsPage(null, null);
    }

    @Override
    protected ListTopicSubscriptionsPage createPage(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ListTopicSubscriptionsResponse response) {
      return new ListTopicSubscriptionsPage(context, response);
    }

    @Override
    protected ApiFuture<ListTopicSubscriptionsPage> createPageAsync(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String> context,
        ApiFuture<ListTopicSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }

    public Iterable<SubscriptionName> iterateAllAsSubscriptionName() {
      return Iterables.transform(
          iterateAll(),
          new Function<String, SubscriptionName>() {
            @Override
            public SubscriptionName apply(String arg0) {
              return SubscriptionName.parse(arg0);
            }
          });
    }

    public Iterable<SubscriptionName> getValuesAsSubscriptionName() {
      return Iterables.transform(
          getValues(),
          new Function<String, SubscriptionName>() {
            @Override
            public SubscriptionName apply(String arg0) {
              return SubscriptionName.parse(arg0);
            }
          });
    }
  }

  public static class ListTopicSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String,
          ListTopicSubscriptionsPage, ListTopicSubscriptionsFixedSizeCollection> {

    private ListTopicSubscriptionsFixedSizeCollection(
        List<ListTopicSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTopicSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListTopicSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTopicSubscriptionsFixedSizeCollection createCollection(
        List<ListTopicSubscriptionsPage> pages, int collectionSize) {
      return new ListTopicSubscriptionsFixedSizeCollection(pages, collectionSize);
    }

    public Iterable<SubscriptionName> getValuesAsSubscriptionName() {
      return Iterables.transform(
          getValues(),
          new Function<String, SubscriptionName>() {
            @Override
            public SubscriptionName apply(String arg0) {
              return SubscriptionName.parse(arg0);
            }
          });
    }
  }

  public static class ListSubscriptionsPagedResponse
      extends AbstractPagedListResponse<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription, ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    public static ApiFuture<ListSubscriptionsPagedResponse> createAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      ApiFuture<ListSubscriptionsPage> futurePage =
          ListSubscriptionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSubscriptionsPage, ListSubscriptionsPagedResponse>() {
            @Override
            public ListSubscriptionsPagedResponse apply(ListSubscriptionsPage input) {
              return new ListSubscriptionsPagedResponse(input);
            }
          });
    }

    private ListSubscriptionsPagedResponse(ListSubscriptionsPage page) {
      super(page, ListSubscriptionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubscriptionsPage
      extends AbstractPage<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription,
          ListSubscriptionsPage> {

    private ListSubscriptionsPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      super(context, response);
    }

    private static ListSubscriptionsPage createEmptyPage() {
      return new ListSubscriptionsPage(null, null);
    }

    @Override
    protected ListSubscriptionsPage createPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ListSubscriptionsResponse response) {
      return new ListSubscriptionsPage(context, response);
    }

    @Override
    protected ApiFuture<ListSubscriptionsPage> createPageAsync(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context,
        ApiFuture<ListSubscriptionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubscriptionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription, ListSubscriptionsPage,
          ListSubscriptionsFixedSizeCollection> {

    private ListSubscriptionsFixedSizeCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubscriptionsFixedSizeCollection createEmptyCollection() {
      return new ListSubscriptionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubscriptionsFixedSizeCollection createCollection(
        List<ListSubscriptionsPage> pages, int collectionSize) {
      return new ListSubscriptionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListSnapshotsPagedResponse> createAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      ApiFuture<ListSnapshotsPage> futurePage =
          ListSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSnapshotsPage, ListSnapshotsPagedResponse>() {
            @Override
            public ListSnapshotsPagedResponse apply(ListSnapshotsPage input) {
              return new ListSnapshotsPagedResponse(input);
            }
          });
    }

    private ListSnapshotsPagedResponse(ListSnapshotsPage page) {
      super(page, ListSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnapshotsPage
      extends AbstractPage<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage> {

    private ListSnapshotsPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      super(context, response);
    }

    private static ListSnapshotsPage createEmptyPage() {
      return new ListSnapshotsPage(null, null);
    }

    @Override
    protected ListSnapshotsPage createPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      return new ListSnapshotsPage(context, response);
    }

    @Override
    protected ApiFuture<ListSnapshotsPage> createPageAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    private ListSnapshotsFixedSizeCollection(List<ListSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnapshotsFixedSizeCollection createCollection(
        List<ListSnapshotsPage> pages, int collectionSize) {
      return new ListSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }
}
