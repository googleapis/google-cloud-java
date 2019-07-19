/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.it.env;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.rules.ExternalResource;

/**
 * Simple JUnit rule to start and stop the target test environment.
 *
 * <p>The environment can be specified via the system property {@code bigtable.env}. The choices
 * are:
 *
 * <ul>
 *   <li>{@code emulator}: uses the cbtemulator component that can be installed by gcloud
 *   <li>{@code prod}: uses a pre-existing production table. The target table is defined using
 *       system properties listed in {@link ProdEnv} and application default credentials
 *   <li>{@code direct_path}: uses a pre-existing table in the direct path test environment. The
 *       target table is defined using system properties listed in {@link ProdEnv} and application
 *       default credentials
 * </ul>
 *
 * <p>By default, {@code emulator} will be used
 */
public class TestEnvRule extends ExternalResource {
  private static final Logger LOGGER = Logger.getLogger(TestEnvRule.class.getName());

  private static final String ENV_PROPERTY = "bigtable.env";

  private TestEnv testEnv;

  @Override
  protected void before() throws Throwable {
    String env = System.getProperty(ENV_PROPERTY, "emulator");

    switch (env) {
      case "emulator":
        testEnv = new EmulatorEnv();
        break;
      case "prod":
        testEnv = ProdEnv.fromSystemProperties();
        break;
      case "direct_path":
        testEnv = DirectPathEnv.create();
        break;
      default:
        throw new IllegalArgumentException(
            String.format(
                "Unknown env: %s. Please set the system property %s to either 'emulator' or 'prod'.",
                env, ENV_PROPERTY));
    }
    testEnv.start();
  }

  @Override
  protected void after() {
    try {
      testEnv.stop();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to stop the environment", e);
    }
    testEnv = null;
  }

  public TestEnv env() {
    return testEnv;
  }
}
