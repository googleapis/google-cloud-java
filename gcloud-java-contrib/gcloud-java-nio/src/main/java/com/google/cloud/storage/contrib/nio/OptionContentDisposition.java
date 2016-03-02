package com.google.cloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionContentDisposition implements CloudStorageOption.OpenCopy {

  static OptionContentDisposition create(String contentDisposition) {
    return new AutoValue_OptionContentDisposition(contentDisposition);
  }

  abstract String contentDisposition();
}
