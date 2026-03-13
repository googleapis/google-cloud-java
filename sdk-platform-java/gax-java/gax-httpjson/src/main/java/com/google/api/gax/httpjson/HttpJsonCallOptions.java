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
package com.google.api.gax.httpjson;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeInstant;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenInstant;

import com.google.api.core.ObsoleteApi;
import com.google.auth.Credentials;
import com.google.auto.value.AutoValue;
import com.google.protobuf.TypeRegistry;
import javax.annotation.Nullable;

/** Options for an http-json call, including deadline and credentials. */
@AutoValue
public abstract class HttpJsonCallOptions {
  public static final HttpJsonCallOptions DEFAULT = newBuilder().build();

  /** This method is obsolete. Use {@link #getTimeoutDuration()} instead. */
  @Nullable
  @ObsoleteApi("Use getTimeoutDuration() instead")
  public final org.threeten.bp.Duration getTimeout() {
    return toThreetenDuration(getTimeoutDuration());
  }

  @Nullable
  public abstract java.time.Duration getTimeoutDuration();

  /** This method is obsolete. Use {@link #getDeadlineInstant()} instead. */
  @Nullable
  @ObsoleteApi("Use getDeadlineInstant() instead")
  public final org.threeten.bp.Instant getDeadline() {
    return toThreetenInstant(getDeadlineInstant());
  }

  @Nullable
  public abstract java.time.Instant getDeadlineInstant();

  @Nullable
  public abstract Credentials getCredentials();

  @Nullable
  public abstract TypeRegistry getTypeRegistry();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_HttpJsonCallOptions.Builder();
  }

  public HttpJsonCallOptions merge(HttpJsonCallOptions inputOptions) {
    if (inputOptions == null) {
      return this;
    }

    Builder builder = this.toBuilder();

    java.time.Instant newDeadline = inputOptions.getDeadlineInstant();
    if (newDeadline != null) {
      builder.setDeadlineInstant(newDeadline);
    }

    if (inputOptions.getTimeout() != null) {
      java.time.Duration newTimeout = inputOptions.getTimeoutDuration();
      if (newTimeout != null) {
        builder.setTimeoutDuration(newTimeout);
      }
    }

    Credentials newCredentials = inputOptions.getCredentials();
    if (newCredentials != null) {
      builder.setCredentials(newCredentials);
    }

    TypeRegistry newTypeRegistry = inputOptions.getTypeRegistry();
    if (newTypeRegistry != null) {
      builder.setTypeRegistry(newTypeRegistry);
    }

    return builder.build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    /** This method is obsolete. Use {@link #setTimeoutDuration(java.time.Duration)} instead. */
    @ObsoleteApi("Use setTimeoutDuration(java.time.Duration) instead")
    public final Builder setTimeout(org.threeten.bp.Duration value) {
      return setTimeoutDuration(toJavaTimeDuration(value));
    }

    public abstract Builder setTimeoutDuration(java.time.Duration value);

    /** This method is obsolete. Use {@link #setDeadlineInstant(java.time.Instant)} instead. */
    @ObsoleteApi("Use setDeadlineInstant(java.time.Instant) instead")
    public final Builder setDeadline(org.threeten.bp.Instant value) {
      return setDeadlineInstant(toJavaTimeInstant(value));
    }

    public abstract Builder setDeadlineInstant(java.time.Instant value);

    public abstract Builder setCredentials(Credentials value);

    public abstract Builder setTypeRegistry(TypeRegistry value);

    public abstract HttpJsonCallOptions build();
  }
}
