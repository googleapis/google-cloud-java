/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/**
 * BasePath represents a path sequence in the Firestore database. It is composed of an ordered
 * sequence of string segments.
 */
abstract class BasePath<B extends BasePath<B>> {

  /**
   * Returns the segments that make up this path.
   *
   * @return The path segments.
   */
  abstract ImmutableList<String> getSegments();

  /**
   * Returns the path of the parent element.
   *
   * @return The new Path or null if we are already at the root.
   */
  @Nullable
  B getParent() {
    ImmutableList<String> parts = getSegments();
    if (parts.isEmpty()) {
      return null;
    }
    return createPathWithSegments(parts.subList(0, parts.size() - 1));
  }

  /**
   * Returns a new path pointing to a child of this Path.
   *
   * @param path A relative path
   */
  B append(String path) {
    Preconditions.checkArgument(
        path != null && !path.isEmpty(), "'path' must be a non-empty String");
    ImmutableList.Builder<String> components = ImmutableList.builder();
    components.addAll(this.getSegments());
    components.add(splitChildPath(path));
    return createPathWithSegments(components.build());
  }

  /**
   * Returns a new path pointing to a child of this Path.
   *
   * @param path A relative path
   */
  B append(BasePath<B> path) {
    ImmutableList.Builder<String> components = ImmutableList.builder();
    components.addAll(this.getSegments());
    components.addAll(path.getSegments());
    return createPathWithSegments(components.build());
  }

  /**
   * Checks to see if this path is a prefix of (or equals) another path.
   *
   * @param path the path to check against
   * @return true if current path is a prefix of the other path.
   */
  boolean isPrefixOf(B path) {
    ImmutableList<String> prefixSegments = getSegments();
    ImmutableList<String> childSegments = path.getSegments();
    if (prefixSegments.size() > path.getSegments().size()) {
      return false;
    }
    for (int i = 0; i < prefixSegments.size(); i++) {
      if (!prefixSegments.get(i).equals(childSegments.get(i))) {
        return false;
      }
    }
    return true;
  }

  abstract String[] splitChildPath(String path);

  abstract B createPathWithSegments(ImmutableList<String> segments);

  boolean isPrefixOf(BasePath<B> field) {
    if (field.getSegments().size() < this.getSegments().size()) {
      return false;
    }

    return this.equals(
        createPathWithSegments(field.getSegments().subList(0, this.getSegments().size())));
  }
}
