package com.google.gcloud.storage;

import java.nio.ByteBuffer;

public interface Bucket {

  String name();

  Acl acl();

  void updateAcl(Acl acl);

  Acl defaultObjectAcl();

  void updateDefaultObjectAcl();

  Acl acl(String objectName);

  void updateAcl(String objectName, Acl acl);

  void delete(String... objectName);

  void compose(Iterable<String> source, String dest);

  void copy(String source, String dest);

  // TODO (ozarov): consider replace with Object that has a reference to bucket and name
  // that object can return its own meta-data, update its own meta-data, replace its content
  // via a stream or byteBuffer, read its content (via stream or ByteBuffer),...
  //void copy(String source, String bucket, String dest);
  // Also consider read with an offset (and limit).

  void put(String name, ByteBuffer bytes);

  // TODO: add listing
}
