/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.rpc.internal;

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;

@InternalApi
public class Headers {
  public static final String DYNAMIC_ROUTING_HEADER_KEY = "x-goog-request-params";

  public static ImmutableMap<String, List<String>> mergeHeaders(
      Map<String, List<String>> oldHeaders, Map<String, List<String>> newHeaders) {
    ImmutableMap.Builder<String, List<String>> headersBuilder = ImmutableMap.builder();
    for (Map.Entry<String, List<String>> entry : oldHeaders.entrySet()) {
      String key = entry.getKey();
      List<String> oldValue = entry.getValue();
      List<String> newValue = newHeaders.get(key);
      ImmutableList.Builder<String> mergedValueBuilder = ImmutableList.builder();
      mergedValueBuilder.addAll(oldValue);
      if (newValue != null) {
        mergedValueBuilder.addAll(newValue);
      }
      headersBuilder.put(key, mergedValueBuilder.build());
    }
    for (Map.Entry<String, List<String>> entry : newHeaders.entrySet()) {
      String key = entry.getKey();
      if (!oldHeaders.containsKey(key)) {
        headersBuilder.put(key, ImmutableList.copyOf(entry.getValue()));
      }
    }
    return headersBuilder.build();
  }
}
