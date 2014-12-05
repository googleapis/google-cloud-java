package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gcloud.datastore.PartialKey.Ancestor;

/**
 * An helper for creating keys for a specific {@link DatastoreService},
 * using its associated dataset and namespace.
 */
public final class KeyBuilder extends PartialKey.Builder {

  private final DatastoreService service;

  /**
   * Constructing a KeyBuilder.
   */
  public KeyBuilder(DatastoreService service, String kind) {
    super(checkNotNull(service).getOptions().dataset(), kind);
    this.service = service;
    namespace(service.getOptions().namespace());
  }

  @Override
  public KeyBuilder kind(String kind) {
    super.kind(kind);
    return this;
  }

  @Override
  public KeyBuilder addAncestor(String kind, String name) {
    super.addAncestor(kind, name);
    return this;
  }

  @Override
  public KeyBuilder addAncestor(String kind, long id) {
    super.addAncestor(kind, id);
    return this;
  }

  @Override
  public KeyBuilder namespace(String namespace) {
    super.namespace(namespace);
    return this;
  }

  @Override
  public KeyBuilder addAncestor(Ancestor... ancestor) {
    super.addAncestor(ancestor);
    return this;
  }

  @Override
  public KeyBuilder addAncestors(Iterable<Ancestor> ancestors) {
    super.addAncestors(ancestors);
    return this;
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

  /**
   * Builds a key with a newly allocated id.
   * @throws DatastoreServiceException if allocation failed.
   */
  public Key allocateIdAndBuild() {
    return service.allocateId(build());
  }
}
