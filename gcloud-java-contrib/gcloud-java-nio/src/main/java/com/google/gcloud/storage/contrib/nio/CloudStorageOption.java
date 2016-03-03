package com.google.gcloud.storage.contrib.nio;

import java.nio.file.CopyOption;
import java.nio.file.OpenOption;

/**
 * Master interface for file operation option classes related to Google Cloud Storage.
 */
public interface CloudStorageOption {

  /**
   * Interface for GCS options that can be specified when opening files.
   */
  interface Open extends CloudStorageOption, OpenOption {}

  /**
   * Interface for GCS options that can be specified when copying files.
   */
  interface Copy extends CloudStorageOption, CopyOption {}

  /**
   * Interface for GCS options that can be specified when opening or copying files.
   */
  interface OpenCopy extends Open, Copy {}
}
