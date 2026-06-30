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

import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.connection.SpannerPool;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.SpringApplication;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

@Ignore("The emulator does not return DML statistics when using a RETURNING clause")
@RunWith(JUnit4.class)
public class ApplicationEmulatorTest {
  private static GenericContainer<?> emulator;

  private static Properties properties;

  @BeforeClass
  public static void startEmulator() {
    assumeTrue(DockerClientFactory.instance().isDockerAvailable());

    emulator =
        new GenericContainer<>(
                DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator:latest"))
            .withExposedPorts(9010)
            .waitingFor(Wait.forListeningPorts(9010));
    emulator.start();
    properties = new Properties();
    properties.setProperty("autoConfigEmulator", "true");
    properties.setProperty(
        "endpoint", String.format("%s:%d", emulator.getHost(), emulator.getMappedPort(9010)));
  }

  @AfterClass
  public static void cleanup() {
    SpannerPool.closeSpannerPool();
    if (emulator != null) {
      emulator.stop();
    }
  }

  @Test
  public void testRunApplication() {
    System.setProperty("open_telemetry.project", "test-project");
    System.setProperty("port", String.valueOf(emulator.getMappedPort(9010)));
    SpringApplication.run(Application.class).close();
  }
}
