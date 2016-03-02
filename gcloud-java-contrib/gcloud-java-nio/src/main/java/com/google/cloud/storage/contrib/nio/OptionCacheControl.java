package com.google.cloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionCacheControl implements CloudStorageOption.OpenCopy {

  static OptionCacheControl create(String cacheControl) {
    return new AutoValue_OptionCacheControl(cacheControl);
  }

  abstract String cacheControl();
}
