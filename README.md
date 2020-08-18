### Application : run
#### DB h2 확인 : localhost/8080/h2-console >>>  connect

alt + f12> gradlew wrapper --gradle-version 4.10.2


#### PostsApiController.java

```javascript

    @GetMapping("/api/v1/posts")
    public List<PostsListResponseDto> _test() {
        return postsService.findAllDesc();
    }

React
 axios.get("/api/v1/posts")

```