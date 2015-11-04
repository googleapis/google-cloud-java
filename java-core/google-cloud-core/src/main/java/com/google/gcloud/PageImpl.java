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

package com.google.gcloud;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;

/**
 * Base implementation for Google Cloud paginated results.
 */
public class PageImpl<T> implements Page<T>, Serializable {

  private static final long serialVersionUID = 3914827379823557934L;

  private final String cursor;
  private final Iterable<T> results;
  private final NextPageFetcher<T> pageFetcher;

  public interface NextPageFetcher<T> extends Serializable {
    Page<T> nextPage();
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
  public Iterable<T> values() {
    return results == null ? Collections.EMPTY_LIST : results;
  }

  @Override
  public String nextPageCursor() {
    return cursor;
  }

  @Override
  public Page<T> nextPage() {
    if (cursor == null || pageFetcher == null) {
      return null;
    }
    return pageFetcher.nextPage();
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
}
