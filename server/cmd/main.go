package main

import (
	"context"
	stdlog "log"
	"os"
	"time"

	"github.com/bpatel85/learn-arcore/server/pkg/api"
	"github.com/rs/zerolog"
	"github.com/rs/zerolog/log"
)

func main() {
	// setup logger
	zerolog.LevelFieldName = "severity"
	zerolog.TimestampFieldName = "time"
	zerolog.TimeFieldFormat = time.RFC3339Nano
	zerolog.SetGlobalLevel(zerolog.DebugLevel)

	stdlog.SetFlags(0)
	stdlog.SetOutput(log.Logger)

	log.Logger = zerolog.New(os.Stdout).With().Timestamp().Caller().Logger()
	zerolog.DefaultContextLogger = &log.Logger

	// start the grpc server
	ctx := context.Background()
	err := api.StartGrpcServer(ctx, api.ApiConfig{
		Address:          ":8800",
		MaxRecvSizeBytes: 8 * 1024 * 1024, // 8MB
	})

	log.Fatal().Err(err).Msg("failed to start the server")
}
