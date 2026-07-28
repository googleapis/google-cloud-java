/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.telemetry;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.UUID;

/** A utility class for retrieving a unique client identifier (CLIENT_UID) */
final class ClientIdentifier {

  private ClientIdentifier() {}

  private static String CLIENT_UID;

  /** Gets the unique identifier for the client. */
  public static String getClientUid() {
    if (CLIENT_UID == null) {
      CLIENT_UID = generateClientUid();
    }
    return CLIENT_UID;
  }

  /**
   * Generates a unique identifier for the client that is composed of a random UUID, the process ID,
   * and the hostname of the machine.
   */
  private static String generateClientUid() {
    String identifier = UUID.randomUUID().toString();
    String pid = getProcessId();
    String hostname = getHostName();
    return String.format("%s@%s@%s", identifier, pid, hostname);
  }

  private static String getHostName() {
    try {
      return InetAddress.getLocalHost().getHostName();
    } catch (Exception e) {
      return "localhost";
    }
  }

  private static String getProcessId() {
    try {
      // Check if Java 9+ and ProcessHandle class is available
      Class<?> processHandleClass = Class.forName("java.lang.ProcessHandle");
      Method currentMethod = processHandleClass.getMethod("current");
      Object processHandleInstance = currentMethod.invoke(null);
      Method pidMethod = processHandleClass.getMethod("pid");
      long pid = (long) pidMethod.invoke(processHandleInstance);
      return Long.toString(pid);
    } catch (Exception e) {
      // Fallback to Java 8 method
      final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
      if (jvmName != null && jvmName.contains("@")) {
        return jvmName.split("@")[0];
      } else {
        return "unknown";
      }
    }
  }
}
