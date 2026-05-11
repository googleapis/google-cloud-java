/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsePubSubEmulatorExampleIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalOut;

  private static void requireEnvVar(String varName) {
    assertWithMessage("Environment variable " + varName + " is required to perform these tests.")
        .that(System.getenv(varName))
        .isNotNull();
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("PUBSUB_EMULATOR_HOST");
  }

  @Before
  public void setUp() {
    originalOut = System.out;
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  public void testUsePubSubEmulatorExample() throws Exception {
    UsePubSubEmulatorExample.main();
    String output = bout.toString();
    assertThat(output).contains("Created topic: ");
    assertThat(output).contains("Published message ID: ");
  }
}
