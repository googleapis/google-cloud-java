/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.InternalApi;
import com.google.cloud.NoCredentials;
import com.google.common.base.Strings;
import java.net.InetAddress;
import java.net.URL;

@InternalApi
public class DatastoreUtils {

  public static boolean isEmulator(DatastoreOptions datastoreOptions) {
    return isLocalHost(datastoreOptions.getHost())
        || NoCredentials.getInstance().equals(datastoreOptions.getCredentials());
  }

  public static boolean isLocalHost(String host) {
    if (Strings.isNullOrEmpty(host)) {
      return false;
    }
    try {
      String normalizedHost = "http://" + removeScheme(host);
      InetAddress hostAddr = InetAddress.getByName(new URL(normalizedHost).getHost());
      return hostAddr.isAnyLocalAddress() || hostAddr.isLoopbackAddress();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String removeScheme(String url) {
    if (url != null) {
      url = url.toLowerCase();
      if (url.startsWith("https://")) {
        return url.substring("https://".length());
      } else if (url.startsWith("http://")) {
        return url.substring("http://".length());
      }
    }
    return url;
  }
}
