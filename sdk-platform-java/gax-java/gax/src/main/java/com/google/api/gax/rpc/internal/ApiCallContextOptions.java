/*
 * Copyright 2021 Google LLC
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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiCallContext.Key;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * ApiCallContextOptions encapsulates additional call options to pass in a {@link ApiCallContext}
 */
@InternalApi
public final class ApiCallContextOptions {

  private final ImmutableMap<Key, Object> options;
  private static final ApiCallContextOptions DEFAULT_OPTIONS =
      new ApiCallContextOptions(ImmutableMap.<Key, Object>of());

  private ApiCallContextOptions(ImmutableMap<Key, Object> options) {
    this.options = Preconditions.checkNotNull(options);
  }

  public static ApiCallContextOptions getDefaultOptions() {
    return DEFAULT_OPTIONS;
  }

  /** Add an option. Any existing value of the key is overwritten. */
  public <T> ApiCallContextOptions withOption(Key<T> key, T value) {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    ImmutableMap.Builder<Key, Object> builder = ImmutableMap.builder();
    if (!options.containsKey(key)) {
      builder.putAll(options).put(key, value);
    } else {
      builder.put(key, value);
      for (Key oldKey : options.keySet()) {
        if (!oldKey.equals(key)) {
          builder.put(oldKey, options.get(oldKey));
        }
      }
    }
    return new ApiCallContextOptions(builder.build());
  }

  /** Get an option. */
  public <T> T getOption(Key<T> key) {
    Preconditions.checkNotNull(key);
    return (T) options.get(key);
  }

  /** Merge new options into existing ones. Any existing values of the keys are overwritten. */
  public ApiCallContextOptions merge(ApiCallContextOptions newOptions) {
    Preconditions.checkNotNull(newOptions);
    ImmutableMap.Builder<Key, Object> builder =
        ImmutableMap.<Key, Object>builder().putAll(newOptions.options);
    for (Key key : options.keySet()) {
      if (!newOptions.options.containsKey(key)) {
        builder.put(key, options.get(key));
      }
    }
    return new ApiCallContextOptions(builder.build());
  }
}
