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
package com.google.cloud.bigtable.test_helpers.env;

import static com.google.common.truth.TruthJUnit.assume;

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
 *       system properties listed in {@link CloudEnv} and application default credentials
 *   <li>{@code direct_path}: uses a pre-existing table in the direct path test environment. The
 *       target table is defined using system properties listed in {@link CloudEnv} and application
 *       default credentials
 * </ul>
 *
 * <p>By default, {@code emulator} will be used
 */
public class TestEnvRule extends ExternalResource {

  private static final Logger LOGGER = Logger.getLogger(TestEnvRule.class.getName());
  private static final String BIGTABLE_EMULATOR_HOST_ENV_VAR = "BIGTABLE_EMULATOR_HOST";
  private static final String ENV_PROPERTY = "bigtable.env";
  private static final String env = System.getProperty(ENV_PROPERTY, "emulator");

  private AbstractTestEnv testEnv;

  @Override
  protected void before() throws Throwable {
    assume()
        .withMessage(
            "Integration tests can't run with the BIGTABLE_EMULATOR_HOST environment variable set"
                + ". Please use the emulator-it maven profile instead")
        .that(System.getenv())
        .doesNotContainKey(BIGTABLE_EMULATOR_HOST_ENV_VAR);

    switch (env) {
      case "emulator":
        testEnv = EmulatorEnv.createBundled();
        break;
      case "cloud":
        testEnv = CloudEnv.fromSystemProperties();
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
      env().cleanUpStale();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to cleanup environment", e);
    }

    try {
      testEnv.stop();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to stop the environment", e);
    }
    testEnv = null;
  }

  public AbstractTestEnv env() {
    return testEnv;
  }
}
