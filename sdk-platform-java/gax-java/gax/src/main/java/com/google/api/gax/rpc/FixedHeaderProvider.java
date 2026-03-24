/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/** An instance of HeaderProvider that always provides the same headers. */
@AutoValue
public abstract class FixedHeaderProvider implements HeaderProvider, Serializable {

  private static final long serialVersionUID = -4881534091594970538L;

  @Override
  @Nullable
  public abstract Map<String, String> getHeaders();

  /** Creates a FixedHeaderProvider. */
  public static FixedHeaderProvider create(Map<String, String> headers) {
    checkKeys(headers.keySet());
    return new AutoValue_FixedHeaderProvider(ImmutableMap.copyOf(headers));
  }

  public static FixedHeaderProvider create(String... keyValuePairs) {
    if (keyValuePairs.length % 2 != 0) {
      throw new IllegalArgumentException(
          "The keyValuePairs var-arg parameter must contain an even number of elements");
    }
    ImmutableMap.Builder<String, String> headersBuilder = ImmutableMap.builder();
    for (int i = 0; i < keyValuePairs.length; i += 2) {
      headersBuilder.put(keyValuePairs[i], keyValuePairs[i + 1]);
    }
    Map<String, String> headers = headersBuilder.build();

    checkKeys(headers.keySet());
    return new AutoValue_FixedHeaderProvider(headers);
  }

  private static void checkKeys(Collection<String> keys) {
    Set<String> caseInsensitiveKeys = new HashSet<>();
    for (String key : keys) {
      if (!caseInsensitiveKeys.add(key.toLowerCase())) {
        throw new IllegalArgumentException(
            "The header key '" + key + "' is not case insensitively unique");
      }
    }
  }
}
