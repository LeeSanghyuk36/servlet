//로컬 깃 저장소 생성(.git 폴더 생성) 

$ git init //Working directory -> Staging Area 

$ git add [directory] 

$ git add . 

//Staging Area -> repository(.git) 

$ git commit -m "commit message" 

//add + commit 한번에 

$ git commit -am "commit message" 

//원격저장소와 연결 

$ git remote add origin [원격저장소 주소] 

//현재 연결된 원격저장소 확인하기

$ git remote -v 

//연결된 원격저장소 삭제하기 

$ git remote remove [origin] 

//연결하고 있던 원격저장소의 name이 변경되었을 때, 재설정 

$ git remote set-url origin [원격저장소 주소] 

//브랜치 명 바꾸기 

$ git branch -M [branch name(main)] 

$ git branch -m [현재 branch name] [바꾸고싶은 branch name] 



//(선택) README.md가 있다면 : push 보다 pull 먼저 

$ git pull origin [branch name(main)] 



//로컬 레포지토리 -> 원격 레포지토리 

$ git push -u origin [branch name(main)] 



//파일 수정 및 추가 이후 : 다음번 commit & push 

$ git pull origin [branch name] (선택:다른 장소에서 작업한게 없으면 안해도 됨)

$ git add [directory] 

$ git commit -m "commit message"

$ git push -u origin [branch name] 



//git clone == remote+pull 

$ git clone [Repo_url] [directory] 

$ git clone [Repo_url] . (보통 이렇게 많이 쓴다)



//브랜치 생성하기(로컬브랜치 생성 -> 원격저장소에 푸쉬)
 1.로컬브랜치 생성
$ git branch [만들고 싶은 브랜치명]

 2.원격저장소에 저장
$ git push origin [로컬에서 만든 브랜치명]

//브랜치 삭제하기
 1.로컬브랜치 삭제
$ git branch -d [삭제 브랜치명]

 2.원격저장소에 있는 브랜치 삭제
$ git push origin --delete [삭제 브랜치명]
//모든 브랜치 확인

$ git branch -v(-a)

//현재 상태 보여줌
$ git status

//지금까지의 모든 커밋에 대한 내용 조회(커밋아이디, 사용자이름, 날짜, 브랜치)
$ git log //git log의 그래프 옵션(그래프로 나타냄)

$ git log --graph



//HEAD가 가리키는 브랜치 바꾸기 (= 현재 있는 브랜치 위치 바꾸기)
$ git checkout [branch name]


//MERGE(브랜치 병합)하기

1. 합치고 싶은 (root와 가까운 줄기)main branch에 가서 merge해줌
2. $ git merge [sub-branch name]
3. (선택) 병합된 sub브랜치 삭제



//git init 취소하기 (.git 폴더가 삭제 & 로컬저장소 지정 해제)
$ rm -rf .git
//git pull 되돌리기


$ git reset --hard ORIG_HEAD


//git add 취소하기
$ git reset HEAD [파일명]


$ git reset

//git commit 취소하기
$ git reset --hard @^ (@^, @~1, @~ 가 동일)

//git remote 취소하기 (원격저장소 연결 해제)
$ git remote rm origin
