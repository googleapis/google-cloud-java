/*
 * Copyright 2017 Google LLC
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
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * BasePath represents a path sequence in the Firestore database. It is composed of an ordered
 * sequence of string segments.
 */
public abstract class BasePath<B extends BasePath<B>> implements Comparable<B> {

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
    return append(path, true);
  }

  /**
   * Returns a new path pointing to a child of this Path.
   *
   * @param path A relative path
   * @param splitPath Whether or not the path should be split
   */
  B append(String path, boolean splitPath) {
    Preconditions.checkArgument(
        path != null && !path.isEmpty(), "'path' must be a non-empty String");
    ImmutableList.Builder<String> components = ImmutableList.builder();
    components.addAll(this.getSegments());
    if (splitPath) {
      components.add(splitChildPath(path));
    } else {
      components.add(path);
    }
    return createPathWithSegments(components.build());
  }

  /**
   * Returns a new path pointing to a child of this Path.
   *
   * @param path A relative path
   */
  B append(BasePath<B> path) {
    ImmutableList<String> segments1 = this.getSegments();
    ImmutableList<String> segments2 = path.getSegments();
    ImmutableList.Builder<String> components =
        ImmutableList.builderWithExpectedSize(segments1.size() + segments2.size());
    components.addAll(segments1);
    components.addAll(segments2);
    return createPathWithSegments(components.build());
  }

  /**
   * Checks to see if this path is a prefix of (or equals) another path.
   *
   * @param path the path to check against
   * @return true if current path is a prefix of the other path.
   */
  boolean isPrefixOf(BasePath<B> path) {
    List<String> prefixSegments = getSegments();
    List<String> childSegments = path.getSegments();
    int size = prefixSegments.size();
    if (size > childSegments.size()) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (!prefixSegments.get(i).equals(childSegments.get(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compare the current path against another Path object.
   *
   * <p>Compare the current path against another Path object. Paths are compared segment by segment,
   * prioritizing numeric IDs (e.g., "__id123__") in numeric ascending order, followed by string
   * segments in lexicographical order.
   *
   * @param other The path to compare to.
   * @return -1 if current is less than other, 1 if current greater than other, 0 if equal
   */
  @Override
  public int compareTo(@Nonnull B other) {
    List<String> thisSegments = this.getSegments();
    List<String> otherSegments = other.getSegments();

    int length = Math.min(thisSegments.size(), otherSegments.size());
    for (int i = 0; i < length; i++) {
      int cmp = compareSegments(thisSegments.get(i), otherSegments.get(i));
      if (cmp != 0) {
        return cmp;
      }
    }
    return Integer.compare(thisSegments.size(), otherSegments.size());
  }

  private int compareSegments(String lhs, String rhs) {
    boolean isLhsNumeric = isNumericId(lhs);
    boolean isRhsNumeric = isNumericId(rhs);

    if (isLhsNumeric && !isRhsNumeric) { // Only lhs is numeric
      return -1;
    } else if (!isLhsNumeric && isRhsNumeric) { // Only rhs is numeric
      return 1;
    } else if (isLhsNumeric && isRhsNumeric) { // both numeric
      return Long.compare(extractNumericId(lhs), extractNumericId(rhs));
    } else { // both string
      return Order.compareUtf8Strings(lhs, rhs);
    }
  }

  /** Checks if a segment is a numeric ID (starts with "__id" and ends with "__"). */
  private boolean isNumericId(String segment) {
    return segment.startsWith("__id") && segment.endsWith("__");
  }

  private long extractNumericId(String segment) {
    return Long.parseLong(segment.substring(4, segment.length() - 2));
  }

  abstract String[] splitChildPath(String path);

  abstract B createPathWithSegments(ImmutableList<String> segments);
}
