package com.google.gcloud.dns;

import com.google.gcloud.BatchResult;

/**
 * This class holds a single result of a batch call to the Cloud DNS.
 */
public class DnsBatchResult<T> implements BatchResult<T, DnsException> {

  private T result;
  private boolean submitted = false;
  private DnsException error;

  DnsBatchResult() {
  }

  @Override
  public boolean submitted() {
    return submitted;
  }

  @Override
  public T get() throws DnsException {
    if(!submitted()) {
      throw new IllegalStateException("Batch has not been submitted yet");
    }
    if(error != null) {
      throw error;
    }
    return result;
  }

  @Override
  public void notify(Callback<T, DnsException> callback) {
    // todo(mderka) implement
    throw new UnsupportedOperationException("Not implemented yet");
  }

  void error(DnsException error) {
    this.error = error;
    this.submitted = true;
  }

  void success(T result) {
    this.result = result;
    this.submitted = true;
  }
}
