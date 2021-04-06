/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.common;

import com.google.common.base.Objects;

/**
 * The `Status` type defines a logical error model. Each `Status` message contains an error code and
 * a error message.
 *
 * <p>This primarily wraps the protobuf {@link com.google.rpc.Status}.
 */
public final class Status {
  public enum Code {
    OK(com.google.rpc.Code.OK),
    CANCELLED(com.google.rpc.Code.CANCELLED),
    UNKNOWN(com.google.rpc.Code.UNKNOWN),
    INVALID_ARGUMENT(com.google.rpc.Code.INVALID_ARGUMENT),
    DEADLINE_EXCEEDED(com.google.rpc.Code.DEADLINE_EXCEEDED),
    NOT_FOUND(com.google.rpc.Code.NOT_FOUND),
    ALREADY_EXISTS(com.google.rpc.Code.ALREADY_EXISTS),
    PERMISSION_DENIED(com.google.rpc.Code.PERMISSION_DENIED),
    UNAUTHENTICATED(com.google.rpc.Code.UNAUTHENTICATED),
    RESOURCE_EXHAUSTED(com.google.rpc.Code.RESOURCE_EXHAUSTED),
    FAILED_PRECONDITION(com.google.rpc.Code.FAILED_PRECONDITION),
    ABORTED(com.google.rpc.Code.ABORTED),
    OUT_OF_RANGE(com.google.rpc.Code.OUT_OF_RANGE),
    UNIMPLEMENTED(com.google.rpc.Code.UNIMPLEMENTED),
    INTERNAL(com.google.rpc.Code.INTERNAL),
    UNAVAILABLE(com.google.rpc.Code.UNAVAILABLE),
    DATA_LOSS(com.google.rpc.Code.DATA_LOSS),

    /** Code not known by the client, please upgrade your client */
    UNRECOGNIZED(com.google.rpc.Code.UNRECOGNIZED);

    private final com.google.rpc.Code proto;

    public static Code fromProto(com.google.rpc.Code proto) {
      for (Code code : values()) {
        if (code.proto.equals(proto)) {
          return code;
        }
      }
      return UNRECOGNIZED;
    }

    public static Code fromCodeNumber(int num) {
      for (Code code : values()) {
        if (code.proto == com.google.rpc.Code.UNRECOGNIZED) {
          continue;
        }
        if (code.proto.getNumber() == num) {
          return code;
        }
      }
      return UNRECOGNIZED;
    }

    Code(com.google.rpc.Code proto) {
      this.proto = proto;
    }

    public com.google.rpc.Code toProto() {
      return proto;
    }
  }

  private final com.google.rpc.Status proto;

  /** Wraps the given protobuf Status */
  public static Status fromProto(com.google.rpc.Status proto) {
    return new Status(proto);
  }

  private Status(com.google.rpc.Status proto) {
    this.proto = proto;
  }

  /** Gets the typesafe code. */
  public Code getCode() {
    return Code.fromCodeNumber(proto.getCode());
  }

  /** Gets error message. */
  public String getMessage() {
    return proto.getMessage();
  }

  /** Gets the underlying protobuf. */
  public com.google.rpc.Status toProto() {
    return proto;
  }

  public String toString() {
    return proto.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equal(proto, status.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }
}
