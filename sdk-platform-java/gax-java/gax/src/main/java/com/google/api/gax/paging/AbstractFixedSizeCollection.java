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

import com.google.api.client.util.Lists;
import com.google.api.pathtemplate.ValidationException;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.List;

/** Partial implementation of {@link FixedSizeCollection}. */
public abstract class AbstractFixedSizeCollection<
        RequestT,
        ResponseT,
        ResourceT,
        PageT extends AbstractPage<RequestT, ResponseT, ResourceT, PageT>,
        CollectionT extends
            AbstractFixedSizeCollection<RequestT, ResponseT, ResourceT, PageT, CollectionT>>
    implements FixedSizeCollection<ResourceT> {

  private final List<PageT> pageList;
  private final int collectionSize;

  protected AbstractFixedSizeCollection(List<PageT> pages, int collectionSize) {
    this.pageList = pages;
    this.collectionSize = collectionSize;
  }

  protected abstract CollectionT createCollection(List<PageT> pages, int collectionSize);

  @Override
  public Iterable<ResourceT> getValues() {
    return new Iterable<ResourceT>() {
      @Override
      public Iterator<ResourceT> iterator() {
        return new CollectionResourcesIterator();
      }
    };
  }

  @Override
  public CollectionT getNextCollection() {
    if (hasNextCollection()) {
      PageT nextFirstPage = getLastPage().getNextPage();
      List<PageT> pages = getPages(nextFirstPage, collectionSize);
      return createCollection(pages, collectionSize);
    } else {
      return null;
    }
  }

  @Override
  public boolean hasNextCollection() {
    return getLastPage().hasNextPage();
  }

  @Override
  public String getNextPageToken() {
    return getLastPage().getNextPageToken();
  }

  @Override
  public int getCollectionSize() {
    int size = 0;
    for (PageT page : pageList) {
      size += page.getPageElementCount();
    }
    return size;
  }

  private PageT getLastPage() {
    return pageList.get(pageList.size() - 1);
  }

  /**
   * Retrieve a list of pages with a total of collectionSize elements.
   *
   * <p>If the collectionSize parameter is greater than the number of elements in the firstPage
   * object, additional pages will be retrieved from the underlying API. It is an error to choose a
   * value of collectionSize that is less that the number of elements that already exist in the Page
   * object.
   */
  List<PageT> getPages(final PageT firstPage, final int collectionSize) {
    Preconditions.checkNotNull(firstPage);
    Preconditions.checkState(collectionSize > 0);
    Integer requestPageSize =
        firstPage.getContext().getPageDescriptor().extractPageSize(firstPage.getRequest());
    if (requestPageSize == null) {
      throw new ValidationException(
          "Error while expanding Page to FixedSizeCollection: No pageSize "
              + "parameter found. The pageSize parameter must be set on the request "
              + "object, and must be less than the collectionSize "
              + "parameter, in order to create a FixedSizeCollection object.");
    }
    if (requestPageSize > collectionSize) {
      throw new ValidationException(
          "Error while expanding Page to FixedSizeCollection: collectionSize "
              + "parameter is less than the pageSize optional argument specified on "
              + "the request object. collectionSize: "
              + collectionSize
              + ", pageSize: "
              + requestPageSize);
    }
    if (firstPage.getPageElementCount() > collectionSize) {
      throw new ValidationException(
          "Cannot construct a FixedSizeCollection with collectionSize less than the number of "
              + "elements in the first page");
    }

    int remainingCount = collectionSize - firstPage.getPageElementCount();
    List<PageT> pages = Lists.newArrayList();
    pages.add(firstPage);
    PageT currentPage = firstPage;
    while (remainingCount > 0) {
      currentPage = currentPage.getNextPage(remainingCount);
      if (currentPage == null) {
        break;
      } else {
        int rxElementCount = currentPage.getPageElementCount();
        if (rxElementCount > remainingCount) {
          throw new ValidationException(
              "API returned a number of elements exceeding the specified page_size limit. "
                  + "page_size: "
                  + collectionSize
                  + ", elements received: "
                  + rxElementCount);
        }
        remainingCount -= rxElementCount;
        pages.add(currentPage);
      }
    }
    return pages;
  }

  private class CollectionResourcesIterator extends AbstractIterator<ResourceT> {

    private final Iterator<PageT> pageIterator = pageList.iterator();
    private Iterator<ResourceT> resourceIterator = pageIterator.next().getValues().iterator();

    @Override
    protected ResourceT computeNext() {
      while (true) {
        if (resourceIterator.hasNext()) {
          return resourceIterator.next();
        } else if (pageIterator.hasNext()) {
          resourceIterator = pageIterator.next().getValues().iterator();
        } else {
          return endOfData();
        }
      }
    }
  }
}
