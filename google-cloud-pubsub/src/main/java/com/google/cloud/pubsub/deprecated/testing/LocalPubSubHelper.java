/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub.deprecated.testing;

import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.deprecated.PubSubOptions;
import com.google.cloud.testing.BaseEmulatorHelper;
import com.google.common.collect.ImmutableList;
import io.grpc.ManagedChannel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.joda.time.Duration;

/**
 * A class that runs a Pubsub emulator instance for use in tests.
 */
public class LocalPubSubHelper extends BaseEmulatorHelper<PubSubOptions> {

  private final List<EmulatorRunner> emulatorRunners;

  // Gcloud emulator settings
  private static final String GCLOUD_CMD_TEXT = "gcloud beta emulators pubsub start";
  private static final String GCLOUD_CMD_PORT_FLAG = "--host-port=";
  private static final String VERSION_PREFIX = "pubsub-emulator";
  private static final String MIN_VERSION = "2016.01.13";
  private static final String BIN_CMD_PORT_FLAG = "--port=";

  // Downloadable emulator settings
  private static final String FILENAME = "pubsub-emulator-20160113-2.zip";
  private static final String BIN_NAME = "pubsub-emulator/bin/cloud-pubsub-fake";
  private static final String MD5_CHECKSUM = "20943e9defa300f2de101568459c133d";
  private static final URL EMULATOR_URL;

  private static final Logger LOGGER = Logger.getLogger(LocalPubSubHelper.class.getName());

  static {
    try {
      EMULATOR_URL = new URL("http://storage.googleapis.com/pubsub/tools/" + FILENAME);
    } catch (MalformedURLException ex) {
      throw new IllegalStateException(ex);
    }
  }

  private LocalPubSubHelper() {
    super("pubsub", BaseEmulatorHelper.findAvailablePort(DEFAULT_PORT),
        PROJECT_ID_PREFIX + UUID.randomUUID().toString());
    String binName = BIN_NAME;
    if (isWindows()) {
      binName = BIN_NAME.replace("/", "\\");
    }
    List<String> gcloudCommand = new ArrayList<>(Arrays.asList(GCLOUD_CMD_TEXT.split(" ")));
    gcloudCommand.add(GCLOUD_CMD_PORT_FLAG + "localhost:" + getPort());
    GcloudEmulatorRunner gcloudRunner =
        new GcloudEmulatorRunner(gcloudCommand, VERSION_PREFIX, MIN_VERSION);
    DownloadableEmulatorRunner downloadRunner =
        new DownloadableEmulatorRunner(Arrays.asList(binName, BIN_CMD_PORT_FLAG + getPort()),
            EMULATOR_URL, MD5_CHECKSUM);
    emulatorRunners = ImmutableList.of(gcloudRunner, downloadRunner);
  }

  @Override
  protected List<EmulatorRunner> getEmulatorRunners() {
    return emulatorRunners;
  }

  @Override
  protected Logger getLogger() {
    return LOGGER;
  }

  /**
   * Creates a channel for making requests to the in-memory service.
   */
  public ManagedChannel createChannel() {
    return NettyChannelBuilder.forAddress(DEFAULT_HOST, getPort())
        .negotiationType(NegotiationType.PLAINTEXT)
        .build();
  }

  /**
   * Returns a {@link PubSubOptions} instance that sets the host to use the PubSub emulator on
   * localhost.
   */
  @Override
  public PubSubOptions getOptions() {
    return PubSubOptions.newBuilder()
        .setProjectId(getProjectId())
        .setHost(DEFAULT_HOST + ":" + getPort())
        .setCredentials(NoCredentials.getInstance())
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
  }

  /**
   * Constructs a new {@code LocalPubSubHelper}. The method {@code start()} must be called before it
   * is used.
   */
  public static LocalPubSubHelper create() {
    return new LocalPubSubHelper();
  }

  /**
   * Starts the local PubSub emulator through {@code gcloud}, downloads and caches the zip file
   * if user does not have {@code gcloud} or a compatible emulator version installed.
   */
  public void start() throws IOException, InterruptedException {
    String blockUntilOutput = "Server started, listening on " + getPort();
    startProcess(blockUntilOutput);
  }

  /**
   * Reset the internal state of the PubSub emulator.
   */
  @Override
  public void reset() throws IOException {
    sendPostRequest("/reset");
  }

  /**
   * Stops the PubSub emulator and related local service.
   */
  @Override
  public void stop(Duration timeout) throws IOException, InterruptedException, TimeoutException {
    sendPostRequest("/shutdown");
    waitForProcess(timeout);
  }
}
