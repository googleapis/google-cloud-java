/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import com.google.api.core.InternalApi;
import com.google.api.gax.paging.Page;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Base implementation for Google Cloud paginated results.
 *
 * @param <T> the value type that the page holds
 */
@InternalApi
public class PageImpl<T> implements Page<T>, Serializable {

  private static final long serialVersionUID = 3914827379823557934L;

  private final String cursor;
  private final Iterable<T> results;
  private final NextPageFetcher<T> pageFetcher;

  /**
   * Interface for fetching the next page of results from the service.
   *
   * @param <T> the value type that the page holds
   */
  public interface NextPageFetcher<T> extends Serializable {

    Page<T> getNextPage();
  }

  static class PageIterator<T> extends AbstractIterator<T> {

    private Iterator<T> currentPageIterator;
    private Page<T> currentPage;

    PageIterator(Page<T> currentPage) {
      this.currentPageIterator = currentPage.getValues().iterator();
      this.currentPage = currentPage;
    }

    @Override
    protected T computeNext() {
      while (!currentPageIterator.hasNext()) {
        currentPage = currentPage.getNextPage();
        if (currentPage == null) {
          return endOfData();
        }
        currentPageIterator = currentPage.getValues().iterator();
      }
      return currentPageIterator.next();
    }
  }

  /**
   * Creates a {@code PageImpl} object. In order for the object to be serializable the {@code
   * results} parameter must be serializable.
   */
  public PageImpl(NextPageFetcher<T> pageFetcher, String cursor, Iterable<T> results) {
    this.pageFetcher = pageFetcher;
    this.cursor = cursor;
    this.results = results;
  }

  @Override
  public Iterable<T> getValues() {
    return results == null ? Collections.<T>emptyList() : results;
  }

  @Override
  public Iterable<T> iterateAll() {
    return new Iterable<T>() {
      @Override
      public Iterator<T> iterator() {
        return new PageIterator<>(PageImpl.this);
      }
    };
  }

  @Override
  public boolean hasNextPage() {
    return getNextPageToken() != null && !getNextPageToken().equals("");
  }

  @Override
  public String getNextPageToken() {
    return cursor;
  }


  @Override
  public Page<T> getNextPage() {
    if (cursor == null || pageFetcher == null) {
      return null;
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(cursor, results);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PageImpl)) {
      return false;
    }
    PageImpl<?> other = (PageImpl<?>) obj;
    return Objects.equals(cursor, other.cursor)
        && Objects.equals(results, other.results);
  }

  /**
   * Utility method to construct the options map for the next page request.
   *
   * @param <T> the value type that the page holds. Instances of {@code T} should be
   *     {@code Serializable}
   * @param pageTokenOption the key for the next page cursor option in the options map
   * @param cursor the cursor for the next page
   * @param optionMap the previous options map
   * @return the options map for the next page request
   */
  public static <T> Map<T, Object> nextRequestOptions(
      T pageTokenOption, String cursor, Map<T, ?> optionMap) {
    ImmutableMap.Builder<T, Object> builder = ImmutableMap.builder();
    if (cursor != null) {
      builder.put(pageTokenOption, cursor);
    }
    for (Map.Entry<T, ?> option : optionMap.entrySet()) {
      if (!Objects.equals(option.getKey(), pageTokenOption)) {
        builder.put(option.getKey(), option.getValue());
      }
    }
    return builder.build();
  }
}
