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

package com.google.cloud.pubsub.testing;

import com.google.api.gax.testing.DownloadableEmulatorRunner;
import com.google.api.gax.testing.GCloudEmulatorRunner;
import com.google.api.gax.testing.LocalServiceHelper;
import com.google.cloud.AuthCredentials;
import com.google.cloud.RetryParams;
import com.google.cloud.pubsub.PubSubOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import io.grpc.ManagedChannel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

/**
 * A class that runs a Pubsub emulator instance for use in tests.
 */
public class LocalPubsubHelper {

  private final int port;
  private final LocalServiceHelper serviceHelper;
  private final String projectId;

  // Local server settings
  private static final int DEFAULT_PORT = 8080;
  private static final String DEFAULT_HOST = "localhost";
  private static final URL EMULATOR_URL;
  private static final String PROJECT_ID_PREFIX = "test-project-";

  // GCloud emulator settings
  private static final String GCLOUD_CMD_TEXT = "gcloud beta emulators pubsub start";
  private static final String GCLOUD_CMD_PORT_FLAG = "--host-port=";
  private static final String VERSION_PREFIX = "pubsub-emulator";
  private static final String MIN_VERSION = "2016.01.13";
  private static final String BIN_CMD_PORT_FLAG = "--port=";

  // Downloadable emulator settings
  private static final String FILENAME = "pubsub-emulator-20160113-2.zip";
  private static final String BIN_NAME = "pubsub-emulator/bin/cloud-pubsub-fake";
  private static final String MD5_CHECKSUM = "20943e9defa300f2de101568459c133d";

  static {
    try {
      EMULATOR_URL = new URL("http://storage.googleapis.com/pubsub/tools/" + FILENAME);
    } catch (MalformedURLException ex) {
      throw new IllegalStateException(ex);
    }
  }

  /**
   * Constructs a new LocalPubsubHelper. The method start() must
   * be called before it is used.
   */
  public LocalPubsubHelper() {
    port = LocalServiceHelper.findAvailablePort(DEFAULT_PORT);
    List<String> gcloudCommand = new ArrayList<>(Arrays.asList(GCLOUD_CMD_TEXT.split(" ")));
    gcloudCommand.add(GCLOUD_CMD_PORT_FLAG + "localhost:" + port);
    GCloudEmulatorRunner gcloudRunner =
        new GCloudEmulatorRunner(gcloudCommand, VERSION_PREFIX, MIN_VERSION);
    DownloadableEmulatorRunner downloadRunner =
        new DownloadableEmulatorRunner(Arrays.asList(BIN_NAME, BIN_CMD_PORT_FLAG + port),
            EMULATOR_URL, MD5_CHECKSUM);
    serviceHelper = new LocalServiceHelper(Arrays.asList(gcloudRunner, downloadRunner), port);
    projectId = PROJECT_ID_PREFIX + UUID.randomUUID().toString();
  }

  /**
   * Start the local pubsub emulator through gcloud, download the zip file if user does not have
   * gcloud installed.
   *
   * @throws InterruptedException
   * @throws IOException
   */
  public void start() throws IOException, InterruptedException {
    String blockUntilOutput = "Server started, listening on " + port;
    serviceHelper.start(blockUntilOutput);
  }

  /**
   * Reset the internal state of the emulator.
   *
   * @throws IOException
   */
  public void reset() throws IOException {
    this.serviceHelper.sendPostRequest("/reset");
  }

  /**
   * Quit the local emulator and related local service.
   *
   * @throws InterruptedException
   * @throws IOException
   */
  public void stop() throws IOException, InterruptedException {
    this.serviceHelper.sendPostRequest("/shutdown");
    this.serviceHelper.stop();
  }

  /**
   * Creates a channel for making requests to the in-memory service.
   */
  public ManagedChannel createChannel() {
    return NettyChannelBuilder.forAddress(DEFAULT_HOST, port)
        .negotiationType(NegotiationType.PLAINTEXT)
        .build();
  }

  /**
   * Returns a {@link PubSubOptions} instance that sets the host to use the PubSub emulator on
   * localhost.
   */
  public PubSubOptions options() {
    return PubSubOptions.builder()
        .projectId(projectId)
        .host("localhost:" + port)
        .authCredentials(AuthCredentials.noAuth())
        .retryParams(RetryParams.noRetries())
        .build();
  }
}
