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

package com.google.cloud.spanner.sample;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.utility.DockerImageName;

public class EmulatorInitializer
    implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
  private GenericContainer<?> emulator;

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    ConfigurableEnvironment environment = event.getEnvironment();
    boolean useEmulator =
        Boolean.TRUE.equals(environment.getProperty("spanner.emulator", Boolean.class));
    if (!useEmulator) {
      return;
    }

    emulator =
        new GenericContainer<>(DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator"));
    emulator.withImagePullPolicy(PullPolicy.alwaysPull());
    emulator.addExposedPort(9010);
    emulator.setWaitStrategy(Wait.forListeningPorts(9010));
    emulator.start();

    System.setProperty("spanner.endpoint", "//localhost:" + emulator.getMappedPort(9010));
  }

  public void stopEmulator() {
    if (this.emulator != null) {
      this.emulator.stop();
    }
  }
}
