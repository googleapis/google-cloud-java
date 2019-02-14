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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.logging.v2.LogEntryOperation;
import java.io.Serializable;
import java.util.Objects;

/**
 * Additional information about a potentially long-running operation with which a log entry is
 * associated.
 *
 * @see <a href=
 *     "https://cloud.google.com/logging/docs/api/ref_v2beta1/rest/v2beta1/LogEntry#LogEntryOperation">
 *     Log Entry Operation</a>
 */
public final class Operation implements Serializable {

  private static final long serialVersionUID = 1586890644894328269L;

  private final String id;
  private final String producer;
  private final boolean first;
  private final boolean last;

  /** A builder for {@code Operation} objects. */
  public static final class Builder {

    private String id;
    private String producer;
    private boolean first;
    private boolean last;

    Builder(String id, String producer) {
      this.id = id;
      this.producer = producer;
    }

    Builder(Operation operation) {
      this.id = operation.id;
      this.producer = operation.producer;
      this.first = operation.first;
      this.last = operation.last;
    }

    /**
     * Sets the operation identifier. Log entries with the same identifier are assumed to be part of
     * the same operation. The combination of id and producer must be globally unique.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets an arbitrary producer identifier. The combination of producer and id must be globally
     * unique. Examples: {@code MyDivision.MyBigCompany.com}, {@code
     * github.com/MyProject/MyApplication}.
     */
    public Builder setProducer(String producer) {
      this.producer = producer;
      return this;
    }

    /**
     * Sets whether the corresponding entry is the first log entry in the operation. If not set,
     * {@code false} is used.
     */
    public Builder setFirst(boolean first) {
      this.first = first;
      return this;
    }

    /**
     * Sets whether the corresponding entry is the last log entry in the operation. If not set,
     * {@code false} is used.
     */
    public Builder setLast(boolean last) {
      this.last = last;
      return this;
    }

    /** Creates an {@code Operation} object for this builder. */
    public Operation build() {
      return new Operation(this);
    }
  }

  Operation(Builder builder) {
    this.id = checkNotNull(builder.id);
    this.producer = checkNotNull(builder.producer);
    this.first = builder.first;
    this.last = builder.last;
  }

  /**
   * Returns the operation identifier. Log entries with the same identifier are assumed to be part
   * of the same operation. The combination of this value and {@link #getProducer()} must be
   * globally unique.
   */
  public String getId() {
    return id;
  }

  /**
   * Returns an arbitrary producer identifier. The combination of this value and {@link #getId()}
   * must be globally unique. Examples: {@code MyDivision.MyBigCompany.com}, {@code
   * github.com/MyProject/MyApplication}.
   */
  public String getProducer() {
    return producer;
  }

  /**
   * Returns {@code true} if the corresponding entry is the first log entry in the operation, {@code
   * false} otherwise.
   */
  public boolean first() {
    return first;
  }

  /**
   * Returns {@code true} if the corresponding entry is the last log entry in the operation, {@code
   * false} otherwise.
   */
  public boolean last() {
    return last;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Operation)) {
      return false;
    }
    Operation other = (Operation) obj;
    return Objects.equals(id, other.id)
        && Objects.equals(producer, other.producer)
        && Objects.equals(first, other.first)
        && Objects.equals(last, other.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, producer, first, last);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("producer", producer)
        .add("first", first)
        .add("last", last)
        .toString();
  }

  /** Returns a {@code Builder} for this operation. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  LogEntryOperation toPb() {
    LogEntryOperation.Builder builder = LogEntryOperation.newBuilder();
    builder.setId(id);
    builder.setProducer(producer);
    builder.setFirst(first);
    builder.setLast(last);
    return builder.build();
  }

  /**
   * Returns a builder for {@code Operation} objects given the operation and producer identifiers.
   * The combination of producer and id must be globally unique.
   */
  public static Builder newBuilder(String id, String producer) {
    return new Builder(id, producer);
  }

  /**
   * Returns a {@code Operation} object given the operation and producer identifiers. The
   * combination of producer and id must be globally unique.
   */
  public static Operation of(String id, String producer) {
    return newBuilder(id, producer).build();
  }

  static Operation fromPb(LogEntryOperation operationPb) {
    return newBuilder(operationPb.getId(), operationPb.getProducer())
        .setFirst(operationPb.getFirst())
        .setLast(operationPb.getLast())
        .build();
  }
}
