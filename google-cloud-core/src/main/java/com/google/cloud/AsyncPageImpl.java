/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.paging.AsyncPage;
import com.google.api.gax.paging.Page;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

/**
 * Base implementation for asynchronously consuming Google Cloud paginated results.
 *
 * @param <T> the value type that the page holds
 */
@InternalApi
public class AsyncPageImpl<T> extends PageImpl<T> implements AsyncPage<T> {

  private static final long serialVersionUID = -6009473188630364906L;

  private final NextPageFetcher<T> asyncPageFetcher;

  /**
   * Interface for asynchronously fetching the next page of results from the service.
   *
   * @param <T> the value type that the page holds
   */
  public interface NextPageFetcher<T> extends Serializable {

    ApiFuture<AsyncPage<T>> getNextPage();
  }

  private static class SyncNextPageFetcher<T> implements PageImpl.NextPageFetcher<T> {

    private static final long serialVersionUID = -4124568632363525351L;

    private final NextPageFetcher<T> asyncPageFetcher;

    private SyncNextPageFetcher(NextPageFetcher<T> asyncPageFetcher) {
      this.asyncPageFetcher = asyncPageFetcher;
    }

    @Override
    public Page<T> getNextPage() {
      try {
        return asyncPageFetcher != null
            ? Uninterruptibles.getUninterruptibly(asyncPageFetcher.getNextPage()) : null;
      } catch (ExecutionException ex) {
        throw Throwables.propagate(ex.getCause());
      }
    }
  }

  /**
   * Creates an {@code AsyncPageImpl} object.
   */
  public AsyncPageImpl(NextPageFetcher<T> asyncPageFetcher, String cursor, Iterable<T> results) {
    super(new SyncNextPageFetcher<T>(asyncPageFetcher), cursor, results);
    this.asyncPageFetcher = asyncPageFetcher;
  }


  @Override
  public ApiFuture<AsyncPage<T>> getNextPageAsync() {
    if (getNextPageToken() == null || asyncPageFetcher == null) {
      return ApiFutures.immediateFuture(null);
    }
    return asyncPageFetcher.getNextPage();
  }
}
