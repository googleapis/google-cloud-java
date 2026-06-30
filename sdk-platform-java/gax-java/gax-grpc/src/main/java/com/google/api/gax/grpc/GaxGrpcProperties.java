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

import com.google.api.core.InternalApi;
import com.google.api.gax.core.GaxProperties;
import io.grpc.Channel;
import java.util.regex.Pattern;

/** Provides properties of the GAX-GRPC library. */
@InternalApi
public class GaxGrpcProperties {
  private static final String GAX_GRPC_VERSION =
      GaxProperties.getLibraryVersion(GaxGrpcProperties.class, "version.gax_grpc");
  private static final String GRPC_VERSION =
      GaxProperties.getLibraryVersion(Channel.class, "version.io_grpc");
  private static final Pattern DEFAULT_API_CLIENT_HEADER_PATTERN =
      Pattern.compile("gl-java/.+ gapic/.* gax/.+ grpc/.+");

  private GaxGrpcProperties() {}

  /** Returns the current version of gRPC */
  public static String getGrpcVersion() {
    return GRPC_VERSION;
  }

  public static String getGrpcTokenName() {
    return "grpc";
  }

  public static String getGaxGrpcVersion() {
    return GAX_GRPC_VERSION;
  }

  /** Returns default api client header pattern (to facilitate testing) */
  public static Pattern getDefaultApiClientHeaderPattern() {
    return DEFAULT_API_CLIENT_HEADER_PATTERN;
  }
}
