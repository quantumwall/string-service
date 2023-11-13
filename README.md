Три варианта запуска приложения:

1. Docker.
Находясь в корне проекта выполнить команды:
  - ./mvnw clean package в линукс (или ./mvnw.cmd clean package в windows)
  - docker compose up
  
2. Maven.
Находясь в корне проекта выполнить:
  - ./mvnw spring-boot:run
  
3. Maven + java -jar
Находясь в корне проекта выполнить:
  - ./mvnv clean package
  - java -jar target/*.jar
  
Приложение запустится на локальном порту 8080. Запросы нужно делать на localhost:8080/string/count. Метод post. Данные передавать в теле запроса в формате "string": "строка".
Например используя curl: curl -X POST -H "content-type: application/json" -d '{"string": "sssttrring"}' localhost:8080/string/count.

В случае корретных входных данных приложение возвращает ответ в формате [{"s":3},{"r":2},{"t":2},{"g":1},{"i":1},{"n":1}] например. В самой программе это List<Map.Entry<Character, Integer>>,
т.к. подсчет символов производится в Map<Character, String>.

В случае некорретного ввода программа выдает Bad request c описанием ошибки.