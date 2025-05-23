# remove from kubeernates
kubectl delete -f fluid-deployment-receiver.yaml
kubectl delete -f fluid-deployment-receiver.yaml -n fluid-test 
# kafka-cluster:9092
docker build -t fluid-test-docker .
minikube image load fluid-test-docker
kubectl apply -f fluid-deployment-receiver.yaml -n fluid-test 