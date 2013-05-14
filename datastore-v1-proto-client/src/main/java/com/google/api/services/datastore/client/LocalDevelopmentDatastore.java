/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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
package com.google.api.services.datastore.client;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Preconditions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * An extension to {@link Datastore} that provides lifecycle management for a development datastore
 * server.
 *
 * In order to use a development datastore for a JUnit 4 test you might do something like this:
 *
 * <pre>
 * public class MyTest {
 *
 *   static LocalDevelopmentDatastore datastore;
 *
 *   {@literal @}BeforeClass
 *   public static void startLocalDatastore() throws LocalDevelopmentDatastoreException {
 *     DatastoreOptions opts = new DatastoreOptions.Builder()
 *         .host("http://localhost:8080")
 *         .dataset("myapp")
 *         .build();
 *     datastore = LocalDevelopmentDatastoreFactory.get().create(opts);
 *     datastore.start("/usr/local/gcdsdk", "myapp");
 *   }
 *
 *   {@literal @}Before
 *   public void setUp() throws LocalDevelopmentDatastoreException {
 *     datastore.clearDatastore();
 *   }
 *
 *   {@literal @}AfterClass
 *   public static void stopLocalDatastore() throws LocalDevelopmentDatastoreException {
 *     datastore.stopDatastore();
 *   }
 *
 *   {@literal @}Test
 *   public void testFoo1() { }

 *   {@literal @}Test
 *   public void testFoo2() { }
 *
 * }
 * </pre>
 *
 */
public class LocalDevelopmentDatastore extends Datastore {
  private static final int STARTUP_TIMEOUT_SECS = 5;

  private final String host;

  /** Internal state lifecycle management. */
  enum State {NEW, STARTED, STOPPED}

  private State state = State.NEW;

  LocalDevelopmentDatastore(RemoteRpc rpc, String host) {
    super(rpc);
    this.host = host;
  }

  /**
   * Clears all data in the Datastore.
   *
   * @throws LocalDevelopmentDatastoreException
   */
  public void clear() throws LocalDevelopmentDatastoreException {
    HttpRequestFactory client = remoteRpc.getHttpRequestFactory();
    try {
      Map<String, String> params = new HashMap<String, String>();
      params.put("action", "Clear Datastore");
      UrlEncodedContent content = new UrlEncodedContent(params);
      GenericUrl url = new GenericUrl(host + "/_ah/admin/datastore");
      HttpResponse httpResponse = client.buildPostRequest(url, content).execute();
      if (!httpResponse.isSuccessStatusCode()) {
        throw new LocalDevelopmentDatastoreException(
            "Clear Datastore returned http status " + httpResponse.getStatusCode());
      }
    } catch (IOException e) {
      throw new LocalDevelopmentDatastoreException(
          "Exception trying to clear the dev datastore", e);
    }
  }

  /**
   * Starts the local datastore. It is the caller's responsibility to call {@link #stop}. Note that
   * receiving an exception does not indicate that the server did not start. We recommend calling
   * {@link #stop} to ensure the server is not running regardless of the result of this method.
   *
   * @param sdkPath The path to the GCD SDK, eg /usr/local/dev/gcd
   * @param dataset The name of the GCD dataset
   * @param cmdLineOptions Command line options to pass to the script that launches the dev server
   * @throws LocalDevelopmentDatastoreException If {@link #start} has already been called or the
   * server does not start successfully.
   */
  public synchronized void start(String sdkPath, String dataset, String... cmdLineOptions)
      throws LocalDevelopmentDatastoreException {
    Preconditions.checkNotNull(sdkPath, "sdkPath cannot be null");
    Preconditions.checkNotNull(dataset, "dataset cannot be null");
    Preconditions.checkState(state == State.NEW, "Cannot call start() more than once.");
    try {
      startDatastoreInternal(sdkPath, dataset, cmdLineOptions);
      state = State.STARTED;
    } finally {
      if (state != State.STARTED) {
        // If we're not able to start the server we don't want people trying again. Just move it
        // straight to the STOPPED state.
        state = State.STOPPED;
      }
    }
  }

  void startDatastoreInternal(String sdkPath, String dataset, String... cmdLineOptions)
      throws LocalDevelopmentDatastoreException {
    List<String> cmd = Arrays.asList("./gcd.sh", "start", dataset, "--allow_remote_shutdown",
        "--property=datastore.no_storage");
    cmd.addAll(Arrays.asList(cmdLineOptions));
    ProcessBuilder builder = new ProcessBuilder(cmd);
    builder.directory(new File(sdkPath));
    builder.redirectErrorStream(true);
    Process devDatastoreServerProcess;
    try {
      devDatastoreServerProcess = builder.start();
    } catch (IOException e) {
      throw new LocalDevelopmentDatastoreException("Could not start dev server", e);
    }
    StartupMonitor monitor = new StartupMonitor(devDatastoreServerProcess.getInputStream());
    try {
      monitor.start();
      if (!monitor.startupCompleteLatch.await(STARTUP_TIMEOUT_SECS, TimeUnit.SECONDS)) {
        throw new LocalDevelopmentDatastoreException("Dev server did not start within 5 seconds");
      }
      if (!monitor.success) {
        throw new LocalDevelopmentDatastoreException("Server did not start normally");
      }
    } catch (InterruptedException e) {
      // not sure why this would happen
      throw new LocalDevelopmentDatastoreException("Received an interrupt", e);
    }
  }

  /**
   * Stops the local datastore. Multiple calls are allowed.
   *
   * @throws LocalDevelopmentDatastoreException
   */
  public synchronized void stop() throws LocalDevelopmentDatastoreException {
    // We intentionally don't check the internal state. If people want to try and stop the server
    // multiple times that's fine.
    stopDatastoreInternal();
    state = State.STOPPED;
  }

  void stopDatastoreInternal() throws LocalDevelopmentDatastoreException {
    // No need to kill the process we started, this function will take care of it.
    HttpRequestFactory client = remoteRpc.getHttpRequestFactory();
    Map<String, String> params = new HashMap<String, String>();
    UrlEncodedContent content = new UrlEncodedContent(params);
    GenericUrl url = new GenericUrl(host + "/_ah/admin/quit");
    try {
      HttpResponse httpResponse = client.buildPostRequest(url, content).execute();
      if (!httpResponse.isSuccessStatusCode()) {
        throw new LocalDevelopmentDatastoreException(
            "Request to shutdown local datastore returned http error code " +
                httpResponse.getStatusCode());
      }
    } catch (IOException e) {
      throw new LocalDevelopmentDatastoreException(
          "Exception trying to stop the dev datastore", e);
    }
  }

  /**
   * Monitors the provided input stream for evidence that the dev server has started successfully
   * and redirects the output of the dev server process to sysout for this process.
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
          // redirect to sysout for our process
          System.out.println(line);
          if (!success && line.contains("Dev App Server is now running")) {
            success = true;
            startupCompleteLatch.countDown();
          }
        }
      } catch (IOException ioe) {
        if (!success) {
          System.err.println("Received an IOException before the dev server startup completed. "
              + "Dev server is in an unknown state.");
        } else {
          // We got an exception after the server started successfully. We'll lose the ability
          // to log the output of the dev server but there's no need to shut anything down.
          System.err.println("Received an exception handling output from the dev server. "
              + "Logging will stop but the dev server is probably ok.");
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
}
