# remove from kubeernates
kubectl delete -f fluid-deployment-sender -n fluid-test
kubectl delete -f fluid-deployment-sender.yaml -n fluid-test 
# kafka-cluster:9092
docker build -t fluid-test-sender-docker . -f Dockerfile
minikube image load fluid-test-sender-docker
kubectl apply -f fluid-deployment-sender.yaml -n fluid-test 