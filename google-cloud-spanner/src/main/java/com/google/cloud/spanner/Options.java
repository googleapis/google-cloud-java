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

package com.google.cloud.spanner;

import com.google.common.base.Preconditions;

/** Specifies options for various spanner operations */
public final class Options {

  /** Marker interface to mark options applicable to both Read and Query operations */
  public interface ReadAndQueryOption extends ReadOption, QueryOption {}

  /** Marker interface to mark options applicable to read operation */
  public interface ReadOption {}

  /** Marker interface to mark options applicable to query operation. */
  public interface QueryOption {}

  /** Marker interface to mark options applicable to list operations in admin API. */
  public interface ListOption {}

  /**
   * Specifying this will cause the read to yield at most this many rows. This should be greater
   * than 0.
   */
  public static ReadOption limit(long limit) {
    Preconditions.checkArgument(limit > 0, "Limit should be greater than 0");
    return new LimitOption(limit);
  }

  /**
   * Specifying this will allow the client to prefetch up to {@code prefetchChunks} {@code
   * PartialResultSet} chunks for read and query. The data size of each chunk depends on the server
   * implementation but a good rule of thumb is that each chunk will be up to 1 MiB. Larger values
   * reduce the likelihood of blocking while consuming results at the cost of greater memory
   * consumption. {@code prefetchChunks} should be greater than 0. To get good performance choose a
   * value that is large enough to allow buffering of chunks for an entire row. Apart from the
   * buffered chunks, there can be at most one more row buffered in the client.
   */
  public static ReadAndQueryOption prefetchChunks(int prefetchChunks) {
    Preconditions.checkArgument(prefetchChunks > 0, "prefetchChunks should be greater than 0");
    return new FlowControlOption(prefetchChunks);
  }

  /**
   * Specifying this will cause the list operations to fetch at most this many records in a page.
   */
  public static ListOption pageSize(int pageSize) {
    return new PageSizeOption(pageSize);
  }

  /**
   * Specifying this will cause the list operation to start fetching the record from this onwards.
   */
  public static ListOption pageToken(String pageToken) {
    return new PageTokenOption(pageToken);
  }

  /**
   * Specifying this will cause the given filter to be applied to the list operation. List
   * operations that support this options are:
   *
   * <ul>
   *   <li> {@link InstanceAdminClient#listInstances}
   * </ul>
   *
   * If this option is passed to any other list operation, it will throw an
   * IllegalArgumentException.
   *
   * @param filter An expression for filtering the results of the request. Filter rules are case
   *     insensitive. Some examples of using filters are:
   *     <ul>
   *       <li> name:* The entity has a name.
   *       <li> name:Howl The entity's name contains "howl".
   *       <li> name:HOWL Equivalent to above.
   *       <li> NAME:howl Equivalent to above.
   *       <li> labels.env:* The entity has the label env.
   *       <li> labels.env:dev The entity has a label env whose value contains "dev".
   *       <li> name:howl labels.env:dev The entity's name contains "howl" and it has the label env
   *           whose value contains "dev".
   *     </ul>
   */
  public static ListOption filter(String filter) {
    return new FilterOption(filter);
  }

  /** Option pertaining to flow control. */
  static final class FlowControlOption extends InternalOption implements ReadAndQueryOption {
    final int prefetchChunks;

    FlowControlOption(int prefetchChunks) {
      this.prefetchChunks = prefetchChunks;
    }

    int prefetchChunks() {
      return prefetchChunks;
    }

    @Override
    void appendToOptions(Options options) {
      options.prefetchChunks = prefetchChunks;
    }
  }

  private Long limit;
  private Integer prefetchChunks;
  private Integer pageSize;
  private String pageToken;
  private String filter;

  // Construction is via factory methods below.
  private Options() {}

  boolean hasLimit() {
    return limit != null;
  }

  long limit() {
    return limit;
  }

  boolean hasPrefetchChunks() {
    return prefetchChunks != null;
  }

  int prefetchChunks() {
    return prefetchChunks;
  }

  boolean hasPageSize() {
    return pageSize != null;
  }

  int pageSize() {
    return pageSize;
  }

  boolean hasPageToken() {
    return pageToken != null;
  }

  String pageToken() {
    return pageToken;
  }

  boolean hasFilter() {
    return filter != null;
  }

  String filter() {
    return filter;
  }

  static Options fromReadOptions(ReadOption... options) {
    Options readOptions = new Options();
    for (ReadOption option : options) {
      ((InternalOption) option).appendToOptions(readOptions);
    }
    return readOptions;
  }

  static Options fromQueryOptions(QueryOption... options) {
    Options readOptions = new Options();
    for (QueryOption option : options) {
      ((InternalOption) option).appendToOptions(readOptions);
    }
    return readOptions;
  }

  static Options fromListOptions(ListOption... options) {
    Options listOptions = new Options();
    for (ListOption option : options) {
      ((InternalOption) option).appendToOptions(listOptions);
    }
    return listOptions;
  }

  private abstract static class InternalOption {
    abstract void appendToOptions(Options options);
  }

  static class LimitOption extends InternalOption implements ReadOption {
    private final long limit;

    LimitOption(long limit) {
      this.limit = limit;
    }

    long limit() {
      return limit;
    }

    @Override
    void appendToOptions(Options options) {
      options.limit = limit;
    }
  }

  static class PageSizeOption extends InternalOption implements ListOption {
    private final int pageSize;

    PageSizeOption(int pageSize) {
      this.pageSize = pageSize;
    }

    int pageSize() {
      return pageSize;
    }

    @Override
    void appendToOptions(Options options) {
      options.pageSize = pageSize;
    }
  }

  static class PageTokenOption extends InternalOption implements ListOption {
    private final String pageToken;

    PageTokenOption(String pageToken) {
      this.pageToken = pageToken;
    }

    String pageToken() {
      return pageToken;
    }

    @Override
    void appendToOptions(Options options) {
      options.pageToken = pageToken;
    }
  }

  static class FilterOption extends InternalOption implements ListOption {
    private final String filter;

    FilterOption(String filter) {
      this.filter = filter;
    }

    @Override
    void appendToOptions(Options options) {
      options.filter = filter;
    }
  }
}
