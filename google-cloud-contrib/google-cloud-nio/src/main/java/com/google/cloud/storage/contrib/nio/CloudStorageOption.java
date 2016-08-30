/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.contrib.nio;

import java.nio.file.CopyOption;
import java.nio.file.OpenOption;

/**
 * Master interface for file operation option classes related to Google Cloud Storage.
 */
public interface CloudStorageOption {

  /**
   * Interface for Google Cloud Storage options that can be specified when opening files.
   */
  interface Open extends CloudStorageOption, OpenOption {}

  /**
   * Interface for Google Cloud Storage options that can be specified when copying files.
   */
  interface Copy extends CloudStorageOption, CopyOption {}

  /**
   * Interface for Google Cloud Storage options that can be specified when opening or copying files.
   */
  interface OpenCopy extends Open, Copy {}
}
