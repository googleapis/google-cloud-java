package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** */
public class ResponseStream<GenerateContentResponse> implements Iterable<GenerateContentResponse> {

  private ResponseStreamIteratorWithHistory<GenerateContentResponse> iteratorWithHistory;
  private boolean consumingStarted = false;

  public ResponseStream(ResponseStreamIteratorWithHistory iteratorWithHistory) {
    this.iteratorWithHistory = iteratorWithHistory;
  }

  @Override
  public Iterator<GenerateContentResponse> iterator() throws IllegalStateException {
    if (!consumingStarted) {
      consumingStarted = true;
      return iteratorWithHistory;
    } else if (iteratorWithHistory.isConsumed()) {
      return iteratorWithHistory.getHistory().iterator();
    } else {
      throw new IllegalStateException("The stream is being consumed but hasn't finished.");
    }
  }

  public Stream<GenerateContentResponse> stream() {
    return StreamSupport.stream(this.spliterator(), false);
  }

  public boolean isConsumed() {
    return iteratorWithHistory.isConsumed();
  }
}
