import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.tracing.ErrorTypeUtil;

public class scratch {
  public static void main(String[] args) {
    ApiException error = new ApiException("test error", null, new StatusCode() {
      @Override public Code getCode() { return Code.INTERNAL; }
      @Override public Object getTransportCode() { return null; }
    }, false);
    System.out.println(ErrorTypeUtil.extractErrorType(error));
  }
}
