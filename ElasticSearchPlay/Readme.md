Run below docker elastic search instance to run given code base.

SpringBoot 2.6.x support elastic search version 7.x
```
docker run --name es01 --net elastic -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -it docker.elastic.co/elasticsearch/elasticsearch:7.15.2-amd64
```
