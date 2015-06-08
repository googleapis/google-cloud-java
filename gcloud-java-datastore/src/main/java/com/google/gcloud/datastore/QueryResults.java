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

package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission.
 * When the result is not typed it is possible to cast it to its appropriate type according to
 * the {@link #resultClass} value.
 * Results are loaded lazily; therefore it is possible to get a {@code DatastoreException}
 * upon {@link Iterator#hasNext hasNext} or {@link Iterator#next next} calls.
 *
 * @param <V> the type of the results value.
 */
public interface QueryResults<V> extends Iterator<V> {

  /**
   * Returns the actual class of the result's values.
   */
  Class<?> resultClass();

  /**
   * Returns the Cursor for point after the value returned in the last {@link #next} call.
   * Not currently implemented (depends on v1beta3).
   */
  Cursor cursorAfter();
}
