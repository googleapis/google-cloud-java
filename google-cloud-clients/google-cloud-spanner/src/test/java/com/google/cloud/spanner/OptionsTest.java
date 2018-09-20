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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link Options}. */
@RunWith(JUnit4.class)
public class OptionsTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void negativeLimitsNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.limit(-1);
  }

  @Test
  public void zeroLimitNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.limit(0);
  }

  @Test
  public void negativePrefetchChunksNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.prefetchChunks(-1);
  }

  @Test
  public void zeroPrefetchChunksNotAllowed() {
    expectedException.expect(IllegalArgumentException.class);
    Options.prefetchChunks(0);
  }

  @Test
  public void allOptionsPresent() {
    Options options = Options.fromReadOptions(Options.limit(10), Options.prefetchChunks(1));
    assertThat(options.hasLimit()).isTrue();
    assertThat(options.limit()).isEqualTo(10);
    assertThat(options.hasPrefetchChunks()).isTrue();
    assertThat(options.prefetchChunks()).isEqualTo(1);
  }

  @Test
  public void allOptionsAbsent() {
    Options options = Options.fromReadOptions();
    assertThat(options.hasLimit()).isFalse();
    assertThat(options.hasPrefetchChunks()).isFalse();
    assertThat(options.hasFilter()).isFalse();
    assertThat(options.hasPageToken()).isFalse();
    assertThat(options.toString()).isEqualTo("");
    assertThat(options.equals(options)).isTrue();
    assertThat(options.equals(null)).isFalse();
    assertThat(options.equals(this)).isFalse();

    assertThat(options.hashCode()).isEqualTo(31);
  }

  @Test
  public void listOptTest() {
    int pageSize = 3;
    String pageToken = "ptok";
    String filter = "env";
    Options opts = Options
        .fromListOptions(
            Options.pageSize(pageSize), Options.pageToken(pageToken), Options.filter(filter));

    assertThat(opts.toString()).isEqualTo("pageSize: " + Integer.toString(pageSize)
        + " pageToken: " + pageToken + " filter: " + filter + " ");

    assertThat(opts.hasPageSize()).isTrue();
    assertThat(opts.hasPageToken()).isTrue();
    assertThat(opts.hasFilter()).isTrue();

    assertThat(opts.pageSize()).isEqualTo(pageSize);
    assertThat(opts.pageToken()).isEqualTo(pageToken);
    assertThat(opts.filter()).isEqualTo(filter);
    assertThat(opts.hashCode()).isEqualTo(108027089);
  }

  @Test
  public void listEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromListOptions();
    o2 = Options.fromListOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromListOptions(Options.pageSize(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromListOptions(Options.pageSize(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.pageSize(2));
    assertThat(o2.equals(o3)).isFalse();

    o2 = Options.fromListOptions(Options.pageToken("t1"));
    assertThat(o1.equals(o2)).isFalse();

    o3 = Options.fromListOptions(Options.pageToken("t1"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.pageToken("t2"));
    assertThat(o2.equals(o3)).isFalse();

    o2 = Options.fromListOptions(Options.filter("f1"));
    assertThat(o1.equals(o2)).isFalse();

    o3 = Options.fromListOptions(Options.filter("f1"));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromListOptions(Options.filter("f2"));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void readOptTest() {
    int limit = 3;
    Options opts = Options.fromReadOptions(Options.limit(limit));

    assertThat(opts.toString()).isEqualTo("limit: " + Integer.toString(limit) + " ");
    assertThat(opts.hashCode()).isEqualTo(964);
  }

  @Test
  public void readEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromReadOptions();
    o2 = Options.fromReadOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromReadOptions(Options.limit(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromReadOptions(Options.limit(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromReadOptions(Options.limit(2));
    assertThat(o2.equals(o3)).isFalse();
  }

  @Test
  public void queryOptTest() {
    int chunks = 3;
    Options opts = Options.fromQueryOptions(Options.prefetchChunks(chunks));
    assertThat(opts.toString())
        .isEqualTo("prefetchChunks: " + Integer.toString(chunks) + " ");
    assertThat(opts.prefetchChunks()).isEqualTo(chunks);
    assertThat(opts.hashCode()).isEqualTo(964);
  }

  @Test
  public void queryEquality() {
    Options o1;
    Options o2;
    Options o3;

    o1 = Options.fromQueryOptions();
    o2 = Options.fromQueryOptions();
    assertThat(o1.equals(o2)).isTrue();

    o2 = Options.fromReadOptions(Options.prefetchChunks(1));
    assertThat(o1.equals(o2)).isFalse();
    assertThat(o2.equals(o1)).isFalse();

    o3 = Options.fromReadOptions(Options.prefetchChunks(1));
    assertThat(o2.equals(o3)).isTrue();

    o3 = Options.fromReadOptions(Options.prefetchChunks(2));
    assertThat(o2.equals(o3)).isFalse();
  }
}
