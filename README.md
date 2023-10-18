# wanted-pre-onboarding-backend

baseUrl : localhost:8080


1. 채용공고 등록

request
POST {{baseUrl}}/api/v1/recruitment
```JSON
{ 
	"companyId" : 1,
	"position" : "백엔드 주니어 개발자",
	"reward" : 1000000,
	"description" : "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
	"skill" : "Python"
}
```
response
code : 201

2. 채용공고 수정

request
PUT {{baseUrl}}/api/v1/recruitment/1
```JSON
{
	"position" : "backend",
	"reward" : 2000,
	"description" : "열정",
	"skill" : "node"
}
```

response
code : 200
```JSON
{
	"recruitmentId": 1
}
```

3. 채용공고 삭제

request
DELETE {{baseUrl}}/api/v1/recruitment/1

response
code : 200

4. 채용공고 목록

request
GET {{baseUrl}}/api/v1/recruitment

response
```JSON
[
    {
        "recruitmentId": 1,
        "companyName": "wanted",
        "country": "한국",
        "area": "판교",
        "position": "backend",
        "reward": 10000,
        "skill": "spring"
    },
    {
        "recruitmentId": 2,
        "companyName": "sangdo",
        "country": "한국",
        "area": "상도동",
        "position": "frontend",
        "reward": 10000,
        "skill": "react"
    },
    {
        "recruitmentId": 3,
        "companyName": "wanted",
        "country": "한국",
        "area": "판교",
        "position": "frontend",
        "reward": 10000,
        "skill": "vue"
    }
]
```

4. 검색기능
   request
   GET {{baseUrl}}/api/v1/recruitment?search=원티드

response
search=원티드
```JSON
[
    {
        "recruitmentId": 5,
        "companyName": "원티드랩",
        "country": "한국",
        "area": "서울",
        "position": "백엔드 주니어 개발자",
        "reward": 10000,
        "skill": "python"
    },
    {
        "recruitmentId": 6,
        "companyName": "원티드코리아",
        "country": "한국",
        "area": "광주",
        "position": "프론트엔드 개발자",
        "reward": 10000,
        "skill": "javascript"
    }
]
```

search=Spring
```JSON
[
    {
        "recruitmentId": 7,
        "companyName": "네이버",
        "country": "한국",
        "area": "판교",
        "position": "Spring 백엔드 개발자",
        "reward": 10000,
        "skill": "Java"
    },
    {
        "recruitmentId": 8,
        "companyName": "카카오",
        "country": "한국",
        "area": "판교",
        "position": "Spring 백엔드 개발자",
        "reward": 10000,
        "skill": "Java"
    }
]
```


5. 채용 상세 페이지

request
GET {{baseUrl}}/api/v1/recruitment/details/3

response
```JSON
{
    "recruitmentId": 3,
    "companyName": "wanted",
    "country": "한국",
    "area": "판교",
    "position": "frontend",
    "reward": 10000,
    "skill": "vue",
    "description": "열정",
    "recruitments": [
        1,
        4
    ]
}
```



6. 채용공고 지원

request
POST {{baseUrl}}/api/v1/application
```JSON
{
	"recruitmentId" : 3,
	"userId" : 1
}
```

response
code : 201