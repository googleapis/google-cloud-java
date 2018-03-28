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
public final class SerialPortOutput implements ApiMessage {
  private final String contents;
  private final String kind;
  private final String next;
  private final String selfLink;
  private final String start;

  private SerialPortOutput() {
    this.contents = null;
    this.kind = null;
    this.next = null;
    this.selfLink = null;
    this.start = null;
  }


  private SerialPortOutput(
      String contents,
      String kind,
      String next,
      String selfLink,
      String start
      ) {
    this.contents = contents;
    this.kind = kind;
    this.next = next;
    this.selfLink = selfLink;
    this.start = start;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("contents") && contents != null) {
      fieldMap.put("contents", Collections.singletonList(String.valueOf(contents)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("next") && next != null) {
      fieldMap.put("next", Collections.singletonList(String.valueOf(next)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("start") && start != null) {
      fieldMap.put("start", Collections.singletonList(String.valueOf(start)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("contents")) {
      return String.valueOf(contents);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("next")) {
      return String.valueOf(next);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("start")) {
      return String.valueOf(start);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getContents() {
    return contents;
  }

  public String getKind() {
    return kind;
  }

  public String getNext() {
    return next;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getStart() {
    return start;
  }


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(SerialPortOutput prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SerialPortOutput getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  private static final SerialPortOutput DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SerialPortOutput();
  }

  public static class Builder {
    private String contents;
    private String kind;
    private String next;
    private String selfLink;
    private String start;

    Builder() {}

    public Builder mergeFrom(SerialPortOutput other) {
      if (other == SerialPortOutput.getDefaultInstance()) return this;
      if (other.getContents() != null) {
        this.contents = other.contents;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getNext() != null) {
        this.next = other.next;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStart() != null) {
        this.start = other.start;
      }
      return this;
    }

    Builder(SerialPortOutput source) {
      this.contents = source.contents;
      this.kind = source.kind;
      this.next = source.next;
      this.selfLink = source.selfLink;
      this.start = source.start;
    }

    public String getContents() {
      return contents;
    }

    public Builder setContents(String contents) {
      this.contents = contents;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getNext() {
      return next;
    }

    public Builder setNext(String next) {
      this.next = next;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getStart() {
      return start;
    }

    public Builder setStart(String start) {
      this.start = start;
      return this;
    }


    public SerialPortOutput build() {




      return new SerialPortOutput(
        contents,
        kind,
        next,
        selfLink,
        start
      );
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setContents(this.contents);
      newBuilder.setKind(this.kind);
      newBuilder.setNext(this.next);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStart(this.start);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SerialPortOutput{"
        + "contents=" + contents + ", "
        + "kind=" + kind + ", "
        + "next=" + next + ", "
        + "selfLink=" + selfLink + ", "
        + "start=" + start
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SerialPortOutput) {
      SerialPortOutput that = (SerialPortOutput) o;
      return
          Objects.equals(this.contents, that.getContents()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.next, that.getNext()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.start, that.getStart())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      contents,
      kind,
      next,
      selfLink,
      start
    );
  }
}
