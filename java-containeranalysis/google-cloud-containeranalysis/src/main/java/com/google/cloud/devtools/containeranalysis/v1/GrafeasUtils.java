/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1;

import io.grafeas.v1.GrafeasSettings;
import java.io.IOException;

/**
 * This internal class is used to link the ContainerAnalysisClient to GrafeasClient implementations.
 * Given a ContainerAnalysisClient, we need to instantiate a GrafeasClient with the same
 * configuration.
 */
class GrafeasUtils {

  /** Converts ContainerAnalysisSettings to GrafeasSettings using the same configuration. */
  static GrafeasSettings transformSettings(ContainerAnalysisSettings settings) throws IOException {
    return GrafeasSettings.newBuilder()
        .setClock(settings.getClock())
        .setCredentialsProvider(settings.getCredentialsProvider())
        .setEndpoint(settings.getEndpoint())
        .setExecutorProvider(settings.getBackgroundExecutorProvider())
        .setHeaderProvider(settings.getHeaderProvider())
        .setTransportChannelProvider(settings.getTransportChannelProvider())
        .setWatchdogCheckInterval(settings.getWatchdogCheckInterval())
        .setWatchdogProvider(settings.getWatchdogProvider())
        .build();
  }
}
