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

package com.google.gcloud.storage;

import com.google.gcloud.AuthCredentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility to create a remote storage configuration for testing
 */
public class RemoteGcsHelper {

  private static final Logger log = Logger.getLogger(RemoteGcsHelper.class.getName());
  private static final String BUCKET_NAME_PREFIX = "gcloud-test-bucket-temp-";
  private static final String PROJECT_ID_ENV_VAR = "GCLOUD_TESTS_PROJECT_ID";
  private static final String PRIVATE_KEY_ENV_VAR = "GCLOUD_TESTS_KEY";

  private final StorageOptions options;
  private final String bucket;

  private RemoteGcsHelper(StorageOptions options, String bucket) {
    this.options = options;
    this.bucket = bucket;
  }

  public StorageOptions options() {
    return options;
  }

  public String bucket() {
    return bucket;
  }
  
  private static String generateBucketName() {
    return BUCKET_NAME_PREFIX + UUID.randomUUID().toString();
  }

  public static RemoteGcsHelper create() {
    if (System.getenv(PROJECT_ID_ENV_VAR) == null || System.getenv(PRIVATE_KEY_ENV_VAR) == null) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.INFO, "Environment variables {0} and {1} not set", new String[] {
            PROJECT_ID_ENV_VAR, PRIVATE_KEY_ENV_VAR});
      }
      return null;
    }  
    String projectId = System.getenv(PROJECT_ID_ENV_VAR);
    String stringKeyPath = System.getenv(PRIVATE_KEY_ENV_VAR);
    File keyFile = new File(stringKeyPath);
    try {
      InputStream keyFileStream = new FileInputStream(keyFile);
      StorageOptions options = StorageOptions.builder()
          .authCredentials(AuthCredentials.createForJson(keyFileStream))
          .projectId(projectId)
          .build();
      return new RemoteGcsHelper(options, generateBucketName());
    } catch (FileNotFoundException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      return null;    
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      return null; 
    }
  }
}
