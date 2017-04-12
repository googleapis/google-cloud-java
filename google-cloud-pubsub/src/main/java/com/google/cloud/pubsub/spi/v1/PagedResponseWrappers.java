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

import com.google.api.gax.core.FixedSizeCollection;
import com.google.api.gax.core.Page;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PageContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseContext;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.protobuf.ExperimentalApi;
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

  public static class ListTopicsPagedResponse implements PagedListResponse<Topic> {

    private final PagedListResponseContext<ListTopicsRequest, ListTopicsResponse, Topic> context;
    private final ListTopicsPage page;

    public ListTopicsPagedResponse(
        UnaryCallable<ListTopicsRequest, ListTopicsResponse> callable,
        PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic> pageDescriptor,
        ListTopicsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListTopicsPage(this.context);
    }

    public Iterable<Topic> iterateAll() {
      return context.iterateAll();
    }

    public Page<Topic> getPage() {
      return page;
    }

    public Iterable<ListTopicsPage> iteratePages() {
      return new Iterable<ListTopicsPage>() {
        @Override
        public Iterator<ListTopicsPage> iterator() {
          return new PageContext.PageIterator<ListTopicsPage>(
              new PageContext.PageFetcher<ListTopicsPage>() {
                @Override
                public ListTopicsPage getNextPage(ListTopicsPage currentPage) {
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

    public FixedSizeCollection<Topic> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<Topic>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListTopicsPage implements Page<Topic> {
    private final PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context;

    public ListTopicsPage(PageContext<ListTopicsRequest, ListTopicsResponse, Topic> context) {
      this.context = context;
    }

    @Override
    public Iterator<Topic> iterator() {
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
    public ListTopicsPage getNextPage() {
      return new ListTopicsPage(context.getNextPageContext());
    }

    public ListTopicsPage getNextPage(int pageSize) {
      return new ListTopicsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<Topic> iterateAll() {
      return context.iterateAll();
    }

    public ListTopicsResponse getResponse() {
      return context.getResponse();
    }

    public ListTopicsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListTopicSubscriptionsPagedResponse implements PagedListResponse<String> {

    private final PagedListResponseContext<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        context;
    private final ListTopicSubscriptionsPage page;

    public ListTopicSubscriptionsPagedResponse(
        UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse> callable,
        PagedListDescriptor<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
            pageDescriptor,
        ListTopicSubscriptionsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListTopicSubscriptionsPage(this.context);
    }

    public Iterable<String> iterateAll() {
      return context.iterateAll();
    }

    public Page<String> getPage() {
      return page;
    }

    public Iterable<ListTopicSubscriptionsPage> iteratePages() {
      return new Iterable<ListTopicSubscriptionsPage>() {
        @Override
        public Iterator<ListTopicSubscriptionsPage> iterator() {
          return new PageContext.PageIterator<ListTopicSubscriptionsPage>(
              new PageContext.PageFetcher<ListTopicSubscriptionsPage>() {
                @Override
                public ListTopicSubscriptionsPage getNextPage(
                    ListTopicSubscriptionsPage currentPage) {
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

  public static class ListTopicSubscriptionsPage implements Page<String> {
    private final PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        context;

    public ListTopicSubscriptionsPage(
        PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
            context) {
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
    public ListTopicSubscriptionsPage getNextPage() {
      return new ListTopicSubscriptionsPage(context.getNextPageContext());
    }

    public ListTopicSubscriptionsPage getNextPage(int pageSize) {
      return new ListTopicSubscriptionsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<String> iterateAll() {
      return context.iterateAll();
    }

    public ListTopicSubscriptionsResponse getResponse() {
      return context.getResponse();
    }

    public ListTopicSubscriptionsRequest getRequest() {
      return context.getRequest();
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

  public static class ListSubscriptionsPagedResponse implements PagedListResponse<Subscription> {

    private final PagedListResponseContext<
            ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
        context;
    private final ListSubscriptionsPage page;

    public ListSubscriptionsPagedResponse(
        UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse> callable,
        PagedListDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
            pageDescriptor,
        ListSubscriptionsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListSubscriptionsPage(this.context);
    }

    public Iterable<Subscription> iterateAll() {
      return context.iterateAll();
    }

    public Page<Subscription> getPage() {
      return page;
    }

    public Iterable<ListSubscriptionsPage> iteratePages() {
      return new Iterable<ListSubscriptionsPage>() {
        @Override
        public Iterator<ListSubscriptionsPage> iterator() {
          return new PageContext.PageIterator<ListSubscriptionsPage>(
              new PageContext.PageFetcher<ListSubscriptionsPage>() {
                @Override
                public ListSubscriptionsPage getNextPage(ListSubscriptionsPage currentPage) {
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

    public FixedSizeCollection<Subscription> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<Subscription>> iterateFixedSizeCollections(
        int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListSubscriptionsPage implements Page<Subscription> {
    private final PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
        context;

    public ListSubscriptionsPage(
        PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription> context) {
      this.context = context;
    }

    @Override
    public Iterator<Subscription> iterator() {
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
    public ListSubscriptionsPage getNextPage() {
      return new ListSubscriptionsPage(context.getNextPageContext());
    }

    public ListSubscriptionsPage getNextPage(int pageSize) {
      return new ListSubscriptionsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<Subscription> iterateAll() {
      return context.iterateAll();
    }

    public ListSubscriptionsResponse getResponse() {
      return context.getResponse();
    }

    public ListSubscriptionsRequest getRequest() {
      return context.getRequest();
    }
  }

  public static class ListSnapshotsPagedResponse implements PagedListResponse<Snapshot> {

    private final PagedListResponseContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>
        context;
    private final ListSnapshotsPage page;

    public ListSnapshotsPagedResponse(
        UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> callable,
        PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> pageDescriptor,
        ListSnapshotsRequest request,
        CallContext callContext) {
      this.context = new PagedListResponseContext<>(callable, pageDescriptor, request, callContext);
      this.page = new ListSnapshotsPage(this.context);
    }

    public Iterable<Snapshot> iterateAll() {
      return context.iterateAll();
    }

    public Page<Snapshot> getPage() {
      return page;
    }

    public Iterable<ListSnapshotsPage> iteratePages() {
      return new Iterable<ListSnapshotsPage>() {
        @Override
        public Iterator<ListSnapshotsPage> iterator() {
          return new PageContext.PageIterator<ListSnapshotsPage>(
              new PageContext.PageFetcher<ListSnapshotsPage>() {
                @Override
                public ListSnapshotsPage getNextPage(ListSnapshotsPage currentPage) {
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

    public FixedSizeCollection<Snapshot> expandToFixedSizeCollection(int collectionSize) {
      return context.expandToFixedSizeCollection(collectionSize);
    }

    public Iterable<FixedSizeCollection<Snapshot>> iterateFixedSizeCollections(int collectionSize) {
      return context.iterateFixedSizeCollections(collectionSize);
    }
  }

  public static class ListSnapshotsPage implements Page<Snapshot> {
    private final PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context;

    public ListSnapshotsPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context) {
      this.context = context;
    }

    @Override
    public Iterator<Snapshot> iterator() {
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
    public ListSnapshotsPage getNextPage() {
      return new ListSnapshotsPage(context.getNextPageContext());
    }

    public ListSnapshotsPage getNextPage(int pageSize) {
      return new ListSnapshotsPage(context.getNextPageContext(pageSize));
    }

    @Override
    public Iterable<Snapshot> iterateAll() {
      return context.iterateAll();
    }

    public ListSnapshotsResponse getResponse() {
      return context.getResponse();
    }

    public ListSnapshotsRequest getRequest() {
      return context.getRequest();
    }
  }
}
