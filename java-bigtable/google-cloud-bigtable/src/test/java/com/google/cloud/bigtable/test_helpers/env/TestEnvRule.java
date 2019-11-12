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

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * JUnit rule to start and stop the target test environment.
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
 *
 * <p>Also, when the system property {@code bigtable.grpc-log-dir} is set, it will enable fine
 * grained gRPC logging to the configured path.
 */
public class TestEnvRule implements TestRule {

  private static final Logger LOGGER = Logger.getLogger(TestEnvRule.class.getName());
  private static final String BIGTABLE_GRPC_LOG_DIR = System.getProperty("bigtable.grpc-log-dir");
  private static final String BIGTABLE_EMULATOR_HOST_ENV_VAR = "BIGTABLE_EMULATOR_HOST";
  private static final String ENV_PROPERTY = "bigtable.env";
  private static final String env = System.getProperty(ENV_PROPERTY, "emulator");

  private AbstractTestEnv testEnv;

  private Handler grpcLogHandler;
  private static final Set<String> GRPC_LOGGER_NAMES =
      ImmutableSet.of("io.grpc", "io.grpc.netty.shaded");

  @Override
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      public void evaluate() throws Throwable {
        TestEnvRule.this.before(description);

        try {
          base.evaluate();
        } finally {
          TestEnvRule.this.after();
        }
      }
    };
  }

  protected void before(Description description) throws Throwable {
    assume()
        .withMessage(
            "Integration tests can't run with the BIGTABLE_EMULATOR_HOST environment variable set"
                + ". Please use the emulator-it maven profile instead")
        .that(System.getenv())
        .doesNotContainKey(BIGTABLE_EMULATOR_HOST_ENV_VAR);

    configureLogging(description);

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

  private void configureLogging(Description description) throws IOException {
    if (Strings.isNullOrEmpty(BIGTABLE_GRPC_LOG_DIR)) {
      return;
    }

    Files.createDirectories(Paths.get(BIGTABLE_GRPC_LOG_DIR));

    String basename =
        Joiner.on("-").useForNull("").join(description.getClassName(), description.getMethodName());
    Path logPath = Paths.get(BIGTABLE_GRPC_LOG_DIR, basename + ".log");

    grpcLogHandler = new FileHandler(logPath.toString());
    grpcLogHandler.setFormatter(new SimpleFormatter());
    grpcLogHandler.setLevel(Level.ALL);

    for (String grpcLoggerName : GRPC_LOGGER_NAMES) {
      Logger logger = Logger.getLogger(grpcLoggerName);
      logger.setLevel(Level.ALL);
      logger.addHandler(grpcLogHandler);
    }
  }

  private void after() {
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
    teardownLogging();
  }

  private void teardownLogging() {
    if (grpcLogHandler == null) {
      return;
    }

    for (String grpcLoggerName : GRPC_LOGGER_NAMES) {
      Logger.getLogger(grpcLoggerName).removeHandler(grpcLogHandler);
    }
    grpcLogHandler.flush();
    grpcLogHandler = null;
  }

  public AbstractTestEnv env() {
    return testEnv;
  }
}
