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

import io.grpc.ManagedChannel;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that runs a Pubsub emulator instance for use in tests.
 */
public class LocalPubsubHelper {
  private final LocalServiceHelper serviceHelper;
  private final List<String> gcloudCommand;
  private final URL emulatorUrl;

  // Local server settings
  private static final int DEFAULT_PORT = 8080;
  private static final String DEFAULT_HOST = "localhost";

  // GCloud emulator settings
  private static final String GCLOUD_CMD_TEXT = "gcloud beta emulators pubsub start --host-port";
  private static final String VERSION_PREFIX = "pubsub-emulator";
  private static final String MIN_VERSION = "2016.01.13";

  // Downloadable emulator settings
  private static final String FILENAME = "pubsub-emulator-20160113-2.zip";
  private static final String BIN_NAME = "pubsub-emulator/bin/cloud-pubsub-fake";
  private static final String MD5_CHECKSUM = "20943e9defa300f2de101568459c133d";

  /**
   * Constructs a new LocalPubsubHelper. The method start() must
   * be called before it is used.
   * @throws MalformedURLException
   */
  public LocalPubsubHelper() throws MalformedURLException {
    gcloudCommand = new ArrayList<>(Arrays.asList(GCLOUD_CMD_TEXT.split(" ")));
    gcloudCommand.add(DEFAULT_HOST);
    emulatorUrl = new URL("http://storage.googleapis.com/pubsub/tools/" + FILENAME);
    GCloudEmulatorRunner gcloudRunner =
        new GCloudEmulatorRunner(gcloudCommand, VERSION_PREFIX, MIN_VERSION);
    DownloadableEmulatorRunner downloadRunner =
        new DownloadableEmulatorRunner(Arrays.asList(BIN_NAME), emulatorUrl, MD5_CHECKSUM);
    serviceHelper =
        new LocalServiceHelper(Arrays.asList(gcloudRunner, downloadRunner), DEFAULT_PORT);
  }

  /**
   * Start the local pubsub emulator through gcloud, download the zip file if user does not have
   * gcloud installed.
   * @throws InterruptedException
   * @throws IOException
   */
  public void start() throws IOException, InterruptedException {
    String blockUntilOutput = Integer.toString(DEFAULT_PORT);
    serviceHelper.start(blockUntilOutput);
  }

  /**
   * Reset the internal state of the emulator.
   * @throws InterruptedException
   * @throws IOException
   */
  public void reset() throws IOException, InterruptedException {
    this.serviceHelper.sendPostRequest("/reset");
  }

  /**
   * Quit the local emulator and related local service.
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
    return NettyChannelBuilder.forAddress(DEFAULT_HOST, DEFAULT_PORT)
        .negotiationType(NegotiationType.PLAINTEXT)
        .build();
  }
}
