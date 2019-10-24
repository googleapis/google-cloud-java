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
import io.grpc.ManagedChannelBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wraps the Bigtable emulator in a java api.
 *
 * <p>This class will use the golang binaries embedded in this jar to launch the emulator as an
 * external process and redirect its output to a {@link Logger}.
 */
@BetaApi("Surface for Bigtable emulator is not yet stable")
public class Emulator {

  private static final Logger LOGGER = Logger.getLogger(Emulator.class.getName());

  private final Path executable;
  private Process process;
  private boolean isStopped = true;
  private Thread shutdownHook;

  private int port;
  private ManagedChannel dataChannel;
  private ManagedChannel adminChannel;

  /**
   * Create a new instance of emulator. The emulator will use the bundled binaries in this jar.
   * Please note that the emulator is created in a stopped state, please use {@link #start()} after
   * creating it.
   */
  public static Emulator createBundled() throws IOException {
    String resourcePath = getBundledResourcePath();

    File tmpEmulator = File.createTempFile("cbtemulator", "");
    tmpEmulator.deleteOnExit();

    try (InputStream is = Emulator.class.getResourceAsStream(resourcePath);
        FileOutputStream os = new FileOutputStream(tmpEmulator)) {

      if (is == null) {
        throw new FileNotFoundException(
            "Failed to find the bundled emulator binary: " + resourcePath);
      }

      byte[] buff = new byte[2048];
      int length;

      while ((length = is.read(buff)) != -1) {
        os.write(buff, 0, length);
      }
    }
    tmpEmulator.setExecutable(true);

    return new Emulator(tmpEmulator.toPath());
  }

  private Emulator(Path executable) {
    this.executable = executable;
  }

  /** Starts the emulator process and waits for it to be ready. */
  public synchronized void start() throws IOException, TimeoutException, InterruptedException {
    if (!isStopped) {
      throw new IllegalStateException("Emulator is already started");
    }
    this.port = getAvailablePort();

    // Workaround https://bugs.openjdk.java.net/browse/JDK-8068370
    for (int attemptsLeft = 3; process == null; attemptsLeft--) {
      try {
        process = Runtime.getRuntime().exec(String.format("%s -port %d", executable, port));
      } catch (IOException e) {
        if (attemptsLeft > 0) {
          Thread.sleep(1000);
          continue;
        }
        throw e;
      }
    }
    pipeStreamToLog(process.getInputStream(), Level.INFO);
    pipeStreamToLog(process.getErrorStream(), Level.WARNING);
    isStopped = false;

    shutdownHook =
        new Thread() {
          @Override
          public void run() {
            if (!isStopped) {
              isStopped = true;
              process.destroy();
            }
          }
        };

    Runtime.getRuntime().addShutdownHook(shutdownHook);

    waitForPort(port);
  }

  /** Stops the emulator process. */
  public synchronized void stop() {
    if (isStopped) {
      throw new IllegalStateException("Emulator already stopped");
    }

    try {
      Runtime.getRuntime().removeShutdownHook(shutdownHook);
      shutdownHook = null;

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
    } finally {
      isStopped = true;
      process.destroy();
    }
  }

  public synchronized int getPort() {
    if (isStopped) {
      throw new IllegalStateException("Emulator is not running");
    }
    return port;
  }

  public synchronized ManagedChannel getDataChannel() {
    if (isStopped) {
      throw new IllegalStateException("Emulator is not running");
    }

    if (dataChannel == null) {
      dataChannel = newChannelBuilder(port).maxInboundMessageSize(256 * 1024 * 1024).build();
    }
    return dataChannel;
  }

  public synchronized ManagedChannel getAdminChannel() {
    if (isStopped) {
      throw new IllegalStateException("Emulator is not running");
    }

    if (adminChannel == null) {
      adminChannel = newChannelBuilder(port).build();
    }
    return adminChannel;
  }

  // <editor-fold desc="Helpers">

  /** Gets the current platform, which will be used to select the appropriate emulator binary. */
  private static String getBundledResourcePath() {
    String unformattedOs = System.getProperty("os.name", "unknown").toLowerCase(Locale.ENGLISH);
    String os;
    String suffix = "";

    if (unformattedOs.contains("mac") || unformattedOs.contains("darwin")) {
      os = "darwin";
    } else if (unformattedOs.contains("win")) {
      os = "windows";
      suffix = ".exe";
    } else if (unformattedOs.contains("linux")) {
      os = "linux";
    } else {
      throw new UnsupportedOperationException(
          "Emulator is not supported on your platform: " + unformattedOs);
    }

    String unformattedArch = System.getProperty("os.arch");
    String arch;

    switch (unformattedArch) {
      case "x86":
        arch = "x86";
        break;
      case "x86_64":
      case "amd64":
        arch = "x86_64";
        break;
      default:
        throw new UnsupportedOperationException("Unsupported architecture: " + unformattedArch);
    }

    return String.format(
        "/gcloud/bigtable-%s-%s/platform/bigtable-emulator/cbtemulator%s", os, arch, suffix);
  }

  /** Gets a random open port number. */
  private static int getAvailablePort() {
    try (ServerSocket serverSocket = new ServerSocket(0)) {
      return serverSocket.getLocalPort();
    } catch (IOException e) {
      throw new RuntimeException("Failed to find open port");
    }
  }

  /** Waits for a port to open. It's used to wait for the emulator's gRPC server to be ready. */
  private static void waitForPort(int port) throws InterruptedException, TimeoutException {
    for (int i = 0; i < 100; i++) {
      try (Socket ignored = new Socket("localhost", port)) {
        return;
      } catch (IOException e) {
        Thread.sleep(200);
      }
    }

    throw new TimeoutException("Timed out waiting for server to start");
  }

  /** Creates a {@link io.grpc.ManagedChannelBuilder} preconfigured for the emulator's port. */
  private static ManagedChannelBuilder<?> newChannelBuilder(int port) {
    // NOTE: usePlaintext is currently @ExperimentalAPI.
    // See https://github.com/grpc/grpc-java/issues/1772 for discussion
    return ManagedChannelBuilder.forAddress("localhost", port).usePlaintext();
  }

  /** Creates a thread that will pipe an {@link java.io.InputStream} to this class' Logger. */
  private static void pipeStreamToLog(final InputStream stream, final Level level) {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

    Thread thread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  String line;
                  while ((line = reader.readLine()) != null) {
                    LOGGER.log(level, line);
                  }
                } catch (IOException e) {
                  if (!"Stream closed".equals(e.getMessage())) {
                    LOGGER.log(Level.WARNING, "Failed to read process stream", e);
                  }
                }
              }
            });
    thread.setDaemon(true);
    thread.start();
  }
  // </editor-fold>
}
