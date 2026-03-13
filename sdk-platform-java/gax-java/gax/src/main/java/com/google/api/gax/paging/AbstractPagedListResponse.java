/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.paging;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.List;

/** Partial implementation of {@link com.google.api.gax.paging.PagedListResponse}. */
public abstract class AbstractPagedListResponse<
        RequestT,
        ResponseT,
        ResourceT,
        PageT extends AbstractPage<RequestT, ResponseT, ResourceT, PageT>,
        CollectionT extends
            AbstractFixedSizeCollection<RequestT, ResponseT, ResourceT, PageT, CollectionT>>
    implements PagedListResponse<ResourceT> {

  private final PageT page;
  private final CollectionT emptyCollection;

  protected AbstractPagedListResponse(PageT page, CollectionT emptyCollection) {
    this.page = page;
    this.emptyCollection = emptyCollection;
  }

  @Override
  public Iterable<ResourceT> iterateAll() {
    return getPage().iterateAll();
  }

  @Override
  public PageT getPage() {
    return page;
  }

  @Override
  public Iterable<PageT> iteratePages() {
    return new Iterable<PageT>() {
      @Override
      public Iterator<PageT> iterator() {
        return new AllPagesIterator(page);
      }
    };
  }

  @Override
  public String getNextPageToken() {
    return getPage().getNextPageToken();
  }

  @Override
  public CollectionT expandToFixedSizeCollection(int collectionSize) {
    List<PageT> pages = emptyCollection.getPages(page, collectionSize);
    return emptyCollection.createCollection(pages, collectionSize);
  }

  @Override
  public Iterable<CollectionT> iterateFixedSizeCollections(int collectionSize) {
    final CollectionT firstCollection = expandToFixedSizeCollection(collectionSize);
    return new Iterable<CollectionT>() {
      @Override
      public Iterator<CollectionT> iterator() {
        return new AllCollectionsIterator(firstCollection);
      }
    };
  }

  private interface Next<T> {
    T next(T current);
  }

  private class AllPagesIterator extends NextIterator<PageT> {
    private AllPagesIterator(PageT firstCollection) {
      super(
          firstCollection,
          new Next<PageT>() {
            @Override
            public PageT next(PageT current) {
              return current.getNextPage();
            }
          });
    }
  }

  private class AllCollectionsIterator extends NextIterator<CollectionT> {
    private AllCollectionsIterator(CollectionT firstCollection) {
      super(
          firstCollection,
          new Next<CollectionT>() {
            @Override
            public CollectionT next(CollectionT current) {
              return current.getNextCollection();
            }
          });
    }
  }

  private class NextIterator<T> extends AbstractIterator<T> {

    private T current;
    private final Next<T> fetcher;
    private boolean computeFirst = true;

    private NextIterator(T first, Next<T> fetcher) {
      this.current = Preconditions.checkNotNull(first);
      this.fetcher = fetcher;
    }

    @Override
    protected T computeNext() {
      if (computeFirst) {
        computeFirst = false;
        return current;
      } else {
        current = fetcher.next(current);
        if (current == null) {
          return endOfData();
        } else {
          return current;
        }
      }
    }
  }
}
