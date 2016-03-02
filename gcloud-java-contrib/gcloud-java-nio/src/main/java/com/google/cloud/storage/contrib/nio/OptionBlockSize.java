package com.google.cloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionBlockSize implements CloudStorageOption.OpenCopy {

  static OptionBlockSize create(int size) {
    return new AutoValue_OptionBlockSize(size);
  }

  abstract int size();
}
