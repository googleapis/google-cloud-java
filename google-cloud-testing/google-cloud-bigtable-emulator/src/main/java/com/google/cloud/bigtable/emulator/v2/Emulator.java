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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Path;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@BetaApi("Surface for Bigtable emulator is not yet stable")
public class Emulator {

  private static final Logger LOGGER = Logger.getLogger(Emulator.class.getName());

  private final Path executable;
  private Process process;
  private boolean isStopped = true;

  private int port;
  private ManagedChannel dataChannel;
  private ManagedChannel adminChannel;

  public static Emulator createBundled() throws IOException {
    String resourcePath = String.format(
        "gcloud/bigtable-%s/platform/bigtable-emulator/cbtemulator", getPlatform());

    URL packagedEmulator = Emulator.class.getResource(resourcePath);

    File tmpEmulator = File.createTempFile("cbtemulator", "");
    tmpEmulator.deleteOnExit();

    try (InputStream is = packagedEmulator.openStream();
        FileOutputStream os = new FileOutputStream(tmpEmulator)) {

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

  public void start() throws Exception {
    this.port = getAvailablePort();

    process = Runtime.getRuntime().exec(executable + " -port " + "" + port);
    pipeStreamToLog(process.getInputStream(), Level.INFO);
    pipeStreamToLog(process.getErrorStream(), Level.WARNING);
    isStopped = false;

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        if (!isStopped) {
          isStopped = true;
          process.destroy();
        }
      }
    });

    waitForPort(port);

    dataChannel = newChannelBuilder(port)
        .maxInboundMessageSize(256 * 1024 * 1024)
        .build();

    adminChannel = newChannelBuilder(port)
        .build();
  }

  public void stop() {
    try {
      dataChannel.shutdownNow();
      adminChannel.shutdownNow();

      dataChannel.awaitTermination(1, TimeUnit.MINUTES);
      adminChannel.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      LOGGER.warning("Interrupted while waiting for client channels to close");
      Thread.currentThread().interrupt();
    } finally {
      isStopped = true;
      process.destroy();
    }
  }

  public int getPort() {
    return port;
  }

  public ManagedChannel getDataChannel() {
    return dataChannel;
  }

  public ManagedChannel getAdminChannel() {
    return adminChannel;
  }

  // <editor-fold desc="Helpers">
  private static String getPlatform() {
    String unformattedOs = System.getProperty("os.name", "unknown").toLowerCase(Locale.ENGLISH);
    String os;

    if ((unformattedOs.indexOf("mac") >= 0) || (unformattedOs.indexOf("darwin") >= 0)) {
      os = "darwin";
    } else if (unformattedOs.indexOf("win") >= 0) {
      os = "windows";
    } else if (unformattedOs.indexOf("linux") >= 0) {
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
      case "xmd64":
        arch = "x86_64";
        break;
      default:
        throw new UnsupportedOperationException("Unsupport architecture: " + unformattedArch);
    }

    return os + "-" + arch;
  }

  private static int getAvailablePort() {
    try (ServerSocket serverSocket = new ServerSocket(0)) {
      return serverSocket.getLocalPort();
    } catch (IOException e) {
      throw new RuntimeException("Failed to find open port");
    }
  }

  private void waitForPort(int port) throws InterruptedException, TimeoutException {
    for (int i = 0; i < 100; i++) {
      try (Socket ignored = new Socket("localhost", port)) {
        return;
      } catch (IOException e) {
        Thread.sleep(200);
      }
    }

    throw new TimeoutException("Timed out waiting for server to start");
  }

  private ManagedChannelBuilder<?> newChannelBuilder(int port) {
    // NOTE: usePlaintext is currently @ExperimentalAPI.
    // See https://github.com/grpc/grpc-java/issues/1772 for discussion
    return ManagedChannelBuilder.forAddress("localhost", port)
        .usePlaintext();
  }

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
                  LOGGER.log(Level.WARNING, "Failed to read process stream", e);
                }
              }
            });
    thread.setDaemon(true);
    thread.start();
  }
  // </editor-fold>
}