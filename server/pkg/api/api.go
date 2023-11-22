package api

import (
	"context"
	"net"
	"time"

	"github.com/bpatel85/learn-arcore/server/pkg/api/game"
	"github.com/rs/zerolog/log"
	"google.golang.org/grpc"
	"google.golang.org/grpc/keepalive"
)

type ApiConfig struct {
	Address          string
	MaxRecvSizeBytes int
}

func StartGrpcServer(ctx context.Context, conf ApiConfig) error {
	log.Info().Msg("starting the grpc server")

	lis, err := net.Listen("tcp", conf.Address)
	if err != nil {
		return err
	}

	grpcServer := grpc.NewServer(
		grpc.KeepaliveEnforcementPolicy(keepalive.EnforcementPolicy{
			MinTime:             2 * time.Second,
			PermitWithoutStream: true,
		}),
		grpc.KeepaliveParams(keepalive.ServerParameters{
			Time:    10 * time.Minute,
			Timeout: 20 * time.Second,
		}),
		grpc.MaxRecvMsgSize(conf.MaxRecvSizeBytes),
	)

	// register all the endpoints
	game.RegisterGameApi(grpcServer)

	if err := grpcServer.Serve(lis); err != nil {
		return err
	}

	log.Info().Msg("grpc server started")
	return nil
}
