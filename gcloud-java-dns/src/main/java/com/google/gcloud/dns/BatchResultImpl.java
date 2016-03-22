package com.google.gcloud.dns;

import com.google.gcloud.dns.batch.BatchResult;

/**
 * This class holds a single result of a batch call to the Cloud DNS.
 */
public class BatchResultImpl<T> implements BatchResult<T, DnsException> {

  private T result;
  private boolean submitted = false;
  private DnsException error;

  BatchResultImpl() {
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

  void result(T result) {
    this.result = result;
  }

  void error(DnsException error) {
    this.error = error;
  }

  void submit() {
    this.submitted = true;
  }
}
