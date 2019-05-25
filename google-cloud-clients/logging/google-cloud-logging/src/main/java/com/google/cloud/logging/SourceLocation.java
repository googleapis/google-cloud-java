/*
 * Copyright 2016 Google LLC
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

/** Additional information about the source code location that produced the log entry. */
public final class SourceLocation implements Serializable {

  private static final long serialVersionUID = 8502955858162387374L;

  private final String file;
  private final Long line;
  private final String function;

  public static Builder newBuilder() {
    return new Builder();
  }

  /** A builder for {@code SourceLocation} objects. */
  public static final class Builder {

    private String file;
    private Long line;
    private String function;

    Builder() {}

    Builder(SourceLocation sourceLocation) {
      this.file = sourceLocation.file;
      this.line = sourceLocation.line;
      this.function = sourceLocation.function;
    }

    /**
     * Sets the source file name. Depending on the runtime environment, this might be a simple name
     * or a fully-qualified name.
     */
    public Builder setFile(String file) {
      this.file = file;
      return this;
    }

    /** Sets the line within the source file. 1-based; 0 indicates no line number available. */
    public Builder setLine(Long line) {
      this.line = line;
      return this;
    }

    /**
     * Sets the human-readable name of the function or method being invoked, with optional context
     * such as the class or package name. This information may be used in contexts such as the logs
     * viewer, where a file and line number are less meaningful. The format can vary by language.
     */
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

  /**
   * Returns the source file name. Depending on the runtime environment, this might be a simple name
   * or a fully-qualified name.
   */
  public String getFile() {
    return file;
  }

  /** Returns the line within the source file. 1-based; 0 indicates no line number available. */
  public Long getLine() {
    return line;
  }

  /**
   * Returns the human-readable name of the function or method being invoked, with optional context
   * such as the class or package name. This information may be used in contexts such as the logs
   * viewer, where a file and line number are less meaningful. The format can vary by language.
   */
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

  static SourceLocation fromPb(LogEntrySourceLocation sourceLocationPb) {
    return new Builder()
        .setFile(sourceLocationPb.getFile())
        .setLine(sourceLocationPb.getLine())
        .setFunction(sourceLocationPb.getFunction())
        .build();
  }
}
