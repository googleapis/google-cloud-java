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
import java.util.Iterator;

/**
 * Google Cloud storage list result.
 */
public class ListResult<T extends Serializable> implements Iterable<T>, Serializable {

  private static final long serialVersionUID = -6937287874908527950L;

  private final String cursor;
  private final Iterable<T> results;

  ListResult(String cursor, Iterable<T> results) {
    this.cursor = cursor;
    this.results = results;
  }

  public String nextPageCursor() {
    return cursor;
  }

  @Override
  public Iterator<T> iterator() {
    return results.iterator();
  }
}
