/*
 * Copyright 2018 Google LLC
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
public final class DeprecationStatus implements ApiMessage {
  private final String deleted;
  private final String deprecated;
  private final String obsolete;
  private final String replacement;
  private final String state;

  private DeprecationStatus() {
    this.deleted = null;
    this.deprecated = null;
    this.obsolete = null;
    this.replacement = null;
    this.state = null;
  }

  private DeprecationStatus(
      String deleted, String deprecated, String obsolete, String replacement, String state) {
    this.deleted = deleted;
    this.deprecated = deprecated;
    this.obsolete = obsolete;
    this.replacement = replacement;
    this.state = state;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("deleted")) {
      return deleted;
    }
    if (fieldName.equals("deprecated")) {
      return deprecated;
    }
    if (fieldName.equals("obsolete")) {
      return obsolete;
    }
    if (fieldName.equals("replacement")) {
      return replacement;
    }
    if (fieldName.equals("state")) {
      return state;
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

  public String getDeleted() {
    return deleted;
  }

  public String getDeprecated() {
    return deprecated;
  }

  public String getObsolete() {
    return obsolete;
  }

  public String getReplacement() {
    return replacement;
  }

  public String getState() {
    return state;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DeprecationStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DeprecationStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DeprecationStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DeprecationStatus();
  }

  public static class Builder {
    private String deleted;
    private String deprecated;
    private String obsolete;
    private String replacement;
    private String state;

    Builder() {}

    public Builder mergeFrom(DeprecationStatus other) {
      if (other == DeprecationStatus.getDefaultInstance()) return this;
      if (other.getDeleted() != null) {
        this.deleted = other.deleted;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getObsolete() != null) {
        this.obsolete = other.obsolete;
      }
      if (other.getReplacement() != null) {
        this.replacement = other.replacement;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      return this;
    }

    Builder(DeprecationStatus source) {
      this.deleted = source.deleted;
      this.deprecated = source.deprecated;
      this.obsolete = source.obsolete;
      this.replacement = source.replacement;
      this.state = source.state;
    }

    public String getDeleted() {
      return deleted;
    }

    public Builder setDeleted(String deleted) {
      this.deleted = deleted;
      return this;
    }

    public String getDeprecated() {
      return deprecated;
    }

    public Builder setDeprecated(String deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    public String getObsolete() {
      return obsolete;
    }

    public Builder setObsolete(String obsolete) {
      this.obsolete = obsolete;
      return this;
    }

    public String getReplacement() {
      return replacement;
    }

    public Builder setReplacement(String replacement) {
      this.replacement = replacement;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public DeprecationStatus build() {

      return new DeprecationStatus(deleted, deprecated, obsolete, replacement, state);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDeleted(this.deleted);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setObsolete(this.obsolete);
      newBuilder.setReplacement(this.replacement);
      newBuilder.setState(this.state);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DeprecationStatus{"
        + "deleted="
        + deleted
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "obsolete="
        + obsolete
        + ", "
        + "replacement="
        + replacement
        + ", "
        + "state="
        + state
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeprecationStatus) {
      DeprecationStatus that = (DeprecationStatus) o;
      return Objects.equals(this.deleted, that.getDeleted())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.obsolete, that.getObsolete())
          && Objects.equals(this.replacement, that.getReplacement())
          && Objects.equals(this.state, that.getState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleted, deprecated, obsolete, replacement, state);
  }
}
