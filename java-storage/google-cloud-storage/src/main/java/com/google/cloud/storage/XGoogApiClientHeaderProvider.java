/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.api.gax.rpc.HeaderProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

final class XGoogApiClientHeaderProvider implements HeaderProvider {

  /** Separate entries with a space */
  private static final Collector<CharSequence, ?, String> COMBINER = Collectors.joining(" ");

  private final Map<String, String> headers;

  private XGoogApiClientHeaderProvider(Map<String, String> headers) {
    this.headers = headers;
  }

  @Override
  public Map<String, String> getHeaders() {
    return headers;
  }

  static XGoogApiClientHeaderProvider of(
      HeaderProvider baseValue, ImmutableList<String> additionalEntries) {
    if (additionalEntries.isEmpty()) {
      return new XGoogApiClientHeaderProvider(baseValue.getHeaders());
    } else {
      ImmutableMap<String, String> right =
          ImmutableMap.of("x-goog-api-client", additionalEntries.stream().collect(COMBINER));
      ImmutableMap<String, String> union = union(baseValue.getHeaders(), right);
      return new XGoogApiClientHeaderProvider(union);
    }
  }

  /**
   * Union two maps, ignoring case of their keys.
   *
   * <p>Any key present in both {@code left} and {@code right} will be combined to produce a new
   * single value.
   */
  @VisibleForTesting
  static ImmutableMap<String, String> union(Map<String, String> left, Map<String, String> right) {
    if (left.equals(right)) {
      return ImmutableMap.copyOf(left);
    }
    Map<String, String> l = lowerKeys(left);
    Map<String, String> r = lowerKeys(right);
    if (l.equals(r)) {
      return ImmutableMap.copyOf(l);
    }

    Map<String, String> tmp = new HashMap<>();

    MapDifference<String, String> diff = Maps.difference(l, r);

    tmp.putAll(diff.entriesOnlyOnLeft());
    tmp.putAll(diff.entriesOnlyOnRight());
    tmp.putAll(diff.entriesInCommon());

    for (Entry<String, ValueDifference<String>> e : diff.entriesDiffering().entrySet()) {
      String k = e.getKey();
      ValueDifference<String> v = e.getValue();

      tmp.put(k, ImmutableList.of(v.leftValue(), v.rightValue()).stream().collect(COMBINER));
    }

    return ImmutableMap.copyOf(tmp);
  }

  private static Map<String, String> lowerKeys(Map<String, String> orig) {
    Map<String, String> tmp = new HashMap<>();
    for (Entry<String, String> e : orig.entrySet()) {
      String k = e.getKey();
      String v = e.getValue();
      tmp.put(Utils.headerNameToLowerCase(k), v);
    }
    return tmp;
  }
}
