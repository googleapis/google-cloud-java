/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.fail;

import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.conformance.retry.CtxFunctions.ResourceSetup;
import com.google.cloud.storage.conformance.retry.CtxFunctions.ResourceTeardown;
import com.google.cloud.storage.conformance.retry.Functions.CtxFunction;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.util.HashSet;
import java.util.function.Predicate;
import org.junit.AssumptionViolatedException;

/**
 * Immutable class which represents a mapping between an {@link RpcMethod} and a method in the
 * public {@code com.google.cloud.storage} API.
 *
 * <p>This class defines a semi-declarative why in which mappings can be declared independent of the
 * actual environment & state necessary to actually invoke a method.
 *
 * @see ITRetryConformanceTest#test()
 * @see RpcMethodMappings
 */
@Immutable
final class RpcMethodMapping {
  private final int mappingId;
  private final RpcMethod method;
  private final Predicate<TestRetryConformance> applicable;
  private final CtxFunction setup;
  private final CtxFunction test;
  private final CtxFunction tearDown;

  RpcMethodMapping(
      int mappingId,
      RpcMethod method,
      Predicate<TestRetryConformance> applicable,
      CtxFunction setup,
      CtxFunction test,
      CtxFunction tearDown) {
    this.mappingId = mappingId;
    this.method = method;
    this.applicable = applicable;
    this.setup = setup;
    this.test = test;
    this.tearDown = tearDown;
  }

  public int getMappingId() {
    return mappingId;
  }

  public RpcMethod getMethod() {
    return method;
  }

  public Predicate<TestRetryConformance> getApplicable() {
    return applicable;
  }

  public CtxFunction getSetup() {
    return setup;
  }

  public CtxFunction getTest() {
    return (ctx, c) -> {
      if (c.isExpectSuccess()) {
        return test.apply(ctx, c);
      } else {
        try {
          test.apply(ctx, c);
          fail("expected failure, but succeeded");
        } catch (StorageException e) {
          // We expect an exception to be thrown by mapping and test retry conformance config
          // Verify that the exception we received is actually what we expect.
          boolean matchExpectedCode = false;
          int code = e.getCode();
          HashSet<String> instructions = newHashSet(c.getInstruction().getInstructionsList());
          if (instructions.contains("return-503") && code == 503) {
            matchExpectedCode = true;
          }
          if (instructions.contains("return-400") && code == 400) {
            matchExpectedCode = true;
          }
          if (instructions.contains("return-401") && code == 401) {
            matchExpectedCode = true;
          }
          if (instructions.contains("return-reset-connection") && code == 0) {
            matchExpectedCode = true;
          }
          // testbench resetting the connection is turned into an UNAVAILABLE in grpc, which we then
          // map to 503. Add graceful handling here, since we can't disambiguate between reset
          // connection and 503 from the service.
          if (c.getTransport() == Transport.GRPC
              && instructions.contains("return-reset-connection")
              && code == 503) {
            matchExpectedCode = true;
          }

          if (matchExpectedCode) {
            return ctx;
          } else {
            throw e;
          }
        }
      }
      throw new IllegalStateException(
          "Unable to determine applicability of mapping for provided TestCaseConfig");
    };
  }

  public CtxFunction getTearDown() {
    return tearDown;
  }

  public Builder toBuilder() {
    return new Builder(mappingId, method, applicable, setup, test, tearDown);
  }

  static Builder newBuilder(int mappingId, RpcMethod method) {
    Preconditions.checkArgument(mappingId >= 1, "mappingId must be >= 1, but was %d", mappingId);
    return new Builder(mappingId, method);
  }

  static RpcMethodMapping notImplemented(RpcMethod method) {
    return new Builder(0, method)
        .withSetup(
            (s, c) -> {
              throw new AssumptionViolatedException("not implemented");
            })
        .withTest(CtxFunction.identity())
        .build();
  }

  static final class Builder {

    private final int mappingId;
    private final RpcMethod method;
    private final Predicate<TestRetryConformance> applicable;
    private final CtxFunction setup;
    private final CtxFunction test;
    private CtxFunction tearDown;

    Builder(int mappingId, RpcMethod method) {
      this(
          mappingId,
          method,
          x -> true,
          ResourceSetup.defaultSetup,
          null,
          ResourceTeardown.defaultTeardown);
    }

    private Builder(
        int mappingId,
        RpcMethod method,
        Predicate<TestRetryConformance> applicable,
        CtxFunction setup,
        CtxFunction test,
        CtxFunction tearDown) {
      this.mappingId = mappingId;
      this.method = method;
      this.applicable = applicable;
      this.setup = setup;
      this.test = test;
      this.tearDown = tearDown;
    }

    public Builder withApplicable(Predicate<TestRetryConformance> applicable) {
      return new Builder(mappingId, method, applicable, setup, test, tearDown);
    }

    public Builder withSetup(CtxFunction setup) {
      return new Builder(mappingId, method, applicable, setup, null, tearDown);
    }

    public Builder withTest(CtxFunction test) {
      return new Builder(mappingId, method, applicable, setup, test, tearDown);
    }

    public Builder withTearDown(CtxFunction tearDown) {
      this.tearDown = tearDown;
      return this;
    }

    public RpcMethodMapping build() {
      return new RpcMethodMapping(
          mappingId,
          requireNonNull(method, "method must be non null"),
          requireNonNull(applicable, "applicable must be non null"),
          requireNonNull(setup, "setup must be non null"),
          requireNonNull(test, "test must be non null"),
          requireNonNull(tearDown, "tearDown must be non null"));
    }
  }
}
