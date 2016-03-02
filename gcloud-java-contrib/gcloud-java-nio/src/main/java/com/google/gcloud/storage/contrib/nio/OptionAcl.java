package com.google.gcloud.storage.contrib.nio;

import com.google.auto.value.AutoValue;
import com.google.gcloud.storage.Acl;

@AutoValue
abstract class OptionAcl implements CloudStorageOption.OpenCopy {

  static OptionAcl create(Acl acl) {
    return new AutoValue_OptionAcl(acl);
  }

  abstract Acl acl();
}
