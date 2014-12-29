package com.google.gcloud.storage;

import java.nio.ByteBuffer;

public interface StorageObject {

  // builder will have an option to populate content and set acl, bucket, name,..

  Key key();

  Acl acl();

  ByteBuffer content();

}
