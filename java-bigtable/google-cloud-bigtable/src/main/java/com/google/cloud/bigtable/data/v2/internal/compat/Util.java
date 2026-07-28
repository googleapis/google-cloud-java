/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.compat;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import io.grpc.Context;
import io.grpc.Deadline;
import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.annotation.Nonnull;

public class Util {
  public static <K, V extends Closeable> LoadingCache<K, V> createSessionMap(
      Function<K, V> factory) {
    return CacheBuilder.newBuilder()
        .expireAfterAccess(Duration.ofMinutes(5))
        .removalListener(
            (RemovalListener<K, V>)
                notification -> {
                  try {
                    @SuppressWarnings("DataFlowIssue")
                    @Nonnull
                    V value = notification.getValue();
                    //noinspection DataFlowIssue
                    value.close();
                  } catch (IOException e) {
                    // TODO log
                  }
                })
        .build(
            new CacheLoader<K, V>() {
              @Override
              @Nonnull
              public V load(@Nonnull K key) {
                return factory.apply(key);
              }
            });
  }

  public static Duration extractTimeout(UnaryCallSettings<?, ?> settings) {
    return settings.getRetrySettings().getTotalTimeoutDuration();
  }

  public static Deadline extractDeadline(GrpcCallContext callContext, Duration defaultDeadline) {
    // NOTE: ignoring callContext.timeout because its an attempt timeout
    Optional<Deadline> ambientDeadline = Optional.ofNullable(Context.current().getDeadline());
    Optional<Duration> retryTotalTimeout =
        Optional.ofNullable(callContext)
            .flatMap(ctx -> Optional.ofNullable(ctx.getRetrySettings()))
            .map(RetrySettings::getTotalTimeoutDuration);
    Optional<Deadline> grpcCallDeadline =
        Optional.ofNullable(callContext)
            .flatMap(ctx -> Optional.ofNullable(ctx.getCallOptions()))
            .flatMap(ctx -> Optional.ofNullable(ctx.getDeadline()));

    Deadline effectiveDeadline = null;
    if (ambientDeadline.isPresent()) {
      effectiveDeadline = ambientDeadline.get();
    }
    if (grpcCallDeadline.isPresent()) {
      if (effectiveDeadline == null || grpcCallDeadline.get().isBefore(effectiveDeadline)) {
        effectiveDeadline = grpcCallDeadline.get();
      }
    }
    if (retryTotalTimeout.isPresent()) {
      Deadline retryDeadline =
          Deadline.after(retryTotalTimeout.get().toMillis(), TimeUnit.MILLISECONDS);
      if (effectiveDeadline == null || retryDeadline.isBefore(effectiveDeadline)) {
        effectiveDeadline = retryDeadline;
      }
    }
    if (effectiveDeadline == null) {
      effectiveDeadline = Deadline.after(defaultDeadline.toMillis(), TimeUnit.MILLISECONDS);
    }
    return effectiveDeadline;
  }
}
