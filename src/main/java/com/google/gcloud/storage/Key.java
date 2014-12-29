package com.google.gcloud.storage;

public class Key {

  // TODO: add builder, factory method, toURL, from URL, equals,hashCode, toString
  private final String bucket;
  private final String name;

  /*
  Builder() {

  }*/

  Key(String bucket, String name) {
    this.bucket = bucket;
    this.name = name;
  }

  public String bucket() {
    return bucket;
  }

  public String name() {
    return name;
  }
}
