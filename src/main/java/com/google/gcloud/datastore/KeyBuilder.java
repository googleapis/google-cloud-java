package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * An helper for creating keys for a specific {@link DatastoreService}/dataset.
 */
public final class KeyBuilder {

  private final PartialKey.Builder delegate;
  private final DatastoreService service;

  /**
   * Constructing a KeyBuilder.
   */
  public KeyBuilder(DatastoreService service, String kind) {
    this.service = checkNotNull(service);
    delegate = new PartialKey.Builder(service.getOptions().getDataset(), kind);
    delegate.namespace(service.getOptions().getDefaultNamespace());
  }

  public KeyBuilder addToPath(String kind, String name) {
    delegate.addToPath(kind, name);
    return this;
  }

  public KeyBuilder addToPath(String kind, long id) {
    delegate.addToPath(kind, id);
    return this;
  }

  public KeyBuilder namespace(String namespace) {
    delegate.namespace(namespace);
    return this;
  }

  /**
   * Builds a key with a newly allocated id.
   * @throws DatastoreServiceException if allocation failed.
   */
  public Key allocateIdAndBuild() {
    return service.allocateId(build());
  }

  public Key build(String name) {
    return new Key.Builder(build(), name).build();
  }

  public Key build(long id) {
    return new Key.Builder(build(), id).build();
  }

  public PartialKey build() {
    return delegate.build();
  }
}
