/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.rpc.Code;
import io.grpc.Status;
import java.util.Map;
import java.util.function.Function;

final class GrpcToDatastoreCodeTranslation {
  /** Mappings between gRPC status codes and their corresponding code numbers. */
  private static final ImmutableList<StatusCodeMapping> STATUS_CODE_MAPPINGS =
      ImmutableList.of(
          StatusCodeMapping.of(Code.OK.getNumber(), Status.Code.OK),
          StatusCodeMapping.of(Code.DATA_LOSS.getNumber(), Status.Code.DATA_LOSS),
          StatusCodeMapping.of(Code.INVALID_ARGUMENT.getNumber(), Status.Code.INVALID_ARGUMENT),
          StatusCodeMapping.of(Code.OUT_OF_RANGE.getNumber(), Status.Code.OUT_OF_RANGE),
          StatusCodeMapping.of(Code.UNAUTHENTICATED.getNumber(), Status.Code.UNAUTHENTICATED),
          StatusCodeMapping.of(Code.PERMISSION_DENIED.getNumber(), Status.Code.PERMISSION_DENIED),
          StatusCodeMapping.of(Code.NOT_FOUND.getNumber(), Status.Code.NOT_FOUND),
          StatusCodeMapping.of(Code.ALREADY_EXISTS.getNumber(), Status.Code.ALREADY_EXISTS),
          StatusCodeMapping.of(
              Code.FAILED_PRECONDITION.getNumber(), Status.Code.FAILED_PRECONDITION),
          StatusCodeMapping.of(Code.RESOURCE_EXHAUSTED.getNumber(), Status.Code.RESOURCE_EXHAUSTED),
          StatusCodeMapping.of(Code.INTERNAL.getNumber(), Status.Code.INTERNAL),
          StatusCodeMapping.of(Code.UNIMPLEMENTED.getNumber(), Status.Code.UNIMPLEMENTED),
          StatusCodeMapping.of(Code.UNAVAILABLE.getNumber(), Status.Code.UNAVAILABLE),
          StatusCodeMapping.of(Code.DEADLINE_EXCEEDED.getNumber(), Status.Code.DEADLINE_EXCEEDED),
          StatusCodeMapping.of(Code.ABORTED.getNumber(), Status.Code.ABORTED),
          StatusCodeMapping.of(Code.CANCELLED.getNumber(), Status.Code.CANCELLED),
          StatusCodeMapping.of(Code.UNKNOWN.getNumber(), Status.Code.UNKNOWN));

  /** Index our {@link StatusCodeMapping} for constant time lookup by {@link Status.Code} */
  private static final Map<Status.Code, StatusCodeMapping> GRPC_CODE_INDEX =
      STATUS_CODE_MAPPINGS.stream()
          .collect(
              ImmutableMap.toImmutableMap(StatusCodeMapping::getGrpcCode, Function.identity()));

  static int grpcCodeToDatastoreStatusCode(Status.Code code) {
    StatusCodeMapping found = GRPC_CODE_INDEX.get(code);
    // theoretically it's possible for gRPC to add a new code we haven't mapped here, if this
    // happens fall through to our default of 0
    if (found != null) {
      return found.getDatastoreCode();
    } else {
      return 0;
    }
  }

  /**
   * Simple tuple class to bind together our corresponding http status code and {@link Status.Code}
   * while providing easy access to the correct {@link GrpcStatusCode} where necessary.
   */
  private static final class StatusCodeMapping {

    private final int datastoreCode;

    private final Status.Code grpcCode;

    private StatusCodeMapping(int datastoreCode, Status.Code grpcCode) {
      this.datastoreCode = datastoreCode;
      this.grpcCode = grpcCode;
    }

    public int getDatastoreCode() {
      return datastoreCode;
    }

    public Status.Code getGrpcCode() {
      return grpcCode;
    }

    static StatusCodeMapping of(int datastoreCode, Status.Code grpcCode) {
      return new StatusCodeMapping(datastoreCode, grpcCode);
    }
  }
}
