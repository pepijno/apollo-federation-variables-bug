# apollo-federation-variables-bug

## How to

```bash
./gradlew bootRun
```
In another shell
```bash
npm i && node gateway.js
```
Then in another shell
```bash
$ curl -X POST -H "Content-Type: application/json" --data '{"query":"query getBook($pageCount: Int!) { bookByPageCount(pageCount: $pageCount) { id name pageCount } }","variables":{"pageCount":223},"operationName":null}' http://localhost:4000/graphql
{"data":{"bookByPageCount":{"id":"book-1","name":"Harry Potter and the Philosopher's Stone","pageCount":223}}}
$ curl -X POST -H "Content-Type: application/json" --data '{"query":"query getBook($pageCount: Int!) { bookByPageCount(pageCount: $pageCount) { id name pageCount } }","variables":{"pageCount":"223"},"operationName":null}' http://localhost:4000/graphql
{}
```
