#!/bin/bash

set -ex

IMAGE_NAME="sba-svr"
TAG="${1}"

REGISTRY="${2}:5000"

docker build -t ${REGISTRY}/${IMAGE_NAME}:${TAG} .
docker push ${REGISTRY}/${IMAGE_NAME}:${TAG}
