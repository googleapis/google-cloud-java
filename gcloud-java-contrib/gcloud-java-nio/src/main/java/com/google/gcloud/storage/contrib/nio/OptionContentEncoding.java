package com.google.gcloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionContentEncoding implements CloudStorageOption.OpenCopy {

  static OptionContentEncoding create(String contentEncoding) {
    return new AutoValue_OptionContentEncoding(contentEncoding);
  }

  abstract String contentEncoding();
}
