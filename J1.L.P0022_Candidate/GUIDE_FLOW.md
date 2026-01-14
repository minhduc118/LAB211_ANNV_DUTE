# GUIDE FLOW - Candidate Management (J1.L.P0022)

## Cấu Trúc Dự Án

```
src/
├── Main.java                       # Entry point
├── constants/
│   └── Messages.java               # Tất cả constants và messages
├── controller/
│   └── CandidateController.java    # Điều phối và hiển thị menu
├── dto/
│   └── CandidateDTO.java           # Data Transfer Object
├── exception/
│   ├── SystemException.java        # Base exception
│   ├── DuplicateCandidateException.java
│   ├── CandidateNotFoundException.java
│   └── InvalidDataException.java
├── model/
│   ├── Candidate.java              # Base model class
│   ├── Experience.java             # Extends Candidate
│   ├── Fresher.java                # Extends Candidate
│   └── Internship.java             # Extends Candidate
├── service/
│   ├── CandidateService.java       # Interface
│   └── CandidateServiceImpl.java   # Business logic
└── util/
    └── Validator.java              # Input validation
```

---

## Luồng Hoạt Động

### 1. Khởi Động Chương Trình

```
Main.main()
    └── CandidateController.controller.run()
            └── displayMenu() + xử lý lựa chọn
```

### 2. Menu Chính

```
CANDIDATE MANAGEMENT
1. Experience      → addExperience()
2. Fresher         → addFresher()
3. Internship      → addInternship()
4. Searching       → searchCandidate()
5. Exit            → return
```

---

## Chi Tiết Các Chức Năng

### Chức Năng 1: Thêm Experience Candidate

```
addExperience()
    │
    ├── Validator.getString(ID)
    │   └── service.candidateExists(id) → Kiểm tra trùng
    │
    ├── Validator.getString(firstName, lastName, address)
    ├── Validator.getBirthYear(birthYear)
    ├── Validator.getPhone(phone)
    ├── Validator.getEmail(email)
    │
    ├── Validator.getExperience(yearExperience, birthYear)
    │   └── Kiểm tra experience <= age
    ├── Validator.getString(professionalSkill)
    │
    ├── new Experience(...) → Tạo đối tượng
    │
    └── service.addCandidate(candidate)
        └── Thêm vào ArrayList<Candidate>
```

### Chức Năng 2: Thêm Fresher Candidate

```
addFresher()
    │
    ├── Nhập thông tin cơ bản (giống Experience)
    │
    ├── Validator.getString(graduationDate)
    ├── Validator.getGraduationRank(graduationRank)
    │   └── Chỉ chấp nhận: Excellence, Good, Fair, Poor
    │
    └── service.addCandidate(new Fresher(...))
```

### Chức Năng 3: Thêm Internship Candidate

```
addInternship()
    │
    ├── Nhập thông tin cơ bản (giống Experience)
    │
    ├── Validator.getString(major)
    ├── Validator.getString(semester)
    ├── Validator.getString(university)
    │
    └── service.addCandidate(new Internship(...))
```

### Chức Năng 4: Tìm Kiếm Candidate

```
searchCandidate()
    │
    ├── service.printCandidatesByType()
    │   └── Hiển thị danh sách theo loại:
    │       ├── Experience Candidates
    │       ├── Fresher Candidates
    │       └── Internship Candidates
    │
    ├── Validator.getString(name)
    ├── Validator.getInt(candidateType, 0, 2)
    │
    └── service.searchByName(name, type)
        └── Tìm theo firstName hoặc lastName (case-insensitive)
```

---

## Sơ Đồ Lớp

```
┌─────────────────────────────────────────────────────────────────────────┐
│                              Main                                       │
│  - main(String[] args)                                                  │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                        CandidateController                              │
│  - service: CandidateService                                            │
│  + run()                                                                │
│  - displayMenu()                                                        │
│  - addExperience()                                                      │
│  - addFresher()                                                         │
│  - addInternship()                                                      │
│  - searchCandidate()                                                    │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                    ┌───────────────┴───────────────┐
                    ▼                               ▼
┌──────────────────────────────┐   ┌──────────────────────────────────────┐
│      CandidateService        │   │            Validator                 │
│         (Interface)          │   │  + getString(prompt): String         │
│  + addCandidate(Candidate)   │   │  + getInt(prompt, min, max): int     │
│  + searchByName(...): List   │   │  + getPhone(prompt): String          │
│  + printCandidatesByType()   │   │  + getEmail(prompt): String          │
│  + candidateExists(id): bool │   │  + getGraduationRank(prompt): String │
└──────────────────────────────┘   │  + getExperience(prompt, birth): int │
              ▲                    │  + getBirthYear(prompt): int         │
              │                    │  + checkYN(prompt): String           │
              │                    └──────────────────────────────────────┘
┌──────────────────────────────┐
│    CandidateServiceImpl      │
│  - candidates: ArrayList     │
│  + addCandidate(...)         │
│  + searchByName(...)         │
│  + printCandidatesByType()   │
│  + candidateExists(id)       │
└──────────────────────────────┘
              │
              ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                            Candidate                                    │
│  - id, firstName, lastName, birthDate, address, phone, email, type      │
│  + getters/setters                                                      │
│  + getFullName(): String                                                │
│  + toString(): String                                                   │
└─────────────────────────────────────────────────────────────────────────┘
          ▲               ▲               ▲
          │               │               │
┌─────────────┐   ┌─────────────┐   ┌─────────────────┐
│ Experience  │   │   Fresher   │   │   Internship    │
│ -yearExp    │   │ -gradDate   │   │ -major          │
│ -proSkill   │   │ -gradRank   │   │ -semester       │
└─────────────┘   └─────────────┘   │ -university     │
                                    └─────────────────┘
```

---

## Validation Rules

| Trường | Quy tắc |
|--------|---------|
| ID | Không rỗng, không trùng |
| First Name | Không rỗng |
| Last Name | Không rỗng |
| Birth Year | 1900 - Năm hiện tại |
| Phone | Tối thiểu 10 chữ số |
| Email | Format: account@domain.ext |
| Graduation Rank | Excellence, Good, Fair, Poor |
| Year Experience | 0 - 100, <= tuổi |

---

## Exception Handling

```
SystemException (base)
    ├── DuplicateCandidateException
    │   └── Khi thêm candidate với ID đã tồn tại
    ├── CandidateNotFoundException
    │   └── Khi tìm kiếm candidate không tồn tại
    └── InvalidDataException
        └── Khi dữ liệu nhập không hợp lệ
```
