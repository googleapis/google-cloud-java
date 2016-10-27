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

import java.util.concurrent.Future;

/**
 * Interface for asynchronously consuming Google Cloud paginated results.
 *
 * <p>Use {@code AsyncPage} to iterate through all values (also in next pages):
 * <pre> {@code
 * AsyncPage<T> page = ...; // get an AsyncPage<T> instance
 * Iterator<T> iterator = page.iterateAll();
 * while (iterator.hasNext()) {
 *   T value = iterator.next();
 *   // do something with value
 * }}</pre>
 *
 * <p>Or handle pagination explicitly:
 * <pre> {@code
 * AsyncPage<T> page = ...; // get a AsyncPage<T> instance
 * while (page != null) {
 *   for (T value : page.getValues()) {
 *     // do something with value
 *   }
 *   page = page.getNextPageAsync().get();
 * }}</pre>
 *
 * @param <T> the value type that the page holds
 */
public interface AsyncPage<T> extends Page<T> {

  /**
   * Returns a {@link Future} object for the next page. {@link Future#get()} returns {@code null} if
   * the last page has been reached.
   */
  @Deprecated
  Future<AsyncPage<T>> nextPageAsync();

  /**
   * Returns a {@link Future} object for the next page. {@link Future#get()} returns {@code null} if
   * the last page has been reached.
   */
  Future<AsyncPage<T>> getNextPageAsync();
}
