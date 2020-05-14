#!/bin/bash

docker run -p '127.0.0.1:5432:5432/tcp' -it --rm -e 'POSTGRES_PASSWORD=qwerty' postgres:12.2
