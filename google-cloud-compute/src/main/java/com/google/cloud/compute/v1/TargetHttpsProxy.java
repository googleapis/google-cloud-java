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
public final class TargetHttpsProxy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;
  private final List<String> sslCertificates;
  private final String urlMap;

  private TargetHttpsProxy() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
    this.sslCertificates = null;
    this.urlMap = null;
  }


  private TargetHttpsProxy(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String selfLink,
      List<String> sslCertificates,
      String urlMap
      ) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
    this.sslCertificates = sslCertificates;
    this.urlMap = urlMap;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
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
    if (fieldNames.contains("sslCertificates") && sslCertificates != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : sslCertificates) {
        stringList.add(item.toString());
      }
      fieldMap.put("sslCertificates", stringList.build());
    }
    if (fieldNames.contains("urlMap") && urlMap != null) {
      fieldMap.put("urlMap", Collections.singletonList(String.valueOf(urlMap)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
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
    if (fieldName.equals("sslCertificates")) {
      return String.valueOf(sslCertificates);
    }
    if (fieldName.equals("urlMap")) {
      return String.valueOf(urlMap);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
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

  public List<String> getSslCertificatesList() {
    return sslCertificates;
  }

  public String getUrlMap() {
    return urlMap;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(TargetHttpsProxy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpsProxy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final TargetHttpsProxy DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new TargetHttpsProxy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String selfLink;
    private List<String> sslCertificates;
    private String urlMap;

    Builder() {}

    public Builder mergeFrom(TargetHttpsProxy other) {
      if (other == TargetHttpsProxy.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
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
      if (other.getSslCertificatesList() != null) {
        this.sslCertificates = other.sslCertificates;
      }
      if (other.getUrlMap() != null) {
        this.urlMap = other.urlMap;
      }
      return this;
    }

    Builder(TargetHttpsProxy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.sslCertificates = source.sslCertificates;
      this.urlMap = source.urlMap;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
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

    public List<String> getSslCertificatesList() {
      return sslCertificates;
    }

    public Builder addAllSslCertificates(List<String> sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new ArrayList<>(sslCertificates.size());
      }
      this.sslCertificates.addAll(sslCertificates);
      return this;
    }

    public Builder addSslCertificates(String sslCertificates) {
      this.sslCertificates.add(sslCertificates);
      return this;
    }

    public String getUrlMap() {
      return urlMap;
    }

    public Builder setUrlMap(String urlMap) {
      this.urlMap = urlMap;
      return this;
    }


    public TargetHttpsProxy build() {







      return new TargetHttpsProxy(
        creationTimestamp,
        description,
        id,
        kind,
        name,
        selfLink,
        sslCertificates,
        urlMap
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSslCertificates(this.sslCertificates);
      newBuilder.setUrlMap(this.urlMap);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpsProxy{"
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "id=" + id + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "selfLink=" + selfLink + ", "
        + "sslCertificates=" + sslCertificates + ", "
        + "urlMap=" + urlMap
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetHttpsProxy) {
      TargetHttpsProxy that = (TargetHttpsProxy) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.sslCertificates, that.getSslCertificatesList()) &&
          Objects.equals(this.urlMap, that.getUrlMap())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      creationTimestamp,
      description,
      id,
      kind,
      name,
      selfLink,
      sslCertificates,
      urlMap
    );
  }
}
