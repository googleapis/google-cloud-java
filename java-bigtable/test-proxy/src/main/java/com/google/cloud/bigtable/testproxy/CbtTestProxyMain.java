/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.testproxy;

import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;

/** Starts a CbtTestProxy server. */
public final class CbtTestProxyMain {

  private CbtTestProxyMain() {}

  private static final Logger logger = Logger.getLogger(CbtTestProxyMain.class.getName());

  public static void main(String[] args) throws InterruptedException, IOException {
    int port = Integer.getInteger("port", 9999);
    if (port <= 0) {
      throw new IllegalArgumentException(String.format("Port %d is not > 0.", port));
    }

    CbtTestProxy cbtTestProxy;

    // If encryption is specified
    boolean encrypted = Boolean.getBoolean("encrypted");
    if (encrypted) {
      String rootCertsPemPath = System.getProperty("root.certs.pem.path");
      String sslTarget = System.getProperty("ssl.target");
      String credentialJsonPath = System.getProperty("credential.json.path");
      cbtTestProxy = CbtTestProxy.createEncrypted(rootCertsPemPath, sslTarget, credentialJsonPath);
    } else {
      cbtTestProxy = CbtTestProxy.createUnencrypted();
    }

    logger.info(String.format("Test proxy starting on %d", port));
    ServerBuilder.forPort(port).addService(cbtTestProxy).build().start().awaitTermination();
  }
}
