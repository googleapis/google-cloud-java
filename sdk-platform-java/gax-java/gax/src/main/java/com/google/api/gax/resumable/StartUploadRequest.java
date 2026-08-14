/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.resumable;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** Request parameters for initiating a resumable upload session. */
@NullMarked
@InternalApi
@AutoValue
public abstract class StartUploadRequest {

  /** Returns the URL path to append to the service endpoint. */
  public abstract String getPath();

  /** Returns the optional initial JSON request payload. */
  @Nullable
  public abstract String getJsonPayload();

  /** Returns the query parameters for the initiation request. */
  public abstract Map<String, List<String>> getQueryParams();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_StartUploadRequest.Builder().setQueryParams(Collections.emptyMap());
  }

  /**
   * Convenience factory for creating a {@link StartUploadRequest} with only a target path.
   *
   * @param path the resource upload path
   * @return a new {@link StartUploadRequest} instance
   */
  public static StartUploadRequest create(String path) {
    return newBuilder().setPath(path).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setPath(String path);

    public abstract Builder setJsonPayload(@Nullable String jsonPayload);

    public abstract Builder setQueryParams(Map<String, List<String>> queryParams);

    abstract @Nullable Map<String, List<String>> getQueryParams();

    abstract @Nullable String getPath();

    abstract StartUploadRequest autoBuild();

    public StartUploadRequest build() {
      if (getPath() != null && getPath().startsWith("/")) {
        setPath(getPath().substring(1));
      }

      Map<String, List<String>> params = getQueryParams();
      if (params != null && !params.isEmpty()) {
        ImmutableMap.Builder<String, List<String>> mapBuilder = ImmutableMap.builder();
        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
          mapBuilder.put(entry.getKey(), ImmutableList.copyOf(entry.getValue()));
        }
        setQueryParams(mapBuilder.build());
      } else {
        setQueryParams(Collections.emptyMap());
      }

      return autoBuild();
    }
  }
}
