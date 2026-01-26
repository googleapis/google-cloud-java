/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.api.client.util.Preconditions.checkState;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * An extension to {@link Datastore} that provides lifecycle management for a datastore emulator.
 *
 * <p>In order to use the emulator for a JUnit 4 test you might do something like this:
 *
 * <pre>
 * public class MyTest {
 *
 *   static DatastoreEmulator datastore;
 *
 *   {@literal @}BeforeClass
 *   public static void startEmulator() throws DatastoreEmulatorException {
 *     DatastoreOptions options = new DatastoreOptions.Builder()
 *         .localHost("localhost:8080")
 *         .projectId("my-project-id")
 *         .build();
 *     datastore = DatastoreEmulatorFactory.get().create(options);
 *     datastore.start("/usr/local/cloud-datastore-emulator", "my-project-id");
 *   }
 *
 *   {@literal @}Before
 *   public void setUp() throws DatastoreEmulatorException {
 *     datastore.clear();
 *   }
 *
 *   {@literal @}AfterClass
 *   public static void stopEmulator() throws DatastoreEmulatorException {
 *     datastore.stop();
 *   }
 *
 *   {@literal @}Test
 *   public void testFoo1() { }
 *
 *   {@literal @}Test
 *   public void testFoo2() { }
 *
 * }
 * </pre>
 */
public class DatastoreEmulator extends Datastore {
  private static final int STARTUP_TIMEOUT_SECS = 30;

  private final String host;
  private final DatastoreEmulatorOptions options;

  /** Internal state lifecycle management. */
  enum State {
    NEW,
    STARTED,
    STOPPED
  }

  private volatile State state = State.NEW;

  private File projectDirectory;

  DatastoreEmulator(RemoteRpc rpc, String localHost, DatastoreEmulatorOptions options) {
    super(rpc);
    this.host = "http://" + localHost;
    this.options = options;
  }

  /**
   * Clears all data in the emulator.
   *
   * @throws DatastoreEmulatorException if the clear fails
   */
  public void clear() throws DatastoreEmulatorException {
    sendEmptyRequest("/reset", "POST");
  }

  /**
   * Starts the emulator. It is the caller's responsibility to call {@link #stop}. Note that
   * receiving an exception does not indicate that the server did not start. We recommend calling
   * {@link #stop} to ensure the server is not running regardless of the result of this method.
   *
   * @param emulatorDir The path to the emulator directory, e.g. /usr/local/cloud-datastore-emulator
   * @param projectId The project ID
   * @param commandLineOptions Command line options to pass to the emulator on startup
   * @throws DatastoreEmulatorException If {@link #start} has already been called or the server does
   *     not start successfully.
   * @deprecated prefer setting options in the emulator options and calling {#start()}.
   */
  @Deprecated
  public synchronized void start(String emulatorDir, String projectId, String... commandLineOptions)
      throws DatastoreEmulatorException {
    checkNotNull(emulatorDir, "emulatorDir cannot be null");
    checkNotNull(projectId, "projectId cannot be null");
    checkState(state == State.NEW, "Cannot call start() more than once.");
    try {
      startEmulatorInternal(
          emulatorDir + "/cloud_datastore_emulator", projectId, Arrays.asList(commandLineOptions));
      state = State.STARTED;
    } finally {
      if (state != State.STARTED) {
        // If we're not able to start the server we don't want people trying again. Just move it
        // straight to the STOPPED state.
        state = State.STOPPED;
      }
    }
  }

  public synchronized void start() throws DatastoreEmulatorException {
    checkState(state == State.NEW, "Cannot call start() more than once.");
    try {
      startEmulatorInternal(options.getCmd(), options.getProjectId(), options.getCmdLineOptions());
      state = State.STARTED;
    } finally {
      if (state != State.STARTED) {
        // If we're not able to start the server we don't want people trying again. Just move it
        // straight to the STOPPED state.
        state = State.STOPPED;
      }
    }
  }

  void startEmulatorInternal(String emulatorCmd, String projectId, List<String> commandLineOptions)
      throws DatastoreEmulatorException {
    projectDirectory = createProjectDirectory(emulatorCmd, projectId);
    List<String> cmd = new ArrayList<>(Arrays.asList(emulatorCmd, "start", "--testing"));
    cmd.addAll(commandLineOptions);
    cmd.add(projectDirectory.getPath());
    final Process emulatorStartProcess;
    try {
      emulatorStartProcess = newEmulatorProcess(cmd).start();
    } catch (IOException e) {
      throw new DatastoreEmulatorException("Could not start emulator", e);
    }
    // Ensure we don't leak the emulator instance if tests end prematurely.
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread() {
              @Override
              public void run() {
                emulatorStartProcess.destroy();
              }
            });
    StartupMonitor monitor = new StartupMonitor(emulatorStartProcess.getInputStream());
    try {
      monitor.start();
      if (!monitor.startupCompleteLatch.await(STARTUP_TIMEOUT_SECS, TimeUnit.SECONDS)) {
        throw new DatastoreEmulatorException("Emulator did not start within 30 seconds");
      }
      if (!monitor.success) {
        throw new DatastoreEmulatorException("Emulator did not start normally");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new DatastoreEmulatorException("Received an interrupt", e);
    }
  }

  private File createProjectDirectory(String emulatorCmd, String projectId)
      throws DatastoreEmulatorException {
    File projectDirectory;
    try {
      projectDirectory = Files.createTempDirectory("datastore-emulator").toFile();
    } catch (IOException e) {
      throw new DatastoreEmulatorException("Could not create temporary project directory", e);
    }
    List<String> cmd =
        Arrays.asList(
            emulatorCmd, "create", "--project_id=" + projectId, projectDirectory.getPath());
    try {
      int retCode = newEmulatorProcess(cmd).start().waitFor();
      if (retCode != 0) {
        throw new DatastoreEmulatorException(
            String.format("Could not create project (retcode=%d)", retCode));
      }
    } catch (IOException e) {
      throw new DatastoreEmulatorException("Could not create project", e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new DatastoreEmulatorException("Received an interrupt", e);
    }
    return projectDirectory;
  }

  private ProcessBuilder newEmulatorProcess(List<String> cmd) {
    ProcessBuilder builder = new ProcessBuilder(cmd);
    builder.redirectErrorStream(true);
    builder.environment().putAll(options.getEnvVars());
    return builder;
  }

  /**
   * Stops the emulator. Multiple calls are allowed.
   *
   * @throws DatastoreEmulatorException if the emulator cannot be stopped
   */
  public synchronized void stop() throws DatastoreEmulatorException {
    // We intentionally don't check the internal state. If people want to try and stop the server
    // multiple times that's fine.
    stopEmulatorInternal();
    if (state != State.STOPPED) {
      state = State.STOPPED;
      if (projectDirectory != null) {
        try {
          Process process =
              new ProcessBuilder("rm", "-r", projectDirectory.getAbsolutePath()).start();
          if (process.waitFor() != 0) {
            throw new IOException(
                "Temporary project directory deletion exited with " + process.exitValue());
          }
        } catch (IOException e) {
          throw new IllegalStateException("Could not delete temporary project directory", e);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IllegalStateException("Could not delete temporary project directory", e);
        }
      }
    }
  }

  protected void stopEmulatorInternal() throws DatastoreEmulatorException {
    sendEmptyRequest("/shutdown", "POST");
  }

  public synchronized File getProjectDirectory() {
    checkState(state == State.STARTED);
    return projectDirectory;
  }

  /**
   * Monitors the provided input stream for evidence that the emulator has started successfully and
   * redirects the output of the emulator process to sysout for this process.
   */
  static class StartupMonitor extends Thread {
    private final InputStream inputStream;
    private volatile boolean success = false;

    /** This latch will reach 0 once server startup has completed. */
    private final CountDownLatch startupCompleteLatch = new CountDownLatch(1);

    StartupMonitor(InputStream inputStream) {
      this.inputStream = inputStream;
      setDaemon(true);
    }

    @Override
    public void run() {
      try {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
          // Redirect to sysout for our process.
          System.out.println(line);
          // TODO(pcostello): Just make a request to "/" and look for an HTTP 200.
          if (!success && line.contains("Dev App Server is now running")) {
            success = true;
            startupCompleteLatch.countDown();
          }
        }
      } catch (IOException ioe) {
        if (!success) {
          System.err.println(
              "Received an IOException before emulator startup completed. "
                  + "Emulator is in an unknown state.");
        } else {
          // We got an exception after the server started successfully. We'll lose the ability
          // to log the output of the emulator but there's no need to shut anything down.
          System.err.println(
              "Received an exception handling output from the emulator. "
                  + "Logging will stop but the emulator is probably ok.");
        }
        ioe.printStackTrace();
      } finally {
        if (!success) {
          // Either the stream is closed (indicates server shut down) or we received an Exception
          // while processing the stream contents. Either way we can tell the calling thread to stop
          // waiting.
          startupCompleteLatch.countDown();
        }
      }
    }
  }

  /** Send an empty request using a standard HTTP connection. */
  private void sendEmptyRequest(String path, String method) throws DatastoreEmulatorException {
    HttpURLConnection connection = null;
    try {
      URL url = new URL(this.host + path);
      connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setRequestMethod(method);
      connection.getOutputStream().close();
      if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
        throw new DatastoreEmulatorException(
            String.format(
                "%s request to %s returned HTTP status %s",
                method, path, connection.getResponseCode()));
      }
    } catch (IOException e) {
      throw new DatastoreEmulatorException(
          String.format("Exception connecting to emulator on %s request to %s", method, path), e);
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }
}
