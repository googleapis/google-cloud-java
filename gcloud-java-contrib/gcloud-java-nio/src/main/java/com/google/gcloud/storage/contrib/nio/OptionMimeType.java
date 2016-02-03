package com.google.gcloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionMimeType implements CloudStorageOption.OpenCopy {

  static OptionMimeType create(String mimeType) {
    return new AutoValue_OptionMimeType(mimeType);
  }

  abstract String mimeType();
}
