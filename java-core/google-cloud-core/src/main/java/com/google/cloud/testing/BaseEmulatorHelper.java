/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.testing;

import com.google.api.core.CurrentMillisClock;
import com.google.api.core.InternalApi;
import com.google.cloud.ExceptionHandler;
import com.google.cloud.RetryHelper;
import com.google.cloud.ServiceOptions;
import com.google.common.io.CharStreams;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.threeten.bp.Duration;

/** Utility class to start and stop a local service which is used by unit testing. */
@InternalApi
public abstract class BaseEmulatorHelper<T extends ServiceOptions> {

  private final String emulator;
  private final int port;
  private final String projectId;
  private EmulatorRunner activeRunner;
  private BlockingProcessStreamReader blockingProcessReader;

  protected static final String PROJECT_ID_PREFIX = "test-project-";
  protected static final String DEFAULT_HOST = "localhost";
  protected static final int DEFAULT_PORT = 8080;

  @InternalApi("This class should only be extended within google-cloud-java")
  protected BaseEmulatorHelper(String emulator, int port, String projectId) {
    this.emulator = emulator;
    this.port = port > 0 ? port : DEFAULT_PORT;
    this.projectId = projectId;
  }

  /**
   * Returns the emulator runners supported by this emulator. Runners are evaluated in order, the
   * first available runner is selected and executed
   */
  protected abstract List<EmulatorRunner> getEmulatorRunners();

  /** Returns a logger. */
  protected abstract Logger getLogger();

  /**
   * Starts the local service as a subprocess. Blocks the execution until {@code blockUntilOutput}
   * is found on stdout.
   */
  protected final void startProcess(String blockUntilOutput)
      throws IOException, InterruptedException {
    for (EmulatorRunner runner : getEmulatorRunners()) {
      // Iterate through all emulator runners until find first available runner.
      if (runner.isAvailable()) {
        activeRunner = runner;
        runner.start();
        break;
      }
    }
    if (activeRunner != null) {
      blockingProcessReader =
          BlockingProcessStreamReader.start(
              emulator, activeRunner.getProcess().getInputStream(), blockUntilOutput, getLogger());
    } else {
      // No available runner found.
      throw new IOException("No available emulator runner is found.");
    }
  }

  /**
   * Waits for the local service's subprocess to terminate, and stop any possible thread listening
   * for its output.
   */
  protected final int waitForProcess(Duration timeout)
      throws IOException, InterruptedException, TimeoutException {
    if (activeRunner != null) {
      int exitCode = activeRunner.waitFor(timeout);
      activeRunner = null;
      return exitCode;
    }
    if (blockingProcessReader != null) {
      blockingProcessReader.join();
      blockingProcessReader = null;
    }
    return 0;
  }

  private static int waitForProcess(final Process process, Duration timeout)
      throws InterruptedException, TimeoutException {
    if (process == null) {
      return 0;
    }

    final SettableFuture<Integer> exitValue = SettableFuture.create();

    Thread waiter =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  exitValue.set(process.waitFor());
                } catch (InterruptedException e) {
                  exitValue.setException(e);
                }
              }
            });
    waiter.start();

    try {
      return exitValue.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
    } catch (ExecutionException e) {
      if (e.getCause() instanceof InterruptedException) {
        throw (InterruptedException) e.getCause();
      }
      throw new UncheckedExecutionException(e);
    } finally {
      waiter.interrupt();
    }
  }

  /** Returns the port to which the local emulator is listening. */
  public int getPort() {
    return port;
  }

  /** Returns the project ID associated with the local emulator. */
  public String getProjectId() {
    return projectId;
  }

  /** Returns service options to access the local emulator. */
  public abstract T getOptions();

  /** Starts the local emulator. */
  public abstract void start() throws IOException, InterruptedException;

  /** Stops the local emulator. */
  public abstract void stop(Duration timeout)
      throws IOException, InterruptedException, TimeoutException;

  /** Resets the internal state of the emulator. */
  public abstract void reset() throws IOException;

  protected final String sendPostRequest(String request) throws IOException {
    URL url = new URL("http", DEFAULT_HOST, this.port, request);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput(true);
    OutputStream out = con.getOutputStream();
    out.write("".getBytes());
    out.flush();

    InputStream in = con.getInputStream();
    String response = CharStreams.toString(new InputStreamReader(con.getInputStream()));
    in.close();
    return response;
  }

  protected static int findAvailablePort(int defaultPort) {
    try (ServerSocket tempSocket = new ServerSocket(0)) {
      return tempSocket.getLocalPort();
    } catch (IOException e) {
      return defaultPort;
    }
  }

  protected static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("windows");
  }

  /** Utility interface to start and run an emulator. */
  protected interface EmulatorRunner {

    /**
     * Returns {@code true} if the emulator associated to this runner is available and can be
     * started.
     */
    boolean isAvailable();

    /** Starts the emulator associated to this runner. */
    void start() throws IOException;

    /** Wait for the emulator associated to this runner to terminate, returning the exit status. */
    int waitFor(Duration timeout) throws InterruptedException, TimeoutException;

    /** Returns the process associated to the emulator, if any. */
    Process getProcess();
  }

  /** Utility class to start and run an emulator from the Google Cloud SDK. */
  protected static class GcloudEmulatorRunner implements EmulatorRunner {

    private final List<String> commandText;
    private final String versionPrefix;
    private final Version minVersion;
    private Process process;
    private static final Logger log = Logger.getLogger(GcloudEmulatorRunner.class.getName());

    public GcloudEmulatorRunner(List<String> commandText, String versionPrefix, String minVersion) {
      this.commandText = commandText;
      this.versionPrefix = versionPrefix;
      this.minVersion = Version.fromString(minVersion);
    }

    @Override
    public boolean isAvailable() {
      try {
        return isGcloudInstalled() && isEmulatorUpToDate() && !commandText.isEmpty();
      } catch (IOException | InterruptedException e) {
        e.printStackTrace(System.err);
      }
      return false;
    }

    @Override
    public void start() throws IOException {
      log.fine("Starting emulator via Google Cloud SDK");
      process = CommandWrapper.create().setCommand(commandText).setRedirectErrorStream().start();
    }

    @Override
    public int waitFor(Duration timeout) throws InterruptedException, TimeoutException {
      return waitForProcess(process, timeout);
    }

    @Override
    public Process getProcess() {
      return process;
    }

    private boolean isGcloudInstalled() {
      String path = System.getenv("PATH");
      return path != null && path.contains("google-cloud-sdk");
    }

    private boolean isEmulatorUpToDate() throws IOException, InterruptedException {
      Version currentVersion = getInstalledEmulatorVersion(versionPrefix);
      return currentVersion != null && currentVersion.compareTo(minVersion) >= 0;
    }

    private Version getInstalledEmulatorVersion(String versionPrefix)
        throws IOException, InterruptedException {
      Process process =
          CommandWrapper.create()
              .setCommand(Arrays.asList("gcloud", "version"))
              // gcloud redirects all output to stderr while emulators' executables use either
              // stdout or stderr with no apparent convention. To be able to properly intercept and
              // block waiting for emulators to be ready we redirect everything to stdout
              .setRedirectErrorStream()
              .start();
      process.waitFor();
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
          if (line.startsWith(versionPrefix)) {
            String[] lineComponents = line.split(" ");
            if (lineComponents.length > 1) {
              return Version.fromString(lineComponents[1]);
            }
          }
        }
        return null;
      }
    }
  }

  /** Utility class to start and run an emulator from a download URL. */
  protected static class DownloadableEmulatorRunner implements EmulatorRunner {

    private final List<String> commandText;
    private final String md5CheckSum;
    private final URL downloadUrl;
    private final String fileName;
    private Process process;
    private static final Logger log = Logger.getLogger(DownloadableEmulatorRunner.class.getName());

    public DownloadableEmulatorRunner(
        List<String> commandText, URL downloadUrl, String md5CheckSum) {
      this.commandText = commandText;
      this.md5CheckSum = md5CheckSum;
      this.downloadUrl = downloadUrl;
      String[] splitUrl = downloadUrl.toString().split("/");
      this.fileName = splitUrl[splitUrl.length - 1];
    }

    @Override
    public boolean isAvailable() {
      try {
        downloadZipFile();
        return true;
      } catch (IOException e) {
        return false;
      }
    }

    @Override
    public void start() throws IOException {
      ExceptionHandler retryOnAnythingExceptionHandler =
          ExceptionHandler.newBuilder().retryOn(Exception.class).build();

      Path emulatorPath =
          RetryHelper.runWithRetries(
              new Callable<Path>() {
                @Override
                public Path call() throws IOException {
                  return downloadEmulator();
                }
              },
              ServiceOptions.getDefaultRetrySettings(),
              retryOnAnythingExceptionHandler,
              CurrentMillisClock.getDefaultClock());
      process =
          CommandWrapper.create()
              .setCommand(commandText)
              .setDirectory(emulatorPath)
              // gcloud redirects all output to stderr while emulators' executables use either
              // stdout
              // or stderr with no apparent convention. To be able to properly intercept and block
              // waiting for emulators to be ready we redirect everything to stdout
              .setRedirectErrorStream()
              .start();
    }

    @Override
    public int waitFor(Duration timeout) throws InterruptedException, TimeoutException {
      return waitForProcess(process, timeout);
    }

    @Override
    public Process getProcess() {
      return process;
    }

    private Path downloadEmulator() throws IOException {
      // Retrieve the file name from the download link
      String[] splittedUrl = downloadUrl.toString().split("/");
      String fileName = splittedUrl[splittedUrl.length - 1];

      // Each run is associated with its own folder that is deleted once test completes.
      Path emulatorPath = Files.createTempDirectory(fileName.split("\\.")[0]);
      File emulatorFolder = emulatorPath.toFile();
      emulatorFolder.deleteOnExit();

      File zipFile = downloadZipFile();
      // Unzip the emulator
      try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile))) {
        if (log.isLoggable(Level.FINE)) {
          log.fine("Unzipping emulator");
        }
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
          File filePath = new File(emulatorFolder, entry.getName());
          String canonicalEmulatorFolderPath = emulatorFolder.getCanonicalPath();
          String canonicalFilePath = filePath.getCanonicalPath();
          if (!canonicalFilePath.startsWith(canonicalEmulatorFolderPath + File.separator)) {
            throw new IllegalStateException(
                "Entry is outside of the target dir: " + entry.getName());
          }
          if (!entry.isDirectory()) {
            extractFile(zipIn, filePath);
          } else {
            filePath.mkdir();
          }
          zipIn.closeEntry();
          entry = zipIn.getNextEntry();
        }
      }
      return emulatorPath;
    }

    private File downloadZipFile() throws IOException {
      // Check if we already have a local copy of the emulator and download it if not.
      File zipFile = new File(System.getProperty("java.io.tmpdir"), fileName);
      if (!zipFile.exists() || (md5CheckSum != null && !md5CheckSum.equals(md5(zipFile)))) {
        if (log.isLoggable(Level.FINE)) {
          log.fine("Fetching emulator");
        }
        ReadableByteChannel rbc = Channels.newChannel(downloadUrl.openStream());
        try (FileOutputStream fos = new FileOutputStream(zipFile)) {
          fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
      } else {
        if (log.isLoggable(Level.FINE)) {
          log.fine("Using cached emulator");
        }
      }
      return zipFile;
    }

    private void extractFile(ZipInputStream zipIn, File filePath) throws IOException {
      try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
        byte[] bytesIn = new byte[1024];
        int read;
        while ((read = zipIn.read(bytesIn)) != -1) {
          bos.write(bytesIn, 0, read);
        }
      }
    }

    private static String md5(File zipFile) throws IOException {
      try {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        try (InputStream is = new BufferedInputStream(new FileInputStream(zipFile))) {
          byte[] bytes = new byte[4 * 1024 * 1024];
          int len;
          while ((len = is.read(bytes)) >= 0) {
            md5.update(bytes, 0, len);
          }
        }
        return String.format("%032x", new BigInteger(1, md5.digest()));
      } catch (NoSuchAlgorithmException e) {
        throw new IOException(e);
      }
    }
  }
}
