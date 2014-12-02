package com.google.gcloud.datastore;

public final class KeyBuilder {

  private final PartialKey.Builder delegate;

  public KeyBuilder(String dataset, String namespace, String kind) {
    delegate = new PartialKey.Builder(dataset, kind);
    if (namespace != null) {
      delegate.setNamespace(namespace);
    }
  }

  public KeyBuilder addToPath(String kind, String name) {
    delegate.addToPath(kind, name);
    return this;
  }

  public KeyBuilder addToPath(String kind, long id) {
    delegate.addToPath(kind, id);
    return this;
  }

  public KeyBuilder setNamespace(String namespace) {
    delegate.setNamespace(namespace);
    return this;
  }

  public PartialKey build() {
    return delegate.build();
  }

  public Key build(String name) {
    return new Key.Builder(build(), name).build();
  }

  public Key build(long id) {
    return new Key.Builder(build(), id).build();
  }
}