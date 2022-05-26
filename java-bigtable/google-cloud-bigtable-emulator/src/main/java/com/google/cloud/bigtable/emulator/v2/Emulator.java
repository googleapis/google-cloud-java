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
import com.google.cloud.bigtable.emulator.core.EmulatorController;
import com.google.common.base.Preconditions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * Wraps the Bigtable emulator in a java api and decorates it with grpc channel builders.
 *
 * <p>This class will use the golang binaries embedded in this jar to launch the emulator as an
 * external process and redirect its output to a {@link Logger}.
 */
@BetaApi("Surface for Bigtable emulator is not yet stable")
public class Emulator {
  private static final Logger LOGGER = Logger.getLogger(Emulator.class.getName());

  private final EmulatorController controller;
  private ManagedChannel dataChannel;
  private ManagedChannel adminChannel;

  public static Emulator createFromPath(Path path) {
    return new Emulator(EmulatorController.createFromPath(path));
  }
  /**
   * Create a new instance of emulator. The emulator will use the bundled binaries in this jar.
   * Please note that the emulator is created in a stopped state, please use {@link #start()} after
   * creating it.
   */
  public static Emulator createBundled() throws IOException {
    return new Emulator(EmulatorController.createBundled());
  }

  private Emulator(EmulatorController controller) {
    this.controller = controller;
  }

  /** Starts the emulator process and waits for it to be ready. */
  public synchronized void start() throws IOException, TimeoutException, InterruptedException {
    controller.start();
  }

  /** Stops the emulator process. */
  public synchronized void stop() {
    controller.stop();

    try {
      // Shutdown channels in parallel
      if (dataChannel != null) {
        dataChannel.shutdownNow();
      }
      if (adminChannel != null) {
        adminChannel.shutdownNow();
      }

      // Then wait for actual shutdown
      if (dataChannel != null) {
        dataChannel.awaitTermination(1, TimeUnit.MINUTES);
        dataChannel = null;
      }
      if (adminChannel != null) {
        adminChannel.awaitTermination(1, TimeUnit.MINUTES);
        adminChannel = null;
      }
    } catch (InterruptedException e) {
      LOGGER.warning("Interrupted while waiting for client channels to close");
      Thread.currentThread().interrupt();
    }
  }

  public synchronized int getPort() {
    return controller.getPort();
  }

  public synchronized ManagedChannel getDataChannel() {
    Preconditions.checkState(controller.isRunning(), "Emulator is not running");

    if (dataChannel == null) {
      dataChannel =
          newChannelBuilder(controller.getPort())
              .maxInboundMessageSize(256 * 1024 * 1024)
              .keepAliveTimeout(10, TimeUnit.SECONDS)
              .keepAliveTime(10, TimeUnit.SECONDS)
              .keepAliveWithoutCalls(true)
              .build();
    }
    return dataChannel;
  }

  public synchronized ManagedChannel getAdminChannel() {
    Preconditions.checkState(controller.isRunning(), "Emulator is not running");

    if (adminChannel == null) {
      adminChannel = newChannelBuilder(controller.getPort()).build();
    }
    return adminChannel;
  }
  // <editor-fold desc="Helpers">

  /** Creates a {@link io.grpc.ManagedChannelBuilder} preconfigured for the emulator's port. */
  private static ManagedChannelBuilder<?> newChannelBuilder(int port) {
    // NOTE: usePlaintext is currently @ExperimentalAPI.
    // See https://github.com/grpc/grpc-java/issues/1772 for discussion
    return ManagedChannelBuilder.forAddress("localhost", port).usePlaintext();
  }
  // </editor-fold>
}
