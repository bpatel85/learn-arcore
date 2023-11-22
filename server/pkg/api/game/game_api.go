package game

import (
	"context"

	"github.com/bpatel85/learn-arcore/server/pb"
	"google.golang.org/grpc"
)

type Service struct {
	pb.GameServer
}

func (svc *Service) LoadGame(context.Context, *pb.LoadGameRequest) (*pb.LoadGameResponse, error) {
	return nil, nil
}

func RegisterGameApi(grpcServer *grpc.Server) {
	pb.RegisterGameServer(grpcServer, &Service{})
}
