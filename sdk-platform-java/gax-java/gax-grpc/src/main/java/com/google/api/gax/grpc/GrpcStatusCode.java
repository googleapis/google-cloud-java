/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.rpc.StatusCode;
import com.google.auto.value.AutoValue;
import io.grpc.Status;

/** A failure code specific to a gRPC call. */
@InternalExtensionOnly
@AutoValue
public abstract class GrpcStatusCode implements StatusCode {
  /** Creates a new instance with the given {@link Status.Code}. */
  public static GrpcStatusCode of(Status.Code grpcCode) {
    return new AutoValue_GrpcStatusCode(grpcCode);
  }

  static StatusCode.Code grpcCodeToStatusCode(Status.Code code) {
    switch (code) {
      case OK:
        return StatusCode.Code.OK;
      case CANCELLED:
        return StatusCode.Code.CANCELLED;
      case UNKNOWN:
        return StatusCode.Code.UNKNOWN;
      case INVALID_ARGUMENT:
        return StatusCode.Code.INVALID_ARGUMENT;
      case DEADLINE_EXCEEDED:
        return StatusCode.Code.DEADLINE_EXCEEDED;
      case NOT_FOUND:
        return StatusCode.Code.NOT_FOUND;
      case ALREADY_EXISTS:
        return StatusCode.Code.ALREADY_EXISTS;
      case PERMISSION_DENIED:
        return StatusCode.Code.PERMISSION_DENIED;
      case RESOURCE_EXHAUSTED:
        return StatusCode.Code.RESOURCE_EXHAUSTED;
      case FAILED_PRECONDITION:
        return StatusCode.Code.FAILED_PRECONDITION;
      case ABORTED:
        return StatusCode.Code.ABORTED;
      case OUT_OF_RANGE:
        return StatusCode.Code.OUT_OF_RANGE;
      case UNIMPLEMENTED:
        return StatusCode.Code.UNIMPLEMENTED;
      case INTERNAL:
        return StatusCode.Code.INTERNAL;
      case UNAVAILABLE:
        return StatusCode.Code.UNAVAILABLE;
      case DATA_LOSS:
        return StatusCode.Code.DATA_LOSS;
      case UNAUTHENTICATED:
        return StatusCode.Code.UNAUTHENTICATED;
      default:
        throw new IllegalStateException("Unrecognized status code: " + code);
    }
  }

  /** Returns the {@link Status.Code} from grpc. */
  @Override
  public StatusCode.Code getCode() {
    return grpcCodeToStatusCode(getTransportCode());
  }

  @Override
  public abstract Status.Code getTransportCode();
}
