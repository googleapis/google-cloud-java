/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Unix file system path.
 *
 * <p>This class is helpful for writing {@link java.nio.file.Path Path} implementations.
 *
 * <p>This implementation behaves almost identically to {@code sun.nio.fs.UnixPath}. The only
 * difference is that some methods (like {@link #relativize(UnixPath)} go to greater lengths to
 * preserve trailing backslashes, in order to ensure the path will continue to be recognized as a
 * directory.
 *
 * <p><b>Note:</b> This code might not play nice with <a
 * href="http://docs.oracle.com/javase/tutorial/i18n/text/supplementaryChars.html">Supplementary
 * Characters as Surrogates</a>.
 */
@Immutable
final class UnixPath implements CharSequence {

  public static final char DOT = '.';
  public static final char SEPARATOR = '/';
  public static final String ROOT = "" + SEPARATOR;
  public static final String CURRENT_DIR = "" + DOT;
  public static final String PARENT_DIR = "" + DOT + DOT;
  public static final UnixPath EMPTY_PATH = new UnixPath(false, "");
  public static final UnixPath ROOT_PATH = new UnixPath(false, ROOT);

  private static final Splitter SPLITTER = Splitter.on(SEPARATOR).omitEmptyStrings();
  private static final Splitter SPLITTER_PERMIT_EMPTY_COMPONENTS = Splitter.on(SEPARATOR);
  private static final Joiner JOINER = Joiner.on(SEPARATOR);
  private static final Ordering<Iterable<String>> ORDERING = Ordering.natural().lexicographical();

  private final String path;
  private List<String> lazyStringParts;
  private final boolean permitEmptyComponents;

  private UnixPath(boolean permitEmptyComponents, String path) {
    this.path = checkNotNull(path);
    this.permitEmptyComponents = permitEmptyComponents;
  }

  /** Returns new path of {@code first}. */
  public static UnixPath getPath(boolean permitEmptyComponents, String path) {
    if (path.isEmpty()) {
      return EMPTY_PATH;
    } else if (isRootInternal(path)) {
      return ROOT_PATH;
    } else {
      return new UnixPath(permitEmptyComponents, path);
    }
  }

  /**
   * Returns new path of {@code first} with {@code more} components resolved against it.
   *
   * @see #resolve(UnixPath)
   * @see java.nio.file.FileSystem#getPath(String, String...)
   */
  public static UnixPath getPath(boolean permitEmptyComponents, String first, String... more) {
    if (more.length == 0) {
      return getPath(permitEmptyComponents, first);
    }
    StringBuilder builder = new StringBuilder(first);
    for (int i = 0; i < more.length; i++) {
      String part = more[i];
      if (part.isEmpty()) {
        continue;
      } else if (isAbsoluteInternal(part)) {
        if (i == more.length - 1) {
          return new UnixPath(permitEmptyComponents, part);
        } else {
          builder.replace(0, builder.length(), part);
        }
      } else if (hasTrailingSeparatorInternal(builder)) {
        builder.append(part);
      } else {
        builder.append(SEPARATOR);
        builder.append(part);
      }
    }
    return new UnixPath(permitEmptyComponents, builder.toString());
  }

  /** Returns {@code true} consists only of {@code separator}. */
  public boolean isRoot() {
    return isRootInternal(path);
  }

  private static boolean isRootInternal(String path) {
    return path.length() == 1 && path.charAt(0) == SEPARATOR;
  }

  /** Returns {@code true} if path starts with {@code separator}. */
  public boolean isAbsolute() {
    return isAbsoluteInternal(path);
  }

  private static boolean isAbsoluteInternal(String path) {
    return !path.isEmpty() && path.charAt(0) == SEPARATOR;
  }

  /** Returns {@code true} if path ends with {@code separator}. */
  public boolean hasTrailingSeparator() {
    return hasTrailingSeparatorInternal(path);
  }

  private static boolean hasTrailingSeparatorInternal(CharSequence path) {
    return path.length() != 0 && path.charAt(path.length() - 1) == SEPARATOR;
  }

  /** Returns {@code true} if path ends with a trailing slash, or would after normalization. */
  public boolean seemsLikeADirectory() {
    int length = path.length();
    return path.isEmpty()
        || path.charAt(length - 1) == SEPARATOR
        || path.endsWith(".") && (length == 1 || path.charAt(length - 2) == SEPARATOR)
        || path.endsWith("..") && (length == 2 || path.charAt(length - 3) == SEPARATOR);
  }

  /**
   * Returns last component in {@code path}.
   *
   * @see java.nio.file.Path#getFileName()
   */
  @Nullable
  public UnixPath getFileName() {
    if (path.isEmpty()) {
      return EMPTY_PATH;
    } else if (isRoot()) {
      return null;
    } else {
      List<String> parts = getParts();
      String last = parts.get(parts.size() - 1);
      return parts.size() == 1 && path.equals(last)
          ? this
          : new UnixPath(permitEmptyComponents, last);
    }
  }

  /**
   * Returns parent directory (including trailing separator) or {@code null} if no parent remains.
   *
   * @see java.nio.file.Path#getParent()
   */
  @Nullable
  public UnixPath getParent() {
    if (path.isEmpty() || isRoot()) {
      return null;
    }
    int index =
        hasTrailingSeparator()
            ? path.lastIndexOf(SEPARATOR, path.length() - 2)
            : path.lastIndexOf(SEPARATOR);
    if (index == -1) {
      return isAbsolute() ? ROOT_PATH : null;
    } else {
      return new UnixPath(permitEmptyComponents, path.substring(0, index + 1));
    }
  }

  /**
   * Returns root component if an absolute path, otherwise {@code null}.
   *
   * @see java.nio.file.Path#getRoot()
   */
  @Nullable
  public UnixPath getRoot() {
    return isAbsolute() ? ROOT_PATH : null;
  }

  /**
   * Returns specified range of sub-components in path joined together.
   *
   * @see java.nio.file.Path#subpath(int, int)
   */
  public UnixPath subpath(int beginIndex, int endIndex) {
    if (path.isEmpty() && beginIndex == 0 && endIndex == 1) {
      return this;
    }
    checkArgument(beginIndex >= 0 && endIndex > beginIndex);
    List<String> subList;
    try {
      subList = getParts().subList(beginIndex, endIndex);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException();
    }
    return new UnixPath(permitEmptyComponents, JOINER.join(subList));
  }

  /**
   * Returns number of components in {@code path}.
   *
   * @see java.nio.file.Path#getNameCount()
   */
  public int getNameCount() {
    if (path.isEmpty()) {
      return 1;
    } else if (isRoot()) {
      return 0;
    } else {
      return getParts().size();
    }
  }

  /**
   * Returns component in {@code path} at {@code index}.
   *
   * @see java.nio.file.Path#getName(int)
   */
  public UnixPath getName(int index) {
    if (path.isEmpty()) {
      return this;
    }
    try {
      return new UnixPath(permitEmptyComponents, getParts().get(index));
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns path without extra separators or {@code .} and {@code ..}, preserving trailing slash.
   *
   * @see java.nio.file.Path#normalize()
   */
  public UnixPath normalize() {
    List<String> parts = new ArrayList<>();
    boolean mutated = false;
    int resultLength = 0;
    int mark = 0;
    int index;
    do {
      index = path.indexOf(SEPARATOR, mark);
      String part = path.substring(mark, index == -1 ? path.length() : index + 1);
      switch (part) {
        case CURRENT_DIR:
        case CURRENT_DIR + SEPARATOR:
          mutated = true;
          break;
        case PARENT_DIR:
        case PARENT_DIR + SEPARATOR:
          mutated = true;
          if (!parts.isEmpty()) {
            resultLength -= parts.remove(parts.size() - 1).length();
          }
          break;
        default:
          if (index != mark || index == 0) {
            parts.add(part);
            resultLength = part.length();
          } else {
            mutated = true;
          }
      }
      mark = index + 1;
    } while (index != -1);
    if (!mutated) {
      return this;
    }
    StringBuilder result = new StringBuilder(resultLength);
    for (String part : parts) {
      result.append(part);
    }
    return new UnixPath(permitEmptyComponents, result.toString());
  }

  /**
   * Returns {@code other} appended to {@code path}.
   *
   * @see java.nio.file.Path#resolve(java.nio.file.Path)
   */
  public UnixPath resolve(UnixPath other) {
    if (other.path.isEmpty()) {
      return this;
    } else if (other.isAbsolute()) {
      return other;
    } else if (hasTrailingSeparator()) {
      return new UnixPath(permitEmptyComponents, path + other.path);
    } else {
      return new UnixPath(permitEmptyComponents, path + SEPARATOR + other.path);
    }
  }

  /**
   * Returns {@code other} resolved against parent of {@code path}.
   *
   * @see java.nio.file.Path#resolveSibling(java.nio.file.Path)
   */
  public UnixPath resolveSibling(UnixPath other) {
    checkNotNull(other);
    UnixPath parent = getParent();
    return parent == null ? other : parent.resolve(other);
  }

  /**
   * Returns {@code other} made relative to {@code path}.
   *
   * @see java.nio.file.Path#relativize(java.nio.file.Path)
   */
  public UnixPath relativize(UnixPath other) {
    checkArgument(isAbsolute() == other.isAbsolute(), "'other' is different type of Path");
    if (path.isEmpty()) {
      return other;
    }
    PeekingIterator<String> left = Iterators.peekingIterator(split());
    PeekingIterator<String> right = Iterators.peekingIterator(other.split());
    while (left.hasNext() && right.hasNext()) {
      if (!left.peek().equals(right.peek())) {
        break;
      }
      left.next();
      right.next();
    }
    StringBuilder result = new StringBuilder(path.length() + other.path.length());
    while (left.hasNext()) {
      result.append(PARENT_DIR);
      result.append(SEPARATOR);
      left.next();
    }
    while (right.hasNext()) {
      result.append(right.next());
      result.append(SEPARATOR);
    }
    if (result.length() > 0 && !other.hasTrailingSeparator()) {
      result.deleteCharAt(result.length() - 1);
    }
    return new UnixPath(permitEmptyComponents, result.toString());
  }

  /**
   * Returns {@code true} if {@code path} starts with {@code other}.
   *
   * @see java.nio.file.Path#startsWith(java.nio.file.Path)
   */
  public boolean startsWith(UnixPath other) {
    UnixPath me = removeTrailingSeparator();
    other = other.removeTrailingSeparator();
    if (other.path.length() > me.path.length()) {
      return false;
    } else if (me.isAbsolute() != other.isAbsolute()) {
      return false;
    } else if (!me.path.isEmpty() && other.path.isEmpty()) {
      return false;
    }
    return startsWith(split(), other.split());
  }

  private static boolean startsWith(Iterator<String> lefts, Iterator<String> rights) {
    while (rights.hasNext()) {
      if (!lefts.hasNext() || !rights.next().equals(lefts.next())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns {@code true} if {@code path} ends with {@code other}.
   *
   * @see java.nio.file.Path#endsWith(java.nio.file.Path)
   */
  public boolean endsWith(UnixPath other) {
    UnixPath me = removeTrailingSeparator();
    other = other.removeTrailingSeparator();
    if (other.path.length() > me.path.length()) {
      return false;
    } else if (!me.path.isEmpty() && other.path.isEmpty()) {
      return false;
    } else if (other.isAbsolute()) {
      return me.isAbsolute() && me.path.equals(other.path);
    }
    return startsWith(me.splitReverse(), other.splitReverse());
  }

  /**
   * Compares two paths lexicographically for ordering.
   *
   * @see java.nio.file.Path#compareTo(java.nio.file.Path)
   */
  public int compareTo(UnixPath other) {
    return ORDERING.compare(getParts(), other.getParts());
  }

  /** Converts relative path to an absolute path. */
  public UnixPath toAbsolutePath(UnixPath currentWorkingDirectory) {
    checkArgument(currentWorkingDirectory.isAbsolute());
    return isAbsolute() ? this : currentWorkingDirectory.resolve(this);
  }

  /** Returns {@code toAbsolutePath(ROOT_PATH)}. */
  public UnixPath toAbsolutePath() {
    return toAbsolutePath(ROOT_PATH);
  }

  /** Removes beginning separator from path, if an absolute path. */
  public UnixPath removeBeginningSeparator() {
    return isAbsolute() ? new UnixPath(permitEmptyComponents, path.substring(1)) : this;
  }

  /** Adds trailing separator to path, if it isn't present. */
  public UnixPath addTrailingSeparator() {
    return hasTrailingSeparator() ? this : new UnixPath(permitEmptyComponents, path + SEPARATOR);
  }

  /** Removes trailing separator from path, unless it's root. */
  public UnixPath removeTrailingSeparator() {
    if (!isRoot() && hasTrailingSeparator()) {
      return new UnixPath(permitEmptyComponents, path.substring(0, path.length() - 1));
    } else {
      return this;
    }
  }

  /** Splits path into components, excluding separators and empty strings. */
  public Iterator<String> split() {
    return getParts().iterator();
  }

  /** Splits path into components in reverse, excluding separators and empty strings. */
  public Iterator<String> splitReverse() {
    return Lists.reverse(getParts()).iterator();
  }

  @Override
  public boolean equals(Object other) {
    return this == other || other instanceof UnixPath && path.equals(((UnixPath) other).path);
  }

  @Override
  public int hashCode() {
    return path.hashCode();
  }

  /** Returns path as a string. */
  @Override
  public String toString() {
    return path;
  }

  @Override
  public int length() {
    return path.length();
  }

  @Override
  public char charAt(int index) {
    return path.charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return path.subSequence(start, end);
  }

  /** Returns {@code true} if this path is an empty string. */
  public boolean isEmpty() {
    return path.isEmpty();
  }

  /** Returns list of path components, excluding slashes. */
  private List<String> getParts() {
    List<String> result = lazyStringParts;
    return result != null
        ? result
        : (lazyStringParts =
            path.isEmpty() || isRoot() ? Collections.<String>emptyList() : createParts());
  }

  private List<String> createParts() {
    if (permitEmptyComponents) {
      return SPLITTER_PERMIT_EMPTY_COMPONENTS.splitToList(
          path.charAt(0) == SEPARATOR ? path.substring(1) : path);
    } else {
      return SPLITTER.splitToList(path);
    }
  }
}
