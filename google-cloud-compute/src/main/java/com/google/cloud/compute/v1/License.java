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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class License implements ApiMessage {
  private final Boolean chargesUseFee;
  private final String kind;
  private final String name;
  private final String selfLink;

  private License() {
    this.chargesUseFee = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
  }


  private License(
      Boolean chargesUseFee,
      String kind,
      String name,
      String selfLink
      ) {
    this.chargesUseFee = chargesUseFee;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("chargesUseFee") && chargesUseFee != null) {
      fieldMap.put("chargesUseFee", Collections.singletonList(String.valueOf(chargesUseFee)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("chargesUseFee")) {
      return String.valueOf(chargesUseFee);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public Boolean getChargesUseFee() {
    return chargesUseFee;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(License prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static License getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final License DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new License();
  }

  public static class Builder {
    private Boolean chargesUseFee;
    private String kind;
    private String name;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(License other) {
      if (other == License.getDefaultInstance()) return this;
      if (other.getChargesUseFee() != null) {
        this.chargesUseFee = other.chargesUseFee;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(License source) {
      this.chargesUseFee = source.chargesUseFee;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
    }

    public Boolean getChargesUseFee() {
      return chargesUseFee;
    }

    public Builder setChargesUseFee(Boolean chargesUseFee) {
      this.chargesUseFee = chargesUseFee;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }


    public License build() {



      return new License(
        chargesUseFee,
        kind,
        name,
        selfLink
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setChargesUseFee(this.chargesUseFee);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "License{"
        + "chargesUseFee=" + chargesUseFee + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "selfLink=" + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof License) {
      License that = (License) o;
      return
          Objects.equals(this.chargesUseFee, that.getChargesUseFee()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.selfLink, that.getSelfLink())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      chargesUseFee,
      kind,
      name,
      selfLink
    );
  }
}
