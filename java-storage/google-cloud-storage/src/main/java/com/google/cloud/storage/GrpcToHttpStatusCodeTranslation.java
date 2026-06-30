/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.grpc.Status.Code;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A set of compatibility tools to map between grpc and HTTP status codes while trying to keep our
 * retry behavior in consideration.
 */
final class GrpcToHttpStatusCodeTranslation {

  /**
   * Mappings between gRPC status codes and their corresponding HTTP status codes, which match our
   * existing definitions and retry bucketing.
   *
   * <p>
   *
   * <p>{@code UNAVAILABLE} covers connection reset
   *
   * <pre>
   *   io.grpc.netty.shaded.io.netty.channel.unix.Errors$NativeIoException: readAddress(..) failed: Connection reset by peer
   * </pre>
   */
  private static final ImmutableList<StatusCodeMapping> STATUS_CODE_MAPPINGS =
      ImmutableList.of(
          StatusCodeMapping.of(200, Code.OK),
          StatusCodeMapping.of(400, Code.DATA_LOSS),
          StatusCodeMapping.of(400, Code.INVALID_ARGUMENT),
          StatusCodeMapping.of(400, Code.OUT_OF_RANGE),
          StatusCodeMapping.of(401, Code.UNAUTHENTICATED),
          StatusCodeMapping.of(403, Code.PERMISSION_DENIED),
          StatusCodeMapping.of(404, Code.NOT_FOUND),
          StatusCodeMapping.of(409, Code.ALREADY_EXISTS),
          StatusCodeMapping.of(412, Code.FAILED_PRECONDITION),
          StatusCodeMapping.of(429, Code.RESOURCE_EXHAUSTED),
          StatusCodeMapping.of(500, Code.INTERNAL),
          StatusCodeMapping.of(501, Code.UNIMPLEMENTED),
          StatusCodeMapping.of(503, Code.UNAVAILABLE),
          StatusCodeMapping.of(504, Code.DEADLINE_EXCEEDED),
          StatusCodeMapping.of(409, Code.ABORTED),
          StatusCodeMapping.of(0, Code.CANCELLED),
          StatusCodeMapping.of(0, Code.UNKNOWN));

  /** Index our {@link StatusCodeMapping} for constant time lookup by {@link Code} */
  private static final Map<Code, StatusCodeMapping> GRPC_CODE_INDEX =
      STATUS_CODE_MAPPINGS.stream()
          .collect(
              ImmutableMap.toImmutableMap(StatusCodeMapping::getGrpcCode, Function.identity()));

  /**
   * For use in {@link #resultRetryAlgorithmToCodes(ResultRetryAlgorithm)}. Resolve all codes and
   * construct corresponding ApiExceptions.
   *
   * <p>Constructing the exceptions will walk the stack for each one. In order to avoid the stack
   * walking overhead for every Code for every invocation, construct the set of exceptions only once
   * and keep in this value.
   */
  private static final Set<StorageException> CODE_API_EXCEPTIONS =
      STATUS_CODE_MAPPINGS.stream()
          .map(StatusCodeMapping::getGrpcStatusCode)
          .map(c -> ApiExceptionFactory.createException(null, c, false))
          .map(StorageException::asStorageException)
          .collect(Collectors.toSet());

  /**
   * When translating from gRPC Status Codes to the HTTP codes all of our middle ware expects, we
   * must take care to translate in accordance with the expected retry semantics already outlined
   * and validated for the JSON implementation. This is why we do not simply use {@link
   * GrpcStatusCode#of(Code)}{@link GrpcStatusCode#getCode() .getCode}{@link
   * StatusCode.Code#getHttpStatusCode() .getHttpStatusCode()} as it sometimes returns conflicting
   * HTTP codes for our retry handling.
   */
  static int grpcCodeToHttpStatusCode(Code code) {
    StatusCodeMapping found = GRPC_CODE_INDEX.get(code);
    // theoretically it's possible for gRPC to add a new code we haven't mapped here, if this
    // happens fall through to our default of 0
    if (found != null) {
      return found.getHttpStatus();
    } else {
      return 0;
    }
  }

  /**
   * When using the retry features of the Gapic client, we are only allowed to provide a {@link
   * Set}{@code <}{@link StatusCode.Code}{@code >}. Given {@link StatusCode.Code} is an enum, we can
   * resolve the set of values from a given {@link ResultRetryAlgorithm} by evaluating each one as
   * an {@link ApiException}.
   */
  static Set<StatusCode.Code> resultRetryAlgorithmToCodes(ResultRetryAlgorithm<?> alg) {
    return CODE_API_EXCEPTIONS.stream()
        .filter(e -> alg.shouldRetry(e, null))
        .map(e -> e.apiExceptionCause.getStatusCode().getCode())
        .collect(Collectors.toSet());
  }

  /**
   * Simple tuple class to bind together our corresponding http status code and {@link Code} while
   * providing easy access to the correct {@link GrpcStatusCode} where necessary.
   */
  private static final class StatusCodeMapping {

    private final int httpStatus;

    private final Code grpcCode;
    private final GrpcStatusCode grpcStatusCode;

    private StatusCodeMapping(int httpStatus, Code grpcCode, GrpcStatusCode grpcStatusCode) {
      this.httpStatus = httpStatus;
      this.grpcCode = grpcCode;
      this.grpcStatusCode = grpcStatusCode;
    }

    public int getHttpStatus() {
      return httpStatus;
    }

    public Code getGrpcCode() {
      return grpcCode;
    }

    public GrpcStatusCode getGrpcStatusCode() {
      return grpcStatusCode;
    }

    static StatusCodeMapping of(int httpStatus, Code grpcCode) {
      return new StatusCodeMapping(httpStatus, grpcCode, GrpcStatusCode.of(grpcCode));
    }
  }
}
