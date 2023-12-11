package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.api.GenerateContentResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** */
public class ResponseStreamIteratorWithHistory<GenerateContentResponse>
    implements Iterator<GenerateContentResponse> {
  Iterator serverStreamIterator = null;
  List<GenerateContentResponse> history = new ArrayList<>();
  private boolean consumed = false;

  public ResponseStreamIteratorWithHistory(Iterator serverStreamIterator) {
    this.serverStreamIterator = serverStreamIterator;
  }

  @Override
  public boolean hasNext() {
    boolean hasNextResponse = serverStreamIterator.hasNext();
    consumed = !hasNextResponse;
    return hasNextResponse;
  }

  @Override
  public GenerateContentResponse next() {
    GenerateContentResponse nextItem = (GenerateContentResponse) serverStreamIterator.next();
    // TODO: any interruption from the SDK side should go here (for example, if we decide to raise
    // an error when the response contains prompt_feedback only, or when we found the repsonse
    // triggered higher safety rating)
    history.add(nextItem);
    return nextItem;
  }

  public List<GenerateContentResponse> getHistory() {
    return history;
  }
  
  public boolean isConsumed() {
    return consumed;
  }
}
