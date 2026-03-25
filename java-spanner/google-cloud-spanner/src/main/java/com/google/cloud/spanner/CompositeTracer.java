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

package com.google.cloud.spanner;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.api.gax.tracing.MetricsTracer;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@InternalApi
public class CompositeTracer extends BaseApiTracer {
  private final List<ApiTracer> children;

  public CompositeTracer(List<ApiTracer> children) {
    this.children = ImmutableList.copyOf(children);
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
    for (ApiTracer child : children) {
      child.attemptStarted(null, attemptNumber);
    }
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    for (ApiTracer child : children) {
      child.attemptStarted(request, attemptNumber);
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

  @Override
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    for (ApiTracer child : children) {
      child.attemptFailedDuration(error, toJavaTimeDuration(delay));
    }
  }

  @Override
  public void attemptFailedDuration(Throwable error, Duration delay) {
    for (ApiTracer child : children) {
      child.attemptFailedDuration(error, delay);
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

  public void addAttributes(String key, String value) {
    for (ApiTracer child : children) {
      if (child instanceof MetricsTracer) {
        MetricsTracer metricsTracer = (MetricsTracer) child;
        metricsTracer.addAttributes(key, value);
      }
    }
  }

  public void addAttributes(Map<String, String> attributes) {
    for (ApiTracer child : children) {
      if (child instanceof MetricsTracer) {
        MetricsTracer metricsTracer = (MetricsTracer) child;
        metricsTracer.addAttributes(attributes);
      }
    }
  }

  public void recordServerTimingHeaderMetrics(
      Float gfeLatency, Float afeLatency, boolean isDirectPathUsed, boolean isAfeEnabled) {
    for (ApiTracer child : children) {
      if (child instanceof BuiltInMetricsTracer) {
        ((BuiltInMetricsTracer) child)
            .recordServerTimingHeaderMetrics(
                gfeLatency, afeLatency, isDirectPathUsed, isAfeEnabled);
      }
    }
  }
}
