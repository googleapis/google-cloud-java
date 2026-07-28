/*
 * Copyright 2023 Google LLC
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

import com.google.auth.Credentials;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/**
 * @deprecated this class is no longer used and is empty. It only exists because it's symbols were
 *     part of the public surface.
 */
@Deprecated
public class BuiltinMetricsView {
  private BuiltinMetricsView() {}

  @Deprecated
  public static void registerBuiltinMetrics(String projectId, SdkMeterProviderBuilder builder)
      throws IOException {}

  @Deprecated
  public static void registerBuiltinMetrics(SdkMeterProviderBuilder builder) throws IOException {}

  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId, @Nullable Credentials credentials, SdkMeterProviderBuilder builder)
      throws IOException {}

  @Deprecated
  public static void registerBuiltinMetrics(
      String projectId,
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint)
      throws IOException {}

  @Deprecated
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials, SdkMeterProviderBuilder builder, @Nullable String endpoint)
      throws IOException {}

  @Deprecated
  public static void registerBuiltinMetrics(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {}

  @Deprecated
  static void registerBuiltinMetricsWithUniverseDomain(
      @Nullable Credentials credentials,
      SdkMeterProviderBuilder builder,
      @Nullable String endpoint,
      String universeDomain,
      @Nullable ScheduledExecutorService executorService)
      throws IOException {}
}
