# Лаборатори №9 — Код хамралт: JaCoCo-гоор тестээ хөтлөх

## 1. Ерөнхий мэдээлэл

| Үзүүлэлт | Мэдээлэл |
|---|---|
| Хичээл | F.CSA313 — Программ хангамжийн чанарын баталгаа ба тест |
| Лаборатори | №9 — Код хамралт |
| Оюутны нэр | Э. Мөнх-Очир |
| Оюутны код | B232270022 |
| Төслийн нэр | lab09-jacoco |
| Java | OpenJDK 25.0.2 |
| Maven | 3.9.12 |
| JaCoCo | 0.8.12 |
| JUnit Jupiter | 5.10.2 |

## 2. Лабораторийн зорилго

Энэхүү лабораторийн ажлын зорилго нь JaCoCo хэрэгслийг ашиглан Java програмын код хамралтыг хэмжих, тестийн чанарыг үнэлэх, branch болон line coverage-ийг бүрэн хангах, мөн Boundary Value Testing ашиглан програмын логик алдааг илрүүлэхэд оршино.

Тестийн бай болгон `ScholarshipCalculator` классыг ашигласан.

## 3. Орчны тохиргоо

### Java хувилбар

```text
openjdk version "25.0.2" 2026-01-20
OpenJDK Runtime Environment Homebrew (build 25.0.2)
OpenJDK 64-Bit Server VM Homebrew (build 25.0.2, mixed mode, sharing)
```

### Maven хувилбар

```text
Apache Maven 3.9.12 (848fbb4bf2d427b72bdb2471c22fced7ebd9a7a1)
Maven home: /opt/homebrew/Cellar/maven/3.9.12/libexec
Java version: 25.0.2, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/25.0.2/libexec/openjdk.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "27.0.1", arch: "aarch64", family: "mac"
```

### Ашигласан технологи

- Java: OpenJDK 25.0.2
- Maven: 3.9.12
- JUnit Jupiter: 5.10.2
- JaCoCo: 0.8.12
- Git болон GitHub

## 4. A хэсэг — Happy Path Testing

Эхний шатанд програмын хэвийн ажиллагааг шалгах 5 Happy Path тест бичсэн.

| № | Тестийн нэр | Шалгасан үйлдэл |
|---|---|---|
| 1 | `letterGradeReturnsA()` | 95 оноонд A үнэлгээ өгөх |
| 2 | `letterGradeReturnsC()` | 75 оноонд C үнэлгээ өгөх |
| 3 | `gpaCalculatesAverageCorrectly()` | Голч дүн тооцоолох |
| 4 | `scholarshipReturns100Percent()` | 100%-ийн тэтгэлэг |
| 5 | `scholarshipReturns70Percent()` | 70%-ийн тэтгэлэг |

### A хэсгийн үр дүн

- Tests run: 5
- Failures: 0
- Errors: 0
- Skipped: 0
- Build: SUCCESS

### JaCoCo coverage

| Үзүүлэлт | Missed | Covered | Coverage |
|---|---:|---:|---:|
| Instructions | 44 | 108 | 71.05% |
| Branches | 19 | 22 | 53.66% |
| Lines | 9 | 16 | 64% |
| Methods | 0 | 4 | 100% |

### JaCoCo тайлангийн өнгөний ажиглалт

Эхний 5 тестийг ажиллуулсны дараа JaCoCo HTML тайлан дээр зарим мөр улаан, зарим мөр шар өнгөөр харагдсан.

**Улаан өнгөөр харагдсан мөрүүд (код ажиллаагүй):**

| Мөрийн дугаар | Кодын хэсгийн тайлбар |
|---:|---|
| 21 | Онооны алдаатай оролтод `IllegalArgumentException` шидэх |
| 26–27 | D үнэлгээ болон F үнэлгээ буцаах |
| 32 | GPA-ийн хоосон эсвэл null массивт exception шидэх |
| 39–40 | GPA тооцооллын switch-ийн D болон default хэсэг |
| 49 | Тэтгэлгийн алдаатай оролтод exception шидэх |
| 54–55 | Тэтгэлгийн 70% болон 0% буцаах хэсгүүд |

**Шар өнгөөр харагдсан мөрүүд (нөхцөлийн бүх салбар бүрэн шалгагдаагүй):**

| Мөрийн дугаар | Кодын хэсгийн тайлбар |
|---:|---|
| 20 | `score < 0 || score > 100` онооны хязгаар шалгах нөхцөл |
| 25 | `score >= 70` нөхцөл |
| 31 | `scores == null || scores.length == 0` массив шалгах нөхцөл |
| 36 | GPA тооцооллын switch-ийн салбарууд |
| 48 | Тэтгэлгийн оролтын шалгалтын нөхцөл |
| 51 | `hasViolation` сахилгын зөрчил шалгах нөхцөл |
| 52 | `gpa >= 3.8 && credits >= 15` нөхцөл |
| 53 | `gpa >= 3.4 && credits >= 12` нөхцөл |

Эхний шатны тестүүд програмын үндсэн хэвийн ажиллагааг шалгасан боловч алдаатай оролт, нөхцөлийн эсрэг үр дүн болон бүх буцаах утгуудыг хамарч чадаагүй.

**Хадгалсан үр дүн:**

- `results/mvn-verify-A.txt`
- `results/jacoco-A.csv`
- `screenshots/jacoco-A.png`

## 5. B хэсэг — Branch болон Line Coverage 100%

Энэ хэсэгт `ScholarshipCalculator` классын бүх нөхцөл болон кодын мөрүүдийг шалгах нэмэлт тестүүд бичсэн.

Шалгасан нөхцөлүүд:

- GPA 0-ээс бага байх.
- GPA 4-өөс их байх.
- Кредит 0-ээс бага байх.
- Сахилгын зөрчилтэй байх.
- GPA 3.8-аас их буюу тэнцүү байх.
- Кредит 15-аас их буюу тэнцүү байх.
- GPA 3.4-өөс их буюу тэнцүү байх.
- Кредит 12-оос их буюу тэнцүү байх.
- GPA 3.0-аас их буюу тэнцүү байх.

Мөн `letterGrade()` болон `gpa()` функцүүдийн хэвийн болон алдаатай оролтуудыг шалгасан.

`&&` болон `||` операторын short-circuit ажиллагааг харгалзан нөхцөл бүрийн үр дүнг шалгах тестүүд нэмсэн.

### Control Flow Graph

`cfg.png` файлд `scholarship()` функцийн Control Flow Graph диаграммыг оруулсан.

### B хэсгийн үр дүн

- Tests run: 21
- Failures: 0
- Errors: 0
- Build: SUCCESS

| Үзүүлэлт | Missed | Covered | Coverage |
|---|---:|---:|---:|
| Instructions | 0 | 152 | 100% |
| Branches | 0 | 41 | 100% |
| Lines | 0 | 25 | 100% |
| Complexity | 0 | 26 | 100% |
| Methods | 0 | 4 | 100% |

**Хадгалсан үр дүн:**
- `results/mvn-verify-B.txt`
- `results/jacoco-B.csv`
- `cfg.png`

## 6. C хэсэг — Loop Boundary Testing

`gpa()` функцийн давталтын ажиллагааг 0, 1 болон 2-оос дээш давталтын тохиолдлоор шалгасан.

| Тохиолдол | Оролт | Хүлээгдэж буй үр дүн |
|---|---|---|
| 0 iteration | `new double[]{}` | `IllegalArgumentException` |
| Null input | `null` | `IllegalArgumentException` |
| 1 iteration | `[95]` | GPA = 4.0 |
| 2+ iterations | `[95, 85, 75, 65]` | GPA = 2.5 |

### C хэсгийн үр дүн

- Tests run: 23
- Failures: 0
- Errors: 0
- Build: SUCCESS

Эдгээр тест нь давталт өөр өөр хэмжээтэй өгөгдөл дээр зөв ажиллаж байгаа эсэхийг шалгасан. Кодын хамралт 100% байсан ч давталтын 0, 1, 2+ элементийн тохиолдлуудыг тусад нь шалгах нь чухал. Учир нь кодын хамралт нь код ажилласныг хэмждэг болохоос бүх оролтод зөв үр дүн өгч байгааг баталдаггүй.

## 7. D хэсэг — Boundary Value Testing ба алдаа засвар

Энэ хэсэгт `letterGrade()` функцийн үнэлгээний зааг утгуудыг шалгасан.

Анхны кодод:

```java
if (score > 60) return "D";
```

гэсэн нөхцөл байсан.

Гэвч шаардлагын дагуу 60–69.99 оноо нь D үнэлгээ байх ёстой. Иймээс 60 оноо дээр алдаа үүссэн.

### Шалгасан зааг утгууд

| Оролт | Хүлээгдэж буй үнэлгээ |
|---:|---|
| 0 | F |
| 59.99 | F |
| 60 | D |
| 69.99 | D |
| 89.99 | B |
| 90 | A |
| 100 | A |

### Алдааг илрүүлсэн үр дүн

`mvn test` ажиллуулахад:

```text
Tests run: 30, Failures: 1, Errors: 0, Skipped: 0

ScholarshipCalculatorTest.letterGradeAt60ShouldReturnD

expected: <D> but was: <F>
```

Энэ нь 60 онооны зааг утгад програм буруу үнэлгээ буцааж байгааг нотолсон.

### Алдааг зассан нь

Нөхцөлийг дараах байдлаар өөрчилсөн:

```java
if (score >= 60) return "D";
```

Ингэснээр 60 оноо D үнэлгээнд зөв хамрагдсан.

### Засварын дараах үр дүн

- Tests run: 30
- Failures: 0
- Errors: 0
- Skipped: 0
- Build: SUCCESS

### Эцсийн JaCoCo coverage

| Үзүүлэлт | Missed | Covered | Coverage |
|---|---:|---:|---:|
| Instructions | 0 | 152 | 100% |
| Branches | 0 | 41 | 100% |
| Lines | 0 | 25 | 100% |
| Complexity | 0 | 26 | 100% |
| Methods | 0 | 4 | 100% |

**D хэсгийн дүгнэлт:**

100% branch coverage авсан нь програмын бүх нөхцөлийн салбар ажилласныг харуулдаг боловч зааг утгын алдааг илрүүлэхэд дангаараа хангалтгүй. Учир нь `score > 60` болон `score >= 60` нөхцөлүүд 60-аас бусад утгууд дээр ижил үр дүн өгч болно. Харин яг 60 гэсэн зааг утгыг шалгахад алдаа илэрсэн. Иймээс Boundary Value Testing нь кодын хамралтыг нөхөж, логик алдааг илрүүлэхэд чухал ач холбогдолтой.

**Хадгалсан үр дүн:**
- `results/mvn-test-D-fail.txt`
- `results/mvn-verify-final.txt`
- `results/jacoco-final.csv`

## 8. Git болон GitHub

Төслийн GitHub repository:

https://github.com/Hirito572/lab09-jacoco

Төслийг Git болон GitHub ашиглан үе шаттай хөгжүүлж, ажлын явцыг commit-уудаар хадгалсан.

### Commit түүх

| Commit ID | Commit message | Тайлбар |
|---|---|---|
| `ae6eeca` | `test: add happy path tests for scholarship calculator` | A хэсгийн Happy Path тестүүд нэмсэн |
| `5b691dc` | `docs: add initial JaCoCo coverage screenshot` | A хэсгийн JaCoCo screenshot нэмсэн |
| `0f82984` | `test: achieve 100 percent JaCoCo line and branch coverage` | B хэсгийн branch болон line coverage-ийг 100% болгосон |
| `fa3cb90` | `test: add GPA loop boundary tests` | C хэсгийн GPA loop boundary тестүүд нэмсэн |
| `8d3bdf2` | `fix: correct D grade boundary at 60` | D хэсгийн зааг утгын тест болон 60 онооны алдааны засвар |
| `053242d` | `docs: complete Lab09 README` | README баримтжуулалтыг нэмсэн |
| `3f81a5b` | `docs: improve CFG branch test labels` | CFG диаграммын T/F ирмэгийн тестийн нэрсийг сайжруулсан |

Repository нь Public тохиргоотой бөгөөд лабораторийн код, тест, JaCoCo тайлан, CFG диаграмм болон README файлыг агуулна.

## 9. Төслийн бүтэц

```text
lab09-jacoco/
├── pom.xml
├── README.md
├── cfg.png
├── .gitignore
├── src/
│   ├── main/
│   │   └── java/
│   │       └── mn/edu/must/sqat/
│   │           └── ScholarshipCalculator.java
│   └── test/
│       └── java/
│           └── mn/edu/must/sqat/
│               └── ScholarshipCalculatorTest.java
├── results/
│   ├── jacoco-A.csv
│   ├── jacoco-B.csv
│   ├── jacoco-final.csv
│   ├── mvn-verify-A.txt
│   ├── mvn-verify-B.txt
│   ├── mvn-test-D-fail.txt
│   └── mvn-verify-final.txt
└── screenshots/
    └── jacoco-A.png
```

## 10. Ерөнхий дүгнэлт

Энэхүү лабораторийн ажлаар JaCoCo ашиглан Java програмын код хамралтыг хэмжиж, JUnit тестүүдээр програмын ажиллагааг шалгалаа. Эхний шатанд happy-path тестүүдээр 64% line coverage болон 53.66% branch coverage авсан. Нэмэлт тестүүд бичсэний үр дүнд B хэсэгт branch болон line coverage-ийг 100% болгосон. C хэсэгт давталтын 0, 1 болон олон элементийн тохиолдлуудыг шалгасан. D хэсэгт Boundary Value Testing ашиглан 60 онооны зааг дээрх алдааг илрүүлж, засварласны дараа 30 тестийг бүгдийг амжилттай ажиллуулсан. Эцсийн үр дүнд branch болон line coverage 100% болсон.

## 11. AI ашигласан тухай

Энэхүү лабораторийн ажлыг гүйцэтгэх явцад ChatGPT-ийг тестийн тохиолдлуудын талаар зөвлөгөө авах, JaCoCo тайланг ойлгох, Control Flow Graph болон Boundary Value Testing-ийн тайлбар боловсруулах, алдаа засах үйл явцыг ойлгоход туслах зорилгоор ашигласан. Кодыг ажиллуулах, тестийн үр дүнг шалгах, Git commit болон GitHub-д оруулах ажлыг өөрийн орчинд гүйцэтгэсэн.