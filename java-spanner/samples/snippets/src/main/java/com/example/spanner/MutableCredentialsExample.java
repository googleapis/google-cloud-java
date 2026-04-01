/*
 * Copyright 2026 Google LLC
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

package com.example.spanner;

// [START spanner_mutable_credentials]

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.MutableCredentials;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class MutableCredentialsExample {

  static void createClientWithMutableCredentials(String credentialsPath) throws IOException {
    Path path = Paths.get(credentialsPath);
    // Use an AtomicReference to hold the mutable lastModifiedTime so it can be accessed in the
    // lambda
    final AtomicReference<FileTime> lastModifiedTime =
        new AtomicReference<>(Files.getLastModifiedTime(path));

    // 1 - create service account credentials
    ServiceAccountCredentials serviceAccountCredentials;
    try (FileInputStream is = new FileInputStream(credentialsPath)) {
      serviceAccountCredentials = ServiceAccountCredentials.fromStream(is);
    }

    // 2 - wrap credentials from step 1 in a MutableCredentials instance
    MutableCredentials mutableCredentials = new MutableCredentials(serviceAccountCredentials);

    // 3 - set credentials on your SpannerOptions builder to your mutableCredentials
    SpannerOptions options = SpannerOptions.newBuilder().setCredentials(mutableCredentials).build();

    // 4 - include logic for when/how to update your mutableCredentials
    // In this example we'll use a SchedulerExecutorService to periodically check for updates
    ThreadFactory daemonThreadFactory =
        runnable -> {
          Thread thread = new Thread(runnable, "spanner-mutable-credentials-rotator");
          thread.setDaemon(true);
          return thread;
        };
    ScheduledExecutorService executorService =
        Executors.newSingleThreadScheduledExecutor(daemonThreadFactory);
    executorService.scheduleAtFixedRate(
        () -> {
          try {
            FileTime currentModifiedTime = Files.getLastModifiedTime(path);
            if (currentModifiedTime.compareTo(lastModifiedTime.get()) > 0) {
              lastModifiedTime.set(currentModifiedTime);
              try (FileInputStream is = new FileInputStream(credentialsPath)) {
                ServiceAccountCredentials credentials = ServiceAccountCredentials.fromStream(is);
                mutableCredentials.updateCredentials(credentials);
              }
            }
          } catch (IOException e) {
            System.err.println("Failed to check or update credentials: " + e.getMessage());
          }
        },
        15,
        15,
        TimeUnit.MINUTES);

    // 5. Use the client
    try (Spanner spanner = options.getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      // Perform operations...
      // long running client operations will always use the latest credentials wrapped in
      // mutableCredentials
    } finally {
      // Ensure the executor is shut down when the application exits or the client is closed
      executorService.shutdown();
    }
  }
}
// [END spanner_mutable_credentials]
