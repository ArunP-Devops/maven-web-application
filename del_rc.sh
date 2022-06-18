#!/bin/bash
echo "kubectl delete rc arun-rc -n arun" 
if [$? -ne 0]
then
echo "kubectl apply -f rs_final.yaml" 
else 
echo "kubectl apply -f rs_final.yaml" 
fi
