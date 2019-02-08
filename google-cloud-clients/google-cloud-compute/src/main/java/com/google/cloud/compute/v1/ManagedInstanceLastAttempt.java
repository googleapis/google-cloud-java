/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ManagedInstanceLastAttempt implements ApiMessage {
  private final Errors errors;

  private ManagedInstanceLastAttempt() {
    this.errors = null;
  }

  private ManagedInstanceLastAttempt(Errors errors) {
    this.errors = errors;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("errors".equals(fieldName)) {
      return errors;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] Encountered errors during the last attempt to create or delete the instance. */
  public Errors getErrors() {
    return errors;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ManagedInstanceLastAttempt prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ManagedInstanceLastAttempt getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ManagedInstanceLastAttempt DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ManagedInstanceLastAttempt();
  }

  public static class Builder {
    private Errors errors;

    Builder() {}

    public Builder mergeFrom(ManagedInstanceLastAttempt other) {
      if (other == ManagedInstanceLastAttempt.getDefaultInstance()) return this;
      if (other.getErrors() != null) {
        this.errors = other.errors;
      }
      return this;
    }

    Builder(ManagedInstanceLastAttempt source) {
      this.errors = source.errors;
    }

    /**
     * [Output Only] Encountered errors during the last attempt to create or delete the instance.
     */
    public Errors getErrors() {
      return errors;
    }

    /**
     * [Output Only] Encountered errors during the last attempt to create or delete the instance.
     */
    public Builder setErrors(Errors errors) {
      this.errors = errors;
      return this;
    }

    public ManagedInstanceLastAttempt build() {
      return new ManagedInstanceLastAttempt(errors);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setErrors(this.errors);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ManagedInstanceLastAttempt{" + "errors=" + errors + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ManagedInstanceLastAttempt) {
      ManagedInstanceLastAttempt that = (ManagedInstanceLastAttempt) o;
      return Objects.equals(this.errors, that.getErrors());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }
}
