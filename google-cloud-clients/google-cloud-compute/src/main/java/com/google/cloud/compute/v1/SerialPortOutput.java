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
/** An instance's serial console output. */
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
      String contents, String kind, String next, String selfLink, String start) {
    this.contents = contents;
    this.kind = kind;
    this.next = next;
    this.selfLink = selfLink;
    this.start = start;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("contents".equals(fieldName)) {
      return contents;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("next".equals(fieldName)) {
      return next;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("start".equals(fieldName)) {
      return start;
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

  /** [Output Only] The contents of the console output. */
  public String getContents() {
    return contents;
  }

  /** [Output Only] Type of the resource. Always compute#serialPortOutput for serial port output. */
  public String getKind() {
    return kind;
  }

  /**
   * [Output Only] The position of the next byte of content from the serial console output. Use this
   * value in the next request as the start parameter.
   */
  public String getNext() {
    return next;
  }

  /** [Output Only] Server-defined URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * The starting byte position of the output that was returned. This should match the start
   * parameter sent with the request. If the serial console output exceeds the size of the buffer,
   * older output will be overwritten by newer content and the start values will be mismatched.
   */
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
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
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

    /** [Output Only] The contents of the console output. */
    public String getContents() {
      return contents;
    }

    /** [Output Only] The contents of the console output. */
    public Builder setContents(String contents) {
      this.contents = contents;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#serialPortOutput for serial port output.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#serialPortOutput for serial port output.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * [Output Only] The position of the next byte of content from the serial console output. Use
     * this value in the next request as the start parameter.
     */
    public String getNext() {
      return next;
    }

    /**
     * [Output Only] The position of the next byte of content from the serial console output. Use
     * this value in the next request as the start parameter.
     */
    public Builder setNext(String next) {
      this.next = next;
      return this;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * The starting byte position of the output that was returned. This should match the start
     * parameter sent with the request. If the serial console output exceeds the size of the buffer,
     * older output will be overwritten by newer content and the start values will be mismatched.
     */
    public String getStart() {
      return start;
    }

    /**
     * The starting byte position of the output that was returned. This should match the start
     * parameter sent with the request. If the serial console output exceeds the size of the buffer,
     * older output will be overwritten by newer content and the start values will be mismatched.
     */
    public Builder setStart(String start) {
      this.start = start;
      return this;
    }

    public SerialPortOutput build() {

      return new SerialPortOutput(contents, kind, next, selfLink, start);
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
        + "contents="
        + contents
        + ", "
        + "kind="
        + kind
        + ", "
        + "next="
        + next
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "start="
        + start
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SerialPortOutput) {
      SerialPortOutput that = (SerialPortOutput) o;
      return Objects.equals(this.contents, that.getContents())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.next, that.getNext())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.start, that.getStart());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(contents, kind, next, selfLink, start);
  }
}
