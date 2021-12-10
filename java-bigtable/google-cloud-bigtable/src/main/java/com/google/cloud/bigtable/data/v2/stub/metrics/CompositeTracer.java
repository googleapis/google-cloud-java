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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.gax.tracing.ApiTracer;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Combines multiple {@link ApiTracer}s and {@link BigtableTracer}s into a single {@link ApiTracer}.
 */
class CompositeTracer extends BigtableTracer {
  private final List<ApiTracer> children;
  private final List<BigtableTracer> bigtableTracers;
  private volatile int attempt;

  CompositeTracer(List<ApiTracer> children) {
    ImmutableList.Builder<ApiTracer> childrenBuilder = ImmutableList.builder();
    ImmutableList.Builder<BigtableTracer> bigtableTracerBuilder = ImmutableList.builder();

    for (ApiTracer child : children) {
      if (child instanceof BigtableTracer) {
        bigtableTracerBuilder.add((BigtableTracer) child);
      }
      childrenBuilder.add(child);
    }
    this.children = childrenBuilder.build();
    this.bigtableTracers = bigtableTracerBuilder.build();
  }

  @Override
  public Scope inScope() {
    final List<Scope> childScopes = new ArrayList<>(children.size());

    for (ApiTracer child : children) {
      childScopes.add(child.inScope());
    }

    return new Scope() {
      @Override
      public void close() {
        for (Scope childScope : childScopes) {
          childScope.close();
        }
      }
    };
  }

  @Override
  public void operationSucceeded() {
    for (ApiTracer child : children) {
      child.operationSucceeded();
    }
  }

  @Override
  public void operationCancelled() {
    for (ApiTracer child : children) {
      child.operationCancelled();
    }
  }

  @Override
  public void operationFailed(Throwable error) {
    for (ApiTracer child : children) {
      child.operationFailed(error);
    }
  }

  @Override
  public void connectionSelected(String id) {
    for (ApiTracer child : children) {
      child.connectionSelected(id);
    }
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    this.attempt = attemptNumber;
    for (ApiTracer child : children) {
      child.attemptStarted(attemptNumber);
    }
  }

  @Override
  public void attemptSucceeded() {
    for (ApiTracer child : children) {
      child.attemptSucceeded();
    }
  }

  @Override
  public void attemptCancelled() {
    for (ApiTracer child : children) {
      child.attemptCancelled();
    }
  }

  public void attemptFailed(Throwable error, Duration delay) {
    for (ApiTracer child : children) {
      child.attemptFailed(error, delay);
    }
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    for (ApiTracer child : children) {
      child.attemptFailedRetriesExhausted(error);
    }
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    for (ApiTracer child : children) {
      child.attemptPermanentFailure(error);
    }
  }

  @Override
  public void lroStartFailed(Throwable error) {
    for (ApiTracer child : children) {
      child.lroStartFailed(error);
    }
  }

  @Override
  public void lroStartSucceeded() {
    for (ApiTracer child : children) {
      child.lroStartSucceeded();
    }
  }

  @Override
  public void responseReceived() {
    for (ApiTracer child : children) {
      child.responseReceived();
    }
  }

  @Override
  public void requestSent() {
    for (ApiTracer child : children) {
      child.requestSent();
    }
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    for (ApiTracer child : children) {
      child.batchRequestSent(elementCount, requestSize);
    }
  }

  @Override
  public int getAttempt() {
    return attempt;
  }

  @Override
  public void recordGfeMetadata(@Nullable Long latency, @Nullable Throwable throwable) {
    for (BigtableTracer tracer : bigtableTracers) {
      tracer.recordGfeMetadata(latency, throwable);
    }
  }

  @Override
  public void batchRequestThrottled(long throttledTimeMs) {
    for (BigtableTracer tracer : bigtableTracers) {
      tracer.batchRequestThrottled(throttledTimeMs);
    }
  }
}
