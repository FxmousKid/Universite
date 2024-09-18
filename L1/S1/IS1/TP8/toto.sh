#!/bin/bash

menfiche() {
  echo "J'ai bien reçu le signal $1, mais sans façon, merci."
}

for sig in SIGINT SIGTERM SIGHUP
do
  trap "menfiche $sig" $sig
done

while :
do
  echo "zzz..."
  sleep 2
done
