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
package com.google.cloud.bigtable.emulator.v2;

import com.google.api.core.BetaApi;
import io.grpc.ManagedChannel;
import org.junit.rules.ExternalResource;

/**
 * The BigtableEmulatorRule manages the lifecycle of the Bigtable {@link Emulator}. Before the start
 * of a test, the emulator will be started on a random port and will be shutdown after the test
 * finishes.
 *
 * <p>Example usage: <code>{@code
 *   {@literal @RunWith(JUnit4.class)}
 *   public class MyTest {
 *     {@literal @Rule}
 *     public final BigtableEmulatorRule bigtableEmulator = BigtableEmulatorRule.create();
 *
 *     {@literal @Test}
 *     public void testUsingEmulator() {
 *        ManagedChannel adminChannel = bigtableEmulator.getAdminChannel();
 *        // Do something with channel
 *     }
 *   }
 * }</code>
 */
@BetaApi("Surface for Bigtable emulator is not yet stable")
public class BigtableEmulatorRule extends ExternalResource {
  private Emulator emulator;

  public static BigtableEmulatorRule create() {
    return new BigtableEmulatorRule();
  }

  private BigtableEmulatorRule() {}

  /** Initializes the Bigtable emulator before a test runs. */
  @Override
  protected void before() throws Throwable {
    emulator = Emulator.createBundled();
    emulator.start();
  }

  /** Stops the Bigtable emulator after a test finishes. */
  @Override
  protected void after() {
    emulator.stop();
    emulator = null;
  }

  /**
   * Gets a {@link ManagedChannel} connected to the Emulator. The channel is configured for data
   * operations.
   */
  public ManagedChannel getDataChannel() {
    return emulator.getDataChannel();
  }

  /**
   * Gets a {@link ManagedChannel} connected to the Emulator. This channel should be used for admin
   * operations.
   */
  public ManagedChannel getAdminChannel() {
    return emulator.getAdminChannel();
  }

  /**
   * Gets the port of the emulator, allowing the caller to create their own {@link ManagedChannel}.
   */
  public int getPort() {
    return emulator.getPort();
  }
}
