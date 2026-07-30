import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;

public class EnvTest2 {
  public static void main(String[] args) throws Exception {
    InstantiatingGrpcChannelProvider p = InstantiatingGrpcChannelProvider.newBuilder()
      .setAttemptDirectPath(true)
      .setAttemptDirectPathXds()
      .build();
    java.lang.reflect.Method m = InstantiatingGrpcChannelProvider.class.getDeclaredMethod("isDirectPathEnabled");
    m.setAccessible(true);
    System.out.println("isDirectPathEnabled: " + m.invoke(p));
  }
}
