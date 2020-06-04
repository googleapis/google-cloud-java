/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore.testing;

import com.google.api.core.InternalApi;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.testing.BaseEmulatorHelper;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * Utility to start and stop local Google Cloud Datastore emulators.
 *
 * <p>This class is unstable.
 */
@InternalApi
public class LocalDatastoreHelper extends BaseEmulatorHelper<DatastoreOptions> {

  private final List<EmulatorRunner> emulatorRunners;
  private final double consistency;
  private final Path gcdPath;
  private boolean storeOnDisk;

  // Gcloud emulator settings
  private static final String GCLOUD_CMD_TEXT = "gcloud beta emulators datastore start";
  private static final String GCLOUD_CMD_PORT_FLAG = "--host-port=";
  private static final String VERSION_PREFIX = "cloud-datastore-emulator ";
  private static final String MIN_VERSION = "1.2.0";

  // Downloadable emulator settings
  private static final String BIN_NAME = "cloud-datastore-emulator/cloud_datastore_emulator";
  private static final String FILENAME = "cloud-datastore-emulator-" + MIN_VERSION + ".zip";
  private static final String MD5_CHECKSUM = "ec2237a0f0ac54964c6bd95e12c73720";
  private static final String BIN_CMD_PORT_FLAG = "--port=";
  private static final URL EMULATOR_URL;

  // Common settings
  private static final String CONSISTENCY_FLAG = "--consistency=";
  private static final double DEFAULT_CONSISTENCY = 0.9;

  private static final Logger LOGGER = Logger.getLogger(LocalDatastoreHelper.class.getName());

  static {
    try {
      EMULATOR_URL = new URL("http://storage.googleapis.com/gcd/tools/" + FILENAME);
    } catch (MalformedURLException ex) {
      throw new IllegalStateException(ex);
    }
  }

  /** A builder for {@code LocalDatastoreHelper} objects. */
  public static class Builder {
    private double consistency;
    private int port;
    private Path dataDir;
    private boolean storeOnDisk = true;

    private Builder() {}

    private Builder(LocalDatastoreHelper helper) {
      this.consistency = helper.consistency;
      this.dataDir = helper.gcdPath;
      this.storeOnDisk = helper.storeOnDisk;
    }

    public Builder setConsistency(double consistency) {
      this.consistency = consistency;
      return this;
    }

    public Builder setPort(int port) {
      this.port = port;
      return this;
    }

    public Builder setDataDir(Path dataDir) {
      this.dataDir = dataDir;
      return this;
    }

    public Builder setStoreOnDisk(boolean storeOnDisk) {
      this.storeOnDisk = storeOnDisk;
      return this;
    }

    /** Creates a {@code LocalDatastoreHelper} object. */
    public LocalDatastoreHelper build() {
      return new LocalDatastoreHelper(this);
    }
  }

  private LocalDatastoreHelper(Builder builder) {
    super(
        "datastore",
        builder.port > 0 ? builder.port : BaseEmulatorHelper.findAvailablePort(DEFAULT_PORT),
        PROJECT_ID_PREFIX + UUID.randomUUID().toString());
    this.consistency = builder.consistency > 0 ? builder.consistency : DEFAULT_CONSISTENCY;
    this.gcdPath = builder.dataDir;
    this.storeOnDisk = builder.storeOnDisk;
    String binName = BIN_NAME;
    if (isWindows()) {
      binName = BIN_NAME.replace("/", "\\");
    }
    List<String> gcloudCommand = new ArrayList<>(Arrays.asList(GCLOUD_CMD_TEXT.split(" ")));
    gcloudCommand.add(GCLOUD_CMD_PORT_FLAG + "localhost:" + getPort());
    gcloudCommand.add(CONSISTENCY_FLAG + builder.consistency);
    if (!builder.storeOnDisk) {
      gcloudCommand.add("--no-store-on-disk");
    }
    GcloudEmulatorRunner gcloudRunner =
        new GcloudEmulatorRunner(gcloudCommand, VERSION_PREFIX, MIN_VERSION);
    List<String> binCommand = new ArrayList<>(Arrays.asList(binName, "start"));
    binCommand.add("--testing");
    binCommand.add(BIN_CMD_PORT_FLAG + getPort());
    binCommand.add(CONSISTENCY_FLAG + getConsistency());
    if (builder.dataDir != null) {
      gcloudCommand.add("--data-dir=" + getGcdPath());
    }
    DownloadableEmulatorRunner downloadRunner =
        new DownloadableEmulatorRunner(binCommand, EMULATOR_URL, MD5_CHECKSUM);
    this.emulatorRunners = ImmutableList.of(gcloudRunner, downloadRunner);
  }

  /** Returns a builder for {@code LocalDatastoreHelper} object. */
  public LocalDatastoreHelper.Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a builder for {@code LocalDatastoreHelper} object. */
  public static LocalDatastoreHelper.Builder newBuilder() {
    return new LocalDatastoreHelper.Builder();
  }

  @Override
  protected List<EmulatorRunner> getEmulatorRunners() {
    return emulatorRunners;
  }

  @Override
  protected Logger getLogger() {
    return LOGGER;
  }

  private DatastoreOptions.Builder optionsBuilder() {
    return DatastoreOptions.newBuilder()
        .setProjectId(getProjectId())
        .setHost(DEFAULT_HOST + ":" + Integer.toString(getPort()))
        .setCredentials(NoCredentials.getInstance())
        .setRetrySettings(ServiceOptions.getNoRetrySettings());
  }

  /**
   * Returns a {@link DatastoreOptions} instance that sets the host to use the Datastore emulator on
   * localhost.
   */
  @Override
  public DatastoreOptions getOptions() {
    return optionsBuilder().build();
  }

  /**
   * Returns a {@link DatastoreOptions} instance that sets the host to use the Datastore emulator on
   * localhost. The default namespace is set to {@code namespace}.
   */
  public DatastoreOptions getOptions(String namespace) {
    return optionsBuilder().setNamespace(namespace).build();
  }

  /** Returns the consistency setting for the local Datastore emulator. */
  public double getConsistency() {
    return consistency;
  }

  /** Returns the data directory path of the local Datastore emulator. */
  public Path getGcdPath() {
    return gcdPath;
  }

  /** Returns {@code true} data persist on disk, otherwise {@code false} data not store on disk. */
  public boolean isStoreOnDisk() {
    return storeOnDisk;
  }

  /**
   * Creates a local Datastore helper with the specified settings for project ID and consistency.
   *
   * @param consistency the fraction of Datastore writes that are immediately visible to global
   *     queries, with 0.0 meaning no writes are immediately visible and 1.0 meaning all writes are
   *     immediately visible. Note that setting this to 1.0 may mask incorrect assumptions about the
   *     consistency of non-ancestor queries; non-ancestor queries are eventually consistent.
   */
  public static LocalDatastoreHelper create(double consistency) {
    return LocalDatastoreHelper.newBuilder().setConsistency(consistency).setPort(0).build();
  }

  /**
   * Creates a local Datastore helper with the specified settings for project ID and consistency.
   *
   * @param consistency the fraction of Datastore writes that are immediately visible to global
   *     queries, with 0.0 meaning no writes are immediately visible and 1.0 meaning all writes are
   *     immediately visible. Note that setting this to 1.0 may mask incorrect assumptions about the
   *     consistency of non-ancestor queries; non-ancestor queries are eventually consistent.
   * @param port the port to be used to start the emulator service. Note that setting this to 0 the
   *     emulator will search for a free random port.
   */
  public static LocalDatastoreHelper create(double consistency, int port) {
    return LocalDatastoreHelper.newBuilder().setConsistency(consistency).setPort(port).build();
  }

  /**
   * Creates a local Datastore helper with a placeholder project ID and the default consistency
   * setting of 0.9.
   *
   * @param port the port to be used to start the emulator service. Note that setting this to 0 the
   *     emulator will search for a free random port.
   */
  public static LocalDatastoreHelper create(int port) {
    return LocalDatastoreHelper.newBuilder()
        .setConsistency(DEFAULT_CONSISTENCY)
        .setPort(port)
        .build();
  }

  /**
   * Creates a local Datastore helper with a placeholder project ID and the default consistency
   * setting of 0.9. Consistency refers to the fraction of Datastore writes that are immediately
   * visible to global queries, with 0.0 meaning no writes are immediately visible and 1.0 meaning
   * all writes are immediately visible.
   */
  public static LocalDatastoreHelper create() {
    return LocalDatastoreHelper.newBuilder().setConsistency(DEFAULT_CONSISTENCY).build();
  }

  /**
   * Starts the local Datastore emulator through {@code gcloud}, downloads and caches the zip file
   * if user does not have {@code gcloud} or a compatible emulator version installed.
   *
   * <p>Currently the emulator does not persist any state across runs.
   */
  @Override
  public void start() throws IOException, InterruptedException {
    String blockUntilOutput = "Dev App Server is now running";
    startProcess(blockUntilOutput);
  }

  /**
   * Resets the internal state of the Datastore emulator.
   *
   * <p>When running tests, one might {@code reset()} before each test, so earlier tests would not
   * affect later ones.
   */
  @Override
  public void reset() throws IOException {
    sendPostRequest("/reset");
  }

  /**
   * Stops the Datastore emulator.
   *
   * <p>It is important to stop the emulator. Since the emulator runs in its own process, not
   * stopping it might cause it to become orphan.
   *
   * <p>It is not required to call {@link #reset()} before {@code stop}.
   *
   * @param timeout The duration to wait for the emulator process to stop. It is recommended to set
   *     this value high to ensure proper shutdown, like 5 seconds or more.
   */
  @Override
  public void stop(Duration timeout) throws IOException, InterruptedException, TimeoutException {
    sendPostRequest("/shutdown");
    waitForProcess(timeout);
    deleteRecursively(gcdPath);
  }

  /**
   * Stops the Datastore emulator. The same as {@link #stop(Duration)} but with timeout duration of
   * 20 seconds.
   *
   * <p>It is important to stop the emulator. Since the emulator runs in its own process, not
   * stopping it might cause it to become orphan.
   *
   * <p>It is not required to call {@link #reset()} before {@code stop()}.
   */
  public void stop() throws IOException, InterruptedException, TimeoutException {
    stop(Duration.ofSeconds(20));
  }

  static void deleteRecursively(Path path) throws IOException {
    if (path == null || !Files.exists(path)) {
      return;
    }
    Files.walkFileTree(
        path,
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            Files.delete(file);
            return FileVisitResult.CONTINUE;
          }
        });
  }
}
