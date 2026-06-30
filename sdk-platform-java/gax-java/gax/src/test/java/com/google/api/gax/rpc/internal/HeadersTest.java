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

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class HeadersTest {

  @Test
  void testMergeHeaders() {
    Map<String, List<String>> headers1 = createHeaders("key1", "value1", "key1", "value2");
    Map<String, List<String>> headers2 = createHeaders("key1", "value2", "key2", "value2");
    Map<String, List<String>> mergedHeaders = Headers.mergeHeaders(headers1, headers2);
    Map<String, List<String>> expectedHeaders =
        createHeaders("key1", "value1", "key1", "value2", "key1", "value2", "key2", "value2");
    assertThat(mergedHeaders).containsExactlyEntriesIn(expectedHeaders);
  }

  @Test
  void testMergeHeadersEmpty() {
    Map<String, List<String>> headers1 = createHeaders();
    Map<String, List<String>> headers2 = createHeaders("key1", "value1", "key2", "value2");
    Map<String, List<String>> mergedHeaders = Headers.mergeHeaders(headers1, headers2);
    Map<String, List<String>> expectedHeaders = createHeaders("key1", "value1", "key2", "value2");
    assertThat(mergedHeaders).containsExactlyEntriesIn(expectedHeaders);
  }

  private static Map<String, List<String>> createHeaders(String... keyValues) {
    Map<String, List<String>> headers = new HashMap<>();
    for (int i = 0; i < keyValues.length; i += 2) {
      String key = keyValues[i];
      String value = keyValues[i + 1];
      if (!headers.containsKey(key)) {
        headers.put(key, new ArrayList<String>());
      }
      headers.get(key).add(value);
    }
    return headers;
  }
}
