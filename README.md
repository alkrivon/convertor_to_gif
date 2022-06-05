# Convertor to Gif
## Описание
Сервис, который обращается к сервису курсов валют, и отдает gif:       
+ Если курс по отношению к USD за сегодня стал **выше** вчерашнего, то отдаем рандомную [отсюда](https://giphy.com/search/rich); 
+ Если курс по отношению к USD за сегодня стал **ниже** вчерашнего, то отдаем рандомную [отсюда](https://giphy.com/search/broke);    
+ [REST API курсов валют](https://docs.openexchangerates.org/);
+ [REST API gif](https://developers.giphy.com/docs/api#quick-start-guide);    
+ Сервис на Spring Boot 2 + Java / Kotlin;   
+ Запросы приходят на HTTP endpoint, туда передается код валюты;   
+ Для взаимодействия с внешними сервисами используется Feign;    
+ Для сборки должен использоуется Gradle;
+ Сборка и запуск Docker-контейнера;
***
## Запуск
+ Скачать Docker-контейнер:
```
docker pull alexkriv/convertor_to_gif_app
```
+ Запустить Docker-контейнер:
```
docker run -p 8080:8080 alexkriv/convertor_to_gif_app
```
***
## Endpoint
Получить gif в зависимости от изменения курса валюты по отношению к USD:
+ `http://localhost:8080/convertor/gif/{symbols}`,
где symbols - код валюты, курс которой необходимо сравнить. Например:
+ `http://localhost:8080/convertor/gif/RUB`


