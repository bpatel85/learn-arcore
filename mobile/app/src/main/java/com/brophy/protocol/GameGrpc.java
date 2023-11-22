package com.brophy.protocol;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GameGrpc {

  private GameGrpc() {}

  public static final String SERVICE_NAME = "game.Game";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.brophy.protocol.LoadGameRequest,
      com.brophy.protocol.LoadGameResponse> getLoadGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoadGame",
      requestType = com.brophy.protocol.LoadGameRequest.class,
      responseType = com.brophy.protocol.LoadGameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.brophy.protocol.LoadGameRequest,
      com.brophy.protocol.LoadGameResponse> getLoadGameMethod() {
    io.grpc.MethodDescriptor<com.brophy.protocol.LoadGameRequest, com.brophy.protocol.LoadGameResponse> getLoadGameMethod;
    if ((getLoadGameMethod = GameGrpc.getLoadGameMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getLoadGameMethod = GameGrpc.getLoadGameMethod) == null) {
          GameGrpc.getLoadGameMethod = getLoadGameMethod =
              io.grpc.MethodDescriptor.<com.brophy.protocol.LoadGameRequest, com.brophy.protocol.LoadGameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoadGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.brophy.protocol.LoadGameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.brophy.protocol.LoadGameResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("LoadGame"))
              .build();
        }
      }
    }
    return getLoadGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameStub>() {
        @java.lang.Override
        public GameStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameStub(channel, callOptions);
        }
      };
    return GameStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameBlockingStub>() {
        @java.lang.Override
        public GameBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameBlockingStub(channel, callOptions);
        }
      };
    return GameBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameFutureStub>() {
        @java.lang.Override
        public GameFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameFutureStub(channel, callOptions);
        }
      };
    return GameFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GameImplBase implements io.grpc.BindableService {

    /**
     */
    public void loadGame(com.brophy.protocol.LoadGameRequest request,
        io.grpc.stub.StreamObserver<com.brophy.protocol.LoadGameResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoadGameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoadGameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.brophy.protocol.LoadGameRequest,
                com.brophy.protocol.LoadGameResponse>(
                  this, METHODID_LOAD_GAME)))
          .build();
    }
  }

  /**
   */
  public static final class GameStub extends io.grpc.stub.AbstractAsyncStub<GameStub> {
    private GameStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameStub(channel, callOptions);
    }

    /**
     */
    public void loadGame(com.brophy.protocol.LoadGameRequest request,
        io.grpc.stub.StreamObserver<com.brophy.protocol.LoadGameResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoadGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GameBlockingStub extends io.grpc.stub.AbstractBlockingStub<GameBlockingStub> {
    private GameBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.brophy.protocol.LoadGameResponse loadGame(com.brophy.protocol.LoadGameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadGameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GameFutureStub extends io.grpc.stub.AbstractFutureStub<GameFutureStub> {
    private GameFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.brophy.protocol.LoadGameResponse> loadGame(
        com.brophy.protocol.LoadGameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoadGameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOAD_GAME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOAD_GAME:
          serviceImpl.loadGame((com.brophy.protocol.LoadGameRequest) request,
              (io.grpc.stub.StreamObserver<com.brophy.protocol.LoadGameResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.brophy.protocol.GameOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Game");
    }
  }

  private static final class GameFileDescriptorSupplier
      extends GameBaseDescriptorSupplier {
    GameFileDescriptorSupplier() {}
  }

  private static final class GameMethodDescriptorSupplier
      extends GameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameFileDescriptorSupplier())
              .addMethod(getLoadGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
