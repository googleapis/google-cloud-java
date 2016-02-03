package com.google.gcloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionUserMetadata implements CloudStorageOption.OpenCopy {

  static OptionUserMetadata create(String key, String value) {
    return new AutoValue_OptionUserMetadata(key, value);
  }

  abstract String key();
  abstract String value();
}
