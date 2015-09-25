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

package com.google.gcloud.storage;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/**
 * Base implementation for Google Cloud storage list result.
 */
public class BaseListResult<T extends Serializable> implements ListResult<T>, Serializable {

  private static final long serialVersionUID = -6937287874908527950L;

  private final String cursor;
  private final Iterable<T> results;
  private final NextPageFetcher<T> pageFetcher;

  public interface NextPageFetcher<T extends Serializable> extends Serializable {
    ListResult<T> nextPage();
  }

  public BaseListResult(NextPageFetcher<T> pageFetcher, String cursor, Iterable<T> results) {
    this.pageFetcher = pageFetcher;
    this.cursor = cursor;
    this.results = results;
  }

  @Override
  public String nextPageCursor() {
    return cursor;
  }

  @Override
  public ListResult<T> nextPage() {
    if (cursor == null || pageFetcher == null) {
      return null;
    }
    return pageFetcher.nextPage();
  }

  @Override
  public Iterator<T> iterator() {
    return results == null ? Collections.<T>emptyIterator() : results.iterator();
  }

  @Override
  public int hashCode() {
    return Objects.hash(cursor, results);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BaseListResult)) {
      return false;
    }
    BaseListResult<?> other = (BaseListResult<?>) obj;
    return Objects.equals(cursor, other.cursor)
        && Objects.equals(results, other.results);
  }
}
