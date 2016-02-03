package com.google.gcloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class OptionAcl implements CloudStorageOption.OpenCopy {

  static OptionAcl create(String acl) {
    return new AutoValue_OptionAcl(acl);
  }

  abstract String acl();
}
