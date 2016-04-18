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

package com.google.cloud.datastore;

import com.google.common.collect.ImmutableList;

/**
 * A helper for creating keys for a specific {@link Datastore},
 * using its associated projectId and namespace.
 */
public final class KeyFactory extends BaseKey.Builder<KeyFactory> {

  private final String pi;
  private final String ns;

  public KeyFactory(String projectId) {
    this(projectId, "");
  }

  public KeyFactory(String projectId, String namespace) {
    super(projectId);
    namespace(namespace);
    this.pi = projectId;
    this.ns = namespace;
  }

  public IncompleteKey newKey() {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind)).build();
    return new IncompleteKey(projectId, namespace, path);
  }

  public Key newKey(String name) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, name)).build();
    return new Key(projectId, namespace, path);
  }

  public Key newKey(long id) {
    ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
        .addAll(ancestors).add(PathElement.of(kind, id)).build();
    return new Key(projectId, namespace, path);
  }

  /**
   * Resets the KeyFactory to its initial state.
   * @return {@code this} for chaining
   */
  public KeyFactory reset() {
    projectId(pi);
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
