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
package com.google.api.gax.grpc;

import com.google.api.gax.rpc.internal.Headers;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import java.util.Collections;
import java.util.Map;

/** A utility class that provides helper functions to work with custom call options. */
class CallOptionsUtil {
  // this is a call option name, not a header name, it is not transferred over the wire
  private static final CallOptions.Key<Map<Key<String>, String>> DYNAMIC_HEADERS_CALL_OPTION_KEY =
      CallOptions.Key.createWithDefault(
          "gax_dynamic_headers", Collections.<Key<String>, String>emptyMap());
  // this is the header name, it is transferred over the wire
  static Metadata.Key<String> REQUEST_PARAMS_HEADER_KEY =
      Metadata.Key.of(Headers.DYNAMIC_ROUTING_HEADER_KEY, Metadata.ASCII_STRING_MARSHALLER);
  private static final CallOptions.Key<ResponseMetadataHandler> METADATA_HANDLER_CALL_OPTION_KEY =
      CallOptions.Key.createWithDefault("gax_metadata_handler", null);

  private CallOptionsUtil() {}

  static CallOptions putRequestParamsDynamicHeaderOption(
      CallOptions callOptions, String requestParams) {
    if (callOptions == null || requestParams.isEmpty()) {
      return callOptions;
    }

    Map<Key<String>, String> dynamicHeadersOption =
        callOptions.getOption(DYNAMIC_HEADERS_CALL_OPTION_KEY);

    // This will fail, if REQUEST_PARAMS_HEADER_KEY is already there
    dynamicHeadersOption =
        ImmutableMap.<Key<String>, String>builder()
            .putAll(dynamicHeadersOption)
            .put(REQUEST_PARAMS_HEADER_KEY, requestParams)
            .build();

    return callOptions.withOption(DYNAMIC_HEADERS_CALL_OPTION_KEY, dynamicHeadersOption);
  }

  static Map<Key<String>, String> getDynamicHeadersOption(CallOptions callOptions) {
    return callOptions.getOption(DYNAMIC_HEADERS_CALL_OPTION_KEY);
  }

  static CallOptions putMetadataHandlerOption(
      CallOptions callOptions, ResponseMetadataHandler handler) {
    Preconditions.checkNotNull(callOptions);
    Preconditions.checkNotNull(handler);
    return callOptions.withOption(METADATA_HANDLER_CALL_OPTION_KEY, handler);
  }

  public static ResponseMetadataHandler getMetadataHandlerOption(CallOptions callOptions) {
    return callOptions.getOption(METADATA_HANDLER_CALL_OPTION_KEY);
  }
}
