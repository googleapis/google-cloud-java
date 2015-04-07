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

import com.google.common.collect.ImmutableList;

/**
 * An helper for creating keys for a specific {@link DatastoreService},
 * using its associated dataset and namespace.
 */
public final class KeyFactory extends BaseKey.Builder<KeyFactory> {

  private final String ds;
  private final String ns;

  public KeyFactory(String dataset) {
    this(dataset, null);
  }

  public KeyFactory(String dataset, String namespace) {
    super(dataset);
    namespace(namespace);
    this.ds = dataset;
    this.ns = namespace;
  }

  public IncompleteKey newKey() {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind)).build();
    return new IncompleteKey(dataset, namespace, path);
  }

  public Key newKey(String name) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, name)).build();
    return new Key(dataset, namespace, path);
  }

  public Key newKey(long id) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, id)).build();
    return new Key(dataset, namespace, path);
  }

  /**
   * Resets the KeyFactory to its initial state.
   * @return {@code this} for chaining.
   */
  public KeyFactory reset() {
    dataset(ds);
    namespace(ns);
    kind = null;
    ancestors.clear();
    return this;
  }

  @Override
  protected IncompleteKey build() {
    return newKey();
  }
}
