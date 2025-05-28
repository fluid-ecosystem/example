# for k8s

put under `fluid-deployment-sender.yaml`:
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fluid-deployment-sender
spec:
  replicas: 1
  selector:
    matchLabels:
      app: fluid
  template:
    metadata:
      labels:
        app: fluid
    spec:
      containers:
        - name: fluid-container
          image: fluid-test-sender-docker
          imagePullPolicy: IfNotPresent
```

one shot deployment:
```
# remove from kubeernates
kubectl delete -f fluid-deployment-sender -n fluid-test
kubectl delete -f fluid-deployment-sender.yaml -n fluid-test 
# kafka-cluster:9092
docker build -t fluid-test-sender-docker . -f Dockerfile
minikube image load fluid-test-sender-docker
kubectl apply -f fluid-deployment-sender.yaml -n fluid-test 
```