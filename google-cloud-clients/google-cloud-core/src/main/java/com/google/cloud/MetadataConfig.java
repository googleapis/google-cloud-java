/*
 * Copyright 2017 Google LLC
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

package com.google.cloud;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Retrieves Google Cloud project-id and a limited set of instance attributes from Metadata server.
 *
 * @see <a href="https://cloud.google.com/compute/docs/storing-retrieving-metadata">
 *     https://cloud.google.com/compute/docs/storing-retrieving-metadata</a>
 */
public class MetadataConfig {

  private static final String METADATA_URL = "http://metadata.google.internal/computeMetadata/v1/";
  private static final int TIMEOUT_MS = 5000;

  private MetadataConfig() {}

  public static String getProjectId() {
    return getAttribute("project/project-id");
  }

  public static String getZone() {
    String zoneId = getAttribute("instance/zone");
    if (zoneId != null && zoneId.contains("/")) {
      return zoneId.substring(zoneId.lastIndexOf('/') + 1);
    }
    return zoneId;
  }

  public static String getInstanceId() {
    return getAttribute("instance/id");
  }

  public static String getClusterName() {
    return getAttribute("instance/attributes/cluster-name");
  }

  public static String getContainerName() {
    return getAttribute("instance/attributes/container-name");
  }

  public static String getNamespaceId() {
    return getAttribute("instance/attributes/namespace-id");
  }

  public static String getAttribute(String attributeName) {
    try {
      URL url = new URL(METADATA_URL + attributeName);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setConnectTimeout(TIMEOUT_MS);
      connection.setReadTimeout(TIMEOUT_MS);
      connection.setRequestProperty("Metadata-Flavor", "Google");
      InputStream input = connection.getInputStream();
      if (connection.getResponseCode() == 200) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, UTF_8))) {
          return reader.readLine();
        }
      }
    } catch (IOException ignore) {
      // ignore
    }
    return null;
  }
}
