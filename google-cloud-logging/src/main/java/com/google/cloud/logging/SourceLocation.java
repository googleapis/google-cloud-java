/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import com.google.common.base.MoreObjects;
import com.google.logging.v2.LogEntrySourceLocation;

import java.io.Serializable;
import java.util.Objects;

public final class SourceLocation implements Serializable {

  private static final long serialVersionUID = 8502955858162387374L;

  String file;
  Long line;
  String function;

  public static final class Builder {

    private String file;
    private Long line;
    private String function;

    Builder() {
    }

    Builder(SourceLocation sourceLocation) {
      this.file = sourceLocation.file;
      this.line = sourceLocation.line;
      this.function = sourceLocation.function;
    }

    public Builder setFile(String file) {
      this.file = file;
      return this;
    }

    public Builder setLine(Long line) {
      this.line = line;
      return this;
    }

    public Builder setFunction(String function) {
      this.function = function;
      return this;
    }

    public SourceLocation build() {
      return new SourceLocation(this);
    }
  }

  SourceLocation(Builder builder) {
    this.file = builder.file;
    this.line = builder.line;
    this.function = builder.function;
  }

  public String getFile() {
    return file;
  }

  public Long getLine() {
    return line;
  }

  public String getFunction() {
    return function;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SourceLocation)) {
      return false;
    }
    SourceLocation other = (SourceLocation) obj;
    return Objects.equals(file, other.file)
        && Objects.equals(line, other.line)
        && Objects.equals(function, other.function);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, line, function);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("file", file)
        .add("line", line)
        .add("function", function)
        .toString();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  LogEntrySourceLocation toPb() {
    LogEntrySourceLocation.Builder builder = LogEntrySourceLocation.newBuilder();
    builder.setFile(file);
    builder.setLine(line);
    builder.setFunction(function);
    return builder.build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static SourceLocation fromPb(LogEntrySourceLocation sourceLocationPb) {
    return newBuilder()
        .setFile(sourceLocationPb.getFile())
        .setLine(sourceLocationPb.getLine())
        .setFunction(sourceLocationPb.getFunction())
        .build();
  }
}
