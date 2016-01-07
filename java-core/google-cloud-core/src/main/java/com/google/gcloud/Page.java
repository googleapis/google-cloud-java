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

import java.util.Iterator;

/**
 * Interface for Google Cloud paginated results.
 *
 * <p>
 * Use {@code Page} to iterate through all values (also in next pages):
 * <pre> {@code
 * Page<T> page = ...; // get a Page<T> instance
 * Iterator<T> iterator = page.iterateAll();
 * while (iterator.hasNext()) {
 *   T value = iterator.next();
 *   // do something with value
 * }}</pre>
 * <p>
 * Or handle pagination explicitly:
 * <pre> {@code
 * Page<T> page = ...; // get a Page<T> instance
 * while (page != null) {
 *   for (T value : page.values()) {
 *     // do something with value
 *   }
 *   page = page.nextPage();
 * }}</pre>
 *
 * @param <T> the value type that the page holds
 */
public interface Page<T> {

  /**
   * Returns the values contained in this page.
   */
  Iterable<T> values();

  /**
   * Returns an iterator for all values, possibly also in the next pages. Once current page's values
   * are traversed the iterator fetches next page, if any.
   */
  Iterator<T> iterateAll();

  /**
   * Returns the cursor for the nextPage or {@code null} if no more results.
   */
  String nextPageCursor();

  /**
   * Returns the next page of results or {@code null} if no more result.
   */
  Page<T> nextPage();

}
