package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;

/**
 * An helper for creating keys for a specific {@link DatastoreService},
 * using its associated dataset and namespace.
 */
public final class KeyBuilder extends BaseKey.Builder<PartialKey, KeyBuilder> {

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
  protected PartialKey build(String dataset, String namespace,
      ImmutableList<PathElement> ancestors, String kind) {
    return new PartialKey(dataset, namespace, ancestors, kind);
  }

  public Key build(String name) {
    return build().newKey(name);
  }

  public Key build(long id) {
    return build().newKey(id);
  }

  /**
   * Builds a key with a newly allocated id.
   * @throws DatastoreServiceException if allocation failed.
   */
  public Key allocateIdAndBuild() {
    return service.allocateId(build());
  }
}
