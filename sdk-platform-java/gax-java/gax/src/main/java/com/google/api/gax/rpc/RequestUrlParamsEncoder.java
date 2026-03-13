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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.escape.PercentEscaper;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import java.util.Map;

/**
 * The request params encoder, which encodes URL-encoded parameters in one URL parameters string.
 *
 * @param <RequestT> request message type
 */
@InternalApi("For use by transport-specific implementations")
public class RequestUrlParamsEncoder<RequestT> implements RequestParamsEncoder<RequestT> {
  // Per RFC 3986 Section 2.3, these are the four unreserved characters that don't need to be
  // encoded
  private static final PercentEscaper PERCENT_ESCAPER = new PercentEscaper("._-~");
  private final RequestParamsExtractor<RequestT> paramsExtractor;

  /**
   * Creates the encoder.
   *
   * @param paramsExtractor parameters extractor which returns already URL-encoded key-value pairs
   */
  public RequestUrlParamsEncoder(RequestParamsExtractor<RequestT> paramsExtractor) {
    this.paramsExtractor = checkNotNull(paramsExtractor);
  }

  /**
   * Encodes the {@code request} in a form of a URL parameters string, for example {@code
   * "param1=value+1&param2=value2%26"}. This method may optionally validate that the name-value
   * paris are URL-encoded. It will URL encode the key and values if there are any non-allowed
   * characters. It will then concatenate the valid individual name-value pairs in a valid URL
   * parameters string.
   *
   * <p>Note: This will url-encode the key and values during concatenation. Double url-encoding may
   * occur if the input has values that are already url-encoded.
   *
   * @param request request message
   * @throws IllegalArgumentException if is not
   */
  @Override
  public String encode(RequestT request) {
    Map<String, String> params = paramsExtractor.extract(request);
    if (params.isEmpty()) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      if (sb.length() > 0) {
        sb.append("&");
      }
      // RequestParamsExtractor checks that the values are non-null and non-empty
      String encodedKey = percentEncodeString(entry.getKey());
      String encodedValue = percentEncodeString(entry.getValue());
      sb.append(encodedKey).append("=").append(encodedValue);
    }

    return sb.toString();
  }

  // Percent encode the value passed in.
  @VisibleForTesting
  String percentEncodeString(String value) {
    return PERCENT_ESCAPER.escape(value);
  }
}
