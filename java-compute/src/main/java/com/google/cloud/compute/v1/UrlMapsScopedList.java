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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class UrlMapsScopedList implements ApiMessage {
  private final List<UrlMap> urlMaps;
  private final Warning warning;

  private UrlMapsScopedList() {
    this.urlMaps = null;
    this.warning = null;
  }

  private UrlMapsScopedList(List<UrlMap> urlMaps, Warning warning) {
    this.urlMaps = urlMaps;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("urlMaps".equals(fieldName)) {
      return urlMaps;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** A list of UrlMaps contained in this scope. */
  public List<UrlMap> getUrlMapsList() {
    return urlMaps;
  }

  /** Informational warning which replaces the list of backend services when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapsScopedList();
  }

  public static class Builder {
    private List<UrlMap> urlMaps;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(UrlMapsScopedList other) {
      if (other == UrlMapsScopedList.getDefaultInstance()) return this;
      if (other.getUrlMapsList() != null) {
        this.urlMaps = other.urlMaps;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(UrlMapsScopedList source) {
      this.urlMaps = source.urlMaps;
      this.warning = source.warning;
    }

    /** A list of UrlMaps contained in this scope. */
    public List<UrlMap> getUrlMapsList() {
      return urlMaps;
    }

    /** A list of UrlMaps contained in this scope. */
    public Builder addAllUrlMaps(List<UrlMap> urlMaps) {
      if (this.urlMaps == null) {
        this.urlMaps = new LinkedList<>();
      }
      this.urlMaps.addAll(urlMaps);
      return this;
    }

    /** A list of UrlMaps contained in this scope. */
    public Builder addUrlMaps(UrlMap urlMaps) {
      if (this.urlMaps == null) {
        this.urlMaps = new LinkedList<>();
      }
      this.urlMaps.add(urlMaps);
      return this;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public UrlMapsScopedList build() {

      return new UrlMapsScopedList(urlMaps, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllUrlMaps(this.urlMaps);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapsScopedList{" + "urlMaps=" + urlMaps + ", " + "warning=" + warning + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapsScopedList) {
      UrlMapsScopedList that = (UrlMapsScopedList) o;
      return Objects.equals(this.urlMaps, that.getUrlMapsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(urlMaps, warning);
  }
}
