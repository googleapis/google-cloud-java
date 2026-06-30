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

import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import io.grpc.Status;

/**
 * Implementation of OperationSnapshot based on gRPC.
 *
 * <p>Package-private for internal usage.
 */
class GrpcOperationSnapshot implements OperationSnapshot {

  private final Operation operation;

  public GrpcOperationSnapshot(Operation operation) {
    this.operation = operation;
  }

  @Override
  public String getName() {
    return operation.getName();
  }

  @Override
  public Object getMetadata() {
    return operation.getMetadata();
  }

  @Override
  public boolean isDone() {
    return operation.getDone();
  }

  @Override
  public Object getResponse() {
    return operation.getResponse();
  }

  @Override
  public StatusCode getErrorCode() {
    return GrpcStatusCode.of(Status.fromCodeValue(operation.getError().getCode()).getCode());
  }

  @Override
  public String getErrorMessage() {
    return operation.getError().getMessage();
  }

  public static GrpcOperationSnapshot create(Operation operation) {
    return new GrpcOperationSnapshot(operation);
  }
}
