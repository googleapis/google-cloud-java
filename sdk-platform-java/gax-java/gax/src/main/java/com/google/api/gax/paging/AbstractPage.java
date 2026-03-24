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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.PageContext;
import com.google.common.base.Strings;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import java.util.Iterator;

/** Partial implementation of {@link AsyncPage}. */
public abstract class AbstractPage<
        RequestT,
        ResponseT,
        ResourceT,
        PageT extends AbstractPage<RequestT, ResponseT, ResourceT, PageT>>
    implements AsyncPage<ResourceT> {

  private final PageContext<RequestT, ResponseT, ResourceT> context;
  private final ResponseT response;

  protected AbstractPage(PageContext<RequestT, ResponseT, ResourceT> context, ResponseT response) {
    this.context = context;
    this.response = response;
  }

  protected abstract PageT createPage(
      PageContext<RequestT, ResponseT, ResourceT> context, ResponseT response);

  @InternalApi("Visible for testing")
  public ApiFuture<PageT> createPageAsync(
      final PageContext<RequestT, ResponseT, ResourceT> context,
      ApiFuture<ResponseT> futureResponse) {
    return ApiFutures.transform(
        futureResponse,
        new ApiFunction<ResponseT, PageT>() {
          @Override
          public PageT apply(ResponseT input) {
            return createPage(context, input);
          }
        },
        directExecutor());
  }

  @Override
  public boolean hasNextPage() {
    return !getNextPageToken().equals(context.getPageDescriptor().emptyToken());
  }

  @Override
  public String getNextPageToken() {
    return Strings.nullToEmpty(context.getPageDescriptor().extractNextToken(response));
  }

  @Override
  public PageT getNextPage() {
    return getNextPageImpl(null);
  }

  public PageT getNextPage(int pageSize) {
    return getNextPageImpl(pageSize);
  }

  @Override
  public ApiFuture<PageT> getNextPageAsync() {
    if (hasNextPage()) {
      RequestT request =
          context.getPageDescriptor().injectToken(context.getRequest(), getNextPageToken());
      final PageContext<RequestT, ResponseT, ResourceT> nextContext = context.withRequest(request);
      return createPageAsync(nextContext, callApi(nextContext));
    } else {
      return ApiFutures.immediateFuture(null);
    }
  }

  private PageT getNextPageImpl(Integer pageSize) {
    if (hasNextPage()) {
      RequestT request =
          context.getPageDescriptor().injectToken(context.getRequest(), getNextPageToken());
      if (pageSize != null) {
        request = context.getPageDescriptor().injectPageSize(request, pageSize);
      }
      PageContext<RequestT, ResponseT, ResourceT> nextContext = context.withRequest(request);
      ResponseT response = ApiExceptions.callAndTranslateApiException(callApi(nextContext));
      return createPage(nextContext, response);
    } else {
      return null;
    }
  }

  private ApiFuture<ResponseT> callApi(PageContext<RequestT, ResponseT, ResourceT> nextContext) {
    return nextContext
        .getCallable()
        .futureCall(nextContext.getRequest(), nextContext.getCallContext());
  }

  @Override
  public Iterable<ResourceT> iterateAll() {
    return new Iterable<ResourceT>() {
      @Override
      public Iterator<ResourceT> iterator() {
        return new AllResourcesIterator();
      }
    };
  }

  @Override
  public Iterable<ResourceT> getValues() {
    return context.getPageDescriptor().extractResources(response);
  }

  public ResponseT getResponse() {
    return response;
  }

  public RequestT getRequest() {
    return context.getRequest();
  }

  public int getPageElementCount() {
    return Iterables.size(context.getPageDescriptor().extractResources(response));
  }

  PageContext<RequestT, ResponseT, ResourceT> getContext() {
    return context;
  }

  private class AllResourcesIterator extends AbstractIterator<ResourceT> {
    private AbstractPage<RequestT, ResponseT, ResourceT, PageT> currentPage;
    private Iterator<ResourceT> currentIterator;

    private AllResourcesIterator() {
      this.currentPage = AbstractPage.this;
      this.currentIterator = this.currentPage.getValues().iterator();
    }

    @Override
    protected ResourceT computeNext() {
      while (true) {
        if (currentIterator.hasNext()) {
          return currentIterator.next();
        }
        currentPage = currentPage.getNextPage();
        if (currentPage == null) {
          return endOfData();
        }
        currentIterator = currentPage.getValues().iterator();
      }
    }
  }
}
