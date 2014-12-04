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
    delegate = new PartialKey.Builder(service.getOptions().dataset(), kind);
    delegate.namespace(service.getOptions().defaultNamespace());
  }

  public KeyBuilder addToPath(String kind, String name) {
    delegate.addAncestor(kind, name);
    return this;
  }

  public KeyBuilder addToPath(String kind, long id) {
    delegate.addAncestor(kind, id);
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
    PartialKey key = build();
    return new Key.Builder(key.dataset(), key.kind(), name)
        .namespace(key.namespace())
        .addAncestors(key.ancestors())
        .build();
  }

  public Key build(long id) {
    PartialKey key = build();
    return new Key.Builder(key.dataset(), key.kind(), id)
        .namespace(key.namespace())
        .addAncestors(key.ancestors())
        .build();
  }

  public PartialKey build() {
    return delegate.build();
  }
}
